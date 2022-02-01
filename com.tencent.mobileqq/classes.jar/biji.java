import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.BusinessObserver;

public class biji
  implements BusinessObserver
{
  public biji(AuthorityActivity paramAuthorityActivity, boolean paramBoolean, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AuthorityActivity.d(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long = (System.currentTimeMillis() - AuthorityActivity.d(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
    Object localObject = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->doAuthorize-onReceive, ssoAccount: " + (String)localObject + " | uin: " + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString);
    }
    if (!this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString.equals(localObject)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangRunnable);
    paramInt = paramBundle.getInt("code");
    SdkAuthorize.AuthorizeResponse localAuthorizeResponse;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.d = 0;
      localAuthorizeResponse = new SdkAuthorize.AuthorizeResponse();
    }
    label1170:
    for (;;)
    {
      try
      {
        localObject = paramBundle.getByteArray("data");
        if (!this.jdField_a_of_type_Boolean) {
          break label1170;
        }
        localObject = biyz.b((byte[])localObject, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc);
        if (localObject != null)
        {
          l1 = localObject.length;
          localAuthorizeResponse = (SdkAuthorize.AuthorizeResponse)localAuthorizeResponse.mergeFrom((byte[])localObject);
          if (localAuthorizeResponse != null)
          {
            Message localMessage = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
            localMessage.what = 1;
            localMessage.obj = localAuthorizeResponse;
            this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
            if (localAuthorizeResponse.ret.get() == 0) {
              biyz.a(AuthorityActivity.e, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString, localAuthorizeResponse.expires_in.get(), (byte[])localObject);
            }
            i = localAuthorizeResponse.toByteArray().length;
            l2 = i;
          }
        }
      }
      catch (Exception paramBundle)
      {
        long l1;
        int i;
        long l2;
        localObject = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        ((Message)localObject).what = 6;
        ((Message)localObject).arg1 = 3002;
        ((Message)localObject).obj = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources().getString(2131694142);
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject);
        localObject = (String)((Message)localObject).obj;
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.jdField_a_of_type_JavaLangString + " | uin : *" + bipr.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt, paramBundle);
        AuthorityActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, "KEY_AUTHORIZE_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.d, false);
        continue;
      }
      try
      {
        i = localAuthorizeResponse.ret.get();
        localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "103");
        ((Bundle)localObject).putString("act_type", "13");
        if (!paramBundle.getBoolean("isShort", false)) {
          continue;
        }
        paramBundle = "2";
        ((Bundle)localObject).putString("intext_3", paramBundle);
        ((Bundle)localObject).putString("stringext_1", AuthorityActivity.d(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putString("intext_2", "" + i);
        ((Bundle)localObject).putString("intext_5", "" + AuthorityActivity.d(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
        bipi.a().a((Bundle)localObject, AuthorityActivity.e, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangString, false);
        biuo.a().a("agent_authority", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.h, l1, l2, 0, Long.parseLong(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString), "1000069", "ret: " + i);
        biur.a().a(0, "LOGIN_AUTH", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString, AuthorityActivity.e, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
        AuthorityActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, "KEY_AUTHORIZE_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.d, true);
      }
      catch (Exception paramBundle)
      {
        bisy.c("AuthorityActivity", "-->success report exception cmd: agent_authority", paramBundle);
        continue;
      }
      QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.jdField_a_of_type_JavaLangString + " | uin : *" + bipr.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt);
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.i = SystemClock.elapsedRealtime();
      bisy.c("Authority_TimeCost", "<TimeStamp> authority cost : " + (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.i - this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.h));
      return;
      paramBundle = "1";
      continue;
      QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.jdField_a_of_type_JavaLangString + " | uin : *" + bipr.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString) + " | ret : failed | code : " + paramInt);
      if ((paramInt == 1002) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.d < 2))
      {
        paramBundle = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity;
        paramBundle.d += 1;
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.k();
        return;
      }
      paramBundle = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      paramBundle.what = 6;
      paramBundle.arg1 = 3002;
      paramBundle.obj = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources().getString(2131694142);
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramBundle);
      AuthorityActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, "KEY_AUTHORIZE_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.d, false);
      paramBundle = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources().getString(2131694142);
      try
      {
        biuo.a().a("agent_authority", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.h, 0L, 0L, paramInt, Long.parseLong(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString), "1000069", paramBundle);
        biur.a().a(1, "LOGIN_AUTH", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString, AuthorityActivity.e, null, Long.valueOf(SystemClock.elapsedRealtime()), 3002, 1, paramBundle);
        bipi.a().a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Biyc.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "6", "" + 3002, false);
      }
      catch (Exception paramBundle)
      {
        bisy.c("AuthorityActivity", "-->failed report exception cmd: agent_authority", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biji
 * JD-Core Version:    0.7.0.1
 */