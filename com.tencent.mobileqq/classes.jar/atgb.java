import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atgb
  extends atfi
{
  public atgb(atfe paramatfe)
  {
    super(paramatfe);
  }
  
  protected String a()
  {
    return "StateRequest";
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
      atfe.a(this.jdField_a_of_type_Atfe, 11, 5, true);
      a("StateAcceptByPC");
      this.jdField_a_of_type_Atfi = new atff(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.a(this.jdField_a_of_type_Atfe, 11, 6, true);
      a("StateRefuseByPC");
      this.jdField_a_of_type_Atfi = new atfy(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.a(this.jdField_a_of_type_Atfe, 11, 8, true);
      a("StateSenderCancelSend");
      this.jdField_a_of_type_Atfi = new atgf(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.a(this.jdField_a_of_type_Atfe, 11, 7, true);
      a("StateSaveToWeiYunByPC");
      this.jdField_a_of_type_Atfi = new atgc(this.jdField_a_of_type_Atfe);
      paramInt = i;
      continue;
      atfe.a(this.jdField_a_of_type_Atfe);
      atfe.a(this.jdField_a_of_type_Atfe, 11, 11);
      atfe.a(this.jdField_a_of_type_Atfe, 11, 14, false);
      a("StateUploadingWhenChangeToOff");
      this.jdField_a_of_type_Atfi = new atgi(this.jdField_a_of_type_Atfe);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    atfe.a(this.jdField_a_of_type_Atfe);
    b(paramInt1, paramInt2);
    atfe.a(this.jdField_a_of_type_Atfe, 11, 11);
    atfe.a(this.jdField_a_of_type_Atfe, 11, 14, false);
    a("StateUploadingWhenChangeToOff");
    this.jdField_a_of_type_Atfi = new atgi(this.jdField_a_of_type_Atfe);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  protected boolean a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    atfe.b(this.jdField_a_of_type_Atfe, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Atgp.a + "-" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Atgp.b + "]");
    boolean bool = this.jdField_a_of_type_Atfe.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
    if (bool)
    {
      atfe.c(this.jdField_a_of_type_Atfe, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_Atfi = new atgo(this.jdField_a_of_type_Atfe);
    }
    for (;;)
    {
      this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      return bool;
      atfe.c(this.jdField_a_of_type_Atfe, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_Atfi = new atfn(this.jdField_a_of_type_Atfe);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]  failure to send recv cmd!!! ");
    }
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
    localFileManagerEntity.setCloudType(1);
    atfe.a(this.jdField_a_of_type_Atfe, 1, -1, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atfi = new atfu(this.jdField_a_of_type_Atfe);
    return true;
  }
  
  protected void b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe, 11, 9, true);
    this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Atfi = new atfl(this.jdField_a_of_type_Atfe);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. onCheckIsTooLongSession entity is null");
      return;
    }
    atfe.a(this.jdField_a_of_type_Atfe, 9, 12, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Atfi = new atft(this.jdField_a_of_type_Atfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgb
 * JD-Core Version:    0.7.0.1
 */