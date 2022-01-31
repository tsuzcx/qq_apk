import android.view.View;
import android.widget.TextView;
import java.util.List;

public class awrk
  extends awrv
{
  public awrk(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  protected awra<awog, awwp> a(baxk parambaxk)
  {
    return new awrl(parambaxk);
  }
  
  public void a(awoe paramawoe, awwo paramawwo)
  {
    int i = 0;
    Object localObject = (awof)paramawoe;
    a(paramawwo, (awof)localObject);
    int k = ((awof)localObject).a();
    paramawoe = paramawwo.a();
    if ((paramawoe != null) && (paramawoe != null))
    {
      localObject = ((awof)localObject).a();
      if (localObject != null)
      {
        int m = Math.min(Math.min(paramawoe.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((awwp)paramawoe.get(i)).a().setVisibility(0);
          ((awwp)paramawoe.get(i)).a().setTag(2131379208, ((List)localObject).get(i));
          ((awwp)paramawoe.get(i)).a().setTag(2131379213, paramawoe.get(i));
          ((awwp)paramawoe.get(i)).a().setTag(2131379209, Integer.valueOf(i));
          ((awwp)paramawoe.get(i)).a().setTag(2131379207, Integer.valueOf(paramawoe.size()));
          ((awwp)paramawoe.get(i)).a().setTag(2131379210, this.a);
          awwb.a((awog)((List)localObject).get(i), m, i);
          int n = ((awog)((List)localObject).get(i)).a();
          int i1 = ((awog)((List)localObject).get(i)).b();
          View localView = ((awwp)paramawoe.get(i)).a();
          if ((((List)localObject).get(i) instanceof awoh)) {}
          for (int j = ((awoh)((List)localObject).get(i)).r;; j = 0)
          {
            awwb.a(n, i1, localView, j);
            this.a.a((awoe)((List)localObject).get(i), (awwq)paramawoe.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < paramawoe.size())
        {
          ((awwp)paramawoe.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramawoe.size())
      {
        ((awwp)paramawoe.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramawwo.b() != null) {
      paramawwo.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrk
 * JD-Core Version:    0.7.0.1
 */