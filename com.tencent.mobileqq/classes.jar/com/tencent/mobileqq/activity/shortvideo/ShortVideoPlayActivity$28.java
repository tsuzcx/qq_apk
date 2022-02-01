package com.tencent.mobileqq.activity.shortvideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import cooperation.qqfav.widget.FavoriteActionSheet.DefaultActions;

class ShortVideoPlayActivity$28
  extends FavoriteActionSheet.DefaultActions
{
  ShortVideoPlayActivity$28(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public int a()
  {
    return ShortVideoPlayActivity.d(this.a);
  }
  
  public void a(Bundle paramBundle)
  {
    Intent localIntent = this.a.a();
    localIntent.putExtras(paramBundle);
    ForwardBaseOption.a((Activity)this.a.a, localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_shoucang");
  }
  
  public void b()
  {
    ShortVideoPlayActivity.e(this.a);
  }
  
  public void e()
  {
    this.a.v();
  }
  
  public void f()
  {
    ShortVideoPlayActivity.g(this.a);
  }
  
  public void g()
  {
    this.a.u();
  }
  
  public void m()
  {
    ShortVideoPlayActivity.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.28
 * JD-Core Version:    0.7.0.1
 */