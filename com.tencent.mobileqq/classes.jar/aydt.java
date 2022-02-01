import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginTicketInfo;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LogoutReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.TicketInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class aydt
{
  private static aydt jdField_a_of_type_Aydt;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static aydt a()
  {
    if (jdField_a_of_type_Aydt == null)
    {
      jdField_a_of_type_Aydt = new aydt();
      aydp.a().b(aycm.b());
    }
    return jdField_a_of_type_Aydt;
  }
  
  public static void a()
  {
    jdField_a_of_type_Aydt = null;
  }
  
  public void a(aydw paramaydw)
  {
    LoginMergedProto.LoginReq localLoginReq = new LoginMergedProto.LoginReq();
    LoginMergedProto.LoginTicketInfo localLoginTicketInfo = new LoginMergedProto.LoginTicketInfo();
    localLoginTicketInfo.client_version.set(0);
    localLoginTicketInfo.login_type.set(0);
    localLoginTicketInfo.client_type.set(16130);
    LoginMergedProto.TicketInfo localTicketInfo = new LoginMergedProto.TicketInfo();
    localLoginTicketInfo.account_id.set(aydy.a());
    localLoginTicketInfo.auth_appid.set("16");
    localTicketInfo.auth_key.set(aydy.c());
    localLoginTicketInfo.ticket_info.set(localTicketInfo);
    localLoginReq.login_ticket_info.set(localLoginTicketInfo);
    aydp.a().a(30840, 1, localLoginReq.toByteArray(), new aydu(this, paramaydw));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    LoginMergedProto.LogoutReq localLogoutReq = new LoginMergedProto.LogoutReq();
    aydp.a().a(30840, 2, localLogoutReq.toByteArray(), new aydv(this));
    aydp.b();
    aydy.a();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydt
 * JD-Core Version:    0.7.0.1
 */