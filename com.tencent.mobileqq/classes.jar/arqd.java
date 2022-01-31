import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class arqd
  extends arqa
{
  private MessageForTroopFile a;
  
  public arqd(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile = ((MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  public long a()
  {
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbtn == null) {
      return 0L;
    }
    return localbbtn.c;
  }
  
  public arpx a()
  {
    arqc localarqc = new arqc(bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
    localarqc.a(new arqe(this));
    return localarqc;
  }
  
  public String a()
  {
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbtn != null) {
      return localbbtn.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    if (localbbtn == null)
    {
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
      return false;
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload: uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "] fileId[" + localbbtn.e + "]");
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
    localTroopFileTransferManager.a(localbbtn.e, localbbtn.g, localbbtn.c, localbbtn.h);
    if ((localbbtn.b == 10) || (localbbtn.b == 9)) {
      if (localbbtn.jdField_a_of_type_JavaUtilUUID != null) {
        localTroopFileTransferManager.c(localbbtn.jdField_a_of_type_JavaUtilUUID);
      }
    }
    for (;;)
    {
      return true;
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : resumeDownload error, infoId is null");
      return false;
      if (localbbtn.b != 7) {
        break;
      }
      localTroopFileTransferManager.a(localbbtn.e, localbbtn.g, localbbtn.c, localbbtn.h);
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : can not handle file info status[" + localbbtn.b + ",download error");
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq;
  }
  
  public boolean b()
  {
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbtn == null) {
      QLog.i("TroopFileSaveModel<QFile>", 1, "stopDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
    }
    while ((localbbtn.b != 8) && (localbbtn.b != 9) && (localbbtn.b != 10)) {
      return false;
    }
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l).d(localbbtn.jdField_a_of_type_JavaUtilUUID);
    return true;
  }
  
  public boolean c()
  {
    bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return (localbbtn != null) && (localbbtn.b == 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqd
 * JD-Core Version:    0.7.0.1
 */