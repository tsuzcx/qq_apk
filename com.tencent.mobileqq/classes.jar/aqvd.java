import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aqvd
  extends aquk
{
  public aqvd(aqug paramaqug)
  {
    super(paramaqug);
  }
  
  protected String a()
  {
    return "StateRequest";
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Aqug.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Aqug.b();
      break label63;
      aqug.a(this.jdField_a_of_type_Aqug, 11, 5, true);
      a("StateAcceptByPC");
      this.jdField_a_of_type_Aquk = new aquh(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.a(this.jdField_a_of_type_Aqug, 11, 6, true);
      a("StateRefuseByPC");
      this.jdField_a_of_type_Aquk = new aqva(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.a(this.jdField_a_of_type_Aqug, 11, 8, true);
      a("StateSenderCancelSend");
      this.jdField_a_of_type_Aquk = new aqvh(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.a(this.jdField_a_of_type_Aqug, 11, 7, true);
      a("StateSaveToWeiYunByPC");
      this.jdField_a_of_type_Aquk = new aqve(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.a(this.jdField_a_of_type_Aqug);
      aqug.a(this.jdField_a_of_type_Aqug, 11, 11);
      aqug.a(this.jdField_a_of_type_Aqug, 11, 14, false);
      a("StateUploadingWhenChangeToOff");
      this.jdField_a_of_type_Aquk = new aqvk(this.jdField_a_of_type_Aqug);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    aqug.a(this.jdField_a_of_type_Aqug);
    b(paramInt1, paramInt2);
    aqug.a(this.jdField_a_of_type_Aqug, 11, 11);
    aqug.a(this.jdField_a_of_type_Aqug, 11, 14, false);
    a("StateUploadingWhenChangeToOff");
    this.jdField_a_of_type_Aquk = new aqvk(this.jdField_a_of_type_Aqug);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  protected boolean a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    aqug.b(this.jdField_a_of_type_Aqug, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a + "-" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.b + "]");
    boolean bool = this.jdField_a_of_type_Aqug.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
    if (bool)
    {
      aqug.c(this.jdField_a_of_type_Aqug, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_Aquk = new aqvq(this.jdField_a_of_type_Aqug);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      return bool;
      aqug.c(this.jdField_a_of_type_Aqug, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_Aquk = new aqup(this.jdField_a_of_type_Aqug);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]  failure to send recv cmd!!! ");
    }
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((arni.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    aqug.a(this.jdField_a_of_type_Aqug, 1, -1, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aquk = new aquw(this.jdField_a_of_type_Aqug);
    return true;
  }
  
  protected void b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 11, 9, true);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Aquk = new aqun(this.jdField_a_of_type_Aqug);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. onCheckIsTooLongSession entity is null");
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 9, 12, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Aquk = new aquv(this.jdField_a_of_type_Aqug);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvd
 * JD-Core Version:    0.7.0.1
 */