import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aquv
  extends aqus
{
  public aquv(aqug paramaqug)
  {
    super(paramaqug);
  }
  
  protected String a()
  {
    return "StateExcepInvalidWhenRecv";
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
      this.jdField_a_of_type_Aqug.b();
      break label63;
      aqug.b(this.jdField_a_of_type_Aqug, 11, 5);
      aqug.c(this.jdField_a_of_type_Aqug, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateAcceptByPC)");
      this.jdField_a_of_type_Aquk = new aquh(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 11, 6);
      aqug.c(this.jdField_a_of_type_Aqug, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateRefuseByPC)");
      this.jdField_a_of_type_Aquk = new aqva(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 11, 8);
      aqug.c(this.jdField_a_of_type_Aqug, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_Aquk = new aqvh(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.b(this.jdField_a_of_type_Aqug, 11, 7);
      aqug.c(this.jdField_a_of_type_Aqug, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_Aquk = new aqve(this.jdField_a_of_type_Aqug);
      paramInt = i;
      continue;
      aqug.a(this.jdField_a_of_type_Aqug);
      aqug.b(this.jdField_a_of_type_Aqug, 11, 11);
      aqug.c(this.jdField_a_of_type_Aqug, 11, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateUploadingWhenChangeToOff)");
      this.jdField_a_of_type_Aquk = new aqvk(this.jdField_a_of_type_Aqug);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    b(paramInt1, paramInt2);
    aqug.b(this.jdField_a_of_type_Aqug, 9, 11);
    aqug.c(this.jdField_a_of_type_Aqug, 9, 11);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateLocalFailedWhenRecv)");
    this.jdField_a_of_type_Aquk = new aquz(this.jdField_a_of_type_Aqug);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aquk = new aquv(this.jdField_a_of_type_Aqug);
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
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 5);
    }
    localFileManagerEntity.setCloudType(1);
    aqug.b(this.jdField_a_of_type_Aqug, 1, 0);
    aqug.c(this.jdField_a_of_type_Aqug, 1, 0);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aquk = new aquw(this.jdField_a_of_type_Aqug);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Aquk = new aqun(this.jdField_a_of_type_Aqug);
  }
  
  protected void d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. onFailedOfLocalSomeThingHappen entity is null");
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug);
    aqug.a(this.jdField_a_of_type_Aqug, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Aquk = new aquz(this.jdField_a_of_type_Aqug);
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aquv
 * JD-Core Version:    0.7.0.1
 */