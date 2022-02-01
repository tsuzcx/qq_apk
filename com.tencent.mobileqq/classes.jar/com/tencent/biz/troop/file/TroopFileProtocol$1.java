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
    this.a.clear();
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
            ((ZipFilePresenter.FileData)localObject).a = true;
            ((ZipFilePresenter.FileData)localObject).c = paramBundle.getString(paramInt);
            this.a.add(localObject);
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
        localFileData.c = paramJSONObject.getString("filename");
        localFileData.b = paramJSONObject.getLong("size");
        if (this.b.equals("/"))
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("/");
          paramJSONObject.append(localFileData.c);
          str = paramJSONObject.toString();
        }
        else
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(this.b);
          paramJSONObject.append("/");
          paramJSONObject.append(localFileData.c);
          continue;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(this.c.strTroopFilePath);
        paramJSONObject.append(this.b);
        paramJSONObject.append(localFileData.c);
        localUUID = UUID.nameUUIDFromBytes(paramJSONObject.toString().getBytes());
        paramBundle = TroopFileTransferUtil.e(this.c.strTroopFilePath);
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
      paramBundle.append(this.b);
      paramBundle.append(localFileData.c);
      paramJSONObject = UUID.nameUUIDFromBytes(paramBundle.toString().getBytes());
      paramBundle = TroopFileTransferManager.a(this.d, this.c.TroopUin);
      localTroopFileStatusInfo = paramBundle.g(localUUID);
      if (localTroopFileStatusInfo != null)
      {
        paramJSONObject = FileManagerUtil.a(localTroopFileStatusInfo);
        paramJSONObject.zipFilePath = this.c.strTroopFilePath;
        paramJSONObject.zipInnerPath = str;
        paramJSONObject.isZipInnerFile = true;
        paramJSONObject.zipType = this.e;
        paramJSONObject.selfUin = this.c.selfUin;
      }
      else
      {
        paramJSONObject = paramBundle.g(paramJSONObject);
        if (paramJSONObject != null)
        {
          paramJSONObject = FileManagerUtil.a(paramJSONObject);
          paramJSONObject.zipFilePath = this.c.strTroopFilePath;
          paramJSONObject.zipInnerPath = str;
          paramJSONObject.isZipInnerFile = true;
          paramJSONObject.zipType = this.e;
          paramJSONObject.selfUin = this.c.selfUin;
        }
        else
        {
          paramJSONObject = new FileManagerEntity();
          paramJSONObject.fileName = localFileData.c;
          paramJSONObject.fileSize = localFileData.b;
          paramJSONObject.nSessionId = FileManagerUtil.a().longValue();
          paramJSONObject.strTroopFilePath = localUUID.toString();
          paramJSONObject.strTroopFileID = localUUID.toString();
          paramJSONObject.zipInnerPath = str;
          paramJSONObject.selfUin = this.c.selfUin;
          paramJSONObject.peerUin = this.c.peerUin;
          paramJSONObject.peerType = this.c.peerType;
          paramJSONObject.busId = this.c.busId;
          paramJSONObject.cloudType = 4;
          paramJSONObject.isZipInnerFile = true;
          paramJSONObject.zipFilePath = this.c.strTroopFilePath;
          paramJSONObject.zipType = this.e;
          paramJSONObject.TroopUin = this.c.TroopUin;
          this.d.getFileManagerProxy().a(paramJSONObject);
        }
      }
      paramJSONObject.isZipInnerFile = true;
      localFileData.d = paramJSONObject.nSessionId;
      this.a.add(localFileData);
      paramInt += 1;
    }
    paramJSONObject.printStackTrace();
    paramJSONObject = this.f;
    if (paramJSONObject != null) {
      paramJSONObject.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol.1
 * JD-Core Version:    0.7.0.1
 */