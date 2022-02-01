import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atom
  extends atnt
{
  public atom(atno paramatno)
  {
    super(paramatno);
  }
  
  protected String a()
  {
    return "StateRequest";
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
      atno.a(this.jdField_a_of_type_Atno, 11, 5, true);
      a("StateAcceptByPC");
      this.jdField_a_of_type_Atnt = new atnq(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.a(this.jdField_a_of_type_Atno, 11, 6, true);
      a("StateRefuseByPC");
      this.jdField_a_of_type_Atnt = new atoj(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.a(this.jdField_a_of_type_Atno, 11, 8, true);
      a("StateSenderCancelSend");
      this.jdField_a_of_type_Atnt = new atoq(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.a(this.jdField_a_of_type_Atno, 11, 7, true);
      a("StateSaveToWeiYunByPC");
      this.jdField_a_of_type_Atnt = new aton(this.jdField_a_of_type_Atno);
      paramInt = i;
      continue;
      atno.a(this.jdField_a_of_type_Atno);
      atno.a(this.jdField_a_of_type_Atno, 11, 11);
      atno.a(this.jdField_a_of_type_Atno, 11, 14, false);
      a("StateUploadingWhenChangeToOff");
      this.jdField_a_of_type_Atnt = new atot(this.jdField_a_of_type_Atno);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    atno.a(this.jdField_a_of_type_Atno);
    b(paramInt1, paramInt2);
    atno.a(this.jdField_a_of_type_Atno, 11, 11);
    atno.a(this.jdField_a_of_type_Atno, 11, 14, false);
    a("StateUploadingWhenChangeToOff");
    this.jdField_a_of_type_Atnt = new atot(this.jdField_a_of_type_Atno);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  protected boolean a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    atno.b(this.jdField_a_of_type_Atno, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Atno.jdField_a_of_type_Atnp.a + "-" + this.jdField_a_of_type_Atno.jdField_a_of_type_Atnp.b + "]");
    boolean bool = this.jdField_a_of_type_Atno.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
    if (bool)
    {
      atno.c(this.jdField_a_of_type_Atno, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_Atnt = new atoz(this.jdField_a_of_type_Atno);
    }
    for (;;)
    {
      this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      return bool;
      atno.c(this.jdField_a_of_type_Atno, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_Atnt = new atny(this.jdField_a_of_type_Atno);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]  failure to send recv cmd!!! ");
    }
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
      this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    atno.a(this.jdField_a_of_type_Atno, 1, -1, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atnt = new atof(this.jdField_a_of_type_Atno);
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
    atno.a(this.jdField_a_of_type_Atno, 11, 9, true);
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Atnt = new atnw(this.jdField_a_of_type_Atno);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. onCheckIsTooLongSession entity is null");
      return;
    }
    atno.a(this.jdField_a_of_type_Atno, 9, 12, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Atnt = new atoe(this.jdField_a_of_type_Atno);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atom
 * JD-Core Version:    0.7.0.1
 */