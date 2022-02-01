import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atyi
  extends atxd
{
  public atyi(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateWaitResultWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.b(this.jdField_a_of_type_Atwy, 9, 10);
    atwy.c(this.jdField_a_of_type_Atwy, 9, 15);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateWaitResultWhenRecv)");
    this.jdField_a_of_type_Atxd = new atyj(this.jdField_a_of_type_Atwy);
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Atwy.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Atwy.d();
      break label63;
      atwy.b(this.jdField_a_of_type_Atwy, 10, 5);
      atwy.c(this.jdField_a_of_type_Atwy, 10, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateAcceptByPCWhenPause)");
      this.jdField_a_of_type_Atxd = new atxb(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.b(this.jdField_a_of_type_Atwy, 10, 6);
      atwy.c(this.jdField_a_of_type_Atwy, 10, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateRefuseByPCWhenPause)");
      this.jdField_a_of_type_Atxd = new atxu(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.b(this.jdField_a_of_type_Atwy, 10, 8);
      atwy.c(this.jdField_a_of_type_Atwy, 10, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateSenderCancelSendWhenPause)");
      this.jdField_a_of_type_Atxd = new atyb(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.b(this.jdField_a_of_type_Atwy, 10, 7);
      atwy.c(this.jdField_a_of_type_Atwy, 10, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateSaveToWeiYunByPCWhenPause)");
      this.jdField_a_of_type_Atxd = new atxy(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.a(this.jdField_a_of_type_Atwy);
      atwy.b(this.jdField_a_of_type_Atwy, 10, 11);
      atwy.c(this.jdField_a_of_type_Atwy, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_Atxd = new atye(this.jdField_a_of_type_Atwy);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (a("onSenderUploadProgressNotify")) {
      return;
    }
    this.jdField_a_of_type_Atwy.c(true);
    atwy.a(this.jdField_a_of_type_Atwy);
    b(paramInt1, paramInt2);
    atwy.a(this.jdField_a_of_type_Atwy, 10, 11);
    atwy.a(this.jdField_a_of_type_Atwy, 10, 14, false);
    a("StateUploadingWhenPause");
    this.jdField_a_of_type_Atxd = new atye(this.jdField_a_of_type_Atwy);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Atxd = new atxn(this.jdField_a_of_type_Atwy);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. onRecvOnLineFileResult entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + " recv  success response of accept,  waiting the cmd of starting upload");
      return;
    }
    this.jdField_a_of_type_Atwy.c(1);
    if (!this.jdField_a_of_type_Atwy.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atxd.a() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Atwy.c(false);
    atwy.b(this.jdField_a_of_type_Atwy, 10, 10);
    atwy.c(this.jdField_a_of_type_Atwy, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Atxd = new atxh(this.jdField_a_of_type_Atwy);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]  recv failed!!");
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((aunj.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Atwy.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    atwy.b(this.jdField_a_of_type_Atwy, 1, 3);
    atwy.c(this.jdField_a_of_type_Atwy, 1, 3);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateUploadoneWhenPause)");
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atxd = new atyh(this.jdField_a_of_type_Atwy);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.jdField_a_of_type_Atxd = new atxf(this.jdField_a_of_type_Atwy);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (a("onAskSenderUpProgressResult")) {
      return;
    }
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + " recv  success response of ask progress,  waiting the notify of progress");
      return;
    }
    this.jdField_a_of_type_Atwy.c(2);
    if (!this.jdField_a_of_type_Atwy.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atxd.a() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
      return;
    }
    this.jdField_a_of_type_Atwy.c(false);
    atwy.b(this.jdField_a_of_type_Atwy, 10, 10);
    atwy.c(this.jdField_a_of_type_Atwy, 10, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateChangeToOffFailedWhenPause)");
    this.jdField_a_of_type_Atxd = new atxh(this.jdField_a_of_type_Atwy);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    this.jdField_a_of_type_Atwy.c(true);
    atwy.a(this.jdField_a_of_type_Atwy);
    atwy.b(this.jdField_a_of_type_Atwy, 10, 11);
    atwy.c(this.jdField_a_of_type_Atwy, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateUploadingWhenPause)");
    this.jdField_a_of_type_Atxd = new atye(this.jdField_a_of_type_Atwy);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atxd.a() + "onRecvButSenderReplayTimeOut entity is null");
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atxd.a() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Atwz.a);
    this.jdField_a_of_type_Atwy.c(1);
    if (!this.jdField_a_of_type_Atwy.e())
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atxd.a() + " sender replay time out and no handle it. here waiting response of asking progress");
      return;
    }
    this.jdField_a_of_type_Atwy.c(false);
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_Atwz.a < 9223372036854775807L)
    {
      atwy.a(this.jdField_a_of_type_Atwy, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Atxd = new atxh(this.jdField_a_of_type_Atwy);
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Atxd = new atxn(this.jdField_a_of_type_Atwy);
  }
  
  protected void h()
  {
    if (a("onAskSenderUpProgressTimeOut")) {
      return;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atxd.a() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Atwz.a);
    this.jdField_a_of_type_Atwy.c(2);
    if (!this.jdField_a_of_type_Atwy.e())
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. state:" + this.jdField_a_of_type_Atxd.a() + " ask progress time out and no handle it. here waiting response of sender when recv");
      return;
    }
    this.jdField_a_of_type_Atwy.c(false);
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_Atwz.a < 9223372036854775807L)
    {
      atwy.a(this.jdField_a_of_type_Atwy, 10, 10, true);
      a("StateChangeToOffFailedWhenPause");
      this.jdField_a_of_type_Atxd = new atxh(this.jdField_a_of_type_Atwy);
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Atxd = new atxn(this.jdField_a_of_type_Atwy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyi
 * JD-Core Version:    0.7.0.1
 */