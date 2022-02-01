import android.text.Editable;
import android.text.Editable.Factory;

final class bczw
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bczv)) {
      return (Editable)paramCharSequence;
    }
    return new bczv(paramCharSequence, 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczw
 * JD-Core Version:    0.7.0.1
 */