import android.widget.TextView;

public class ayqm
  extends ayrm
{
  public ayqm(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    super.b(paramaynu, paramaywd);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((paramaynu instanceof aylj))
    {
      aylj localaylj = (aylj)paramaynu;
      localTextView = ((ayvz)paramaywd).e();
      paramaynu = ((ayvz)paramaywd).f();
      paramaywd = ((ayvz)paramaywd).g();
      if (localTextView != null)
      {
        localCharSequence = localaylj.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (paramaywd != null) {
          paramaywd.setVisibility(8);
        }
      }
      if (paramaynu != null)
      {
        paramaywd = localaylj.f();
        if (paramaywd != null) {
          break label115;
        }
        paramaynu.setText("");
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
        if (paramaywd == null) {
          break;
        }
        paramaywd.setVisibility(0);
        break;
        paramaynu.setText(paramaywd);
        return;
      } while (!(paramaynu instanceof ayli));
      paramaynu = (ayli)paramaynu;
      paramaywd = ((ayvz)paramaywd).h();
    } while (paramaywd == null);
    paramaynu = paramaynu.e();
    if (paramaynu == null)
    {
      paramaywd.setText("");
      return;
    }
    paramaywd.setText(paramaynu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqm
 * JD-Core Version:    0.7.0.1
 */