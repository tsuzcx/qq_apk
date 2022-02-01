package com.tencent.autotemplate.model;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.model.rhythm.TAVTimeAutomaticEffect;
import com.tencent.tav.decoder.logger.Logger;

public class TAVEffectAutomaticEffect
  extends TAVBaseAutomaticEffect
{
  public static final int RHYTHM_EFFECT_APPLY_AUTO_ONLY = 100;
  public static final int RHYTHM_EFFECT_APPLY_BOTH = 0;
  public static final int RHYTHM_EFFECT_APPLY_HIGHLIGHT_PAG = 2;
  public static final int RHYTHM_EFFECT_APPLY_HIGHLIGHT_START = 1;
  public static final String TAG = "TAVEffectAutomaticEffect";
  @SerializedName("endOffset")
  public long endOffset = -1L;
  @SerializedName("isClosingcredits")
  public int isClosingcredits = 0;
  @SerializedName("isOpeningCredits")
  public int isOpeningCredits = 0;
  @SerializedName("isRelative")
  public int isRelative = 0;
  @SerializedName("rhythmEffectType")
  public int rhythmEffectType = 0;
  @SerializedName("startOffset")
  public long startOffset = -1L;
  
  public TAVEffectAutomaticEffect() {}
  
  public TAVEffectAutomaticEffect(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public TAVEffectAutomaticEffect copy()
  {
    Object localObject;
    if (getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
      localObject = copyPAGEffectFrom();
    }
    do
    {
      return localObject;
      if (getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT) {
        return copyLUTEffectFrom();
      }
      localObject = this;
    } while (getEffectType() != TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime);
    return copyTimeEffectFrom();
  }
  
  public TAVLUTAutomaticEffect copyLUTEffectFrom()
  {
    TAVLUTAutomaticEffect localTAVLUTAutomaticEffect = new TAVLUTAutomaticEffect(this.fileDir);
    localTAVLUTAutomaticEffect.effectId = this.effectId;
    localTAVLUTAutomaticEffect.effectTypeStr = this.effectTypeStr;
    localTAVLUTAutomaticEffect.parameter = this.parameter;
    localTAVLUTAutomaticEffect.duration = this.duration;
    localTAVLUTAutomaticEffect.fileDir = this.fileDir;
    localTAVLUTAutomaticEffect.startOffset = this.startOffset;
    localTAVLUTAutomaticEffect.endOffset = this.endOffset;
    localTAVLUTAutomaticEffect.isClosingcredits = this.isClosingcredits;
    localTAVLUTAutomaticEffect.isOpeningCredits = this.isOpeningCredits;
    localTAVLUTAutomaticEffect.rhythmEffectType = this.rhythmEffectType;
    localTAVLUTAutomaticEffect.isRelative = this.isRelative;
    return localTAVLUTAutomaticEffect;
  }
  
  public TAVPagAutomaticEffect copyPAGEffectFrom()
  {
    TAVPagAutomaticEffect localTAVPagAutomaticEffect = new TAVPagAutomaticEffect(this.fileDir);
    localTAVPagAutomaticEffect.effectId = this.effectId;
    localTAVPagAutomaticEffect.effectTypeStr = this.effectTypeStr;
    localTAVPagAutomaticEffect.parameter = this.parameter;
    localTAVPagAutomaticEffect.duration = this.duration;
    localTAVPagAutomaticEffect.fileDir = this.fileDir;
    localTAVPagAutomaticEffect.startOffset = this.startOffset;
    localTAVPagAutomaticEffect.endOffset = this.endOffset;
    localTAVPagAutomaticEffect.isClosingcredits = this.isClosingcredits;
    localTAVPagAutomaticEffect.isOpeningCredits = this.isOpeningCredits;
    localTAVPagAutomaticEffect.rhythmEffectType = this.rhythmEffectType;
    localTAVPagAutomaticEffect.isRelative = this.isRelative;
    return localTAVPagAutomaticEffect;
  }
  
  public TAVTimeAutomaticEffect copyTimeEffectFrom()
  {
    TAVTimeAutomaticEffect localTAVTimeAutomaticEffect = new TAVTimeAutomaticEffect(this.fileDir);
    localTAVTimeAutomaticEffect.effectId = this.effectId;
    localTAVTimeAutomaticEffect.effectTypeStr = this.effectTypeStr;
    localTAVTimeAutomaticEffect.parameter = this.parameter;
    localTAVTimeAutomaticEffect.duration = this.duration;
    localTAVTimeAutomaticEffect.fileDir = this.fileDir;
    localTAVTimeAutomaticEffect.startOffset = this.startOffset;
    localTAVTimeAutomaticEffect.endOffset = this.endOffset;
    localTAVTimeAutomaticEffect.isClosingcredits = this.isClosingcredits;
    localTAVTimeAutomaticEffect.isOpeningCredits = this.isOpeningCredits;
    localTAVTimeAutomaticEffect.rhythmEffectType = this.rhythmEffectType;
    localTAVTimeAutomaticEffect.isRelative = this.isRelative;
    return localTAVTimeAutomaticEffect;
  }
  
  public long getEndOffset()
  {
    return this.endOffset;
  }
  
  public int getRhythmEffectType()
  {
    return this.rhythmEffectType;
  }
  
  public long getStartOffset()
  {
    return this.startOffset;
  }
  
  protected boolean isAvailable()
  {
    if ((this.startOffset == -1L) && (this.endOffset == -1L))
    {
      Logger.e("TAVEffectAutomaticEffect", "this effect's startOffset == -1 and endOffset == -1, is wrong.");
      return false;
    }
    return true;
  }
  
  public boolean isClosingcredits()
  {
    return this.isClosingcredits == 1;
  }
  
  public boolean isOpeningCredits()
  {
    return this.isOpeningCredits == 1;
  }
  
  public int isRelative()
  {
    return this.isRelative;
  }
  
  public void setClosingcredits(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.isClosingcredits = i;
      return;
    }
  }
  
  public void setEndOffset(long paramLong)
  {
    this.endOffset = paramLong;
  }
  
  public void setIsRelative(int paramInt)
  {
    this.isRelative = paramInt;
  }
  
  public void setOpeningCredits(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.isOpeningCredits = i;
      return;
    }
  }
  
  public void setRhythmEffectType(int paramInt)
  {
    this.rhythmEffectType = paramInt;
  }
  
  public void setStartOffset(long paramLong)
  {
    this.startOffset = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVEffectAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */