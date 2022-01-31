import android.text.Editable;
import android.text.Editable.Factory;

final class aykb
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayka)) {
      return (Editable)paramCharSequence;
    }
    return new ayka(paramCharSequence, 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykb
 * JD-Core Version:    0.7.0.1
 */