import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class asks
  extends asjn
{
  public asks(asji paramasji)
  {
    super(paramasji);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    asji.b(this.jdField_a_of_type_Asji, 9, 10);
    asji.c(this.jdField_a_of_type_Asji, 9, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Asjn = new askt(this.jdField_a_of_type_Asji);
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Asji.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Asji.d();
      break label63;
      asji.b(this.jdField_a_of_type_Asji, 10, 5);
      asji.c(this.jdField_a_of_type_Asji, 10, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateAcceptByPCWhenPause)");
      this.jdField_a_of_type_Asjn = new asjl(this.jdField_a_of_type_Asji);
      paramInt = i;
      continue;
      asji.b(this.jdField_a_of_type_Asji, 10, 6);
      asji.c(this.jdField_a_of_type_Asji, 10, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateRefuseByPCWhenPause)");
      this.jdField_a_of_type_Asjn = new aske(this.jdField_a_of_type_Asji);
      paramInt = i;
      continue;
      asji.b(this.jdField_a_of_type_Asji, 10, 8);
      asji.c(this.jdField_a_of_type_Asji, 10, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateSenderCancelSendWhenPause)");
      this.jdField_a_of_type_Asjn = new askl(this.jdField_a_of_type_Asji);
      paramInt = i;
      continue;
      asji.b(this.jdField_a_of_type_Asji, 10, 7);
      asji.c(this.jdField_a_of_type_Asji, 10, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateSaveToWeiYunByPCWhenPause)");
      this.jdField_a_of_type_Asjn = new aski(this.jdField_a_of_type_Asji);
      paramInt = i;
      continue;
      asji.a(this.jdField_a_of_type_Asji);
      asji.b(this.jdField_a_of_type_Asji, 10, 11);
      asji.c(this.jdField_a_of_type_Asji, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_Asjn = new asko(this.jdField_a_of_type_Asji);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    this.jdField_a_of_type_Asji.c(true);
    asji.a(this.jdField_a_of_type_Asji);
    b(paramInt1, paramInt2);
    asji.a(this.jdField_a_of_type_Asji, 10, 11);
    asji.a(this.jdField_a_of_type_Asji, 10, 14, false);
    a("StateUploadingWhenPause");
    this.jdField_a_of_type_Asjn = new asko(this.jdField_a_of_type_Asji);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    asji.a(this.jdField_a_of_type_Asji, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Asjn = new asjx(this.jdField_a_of_type_Asji);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. onRecvOnLineFileResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + " recv  success response of accept,  waiting the cmd of starting upload");
      return;
    }
    this.jdField_a_of_type_Asji.c(1);
    if (!this.jdField_a_of_type_Asji.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Asjn.a() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Asji.c(false);
    asji.b(this.jdField_a_of_type_Asji, 10, 10);
    asji.c(this.jdField_a_of_type_Asji, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Asjn = new asjr(this.jdField_a_of_type_Asji);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]  recv failed!!");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((aszt.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Asji.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    asji.b(this.jdField_a_of_type_Asji, 1, 3);
    asji.c(this.jdField_a_of_type_Asji, 1, 3);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateUploadoneWhenPause)");
    this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Asjn = new askr(this.jdField_a_of_type_Asji);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    asji.a(this.jdField_a_of_type_Asji, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.jdField_a_of_type_Asjn = new asjp(this.jdField_a_of_type_Asji);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (a("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + " recv  success response of ask progress,  waiting the notify of progress");
      return;
    }
    this.jdField_a_of_type_Asji.c(2);
    if (!this.jdField_a_of_type_Asji.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Asjn.a() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Asji.c(false);
    asji.b(this.jdField_a_of_type_Asji, 10, 10);
    asji.c(this.jdField_a_of_type_Asji, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Asjn = new asjr(this.jdField_a_of_type_Asji);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    this.jdField_a_of_type_Asji.c(true);
    asji.a(this.jdField_a_of_type_Asji);
    asji.b(this.jdField_a_of_type_Asji, 10, 11);
    asji.c(this.jdField_a_of_type_Asji, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateUploadingWhenPause)");
    this.jdField_a_of_type_Asjn = new asko(this.jdField_a_of_type_Asji);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Asjn.a() + "onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Asjn.a() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + this.jdField_a_of_type_Asji.jdField_a_of_type_Asjj.a);
    this.jdField_a_of_type_Asji.c(1);
    if (!this.jdField_a_of_type_Asji.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Asjn.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Asji.c(false);
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_Asjj.a < 9223372036854775807L)
    {
      asji.a(this.jdField_a_of_type_Asji, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Asjn = new asjr(this.jdField_a_of_type_Asji);
      return;
    }
    asji.a(this.jdField_a_of_type_Asji, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Asjn = new asjx(this.jdField_a_of_type_Asji);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Asjn.a() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Asji.jdField_a_of_type_Asjj.a);
    this.jdField_a_of_type_Asji.c(2);
    if (!this.jdField_a_of_type_Asji.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Asjn.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Asji.c(false);
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_Asjj.a < 9223372036854775807L)
    {
      asji.a(this.jdField_a_of_type_Asji, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Asjn = new asjr(this.jdField_a_of_type_Asji);
      return;
    }
    asji.a(this.jdField_a_of_type_Asji, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Asjn = new asjx(this.jdField_a_of_type_Asji);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asks
 * JD-Core Version:    0.7.0.1
 */