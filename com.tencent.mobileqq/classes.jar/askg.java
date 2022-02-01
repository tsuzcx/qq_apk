import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class askg
  extends asjn
{
  public askg(asji paramasji)
  {
    super(paramasji);
  }
  
  protected String a()
  {
    return "StateRequest";
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Asji.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Asji.b();
      break label63;
      asji.a(this.jdField_a_of_type_Asji, 11, 5, true);
      a("StateAcceptByPC");
      this.jdField_a_of_type_Asjn = new asjk(this.jdField_a_of_type_Asji);
      paramInt = i;
      continue;
      asji.a(this.jdField_a_of_type_Asji, 11, 6, true);
      a("StateRefuseByPC");
      this.jdField_a_of_type_Asjn = new askd(this.jdField_a_of_type_Asji);
      paramInt = i;
      continue;
      asji.a(this.jdField_a_of_type_Asji, 11, 8, true);
      a("StateSenderCancelSend");
      this.jdField_a_of_type_Asjn = new askk(this.jdField_a_of_type_Asji);
      paramInt = i;
      continue;
      asji.a(this.jdField_a_of_type_Asji, 11, 7, true);
      a("StateSaveToWeiYunByPC");
      this.jdField_a_of_type_Asjn = new askh(this.jdField_a_of_type_Asji);
      paramInt = i;
      continue;
      asji.a(this.jdField_a_of_type_Asji);
      asji.a(this.jdField_a_of_type_Asji, 11, 11);
      asji.a(this.jdField_a_of_type_Asji, 11, 14, false);
      a("StateUploadingWhenChangeToOff");
      this.jdField_a_of_type_Asjn = new askn(this.jdField_a_of_type_Asji);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    asji.a(this.jdField_a_of_type_Asji);
    b(paramInt1, paramInt2);
    asji.a(this.jdField_a_of_type_Asji, 11, 11);
    asji.a(this.jdField_a_of_type_Asji, 11, 14, false);
    a("StateUploadingWhenChangeToOff");
    this.jdField_a_of_type_Asjn = new askn(this.jdField_a_of_type_Asji);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  protected boolean a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    asji.b(this.jdField_a_of_type_Asji, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Asji.jdField_a_of_type_Asjj.a + "-" + this.jdField_a_of_type_Asji.jdField_a_of_type_Asjj.b + "]");
    boolean bool = this.jdField_a_of_type_Asji.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
    if (bool)
    {
      asji.c(this.jdField_a_of_type_Asji, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_Asjn = new askt(this.jdField_a_of_type_Asji);
    }
    for (;;)
    {
      this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      return bool;
      asji.c(this.jdField_a_of_type_Asji, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_Asjn = new asjs(this.jdField_a_of_type_Asji);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]  failure to send recv cmd!!! ");
    }
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((aszt.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    asji.a(this.jdField_a_of_type_Asji, 1, -1, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Asjn = new asjz(this.jdField_a_of_type_Asji);
    return true;
  }
  
  protected void b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    asji.a(this.jdField_a_of_type_Asji, 11, 9, true);
    this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Asjn = new asjq(this.jdField_a_of_type_Asji);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. onCheckIsTooLongSession entity is null");
      return;
    }
    asji.a(this.jdField_a_of_type_Asji, 9, 12, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Asjn = new asjy(this.jdField_a_of_type_Asji);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askg
 * JD-Core Version:    0.7.0.1
 */