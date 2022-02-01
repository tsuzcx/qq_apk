import android.util.Log;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.AccountBaseInfo;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginRsp;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.TicketInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class ayqa
  implements aypy
{
  ayqa(aypz paramaypz, ayqc paramayqc) {}
  
  public void a(int paramInt, String paramString)
  {
    Log.d("now_live_login_mgr", "login faile, errCode=" + paramInt + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Ayqc != null) {
      this.jdField_a_of_type_Ayqc.a(paramInt, paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (aypz.a(this.jdField_a_of_type_Aypz)) {
      return;
    }
    for (;;)
    {
      try
      {
        Log.d("now_live_login_mgr", "login success");
        LoginMergedProto.LoginRsp localLoginRsp = new LoginMergedProto.LoginRsp();
        localLoginRsp.mergeFrom(paramArrayOfByte);
        ayqe.a().a(localLoginRsp.account_base_info.uid.get());
        ayqe.a().b(localLoginRsp.account_base_info.tinyid.get());
        ayqe.a().a(localLoginRsp.tickets.auth_key.get());
        paramArrayOfByte = this.jdField_a_of_type_Aypz;
        if (localLoginRsp.result.get() != 0) {
          break label185;
        }
        bool = true;
        aypz.a(paramArrayOfByte, bool);
        if (this.jdField_a_of_type_Ayqc == null) {
          break;
        }
        this.jdField_a_of_type_Ayqc.a(localLoginRsp.result.get(), localLoginRsp.errMsg.get());
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.d("now_live_login_mgr", "login parse exception, errMsg=" + paramArrayOfByte.getMessage());
      }
      if (this.jdField_a_of_type_Ayqc == null) {
        break;
      }
      this.jdField_a_of_type_Ayqc.a(1000001, "login parse exception");
      return;
      label185:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqa
 * JD-Core Version:    0.7.0.1
 */