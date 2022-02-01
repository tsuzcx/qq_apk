package com.tencent.mobileqq.app.compact;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.BuildConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class DFPluginOatService
  extends Service
{
  private void a()
  {
    QLog.i("plugin_tag", 1, "start oat plugins in oat process!");
    Iterator localIterator = BuildConfig.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QRoutePluginInfo localQRoutePluginInfo = QRoute.plugin(str).queryPluginInfo();
      if ((localQRoutePluginInfo != null) && (localQRoutePluginInfo.getState() == 4)) {
        LoadCompactDynamicFeature.a().b(str);
      }
    }
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    ThreadManager.getFileThreadHandler().post(new DFPluginOatService.1(this));
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.DFPluginOatService
 * JD-Core Version:    0.7.0.1
 */