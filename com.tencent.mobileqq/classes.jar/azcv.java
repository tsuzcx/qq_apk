import android.text.Editable;
import android.text.Editable.Factory;

public final class azcv
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayks)) {
      return (Editable)paramCharSequence;
    }
    return new ayks(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azcv
 * JD-Core Version:    0.7.0.1
 */