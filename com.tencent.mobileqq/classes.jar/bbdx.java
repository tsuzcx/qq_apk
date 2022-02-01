import android.content.DialogInterface.OnDismissListener;

public abstract class bbdx
  implements DialogInterface.OnDismissListener
{
  public DialogInterface.OnDismissListener a()
  {
    return new bbdy(this, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdx
 * JD-Core Version:    0.7.0.1
 */