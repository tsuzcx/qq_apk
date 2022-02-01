import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asab
  implements View.OnClickListener
{
  public asab(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    asao localasao = (asao)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localasao.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      aszt.b(localFileManagerEntity);
    }
    switch (localasao.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.i();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.a.a.a().aa();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          aszk.a(2131692367);
        }
        else if (localFileManagerEntity.status == 16)
        {
          aszk.a(2131692520);
        }
        else
        {
          asyq.a(localFileManagerEntity).a(false, this.a.getContext(), new asac(this, localFileManagerEntity));
          break;
          this.a.a.a().Z();
          this.a.a(localFileManagerEntity, localasao.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
          break;
          this.a.a.a().ab();
          if (localFileManagerEntity.getCloudType() == 0)
          {
            QfileBaseRecentFileTabView.w(this.a).getOnlineFileSessionCenter().a(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((amqd)QfileBaseRecentFileTabView.x(this.a).getBusinessHandler(8)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          QfileBaseRecentFileTabView.y(this.a).getFileManagerEngine().a(localFileManagerEntity.nSessionId);
          break;
          this.a.a.a().ac();
          if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
          {
            aszk.a(2131692367);
          }
          else
          {
            if (localFileManagerEntity.status != 16) {
              break label344;
            }
            aszk.a(2131692520);
          }
        }
      }
      label344:
      boolean bool = localFileManagerEntity.isSend();
      asyq.a(localFileManagerEntity).a(bool, this.a.a, new asad(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asab
 * JD-Core Version:    0.7.0.1
 */