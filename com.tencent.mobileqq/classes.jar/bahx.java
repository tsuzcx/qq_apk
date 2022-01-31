import android.text.Editable;
import android.text.Editable.Factory;

final class bahx
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bahw)) {
      return (Editable)paramCharSequence;
    }
    return new bahw(paramCharSequence, 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahx
 * JD-Core Version:    0.7.0.1
 */