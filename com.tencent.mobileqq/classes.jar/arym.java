import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arym
  implements View.OnClickListener
{
  public arym(QfileFavPicFileTabView paramQfileFavPicFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileFavPicFileTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arym
 * JD-Core Version:    0.7.0.1
 */