import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aqvq
  extends aquk
{
  public aqvq(aqug paramaqug)
  {
    super(paramaqug);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenRecv";
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
      this.jdField_a_of_type_Aqug.d();
      break label63;
      aqug.b(this.jdField_a_of_type_Aqug, 11, 5);
      aqug.c(this.jdField_a_of_type_Aqug, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateAcceptByPC)");
      this.jdField_a_of_type_Aquk = new aquh(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 11, 6);
      aqug.c(this.jdField_a_of_type_Aqug, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateRefuseByPC)");
      this.jdField_a_of_type_Aquk = new aqva(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 11, 8);
      aqug.c(this.jdField_a_of_type_Aqug, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_Aquk = new aqvh(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 11, 7);
      aqug.c(this.jdField_a_of_type_Aqug, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_Aquk = new aqve(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.a(this.jdField_a_of_type_Aqug);
      aqug.b(this.jdField_a_of_type_Aqug, 9, 11);
      aqug.c(this.jdField_a_of_type_Aqug, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateUploadingWhenRecv)");
      this.jdField_a_of_type_Aquk = new aqvm(this.jdField_a_of_type_Aqug);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    this.jdField_a_of_type_Aqug.c(true);
    aqug.a(this.jdField_a_of_type_Aqug);
    b(paramInt1, paramInt2);
    aqug.a(this.jdField_a_of_type_Aqug, 9, 11);
    aqug.a(this.jdField_a_of_type_Aqug, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Aquk = new aqvm(this.jdField_a_of_type_Aqug);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aquk = new aquv(this.jdField_a_of_type_Aqug);
  }
  
  protected void a(boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. StateWaitingRecvResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + " recv  success response of accept,  waiting the cmd of starting upload");
      return;
    }
    this.jdField_a_of_type_Aqug.c(1);
    if (!this.jdField_a_of_type_Aqug.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Aqug.c(false);
    aqug.b(this.jdField_a_of_type_Aqug, 9, 10);
    aqug.c(this.jdField_a_of_type_Aqug, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Aquk = new aqup(this.jdField_a_of_type_Aqug);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]  recv failed!!");
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
    if ((arni.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Aqug.a(paramLong, localFileManagerEntity.peerUin);
    if (localFileManagerEntity.fProgress < 0.9F)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. start make progress pass to 100% directly");
      this.b = true;
      this.jdField_a_of_type_Aqug.a(1.0F);
      return true;
    }
    f();
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Aquk = new aqun(this.jdField_a_of_type_Aqug);
  }
  
  protected void b(int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. onFailedOfLocalSomeThingHappen entity is null");
      return;
    }
    aqug.b(this.jdField_a_of_type_Aqug, 9, 10);
    aqug.c(this.jdField_a_of_type_Aqug, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Aquk = new aqup(this.jdField_a_of_type_Aqug);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (a("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + " recv  success response of ask progress,  waiting the notify of progress");
      return;
    }
    this.jdField_a_of_type_Aqug.c(2);
    if (!this.jdField_a_of_type_Aqug.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + "ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Aqug.c(false);
    aqug.b(this.jdField_a_of_type_Aqug, 9, 10);
    aqug.c(this.jdField_a_of_type_Aqug, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Aquk = new aqup(this.jdField_a_of_type_Aqug);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. onPauseTrans entity is null");
      return;
    }
    aqug.b(this.jdField_a_of_type_Aqug, 10, -2);
    aqug.c(this.jdField_a_of_type_Aqug, 10, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateWaitResultWhenPause)");
    this.jdField_a_of_type_Aquk = new aqvp(this.jdField_a_of_type_Aqug);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    this.jdField_a_of_type_Aqug.c(true);
    aqug.a(this.jdField_a_of_type_Aqug);
    aqug.b(this.jdField_a_of_type_Aqug, 9, 11);
    aqug.c(this.jdField_a_of_type_Aqug, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Aquk = new aqvm(this.jdField_a_of_type_Aqug);
  }
  
  protected void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " you had recv the file, but sender replay time out!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a);
    this.jdField_a_of_type_Aqug.c(1);
    if (!this.jdField_a_of_type_Aqug.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Aqug.c(false);
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a < 9223372036854775807L)
    {
      aqug.a(this.jdField_a_of_type_Aqug, 9, 10, true);
      a("StateChangeToOffFailedWhenRecv");
      this.jdField_a_of_type_Aquk = new aqup(this.jdField_a_of_type_Aqug);
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 9, 12, true);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aquk = new aquv(this.jdField_a_of_type_Aqug);
  }
  
  protected void f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. doSomeThingOnUploadDone entity is null");
      return;
    }
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    localFileManagerEntity.fProgress = 0.0F;
    localFileManagerEntity.setCloudType(1);
    aqug.b(this.jdField_a_of_type_Aqug, 1, 0);
    aqug.c(this.jdField_a_of_type_Aqug, 1, 2);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + ". doSomeThingOnUploadDone start recv offline file....)");
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqug.jdField_a_of_type_Long, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 1);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Aquk = new aquw(this.jdField_a_of_type_Aqug);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " you had recv the file, but  ask progress time out!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a);
    this.jdField_a_of_type_Aqug.c(2);
    if (!this.jdField_a_of_type_Aqug.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Aqug.c(false);
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a < 9223372036854775807L)
    {
      aqug.a(this.jdField_a_of_type_Aqug, 9, 10, true);
      a("StateChangeToOffFailedWhenRecv");
      this.jdField_a_of_type_Aquk = new aqup(this.jdField_a_of_type_Aqug);
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 9, 12, true);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aquk = new aquv(this.jdField_a_of_type_Aqug);
  }
  
  protected void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvq
 * JD-Core Version:    0.7.0.1
 */