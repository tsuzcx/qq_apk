import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aryn
  implements View.OnClickListener
{
  public aryn(QfileFavPicFileTabView paramQfileFavPicFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileFavPicFileTabView.a(this.a, paramView, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryn
 * JD-Core Version:    0.7.0.1
 */