package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.SimpleActivityLifeCycle;
import java.util.Iterator;
import java.util.Set;

public class BannerVideoInfoWidget3$BannerActivityLifeCycle
  extends SimpleActivityLifeCycle
{
  public BannerVideoInfoWidget3$BannerActivityLifeCycle(BannerVideoInfoWidget3 paramBannerVideoInfoWidget3) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.a.a != null) && (this.a.a.a != null) && (!this.a.a.a.isEmpty()))
    {
      Iterator localIterator = this.a.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ActivityLifeCycle)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((this.a.a != null) && (this.a.a.a != null) && (!this.a.a.a.isEmpty()))
    {
      Iterator localIterator = this.a.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ActivityLifeCycle)localIterator.next()).a(paramBundle1, paramBundle2);
      }
    }
  }
  
  public void c()
  {
    if ((this.a.a != null) && (this.a.a.a != null) && (!this.a.a.a.isEmpty()))
    {
      Iterator localIterator = this.a.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ActivityLifeCycle)localIterator.next()).c();
      }
    }
  }
  
  public void d()
  {
    if ((this.a.a != null) && (this.a.a.a != null) && (!this.a.a.a.isEmpty()))
    {
      Iterator localIterator = this.a.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ActivityLifeCycle)localIterator.next()).d();
      }
    }
  }
  
  public void e()
  {
    if ((this.a.a != null) && (this.a.a.a != null) && (!this.a.a.a.isEmpty()))
    {
      Iterator localIterator = this.a.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ActivityLifeCycle)localIterator.next()).e();
      }
    }
  }
  
  public void f()
  {
    if ((this.a.a != null) && (this.a.a.a != null) && (!this.a.a.a.isEmpty()))
    {
      Iterator localIterator = this.a.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ActivityLifeCycle)localIterator.next()).f();
      }
    }
  }
  
  public void g()
  {
    if ((this.a.a != null) && (this.a.a.a != null) && (!this.a.a.a.isEmpty()))
    {
      Iterator localIterator = this.a.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ActivityLifeCycle)localIterator.next()).g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3.BannerActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */