import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.SSOHttpUtils.1.1;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class bdyq
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = "";
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        Object localObject = paramBundle.getByteArray("extra_data");
        if (localObject == null)
        {
          QLog.e("SSOHttpUtils", 1, "report failed response data is null");
          return;
        }
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom((byte[])localObject);
        QLog.i("SSOHttpUtils", 1, "report result:" + paramBundle.rspdata.get() + ",ret:" + paramBundle.ret.get());
        if (0L == paramBundle.ret.get())
        {
          localObject = new NewIntent(BaseApplicationImpl.getApplication(), bdyx.class);
          ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_update_lastreport_time");
          ((NewIntent)localObject).putExtra("last_report_time", new Long(NetConnInfoCenter.getServerTimeMillis()));
          ((NewIntent)localObject).putExtra("has_report_yes", new Boolean(bdyp.jdField_a_of_type_Boolean));
          BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
          bdyp.jdField_a_of_type_Float = bdyp.jdField_a_of_type_Int - bdyp.b + bdyp.c;
          localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            bdyp.jdField_a_of_type_JavaLangString = (String)localObject;
          }
          bdyp.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
          QLog.i("SSOHttpUtils", 1, "SSOHttpUtils do report success steps:" + bdyp.jdField_a_of_type_Float);
        }
        localObject = new JSONObject(paramBundle.rspdata.get());
        paramBundle = str;
        if (((JSONObject)localObject).has("svr_steps"))
        {
          paramInt = ((JSONObject)localObject).getInt("svr_steps");
          QLog.e("SSOHttpUtils", 1, "step reset from server:" + paramInt);
          paramBundle = new NewIntent(BaseApplicationImpl.getApplication(), bdyx.class);
          paramBundle.putExtra("msf_cmd_type", "cmd_reset_step");
          paramBundle.putExtra("server_step", paramInt);
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramBundle);
          paramBundle = str;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("SSOHttpUtils", 1, "Parse response exception:" + paramBundle.getMessage());
        paramBundle = str;
        continue;
      }
      ThreadManager.post(new SSOHttpUtils.1.1(this, -1, paramBundle), 5, null, true);
      return;
      QLog.i("SSOHttpUtils", 1, "SSO sent Failed!!" + paramBundle.toString());
      paramBundle = paramBundle.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyq
 * JD-Core Version:    0.7.0.1
 */