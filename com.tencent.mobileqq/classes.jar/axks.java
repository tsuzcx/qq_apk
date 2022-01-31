import android.text.Editable;
import android.text.Editable.Factory;

final class axks
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof axkr)) {
      return (Editable)paramCharSequence;
    }
    return new axkr(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axks
 * JD-Core Version:    0.7.0.1
 */