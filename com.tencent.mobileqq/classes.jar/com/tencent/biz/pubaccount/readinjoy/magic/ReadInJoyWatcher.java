package com.tencent.biz.pubaccount.readinjoy.magic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidAPs;
import com.tencent.biz.pubaccount.readinjoy.magic.utils.DebounceCallback;
import com.tencent.biz.pubaccount.readinjoy.magic.utils.Debouncer;
import com.tencent.biz.pubaccount.readinjoy.struct.MagicEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import lrl;
import lrn;

public class ReadInJoyWatcher
  extends BroadcastReceiver
  implements DebounceCallback, lrn
{
  private static ReadInJoyWatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcher = new ReadInJoyWatcher();
  private int jdField_a_of_type_Int;
  private ReadInJoyWatcherObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver;
  private AndroidAPs jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs;
  private Debouncer jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebouncer;
  
  public static ReadInJoyWatcher a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcher;
  }
  
  private void a(MagicEvent paramMagicEvent)
  {
    ReadInJoyLogicEngine.a().a(paramMagicEvent);
    QLog.d("ReadInJoyWatcher", 2, "addEventRecord: " + paramMagicEvent.toString());
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= 20)
    {
      this.jdField_a_of_type_Int = 0;
      ReadInJoyLogicEngine.a().p();
    }
  }
  
  private static boolean a()
  {
    return ReadInJoyHelper.i();
  }
  
  private void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver.stopWatching();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebouncer != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebouncer.a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver = null;
      QLog.d("ReadInJoyWatcher", 2, "stopWatching");
    }
  }
  
  public void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      QLog.d("ReadInJoyWatcher", 2, "startWatching: won't watch in android N");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver != null)
    {
      QLog.d("ReadInJoyWatcher", 2, "startWatching: already watching");
      return;
    }
    if (!a())
    {
      QLog.d("ReadInJoyWatcher", 2, "startWatching: shouldn't watch");
      return;
    }
    PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
    if ((localPowerManager != null) && (!localPowerManager.isScreenOn()))
    {
      QLog.d("ReadInJoyWatcher", 2, "startWatching: won't watch when screen off");
      return;
    }
    QLog.d("ReadInJoyWatcher", 2, "startWatching");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver = new ReadInJoyWatcherObserver(paramContext, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebouncer = new Debouncer(this, (int)ReadInJoyHelper.b());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver.startWatching();
    b();
  }
  
  public void a(AndroidAPs paramAndroidAPs)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (paramAndroidAPs != null) {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs.b != paramAndroidAPs.b))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs != null) {
          a(new MagicEvent(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs.a(), l));
        }
        a(new MagicEvent(true, paramAndroidAPs.a(), l));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs = paramAndroidAPs;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebouncer.a(paramAndroidAPs);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs == null) {
      return;
    }
    a(new MagicEvent(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs.a(), l));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs = null;
  }
  
  public void b(AndroidAPs paramAndroidAPs)
  {
    ReadInJoyLogicEngine.a().p();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
      ThreadManager.executeOnSubThread(new lrl(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.ReadInJoyWatcher
 * JD-Core Version:    0.7.0.1
 */