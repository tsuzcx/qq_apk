import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class au
  implements View.OnClickListener
{
  public au(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    afur.n = true;
    ek localek = (ek)paramView.getTag();
    this.a.b(localek);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     au
 * JD-Core Version:    0.7.0.1
 */