import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atny
  extends atnt
{
  public atny(atno paramatno)
  {
    super(paramatno);
  }
  
  protected String a()
  {
    return "StateChangeToOffFailedWhenRecv";
  }
  
  protected void a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
    }
    do
    {
      return;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Atno.jdField_a_of_type_Atnp.a + "-" + this.jdField_a_of_type_Atno.jdField_a_of_type_Atnp.b + "]");
    } while (!this.jdField_a_of_type_Atno.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId));
    atno.c(this.jdField_a_of_type_Atno, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Atnt = new atoz(this.jdField_a_of_type_Atno);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Atno.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Atno.b();
      break label63;
      atno.b(this.jdField_a_of_type_Atno, 13, 5);
      atno.c(this.jdField_a_of_type_Atno, 13, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateAcceptByPCWhenToOffFailed)");
      this.jdField_a_of_type_Atnt = new atns(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.b(this.jdField_a_of_type_Atno, 13, 6);
      atno.c(this.jdField_a_of_type_Atno, 13, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateRefuseByPCWhenToOffFailed)");
      this.jdField_a_of_type_Atnt = new atol(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.b(this.jdField_a_of_type_Atno, 13, 8);
      atno.c(this.jdField_a_of_type_Atno, 13, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateSenderCancelSendWhenToOffFailed)");
      this.jdField_a_of_type_Atnt = new atos(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.b(this.jdField_a_of_type_Atno, 13, 7);
      atno.c(this.jdField_a_of_type_Atno, 13, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
      this.jdField_a_of_type_Atnt = new atop(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.a(this.jdField_a_of_type_Atno);
      atno.b(this.jdField_a_of_type_Atno, 13, 11);
      atno.c(this.jdField_a_of_type_Atno, 13, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateChangeToOffWhenToOffFailed)");
      this.jdField_a_of_type_Atnt = new atoa(this.jdField_a_of_type_Atno);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    atno.a(this.jdField_a_of_type_Atno);
    b(paramInt1, paramInt2);
    atno.a(this.jdField_a_of_type_Atno, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Atnt = new atoi(this.jdField_a_of_type_Atno);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (a("onSenderUploadException")) {
      return;
    }
    atno.a(this.jdField_a_of_type_Atno, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Atnt = new atoe(this.jdField_a_of_type_Atno);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. StateWaitingRecvResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      atno.a(this.jdField_a_of_type_Atno);
      atno.a(this.jdField_a_of_type_Atno, 9, 11, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateLocalFailedWhenRecv)");
      this.jdField_a_of_type_Atnt = new atoi(this.jdField_a_of_type_Atno);
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateChangeToOffFailedWhenRecv)");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((auea.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Atno.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    atno.b(this.jdField_a_of_type_Atno, 1, 0);
    atno.c(this.jdField_a_of_type_Atno, 1, 0);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atnt = new atof(this.jdField_a_of_type_Atno);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    atno.a(this.jdField_a_of_type_Atno, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Atnt = new atnw(this.jdField_a_of_type_Atno);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + " recv  success response of ask progress, not handle it");
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + " recv  failed response of ask progress, not handle it");
  }
  
  protected void d()
  {
    if (a("onSenderReplayComeOnRecv")) {
      return;
    }
    atno.a(this.jdField_a_of_type_Atno);
    atno.a(this.jdField_a_of_type_Atno, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Atnt = new atoi(this.jdField_a_of_type_Atno);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atny
 * JD-Core Version:    0.7.0.1
 */