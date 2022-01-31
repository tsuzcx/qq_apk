package com.tencent.av.video.effect.beauty;

import android.content.Context;
import com.tencent.av.video.effect.core.BeautyNative;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

public class Beauty20Render
{
  private static final String TAG = "Beauty20Render";
  private WeakReference<Context> mContextReference;
  private float mCurrentBeautyLevel = 0.0F;
  
  public Beauty20Render(Context paramContext)
  {
    this.mContextReference = new WeakReference(paramContext);
  }
  
  public void destroy() {}
  
  public EffectFrame processData(EffectFrame paramEffectFrame)
  {
    if (paramEffectFrame == null)
    {
      Log.d("Beauty20Render", "processData inFrame = null");
      return paramEffectFrame;
    }
    if ((paramEffectFrame.frameData == null) || (paramEffectFrame.frameData.length == 0))
    {
      Log.d("Beauty20Render", "processData frameData = null");
      return paramEffectFrame;
    }
    if (this.mCurrentBeautyLevel == 0.0F)
    {
      Log.d("Beauty20Render", "processData mCurrentBeautyLevel = 0");
      return paramEffectFrame;
    }
    int i = (int)(this.mCurrentBeautyLevel * 100.0F + 9.0F) / 10;
    Log.d("Beauty20Render", "processData mCurrentBeautyLevel = " + this.mCurrentBeautyLevel + " | nativeBeautyLevel = " + i + " | dataLength = " + paramEffectFrame.frameData.length + " | width=" + paramEffectFrame.frameWidth + " | height = " + paramEffectFrame.frameHeight + " | format =" + paramEffectFrame.frameFormat);
    try
    {
      EffectFrame localEffectFrame = new EffectFrame();
      localEffectFrame.frameData = BeautyNative.beautyProcess20(paramEffectFrame.frameData, paramEffectFrame.frameFormat.ordinal(), paramEffectFrame.frameWidth, paramEffectFrame.frameHeight, i);
      localEffectFrame.frameWidth = paramEffectFrame.frameWidth;
      localEffectFrame.frameHeight = paramEffectFrame.frameHeight;
      localEffectFrame.frameFormat = ColorFormat.I420;
      return localEffectFrame;
    }
    catch (Throwable localThrowable)
    {
      Log.d("Beauty20Render", "processData e = " + localThrowable.getMessage());
    }
    return paramEffectFrame;
  }
  
  public void setBeautyLevel(float paramFloat)
  {
    Log.d("Beauty20Render", "setBeautyLevel beautyLevel = " + paramFloat);
    if (paramFloat > 1.0F)
    {
      this.mCurrentBeautyLevel = 1.0F;
      return;
    }
    if (paramFloat < 0.0F)
    {
      this.mCurrentBeautyLevel = 0.0F;
      return;
    }
    this.mCurrentBeautyLevel = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.beauty.Beauty20Render
 * JD-Core Version:    0.7.0.1
 */