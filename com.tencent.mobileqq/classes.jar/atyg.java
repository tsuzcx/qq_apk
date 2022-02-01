import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class atyg
  implements atvp
{
  atyg(atxr paramatxr) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Atuz.a();
    bfjs localbfjs = this.a.a(localFileManagerEntity);
    if ((TextUtils.isEmpty(atxr.a(this.a))) && (localbfjs.a != null)) {
      atxr.a(this.a, localbfjs.a.toString());
    }
    bfis localbfis = new bfis(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if ((localbfjs.b == 10) || (localbfjs.b == 9)) {
      if (localbfjs.a != null)
      {
        localbfis.b(localbfjs.a);
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
      if (localbfjs.b == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localbfis.a(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localbfis.a(localFileManagerEntity.strTroopFilePath, localbfjs.g, localbfjs.c, localbfjs.h);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Atuz.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = this.a.a((FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(atxr.a(this.a))) && (((bfjs)localObject).a != null)) {
      atxr.a(this.a, ((bfjs)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(atxr.a(this.a)))
    {
      localTroopFileTransferManager.d(UUID.fromString(atxr.a(this.a)));
      if (aufd.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.a.a("0x8009D61", null);
      }
    }
    atxr.a(this.a, (bfjs)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyg
 * JD-Core Version:    0.7.0.1
 */