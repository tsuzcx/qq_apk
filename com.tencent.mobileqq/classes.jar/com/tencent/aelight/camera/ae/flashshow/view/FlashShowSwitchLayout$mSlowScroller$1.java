package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$mSlowScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowSwitchLayout$mSlowScroller$1
  extends LinearSmoothScroller
{
  FlashShowSwitchLayout$mSlowScroller$1(Context paramContext)
  {
    super(localContext);
  }
  
  protected float calculateSpeedPerPixel(@Nullable DisplayMetrics paramDisplayMetrics)
  {
    return super.calculateSpeedPerPixel(paramDisplayMetrics) * 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout.mSlowScroller.1
 * JD-Core Version:    0.7.0.1
 */