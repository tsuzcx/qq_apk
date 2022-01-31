package com.tencent.component.media.image;

public class ImageDownloadInfo
{
  public String clientIp;
  public String contentType;
  public String downloadDetailInfo;
  public int failCode;
  public int nocacheCode;
  public int retCode;
  public String serverIp;
  
  private ImageDownloadInfo(ImageDownloadInfo.Builder paramBuilder)
  {
    this.failCode = ImageDownloadInfo.Builder.a(paramBuilder);
    this.retCode = ImageDownloadInfo.Builder.b(paramBuilder);
    this.contentType = ImageDownloadInfo.Builder.a(paramBuilder);
    this.serverIp = ImageDownloadInfo.Builder.b(paramBuilder);
    this.clientIp = ImageDownloadInfo.Builder.c(paramBuilder);
    this.nocacheCode = paramBuilder.nocache_code;
    this.downloadDetailInfo = paramBuilder.download_detail_info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageDownloadInfo
 * JD-Core Version:    0.7.0.1
 */