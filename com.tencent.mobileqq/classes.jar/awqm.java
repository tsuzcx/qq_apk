import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class awqm
  extends awrv
{
  public awqm(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  protected awra<awog, awwp> a(baxk parambaxk)
  {
    return new awqq(parambaxk);
  }
  
  public void a(awoe paramawoe, awwo paramawwo)
  {
    paramawoe = (awof)paramawoe;
    LinearLayout localLinearLayout = ((awwh)paramawwo).a();
    if (localLinearLayout != null)
    {
      List localList = paramawoe.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), paramawoe.a());
        int i = 0;
        if (i < k)
        {
          awog localawog = (awog)localList.get(i);
          View localView = LayoutInflater.from(paramawwo.a().getContext()).inflate(2131562383, null);
          awwj localawwj = new awwj(localView);
          localView.setTag(2131379208, localawog);
          localView.setTag(2131379213, localawwj);
          localView.setTag(2131379209, Integer.valueOf(i));
          localView.setTag(2131379207, Integer.valueOf(localList.size()));
          localView.setTag(2131379210, this.a);
          awwb.a(localawog, k, i);
          int m = localawog.a();
          int n = localawog.b();
          if ((localawog instanceof awoh)) {}
          for (int j = ((awoh)localawog).r;; j = 0)
          {
            awwb.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localawog, localawwj);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramawwo.b() != null) {
      paramawwo.b().setVisibility(8);
    }
    if ((paramawoe instanceof awnq))
    {
      paramawoe = ((awnq)paramawoe).a();
      paramawwo = ((awwh)paramawwo).a();
      if (paramawwo != null)
      {
        if (paramawoe == null) {
          break label325;
        }
        paramawwo.a().setVisibility(0);
        this.a.a(paramawoe, paramawwo);
      }
    }
    return;
    label325:
    paramawwo.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqm
 * JD-Core Version:    0.7.0.1
 */