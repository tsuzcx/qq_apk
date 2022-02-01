import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aryd
  implements View.OnClickListener
{
  public aryd(QfileFavFileTabView paramQfileFavFileTabView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof arxt)) {}
    for (FavFileInfo localFavFileInfo = (FavFileInfo)((arxt)paramView.getTag()).a;; localFavFileInfo = null)
    {
      QfileFavFileTabView localQfileFavFileTabView;
      if (localFavFileInfo != null)
      {
        localQfileFavFileTabView = this.a;
        if (paramView.getId() != 2131366631) {
          break label60;
        }
      }
      label60:
      for (boolean bool = true;; bool = false)
      {
        localQfileFavFileTabView.a(localFavFileInfo, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryd
 * JD-Core Version:    0.7.0.1
 */