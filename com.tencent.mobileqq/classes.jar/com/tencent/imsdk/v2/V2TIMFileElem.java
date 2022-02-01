package com.tencent.imsdk.v2;

import androidx.annotation.NonNull;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;

public class V2TIMFileElem
  extends V2TIMElem
{
  public void downloadFile(@NonNull String paramString, V2TIMDownloadCallback paramV2TIMDownloadCallback)
  {
    if (getElement() == null) {
      return;
    }
    FileElement localFileElement = (FileElement)getElement();
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.setDownloadFlag(localFileElement.getFileDownloadFlag());
    localDownloadParam.setDownloadUrl(localFileElement.getFileDownloadUrl());
    localDownloadParam.setUuid(getUUID());
    localDownloadParam.setUuidType(MessageBaseElement.UUID_TYPE_FILE);
    localDownloadParam.setBusinessID(localFileElement.getFileBusinessID());
    localDownloadParam.setFileSavePath(paramString);
    paramString = new V2TIMFileElem.1(this, paramV2TIMDownloadCallback);
    paramV2TIMDownloadCallback = new V2TIMFileElem.2(this, paramV2TIMDownloadCallback);
    MessageCenter.getInstance().downloadMessageElement(localDownloadParam, new V2TIMFileElem.3(this, paramString), new V2TIMFileElem.4(this, paramV2TIMDownloadCallback));
  }
  
  public String getFileName()
  {
    if (getElement() == null) {
      return null;
    }
    return ((FileElement)getElement()).getFileName();
  }
  
  public int getFileSize()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((FileElement)getElement()).getFileSize();
  }
  
  public String getPath()
  {
    if (getElement() == null) {
      return null;
    }
    return ((FileElement)getElement()).getFilePath();
  }
  
  public String getUUID()
  {
    if (getElement() == null) {
      return null;
    }
    return ((FileElement)getElement()).getFileUUID();
  }
  
  public void getUrl(V2TIMValueCallback<String> paramV2TIMValueCallback)
  {
    if (paramV2TIMValueCallback == null) {
      return;
    }
    if (getElement() == null)
    {
      paramV2TIMValueCallback.onError(6017, "elem is null");
      return;
    }
    FileElement localFileElement = (FileElement)getElement();
    if (localFileElement.getFileDownloadFlag() == 2)
    {
      paramV2TIMValueCallback.onSuccess(localFileElement.getFileDownloadUrl());
      return;
    }
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.setDownloadFlag(localFileElement.getFileDownloadFlag());
    localDownloadParam.setUuid(getUUID());
    localDownloadParam.setUuidType(MessageBaseElement.UUID_TYPE_FILE);
    localDownloadParam.setBusinessID(localFileElement.getFileBusinessID());
    MessageCenter.getInstance().getDownloadUrl(localDownloadParam, new V2TIMFileElem.5(this, paramV2TIMValueCallback));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMFileElem--->");
    localStringBuilder.append("uuid:");
    localStringBuilder.append(getUUID());
    localStringBuilder.append(", sender local path:");
    localStringBuilder.append(getPath());
    localStringBuilder.append(", file name:");
    localStringBuilder.append(getFileName());
    localStringBuilder.append(", file size:");
    localStringBuilder.append(getFileSize());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFileElem
 * JD-Core Version:    0.7.0.1
 */