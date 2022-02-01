import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class beba
  extends atrl
{
  beba(beaz parambeaz) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    paramInt = 0;
    paramByteStringMicro = new JSONObject();
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportJobForC2C", 2, "---onUpdateGetOfflineDownloadInfo retCode: " + paramLong1 + ",retMsg: " + paramString1 + ",strCookie: " + paramString2 + ",strIP: " + paramString3 + ",port: " + paramShort);
      }
      paramString1 = new StringBuilder("http://");
      paramString1.append(paramString3).append(":").append(paramShort).append(paramString4);
      if (paramBoolean2) {
        paramString1.append("&isthumb=0");
      }
      try
      {
        paramString3 = new JSONArray();
        paramString3.put(0, paramString1.toString());
        paramByteStringMicro.put("urls", paramString3);
        paramByteStringMicro.put("filename", paramString5);
        paramByteStringMicro.put("cookie", paramString2);
        paramByteStringMicro.put("bUseMediaPlatform", paramBoolean2);
        paramShort = 1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramShort = 0;
          QLog.e("TeamWorkFileImportJobForC2C", 2, "onUpdateGetOfflineDownloadInfo exception: " + paramString1.toString());
        }
      }
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
        {
          if (paramShort == 0) {
            paramByteStringMicro.put("filename", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b);
          }
          paramByteStringMicro.put("filetype", 1);
          paramByteStringMicro.put("fileid", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
          paramByteStringMicro.put("md5", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5);
          paramByteStringMicro.put("sha", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA);
          paramByteStringMicro.put("filesize", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
          if (this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.j != null) {
            paramByteStringMicro.put("senderuin", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.j);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.l = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.i = 1;
          if (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
            continue;
          }
          paramByteStringMicro.put("ownertype", 1);
          paramByteStringMicro.put("importoption", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g);
          paramInt = 1;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("TeamWorkFileImportJobForC2C", 2, "put fileid exception: " + paramString1.toString());
        paramInt = 0;
        continue;
        this.a.a(true);
      }
      if (((paramInt == 0) && (paramShort == 0)) || (!beaj.a(paramByteStringMicro)) || (!beaz.a(this.a, paramByteStringMicro))) {
        continue;
      }
      this.a.jdField_a_of_type_Beav.a(paramByteStringMicro, this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, this.a.hashCode());
      return;
      QLog.e("TeamWorkFileImportJobForC2C", 1, "---onUpdateGetOfflineDownloadInfo retCode: " + paramLong1 + ",fileName: " + paramString5 + "----");
      paramShort = paramInt;
      break;
      paramByteStringMicro.put("ownertype", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beba
 * JD-Core Version:    0.7.0.1
 */