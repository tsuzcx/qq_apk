import android.text.Editable;
import android.text.Editable.Factory;

final class bait
  extends Editable.Factory
{
  bait(int paramInt) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof baiq)) {
      return (Editable)paramCharSequence;
    }
    return new baiq(paramCharSequence, 3, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bait
 * JD-Core Version:    0.7.0.1
 */