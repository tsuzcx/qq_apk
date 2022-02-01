import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atvy
  extends atib
{
  atvy(atvx paramatvx, atmc paramatmc) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (paramBoolean2) {}
    for (paramString1 = paramString4 + "&isthumb=0";; paramString1 = paramString4)
    {
      QLog.i("VideoForC2C<QFile>XOXO", 2, "[" + this.jdField_a_of_type_Atvx.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],[getOnlinePlay]  ID[" + paramLong2 + "]onUpdateGetOfflineDownloadInfo");
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Atvx.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
        this.jdField_a_of_type_Atvx.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString6;
      }
      this.jdField_a_of_type_Atvx.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform = paramBoolean2;
      auea.a(this.jdField_a_of_type_Atvx.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Atvx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new atvz(this, paramLong1, paramBoolean1, paramString3, paramBundle, paramShort, paramBoolean2, paramString2, paramString1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvy
 * JD-Core Version:    0.7.0.1
 */