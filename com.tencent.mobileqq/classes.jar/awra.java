import android.widget.TextView;

public class awra
  extends awsa
{
  public awra(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    super.b(paramawoi, paramawwr);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((paramawoi instanceof awlx))
    {
      awlx localawlx = (awlx)paramawoi;
      localTextView = ((awwn)paramawwr).e();
      paramawoi = ((awwn)paramawwr).f();
      paramawwr = ((awwn)paramawwr).g();
      if (localTextView != null)
      {
        localCharSequence = localawlx.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (paramawwr != null) {
          paramawwr.setVisibility(8);
        }
      }
      if (paramawoi != null)
      {
        paramawwr = localawlx.f();
        if (paramawwr != null) {
          break label115;
        }
        paramawoi.setText("");
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
        if (paramawwr == null) {
          break;
        }
        paramawwr.setVisibility(0);
        break;
        paramawoi.setText(paramawwr);
        return;
      } while (!(paramawoi instanceof awlw));
      paramawoi = (awlw)paramawoi;
      paramawwr = ((awwn)paramawwr).h();
    } while (paramawwr == null);
    paramawoi = paramawoi.e();
    if (paramawoi == null)
    {
      paramawwr.setText("");
      return;
    }
    paramawwr.setText(paramawoi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awra
 * JD-Core Version:    0.7.0.1
 */