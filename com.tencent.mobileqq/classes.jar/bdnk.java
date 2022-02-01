import android.text.Editable;
import android.text.Editable.Factory;

final class bdnk
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bdnj)) {
      return (Editable)paramCharSequence;
    }
    return new bdnj(paramCharSequence, 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnk
 * JD-Core Version:    0.7.0.1
 */