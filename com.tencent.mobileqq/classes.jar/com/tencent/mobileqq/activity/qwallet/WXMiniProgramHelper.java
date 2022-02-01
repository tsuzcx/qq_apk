package com.tencent.mobileqq.activity.qwallet;

import akoz;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.Map;
import mqq.os.MqqHandler;

public class WXMiniProgramHelper
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  private static WXMiniProgramHelper jdField_a_of_type_ComTencentMobileqqActivityQwalletWXMiniProgramHelper;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private IWXAPI jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wxf0a80d0ac2e82aa7", true);
  
  public WXMiniProgramHelper()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    a();
  }
  
  public static WXMiniProgramHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletWXMiniProgramHelper == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletWXMiniProgramHelper == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletWXMiniProgramHelper = new WXMiniProgramHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletWXMiniProgramHelper;
    }
  }
  
  private void a(MqqHandler paramMqqHandler, int paramInt)
  {
    paramMqqHandler.post(new WXMiniProgramHelper.1(this, paramInt));
  }
  
  private void b()
  {
    try
    {
      Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
      if (QLog.isColorLevel()) {
        QLog.i("WXMiniProgramHelper", 2, "launchWXUsingPendingIntent");
      }
      PendingIntent.getActivity(localContext, 1, localContext.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"), 134217728).send(localContext, 1, null, new akoz(this), null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WXMiniProgramHelper", 1, "launchWXUsingPendingIntent pendingIntent send failed: " + localException.getMessage());
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.openWXApp();
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.registerApp("wxf0a80d0ac2e82aa7");
      if (QLog.isColorLevel()) {
        QLog.d("WXMiniProgramHelper", 1, "registerApp()");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WXMiniProgramHelper", 1, localException, new Object[0]);
    }
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WXMiniProgramHelper", 2, "handleWXEntryActivityIntent");
    }
    if (this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WXMiniProgramHelper", 2, "handleWXEntryActivityIntent api != null");
      }
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXMiniProgramHelper", 2, "launchMiniProgram: ");
    }
    Object localObject = ThreadManager.getUIHandler();
    if (!this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.isWXAppInstalled())
    {
      a((MqqHandler)localObject, 2131692608);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() < 621086464)
    {
      a((MqqHandler)localObject, 2131692609);
      return;
    }
    if (Build.VERSION.SDK_INT >= 29) {
      b();
    }
    localObject = new WXLaunchMiniProgram.Req();
    ((WXLaunchMiniProgram.Req)localObject).userName = ((String)paramMap.get("user_name"));
    try
    {
      i = Integer.valueOf((String)paramMap.get("app_type")).intValue();
      ((WXLaunchMiniProgram.Req)localObject).miniprogramType = i;
      str = (String)paramMap.get("path");
      if (TextUtils.isEmpty(str)) {}
    }
    catch (Exception localException)
    {
      try
      {
        String str;
        ((WXLaunchMiniProgram.Req)localObject).path = URLDecoder.decode(str, "UTF-8");
        paramMap = (String)paramMap.get("ext");
        if (paramMap != null) {
          ((WXLaunchMiniProgram.Req)localObject).extData = paramMap;
        }
        this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq((BaseReq)localObject);
        return;
        localException = localException;
        QLog.e("WXMiniProgramHelper", 1, localException, new Object[0]);
        int i = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WXMiniProgramHelper", 1, "onReceive() api != null");
      }
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
    }
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXMiniProgramHelper", 1, "onReq: ");
    }
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXMiniProgramHelper", 1, "onResp: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper
 * JD-Core Version:    0.7.0.1
 */