import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ayml
  extends ayna
{
  public ayml(bcws parambcws)
  {
    super(parambcws);
  }
  
  protected aymf<ayjl, ayru> a(bcws parambcws)
  {
    return new aymm(parambcws);
  }
  
  public void a(ayjj paramayjj, ayrt paramayrt)
  {
    paramayjj = (ayjk)paramayjj;
    LinearLayout localLinearLayout = ((ayry)paramayrt).a();
    List localList;
    int k;
    int i;
    ayjh localayjh;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = paramayjj.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          paramayjj = (ayjl)localList.get(i);
          if ((paramayjj instanceof ayjh))
          {
            localayjh = (ayjh)paramayjj;
            localObject2 = null;
            if (aykw.a(localayjh.e()) == 1)
            {
              localObject2 = LayoutInflater.from(paramayrt.a().getContext()).inflate(2131562586, null);
              paramayjj = ((View)localObject2).findViewById(2131368472);
              localObject1 = new ayro((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (paramayjj != null))
      {
        ((View)localObject2).setTag(2131379913, localayjh);
        ((View)localObject2).setTag(2131379918, localObject1);
        ((View)localObject2).setTag(2131379914, Integer.valueOf(i));
        ((View)localObject2).setTag(2131379912, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131379915, this.a);
        ayrg.a(localayjh, k, i);
        int m = localayjh.a();
        int n = localayjh.b();
        if ((localayjh instanceof ayjm))
        {
          j = localayjh.r;
          label240:
          ayrg.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localayjh, (ayrv)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (aykw.a(localayjh.e()) != 2) {
          break label538;
        }
        localObject2 = LayoutInflater.from(paramayrt.a().getContext()).inflate(2131562593, null);
        paramayjj = ((View)localObject2).findViewById(2131368472);
        localObject1 = new ayrx((View)localObject2);
        break label137;
        j = 0;
        break label240;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localayjh.e());
        continue;
        if ((paramayjj instanceof ayij))
        {
          paramayjj = (ayij)paramayjj;
          localObject1 = new aytc(localLinearLayout, paramayjj.d());
          localObject2 = ((aytc)localObject1).a();
          ((View)localObject2).setTag(2131379913, paramayjj);
          ((View)localObject2).setTag(2131379918, localObject1);
          ((View)localObject2).setTag(2131379914, Integer.valueOf(i));
          ((View)localObject2).setTag(2131379912, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131379915, this.a);
          ayrg.a(paramayjj, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((aytc)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(paramayjj, (ayrv)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (paramayrt.b() != null) {
        paramayrt.b().setVisibility(8);
      }
      return;
      label538:
      paramayjj = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayml
 * JD-Core Version:    0.7.0.1
 */