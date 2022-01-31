import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

final class apiw
  implements View.OnClickListener
{
  apiw(FileManagerEntity paramFileManagerEntity, Activity paramActivity, apkq paramapkq) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      apuf localapuf = new apuf();
      localapuf.b = "file_forward";
      localapuf.jdField_a_of_type_Int = 71;
      localapuf.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      localapuf.c = apvd.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      localapuf.d = apug.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
      apue.a(paramView.getCurrentAccountUin(), localapuf);
      apvm.a(paramView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_a_of_type_Apkq != null) {
        this.jdField_a_of_type_Apkq.a(2);
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apiw
 * JD-Core Version:    0.7.0.1
 */