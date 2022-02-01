package com.tencent.imsdk.v2;

import androidx.annotation.NonNull;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.VideoElement;

public class V2TIMVideoElem
  extends V2TIMElem
{
  public void downloadSnapshot(@NonNull String paramString, V2TIMDownloadCallback paramV2TIMDownloadCallback)
  {
    if (getElement() == null) {
      return;
    }
    VideoElement localVideoElement = (VideoElement)getElement();
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.setDownloadFlag(localVideoElement.getSnapshotDownloadFlag());
    localDownloadParam.setDownloadUrl(localVideoElement.getSnapshotDownloadUrl());
    localDownloadParam.setUuid(localVideoElement.getSnapshotUUID());
    localDownloadParam.setUuidType(MessageBaseElement.UUID_TYPE_VIDEO_THUMB);
    localDownloadParam.setBusinessID(localVideoElement.getVideoBusinessID());
    localDownloadParam.setFileSavePath(paramString);
    paramString = new V2TIMVideoElem.6(this, paramV2TIMDownloadCallback);
    paramV2TIMDownloadCallback = new V2TIMVideoElem.7(this, paramV2TIMDownloadCallback);
    MessageCenter.getInstance().downloadMessageElement(localDownloadParam, new V2TIMVideoElem.8(this, paramString), new V2TIMVideoElem.9(this, paramV2TIMDownloadCallback));
  }
  
  public void downloadVideo(@NonNull String paramString, V2TIMDownloadCallback paramV2TIMDownloadCallback)
  {
    if (getElement() == null)
    {
      if (paramV2TIMDownloadCallback != null) {
        paramV2TIMDownloadCallback.onError(6017, "getTIMElem is null");
      }
      return;
    }
    VideoElement localVideoElement = (VideoElement)getElement();
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.setDownloadFlag(localVideoElement.getVideoDownloadFlag());
    localDownloadParam.setDownloadUrl(localVideoElement.getVideoDownloadUrl());
    localDownloadParam.setUuid(localVideoElement.getVideoUUID());
    localDownloadParam.setUuidType(MessageBaseElement.UUID_TYPE_VIDEO);
    localDownloadParam.setBusinessID(localVideoElement.getVideoBusinessID());
    localDownloadParam.setFileSavePath(paramString);
    paramString = new V2TIMVideoElem.1(this, paramV2TIMDownloadCallback);
    paramV2TIMDownloadCallback = new V2TIMVideoElem.2(this, paramV2TIMDownloadCallback);
    MessageCenter.getInstance().downloadMessageElement(localDownloadParam, new V2TIMVideoElem.3(this, paramString), new V2TIMVideoElem.4(this, paramV2TIMDownloadCallback));
  }
  
  public int getDuration()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((VideoElement)getElement()).getVideoDuration();
  }
  
  public int getSnapshotHeight()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((VideoElement)getElement()).getSnapshotHeight();
  }
  
  public String getSnapshotPath()
  {
    if (getElement() == null) {
      return null;
    }
    return ((VideoElement)getElement()).getSnapshotFilePath();
  }
  
  public int getSnapshotSize()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((VideoElement)getElement()).getSnapshotFileSize();
  }
  
  public String getSnapshotUUID()
  {
    if (getElement() == null) {
      return null;
    }
    return ((VideoElement)getElement()).getSnapshotUUID();
  }
  
  public void getSnapshotUrl(V2TIMValueCallback<String> paramV2TIMValueCallback)
  {
    if (paramV2TIMValueCallback == null) {
      return;
    }
    if (getElement() == null)
    {
      paramV2TIMValueCallback.onError(6017, "elem is null");
      return;
    }
    VideoElement localVideoElement = (VideoElement)getElement();
    if (localVideoElement.getSnapshotDownloadFlag() == 2)
    {
      paramV2TIMValueCallback.onSuccess(localVideoElement.getSnapshotDownloadUrl());
      return;
    }
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.setDownloadFlag(localVideoElement.getSnapshotDownloadFlag());
    localDownloadParam.setUuid(getSnapshotUUID());
    localDownloadParam.setUuidType(MessageBaseElement.UUID_TYPE_FILE);
    localDownloadParam.setBusinessID(localVideoElement.getVideoBusinessID());
    MessageCenter.getInstance().getDownloadUrl(localDownloadParam, new V2TIMVideoElem.10(this, paramV2TIMValueCallback));
  }
  
  public int getSnapshotWidth()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((VideoElement)getElement()).getSnapshotWidth();
  }
  
  public String getVideoPath()
  {
    if (getElement() == null) {
      return null;
    }
    return ((VideoElement)getElement()).getVideoFilePath();
  }
  
  public int getVideoSize()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((VideoElement)getElement()).getVideoFileSize();
  }
  
  public String getVideoUUID()
  {
    if (getElement() == null) {
      return null;
    }
    return ((VideoElement)getElement()).getVideoUUID();
  }
  
  public void getVideoUrl(V2TIMValueCallback<String> paramV2TIMValueCallback)
  {
    if (paramV2TIMValueCallback == null) {
      return;
    }
    if (getElement() == null)
    {
      paramV2TIMValueCallback.onError(6017, "elem is null");
      return;
    }
    VideoElement localVideoElement = (VideoElement)getElement();
    if (localVideoElement.getSnapshotDownloadFlag() == 2)
    {
      paramV2TIMValueCallback.onSuccess(localVideoElement.getVideoDownloadUrl());
      return;
    }
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.setDownloadFlag(localVideoElement.getVideoDownloadFlag());
    localDownloadParam.setUuid(getVideoUUID());
    localDownloadParam.setUuidType(MessageBaseElement.UUID_TYPE_FILE);
    localDownloadParam.setBusinessID(localVideoElement.getVideoBusinessID());
    MessageCenter.getInstance().getDownloadUrl(localDownloadParam, new V2TIMVideoElem.5(this, paramV2TIMValueCallback));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMVideoElem--->");
    localStringBuilder.append("video uuid:");
    localStringBuilder.append(getVideoUUID());
    localStringBuilder.append(", snapshot uuid:");
    localStringBuilder.append(getSnapshotUUID());
    localStringBuilder.append(", duration:");
    localStringBuilder.append(getDuration());
    localStringBuilder.append(", sender local video path:");
    localStringBuilder.append(getVideoPath());
    localStringBuilder.append(", video size:");
    localStringBuilder.append(getVideoSize());
    localStringBuilder.append(", sender local snapshot path");
    localStringBuilder.append(getSnapshotPath());
    localStringBuilder.append(", snapshot height:");
    localStringBuilder.append(getSnapshotHeight());
    localStringBuilder.append(", snapshot width:");
    localStringBuilder.append(getSnapshotWidth());
    localStringBuilder.append(", snapshot size:");
    localStringBuilder.append(getSnapshotSize());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMVideoElem
 * JD-Core Version:    0.7.0.1
 */