import android.text.Editable;
import android.text.Editable.Factory;

final class bdoj
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bdoi)) {
      return (Editable)paramCharSequence;
    }
    return new bdoi(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoj
 * JD-Core Version:    0.7.0.1
 */