import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apbw
  extends apbm
{
  public apbw(apbi paramapbi)
  {
    super(paramapbi);
  }
  
  protected String a()
  {
    return "StateExcepInvalidWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.b(this.jdField_a_of_type_Apbi, 9, 12);
    apbi.c(this.jdField_a_of_type_Apbi, 9, 12);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Apbm = new apbx(this.jdField_a_of_type_Apbi);
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
      this.jdField_a_of_type_Apbi.b();
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
    b(paramInt1, paramInt2);
    apbi.b(this.jdField_a_of_type_Apbi, 10, 11);
    apbi.c(this.jdField_a_of_type_Apbi, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateUploadingWhenPause)");
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
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Apbm = new apby(this.jdField_a_of_type_Apbi);
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
  
  protected void d()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. onSenderReplayComeOnRecv entity is null");
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi);
    apbi.a(this.jdField_a_of_type_Apbi, 10, 11, true);
    a("StateLocalFailedWhenPause");
    this.jdField_a_of_type_Apbm = new apca(this.jdField_a_of_type_Apbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbw
 * JD-Core Version:    0.7.0.1
 */