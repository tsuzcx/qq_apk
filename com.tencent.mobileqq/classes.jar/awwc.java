import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awwc
  implements View.OnClickListener
{
  awwc(awwb paramawwb) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (StartLiveTopicLabelListView.a(this.a.a) != null) {
        StartLiveTopicLabelListView.a(this.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwc
 * JD-Core Version:    0.7.0.1
 */