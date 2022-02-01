import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqconnect.wtlogin.Login;

public class bkjw
  implements DialogInterface.OnClickListener
{
  public bkjw(Login paramLogin, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdla.a(null, "dc00898", "", "", "0X800B432", "0X800B432", 0, 0, "", "", "", "");
    paramDialogInterface = aozj.a().a(this.jdField_a_of_type_JavaLangString, this.b);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentQqconnectWtloginLogin.getActivity(), QQBrowserActivity.class);
    this.jdField_a_of_type_ComTencentQqconnectWtloginLogin.startActivity(localIntent.putExtra("url", paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjw
 * JD-Core Version:    0.7.0.1
 */