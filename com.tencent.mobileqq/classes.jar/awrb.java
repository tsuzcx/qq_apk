import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class awrb
  extends awrx
{
  public awrb(baxy parambaxy)
  {
    super(parambaxy, 268435456);
  }
  
  public void a(awog paramawog, awwq paramawwq)
  {
    Object localObject1 = (awoh)paramawog;
    paramawog = ((awwo)paramawwq).a();
    if (paramawog != null)
    {
      List localList = ((awoh)localObject1).a();
      if (localList != null)
      {
        paramawog.removeAllViews();
        int j = Math.min(localList.size(), ((awoh)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new awxz(((awwo)paramawwq).a(), 268435456);
          Object localObject2 = ((awxz)localObject1).a();
          awoi localawoi = (awoi)localList.get(i);
          ((View)localObject2).setTag(2131379213, localawoi);
          ((View)localObject2).setTag(2131379218, localObject1);
          ((View)localObject2).setTag(2131379214, Integer.valueOf(i));
          ((View)localObject2).setTag(2131379212, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131379215, this.a);
          if ((localawoi instanceof awng)) {
            awwd.a((awng)localawoi, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          paramawog.addView(((awxz)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localawoi, (awws)localObject1);
          i += 1;
        }
      }
    }
    if (paramawwq.b() != null) {
      paramawwq.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrb
 * JD-Core Version:    0.7.0.1
 */