import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.BuddyUploadTaskExcuter.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;

public class aovh
  extends aows
{
  public aovh(FileMultiMsgManager.BuddyUploadTaskExcuter.1 param1, aowt paramaowt, byte[] paramArrayOfByte) {}
  
  protected void a(boolean paramBoolean, int paramInt, cmd0x346.ApplyUploadRspV3 paramApplyUploadRspV3)
  {
    if ((paramInt == -100001) || (paramInt == -100002))
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "BuddyUploadTaskExcuter faild，retCode[" + paramInt + "]" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, false), true);
    }
    while (paramApplyUploadRspV3 == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "BuddyUploadTaskExcuter faild，retCode[" + paramInt + "], but rspV3 is null" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, false), false);
      return;
      if (paramInt == -100003)
      {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, "BuddyUploadTaskExcuter faild，retCode[" + paramInt + "]" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, false), false);
        return;
      }
    }
    if (!paramApplyUploadRspV3.int32_ret_code.has())
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "BuddyUploadTaskExcuter faild not has int32_ret_code" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, false), false);
      return;
    }
    if (paramApplyUploadRspV3.int32_ret_code.get() != 0)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild，retcode:" + paramApplyUploadRspV3.int32_ret_code.get());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, false), false);
      return;
    }
    if ((paramApplyUploadRspV3.bool_file_exist.has()) && (paramApplyUploadRspV3.bytes_uuid.has()))
    {
      paramApplyUploadRspV3 = paramApplyUploadRspV3.bytes_uuid.get().toByteArray();
      if (paramApplyUploadRspV3 != null)
      {
        str1 = new String(paramApplyUploadRspV3);
        aovg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg).putString("_m_ForwardUuid", str1);
        this.jdField_a_of_type_Aowt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_JavaLangString, paramApplyUploadRspV3, 5000, 3, null);
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start sendLocalFileToBuddyBySHA cs hit:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(str1, aovg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg));
        return;
      }
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild，file exist bug uuid is null");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, false), true);
      return;
    }
    if (!paramApplyUploadRspV3.bytes_upload_key.has())
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild，uploadkey is null");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, false), true);
      return;
    }
    if (!paramApplyUploadRspV3.bytes_uuid.has())
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild，uuid is null");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, false), true);
      return;
    }
    if (!paramApplyUploadRspV3.str_upload_https_domain.has())
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString + " BuddyUploadTaskExcuter faild，https domain is null");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, false), true);
      return;
    }
    String str1 = paramApplyUploadRspV3.str_upload_https_domain.get();
    paramBoolean = apei.a(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Aouy));
    ByteStringMicro localByteStringMicro = paramApplyUploadRspV3.bytes_uuid.get();
    String str2 = new String(localByteStringMicro.toByteArray());
    String str3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramApplyUploadRspV3.bytes_upload_key.get().toByteArray());
    paramApplyUploadRspV3 = paramApplyUploadRspV3.str_upload_ip.get();
    if (paramBoolean) {}
    for (paramApplyUploadRspV3 = "https://" + paramApplyUploadRspV3 + "/ftn_handler";; paramApplyUploadRspV3 = "http://" + paramApplyUploadRspV3 + "/ftn_handler")
    {
      String str4 = com.qq.taf.jce.HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString + " sendLocalFileToBuddyBySHA cs nohit, start uploadFile");
      }
      paramApplyUploadRspV3 = new aown(aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Aouy), this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.b, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Long, str3, str4, paramApplyUploadRspV3, paramBoolean, str1, new aovi(this, localByteStringMicro, str2));
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_JavaLangString + " add to rsCenter");
      }
      aovg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg, apug.a().longValue());
      aouy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg.jdField_a_of_type_Aouy).a().a(aovg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgManager$BuddyUploadTaskExcuter$1.jdField_a_of_type_Aovg), paramApplyUploadRspV3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovh
 * JD-Core Version:    0.7.0.1
 */