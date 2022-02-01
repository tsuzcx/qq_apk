import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azha
  implements View.OnClickListener
{
  azha(azgy paramazgy) {}
  
  public void onClick(View paramView)
  {
    this.a.a = 3;
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azha
 * JD-Core Version:    0.7.0.1
 */