package com.tencent.autotemplate.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.tavmovie.base.TAVDecodeAndEncodeBase;
import com.tencent.tavmovie.sticker.TAVMovieSticker.TAVMovieStickerMode;
import java.io.File;

public class TAVBaseAutomaticEffect
  implements TAVDecodeAndEncodeBase
{
  public static final String EFFECT_TYPE_CUSTOM = "Custom";
  public static final String EFFECT_TYPE_LUT = "lut";
  public static final String EFFECT_TYPE_PAG = "pag";
  public static final String EFFECT_TYPE_PITU = "pitu";
  public static final String EFFECT_TYPE_TIME = "time";
  public static final String TYPE_FILTER = "filter";
  public static final String TYPE_GRADIENT_FACE = "GradientFace";
  public static final String TYPE_SPEED = "Speed";
  @SerializedName("duration")
  public long duration;
  @SerializedName("effectId")
  public String effectId;
  protected transient TAVBaseAutomaticEffect.TAVEffectType effectType;
  @SerializedName("effectType")
  public String effectTypeStr;
  public transient String fileDir;
  @SerializedName("parameter")
  public TAVEffectParameter parameter;
  
  public TAVBaseAutomaticEffect() {}
  
  public TAVBaseAutomaticEffect(@NonNull String paramString)
  {
    this.fileDir = paramString;
  }
  
  public TAVDecodeAndEncodeBase decodeFromJsonString(String paramString)
  {
    return (TAVDecodeAndEncodeBase)JsonUtils.parseObjectFromJsonString(paramString, getClass());
  }
  
  public String encodeToJsonString()
  {
    return JsonUtils.encodeObjectToJsonString(this);
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public TAVBaseAutomaticEffect.TAVEffectType getEffectType()
  {
    if ("pag".equalsIgnoreCase(this.effectTypeStr)) {
      return TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG;
    }
    if ("lut".equalsIgnoreCase(this.effectTypeStr)) {
      return TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT;
    }
    if ("pitu".equalsIgnoreCase(this.effectTypeStr)) {
      return TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePITU;
    }
    if ("time".equalsIgnoreCase(this.effectTypeStr)) {
      return TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime;
    }
    if ("Custom".equalsIgnoreCase(this.effectTypeStr)) {
      return TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeCustom;
    }
    return TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG;
  }
  
  public String getFileDir()
  {
    return this.fileDir;
  }
  
  public String getFilePath()
  {
    TAVEffectParameter localTAVEffectParameter = this.parameter;
    if (localTAVEffectParameter != null) {
      return localTAVEffectParameter.filePath;
    }
    return null;
  }
  
  protected String getFullPath()
  {
    if (!TextUtils.isEmpty(this.fileDir))
    {
      Object localObject = this.parameter;
      if ((localObject != null) && (!TextUtils.isEmpty(((TAVEffectParameter)localObject).filePath)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.fileDir);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(this.parameter.filePath);
        return ((StringBuilder)localObject).toString();
      }
    }
    return null;
  }
  
  public TAVMovieSticker.TAVMovieStickerMode getMode()
  {
    TAVEffectParameter localTAVEffectParameter = this.parameter;
    if ((localTAVEffectParameter != null) && ("filter".equalsIgnoreCase(localTAVEffectParameter.type))) {
      return TAVMovieSticker.TAVMovieStickerMode.TAVMovieStickerModeFilter;
    }
    return TAVMovieSticker.TAVMovieStickerMode.TAVMovieStickerModeOverlay;
  }
  
  public int getProcMethod()
  {
    TAVEffectParameter localTAVEffectParameter = this.parameter;
    if (localTAVEffectParameter != null) {
      return localTAVEffectParameter.procMethod;
    }
    return 0;
  }
  
  public float getSpeed()
  {
    TAVEffectParameter localTAVEffectParameter = this.parameter;
    if (localTAVEffectParameter != null) {
      return localTAVEffectParameter.speed;
    }
    return 1.0F;
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setFileDir(String paramString)
  {
    this.fileDir = paramString;
  }
  
  public void setFilePath(String paramString)
  {
    if (this.parameter == null) {
      this.parameter = new TAVEffectParameter();
    }
    this.parameter.filePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVBaseAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */