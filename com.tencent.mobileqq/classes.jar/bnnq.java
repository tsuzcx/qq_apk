import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.view.AECompoundButton;

class bnnq
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  bnnq(bnnl parambnnl) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    boolean bool2 = true;
    if (paramRatio == null) {
      return;
    }
    Object localObject = bnnl.b(this.a);
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL)
    {
      bool1 = true;
      ((AECompoundButton)localObject).setSelected(bool1);
      bnzc.a();
      if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
        break label112;
      }
      localObject = bnzg.a;
      label47:
      bnnl.a(this.a, (bnzg)localObject);
      localObject = new Intent();
      ((Intent)localObject).setAction("ae_editor_bottom_tab_change_style");
      if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.FULL) {
        break label120;
      }
    }
    label112:
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((Intent)localObject).putExtra("is_full_screen_capture", bool1);
      bnnl.a(this.a).a().sendBroadcast((Intent)localObject);
      return;
      bool1 = false;
      break;
      localObject = bnzg.b;
      break label47;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnq
 * JD-Core Version:    0.7.0.1
 */