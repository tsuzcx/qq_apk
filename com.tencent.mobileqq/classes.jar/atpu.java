import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class atpu
  implements atnd
{
  atpu(atpf paramatpf) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Atmn.a();
    bety localbety = this.a.a(localFileManagerEntity);
    if ((TextUtils.isEmpty(atpf.a(this.a))) && (localbety.a != null)) {
      atpf.a(this.a, localbety.a.toString());
    }
    besy localbesy = new besy(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if ((localbety.b == 10) || (localbety.b == 9)) {
      if (localbety.a != null)
      {
        localbesy.b(localbety.a);
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
      if (localbety.b == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localbesy.a(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localbesy.a(localFileManagerEntity.strTroopFilePath, localbety.g, localbety.c, localbety.h);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Atmn.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = this.a.a((FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(atpf.a(this.a))) && (((bety)localObject).a != null)) {
      atpf.a(this.a, ((bety)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(atpf.a(this.a)))
    {
      localTroopFileTransferManager.d(UUID.fromString(atpf.a(this.a)));
      if (atwt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.a.a("0x8009D61", null);
      }
    }
    atpf.a(this.a, (bety)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpu
 * JD-Core Version:    0.7.0.1
 */