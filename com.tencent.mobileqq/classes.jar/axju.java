import android.text.Editable;
import android.text.Editable.Factory;

final class axju
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof axjt)) {
      return (Editable)paramCharSequence;
    }
    return new axjt(paramCharSequence, 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axju
 * JD-Core Version:    0.7.0.1
 */