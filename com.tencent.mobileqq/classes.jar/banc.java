import android.text.Editable;
import android.text.Editable.Factory;

final class banc
  extends Editable.Factory
{
  banc(int paramInt) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bamz)) {
      return (Editable)paramCharSequence;
    }
    return new bamz(paramCharSequence, 3, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banc
 * JD-Core Version:    0.7.0.1
 */