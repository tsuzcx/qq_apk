import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bier
  implements View.OnClickListener
{
  bier(bieo parambieo) {}
  
  public void onClick(View paramView)
  {
    this.a.setWarnToastVisible(false, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bier
 * JD-Core Version:    0.7.0.1
 */