import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.BuddyUploadTaskExcuter.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class aqsp
  implements aqtv
{
  aqsp(aqso paramaqso, ByteStringMicro paramByteStringMicro, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    aqsf.a(this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqsn.jdField_a_of_type_Aqsf).a().a(aqsn.a(this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqsn));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqsn.jdField_a_of_type_JavaLangString + " sendLocalFileToBuddyBySHA uploadFile success");
      }
      this.jdField_a_of_type_Aqso.jdField_a_of_type_Aqua.a(this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro.toByteArray(), 5000, 3, null);
      aqsn.a(this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqsn).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqtc.a(this.jdField_a_of_type_JavaLangString, aqsn.a(this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqsn));
      return;
    }
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqsn.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild");
    this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqtc.a(aqsf.a(this.jdField_a_of_type_Aqso.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqsn.jdField_a_of_type_Long, false), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsp
 * JD-Core Version:    0.7.0.1
 */