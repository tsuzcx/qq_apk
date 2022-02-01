import android.view.View;
import android.widget.TextView;
import java.util.List;

public class bbqb
  extends bbqm
{
  public bbqb(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  protected bbpr<bbmy, bbvg> a(aobu paramaobu)
  {
    return new bbqc(paramaobu);
  }
  
  public void a(bbmw parambbmw, bbvf parambbvf)
  {
    int i = 0;
    Object localObject = (bbmx)parambbmw;
    a(parambbvf, (bbmx)localObject);
    int k = ((bbmx)localObject).a();
    parambbmw = parambbvf.a();
    if ((parambbmw != null) && (parambbmw != null))
    {
      localObject = ((bbmx)localObject).a();
      if (localObject != null)
      {
        int m = Math.min(Math.min(parambbmw.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((bbvg)parambbmw.get(i)).a().setVisibility(0);
          ((bbvg)parambbmw.get(i)).a().setTag(2131380929, ((List)localObject).get(i));
          ((bbvg)parambbmw.get(i)).a().setTag(2131380935, parambbmw.get(i));
          ((bbvg)parambbmw.get(i)).a().setTag(2131380930, Integer.valueOf(i));
          ((bbvg)parambbmw.get(i)).a().setTag(2131380928, Integer.valueOf(parambbmw.size()));
          ((bbvg)parambbmw.get(i)).a().setTag(2131380931, this.a);
          bbus.a((bbmy)((List)localObject).get(i), m, i);
          int n = ((bbmy)((List)localObject).get(i)).a();
          int i1 = ((bbmy)((List)localObject).get(i)).b();
          View localView = ((bbvg)parambbmw.get(i)).a();
          if ((((List)localObject).get(i) instanceof bbmz)) {}
          for (int j = ((bbmz)((List)localObject).get(i)).s;; j = 0)
          {
            bbus.a(n, i1, localView, j);
            this.a.a((bbmw)((List)localObject).get(i), (bbvh)parambbmw.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < parambbmw.size())
        {
          ((bbvg)parambbmw.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < parambbmw.size())
      {
        ((bbvg)parambbmw.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (parambbvf.b() != null) {
      parambbvf.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqb
 * JD-Core Version:    0.7.0.1
 */