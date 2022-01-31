import android.view.View;
import android.widget.TextView;
import java.util.List;

public class aymp
  extends ayna
{
  public aymp(bcws parambcws)
  {
    super(parambcws);
  }
  
  protected aymf<ayjl, ayru> a(bcws parambcws)
  {
    return new aymq(parambcws);
  }
  
  public void a(ayjj paramayjj, ayrt paramayrt)
  {
    int i = 0;
    Object localObject = (ayjk)paramayjj;
    a(paramayrt, (ayjk)localObject);
    int k = ((ayjk)localObject).a();
    paramayjj = paramayrt.a();
    if ((paramayjj != null) && (paramayjj != null))
    {
      localObject = ((ayjk)localObject).a();
      if (localObject != null)
      {
        int m = Math.min(Math.min(paramayjj.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((ayru)paramayjj.get(i)).a().setVisibility(0);
          ((ayru)paramayjj.get(i)).a().setTag(2131379913, ((List)localObject).get(i));
          ((ayru)paramayjj.get(i)).a().setTag(2131379918, paramayjj.get(i));
          ((ayru)paramayjj.get(i)).a().setTag(2131379914, Integer.valueOf(i));
          ((ayru)paramayjj.get(i)).a().setTag(2131379912, Integer.valueOf(paramayjj.size()));
          ((ayru)paramayjj.get(i)).a().setTag(2131379915, this.a);
          ayrg.a((ayjl)((List)localObject).get(i), m, i);
          int n = ((ayjl)((List)localObject).get(i)).a();
          int i1 = ((ayjl)((List)localObject).get(i)).b();
          View localView = ((ayru)paramayjj.get(i)).a();
          if ((((List)localObject).get(i) instanceof ayjm)) {}
          for (int j = ((ayjm)((List)localObject).get(i)).r;; j = 0)
          {
            ayrg.a(n, i1, localView, j);
            this.a.a((ayjj)((List)localObject).get(i), (ayrv)paramayjj.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < paramayjj.size())
        {
          ((ayru)paramayjj.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramayjj.size())
      {
        ((ayru)paramayjj.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramayrt.b() != null) {
      paramayrt.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymp
 * JD-Core Version:    0.7.0.1
 */