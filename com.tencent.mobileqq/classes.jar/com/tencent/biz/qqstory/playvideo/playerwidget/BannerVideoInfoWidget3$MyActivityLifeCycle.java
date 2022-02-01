package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Intent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.SimpleActivityLifeCycle;

public class BannerVideoInfoWidget3$MyActivityLifeCycle
  extends SimpleActivityLifeCycle
{
  private BannerVideoInfoWidget3.LifeCycleCallback a;
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void f()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void g()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3.MyActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */