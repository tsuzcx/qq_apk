package com.tencent.av.ui.funcall;

import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class FunCallUtil
{
  public static int a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        i = VipFunCallUtil.a(paramAppRuntime, paramString, 6, paramBoolean1, null);
      } else {
        i = VipFunCallUtil.a(paramAppRuntime, paramAppRuntime.getAccount(), 6, paramBoolean1, paramString);
      }
    }
    else {
      i = 0;
    }
    if (i != 0)
    {
      if (AudioHelper.b())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("getFunVideoId, 已经有默认配置, fcId[");
        paramAppRuntime.append(i);
        paramAppRuntime.append("]");
        QLog.w("QAVConfig_382", 1, paramAppRuntime.toString());
      }
      return i;
    }
    paramString = BusinessCommonConfig.getInstance(paramAppRuntime);
    if (paramString != null) {
      paramAppRuntime = (QAVFunCallHandler)paramString.getConfigHandler(382);
    } else {
      paramAppRuntime = new QAVFunCallHandler(paramAppRuntime.getAccount());
    }
    paramAppRuntime = paramAppRuntime.getConfigDirect();
    if (paramAppRuntime != null) {
      i = paramAppRuntime.getActivityFCId();
    }
    if (AudioHelper.b())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("getFunVideoId, fcId[");
      paramAppRuntime.append(i);
      paramAppRuntime.append("]");
      QLog.w("QAVConfig_382", 1, paramAppRuntime.toString());
    }
    return i;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.AnnimateDownloadStart");
    localIntent.setPackage(paramVideoAppInterface.getApp().getPackageName());
    localIntent.putExtra("callId", paramInt);
    paramVideoAppInterface.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funcall.FunCallUtil
 * JD-Core Version:    0.7.0.1
 */