package com.tencent.biz.troop.file;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class TroopFileProtocol$1
  implements HttpWebCgiAsyncTask.Callback
{
  TroopFileProtocol$1(List paramList, String paramString, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, int paramInt, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramJSONObject != null) {}
    for (;;)
    {
      ZipFilePresenter.FileData localFileData;
      UUID localUUID;
      try
      {
        Object localObject;
        if (!paramJSONObject.isNull("dirs"))
        {
          paramBundle = paramJSONObject.getJSONArray("dirs");
          paramInt = 0;
          if (paramInt < paramBundle.length())
          {
            localObject = new ZipFilePresenter.FileData();
            ((ZipFilePresenter.FileData)localObject).jdField_a_of_type_Boolean = true;
            ((ZipFilePresenter.FileData)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString(paramInt);
            this.jdField_a_of_type_JavaUtilList.add(localObject);
            paramInt += 1;
            continue;
          }
        }
        if ((paramJSONObject != null) && (!paramJSONObject.isNull("files")))
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("files");
          paramInt = 0;
          if (paramInt < localJSONArray.length())
          {
            localFileData = new ZipFilePresenter.FileData();
            paramJSONObject = localJSONArray.getJSONObject(paramInt);
            localFileData.jdField_a_of_type_JavaLangString = paramJSONObject.getString("filename");
            localFileData.jdField_a_of_type_Long = paramJSONObject.getLong("size");
            if (this.jdField_a_of_type_JavaLangString.equals("/"))
            {
              paramJSONObject = "/" + localFileData.jdField_a_of_type_JavaLangString;
              localUUID = UUID.nameUUIDFromBytes((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath + this.jdField_a_of_type_JavaLangString + localFileData.jdField_a_of_type_JavaLangString).getBytes());
              localObject = TroopFileTransferUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath);
              if (localObject == null) {
                break label690;
              }
              paramBundle = (Bundle)localObject;
              if (((String)localObject).length() == 0) {
                break label690;
              }
              paramBundle = UUID.nameUUIDFromBytes((paramBundle + this.jdField_a_of_type_JavaLangString + localFileData.jdField_a_of_type_JavaLangString).getBytes());
              localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
              TroopFileStatusInfo localTroopFileStatusInfo = ((TroopFileTransferManager)localObject).a(localUUID);
              if (localTroopFileStatusInfo != null)
              {
                paramBundle = FileManagerUtil.a(localTroopFileStatusInfo);
                paramBundle.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
                paramBundle.zipInnerPath = paramJSONObject;
                paramBundle.isZipInnerFile = true;
                paramBundle.zipType = this.jdField_a_of_type_Int;
                paramBundle.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
                paramJSONObject = paramBundle;
                paramJSONObject.isZipInnerFile = true;
                localFileData.b = paramJSONObject.nSessionId;
                this.jdField_a_of_type_JavaUtilList.add(localFileData);
                paramInt += 1;
              }
            }
            else
            {
              paramJSONObject = this.jdField_a_of_type_JavaLangString + "/" + localFileData.jdField_a_of_type_JavaLangString;
              continue;
            }
            paramBundle = ((TroopFileTransferManager)localObject).a(paramBundle);
            if (paramBundle == null) {
              break label531;
            }
            paramBundle = FileManagerUtil.a(paramBundle);
            paramBundle.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
            paramBundle.zipInnerPath = paramJSONObject;
            paramBundle.isZipInnerFile = true;
            paramBundle.zipType = this.jdField_a_of_type_Int;
            paramBundle.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
            paramJSONObject = paramBundle;
            continue;
          }
        }
        paramBundle = new FileManagerEntity();
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        if (this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$OnGetZipFileList != null) {
          this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$OnGetZipFileList.a(this.jdField_a_of_type_JavaUtilList);
        }
        return;
      }
      label531:
      paramBundle.fileName = localFileData.jdField_a_of_type_JavaLangString;
      paramBundle.fileSize = localFileData.jdField_a_of_type_Long;
      paramBundle.nSessionId = FileManagerUtil.a().longValue();
      paramBundle.strTroopFilePath = localUUID.toString();
      paramBundle.strTroopFileID = localUUID.toString();
      paramBundle.zipInnerPath = paramJSONObject;
      paramBundle.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
      paramBundle.peerUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      paramBundle.peerType = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
      paramBundle.busId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
      paramBundle.cloudType = 4;
      paramBundle.isZipInnerFile = true;
      paramBundle.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
      paramBundle.zipType = this.jdField_a_of_type_Int;
      paramBundle.TroopUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramBundle);
      paramJSONObject = paramBundle;
      continue;
      label690:
      paramBundle = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol.1
 * JD-Core Version:    0.7.0.1
 */