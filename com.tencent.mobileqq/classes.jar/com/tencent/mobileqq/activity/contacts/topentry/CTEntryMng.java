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
  protected int a;
  private final SparseArray<CTEntry> jdField_a_of_type_AndroidUtilSparseArray;
  private CardViewController.MayKnowListener jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController$MayKnowListener = new CTEntryMng.4(this);
  private final CardViewController jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new CTEntryMng.5(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new CTEntryMng.8(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IPhoneContactListener jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener = new CTEntryMng.7(this);
  private ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new CTEntryMng.6(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private final SparseArray<CTEntryMng.EntryRedDotInfo> jdField_b_of_type_AndroidUtilSparseArray;
  private final List<CTEntryMng.EntryUserSetting> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private final List<CTEntryListener> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  private boolean e;
  
  public CTEntryMng(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "CTEntryMng create");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(5);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(5);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList(5));
    this.jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList(5));
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList(5));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController = new CardViewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController$MayKnowListener);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess();
    paramQQAppInterface.a("confess_config", this);
    paramQQAppInterface.a("extend_friend_config_785", this);
    paramQQAppInterface.a("contact_top_entry_config", this);
    paramQQAppInterface.a("register_invitation_config", this);
    ThreadManager.excute(new CTEntryMng.1(this), 64, null, false);
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener != null) {
      ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).addListener(this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener);
    }
  }
  
  public static int a(List<CTEntry> paramList)
  {
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      CTEntry localCTEntry = (CTEntry)paramList.get(i);
      if ((localCTEntry != null) && (localCTEntry.jdField_d_of_type_Boolean)) {
        return 1;
      }
      i += 1;
    }
    return -1;
  }
  
  private CTEntryMng.EntryUserSetting a(short paramShort)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (((CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Short == paramShort) {
        return (CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private String a(SparseArray<CTEntryMng.EntryRedDotInfo> paramSparseArray)
  {
    Object localObject1;
    int i;
    Object localObject2;
    if ((paramSparseArray != null) && (paramSparseArray.size() > 0))
    {
      localObject1 = new JSONArray();
      i = 0;
      while (i < paramSparseArray.size())
      {
        localObject2 = (CTEntryMng.EntryRedDotInfo)paramSparseArray.valueAt(i);
        if ((((CTEntryMng.EntryRedDotInfo)localObject2).jdField_a_of_type_Int > 4) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(((CTEntryMng.EntryRedDotInfo)localObject2).jdField_a_of_type_Int))))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getEntryRedDotStr not save id: ");
            localStringBuilder.append(((CTEntryMng.EntryRedDotInfo)localObject2).jdField_a_of_type_Int);
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
        i += 1;
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
        i = 0;
      } else {
        i = paramSparseArray.size();
      }
      QLog.i("CTEntryMng", 2, String.format((Locale)localObject2, "getEntryRedDotStr size: %s, str: %s", new Object[] { Integer.valueOf(i), localObject1 }));
    }
    return localObject1;
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
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramEntryUserSetting)) {
      this.jdField_b_of_type_JavaUtilList.add(paramEntryUserSetting);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ((CTEntryMng)paramQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).a();
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {}
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      d();
      f();
      b(paramString);
      d(true);
      this.jdField_a_of_type_Boolean = true;
      b();
      c();
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "initOrUpdateConfig isFromServer: %s, value: %s uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() }));
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
    int i = paramJSONObject.optInt("id", 0);
    if (i == 0) {
      return false;
    }
    ??? = a(i);
    ((CTEntry)???).jdField_a_of_type_Int = i;
    ((CTEntry)???).jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", ((CTEntry)???).jdField_a_of_type_JavaLangString);
    ((CTEntry)???).jdField_c_of_type_JavaLangString = paramJSONObject.optString("AndroidMultiCardsIcon", ((CTEntry)???).jdField_c_of_type_JavaLangString);
    ((CTEntry)???).jdField_d_of_type_JavaLangString = paramJSONObject.optString("AndroidSingleCardIcon", ((CTEntry)???).jdField_d_of_type_JavaLangString);
    ((CTEntry)???).jdField_e_of_type_JavaLangString = paramJSONObject.optString("url", ((CTEntry)???).jdField_e_of_type_JavaLangString);
    ((CTEntry)???).jdField_a_of_type_Boolean = paramJSONObject.optBoolean("showRedDot", ((CTEntry)???).jdField_a_of_type_Boolean);
    ((CTEntry)???).jdField_b_of_type_Int = paramJSONObject.optInt("redDotVersion", ((CTEntry)???).jdField_b_of_type_Int);
    ((CTEntry)???).jdField_a_of_type_Short = ((short)paramJSONObject.optInt("switchFlag", ((CTEntry)???).jdField_a_of_type_Short));
    i = ((CTEntry)???).jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
              ((CTEntry)???).jdField_b_of_type_Boolean = false;
              ((CTEntry)???).jdField_c_of_type_Boolean = true;
            }
            else
            {
              ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
              ((CTEntry)???).jdField_b_of_type_Boolean = false;
              ((CTEntry)???).jdField_e_of_type_JavaLangString = "native";
              ((CTEntry)???).jdField_a_of_type_Short = -23316;
            }
          }
          else
          {
            ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
            ((CTEntry)???).jdField_b_of_type_Boolean = false;
            ((CTEntry)???).jdField_a_of_type_Short = -23323;
          }
        }
        else
        {
          ((CTEntry)???).jdField_b_of_type_Boolean = true;
          ((CTEntry)???).jdField_e_of_type_JavaLangString = "native";
          ((CTEntry)???).jdField_a_of_type_Short = -23447;
        }
      }
      else
      {
        ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
        ((CTEntry)???).jdField_b_of_type_Boolean = false;
        ((CTEntry)???).jdField_e_of_type_JavaLangString = "native";
        ((CTEntry)???).jdField_a_of_type_Short = -23324;
      }
    }
    else
    {
      ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
      ((CTEntry)???).jdField_b_of_type_Boolean = false;
      ((CTEntry)???).jdField_a_of_type_Short = -25161;
    }
    b((CTEntry)???);
    paramJSONObject = a(((CTEntry)???).jdField_a_of_type_Int);
    if (paramJSONObject.jdField_b_of_type_Int != ((CTEntry)???).jdField_b_of_type_Int)
    {
      paramJSONObject.jdField_b_of_type_Int = ((CTEntry)???).jdField_b_of_type_Int;
      paramJSONObject.jdField_a_of_type_Boolean = ((CTEntry)???).jdField_a_of_type_Boolean;
      paramJSONObject.jdField_b_of_type_Boolean = false;
      paramJSONObject.jdField_a_of_type_Long = 0L;
      synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
      {
        this.jdField_b_of_type_AndroidUtilSparseArray.put(paramJSONObject.jdField_a_of_type_Int, paramJSONObject);
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    int i = 0;
    try
    {
      while (i < this.jdField_c_of_type_JavaUtilList.size())
      {
        CTEntryListener localCTEntryListener = (CTEntryListener)this.jdField_c_of_type_JavaUtilList.get(i);
        if (localCTEntryListener != null) {
          localCTEntryListener.a();
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "notifyEntryUpdated [isEntryUIInit: %s, redDotFlag: %s]", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      if (!this.jdField_e_of_type_Boolean) {
        a(a(b()));
      }
    }
  }
  
  private void b(CTEntry paramCTEntry)
  {
    if (paramCTEntry == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramCTEntry.jdField_a_of_type_Int, paramCTEntry);
      return;
    }
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: invokeinterface 413 1 0
    //   9: aload_1
    //   10: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +184 -> 197
    //   16: new 324	org/json/JSONObject
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 421	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc_w 423
    //   29: invokevirtual 427	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   32: ifeq +334 -> 366
    //   35: aload_1
    //   36: ldc_w 423
    //   39: invokevirtual 431	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
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
    //   65: invokevirtual 434	org/json/JSONArray:length	()I
    //   68: if_icmpge +27 -> 95
    //   71: iload_3
    //   72: istore 4
    //   74: aload_0
    //   75: aload 6
    //   77: iload 5
    //   79: invokevirtual 438	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   82: invokespecial 440	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:a	(Lorg/json/JSONObject;)Z
    //   85: ifne +270 -> 355
    //   88: iload_3
    //   89: ifeq +261 -> 350
    //   92: goto +263 -> 355
    //   95: iload_2
    //   96: istore 4
    //   98: iload_2
    //   99: istore_3
    //   100: aload_1
    //   101: ldc_w 442
    //   104: invokevirtual 427	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   107: ifeq +92 -> 199
    //   110: iload_2
    //   111: istore 4
    //   113: aload_1
    //   114: ldc_w 442
    //   117: invokevirtual 431	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
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
    //   138: invokevirtual 434	org/json/JSONArray:length	()I
    //   141: if_icmpge +58 -> 199
    //   144: iload_2
    //   145: istore 4
    //   147: aload_1
    //   148: iload 5
    //   150: invokevirtual 446	org/json/JSONArray:getInt	(I)I
    //   153: istore_3
    //   154: iload_2
    //   155: istore 4
    //   157: aload_0
    //   158: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   161: iload_3
    //   162: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokeinterface 275 2 0
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
    //   191: invokevirtual 447	org/json/JSONException:printStackTrace	()V
    //   194: goto +5 -> 199
    //   197: iconst_0
    //   198: istore_3
    //   199: aload_0
    //   200: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   203: iconst_3
    //   204: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokeinterface 219 2 0
    //   212: ifne +17 -> 229
    //   215: aload_0
    //   216: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   219: iconst_3
    //   220: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: invokeinterface 275 2 0
    //   228: pop
    //   229: aload_0
    //   230: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   233: iconst_1
    //   234: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: invokeinterface 219 2 0
    //   242: ifeq +8 -> 250
    //   245: aload_0
    //   246: iconst_0
    //   247: invokespecial 449	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	(Z)V
    //   250: aload_0
    //   251: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   254: iconst_2
    //   255: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokeinterface 219 2 0
    //   263: ifeq +8 -> 271
    //   266: aload_0
    //   267: iconst_0
    //   268: invokespecial 451	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:f	(Z)V
    //   271: aload_0
    //   272: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   275: iconst_3
    //   276: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   279: invokeinterface 219 2 0
    //   284: ifeq +8 -> 292
    //   287: aload_0
    //   288: iconst_0
    //   289: invokespecial 282	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:g	(Z)V
    //   292: aload_0
    //   293: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   296: iconst_4
    //   297: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: invokeinterface 219 2 0
    //   305: ifeq +8 -> 313
    //   308: aload_0
    //   309: iconst_0
    //   310: invokespecial 454	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:h	(Z)V
    //   313: aload_0
    //   314: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   317: iconst_5
    //   318: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: invokeinterface 219 2 0
    //   326: ifeq +8 -> 334
    //   329: aload_0
    //   330: iconst_0
    //   331: invokevirtual 456	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:c	(Z)V
    //   334: iload_3
    //   335: ifeq +14 -> 349
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 105	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   343: invokevirtual 460	android/util/SparseArray:clone	()Landroid/util/SparseArray;
    //   346: invokespecial 462	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:a	(Landroid/util/SparseArray;)V
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
    //   50	318	2	i	int
    //   48	309	3	j	int
    //   59	123	4	k	int
    //   45	317	5	m	int
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
  
  private void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_switch", 4).getInt("key_mayknow_connections_switch", 0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initConnectionsSwitchLocal ");
        localStringBuilder.append(this.jdField_c_of_type_Int);
        QLog.i("CTEntryMng", 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
    {
      this.jdField_b_of_type_AndroidUtilSparseArray.clear();
      a(ConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "ct_entry_reddot_info"));
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "initEntryRedDot");
      }
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  private void e()
  {
    ThreadManager.excute(new CTEntryMng.3(this), 64, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveUserSetting");
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    CTEntry localCTEntry = a(1);
    boolean bool = localCTEntry.jdField_c_of_type_Boolean;
    ConfessConfig localConfessConfig = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
    if (TextUtils.isEmpty(localCTEntry.jdField_a_of_type_JavaLangString)) {
      localCTEntry.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131702801);
    }
    localCTEntry.jdField_c_of_type_Boolean = localConfessConfig.a();
    b(localCTEntry);
    if ((bool != localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_c_of_type_Boolean) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateConfessEntry show: %s, title: %s, sub: %s preValue: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
    }
  }
  
  private void f()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject = ConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "ct_entry_user_setting");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          CTEntryMng.EntryUserSetting localEntryUserSetting = new CTEntryMng.EntryUserSetting();
          localEntryUserSetting.a(localJSONObject);
          if ((localEntryUserSetting.jdField_a_of_type_Int != 0) && (localEntryUserSetting.jdField_a_of_type_Short != 0)) {
            a(localEntryUserSetting);
          }
          i += 1;
        }
        this.jdField_c_of_type_Boolean = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    CTEntry localCTEntry = a(2);
    boolean bool = localCTEntry.jdField_c_of_type_Boolean;
    IExpandManager localIExpandManager = (IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    ExpandConfig localExpandConfig;
    if (localIExpandManager == null) {
      localExpandConfig = null;
    } else {
      localExpandConfig = localIExpandManager.b();
    }
    if (localExpandConfig != null)
    {
      localCTEntry.jdField_c_of_type_Boolean = localIExpandManager.a(localExpandConfig);
      localCTEntry.jdField_a_of_type_JavaLangObject = Boolean.valueOf(localIExpandManager.d());
    }
    else
    {
      localCTEntry.jdField_c_of_type_Boolean = false;
      localCTEntry.jdField_a_of_type_JavaLangObject = null;
    }
    b(localCTEntry);
    if ((bool != localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_c_of_type_Boolean) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateExtendFrdEntry show: %s, title: %s, sub: %s, preValue: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    CTEntry localCTEntry = a(3);
    boolean bool3 = localCTEntry.jdField_c_of_type_Boolean;
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    boolean bool2;
    boolean bool1;
    if (localMayknowRecommendManager != null)
    {
      bool2 = localMayknowRecommendManager.b("sp_mayknow_entry_list_recommend");
      bool1 = localMayknowRecommendManager.b("sp_mayknow_entry_list_head");
    }
    else
    {
      bool1 = true;
      bool2 = false;
    }
    localCTEntry.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131699007);
    if ((bool1) && (!bool2)) {
      localCTEntry.jdField_c_of_type_Boolean = true;
    } else {
      localCTEntry.jdField_c_of_type_Boolean = false;
    }
    if (localCTEntry.jdField_a_of_type_JavaLangObject == null) {
      localCTEntry.jdField_b_of_type_JavaLangString = "";
    }
    if ((paramBoolean) || ((localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_a_of_type_JavaLangObject == null))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController.b();
    }
    b(localCTEntry);
    if ((bool3 != localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_c_of_type_Boolean) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateMayKnowEntry show: %s, title: %s, sub: %s, extra: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, localCTEntry.jdField_a_of_type_JavaLangObject }));
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    CTEntry localCTEntry = a(4);
    boolean bool2 = localCTEntry.jdField_c_of_type_Boolean;
    boolean bool1;
    if (BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("contacts_invite_friend_entry", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localCTEntry.jdField_c_of_type_Boolean = bool1;
    if ((bool2 != localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_c_of_type_Boolean) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateInviteFrd show: %s, title: %s, sub: %s, url: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, localCTEntry.jdField_e_of_type_JavaLangString }));
    }
  }
  
  public CTEntry a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      CTEntry localCTEntry = (CTEntry)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localCTEntry;
      if (localCTEntry == null)
      {
        ??? = new CTEntry();
        ((CTEntry)???).jdField_a_of_type_Int = paramInt;
        ((CTEntry)???).jdField_c_of_type_Boolean = false;
        ((CTEntry)???).jdField_e_of_type_Boolean = false;
        ((CTEntry)???).jdField_a_of_type_JavaLangObject = null;
      }
      return ???;
    }
  }
  
  public CTEntryMng.EntryRedDotInfo a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
    {
      CTEntryMng.EntryRedDotInfo localEntryRedDotInfo = (CTEntryMng.EntryRedDotInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localEntryRedDotInfo;
      if (localEntryRedDotInfo == null)
      {
        ??? = new CTEntryMng.EntryRedDotInfo();
        ((CTEntryMng.EntryRedDotInfo)???).jdField_a_of_type_Int = paramInt;
      }
      return ???;
    }
  }
  
  public CTEntryMng.EntryUserSetting a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (((CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramInt)
      {
        localEntryUserSetting1 = (CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i);
        break label61;
      }
      i += 1;
    }
    CTEntryMng.EntryUserSetting localEntryUserSetting1 = null;
    label61:
    CTEntryMng.EntryUserSetting localEntryUserSetting2 = localEntryUserSetting1;
    if (localEntryUserSetting1 == null)
    {
      localEntryUserSetting2 = new CTEntryMng.EntryUserSetting();
      localEntryUserSetting2.jdField_a_of_type_Int = paramInt;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                localEntryUserSetting2.jdField_a_of_type_Short = 0;
              } else {
                localEntryUserSetting2.jdField_a_of_type_Short = -23316;
              }
            }
            else {
              localEntryUserSetting2.jdField_a_of_type_Short = -23323;
            }
          }
          else {
            localEntryUserSetting2.jdField_a_of_type_Short = -23447;
          }
        }
        else {
          localEntryUserSetting2.jdField_a_of_type_Short = -23324;
        }
      }
      else {
        localEntryUserSetting2.jdField_a_of_type_Short = -25161;
      }
      localEntryUserSetting2.b = -32768;
    }
    return localEntryUserSetting2;
  }
  
  public CardViewController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController;
  }
  
  public List<CTEntry> a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(false, SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "contact_top_entry_config"));
    }
    return c();
  }
  
  public short a(CTEntry paramCTEntry, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).h();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    int i = this.jdField_a_of_type_Int;
    paramInt = 1;
    if (i != 1) {
      paramInt = 0;
    }
    CardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
    ((IRedTouchServer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateRedPoint mRedDotFlag: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("CTEntryMng", 2, localStringBuilder.toString());
    }
  }
  
  public void a(CTEntry paramCTEntry)
  {
    if (paramCTEntry == null) {
      return;
    }
    short[] arrayOfShort = new short[1];
    int i = paramCTEntry.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              arrayOfShort[0] = paramCTEntry.jdField_a_of_type_Short;
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
    Object localObject = a(paramCTEntry.jdField_a_of_type_Int);
    ((CTEntryMng.EntryUserSetting)localObject).jdField_a_of_type_Short = arrayOfShort[0];
    a((CTEntryMng.EntryUserSetting)localObject);
    localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
    if (localObject != null) {
      ((TempGetProfileDetailProcessor)localObject).getCommonSwitch(arrayOfShort);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer [id: %s, switch_id: %s, title: %s]", new Object[] { Integer.valueOf(paramCTEntry.jdField_a_of_type_Int), Short.valueOf(arrayOfShort[0]), paramCTEntry.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void a(CTEntry paramCTEntry, short paramShort)
  {
    if (paramCTEntry == null) {
      return;
    }
    CTEntryMng.EntryUserSetting localEntryUserSetting = a(paramCTEntry.jdField_a_of_type_Short);
    boolean bool;
    if ((localEntryUserSetting != null) && (localEntryUserSetting.b != paramShort))
    {
      localEntryUserSetting.b = paramShort;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (bool)
    {
      e();
      b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateEntrySetting [id:%s, switch_value: %s, needUpdate: %s]", new Object[] { Integer.valueOf(paramCTEntry.jdField_a_of_type_Int), Short.valueOf(paramShort), Boolean.valueOf(bool) }));
    }
  }
  
  public void a(CTEntryListener paramCTEntryListener)
  {
    if ((paramCTEntryListener != null) && (!this.jdField_c_of_type_JavaUtilList.contains(paramCTEntryListener))) {
      this.jdField_c_of_type_JavaUtilList.add(paramCTEntryListener);
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
      int i = 0;
      while (i < localJSONArray.length())
      {
        ??? = localJSONArray.getJSONObject(i);
        CTEntryMng.EntryRedDotInfo localEntryRedDotInfo = new CTEntryMng.EntryRedDotInfo();
        localEntryRedDotInfo.a((JSONObject)???);
        if (localEntryRedDotInfo.jdField_a_of_type_Int != 0) {
          synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.put(localEntryRedDotInfo.jdField_a_of_type_Int, localEntryRedDotInfo);
          }
        }
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "parseEntryRedDot size: %s, str: %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_AndroidUtilSparseArray.size()), paramString }));
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
    this.jdField_e_of_type_Boolean = paramBoolean;
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
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      QLog.i("CTEntryMng", 4, localStringBuilder.toString());
    }
    SharedPreUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()).edit().putBoolean("contacts_bind_phone_canshow", paramBoolean1).putInt("contacts_bind_phone_next_gap", paramInt).putBoolean("contacts_bind_phone_is_new_user", paramBoolean2).commit();
    c(false);
    b();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public List<CTEntry> b()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      CTEntry localCTEntry = a(3);
      if (localCTEntry.a())
      {
        localCTEntry.jdField_e_of_type_Boolean = a(3).a();
        localCTEntry.jdField_d_of_type_Boolean = false;
        localArrayList.add(localCTEntry);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getEntryListToShow size:");
        localStringBuilder.append(localArrayList.size());
        localStringBuilder.append("  canBeShown:");
        localStringBuilder.append(localCTEntry.jdField_c_of_type_Boolean);
        localStringBuilder.append("  isUserClose:");
        localStringBuilder.append(localCTEntry.jdField_e_of_type_Boolean);
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
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("saveConnectionsSwitchToLocal ");
      ((StringBuilder)???).append(paramInt);
      QLog.i("CTEntryMng", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_switch", 4).edit().putInt("key_mayknow_connections_switch", paramInt).commit();
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
  }
  
  public void b(CTEntryListener paramCTEntryListener)
  {
    if (paramCTEntryListener != null) {
      this.jdField_c_of_type_JavaUtilList.remove(paramCTEntryListener);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:489)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean b()
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if ((this.jdField_b_of_type_JavaUtilList.get(i) != null) && (((CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == 3)) {
        return ((CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i)).a();
      }
      i += 1;
    }
    return false;
  }
  
  public List<CTEntry> c()
  {
    return new ArrayList();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    CTEntry localCTEntry = a(5);
    boolean bool1 = localCTEntry.jdField_c_of_type_Boolean;
    int i = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateFindFriendEntry selfBindState:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      QLog.i("CTEntryMng", 4, ((StringBuilder)localObject).toString());
    }
    if ((i != 1) && (i != 2))
    {
      localCTEntry.jdField_c_of_type_Boolean = false;
    }
    else
    {
      localObject = SharedPreUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      boolean bool2 = ((SharedPreferences)localObject).getBoolean("contacts_bind_phone_canshow", false);
      localCTEntry.jdField_c_of_type_Boolean = bool2;
      if (bool2) {
        localCTEntry.jdField_a_of_type_JavaLangObject = Boolean.valueOf(((SharedPreferences)localObject).getBoolean("contacts_bind_phone_is_new_user", false));
      }
      if (!localCTEntry.jdField_e_of_type_Boolean)
      {
        i = ((SharedPreferences)localObject).getInt("contacts_bind_phone_next_gap", 300);
        long l1 = ((SharedPreferences)localObject).getLong("contacts_bind_phone_last_time", -1L);
        long l2 = NetConnInfoCenter.getServerTime();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateFindFriendEntry nextGap:");
          localStringBuilder.append(i);
          localStringBuilder.append(" gap:");
          localStringBuilder.append(l2 - l1);
          localStringBuilder.append(" uin:");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          QLog.i("CTEntryMng", 4, localStringBuilder.toString());
        }
        if ((l1 < 0L) || (l2 - l1 >= i))
        {
          ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).m();
          ((SharedPreferences)localObject).edit().putLong("contacts_bind_phone_last_time", l2).commit();
        }
      }
    }
    b(localCTEntry);
    if ((bool1 != localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_c_of_type_Boolean) && (paramBoolean)) {
      a(localCTEntry);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateFindFriendEntry show: %s, title: %s, sub: %s, preValue: %s uin: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() }));
    }
  }
  
  public boolean c()
  {
    c();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_c_of_type_Int == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_b_of_type_Int > 20))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryUserSettingFromServer fromConfig to many times!");
      }
      return;
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Int += 1;
    }
    for (;;)
    {
      short[] arrayOfShort;
      int i;
      Object localObject3;
      try
      {
        List localList = c();
        if (localList.size() > 0)
        {
          arrayOfShort = new short[localList.size()];
          Object localObject1 = "";
          i = 0;
          if (i < localList.size())
          {
            CTEntry localCTEntry = (CTEntry)localList.get(i);
            int j = localCTEntry.jdField_a_of_type_Int;
            if (j == 1) {
              break label337;
            }
            if (j == 2) {
              break label327;
            }
            if (j == 3) {
              break label317;
            }
            if (j == 4) {
              break label307;
            }
            if (j == 5) {
              break label297;
            }
            arrayOfShort[i] = localCTEntry.jdField_a_of_type_Short;
            localObject3 = a(localCTEntry.jdField_a_of_type_Int);
            ((CTEntryMng.EntryUserSetting)localObject3).jdField_a_of_type_Short = arrayOfShort[i];
            a((CTEntryMng.EntryUserSetting)localObject3);
            localObject3 = localObject1;
            if (!QLog.isColorLevel()) {
              break label347;
            }
            localObject3 = String.format(Locale.getDefault(), "%s, [id: %s, title: %s, flag: %s]", new Object[] { localObject1, Integer.valueOf(localCTEntry.jdField_a_of_type_Int), localCTEntry.jdField_a_of_type_JavaLangString, Short.valueOf(arrayOfShort[i]) });
            break label347;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer log: %s", new Object[] { localObject1 }));
          }
          localObject1 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
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
      arrayOfShort[i] = -23316;
      continue;
      label307:
      arrayOfShort[i] = -23323;
      continue;
      label317:
      arrayOfShort[i] = -23447;
      continue;
      label327:
      arrayOfShort[i] = -23324;
      continue;
      label337:
      arrayOfShort[i] = -25161;
      continue;
      label347:
      i += 1;
      Object localObject2 = localObject3;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a(this);
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController.a();
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener != null) {
      ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).removeListener(this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener = null;
  }
  
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if (paramCfgParseResult != null) {
      a(paramString, paramCfgParseResult.jdField_a_of_type_JavaLangString, paramCfgParseResult.jdField_a_of_type_Int, paramCfgParseResult.jdField_b_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng
 * JD-Core Version:    0.7.0.1
 */