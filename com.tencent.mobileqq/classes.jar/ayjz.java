import android.text.Editable;
import android.text.Editable.Factory;

final class ayjz
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayjy)) {
      return (Editable)paramCharSequence;
    }
    return new ayjy(paramCharSequence, 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayjz
 * JD-Core Version:    0.7.0.1
 */