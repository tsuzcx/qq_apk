package com.tencent.biz.qqstory.channel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.NewIntent;

class QQStoryCmdHandler$4
  extends SimpleJob
{
  QQStoryCmdHandler$4(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, NetworkRequest paramNetworkRequest)
  {
    super(paramString);
  }
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    try
    {
      paramJobContext = this.a.c();
      paramArrayOfObject = Integer.valueOf(QQStoryCmdHandler.a(this.b).getAndIncrement());
      AppInterface localAppInterface = QQStoryContext.k();
      NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), StoryMsfServlet.class);
      localNewIntent.putExtra("storySeq", paramArrayOfObject);
      localNewIntent.putExtra("cmd", this.a.a());
      localNewIntent.putExtra("data", paramJobContext);
      localNewIntent.putExtra("start_time", System.currentTimeMillis());
      if (this.b.a.contains(Integer.valueOf(this.a.e())))
      {
        localNewIntent.putExtra("timeout", 10000L);
        localNewIntent.putExtra("support_retry", true);
      }
      else if (this.a.b > 0L)
      {
        localNewIntent.putExtra("timeout", this.a.b);
      }
      QQStoryCmdHandler.b(this.b).put(paramArrayOfObject, this.a);
      localAppInterface.startServlet(localNewIntent);
      return null;
    }
    catch (QQStoryCmdHandler.IllegalUinException paramJobContext)
    {
      Bosses.get().scheduleJobDelayed(new QQStoryCmdHandler.4.1(this, "Q.qqstory.net:QQStoryCmdHandler", paramJobContext), 100);
    }
    return null;
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler.4
 * JD-Core Version:    0.7.0.1
 */