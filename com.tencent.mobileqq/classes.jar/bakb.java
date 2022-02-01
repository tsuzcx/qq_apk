import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import mqq.util.WeakReference;

public class bakb
  implements DialogInterface.OnDismissListener
{
  WeakReference<DialogInterface.OnDismissListener> jdField_a_of_type_MqqUtilWeakReference;
  
  bakb(baka parambaka, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnDismissListener);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnDismissListener localOnDismissListener = (DialogInterface.OnDismissListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakb
 * JD-Core Version:    0.7.0.1
 */