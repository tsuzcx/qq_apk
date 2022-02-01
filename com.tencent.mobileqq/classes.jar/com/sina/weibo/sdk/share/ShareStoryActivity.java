package com.sina.weibo.sdk.share;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.api.StoryMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ShareStoryActivity
  extends BaseActivity
{
  private e B;
  private Intent v;
  private FrameLayout w;
  private Handler y = new ShareStoryActivity.1(this, Looper.getMainLooper());
  
  private void a(int paramInt, String paramString)
  {
    if (this.w != null) {
      this.w.setVisibility(4);
    }
    try
    {
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putInt("_weibo_resp_errcode", paramInt);
      localBundle.putString("_weibo_resp_errstr", paramString);
      localIntent.putExtras(localBundle);
      setResult(-1, localIntent);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    finally
    {
      if (this.y != null)
      {
        this.y.removeMessages(0);
        this.y = null;
      }
      finish();
    }
  }
  
  private void c(String paramString)
  {
    if (this.y != null)
    {
      this.y.removeMessages(0);
      this.y = null;
    }
    a(2, paramString);
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
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      this.w.addView(paramBundle, localLayoutParams);
      this.w.setBackgroundColor(855638016);
      setContentView(this.w);
      if (this.v.getExtras() != null) {
        break;
      }
      finish();
      return;
    }
    paramBundle = (StoryMessage)getIntent().getParcelableExtra("_weibo_message_stroy");
    if (paramBundle == null)
    {
      c("StoryMessage is null.");
      return;
    }
    if ((paramBundle.checkResource()) && (a.b(this)))
    {
      if (this.B != null) {
        this.B.cancel(true);
      }
      this.B = new e(this, new ShareStoryActivity.2(this));
      this.B.execute(new StoryMessage[] { paramBundle });
      return;
    }
    c("StoryMessage's resource is error.");
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.y != null)
    {
      this.y.removeMessages(0);
      this.y = null;
    }
    if (paramIntent.getIntExtra("backType", 0) == 0)
    {
      a(1, "cancel");
      return;
    }
    a(0, "ok");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareStoryActivity
 * JD-Core Version:    0.7.0.1
 */