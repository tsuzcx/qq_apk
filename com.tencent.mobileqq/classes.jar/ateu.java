import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ateu
  extends aszq
{
  ateu(atet paramatet) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [CC Replay] nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      atet.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      atet.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      atet.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      atet.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      atet.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      atet.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.jdField_a_of_type_Atdy != null)
    {
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_Atdy.a() > 0) {
        localObject1 = "ChanedUrlCount[" + this.a.jdField_a_of_type_Atdy.a() + "]";
      }
    }
    this.a.b((String)localObject1);
    agjf.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3);
  }
  
  protected void a(boolean paramBoolean, aszn paramaszn, anqe paramanqe)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      atet.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaszn.jdField_a_of_type_Int, paramaszn.jdField_a_of_type_JavaLangString);
      int i = 9045;
      if (-100001 == paramaszn.jdField_a_of_type_Int) {
        i = 9043;
      }
      atet.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      atet.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [SetFileStatus Step]Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, atet.a(this.a));
  }
  
  protected void a(boolean paramBoolean, aszn paramaszn, anqe paramanqe, List<String> paramList)
  {
    if (this.a.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "=_= ^! Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    int i;
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSendOfflineFile-->failed");
      atet.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaszn.jdField_a_of_type_Int, paramaszn.jdField_a_of_type_JavaLangString);
      i = paramaszn.jdField_a_of_type_Int;
      if (-100001 == paramaszn.jdField_a_of_type_Int) {
        i = 9043;
      }
      paramanqe = "server retError";
      if (paramaszn.jdField_a_of_type_JavaLangString != null) {
        paramanqe = paramaszn.jdField_a_of_type_JavaLangString;
      }
      atet.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramanqe);
      atet.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramanqe);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if (atet.a(this.a, paramaszn))
    {
      atet.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaszn.jdField_a_of_type_Int, paramaszn.jdField_a_of_type_JavaLangString);
      QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]ResultCodeNoServerAddr ip = 0");
      i = paramaszn.jdField_a_of_type_Int;
      paramanqe = paramaszn.jdField_a_of_type_JavaLangString;
      if (paramaszn.jdField_a_of_type_Int == 0)
      {
        i = 9048;
        paramanqe = "onUpSend ip url error";
      }
      atet.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramanqe);
      atet.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramanqe);
      return;
    }
    paramBoolean = false;
    Object localObject1 = null;
    short s2 = paramaszn.jdField_a_of_type_Short;
    boolean bool = paramBoolean;
    paramanqe = (anqe)localObject1;
    short s1 = s2;
    if (atgz.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      bool = paramBoolean;
      paramanqe = (anqe)localObject1;
      s1 = s2;
      if (paramaszn.jdField_d_of_type_Int == 2)
      {
        bool = paramBoolean;
        paramanqe = (anqe)localObject1;
        s1 = s2;
        if (!TextUtils.isEmpty(paramaszn.c))
        {
          paramBoolean = true;
          localObject1 = paramaszn.c;
          s2 = paramaszn.jdField_b_of_type_Short;
          bool = paramBoolean;
          paramanqe = (anqe)localObject1;
          s1 = s2;
          if (s2 == 0)
          {
            s1 = 443;
            paramanqe = (anqe)localObject1;
            bool = paramBoolean;
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
        ((List)localObject1).add(str + ":" + s1);
      }
    }
    ((List)localObject1).add(0, paramaszn.jdField_b_of_type_JavaLangString + ":" + s1);
    Object localObject2 = new ArrayList();
    if (paramList != null) {
      ((List)localObject2).addAll(paramList);
    }
    ((List)localObject2).add(0, paramaszn.jdField_b_of_type_JavaLangString);
    if (!this.a.d()) {
      this.a.c = bool;
    }
    paramBoolean = false;
    if (atet.b(this.a, paramaszn))
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload. is config enable IPv6. domain[" + paramaszn.jdField_d_of_type_JavaLangString + "]");
      paramList = new atcr(paramaszn.jdField_d_of_type_JavaLangString, s1);
      paramList = atcq.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, 1);
      if ((paramList != null) && (!paramList.a()))
      {
        if (atcq.a())
        {
          QLog.d("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload. debugIsDisableIPv4OnDoubleStack");
          ((List)localObject1).clear();
          ((List)localObject2).clear();
        }
        atcq.a(paramList.jdField_a_of_type_JavaUtilList, (List)localObject1, false, false);
        atcq.a(paramList.jdField_a_of_type_JavaUtilList, (List)localObject2, true, false);
        this.a.jdField_b_of_type_Int = 2;
        if (paramList.jdField_a_of_type_Int == 1) {
          this.a.jdField_b_of_type_Int = 3;
        }
        paramBoolean = true;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload use IPv6. iplist:" + localObject1.toString());
      }
    }
    for (;;)
    {
      atet.a(this.a, paramaszn, bool, paramanqe, s1, (List)localObject1, (List)localObject2, paramBoolean);
      return;
      this.a.jdField_b_of_type_Int = 1;
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload use IPv4");
      continue;
      this.a.jdField_b_of_type_Int = 1;
      paramBoolean = false;
    }
  }
  
  protected void b(boolean paramBoolean, aszn paramaszn, anqe paramanqe, List<String> paramList)
  {
    if (this.a.a()) {}
    while (paramaszn.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramaszn.jdField_a_of_type_ArrayOfByte != null) && (paramaszn.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(paramaszn.jdField_a_of_type_ArrayOfByte);
      this.a.b();
      this.a.jdField_b_of_type_Boolean = true;
      atet.a(this.a);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ateu
 * JD-Core Version:    0.7.0.1
 */