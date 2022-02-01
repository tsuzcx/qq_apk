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

public class bjap
  implements BusinessObserver
{
  public bjap(AuthorityActivity paramAuthorityActivity, boolean paramBoolean, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AuthorityActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long = (System.currentTimeMillis() - AuthorityActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
    Object localObject1 = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString.equals(localObject1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangRunnable);
    if (!this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.b) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    paramInt = paramBundle.getInt("code");
    Object localObject2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.c = 0;
      localObject2 = new SdkAuthorize.GetAuthApiListResponse();
    }
    label1282:
    for (;;)
    {
      try
      {
        localObject1 = paramBundle.getByteArray("data");
        if (!this.jdField_a_of_type_Boolean) {
          break label1282;
        }
        localObject1 = bjqk.b((byte[])localObject1, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl);
        if (localObject1 != null)
        {
          l1 = localObject1.length;
          localObject2 = (SdkAuthorize.GetAuthApiListResponse)((SdkAuthorize.GetAuthApiListResponse)localObject2).mergeFrom((byte[])localObject1);
          if (localObject2 != null)
          {
            Message localMessage = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
            localMessage.what = 0;
            localMessage.obj = localObject2;
            this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
            i = ((SdkAuthorize.GetAuthApiListResponse)localObject2).toByteArray().length;
            l2 = i;
          }
        }
      }
      catch (Exception paramBundle)
      {
        long l1;
        long l2;
        localObject1 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        ((Message)localObject1).what = 6;
        ((Message)localObject1).arg1 = 3001;
        ((Message)localObject1).obj = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources().getString(2131694453);
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject1);
        localObject1 = (String)((Message)localObject1).obj;
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.jdField_a_of_type_JavaLangString + " | uin : *" + bjhh.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt, paramBundle);
        AuthorityActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, "KEY_GET_AUTH_API_LIST_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.c, false);
        continue;
        int i = localObject1.length;
        paramBundle = Integer.valueOf(i);
        continue;
      }
      try
      {
        i = ((SdkAuthorize.GetAuthApiListResponse)localObject2).ret.get();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("report_type", "103");
        ((Bundle)localObject2).putString("act_type", "11");
        if (!paramBundle.getBoolean("isShort", false)) {
          continue;
        }
        paramBundle = "2";
        ((Bundle)localObject2).putString("intext_3", paramBundle);
        ((Bundle)localObject2).putString("stringext_1", AuthorityActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject2).putString("intext_2", "" + i);
        ((Bundle)localObject2).putString("intext_5", "" + AuthorityActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
        bjgx.a().a((Bundle)localObject2, AuthorityActivity.e, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangString, false, true);
        paramBundle = new Bundle();
        paramBundle.putString("report_type", "103");
        paramBundle.putString("act_type", "14");
        paramBundle.putString("intext_5", "" + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Long));
        bjgx.a().a(paramBundle, AuthorityActivity.e, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangString, false, true);
        bjmb.a().a("agent_query_authority", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.f, l1, l2, 0, Long.parseLong(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString), "1000069", "ret: " + i, true);
        bjme.a().a(0, "LOGIN_GETAUTHLIST_AGENT", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString, AuthorityActivity.e, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
        bjgx.a().a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "2", "0", false, true);
        AuthorityActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, "KEY_GET_AUTH_API_LIST_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.c, true);
      }
      catch (Exception paramBundle)
      {
        bjko.c("AuthorityActivity", "-->report exception cmd: agent_query_authority", paramBundle);
        continue;
      }
      localObject2 = new StringBuilder().append("rec | cmd: ").append(this.jdField_a_of_type_JavaLangString).append(" | uin : *").append(bjhh.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString)).append(" | ret : success | code : ").append(paramInt).append(" | data=");
      if (localObject1 == null)
      {
        paramBundle = "null";
        QLog.d("AuthorityActivity", 1, paramBundle);
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.g = SystemClock.elapsedRealtime();
        bjko.c("Authority_TimeCost", "<TimeStamp> query authority cost : " + (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.g - this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.f));
        return;
        paramBundle = "1";
      }
      else
      {
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.jdField_a_of_type_JavaLangString + " | uin : *" + bjhh.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString) + " | ret : failed | code : " + paramInt);
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
        paramBundle.obj = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources().getString(2131694453);
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramBundle);
        AuthorityActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, "KEY_GET_AUTH_API_LIST_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.c, false);
        paramBundle = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources().getString(2131694453);
        try
        {
          bjmb.a().a("agent_query_authority", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.f, 0L, 0L, paramInt, Long.parseLong(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString), "1000069", paramBundle, true);
          bjme.a().a(1, "LOGIN_GETAUTHLIST_AGENT", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString, AuthorityActivity.e, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt, 1, paramBundle);
          bjgx.a().a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "2", "" + paramInt, false, true);
          bjgx.a().a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_Bjpl.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "6", "" + paramInt, false, true);
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjap
 * JD-Core Version:    0.7.0.1
 */