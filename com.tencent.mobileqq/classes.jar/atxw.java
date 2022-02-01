import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atxw
  extends atxd
{
  public atxw(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateRequest";
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Atwy.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Atwy.b();
      break label63;
      atwy.a(this.jdField_a_of_type_Atwy, 11, 5, true);
      a("StateAcceptByPC");
      this.jdField_a_of_type_Atxd = new atxa(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.a(this.jdField_a_of_type_Atwy, 11, 6, true);
      a("StateRefuseByPC");
      this.jdField_a_of_type_Atxd = new atxt(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.a(this.jdField_a_of_type_Atwy, 11, 8, true);
      a("StateSenderCancelSend");
      this.jdField_a_of_type_Atxd = new atya(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.a(this.jdField_a_of_type_Atwy, 11, 7, true);
      a("StateSaveToWeiYunByPC");
      this.jdField_a_of_type_Atxd = new atxx(this.jdField_a_of_type_Atwy);
      paramInt = i;
      continue;
      atwy.a(this.jdField_a_of_type_Atwy);
      atwy.a(this.jdField_a_of_type_Atwy, 11, 11);
      atwy.a(this.jdField_a_of_type_Atwy, 11, 14, false);
      a("StateUploadingWhenChangeToOff");
      this.jdField_a_of_type_Atxd = new atyd(this.jdField_a_of_type_Atwy);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    atwy.a(this.jdField_a_of_type_Atwy);
    b(paramInt1, paramInt2);
    atwy.a(this.jdField_a_of_type_Atwy, 11, 11);
    atwy.a(this.jdField_a_of_type_Atwy, 11, 14, false);
    a("StateUploadingWhenChangeToOff");
    this.jdField_a_of_type_Atxd = new atyd(this.jdField_a_of_type_Atwy);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  protected boolean a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    atwy.b(this.jdField_a_of_type_Atwy, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Atwz.a + "-" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Atwz.b + "]");
    boolean bool = this.jdField_a_of_type_Atwy.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
    if (bool)
    {
      atwy.c(this.jdField_a_of_type_Atwy, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_Atxd = new atyj(this.jdField_a_of_type_Atwy);
    }
    for (;;)
    {
      this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      return bool;
      atwy.c(this.jdField_a_of_type_Atwy, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_Atxd = new atxi(this.jdField_a_of_type_Atwy);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]  failure to send recv cmd!!! ");
    }
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((aunj.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    atwy.a(this.jdField_a_of_type_Atwy, 1, -1, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atxd = new atxp(this.jdField_a_of_type_Atwy);
    return true;
  }
  
  protected void b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 11, 9, true);
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Atxd = new atxg(this.jdField_a_of_type_Atwy);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. onCheckIsTooLongSession entity is null");
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 9, 12, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Atxd = new atxo(this.jdField_a_of_type_Atwy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxw
 * JD-Core Version:    0.7.0.1
 */