import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class at
  implements View.OnClickListener
{
  public at(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    ek localek = (ek)((ek)paramView.getTag()).clone();
    this.a.a(localek);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     at
 * JD-Core Version:    0.7.0.1
 */