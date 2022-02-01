import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class anet
  implements DialogInterface.OnKeyListener
{
  anet(anep paramanep, anex paramanex) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Anex != null)) {
      this.jdField_a_of_type_Anex.a(this.jdField_a_of_type_Anep.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anet
 * JD-Core Version:    0.7.0.1
 */