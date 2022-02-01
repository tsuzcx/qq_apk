import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class axlw
  implements View.OnClickListener
{
  axlw(axlu paramaxlu) {}
  
  public void onClick(View paramView)
  {
    axlu.a(this.a).a.clear();
    axlu.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlw
 * JD-Core Version:    0.7.0.1
 */