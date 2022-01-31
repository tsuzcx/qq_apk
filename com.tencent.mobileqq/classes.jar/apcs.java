import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apcs
  extends apbm
{
  public apcs(apbi paramapbi)
  {
    super(paramapbi);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenRecv";
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Apbi.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Apbi.d();
      break label63;
      apbi.b(this.jdField_a_of_type_Apbi, 11, 5);
      apbi.c(this.jdField_a_of_type_Apbi, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateAcceptByPC)");
      this.jdField_a_of_type_Apbm = new apbj(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.b(this.jdField_a_of_type_Apbi, 11, 6);
      apbi.c(this.jdField_a_of_type_Apbi, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateRefuseByPC)");
      this.jdField_a_of_type_Apbm = new apcc(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.b(this.jdField_a_of_type_Apbi, 11, 8);
      apbi.c(this.jdField_a_of_type_Apbi, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_Apbm = new apcj(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.b(this.jdField_a_of_type_Apbi, 11, 7);
      apbi.c(this.jdField_a_of_type_Apbi, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_Apbm = new apcg(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.a(this.jdField_a_of_type_Apbi);
      apbi.b(this.jdField_a_of_type_Apbi, 9, 11);
      apbi.c(this.jdField_a_of_type_Apbi, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateUploadingWhenRecv)");
      this.jdField_a_of_type_Apbm = new apco(this.jdField_a_of_type_Apbi);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    this.jdField_a_of_type_Apbi.c(true);
    apbi.a(this.jdField_a_of_type_Apbi);
    b(paramInt1, paramInt2);
    apbi.a(this.jdField_a_of_type_Apbi, 9, 11);
    apbi.a(this.jdField_a_of_type_Apbi, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Apbm = new apco(this.jdField_a_of_type_Apbi);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Apbm = new apbx(this.jdField_a_of_type_Apbi);
  }
  
  protected void a(boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. StateWaitingRecvResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + " recv  success response of accept,  waiting the cmd of starting upload");
      return;
    }
    this.jdField_a_of_type_Apbi.c(1);
    if (!this.jdField_a_of_type_Apbi.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Apbi.c(false);
    apbi.b(this.jdField_a_of_type_Apbi, 9, 10);
    apbi.c(this.jdField_a_of_type_Apbi, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Apbm = new apbr(this.jdField_a_of_type_Apbi);
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]  recv failed!!");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    if ((apug.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Apbi.a(paramLong, localFileManagerEntity.peerUin);
    if (localFileManagerEntity.fProgress < 0.9F)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. start make progress pass to 100% directly");
      this.b = true;
      this.jdField_a_of_type_Apbi.a(1.0F);
      return true;
    }
    f();
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Apbm = new apbp(this.jdField_a_of_type_Apbi);
  }
  
  protected void b(int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. onFailedOfLocalSomeThingHappen entity is null");
      return;
    }
    apbi.b(this.jdField_a_of_type_Apbi, 9, 10);
    apbi.c(this.jdField_a_of_type_Apbi, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Apbm = new apbr(this.jdField_a_of_type_Apbi);
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (a("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + " recv  success response of ask progress,  waiting the notify of progress");
      return;
    }
    this.jdField_a_of_type_Apbi.c(2);
    if (!this.jdField_a_of_type_Apbi.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + "ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Apbi.c(false);
    apbi.b(this.jdField_a_of_type_Apbi, 9, 10);
    apbi.c(this.jdField_a_of_type_Apbi, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Apbm = new apbr(this.jdField_a_of_type_Apbi);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. onPauseTrans entity is null");
      return;
    }
    apbi.b(this.jdField_a_of_type_Apbi, 10, -2);
    apbi.c(this.jdField_a_of_type_Apbi, 10, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateWaitResultWhenPause)");
    this.jdField_a_of_type_Apbm = new apcr(this.jdField_a_of_type_Apbi);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    this.jdField_a_of_type_Apbi.c(true);
    apbi.a(this.jdField_a_of_type_Apbi);
    apbi.b(this.jdField_a_of_type_Apbi, 9, 11);
    apbi.c(this.jdField_a_of_type_Apbi, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Apbm = new apco(this.jdField_a_of_type_Apbi);
  }
  
  protected void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " you had recv the file, but sender replay time out!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.a);
    this.jdField_a_of_type_Apbi.c(1);
    if (!this.jdField_a_of_type_Apbi.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Apbi.c(false);
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.a < 9223372036854775807L)
    {
      apbi.a(this.jdField_a_of_type_Apbi, 9, 10, true);
      a("StateChangeToOffFailedWhenRecv");
      this.jdField_a_of_type_Apbm = new apbr(this.jdField_a_of_type_Apbi);
      this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 9, 12, true);
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Apbm = new apbx(this.jdField_a_of_type_Apbi);
  }
  
  protected void f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. doSomeThingOnUploadDone entity is null");
      return;
    }
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    localFileManagerEntity.fProgress = 0.0F;
    localFileManagerEntity.setCloudType(1);
    apbi.b(this.jdField_a_of_type_Apbi, 1, 0);
    apbi.c(this.jdField_a_of_type_Apbi, 1, 2);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + ". doSomeThingOnUploadDone start recv offline file....)");
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Apbi.jdField_a_of_type_Long, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 1);
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Apbm = new apby(this.jdField_a_of_type_Apbi);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " you had recv the file, but  ask progress time out!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.a);
    this.jdField_a_of_type_Apbi.c(2);
    if (!this.jdField_a_of_type_Apbi.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Apbi.c(false);
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.a < 9223372036854775807L)
    {
      apbi.a(this.jdField_a_of_type_Apbi, 9, 10, true);
      a("StateChangeToOffFailedWhenRecv");
      this.jdField_a_of_type_Apbm = new apbr(this.jdField_a_of_type_Apbi);
      this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 9, 12, true);
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Apbm = new apbx(this.jdField_a_of_type_Apbi);
  }
  
  protected void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apcs
 * JD-Core Version:    0.7.0.1
 */