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

public class bcyq
  implements BusinessObserver
{
  public bcyq(AuthorityActivity paramAuthorityActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AuthorityActivity.b(this.a).jdField_a_of_type_Long = (System.currentTimeMillis() - AuthorityActivity.b(this.a).jdField_a_of_type_Long);
    String str = paramBundle.getString("ssoAccount");
    if (!this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString.equals(str)) {
      return;
    }
    this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    if (!this.a.b) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    paramInt = paramBundle.getInt("code");
    if (!this.a.i) {}
    for (str = "g_a_a_l_emp";; str = "g_a_a_l")
    {
      if (paramBoolean)
      {
        this.a.c = 0;
        SdkAuthorize.GetAuthApiListResponse localGetAuthApiListResponse = new SdkAuthorize.GetAuthApiListResponse();
        for (;;)
        {
          try
          {
            Object localObject2 = paramBundle.getByteArray("data");
            localObject1 = localObject2;
            if (!this.a.i) {
              localObject1 = bdoo.b((byte[])localObject2, this.a.jdField_a_of_type_Bdnp);
            }
            if (localObject1 != null)
            {
              l1 = localObject1.length;
              localObject1 = (SdkAuthorize.GetAuthApiListResponse)localGetAuthApiListResponse.mergeFrom((byte[])localObject1);
              if (localObject1 != null)
              {
                localObject2 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
                ((Message)localObject2).what = 0;
                ((Message)localObject2).obj = localObject1;
                this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
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
            Object localObject1 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
            ((Message)localObject1).what = 6;
            ((Message)localObject1).arg1 = 3001;
            ((Message)localObject1).obj = this.a.getResources().getString(2131694897);
            this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject1);
            localObject1 = (String)((Message)localObject1).obj;
            QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + bdfb.a(this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt, paramBundle);
            AuthorityActivity.a(this.a, "KEY_GET_AUTH_API_LIST_REQUEST", this.a.c, false);
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
            ((Bundle)localObject1).putString("stringext_1", AuthorityActivity.b(this.a).jdField_a_of_type_JavaLangString);
            ((Bundle)localObject1).putString("intext_2", "" + i);
            ((Bundle)localObject1).putString("intext_5", "" + AuthorityActivity.b(this.a).jdField_a_of_type_Long);
            bdes.a().a((Bundle)localObject1, AuthorityActivity.e, this.a.jdField_a_of_type_JavaLangString, false);
            paramBundle = new Bundle();
            paramBundle.putString("report_type", "103");
            paramBundle.putString("act_type", "14");
            paramBundle.putString("intext_5", "" + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
            bdes.a().a(paramBundle, AuthorityActivity.e, this.a.jdField_a_of_type_JavaLangString, false);
            bdka.a().a("agent_query_authority", this.a.f, l1, l2, 0, Long.parseLong(this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString), "1000069", "ret: " + i);
            bdkd.a().a(0, "LOGIN_GETAUTHLIST_AGENT", this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString, AuthorityActivity.e, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
            bdes.a().a(this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "2", "0", false);
            AuthorityActivity.a(this.a, "KEY_GET_AUTH_API_LIST_REQUEST", this.a.c, true);
          }
          catch (Exception paramBundle)
          {
            bdii.c("AuthorityActivity", "-->report exception cmd: agent_query_authority", paramBundle);
          }
        }
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + bdfb.a(this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt);
      }
      for (;;)
      {
        this.a.g = SystemClock.elapsedRealtime();
        bdii.c("Authority_TimeCost", "<TimeStamp> query authority cost : " + (this.a.g - this.a.f));
        return;
        paramBundle = "1";
        break;
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + str + " | uin : *" + bdfb.a(this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString) + " | ret : failed | code : " + paramInt);
        this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
        if ((paramInt == 1002) && (this.a.c < 2))
        {
          paramBundle = this.a;
          paramBundle.c += 1;
          this.a.i();
          return;
        }
        paramBundle = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        paramBundle.what = 6;
        paramBundle.arg1 = 3001;
        paramBundle.obj = this.a.getResources().getString(2131694897);
        this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramBundle);
        AuthorityActivity.a(this.a, "KEY_GET_AUTH_API_LIST_REQUEST", this.a.c, false);
        paramBundle = this.a.getResources().getString(2131694897);
        try
        {
          bdka.a().a("agent_query_authority", this.a.f, 0L, 0L, paramInt, Long.parseLong(this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString), "1000069", paramBundle);
          bdkd.a().a(1, "LOGIN_GETAUTHLIST_AGENT", this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString, AuthorityActivity.e, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt, 1, paramBundle);
          bdes.a().a(this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "2", "" + paramInt, false);
          bdes.a().a(this.a.jdField_a_of_type_Bdnp.jdField_a_of_type_JavaLangString, "", AuthorityActivity.e, "1", "6", "" + paramInt, false);
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcyq
 * JD-Core Version:    0.7.0.1
 */