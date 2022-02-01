package com.tencent.aelight.camera.aeeditor.manage;

import java.io.Serializable;

public class AEEditorEffectGroupListBean$AEEditorEffectItem
  implements Serializable
{
  public static final int STYLIZE_TYPE_COMIC = 1;
  public static final int STYLIZE_TYPE_PAINTING = 2;
  private int disableForImage = 0;
  private int disableForVideo = 0;
  private String effectID = "";
  private String effectName = "";
  private String effectType = "client";
  private int hideAlphaBar = 0;
  private int hideApplyAll = 0;
  private int imageShowLevel = 0;
  private int netStylizeType = 0;
  private int preDownload = 0;
  private String resourceMD5 = "";
  private String resourceURL = "";
  private String thumbURL = "";
  private int uploadMaxSize;
  private int videoShowLevel = 0;
  
  public int getDisableForImage()
  {
    return this.disableForImage;
  }
  
  public int getDisableForVideo()
  {
    return this.disableForVideo;
  }
  
  public String getEffectID()
  {
    return this.effectID;
  }
  
  public String getEffectName()
  {
    return this.effectName;
  }
  
  public String getEffectType()
  {
    return this.effectType;
  }
  
  public int getHideAlphaBar()
  {
    return this.hideAlphaBar;
  }
  
  public int getHideApplyAll()
  {
    return this.hideApplyAll;
  }
  
  public int getImageShowLevel()
  {
    return this.imageShowLevel;
  }
  
  public int getPreDownload()
  {
    return this.preDownload;
  }
  
  public String getResourceMD5()
  {
    return this.resourceMD5;
  }
  
  public String getResourceURL()
  {
    return this.resourceURL;
  }
  
  public int getStylizeType()
  {
    return this.netStylizeType;
  }
  
  public String getThumbURL()
  {
    return this.thumbURL;
  }
  
  public int getUploadMaxSize()
  {
    return this.uploadMaxSize;
  }
  
  public int getVideoShowLevel()
  {
    return this.videoShowLevel;
  }
  
  public void setHideApplyAll(int paramInt)
  {
    this.hideApplyAll = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem
 * JD-Core Version:    0.7.0.1
 */