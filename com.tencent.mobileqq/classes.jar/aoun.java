import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aoun
  extends ajgs
{
  aoun(aoum paramaoum) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    Object localObject = this.a.jdField_a_of_type_Aotf.a();
    if (localObject == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DatalineFileModel<FileAssistant>", 2, "DataLine onProgress : opType[" + this.a.jdField_a_of_type_Aotf.e() + "], uniseq[" + ((FileManagerEntity)localObject).uniseq + "], nSessionId[" + ((FileManagerEntity)localObject).nSessionId + "], peerType[" + this.a.jdField_a_of_type_Aotf.b() + "]");
      }
      int i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(((FileManagerEntity)localObject).uniseq);
    } while ((localObject == null) || (paramLong != ((DataLineMsgRecord)localObject).sessionid) || (this.a.jdField_a_of_type_Aovo == null));
    this.a.jdField_a_of_type_Aovo.a(paramFloat);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Aotf.a();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineFileModel<FileAssistant>", 2, "DataLine onRecvFile : isSuccess[" + paramBoolean + "], uniseq[" + localFileManagerEntity.uniseq + "], nSessionId[" + localFileManagerEntity.nSessionId + "], peerType[" + this.a.jdField_a_of_type_Aotf.b() + "]");
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        return;
        String str = localFileManagerEntity.getFilePath();
        if ((paramLong == localDataLineMsgRecord.sessionid) || (str == null) || (str.equals(paramString))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("DatalineFileModel<FileAssistant>", 1, "this recv file done is not current visit file");
      return;
    } while (this.a.jdField_a_of_type_Aovo == null);
    if (paramBoolean)
    {
      localFileManagerEntity.status = 1;
      this.a.jdField_a_of_type_Aovo.f();
      return;
    }
    localFileManagerEntity.status = 3;
    this.a.jdField_a_of_type_Aovo.g();
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    paramString = this.a.jdField_a_of_type_Aotf.a();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineFileModel<FileAssistant>", 2, "DataLine onSendFile : isSuccess[" + paramBoolean + "], uniseq[" + paramString.uniseq + "], nSessionId[" + paramString.nSessionId + "], peerType[" + this.a.jdField_a_of_type_Aotf.b() + "]");
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramString.uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(paramString.uniseq);
    if (localDataLineMsgRecord == null) {}
    do
    {
      return;
      if (paramLong != localDataLineMsgRecord.sessionid)
      {
        QLog.i("DatalineFileModel<FileAssistant>", 1, "this send file done is not current visit file");
        return;
      }
    } while (this.a.jdField_a_of_type_Aovo == null);
    if (paramBoolean)
    {
      paramString.status = 1;
      this.a.jdField_a_of_type_Aovo.f();
      return;
    }
    this.a.jdField_a_of_type_Aovo.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoun
 * JD-Core Version:    0.7.0.1
 */