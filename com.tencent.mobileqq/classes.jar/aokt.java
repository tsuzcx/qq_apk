import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aokt
  extends aoko
{
  public aokt(aokk paramaokk)
  {
    super(paramaokk);
  }
  
  protected String a()
  {
    return "StateChangeToOffFailedWhenRecv";
  }
  
  protected void a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
    }
    do
    {
      return;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Aolv.a + "-" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Aolv.b + "]");
    } while (!this.jdField_a_of_type_Aokk.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId));
    aokk.c(this.jdField_a_of_type_Aokk, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Aoko = new aolu(this.jdField_a_of_type_Aokk);
    this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
    this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Aokk.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Aokk.b();
      break label63;
      aokk.b(this.jdField_a_of_type_Aokk, 13, 5);
      aokk.c(this.jdField_a_of_type_Aokk, 13, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateAcceptByPCWhenToOffFailed)");
      this.jdField_a_of_type_Aoko = new aokn(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.b(this.jdField_a_of_type_Aokk, 13, 6);
      aokk.c(this.jdField_a_of_type_Aokk, 13, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateRefuseByPCWhenToOffFailed)");
      this.jdField_a_of_type_Aoko = new aolg(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.b(this.jdField_a_of_type_Aokk, 13, 8);
      aokk.c(this.jdField_a_of_type_Aokk, 13, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateSenderCancelSendWhenToOffFailed)");
      this.jdField_a_of_type_Aoko = new aoln(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.b(this.jdField_a_of_type_Aokk, 13, 7);
      aokk.c(this.jdField_a_of_type_Aokk, 13, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
      this.jdField_a_of_type_Aoko = new aolk(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.a(this.jdField_a_of_type_Aokk);
      aokk.b(this.jdField_a_of_type_Aokk, 13, 11);
      aokk.c(this.jdField_a_of_type_Aokk, 13, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateChangeToOffWhenToOffFailed)");
      this.jdField_a_of_type_Aoko = new aokv(this.jdField_a_of_type_Aokk);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk);
    b(paramInt1, paramInt2);
    aokk.a(this.jdField_a_of_type_Aokk, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Aoko = new aold(this.jdField_a_of_type_Aokk);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (a("onSenderUploadException")) {
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aoko = new aokz(this.jdField_a_of_type_Aokk);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. StateWaitingRecvResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      aokk.a(this.jdField_a_of_type_Aokk);
      aokk.a(this.jdField_a_of_type_Aokk, 9, 11, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateLocalFailedWhenRecv)");
      this.jdField_a_of_type_Aoko = new aold(this.jdField_a_of_type_Aokk);
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateChangeToOffFailedWhenRecv)");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((apck.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Aokk.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    aokk.b(this.jdField_a_of_type_Aokk, 1, 0);
    aokk.c(this.jdField_a_of_type_Aokk, 1, 0);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aoko = new aola(this.jdField_a_of_type_Aokk);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Aoko = new aokr(this.jdField_a_of_type_Aokk);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + " recv  success response of ask progress, not handle it");
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + " recv  failed response of ask progress, not handle it");
  }
  
  protected void d()
  {
    if (a("onSenderReplayComeOnRecv")) {
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk);
    aokk.a(this.jdField_a_of_type_Aokk, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Aoko = new aold(this.jdField_a_of_type_Aokk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aokt
 * JD-Core Version:    0.7.0.1
 */