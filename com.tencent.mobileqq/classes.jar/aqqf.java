import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class aqqf
  implements aqpm
{
  aqqf(aqqe paramaqqe, ByteStringMicro paramByteStringMicro, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    aqpv.a(this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqqd.jdField_a_of_type_Aqpv).a().a(aqqd.a(this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqqd));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqqd.jdField_a_of_type_JavaLangString + " sendLocalFileToBuddyBySHA uploadFile success");
      }
      this.jdField_a_of_type_Aqqe.jdField_a_of_type_Aqpr.a(this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro.toByteArray(), 5000, 3, null);
      aqqd.a(this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqqd).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqqr.a(this.jdField_a_of_type_JavaLangString, aqqd.a(this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqqd));
      return;
    }
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqqd.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild");
    this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqqr.a(aqpv.a(this.jdField_a_of_type_Aqqe.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqqd.jdField_a_of_type_Long, false), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqf
 * JD-Core Version:    0.7.0.1
 */