import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bbpx
  extends bbqm
{
  public bbpx(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  protected bbpr<bbmy, bbvg> a(aobu paramaobu)
  {
    return new bbpy(paramaobu);
  }
  
  public void a(bbmw parambbmw, bbvf parambbvf)
  {
    parambbmw = (bbmx)parambbmw;
    LinearLayout localLinearLayout = ((bbvk)parambbvf).a();
    List localList;
    int k;
    int i;
    bbmu localbbmu;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = parambbmw.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          parambbmw = (bbmy)localList.get(i);
          if ((parambbmw instanceof bbmu))
          {
            localbbmu = (bbmu)parambbmw;
            localObject2 = null;
            if (bboj.a(localbbmu.e()) == 1)
            {
              localObject2 = LayoutInflater.from(parambbvf.a().getContext()).inflate(2131562842, null);
              parambbmw = ((View)localObject2).findViewById(2131368791);
              localObject1 = new bbva((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (parambbmw != null))
      {
        ((View)localObject2).setTag(2131380929, localbbmu);
        ((View)localObject2).setTag(2131380935, localObject1);
        ((View)localObject2).setTag(2131380930, Integer.valueOf(i));
        ((View)localObject2).setTag(2131380928, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131380931, this.a);
        bbus.a(localbbmu, k, i);
        int m = localbbmu.a();
        int n = localbbmu.b();
        if ((localbbmu instanceof bbmz))
        {
          j = localbbmu.s;
          label240:
          bbus.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localbbmu, (bbvh)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (bboj.a(localbbmu.e()) != 2) {
          break label538;
        }
        localObject2 = LayoutInflater.from(parambbvf.a().getContext()).inflate(2131562849, null);
        parambbmw = ((View)localObject2).findViewById(2131368791);
        localObject1 = new bbvj((View)localObject2);
        break label137;
        j = 0;
        break label240;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localbbmu.e());
        continue;
        if ((parambbmw instanceof bblw))
        {
          parambbmw = (bblw)parambbmw;
          localObject1 = new bbwo(localLinearLayout, parambbmw.d());
          localObject2 = ((bbwo)localObject1).a();
          ((View)localObject2).setTag(2131380929, parambbmw);
          ((View)localObject2).setTag(2131380935, localObject1);
          ((View)localObject2).setTag(2131380930, Integer.valueOf(i));
          ((View)localObject2).setTag(2131380928, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131380931, this.a);
          bbus.a(parambbmw, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((bbwo)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(parambbmw, (bbvh)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (parambbvf.b() != null) {
        parambbvf.b().setVisibility(8);
      }
      return;
      label538:
      parambbmw = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpx
 * JD-Core Version:    0.7.0.1
 */