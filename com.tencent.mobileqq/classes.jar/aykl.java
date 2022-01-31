import android.text.Spannable;
import android.text.Spannable.Factory;

final class aykl
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!aykk.b) && ((paramCharSequence instanceof aykk))) {
      try
      {
        aykk localaykk = (aykk)((aykk)paramCharSequence).clone();
        return localaykk;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykl
 * JD-Core Version:    0.7.0.1
 */