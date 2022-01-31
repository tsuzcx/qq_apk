package com.tencent.biz.pubaccount.readinjoy.magic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidAPs;
import com.tencent.biz.pubaccount.readinjoy.struct.MagicEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import ogy;
import ony;
import onz;
import ooa;
import ool;

public class ReadInJoyWatcher
  extends BroadcastReceiver
  implements onz
{
  private static ReadInJoyWatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcher = new ReadInJoyWatcher();
  private ony jdField_a_of_type_Ony;
  
  public static ReadInJoyWatcher a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcher;
  }
  
  private static boolean a()
  {
    return bgmq.m();
  }
  
  private void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      BaseApplicationImpl.getContext().registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyWatcher", 2, "registerScreenOffReceiver: ", localException);
    }
  }
  
  public void a()
  {
    QLog.d("ReadInJoyWatcher", 2, "stopWatching: ");
    if (this.jdField_a_of_type_Ony != null)
    {
      this.jdField_a_of_type_Ony.b();
      this.jdField_a_of_type_Ony = null;
      QLog.d("ReadInJoyWatcher", 2, "my watch has ended");
    }
  }
  
  public void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      QLog.d("ReadInJoyWatcher", 2, "startWatching: won't watch in android N");
      return;
    }
    if (!a())
    {
      QLog.d("ReadInJoyWatcher", 2, "startWatching: shouldn't watch");
      return;
    }
    ool.a();
    if (this.jdField_a_of_type_Ony != null)
    {
      QLog.d("ReadInJoyWatcher", 2, "startWatching: already watching");
      return;
    }
    if (ooa.a())
    {
      QLog.d("ReadInJoyWatcher", 2, "startWatching: won't watch cz configuration not ready");
      return;
    }
    PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
    if ((localPowerManager != null) && (!localPowerManager.isScreenOn()))
    {
      QLog.d("ReadInJoyWatcher", 2, "startWatching: won't watch when screen off");
      return;
    }
    QLog.d("ReadInJoyWatcher", 2, "startWatching");
    this.jdField_a_of_type_Ony = new ony(paramContext, this);
    this.jdField_a_of_type_Ony.a();
    b();
  }
  
  public void a(Set<AndroidAPs> paramSet)
  {
    long l = NetConnInfoCenter.getServerTime();
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        AndroidAPs localAndroidAPs = (AndroidAPs)paramSet.next();
        ogy.a().a(new MagicEvent(true, localAndroidAPs.a(), l));
      }
      ThreadManager.executeOnSubThread(new ReadInJoyWatcher.1(this));
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
    {
      QLog.d("ReadInJoyWatcher", 2, "ACTION_SCREEN_OFF STOP WATCHING");
      a();
    }
    while (!"android.intent.action.SCREEN_ON".equals(paramIntent.getAction())) {
      return;
    }
    QLog.d("ReadInJoyWatcher", 2, "ACTION_SCREEN_ON");
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.ReadInJoyWatcher
 * JD-Core Version:    0.7.0.1
 */