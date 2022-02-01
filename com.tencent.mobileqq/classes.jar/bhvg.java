import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.AuthResponse;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;

public class bhvg
{
  public PBInt64Field a;
  public PBRepeatMessageField<appType.PassData> a;
  public PBStringField a;
  public PBUInt32Field a;
  public auth.ProxyAuthResponse a;
  public PBStringField b;
  public PBUInt32Field b;
  public PBStringField c = PBField.initString("");
  public PBStringField d = PBField.initString("");
  public PBStringField e = PBField.initString("");
  public PBStringField f = PBField.initString("");
  public PBStringField g = PBField.initString("");
  public PBStringField h = PBField.initString("");
  public PBStringField i = PBField.initString("");
  public PBStringField j = PBField.initString("");
  public PBStringField k = PBField.initString("");
  public PBStringField l = PBField.initString("");
  public PBStringField m = PBField.initString("");
  public PBStringField n = PBField.initString("");
  
  public bhvg()
  {
    this.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_b_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = PBField.initInt64(0L);
    this.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = PBField.initRepeatMessage(appType.PassData.class);
    this.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = new auth.ProxyAuthResponse();
  }
  
  public static bhvg a(SdkAuthorize.AuthorizeResponse paramAuthorizeResponse)
  {
    bhvg localbhvg = new bhvg();
    localbhvg.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.ret;
    localbhvg.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.msg;
    localbhvg.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.access_token;
    localbhvg.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthorizeResponse.expires_in;
    localbhvg.c = paramAuthorizeResponse.openid;
    localbhvg.d = paramAuthorizeResponse.pay_token;
    localbhvg.e = paramAuthorizeResponse.encrytoken;
    localbhvg.f = paramAuthorizeResponse.pf;
    localbhvg.g = paramAuthorizeResponse.pfkey;
    localbhvg.h = paramAuthorizeResponse.encrykey;
    localbhvg.i = paramAuthorizeResponse.md5key;
    localbhvg.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.sendinstall;
    localbhvg.j = paramAuthorizeResponse.installwording;
    localbhvg.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthorizeResponse.passDataResp;
    localbhvg.k = paramAuthorizeResponse.signQQkey;
    localbhvg.l = paramAuthorizeResponse.md5QQkey;
    localbhvg.m = paramAuthorizeResponse.callbackURL;
    return localbhvg;
  }
  
  public static bhvg a(auth.AuthResponse paramAuthResponse)
  {
    bhvg localbhvg = new bhvg();
    localbhvg.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthResponse.ret;
    localbhvg.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.msg;
    localbhvg.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.access_token;
    localbhvg.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthResponse.expires_in;
    localbhvg.c = paramAuthResponse.openid;
    localbhvg.d = paramAuthResponse.pay_token;
    localbhvg.e = paramAuthResponse.encrytoken;
    localbhvg.f = paramAuthResponse.pf;
    localbhvg.g = paramAuthResponse.pfkey;
    localbhvg.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthResponse.pass_data_resp;
    localbhvg.m = paramAuthResponse.callback_url;
    localbhvg.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = paramAuthResponse.proxy_auth_resp;
    localbhvg.n = paramAuthResponse.code;
    return localbhvg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvg
 * JD-Core Version:    0.7.0.1
 */