import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aqzy
  extends aqyt
{
  public aqzy(aqyp paramaqyp)
  {
    super(paramaqyp);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqyp.b(this.jdField_a_of_type_Aqyp, 9, 10);
    aqyp.c(this.jdField_a_of_type_Aqyp, 9, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Aqyt = new aqzz(this.jdField_a_of_type_Aqyp);
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
      aqyp.b(this.jdField_a_of_type_Aqyp, 10, 5);
      aqyp.c(this.jdField_a_of_type_Aqyp, 10, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateAcceptByPCWhenPause)");
      this.jdField_a_of_type_Aqyt = new aqyr(this.jdField_a_of_type_Aqyp);
      paramInt = i;
      continue;
      aqyp.b(this.jdField_a_of_type_Aqyp, 10, 6);
      aqyp.c(this.jdField_a_of_type_Aqyp, 10, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateRefuseByPCWhenPause)");
      this.jdField_a_of_type_Aqyt = new aqzk(this.jdField_a_of_type_Aqyp);
      paramInt = i;
      continue;
      aqyp.b(this.jdField_a_of_type_Aqyp, 10, 8);
      aqyp.c(this.jdField_a_of_type_Aqyp, 10, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateSenderCancelSendWhenPause)");
      this.jdField_a_of_type_Aqyt = new aqzr(this.jdField_a_of_type_Aqyp);
      paramInt = i;
      continue;
      aqyp.b(this.jdField_a_of_type_Aqyp, 10, 7);
      aqyp.c(this.jdField_a_of_type_Aqyp, 10, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateSaveToWeiYunByPCWhenPause)");
      this.jdField_a_of_type_Aqyt = new aqzo(this.jdField_a_of_type_Aqyp);
      paramInt = i;
      continue;
      aqyp.a(this.jdField_a_of_type_Aqyp);
      aqyp.b(this.jdField_a_of_type_Aqyp, 10, 11);
      aqyp.c(this.jdField_a_of_type_Aqyp, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_Aqyt = new aqzu(this.jdField_a_of_type_Aqyp);
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
    aqyp.a(this.jdField_a_of_type_Aqyp, 10, 11);
    aqyp.a(this.jdField_a_of_type_Aqyp, 10, 14, false);
    a("StateUploadingWhenPause");
    this.jdField_a_of_type_Aqyt = new aqzu(this.jdField_a_of_type_Aqyp);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqyp.a(this.jdField_a_of_type_Aqyp, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Aqyt = new aqzd(this.jdField_a_of_type_Aqyp);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. onRecvOnLineFileResult entity is null");
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
    aqyp.b(this.jdField_a_of_type_Aqyp, 10, 10);
    aqyp.c(this.jdField_a_of_type_Aqyp, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Aqyt = new aqyx(this.jdField_a_of_type_Aqyp);
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
    localFileManagerEntity.fProgress = 0.0F;
    if ((arrr.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Aqyp.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    aqyp.b(this.jdField_a_of_type_Aqyp, 1, 3);
    aqyp.c(this.jdField_a_of_type_Aqyp, 1, 3);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateUploadoneWhenPause)");
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aqyt = new aqzx(this.jdField_a_of_type_Aqyp);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqyp.a(this.jdField_a_of_type_Aqyp, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.jdField_a_of_type_Aqyt = new aqyv(this.jdField_a_of_type_Aqyp);
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
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(false);
    aqyp.b(this.jdField_a_of_type_Aqyp, 10, 10);
    aqyp.c(this.jdField_a_of_type_Aqyp, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Aqyt = new aqyx(this.jdField_a_of_type_Aqyp);
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
    aqyp.b(this.jdField_a_of_type_Aqyp, 10, 11);
    aqyp.c(this.jdField_a_of_type_Aqyp, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateUploadingWhenPause)");
    this.jdField_a_of_type_Aqyt = new aqzu(this.jdField_a_of_type_Aqyp);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + "onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Araa.a);
    this.jdField_a_of_type_Aqyp.c(1);
    if (!this.jdField_a_of_type_Aqyp.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(false);
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_Araa.a < 9223372036854775807L)
    {
      aqyp.a(this.jdField_a_of_type_Aqyp, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Aqyt = new aqyx(this.jdField_a_of_type_Aqyp);
      return;
    }
    aqyp.a(this.jdField_a_of_type_Aqyp, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Aqyt = new aqzd(this.jdField_a_of_type_Aqyp);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Araa.a);
    this.jdField_a_of_type_Aqyp.c(2);
    if (!this.jdField_a_of_type_Aqyp.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aqyt.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Aqyp.c(false);
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_Araa.a < 9223372036854775807L)
    {
      aqyp.a(this.jdField_a_of_type_Aqyp, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Aqyt = new aqyx(this.jdField_a_of_type_Aqyp);
      return;
    }
    aqyp.a(this.jdField_a_of_type_Aqyp, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Aqyt = new aqzd(this.jdField_a_of_type_Aqyp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzy
 * JD-Core Version:    0.7.0.1
 */