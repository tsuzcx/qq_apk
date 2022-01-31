package com.tencent.mobileqq.addon;

import java.io.Serializable;

public class DiyPendantSticker
  implements Serializable
{
  public int angle;
  public String fontColor;
  public int fontId;
  public int fontType;
  public int stickerId;
  public String text;
  public int type;
  
  public DiyPendantSticker(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, String paramString2)
  {
    this.type = paramInt1;
    this.stickerId = paramInt2;
    this.angle = paramInt3;
    this.text = paramString1;
    this.fontId = paramInt4;
    this.fontType = paramInt5;
    this.fontColor = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantSticker
 * JD-Core Version:    0.7.0.1
 */