import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class ayiy
  implements DialogInterface.OnKeyListener
{
  ayiy(ayiv paramayiv) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (ayiv.a(this.a) != null)) {
      ayiv.a(this.a).a();
    }
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayiy
 * JD-Core Version:    0.7.0.1
 */