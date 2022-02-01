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
    if ((paramEffectFrame.frameData != null) && (paramEffectFrame.frameData.length != 0))
    {
      if ((this.mCurrentBeautyLevel == 0.0F) && (this.mCurrentWhiteLevel == 0.0F) && (!this.mCurrentClearFlag))
      {
        Log.d("Beauty25Render", "processData mCurrentBeautyLevel = 0 | mCurrentWhiteLevel = 0 | mCurrentClearFlag = false");
        return paramEffectFrame;
      }
      int i = (int)(this.mCurrentBeautyLevel * 100.0F + 9.0F) / 10;
      int j = (int)(this.mCurrentWhiteLevel * 100.0F + 9.0F) / 10;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processData mCurrentBeautyLevel = ");
      ((StringBuilder)localObject).append(this.mCurrentBeautyLevel);
      ((StringBuilder)localObject).append(" | nativeBeautyLevel = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" | mCurrentWhiteLevel = ");
      ((StringBuilder)localObject).append(this.mCurrentWhiteLevel);
      ((StringBuilder)localObject).append(" | nativeWhiteLevel = ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" | mCurrentClearFlag = ");
      ((StringBuilder)localObject).append(this.mCurrentClearFlag);
      ((StringBuilder)localObject).append(" | dataLength = ");
      ((StringBuilder)localObject).append(paramEffectFrame.frameData.length);
      ((StringBuilder)localObject).append(" | width=");
      ((StringBuilder)localObject).append(paramEffectFrame.frameWidth);
      ((StringBuilder)localObject).append(" | height = ");
      ((StringBuilder)localObject).append(paramEffectFrame.frameHeight);
      ((StringBuilder)localObject).append(" | format =");
      ((StringBuilder)localObject).append(paramEffectFrame.frameFormat);
      Log.d("Beauty25Render", ((StringBuilder)localObject).toString());
      try
      {
        localObject = new EffectFrame();
        ((EffectFrame)localObject).frameData = BeautyNative.beautyProcess25(paramEffectFrame.frameData, paramEffectFrame.frameFormat.ordinal(), paramEffectFrame.frameWidth, paramEffectFrame.frameHeight, i, j, this.mCurrentClearFlag);
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
        Log.d("Beauty25Render", localStringBuilder.toString());
        return paramEffectFrame;
      }
    }
    Log.d("Beauty25Render", "processData frameData = null");
    return paramEffectFrame;
  }
  
  public void setBeautyLevel(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBeautyLevel beautyLevel = ");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" | whiteLevel = ");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append(" | clearFlag = ");
    localStringBuilder.append(paramBoolean);
    Log.d("Beauty25Render", localStringBuilder.toString());
    if (paramFloat1 > 1.0F) {
      this.mCurrentBeautyLevel = 1.0F;
    } else if (paramFloat1 < 0.0F) {
      this.mCurrentBeautyLevel = 0.0F;
    } else {
      this.mCurrentBeautyLevel = paramFloat1;
    }
    if (paramFloat2 > 1.0F) {
      this.mCurrentWhiteLevel = 1.0F;
    } else if (paramFloat2 < 0.0F) {
      this.mCurrentWhiteLevel = 0.0F;
    } else {
      this.mCurrentWhiteLevel = paramFloat2;
    }
    this.mCurrentClearFlag = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.beauty.Beauty25Render
 * JD-Core Version:    0.7.0.1
 */