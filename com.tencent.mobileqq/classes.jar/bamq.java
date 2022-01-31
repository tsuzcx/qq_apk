import android.text.Spannable;
import android.text.Spannable.Factory;

final class bamq
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!bamp.b) && ((paramCharSequence instanceof bamp))) {
      try
      {
        bamp localbamp = (bamp)((bamp)paramCharSequence).clone();
        return localbamp;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamq
 * JD-Core Version:    0.7.0.1
 */