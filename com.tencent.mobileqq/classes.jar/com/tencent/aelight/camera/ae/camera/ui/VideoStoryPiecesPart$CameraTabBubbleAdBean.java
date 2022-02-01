package com.tencent.aelight.camera.ae.camera.ui;

import java.io.Serializable;

public class VideoStoryPiecesPart$CameraTabBubbleAdBean
  implements Serializable
{
  private String content;
  private String opID;
  private String tab;
  private String verFrom;
  private String verTo;
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getOpID()
  {
    return this.opID;
  }
  
  public String getTab()
  {
    return this.tab;
  }
  
  public String getVerFrom()
  {
    return this.verFrom;
  }
  
  public String getVerTo()
  {
    return this.verTo;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setOpID(String paramString)
  {
    this.opID = paramString;
  }
  
  public void setTab(String paramString)
  {
    this.tab = paramString;
  }
  
  public void setVerFrom(String paramString)
  {
    this.verFrom = paramString;
  }
  
  public void setVerTo(String paramString)
  {
    this.verTo = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraTabBubbleAdBean{opID='");
    localStringBuilder.append(this.opID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tab='");
    localStringBuilder.append(this.tab);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.content);
    localStringBuilder.append('\'');
    localStringBuilder.append(", verFrom='");
    localStringBuilder.append(this.verFrom);
    localStringBuilder.append('\'');
    localStringBuilder.append(", verTo='");
    localStringBuilder.append(this.verTo);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.CameraTabBubbleAdBean
 * JD-Core Version:    0.7.0.1
 */