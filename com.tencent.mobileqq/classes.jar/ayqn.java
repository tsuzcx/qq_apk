import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class ayqn
  extends ayrj
{
  public ayqn(bdbb parambdbb)
  {
    super(parambdbb, 268435456);
  }
  
  public void a(ayns paramayns, aywc paramaywc)
  {
    Object localObject1 = (aynt)paramayns;
    paramayns = ((aywa)paramaywc).a();
    if (paramayns != null)
    {
      List localList = ((aynt)localObject1).a();
      if (localList != null)
      {
        paramayns.removeAllViews();
        int j = Math.min(localList.size(), ((aynt)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new ayxl(((aywa)paramaywc).a(), 268435456);
          Object localObject2 = ((ayxl)localObject1).a();
          aynu localaynu = (aynu)localList.get(i);
          ((View)localObject2).setTag(2131379971, localaynu);
          ((View)localObject2).setTag(2131379976, localObject1);
          ((View)localObject2).setTag(2131379972, Integer.valueOf(i));
          ((View)localObject2).setTag(2131379970, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131379973, this.a);
          if ((localaynu instanceof ayms)) {
            ayvp.a((ayms)localaynu, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          paramayns.addView(((ayxl)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localaynu, (aywe)localObject1);
          i += 1;
        }
      }
    }
    if (paramaywc.b() != null) {
      paramaywc.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqn
 * JD-Core Version:    0.7.0.1
 */