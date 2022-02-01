package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

class AIOGalleryScene$24
  implements AIOGalleryAdapter.OnAdapterNotify
{
  AIOGalleryScene$24(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      View localView = this.a.a().findViewById(2131367440);
      if (localView == null) {
        return;
      }
      localView.setVisibility(0);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(300L);
      localView.startAnimation(localAlphaAnimation);
      localView.postDelayed(new AIOGalleryScene.24.1(this, localView), 8000L);
      return;
    }
    if (2 == paramInt)
    {
      this.a.a(null);
      return;
    }
    if (3 == paramInt)
    {
      this.a.a.a().a.i = true;
      this.a.e.setText("");
      this.a.u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.24
 * JD-Core Version:    0.7.0.1
 */