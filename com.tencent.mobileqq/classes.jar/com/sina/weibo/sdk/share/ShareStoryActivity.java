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
  
  /* Error */
  private void a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/sina/weibo/sdk/share/ShareStoryActivity:w	Landroid/widget/FrameLayout;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +8 -> 14
    //   9: aload_3
    //   10: iconst_4
    //   11: invokevirtual 43	android/widget/FrameLayout:setVisibility	(I)V
    //   14: new 45	android/content/Intent
    //   17: dup
    //   18: invokespecial 46	android/content/Intent:<init>	()V
    //   21: astore_3
    //   22: new 48	android/os/Bundle
    //   25: dup
    //   26: invokespecial 49	android/os/Bundle:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: ldc 51
    //   35: iload_1
    //   36: invokevirtual 55	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   39: aload 4
    //   41: ldc 57
    //   43: aload_2
    //   44: invokevirtual 61	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_3
    //   48: aload 4
    //   50: invokevirtual 65	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   53: pop
    //   54: aload_0
    //   55: iconst_m1
    //   56: aload_3
    //   57: invokevirtual 69	com/sina/weibo/sdk/share/ShareStoryActivity:setResult	(ILandroid/content/Intent;)V
    //   60: aload_0
    //   61: getfield 29	com/sina/weibo/sdk/share/ShareStoryActivity:y	Landroid/os/Handler;
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +13 -> 79
    //   69: aload_2
    //   70: iconst_0
    //   71: invokevirtual 74	android/os/Handler:removeMessages	(I)V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 29	com/sina/weibo/sdk/share/ShareStoryActivity:y	Landroid/os/Handler;
    //   79: aload_0
    //   80: invokevirtual 77	com/sina/weibo/sdk/share/ShareStoryActivity:finish	()V
    //   83: return
    //   84: astore_2
    //   85: goto +32 -> 117
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   93: aload_0
    //   94: getfield 29	com/sina/weibo/sdk/share/ShareStoryActivity:y	Landroid/os/Handler;
    //   97: astore_2
    //   98: aload_2
    //   99: ifnull +13 -> 112
    //   102: aload_2
    //   103: iconst_0
    //   104: invokevirtual 74	android/os/Handler:removeMessages	(I)V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 29	com/sina/weibo/sdk/share/ShareStoryActivity:y	Landroid/os/Handler;
    //   112: aload_0
    //   113: invokevirtual 77	com/sina/weibo/sdk/share/ShareStoryActivity:finish	()V
    //   116: return
    //   117: aload_0
    //   118: getfield 29	com/sina/weibo/sdk/share/ShareStoryActivity:y	Landroid/os/Handler;
    //   121: astore_3
    //   122: aload_3
    //   123: ifnull +13 -> 136
    //   126: aload_3
    //   127: iconst_0
    //   128: invokevirtual 74	android/os/Handler:removeMessages	(I)V
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 29	com/sina/weibo/sdk/share/ShareStoryActivity:y	Landroid/os/Handler;
    //   136: aload_0
    //   137: invokevirtual 77	com/sina/weibo/sdk/share/ShareStoryActivity:finish	()V
    //   140: aload_2
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	ShareStoryActivity
    //   0	142	1	paramInt	int
    //   0	142	2	paramString	String
    //   4	123	3	localObject	Object
    //   29	20	4	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   14	60	84	finally
    //   89	93	84	finally
    //   14	60	88	java/lang/Exception
  }
  
  private void c(String paramString)
  {
    Handler localHandler = this.y;
    if (localHandler != null)
    {
      localHandler.removeMessages(0);
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
    if (this.v.getExtras() == null)
    {
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
      localObject = this.B;
      if (localObject != null) {
        ((e)localObject).cancel(true);
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
    Handler localHandler = this.y;
    if (localHandler != null)
    {
      localHandler.removeMessages(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareStoryActivity
 * JD-Core Version:    0.7.0.1
 */