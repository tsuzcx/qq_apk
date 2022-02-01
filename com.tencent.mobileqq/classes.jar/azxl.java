import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azxl
  implements View.OnClickListener
{
  azxl(azxh paramazxh) {}
  
  public void onClick(View paramView)
  {
    azxh.c(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxl
 * JD-Core Version:    0.7.0.1
 */