import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.BusinessObserver;

public class bbxp
  implements BusinessObserver
{
  public bbxp(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    OpenAuthorityFragment.b(this.a).jdField_a_of_type_Long = (System.currentTimeMillis() - OpenAuthorityFragment.b(this.a).jdField_a_of_type_Long);
    Object localObject = paramBundle.getString("ssoAccount");
    QLog.d("AuthorityActivity", 1, new Object[] { "-->doAuthorize-onReceive, ssoAccount: ", localObject, " | mAccount.uin: ", this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString });
    if (!this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString.equals(localObject)) {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    paramInt = paramBundle.getInt("code");
    if (paramBoolean)
    {
      this.a.c = 0;
      SdkAuthorize.AuthorizeResponse localAuthorizeResponse = new SdkAuthorize.AuthorizeResponse();
      for (;;)
      {
        try
        {
          localObject = bcjy.b(paramBundle.getByteArray("data"), this.a.jdField_a_of_type_Bciz);
          if (localObject != null)
          {
            l1 = localObject.length;
            localAuthorizeResponse = (SdkAuthorize.AuthorizeResponse)localAuthorizeResponse.mergeFrom((byte[])localObject);
            if (localAuthorizeResponse != null)
            {
              Message localMessage = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
              localMessage.what = 1;
              localMessage.obj = localAuthorizeResponse;
              this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
              if (localAuthorizeResponse.ret.get() == 0) {
                bcjy.a(OpenAuthorityFragment.a(this.a), this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString, localAuthorizeResponse.expires_in.get(), (byte[])localObject);
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
          localObject = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
          ((Message)localObject).what = 6;
          ((Message)localObject).arg1 = 3002;
          ((Message)localObject).obj = this.a.getResources().getString(2131629228);
          this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject);
          localObject = (String)((Message)localObject).obj;
          QLog.d("OpenAuthorityFragment", 1, "rec | cmd: " + "s_a_a_emp" + " | uin : *" + bcam.a(this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt, paramBundle);
          OpenAuthorityFragment.a(this.a, "KEY_AUTHORIZE_REQUEST", this.a.c, false);
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
          ((Bundle)localObject).putString("stringext_1", OpenAuthorityFragment.b(this.a).jdField_a_of_type_JavaLangString);
          ((Bundle)localObject).putString("intext_2", "" + i);
          ((Bundle)localObject).putString("intext_5", "" + OpenAuthorityFragment.b(this.a).jdField_a_of_type_Long);
          bcad.a().a((Bundle)localObject, OpenAuthorityFragment.a(this.a), this.a.jdField_a_of_type_JavaLangString, false);
          bcfk.a().a("agent_authority", this.a.h, l1, l2, 0, Long.parseLong(this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString), "1000069", "ret: " + i);
          bcfn.a().a(0, "LOGIN_AUTH", this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString, OpenAuthorityFragment.a(this.a), null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
          OpenAuthorityFragment.a(this.a, "KEY_AUTHORIZE_REQUEST", this.a.c, true);
        }
        catch (Exception paramBundle)
        {
          bcds.c("OpenAuthorityFragment", "-->success report exception cmd: agent_authority", paramBundle);
        }
      }
      QLog.d("OpenAuthorityFragment", 1, "rec | cmd: " + "s_a_a_emp" + " | uin : *" + bcam.a(this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + paramInt);
    }
    for (;;)
    {
      this.a.i = SystemClock.elapsedRealtime();
      bcds.c("Authority_TimeCost", "<TimeStamp> authority cost : " + (this.a.i - this.a.h));
      return;
      paramBundle = "1";
      break;
      QLog.d("OpenAuthorityFragment", 1, "rec | cmd: " + "s_a_a_emp" + " | uin : *" + bcam.a(this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString) + " | ret : failed | code : " + paramInt);
      if ((paramInt == 1002) && (this.a.c < 2))
      {
        paramBundle = this.a;
        paramBundle.c += 1;
        this.a.j();
        return;
      }
      OpenAuthorityFragment.a(this.a, "KEY_AUTHORIZE_REQUEST", this.a.c, false);
      paramBundle = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      paramBundle.what = 6;
      paramBundle.arg1 = 3002;
      paramBundle.obj = this.a.getResources().getString(2131629228);
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramBundle);
      paramBundle = this.a.getResources().getString(2131629228);
      try
      {
        bcfk.a().a("agent_authority", this.a.h, 0L, 0L, paramInt, Long.parseLong(this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString), "1000069", paramBundle);
        bcfn.a().a(1, "LOGIN_AUTH", this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString, OpenAuthorityFragment.a(this.a), null, Long.valueOf(SystemClock.elapsedRealtime()), 3002, 1, paramBundle);
        bcad.a().a(this.a.jdField_a_of_type_Bciz.jdField_a_of_type_JavaLangString, "", OpenAuthorityFragment.a(this.a), "1", "6", "" + 3002, false);
      }
      catch (Exception paramBundle)
      {
        bcds.c("OpenAuthorityFragment", "-->failed report exception cmd: agent_authority", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbxp
 * JD-Core Version:    0.7.0.1
 */