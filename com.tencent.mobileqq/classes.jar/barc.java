import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class barc
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    barb.a(paramView.getContext(), (String)paramView.getTag());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     barc
 * JD-Core Version:    0.7.0.1
 */