import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avuw
  implements View.OnClickListener
{
  public avuw(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.hotpic.HotPicPageView.b = true;
    if (this.a.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a(3, paramView);
      QLog.d("HotVideoRelativeLayout", 2, "click mute view");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuw
 * JD-Core Version:    0.7.0.1
 */