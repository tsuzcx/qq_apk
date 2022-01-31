import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class bagu
  implements DialogInterface.OnKeyListener
{
  bagu(bagr parambagr) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (bagr.a(this.a) != null)) {
      bagr.a(this.a).a();
    }
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagu
 * JD-Core Version:    0.7.0.1
 */