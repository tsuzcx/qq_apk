import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnnv
  implements View.OnClickListener
{
  bnnv(bnnu parambnnu) {}
  
  public void onClick(View paramView)
  {
    bnnu.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnv
 * JD-Core Version:    0.7.0.1
 */