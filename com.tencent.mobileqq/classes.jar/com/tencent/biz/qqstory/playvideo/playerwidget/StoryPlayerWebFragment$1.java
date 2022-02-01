package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.widget.QQToast;

class StoryPlayerWebFragment$1
  extends BroadcastReceiver
{
  StoryPlayerWebFragment$1(StoryPlayerWebFragment paramStoryPlayerWebFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    SLog.a("StoryPlayerWebFragment", "onReceive() Action: %s", paramIntent.getAction());
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("event");
      SLog.a("StoryPlayerWebFragment", "onReceive() Event: %s", paramContext);
      if ("closeMeEvent".equals(paramContext))
      {
        if (this.a.a != null) {
          this.a.a.a();
        }
      }
      else if ("readyEvent".equals(paramContext))
      {
        if (this.a.a != null) {
          this.a.a.b();
        }
      }
      else
      {
        paramIntent = this.a.getQBaseActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unknown event: ");
        localStringBuilder.append(paramContext);
        QQToast.makeText(paramIntent, 1, localStringBuilder.toString(), 1).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment.1
 * JD-Core Version:    0.7.0.1
 */