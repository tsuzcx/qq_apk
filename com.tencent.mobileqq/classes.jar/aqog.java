import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.BuddyUploadTaskExcuter.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class aqog
  implements aqpm
{
  aqog(aqof paramaqof, ByteStringMicro paramByteStringMicro, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    aqnw.a(this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqoe.jdField_a_of_type_Aqnw).a().a(aqoe.a(this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqoe));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqoe.jdField_a_of_type_JavaLangString + " sendLocalFileToBuddyBySHA uploadFile success");
      }
      this.jdField_a_of_type_Aqof.jdField_a_of_type_Aqpr.a(this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro.toByteArray(), 5000, 3, null);
      aqoe.a(this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqoe).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqot.a(this.jdField_a_of_type_JavaLangString, aqoe.a(this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqoe));
      return;
    }
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqoe.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild");
    this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqot.a(aqnw.a(this.jdField_a_of_type_Aqof.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aqoe.jdField_a_of_type_Long, false), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqog
 * JD-Core Version:    0.7.0.1
 */