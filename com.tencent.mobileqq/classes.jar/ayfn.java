import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayfn
  implements View.OnClickListener
{
  public ayfn(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    this.a.j();
    ShortVideoCommentsView.a(this.a).setVisibility(8);
    ShortVideoCommentsView.a(this.a, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfn
 * JD-Core Version:    0.7.0.1
 */