import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class awrc
  extends awrv
{
  public awrc(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  protected awra<awog, awwp> a(baxk parambaxk)
  {
    return new awrd(parambaxk);
  }
  
  public void a(awoe paramawoe, awwo paramawwo)
  {
    Object localObject = (awof)paramawoe;
    paramawoe = ((awwr)paramawwo).a();
    if (paramawoe != null)
    {
      List localList = ((awof)localObject).a();
      if (localList != null)
      {
        paramawoe.removeAllViews();
        int k = Math.min(localList.size(), ((awof)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (awog)localList.get(i);
          View localView = LayoutInflater.from(paramawwo.a().getContext()).inflate(2131562390, null);
          awws localawws = new awws(localView);
          localView.setTag(2131379208, localObject);
          localView.setTag(2131379213, localawws);
          localView.setTag(2131379209, Integer.valueOf(i));
          localView.setTag(2131379207, Integer.valueOf(localList.size()));
          localView.setTag(2131379210, this.a);
          awwb.a((awog)localObject, k, i);
          int m = ((awog)localObject).a();
          int n = ((awog)localObject).b();
          if ((localObject instanceof awoh)) {}
          for (int j = ((awoh)localObject).r;; j = 0)
          {
            awwb.a(m, n, localView, j);
            paramawoe.addView(localView);
            this.a.a((awoe)localObject, localawws);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramawwo.b() != null) {
      paramawwo.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrc
 * JD-Core Version:    0.7.0.1
 */