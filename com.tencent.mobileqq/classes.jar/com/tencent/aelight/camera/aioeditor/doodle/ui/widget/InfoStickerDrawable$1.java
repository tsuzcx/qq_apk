package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.ArrayList;

class InfoStickerDrawable$1
  implements ValueAnimator.AnimatorUpdateListener
{
  InfoStickerDrawable$1(InfoStickerDrawable paramInfoStickerDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (ArrayList)paramValueAnimator.getAnimatedValue();
    InfoStickerDrawable localInfoStickerDrawable = this.a;
    localInfoStickerDrawable.g = paramValueAnimator;
    localInfoStickerDrawable.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable.1
 * JD-Core Version:    0.7.0.1
 */