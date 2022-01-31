import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

final class arge
  implements View.OnClickListener
{
  arge(FileManagerEntity paramFileManagerEntity, arhw paramarhw) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (biyx.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity))
      {
        biyx.a().a(this.jdField_a_of_type_Arhw.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, false);
        return;
      }
      QLog.e("FileOperaterUtils-PUPU", 2, "Should not open the file with pupu: " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arge
 * JD-Core Version:    0.7.0.1
 */