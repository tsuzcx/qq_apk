import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;

class bnlj
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  bnlj(bnlc parambnlc) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    bnzb.b("VideoStoryCapturePart", "mCurrentRatio---onChanged: ratio=" + paramRatio);
    if (paramRatio == null) {}
    while (bnlc.a(this.a) == paramRatio) {
      return;
    }
    bnlc.a(this.a, paramRatio);
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {}
    for (int i = bnlc.a;; i = 0)
    {
      bnlc.a(this.a, i, bnza.a(bnlc.a(this.a), bnza.a(), bnlc.b(this.a), paramRatio));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlj
 * JD-Core Version:    0.7.0.1
 */