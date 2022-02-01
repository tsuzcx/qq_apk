import android.text.Spannable;
import android.text.Spannable.Factory;

final class begq
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!begp.b) && ((paramCharSequence instanceof begp))) {
      try
      {
        begp localbegp = (begp)((begp)paramCharSequence).clone();
        return localbegp;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begq
 * JD-Core Version:    0.7.0.1
 */