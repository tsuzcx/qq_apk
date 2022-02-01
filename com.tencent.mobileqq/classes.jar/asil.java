import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class asil
  implements asir
{
  asil(asii paramasii, TroopFileTransferManager.Item paramItem, long paramLong) {}
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] onCheckResult. Item.Id=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getId() + " errCode:" + paramInt1);
    if ((paramInt1 == 0) && (paramInt2 != 0) && (paramInt2 != 4))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.apkSafeLevel = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.apkSafeMsg = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.apkSafeDetailUrl = paramString2;
      beel.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      if ((this.jdField_a_of_type_Asii.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null))
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asii.a.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString());
        if (localFileManagerEntity != null)
        {
          QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] onCheckResult. Item.Id=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getId() + " update about entity:" + localFileManagerEntity.nSessionId);
          localFileManagerEntity.apkSafeLevel = paramInt2;
          localFileManagerEntity.apkSafeMsg = paramString1;
          localFileManagerEntity.apkSafeDetailUrl = paramString2;
          this.jdField_a_of_type_Asii.a.getFileManagerDataCenter().c(localFileManagerEntity);
        }
      }
    }
    if (this.jdField_a_of_type_Asii.a != null) {
      ((amoo)this.jdField_a_of_type_Asii.a.getBusinessHandler(22)).e(new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_a_of_type_Long), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramBundle });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asil
 * JD-Core Version:    0.7.0.1
 */