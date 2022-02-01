import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atoe
  extends atob
{
  public atoe(atno paramatno)
  {
    super(paramatno);
  }
  
  protected String a()
  {
    return "StateExcepInvalidWhenRecv";
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Atno.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Atno.b();
      break label63;
      atno.b(this.jdField_a_of_type_Atno, 11, 5);
      atno.c(this.jdField_a_of_type_Atno, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateAcceptByPC)");
      this.jdField_a_of_type_Atnt = new atnq(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.b(this.jdField_a_of_type_Atno, 11, 6);
      atno.c(this.jdField_a_of_type_Atno, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateRefuseByPC)");
      this.jdField_a_of_type_Atnt = new atoj(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.b(this.jdField_a_of_type_Atno, 11, 8);
      atno.c(this.jdField_a_of_type_Atno, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_Atnt = new atoq(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.b(this.jdField_a_of_type_Atno, 11, 7);
      atno.c(this.jdField_a_of_type_Atno, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_Atnt = new aton(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.a(this.jdField_a_of_type_Atno);
      atno.b(this.jdField_a_of_type_Atno, 11, 11);
      atno.c(this.jdField_a_of_type_Atno, 11, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateUploadingWhenChangeToOff)");
      this.jdField_a_of_type_Atnt = new atot(this.jdField_a_of_type_Atno);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    b(paramInt1, paramInt2);
    atno.b(this.jdField_a_of_type_Atno, 9, 11);
    atno.c(this.jdField_a_of_type_Atno, 9, 11);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateLocalFailedWhenRecv)");
    this.jdField_a_of_type_Atnt = new atoi(this.jdField_a_of_type_Atno);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atno.a(this.jdField_a_of_type_Atno, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Atnt = new atoe(this.jdField_a_of_type_Atno);
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((auea.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 5);
    }
    localFileManagerEntity.setCloudType(1);
    atno.b(this.jdField_a_of_type_Atno, 1, 0);
    atno.c(this.jdField_a_of_type_Atno, 1, 0);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atnt = new atof(this.jdField_a_of_type_Atno);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atno.a(this.jdField_a_of_type_Atno, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Atnt = new atnw(this.jdField_a_of_type_Atno);
  }
  
  protected void d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. onFailedOfLocalSomeThingHappen entity is null");
      return;
    }
    atno.a(this.jdField_a_of_type_Atno);
    atno.a(this.jdField_a_of_type_Atno, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Atnt = new atoi(this.jdField_a_of_type_Atno);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoe
 * JD-Core Version:    0.7.0.1
 */