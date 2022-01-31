import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class arha
  implements arei
{
  arha(argq paramargq) {}
  
  public void a(argc paramargc)
  {
    paramargc = ((arel)paramargc).a();
    if (paramargc == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((arni.a(paramargc.a()) != 0) || (TextUtils.isEmpty(paramargc.a())) || (!TextUtils.isEmpty(paramargc.g())));
      FileManagerEntity localFileManagerEntity = paramargc.a();
      if (localFileManagerEntity == null)
      {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : can not get the troop file entity, return.");
        return;
      }
      localObject = bcjk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.strTroopFileID, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : troopUin[" + localFileManagerEntity.TroopUin + "] troopFileId[" + localFileManagerEntity.strTroopFileID + "] troopFilePath[" + localFileManagerEntity.strTroopFilePath + "]");
      }
      if (TextUtils.isEmpty(((bbpe)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can not find local thumb file, download.");
        }
        localObject = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin);
        if (localFileManagerEntity.strTroopFileID == null)
        {
          ((TroopFileTransferManager)localObject).a(localFileManagerEntity.strTroopFilePath, paramargc.a(), localFileManagerEntity.busId, 640);
          return;
        }
        ((TroopFileTransferManager)localObject).a(UUID.fromString(localFileManagerEntity.strTroopFileID), 640);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can find local thumb file, refresh the picture browser.");
      }
    } while (this.a.jdField_a_of_type_Arge == null);
    this.a.jdField_a_of_type_Arge.a(((bbpe)localObject).e, ((bbpe)localObject).c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arha
 * JD-Core Version:    0.7.0.1
 */