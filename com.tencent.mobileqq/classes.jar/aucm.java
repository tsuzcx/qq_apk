import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class aucm
  extends aucj
{
  private MessageForTroopFile a;
  
  public aucm(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile = ((MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  public long a()
  {
    bfjs localbfjs = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbfjs == null) {
      return 0L;
    }
    return localbfjs.c;
  }
  
  public aucg a()
  {
    aucl localaucl = new aucl(bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
    localaucl.a(new aucn(this));
    return localaucl;
  }
  
  public String a()
  {
    bfjs localbfjs = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbfjs != null) {
      return localbfjs.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    bfjs localbfjs = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    if (localbfjs == null)
    {
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
      return false;
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload: uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "] fileId[" + localbfjs.e + "]");
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
    localTroopFileTransferManager.a(localbfjs.e, localbfjs.g, localbfjs.c, localbfjs.h);
    if ((localbfjs.b == 10) || (localbfjs.b == 9)) {
      if (localbfjs.jdField_a_of_type_JavaUtilUUID != null) {
        localTroopFileTransferManager.c(localbfjs.jdField_a_of_type_JavaUtilUUID);
      }
    }
    for (;;)
    {
      return true;
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : resumeDownload error, infoId is null");
      return false;
      if (localbfjs.b != 7) {
        break;
      }
      localTroopFileTransferManager.a(localbfjs.e, localbfjs.g, localbfjs.c, localbfjs.h);
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : can not handle file info status[" + localbfjs.b + ",download error");
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq;
  }
  
  public boolean b()
  {
    bfjs localbfjs = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbfjs == null) {
      QLog.i("TroopFileSaveModel<QFile>", 1, "stopDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
    }
    while ((localbfjs.b != 8) && (localbfjs.b != 9) && (localbfjs.b != 10)) {
      return false;
    }
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l).d(localbfjs.jdField_a_of_type_JavaUtilUUID);
    return true;
  }
  
  public boolean c()
  {
    bfjs localbfjs = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return (localbfjs != null) && (localbfjs.b == 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucm
 * JD-Core Version:    0.7.0.1
 */