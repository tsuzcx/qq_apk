import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class auhp
  implements auey
{
  auhp(auha paramauha) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Auei.a();
    bftf localbftf = this.a.a(localFileManagerEntity);
    if ((TextUtils.isEmpty(auha.a(this.a))) && (localbftf.a != null)) {
      auha.a(this.a, localbftf.a.toString());
    }
    bfsf localbfsf = new bfsf(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if ((localbftf.b == 10) || (localbftf.b == 9)) {
      if (localbftf.a != null)
      {
        localbfsf.b(localbftf.a);
        localFileManagerEntity.status = 2;
      }
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : resumeDownload error, infoId is null");
      return;
      if (localbftf.b == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localbfsf.a(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localbfsf.a(localFileManagerEntity.strTroopFilePath, localbftf.g, localbftf.c, localbftf.h);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Auei.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = this.a.a((FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(auha.a(this.a))) && (((bftf)localObject).a != null)) {
      auha.a(this.a, ((bftf)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(auha.a(this.a)))
    {
      localTroopFileTransferManager.d(UUID.fromString(auha.a(this.a)));
      if (auoo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.a.a("0x8009D61", null);
      }
    }
    auha.a(this.a, (bftf)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhp
 * JD-Core Version:    0.7.0.1
 */