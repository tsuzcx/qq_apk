import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atfs
  extends atfi
{
  public atfs(atfe paramatfe)
  {
    super(paramatfe);
  }
  
  protected String a()
  {
    return "StateExcepInvalidWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atfe.b(this.jdField_a_of_type_Atfe, 9, 12);
    atfe.c(this.jdField_a_of_type_Atfe, 9, 12);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Atfi = new atft(this.jdField_a_of_type_Atfe);
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
      this.jdField_a_of_type_Atfe.b();
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
    b(paramInt1, paramInt2);
    atfe.b(this.jdField_a_of_type_Atfe, 10, 11);
    atfe.c(this.jdField_a_of_type_Atfe, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateUploadingWhenPause)");
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
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atfi = new atfu(this.jdField_a_of_type_Atfe);
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
  
  protected void d()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe);
    atfe.a(this.jdField_a_of_type_Atfe, 10, 11, true);
    a("StateLocalFailedWhenPause");
    this.jdField_a_of_type_Atfi = new atfw(this.jdField_a_of_type_Atfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfs
 * JD-Core Version:    0.7.0.1
 */