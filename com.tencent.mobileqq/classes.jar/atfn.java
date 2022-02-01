import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atfn
  extends atfi
{
  public atfn(atfe paramatfe)
  {
    super(paramatfe);
  }
  
  protected String a()
  {
    return "StateChangeToOffFailedWhenRecv";
  }
  
  protected void a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
    }
    do
    {
      return;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Atgp.a + "-" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Atgp.b + "]");
    } while (!this.jdField_a_of_type_Atfe.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId));
    atfe.c(this.jdField_a_of_type_Atfe, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Atfi = new atgo(this.jdField_a_of_type_Atfe);
    this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
    this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Atfe.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Atfe.b();
      break label63;
      atfe.b(this.jdField_a_of_type_Atfe, 13, 5);
      atfe.c(this.jdField_a_of_type_Atfe, 13, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateAcceptByPCWhenToOffFailed)");
      this.jdField_a_of_type_Atfi = new atfh(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.b(this.jdField_a_of_type_Atfe, 13, 6);
      atfe.c(this.jdField_a_of_type_Atfe, 13, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateRefuseByPCWhenToOffFailed)");
      this.jdField_a_of_type_Atfi = new atga(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.b(this.jdField_a_of_type_Atfe, 13, 8);
      atfe.c(this.jdField_a_of_type_Atfe, 13, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateSenderCancelSendWhenToOffFailed)");
      this.jdField_a_of_type_Atfi = new atgh(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.b(this.jdField_a_of_type_Atfe, 13, 7);
      atfe.c(this.jdField_a_of_type_Atfe, 13, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
      this.jdField_a_of_type_Atfi = new atge(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.a(this.jdField_a_of_type_Atfe);
      atfe.b(this.jdField_a_of_type_Atfe, 13, 11);
      atfe.c(this.jdField_a_of_type_Atfe, 13, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateChangeToOffWhenToOffFailed)");
      this.jdField_a_of_type_Atfi = new atfp(this.jdField_a_of_type_Atfe);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe);
    b(paramInt1, paramInt2);
    atfe.a(this.jdField_a_of_type_Atfe, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Atfi = new atfx(this.jdField_a_of_type_Atfe);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (a("onSenderUploadException")) {
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Atfi = new atft(this.jdField_a_of_type_Atfe);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. StateWaitingRecvResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      atfe.a(this.jdField_a_of_type_Atfe);
      atfe.a(this.jdField_a_of_type_Atfe, 9, 11, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateLocalFailedWhenRecv)");
      this.jdField_a_of_type_Atfi = new atfx(this.jdField_a_of_type_Atfe);
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateChangeToOffFailedWhenRecv)");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((atvo.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Atfe.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    atfe.b(this.jdField_a_of_type_Atfe, 1, 0);
    atfe.c(this.jdField_a_of_type_Atfe, 1, 0);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atfi = new atfu(this.jdField_a_of_type_Atfe);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Atfi = new atfl(this.jdField_a_of_type_Atfe);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + " recv  success response of ask progress, not handle it");
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + " recv  failed response of ask progress, not handle it");
  }
  
  protected void d()
  {
    if (a("onSenderReplayComeOnRecv")) {
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe);
    atfe.a(this.jdField_a_of_type_Atfe, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Atfi = new atfx(this.jdField_a_of_type_Atfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfn
 * JD-Core Version:    0.7.0.1
 */