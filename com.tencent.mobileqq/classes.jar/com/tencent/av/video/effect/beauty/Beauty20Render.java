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
    if ((paramEffectFrame.frameData != null) && (paramEffectFrame.frameData.length != 0))
    {
      float f = this.mCurrentBeautyLevel;
      if (f == 0.0F)
      {
        Log.d("Beauty20Render", "processData mCurrentBeautyLevel = 0");
        return paramEffectFrame;
      }
      int i = (int)(f * 100.0F + 9.0F) / 10;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processData mCurrentBeautyLevel = ");
      ((StringBuilder)localObject).append(this.mCurrentBeautyLevel);
      ((StringBuilder)localObject).append(" | nativeBeautyLevel = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" | dataLength = ");
      ((StringBuilder)localObject).append(paramEffectFrame.frameData.length);
      ((StringBuilder)localObject).append(" | width=");
      ((StringBuilder)localObject).append(paramEffectFrame.frameWidth);
      ((StringBuilder)localObject).append(" | height = ");
      ((StringBuilder)localObject).append(paramEffectFrame.frameHeight);
      ((StringBuilder)localObject).append(" | format =");
      ((StringBuilder)localObject).append(paramEffectFrame.frameFormat);
      Log.d("Beauty20Render", ((StringBuilder)localObject).toString());
      try
      {
        localObject = new EffectFrame();
        ((EffectFrame)localObject).frameData = BeautyNative.beautyProcess20(paramEffectFrame.frameData, paramEffectFrame.frameFormat.ordinal(), paramEffectFrame.frameWidth, paramEffectFrame.frameHeight, i);
        ((EffectFrame)localObject).frameWidth = paramEffectFrame.frameWidth;
        ((EffectFrame)localObject).frameHeight = paramEffectFrame.frameHeight;
        ((EffectFrame)localObject).frameFormat = ColorFormat.I420;
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processData e = ");
        localStringBuilder.append(localThrowable.getMessage());
        Log.d("Beauty20Render", localStringBuilder.toString());
        return paramEffectFrame;
      }
    }
    Log.d("Beauty20Render", "processData frameData = null");
    return paramEffectFrame;
  }
  
  public void setBeautyLevel(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBeautyLevel beautyLevel = ");
    localStringBuilder.append(paramFloat);
    Log.d("Beauty20Render", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.beauty.Beauty20Render
 * JD-Core Version:    0.7.0.1
 */