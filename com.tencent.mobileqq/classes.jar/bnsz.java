import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnsz
  implements View.OnClickListener
{
  bnsz(bnss parambnss) {}
  
  public void onClick(View paramView)
  {
    bnss.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsz
 * JD-Core Version:    0.7.0.1
 */