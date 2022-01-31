import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aolh
  extends aoko
{
  public aolh(aokk paramaokk)
  {
    super(paramaokk);
  }
  
  protected String a()
  {
    return "StateRequest";
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_Aokk.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_Aokk.b();
      break label63;
      aokk.a(this.jdField_a_of_type_Aokk, 11, 5, true);
      a("StateAcceptByPC");
      this.jdField_a_of_type_Aoko = new aokl(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.a(this.jdField_a_of_type_Aokk, 11, 6, true);
      a("StateRefuseByPC");
      this.jdField_a_of_type_Aoko = new aole(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.a(this.jdField_a_of_type_Aokk, 11, 8, true);
      a("StateSenderCancelSend");
      this.jdField_a_of_type_Aoko = new aoll(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.a(this.jdField_a_of_type_Aokk, 11, 7, true);
      a("StateSaveToWeiYunByPC");
      this.jdField_a_of_type_Aoko = new aoli(this.jdField_a_of_type_Aokk);
      paramInt = i;
      continue;
      aokk.a(this.jdField_a_of_type_Aokk);
      aokk.a(this.jdField_a_of_type_Aokk, 11, 11);
      aokk.a(this.jdField_a_of_type_Aokk, 11, 14, false);
      a("StateUploadingWhenChangeToOff");
      this.jdField_a_of_type_Aoko = new aolo(this.jdField_a_of_type_Aokk);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    aokk.a(this.jdField_a_of_type_Aokk);
    b(paramInt1, paramInt2);
    aokk.a(this.jdField_a_of_type_Aokk, 11, 11);
    aokk.a(this.jdField_a_of_type_Aokk, 11, 14, false);
    a("StateUploadingWhenChangeToOff");
    this.jdField_a_of_type_Aoko = new aolo(this.jdField_a_of_type_Aokk);
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  protected boolean a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    aokk.b(this.jdField_a_of_type_Aokk, 9, 10);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "start send recv cmd.... [" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Aolv.a + "-" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Aolv.b + "]");
    boolean bool = this.jdField_a_of_type_Aokk.a(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
    if (bool)
    {
      aokk.c(this.jdField_a_of_type_Aokk, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_Aoko = new aolu(this.jdField_a_of_type_Aokk);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      return bool;
      aokk.c(this.jdField_a_of_type_Aokk, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_Aoko = new aokt(this.jdField_a_of_type_Aokk);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]  failure to send recv cmd!!! ");
    }
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((apck.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    aokk.a(this.jdField_a_of_type_Aokk, 1, -1, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aoko = new aola(this.jdField_a_of_type_Aokk);
    return true;
  }
  
  protected void b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk, 11, 9, true);
    this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Aoko = new aokr(this.jdField_a_of_type_Aokk);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. onCheckIsTooLongSession entity is null");
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk, 9, 12, true);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Aoko = new aokz(this.jdField_a_of_type_Aokk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aolh
 * JD-Core Version:    0.7.0.1
 */