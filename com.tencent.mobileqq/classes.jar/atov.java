import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atov
  extends atnt
{
  public atov(atno paramatno)
  {
    super(paramatno);
  }
  
  protected String a()
  {
    return "StateUploadingWhenRecv";
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (paramString == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atno.b(this.jdField_a_of_type_Atno, 9, 12);
    atno.c(this.jdField_a_of_type_Atno, 9, 12);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramString.uniseq, paramString.nSessionId, paramString.peerUin, paramString.peerType, 12, null, 5, null);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Atnt = new atoe(this.jdField_a_of_type_Atno);
  }
  
  protected void a(long paramLong)
  {
    b(paramLong);
  }
  
  protected void a(boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    if (paramBoolean == true)
    {
      atno.a(this.jdField_a_of_type_Atno);
      atno.b(this.jdField_a_of_type_Atno, 9, 11);
      atno.c(this.jdField_a_of_type_Atno, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateUploadingWhenRecv)");
      this.jdField_a_of_type_Atnt = new atov(this.jdField_a_of_type_Atno);
      return;
    }
    atno.b(this.jdField_a_of_type_Atno, 9, 10);
    atno.c(this.jdField_a_of_type_Atno, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateChangeToOffFailedWhenRecv)");
    this.jdField_a_of_type_Atnt = new atny(this.jdField_a_of_type_Atno);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]  recv failed!!");
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
    if ((auea.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Atno.a(paramLong, localFileManagerEntity.peerUin);
    if (localFileManagerEntity.fProgress < 0.9F)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. start make progress pass to 100% directly");
      this.b = true;
      this.jdField_a_of_type_Atno.a(1.0F);
      return true;
    }
    f();
    return true;
  }
  
  protected void b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atno.b(this.jdField_a_of_type_Atno, 11, 9);
    atno.c(this.jdField_a_of_type_Atno, 11, 9);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Atnt = new atnw(this.jdField_a_of_type_Atno);
  }
  
  protected void b(int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. onFailedOfLocalSomeThingHappen entity is null");
      return;
    }
    atno.b(this.jdField_a_of_type_Atno, 9, 11);
    atno.c(this.jdField_a_of_type_Atno, 9, 11);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateLocalFailedWhenRecv)");
    this.jdField_a_of_type_Atnt = new atoi(this.jdField_a_of_type_Atno);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atno.b(this.jdField_a_of_type_Atno, 10, -2);
    atno.c(this.jdField_a_of_type_Atno, 10, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateUploadingWhenPause)");
    this.jdField_a_of_type_Atnt = new atou(this.jdField_a_of_type_Atno);
  }
  
  protected void f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. doSomeThingOnUploadDone entity is null");
      return;
    }
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    localFileManagerEntity.fProgress = 0.0F;
    localFileManagerEntity.setCloudType(1);
    atno.b(this.jdField_a_of_type_Atno, 1, 0);
    atno.c(this.jdField_a_of_type_Atno, 1, 2);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + ". doSomeThingOnUploadDone start recv offline file....)");
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(this.jdField_a_of_type_Atno.jdField_a_of_type_Long, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 1);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atnt = new atof(this.jdField_a_of_type_Atno);
  }
  
  protected void j()
  {
    if (a("onStop")) {
      return;
    }
    atno.a(this.jdField_a_of_type_Atno, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Atnt = new atoi(this.jdField_a_of_type_Atno);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atov
 * JD-Core Version:    0.7.0.1
 */