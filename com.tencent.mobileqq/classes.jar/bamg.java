import android.text.Editable;
import android.text.Editable.Factory;

final class bamg
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bamf)) {
      return (Editable)paramCharSequence;
    }
    return new bamf(paramCharSequence, 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamg
 * JD-Core Version:    0.7.0.1
 */