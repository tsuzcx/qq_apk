import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

class bdaw
  implements View.OnClickListener
{
  bdaw(bdav parambdav) {}
  
  public void onClick(View paramView)
  {
    bdav.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdaw
 * JD-Core Version:    0.7.0.1
 */