import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class apob
  implements aplj
{
  apob(apnq paramapnq) {}
  
  public void a(apnc paramapnc)
  {
    paramapnc = ((aplm)paramapnc).a();
    if (paramapnc == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((apug.a(paramapnc.a()) != 0) || (TextUtils.isEmpty(paramapnc.a())) || (!TextUtils.isEmpty(paramapnc.g())));
      FileManagerEntity localFileManagerEntity = paramapnc.a();
      if (localFileManagerEntity == null)
      {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : can not get the troop file entity, return.");
        return;
      }
      localObject = bakx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.strTroopFileID, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : troopUin[" + localFileManagerEntity.TroopUin + "] troopFileId[" + localFileManagerEntity.strTroopFileID + "] troopFilePath[" + localFileManagerEntity.strTroopFilePath + "]");
      }
      if (TextUtils.isEmpty(((azqv)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can not find local thumb file, download.");
        }
        localObject = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin);
        if (localFileManagerEntity.strTroopFileID == null)
        {
          ((TroopFileTransferManager)localObject).a(localFileManagerEntity.strTroopFilePath, paramapnc.a(), localFileManagerEntity.busId, 640);
          return;
        }
        ((TroopFileTransferManager)localObject).a(UUID.fromString(localFileManagerEntity.strTroopFileID), 640);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can find local thumb file, refresh the picture browser.");
      }
    } while (this.a.jdField_a_of_type_Apne == null);
    this.a.jdField_a_of_type_Apne.a(((azqv)localObject).e, ((azqv)localObject).c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apob
 * JD-Core Version:    0.7.0.1
 */