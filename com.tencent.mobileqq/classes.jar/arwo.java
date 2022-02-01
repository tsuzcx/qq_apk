import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arwo
  implements View.OnClickListener
{
  public arwo(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int i;
    if ((localObject instanceof arxa))
    {
      localObject = (arxa)paramView.getTag();
      i = ((arxa)localObject).c;
      localObject = (WeiYunFileInfo)((arxa)localObject).a;
    }
    for (;;)
    {
      QfileBaseCloudFileTabView localQfileBaseCloudFileTabView;
      if (localObject != null)
      {
        if ((paramView.getId() == 2131366631) && (QfileBaseCloudFileTabView.c(this.a))) {
          bcef.b(QfileBaseCloudFileTabView.c(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        localQfileBaseCloudFileTabView = this.a;
        if (paramView.getId() != 2131366631) {
          break label155;
        }
      }
      label155:
      for (boolean bool = true;; bool = false)
      {
        localQfileBaseCloudFileTabView.a((WeiYunFileInfo)localObject, i, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject instanceof arvu)) {
          break label160;
        }
        localObject = (WeiYunFileInfo)((arvu)paramView.getTag()).a;
        i = -1;
        break;
      }
      label160:
      i = 0;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwo
 * JD-Core Version:    0.7.0.1
 */