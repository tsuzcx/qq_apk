import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.BusinessObserver;

public class bfcd
  implements BusinessObserver
{
  public bfcd(AuthorityActivity paramAuthorityActivity, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "getAppInfo observer onReceive isSuccess = " + paramBoolean);
    }
    aseh.a("KEY_GET_APP_INFO_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv, paramBoolean);
    AuthorityActivity.c(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long = (System.currentTimeMillis() - AuthorityActivity.c(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString.equals(localObject)) {
      QLog.e("AuthorityActivity", 1, "mAccount.uin != ssoAccount");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangRunnable);
    } while (!paramBoolean);
    GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        localObject = arrayOfByte;
        if (!this.jdField_a_of_type_Boolean) {
          localObject = bfru.b(arrayOfByte, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv);
        }
        if (localObject == null) {
          break;
        }
        localGetAppinfoResponse.mergeFrom((byte[])localObject);
        if (!localGetAppinfoResponse.has()) {
          break;
        }
        paramInt = localGetAppinfoResponse.ret.get();
        if (paramInt == 0)
        {
          localObject = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
          ((Message)localObject).what = 3;
          ((Message)localObject).obj = localGetAppinfoResponse;
          this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject);
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "103");
        ((Bundle)localObject).putString("act_type", "12");
        if (paramBundle.getBoolean("isShort", false))
        {
          paramBundle = "2";
          ((Bundle)localObject).putString("intext_3", paramBundle);
          ((Bundle)localObject).putString("stringext_1", AuthorityActivity.c(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_JavaLangString);
          ((Bundle)localObject).putString("intext_2", "" + paramInt);
          ((Bundle)localObject).putString("intext_5", "" + AuthorityActivity.c(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
          bfhz.a().a((Bundle)localObject, AuthorityActivity.e, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangString, false);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("AuthorityActivity", 1, "getAppInfoResponse deal exception : " + paramBundle.getMessage());
        paramBundle.printStackTrace();
        return;
      }
      paramBundle = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcd
 * JD-Core Version:    0.7.0.1
 */