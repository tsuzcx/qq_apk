import android.view.View;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.LayoutParams;
import java.util.Comparator;

public class awtf
  implements Comparator<View>
{
  public int a(View paramView1, View paramView2)
  {
    paramView1 = (MultiAIOBaseViewPager.LayoutParams)paramView1.getLayoutParams();
    paramView2 = (MultiAIOBaseViewPager.LayoutParams)paramView2.getLayoutParams();
    if (paramView1.a != paramView2.a)
    {
      if (paramView1.a) {
        return 1;
      }
      return -1;
    }
    return paramView1.b - paramView2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtf
 * JD-Core Version:    0.7.0.1
 */