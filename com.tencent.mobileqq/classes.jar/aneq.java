import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class aneq
  implements DialogInterface.OnKeyListener
{
  aneq(anep paramanep, anex paramanex) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.jdField_a_of_type_Anep.a(this.jdField_a_of_type_Anex);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aneq
 * JD-Core Version:    0.7.0.1
 */