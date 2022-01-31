import android.text.Editable;
import android.text.Editable.Factory;

final class axkq
  extends Editable.Factory
{
  axkq(int paramInt) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof axkn)) {
      return (Editable)paramCharSequence;
    }
    return new axkn(paramCharSequence, 3, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axkq
 * JD-Core Version:    0.7.0.1
 */