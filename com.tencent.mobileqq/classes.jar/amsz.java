import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class amsz
  implements DialogInterface.OnKeyListener
{
  amsz(amsv paramamsv, amtd paramamtd) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Amtd != null)) {
      this.jdField_a_of_type_Amtd.a(this.jdField_a_of_type_Amsv.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsz
 * JD-Core Version:    0.7.0.1
 */