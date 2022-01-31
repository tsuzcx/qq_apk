import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

final class apiy
  implements View.OnClickListener
{
  apiy(FileManagerEntity paramFileManagerEntity, apkq paramapkq) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (bgtr.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity))
      {
        bgtr.a().a(this.jdField_a_of_type_Apkq.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, false);
        return;
      }
      QLog.e("FileOperaterUtils-PUPU", 2, "Should not open the file with pupu: " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apiy
 * JD-Core Version:    0.7.0.1
 */