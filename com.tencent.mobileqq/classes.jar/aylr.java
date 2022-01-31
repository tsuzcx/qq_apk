import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class aylr
  extends ayna
{
  public aylr(bcws parambcws)
  {
    super(parambcws);
  }
  
  protected aymf<ayjl, ayru> a(bcws parambcws)
  {
    return new aylv(parambcws);
  }
  
  public void a(ayjj paramayjj, ayrt paramayrt)
  {
    paramayjj = (ayjk)paramayjj;
    LinearLayout localLinearLayout = ((ayrm)paramayrt).a();
    if (localLinearLayout != null)
    {
      List localList = paramayjj.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), paramayjj.a());
        int i = 0;
        if (i < k)
        {
          ayjl localayjl = (ayjl)localList.get(i);
          View localView = LayoutInflater.from(paramayrt.a().getContext()).inflate(2131562586, null);
          ayro localayro = new ayro(localView);
          localView.setTag(2131379913, localayjl);
          localView.setTag(2131379918, localayro);
          localView.setTag(2131379914, Integer.valueOf(i));
          localView.setTag(2131379912, Integer.valueOf(localList.size()));
          localView.setTag(2131379915, this.a);
          ayrg.a(localayjl, k, i);
          int m = localayjl.a();
          int n = localayjl.b();
          if ((localayjl instanceof ayjm)) {}
          for (int j = ((ayjm)localayjl).r;; j = 0)
          {
            ayrg.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localayjl, localayro);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramayrt.b() != null) {
      paramayrt.b().setVisibility(8);
    }
    if ((paramayjj instanceof ayiv))
    {
      paramayjj = ((ayiv)paramayjj).a();
      paramayrt = ((ayrm)paramayrt).a();
      if (paramayrt != null)
      {
        if (paramayjj == null) {
          break label325;
        }
        paramayrt.a().setVisibility(0);
        this.a.a(paramayjj, paramayrt);
      }
    }
    return;
    label325:
    paramayrt.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylr
 * JD-Core Version:    0.7.0.1
 */