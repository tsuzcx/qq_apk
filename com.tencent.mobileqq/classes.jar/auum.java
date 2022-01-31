import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

final class auum
  implements DialogInterface.OnClickListener
{
  auum(String paramString, int paramInt, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_JavaLangString + "&from=" + this.jdField_a_of_type_Int;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tribeAppDownload", 2, "open download page, url=" + paramDialogInterface);
    }
    if (this.jdField_a_of_type_Int == 1) {
      azqs.b(null, "dc00899", "grp_lbs", "", "app_down", "msg_down", 0, 0, "", "", "", "");
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    azqs.b(null, "dc00899", "grp_lbs", "", "app_down", "pic_down", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auum
 * JD-Core Version:    0.7.0.1
 */