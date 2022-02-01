import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginTicketInfo;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LogoutReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.TicketInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class aywm
{
  private static aywm jdField_a_of_type_Aywm;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static aywm a()
  {
    if (jdField_a_of_type_Aywm == null)
    {
      jdField_a_of_type_Aywm = new aywm();
      aywi.a().b(ayvf.b());
    }
    return jdField_a_of_type_Aywm;
  }
  
  public static void a()
  {
    jdField_a_of_type_Aywm = null;
  }
  
  public void a(aywp paramaywp)
  {
    LoginMergedProto.LoginReq localLoginReq = new LoginMergedProto.LoginReq();
    LoginMergedProto.LoginTicketInfo localLoginTicketInfo = new LoginMergedProto.LoginTicketInfo();
    localLoginTicketInfo.client_version.set(0);
    localLoginTicketInfo.login_type.set(0);
    localLoginTicketInfo.client_type.set(16130);
    LoginMergedProto.TicketInfo localTicketInfo = new LoginMergedProto.TicketInfo();
    localLoginTicketInfo.account_id.set(aywr.a());
    localLoginTicketInfo.auth_appid.set("16");
    localTicketInfo.auth_key.set(aywr.c());
    localLoginTicketInfo.ticket_info.set(localTicketInfo);
    localLoginReq.login_ticket_info.set(localLoginTicketInfo);
    aywi.a().a(30840, 1, localLoginReq.toByteArray(), new aywn(this, paramaywp));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    LoginMergedProto.LogoutReq localLogoutReq = new LoginMergedProto.LogoutReq();
    aywi.a().a(30840, 2, localLogoutReq.toByteArray(), new aywo(this));
    aywi.b();
    aywr.a();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywm
 * JD-Core Version:    0.7.0.1
 */