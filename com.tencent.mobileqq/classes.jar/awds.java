import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.net.URLEncoder;

class awds
  implements DialogInterface.OnClickListener
{
  awds(awdr paramawdr, String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      paramDialogInterface = new StringBuilder("https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw");
      paramDialogInterface.append("?");
      paramDialogInterface.append("uin=");
      paramDialogInterface.append(this.jdField_a_of_type_JavaLangString);
      paramDialogInterface.append("&plat=1");
      paramDialogInterface.append("&app=1");
      paramDialogInterface.append("&version=8.3.3.4515");
      paramDialogInterface.append("&device=" + URLEncoder.encode(Build.DEVICE));
      paramDialogInterface.append("&system=" + Build.VERSION.RELEASE);
      paramDialogInterface.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      paramDialogInterface = paramDialogInterface.toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", paramDialogInterface);
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_AndroidAppActivity, paramDialogInterface, 32768L, localIntent, false, -1);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Mobile_signup", "Setiing_pw_tips", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awds
 * JD-Core Version:    0.7.0.1
 */