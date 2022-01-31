import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class awri
  extends awrx
{
  public awri(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  protected awrc<awoi, awwr> a(baxy parambaxy)
  {
    return new awrj(parambaxy);
  }
  
  public void a(awog paramawog, awwq paramawwq)
  {
    paramawog = (awoh)paramawog;
    LinearLayout localLinearLayout = ((awwv)paramawwq).a();
    List localList;
    int k;
    int i;
    awoe localawoe;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = paramawog.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          paramawog = (awoi)localList.get(i);
          if ((paramawog instanceof awoe))
          {
            localawoe = (awoe)paramawog;
            localObject2 = null;
            if (awpt.a(localawoe.e()) == 1)
            {
              localObject2 = LayoutInflater.from(paramawwq.a().getContext()).inflate(2131562382, null);
              paramawog = ((View)localObject2).findViewById(2131368325);
              localObject1 = new awwl((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (paramawog != null))
      {
        ((View)localObject2).setTag(2131379213, localawoe);
        ((View)localObject2).setTag(2131379218, localObject1);
        ((View)localObject2).setTag(2131379214, Integer.valueOf(i));
        ((View)localObject2).setTag(2131379212, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131379215, this.a);
        awwd.a(localawoe, k, i);
        int m = localawoe.a();
        int n = localawoe.b();
        if ((localawoe instanceof awoj))
        {
          j = localawoe.r;
          label240:
          awwd.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localawoe, (awws)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (awpt.a(localawoe.e()) != 2) {
          break label538;
        }
        localObject2 = LayoutInflater.from(paramawwq.a().getContext()).inflate(2131562389, null);
        paramawog = ((View)localObject2).findViewById(2131368325);
        localObject1 = new awwu((View)localObject2);
        break label137;
        j = 0;
        break label240;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localawoe.e());
        continue;
        if ((paramawog instanceof awng))
        {
          paramawog = (awng)paramawog;
          localObject1 = new awxz(localLinearLayout, paramawog.d());
          localObject2 = ((awxz)localObject1).a();
          ((View)localObject2).setTag(2131379213, paramawog);
          ((View)localObject2).setTag(2131379218, localObject1);
          ((View)localObject2).setTag(2131379214, Integer.valueOf(i));
          ((View)localObject2).setTag(2131379212, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131379215, this.a);
          awwd.a(paramawog, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((awxz)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(paramawog, (awws)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (paramawwq.b() != null) {
        paramawwq.b().setVisibility(8);
      }
      return;
      label538:
      paramawog = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awri
 * JD-Core Version:    0.7.0.1
 */