import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;

public class beve
  implements InputFilter
{
  public beve(AbsPublishActivity paramAbsPublishActivity) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if (bgip.a(paramCharSequence, '\n') + bgip.a(paramSpanned.toString(), '\n') > 100) {
        return paramCharSequence.replaceAll("\n", "");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beve
 * JD-Core Version:    0.7.0.1
 */