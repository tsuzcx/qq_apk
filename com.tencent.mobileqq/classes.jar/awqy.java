import android.widget.TextView;

public class awqy
  extends awry
{
  public awqy(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    super.b(paramawog, paramawwp);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((paramawog instanceof awlv))
    {
      awlv localawlv = (awlv)paramawog;
      localTextView = ((awwl)paramawwp).e();
      paramawog = ((awwl)paramawwp).f();
      paramawwp = ((awwl)paramawwp).g();
      if (localTextView != null)
      {
        localCharSequence = localawlv.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (paramawwp != null) {
          paramawwp.setVisibility(8);
        }
      }
      if (paramawog != null)
      {
        paramawwp = localawlv.f();
        if (paramawwp != null) {
          break label115;
        }
        paramawog.setText("");
      }
    }
    label96:
    label115:
    do
    {
      do
      {
        return;
        localTextView.setText(localCharSequence);
        if (paramawwp == null) {
          break;
        }
        paramawwp.setVisibility(0);
        break;
        paramawog.setText(paramawwp);
        return;
      } while (!(paramawog instanceof awlu));
      paramawog = (awlu)paramawog;
      paramawwp = ((awwl)paramawwp).h();
    } while (paramawwp == null);
    paramawog = paramawog.e();
    if (paramawog == null)
    {
      paramawwp.setText("");
      return;
    }
    paramawwp.setText(paramawog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqy
 * JD-Core Version:    0.7.0.1
 */