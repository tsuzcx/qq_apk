import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class aucd
  extends aucj
{
  private MessageForFile jdField_a_of_type_ComTencentMobileqqDataMessageForFile = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = auea.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
  
  public aucd(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "init: not find the target entity.");
      return;
    }
    QLog.e("OfflineFileSaveModel<QFile>", 1, "init: uniseq[" + paramChatMessage.uniseq + "] session[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]");
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    }
    return 0L;
  }
  
  public aucg a()
  {
    aucc localaucc = new aucc(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localaucc.a(new auce(this));
    return localaucc;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    }
    return "";
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "download: file entity is null.");
      return false;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType();
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    QLog.e("OfflineFileSaveModel<QFile>", 1, "download: uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq + "] session[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] cloudType[" + i + "] status[" + j + "]");
    if ((!FileUtils.fileExistsAndNotEmpty(str)) && (i != 0))
    {
      if (j == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return true;
    }
    QLog.e("OfflineFileSaveModel<QFile>", 1, "download: error, file status is not right.");
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "stopDownload: file entity is null.");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    return true;
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getStatus() == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucd
 * JD-Core Version:    0.7.0.1
 */