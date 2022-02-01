import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class asik
  implements asir
{
  asik(asii paramasii, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] onCheckResult. nSessionId=" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + " errCode:" + paramInt1);
    if ((paramInt1 == 0) && (paramInt2 != 0) && (paramInt2 != 4))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.apkSafeLevel = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.apkSafeMsg = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.apkSafeDetailUrl = paramString2;
      if (this.jdField_a_of_type_Asii.a != null) {
        this.jdField_a_of_type_Asii.a.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
    if (this.jdField_a_of_type_Asii.a != null) {
      this.jdField_a_of_type_Asii.a.getFileManagerNotifyCenter().a(true, 200, new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramBundle });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asik
 * JD-Core Version:    0.7.0.1
 */