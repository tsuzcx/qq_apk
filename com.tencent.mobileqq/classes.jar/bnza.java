import com.tencent.common.app.BaseApplicationImpl;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;

public final class bnza
{
  private static allk a = new allk(bgtn.a(), bgtn.b());
  
  public static allk a()
  {
    return a;
  }
  
  public static allk a(AECaptureMode paramAECaptureMode, allk paramallk, boolean paramBoolean, AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    allk localallk;
    if (paramAECaptureMode == AECaptureMode.NORMAL)
    {
      localallk = paramallk;
      if (paramBoolean)
      {
        if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
          break label50;
        }
        i = Math.min(paramallk.a, paramallk.b);
        localallk = new allk(i, i);
      }
    }
    label50:
    do
    {
      do
      {
        return localallk;
        localallk = paramallk;
      } while (paramRatio != AEVideoStoryTopBarViewModel.Ratio.FULL);
      return paramallk;
      localallk = paramallk;
    } while (paramAECaptureMode != AECaptureMode.GIF);
    int j = Math.min(paramallk.a, paramallk.b);
    int k = bggq.a(BaseApplicationImpl.getContext(), 250.0F);
    int i = j;
    if (k > 0) {
      i = Math.min(j, k);
    }
    return new allk(i, i);
  }
  
  public static void a(allk paramallk)
  {
    a = paramallk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnza
 * JD-Core Version:    0.7.0.1
 */