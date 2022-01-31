import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.3.1;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apay
  extends aowi
{
  apay(apax paramapax) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [CC Replay] nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      apax.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      apax.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      apax.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      apax.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      apax.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      apax.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.jdField_a_of_type_Apar != null)
    {
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_Apar.a() > 0) {
        localObject1 = "ChanedUrlCount[" + this.a.jdField_a_of_type_Apar.a() + "]";
      }
    }
    this.a.b((String)localObject1);
    adgc.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3);
  }
  
  protected void a(boolean paramBoolean, aowf paramaowf, akau paramakau)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      apax.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaowf.jdField_a_of_type_Int, paramaowf.jdField_a_of_type_JavaLangString);
      int i = 9045;
      if (-100001 == paramaowf.jdField_a_of_type_Int) {
        i = 9043;
      }
      apax.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      apax.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [SetFileStatus Step]Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, apax.a(this.a));
  }
  
  protected void a(boolean paramBoolean, aowf paramaowf, akau paramakau, List<String> paramList)
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
      apax.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaowf.jdField_a_of_type_Int, paramaowf.jdField_a_of_type_JavaLangString);
      i = paramaowf.jdField_a_of_type_Int;
      if (-100001 == paramaowf.jdField_a_of_type_Int) {
        i = 9043;
      }
      paramakau = "server retError";
      if (paramaowf.jdField_a_of_type_JavaLangString != null) {
        paramakau = paramaowf.jdField_a_of_type_JavaLangString;
      }
      apax.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramakau);
      apax.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramakau);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if ((paramaowf.jdField_b_of_type_JavaLangString == null) || (paramaowf.jdField_b_of_type_JavaLangString.length() == 0))
    {
      apax.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaowf.jdField_a_of_type_Int, paramaowf.jdField_a_of_type_JavaLangString);
      QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]ResultCodeNoServerAddr ip = 0");
      i = paramaowf.jdField_a_of_type_Int;
      paramakau = paramaowf.jdField_a_of_type_JavaLangString;
      if (paramaowf.jdField_a_of_type_Int == 0)
      {
        i = 9048;
        paramakau = "onUpSend ip url error";
      }
      apax.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramakau);
      apax.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramakau);
      return;
    }
    boolean bool = false;
    Object localObject1 = null;
    int j = paramaowf.jdField_a_of_type_Short;
    paramBoolean = bool;
    paramakau = (akau)localObject1;
    int i = j;
    if (apei.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramBoolean = bool;
      paramakau = (akau)localObject1;
      i = j;
      if (paramaowf.jdField_d_of_type_Int == 2)
      {
        paramBoolean = bool;
        paramakau = (akau)localObject1;
        i = j;
        if (!TextUtils.isEmpty(paramaowf.c))
        {
          bool = true;
          localObject1 = paramaowf.c;
          j = paramaowf.jdField_b_of_type_Short;
          paramBoolean = bool;
          paramakau = (akau)localObject1;
          i = j;
          if (j == 0)
          {
            i = 443;
            paramakau = (akau)localObject1;
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
    ((List)localObject1).add(0, paramaowf.jdField_b_of_type_JavaLangString + ":" + i);
    if ((!TextUtils.isEmpty(paramaowf.jdField_d_of_type_JavaLangString)) && (apvm.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "[CS Replay] offline upload support IPv6. domain[" + paramaowf.jdField_d_of_type_JavaLangString + "]");
      ((List)localObject1).add(0, paramaowf.jdField_d_of_type_JavaLangString + ":" + i);
    }
    Object localObject2 = new ArrayList();
    if (paramList != null) {
      ((List)localObject2).addAll(paramList);
    }
    ((List)localObject2).add(0, paramaowf.jdField_b_of_type_JavaLangString);
    ThreadManager.post(new OfflineSendWorker.3.1(this, paramaowf, paramBoolean, paramakau, (List)localObject1, (List)localObject2, i), 5, null, false);
  }
  
  protected void b(boolean paramBoolean, aowf paramaowf, akau paramakau, List<String> paramList)
  {
    if (this.a.a()) {}
    while (paramaowf.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramaowf.jdField_a_of_type_ArrayOfByte != null) && (paramaowf.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(paramaowf.jdField_a_of_type_ArrayOfByte);
      this.a.b();
      this.a.b = true;
      apax.a(this.a);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apay
 * JD-Core Version:    0.7.0.1
 */