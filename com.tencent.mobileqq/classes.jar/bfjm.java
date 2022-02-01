import android.text.Editable;
import android.text.Editable.Factory;

public final class bfjm
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof begz)) {
      return (Editable)paramCharSequence;
    }
    return new begz(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjm
 * JD-Core Version:    0.7.0.1
 */