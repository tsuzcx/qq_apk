import android.view.View;
import android.widget.TextView;
import java.util.List;

public class ayqy
  extends ayrj
{
  public ayqy(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  protected ayqo<aynu, aywd> a(bdbb parambdbb)
  {
    return new ayqz(parambdbb);
  }
  
  public void a(ayns paramayns, aywc paramaywc)
  {
    int i = 0;
    Object localObject = (aynt)paramayns;
    a(paramaywc, (aynt)localObject);
    int k = ((aynt)localObject).a();
    paramayns = paramaywc.a();
    if ((paramayns != null) && (paramayns != null))
    {
      localObject = ((aynt)localObject).a();
      if (localObject != null)
      {
        int m = Math.min(Math.min(paramayns.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((aywd)paramayns.get(i)).a().setVisibility(0);
          ((aywd)paramayns.get(i)).a().setTag(2131379971, ((List)localObject).get(i));
          ((aywd)paramayns.get(i)).a().setTag(2131379976, paramayns.get(i));
          ((aywd)paramayns.get(i)).a().setTag(2131379972, Integer.valueOf(i));
          ((aywd)paramayns.get(i)).a().setTag(2131379970, Integer.valueOf(paramayns.size()));
          ((aywd)paramayns.get(i)).a().setTag(2131379973, this.a);
          ayvp.a((aynu)((List)localObject).get(i), m, i);
          int n = ((aynu)((List)localObject).get(i)).a();
          int i1 = ((aynu)((List)localObject).get(i)).b();
          View localView = ((aywd)paramayns.get(i)).a();
          if ((((List)localObject).get(i) instanceof aynv)) {}
          for (int j = ((aynv)((List)localObject).get(i)).r;; j = 0)
          {
            ayvp.a(n, i1, localView, j);
            this.a.a((ayns)((List)localObject).get(i), (aywe)paramayns.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < paramayns.size())
        {
          ((aywd)paramayns.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramayns.size())
      {
        ((aywd)paramayns.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramaywc.b() != null) {
      paramaywc.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqy
 * JD-Core Version:    0.7.0.1
 */