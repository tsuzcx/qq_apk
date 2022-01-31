import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apcb
  extends apbi
{
  public apcb(apbe paramapbe)
  {
    super(paramapbe);
  }
  
  protected String a()
  {
    return "StateRequest";
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
      apbe.a(this.jdField_a_of_type_Apbe, 11, 5, true);
      a("StateAcceptByPC");
      this.jdField_a_of_type_Apbi = new apbf(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.a(this.jdField_a_of_type_Apbe, 11, 6, true);
      a("StateRefuseByPC");
      this.jdField_a_of_type_Apbi = new apby(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.a(this.jdField_a_of_type_Apbe, 11, 8, true);
      a("StateSenderCancelSend");
      this.jdField_a_of_type_Apbi = new apcf(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.a(this.jdField_a_of_type_Apbe, 11, 7, true);
      a("StateSaveToWeiYunByPC");
      this.jdField_a_of_type_Apbi = new apcc(this.jdField_a_of_type_Apbe);
      paramInt = i;
      continue;
      apbe.a(this.jdField_a_of_type_Apbe);
      apbe.a(this.jdField_a_of_type_Apbe, 11, 11);
      apbe.a(this.jdField_a_of_type_Apbe, 11, 14, false);
      a("StateUploadingWhenChangeToOff");
      this.jdField_a_of_type_Apbi = new apci(this.jdField_a_of_type_Apbe);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    apbe.a(this.jdField_a_of_type_Apbe);
    b(paramInt1, paramInt2);
    apbe.a(this.jdField_a_of_type_Apbe, 11, 11);
    apbe.a(this.jdField_a_of_type_Apbe, 11, 14, false);
    a("StateUploadingWhenChangeToOff");
    this.jdField_a_of_type_Apbi = new apci(this.jdField_a_of_type_Apbe);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  protected boolean a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    apbe.b(this.jdField_a_of_type_Apbe, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Apcp.a + "-" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Apcp.b + "]");
    boolean bool = this.jdField_a_of_type_Apbe.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
    if (bool)
    {
      apbe.c(this.jdField_a_of_type_Apbe, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_Apbi = new apco(this.jdField_a_of_type_Apbe);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      return bool;
      apbe.c(this.jdField_a_of_type_Apbe, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_Apbi = new apbn(this.jdField_a_of_type_Apbe);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]  failure to send recv cmd!!! ");
    }
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
      this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    apbe.a(this.jdField_a_of_type_Apbe, 1, -1, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Apbi = new apbu(this.jdField_a_of_type_Apbe);
    return true;
  }
  
  protected void b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbe.a(this.jdField_a_of_type_Apbe, 11, 9, true);
    this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Apbi = new apbl(this.jdField_a_of_type_Apbe);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. onCheckIsTooLongSession entity is null");
      return;
    }
    apbe.a(this.jdField_a_of_type_Apbe, 9, 12, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Apbi = new apbt(this.jdField_a_of_type_Apbe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apcb
 * JD-Core Version:    0.7.0.1
 */