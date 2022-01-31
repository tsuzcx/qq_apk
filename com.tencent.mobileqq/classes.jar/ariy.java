import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ariy
  extends aqtp
{
  ariy(arix paramarix, aqxm paramaqxm) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    QLog.i("VideoForC2C<QFile>", 2, "[" + this.jdField_a_of_type_Arix.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],[getOnlinePlay]  ID[" + paramLong2 + "]onUpdateGetOfflineDownloadInfo");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Arix.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
      this.jdField_a_of_type_Arix.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString6;
    }
    arrr.a(this.jdField_a_of_type_Arix.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Arix.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ariz(this, paramLong1, paramBoolean, paramString3, paramString2, paramShort, paramString4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ariy
 * JD-Core Version:    0.7.0.1
 */