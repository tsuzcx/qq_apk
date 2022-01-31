import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

final class arbu
  implements View.OnClickListener
{
  arbu(FileManagerEntity paramFileManagerEntity, ardn paramardn) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      int i = arni.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if ((i == 1) || (i == 2) || (i == 4)) {
        new biqt(3).a(paramView, BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, null, false);
      }
      while ((this.jdField_a_of_type_Ardn != null) && (this.jdField_a_of_type_Ardn.b()))
      {
        this.jdField_a_of_type_Ardn.a(3);
        arni.a(paramView, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) && (arof.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())))
        {
          biqt.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()).a(paramView).a(BaseActivity.sTopActivity, paramView.getAccount());
          birh.a(paramView, 7, 3);
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("FileOperaterUtils", 2, "FileVideoMediaPlayHelperthis is a local file, but favorite fail. [Uuid] = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid + " [status] = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + " [fileType] = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType);
        }
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbu
 * JD-Core Version:    0.7.0.1
 */