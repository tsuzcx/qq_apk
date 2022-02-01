import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class aryx
  implements DialogInterface.OnKeyListener
{
  aryx(aryw paramaryw) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 84) || (paramInt == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryx
 * JD-Core Version:    0.7.0.1
 */