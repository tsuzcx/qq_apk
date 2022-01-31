import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class avrg
  extends avsc
{
  public avrg(azwg paramazwg)
  {
    super(paramazwg, 268435456);
  }
  
  public void a(avol paramavol, avwv paramavwv)
  {
    Object localObject1 = (avom)paramavol;
    paramavol = ((avwt)paramavwv).a();
    if (paramavol != null)
    {
      List localList = ((avom)localObject1).a();
      if (localList != null)
      {
        paramavol.removeAllViews();
        int j = Math.min(localList.size(), ((avom)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new avye(((avwt)paramavwv).a(), 268435456);
          Object localObject2 = ((avye)localObject1).a();
          avon localavon = (avon)localList.get(i);
          ((View)localObject2).setTag(2131313373, localavon);
          ((View)localObject2).setTag(2131313378, localObject1);
          ((View)localObject2).setTag(2131313374, Integer.valueOf(i));
          ((View)localObject2).setTag(2131313372, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131313375, this.a);
          if ((localavon instanceof avnl)) {
            avwi.a((avnl)localavon, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          paramavol.addView(((avye)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localavon, (avwx)localObject1);
          i += 1;
        }
      }
    }
    if (paramavwv.b() != null) {
      paramavwv.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrg
 * JD-Core Version:    0.7.0.1
 */