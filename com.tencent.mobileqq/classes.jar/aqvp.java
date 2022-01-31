import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aqvp
  extends aquk
{
  public aqvp(aqug paramaqug)
  {
    super(paramaqug);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.b(this.jdField_a_of_type_Aqug, 9, 10);
    aqug.c(this.jdField_a_of_type_Aqug, 9, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Aquk = new aqvq(this.jdField_a_of_type_Aqug);
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
      aqug.b(this.jdField_a_of_type_Aqug, 10, 5);
      aqug.c(this.jdField_a_of_type_Aqug, 10, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateAcceptByPCWhenPause)");
      this.jdField_a_of_type_Aquk = new aqui(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 10, 6);
      aqug.c(this.jdField_a_of_type_Aqug, 10, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateRefuseByPCWhenPause)");
      this.jdField_a_of_type_Aquk = new aqvb(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 10, 8);
      aqug.c(this.jdField_a_of_type_Aqug, 10, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateSenderCancelSendWhenPause)");
      this.jdField_a_of_type_Aquk = new aqvi(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 10, 7);
      aqug.c(this.jdField_a_of_type_Aqug, 10, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateSaveToWeiYunByPCWhenPause)");
      this.jdField_a_of_type_Aquk = new aqvf(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.a(this.jdField_a_of_type_Aqug);
      aqug.b(this.jdField_a_of_type_Aqug, 10, 11);
      aqug.c(this.jdField_a_of_type_Aqug, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_Aquk = new aqvl(this.jdField_a_of_type_Aqug);
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
    aqug.a(this.jdField_a_of_type_Aqug, 10, 11);
    aqug.a(this.jdField_a_of_type_Aqug, 10, 14, false);
    a("StateUploadingWhenPause");
    this.jdField_a_of_type_Aquk = new aqvl(this.jdField_a_of_type_Aqug);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Aquk = new aquu(this.jdField_a_of_type_Aqug);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. onRecvOnLineFileResult entity is null");
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
    aqug.b(this.jdField_a_of_type_Aqug, 10, 10);
    aqug.c(this.jdField_a_of_type_Aqug, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Aquk = new aquo(this.jdField_a_of_type_Aqug);
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
    localFileManagerEntity.fProgress = 0.0F;
    if ((arni.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Aqug.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    aqug.b(this.jdField_a_of_type_Aqug, 1, 3);
    aqug.c(this.jdField_a_of_type_Aqug, 1, 3);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateUploadoneWhenPause)");
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aquk = new aqvo(this.jdField_a_of_type_Aqug);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.jdField_a_of_type_Aquk = new aqum(this.jdField_a_of_type_Aqug);
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
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Aqug.c(false);
    aqug.b(this.jdField_a_of_type_Aqug, 10, 10);
    aqug.c(this.jdField_a_of_type_Aqug, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Aquk = new aquo(this.jdField_a_of_type_Aqug);
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
    aqug.b(this.jdField_a_of_type_Aqug, 10, 11);
    aqug.c(this.jdField_a_of_type_Aqug, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateUploadingWhenPause)");
    this.jdField_a_of_type_Aquk = new aqvl(this.jdField_a_of_type_Aqug);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + "onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a);
    this.jdField_a_of_type_Aqug.c(1);
    if (!this.jdField_a_of_type_Aqug.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Aqug.c(false);
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a < 9223372036854775807L)
    {
      aqug.a(this.jdField_a_of_type_Aqug, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Aquk = new aquo(this.jdField_a_of_type_Aqug);
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Aquk = new aquu(this.jdField_a_of_type_Aqug);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a);
    this.jdField_a_of_type_Aqug.c(2);
    if (!this.jdField_a_of_type_Aqug.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aquk.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Aqug.c(false);
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_Aqvr.a < 9223372036854775807L)
    {
      aqug.a(this.jdField_a_of_type_Aqug, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Aquk = new aquo(this.jdField_a_of_type_Aqug);
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Aquk = new aquu(this.jdField_a_of_type_Aqug);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvp
 * JD-Core Version:    0.7.0.1
 */