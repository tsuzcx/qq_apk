import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

public class aqob
  implements View.OnClickListener
{
  public aqob(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int i;
    if ((localObject instanceof aqon))
    {
      localObject = (aqon)paramView.getTag();
      i = ((aqon)localObject).c;
      localObject = (WeiYunFileInfo)((aqon)localObject).a;
    }
    for (;;)
    {
      QfileBaseCloudFileTabView localQfileBaseCloudFileTabView;
      if (localObject != null)
      {
        if ((paramView.getId() == 2131366301) && (QfileBaseCloudFileTabView.c(this.a))) {
          azqs.b(QfileBaseCloudFileTabView.c(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        localQfileBaseCloudFileTabView = this.a;
        if (paramView.getId() != 2131366301) {
          break label148;
        }
      }
      label148:
      for (boolean bool = true;; bool = false)
      {
        localQfileBaseCloudFileTabView.a((WeiYunFileInfo)localObject, i, bool);
        return;
        if (!(localObject instanceof aqnh)) {
          break label153;
        }
        localObject = (WeiYunFileInfo)((aqnh)paramView.getTag()).a;
        i = -1;
        break;
      }
      label153:
      i = 0;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqob
 * JD-Core Version:    0.7.0.1
 */