package com.tencent.aelight.camera.aeeditor.data;

import java.io.Serializable;

public class AEEditorDownloadResBean
  implements Serializable
{
  public static final int PRE_DOWNLOAD_FALSE = 0;
  public static final int PRE_DOWNLOAD_TRUE = 1;
  private String fontFamily;
  private String id;
  private String md5;
  private int preDownload;
  private String url;
  
  public String getFontFamily()
  {
    return this.fontFamily;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public int getPreDownload()
  {
    return this.preDownload;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setFontFamily(String paramString)
  {
    this.fontFamily = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMd5(String paramString)
  {
    this.md5 = paramString;
  }
  
  public void setPreDownload(int paramInt)
  {
    this.preDownload = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean
 * JD-Core Version:    0.7.0.1
 */