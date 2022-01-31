import android.text.Editable;
import android.text.Editable.Factory;

final class aykx
  extends Editable.Factory
{
  aykx(int paramInt) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayku)) {
      return (Editable)paramCharSequence;
    }
    return new ayku(paramCharSequence, 3, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykx
 * JD-Core Version:    0.7.0.1
 */