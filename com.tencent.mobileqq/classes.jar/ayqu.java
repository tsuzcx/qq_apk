import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ayqu
  extends ayrj
{
  public ayqu(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  protected ayqo<aynu, aywd> a(bdbb parambdbb)
  {
    return new ayqv(parambdbb);
  }
  
  public void a(ayns paramayns, aywc paramaywc)
  {
    paramayns = (aynt)paramayns;
    LinearLayout localLinearLayout = ((aywh)paramaywc).a();
    List localList;
    int k;
    int i;
    aynq localaynq;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = paramayns.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          paramayns = (aynu)localList.get(i);
          if ((paramayns instanceof aynq))
          {
            localaynq = (aynq)paramayns;
            localObject2 = null;
            if (aypf.a(localaynq.e()) == 1)
            {
              localObject2 = LayoutInflater.from(paramaywc.a().getContext()).inflate(2131562604, null);
              paramayns = ((View)localObject2).findViewById(2131368483);
              localObject1 = new ayvx((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (paramayns != null))
      {
        ((View)localObject2).setTag(2131379971, localaynq);
        ((View)localObject2).setTag(2131379976, localObject1);
        ((View)localObject2).setTag(2131379972, Integer.valueOf(i));
        ((View)localObject2).setTag(2131379970, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131379973, this.a);
        ayvp.a(localaynq, k, i);
        int m = localaynq.a();
        int n = localaynq.b();
        if ((localaynq instanceof aynv))
        {
          j = localaynq.r;
          label240:
          ayvp.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localaynq, (aywe)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (aypf.a(localaynq.e()) != 2) {
          break label538;
        }
        localObject2 = LayoutInflater.from(paramaywc.a().getContext()).inflate(2131562611, null);
        paramayns = ((View)localObject2).findViewById(2131368483);
        localObject1 = new aywg((View)localObject2);
        break label137;
        j = 0;
        break label240;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localaynq.e());
        continue;
        if ((paramayns instanceof ayms))
        {
          paramayns = (ayms)paramayns;
          localObject1 = new ayxl(localLinearLayout, paramayns.d());
          localObject2 = ((ayxl)localObject1).a();
          ((View)localObject2).setTag(2131379971, paramayns);
          ((View)localObject2).setTag(2131379976, localObject1);
          ((View)localObject2).setTag(2131379972, Integer.valueOf(i));
          ((View)localObject2).setTag(2131379970, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131379973, this.a);
          ayvp.a(paramayns, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((ayxl)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(paramayns, (aywe)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (paramaywc.b() != null) {
        paramaywc.b().setVisibility(8);
      }
      return;
      label538:
      paramayns = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqu
 * JD-Core Version:    0.7.0.1
 */