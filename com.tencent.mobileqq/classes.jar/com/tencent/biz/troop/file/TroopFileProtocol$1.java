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
    int i = 0;
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
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
        if ((paramJSONObject == null) || (paramJSONObject.isNull("files"))) {
          continue;
        }
        Object localObject = paramJSONObject.getJSONArray("files");
        paramInt = i;
        if (paramInt >= ((JSONArray)localObject).length()) {
          continue;
        }
        localFileData = new ZipFilePresenter.FileData();
        paramJSONObject = ((JSONArray)localObject).getJSONObject(paramInt);
        localFileData.jdField_a_of_type_JavaLangString = paramJSONObject.getString("filename");
        localFileData.jdField_a_of_type_Long = paramJSONObject.getLong("size");
        if (this.jdField_a_of_type_JavaLangString.equals("/"))
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("/");
          paramJSONObject.append(localFileData.jdField_a_of_type_JavaLangString);
          str = paramJSONObject.toString();
        }
        else
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(this.jdField_a_of_type_JavaLangString);
          paramJSONObject.append("/");
          paramJSONObject.append(localFileData.jdField_a_of_type_JavaLangString);
          continue;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath);
        paramJSONObject.append(this.jdField_a_of_type_JavaLangString);
        paramJSONObject.append(localFileData.jdField_a_of_type_JavaLangString);
        localUUID = UUID.nameUUIDFromBytes(paramJSONObject.toString().getBytes());
        paramBundle = TroopFileTransferUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath);
        if (paramBundle == null) {
          continue;
        }
        paramJSONObject = paramBundle;
        if (paramBundle.length() != 0) {}
      }
      catch (JSONException paramJSONObject)
      {
        ZipFilePresenter.FileData localFileData;
        String str;
        UUID localUUID;
        TroopFileStatusInfo localTroopFileStatusInfo;
        continue;
        paramJSONObject = "0";
        continue;
      }
      paramBundle = new StringBuilder();
      paramBundle.append(paramJSONObject);
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      paramBundle.append(localFileData.jdField_a_of_type_JavaLangString);
      paramJSONObject = UUID.nameUUIDFromBytes(paramBundle.toString().getBytes());
      paramBundle = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
      localTroopFileStatusInfo = paramBundle.a(localUUID);
      if (localTroopFileStatusInfo != null)
      {
        paramJSONObject = FileManagerUtil.a(localTroopFileStatusInfo);
        paramJSONObject.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
        paramJSONObject.zipInnerPath = str;
        paramJSONObject.isZipInnerFile = true;
        paramJSONObject.zipType = this.jdField_a_of_type_Int;
        paramJSONObject.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
      }
      else
      {
        paramJSONObject = paramBundle.a(paramJSONObject);
        if (paramJSONObject != null)
        {
          paramJSONObject = FileManagerUtil.a(paramJSONObject);
          paramJSONObject.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
          paramJSONObject.zipInnerPath = str;
          paramJSONObject.isZipInnerFile = true;
          paramJSONObject.zipType = this.jdField_a_of_type_Int;
          paramJSONObject.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
        }
        else
        {
          paramJSONObject = new FileManagerEntity();
          paramJSONObject.fileName = localFileData.jdField_a_of_type_JavaLangString;
          paramJSONObject.fileSize = localFileData.jdField_a_of_type_Long;
          paramJSONObject.nSessionId = FileManagerUtil.a().longValue();
          paramJSONObject.strTroopFilePath = localUUID.toString();
          paramJSONObject.strTroopFileID = localUUID.toString();
          paramJSONObject.zipInnerPath = str;
          paramJSONObject.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
          paramJSONObject.peerUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          paramJSONObject.peerType = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
          paramJSONObject.busId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
          paramJSONObject.cloudType = 4;
          paramJSONObject.isZipInnerFile = true;
          paramJSONObject.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
          paramJSONObject.zipType = this.jdField_a_of_type_Int;
          paramJSONObject.TroopUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramJSONObject);
        }
      }
      paramJSONObject.isZipInnerFile = true;
      localFileData.b = paramJSONObject.nSessionId;
      this.jdField_a_of_type_JavaUtilList.add(localFileData);
      paramInt += 1;
    }
    paramJSONObject.printStackTrace();
    paramJSONObject = this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$OnGetZipFileList;
    if (paramJSONObject != null) {
      paramJSONObject.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol.1
 * JD-Core Version:    0.7.0.1
 */