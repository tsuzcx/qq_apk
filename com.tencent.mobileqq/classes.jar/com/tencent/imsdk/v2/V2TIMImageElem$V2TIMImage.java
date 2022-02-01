package com.tencent.imsdk.v2;

import androidx.annotation.NonNull;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.MessageCenter;

public class V2TIMImageElem$V2TIMImage
{
  private int height;
  private int size;
  private int type;
  private String url;
  private String uuid;
  private int width;
  
  public V2TIMImageElem$V2TIMImage(V2TIMImageElem paramV2TIMImageElem) {}
  
  public void downloadImage(@NonNull String paramString, V2TIMDownloadCallback paramV2TIMDownloadCallback)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.setDownloadFlag(DownloadParam.DOWNLOAD_FLAG_REQUEST_DIRECT_DOWNLOAD);
    localDownloadParam.setDownloadUrl(this.url);
    localDownloadParam.setFileSavePath(paramString);
    paramString = new V2TIMImageElem.V2TIMImage.1(this, paramV2TIMDownloadCallback);
    paramV2TIMDownloadCallback = new V2TIMImageElem.V2TIMImage.2(this, paramV2TIMDownloadCallback);
    MessageCenter.getInstance().downloadMessageElement(localDownloadParam, new V2TIMImageElem.V2TIMImage.3(this, paramString), new V2TIMImageElem.V2TIMImage.4(this, paramV2TIMDownloadCallback));
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUUID()
  {
    return this.uuid;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  protected void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  protected void setSize(int paramInt)
  {
    this.size = paramInt;
  }
  
  protected void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  protected void setUUID(String paramString)
  {
    this.uuid = paramString;
  }
  
  protected void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  protected void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage
 * JD-Core Version:    0.7.0.1
 */