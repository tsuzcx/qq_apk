import android.text.Spannable;
import android.text.Spannable.Factory;

final class axke
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!axkd.b) && ((paramCharSequence instanceof axkd))) {
      try
      {
        axkd localaxkd = (axkd)((axkd)paramCharSequence).clone();
        return localaxkd;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axke
 * JD-Core Version:    0.7.0.1
 */