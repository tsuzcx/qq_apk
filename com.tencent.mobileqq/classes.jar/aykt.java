import android.text.Editable;
import android.text.Editable.Factory;

final class aykt
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayks)) {
      return (Editable)paramCharSequence;
    }
    return new ayks(paramCharSequence, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykt
 * JD-Core Version:    0.7.0.1
 */