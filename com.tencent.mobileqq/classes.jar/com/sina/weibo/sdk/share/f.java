package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import java.lang.ref.WeakReference;

public final class f
{
  public WeakReference<Activity> g;
  
  public f(Activity paramActivity)
  {
    this.g = new WeakReference(paramActivity);
  }
  
  public final void b(WeiboMultiMessage paramWeiboMultiMessage)
  {
    Activity localActivity = (Activity)this.g.get();
    if (localActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("_weibo_command_type", 1);
    localBundle.putString("_weibo_transaction", System.currentTimeMillis());
    localBundle.putAll(paramWeiboMultiMessage.writeToBundle(localBundle));
    paramWeiboMultiMessage = new Intent(localActivity, ShareTransActivity.class);
    paramWeiboMultiMessage.putExtra("start_flag", 0);
    paramWeiboMultiMessage.putExtras(localBundle);
    localActivity.startActivityForResult(paramWeiboMultiMessage, 10001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.share.f
 * JD-Core Version:    0.7.0.1
 */