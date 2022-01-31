import android.text.Spanned;
import android.text.method.NumberKeyListener;
import com.tencent.widget.TCWNumberPicker;

public class amlh
  extends NumberKeyListener
{
  private amlh(TCWNumberPicker paramTCWNumberPicker) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    CharSequence localCharSequence2 = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    CharSequence localCharSequence1 = localCharSequence2;
    if (localCharSequence2 == null) {
      localCharSequence1 = paramCharSequence.subSequence(paramInt1, paramInt2);
    }
    paramCharSequence = String.valueOf(paramSpanned.subSequence(0, paramInt3)) + localCharSequence1 + paramSpanned.subSequence(paramInt4, paramSpanned.length());
    if ("".equals(paramCharSequence)) {
      localCharSequence1 = paramCharSequence;
    }
    while (TCWNumberPicker.a(this.a, paramCharSequence) <= TCWNumberPicker.b(this.a)) {
      return localCharSequence1;
    }
    return "";
  }
  
  protected char[] getAcceptedChars()
  {
    return TCWNumberPicker.a();
  }
  
  public int getInputType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amlh
 * JD-Core Version:    0.7.0.1
 */