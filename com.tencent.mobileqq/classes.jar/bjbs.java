import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

public final class bjbs
  implements DialogInterface.OnClickListener
{
  public bjbs(Context paramContext, int paramInt, String paramString, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bizm.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
      bizm.a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("sid"), this.jdField_a_of_type_AndroidContentContext);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbs
 * JD-Core Version:    0.7.0.1
 */