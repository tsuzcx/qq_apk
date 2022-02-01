import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.AuthResponse;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;

public class bjgh
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
  
  public bjgh()
  {
    this.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_b_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = PBField.initInt64(0L);
    this.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = PBField.initRepeatMessage(appType.PassData.class);
    this.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = new auth.ProxyAuthResponse();
  }
  
  public static bjgh a(SdkAuthorize.AuthorizeResponse paramAuthorizeResponse)
  {
    bjgh localbjgh = new bjgh();
    localbjgh.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.ret;
    localbjgh.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.msg;
    localbjgh.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.access_token;
    localbjgh.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthorizeResponse.expires_in;
    localbjgh.c = paramAuthorizeResponse.openid;
    localbjgh.d = paramAuthorizeResponse.pay_token;
    localbjgh.e = paramAuthorizeResponse.encrytoken;
    localbjgh.f = paramAuthorizeResponse.pf;
    localbjgh.g = paramAuthorizeResponse.pfkey;
    localbjgh.h = paramAuthorizeResponse.encrykey;
    localbjgh.i = paramAuthorizeResponse.md5key;
    localbjgh.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.sendinstall;
    localbjgh.j = paramAuthorizeResponse.installwording;
    localbjgh.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthorizeResponse.passDataResp;
    localbjgh.k = paramAuthorizeResponse.signQQkey;
    localbjgh.l = paramAuthorizeResponse.md5QQkey;
    localbjgh.m = paramAuthorizeResponse.callbackURL;
    return localbjgh;
  }
  
  public static bjgh a(auth.AuthResponse paramAuthResponse)
  {
    bjgh localbjgh = new bjgh();
    localbjgh.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthResponse.ret;
    localbjgh.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.msg;
    localbjgh.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.access_token;
    localbjgh.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthResponse.expires_in;
    localbjgh.c = paramAuthResponse.openid;
    localbjgh.d = paramAuthResponse.pay_token;
    localbjgh.e = paramAuthResponse.encrytoken;
    localbjgh.f = paramAuthResponse.pf;
    localbjgh.g = paramAuthResponse.pfkey;
    localbjgh.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthResponse.pass_data_resp;
    localbjgh.m = paramAuthResponse.callback_url;
    localbjgh.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = paramAuthResponse.proxy_auth_resp;
    localbjgh.n = paramAuthResponse.code;
    return localbjgh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgh
 * JD-Core Version:    0.7.0.1
 */