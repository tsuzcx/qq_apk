package com.tencent.imsdk.message;

public class ImageElement
  extends MessageBaseElement
{
  private int compressType;
  private int imageFormat;
  private int largeImageFileSize;
  private int largeImageHeight;
  private String largeImageUUID;
  private String largeImageUrl;
  private int largeImageWidth;
  private String originImageFilePath;
  private int originImageFileSize;
  private int originImageHeight;
  private String originImageUUID;
  private String originImageUrl;
  private int originImageWidth;
  private int thumbImageFileSize;
  private int thumbImageHeight;
  private String thumbImageUUID;
  private String thumbImageUrl;
  private int thumbImageWidth;
  
  public ImageElement()
  {
    setElementType(3);
  }
  
  public int getCompressType()
  {
    return this.compressType;
  }
  
  public int getImageFormat()
  {
    return this.imageFormat;
  }
  
  public int getLargeImageFileSize()
  {
    return this.largeImageFileSize;
  }
  
  public int getLargeImageHeight()
  {
    return this.largeImageHeight;
  }
  
  public String getLargeImageUUID()
  {
    return this.largeImageUUID;
  }
  
  public String getLargeImageUrl()
  {
    return this.largeImageUrl;
  }
  
  public int getLargeImageWidth()
  {
    return this.largeImageWidth;
  }
  
  public String getOriginImageFilePath()
  {
    return this.originImageFilePath;
  }
  
  public int getOriginImageFileSize()
  {
    return this.originImageFileSize;
  }
  
  public int getOriginImageHeight()
  {
    return this.originImageHeight;
  }
  
  public String getOriginImageUUID()
  {
    return this.originImageUUID;
  }
  
  public String getOriginImageUrl()
  {
    return this.originImageUrl;
  }
  
  public int getOriginImageWidth()
  {
    return this.originImageWidth;
  }
  
  public int getThumbImageFileSize()
  {
    return this.thumbImageFileSize;
  }
  
  public int getThumbImageHeight()
  {
    return this.thumbImageHeight;
  }
  
  public String getThumbImageUUID()
  {
    return this.thumbImageUUID;
  }
  
  public String getThumbImageUrl()
  {
    return this.thumbImageUrl;
  }
  
  public int getThumbImageWidth()
  {
    return this.thumbImageWidth;
  }
  
  public void setOriginImageFilePath(String paramString)
  {
    this.originImageFilePath = paramString;
  }
  
  public boolean update(MessageBaseElement paramMessageBaseElement)
  {
    if (this.elementType == paramMessageBaseElement.elementType)
    {
      paramMessageBaseElement = (ImageElement)paramMessageBaseElement;
      if (this.originImageFilePath.equals(paramMessageBaseElement.originImageFilePath))
      {
        this.imageFormat = paramMessageBaseElement.imageFormat;
        this.compressType = paramMessageBaseElement.compressType;
        this.originImageUUID = paramMessageBaseElement.originImageUUID;
        this.originImageUrl = paramMessageBaseElement.originImageUrl;
        this.originImageFileSize = paramMessageBaseElement.originImageFileSize;
        this.originImageWidth = paramMessageBaseElement.originImageWidth;
        this.originImageHeight = paramMessageBaseElement.originImageHeight;
        this.thumbImageUUID = paramMessageBaseElement.thumbImageUUID;
        this.thumbImageUrl = paramMessageBaseElement.thumbImageUrl;
        this.thumbImageFileSize = paramMessageBaseElement.thumbImageFileSize;
        this.thumbImageWidth = paramMessageBaseElement.thumbImageWidth;
        this.thumbImageHeight = paramMessageBaseElement.thumbImageHeight;
        this.largeImageUUID = paramMessageBaseElement.largeImageUUID;
        this.largeImageUrl = paramMessageBaseElement.largeImageUrl;
        this.largeImageFileSize = paramMessageBaseElement.largeImageFileSize;
        this.largeImageWidth = paramMessageBaseElement.largeImageWidth;
        this.largeImageHeight = paramMessageBaseElement.largeImageHeight;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.ImageElement
 * JD-Core Version:    0.7.0.1
 */