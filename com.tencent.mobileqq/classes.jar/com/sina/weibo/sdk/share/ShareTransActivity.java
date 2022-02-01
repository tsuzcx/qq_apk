package com.sina.weibo.sdk.share;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.c.a.a;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.c.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ShareTransActivity
  extends BaseActivity
{
  private d D;
  private Intent v;
  private FrameLayout w;
  private Handler y = new ShareTransActivity.1(this, Looper.getMainLooper());
  
  private void a(WeiboMultiMessage paramWeiboMultiMessage)
  {
    c.a("WBShareTag", "start wb composer");
    try
    {
      this.v.putExtra("start_flag", -1);
      Bundle localBundle = this.v.getExtras();
      Intent localIntent = new Intent("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
      localIntent.putExtras(paramWeiboMultiMessage.writeToBundle(localBundle));
      localIntent.putExtra("_weibo_sdkVersion", "0041005000");
      localIntent.putExtra("_weibo_appPackage", getPackageName());
      localIntent.putExtra("_weibo_appKey", com.sina.weibo.sdk.a.a().getAppKey());
      localIntent.putExtra("_weibo_flag", 538116905);
      localIntent.putExtra("_weibo_sign", com.sina.weibo.sdk.c.d.e(e.e(this, getPackageName())));
      paramWeiboMultiMessage = this.v.getStringExtra("start_web_activity");
      if ((!TextUtils.isEmpty(paramWeiboMultiMessage)) && ("com.sina.weibo.sdk.web.WebActivity".equals(paramWeiboMultiMessage)))
      {
        localIntent.setClassName(this, paramWeiboMultiMessage);
        startActivityForResult(localIntent, 10001);
        return;
      }
      if (com.sina.weibo.sdk.a.a(this))
      {
        paramWeiboMultiMessage = com.sina.weibo.sdk.c.a.c(this);
        if (paramWeiboMultiMessage != null) {
          localIntent.setPackage(paramWeiboMultiMessage.packageName);
        }
        startActivityForResult(localIntent, 10001);
        return;
      }
    }
    catch (Throwable paramWeiboMultiMessage)
    {
      c.b("WBShareTag", "start wb composer fail," + paramWeiboMultiMessage.getMessage());
      c("Start weibo client's composer fail. " + paramWeiboMultiMessage.getMessage());
      return;
    }
    c("Start weibo client's composer fail. And Weibo client is not installed.");
  }
  
  private void c(String paramString)
  {
    if (this.w != null) {
      this.w.setVisibility(4);
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("_weibo_resp_errcode", 2);
    localBundle.putString("_weibo_resp_errstr", paramString);
    localIntent.putExtras(localBundle);
    setResult(-1, localIntent);
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    c.a("WBShareTag", "onActivityResult.");
    if (this.y != null) {
      this.y.sendEmptyMessageDelayed(0, 100L);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c.a("WBShareTag", "start share activity.");
    this.v = getIntent();
    if (this.v == null)
    {
      finish();
      return;
    }
    if (this.v.getIntExtra("start_flag", -1) != 0)
    {
      finish();
      return;
    }
    this.w = new FrameLayout(this);
    int i = getIntent().getIntExtra("progress_id", -1);
    if (i != -1) {}
    for (paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(i, null);; paramBundle = new ProgressBar(this))
    {
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.w.addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      this.w.setBackgroundColor(855638016);
      setContentView(this.w);
      c.a("WBShareTag", "prepare wb resource.");
      paramBundle = this.v.getExtras();
      if (paramBundle != null) {
        break;
      }
      finish();
      return;
    }
    Object localObject = new WeiboMultiMessage();
    ((WeiboMultiMessage)localObject).readFromBundle(paramBundle);
    if ((((WeiboMultiMessage)localObject).multiImageObject != null) || (((WeiboMultiMessage)localObject).videoSourceObject != null))
    {
      if (this.D != null) {
        this.D.cancel(true);
      }
      this.D = new d(this, new ShareTransActivity.2(this));
      this.D.execute(new WeiboMultiMessage[] { localObject });
      return;
    }
    a((WeiboMultiMessage)localObject);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    c.a("WBShareTag", "start share activity again.");
    if (this.y != null)
    {
      this.y.removeMessages(0);
      this.y = null;
    }
    setResult(-1, paramIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareTransActivity
 * JD-Core Version:    0.7.0.1
 */