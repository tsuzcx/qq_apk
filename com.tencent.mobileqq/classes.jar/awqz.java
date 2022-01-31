import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class awqz
  extends awrv
{
  public awqz(baxk parambaxk)
  {
    super(parambaxk, 268435456);
  }
  
  public void a(awoe paramawoe, awwo paramawwo)
  {
    Object localObject1 = (awof)paramawoe;
    paramawoe = ((awwm)paramawwo).a();
    if (paramawoe != null)
    {
      List localList = ((awof)localObject1).a();
      if (localList != null)
      {
        paramawoe.removeAllViews();
        int j = Math.min(localList.size(), ((awof)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new awxx(((awwm)paramawwo).a(), 268435456);
          Object localObject2 = ((awxx)localObject1).a();
          awog localawog = (awog)localList.get(i);
          ((View)localObject2).setTag(2131379208, localawog);
          ((View)localObject2).setTag(2131379213, localObject1);
          ((View)localObject2).setTag(2131379209, Integer.valueOf(i));
          ((View)localObject2).setTag(2131379207, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131379210, this.a);
          if ((localawog instanceof awne)) {
            awwb.a((awne)localawog, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          paramawoe.addView(((awxx)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localawog, (awwq)localObject1);
          i += 1;
        }
      }
    }
    if (paramawwo.b() != null) {
      paramawwo.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqz
 * JD-Core Version:    0.7.0.1
 */