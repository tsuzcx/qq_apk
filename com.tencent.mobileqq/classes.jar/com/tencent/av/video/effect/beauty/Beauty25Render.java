package com.tencent.av.video.effect.beauty;

import android.content.Context;
import com.tencent.av.video.effect.core.BeautyNative;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

public class Beauty25Render
{
  private static final String TAG = "Beauty25Render";
  private WeakReference<Context> mContextReference;
  private float mCurrentBeautyLevel = 0.0F;
  private boolean mCurrentClearFlag = false;
  private float mCurrentWhiteLevel = 0.0F;
  
  public Beauty25Render(Context paramContext)
  {
    this.mContextReference = new WeakReference(paramContext);
  }
  
  public void destroy() {}
  
  public EffectFrame processData(EffectFrame paramEffectFrame)
  {
    if (paramEffectFrame == null)
    {
      Log.d("Beauty25Render", "processData inFrame = null");
      return paramEffectFrame;
    }
    if ((paramEffectFrame.frameData == null) || (paramEffectFrame.frameData.length == 0))
    {
      Log.d("Beauty25Render", "processData frameData = null");
      return paramEffectFrame;
    }
    if ((this.mCurrentBeautyLevel == 0.0F) && (this.mCurrentWhiteLevel == 0.0F) && (!this.mCurrentClearFlag))
    {
      Log.d("Beauty25Render", "processData mCurrentBeautyLevel = 0 | mCurrentWhiteLevel = 0 | mCurrentClearFlag = false");
      return paramEffectFrame;
    }
    int i = (int)(this.mCurrentBeautyLevel * 100.0F + 9.0F) / 10;
    int j = (int)(this.mCurrentWhiteLevel * 100.0F + 9.0F) / 10;
    Log.d("Beauty25Render", "processData mCurrentBeautyLevel = " + this.mCurrentBeautyLevel + " | nativeBeautyLevel = " + i + " | mCurrentWhiteLevel = " + this.mCurrentWhiteLevel + " | nativeWhiteLevel = " + j + " | mCurrentClearFlag = " + this.mCurrentClearFlag + " | dataLength = " + paramEffectFrame.frameData.length + " | width=" + paramEffectFrame.frameWidth + " | height = " + paramEffectFrame.frameHeight + " | format =" + paramEffectFrame.frameFormat);
    try
    {
      EffectFrame localEffectFrame = new EffectFrame();
      localEffectFrame.frameData = BeautyNative.beautyProcess25(paramEffectFrame.frameData, paramEffectFrame.frameFormat.ordinal(), paramEffectFrame.frameWidth, paramEffectFrame.frameHeight, i, j, this.mCurrentClearFlag);
      localEffectFrame.frameWidth = paramEffectFrame.frameWidth;
      localEffectFrame.frameHeight = paramEffectFrame.frameHeight;
      localEffectFrame.frameFormat = ColorFormat.I420;
      return localEffectFrame;
    }
    catch (Throwable localThrowable)
    {
      Log.d("Beauty25Render", "processData e = " + localThrowable.getMessage());
    }
    return paramEffectFrame;
  }
  
  public void setBeautyLevel(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    Log.d("Beauty25Render", "setBeautyLevel beautyLevel = " + paramFloat1 + " | whiteLevel = " + paramFloat2 + " | clearFlag = " + paramBoolean);
    if (paramFloat1 > 1.0F)
    {
      this.mCurrentBeautyLevel = 1.0F;
      if (paramFloat2 <= 1.0F) {
        break label92;
      }
      this.mCurrentWhiteLevel = 1.0F;
    }
    for (;;)
    {
      this.mCurrentClearFlag = paramBoolean;
      return;
      if (paramFloat1 < 0.0F)
      {
        this.mCurrentBeautyLevel = 0.0F;
        break;
      }
      this.mCurrentBeautyLevel = paramFloat1;
      break;
      label92:
      if (paramFloat2 < 0.0F) {
        this.mCurrentWhiteLevel = 0.0F;
      } else {
        this.mCurrentWhiteLevel = paramFloat2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.beauty.Beauty25Render
 * JD-Core Version:    0.7.0.1
 */