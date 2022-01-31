import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.List;

class aotm
  implements aptw
{
  aotm(aotk paramaotk, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0) {
      QfileBaseRecentFileTabView.z(this.jdField_a_of_type_Aotk.a).a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    }
    ajum localajum;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 6) {
        break;
      }
      localajum = (ajum)QfileBaseRecentFileTabView.A(this.jdField_a_of_type_Aotk.a).a(8);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq));
    } while (localajum.a(localArrayList));
    aptx.a(2131692665);
    return;
    QfileBaseRecentFileTabView.B(this.jdField_a_of_type_Aotk.a).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotm
 * JD-Core Version:    0.7.0.1
 */