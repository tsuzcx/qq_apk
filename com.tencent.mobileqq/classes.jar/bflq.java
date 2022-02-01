import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bflq
  implements View.OnClickListener
{
  bflq(bfll parambfll) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (bfll.a(this.a) == null) || (bfll.a(this.a).a == null) || (bfll.a(this.a) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView.getTag() instanceof bfkl))
      {
        bfll.a(this.a).a(paramView);
        bfll.a(this.a).b(paramView, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflq
 * JD-Core Version:    0.7.0.1
 */