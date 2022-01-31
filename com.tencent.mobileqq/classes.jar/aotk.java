import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

public class aotk
  implements View.OnClickListener
{
  public aotk(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    paramView = (aots)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      apug.c(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.i();
      return;
      this.a.a.a().ac();
      if (!bbfj.d(BaseApplication.getContext()))
      {
        aptx.a(2131692666);
        return;
      }
      if (localFileManagerEntity.status == 16)
      {
        aptx.a(2131692857);
        return;
      }
      aptd.a(localFileManagerEntity).a(false, this.a.getContext(), new aotl(this, localFileManagerEntity));
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
        ((ajum)QfileBaseRecentFileTabView.x(this.a).a(8)).a(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        QfileBaseRecentFileTabView.y(this.a).a().a(localFileManagerEntity.nSessionId);
        continue;
        this.a.a.a().ae();
        if (!bbfj.d(BaseApplication.getContext()))
        {
          aptx.a(2131692666);
          return;
        }
        if (localFileManagerEntity.status == 16)
        {
          aptx.a(2131692857);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        aptd.a(localFileManagerEntity).a(bool, this.a.a, new aotm(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotk
 * JD-Core Version:    0.7.0.1
 */