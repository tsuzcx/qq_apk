import android.text.Spannable;
import android.text.Spannable.Factory;

final class bdnu
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!bdnt.b) && ((paramCharSequence instanceof bdnt))) {
      try
      {
        bdnt localbdnt = (bdnt)((bdnt)paramCharSequence).clone();
        return localbdnt;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnu
 * JD-Core Version:    0.7.0.1
 */