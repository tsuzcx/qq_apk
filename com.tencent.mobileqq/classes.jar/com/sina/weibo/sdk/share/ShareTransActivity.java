package com.sina.weibo.sdk.share;

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
      localObject = new Intent("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
      ((Intent)localObject).putExtras(paramWeiboMultiMessage.writeToBundle(localBundle));
      ((Intent)localObject).putExtra("_weibo_sdkVersion", "0041005000");
      ((Intent)localObject).putExtra("_weibo_appPackage", getPackageName());
      ((Intent)localObject).putExtra("_weibo_appKey", com.sina.weibo.sdk.a.a().getAppKey());
      ((Intent)localObject).putExtra("_weibo_flag", 538116905);
      ((Intent)localObject).putExtra("_weibo_sign", com.sina.weibo.sdk.c.d.e(e.e(this, getPackageName())));
      paramWeiboMultiMessage = this.v.getStringExtra("start_web_activity");
      if ((!TextUtils.isEmpty(paramWeiboMultiMessage)) && ("com.sina.weibo.sdk.web.WebActivity".equals(paramWeiboMultiMessage)))
      {
        ((Intent)localObject).setClassName(this, paramWeiboMultiMessage);
        startActivityForResult((Intent)localObject, 10001);
        return;
      }
      if (com.sina.weibo.sdk.a.a(this))
      {
        paramWeiboMultiMessage = com.sina.weibo.sdk.c.a.c(this);
        if (paramWeiboMultiMessage != null) {
          ((Intent)localObject).setPackage(paramWeiboMultiMessage.packageName);
        }
        startActivityForResult((Intent)localObject, 10001);
        return;
      }
      c("Start weibo client's composer fail. And Weibo client is not installed.");
      return;
    }
    catch (Throwable paramWeiboMultiMessage)
    {
      Object localObject = new StringBuilder("start wb composer fail,");
      ((StringBuilder)localObject).append(paramWeiboMultiMessage.getMessage());
      c.b("WBShareTag", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder("Start weibo client's composer fail. ");
      ((StringBuilder)localObject).append(paramWeiboMultiMessage.getMessage());
      c(((StringBuilder)localObject).toString());
    }
  }
  
  private void c(String paramString)
  {
    Object localObject = this.w;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(4);
    }
    localObject = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("_weibo_resp_errcode", 2);
    localBundle.putString("_weibo_resp_errstr", paramString);
    ((Intent)localObject).putExtras(localBundle);
    setResult(-1, (Intent)localObject);
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
    paramIntent = this.y;
    if (paramIntent != null) {
      paramIntent.sendEmptyMessageDelayed(0, 100L);
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
    paramBundle = this.v;
    if (paramBundle == null)
    {
      finish();
      return;
    }
    if (paramBundle.getIntExtra("start_flag", -1) != 0)
    {
      finish();
      return;
    }
    this.w = new FrameLayout(this);
    int i = getIntent().getIntExtra("progress_id", -1);
    if (i != -1) {
      paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(i, null);
    } else {
      paramBundle = new ProgressBar(this);
    }
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.w.addView(paramBundle, (ViewGroup.LayoutParams)localObject);
    this.w.setBackgroundColor(855638016);
    setContentView(this.w);
    c.a("WBShareTag", "prepare wb resource.");
    localObject = this.v.getExtras();
    if (localObject == null)
    {
      finish();
      return;
    }
    paramBundle = new WeiboMultiMessage();
    paramBundle.readFromBundle((Bundle)localObject);
    if ((paramBundle.multiImageObject == null) && (paramBundle.videoSourceObject == null))
    {
      a(paramBundle);
      return;
    }
    localObject = this.D;
    if (localObject != null) {
      ((d)localObject).cancel(true);
    }
    this.D = new d(this, new ShareTransActivity.2(this));
    this.D.execute(new WeiboMultiMessage[] { paramBundle });
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    c.a("WBShareTag", "start share activity again.");
    Handler localHandler = this.y;
    if (localHandler != null)
    {
      localHandler.removeMessages(0);
      this.y = null;
    }
    setResult(-1, paramIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareTransActivity
 * JD-Core Version:    0.7.0.1
 */