import android.text.Editable;
import android.text.Editable.Factory;

final class banf
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bane)) {
      return (Editable)paramCharSequence;
    }
    return new bane(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banf
 * JD-Core Version:    0.7.0.1
 */