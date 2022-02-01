import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awuf
  implements View.OnClickListener
{
  awuf(awud paramawud) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuf
 * JD-Core Version:    0.7.0.1
 */