import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class awrg
  extends awrv
{
  public awrg(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  protected awra<awog, awwp> a(baxk parambaxk)
  {
    return new awrh(parambaxk);
  }
  
  public void a(awoe paramawoe, awwo paramawwo)
  {
    paramawoe = (awof)paramawoe;
    LinearLayout localLinearLayout = ((awwt)paramawwo).a();
    List localList;
    int k;
    int i;
    awoc localawoc;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = paramawoe.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          paramawoe = (awog)localList.get(i);
          if ((paramawoe instanceof awoc))
          {
            localawoc = (awoc)paramawoe;
            localObject2 = null;
            if (awpr.a(localawoc.e()) == 1)
            {
              localObject2 = LayoutInflater.from(paramawwo.a().getContext()).inflate(2131562383, null);
              paramawoe = ((View)localObject2).findViewById(2131368325);
              localObject1 = new awwj((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (paramawoe != null))
      {
        ((View)localObject2).setTag(2131379208, localawoc);
        ((View)localObject2).setTag(2131379213, localObject1);
        ((View)localObject2).setTag(2131379209, Integer.valueOf(i));
        ((View)localObject2).setTag(2131379207, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131379210, this.a);
        awwb.a(localawoc, k, i);
        int m = localawoc.a();
        int n = localawoc.b();
        if ((localawoc instanceof awoh))
        {
          j = localawoc.r;
          label240:
          awwb.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localawoc, (awwq)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (awpr.a(localawoc.e()) != 2) {
          break label538;
        }
        localObject2 = LayoutInflater.from(paramawwo.a().getContext()).inflate(2131562390, null);
        paramawoe = ((View)localObject2).findViewById(2131368325);
        localObject1 = new awws((View)localObject2);
        break label137;
        j = 0;
        break label240;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localawoc.e());
        continue;
        if ((paramawoe instanceof awne))
        {
          paramawoe = (awne)paramawoe;
          localObject1 = new awxx(localLinearLayout, paramawoe.d());
          localObject2 = ((awxx)localObject1).a();
          ((View)localObject2).setTag(2131379208, paramawoe);
          ((View)localObject2).setTag(2131379213, localObject1);
          ((View)localObject2).setTag(2131379209, Integer.valueOf(i));
          ((View)localObject2).setTag(2131379207, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131379210, this.a);
          awwb.a(paramawoe, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((awxx)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(paramawoe, (awwq)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (paramawwo.b() != null) {
        paramawwo.b().setVisibility(8);
      }
      return;
      label538:
      paramawoe = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrg
 * JD-Core Version:    0.7.0.1
 */