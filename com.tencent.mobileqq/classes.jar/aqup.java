import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aqup
  extends aquk
{
  public aqup(aqug paramaqug)
  {
    super(paramaqug);
  }
  
  protected String a()
  {
    return "StateChangeToOffFailedWhenRecv";
  }
  
  protected void a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
    }
    do
    {
      return;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a + "-" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.b + "]");
    } while (!this.jdField_a_of_type_Aqug.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId));
    aqug.c(this.jdField_a_of_type_Aqug, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Aquk = new aqvq(this.jdField_a_of_type_Aqug);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
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
      aqug.b(this.jdField_a_of_type_Aqug, 13, 5);
      aqug.c(this.jdField_a_of_type_Aqug, 13, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateAcceptByPCWhenToOffFailed)");
      this.jdField_a_of_type_Aquk = new aquj(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 13, 6);
      aqug.c(this.jdField_a_of_type_Aqug, 13, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateRefuseByPCWhenToOffFailed)");
      this.jdField_a_of_type_Aquk = new aqvc(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 13, 8);
      aqug.c(this.jdField_a_of_type_Aqug, 13, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateSenderCancelSendWhenToOffFailed)");
      this.jdField_a_of_type_Aquk = new aqvj(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 13, 7);
      aqug.c(this.jdField_a_of_type_Aqug, 13, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
      this.jdField_a_of_type_Aquk = new aqvg(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.a(this.jdField_a_of_type_Aqug);
      aqug.b(this.jdField_a_of_type_Aqug, 13, 11);
      aqug.c(this.jdField_a_of_type_Aqug, 13, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateChangeToOffWhenToOffFailed)");
      this.jdField_a_of_type_Aquk = new aqur(this.jdField_a_of_type_Aqug);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug);
    b(paramInt1, paramInt2);
    aqug.a(this.jdField_a_of_type_Aqug, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Aquk = new aquz(this.jdField_a_of_type_Aqug);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (a("onSenderUploadException")) {
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aquk = new aquv(this.jdField_a_of_type_Aqug);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. StateWaitingRecvResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      aqug.a(this.jdField_a_of_type_Aqug);
      aqug.a(this.jdField_a_of_type_Aqug, 9, 11, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateLocalFailedWhenRecv)");
      this.jdField_a_of_type_Aquk = new aquz(this.jdField_a_of_type_Aqug);
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateChangeToOffFailedWhenRecv)");
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
    this.jdField_a_of_type_Aqug.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    aqug.b(this.jdField_a_of_type_Aqug, 1, 0);
    aqug.c(this.jdField_a_of_type_Aqug, 1, 0);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aquk = new aquw(this.jdField_a_of_type_Aqug);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Aquk = new aqun(this.jdField_a_of_type_Aqug);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + " recv  success response of ask progress, not handle it");
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + " recv  failed response of ask progress, not handle it");
  }
  
  protected void d()
  {
    if (a("onSenderReplayComeOnRecv")) {
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug);
    aqug.a(this.jdField_a_of_type_Aqug, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Aquk = new aquz(this.jdField_a_of_type_Aqug);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqup
 * JD-Core Version:    0.7.0.1
 */