package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.Destroyable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class RecentTabHaloPresenter
  implements Destroyable, IEventReceiver
{
  private RecentTabHaloPresenter.Callback jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$Callback;
  private RecentTabHaloPresenter.HaloResponseReceiver jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$HaloResponseReceiver;
  private RecentTabHaloPresenter.ReadStoryVideoEventReceiver jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$ReadStoryVideoEventReceiver;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public RecentTabHaloPresenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$HaloResponseReceiver = new RecentTabHaloPresenter.HaloResponseReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$ReadStoryVideoEventReceiver = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$HaloResponseReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$ReadStoryVideoEventReceiver);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$Callback);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$Callback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$Callback.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$HaloResponseReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$ReadStoryVideoEventReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$Callback = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(RecentTabHaloPresenter.Callback paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramCallback);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloPresenter$Callback = paramCallback;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter
 * JD-Core Version:    0.7.0.1
 */