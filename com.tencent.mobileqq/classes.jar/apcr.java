import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apcr
  extends apbm
{
  public apcr(apbi paramapbi)
  {
    super(paramapbi);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.b(this.jdField_a_of_type_Apbi, 9, 10);
    apbi.c(this.jdField_a_of_type_Apbi, 9, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Apbm = new apcs(this.jdField_a_of_type_Apbi);
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
      apbi.b(this.jdField_a_of_type_Apbi, 10, 5);
      apbi.c(this.jdField_a_of_type_Apbi, 10, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateAcceptByPCWhenPause)");
      this.jdField_a_of_type_Apbm = new apbk(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.b(this.jdField_a_of_type_Apbi, 10, 6);
      apbi.c(this.jdField_a_of_type_Apbi, 10, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateRefuseByPCWhenPause)");
      this.jdField_a_of_type_Apbm = new apcd(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.b(this.jdField_a_of_type_Apbi, 10, 8);
      apbi.c(this.jdField_a_of_type_Apbi, 10, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateSenderCancelSendWhenPause)");
      this.jdField_a_of_type_Apbm = new apck(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.b(this.jdField_a_of_type_Apbi, 10, 7);
      apbi.c(this.jdField_a_of_type_Apbi, 10, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateSaveToWeiYunByPCWhenPause)");
      this.jdField_a_of_type_Apbm = new apch(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.a(this.jdField_a_of_type_Apbi);
      apbi.b(this.jdField_a_of_type_Apbi, 10, 11);
      apbi.c(this.jdField_a_of_type_Apbi, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_Apbm = new apcn(this.jdField_a_of_type_Apbi);
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
    apbi.a(this.jdField_a_of_type_Apbi, 10, 11);
    apbi.a(this.jdField_a_of_type_Apbi, 10, 14, false);
    a("StateUploadingWhenPause");
    this.jdField_a_of_type_Apbm = new apcn(this.jdField_a_of_type_Apbi);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Apbm = new apbw(this.jdField_a_of_type_Apbi);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. onRecvOnLineFileResult entity is null");
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
    apbi.b(this.jdField_a_of_type_Apbi, 10, 10);
    apbi.c(this.jdField_a_of_type_Apbi, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Apbm = new apbq(this.jdField_a_of_type_Apbi);
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
    localFileManagerEntity.fProgress = 0.0F;
    if ((apug.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Apbi.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    apbi.b(this.jdField_a_of_type_Apbi, 1, 3);
    apbi.c(this.jdField_a_of_type_Apbi, 1, 3);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateUploadoneWhenPause)");
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Apbm = new apcq(this.jdField_a_of_type_Apbi);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.jdField_a_of_type_Apbm = new apbo(this.jdField_a_of_type_Apbi);
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
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Apbi.c(false);
    apbi.b(this.jdField_a_of_type_Apbi, 10, 10);
    apbi.c(this.jdField_a_of_type_Apbi, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Apbm = new apbq(this.jdField_a_of_type_Apbi);
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
    apbi.b(this.jdField_a_of_type_Apbi, 10, 11);
    apbi.c(this.jdField_a_of_type_Apbi, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateUploadingWhenPause)");
    this.jdField_a_of_type_Apbm = new apcn(this.jdField_a_of_type_Apbi);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + "onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.a);
    this.jdField_a_of_type_Apbi.c(1);
    if (!this.jdField_a_of_type_Apbi.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Apbi.c(false);
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.a < 9223372036854775807L)
    {
      apbi.a(this.jdField_a_of_type_Apbi, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Apbm = new apbq(this.jdField_a_of_type_Apbi);
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Apbm = new apbw(this.jdField_a_of_type_Apbi);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.a);
    this.jdField_a_of_type_Apbi.c(2);
    if (!this.jdField_a_of_type_Apbi.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Apbm.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Apbi.c(false);
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.a < 9223372036854775807L)
    {
      apbi.a(this.jdField_a_of_type_Apbi, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Apbm = new apbq(this.jdField_a_of_type_Apbi);
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Apbm = new apbw(this.jdField_a_of_type_Apbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apcr
 * JD-Core Version:    0.7.0.1
 */