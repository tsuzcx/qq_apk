import android.text.Spannable;
import android.text.Spannable.Factory;

final class aykj
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!ayki.b) && ((paramCharSequence instanceof ayki))) {
      try
      {
        ayki localayki = (ayki)((ayki)paramCharSequence).clone();
        return localayki;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykj
 * JD-Core Version:    0.7.0.1
 */