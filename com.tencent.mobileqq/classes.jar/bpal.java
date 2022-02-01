import com.tencent.common.app.BaseApplicationImpl;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;

public final class bpal
{
  private static alxc a = new alxc(bhtq.a(), bhtq.b());
  
  public static int a()
  {
    float f = 1.0F * a.a() / a.b();
    int i;
    if (f <= 0.5215578F) {
      i = 1;
    }
    for (;;)
    {
      bpam.b("AEPreviewSizeUtil", "[CircleCameraRatio]---screen size=" + a + ", screen ratio=" + f + ", type=" + i);
      return i;
      if (f <= 0.5625F) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static alxc a()
  {
    return a;
  }
  
  public static alxc a(AECaptureMode paramAECaptureMode, alxc paramalxc, boolean paramBoolean, AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    alxc localalxc;
    if (paramAECaptureMode == AECaptureMode.NORMAL)
    {
      localalxc = paramalxc;
      if (paramBoolean)
      {
        if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
          break label50;
        }
        i = Math.min(paramalxc.a, paramalxc.b);
        localalxc = new alxc(i, i);
      }
    }
    label50:
    do
    {
      do
      {
        do
        {
          return localalxc;
          localalxc = paramalxc;
        } while (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL);
        localalxc = paramalxc;
      } while (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_4_3);
      return new alxc(paramalxc.a, (int)(1.333333F * paramalxc.a));
      localalxc = paramalxc;
    } while (paramAECaptureMode != AECaptureMode.GIF);
    int j = Math.min(paramalxc.a, paramalxc.b);
    int k = bhgr.a(BaseApplicationImpl.getContext(), 250.0F);
    int i = j;
    if (k > 0) {
      i = Math.min(j, k);
    }
    return new alxc(i, i);
  }
  
  public static void a(alxc paramalxc)
  {
    a = paramalxc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpal
 * JD-Core Version:    0.7.0.1
 */