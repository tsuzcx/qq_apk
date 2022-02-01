package com.tencent.autotemplate.model.rhythm;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.effects.CanyingEffect;
import com.tencent.taveffect.effects.ChongdieEffect;
import com.tencent.taveffect.effects.GanraoEffect;
import com.tencent.taveffect.effects.HuanjueEffect;
import com.tencent.taveffect.effects.LookupFilter;
import com.tencent.taveffect.effects.LvdongEffect;
import com.tencent.taveffect.effects.RGBEffect;
import com.tencent.taveffect.effects.ShanbaiEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavmovie.filter.TAVMovieFilterProxy;

public class TAVMovieFilterProxyWithTimeRange
  extends TAVMovieFilterProxy
{
  private static final String TAG = "TAVMovieFilterProxyWithTimeRange";
  private Bitmap bitmap;
  private int effectID;
  private CMTimeRange timeRange;
  
  public TAVMovieFilterProxyWithTimeRange(int paramInt)
  {
    super(paramInt);
    this.effectID = paramInt;
  }
  
  public TAVMovieFilterProxyWithTimeRange(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
    this.effectID = paramInt;
    this.bitmap = paramBitmap;
  }
  
  @NonNull
  private BaseEffect createEffect()
  {
    switch (this.effectID)
    {
    default: 
      return new RGBEffect();
    case 0: 
      if (this.bitmap == null) {
        return null;
      }
      return new LookupFilter(this.bitmap);
    case 1: 
      return new RGBEffect();
    case 2: 
      return new CanyingEffect();
    case 3: 
      return new ChongdieEffect();
    case 4: 
      return new GanraoEffect();
    case 5: 
      return new HuanjueEffect();
    case 6: 
      return new LvdongEffect();
    }
    return new ShanbaiEffect();
  }
  
  @NonNull
  private TextureInfo getOutputTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramTAVTextureInfo.width, paramTAVTextureInfo.height, null, 0);
  }
  
  @NonNull
  private TAVTextureInfo getTavTextureInfo(TextureInfo paramTextureInfo)
  {
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, 0);
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new TAVMovieFilterProxyWithTimeRange.TAVMovieFilterEffect(this);
  }
  
  public void release()
  {
    if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
    {
      this.bitmap.recycle();
      this.bitmap = null;
    }
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.rhythm.TAVMovieFilterProxyWithTimeRange
 * JD-Core Version:    0.7.0.1
 */