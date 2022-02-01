package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AEFlashShowMusicPart$initView$2
  implements View.OnClickListener
{
  AEFlashShowMusicPart$initView$2(AEFlashShowMusicPart paramAEFlashShowMusicPart) {}
  
  public final void onClick(View paramView)
  {
    AEFlashShowMusicPart.b(this.a).d().postValue(Boolean.valueOf(true));
    AEFlashShowMusicPart.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart.initView.2
 * JD-Core Version:    0.7.0.1
 */