package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

public class SyncParentPressedRelativeLayout
  extends RelativeLayout
{
  public SyncParentPressedRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (isPressed() == paramBoolean) {
      return;
    }
    View localView = (View)getParent();
    if ((localView != null) && ((localView instanceof BreathAnimationLayout)) && (localView.isPressed() != paramBoolean)) {
      localView.setPressed(paramBoolean);
    }
    super.setPressed(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout
 * JD-Core Version:    0.7.0.1
 */