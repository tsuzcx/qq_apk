import android.text.Editable;
import android.text.Editable.Factory;

final class bair
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof baiq)) {
      return (Editable)paramCharSequence;
    }
    return new baiq(paramCharSequence, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bair
 * JD-Core Version:    0.7.0.1
 */