package com.tencent.biz.pubaccount.readinjoy.popup;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.util.AnimateUtils.AnimationAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/popup/RIJBottomDialog$animateDown$1$1", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJBottomDialog$animateDown$$inlined$let$lambda$1
  extends AnimateUtils.AnimationAdapter
{
  RIJBottomDialog$animateDown$$inlined$let$lambda$1(RIJBottomDialog paramRIJBottomDialog) {}
  
  public void onAnimationEnd(@Nullable Animation paramAnimation)
  {
    RIJBottomDialog.a(this.a, false);
    paramAnimation = this.a.a();
    if (paramAnimation != null) {
      paramAnimation.post((Runnable)new RIJBottomDialog.animateDown..inlined.let.lambda.1.1(this));
    }
  }
  
  public void onAnimationStart(@Nullable Animation paramAnimation)
  {
    RIJBottomDialog.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJBottomDialog.animateDown..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */