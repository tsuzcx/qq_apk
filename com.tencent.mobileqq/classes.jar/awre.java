import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class awre
  extends awrx
{
  public awre(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  protected awrc<awoi, awwr> a(baxy parambaxy)
  {
    return new awrf(parambaxy);
  }
  
  public void a(awog paramawog, awwq paramawwq)
  {
    Object localObject = (awoh)paramawog;
    paramawog = ((awwt)paramawwq).a();
    if (paramawog != null)
    {
      List localList = ((awoh)localObject).a();
      if (localList != null)
      {
        paramawog.removeAllViews();
        int k = Math.min(localList.size(), ((awoh)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (awoi)localList.get(i);
          View localView = LayoutInflater.from(paramawwq.a().getContext()).inflate(2131562389, null);
          awwu localawwu = new awwu(localView);
          localView.setTag(2131379213, localObject);
          localView.setTag(2131379218, localawwu);
          localView.setTag(2131379214, Integer.valueOf(i));
          localView.setTag(2131379212, Integer.valueOf(localList.size()));
          localView.setTag(2131379215, this.a);
          awwd.a((awoi)localObject, k, i);
          int m = ((awoi)localObject).a();
          int n = ((awoi)localObject).b();
          if ((localObject instanceof awoj)) {}
          for (int j = ((awoj)localObject).r;; j = 0)
          {
            awwd.a(m, n, localView, j);
            paramawog.addView(localView);
            this.a.a((awog)localObject, localawwu);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramawwq.b() != null) {
      paramawwq.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awre
 * JD-Core Version:    0.7.0.1
 */