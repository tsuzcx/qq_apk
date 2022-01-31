import android.view.View;
import android.widget.TextView;
import java.util.List;

public class awrm
  extends awrx
{
  public awrm(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  protected awrc<awoi, awwr> a(baxy parambaxy)
  {
    return new awrn(parambaxy);
  }
  
  public void a(awog paramawog, awwq paramawwq)
  {
    int i = 0;
    Object localObject = (awoh)paramawog;
    a(paramawwq, (awoh)localObject);
    int k = ((awoh)localObject).a();
    paramawog = paramawwq.a();
    if ((paramawog != null) && (paramawog != null))
    {
      localObject = ((awoh)localObject).a();
      if (localObject != null)
      {
        int m = Math.min(Math.min(paramawog.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((awwr)paramawog.get(i)).a().setVisibility(0);
          ((awwr)paramawog.get(i)).a().setTag(2131379213, ((List)localObject).get(i));
          ((awwr)paramawog.get(i)).a().setTag(2131379218, paramawog.get(i));
          ((awwr)paramawog.get(i)).a().setTag(2131379214, Integer.valueOf(i));
          ((awwr)paramawog.get(i)).a().setTag(2131379212, Integer.valueOf(paramawog.size()));
          ((awwr)paramawog.get(i)).a().setTag(2131379215, this.a);
          awwd.a((awoi)((List)localObject).get(i), m, i);
          int n = ((awoi)((List)localObject).get(i)).a();
          int i1 = ((awoi)((List)localObject).get(i)).b();
          View localView = ((awwr)paramawog.get(i)).a();
          if ((((List)localObject).get(i) instanceof awoj)) {}
          for (int j = ((awoj)((List)localObject).get(i)).r;; j = 0)
          {
            awwd.a(n, i1, localView, j);
            this.a.a((awog)((List)localObject).get(i), (awws)paramawog.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < paramawog.size())
        {
          ((awwr)paramawog.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramawog.size())
      {
        ((awwr)paramawog.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramawwq.b() != null) {
      paramawwq.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrm
 * JD-Core Version:    0.7.0.1
 */