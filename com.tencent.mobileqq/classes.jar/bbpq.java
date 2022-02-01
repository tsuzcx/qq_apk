import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class bbpq
  extends bbqm
{
  public bbpq(aobu paramaobu)
  {
    super(paramaobu, 268435456);
  }
  
  public void a(bbmw parambbmw, bbvf parambbvf)
  {
    Object localObject1 = (bbmx)parambbmw;
    parambbmw = ((bbvd)parambbvf).a();
    if (parambbmw != null)
    {
      List localList = ((bbmx)localObject1).a();
      if (localList != null)
      {
        parambbmw.removeAllViews();
        int j = Math.min(localList.size(), ((bbmx)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new bbwo(((bbvd)parambbvf).a(), 268435456);
          Object localObject2 = ((bbwo)localObject1).a();
          bbmy localbbmy = (bbmy)localList.get(i);
          ((View)localObject2).setTag(2131380929, localbbmy);
          ((View)localObject2).setTag(2131380935, localObject1);
          ((View)localObject2).setTag(2131380930, Integer.valueOf(i));
          ((View)localObject2).setTag(2131380928, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131380931, this.a);
          if ((localbbmy instanceof bblw)) {
            bbus.a((bblw)localbbmy, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          parambbmw.addView(((bbwo)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localbbmy, (bbvh)localObject1);
          i += 1;
        }
      }
    }
    if (parambbvf.b() != null) {
      parambbvf.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpq
 * JD-Core Version:    0.7.0.1
 */