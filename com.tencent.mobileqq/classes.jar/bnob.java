import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnob
  implements View.OnClickListener
{
  bnob(bnnu parambnnu) {}
  
  public void onClick(View paramView)
  {
    bnnu.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnob
 * JD-Core Version:    0.7.0.1
 */