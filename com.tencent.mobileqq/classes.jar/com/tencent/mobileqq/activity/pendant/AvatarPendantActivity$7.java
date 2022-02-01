package com.tencent.mobileqq.activity.pendant;

import android.os.Build.VERSION;
import com.tencent.widget.AbsListView;

class AvatarPendantActivity$7
  extends AvatarPendantActivity.AnimationScrollListener
{
  AvatarPendantActivity$7(AvatarPendantActivity paramAvatarPendantActivity)
  {
    super(paramAvatarPendantActivity);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.e == AvatarPendantActivity.d) {
      return;
    }
    if (Build.VERSION.SDK_INT < 14) {
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.7
 * JD-Core Version:    0.7.0.1
 */