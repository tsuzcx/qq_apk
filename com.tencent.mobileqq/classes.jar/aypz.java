import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginTicketInfo;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LogoutReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.TicketInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class aypz
{
  private static aypz jdField_a_of_type_Aypz;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static aypz a()
  {
    if (jdField_a_of_type_Aypz == null)
    {
      jdField_a_of_type_Aypz = new aypz();
      aypv.a().b(ayos.b());
    }
    return jdField_a_of_type_Aypz;
  }
  
  public static void a()
  {
    jdField_a_of_type_Aypz = null;
  }
  
  public void a(ayqc paramayqc)
  {
    LoginMergedProto.LoginReq localLoginReq = new LoginMergedProto.LoginReq();
    LoginMergedProto.LoginTicketInfo localLoginTicketInfo = new LoginMergedProto.LoginTicketInfo();
    localLoginTicketInfo.client_version.set(0);
    localLoginTicketInfo.login_type.set(0);
    localLoginTicketInfo.client_type.set(16130);
    LoginMergedProto.TicketInfo localTicketInfo = new LoginMergedProto.TicketInfo();
    localLoginTicketInfo.account_id.set(ayqe.a());
    localLoginTicketInfo.auth_appid.set("16");
    localTicketInfo.auth_key.set(ayqe.c());
    localLoginTicketInfo.ticket_info.set(localTicketInfo);
    localLoginReq.login_ticket_info.set(localLoginTicketInfo);
    aypv.a().a(30840, 1, localLoginReq.toByteArray(), new ayqa(this, paramayqc));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    LoginMergedProto.LogoutReq localLogoutReq = new LoginMergedProto.LogoutReq();
    aypv.a().a(30840, 2, localLogoutReq.toByteArray(), new ayqb(this));
    aypv.b();
    ayqe.a();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypz
 * JD-Core Version:    0.7.0.1
 */