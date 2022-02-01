package com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.kandian.ad.api.entity.IHomeWatcher;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReadInJoyAdHomeWatcher
  implements IHomeWatcher
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private OnHomePressedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherOnHomePressedListener;
  private ReadInJoyAdHomeWatcher.InnerRecevier jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher$InnerRecevier;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public ReadInJoyAdHomeWatcher(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher$InnerRecevier != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher$InnerRecevier, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
  }
  
  public void a(OnHomePressedListener paramOnHomePressedListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherOnHomePressedListener = paramOnHomePressedListener;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher$InnerRecevier = new ReadInJoyAdHomeWatcher.InnerRecevier(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher$InnerRecevier != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHome_watcherReadInJoyAdHomeWatcher$InnerRecevier);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher.ReadInJoyAdHomeWatcher
 * JD-Core Version:    0.7.0.1
 */