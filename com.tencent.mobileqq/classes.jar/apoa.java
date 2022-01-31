import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class apoa
  implements aple
{
  apoa(apnm paramapnm) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Apkp.a();
    azqt localazqt = bakj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(apnm.a(this.a))) && (localazqt.a != null)) {
      apnm.a(this.a, localazqt.a.toString());
    }
    azpt localazpt = new azpt(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if ((localazqt.b == 10) || (localazqt.b == 9)) {
      if (localazqt.a != null)
      {
        localazpt.b(localazqt.a);
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
      if (localazqt.b == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localazpt.a(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localazpt.a(localFileManagerEntity.strTroopFilePath, localazqt.g, localazqt.c, localazqt.h);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Apkp.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = bakj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(apnm.a(this.a))) && (((azqt)localObject).a != null)) {
      apnm.a(this.a, ((azqt)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(apnm.a(this.a)))
    {
      localTroopFileTransferManager.d(UUID.fromString(apnm.a(this.a)));
      if (apvk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.a.a("0x8009D61", null);
      }
    }
    apnm.a(this.a, (azqt)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apoa
 * JD-Core Version:    0.7.0.1
 */