package com.tencent.mm.ui.widget.dialog;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMAlertDialog$1
  implements View.OnClickListener
{
  MMAlertDialog$1(MMAlertDialog paramMMAlertDialog, MMAlertDialog.Builder.IOnTitleClick paramIOnTitleClick, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    MMAlertDialog.Builder.IOnTitleClick localIOnTitleClick = this.a;
    if (localIOnTitleClick != null) {
      localIOnTitleClick.onTitleClick(true);
    }
    if (this.b.isSelected())
    {
      MMAlertDialog.b(this.c).startAnimation(MMAlertDialog.a(this.c));
      MMAlertDialog.a(this.c).setAnimationListener(new MMAlertDialog.1.1(this));
      ObjectAnimator.ofFloat(this.b, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
      this.b.setSelected(false);
    }
    else
    {
      MMAlertDialog.b(this.c).startAnimation(MMAlertDialog.d(this.c));
      MMAlertDialog.d(this.c).setAnimationListener(new MMAlertDialog.1.2(this));
      ObjectAnimator.ofFloat(this.b, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
      this.b.setSelected(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMAlertDialog.1
 * JD-Core Version:    0.7.0.1
 */