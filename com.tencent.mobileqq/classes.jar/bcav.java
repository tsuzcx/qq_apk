import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.MixSearchWebFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcav
  implements View.OnClickListener
{
  public bcav(MixSearchWebFragment paramMixSearchWebFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a(3);
    this.a.doOnBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcav
 * JD-Core Version:    0.7.0.1
 */