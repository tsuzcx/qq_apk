import android.text.Editable;
import android.text.Editable.Factory;

final class behc
  extends Editable.Factory
{
  behc(int paramInt) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof begz)) {
      return (Editable)paramCharSequence;
    }
    return new begz(paramCharSequence, 3, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behc
 * JD-Core Version:    0.7.0.1
 */