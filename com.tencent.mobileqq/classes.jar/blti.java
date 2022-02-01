import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;

class blti
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  blti(bltd parambltd) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    bmby.a();
    Object localObject = bloe.a(paramRatio);
    bltd.a(this.a, (bmcd)localObject);
    localObject = new Intent();
    ((Intent)localObject).setAction("ae_editor_bottom_tab_change_style");
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL) {}
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("is_full_screen_capture", bool);
      bltd.a(this.a).a().sendBroadcast((Intent)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blti
 * JD-Core Version:    0.7.0.1
 */