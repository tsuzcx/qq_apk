package com.tencent.biz.pubaccount.Advertisement.activity;

import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout.OnDraggingListener;
import com.tencent.mobileqq.util.DisplayUtil;

class PublicAccountAdvertisementActivity$1
  implements DragFrameLayout.OnDraggingListener
{
  PublicAccountAdvertisementActivity$1(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 - paramInt3 > DisplayUtil.a(this.a, 60.0F))
    {
      PublicAccountAdvertisementActivity.a(this.a);
      PublicAccountAdvertisementActivity.b(this.a);
      this.a.finish();
      return;
    }
    PublicAccountAdvertisementActivity.c(this.a).a();
  }
  
  public boolean a()
  {
    return (!PublicAccountAdvertisementActivity.d(this.a)) && (!PublicAccountAdvertisementActivity.e(this.a)) && (PublicAccountAdvertisementActivity.f(this.a));
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.1
 * JD-Core Version:    0.7.0.1
 */