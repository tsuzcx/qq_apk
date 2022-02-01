import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.AuthResponse;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;

public class bjpr
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
  
  public bjpr()
  {
    this.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_b_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = PBField.initInt64(0L);
    this.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = PBField.initRepeatMessage(appType.PassData.class);
    this.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = new auth.ProxyAuthResponse();
  }
  
  public static bjpr a(SdkAuthorize.AuthorizeResponse paramAuthorizeResponse)
  {
    bjpr localbjpr = new bjpr();
    localbjpr.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.ret;
    localbjpr.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.msg;
    localbjpr.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.access_token;
    localbjpr.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthorizeResponse.expires_in;
    localbjpr.c = paramAuthorizeResponse.openid;
    localbjpr.d = paramAuthorizeResponse.pay_token;
    localbjpr.e = paramAuthorizeResponse.encrytoken;
    localbjpr.f = paramAuthorizeResponse.pf;
    localbjpr.g = paramAuthorizeResponse.pfkey;
    localbjpr.h = paramAuthorizeResponse.encrykey;
    localbjpr.i = paramAuthorizeResponse.md5key;
    localbjpr.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.sendinstall;
    localbjpr.j = paramAuthorizeResponse.installwording;
    localbjpr.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthorizeResponse.passDataResp;
    localbjpr.k = paramAuthorizeResponse.signQQkey;
    localbjpr.l = paramAuthorizeResponse.md5QQkey;
    localbjpr.m = paramAuthorizeResponse.callbackURL;
    return localbjpr;
  }
  
  public static bjpr a(auth.AuthResponse paramAuthResponse)
  {
    bjpr localbjpr = new bjpr();
    localbjpr.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthResponse.ret;
    localbjpr.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.msg;
    localbjpr.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.access_token;
    localbjpr.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthResponse.expires_in;
    localbjpr.c = paramAuthResponse.openid;
    localbjpr.d = paramAuthResponse.pay_token;
    localbjpr.e = paramAuthResponse.encrytoken;
    localbjpr.f = paramAuthResponse.pf;
    localbjpr.g = paramAuthResponse.pfkey;
    localbjpr.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthResponse.pass_data_resp;
    localbjpr.m = paramAuthResponse.callback_url;
    localbjpr.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = paramAuthResponse.proxy_auth_resp;
    localbjpr.n = paramAuthResponse.code;
    return localbjpr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpr
 * JD-Core Version:    0.7.0.1
 */