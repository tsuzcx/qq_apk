import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.BusinessObserver;

public class bfcb
  implements BusinessObserver
{
  public bfcb(AuthorityActivity paramAuthorityActivity, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AuthorityActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long = (System.currentTimeMillis() - AuthorityActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
    String str = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString.equals(str)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangRunnable);
    if (!this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.b) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    paramInt = paramBundle.getInt("code");
    if (!this.jdField_a_of_type_Boolean) {}
    for (str = "g_a_a_l_emp";; str = "g_a_a_l")
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.c = 0;
        SdkAuthorize.GetAuthApiListResponse localGetAuthApiListResponse = new SdkAuthorize.GetAuthApiListResponse();
        for (;;)
        {
          try
          {
            Object localObject2 = paramBundle.getByteArray("data");
            localObject1 = localObject2;
            if (!this.jdField_a_of_type_Boolean) {
              localObject1 = bfru.b((byte[])localObject2, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv);
            }
            if (localObject1 != null)
            {
              l1 = localObject1.length;
              localObject1 = (SdkAuthorize.GetAuthApiListResponse)localGetAuthApiListResponse.mergeFrom((byte[])localObject1);
              if (localObject1 != null)
              {
                localObject2 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
                ((Message)localObject2).what = 0;
                ((Message)localObject2).obj = localObject1;
                this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
                i = ((SdkAuthorize.GetAuthApiListResponse)localObject1).toByteArray().length;
                l2 = i;
              }
            }
          }
          catch (Exception paramBundle)
          {
            long l1;
            int i;
            long l2;
            Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
            ((Message)localObject1).what = 6;
            ((Message)localObject1).arg1 = 3001;
            ((Message)localObject1).obj = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources().getString(2131695056);
            this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject1);
            localObject1 = (String)((Message)localObject1).obj;
            QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + bfii.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt, paramBundle);
            AuthorityActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, "KEY_GET_AUTH_API_LIST_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.c, false);
            continue;
          }
          try
          {
            i = ((SdkAuthorize.GetAuthApiListResponse)localObject1).ret.get();
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("report_type", "103");
            ((Bundle)localObject1).putString("act_type", "11");
            if (!paramBundle.getBoolean("isShort", false)) {
              continue;
            }
            paramBundle = "2";
            ((Bundle)localObject1).putString("intext_3", paramBundle);
            ((Bundle)localObject1).putString("stringext_1", AuthorityActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_JavaLangString);
            ((Bundle)localObject1).putString("intext_2", "" + i);
            ((Bundle)localObject1).putString("intext_5", "" + AuthorityActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
            bfhz.a().a((Bundle)localObject1, AuthorityActivity.e, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangString, false);
            paramBundle = new Bundle();
            paramBundle.putString("report_type", "103");
            paramBundle.putString("act_type", "14");
            paramBundle.putString("intext_5", "" + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Long));
            bfhz.a().a(paramBundle, AuthorityActivity.e, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangString, false);
            bfng.a().a("agent_query_authority", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.f, l1, l2, 0, Long.parseLong(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString), "1000069", "ret: " + i);
            bfnj.a().a(0, "LOGIN_GETAUTHLIST_AGENT", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, AuthorityActivity.e, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
            bfhz.a().a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "2", "0", false);
            AuthorityActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, "KEY_GET_AUTH_API_LIST_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.c, true);
          }
          catch (Exception paramBundle)
          {
            bflp.c("AuthorityActivity", "-->report exception cmd: agent_query_authority", paramBundle);
          }
        }
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + bfii.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.g = SystemClock.elapsedRealtime();
        bflp.c("Authority_TimeCost", "<TimeStamp> query authority cost : " + (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.g - this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.f));
        return;
        paramBundle = "1";
        break;
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + bfii.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString) + " | ret : failed | code : " + paramInt);
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
        if ((paramInt == 1002) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.c < 2))
        {
          paramBundle = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity;
          paramBundle.c += 1;
          this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.i();
          return;
        }
        paramBundle = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        paramBundle.what = 6;
        paramBundle.arg1 = 3001;
        paramBundle.obj = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources().getString(2131695056);
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramBundle);
        AuthorityActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, "KEY_GET_AUTH_API_LIST_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.c, false);
        paramBundle = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources().getString(2131695056);
        try
        {
          bfng.a().a("agent_query_authority", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.f, 0L, 0L, paramInt, Long.parseLong(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString), "1000069", paramBundle);
          bfnj.a().a(1, "LOGIN_GETAUTHLIST_AGENT", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, AuthorityActivity.e, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt, 1, paramBundle);
          bfhz.a().a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "2", "" + paramInt, false);
          bfhz.a().a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "6", "" + paramInt, false);
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcb
 * JD-Core Version:    0.7.0.1
 */