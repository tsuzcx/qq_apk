import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class audd
  implements View.OnClickListener
{
  audd(FileManagerEntity paramFileManagerEntity, auef paramauef) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        int i = aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if ((i != 1) && (i != 2) && (i != 4)) {
          continue;
        }
        new bmko(3).a(localQQAppInterface, BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, null, false);
        if ((this.jdField_a_of_type_Auef != null) && (this.jdField_a_of_type_Auef.c()))
        {
          this.jdField_a_of_type_Auef.a(3);
          aunj.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        }
      }
      catch (Exception localException)
      {
        QQAppInterface localQQAppInterface;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) && (auog.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())))
      {
        bmko.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()).a(localQQAppInterface).a(BaseActivity.sTopActivity, localQQAppInterface.getAccount());
        bmky.a(localQQAppInterface, 7, 3);
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("FileOperaterUtils", 2, "FileVideoMediaPlayHelperthis is a local file, but favorite fail. [Uuid] = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid + " [status] = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + " [fileType] = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audd
 * JD-Core Version:    0.7.0.1
 */