import android.os.Bundle;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0xb61.GetAppinfoRsp;
import tencent.im.oidb.oidb_0xb61.GetPkgUrlRsp;
import tencent.im.oidb.oidb_0xb61.RspBody;
import tencent.im.oidb.qqconnect.Appinfo;

public class asiy
  extends mxg
{
  public asiy(MiniAppInfoManager.1 param1) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppInfoManager", 2, "onResult type=" + this.a.jdField_a_of_type_Asiw.jdField_a_of_type_Int + ", appid=" + this.a.jdField_a_of_type_Asiw.jdField_a_of_type_JavaLangString + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null)) {
      if ((QLog.isColorLevel()) && (paramArrayOfByte == null)) {
        break label798;
      }
    }
    label798:
    for (;;)
    {
      try
      {
        paramBundle = ((oidb_0xb61.RspBody)new oidb_0xb61.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
        StringBuilder localStringBuilder = new StringBuilder().append("req error code=").append(paramInt);
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = ", data=null";
          QLog.i("MiniAppInfoManager", 2, paramArrayOfByte);
          if ((this.a.jdField_a_of_type_Asiz != null) && (this.a.jdField_a_of_type_Asiz.a != null)) {
            this.a.jdField_a_of_type_Asiz.a(this.a.jdField_a_of_type_Asiz.a.get(), false, this.a.jdField_a_of_type_Asiw);
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle = "";
        continue;
        paramArrayOfByte = ", msg=" + paramBundle;
        continue;
      }
      paramBundle = new oidb_0xb61.RspBody();
      for (;;)
      {
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          if (paramBundle.wording.has()) {
            this.a.jdField_a_of_type_Asiw.g = paramBundle.wording.get();
          }
          if ((this.a.jdField_a_of_type_Int != 1) || (!paramBundle.get_appinfo_rsp.appinfo.has())) {
            break label637;
          }
          this.a.jdField_a_of_type_Asiw.jdField_b_of_type_Int = paramBundle.get_appinfo_rsp.appinfo.platform.get();
          this.a.jdField_a_of_type_Asiw.jdField_b_of_type_JavaLangString = paramBundle.get_appinfo_rsp.appinfo.app_name.get();
          this.a.jdField_a_of_type_Asiw.jdField_c_of_type_Int = paramBundle.get_appinfo_rsp.appinfo.app_state.get();
          this.a.jdField_a_of_type_Asiw.jdField_c_of_type_JavaLangString = paramBundle.get_appinfo_rsp.appinfo.icon_url.get();
          this.a.jdField_a_of_type_Asiw.e = paramBundle.get_appinfo_rsp.appinfo.icon_small_url.get();
          this.a.jdField_a_of_type_Asiw.jdField_d_of_type_JavaLangString = paramBundle.get_appinfo_rsp.appinfo.icon_middle_url.get();
          if (paramBundle.next_req_duration.has()) {
            this.a.jdField_a_of_type_Asiw.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.next_req_duration.get() * 1000L, 300000L));
          }
          if (QLog.isColorLevel()) {
            QLog.d("MiniAppInfoManager", 2, "receive appInfo: " + this.a.jdField_a_of_type_Asiw);
          }
          asjb.a().a(this.a.jdField_a_of_type_Asiw);
          if ((this.a.jdField_a_of_type_Asiz == null) || (this.a.jdField_a_of_type_Asiz.a == null)) {
            break;
          }
          this.a.jdField_a_of_type_Asiz.a(this.a.jdField_a_of_type_Asiz.a.get(), true, this.a.jdField_a_of_type_Asiw);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        if ((this.a.jdField_a_of_type_Asiz == null) || (this.a.jdField_a_of_type_Asiz.a == null)) {
          break;
        }
        this.a.jdField_a_of_type_Asiz.a(this.a.jdField_a_of_type_Asiz.a.get(), false, this.a.jdField_a_of_type_Asiw);
        return;
        label637:
        if ((this.a.jdField_a_of_type_Int != 2) || (!paramBundle.get_mqqapp_url_rsp.has())) {
          break label743;
        }
        this.a.jdField_a_of_type_Asiw.jdField_d_of_type_Int = paramBundle.get_mqqapp_url_rsp.app_version.get();
        this.a.jdField_a_of_type_Asiw.f = paramBundle.get_mqqapp_url_rsp.pkg_url.get();
        if (paramBundle.next_req_duration.has()) {
          this.a.jdField_a_of_type_Asiw.jdField_b_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.next_req_duration.get() * 1000L, 300000L));
        }
      }
      label743:
      if ((this.a.jdField_a_of_type_Asiz != null) && (this.a.jdField_a_of_type_Asiz.a != null))
      {
        this.a.jdField_a_of_type_Asiz.a(this.a.jdField_a_of_type_Asiz.a.get(), false, this.a.jdField_a_of_type_Asiw);
        return;
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asiy
 * JD-Core Version:    0.7.0.1
 */