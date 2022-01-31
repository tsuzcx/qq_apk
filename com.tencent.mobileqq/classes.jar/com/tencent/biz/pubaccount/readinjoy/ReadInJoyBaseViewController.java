package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;

public abstract class ReadInJoyBaseViewController
{
  protected Activity a;
  
  protected ReadInJoyBaseViewController() {}
  
  protected ReadInJoyBaseViewController(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public Activity a()
  {
    return this.a;
  }
  
  public ViewGroup a()
  {
    return null;
  }
  
  public VideoPlayManager a()
  {
    return null;
  }
  
  public VideoRecommendManager a()
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void l() {}
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController
 * JD-Core Version:    0.7.0.1
 */