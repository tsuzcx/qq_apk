import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class befc
  implements DialogInterface.OnKeyListener
{
  befc(beez parambeez) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (beez.a(this.a) != null)) {
      beez.a(this.a).a();
    }
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befc
 * JD-Core Version:    0.7.0.1
 */