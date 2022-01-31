import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.EditText;

class bmgu
  implements DialogInterface.OnDismissListener
{
  bmgu(bmgo parambmgo, bmui parambmui) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bmgo.a.a(0);
    bmgo.a(this.jdField_a_of_type_Bmgo).setText(this.jdField_a_of_type_Bmui.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgu
 * JD-Core Version:    0.7.0.1
 */