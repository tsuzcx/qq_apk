import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arvf
  implements bezd
{
  public arvf(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, List paramList, String paramString1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3, String paramString4, short paramShort, String paramString5, int paramInt, String paramString6, zrl paramzrl) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramJSONObject != null) {}
    try
    {
      aswh localaswh;
      if (!paramJSONObject.isNull("dirs"))
      {
        paramBundle = paramJSONObject.getJSONArray("dirs");
        paramInt = 0;
        while (paramInt < paramBundle.length())
        {
          localaswh = new aswh();
          localaswh.jdField_a_of_type_Boolean = true;
          localaswh.jdField_a_of_type_JavaLangString = paramBundle.getString(paramInt);
          this.jdField_a_of_type_JavaUtilList.add(localaswh);
          paramInt += 1;
        }
      }
      if ((paramJSONObject != null) && (!paramJSONObject.isNull("files")))
      {
        paramBundle = paramJSONObject.getJSONArray("files");
        paramInt = 0;
        if (paramInt < paramBundle.length())
        {
          localaswh = new aswh();
          paramJSONObject = paramBundle.getJSONObject(paramInt);
          localaswh.jdField_a_of_type_JavaLangString = paramJSONObject.getString("filename");
          localaswh.jdField_a_of_type_Long = paramJSONObject.getLong("size");
          label186:
          FileManagerEntity localFileManagerEntity;
          if (this.jdField_a_of_type_JavaLangString.equals("/"))
          {
            paramJSONObject = "/" + localaswh.jdField_a_of_type_JavaLangString;
            localFileManagerEntity = new FileManagerEntity();
            localFileManagerEntity.fileName = localaswh.jdField_a_of_type_JavaLangString;
            localFileManagerEntity.nRelatedSessionId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
            localFileManagerEntity.fileSize = localaswh.jdField_a_of_type_Long;
            localFileManagerEntity.mContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
            localFileManagerEntity.nSessionId = aszt.a().longValue();
            if (this.jdField_a_of_type_Boolean)
            {
              localFileManagerEntity.WeiYunFileId = this.jdField_b_of_type_JavaLangString;
              localFileManagerEntity.mContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
              localFileManagerEntity.nRelatedSessionId = aszt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
            }
            localFileManagerEntity.zipFileId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
            if (localFileManagerEntity.mContext == null) {
              QLog.i("IphoneTitleBarActivity", 1, "zip list file content is empty. zipSessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] zipIsWeiyunFile[" + this.jdField_a_of_type_Boolean + "] zipCouldType[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType + "] fileSessionId[" + localFileManagerEntity.nSessionId + "]");
            }
            if ((this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(this.c))) {
              break label691;
            }
            localFileManagerEntity.strServerPath = ("https://" + this.d + ":" + this.jdField_a_of_type_Short + "/ftn_compress_getfile/rkey=" + this.e + "&filetype=" + this.jdField_a_of_type_Int + "&path=" + bjnd.a(paramJSONObject) + "&");
            localFileManagerEntity.httpsDomain = this.c;
          }
          for (;;)
          {
            localFileManagerEntity.zipFileId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
            localFileManagerEntity.zipInnerPath = paramJSONObject;
            localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
            localFileManagerEntity.peerUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
            localFileManagerEntity.peerType = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
            localFileManagerEntity.busId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
            localFileManagerEntity.cloudType = 1;
            localFileManagerEntity.isZipInnerFile = true;
            localFileManagerEntity.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
            localFileManagerEntity.zipType = this.jdField_a_of_type_Int;
            localFileManagerEntity.TroopUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
            localaswh.b = localFileManagerEntity.nSessionId;
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.app.getFileManagerProxy().a(localFileManagerEntity);
            this.jdField_a_of_type_JavaUtilList.add(localaswh);
            paramInt += 1;
            break;
            paramJSONObject = this.jdField_a_of_type_JavaLangString + "/" + localaswh.jdField_a_of_type_JavaLangString;
            break label186;
            label691:
            localFileManagerEntity.strServerPath = ("http://" + this.d + ":" + this.f + "/ftn_compress_getfile/rkey=" + this.e + "&filetype=" + this.jdField_a_of_type_Int + "&path=" + bjnd.a(paramJSONObject) + "&");
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      if (this.jdField_a_of_type_Zrl != null) {
        this.jdField_a_of_type_Zrl.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvf
 * JD-Core Version:    0.7.0.1
 */