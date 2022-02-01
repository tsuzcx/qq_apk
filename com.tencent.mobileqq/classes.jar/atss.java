import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class atss
  implements atrr
{
  atss(atsr paramatsr, ByteStringMicro paramByteStringMicro, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    atsi.a(this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Atsq.jdField_a_of_type_Atsi).a().a(atsq.a(this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Atsq));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Atsq.jdField_a_of_type_JavaLangString + " sendLocalFileToBuddyBySHA uploadFile success");
      }
      this.jdField_a_of_type_Atsr.jdField_a_of_type_Atrw.a(this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro.toByteArray(), 5000, 3, null);
      atsq.a(this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Atsq).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Atte.a(this.jdField_a_of_type_JavaLangString, atsq.a(this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Atsq));
      return;
    }
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Atsq.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild");
    this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Atte.a(atsi.a(this.jdField_a_of_type_Atsr.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Atsq.jdField_a_of_type_Long, false), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atss
 * JD-Core Version:    0.7.0.1
 */