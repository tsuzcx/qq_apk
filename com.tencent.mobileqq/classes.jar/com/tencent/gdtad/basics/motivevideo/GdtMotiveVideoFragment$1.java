package com.tencent.gdtad.basics.motivevideo;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.qphone.base.util.QLog;

class GdtMotiveVideoFragment$1
  implements GdtMvViewController.Listener
{
  GdtMotiveVideoFragment$1(GdtMotiveVideoFragment paramGdtMotiveVideoFragment) {}
  
  public void a(long paramLong)
  {
    QLog.i("GdtMotiveVideoFragment", 4, "[onClickChangeVideo]");
    if (GdtMotiveVideoFragment.a(this.a) == null)
    {
      QLog.e("GdtMotiveVideoFragment", 4, "[onClickChangeVideo] mRootView is null");
      return;
    }
    GdtMotiveVideoFragment.a(this.a, true);
    if (GdtMotiveVideoFragment.b(this.a) == null)
    {
      QLog.e("GdtMotiveVideoFragment", 4, "[onClickChangeVideo] mSecondVideoData is null");
      return;
    }
    Object localObject = this.a;
    GdtMotiveVideoFragment.a((GdtMotiveVideoFragment)localObject, new GdtMotiveVideoModel(GdtMotiveVideoFragment.b((GdtMotiveVideoFragment)localObject)));
    localObject = this.a;
    localObject = ((GdtMotiveVideoFragment)localObject).a(LayoutInflater.from(((GdtMotiveVideoFragment)localObject).getContext()), GdtMotiveVideoFragment.a(this.a), 2);
    if (localObject == null)
    {
      QLog.e("GdtMotiveVideoFragment", 4, "[onClickChangeVideo] childViews is null");
      return;
    }
    GdtMotiveVideoFragment.c(this.a).a(paramLong);
    GdtMotiveVideoFragment.a(this.a).removeAllViews();
    GdtMotiveVideoFragment.a(this.a).addView((View)localObject);
    GdtMotiveVideoFragment.c(this.a).l();
    QLog.e("GdtMotiveVideoFragment", 4, "[onClickChangeVideo] childViews is added");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */