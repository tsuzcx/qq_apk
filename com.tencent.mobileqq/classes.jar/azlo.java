import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azlo
  implements View.OnClickListener
{
  azlo(azlk paramazlk) {}
  
  public void onClick(View paramView)
  {
    azlk.c(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlo
 * JD-Core Version:    0.7.0.1
 */