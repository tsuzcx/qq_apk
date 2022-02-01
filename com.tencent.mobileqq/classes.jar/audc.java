import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class audc
  implements View.OnClickListener
{
  audc(FileManagerEntity paramFileManagerEntity, Activity paramActivity, auef paramauef) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      auni localauni = new auni();
      localauni.b = "file_forward";
      localauni.jdField_a_of_type_Int = 71;
      localauni.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      localauni.c = auog.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      localauni.d = aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
      aunh.a(localQQAppInterface.getCurrentAccountUin(), localauni);
      auoo.b(localQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_a_of_type_Auef != null) {
        this.jdField_a_of_type_Auef.a(2);
      }
      label113:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label113;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audc
 * JD-Core Version:    0.7.0.1
 */