import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aowm
  implements aots
{
  aowm(aovz paramaovz) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Aotf.a();
    ayqd localayqd = azjg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(aovz.a(this.a))) && (localayqd.a != null)) {
      aovz.a(this.a, localayqd.a.toString());
    }
    aypd localaypd = new aypd(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if ((localayqd.b == 10) || (localayqd.b == 9)) {
      if (localayqd.a != null)
      {
        localaypd.b(localayqd.a);
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
      if (localayqd.b == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localaypd.a(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localaypd.a(localFileManagerEntity.strTroopFilePath, localayqd.g, localayqd.c, localayqd.h);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Aotf.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = azjg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(aovz.a(this.a))) && (((ayqd)localObject).a != null)) {
      aovz.a(this.a, ((ayqd)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(aovz.a(this.a)))
    {
      localTroopFileTransferManager.d(UUID.fromString(aovz.a(this.a)));
      if (apdq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.a.a("0x8009D61", null);
      }
    }
    aovz.a(this.a, (ayqd)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aowm
 * JD-Core Version:    0.7.0.1
 */