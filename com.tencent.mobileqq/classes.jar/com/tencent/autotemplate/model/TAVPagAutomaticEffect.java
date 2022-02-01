package com.tencent.autotemplate.model;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.sticker.TAVMovieSticker.TAVMovieStickerMode;
import com.tencent.tavsticker.model.TAVSticker;

public class TAVPagAutomaticEffect
  extends TAVEffectAutomaticEffect
{
  public static final String KEY_EXTRA_MATERIAL_ID = "key_extra_material_id";
  private transient TAVMovieSticker.TAVMovieStickerMode mode;
  private transient PointF position = new PointF(0.5F, 0.5F);
  private transient float rotation = 0.0F;
  private transient float scale = 1.0F;
  
  public TAVPagAutomaticEffect(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public TAVMovieSticker convertToMovieStickerWithDuraton(float paramFloat)
  {
    if (!isAvailable()) {
      return null;
    }
    TAVMovieSticker localTAVMovieSticker = new TAVMovieSticker(getFullPath());
    if ((localTAVMovieSticker == null) || (localTAVMovieSticker.getSticker() == null)) {
      return null;
    }
    label194:
    float f2;
    if (this.parameter != null)
    {
      localTAVMovieSticker.setRotation(this.parameter.rotation);
      localTAVMovieSticker.setScale(this.parameter.scale);
      if (this.parameter.position != null) {
        localTAVMovieSticker.setPosition(new PointF(this.parameter.position.centerX, this.parameter.position.centerY));
      }
      localTAVMovieSticker.getSticker().updateTextData();
      if (this.effectId != null) {
        localTAVMovieSticker.getSticker().getExtraBundle().putString("key_extra_material_id", this.effectId);
      }
      localTAVMovieSticker.setStickerMode(getMode());
      if ((this.startOffset <= -1L) || (this.endOffset != -1L)) {
        break label275;
      }
      f1 = (float)this.startOffset;
      if (this.duration <= 0L) {
        break label259;
      }
      paramFloat = (float)this.duration;
      f2 = f1;
      if (this.parameter != null)
      {
        if (this.parameter.rhythmPosition != 1L) {
          break label368;
        }
        f2 = f1 - paramFloat / 2.0F;
      }
    }
    for (;;)
    {
      if (paramFloat > 0.0F) {
        break label391;
      }
      return null;
      localTAVMovieSticker.setRotation(this.rotation);
      localTAVMovieSticker.setScale(this.scale);
      localTAVMovieSticker.setPosition(this.position);
      break;
      label259:
      paramFloat = (float)localTAVMovieSticker.getSticker().durationTime() / 1000.0F;
      break label194;
      label275:
      if ((this.startOffset == -1L) && (this.endOffset > -1L))
      {
        if (this.duration > 0L) {}
        for (f1 = (float)this.duration;; f1 = (float)localTAVMovieSticker.getSticker().durationTime() / 1000.0F)
        {
          f2 = paramFloat - f1 - (float)this.endOffset;
          paramFloat = f1;
          f1 = f2;
          break;
        }
      }
      paramFloat = paramFloat - (float)this.startOffset - (float)this.endOffset;
      f1 = (float)this.startOffset;
      break label194;
      label368:
      f2 = f1;
      if (this.parameter.rhythmPosition == 2L) {
        f2 = f1 - paramFloat;
      }
    }
    label391:
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = 0.0F;
    }
    localTAVMovieSticker.setTimeRange(new CMTimeRange(new CMTime(f1 / 1000.0F), new CMTime(paramFloat / 1000.0F)));
    return localTAVMovieSticker;
  }
  
  public PointF getPosition()
  {
    return this.position;
  }
  
  public float getRotation()
  {
    return this.rotation;
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public CMTime getStickerDuration()
  {
    TAVMovieSticker localTAVMovieSticker = new TAVMovieSticker(getFullPath());
    if ((localTAVMovieSticker == null) || (localTAVMovieSticker.getSticker() == null)) {
      return new CMTime(0L, 1000000);
    }
    return new CMTime(localTAVMovieSticker.getSticker().durationTime(), 1000000);
  }
  
  public void setPosition(PointF paramPointF)
  {
    this.position = paramPointF;
  }
  
  public void setRotation(float paramFloat)
  {
    this.rotation = paramFloat;
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVPagAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */