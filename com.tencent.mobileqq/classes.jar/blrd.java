import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;

class blrd
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  blrd(blqw paramblqw) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    bmbx.b("VideoStoryCapturePart", "mCurrentRatio---onChanged: ratio=" + paramRatio);
    if (paramRatio == null) {}
    while (blqw.a(this.a) == paramRatio) {
      return;
    }
    blqw.a(this.a, paramRatio);
    int i = 0;
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
      i = blqw.a(this.a);
    }
    for (;;)
    {
      akur localakur = bmbw.a();
      paramRatio = bmbw.a(blqw.a(this.a), localakur, blqw.b(this.a), paramRatio);
      blqw.a(this.a, i, paramRatio);
      blqw.a(this.a, localakur, paramRatio);
      return;
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
        i = blqw.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrd
 * JD-Core Version:    0.7.0.1
 */