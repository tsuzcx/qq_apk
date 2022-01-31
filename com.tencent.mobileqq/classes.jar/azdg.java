import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;

public class azdg
  implements InputFilter
{
  public azdg(AbsPublishActivity paramAbsPublishActivity) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if (bajf.a(paramCharSequence, '\n') + bajf.a(paramSpanned.toString(), '\n') > 100) {
        return paramCharSequence.replaceAll("\n", "");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdg
 * JD-Core Version:    0.7.0.1
 */