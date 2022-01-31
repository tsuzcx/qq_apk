import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.EditText;

class bidw
  implements DialogInterface.OnDismissListener
{
  bidw(bidq parambidq, birt parambirt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bidq.a.a(0);
    bidq.a(this.jdField_a_of_type_Bidq).setText(this.jdField_a_of_type_Birt.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bidw
 * JD-Core Version:    0.7.0.1
 */