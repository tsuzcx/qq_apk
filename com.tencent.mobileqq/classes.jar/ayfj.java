import android.text.Editable;
import android.text.Editable.Factory;

public final class ayfj
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bamz)) {
      return (Editable)paramCharSequence;
    }
    return new bamz(paramCharSequence, 1, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfj
 * JD-Core Version:    0.7.0.1
 */