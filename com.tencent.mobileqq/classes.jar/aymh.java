import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class aymh
  extends ayna
{
  public aymh(bcws parambcws)
  {
    super(parambcws);
  }
  
  protected aymf<ayjl, ayru> a(bcws parambcws)
  {
    return new aymi(parambcws);
  }
  
  public void a(ayjj paramayjj, ayrt paramayrt)
  {
    Object localObject = (ayjk)paramayjj;
    paramayjj = ((ayrw)paramayrt).a();
    if (paramayjj != null)
    {
      List localList = ((ayjk)localObject).a();
      if (localList != null)
      {
        paramayjj.removeAllViews();
        int k = Math.min(localList.size(), ((ayjk)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (ayjl)localList.get(i);
          View localView = LayoutInflater.from(paramayrt.a().getContext()).inflate(2131562593, null);
          ayrx localayrx = new ayrx(localView);
          localView.setTag(2131379913, localObject);
          localView.setTag(2131379918, localayrx);
          localView.setTag(2131379914, Integer.valueOf(i));
          localView.setTag(2131379912, Integer.valueOf(localList.size()));
          localView.setTag(2131379915, this.a);
          ayrg.a((ayjl)localObject, k, i);
          int m = ((ayjl)localObject).a();
          int n = ((ayjl)localObject).b();
          if ((localObject instanceof ayjm)) {}
          for (int j = ((ayjm)localObject).r;; j = 0)
          {
            ayrg.a(m, n, localView, j);
            paramayjj.addView(localView);
            this.a.a((ayjj)localObject, localayrx);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramayrt.b() != null) {
      paramayrt.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymh
 * JD-Core Version:    0.7.0.1
 */