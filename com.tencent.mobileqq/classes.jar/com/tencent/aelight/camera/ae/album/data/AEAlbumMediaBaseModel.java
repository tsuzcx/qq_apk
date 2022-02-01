package com.tencent.aelight.camera.ae.album.data;

import java.io.Serializable;

public class AEAlbumMediaBaseModel
  implements Serializable
{
  private String mOriginPath;
  private String path;
  
  public AEAlbumMediaBaseModel(String paramString)
  {
    this.path = paramString;
  }
  
  public String getOriginPath()
  {
    return this.mOriginPath;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public void setOriginPath(String paramString)
  {
    this.mOriginPath = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel
 * JD-Core Version:    0.7.0.1
 */