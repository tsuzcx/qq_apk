package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.CMSCommonAction;
import com.tencent.mobileqq.apollo.api.player.action.CMSPanelAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig.FrameType;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.ApolloRoleInfoListener;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.ApolloUserDressInfoListener;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager;
import com.tencent.mobileqq.apollo.player.CMSPlayer;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.ICMSRecordCallback;
import com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;

public class ApolloClientQIPCModule
  extends QIPCModule
{
  public static final float a;
  private static HashMap<CMSAction, GetFrameCallback> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static HashMap<CMSAction, ICMSPlayerListener> b = new HashMap();
  private CMSPlayer jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer = null;
  
  static
  {
    jdField_a_of_type_Float = CmShowWnsUtils.b();
  }
  
  private ApolloClientQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static ApolloClientQIPCModule a()
  {
    return ApolloClientQIPCModule.ApolloClientClass.a();
  }
  
  public static void a(int paramInt, ApolloResManagerImpl.ApolloRoleInfoListener paramApolloRoleInfoListener)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putInt("apolloRoleId", paramInt);
    localBundle.putLong("startTime", l);
    TraceReportUtil.a(132, String.valueOf(l));
    TraceReportUtil.a(132, String.valueOf(l), 3);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_get_role_dir", localBundle, new ApolloClientQIPCModule.11(paramApolloRoleInfoListener));
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = new ApolloActionData();
    ((ApolloActionData)localObject).actionId = paramInt2;
    ((ApolloActionData)localObject).actionType = paramInt3;
    ((ApolloActionData)localObject).personNum = 0;
    ((ApolloActionData)localObject).actionName = "avatar";
    paramString = new CMSPanelAction((ApolloActionData)localObject, paramString);
    paramString.a().a(ApolloConstant.c);
    paramString.a().a(BusinessConfig.FrameType.JPEG);
    localObject = new ApolloClientQIPCModule.3(this, paramInt2, paramInt1);
    jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer.a(paramString, jdField_a_of_type_Float, (GetFrameCallback)localObject);
  }
  
  private void a(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    String str = paramBundle.getString("uin");
    int i = paramBundle.getInt("actionId");
    int j = paramBundle.getInt("isDynamic");
    int k = paramBundle.getInt("actionType");
    if (j == 1)
    {
      paramBundle = new ApolloAvatarVideoProcessor(paramQQAppInterface);
      paramBundle.a(new ApolloClientQIPCModule.1(this, j, paramInt));
      paramBundle.a(i, k);
    }
    while (j != 0) {
      return;
    }
    ApolloAvatarFileManager.a().a(i, k, str, new ApolloClientQIPCModule.2(this, paramQQAppInterface, j, paramInt));
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ICMSRecordCallback paramICMSRecordCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putInt("actionId", paramInt1);
    localBundle.putInt("actionType", paramInt2);
    localBundle.putInt("isDynamic", paramInt3);
    localBundle.putInt("spriteType", paramInt4);
    localBundle.putInt("width", paramInt5);
    localBundle.putInt("height", paramInt6);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_record_action", localBundle, new ApolloClientQIPCModule.13(paramICMSRecordCallback, paramInt1));
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, IAvatarInterface paramIAvatarInterface)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putInt("actionId", paramInt1);
    localBundle.putInt("isDynamic", paramInt3);
    localBundle.putInt("actionType", paramInt2);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_set_avatar", localBundle, new ApolloClientQIPCModule.14(paramIAvatarInterface));
  }
  
  public static void a(String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putLong("startTime", l);
    TraceReportUtil.a(132, String.valueOf(l));
    TraceReportUtil.a(132, String.valueOf(l), 4);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_check_face_data_download", localBundle, new ApolloClientQIPCModule.12(paramOnFaceDataDownloadListener));
  }
  
  public static void a(String paramString, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putLong("startTime", l);
    TraceReportUtil.a(132, null, String.valueOf(l));
    TraceReportUtil.a(132, String.valueOf(l), 1);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_get_user_res_info", localBundle, new ApolloClientQIPCModule.9(paramApolloUserDressInfoListener));
  }
  
  public static void a(ArrayList<Integer> paramArrayList, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putIntegerArrayList("apolloDressIdList", paramArrayList);
    localBundle.putLong("startTime", l);
    TraceReportUtil.a(132, null, String.valueOf(l));
    TraceReportUtil.a(132, String.valueOf(l), 2);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_get_dress_info", localBundle, new ApolloClientQIPCModule.10(paramApolloDressInfoListener));
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramString = new CMSCommonAction(paramInt2, paramInt3, paramString, null, null);
    paramString.a(MODE.ACTION_MODE_RECORD_GIF);
    paramString.a().b(ApolloConstant.c);
    ApolloClientQIPCModule.4 local4 = new ApolloClientQIPCModule.4(this, paramInt2, paramInt1);
    b.put(paramString, local4);
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer.a(null, paramString, local4);
  }
  
  private void b(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramBundle.getString("uin");
    int i = paramBundle.getInt("actionId");
    int j = paramBundle.getInt("actionType");
    int k = paramBundle.getInt("isDynamic");
    int m = paramBundle.getInt("width");
    int n = paramBundle.getInt("height");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer = new CMSPlayer(m, n);
    }
    if (k == 1) {
      b(paramInt, paramQQAppInterface, i, j);
    }
    while (k != 0) {
      return;
    }
    a(paramInt, paramQQAppInterface, i, j);
  }
  
  private void c(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("cm_res", 1, " handleGetDressInfo ");
    ApolloResManagerImpl localApolloResManagerImpl = (ApolloResManagerImpl)QRoute.api(IApolloResManager.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (localApolloResManagerImpl == null)
    {
      localBundle.putString("apolloErrMsg", "apolloResManager is null");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    localApolloResManagerImpl.getApolloRoleInfo(paramQQAppInterface, paramBundle.getInt("apolloRoleId"), new ApolloClientQIPCModule.5(this, localBundle, paramInt));
  }
  
  private void d(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("cm_res", 1, " handleGetDressInfo ");
    ApolloResManagerImpl localApolloResManagerImpl = (ApolloResManagerImpl)QRoute.api(IApolloResManager.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (localApolloResManagerImpl == null)
    {
      localBundle.putString("apolloErrMsg", "apolloResManager is null");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    localApolloResManagerImpl.getApolloDressInfo(paramQQAppInterface, paramBundle.getIntegerArrayList("apolloDressIdList"), new ApolloClientQIPCModule.6(this, localBundle, paramInt));
  }
  
  private void e(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("cm_res", 1, " handleGetUserRes ");
    String str = paramBundle.getString("uin");
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (TextUtils.isEmpty(str))
    {
      localBundle.putString("apolloErrMsg", "uin isEmpty");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    paramBundle = (ApolloResManagerImpl)QRoute.api(IApolloResManager.class);
    if (paramBundle == null)
    {
      localBundle.putString("apolloErrMsg", "apolloResManager is null");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    paramBundle.getApolloUserDressInfo(paramQQAppInterface, str, new ApolloClientQIPCModule.7(this, localBundle, paramInt));
  }
  
  private void f(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("cm_res", 1, " handleCheckFaceDataDownload ");
    String str = paramBundle.getString("url");
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (TextUtils.isEmpty(str))
    {
      localBundle.putString("apolloErrMsg", "url isEmpty");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(paramQQAppInterface, str, new ApolloClientQIPCModule.8(this, localBundle, paramInt));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("cm_res", 2, "onCall, action : " + paramString);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      QLog.i("cm_res", 2, "onRemoteInvoke cannot get QQAppInterface");
    }
    do
    {
      return null;
      localObject = (QQAppInterface)localObject;
      if ("action_get_user_res_info".equals(paramString))
      {
        e(paramBundle, paramInt, (QQAppInterface)localObject);
        return null;
      }
      if ("action_get_dress_info".equals(paramString))
      {
        d(paramBundle, paramInt, (QQAppInterface)localObject);
        return null;
      }
      if ("action_get_role_dir".equals(paramString))
      {
        c(paramBundle, paramInt, (QQAppInterface)localObject);
        return null;
      }
      if ("action_check_face_data_download".equals(paramString))
      {
        f(paramBundle, paramInt, (QQAppInterface)localObject);
        return null;
      }
      if ("action_record_action".equals(paramString))
      {
        b(paramBundle, paramInt, (QQAppInterface)localObject);
        return null;
      }
    } while (!"action_set_avatar".equals(paramString));
    a(paramBundle, paramInt, (QQAppInterface)localObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */