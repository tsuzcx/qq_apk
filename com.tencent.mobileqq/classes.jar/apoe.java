import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class apoe
  implements apli
{
  apoe(apnq paramapnq) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Apkt.a();
    azqv localazqv = bakx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(apnq.a(this.a))) && (localazqv.a != null)) {
      apnq.a(this.a, localazqv.a.toString());
    }
    azpv localazpv = new azpv(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if ((localazqv.b == 10) || (localazqv.b == 9)) {
      if (localazqv.a != null)
      {
        localazpv.b(localazqv.a);
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
      if (localazqv.b == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localazpv.a(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localazpv.a(localFileManagerEntity.strTroopFilePath, localazqv.g, localazqv.c, localazqv.h);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Apkt.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = bakx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(apnq.a(this.a))) && (((azqv)localObject).a != null)) {
      apnq.a(this.a, ((azqv)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(apnq.a(this.a)))
    {
      localTroopFileTransferManager.d(UUID.fromString(apnq.a(this.a)));
      if (apvm.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.a.a("0x8009D61", null);
      }
    }
    apnq.a(this.a, (azqv)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apoe
 * JD-Core Version:    0.7.0.1
 */