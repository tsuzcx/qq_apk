import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class bbpd
  extends bbqm
{
  public bbpd(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  protected bbpr<bbmy, bbvg> a(aobu paramaobu)
  {
    return new bbph(paramaobu);
  }
  
  public void a(bbmw parambbmw, bbvf parambbvf)
  {
    parambbmw = (bbmx)parambbmw;
    LinearLayout localLinearLayout = ((bbuy)parambbvf).a();
    if (localLinearLayout != null)
    {
      List localList = parambbmw.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), parambbmw.a());
        int i = 0;
        if (i < k)
        {
          bbmy localbbmy = (bbmy)localList.get(i);
          View localView = LayoutInflater.from(parambbvf.a().getContext()).inflate(2131562842, null);
          bbva localbbva = new bbva(localView);
          localView.setTag(2131380929, localbbmy);
          localView.setTag(2131380935, localbbva);
          localView.setTag(2131380930, Integer.valueOf(i));
          localView.setTag(2131380928, Integer.valueOf(localList.size()));
          localView.setTag(2131380931, this.a);
          bbus.a(localbbmy, k, i);
          int m = localbbmy.a();
          int n = localbbmy.b();
          if ((localbbmy instanceof bbmz)) {}
          for (int j = ((bbmz)localbbmy).s;; j = 0)
          {
            bbus.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localbbmy, localbbva);
            i += 1;
            break;
          }
        }
      }
    }
    if (parambbvf.b() != null) {
      parambbvf.b().setVisibility(8);
    }
    if ((parambbmw instanceof bbmi))
    {
      parambbmw = ((bbmi)parambbmw).a();
      parambbvf = ((bbuy)parambbvf).a();
      if (parambbvf != null)
      {
        if (parambbmw == null) {
          break label325;
        }
        parambbvf.a().setVisibility(0);
        this.a.a(parambbmw, parambbvf);
      }
    }
    return;
    label325:
    parambbvf.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpd
 * JD-Core Version:    0.7.0.1
 */