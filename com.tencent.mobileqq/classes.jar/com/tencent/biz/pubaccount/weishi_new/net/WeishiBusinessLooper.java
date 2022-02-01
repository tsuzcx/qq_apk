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
    if ((paramWeishiTask == null) || (paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest == null) || (TextUtils.isEmpty(paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.d()))) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.d();
        if ((jdField_a_of_type_JavaLangString.contains(str)) && (paramWeishiTask.b != 0))
        {
          WSLog.d("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramWeishiTask.b + " msg=" + paramWeishiTask.jdField_a_of_type_JavaLangString + " duration=" + (System.currentTimeMillis() - paramWeishiTask.jdField_a_of_type_Long));
          return;
        }
      }
      catch (Exception paramWeishiTask)
      {
        WSLog.d("weishi-BusinessLooper", "reportRequest Exception:" + paramWeishiTask.getLocalizedMessage());
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
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      WSLog.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    WeishiTask localWeishiTask;
    do
    {
      do
      {
        return false;
        localWeishiTask = (WeishiTask)paramMessage.obj;
      } while (localWeishiTask == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest != null) {}
      for (paramMessage = localWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.getCmdString();; paramMessage = "mRequest is null")
      {
        WSLog.a("weishi-BusinessLooper", paramMessage);
        localWeishiTask.a();
        break;
      }
      localWeishiTask = (WeishiTask)paramMessage.obj;
    } while (localWeishiTask == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localWeishiTask.b).append(", cmd=");
    if (localWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest != null) {}
    for (paramMessage = localWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        WSLog.c("weishi-BusinessLooper", paramMessage);
        if (localWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiServiceListener == null) {
          break;
        }
        try
        {
          c(localWeishiTask);
          localWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiServiceListener.a(localWeishiTask);
        }
        catch (Exception paramMessage)
        {
          WSLog.d("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper
 * JD-Core Version:    0.7.0.1
 */