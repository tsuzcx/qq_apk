import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;

class bomw
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  bomw(bomp parambomp) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    bpam.b("VideoStoryCapturePart", "mCurrentRatio---onChanged: ratio=" + paramRatio);
    if (paramRatio == null) {}
    while (bomp.a(this.a) == paramRatio) {
      return;
    }
    bomp.a(this.a, paramRatio);
    int i = 0;
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
      i = bomp.a(this.a);
    }
    for (;;)
    {
      alxc localalxc = bpal.a();
      paramRatio = bpal.a(bomp.a(this.a), localalxc, bomp.b(this.a), paramRatio);
      bomp.a(this.a, i, paramRatio);
      bomp.a(this.a, localalxc, paramRatio);
      return;
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
        i = bomp.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomw
 * JD-Core Version:    0.7.0.1
 */