import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arwx
  implements View.OnClickListener
{
  public arwx(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseCloudFileTabView.b, 2, "qfilebaserecenttabview del error, tag is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramView.getTag();
      if (localWeiYunFileInfo != null)
      {
        if (this.a.a != null) {
          this.a.a.a(null);
        }
        QfileBaseCloudFileTabView.a(this.a).getFileManagerEngine().a(localWeiYunFileInfo);
      }
      this.a.a.a(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.a.setListFooter();
      this.a.al_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwx
 * JD-Core Version:    0.7.0.1
 */