import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;

class bncc
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  bncc(bnbp parambnbp) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    bnru localbnru = bnbp.a(paramRatio);
    if (bnbp.a(this.a) != null) {
      bnbp.a(this.a).setCaptureRadio(paramRatio);
    }
    bnbp.a(this.a, localbnru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncc
 * JD-Core Version:    0.7.0.1
 */