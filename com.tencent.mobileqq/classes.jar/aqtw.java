import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.3.1;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqtw
  extends aqpg
{
  aqtw(aqtv paramaqtv) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [CC Replay] nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      aqtv.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      aqtv.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      aqtv.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      aqtv.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      aqtv.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      aqtv.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.jdField_a_of_type_Aqtp != null)
    {
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_Aqtp.a() > 0) {
        localObject1 = "ChanedUrlCount[" + this.a.jdField_a_of_type_Aqtp.a() + "]";
      }
    }
    this.a.b((String)localObject1);
    aeyf.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3);
  }
  
  protected void a(boolean paramBoolean, aqpd paramaqpd, alsj paramalsj)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      aqtv.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaqpd.jdField_a_of_type_Int, paramaqpd.jdField_a_of_type_JavaLangString);
      int i = 9045;
      if (-100001 == paramaqpd.jdField_a_of_type_Int) {
        i = 9043;
      }
      aqtv.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      aqtv.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [SetFileStatus Step]Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, aqtv.a(this.a));
  }
  
  protected void a(boolean paramBoolean, aqpd paramaqpd, alsj paramalsj, List<String> paramList)
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
      aqtv.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaqpd.jdField_a_of_type_Int, paramaqpd.jdField_a_of_type_JavaLangString);
      i = paramaqpd.jdField_a_of_type_Int;
      if (-100001 == paramaqpd.jdField_a_of_type_Int) {
        i = 9043;
      }
      paramalsj = "server retError";
      if (paramaqpd.jdField_a_of_type_JavaLangString != null) {
        paramalsj = paramaqpd.jdField_a_of_type_JavaLangString;
      }
      aqtv.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramalsj);
      aqtv.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramalsj);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if ((paramaqpd.jdField_b_of_type_JavaLangString == null) || (paramaqpd.jdField_b_of_type_JavaLangString.length() == 0))
    {
      aqtv.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaqpd.jdField_a_of_type_Int, paramaqpd.jdField_a_of_type_JavaLangString);
      QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]ResultCodeNoServerAddr ip = 0");
      i = paramaqpd.jdField_a_of_type_Int;
      paramalsj = paramaqpd.jdField_a_of_type_JavaLangString;
      if (paramaqpd.jdField_a_of_type_Int == 0)
      {
        i = 9048;
        paramalsj = "onUpSend ip url error";
      }
      aqtv.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramalsj);
      aqtv.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramalsj);
      return;
    }
    boolean bool = false;
    Object localObject1 = null;
    int j = paramaqpd.jdField_a_of_type_Short;
    paramBoolean = bool;
    paramalsj = (alsj)localObject1;
    int i = j;
    if (aqxg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramBoolean = bool;
      paramalsj = (alsj)localObject1;
      i = j;
      if (paramaqpd.jdField_d_of_type_Int == 2)
      {
        paramBoolean = bool;
        paramalsj = (alsj)localObject1;
        i = j;
        if (!TextUtils.isEmpty(paramaqpd.c))
        {
          bool = true;
          localObject1 = paramaqpd.c;
          j = paramaqpd.jdField_b_of_type_Short;
          paramBoolean = bool;
          paramalsj = (alsj)localObject1;
          i = j;
          if (j == 0)
          {
            i = 443;
            paramalsj = (alsj)localObject1;
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
    ((List)localObject1).add(0, paramaqpd.jdField_b_of_type_JavaLangString + ":" + i);
    if ((!TextUtils.isEmpty(paramaqpd.jdField_d_of_type_JavaLangString)) && (aroo.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "[CS Replay] offline upload support IPv6. domain[" + paramaqpd.jdField_d_of_type_JavaLangString + "]");
      ((List)localObject1).add(0, paramaqpd.jdField_d_of_type_JavaLangString + ":" + i);
    }
    Object localObject2 = new ArrayList();
    if (paramList != null) {
      ((List)localObject2).addAll(paramList);
    }
    ((List)localObject2).add(0, paramaqpd.jdField_b_of_type_JavaLangString);
    ThreadManager.post(new OfflineSendWorker.3.1(this, paramaqpd, paramBoolean, paramalsj, (List)localObject1, (List)localObject2, i), 5, null, false);
  }
  
  protected void b(boolean paramBoolean, aqpd paramaqpd, alsj paramalsj, List<String> paramList)
  {
    if (this.a.a()) {}
    while (paramaqpd.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramaqpd.jdField_a_of_type_ArrayOfByte != null) && (paramaqpd.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(paramaqpd.jdField_a_of_type_ArrayOfByte);
      this.a.b();
      this.a.b = true;
      aqtv.a(this.a);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtw
 * JD-Core Version:    0.7.0.1
 */