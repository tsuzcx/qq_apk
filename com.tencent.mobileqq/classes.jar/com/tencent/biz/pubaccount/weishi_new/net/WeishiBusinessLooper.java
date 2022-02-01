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
  private static final Singleton<WeishiBusinessLooper, Void> jdField_a_of_type_CooperationQzoneStatisticSingleton = new WeishiBusinessLooper.1();
  private static String jdField_a_of_type_JavaLangString = null;
  public Handler a;
  
  public static WeishiBusinessLooper a()
  {
    return (WeishiBusinessLooper)jdField_a_of_type_CooperationQzoneStatisticSingleton.get(null);
  }
  
  private static void c(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask != null) && (paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest != null))
    {
      if (TextUtils.isEmpty(paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.d())) {
        return;
      }
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        localObject = paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.d();
        if ((jdField_a_of_type_JavaLangString.contains((CharSequence)localObject)) && (paramWeishiTask.b != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cmd error report! cmd=");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" retCode=");
          localStringBuilder.append(paramWeishiTask.b);
          localStringBuilder.append(" msg=");
          localStringBuilder.append(paramWeishiTask.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(" duration=");
          localStringBuilder.append(System.currentTimeMillis() - paramWeishiTask.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramWeishiTask;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void b(WeishiTask paramWeishiTask)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramWeishiTask;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
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
          localStringBuilder.append(paramMessage.b);
          localStringBuilder.append(", cmd=");
          if (paramMessage.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest != null) {
            localObject = paramMessage.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.getCmdString();
          }
          localStringBuilder.append((String)localObject);
          WSLog.c("weishi-BusinessLooper", localStringBuilder.toString());
          if (paramMessage.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiServiceListener != null) {
            try
            {
              c(paramMessage);
              paramMessage.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiServiceListener.a(paramMessage);
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
        if (paramMessage.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest != null) {
          localObject = paramMessage.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.getCmdString();
        }
        localStringBuilder.append((String)localObject);
        WSLog.a("weishi-BusinessLooper", localStringBuilder.toString());
        paramMessage.a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper
 * JD-Core Version:    0.7.0.1
 */