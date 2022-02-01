import android.widget.TextView;

public class bbpp
  extends bbqp
{
  public bbpp(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    super.b(parambbmy, parambbvg);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((parambbmy instanceof bbkn))
    {
      bbkn localbbkn = (bbkn)parambbmy;
      localTextView = ((bbvc)parambbvg).e();
      parambbmy = ((bbvc)parambbvg).f();
      parambbvg = ((bbvc)parambbvg).g();
      if (localTextView != null)
      {
        localCharSequence = localbbkn.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (parambbvg != null) {
          parambbvg.setVisibility(8);
        }
      }
      if (parambbmy != null)
      {
        parambbvg = localbbkn.f();
        if (parambbvg != null) {
          break label115;
        }
        parambbmy.setText("");
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
        if (parambbvg == null) {
          break;
        }
        parambbvg.setVisibility(0);
        break;
        parambbmy.setText(parambbvg);
        return;
      } while (!(parambbmy instanceof bbkm));
      parambbmy = (bbkm)parambbmy;
      parambbvg = ((bbvc)parambbvg).h();
    } while (parambbvg == null);
    parambbmy = parambbmy.e();
    if (parambbmy == null)
    {
      parambbvg.setText("");
      return;
    }
    parambbvg.setText(parambbmy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpp
 * JD-Core Version:    0.7.0.1
 */