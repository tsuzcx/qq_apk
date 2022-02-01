import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ateh
  implements View.OnClickListener
{
  public ateh(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    ateu localateu = (ateu)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localateu.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      auea.b(localFileManagerEntity);
    }
    switch (localateu.jdField_a_of_type_Int)
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
          audr.a(2131692469);
        }
        else if (localFileManagerEntity.status == 16)
        {
          audr.a(2131692622);
        }
        else
        {
          aucx.a(localFileManagerEntity).a(false, this.a.getContext(), new atei(this, localFileManagerEntity));
          break;
          this.a.a.a().Z();
          this.a.a(localFileManagerEntity, localateu.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
          break;
          this.a.a.a().ab();
          if (localFileManagerEntity.getCloudType() == 0)
          {
            QfileBaseRecentFileTabView.w(this.a).getOnlineFileSessionCenter().a(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((ansr)QfileBaseRecentFileTabView.x(this.a).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          QfileBaseRecentFileTabView.y(this.a).getFileManagerEngine().a(localFileManagerEntity.nSessionId);
          break;
          this.a.a.a().ac();
          if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
          {
            audr.a(2131692469);
          }
          else
          {
            if (localFileManagerEntity.status != 16) {
              break label345;
            }
            audr.a(2131692622);
          }
        }
      }
      label345:
      boolean bool = localFileManagerEntity.isSend();
      aucx.a(localFileManagerEntity).a(bool, this.a.a, new atej(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ateh
 * JD-Core Version:    0.7.0.1
 */