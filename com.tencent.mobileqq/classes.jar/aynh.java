import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aynh
  implements View.OnClickListener
{
  aynh(aymj paramaymj) {}
  
  public void onClick(View paramView)
  {
    aymj.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynh
 * JD-Core Version:    0.7.0.1
 */