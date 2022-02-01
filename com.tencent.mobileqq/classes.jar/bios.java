import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.AuthResponse;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;

public class bios
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
  
  public bios()
  {
    this.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_b_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = PBField.initInt64(0L);
    this.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = PBField.initRepeatMessage(appType.PassData.class);
    this.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = new auth.ProxyAuthResponse();
  }
  
  public static bios a(SdkAuthorize.AuthorizeResponse paramAuthorizeResponse)
  {
    bios localbios = new bios();
    localbios.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.ret;
    localbios.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.msg;
    localbios.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.access_token;
    localbios.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthorizeResponse.expires_in;
    localbios.c = paramAuthorizeResponse.openid;
    localbios.d = paramAuthorizeResponse.pay_token;
    localbios.e = paramAuthorizeResponse.encrytoken;
    localbios.f = paramAuthorizeResponse.pf;
    localbios.g = paramAuthorizeResponse.pfkey;
    localbios.h = paramAuthorizeResponse.encrykey;
    localbios.i = paramAuthorizeResponse.md5key;
    localbios.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.sendinstall;
    localbios.j = paramAuthorizeResponse.installwording;
    localbios.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthorizeResponse.passDataResp;
    localbios.k = paramAuthorizeResponse.signQQkey;
    localbios.l = paramAuthorizeResponse.md5QQkey;
    localbios.m = paramAuthorizeResponse.callbackURL;
    return localbios;
  }
  
  public static bios a(auth.AuthResponse paramAuthResponse)
  {
    bios localbios = new bios();
    localbios.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthResponse.ret;
    localbios.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.msg;
    localbios.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.access_token;
    localbios.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthResponse.expires_in;
    localbios.c = paramAuthResponse.openid;
    localbios.d = paramAuthResponse.pay_token;
    localbios.e = paramAuthResponse.encrytoken;
    localbios.f = paramAuthResponse.pf;
    localbios.g = paramAuthResponse.pfkey;
    localbios.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthResponse.pass_data_resp;
    localbios.m = paramAuthResponse.callback_url;
    localbios.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = paramAuthResponse.proxy_auth_resp;
    localbios.n = paramAuthResponse.code;
    return localbios;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bios
 * JD-Core Version:    0.7.0.1
 */