import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class auvt
  implements DialogInterface.OnClickListener
{
  auvt(auvr paramauvr, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_Auvr.a;
    if ((paramDialogInterface != null) && (!TextUtils.isEmpty(paramDialogInterface.b)))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDialogInterface.b);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
    auvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_up", this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auvt
 * JD-Core Version:    0.7.0.1
 */