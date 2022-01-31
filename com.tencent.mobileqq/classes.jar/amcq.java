import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import cooperation.qzone.QZoneHelper;

public final class amcq
  implements DialogInterface.OnClickListener
{
  public amcq(Activity paramActivity, int paramInt, String paramString, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!QZoneHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
      QZoneHelper.a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("sid"), this.jdField_a_of_type_AndroidAppActivity);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcq
 * JD-Core Version:    0.7.0.1
 */