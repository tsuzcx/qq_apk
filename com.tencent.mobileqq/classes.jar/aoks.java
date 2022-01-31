import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aoks
  extends aoko
{
  public aoks(aokk paramaokk)
  {
    super(paramaokk);
  }
  
  protected String a()
  {
    return "StateChangeToOffFailedWhenPause";
  }
  
  protected void a()
  {
    if (a("onResumeTrans")) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
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
      aokk.b(this.jdField_a_of_type_Aokk, 10, 5);
      aokk.c(this.jdField_a_of_type_Aokk, 10, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateAcceptByPCWhenPause)");
      this.jdField_a_of_type_Aoko = new aokm(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.b(this.jdField_a_of_type_Aokk, 10, 6);
      aokk.c(this.jdField_a_of_type_Aokk, 10, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateRefuseByPCWhenPause)");
      this.jdField_a_of_type_Aoko = new aolf(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.b(this.jdField_a_of_type_Aokk, 10, 8);
      aokk.c(this.jdField_a_of_type_Aokk, 10, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateSenderCancelSendWhenPause)");
      this.jdField_a_of_type_Aoko = new aolm(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.b(this.jdField_a_of_type_Aokk, 10, 7);
      aokk.c(this.jdField_a_of_type_Aokk, 10, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateSaveToWeiYunByPCWhenPause)");
      this.jdField_a_of_type_Aoko = new aolj(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.a(this.jdField_a_of_type_Aokk);
      aokk.b(this.jdField_a_of_type_Aokk, 10, 11);
      aokk.c(this.jdField_a_of_type_Aokk, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateChangeToOffWhenPause)");
      this.jdField_a_of_type_Aoko = new aoku(this.jdField_a_of_type_Aokk);
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
    aokk.a(this.jdField_a_of_type_Aokk, 10, 11);
    aokk.a(this.jdField_a_of_type_Aokk, 10, 14, false);
    a("StateUploadingWhenPause");
    this.jdField_a_of_type_Aoko = new aolp(this.jdField_a_of_type_Aokk);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Aoko = new aoky(this.jdField_a_of_type_Aokk);
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
      aokk.a(this.jdField_a_of_type_Aokk, 10, 11, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateLocalFailedWhenPause)");
      this.jdField_a_of_type_Aoko = new aolc(this.jdField_a_of_type_Aokk);
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateChangeToOffFailedWhenPause)");
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
    aokk.b(this.jdField_a_of_type_Aokk, 1, 3);
    aokk.c(this.jdField_a_of_type_Aokk, 1, 3);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateUploadoneWhenPause)");
    this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aoko = new aols(this.jdField_a_of_type_Aokk);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.jdField_a_of_type_Aoko = new aokq(this.jdField_a_of_type_Aokk);
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
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk);
    aokk.a(this.jdField_a_of_type_Aokk, 10, 11, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateLocalFailedWhenPause)");
    this.jdField_a_of_type_Aoko = new aolc(this.jdField_a_of_type_Aokk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoks
 * JD-Core Version:    0.7.0.1
 */