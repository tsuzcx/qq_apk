package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class LoadingMoreWidget$ScrollListener
  implements XViewPager.OnPageChangeListener
{
  private float b = -1.0F;
  private int c = UIUtils.e(BaseApplication.getContext());
  private int d = -1;
  private int e = -1;
  
  public LoadingMoreWidget$ScrollListener(LoadingMoreWidget paramLoadingMoreWidget) {}
  
  public void a(int paramInt)
  {
    if (this.a.g() != 0) {
      return;
    }
    this.e = paramInt;
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.a.g() != 0) {
      return;
    }
    if (this.d == -1) {
      this.d = paramInt1;
    }
    if (this.d != paramInt1)
    {
      this.d = paramInt1;
      this.b = paramFloat;
    }
    if (this.b > 0.5D)
    {
      this.a.b.setTranslationY(this.c - paramInt2);
      return;
    }
    this.a.b.setTranslationY(-paramInt2);
  }
  
  public void b(int paramInt)
  {
    SLog.a("Q.qqstory.playernew.LoadingMoreWidget", "onPageScrollStateChanged newState=%d visible=%d", Integer.valueOf(paramInt), Integer.valueOf(this.a.g()));
    if (this.a.g() != 0) {
      return;
    }
    if (paramInt == 1)
    {
      this.b = -1.0F;
      this.d = -1;
      this.e = -1;
      this.a.b.clearAnimation();
      return;
    }
    if (paramInt == 0)
    {
      if (this.b < 0.5D)
      {
        this.a.b.setTranslationY(0.0F);
        return;
      }
      if (this.e != -1) {
        this.a.b.setTranslationY(this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.LoadingMoreWidget.ScrollListener
 * JD-Core Version:    0.7.0.1
 */