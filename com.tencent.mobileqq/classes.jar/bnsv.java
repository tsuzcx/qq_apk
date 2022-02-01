import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnsv
  implements View.OnClickListener
{
  bnsv(bnss parambnss) {}
  
  public void onClick(View paramView)
  {
    bnyh.a().ad();
    bnss.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsv
 * JD-Core Version:    0.7.0.1
 */