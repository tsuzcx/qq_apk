import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

final class arbt
  implements View.OnClickListener
{
  arbt(FileManagerEntity paramFileManagerEntity, Activity paramActivity, ardn paramardn) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      arnh localarnh = new arnh();
      localarnh.b = "file_forward";
      localarnh.jdField_a_of_type_Int = 71;
      localarnh.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      localarnh.c = arof.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      localarnh.d = arni.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
      arng.a(paramView.getCurrentAccountUin(), localarnh);
      aroo.b(paramView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_a_of_type_Ardn != null) {
        this.jdField_a_of_type_Ardn.a(2);
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbt
 * JD-Core Version:    0.7.0.1
 */