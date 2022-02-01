import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atgn
  extends atfi
{
  public atgn(atfe paramatfe)
  {
    super(paramatfe);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atfe.b(this.jdField_a_of_type_Atfe, 9, 10);
    atfe.c(this.jdField_a_of_type_Atfe, 9, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Atfi = new atgo(this.jdField_a_of_type_Atfe);
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Atfe.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Atfe.d();
      break label63;
      atfe.b(this.jdField_a_of_type_Atfe, 10, 5);
      atfe.c(this.jdField_a_of_type_Atfe, 10, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateAcceptByPCWhenPause)");
      this.jdField_a_of_type_Atfi = new atfg(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.b(this.jdField_a_of_type_Atfe, 10, 6);
      atfe.c(this.jdField_a_of_type_Atfe, 10, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateRefuseByPCWhenPause)");
      this.jdField_a_of_type_Atfi = new atfz(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.b(this.jdField_a_of_type_Atfe, 10, 8);
      atfe.c(this.jdField_a_of_type_Atfe, 10, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateSenderCancelSendWhenPause)");
      this.jdField_a_of_type_Atfi = new atgg(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.b(this.jdField_a_of_type_Atfe, 10, 7);
      atfe.c(this.jdField_a_of_type_Atfe, 10, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateSaveToWeiYunByPCWhenPause)");
      this.jdField_a_of_type_Atfi = new atgd(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.a(this.jdField_a_of_type_Atfe);
      atfe.b(this.jdField_a_of_type_Atfe, 10, 11);
      atfe.c(this.jdField_a_of_type_Atfe, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_Atfi = new atgj(this.jdField_a_of_type_Atfe);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    this.jdField_a_of_type_Atfe.c(true);
    atfe.a(this.jdField_a_of_type_Atfe);
    b(paramInt1, paramInt2);
    atfe.a(this.jdField_a_of_type_Atfe, 10, 11);
    atfe.a(this.jdField_a_of_type_Atfe, 10, 14, false);
    a("StateUploadingWhenPause");
    this.jdField_a_of_type_Atfi = new atgj(this.jdField_a_of_type_Atfe);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Atfi = new atfs(this.jdField_a_of_type_Atfe);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. onRecvOnLineFileResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + " recv  success response of accept,  waiting the cmd of starting upload");
      return;
    }
    this.jdField_a_of_type_Atfe.c(1);
    if (!this.jdField_a_of_type_Atfe.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atfi.a() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Atfe.c(false);
    atfe.b(this.jdField_a_of_type_Atfe, 10, 10);
    atfe.c(this.jdField_a_of_type_Atfe, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Atfi = new atfm(this.jdField_a_of_type_Atfe);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]  recv failed!!");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((atvo.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Atfe.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    atfe.b(this.jdField_a_of_type_Atfe, 1, 3);
    atfe.c(this.jdField_a_of_type_Atfe, 1, 3);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateUploadoneWhenPause)");
    this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atfi = new atgm(this.jdField_a_of_type_Atfe);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.jdField_a_of_type_Atfi = new atfk(this.jdField_a_of_type_Atfe);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (a("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + " recv  success response of ask progress,  waiting the notify of progress");
      return;
    }
    this.jdField_a_of_type_Atfe.c(2);
    if (!this.jdField_a_of_type_Atfe.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atfi.a() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Atfe.c(false);
    atfe.b(this.jdField_a_of_type_Atfe, 10, 10);
    atfe.c(this.jdField_a_of_type_Atfe, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Atfi = new atfm(this.jdField_a_of_type_Atfe);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    this.jdField_a_of_type_Atfe.c(true);
    atfe.a(this.jdField_a_of_type_Atfe);
    atfe.b(this.jdField_a_of_type_Atfe, 10, 11);
    atfe.c(this.jdField_a_of_type_Atfe, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateUploadingWhenPause)");
    this.jdField_a_of_type_Atfi = new atgj(this.jdField_a_of_type_Atfe);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atfi.a() + "onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atfi.a() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Atgp.a);
    this.jdField_a_of_type_Atfe.c(1);
    if (!this.jdField_a_of_type_Atfe.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atfi.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Atfe.c(false);
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_Atgp.a < 9223372036854775807L)
    {
      atfe.a(this.jdField_a_of_type_Atfe, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Atfi = new atfm(this.jdField_a_of_type_Atfe);
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Atfi = new atfs(this.jdField_a_of_type_Atfe);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atfi.a() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Atgp.a);
    this.jdField_a_of_type_Atfe.c(2);
    if (!this.jdField_a_of_type_Atfe.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atfi.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Atfe.c(false);
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_Atgp.a < 9223372036854775807L)
    {
      atfe.a(this.jdField_a_of_type_Atfe, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Atfi = new atfm(this.jdField_a_of_type_Atfe);
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Atfi = new atfs(this.jdField_a_of_type_Atfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgn
 * JD-Core Version:    0.7.0.1
 */