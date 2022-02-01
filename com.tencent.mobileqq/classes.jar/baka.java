import android.content.DialogInterface.OnDismissListener;

public abstract class baka
  implements DialogInterface.OnDismissListener
{
  public DialogInterface.OnDismissListener a()
  {
    return new bakb(this, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baka
 * JD-Core Version:    0.7.0.1
 */