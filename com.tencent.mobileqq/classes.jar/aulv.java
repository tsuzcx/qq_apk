import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class aulv
  extends auls
{
  private MessageForTroopFile a;
  
  public aulv(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile = ((MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  public long a()
  {
    bftf localbftf = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbftf == null) {
      return 0L;
    }
    return localbftf.c;
  }
  
  public aulp a()
  {
    aulu localaulu = new aulu(bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
    localaulu.a(new aulw(this));
    return localaulu;
  }
  
  public String a()
  {
    bftf localbftf = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbftf != null) {
      return localbftf.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    bftf localbftf = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    if (localbftf == null)
    {
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
      return false;
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload: uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "] fileId[" + localbftf.e + "]");
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
    localTroopFileTransferManager.a(localbftf.e, localbftf.g, localbftf.c, localbftf.h);
    if ((localbftf.b == 10) || (localbftf.b == 9)) {
      if (localbftf.jdField_a_of_type_JavaUtilUUID != null) {
        localTroopFileTransferManager.c(localbftf.jdField_a_of_type_JavaUtilUUID);
      }
    }
    for (;;)
    {
      return true;
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : resumeDownload error, infoId is null");
      return false;
      if (localbftf.b != 7) {
        break;
      }
      localTroopFileTransferManager.a(localbftf.e, localbftf.g, localbftf.c, localbftf.h);
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : can not handle file info status[" + localbftf.b + ",download error");
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq;
  }
  
  public boolean b()
  {
    bftf localbftf = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbftf == null) {
      QLog.i("TroopFileSaveModel<QFile>", 1, "stopDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
    }
    while ((localbftf.b != 8) && (localbftf.b != 9) && (localbftf.b != 10)) {
      return false;
    }
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l).d(localbftf.jdField_a_of_type_JavaUtilUUID);
    return true;
  }
  
  public boolean c()
  {
    bftf localbftf = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return (localbftf != null) && (localbftf.b == 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulv
 * JD-Core Version:    0.7.0.1
 */