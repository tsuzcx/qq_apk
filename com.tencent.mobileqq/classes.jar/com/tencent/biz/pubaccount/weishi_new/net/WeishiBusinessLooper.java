package com.tencent.biz.pubaccount.weishi_new.net;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.statistic.Singleton;

@Deprecated
public class WeishiBusinessLooper
  implements Handler.Callback
{
  private static final Singleton<WeishiBusinessLooper, Void> b = new WeishiBusinessLooper.1();
  private static String c = null;
  public Handler a;
  
  public static WeishiBusinessLooper a()
  {
    return (WeishiBusinessLooper)b.get(null);
  }
  
  private static void c(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask != null) && (paramWeishiTask.g != null))
    {
      if (TextUtils.isEmpty(paramWeishiTask.g.i())) {
        return;
      }
      try
      {
        if (c == null) {
          c = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        localObject = paramWeishiTask.g.i();
        if ((c.contains((CharSequence)localObject)) && (paramWeishiTask.e != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cmd error report! cmd=");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" retCode=");
          localStringBuilder.append(paramWeishiTask.e);
          localStringBuilder.append(" msg=");
          localStringBuilder.append(paramWeishiTask.c);
          localStringBuilder.append(" duration=");
          localStringBuilder.append(System.currentTimeMillis() - paramWeishiTask.k);
          WSLog.d("WeishiBusinessLooper", localStringBuilder.toString());
          return;
        }
      }
      catch (Exception paramWeishiTask)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportRequest Exception:");
        ((StringBuilder)localObject).append(paramWeishiTask.getLocalizedMessage());
        WSLog.d("weishi-BusinessLooper", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(WeishiTask paramWeishiTask)
  {
    if (this.a == null) {
      this.a = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramWeishiTask;
    this.a.sendMessage(localMessage);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.a == null) {
      this.a = new Handler(Looper.getMainLooper(), this);
    }
    this.a.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (this.a == null) {
      this.a = new Handler(Looper.getMainLooper(), this);
    }
    this.a.postDelayed(paramRunnable, paramLong);
  }
  
  public void b(WeishiTask paramWeishiTask)
  {
    if (this.a == null) {
      this.a = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramWeishiTask;
    this.a.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    Handler localHandler = this.a;
    if (localHandler != null) {
      localHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      WSLog.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    int i = paramMessage.what;
    Object localObject = "mRequest is null";
    StringBuilder localStringBuilder;
    if (i != 0)
    {
      if (i == 1)
      {
        paramMessage = (WeishiTask)paramMessage.obj;
        if (paramMessage != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("completeTask resultCode:");
          localStringBuilder.append(paramMessage.e);
          localStringBuilder.append(", cmd=");
          if (paramMessage.g != null) {
            localObject = paramMessage.g.getCmdString();
          }
          localStringBuilder.append((String)localObject);
          WSLog.c("weishi-BusinessLooper", localStringBuilder.toString());
          if (paramMessage.b != null) {
            try
            {
              c(paramMessage);
              paramMessage.b.a(paramMessage);
            }
            catch (Exception paramMessage)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("handleMessage MSG_COMPLETE_TASK:");
              ((StringBuilder)localObject).append(paramMessage.getLocalizedMessage());
              WSLog.d("weishi-BusinessLooper", ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
    else
    {
      paramMessage = (WeishiTask)paramMessage.obj;
      if (paramMessage != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("runTask cmd=");
        if (paramMessage.g != null) {
          localObject = paramMessage.g.getCmdString();
        }
        localStringBuilder.append((String)localObject);
        WSLog.a("weishi-BusinessLooper", localStringBuilder.toString());
        paramMessage.a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper
 * JD-Core Version:    0.7.0.1
 */