package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AEFlashShowMusicPart$initView$6
  implements View.OnClickListener
{
  AEFlashShowMusicPart$initView$6(AEFlashShowMusicPart paramAEFlashShowMusicPart) {}
  
  public final void onClick(View paramView)
  {
    paramView = AEFlashShowMusicPart.e(this.a);
    if (paramView != null) {
      paramView.setCurrentItem(1);
    }
    paramView = AEFlashShowMusicPart.f(this.a);
    if (paramView != null) {
      paramView.setSelected(false);
    }
    paramView = AEFlashShowMusicPart.g(this.a);
    if (paramView != null) {
      paramView.setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart.initView.6
 * JD-Core Version:    0.7.0.1
 */