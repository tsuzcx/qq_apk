package com.tencent.autotemplate.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.autotemplate.model.rhythm.TAVMovieFilterProxyWithTimeRange;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavmovie.filter.TAVMovieFilterProxy;

public class TAVLUTAutomaticEffect
  extends TAVEffectAutomaticEffect
{
  public static final String TAG = "TAVLUTAutomaticEffect";
  
  public TAVLUTAutomaticEffect(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public TAVMovieFilterProxy convertToMovieFilter()
  {
    if (!isAvailable()) {
      return null;
    }
    Object localObject = getFullPath();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = BitmapFactory.decodeFile((String)localObject);
      if (localObject != null) {
        return new TAVMovieFilterProxy(0, (Bitmap)localObject);
      }
      Logger.e("TAVLUTAutomaticEffect", "this lut effect's bitmap is null.");
      return null;
    }
    Logger.e("TAVLUTAutomaticEffect", "this lut effect's filterPath is null.");
    return null;
  }
  
  public TAVMovieFilterProxyWithTimeRange covertToMovieFilterWithDuraton(float paramFloat)
  {
    if (!isAvailable()) {
      return null;
    }
    CMTimeRange localCMTimeRange = getLutTimeRange(paramFloat);
    Object localObject = getFullPath();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = BitmapFactory.decodeFile((String)localObject);
      if (localObject != null)
      {
        localObject = new TAVMovieFilterProxyWithTimeRange(0, (Bitmap)localObject);
        ((TAVMovieFilterProxyWithTimeRange)localObject).setTimeRange(localCMTimeRange);
        return localObject;
      }
      Logger.e("TAVLUTAutomaticEffect", "this lut effect's bitmap is null.");
      return null;
    }
    Logger.e("TAVLUTAutomaticEffect", "this lut effect's filterPath is null.");
    return null;
  }
  
  public CMTimeRange getLutTimeRange(float paramFloat)
  {
    long l2 = this.startOffset;
    long l1 = 0L;
    if ((l2 > -1L) && (this.endOffset == -1L))
    {
      l2 = this.startOffset;
      if (this.duration > 0L) {
        l1 = this.duration;
      } else {
        l1 = (paramFloat - (float)this.startOffset);
      }
    }
    else
    {
      if ((this.startOffset == -1L) && (this.endOffset > -1L))
      {
        if (this.duration > 0L)
        {
          l2 = (paramFloat - (float)this.endOffset - (float)this.duration);
          l1 = this.duration;
          break label160;
        }
        l2 = this.endOffset;
      }
      else
      {
        l1 = this.startOffset;
        paramFloat -= (float)this.startOffset;
        l2 = this.endOffset;
      }
      long l3 = (paramFloat - (float)l2);
      l2 = l1;
      l1 = l3;
    }
    label160:
    return new CMTimeRange(new CMTime(l2, 1000), new CMTime(l1, 1000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVLUTAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */