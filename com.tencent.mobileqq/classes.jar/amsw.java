import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class amsw
  implements DialogInterface.OnKeyListener
{
  amsw(amsv paramamsv, amtd paramamtd) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.jdField_a_of_type_Amsv.a(this.jdField_a_of_type_Amtd);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsw
 * JD-Core Version:    0.7.0.1
 */