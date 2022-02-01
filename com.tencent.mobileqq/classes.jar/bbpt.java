import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class bbpt
  extends bbqm
{
  public bbpt(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  protected bbpr<bbmy, bbvg> a(aobu paramaobu)
  {
    return new bbpu(paramaobu);
  }
  
  public void a(bbmw parambbmw, bbvf parambbvf)
  {
    Object localObject = (bbmx)parambbmw;
    parambbmw = ((bbvi)parambbvf).a();
    if (parambbmw != null)
    {
      List localList = ((bbmx)localObject).a();
      if (localList != null)
      {
        parambbmw.removeAllViews();
        int k = Math.min(localList.size(), ((bbmx)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (bbmy)localList.get(i);
          View localView = LayoutInflater.from(parambbvf.a().getContext()).inflate(2131562849, null);
          bbvj localbbvj = new bbvj(localView);
          localView.setTag(2131380929, localObject);
          localView.setTag(2131380935, localbbvj);
          localView.setTag(2131380930, Integer.valueOf(i));
          localView.setTag(2131380928, Integer.valueOf(localList.size()));
          localView.setTag(2131380931, this.a);
          bbus.a((bbmy)localObject, k, i);
          int m = ((bbmy)localObject).a();
          int n = ((bbmy)localObject).b();
          if ((localObject instanceof bbmz)) {}
          for (int j = ((bbmz)localObject).s;; j = 0)
          {
            bbus.a(m, n, localView, j);
            parambbmw.addView(localView);
            this.a.a((bbmw)localObject, localbbvj);
            i += 1;
            break;
          }
        }
      }
    }
    if (parambbvf.b() != null) {
      parambbvf.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpt
 * JD-Core Version:    0.7.0.1
 */