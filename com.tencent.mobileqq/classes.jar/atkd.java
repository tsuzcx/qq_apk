import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atkd
  implements View.OnClickListener
{
  atkd(atkc paramatkc, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof atjl))
    {
      localObject = (WeiYunFileInfo)((atjl)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if ((atyw.a(((WeiYunFileInfo)localObject).a)) && (QLog.isColorLevel())) {
        QLog.d(QfileBaseCloudFileTabView.b, 2, "there is a bug ");
      }
      QfileBaseCloudFileTabView.b(this.jdField_a_of_type_Atkc.a).a().a((WeiYunFileInfo)localObject);
      this.jdField_a_of_type_Atkc.a.aw_();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof atkr))
      {
        localObject = (WeiYunFileInfo)((atkr)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseCloudFileTabView.b, 2, "unknow Object");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkd
 * JD-Core Version:    0.7.0.1
 */