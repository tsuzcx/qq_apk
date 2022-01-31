import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aolt
  extends aoko
{
  public aolt(aokk paramaokk)
  {
    super(paramaokk);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aokk.b(this.jdField_a_of_type_Aokk, 9, 10);
    aokk.c(this.jdField_a_of_type_Aokk, 9, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Aoko = new aolu(this.jdField_a_of_type_Aokk);
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
      this.jdField_a_of_type_Aokk.d();
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
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_Aoko = new aolp(this.jdField_a_of_type_Aokk);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    this.jdField_a_of_type_Aokk.c(true);
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
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. onRecvOnLineFileResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + " recv  success response of accept,  waiting the cmd of starting upload");
      return;
    }
    this.jdField_a_of_type_Aokk.c(1);
    if (!this.jdField_a_of_type_Aokk.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aoko.a() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Aokk.c(false);
    aokk.b(this.jdField_a_of_type_Aokk, 10, 10);
    aokk.c(this.jdField_a_of_type_Aokk, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Aoko = new aoks(this.jdField_a_of_type_Aokk);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]  recv failed!!");
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
    if (a("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + " recv  success response of ask progress,  waiting the notify of progress");
      return;
    }
    this.jdField_a_of_type_Aokk.c(2);
    if (!this.jdField_a_of_type_Aokk.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aoko.a() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Aokk.c(false);
    aokk.b(this.jdField_a_of_type_Aokk, 10, 10);
    aokk.c(this.jdField_a_of_type_Aokk, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Aoko = new aoks(this.jdField_a_of_type_Aokk);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    this.jdField_a_of_type_Aokk.c(true);
    aokk.a(this.jdField_a_of_type_Aokk);
    aokk.b(this.jdField_a_of_type_Aokk, 10, 11);
    aokk.c(this.jdField_a_of_type_Aokk, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateUploadingWhenPause)");
    this.jdField_a_of_type_Aoko = new aolp(this.jdField_a_of_type_Aokk);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aoko.a() + "onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aoko.a() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Aolv.a);
    this.jdField_a_of_type_Aokk.c(1);
    if (!this.jdField_a_of_type_Aokk.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aoko.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Aokk.c(false);
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_Aolv.a < 9223372036854775807L)
    {
      aokk.a(this.jdField_a_of_type_Aokk, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Aoko = new aoks(this.jdField_a_of_type_Aokk);
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Aoko = new aoky(this.jdField_a_of_type_Aokk);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aoko.a() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Aolv.a);
    this.jdField_a_of_type_Aokk.c(2);
    if (!this.jdField_a_of_type_Aokk.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Aoko.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Aokk.c(false);
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_Aolv.a < 9223372036854775807L)
    {
      aokk.a(this.jdField_a_of_type_Aokk, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Aoko = new aoks(this.jdField_a_of_type_Aokk);
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Aoko = new aoky(this.jdField_a_of_type_Aokk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aolt
 * JD-Core Version:    0.7.0.1
 */