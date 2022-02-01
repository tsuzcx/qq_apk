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
    this.failCode = ImageDownloadInfo.Builder.access$100(paramBuilder);
    this.retCode = ImageDownloadInfo.Builder.access$200(paramBuilder);
    this.contentType = ImageDownloadInfo.Builder.access$300(paramBuilder);
    this.serverIp = ImageDownloadInfo.Builder.access$400(paramBuilder);
    this.clientIp = ImageDownloadInfo.Builder.access$500(paramBuilder);
    this.nocacheCode = paramBuilder.nocache_code;
    this.downloadDetailInfo = paramBuilder.download_detail_info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ImageDownloadInfo
 * JD-Core Version:    0.7.0.1
 */