import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.EditText;

class bmlg
  implements DialogInterface.OnDismissListener
{
  bmlg(bmla parambmla, bmyu parambmyu) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bmla.a.a(0);
    bmla.a(this.jdField_a_of_type_Bmla).setText(this.jdField_a_of_type_Bmyu.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlg
 * JD-Core Version:    0.7.0.1
 */