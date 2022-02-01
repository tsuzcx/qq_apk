package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.SoundElement;

public class V2TIMSoundElem
  extends V2TIMElem
{
  public void downloadSound(String paramString, V2TIMDownloadCallback paramV2TIMDownloadCallback)
  {
    if (getElement() == null) {
      return;
    }
    SoundElement localSoundElement = (SoundElement)getElement();
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.setDownloadFlag(localSoundElement.getSoundDownloadFlag());
    localDownloadParam.setDownloadUrl(localSoundElement.getSoundDownloadUrl());
    localDownloadParam.setUuid(getUUID());
    localDownloadParam.setUuidType(MessageBaseElement.UUID_TYPE_AUDIO);
    localDownloadParam.setBusinessID(localSoundElement.getSoundBusinessID());
    localDownloadParam.setFileSavePath(paramString);
    paramString = new V2TIMSoundElem.1(this, paramV2TIMDownloadCallback);
    paramV2TIMDownloadCallback = new V2TIMSoundElem.2(this, paramV2TIMDownloadCallback);
    MessageCenter.getInstance().downloadMessageElement(localDownloadParam, new V2TIMSoundElem.3(this, paramString), new V2TIMSoundElem.4(this, paramV2TIMDownloadCallback));
  }
  
  public int getDataSize()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((SoundElement)getElement()).getSoundFileSize();
  }
  
  public int getDuration()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((SoundElement)getElement()).getSoundDuration();
  }
  
  public String getPath()
  {
    if (getElement() == null) {
      return null;
    }
    return ((SoundElement)getElement()).getSoundFilePath();
  }
  
  public String getUUID()
  {
    if (getElement() == null) {
      return null;
    }
    return ((SoundElement)getElement()).getSoundUUID();
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
    SoundElement localSoundElement = (SoundElement)getElement();
    if (localSoundElement.getSoundDownloadFlag() == 2)
    {
      paramV2TIMValueCallback.onSuccess(localSoundElement.getSoundDownloadUrl());
      return;
    }
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.setDownloadFlag(localSoundElement.getSoundDownloadFlag());
    localDownloadParam.setUuid(getUUID());
    localDownloadParam.setUuidType(MessageBaseElement.UUID_TYPE_FILE);
    localDownloadParam.setBusinessID(localSoundElement.getSoundBusinessID());
    MessageCenter.getInstance().getDownloadUrl(localDownloadParam, new V2TIMSoundElem.5(this, paramV2TIMValueCallback));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMSoundElem--->");
    localStringBuilder.append("uuid:");
    localStringBuilder.append(getUUID());
    localStringBuilder.append(", sender local path:");
    localStringBuilder.append(getPath());
    localStringBuilder.append(", duration:");
    localStringBuilder.append(getDuration());
    localStringBuilder.append(", dataSize:");
    localStringBuilder.append(getDataSize());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSoundElem
 * JD-Core Version:    0.7.0.1
 */