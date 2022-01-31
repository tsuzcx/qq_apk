import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

public class anzw
  implements View.OnClickListener
{
  public anzw(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int i;
    if ((localObject instanceof aoai))
    {
      localObject = (aoai)paramView.getTag();
      i = ((aoai)localObject).c;
      localObject = (WeiYunFileInfo)((aoai)localObject).a;
    }
    for (;;)
    {
      QfileBaseCloudFileTabView localQfileBaseCloudFileTabView;
      if (localObject != null)
      {
        if ((paramView.getId() == 2131300609) && (QfileBaseCloudFileTabView.c(this.a))) {
          awqx.b(QfileBaseCloudFileTabView.c(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        localQfileBaseCloudFileTabView = this.a;
        if (paramView.getId() != 2131300609) {
          break label148;
        }
      }
      label148:
      for (boolean bool = true;; bool = false)
      {
        localQfileBaseCloudFileTabView.a((WeiYunFileInfo)localObject, i, bool);
        return;
        if (!(localObject instanceof anzc)) {
          break label153;
        }
        localObject = (WeiYunFileInfo)((anzc)paramView.getTag()).a;
        i = -1;
        break;
      }
      label153:
      i = 0;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anzw
 * JD-Core Version:    0.7.0.1
 */