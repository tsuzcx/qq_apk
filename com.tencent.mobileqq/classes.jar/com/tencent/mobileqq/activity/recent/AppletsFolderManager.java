package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.cache.AppletAccountCache;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class AppletsFolderManager
  implements Handler.Callback, Manager
{
  private static int jdField_b_of_type_Int = -1;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DBDelayManager jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager;
  private AppletAccountCache jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheAppletAccountCache;
  private AppletsHandler jdField_a_of_type_ComTencentMobileqqAppletsAppletsHandler;
  private AppletsObserver jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver = new AppletsFolderManager.1(this);
  private CustomHandler jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  @Deprecated
  public AppletsFolderManager() {}
  
  public AppletsFolderManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager = new DBDelayManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.start();
    this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsHandler = ((AppletsHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheAppletAccountCache = new AppletAccountCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(ThreadManagerV2.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(1);
    this.jdField_a_of_type_Long = a();
    this.jdField_a_of_type_Boolean = a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver);
    b();
    a(true);
  }
  
  private SharedPreferences a()
  {
    try
    {
      Object localObject = a();
      if (localObject != null)
      {
        BaseApplication localBaseApplication = ((QQAppInterface)localObject).getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AppletsFolderManager");
        localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
        localObject = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AppletsFolderManager", 2, "getSharedPreferences error!: ", localThrowable);
    }
    return null;
  }
  
  private QQAppInterface a()
  {
    QQAppInterface localQQAppInterface3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    QQAppInterface localQQAppInterface1 = localQQAppInterface3;
    QQAppInterface localQQAppInterface2;
    if (localQQAppInterface3 == null) {
      try
      {
        Object localObject = BaseApplicationImpl.getApplication();
        localQQAppInterface1 = localQQAppInterface3;
        if (localObject != null)
        {
          localObject = ((BaseApplicationImpl)localObject).getRuntime();
          localQQAppInterface1 = localQQAppInterface3;
          if ((localObject instanceof QQAppInterface)) {
            localQQAppInterface1 = (QQAppInterface)localObject;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("AppletsFolderManager", 2, "getQQAppInterface error!: ", localThrowable);
        localQQAppInterface2 = localQQAppInterface3;
      }
    }
    if (localQQAppInterface2 == null) {
      QLog.e("AppletsFolderManager", 2, "getQQAppInterface error: return null!");
    }
    return localQQAppInterface2;
  }
  
  /* Error */
  public static com.tencent.mobileqq.applets.data.AppletInfo a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 177	java/io/ObjectInputStream
    //   3: dup
    //   4: new 179	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 182	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: invokespecial 185	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_0
    //   18: aload_1
    //   19: invokevirtual 189	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_1
    //   24: astore_0
    //   25: aload_2
    //   26: instanceof 191
    //   29: ifeq +23 -> 52
    //   32: aload_1
    //   33: astore_0
    //   34: aload_2
    //   35: checkcast 191	com/tencent/mobileqq/applets/data/AppletInfo
    //   38: astore_2
    //   39: aload_1
    //   40: invokevirtual 194	java/io/ObjectInputStream:close	()V
    //   43: aload_2
    //   44: areturn
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   50: aload_2
    //   51: areturn
    //   52: aload_1
    //   53: invokevirtual 194	java/io/ObjectInputStream:close	()V
    //   56: aconst_null
    //   57: areturn
    //   58: astore_0
    //   59: aload_0
    //   60: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_2
    //   66: goto +16 -> 82
    //   69: astore_2
    //   70: goto +31 -> 101
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_1
    //   76: goto +53 -> 129
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: aload_2
    //   85: invokevirtual 198	java/lang/ClassNotFoundException:printStackTrace	()V
    //   88: aload_1
    //   89: ifnull +33 -> 122
    //   92: aload_1
    //   93: invokevirtual 194	java/io/ObjectInputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: aload_2
    //   104: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   107: aload_1
    //   108: ifnull +14 -> 122
    //   111: aload_1
    //   112: invokevirtual 194	java/io/ObjectInputStream:close	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_2
    //   125: aload_0
    //   126: astore_1
    //   127: aload_2
    //   128: astore_0
    //   129: aload_1
    //   130: ifnull +15 -> 145
    //   133: aload_1
    //   134: invokevirtual 194	java/io/ObjectInputStream:close	()V
    //   137: goto +8 -> 145
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   145: aload_0
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramArrayOfByte	byte[]
    //   15	119	1	localObject1	Object
    //   140	2	1	localIOException1	java.io.IOException
    //   22	29	2	localObject2	Object
    //   65	1	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   69	1	2	localIOException2	java.io.IOException
    //   79	6	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   98	6	2	localIOException3	java.io.IOException
    //   124	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	43	45	java/io/IOException
    //   52	56	58	java/io/IOException
    //   18	23	65	java/lang/ClassNotFoundException
    //   25	32	65	java/lang/ClassNotFoundException
    //   34	39	65	java/lang/ClassNotFoundException
    //   18	23	69	java/io/IOException
    //   25	32	69	java/io/IOException
    //   34	39	69	java/io/IOException
    //   0	16	73	finally
    //   0	16	79	java/lang/ClassNotFoundException
    //   0	16	98	java/io/IOException
    //   92	96	117	java/io/IOException
    //   111	115	117	java/io/IOException
    //   18	23	124	finally
    //   25	32	124	finally
    //   34	39	124	finally
    //   84	88	124	finally
    //   103	107	124	finally
    //   133	137	140	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.equals(paramString, QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735"))) {
      return a(false);
    }
    return true;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  /* Error */
  public static byte[] a(com.tencent.mobileqq.applets.data.AppletInfo paramAppletInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 236	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 237	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore_3
    //   16: new 239	java/io/ObjectOutputStream
    //   19: dup
    //   20: aload_3
    //   21: invokespecial 242	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: aload_0
    //   29: invokevirtual 246	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_3
    //   35: invokevirtual 250	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: astore_0
    //   39: aload_2
    //   40: invokevirtual 251	java/io/ObjectOutputStream:close	()V
    //   43: aload_0
    //   44: areturn
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   50: aload_0
    //   51: areturn
    //   52: astore_1
    //   53: aload_2
    //   54: astore_0
    //   55: aload_1
    //   56: astore_2
    //   57: goto +10 -> 67
    //   60: astore_0
    //   61: goto +30 -> 91
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: aload_2
    //   70: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   73: aload_0
    //   74: ifnull +14 -> 88
    //   77: aload_0
    //   78: invokevirtual 251	java/io/ObjectOutputStream:close	()V
    //   81: aconst_null
    //   82: areturn
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_0
    //   91: aload_1
    //   92: ifnull +15 -> 107
    //   95: aload_1
    //   96: invokevirtual 251	java/io/ObjectOutputStream:close	()V
    //   99: goto +8 -> 107
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   107: aload_0
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramAppletInfo	com.tencent.mobileqq.applets.data.AppletInfo
    //   1	33	1	localObject1	Object
    //   45	2	1	localIOException1	java.io.IOException
    //   52	4	1	localIOException2	java.io.IOException
    //   68	28	1	localAppletInfo	com.tencent.mobileqq.applets.data.AppletInfo
    //   102	2	1	localIOException3	java.io.IOException
    //   24	33	2	localObject2	Object
    //   64	6	2	localIOException4	java.io.IOException
    //   15	20	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   39	43	45	java/io/IOException
    //   27	32	52	java/io/IOException
    //   34	39	52	java/io/IOException
    //   8	25	60	finally
    //   8	25	64	java/io/IOException
    //   77	81	83	java/io/IOException
    //   27	32	90	finally
    //   34	39	90	finally
    //   69	73	90	finally
    //   95	99	102	java/io/IOException
  }
  
  public int a(com.tencent.imcore.message.Message paramMessage)
  {
    int j = 1;
    int i = j;
    if (paramMessage != null)
    {
      String str = paramMessage.getExtInfoFromExtStr(MessageConstants.A);
      if (!TextUtils.isEmpty(str)) {
        i = Integer.valueOf(str).intValue();
      } else {
        i = 1;
      }
      if (paramMessage.time < this.jdField_a_of_type_Long)
      {
        i = j;
        if (this.jdField_a_of_type_Boolean) {
          return 2;
        }
      }
    }
    return i;
  }
  
  public int a(com.tencent.imcore.message.Message paramMessage, RecentUser paramRecentUser)
  {
    int j = 1;
    int i = j;
    if (paramMessage != null)
    {
      paramMessage = paramMessage.getExtInfoFromExtStr(MessageConstants.A);
      if (!TextUtils.isEmpty(paramMessage)) {
        i = Integer.valueOf(paramMessage).intValue();
      } else {
        i = 1;
      }
      if ((paramRecentUser != null) && (paramRecentUser.lastmsgtime < this.jdField_a_of_type_Long))
      {
        i = j;
        if (this.jdField_a_of_type_Boolean) {
          return 2;
        }
      }
    }
    return i;
  }
  
  public long a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0L;
    }
    this.jdField_a_of_type_Long = localSharedPreferences.getLong("applets_setting_main_switch_time", 0L);
    return this.jdField_a_of_type_Long;
  }
  
  public AppletsAccountInfo a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheAppletAccountCache.a(paramString);
    if ((paramString != null) && (paramString.appInfoDetail != null)) {
      paramString.appInfo = a(paramString.appInfoDetail);
    }
    return paramString;
  }
  
  public String a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("applets_main_des", "");
  }
  
  public Set<String> a()
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    localObject = ((SharedPreferences)localObject).getStringSet("applets_app_list_unreceive_msg_appids", null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppletsSettingUnReceiveMsgAppids: ");
      localStringBuilder.append(localObject);
      QLog.i("AppletsFolderManager", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheAppletAccountCache.a();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    this.jdField_b_of_type_Long = paramLong;
    localSharedPreferences.edit().putLong("applets_detail_last_request_time", paramLong).apply();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.runOnUiThread(new AppletsFolderManager.2(this, paramContext, paramString1, paramString2));
  }
  
  public void a(AppletsAccountInfo paramAppletsAccountInfo)
  {
    if (paramAppletsAccountInfo != null)
    {
      paramAppletsAccountInfo.appInfoDetail = a(paramAppletsAccountInfo.appInfo);
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheAppletAccountCache.a(paramAppletsAccountInfo);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("putAppletAccountInfo: ");
      localStringBuilder.append(paramAppletsAccountInfo);
      QLog.d("AppletsFolderManager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    if (paramRecentUser != null)
    {
      paramRecentUser = paramRecentUser.uin;
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.obtainMessage(3, 0, 0, paramRecentUser).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString("applets_main_des", paramString).apply();
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    localSharedPreferences.edit().putString("applets_detail_request_answer", paramString).putInt("applets_detail_request_duration", this.jdField_a_of_type_Int).apply();
  }
  
  public void a(Set<String> paramSet)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if ((paramSet != null) && (paramSet.size() >= 1)) {
      ((SharedPreferences)localObject).edit().putStringSet("applets_app_list_unreceive_msg_appids", paramSet).apply();
    } else {
      ((SharedPreferences)localObject).edit().remove("applets_app_list_unreceive_msg_appids").apply();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAppletsSettingUnReceiveMsgAppids: ");
      ((StringBuilder)localObject).append(paramSet);
      QLog.i("AppletsFolderManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    this.jdField_a_of_type_Boolean = paramBoolean;
    localSharedPreferences.edit().putBoolean("applets_setting_main_switch", paramBoolean).putLong("applets_setting_main_switch_time", NetConnInfoCenter.getServerTime()).apply();
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return false;
    }
    this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("applets_setting_main_switch", false);
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("applets_app_list_des", "");
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = localSharedPreferences.getString("applets_detail_request_answer", "");
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("applets_detail_request_duration", 0);
    this.jdField_b_of_type_Long = localSharedPreferences.getLong("applets_detail_last_request_time", 0L);
  }
  
  public void b(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString("applets_app_list_des", paramString).apply();
  }
  
  public String c()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("applets_main_title", "");
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject2 = a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashSet();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("addAppletsSettingUnReceiveMsgAppid: ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i("AppletsFolderManager", 2, ((StringBuilder)localObject2).toString());
    }
    ((Set)localObject1).add(paramString);
    a((Set)localObject1);
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Set localSet = a();
    if (localSet != null)
    {
      if (localSet.size() < 1) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeAppletsSettingUnReceiveMsgAppid: ");
        localStringBuilder.append(paramString);
        QLog.i("AppletsFolderManager", 2, localStringBuilder.toString());
      }
      if (localSet.remove(paramString)) {
        a(localSet);
      }
    }
  }
  
  public void e(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString("applets_main_title", paramString).apply();
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheAppletAccountCache.a();
          this.jdField_b_of_type_Boolean = true;
        }
        if ((a(paramMessage) == null) || (this.jdField_b_of_type_Long + this.jdField_a_of_type_Int <= NetConnInfoCenter.getServerTime()))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(paramMessage));
          this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsHandler.a(localArrayList);
          a(NetConnInfoCenter.getServerTime());
          return true;
        }
      }
      else
      {
        paramMessage = ((List)paramMessage.obj).iterator();
        while (paramMessage.hasNext()) {
          a((AppletsAccountInfo)paramMessage.next());
        }
      }
    }
    else {
      a();
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsFolderManager", 2, "onDestroy.");
    }
    jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeCallbacksAndMessages(null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager;
    if (localObject != null) {
      ((DBDelayManager)localObject).onDestroy();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheAppletAccountCache;
    if (localObject != null) {
      ((AppletAccountCache)localObject).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.AppletsFolderManager
 * JD-Core Version:    0.7.0.1
 */