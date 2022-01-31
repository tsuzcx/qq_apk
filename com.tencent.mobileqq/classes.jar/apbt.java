import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apbt
  extends apbq
{
  public apbt(apbe paramapbe)
  {
    super(paramapbe);
  }
  
  protected String a()
  {
    return "StateExcepInvalidWhenRecv";
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Apbe.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Apbe.b();
      break label63;
      apbe.b(this.jdField_a_of_type_Apbe, 11, 5);
      apbe.c(this.jdField_a_of_type_Apbe, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateAcceptByPC)");
      this.jdField_a_of_type_Apbi = new apbf(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.b(this.jdField_a_of_type_Apbe, 11, 6);
      apbe.c(this.jdField_a_of_type_Apbe, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateRefuseByPC)");
      this.jdField_a_of_type_Apbi = new apby(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.b(this.jdField_a_of_type_Apbe, 11, 8);
      apbe.c(this.jdField_a_of_type_Apbe, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_Apbi = new apcf(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.b(this.jdField_a_of_type_Apbe, 11, 7);
      apbe.c(this.jdField_a_of_type_Apbe, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_Apbi = new apcc(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.a(this.jdField_a_of_type_Apbe);
      apbe.b(this.jdField_a_of_type_Apbe, 11, 11);
      apbe.c(this.jdField_a_of_type_Apbe, 11, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateUploadingWhenChangeToOff)");
      this.jdField_a_of_type_Apbi = new apci(this.jdField_a_of_type_Apbe);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    b(paramInt1, paramInt2);
    apbe.b(this.jdField_a_of_type_Apbe, 9, 11);
    apbe.c(this.jdField_a_of_type_Apbe, 9, 11);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateLocalFailedWhenRecv)");
    this.jdField_a_of_type_Apbi = new apbx(this.jdField_a_of_type_Apbe);
    this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbe.a(this.jdField_a_of_type_Apbe, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Apbi = new apbt(this.jdField_a_of_type_Apbe);
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((apue.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 5);
    }
    localFileManagerEntity.setCloudType(1);
    apbe.b(this.jdField_a_of_type_Apbe, 1, 0);
    apbe.c(this.jdField_a_of_type_Apbe, 1, 0);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Apbi = new apbu(this.jdField_a_of_type_Apbe);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbe.a(this.jdField_a_of_type_Apbe, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Apbi = new apbl(this.jdField_a_of_type_Apbe);
  }
  
  protected void d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. onFailedOfLocalSomeThingHappen entity is null");
      return;
    }
    apbe.a(this.jdField_a_of_type_Apbe);
    apbe.a(this.jdField_a_of_type_Apbe, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Apbi = new apbx(this.jdField_a_of_type_Apbe);
    this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbt
 * JD-Core Version:    0.7.0.1
 */