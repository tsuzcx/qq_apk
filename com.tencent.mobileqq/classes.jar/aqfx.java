import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class aqfx
  implements DialogInterface.OnClickListener
{
  aqfx(long paramLong, int paramInt, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardShareByServerHelper", 2, "-->qbShowShareResultDialog--stay");
    }
    aqfv.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfx
 * JD-Core Version:    0.7.0.1
 */