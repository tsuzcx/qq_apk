import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atns
  implements View.OnClickListener
{
  public atns(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    atof localatof = (atof)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localatof.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      aunj.b(localFileManagerEntity);
    }
    switch (localatof.jdField_a_of_type_Int)
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
        if (!bhnv.d(BaseApplication.getContext()))
        {
          auna.a(2131692319);
        }
        else if (localFileManagerEntity.status == 16)
        {
          auna.a(2131692472);
        }
        else
        {
          aumg.a(localFileManagerEntity).a(false, this.a.getContext(), new atnt(this, localFileManagerEntity));
          break;
          this.a.a.a().Z();
          this.a.a(localFileManagerEntity, localatof.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
          break;
          this.a.a.a().ab();
          if (localFileManagerEntity.getCloudType() == 0)
          {
            QfileBaseRecentFileTabView.w(this.a).a().a(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((anvu)QfileBaseRecentFileTabView.x(this.a).a(8)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          QfileBaseRecentFileTabView.y(this.a).a().a(localFileManagerEntity.nSessionId);
          break;
          this.a.a.a().ac();
          if (!bhnv.d(BaseApplication.getContext()))
          {
            auna.a(2131692319);
          }
          else
          {
            if (localFileManagerEntity.status != 16) {
              break label344;
            }
            auna.a(2131692472);
          }
        }
      }
      label344:
      boolean bool = localFileManagerEntity.isSend();
      aumg.a(localFileManagerEntity).a(bool, this.a.a, new atnu(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atns
 * JD-Core Version:    0.7.0.1
 */