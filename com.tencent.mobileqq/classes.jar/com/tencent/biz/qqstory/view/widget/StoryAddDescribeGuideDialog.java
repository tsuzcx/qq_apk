package com.tencent.biz.qqstory.view.widget;

import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class StoryAddDescribeGuideDialog
  extends ReportDialog
{
  private LinearLayout a;
  private ImageView b;
  private boolean c;
  
  private void a()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b.clearAnimation();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setFillAfter(true);
    this.a.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new StoryAddDescribeGuideDialog.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryAddDescribeGuideDialog
 * JD-Core Version:    0.7.0.1
 */