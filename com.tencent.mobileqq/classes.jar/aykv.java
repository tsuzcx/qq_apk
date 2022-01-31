import android.text.Editable;
import android.text.Editable.Factory;

final class aykv
  extends Editable.Factory
{
  aykv(int paramInt) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayks)) {
      return (Editable)paramCharSequence;
    }
    return new ayks(paramCharSequence, 3, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykv
 * JD-Core Version:    0.7.0.1
 */