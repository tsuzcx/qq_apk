import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;

class bnem
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  bnem(bnef parambnef) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    bnrh.b("VideoStoryCapturePart", "mCurrentRatio---onChanged: ratio=" + paramRatio);
    if (paramRatio == null) {}
    while (bnef.a(this.a) == paramRatio) {
      return;
    }
    bnef.a(this.a, paramRatio);
    int i = 0;
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
      i = bnef.a(this.a);
    }
    for (;;)
    {
      alsn localalsn = bnrg.a();
      paramRatio = bnrg.a(bnef.a(this.a), localalsn, bnef.b(this.a), paramRatio);
      bnef.a(this.a, i, paramRatio);
      bnef.a(this.a, localalsn, paramRatio);
      return;
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
        i = bnef.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnem
 * JD-Core Version:    0.7.0.1
 */