import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginTicketInfo;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LogoutReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.TicketInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class axju
{
  private static axju jdField_a_of_type_Axju;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static axju a()
  {
    if (jdField_a_of_type_Axju == null)
    {
      jdField_a_of_type_Axju = new axju();
      axjq.a().b(axin.b());
    }
    return jdField_a_of_type_Axju;
  }
  
  public static void a()
  {
    jdField_a_of_type_Axju = null;
  }
  
  public void a(axjx paramaxjx)
  {
    LoginMergedProto.LoginReq localLoginReq = new LoginMergedProto.LoginReq();
    LoginMergedProto.LoginTicketInfo localLoginTicketInfo = new LoginMergedProto.LoginTicketInfo();
    localLoginTicketInfo.client_version.set(0);
    localLoginTicketInfo.login_type.set(0);
    localLoginTicketInfo.client_type.set(16130);
    LoginMergedProto.TicketInfo localTicketInfo = new LoginMergedProto.TicketInfo();
    localLoginTicketInfo.account_id.set(axjz.a());
    localLoginTicketInfo.auth_appid.set("16");
    localTicketInfo.auth_key.set(axjz.c());
    localLoginTicketInfo.ticket_info.set(localTicketInfo);
    localLoginReq.login_ticket_info.set(localLoginTicketInfo);
    axjq.a().a(30840, 1, localLoginReq.toByteArray(), new axjv(this, paramaxjx));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    LoginMergedProto.LogoutReq localLogoutReq = new LoginMergedProto.LogoutReq();
    axjq.a().a(30840, 2, localLogoutReq.toByteArray(), new axjw(this));
    axjq.b();
    axjz.a();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axju
 * JD-Core Version:    0.7.0.1
 */