import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.SliceSttManager.SliceSttServet.2;
import java.io.File;

public class baak
{
  aeyl jdField_a_of_type_Aeyl = new baal(this);
  private aeyz jdField_a_of_type_Aeyz = new aeyz();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public MessageForPtt a;
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  String b;
  
  public baak(baaj parambaaj, QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = paramMessageForPtt;
  }
  
  private void b()
  {
    if (this.b != null)
    {
      File localFile = new File(this.b);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.sttAbility = 2;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.sttText = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isReadPtt = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.serial();
    this.jdField_a_of_type_Baaj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgData);
    this.jdField_a_of_type_Baaj.jdField_a_of_type_AndroidOsHandler.post(new SliceSttManager.SliceSttServet.2(this));
  }
  
  public void a()
  {
    this.b = MessageForPtt.getTmpFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getLocalFilePath());
    this.jdField_a_of_type_Aeyz.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeyl, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin);
    this.jdField_a_of_type_Aeyz.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getLocalFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baak
 * JD-Core Version:    0.7.0.1
 */