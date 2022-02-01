package com.tencent.mobileqq.activity.contacts.topentry;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.CfgProcess.CfgParseResult;
import com.tencent.mobileqq.config.CfgProcess.OnGetConfigListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.utils.ConfigUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CTEntryMng
  implements CfgProcess.OnGetConfigListener, Manager
{
  protected int a = 0;
  FriendListObserver b = new CTEntryMng.8(this);
  private final QQAppInterface c;
  private final SparseArray<CTEntry> d;
  private final List<Integer> e;
  private final SparseArray<CTEntryMng.EntryRedDotInfo> f;
  private final List<CTEntryMng.EntryUserSetting> g;
  private final CardViewController h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private final List<CTEntryListener> l;
  private int m = 0;
  private boolean n = false;
  private boolean o = false;
  private int p = 0;
  private Object q = new Object();
  private CardViewController.MayKnowListener r = new CTEntryMng.4(this);
  private CardObserver s = new CTEntryMng.5(this);
  private ExpandObserver t = new CTEntryMng.6(this);
  private IPhoneContactListener u = new CTEntryMng.7(this);
  
  public CTEntryMng(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "CTEntryMng create");
    }
    this.c = paramQQAppInterface;
    this.d = new SparseArray(5);
    this.f = new SparseArray(5);
    this.e = Collections.synchronizedList(new ArrayList(5));
    this.l = Collections.synchronizedList(new ArrayList(5));
    this.g = Collections.synchronizedList(new ArrayList(5));
    this.c.addObserver(this.s);
    this.c.addObserver(this.t);
    this.c.addObserver(this.b);
    this.h = new CardViewController(this.c, this.r);
    paramQQAppInterface = this.c.getConfigProcess();
    paramQQAppInterface.a("confess_config", this);
    paramQQAppInterface.a("extend_friend_config_785", this);
    paramQQAppInterface.a("contact_top_entry_config", this);
    paramQQAppInterface.a("register_invitation_config", this);
    ThreadManager.excute(new CTEntryMng.1(this), 64, null, false);
    if (this.u != null) {
      ((IPhoneContactService)this.c.getRuntimeService(IPhoneContactService.class, "")).addListener(this.u);
    }
  }
  
  public static int a(List<CTEntry> paramList)
  {
    int i1 = 0;
    while ((paramList != null) && (i1 < paramList.size()))
    {
      CTEntry localCTEntry = (CTEntry)paramList.get(i1);
      if ((localCTEntry != null) && (localCTEntry.l)) {
        return 1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private CTEntryMng.EntryUserSetting a(short paramShort)
  {
    int i1 = 0;
    while (i1 < this.g.size())
    {
      if (((CTEntryMng.EntryUserSetting)this.g.get(i1)).b == paramShort) {
        return (CTEntryMng.EntryUserSetting)this.g.get(i1);
      }
      i1 += 1;
    }
    return null;
  }
  
  private void a(SparseArray<CTEntryMng.EntryRedDotInfo> paramSparseArray)
  {
    ThreadManager.excute(new CTEntryMng.2(this, paramSparseArray), 64, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveEntryRedDot");
    }
  }
  
  private void a(CTEntryMng.EntryUserSetting paramEntryUserSetting)
  {
    if (!this.g.contains(paramEntryUserSetting)) {
      this.g.add(paramEntryUserSetting);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ((CTEntryMng)paramQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).h();
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {}
    try
    {
      boolean bool = this.i;
      if (bool) {
        return;
      }
      k();
      m();
      b(paramString);
      d(true);
      this.i = true;
      i();
      j();
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "initOrUpdateConfig isFromServer: %s, value: %s uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString, this.c.getCurrentUin() }));
      }
      return;
    }
    finally {}
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    int i1 = paramJSONObject.optInt("id", 0);
    if (i1 == 0) {
      return false;
    }
    ??? = c(i1);
    ((CTEntry)???).a = i1;
    ((CTEntry)???).b = paramJSONObject.optString("title", ((CTEntry)???).b);
    ((CTEntry)???).d = paramJSONObject.optString("AndroidMultiCardsIcon", ((CTEntry)???).d);
    ((CTEntry)???).e = paramJSONObject.optString("AndroidSingleCardIcon", ((CTEntry)???).e);
    ((CTEntry)???).f = paramJSONObject.optString("url", ((CTEntry)???).f);
    ((CTEntry)???).g = paramJSONObject.optBoolean("showRedDot", ((CTEntry)???).g);
    ((CTEntry)???).h = paramJSONObject.optInt("redDotVersion", ((CTEntry)???).h);
    ((CTEntry)???).j = ((short)paramJSONObject.optInt("switchFlag", ((CTEntry)???).j));
    i1 = ((CTEntry)???).a;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5)
            {
              ((CTEntry)???).c = paramJSONObject.optString("subTitle", ((CTEntry)???).c);
              ((CTEntry)???).i = false;
              ((CTEntry)???).k = true;
            }
            else
            {
              ((CTEntry)???).c = paramJSONObject.optString("subTitle", ((CTEntry)???).c);
              ((CTEntry)???).i = false;
              ((CTEntry)???).f = "native";
              ((CTEntry)???).j = -23316;
            }
          }
          else
          {
            ((CTEntry)???).c = paramJSONObject.optString("subTitle", ((CTEntry)???).c);
            ((CTEntry)???).i = false;
            ((CTEntry)???).j = -23323;
          }
        }
        else
        {
          ((CTEntry)???).i = true;
          ((CTEntry)???).f = "native";
          ((CTEntry)???).j = -23447;
        }
      }
      else
      {
        ((CTEntry)???).c = paramJSONObject.optString("subTitle", ((CTEntry)???).c);
        ((CTEntry)???).i = false;
        ((CTEntry)???).f = "native";
        ((CTEntry)???).j = -23324;
      }
    }
    else
    {
      ((CTEntry)???).c = paramJSONObject.optString("subTitle", ((CTEntry)???).c);
      ((CTEntry)???).i = false;
      ((CTEntry)???).j = -25161;
    }
    b((CTEntry)???);
    paramJSONObject = d(((CTEntry)???).a);
    if (paramJSONObject.b != ((CTEntry)???).h)
    {
      paramJSONObject.b = ((CTEntry)???).h;
      paramJSONObject.c = ((CTEntry)???).g;
      paramJSONObject.d = false;
      paramJSONObject.e = 0L;
      synchronized (this.f)
      {
        this.f.put(paramJSONObject.a, paramJSONObject);
        return true;
      }
    }
    return false;
  }
  
  private String b(SparseArray<CTEntryMng.EntryRedDotInfo> paramSparseArray)
  {
    Object localObject1;
    int i1;
    Object localObject2;
    if ((paramSparseArray != null) && (paramSparseArray.size() > 0))
    {
      localObject1 = new JSONArray();
      i1 = 0;
      while (i1 < paramSparseArray.size())
      {
        localObject2 = (CTEntryMng.EntryRedDotInfo)paramSparseArray.valueAt(i1);
        if ((((CTEntryMng.EntryRedDotInfo)localObject2).a > 4) && (!this.e.contains(Integer.valueOf(((CTEntryMng.EntryRedDotInfo)localObject2).a))))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getEntryRedDotStr not save id: ");
            localStringBuilder.append(((CTEntryMng.EntryRedDotInfo)localObject2).a);
            QLog.i("CTEntryMng", 2, localStringBuilder.toString());
          }
        }
        else
        {
          localObject2 = ((CTEntryMng.EntryRedDotInfo)localObject2).a();
          if (localObject2 != null) {
            ((JSONArray)localObject1).put(localObject2);
          }
        }
        i1 += 1;
      }
      localObject1 = ((JSONArray)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    if (QLog.isColorLevel())
    {
      localObject2 = Locale.getDefault();
      if (paramSparseArray == null) {
        i1 = 0;
      } else {
        i1 = paramSparseArray.size();
      }
      QLog.i("CTEntryMng", 2, String.format((Locale)localObject2, "getEntryRedDotStr size: %s, str: %s", new Object[] { Integer.valueOf(i1), localObject1 }));
    }
    return localObject1;
  }
  
  private void b(CTEntry paramCTEntry)
  {
    if (paramCTEntry == null) {
      return;
    }
    synchronized (this.d)
    {
      this.d.put(paramCTEntry.a, paramCTEntry);
      return;
    }
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	Ljava/util/List;
    //   4: invokeinterface 414 1 0
    //   9: aload_1
    //   10: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +184 -> 197
    //   16: new 296	org/json/JSONObject
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 422	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc_w 424
    //   29: invokevirtual 428	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   32: ifeq +334 -> 366
    //   35: aload_1
    //   36: ldc_w 424
    //   39: invokevirtual 432	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   42: astore 6
    //   44: iconst_0
    //   45: istore 5
    //   47: iconst_0
    //   48: istore_3
    //   49: iload_3
    //   50: istore_2
    //   51: aload 6
    //   53: ifnull +42 -> 95
    //   56: iload_3
    //   57: istore_2
    //   58: iload_3
    //   59: istore 4
    //   61: iload 5
    //   63: aload 6
    //   65: invokevirtual 435	org/json/JSONArray:length	()I
    //   68: if_icmpge +27 -> 95
    //   71: iload_3
    //   72: istore 4
    //   74: aload_0
    //   75: aload 6
    //   77: iload 5
    //   79: invokevirtual 439	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   82: invokespecial 441	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:a	(Lorg/json/JSONObject;)Z
    //   85: ifne +270 -> 355
    //   88: iload_3
    //   89: ifeq +261 -> 350
    //   92: goto +263 -> 355
    //   95: iload_2
    //   96: istore 4
    //   98: iload_2
    //   99: istore_3
    //   100: aload_1
    //   101: ldc_w 443
    //   104: invokevirtual 428	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   107: ifeq +92 -> 199
    //   110: iload_2
    //   111: istore 4
    //   113: aload_1
    //   114: ldc_w 443
    //   117: invokevirtual 432	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   120: astore_1
    //   121: iconst_0
    //   122: istore 5
    //   124: iload_2
    //   125: istore_3
    //   126: aload_1
    //   127: ifnull +72 -> 199
    //   130: iload_2
    //   131: istore 4
    //   133: iload_2
    //   134: istore_3
    //   135: iload 5
    //   137: aload_1
    //   138: invokevirtual 435	org/json/JSONArray:length	()I
    //   141: if_icmpge +58 -> 199
    //   144: iload_2
    //   145: istore 4
    //   147: aload_1
    //   148: iload 5
    //   150: invokevirtual 447	org/json/JSONArray:getInt	(I)I
    //   153: istore_3
    //   154: iload_2
    //   155: istore 4
    //   157: aload_0
    //   158: getfield 131	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	Ljava/util/List;
    //   161: iload_3
    //   162: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokeinterface 235 2 0
    //   170: pop
    //   171: iload 5
    //   173: iconst_1
    //   174: iadd
    //   175: istore 5
    //   177: goto -53 -> 124
    //   180: astore_1
    //   181: iload 4
    //   183: istore_3
    //   184: goto +6 -> 190
    //   187: astore_1
    //   188: iconst_0
    //   189: istore_3
    //   190: aload_1
    //   191: invokevirtual 450	org/json/JSONException:printStackTrace	()V
    //   194: goto +5 -> 199
    //   197: iconst_0
    //   198: istore_3
    //   199: aload_0
    //   200: getfield 131	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	Ljava/util/List;
    //   203: iconst_3
    //   204: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokeinterface 232 2 0
    //   212: ifne +17 -> 229
    //   215: aload_0
    //   216: getfield 131	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	Ljava/util/List;
    //   219: iconst_3
    //   220: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: invokeinterface 235 2 0
    //   228: pop
    //   229: aload_0
    //   230: getfield 131	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	Ljava/util/List;
    //   233: iconst_1
    //   234: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: invokeinterface 232 2 0
    //   242: ifeq +8 -> 250
    //   245: aload_0
    //   246: iconst_0
    //   247: invokespecial 452	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	(Z)V
    //   250: aload_0
    //   251: getfield 131	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	Ljava/util/List;
    //   254: iconst_2
    //   255: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokeinterface 232 2 0
    //   263: ifeq +8 -> 271
    //   266: aload_0
    //   267: iconst_0
    //   268: invokespecial 454	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:f	(Z)V
    //   271: aload_0
    //   272: getfield 131	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	Ljava/util/List;
    //   275: iconst_3
    //   276: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   279: invokeinterface 232 2 0
    //   284: ifeq +8 -> 292
    //   287: aload_0
    //   288: iconst_0
    //   289: invokespecial 239	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:g	(Z)V
    //   292: aload_0
    //   293: getfield 131	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	Ljava/util/List;
    //   296: iconst_4
    //   297: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: invokeinterface 232 2 0
    //   305: ifeq +8 -> 313
    //   308: aload_0
    //   309: iconst_0
    //   310: invokespecial 456	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:h	(Z)V
    //   313: aload_0
    //   314: getfield 131	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	Ljava/util/List;
    //   317: iconst_5
    //   318: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: invokeinterface 232 2 0
    //   326: ifeq +8 -> 334
    //   329: aload_0
    //   330: iconst_0
    //   331: invokevirtual 458	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:c	(Z)V
    //   334: iload_3
    //   335: ifeq +14 -> 349
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 120	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:f	Landroid/util/SparseArray;
    //   343: invokevirtual 462	android/util/SparseArray:clone	()Landroid/util/SparseArray;
    //   346: invokespecial 464	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:a	(Landroid/util/SparseArray;)V
    //   349: return
    //   350: iconst_0
    //   351: istore_3
    //   352: goto +5 -> 357
    //   355: iconst_1
    //   356: istore_3
    //   357: iload 5
    //   359: iconst_1
    //   360: iadd
    //   361: istore 5
    //   363: goto -314 -> 49
    //   366: iconst_0
    //   367: istore_2
    //   368: goto -273 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	CTEntryMng
    //   0	371	1	paramString	String
    //   50	318	2	i1	int
    //   48	309	3	i2	int
    //   59	123	4	i3	int
    //   45	317	5	i4	int
    //   42	34	6	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   61	71	180	org/json/JSONException
    //   74	88	180	org/json/JSONException
    //   100	110	180	org/json/JSONException
    //   113	121	180	org/json/JSONException
    //   135	144	180	org/json/JSONException
    //   147	154	180	org/json/JSONException
    //   157	171	180	org/json/JSONException
    //   16	44	187	org/json/JSONException
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.n) {
      return;
    }
    CTEntry localCTEntry = c(1);
    boolean bool = localCTEntry.k;
    ConfessConfig localConfessConfig = ((ConfessManager)this.c.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
    if (TextUtils.isEmpty(localCTEntry.b)) {
      localCTEntry.b = HardCodeUtil.a(2131900790);
    }
    localCTEntry.k = localConfessConfig.c();
    b(localCTEntry);
    if ((bool != localCTEntry.k) && (localCTEntry.k) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateConfessEntry show: %s, title: %s, sub: %s preValue: %s", new Object[] { Boolean.valueOf(localCTEntry.k), localCTEntry.b, localCTEntry.c, Boolean.valueOf(bool) }));
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.n) {
      return;
    }
    CTEntry localCTEntry = c(2);
    boolean bool = localCTEntry.k;
    IExpandManager localIExpandManager = (IExpandManager)this.c.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    ExpandConfig localExpandConfig;
    if (localIExpandManager == null) {
      localExpandConfig = null;
    } else {
      localExpandConfig = localIExpandManager.u();
    }
    if (localExpandConfig != null)
    {
      localCTEntry.k = localIExpandManager.a(localExpandConfig);
      localCTEntry.n = Boolean.valueOf(localIExpandManager.x());
    }
    else
    {
      localCTEntry.k = false;
      localCTEntry.n = null;
    }
    b(localCTEntry);
    if ((bool != localCTEntry.k) && (localCTEntry.k) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateExtendFrdEntry show: %s, title: %s, sub: %s, preValue: %s", new Object[] { Boolean.valueOf(localCTEntry.k), localCTEntry.b, localCTEntry.c, Boolean.valueOf(bool) }));
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.n) {
      return;
    }
    CTEntry localCTEntry = c(3);
    boolean bool3 = localCTEntry.k;
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.c.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    boolean bool2;
    boolean bool1;
    if (localMayknowRecommendManager != null)
    {
      bool2 = localMayknowRecommendManager.d("sp_mayknow_entry_list_recommend");
      bool1 = localMayknowRecommendManager.d("sp_mayknow_entry_list_head");
    }
    else
    {
      bool1 = true;
      bool2 = false;
    }
    localCTEntry.b = this.c.getApp().getResources().getString(2131897011);
    if ((bool1) && (!bool2)) {
      localCTEntry.k = true;
    } else {
      localCTEntry.k = false;
    }
    if (localCTEntry.n == null) {
      localCTEntry.c = "";
    }
    if ((paramBoolean) || ((localCTEntry.k) && (localCTEntry.n == null))) {
      this.h.b();
    }
    b(localCTEntry);
    if ((bool3 != localCTEntry.k) && (localCTEntry.k) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateMayKnowEntry show: %s, title: %s, sub: %s, extra: %s", new Object[] { Boolean.valueOf(localCTEntry.k), localCTEntry.b, localCTEntry.c, localCTEntry.n }));
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (this.n) {
      return;
    }
    CTEntry localCTEntry = c(4);
    boolean bool2 = localCTEntry.k;
    boolean bool1;
    if (BaseApplicationImpl.getContext().getSharedPreferences(this.c.getCurrentAccountUin(), 0).getInt("contacts_invite_friend_entry", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localCTEntry.k = bool1;
    if ((bool2 != localCTEntry.k) && (localCTEntry.k) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateInviteFrd show: %s, title: %s, sub: %s, url: %s", new Object[] { Boolean.valueOf(localCTEntry.k), localCTEntry.b, localCTEntry.c, localCTEntry.f }));
    }
  }
  
  private void i()
  {
    int i1 = 0;
    try
    {
      while (i1 < this.l.size())
      {
        CTEntryListener localCTEntryListener = (CTEntryListener)this.l.get(i1);
        if (localCTEntryListener != null) {
          localCTEntryListener.a();
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "notifyEntryUpdated [isEntryUIInit: %s, redDotFlag: %s]", new Object[] { Boolean.valueOf(this.o), Integer.valueOf(this.a) }));
      }
      if (!this.o) {
        a(a(f()));
      }
    }
  }
  
  private void j()
  {
    synchronized (this.q)
    {
      this.p = this.c.getApp().getSharedPreferences("mayknow_connections_switch", 4).getInt("key_mayknow_connections_switch", 0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initConnectionsSwitchLocal ");
        localStringBuilder.append(this.p);
        QLog.i("CTEntryMng", 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  private void k()
  {
    if (this.j) {
      return;
    }
    synchronized (this.f)
    {
      this.f.clear();
      a(ConfigUtil.a(this.c.getApp(), this.c.getCurrentUin(), "ct_entry_reddot_info"));
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "initEntryRedDot");
      }
      this.j = true;
      return;
    }
  }
  
  private void l()
  {
    ThreadManager.excute(new CTEntryMng.3(this), 64, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveUserSetting");
    }
  }
  
  private void m()
  {
    if (this.k) {
      return;
    }
    Object localObject = ConfigUtil.a(this.c.getApp(), this.c.getCurrentUin(), "ct_entry_user_setting");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i1 = 0;
        while (i1 < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
          CTEntryMng.EntryUserSetting localEntryUserSetting = new CTEntryMng.EntryUserSetting();
          localEntryUserSetting.a(localJSONObject);
          if ((localEntryUserSetting.a != 0) && (localEntryUserSetting.b != 0)) {
            a(localEntryUserSetting);
          }
          i1 += 1;
        }
        this.k = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public CardViewController a()
  {
    return this.h;
  }
  
  public short a(CTEntry paramCTEntry, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(int paramInt)
  {
    if (this.a == paramInt) {
      return;
    }
    this.a = paramInt;
    int i1 = this.a;
    paramInt = 1;
    if (i1 != 1) {
      paramInt = 0;
    }
    CardUtil.a(this.c, paramInt);
    ((IRedTouchServer)this.c.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.c);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateRedPoint mRedDotFlag: ");
      localStringBuilder.append(this.a);
      QLog.i("CTEntryMng", 2, localStringBuilder.toString());
    }
  }
  
  public void a(CTEntry paramCTEntry)
  {
    if (paramCTEntry == null) {
      return;
    }
    short[] arrayOfShort = new short[1];
    int i1 = paramCTEntry.a;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              arrayOfShort[0] = paramCTEntry.j;
            } else {
              arrayOfShort[0] = -23316;
            }
          }
          else {
            arrayOfShort[0] = -23323;
          }
        }
        else {
          arrayOfShort[0] = -23447;
        }
      }
      else {
        arrayOfShort[0] = -23324;
      }
    }
    else {
      arrayOfShort[0] = -25161;
    }
    Object localObject = e(paramCTEntry.a);
    ((CTEntryMng.EntryUserSetting)localObject).b = arrayOfShort[0];
    a((CTEntryMng.EntryUserSetting)localObject);
    localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.c, TempGetProfileDetailProcessor.class);
    if (localObject != null) {
      ((TempGetProfileDetailProcessor)localObject).getCommonSwitch(arrayOfShort);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer [id: %s, switch_id: %s, title: %s]", new Object[] { Integer.valueOf(paramCTEntry.a), Short.valueOf(arrayOfShort[0]), paramCTEntry.b }));
    }
  }
  
  public void a(CTEntry paramCTEntry, short paramShort)
  {
    if (paramCTEntry == null) {
      return;
    }
    CTEntryMng.EntryUserSetting localEntryUserSetting = a(paramCTEntry.j);
    boolean bool;
    if ((localEntryUserSetting != null) && (localEntryUserSetting.c != paramShort))
    {
      localEntryUserSetting.c = paramShort;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (bool)
    {
      l();
      i();
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateEntrySetting [id:%s, switch_value: %s, needUpdate: %s]", new Object[] { Integer.valueOf(paramCTEntry.a), Short.valueOf(paramShort), Boolean.valueOf(bool) }));
    }
  }
  
  public void a(CTEntryListener paramCTEntryListener)
  {
    if ((paramCTEntryListener != null) && (!this.l.contains(paramCTEntryListener))) {
      this.l.add(paramCTEntryListener);
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      int i1 = 0;
      while (i1 < localJSONArray.length())
      {
        ??? = localJSONArray.getJSONObject(i1);
        CTEntryMng.EntryRedDotInfo localEntryRedDotInfo = new CTEntryMng.EntryRedDotInfo();
        localEntryRedDotInfo.a((JSONObject)???);
        if (localEntryRedDotInfo.a != 0) {
          synchronized (this.f)
          {
            this.f.put(localEntryRedDotInfo.a, localEntryRedDotInfo);
          }
        }
        i1 += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "parseEntryRedDot size: %s, str: %s", new Object[] { Integer.valueOf(this.f.size()), paramString }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onConfigUpdatedFromServer tag: %s, localVersion: %s, version: %s, value: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    }
    if ("confess_config".equals(paramString1))
    {
      e(true);
      return;
    }
    if ("extend_friend_config_785".equals(paramString1))
    {
      f(true);
      return;
    }
    if ("register_invitation_config".equals(paramString1))
    {
      h(true);
      return;
    }
    if ("contact_top_entry_config".equals(paramString1)) {
      a(true, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEntryUIInit  ");
      localStringBuilder.append(paramBoolean);
      QLog.i("CTEntryMng", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBindPhoneSwitchInfo needShow:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" net_gap:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isNewUser:");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(this.c.getCurrentUin());
      QLog.i("CTEntryMng", 4, localStringBuilder.toString());
    }
    SharedPreUtils.f(this.c.getCurrentUin()).edit().putBoolean("contacts_bind_phone_canshow", paramBoolean1).putInt("contacts_bind_phone_next_gap", paramInt).putBoolean("contacts_bind_phone_is_new_user", paramBoolean2).commit();
    c(false);
    i();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("saveConnectionsSwitchToLocal ");
      ((StringBuilder)???).append(paramInt);
      QLog.i("CTEntryMng", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.q)
    {
      this.c.getApp().getSharedPreferences("mayknow_connections_switch", 4).edit().putInt("key_mayknow_connections_switch", paramInt).commit();
      this.p = paramInt;
      return;
    }
  }
  
  public void b(CTEntryListener paramCTEntryListener)
  {
    if (paramCTEntryListener != null) {
      this.l.remove(paramCTEntryListener);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:489)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean b()
  {
    return false;
  }
  
  public CTEntry c(int paramInt)
  {
    synchronized (this.d)
    {
      CTEntry localCTEntry = (CTEntry)this.d.get(paramInt);
      ??? = localCTEntry;
      if (localCTEntry == null)
      {
        ??? = new CTEntry();
        ((CTEntry)???).a = paramInt;
        ((CTEntry)???).k = false;
        ((CTEntry)???).m = false;
        ((CTEntry)???).n = null;
      }
      return ???;
    }
  }
  
  public List<CTEntry> c()
  {
    if (!this.i) {
      a(false, SharedPreUtils.s(this.c.getApp(), this.c.getCurrentUin(), "contact_top_entry_config"));
    }
    return g();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.n) {
      return;
    }
    CTEntry localCTEntry = c(5);
    boolean bool1 = localCTEntry.k;
    int i1 = ((IPhoneContactService)this.c.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateFindFriendEntry selfBindState:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(this.c.getCurrentUin());
      QLog.i("CTEntryMng", 4, ((StringBuilder)localObject).toString());
    }
    if ((i1 != 1) && (i1 != 2))
    {
      localCTEntry.k = false;
    }
    else
    {
      localObject = SharedPreUtils.f(this.c.getCurrentUin());
      boolean bool2 = ((SharedPreferences)localObject).getBoolean("contacts_bind_phone_canshow", false);
      localCTEntry.k = bool2;
      if (bool2) {
        localCTEntry.n = Boolean.valueOf(((SharedPreferences)localObject).getBoolean("contacts_bind_phone_is_new_user", false));
      }
      if (!localCTEntry.m)
      {
        i1 = ((SharedPreferences)localObject).getInt("contacts_bind_phone_next_gap", 300);
        long l1 = ((SharedPreferences)localObject).getLong("contacts_bind_phone_last_time", -1L);
        long l2 = NetConnInfoCenter.getServerTime();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateFindFriendEntry nextGap:");
          localStringBuilder.append(i1);
          localStringBuilder.append(" gap:");
          localStringBuilder.append(l2 - l1);
          localStringBuilder.append(" uin:");
          localStringBuilder.append(this.c.getCurrentUin());
          QLog.i("CTEntryMng", 4, localStringBuilder.toString());
        }
        if ((l1 < 0L) || (l2 - l1 >= i1))
        {
          ((CardHandler)this.c.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).o();
          ((SharedPreferences)localObject).edit().putLong("contacts_bind_phone_last_time", l2).commit();
        }
      }
    }
    b(localCTEntry);
    if ((bool1 != localCTEntry.k) && (localCTEntry.k) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateFindFriendEntry show: %s, title: %s, sub: %s, preValue: %s uin: %s", new Object[] { Boolean.valueOf(localCTEntry.k), localCTEntry.b, localCTEntry.c, Boolean.valueOf(bool1), this.c.getCurrentUin() }));
    }
  }
  
  public CTEntryMng.EntryRedDotInfo d(int paramInt)
  {
    synchronized (this.f)
    {
      CTEntryMng.EntryRedDotInfo localEntryRedDotInfo = (CTEntryMng.EntryRedDotInfo)this.f.get(paramInt);
      ??? = localEntryRedDotInfo;
      if (localEntryRedDotInfo == null)
      {
        ??? = new CTEntryMng.EntryRedDotInfo();
        ((CTEntryMng.EntryRedDotInfo)???).a = paramInt;
      }
      return ???;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.m > 20))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryUserSettingFromServer fromConfig to many times!");
      }
      return;
    }
    if (paramBoolean) {
      this.m += 1;
    }
    for (;;)
    {
      short[] arrayOfShort;
      int i1;
      Object localObject3;
      try
      {
        List localList = g();
        if (localList.size() > 0)
        {
          arrayOfShort = new short[localList.size()];
          Object localObject1 = "";
          i1 = 0;
          if (i1 < localList.size())
          {
            CTEntry localCTEntry = (CTEntry)localList.get(i1);
            int i2 = localCTEntry.a;
            if (i2 == 1) {
              break label337;
            }
            if (i2 == 2) {
              break label327;
            }
            if (i2 == 3) {
              break label317;
            }
            if (i2 == 4) {
              break label307;
            }
            if (i2 == 5) {
              break label297;
            }
            arrayOfShort[i1] = localCTEntry.j;
            localObject3 = e(localCTEntry.a);
            ((CTEntryMng.EntryUserSetting)localObject3).b = arrayOfShort[i1];
            a((CTEntryMng.EntryUserSetting)localObject3);
            localObject3 = localObject1;
            if (!QLog.isColorLevel()) {
              break label347;
            }
            localObject3 = String.format(Locale.getDefault(), "%s, [id: %s, title: %s, flag: %s]", new Object[] { localObject1, Integer.valueOf(localCTEntry.a), localCTEntry.b, Short.valueOf(arrayOfShort[i1]) });
            break label347;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer log: %s", new Object[] { localObject1 }));
          }
          localObject1 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.c, TempGetProfileDetailProcessor.class);
          if (localObject1 != null)
          {
            ((TempGetProfileDetailProcessor)localObject1).getCommonSwitch(arrayOfShort);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return;
      label297:
      arrayOfShort[i1] = -23316;
      continue;
      label307:
      arrayOfShort[i1] = -23323;
      continue;
      label317:
      arrayOfShort[i1] = -23447;
      continue;
      label327:
      arrayOfShort[i1] = -23324;
      continue;
      label337:
      arrayOfShort[i1] = -25161;
      continue;
      label347:
      i1 += 1;
      Object localObject2 = localObject3;
    }
  }
  
  public boolean d()
  {
    int i1 = 0;
    while (i1 < this.g.size())
    {
      if ((this.g.get(i1) != null) && (((CTEntryMng.EntryUserSetting)this.g.get(i1)).a == 3)) {
        return ((CTEntryMng.EntryUserSetting)this.g.get(i1)).b();
      }
      i1 += 1;
    }
    return false;
  }
  
  public CTEntryMng.EntryUserSetting e(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.g.size())
    {
      if (((CTEntryMng.EntryUserSetting)this.g.get(i1)).a == paramInt)
      {
        localEntryUserSetting1 = (CTEntryMng.EntryUserSetting)this.g.get(i1);
        break label61;
      }
      i1 += 1;
    }
    CTEntryMng.EntryUserSetting localEntryUserSetting1 = null;
    label61:
    CTEntryMng.EntryUserSetting localEntryUserSetting2 = localEntryUserSetting1;
    if (localEntryUserSetting1 == null)
    {
      localEntryUserSetting2 = new CTEntryMng.EntryUserSetting();
      localEntryUserSetting2.a = paramInt;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                localEntryUserSetting2.b = 0;
              } else {
                localEntryUserSetting2.b = -23316;
              }
            }
            else {
              localEntryUserSetting2.b = -23323;
            }
          }
          else {
            localEntryUserSetting2.b = -23447;
          }
        }
        else {
          localEntryUserSetting2.b = -23324;
        }
      }
      else {
        localEntryUserSetting2.b = -25161;
      }
      localEntryUserSetting2.c = -32768;
    }
    return localEntryUserSetting2;
  }
  
  public boolean e()
  {
    j();
    for (;;)
    {
      synchronized (this.q)
      {
        if (this.p == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public List<CTEntry> f()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      CTEntry localCTEntry = c(3);
      if (localCTEntry.a())
      {
        localCTEntry.m = e(3).b();
        localCTEntry.l = false;
        localArrayList.add(localCTEntry);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getEntryListToShow size:");
        localStringBuilder.append(localArrayList.size());
        localStringBuilder.append("  canBeShown:");
        localStringBuilder.append(localCTEntry.k);
        localStringBuilder.append("  isUserClose:");
        localStringBuilder.append(localCTEntry.m);
        QLog.i("CTEntryMng", 2, localStringBuilder.toString());
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEntryListToShow error:");
      localStringBuilder.append(localException.getMessage());
      QLog.e("CTEntryMng", 1, localStringBuilder.toString());
    }
    return localArrayList;
  }
  
  public List<CTEntry> g()
  {
    return new ArrayList();
  }
  
  public void h()
  {
    ((CardHandler)this.c.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).j();
  }
  
  public void onDestroy()
  {
    this.n = true;
    this.c.getConfigProcess().a(this);
    this.l.clear();
    this.c.removeObserver(this.s);
    this.c.removeObserver(this.t);
    this.c.removeObserver(this.b);
    this.h.a();
    if (this.u != null) {
      ((IPhoneContactService)this.c.getRuntimeService(IPhoneContactService.class, "")).removeListener(this.u);
    }
    this.u = null;
  }
  
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if (paramCfgParseResult != null) {
      a(paramString, paramCfgParseResult.d, paramCfgParseResult.a, paramCfgParseResult.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng
 * JD-Core Version:    0.7.0.1
 */