import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bglr
  implements View.OnClickListener
{
  bglr(bglm parambglm) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (bglm.a(this.a) == null) || (bglm.a(this.a).a == null) || (bglm.a(this.a) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView.getTag() instanceof bgkm))
      {
        bglm.a(this.a).a(paramView);
        bglm.a(this.a).b(paramView, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglr
 * JD-Core Version:    0.7.0.1
 */