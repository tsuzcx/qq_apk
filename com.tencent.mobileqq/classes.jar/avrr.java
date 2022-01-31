import android.view.View;
import android.widget.TextView;
import java.util.List;

public class avrr
  extends avsc
{
  public avrr(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  protected avrh<avon, avww> a(azwg paramazwg)
  {
    return new avrs(paramazwg);
  }
  
  public void a(avol paramavol, avwv paramavwv)
  {
    int i = 0;
    Object localObject = (avom)paramavol;
    a(paramavwv, (avom)localObject);
    int k = ((avom)localObject).a();
    paramavol = paramavwv.a();
    if ((paramavol != null) && (paramavol != null))
    {
      localObject = ((avom)localObject).a();
      if (localObject != null)
      {
        int m = Math.min(Math.min(paramavol.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((avww)paramavol.get(i)).a().setVisibility(0);
          ((avww)paramavol.get(i)).a().setTag(2131313373, ((List)localObject).get(i));
          ((avww)paramavol.get(i)).a().setTag(2131313378, paramavol.get(i));
          ((avww)paramavol.get(i)).a().setTag(2131313374, Integer.valueOf(i));
          ((avww)paramavol.get(i)).a().setTag(2131313372, Integer.valueOf(paramavol.size()));
          ((avww)paramavol.get(i)).a().setTag(2131313375, this.a);
          avwi.a((avon)((List)localObject).get(i), m, i);
          int n = ((avon)((List)localObject).get(i)).a();
          int i1 = ((avon)((List)localObject).get(i)).b();
          View localView = ((avww)paramavol.get(i)).a();
          if ((((List)localObject).get(i) instanceof avoo)) {}
          for (int j = ((avoo)((List)localObject).get(i)).r;; j = 0)
          {
            avwi.a(n, i1, localView, j);
            this.a.a((avol)((List)localObject).get(i), (avwx)paramavol.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < paramavol.size())
        {
          ((avww)paramavol.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramavol.size())
      {
        ((avww)paramavol.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramavwv.b() != null) {
      paramavwv.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrr
 * JD-Core Version:    0.7.0.1
 */