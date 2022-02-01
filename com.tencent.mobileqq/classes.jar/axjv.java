import android.util.Log;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.AccountBaseInfo;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginRsp;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.TicketInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class axjv
  implements axjt
{
  axjv(axju paramaxju, axjx paramaxjx) {}
  
  public void a(int paramInt, String paramString)
  {
    Log.d("now_live_login_mgr", "login faile, errCode=" + paramInt + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Axjx != null) {
      this.jdField_a_of_type_Axjx.a(paramInt, paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (axju.a(this.jdField_a_of_type_Axju)) {
      return;
    }
    for (;;)
    {
      try
      {
        Log.d("now_live_login_mgr", "login success");
        LoginMergedProto.LoginRsp localLoginRsp = new LoginMergedProto.LoginRsp();
        localLoginRsp.mergeFrom(paramArrayOfByte);
        axjz.a().a(localLoginRsp.account_base_info.uid.get());
        axjz.a().b(localLoginRsp.account_base_info.tinyid.get());
        axjz.a().a(localLoginRsp.tickets.auth_key.get());
        paramArrayOfByte = this.jdField_a_of_type_Axju;
        if (localLoginRsp.result.get() != 0) {
          break label185;
        }
        bool = true;
        axju.a(paramArrayOfByte, bool);
        if (this.jdField_a_of_type_Axjx == null) {
          break;
        }
        this.jdField_a_of_type_Axjx.a(localLoginRsp.result.get(), localLoginRsp.errMsg.get());
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.d("now_live_login_mgr", "login parse exception, errMsg=" + paramArrayOfByte.getMessage());
      }
      if (this.jdField_a_of_type_Axjx == null) {
        break;
      }
      this.jdField_a_of_type_Axjx.a(1000001, "login parse exception");
      return;
      label185:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjv
 * JD-Core Version:    0.7.0.1
 */