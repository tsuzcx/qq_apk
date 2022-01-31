import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class ayme
  extends ayna
{
  public ayme(bcws parambcws)
  {
    super(parambcws, 268435456);
  }
  
  public void a(ayjj paramayjj, ayrt paramayrt)
  {
    Object localObject1 = (ayjk)paramayjj;
    paramayjj = ((ayrr)paramayrt).a();
    if (paramayjj != null)
    {
      List localList = ((ayjk)localObject1).a();
      if (localList != null)
      {
        paramayjj.removeAllViews();
        int j = Math.min(localList.size(), ((ayjk)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new aytc(((ayrr)paramayrt).a(), 268435456);
          Object localObject2 = ((aytc)localObject1).a();
          ayjl localayjl = (ayjl)localList.get(i);
          ((View)localObject2).setTag(2131379913, localayjl);
          ((View)localObject2).setTag(2131379918, localObject1);
          ((View)localObject2).setTag(2131379914, Integer.valueOf(i));
          ((View)localObject2).setTag(2131379912, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131379915, this.a);
          if ((localayjl instanceof ayij)) {
            ayrg.a((ayij)localayjl, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          paramayjj.addView(((aytc)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localayjl, (ayrv)localObject1);
          i += 1;
        }
      }
    }
    if (paramayrt.b() != null) {
      paramayrt.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayme
 * JD-Core Version:    0.7.0.1
 */