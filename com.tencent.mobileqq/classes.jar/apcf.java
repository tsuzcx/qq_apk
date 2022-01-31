import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class apcf
  extends apbm
{
  public apcf(apbi paramapbi)
  {
    super(paramapbi);
  }
  
  protected String a()
  {
    return "StateRequest";
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
      apbi.a(this.jdField_a_of_type_Apbi, 11, 5, true);
      a("StateAcceptByPC");
      this.jdField_a_of_type_Apbm = new apbj(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.a(this.jdField_a_of_type_Apbi, 11, 6, true);
      a("StateRefuseByPC");
      this.jdField_a_of_type_Apbm = new apcc(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.a(this.jdField_a_of_type_Apbi, 11, 8, true);
      a("StateSenderCancelSend");
      this.jdField_a_of_type_Apbm = new apcj(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.a(this.jdField_a_of_type_Apbi, 11, 7, true);
      a("StateSaveToWeiYunByPC");
      this.jdField_a_of_type_Apbm = new apcg(this.jdField_a_of_type_Apbi);
      paramInt = i;
      continue;
      apbi.a(this.jdField_a_of_type_Apbi);
      apbi.a(this.jdField_a_of_type_Apbi, 11, 11);
      apbi.a(this.jdField_a_of_type_Apbi, 11, 14, false);
      a("StateUploadingWhenChangeToOff");
      this.jdField_a_of_type_Apbm = new apcm(this.jdField_a_of_type_Apbi);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    apbi.a(this.jdField_a_of_type_Apbi);
    b(paramInt1, paramInt2);
    apbi.a(this.jdField_a_of_type_Apbi, 11, 11);
    apbi.a(this.jdField_a_of_type_Apbi, 11, 14, false);
    a("StateUploadingWhenChangeToOff");
    this.jdField_a_of_type_Apbm = new apcm(this.jdField_a_of_type_Apbi);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  protected boolean a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    apbi.b(this.jdField_a_of_type_Apbi, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.a + "-" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Apct.b + "]");
    boolean bool = this.jdField_a_of_type_Apbi.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
    if (bool)
    {
      apbi.c(this.jdField_a_of_type_Apbi, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_Apbm = new apcs(this.jdField_a_of_type_Apbi);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      return bool;
      apbi.c(this.jdField_a_of_type_Apbi, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_Apbm = new apbr(this.jdField_a_of_type_Apbi);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]  failure to send recv cmd!!! ");
    }
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
    localFileManagerEntity.setCloudType(1);
    apbi.a(this.jdField_a_of_type_Apbi, 1, -1, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Apbm = new apby(this.jdField_a_of_type_Apbi);
    return true;
  }
  
  protected void b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 11, 9, true);
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Apbm = new apbp(this.jdField_a_of_type_Apbi);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. onCheckIsTooLongSession entity is null");
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 9, 12, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Apbm = new apbx(this.jdField_a_of_type_Apbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apcf
 * JD-Core Version:    0.7.0.1
 */