import android.text.Editable;
import android.text.Editable.Factory;

final class begu
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof begt)) {
      return (Editable)paramCharSequence;
    }
    return new begt(paramCharSequence, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begu
 * JD-Core Version:    0.7.0.1
 */