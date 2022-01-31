import android.widget.TextView;

public class aymd
  extends aynd
{
  public aymd(bcws parambcws)
  {
    super(parambcws);
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    super.b(paramayjl, paramayru);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((paramayjl instanceof ayha))
    {
      ayha localayha = (ayha)paramayjl;
      localTextView = ((ayrq)paramayru).e();
      paramayjl = ((ayrq)paramayru).f();
      paramayru = ((ayrq)paramayru).g();
      if (localTextView != null)
      {
        localCharSequence = localayha.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (paramayru != null) {
          paramayru.setVisibility(8);
        }
      }
      if (paramayjl != null)
      {
        paramayru = localayha.f();
        if (paramayru != null) {
          break label115;
        }
        paramayjl.setText("");
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
        if (paramayru == null) {
          break;
        }
        paramayru.setVisibility(0);
        break;
        paramayjl.setText(paramayru);
        return;
      } while (!(paramayjl instanceof aygz));
      paramayjl = (aygz)paramayjl;
      paramayru = ((ayrq)paramayru).h();
    } while (paramayru == null);
    paramayjl = paramayjl.e();
    if (paramayjl == null)
    {
      paramayru.setText("");
      return;
    }
    paramayru.setText(paramayjl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymd
 * JD-Core Version:    0.7.0.1
 */