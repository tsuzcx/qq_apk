import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class auhm
  implements aufa
{
  auhm(auha paramauha) {}
  
  public void a(augl paramaugl)
  {
    paramaugl = ((aufd)paramaugl).a();
    if (paramaugl == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((aunj.a(paramaugl.a()) != 0) || (TextUtils.isEmpty(paramaugl.a())) || (!TextUtils.isEmpty(paramaugl.g())));
      FileManagerEntity localFileManagerEntity = paramaugl.a();
      if (localFileManagerEntity == null)
      {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : can not get the troop file entity, return.");
        return;
      }
      localObject = bgsk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.strTroopFileID, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : troopUin[" + localFileManagerEntity.TroopUin + "] troopFileId[" + localFileManagerEntity.strTroopFileID + "] troopFilePath[" + localFileManagerEntity.strTroopFilePath + "]");
      }
      if (TextUtils.isEmpty(((bftf)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can not find local thumb file, download.");
        }
        localObject = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin);
        if (localFileManagerEntity.strTroopFileID == null)
        {
          ((TroopFileTransferManager)localObject).a(localFileManagerEntity.strTroopFilePath, paramaugl.a(), localFileManagerEntity.busId, 640);
          return;
        }
        ((TroopFileTransferManager)localObject).a(UUID.fromString(localFileManagerEntity.strTroopFileID), 640);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can find local thumb file, refresh the picture browser.");
      }
    } while (this.a.jdField_a_of_type_Augo == null);
    this.a.jdField_a_of_type_Augo.a(((bftf)localObject).e, ((bftf)localObject).c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhm
 * JD-Core Version:    0.7.0.1
 */