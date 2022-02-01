import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aspo
  implements View.OnClickListener
{
  aspo(FileManagerEntity paramFileManagerEntity, asqp paramasqp) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (bkss.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
        bkss.a().a(this.jdField_a_of_type_Asqp.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspo
 * JD-Core Version:    0.7.0.1
 */