import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asxo
  implements View.OnClickListener
{
  public asxo(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    asyb localasyb = (asyb)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localasyb.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      atvo.b(localFileManagerEntity);
    }
    switch (localasyb.jdField_a_of_type_Int)
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
        if (!bgnt.d(BaseApplication.getContext()))
        {
          atvf.a(2131692314);
        }
        else if (localFileManagerEntity.status == 16)
        {
          atvf.a(2131692466);
        }
        else
        {
          atul.a(localFileManagerEntity).a(false, this.a.getContext(), new asxp(this, localFileManagerEntity));
          break;
          this.a.a.a().Z();
          this.a.a(localFileManagerEntity, localasyb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
          break;
          this.a.a.a().ab();
          if (localFileManagerEntity.getCloudType() == 0)
          {
            QfileBaseRecentFileTabView.w(this.a).a().a(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((anjx)QfileBaseRecentFileTabView.x(this.a).a(8)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          QfileBaseRecentFileTabView.y(this.a).a().a(localFileManagerEntity.nSessionId);
          break;
          this.a.a.a().ac();
          if (!bgnt.d(BaseApplication.getContext()))
          {
            atvf.a(2131692314);
          }
          else
          {
            if (localFileManagerEntity.status != 16) {
              break label344;
            }
            atvf.a(2131692466);
          }
        }
      }
      label344:
      boolean bool = localFileManagerEntity.isSend();
      atul.a(localFileManagerEntity).a(bool, this.a.a, new asxq(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxo
 * JD-Core Version:    0.7.0.1
 */