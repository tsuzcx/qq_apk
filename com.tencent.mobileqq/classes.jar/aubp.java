import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class aubp
  implements DialogInterface.OnDismissListener
{
  aubp(aubn paramaubn, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aubp
 * JD-Core Version:    0.7.0.1
 */