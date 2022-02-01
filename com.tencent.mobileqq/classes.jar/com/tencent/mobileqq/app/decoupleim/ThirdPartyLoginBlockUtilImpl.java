package com.tencent.mobileqq.app.decoupleim;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspLftInfo;

public class ThirdPartyLoginBlockUtilImpl
  implements ThirdPartyLoginBlockUtilInterface
{
  private static volatile ThirdPartyLoginBlockUtilImpl a;
  private OpenSDKLoginCallback b;
  
  public static ThirdPartyLoginBlockUtilImpl a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ThirdPartyLoginBlockUtilImpl();
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean b(byte[] paramArrayOfByte, QBaseActivity paramQBaseActivity)
  {
    if ((paramQBaseActivity != null) && (paramQBaseActivity.getIntent() != null))
    {
      if (paramArrayOfByte == null)
      {
        QLog.d("ThirdPartyLoginUtilImpl", 1, "not im block");
        return true;
      }
      return false;
    }
    QLog.e("ThirdPartyLoginUtilImpl", 1, "activity related param null");
    return true;
  }
  
  public void a(OpenSDKLoginCallback paramOpenSDKLoginCallback)
  {
    this.b = paramOpenSDKLoginCallback;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ThirdPartyLoginUtilImpl", 1, "loginWithOpenSDKApi");
    LoginHelper.a(paramString1, paramString2, paramString3, new ThirdPartyLoginBlockUtilImpl.1(this, paramString1));
  }
  
  public boolean a(byte[] paramArrayOfByte, QBaseActivity paramQBaseActivity)
  {
    QLog.d("ThirdPartyLoginUtilImpl", 1, "shouldIMLoginBlock");
    if (b(paramArrayOfByte, paramQBaseActivity)) {
      return false;
    }
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      if ((localRspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() == 1) && (AuthParamUtil.a(paramQBaseActivity.getIntent())))
      {
        QLog.d("ThirdPartyLoginUtilImpl", 1, "shouldIMLoginBlock FORBID_AREA_IM");
        return true;
      }
      ReportController.a(null, "dc00898", "", "", "0X800B189", "0X800B189", 0, 0, "", "", "", "");
      QLog.d("ThirdPartyLoginUtilImpl", 1, "shouldIMLoginBlock FORBID_AREA_ALL");
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "GatewayVerify.RspBody error: ", paramArrayOfByte);
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, QBaseActivity paramQBaseActivity, String paramString1, String paramString2, OpenSDKLoginCallback paramOpenSDKLoginCallback)
  {
    if (a(paramArrayOfByte, paramQBaseActivity))
    {
      QLog.d("ThirdPartyLoginUtilImpl", 1, "handleByThirdPartyLoginUtil true");
      a(paramOpenSDKLoginCallback);
      a(paramString1, paramString2, paramQBaseActivity.getIntent().getStringExtra("im_block_sso_appid"));
      return true;
    }
    QLog.d("ThirdPartyLoginUtilImpl", 1, "handleByThirdPartyLoginUtil false");
    return false;
  }
  
  public void b()
  {
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl
 * JD-Core Version:    0.7.0.1
 */