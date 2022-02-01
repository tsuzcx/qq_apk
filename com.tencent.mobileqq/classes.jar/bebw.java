import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class bebw
  extends aahm
{
  bebw(bebv parambebv) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      if (paramDownloadFileRspBody != null)
      {
        paramInt = paramDownloadFileRspBody.int32_ret_code.get();
        if (paramInt != 0) {
          break label549;
        }
        Object localObject = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
        paramBundle = (Bundle)localObject;
        if (localObject != null) {
          paramBundle = ((String)localObject).toLowerCase();
        }
        localObject = paramDownloadFileRspBody.str_download_ip.get();
        String str = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.i("TeamWorkFileImportJobForGroup", 2, "---onReqDownloadFileResult success ,ip: " + (String)localObject + ",param: " + str);
        }
        paramDownloadFileRspBody = new StringBuilder("http://");
        paramDownloadFileRspBody.append((String)localObject).append("/ftn_handler/").append(str).append("/?fname=").append(HexUtil.String2HexString(this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString));
        try
        {
          localObject = new JSONArray();
          ((JSONArray)localObject).put(0, paramDownloadFileRspBody.toString());
          localJSONObject.put("urls", localObject);
          localJSONObject.put("filename", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
          localJSONObject.put("cookie", "FTN5K=" + paramBundle);
          paramInt = 1;
          if (paramInt != 0) {}
        }
        catch (Exception paramDownloadFileRspBody)
        {
          label459:
          QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult json exception: " + paramDownloadFileRspBody.toString());
        }
      }
    }
    try
    {
      localJSONObject.put("filename", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("filetype", 3);
      localJSONObject.put("fileid", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString);
      localJSONObject.put("businesstype", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Int);
      localJSONObject.put("groupuin", Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.a));
      localJSONObject.put("importoption", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
      {
        localJSONObject.put("md5", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5);
        localJSONObject.put("sha", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA);
      }
      localJSONObject.put("filesize", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Long);
      this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.l = this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString;
      this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.i = 3;
      i = 1;
    }
    catch (Exception paramDownloadFileRspBody)
    {
      label549:
      QLog.e("TeamWorkFileImportJobForGroup", 2, "put fileid exception: " + paramDownloadFileRspBody.toString());
      break label459;
      this.a.a(true);
    }
    if (((i != 0) || (paramInt != 0)) && (beaz.a(localJSONObject)) && (bebv.a(this.a, localJSONObject)))
    {
      this.a.jdField_a_of_type_Bebl.a(localJSONObject, this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, this.a.hashCode());
      return;
      for (;;)
      {
        paramInt = 0;
        break;
        QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult retCode: " + paramInt);
        continue;
        QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult errorCode: " + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebw
 * JD-Core Version:    0.7.0.1
 */