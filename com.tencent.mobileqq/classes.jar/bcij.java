import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class bcij
  extends bcjf
{
  public bcij(aoof paramaoof)
  {
    super(paramaoof, 268435456);
  }
  
  public void a(bcfp parambcfp, bcny parambcny)
  {
    Object localObject1 = (bcfq)parambcfp;
    parambcfp = ((bcnw)parambcny).a();
    if (parambcfp != null)
    {
      List localList = ((bcfq)localObject1).a();
      if (localList != null)
      {
        parambcfp.removeAllViews();
        int j = Math.min(localList.size(), ((bcfq)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new bcph(((bcnw)parambcny).a(), 268435456);
          Object localObject2 = ((bcph)localObject1).a();
          bcfr localbcfr = (bcfr)localList.get(i);
          ((View)localObject2).setTag(2131381109, localbcfr);
          ((View)localObject2).setTag(2131381115, localObject1);
          ((View)localObject2).setTag(2131381110, Integer.valueOf(i));
          ((View)localObject2).setTag(2131381108, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131381111, this.a);
          if ((localbcfr instanceof bcep)) {
            bcnl.a((bcep)localbcfr, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          parambcfp.addView(((bcph)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localbcfr, (bcoa)localObject1);
          i += 1;
        }
      }
    }
    if (parambcny.b() != null) {
      parambcny.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcij
 * JD-Core Version:    0.7.0.1
 */