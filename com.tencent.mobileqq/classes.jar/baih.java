import android.text.Spannable;
import android.text.Spannable.Factory;

final class baih
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!baig.b) && ((paramCharSequence instanceof baig))) {
      try
      {
        baig localbaig = (baig)((baig)paramCharSequence).clone();
        return localbaig;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baih
 * JD-Core Version:    0.7.0.1
 */