import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class awqo
  extends awrx
{
  public awqo(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  protected awrc<awoi, awwr> a(baxy parambaxy)
  {
    return new awqs(parambaxy);
  }
  
  public void a(awog paramawog, awwq paramawwq)
  {
    paramawog = (awoh)paramawog;
    LinearLayout localLinearLayout = ((awwj)paramawwq).a();
    if (localLinearLayout != null)
    {
      List localList = paramawog.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), paramawog.a());
        int i = 0;
        if (i < k)
        {
          awoi localawoi = (awoi)localList.get(i);
          View localView = LayoutInflater.from(paramawwq.a().getContext()).inflate(2131562382, null);
          awwl localawwl = new awwl(localView);
          localView.setTag(2131379213, localawoi);
          localView.setTag(2131379218, localawwl);
          localView.setTag(2131379214, Integer.valueOf(i));
          localView.setTag(2131379212, Integer.valueOf(localList.size()));
          localView.setTag(2131379215, this.a);
          awwd.a(localawoi, k, i);
          int m = localawoi.a();
          int n = localawoi.b();
          if ((localawoi instanceof awoj)) {}
          for (int j = ((awoj)localawoi).r;; j = 0)
          {
            awwd.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localawoi, localawwl);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramawwq.b() != null) {
      paramawwq.b().setVisibility(8);
    }
    if ((paramawog instanceof awns))
    {
      paramawog = ((awns)paramawog).a();
      paramawwq = ((awwj)paramawwq).a();
      if (paramawwq != null)
      {
        if (paramawog == null) {
          break label325;
        }
        paramawwq.a().setVisibility(0);
        this.a.a(paramawog, paramawwq);
      }
    }
    return;
    label325:
    paramawwq.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqo
 * JD-Core Version:    0.7.0.1
 */