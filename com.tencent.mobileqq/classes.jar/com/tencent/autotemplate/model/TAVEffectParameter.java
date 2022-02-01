package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;

public class TAVEffectParameter
{
  @SerializedName("content")
  public String content;
  @SerializedName("duration")
  public long duration;
  @SerializedName("filePath")
  public String filePath;
  @SerializedName("fontId")
  public String fontId;
  @SerializedName("fontName")
  public String fontName;
  @SerializedName("position")
  public StickerPosition position = new StickerPosition();
  @SerializedName("procMethod")
  public int procMethod;
  @SerializedName("rhythmOffset")
  public long rhythmOffset = 0L;
  @SerializedName("rhythmPosition")
  public long rhythmPosition = 0L;
  @SerializedName("rotation")
  public float rotation = 0.0F;
  @SerializedName("scale")
  public float scale = 1.0F;
  @SerializedName("speed")
  public float speed;
  @SerializedName("textType")
  public String textType;
  @SerializedName("type")
  public String type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVEffectParameter
 * JD-Core Version:    0.7.0.1
 */