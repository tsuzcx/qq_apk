package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.b.b;
import com.sina.weibo.sdk.b.b.a;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.b.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.FutureTask;

public class ShareChatActivity
  extends BaseActivity
{
  private Intent v;
  private FrameLayout w;
  private d x;
  private Handler y = new ShareChatActivity.1(this, Looper.getMainLooper());
  
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
    paramBundle = this.v.getExtras();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    paramBundle = (ChatObject)paramBundle.getParcelable("chat_object");
    if (paramBundle != null)
    {
      localObject = this.x;
      if (localObject != null) {
        ((c)localObject).T.cancel(true);
      }
      this.x = new d(this, paramBundle, new ShareChatActivity.2(this, paramBundle));
      b.a.n().a(this.x);
      return;
    }
    this.w.setVisibility(4);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
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
 * Qualified Name:     com.sina.weibo.sdk.share.ShareChatActivity
 * JD-Core Version:    0.7.0.1
 */