import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class arlm
  implements arip
{
  arlm(arkz paramarkz) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Arhz.a();
    bbtn localbbtn = bcnt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(arkz.a(this.a))) && (localbbtn.a != null)) {
      arkz.a(this.a, localbbtn.a.toString());
    }
    bbsn localbbsn = new bbsn(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if ((localbbtn.b == 10) || (localbbtn.b == 9)) {
      if (localbbtn.a != null)
      {
        localbbsn.b(localbbtn.a);
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
      if (localbbtn.b == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localbbsn.a(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localbbsn.a(localFileManagerEntity.strTroopFilePath, localbbtn.g, localbbtn.c, localbbtn.h);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Arhz.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = bcnt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(arkz.a(this.a))) && (((bbtn)localObject).a != null)) {
      arkz.a(this.a, ((bbtn)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(arkz.a(this.a)))
    {
      localTroopFileTransferManager.d(UUID.fromString(arkz.a(this.a)));
      if (arsx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.a.a("0x8009D61", null);
      }
    }
    arkz.a(this.a, (bbtn)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arlm
 * JD-Core Version:    0.7.0.1
 */