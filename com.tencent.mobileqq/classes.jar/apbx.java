import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apbx
  extends apbu
{
  public apbx(apbi paramapbi)
  {
    super(paramapbi);
  }
  
  protected String a()
  {
    return "StateExcepInvalidWhenRecv";
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
      apbi.b(this.jdField_a_of_type_Apbi, 11, 5);
      apbi.c(this.jdField_a_of_type_Apbi, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateAcceptByPC)");
      this.jdField_a_of_type_Apbm = new apbj(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.b(this.jdField_a_of_type_Apbi, 11, 6);
      apbi.c(this.jdField_a_of_type_Apbi, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateRefuseByPC)");
      this.jdField_a_of_type_Apbm = new apcc(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.b(this.jdField_a_of_type_Apbi, 11, 8);
      apbi.c(this.jdField_a_of_type_Apbi, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_Apbm = new apcj(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.b(this.jdField_a_of_type_Apbi, 11, 7);
      apbi.c(this.jdField_a_of_type_Apbi, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_Apbm = new apcg(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.a(this.jdField_a_of_type_Apbi);
      apbi.b(this.jdField_a_of_type_Apbi, 11, 11);
      apbi.c(this.jdField_a_of_type_Apbi, 11, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateUploadingWhenChangeToOff)");
      this.jdField_a_of_type_Apbm = new apcm(this.jdField_a_of_type_Apbi);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    b(paramInt1, paramInt2);
    apbi.b(this.jdField_a_of_type_Apbi, 9, 11);
    apbi.c(this.jdField_a_of_type_Apbi, 9, 11);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateLocalFailedWhenRecv)");
    this.jdField_a_of_type_Apbm = new apcb(this.jdField_a_of_type_Apbi);
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Apbm = new apbx(this.jdField_a_of_type_Apbi);
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
      this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 5);
    }
    localFileManagerEntity.setCloudType(1);
    apbi.b(this.jdField_a_of_type_Apbi, 1, 0);
    apbi.c(this.jdField_a_of_type_Apbi, 1, 0);
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
    apbi.a(this.jdField_a_of_type_Apbi, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Apbm = new apbp(this.jdField_a_of_type_Apbi);
  }
  
  protected void d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. onFailedOfLocalSomeThingHappen entity is null");
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi);
    apbi.a(this.jdField_a_of_type_Apbi, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Apbm = new apcb(this.jdField_a_of_type_Apbi);
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbx
 * JD-Core Version:    0.7.0.1
 */