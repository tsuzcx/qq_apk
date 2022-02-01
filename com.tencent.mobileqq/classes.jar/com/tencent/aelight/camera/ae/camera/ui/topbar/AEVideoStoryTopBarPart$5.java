package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;

class AEVideoStoryTopBarPart$5
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  AEVideoStoryTopBarPart$5(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    AEThemeUtil.a();
    Object localObject = VideoStoryPiecesPart.a(paramRatio);
    AEVideoStoryTopBarPart.a(this.a, (AECircleCaptureStyle)localObject);
    localObject = new Intent();
    ((Intent)localObject).setAction("ae_editor_bottom_tab_change_style");
    boolean bool;
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
      bool = true;
    } else {
      bool = false;
    }
    ((Intent)localObject).putExtra("is_full_screen_capture", bool);
    AEVideoStoryTopBarPart.a(this.a).a().sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.5
 * JD-Core Version:    0.7.0.1
 */