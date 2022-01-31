import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class arlu
  extends arlr
{
  private MessageForTroopFile a;
  
  public arlu(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile = ((MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  public long a()
  {
    bbpe localbbpe = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbpe == null) {
      return 0L;
    }
    return localbbpe.c;
  }
  
  public arlo a()
  {
    arlt localarlt = new arlt(bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
    localarlt.a(new arlv(this));
    return localarlt;
  }
  
  public String a()
  {
    bbpe localbbpe = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbpe != null) {
      return localbbpe.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    bbpe localbbpe = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    if (localbbpe == null)
    {
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
      return false;
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload: uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "] fileId[" + localbbpe.e + "]");
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
    localTroopFileTransferManager.a(localbbpe.e, localbbpe.g, localbbpe.c, localbbpe.h);
    if ((localbbpe.b == 10) || (localbbpe.b == 9)) {
      if (localbbpe.jdField_a_of_type_JavaUtilUUID != null) {
        localTroopFileTransferManager.c(localbbpe.jdField_a_of_type_JavaUtilUUID);
      }
    }
    for (;;)
    {
      return true;
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : resumeDownload error, infoId is null");
      return false;
      if (localbbpe.b != 7) {
        break;
      }
      localTroopFileTransferManager.a(localbbpe.e, localbbpe.g, localbbpe.c, localbbpe.h);
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : can not handle file info status[" + localbbpe.b + ",download error");
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq;
  }
  
  public boolean b()
  {
    bbpe localbbpe = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localbbpe == null) {
      QLog.i("TroopFileSaveModel<QFile>", 1, "stopDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
    }
    while ((localbbpe.b != 8) && (localbbpe.b != 9) && (localbbpe.b != 10)) {
      return false;
    }
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l).d(localbbpe.jdField_a_of_type_JavaUtilUUID);
    return true;
  }
  
  public boolean c()
  {
    bbpe localbbpe = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return (localbbpe != null) && (localbbpe.b == 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arlu
 * JD-Core Version:    0.7.0.1
 */