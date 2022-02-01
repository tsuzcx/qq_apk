import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.List;

class atei
  implements audq
{
  atei(ateh paramateh, FileManagerEntity paramFileManagerEntity) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    this.jdField_a_of_type_Ateh.a.a.a().aa();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0) {
      QfileBaseRecentFileTabView.t(this.jdField_a_of_type_Ateh.a).getOnlineFileSessionCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    }
    ansr localansr;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 6) {
        break;
      }
      localansr = (ansr)QfileBaseRecentFileTabView.u(this.jdField_a_of_type_Ateh.a).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq));
    } while (localansr.a(localArrayList));
    audr.a(2131692468);
    return;
    QfileBaseRecentFileTabView.v(this.jdField_a_of_type_Ateh.a).getFileManagerEngine().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atei
 * JD-Core Version:    0.7.0.1
 */