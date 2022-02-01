package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DoodleMagicAlgoHandler
{
  public static final String TAG = "Doodle_Strokes_MagicAlgoHandler";
  public static final int TOUCH_DOWN = 0;
  public static final int TOUCH_MOVE = 1;
  public static final int TOUCH_UP = 2;
  private static WeakReference<VideoFilterBase> mFilter;
  
  public static void OnUpdateSize(int paramInt1, int paramInt2, float paramFloat)
  {
    try
    {
      updateSize(paramInt1, paramInt2, paramFloat);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public static void onTouchEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((paramInt == 0) || ((paramInt == 1) || (paramInt == 2))) {}
    try
    {
      touchEnd(paramFloat1, paramFloat2);
      break label38;
      touchMove(paramFloat1, paramFloat2);
      break label38;
      touchBegin(paramFloat1, paramFloat2);
      label38:
      long l1 = System.currentTimeMillis();
      processTouch();
      long l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchEvent|processTouch time= ");
      localStringBuilder.append(l2 - l1);
      QLog.d("Doodle_Strokes_MagicAlgoHandler", 2, localStringBuilder.toString());
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}catch (Exception localException)
    {
      break label111;
    }
    localException.printStackTrace();
    return;
    label111:
    localException.printStackTrace();
  }
  
  public static native void processTouch();
  
  public static void renderToTemp(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("size= ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Doodle_Strokes_MagicAlgoHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = mFilter;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (VideoFilterBase)mFilter.get();
      if (localObject != null)
      {
        DoodleMagicAlgoHandler.RenderPoint localRenderPoint = new DoodleMagicAlgoHandler.RenderPoint();
        localRenderPoint.xList = paramArrayOfFloat1;
        localRenderPoint.yList = paramArrayOfFloat2;
        localRenderPoint.aList = paramArrayOfFloat3;
        if ((localObject instanceof PersonalityFireworksFilter)) {
          ((PersonalityFireworksFilter)localObject).a(localRenderPoint);
        }
      }
    }
  }
  
  public static void setFilter(VideoFilterBase paramVideoFilterBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Doodle_Strokes_MagicAlgoHandler", 2, "setFilter");
    }
    mFilter = new WeakReference(paramVideoFilterBase);
  }
  
  public static native void touchBegin(float paramFloat1, float paramFloat2);
  
  public static native void touchEnd(float paramFloat1, float paramFloat2);
  
  public static native void touchMove(float paramFloat1, float paramFloat2);
  
  public static native void updateSize(int paramInt1, int paramInt2, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleMagicAlgoHandler
 * JD-Core Version:    0.7.0.1
 */