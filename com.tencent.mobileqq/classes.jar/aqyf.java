import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.3.1;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqyf
  extends aqtp
{
  aqyf(aqye paramaqye) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [CC Replay] nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      aqye.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      aqye.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      aqye.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      aqye.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      aqye.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      aqye.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.jdField_a_of_type_Aqxy != null)
    {
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_Aqxy.a() > 0) {
        localObject1 = "ChanedUrlCount[" + this.a.jdField_a_of_type_Aqxy.a() + "]";
      }
    }
    this.a.b((String)localObject1);
    afcu.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3);
  }
  
  protected void a(boolean paramBoolean, aqtm paramaqtm, alwy paramalwy)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      aqye.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaqtm.jdField_a_of_type_Int, paramaqtm.jdField_a_of_type_JavaLangString);
      int i = 9045;
      if (-100001 == paramaqtm.jdField_a_of_type_Int) {
        i = 9043;
      }
      aqye.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      aqye.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [SetFileStatus Step]Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, aqye.a(this.a));
  }
  
  protected void a(boolean paramBoolean, aqtm paramaqtm, alwy paramalwy, List<String> paramList)
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
      aqye.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaqtm.jdField_a_of_type_Int, paramaqtm.jdField_a_of_type_JavaLangString);
      i = paramaqtm.jdField_a_of_type_Int;
      if (-100001 == paramaqtm.jdField_a_of_type_Int) {
        i = 9043;
      }
      paramalwy = "server retError";
      if (paramaqtm.jdField_a_of_type_JavaLangString != null) {
        paramalwy = paramaqtm.jdField_a_of_type_JavaLangString;
      }
      aqye.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramalwy);
      aqye.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramalwy);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if ((paramaqtm.jdField_b_of_type_JavaLangString == null) || (paramaqtm.jdField_b_of_type_JavaLangString.length() == 0))
    {
      aqye.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramaqtm.jdField_a_of_type_Int, paramaqtm.jdField_a_of_type_JavaLangString);
      QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]ResultCodeNoServerAddr ip = 0");
      i = paramaqtm.jdField_a_of_type_Int;
      paramalwy = paramaqtm.jdField_a_of_type_JavaLangString;
      if (paramaqtm.jdField_a_of_type_Int == 0)
      {
        i = 9048;
        paramalwy = "onUpSend ip url error";
      }
      aqye.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramalwy);
      aqye.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, paramalwy);
      return;
    }
    boolean bool = false;
    Object localObject1 = null;
    int j = paramaqtm.jdField_a_of_type_Short;
    paramBoolean = bool;
    paramalwy = (alwy)localObject1;
    int i = j;
    if (arbp.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramBoolean = bool;
      paramalwy = (alwy)localObject1;
      i = j;
      if (paramaqtm.jdField_d_of_type_Int == 2)
      {
        paramBoolean = bool;
        paramalwy = (alwy)localObject1;
        i = j;
        if (!TextUtils.isEmpty(paramaqtm.c))
        {
          bool = true;
          localObject1 = paramaqtm.c;
          j = paramaqtm.jdField_b_of_type_Short;
          paramBoolean = bool;
          paramalwy = (alwy)localObject1;
          i = j;
          if (j == 0)
          {
            i = 443;
            paramalwy = (alwy)localObject1;
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
    ((List)localObject1).add(0, paramaqtm.jdField_b_of_type_JavaLangString + ":" + i);
    if ((!TextUtils.isEmpty(paramaqtm.jdField_d_of_type_JavaLangString)) && (arsx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "[CS Replay] offline upload support IPv6. domain[" + paramaqtm.jdField_d_of_type_JavaLangString + "]");
      ((List)localObject1).add(0, paramaqtm.jdField_d_of_type_JavaLangString + ":" + i);
    }
    Object localObject2 = new ArrayList();
    if (paramList != null) {
      ((List)localObject2).addAll(paramList);
    }
    ((List)localObject2).add(0, paramaqtm.jdField_b_of_type_JavaLangString);
    ThreadManager.post(new OfflineSendWorker.3.1(this, paramaqtm, paramBoolean, paramalwy, (List)localObject1, (List)localObject2, i), 5, null, false);
  }
  
  protected void b(boolean paramBoolean, aqtm paramaqtm, alwy paramalwy, List<String> paramList)
  {
    if (this.a.a()) {}
    while (paramaqtm.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramaqtm.jdField_a_of_type_ArrayOfByte != null) && (paramaqtm.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(paramaqtm.jdField_a_of_type_ArrayOfByte);
      this.a.b();
      this.a.b = true;
      aqye.a(this.a);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyf
 * JD-Core Version:    0.7.0.1
 */