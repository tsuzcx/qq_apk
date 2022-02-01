import android.content.res.Resources;
import android.util.TypedValue;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public final class bmbw
{
  private static int jdField_a_of_type_Int = -1;
  private static akur jdField_a_of_type_Akur = new akur(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight());
  
  public static int a()
  {
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int;
    }
    int k = ViewUtils.getScreenWidth();
    int j = ViewUtils.getScreenHeight();
    boolean bool = LiuHaiUtils.jdField_a_of_type_Boolean;
    int m = LiuHaiUtils.jdField_a_of_type_Int;
    int i = j;
    if (bool) {
      i = j + m;
    }
    j = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
    int n = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296276);
    int i2 = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296270);
    int i3 = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296271);
    int i4 = (int)(1.1735F * AIOUtils.dp2px(98.0F, BaseApplication.getContext().getResources()));
    int i5 = (int)(BaseApplication.getContext().getResources().getDimensionPixelSize(2131296269) + TypedValue.applyDimension(2, 14.0F, BaseApplication.getContext().getResources().getDisplayMetrics()));
    int i1 = (int)(1.333333F * k);
    i2 = i - (i2 + i3) - i4 - i5;
    if (i2 - j - n >= i1) {
      jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      bmbx.b("AEPreviewSizeUtil", "[getScreenTypeForCircle]---screen size=" + k + "X" + i + ", sScreenTypeForCircle=" + jdField_a_of_type_Int + ", statusBarHeight=" + j + ", hasNotch=" + bool + ", notchHeight=" + m);
      return jdField_a_of_type_Int;
      if (i2 >= i1) {
        jdField_a_of_type_Int = 2;
      } else {
        jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public static akur a()
  {
    return jdField_a_of_type_Akur;
  }
  
  public static akur a(AECaptureMode paramAECaptureMode, akur paramakur, AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    return a(paramAECaptureMode, paramakur, true, paramRatio);
  }
  
  public static akur a(AECaptureMode paramAECaptureMode, akur paramakur, boolean paramBoolean, AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    akur localakur;
    if (paramAECaptureMode == AECaptureMode.NORMAL)
    {
      localakur = paramakur;
      if (paramBoolean)
      {
        if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
          break label50;
        }
        i = Math.min(paramakur.jdField_a_of_type_Int, paramakur.b);
        localakur = new akur(i, i);
      }
    }
    label50:
    do
    {
      do
      {
        do
        {
          return localakur;
          localakur = paramakur;
        } while (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL);
        localakur = paramakur;
      } while (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_4_3);
      return new akur(paramakur.jdField_a_of_type_Int, (int)(1.333333F * paramakur.jdField_a_of_type_Int));
      localakur = paramakur;
    } while (paramAECaptureMode != AECaptureMode.GIF);
    int j = Math.min(paramakur.jdField_a_of_type_Int, paramakur.b);
    int k = DisplayUtil.dip2px(BaseApplicationImpl.getContext(), 250.0F);
    int i = j;
    if (k > 0) {
      i = Math.min(j, k);
    }
    return new akur(i, i);
  }
  
  public static void a(akur paramakur)
  {
    jdField_a_of_type_Akur = paramakur;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbw
 * JD-Core Version:    0.7.0.1
 */