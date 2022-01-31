import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;

public class aoqy
  implements View.OnClickListener
{
  public aoqy(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseCloudFileTabView.b, 2, "qfilebaserecenttabview del error, tag is null");
      }
      return;
    }
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramView.getTag();
    if (localWeiYunFileInfo != null)
    {
      if (this.a.a != null) {
        this.a.a.a(null);
      }
      QfileBaseCloudFileTabView.a(this.a).a().a(localWeiYunFileInfo);
    }
    this.a.a.a(Integer.valueOf(-1));
    paramView.setVisibility(4);
    this.a.setListFooter();
    this.a.au_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqy
 * JD-Core Version:    0.7.0.1
 */