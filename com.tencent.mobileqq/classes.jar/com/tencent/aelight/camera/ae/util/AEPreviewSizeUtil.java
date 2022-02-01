package com.tencent.aelight.camera.ae.util;

import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class AEPreviewSizeUtil
{
  private static int a = -1;
  private static Size b = new Size(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight());
  
  public static Size a()
  {
    return b;
  }
  
  public static Size a(AECaptureMode paramAECaptureMode, Size paramSize, AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    return a(paramAECaptureMode, paramSize, true, paramRatio);
  }
  
  public static Size a(AECaptureMode paramAECaptureMode, Size paramSize, boolean paramBoolean, AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPreviewSize");
    localStringBuilder.append(paramAECaptureMode);
    localStringBuilder.append(" currentRatio");
    localStringBuilder.append(paramRatio);
    Log.d("adjustRatio ", localStringBuilder.toString());
    int i;
    if (paramAECaptureMode == AECaptureMode.NORMAL)
    {
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1)
      {
        i = Math.min(paramSize.a, paramSize.b);
        return new Size(i, i);
      }
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
        return paramSize;
      }
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
        return new Size(paramSize.a, (int)(paramSize.a * 1.333333F));
      }
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_16_9)
      {
        paramAECaptureMode = new StringBuilder();
        paramAECaptureMode.append(" R_16_9");
        paramAECaptureMode.append(paramSize.a * 1.777778F);
        Log.d("adjustRatio", paramAECaptureMode.toString());
        return new Size(paramSize.a, (int)(paramSize.a * 1.777778F));
      }
      return paramSize;
    }
    paramRatio = paramSize;
    if (paramAECaptureMode == AECaptureMode.GIF)
    {
      int j = Math.min(paramSize.a, paramSize.b);
      int k = DisplayUtil.a(BaseApplicationImpl.getContext(), 250.0F);
      i = j;
      if (k > 0) {
        i = Math.min(j, k);
      }
      paramRatio = new Size(i, i);
    }
    return paramRatio;
  }
  
  public static void a(Size paramSize)
  {
    b = paramSize;
  }
  
  public static int b()
  {
    int i = a;
    if (i != -1) {
      return i;
    }
    int k = ViewUtils.getScreenWidth();
    int j = ViewUtils.getScreenHeight();
    boolean bool = LiuHaiUtils.b;
    int m = LiuHaiUtils.d;
    i = j;
    if (bool) {
      i = j + m;
    }
    j = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
    int n = BaseApplication.getContext().getResources().getDimensionPixelSize(2063859721);
    int i2 = BaseApplication.getContext().getResources().getDimensionPixelSize(2063859714);
    int i3 = BaseApplication.getContext().getResources().getDimensionPixelSize(2063859715);
    int i4 = (int)(AIOUtils.b(98.0F, BaseApplication.getContext().getResources()) * 1.1735F);
    int i5 = (int)(BaseApplication.getContext().getResources().getDimensionPixelSize(2063859713) + TypedValue.applyDimension(2, 18.0F, BaseApplication.getContext().getResources().getDisplayMetrics()));
    int i1 = (int)(k * 1.333333F);
    i2 = i - (i2 + i3) - i4 - i5;
    if (i2 - j - n >= i1) {
      a = 1;
    } else if (i2 >= i1) {
      a = 2;
    } else {
      a = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getScreenTypeForCircle]---screen size=");
    localStringBuilder.append(k);
    localStringBuilder.append("X");
    localStringBuilder.append(i);
    localStringBuilder.append(", sScreenTypeForCircle=");
    localStringBuilder.append(a);
    localStringBuilder.append(", statusBarHeight=");
    localStringBuilder.append(j);
    localStringBuilder.append(", hasNotch=");
    localStringBuilder.append(bool);
    localStringBuilder.append(", notchHeight=");
    localStringBuilder.append(m);
    AEQLog.b("AEPreviewSizeUtil", localStringBuilder.toString());
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil
 * JD-Core Version:    0.7.0.1
 */