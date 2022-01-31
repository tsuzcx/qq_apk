package com.tencent.component.media.image;

public class ImageDownloadInfo$Builder
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  public String download_detail_info;
  public int nocache_code;
  
  public ImageDownloadInfo$Builder(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public ImageDownloadInfo build()
  {
    return new ImageDownloadInfo(this, null);
  }
  
  public Builder clientIp(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Builder contentType(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder downloadDetailInfo(String paramString)
  {
    this.download_detail_info = paramString;
    return this;
  }
  
  public Builder nocacheCode(int paramInt)
  {
    this.nocache_code = paramInt;
    return this;
  }
  
  public Builder serverIp(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageDownloadInfo.Builder
 * JD-Core Version:    0.7.0.1
 */