package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Intent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.SimpleActivityLifeCycle;

public class BannerVideoInfoWidget3$MyActivityLifeCycle
  extends SimpleActivityLifeCycle
{
  private BannerVideoInfoWidget3.LifeCycleCallback a;
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    BannerVideoInfoWidget3.LifeCycleCallback localLifeCycleCallback = this.a;
    if (localLifeCycleCallback != null) {
      localLifeCycleCallback.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void f()
  {
    BannerVideoInfoWidget3.LifeCycleCallback localLifeCycleCallback = this.a;
    if (localLifeCycleCallback != null) {
      localLifeCycleCallback.b();
    }
  }
  
  public void g()
  {
    BannerVideoInfoWidget3.LifeCycleCallback localLifeCycleCallback = this.a;
    if (localLifeCycleCallback != null) {
      localLifeCycleCallback.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3.MyActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */