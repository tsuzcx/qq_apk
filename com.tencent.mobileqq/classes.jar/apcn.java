import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apcn
  extends apbi
{
  public apcn(apbe paramapbe)
  {
    super(paramapbe);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbe.b(this.jdField_a_of_type_Apbe, 9, 10);
    apbe.c(this.jdField_a_of_type_Apbe, 9, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Apbi = new apco(this.jdField_a_of_type_Apbe);
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Apbe.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Apbe.d();
      break label63;
      apbe.b(this.jdField_a_of_type_Apbe, 10, 5);
      apbe.c(this.jdField_a_of_type_Apbe, 10, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateAcceptByPCWhenPause)");
      this.jdField_a_of_type_Apbi = new apbg(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.b(this.jdField_a_of_type_Apbe, 10, 6);
      apbe.c(this.jdField_a_of_type_Apbe, 10, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateRefuseByPCWhenPause)");
      this.jdField_a_of_type_Apbi = new apbz(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.b(this.jdField_a_of_type_Apbe, 10, 8);
      apbe.c(this.jdField_a_of_type_Apbe, 10, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateSenderCancelSendWhenPause)");
      this.jdField_a_of_type_Apbi = new apcg(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.b(this.jdField_a_of_type_Apbe, 10, 7);
      apbe.c(this.jdField_a_of_type_Apbe, 10, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateSaveToWeiYunByPCWhenPause)");
      this.jdField_a_of_type_Apbi = new apcd(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.a(this.jdField_a_of_type_Apbe);
      apbe.b(this.jdField_a_of_type_Apbe, 10, 11);
      apbe.c(this.jdField_a_of_type_Apbe, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_Apbi = new apcj(this.jdField_a_of_type_Apbe);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    this.jdField_a_of_type_Apbe.c(true);
    apbe.a(this.jdField_a_of_type_Apbe);
    b(paramInt1, paramInt2);
    apbe.a(this.jdField_a_of_type_Apbe, 10, 11);
    apbe.a(this.jdField_a_of_type_Apbe, 10, 14, false);
    a("StateUploadingWhenPause");
    this.jdField_a_of_type_Apbi = new apcj(this.jdField_a_of_type_Apbe);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbe.a(this.jdField_a_of_type_Apbe, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Apbi = new apbs(this.jdField_a_of_type_Apbe);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. onRecvOnLineFileResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + " recv  success response of accept,  waiting the cmd of starting upload");
      return;
    }
    this.jdField_a_of_type_Apbe.c(1);
    if (!this.jdField_a_of_type_Apbe.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbi.a() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Apbe.c(false);
    apbe.b(this.jdField_a_of_type_Apbe, 10, 10);
    apbe.c(this.jdField_a_of_type_Apbe, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Apbi = new apbm(this.jdField_a_of_type_Apbe);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]  recv failed!!");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((apue.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Apbe.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    apbe.b(this.jdField_a_of_type_Apbe, 1, 3);
    apbe.c(this.jdField_a_of_type_Apbe, 1, 3);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateUploadoneWhenPause)");
    this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Apbi = new apcm(this.jdField_a_of_type_Apbe);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbe.a(this.jdField_a_of_type_Apbe, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.jdField_a_of_type_Apbi = new apbk(this.jdField_a_of_type_Apbe);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (a("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + " recv  success response of ask progress,  waiting the notify of progress");
      return;
    }
    this.jdField_a_of_type_Apbe.c(2);
    if (!this.jdField_a_of_type_Apbe.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbi.a() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Apbe.c(false);
    apbe.b(this.jdField_a_of_type_Apbe, 10, 10);
    apbe.c(this.jdField_a_of_type_Apbe, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Apbi = new apbm(this.jdField_a_of_type_Apbe);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    this.jdField_a_of_type_Apbe.c(true);
    apbe.a(this.jdField_a_of_type_Apbe);
    apbe.b(this.jdField_a_of_type_Apbe, 10, 11);
    apbe.c(this.jdField_a_of_type_Apbe, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateUploadingWhenPause)");
    this.jdField_a_of_type_Apbi = new apcj(this.jdField_a_of_type_Apbe);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbi.a() + "onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbi.a() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Apcp.a);
    this.jdField_a_of_type_Apbe.c(1);
    if (!this.jdField_a_of_type_Apbe.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbi.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Apbe.c(false);
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_Apcp.a < 9223372036854775807L)
    {
      apbe.a(this.jdField_a_of_type_Apbe, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Apbi = new apbm(this.jdField_a_of_type_Apbe);
      return;
    }
    apbe.a(this.jdField_a_of_type_Apbe, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Apbi = new apbs(this.jdField_a_of_type_Apbe);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbi.a() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Apcp.a);
    this.jdField_a_of_type_Apbe.c(2);
    if (!this.jdField_a_of_type_Apbe.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbi.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Apbe.c(false);
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_Apcp.a < 9223372036854775807L)
    {
      apbe.a(this.jdField_a_of_type_Apbe, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Apbi = new apbm(this.jdField_a_of_type_Apbe);
      return;
    }
    apbe.a(this.jdField_a_of_type_Apbe, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Apbi = new apbs(this.jdField_a_of_type_Apbe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apcn
 * JD-Core Version:    0.7.0.1
 */