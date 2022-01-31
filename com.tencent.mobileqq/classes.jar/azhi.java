import android.text.Editable;
import android.text.Editable.Factory;

public final class azhi
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayku)) {
      return (Editable)paramCharSequence;
    }
    return new ayku(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhi
 * JD-Core Version:    0.7.0.1
 */