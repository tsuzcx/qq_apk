import android.widget.TextView;

public class avrf
  extends avsf
{
  public avrf(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    super.b(paramavon, paramavww);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((paramavon instanceof avmc))
    {
      avmc localavmc = (avmc)paramavon;
      localTextView = ((avws)paramavww).e();
      paramavon = ((avws)paramavww).f();
      paramavww = ((avws)paramavww).g();
      if (localTextView != null)
      {
        localCharSequence = localavmc.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (paramavww != null) {
          paramavww.setVisibility(8);
        }
      }
      if (paramavon != null)
      {
        paramavww = localavmc.f();
        if (paramavww != null) {
          break label115;
        }
        paramavon.setText("");
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
        if (paramavww == null) {
          break;
        }
        paramavww.setVisibility(0);
        break;
        paramavon.setText(paramavww);
        return;
      } while (!(paramavon instanceof avmb));
      paramavon = (avmb)paramavon;
      paramavww = ((avws)paramavww).h();
    } while (paramavww == null);
    paramavon = paramavon.e();
    if (paramavon == null)
    {
      paramavww.setText("");
      return;
    }
    paramavww.setText(paramavon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrf
 * JD-Core Version:    0.7.0.1
 */