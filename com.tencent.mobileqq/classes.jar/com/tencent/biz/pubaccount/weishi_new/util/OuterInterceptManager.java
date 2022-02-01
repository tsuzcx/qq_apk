package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stCallInfo;
import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class OuterInterceptManager
{
  public static void a(Activity paramActivity, OuterInterceptManager.OnInterceptDialogClickListener paramOnInterceptDialogClickListener)
  {
    stCallInfo localstCallInfo = WSGlobalConfig.a().a();
    if ((localstCallInfo != null) && (localstCallInfo.switch_call_live))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stGlobalConfig.callinfo: ");
      localStringBuilder.append(localstCallInfo);
      WSLog.e("OuterInterceptManager", localStringBuilder.toString());
      if (paramOnInterceptDialogClickListener != null) {
        paramOnInterceptDialogClickListener.b();
      }
      b(paramActivity, paramOnInterceptDialogClickListener);
      return;
    }
    if (paramOnInterceptDialogClickListener != null) {
      paramOnInterceptDialogClickListener.a();
    }
  }
  
  private static void b(Activity paramActivity, OuterInterceptManager.OnInterceptDialogClickListener paramOnInterceptDialogClickListener)
  {
    ThreadManager.getUIHandler().post(new OuterInterceptManager.1(paramActivity, paramOnInterceptDialogClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager
 * JD-Core Version:    0.7.0.1
 */