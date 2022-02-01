package com.tencent.mobileqq.activity.contacts.topentry;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
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
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
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
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new CTEntryMng.6(this);
  private PhoneContactManager.IPhoneContactListener jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = new CTEntryMng.7(this);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController = new CardViewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController$MayKnowListener);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess();
    paramQQAppInterface.a("confess_config", this);
    paramQQAppInterface.a("extend_friend_config_785", this);
    paramQQAppInterface.a("contact_top_entry_config", this);
    paramQQAppInterface.a("register_invitation_config", this);
    ThreadManager.excute(new CTEntryMng.1(this), 64, null, false);
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener != null) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
    }
  }
  
  public static int a(List<CTEntry> paramList)
  {
    int i = 0;
    if ((paramList != null) && (i < paramList.size()))
    {
      CTEntry localCTEntry = (CTEntry)paramList.get(i);
      if (localCTEntry == null) {}
      while (!localCTEntry.jdField_d_of_type_Boolean)
      {
        i += 1;
        break;
      }
      return 1;
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
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramSparseArray != null)
    {
      localObject1 = localObject2;
      if (paramSparseArray.size() > 0)
      {
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramSparseArray.size())
        {
          localObject2 = (CTEntryMng.EntryRedDotInfo)paramSparseArray.valueAt(i);
          if ((((CTEntryMng.EntryRedDotInfo)localObject2).jdField_a_of_type_Int > 4) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(((CTEntryMng.EntryRedDotInfo)localObject2).jdField_a_of_type_Int)))) {
            if (QLog.isColorLevel()) {
              QLog.i("CTEntryMng", 2, "getEntryRedDotStr not save id: " + ((CTEntryMng.EntryRedDotInfo)localObject2).jdField_a_of_type_Int);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((CTEntryMng.EntryRedDotInfo)localObject2).a();
            if (localObject2 != null) {
              ((JSONArray)localObject1).put(localObject2);
            }
          }
        }
        localObject1 = ((JSONArray)localObject1).toString();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = Locale.getDefault();
      if (paramSparseArray != null) {
        break label194;
      }
    }
    label194:
    for (int i = 0;; i = paramSparseArray.size())
    {
      QLog.i("CTEntryMng", 2, String.format((Locale)localObject2, "getEntryRedDotStr size: %s, str: %s", new Object[] { Integer.valueOf(i), localObject1 }));
      return localObject1;
    }
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
  
  /* Error */
  private void a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifne +15 -> 18
    //   6: aload_0
    //   7: getfield 37	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_Boolean	Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: invokespecial 297	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:d	()V
    //   22: aload_0
    //   23: invokespecial 300	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:f	()V
    //   26: aload_0
    //   27: aload_2
    //   28: invokespecial 303	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:b	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual 305	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:d	(Z)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 37	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_Boolean	Z
    //   41: aload_0
    //   42: invokespecial 281	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:b	()V
    //   45: aload_0
    //   46: invokespecial 307	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:c	()V
    //   49: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -37 -> 15
    //   55: ldc 88
    //   57: iconst_2
    //   58: invokestatic 253	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   61: ldc_w 309
    //   64: iconst_3
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_1
    //   71: invokestatic 314	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload_2
    //   78: aastore
    //   79: dup
    //   80: iconst_2
    //   81: aload_0
    //   82: getfield 96	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   85: invokevirtual 317	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   88: aastore
    //   89: invokestatic 261	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokestatic 94	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -80 -> 15
    //   98: astore_2
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_2
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	CTEntryMng
    //   0	103	1	paramBoolean	boolean
    //   0	103	2	paramString	String
    //   10	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	98	finally
    //   18	95	98	finally
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {}
    int i;
    do
    {
      return false;
      i = paramJSONObject.optInt("id", 0);
    } while (i == 0);
    ??? = a(i);
    ((CTEntry)???).jdField_a_of_type_Int = i;
    ((CTEntry)???).jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", ((CTEntry)???).jdField_a_of_type_JavaLangString);
    ((CTEntry)???).jdField_c_of_type_JavaLangString = paramJSONObject.optString("AndroidMultiCardsIcon", ((CTEntry)???).jdField_c_of_type_JavaLangString);
    ((CTEntry)???).jdField_d_of_type_JavaLangString = paramJSONObject.optString("AndroidSingleCardIcon", ((CTEntry)???).jdField_d_of_type_JavaLangString);
    ((CTEntry)???).jdField_e_of_type_JavaLangString = paramJSONObject.optString("url", ((CTEntry)???).jdField_e_of_type_JavaLangString);
    ((CTEntry)???).jdField_a_of_type_Boolean = paramJSONObject.optBoolean("showRedDot", ((CTEntry)???).jdField_a_of_type_Boolean);
    ((CTEntry)???).jdField_b_of_type_Int = paramJSONObject.optInt("redDotVersion", ((CTEntry)???).jdField_b_of_type_Int);
    ((CTEntry)???).jdField_a_of_type_Short = ((short)paramJSONObject.optInt("switchFlag", ((CTEntry)???).jdField_a_of_type_Short));
    switch (((CTEntry)???).jdField_a_of_type_Int)
    {
    default: 
      ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
      ((CTEntry)???).jdField_b_of_type_Boolean = false;
      ((CTEntry)???).jdField_c_of_type_Boolean = true;
      b((CTEntry)???);
      paramJSONObject = a(((CTEntry)???).jdField_a_of_type_Int);
      if (paramJSONObject.jdField_b_of_type_Int != ((CTEntry)???).jdField_b_of_type_Int)
      {
        paramJSONObject.jdField_b_of_type_Int = ((CTEntry)???).jdField_b_of_type_Int;
        paramJSONObject.jdField_a_of_type_Boolean = ((CTEntry)???).jdField_a_of_type_Boolean;
        paramJSONObject.jdField_b_of_type_Boolean = false;
        paramJSONObject.jdField_a_of_type_Long = 0L;
      }
      break;
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
      {
        this.jdField_b_of_type_AndroidUtilSparseArray.put(paramJSONObject.jdField_a_of_type_Int, paramJSONObject);
        return bool;
        ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
        ((CTEntry)???).jdField_b_of_type_Boolean = false;
        ((CTEntry)???).jdField_a_of_type_Short = -25161;
        break;
        ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
        ((CTEntry)???).jdField_b_of_type_Boolean = false;
        ((CTEntry)???).jdField_e_of_type_JavaLangString = "native";
        ((CTEntry)???).jdField_a_of_type_Short = -23324;
        break;
        ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
        ((CTEntry)???).jdField_b_of_type_Boolean = false;
        ((CTEntry)???).jdField_a_of_type_Short = -23323;
        break;
        ((CTEntry)???).jdField_b_of_type_Boolean = true;
        ((CTEntry)???).jdField_e_of_type_JavaLangString = "native";
        ((CTEntry)???).jdField_a_of_type_Short = -23447;
        break;
        ((CTEntry)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((CTEntry)???).jdField_b_of_type_JavaLangString);
        ((CTEntry)???).jdField_b_of_type_Boolean = false;
        ((CTEntry)???).jdField_e_of_type_JavaLangString = "native";
        ((CTEntry)???).jdField_a_of_type_Short = -23316;
      }
      bool = false;
    }
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
    //   4: invokeinterface 411 1 0
    //   9: aload_1
    //   10: invokestatic 417	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +327 -> 340
    //   16: new 322	org/json/JSONObject
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 419	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc_w 421
    //   29: invokevirtual 425	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   32: ifeq +303 -> 335
    //   35: aload_1
    //   36: ldc_w 421
    //   39: invokevirtual 429	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   42: astore 6
    //   44: iconst_0
    //   45: istore_3
    //   46: iconst_0
    //   47: istore_2
    //   48: aload 6
    //   50: ifnull +47 -> 97
    //   53: iload_3
    //   54: aload 6
    //   56: invokevirtual 432	org/json/JSONArray:length	()I
    //   59: if_icmpge +38 -> 97
    //   62: aload_0
    //   63: aload 6
    //   65: iload_3
    //   66: invokevirtual 436	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   69: invokespecial 438	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:a	(Lorg/json/JSONObject;)Z
    //   72: istore 5
    //   74: iload 5
    //   76: ifne +7 -> 83
    //   79: iload_2
    //   80: ifeq +12 -> 92
    //   83: iconst_1
    //   84: istore_2
    //   85: iload_3
    //   86: iconst_1
    //   87: iadd
    //   88: istore_3
    //   89: goto -41 -> 48
    //   92: iconst_0
    //   93: istore_2
    //   94: goto -9 -> 85
    //   97: iload_2
    //   98: istore_3
    //   99: aload_1
    //   100: ldc_w 440
    //   103: invokevirtual 425	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   106: ifeq +70 -> 176
    //   109: aload_1
    //   110: ldc_w 440
    //   113: invokevirtual 429	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   116: astore_1
    //   117: iconst_0
    //   118: istore 4
    //   120: iload_2
    //   121: istore_3
    //   122: aload_1
    //   123: ifnull +53 -> 176
    //   126: iload_2
    //   127: istore_3
    //   128: iload 4
    //   130: aload_1
    //   131: invokevirtual 432	org/json/JSONArray:length	()I
    //   134: if_icmpge +42 -> 176
    //   137: aload_1
    //   138: iload 4
    //   140: invokevirtual 444	org/json/JSONArray:getInt	(I)I
    //   143: istore_3
    //   144: aload_0
    //   145: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   148: iload_3
    //   149: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: invokeinterface 279 2 0
    //   157: pop
    //   158: iload 4
    //   160: iconst_1
    //   161: iadd
    //   162: istore 4
    //   164: goto -44 -> 120
    //   167: astore_1
    //   168: iconst_0
    //   169: istore_2
    //   170: aload_1
    //   171: invokevirtual 445	org/json/JSONException:printStackTrace	()V
    //   174: iload_2
    //   175: istore_3
    //   176: aload_0
    //   177: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   180: iconst_3
    //   181: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokeinterface 223 2 0
    //   189: ifne +17 -> 206
    //   192: aload_0
    //   193: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   196: iconst_3
    //   197: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokeinterface 279 2 0
    //   205: pop
    //   206: aload_0
    //   207: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   210: iconst_1
    //   211: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: invokeinterface 223 2 0
    //   219: ifeq +8 -> 227
    //   222: aload_0
    //   223: iconst_0
    //   224: invokespecial 447	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:e	(Z)V
    //   227: aload_0
    //   228: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   231: iconst_2
    //   232: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: invokeinterface 223 2 0
    //   240: ifeq +8 -> 248
    //   243: aload_0
    //   244: iconst_0
    //   245: invokespecial 449	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:f	(Z)V
    //   248: aload_0
    //   249: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   252: iconst_3
    //   253: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokeinterface 223 2 0
    //   261: ifeq +8 -> 269
    //   264: aload_0
    //   265: iconst_0
    //   266: invokespecial 286	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:g	(Z)V
    //   269: aload_0
    //   270: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   273: iconst_4
    //   274: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokeinterface 223 2 0
    //   282: ifeq +8 -> 290
    //   285: aload_0
    //   286: iconst_0
    //   287: invokespecial 452	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:h	(Z)V
    //   290: aload_0
    //   291: getfield 116	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   294: iconst_5
    //   295: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: invokeinterface 223 2 0
    //   303: ifeq +8 -> 311
    //   306: aload_0
    //   307: iconst_0
    //   308: invokevirtual 454	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:c	(Z)V
    //   311: iload_3
    //   312: ifeq +14 -> 326
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 105	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   320: invokevirtual 458	android/util/SparseArray:clone	()Landroid/util/SparseArray;
    //   323: invokespecial 460	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:a	(Landroid/util/SparseArray;)V
    //   326: return
    //   327: astore_1
    //   328: goto -158 -> 170
    //   331: astore_1
    //   332: goto -162 -> 170
    //   335: iconst_0
    //   336: istore_2
    //   337: goto -240 -> 97
    //   340: iconst_0
    //   341: istore_3
    //   342: goto -166 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	CTEntryMng
    //   0	345	1	paramString	String
    //   47	290	2	i	int
    //   45	297	3	j	int
    //   118	45	4	k	int
    //   72	3	5	bool	boolean
    //   42	22	6	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   16	44	167	org/json/JSONException
    //   53	74	327	org/json/JSONException
    //   99	117	331	org/json/JSONException
    //   128	158	331	org/json/JSONException
  }
  
  private void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_switch", 4).getInt("key_mayknow_connections_switch", 0);
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "initConnectionsSwitchLocal " + this.jdField_c_of_type_Int);
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
    if (this.jdField_d_of_type_Boolean) {}
    CTEntry localCTEntry;
    boolean bool;
    do
    {
      return;
      localCTEntry = a(1);
      bool = localCTEntry.jdField_c_of_type_Boolean;
      ConfessConfig localConfessConfig = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
      if (TextUtils.isEmpty(localCTEntry.jdField_a_of_type_JavaLangString)) {
        localCTEntry.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131702668);
      }
      localCTEntry.jdField_c_of_type_Boolean = localConfessConfig.a();
      b(localCTEntry);
      if ((bool != localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localCTEntry);
      }
    } while (!QLog.isColorLevel());
    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateConfessEntry show: %s, title: %s, sub: %s preValue: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
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
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    ExtendFriendConfig localExtendFriendConfig = localExtendFriendManager.b();
    if (localExtendFriendConfig != null) {
      localCTEntry.jdField_c_of_type_Boolean = localExtendFriendManager.a(localExtendFriendConfig);
    }
    for (localCTEntry.jdField_a_of_type_JavaLangObject = Boolean.valueOf(localExtendFriendManager.d());; localCTEntry.jdField_a_of_type_JavaLangObject = null)
    {
      b(localCTEntry);
      if ((bool != localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localCTEntry);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateExtendFrdEntry show: %s, title: %s, sub: %s, preValue: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
      return;
      localCTEntry.jdField_c_of_type_Boolean = false;
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
    for (;;)
    {
      localCTEntry.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131698928);
      if ((bool1) && (!bool2)) {}
      for (localCTEntry.jdField_c_of_type_Boolean = true;; localCTEntry.jdField_c_of_type_Boolean = false)
      {
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
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateMayKnowEntry show: %s, title: %s, sub: %s, extra: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, localCTEntry.jdField_a_of_type_JavaLangObject }));
        return;
      }
      bool1 = true;
      bool2 = false;
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    CTEntry localCTEntry = a(4);
    boolean bool2 = localCTEntry.jdField_c_of_type_Boolean;
    if (BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("contacts_invite_friend_entry", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localCTEntry.jdField_c_of_type_Boolean = bool1;
      if ((bool2 != localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localCTEntry);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateInviteFrd show: %s, title: %s, sub: %s, url: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, localCTEntry.jdField_e_of_type_JavaLangString }));
      return;
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
    if (i < this.jdField_b_of_type_JavaUtilList.size()) {
      if (((CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (CTEntryMng.EntryUserSetting localEntryUserSetting1 = (CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i);; localEntryUserSetting1 = null)
    {
      CTEntryMng.EntryUserSetting localEntryUserSetting2 = localEntryUserSetting1;
      if (localEntryUserSetting1 == null)
      {
        localEntryUserSetting2 = new CTEntryMng.EntryUserSetting();
        localEntryUserSetting2.jdField_a_of_type_Int = paramInt;
        switch (paramInt)
        {
        default: 
          localEntryUserSetting2.jdField_a_of_type_Short = 0;
        }
      }
      for (;;)
      {
        localEntryUserSetting2.b = -32768;
        return localEntryUserSetting2;
        i += 1;
        break;
        localEntryUserSetting2.jdField_a_of_type_Short = -25161;
        continue;
        localEntryUserSetting2.jdField_a_of_type_Short = -23324;
        continue;
        localEntryUserSetting2.jdField_a_of_type_Short = -23447;
        continue;
        localEntryUserSetting2.jdField_a_of_type_Short = -23323;
        continue;
        localEntryUserSetting2.jdField_a_of_type_Short = -23316;
      }
    }
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
    if (paramCTEntry == null) {
      return 0;
    }
    paramCTEntry = a(paramCTEntry.jdField_a_of_type_Int);
    short s2 = paramCTEntry.jdField_a_of_type_Short;
    if ((paramBoolean) && (paramCTEntry.b != 1)) {}
    for (short s1 = 1;; s1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "closeEntry switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(s2), Short.valueOf(s1) }));
      }
      if (s2 != 0) {
        ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(s2, s1);
      }
      return s2;
      if ((paramBoolean) || (paramCTEntry.b == 0)) {
        break;
      }
    }
    if (paramBoolean) {}
    for (s1 = 1;; s1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "closeEntry, caution something wrong!");
      }
      break;
    }
  }
  
  public void a()
  {
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).h();
  }
  
  public void a(int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramInt = i;; paramInt = 0)
    {
      CardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
      ((IRedTouchServer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, "updateRedPoint mRedDotFlag: " + this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void a(CTEntry paramCTEntry)
  {
    if (paramCTEntry == null) {
      return;
    }
    short[] arrayOfShort = new short[1];
    switch (paramCTEntry.jdField_a_of_type_Int)
    {
    default: 
      arrayOfShort[0] = paramCTEntry.jdField_a_of_type_Short;
    }
    for (;;)
    {
      Object localObject = a(paramCTEntry.jdField_a_of_type_Int);
      ((CTEntryMng.EntryUserSetting)localObject).jdField_a_of_type_Short = arrayOfShort[0];
      a((CTEntryMng.EntryUserSetting)localObject);
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
      if (localObject != null) {
        ((TempGetProfileDetailProcessor)localObject).getCommonSwitch(arrayOfShort);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer [id: %s, switch_id: %s, title: %s]", new Object[] { Integer.valueOf(paramCTEntry.jdField_a_of_type_Int), Short.valueOf(arrayOfShort[0]), paramCTEntry.jdField_a_of_type_JavaLangString }));
      return;
      arrayOfShort[0] = -25161;
      continue;
      arrayOfShort[0] = -23324;
      continue;
      arrayOfShort[0] = -23447;
      continue;
      arrayOfShort[0] = -23323;
      continue;
      arrayOfShort[0] = -23316;
    }
  }
  
  public void a(CTEntry paramCTEntry, short paramShort)
  {
    if (paramCTEntry == null) {
      return;
    }
    CTEntryMng.EntryUserSetting localEntryUserSetting = a(paramCTEntry.jdField_a_of_type_Short);
    if ((localEntryUserSetting != null) && (localEntryUserSetting.b != paramShort)) {
      localEntryUserSetting.b = paramShort;
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        e();
        b();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateEntrySetting [id:%s, switch_value: %s, needUpdate: %s]", new Object[] { Integer.valueOf(paramCTEntry.jdField_a_of_type_Int), Short.valueOf(paramShort), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public void a(CTEntryListener paramCTEntryListener)
  {
    if ((paramCTEntryListener != null) && (!this.jdField_c_of_type_JavaUtilList.contains(paramCTEntryListener))) {
      this.jdField_c_of_type_JavaUtilList.add(paramCTEntryListener);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if (paramCfgParseResult != null) {
      a(paramString, paramCfgParseResult.jdField_a_of_type_JavaLangString, paramCfgParseResult.jdField_a_of_type_Int, paramCfgParseResult.jdField_b_of_type_Int);
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        i = 0;
        if (i < localJSONArray.length())
        {
          ??? = localJSONArray.getJSONObject(i);
          CTEntryMng.EntryRedDotInfo localEntryRedDotInfo = new CTEntryMng.EntryRedDotInfo();
          localEntryRedDotInfo.a((JSONObject)???);
          if (localEntryRedDotInfo.jdField_a_of_type_Int == 0) {
            break label141;
          }
          synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.put(localEntryRedDotInfo.jdField_a_of_type_Int, localEntryRedDotInfo);
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "parseEntryRedDot size: %s, str: %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_AndroidUtilSparseArray.size()), paramString }));
      return;
      label141:
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onConfigUpdatedFromServer tag: %s, localVersion: %s, version: %s, value: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    }
    if ("confess_config".equals(paramString1)) {
      e(true);
    }
    do
    {
      return;
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
    } while (!"contact_top_entry_config".equals(paramString1));
    a(true, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "setEntryUIInit  " + paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CTEntryMng", 4, "updateBindPhoneSwitchInfo needShow:" + paramBoolean1 + " net_gap:" + paramInt + " isNewUser:" + paramBoolean2 + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryListToShow size:" + localArrayList.size() + "  canBeShown:" + localCTEntry.jdField_c_of_type_Boolean + "  isUserClose:" + localCTEntry.jdField_e_of_type_Boolean);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("CTEntryMng", 1, "getEntryListToShow error:" + localException.getMessage());
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveConnectionsSwitchToLocal " + paramInt);
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
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "setConnectionsSwitch " + paramBoolean);
    }
    if (!c()) {}
    for (boolean bool = true; bool == paramBoolean; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "setConnectionsSwitch no need to set");
      }
      return;
    }
    CardHandler localCardHandler = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramBoolean) {}
    for (;;)
    {
      localCardHandler.a((short)-23204, (short)i);
      return;
      i = 0;
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        if ((this.jdField_b_of_type_JavaUtilList.get(i) != null) && (((CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == 3)) {
          bool1 = ((CTEntryMng.EntryUserSetting)this.jdField_b_of_type_JavaUtilList.get(i)).a();
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
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
    int i = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).d();
    if (QLog.isDevelopLevel()) {
      QLog.i("CTEntryMng", 4, "updateFindFriendEntry selfBindState:" + i + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
    if ((i == 1) || (i == 2))
    {
      SharedPreferences localSharedPreferences = SharedPreUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      boolean bool2 = localSharedPreferences.getBoolean("contacts_bind_phone_canshow", false);
      localCTEntry.jdField_c_of_type_Boolean = bool2;
      if (bool2) {
        localCTEntry.jdField_a_of_type_JavaLangObject = Boolean.valueOf(localSharedPreferences.getBoolean("contacts_bind_phone_is_new_user", false));
      }
      if (!localCTEntry.jdField_e_of_type_Boolean)
      {
        i = localSharedPreferences.getInt("contacts_bind_phone_next_gap", 300);
        long l1 = localSharedPreferences.getLong("contacts_bind_phone_last_time", -1L);
        long l2 = NetConnInfoCenter.getServerTime();
        if (QLog.isDevelopLevel()) {
          QLog.i("CTEntryMng", 4, "updateFindFriendEntry nextGap:" + i + " gap:" + (l2 - l1) + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        }
        if ((l1 < 0L) || (l2 - l1 >= i))
        {
          ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).n();
          localSharedPreferences.edit().putLong("contacts_bind_phone_last_time", l2).commit();
        }
      }
    }
    for (;;)
    {
      b(localCTEntry);
      if ((bool1 != localCTEntry.jdField_c_of_type_Boolean) && (localCTEntry.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localCTEntry);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateFindFriendEntry show: %s, title: %s, sub: %s, preValue: %s uin: %s", new Object[] { Boolean.valueOf(localCTEntry.jdField_c_of_type_Boolean), localCTEntry.jdField_a_of_type_JavaLangString, localCTEntry.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() }));
      return;
      localCTEntry.jdField_c_of_type_Boolean = false;
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
    String str = "";
    for (;;)
    {
      short[] arrayOfShort;
      int i;
      try
      {
        List localList = c();
        if (localList.size() <= 0) {
          break;
        }
        arrayOfShort = new short[localList.size()];
        i = 0;
        if (i >= localList.size()) {
          break label257;
        }
        CTEntry localCTEntry = (CTEntry)localList.get(i);
        switch (localCTEntry.jdField_a_of_type_Int)
        {
        case 1: 
          arrayOfShort[i] = localCTEntry.jdField_a_of_type_Short;
          CTEntryMng.EntryUserSetting localEntryUserSetting = a(localCTEntry.jdField_a_of_type_Int);
          localEntryUserSetting.jdField_a_of_type_Short = arrayOfShort[i];
          a(localEntryUserSetting);
          if (!QLog.isColorLevel()) {
            break label311;
          }
          str = String.format(Locale.getDefault(), "%s, [id: %s, title: %s, flag: %s]", new Object[] { str, Integer.valueOf(localCTEntry.jdField_a_of_type_Int), localCTEntry.jdField_a_of_type_JavaLangString, Short.valueOf(arrayOfShort[i]) });
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      arrayOfShort[i] = -25161;
      continue;
      arrayOfShort[i] = -23324;
      continue;
      label257:
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer log: %s", new Object[] { localThrowable }));
      }
      TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
      if (localTempGetProfileDetailProcessor == null) {
        break;
      }
      localTempGetProfileDetailProcessor.getCommonSwitch(arrayOfShort);
      return;
      label311:
      break label317;
      continue;
      label317:
      i += 1;
      continue;
      arrayOfShort[i] = -23447;
      continue;
      arrayOfShort[i] = -23323;
      continue;
      arrayOfShort[i] = -23316;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a(this);
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.CONTACT_MANAGER)) && (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener != null)) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng
 * JD-Core Version:    0.7.0.1
 */