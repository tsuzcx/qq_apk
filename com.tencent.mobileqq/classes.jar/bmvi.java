import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

public final class bmvi
  implements DialogInterface.OnClickListener
{
  public bmvi(Context paramContext, int paramInt, String paramString, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bmtd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
      bmtd.a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("sid"), this.jdField_a_of_type_AndroidContentContext);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvi
 * JD-Core Version:    0.7.0.1
 */