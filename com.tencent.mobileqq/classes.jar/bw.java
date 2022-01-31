import android.text.InputFilter;
import android.text.Spanned;
import com.dataline.activities.LiteActivity;

public class bw
  implements InputFilter
{
  public bw(LiteActivity paramLiteActivity) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt3 = 4500 - (paramSpanned.length() - (paramInt4 - paramInt3));
    if (paramInt3 <= 0)
    {
      LiteActivity.a(this.a);
      return "";
    }
    if (paramInt3 >= paramInt2 - paramInt1) {
      return null;
    }
    paramInt3 += paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1)
      {
        LiteActivity.a(this.a);
        return "";
      }
    }
    LiteActivity.a(this.a);
    return paramCharSequence.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bw
 * JD-Core Version:    0.7.0.1
 */