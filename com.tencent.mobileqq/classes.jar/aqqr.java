import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

public class aqqr
  implements View.OnClickListener
{
  public aqqr(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    paramView = (aqqz)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      arrr.c(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.i();
      return;
      this.a.a.a().ac();
      if (!bdin.d(BaseApplication.getContext()))
      {
        arri.a(2131692747);
        return;
      }
      if (localFileManagerEntity.status == 16)
      {
        arri.a(2131692941);
        return;
      }
      arqo.a(localFileManagerEntity).a(false, this.a.getContext(), new aqqs(this, localFileManagerEntity));
      continue;
      this.a.a.a().ab();
      this.a.a(localFileManagerEntity, paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
      continue;
      this.a.a.a().ad();
      if (localFileManagerEntity.getCloudType() == 0)
      {
        QfileBaseRecentFileTabView.w(this.a).a().a(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        ((alqo)QfileBaseRecentFileTabView.x(this.a).a(8)).a(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        QfileBaseRecentFileTabView.y(this.a).a().a(localFileManagerEntity.nSessionId);
        continue;
        this.a.a.a().ae();
        if (!bdin.d(BaseApplication.getContext()))
        {
          arri.a(2131692747);
          return;
        }
        if (localFileManagerEntity.status == 16)
        {
          arri.a(2131692941);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        arqo.a(localFileManagerEntity).a(bool, this.a.a, new aqqt(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqr
 * JD-Core Version:    0.7.0.1
 */