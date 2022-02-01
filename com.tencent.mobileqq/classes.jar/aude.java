import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aude
  implements View.OnClickListener
{
  aude(FileManagerEntity paramFileManagerEntity, auef paramauef) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (bmol.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
        bmol.a().a(this.jdField_a_of_type_Auef.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), false);
      }
      for (;;)
      {
        label36:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        QLog.e("FileOperaterUtils-PUPU", 2, "Should not open the file with pupu: " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      }
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aude
 * JD-Core Version:    0.7.0.1
 */