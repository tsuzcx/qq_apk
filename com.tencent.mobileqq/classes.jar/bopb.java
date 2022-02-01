import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;

class bopb
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  bopb(boow paramboow) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    bpan.a();
    Object localObject = bojy.a(paramRatio);
    boow.a(this.a, (bpas)localObject);
    localObject = new Intent();
    ((Intent)localObject).setAction("ae_editor_bottom_tab_change_style");
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL) {}
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("is_full_screen_capture", bool);
      boow.a(this.a).a().sendBroadcast((Intent)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopb
 * JD-Core Version:    0.7.0.1
 */