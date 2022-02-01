package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AEFlashShowMusicPart$initView$5
  implements View.OnClickListener
{
  AEFlashShowMusicPart$initView$5(AEFlashShowMusicPart paramAEFlashShowMusicPart) {}
  
  public final void onClick(View paramView)
  {
    paramView = AEFlashShowMusicPart.e(this.a);
    if (paramView != null) {
      paramView.setCurrentItem(0);
    }
    paramView = AEFlashShowMusicPart.f(this.a);
    if (paramView != null) {
      paramView.setSelected(true);
    }
    paramView = AEFlashShowMusicPart.g(this.a);
    if (paramView != null) {
      paramView.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart.initView.5
 * JD-Core Version:    0.7.0.1
 */