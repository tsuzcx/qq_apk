import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.widget.TCWNumberPicker;

public class bkpd
  implements InputFilter
{
  private bkpd(TCWNumberPicker paramTCWNumberPicker) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int i = 0;
    if (TCWNumberPicker.a(this.a) == null)
    {
      paramCharSequence = TCWNumberPicker.a(this.a).filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      return paramCharSequence;
    }
    String str = String.valueOf(paramCharSequence.subSequence(paramInt1, paramInt2));
    paramSpanned = String.valueOf(String.valueOf(paramSpanned.subSequence(0, paramInt3)) + str + paramSpanned.subSequence(paramInt4, paramSpanned.length())).toLowerCase();
    String[] arrayOfString = TCWNumberPicker.a(this.a);
    paramInt2 = arrayOfString.length;
    paramInt1 = i;
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        break label154;
      }
      paramCharSequence = str;
      if (arrayOfString[paramInt1].toLowerCase().startsWith(paramSpanned)) {
        break;
      }
      paramInt1 += 1;
    }
    label154:
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpd
 * JD-Core Version:    0.7.0.1
 */