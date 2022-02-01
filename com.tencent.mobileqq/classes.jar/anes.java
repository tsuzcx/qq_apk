import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class anes
  implements DialogInterface.OnClickListener
{
  anes(anep paramanep, anex paramanex) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Anex != null) {
      this.jdField_a_of_type_Anex.a(this.jdField_a_of_type_Anep.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anes
 * JD-Core Version:    0.7.0.1
 */