import android.content.Context;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

public class bjmn
{
  public static void a(Context paramContext, int paramInt)
  {
    if ((paramContext == null) || (!(paramContext instanceof LoginActivity)) || (paramInt != 16908322))
    {
      QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: params wrong");
      return;
    }
    paramContext = ((LoginActivity)paramContext).a();
    if ((paramContext == null) || (!(paramContext instanceof LoginView)))
    {
      QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: fragment wrong");
      return;
    }
    paramContext = ((LoginView)paramContext).a();
    if (paramContext == null)
    {
      QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: autoCompleteTextView == null");
      return;
    }
    paramContext = paramContext.getText();
    if (paramContext == null)
    {
      QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: editable null");
      return;
    }
    paramContext = paramContext.toString();
    if ((TextUtils.isEmpty(paramContext)) || (!Friends.isValidUin(paramContext)) || (!yyi.i(paramContext)))
    {
      QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: uin error");
      return;
    }
    bcef.a(null, "dc00898", "", paramContext, "0X800B29A", "0X800B29A", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmn
 * JD-Core Version:    0.7.0.1
 */