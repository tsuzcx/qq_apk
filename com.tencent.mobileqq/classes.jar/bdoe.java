import android.text.Editable;
import android.text.Editable.Factory;

final class bdoe
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bdod)) {
      return (Editable)paramCharSequence;
    }
    return new bdod(paramCharSequence, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoe
 * JD-Core Version:    0.7.0.1
 */