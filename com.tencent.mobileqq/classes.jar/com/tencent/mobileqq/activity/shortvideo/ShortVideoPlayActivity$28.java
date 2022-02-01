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
    return ShortVideoPlayActivity.access$2200(this.a);
  }
  
  public void a(Bundle paramBundle)
  {
    Intent localIntent = this.a.getIntentForStartForwardRecentActivity();
    localIntent.putExtras(paramBundle);
    ForwardBaseOption.a((Activity)this.a.mContext, localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_shoucang");
  }
  
  public void b()
  {
    ShortVideoPlayActivity.access$2100(this.a);
  }
  
  public void e()
  {
    this.a.forwardFavorite();
  }
  
  public void f()
  {
    ShortVideoPlayActivity.access$2400(this.a);
  }
  
  public void g()
  {
    this.a.shareToPC();
  }
  
  public void m()
  {
    ShortVideoPlayActivity.access$2300(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.28
 * JD-Core Version:    0.7.0.1
 */