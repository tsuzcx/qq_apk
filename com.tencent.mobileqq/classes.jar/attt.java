import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class attt
  implements View.OnClickListener
{
  attt(FileManagerEntity paramFileManagerEntity, Activity paramActivity, atuw paramatuw) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      audz localaudz = new audz();
      localaudz.b = "file_forward";
      localaudz.jdField_a_of_type_Int = 71;
      localaudz.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      localaudz.c = FileUtil.getExtension(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      localaudz.d = auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
      audy.a(localQQAppInterface.getCurrentAccountUin(), localaudz);
      aufd.b(localQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_a_of_type_Atuw != null) {
        this.jdField_a_of_type_Atuw.a(2);
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
 * Qualified Name:     attt
 * JD-Core Version:    0.7.0.1
 */