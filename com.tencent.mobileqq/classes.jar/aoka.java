import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.3.1;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aoka
  extends aofk
{
  aoka(aojz paramaojz) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [CC Replay] nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      aojz.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      aojz.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      aojz.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      aojz.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      aojz.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      aojz.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.jdField_a_of_type_Aojt != null)
    {
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_Aojt.a() > 0) {
        localObject1 = "ChanedUrlCount[" + this.a.jdField_a_of_type_Aojt.a() + "]";
      }
    }
    this.a.b((String)localObject1);
    acvh.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3);
  }
  
  protected void a(boolean paramBoolean, aofh paramaofh, ajmn paramajmn)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      aojz.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaofh.jdField_a_of_type_Int, paramaofh.jdField_a_of_type_JavaLangString);
      int i = 9045;
      if (-100001 == paramaofh.jdField_a_of_type_Int) {
        i = 9043;
      }
      aojz.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      aojz.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [SetFileStatus Step]Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, aojz.a(this.a));
  }
  
  protected void a(boolean paramBoolean, aofh paramaofh, ajmn paramajmn, List<String> paramList)
  {
    if (this.a.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "=_= ^! Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSendOfflineFile-->failed");
      aojz.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaofh.jdField_a_of_type_Int, paramaofh.jdField_a_of_type_JavaLangString);
      i = paramaofh.jdField_a_of_type_Int;
      if (-100001 == paramaofh.jdField_a_of_type_Int) {
        i = 9043;
      }
      paramajmn = "server retError";
      if (paramaofh.jdField_a_of_type_JavaLangString != null) {
        paramajmn = paramaofh.jdField_a_of_type_JavaLangString;
      }
      aojz.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramajmn);
      aojz.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramajmn);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if ((paramaofh.jdField_b_of_type_JavaLangString == null) || (paramaofh.jdField_b_of_type_JavaLangString.length() == 0))
    {
      aojz.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaofh.jdField_a_of_type_Int, paramaofh.jdField_a_of_type_JavaLangString);
      QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]ResultCodeNoServerAddr ip = 0");
      i = paramaofh.jdField_a_of_type_Int;
      paramajmn = paramaofh.jdField_a_of_type_JavaLangString;
      if (paramaofh.jdField_a_of_type_Int == 0)
      {
        i = 9048;
        paramajmn = "onUpSend ip url error";
      }
      aojz.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramajmn);
      aojz.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramajmn);
      return;
    }
    boolean bool = false;
    Object localObject1 = null;
    int j = paramaofh.jdField_a_of_type_Short;
    paramBoolean = bool;
    paramajmn = (ajmn)localObject1;
    int i = j;
    if (aonj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramBoolean = bool;
      paramajmn = (ajmn)localObject1;
      i = j;
      if (paramaofh.jdField_d_of_type_Int == 2)
      {
        paramBoolean = bool;
        paramajmn = (ajmn)localObject1;
        i = j;
        if (!TextUtils.isEmpty(paramaofh.c))
        {
          bool = true;
          localObject1 = paramaofh.c;
          j = paramaofh.jdField_b_of_type_Short;
          paramBoolean = bool;
          paramajmn = (ajmn)localObject1;
          i = j;
          if (j == 0)
          {
            i = 443;
            paramajmn = (ajmn)localObject1;
            paramBoolean = bool;
          }
        }
      }
    }
    localObject1 = new ArrayList();
    if (paramList != null)
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ((List)localObject1).add(str + ":" + i);
      }
    }
    ((List)localObject1).add(0, paramaofh.jdField_b_of_type_JavaLangString + ":" + i);
    if ((!TextUtils.isEmpty(paramaofh.jdField_d_of_type_JavaLangString)) && (apdq.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "[CS Replay] offline upload support IPv6. domain[" + paramaofh.jdField_d_of_type_JavaLangString + "]");
      ((List)localObject1).add(0, paramaofh.jdField_d_of_type_JavaLangString + ":" + i);
    }
    Object localObject2 = new ArrayList();
    if (paramList != null) {
      ((List)localObject2).addAll(paramList);
    }
    ((List)localObject2).add(0, paramaofh.jdField_b_of_type_JavaLangString);
    ThreadManager.post(new OfflineSendWorker.3.1(this, paramaofh, paramBoolean, paramajmn, (List)localObject1, (List)localObject2, i), 5, null, false);
  }
  
  protected void b(boolean paramBoolean, aofh paramaofh, ajmn paramajmn, List<String> paramList)
  {
    if (this.a.a()) {}
    while (paramaofh.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramaofh.jdField_a_of_type_ArrayOfByte != null) && (paramaofh.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(paramaofh.jdField_a_of_type_ArrayOfByte);
      this.a.b();
      this.a.b = true;
      aojz.a(this.a);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoka
 * JD-Core Version:    0.7.0.1
 */