import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;

public class bffo
  implements InputFilter
{
  public bffo(AbsPublishActivity paramAbsPublishActivity) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if (paramCharSequence.contains("\n")) {
        return paramCharSequence.replaceAll("\n", "");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffo
 * JD-Core Version:    0.7.0.1
 */