package com.tencent.comic;

import android.content.Context;
import android.content.Intent;
import com.tencent.comic.data.VipComicDataHelper;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class VipProxyPreLoadComicProcess
  extends PluginProxyBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "onReceive start");
    }
    super.onReceive(paramContext, paramIntent);
    try
    {
      if (paramIntent.getBooleanExtra("isPreloadProcess", false))
      {
        VipComicDataHelper.n.set(2);
        int i = paramIntent.getIntExtra("preloadEntry", 0);
        VipComicDataHelper.o.set(i);
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("QQComicDebug", 1, paramContext, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "onReceive end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipProxyPreLoadComicProcess
 * JD-Core Version:    0.7.0.1
 */