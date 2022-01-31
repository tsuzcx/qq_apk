import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aqzz
  extends aqyt
{
  public aqzz(aqyp paramaqyp)
  {
    super(paramaqyp);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenRecv";
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Aqyp.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Aqyp.d();
      break label63;
      aqyp.b(this.jdField_a_of_type_Aqyp, 11, 5);
      aqyp.c(this.jdField_a_of_type_Aqyp, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateAcceptByPC)");
      this.jdField_a_of_type_Aqyt = new aqyq(this.jdField_a_of_type_Aqyp);
      paramInt = i;
      continue;
      aqyp.b(this.jdField_a_of_type_Aqyp, 11, 6);
      aqyp.c(this.jdField_a_of_type_Aqyp, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateRefuseByPC)");
      this.jdField_a_of_type_Aqyt = new aqzj(this.jdField_a_of_type_Aqyp);
      paramInt = i;
      continue;
      aqyp.b(this.jdField_a_of_type_Aqyp, 11, 8);
      aqyp.c(this.jdField_a_of_type_Aqyp, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_Aqyt = new aqzq(this.jdField_a_of_type_Aqyp);
      paramInt = i;
      continue;
      aqyp.b(this.jdField_a_of_type_Aqyp, 11, 7);
      aqyp.c(this.jdField_a_of_type_Aqyp, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_Aqyt = new aqzn(this.jdField_a_of_type_Aqyp);
      paramInt = i;
      continue;
      aqyp.a(this.jdField_a_of_type_Aqyp);
      aqyp.b(this.jdField_a_of_type_Aqyp, 9, 11);
      aqyp.c(this.jdField_a_of_type_Aqyp, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateUploadingWhenRecv)");
      this.jdField_a_of_type_Aqyt = new aqzv(this.jdField_a_of_type_Aqyp);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    this.jdField_a_of_type_Aqyp.c(true);
    aqyp.a(this.jdField_a_of_type_Aqyp);
    b(paramInt1, paramInt2);
    aqyp.a(this.jdField_a_of_type_Aqyp, 9, 11);
    aqyp.a(this.jdField_a_of_type_Aqyp, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Aqyt = new aqzv(this.jdField_a_of_type_Aqyp);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqyp.a(this.jdField_a_of_type_Aqyp, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aqyt = new aqze(this.jdField_a_of_type_Aqyp);
  }
  
  protected void a(boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. StateWaitingRecvResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + " recv  success response of accept,  waiting the cmd of starting upload");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(1);
    if (!this.jdField_a_of_type_Aqyp.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(false);
    aqyp.b(this.jdField_a_of_type_Aqyp, 9, 10);
    aqyp.c(this.jdField_a_of_type_Aqyp, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Aqyt = new aqyy(this.jdField_a_of_type_Aqyp);
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]  recv failed!!");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    if ((arrr.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Aqyp.a(paramLong, localFileManagerEntity.peerUin);
    if (localFileManagerEntity.fProgress < 0.9F)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. start make progress pass to 100% directly");
      this.b = true;
      this.jdField_a_of_type_Aqyp.a(1.0F);
      return true;
    }
    f();
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqyp.a(this.jdField_a_of_type_Aqyp, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Aqyt = new aqyw(this.jdField_a_of_type_Aqyp);
  }
  
  protected void b(int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. onFailedOfLocalSomeThingHappen entity is null");
      return;
    }
    aqyp.b(this.jdField_a_of_type_Aqyp, 9, 10);
    aqyp.c(this.jdField_a_of_type_Aqyp, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Aqyt = new aqyy(this.jdField_a_of_type_Aqyp);
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (a("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + " recv  success response of ask progress,  waiting the notify of progress");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(2);
    if (!this.jdField_a_of_type_Aqyp.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + "ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(false);
    aqyp.b(this.jdField_a_of_type_Aqyp, 9, 10);
    aqyp.c(this.jdField_a_of_type_Aqyp, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Aqyt = new aqyy(this.jdField_a_of_type_Aqyp);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. onPauseTrans entity is null");
      return;
    }
    aqyp.b(this.jdField_a_of_type_Aqyp, 10, -2);
    aqyp.c(this.jdField_a_of_type_Aqyp, 10, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateWaitResultWhenPause)");
    this.jdField_a_of_type_Aqyt = new aqzy(this.jdField_a_of_type_Aqyp);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(true);
    aqyp.a(this.jdField_a_of_type_Aqyp);
    aqyp.b(this.jdField_a_of_type_Aqyp, 9, 11);
    aqyp.c(this.jdField_a_of_type_Aqyp, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Aqyt = new aqzv(this.jdField_a_of_type_Aqyp);
  }
  
  protected void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " you had recv the file, but sender replay time out!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Araa.a);
    this.jdField_a_of_type_Aqyp.c(1);
    if (!this.jdField_a_of_type_Aqyp.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(false);
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_Araa.a < 9223372036854775807L)
    {
      aqyp.a(this.jdField_a_of_type_Aqyp, 9, 10, true);
      a("StateChangeToOffFailedWhenRecv");
      this.jdField_a_of_type_Aqyt = new aqyy(this.jdField_a_of_type_Aqyp);
      this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
      return;
    }
    aqyp.a(this.jdField_a_of_type_Aqyp, 9, 12, true);
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aqyt = new aqze(this.jdField_a_of_type_Aqyp);
  }
  
  protected void f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. doSomeThingOnUploadDone entity is null");
      return;
    }
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    localFileManagerEntity.fProgress = 0.0F;
    localFileManagerEntity.setCloudType(1);
    aqyp.b(this.jdField_a_of_type_Aqyp, 1, 0);
    aqyp.c(this.jdField_a_of_type_Aqyp, 1, 2);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + ". doSomeThingOnUploadDone start recv offline file....)");
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 1);
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Aqyt = new aqzf(this.jdField_a_of_type_Aqyp);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " you had recv the file, but  ask progress time out!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Araa.a);
    this.jdField_a_of_type_Aqyp.c(2);
    if (!this.jdField_a_of_type_Aqyp.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(false);
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_Araa.a < 9223372036854775807L)
    {
      aqyp.a(this.jdField_a_of_type_Aqyp, 9, 10, true);
      a("StateChangeToOffFailedWhenRecv");
      this.jdField_a_of_type_Aqyt = new aqyy(this.jdField_a_of_type_Aqyp);
      this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
      return;
    }
    aqyp.a(this.jdField_a_of_type_Aqyp, 9, 12, true);
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aqyt = new aqze(this.jdField_a_of_type_Aqyp);
  }
  
  protected void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzz
 * JD-Core Version:    0.7.0.1
 */