import android.view.View;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.LayoutParams;

public class auhk
  extends auhs
{
  private final MultiAIOBaseViewPager a;
  
  public auhk(MultiAIOBaseViewPager paramMultiAIOBaseViewPager)
  {
    this.a = paramMultiAIOBaseViewPager;
  }
  
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
    int i = this.a.a();
    if (i == paramView1.b) {
      return 1;
    }
    if (i == paramView2.b) {
      return -1;
    }
    return paramView1.b - paramView2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auhk
 * JD-Core Version:    0.7.0.1
 */