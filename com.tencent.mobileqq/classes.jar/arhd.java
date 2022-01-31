import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class arhd
  implements areg
{
  arhd(argq paramargq) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Ardq.a();
    bbpe localbbpe = bcjk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(argq.a(this.a))) && (localbbpe.a != null)) {
      argq.a(this.a, localbbpe.a.toString());
    }
    bboe localbboe = new bboe(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if ((localbbpe.b == 10) || (localbbpe.b == 9)) {
      if (localbbpe.a != null)
      {
        localbboe.b(localbbpe.a);
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
      if (localbbpe.b == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localbboe.a(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localbboe.a(localFileManagerEntity.strTroopFilePath, localbbpe.g, localbbpe.c, localbbpe.h);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Ardq.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = bcjk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(argq.a(this.a))) && (((bbpe)localObject).a != null)) {
      argq.a(this.a, ((bbpe)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(argq.a(this.a)))
    {
      localTroopFileTransferManager.d(UUID.fromString(argq.a(this.a)));
      if (aroo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.a.a("0x8009D61", null);
      }
    }
    argq.a(this.a, (bbpe)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhd
 * JD-Core Version:    0.7.0.1
 */