import android.text.Editable;
import android.text.Editable.Factory;

public final class aygt
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof axkn)) {
      return (Editable)paramCharSequence;
    }
    return new axkn(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aygt
 * JD-Core Version:    0.7.0.1
 */