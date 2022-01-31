import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

final class apiu
  implements View.OnClickListener
{
  apiu(FileManagerEntity paramFileManagerEntity, apkm paramapkm) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (bgta.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity))
      {
        bgta.a().a(this.jdField_a_of_type_Apkm.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, false);
        return;
      }
      QLog.e("FileOperaterUtils-PUPU", 2, "Should not open the file with pupu: " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apiu
 * JD-Core Version:    0.7.0.1
 */