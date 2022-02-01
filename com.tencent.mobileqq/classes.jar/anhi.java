import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspLftInfo;

public class anhi
{
  private static volatile anhi jdField_a_of_type_Anhi;
  private anhh jdField_a_of_type_Anhh;
  
  public static anhi a()
  {
    if (jdField_a_of_type_Anhi == null) {}
    try
    {
      if (jdField_a_of_type_Anhi == null) {
        jdField_a_of_type_Anhi = new anhi();
      }
      return jdField_a_of_type_Anhi;
    }
    finally {}
  }
  
  private boolean a(Intent paramIntent, Bundle paramBundle)
  {
    if ((paramIntent == null) || (paramBundle == null))
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "handleAgentAppId params empty");
      return true;
    }
    return false;
  }
  
  private boolean a(WUserSigInfo paramWUserSigInfo)
  {
    if (paramWUserSigInfo == null) {
      return true;
    }
    paramWUserSigInfo = paramWUserSigInfo.loginResultTLVMap;
    if (paramWUserSigInfo == null) {
      return true;
    }
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.get(Integer.valueOf(1347));
    if (paramWUserSigInfo == null) {
      return true;
    }
    if (paramWUserSigInfo.get_data() == null) {
      return true;
    }
    QLog.d("ThirdPartyLoginUtilImpl", 1, "SigData is valid");
    return false;
  }
  
  private boolean b(Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramBundle.getParcelable("userSigInfo") == null))
    {
      QLog.d("ThirdPartyLoginUtilImpl", 1, "checkIMBlockByBundle not support im block check");
      return true;
    }
    return false;
  }
  
  private boolean b(byte[] paramArrayOfByte, BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.getIntent() == null))
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "activity related param null");
      return true;
    }
    if (paramArrayOfByte == null)
    {
      QLog.d("ThirdPartyLoginUtilImpl", 1, "not im block");
      return true;
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Anhh = null;
  }
  
  public void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    QLog.d("ThirdPartyLoginUtilImpl", 1, "handleAgentAppId");
    if (a(paramIntent, paramBundle)) {
      return;
    }
    long l2 = paramBundle.getLong("dstAppid");
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1600001540L;
    }
    paramBundle = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramBundle = String.valueOf(l1);
    }
    paramIntent.putExtra("im_block_sso_appid", paramBundle);
    QLog.d("ThirdPartyLoginUtilImpl", 1, "put IM_BLOCK_SSO_APPID: " + paramBundle);
  }
  
  public void a(anhh paramanhh)
  {
    this.jdField_a_of_type_Anhh = paramanhh;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ThirdPartyLoginUtilImpl", 1, "loginWithOpenSDKApi");
    bize.a(paramString1, paramString2, paramString3, new anhj(this, paramString1));
  }
  
  public boolean a(Bundle paramBundle)
  {
    QLog.d("ThirdPartyLoginUtilImpl", 1, "checkIMBlockByBundle");
    if (b(paramBundle)) {
      return false;
    }
    paramBundle = (WUserSigInfo)paramBundle.getParcelable("userSigInfo");
    if (a(paramBundle)) {
      return false;
    }
    try
    {
      paramBundle = ((tlv_t)paramBundle.loginResultTLVMap.get(Integer.valueOf(1347))).get_data();
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramBundle);
      if (localRspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() == 1)
      {
        QLog.d("ThirdPartyLoginUtilImpl", 1, "checkIMBlockByBundle FORBID_AREA_IM");
        return true;
      }
      QLog.d("ThirdPartyLoginUtilImpl", 1, "checkIMBlockByBundle FORBID_AREA_ALL");
      return false;
    }
    catch (Exception paramBundle)
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "GatewayVerify.RspBody error: ", paramBundle);
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, BaseActivity paramBaseActivity)
  {
    QLog.d("ThirdPartyLoginUtilImpl", 1, "shouldIMLoginBlock");
    if (b(paramArrayOfByte, paramBaseActivity)) {
      return false;
    }
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      if ((localRspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() == 1) && (paramBaseActivity.getIntent().getBooleanExtra("authority_start_qq_login", false)))
      {
        QLog.d("ThirdPartyLoginUtilImpl", 1, "shouldIMLoginBlock FORBID_AREA_IM");
        return true;
      }
      bcef.a(null, "dc00898", "", "", "0X800B189", "0X800B189", 0, 0, "", "", "", "");
      QLog.d("ThirdPartyLoginUtilImpl", 1, "shouldIMLoginBlock FORBID_AREA_ALL");
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "GatewayVerify.RspBody error: ", paramArrayOfByte);
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, BaseActivity paramBaseActivity, String paramString1, String paramString2, anhh paramanhh)
  {
    if (a(paramArrayOfByte, paramBaseActivity))
    {
      QLog.d("ThirdPartyLoginUtilImpl", 1, "handleByThirdPartyLoginUtil true");
      a(paramanhh);
      a(paramString1, paramString2, paramBaseActivity.getIntent().getStringExtra("im_block_sso_appid"));
      return true;
    }
    QLog.d("ThirdPartyLoginUtilImpl", 1, "handleByThirdPartyLoginUtil false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhi
 * JD-Core Version:    0.7.0.1
 */