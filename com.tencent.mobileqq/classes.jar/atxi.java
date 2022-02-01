import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atxi
  extends atxd
{
  public atxi(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateChangeToOffFailedWhenRecv";
  }
  
  protected void a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
    }
    do
    {
      return;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Atwz.a + "-" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Atwz.b + "]");
    } while (!this.jdField_a_of_type_Atwy.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId));
    atwy.c(this.jdField_a_of_type_Atwy, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Atxd = new atyj(this.jdField_a_of_type_Atwy);
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Atwy.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Atwy.b();
      break label63;
      atwy.b(this.jdField_a_of_type_Atwy, 13, 5);
      atwy.c(this.jdField_a_of_type_Atwy, 13, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateAcceptByPCWhenToOffFailed)");
      this.jdField_a_of_type_Atxd = new atxc(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.b(this.jdField_a_of_type_Atwy, 13, 6);
      atwy.c(this.jdField_a_of_type_Atwy, 13, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateRefuseByPCWhenToOffFailed)");
      this.jdField_a_of_type_Atxd = new atxv(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.b(this.jdField_a_of_type_Atwy, 13, 8);
      atwy.c(this.jdField_a_of_type_Atwy, 13, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateSenderCancelSendWhenToOffFailed)");
      this.jdField_a_of_type_Atxd = new atyc(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.b(this.jdField_a_of_type_Atwy, 13, 7);
      atwy.c(this.jdField_a_of_type_Atwy, 13, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
      this.jdField_a_of_type_Atxd = new atxz(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.a(this.jdField_a_of_type_Atwy);
      atwy.b(this.jdField_a_of_type_Atwy, 13, 11);
      atwy.c(this.jdField_a_of_type_Atwy, 13, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateChangeToOffWhenToOffFailed)");
      this.jdField_a_of_type_Atxd = new atxk(this.jdField_a_of_type_Atwy);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy);
    b(paramInt1, paramInt2);
    atwy.a(this.jdField_a_of_type_Atwy, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Atxd = new atxs(this.jdField_a_of_type_Atwy);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (a("onSenderUploadException")) {
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Atxd = new atxo(this.jdField_a_of_type_Atwy);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. StateWaitingRecvResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      atwy.a(this.jdField_a_of_type_Atwy);
      atwy.a(this.jdField_a_of_type_Atwy, 9, 11, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateLocalFailedWhenRecv)");
      this.jdField_a_of_type_Atxd = new atxs(this.jdField_a_of_type_Atwy);
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateChangeToOffFailedWhenRecv)");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((aunj.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Atwy.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    atwy.b(this.jdField_a_of_type_Atwy, 1, 0);
    atwy.c(this.jdField_a_of_type_Atwy, 1, 0);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atxd = new atxp(this.jdField_a_of_type_Atwy);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Atxd = new atxg(this.jdField_a_of_type_Atwy);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + " recv  success response of ask progress, not handle it");
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + " recv  failed response of ask progress, not handle it");
  }
  
  protected void d()
  {
    if (a("onSenderReplayComeOnRecv")) {
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy);
    atwy.a(this.jdField_a_of_type_Atwy, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Atxd = new atxs(this.jdField_a_of_type_Atwy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxi
 * JD-Core Version:    0.7.0.1
 */