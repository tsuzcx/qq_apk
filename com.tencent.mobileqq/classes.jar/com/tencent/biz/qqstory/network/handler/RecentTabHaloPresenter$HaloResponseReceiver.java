package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class RecentTabHaloPresenter$HaloResponseReceiver
  extends QQUIEventReceiver<RecentTabHaloPresenter, RecentTabHaloBatchLoader.RecentTabHaloEvent>
{
  public RecentTabHaloPresenter$HaloResponseReceiver(RecentTabHaloPresenter paramRecentTabHaloPresenter)
  {
    super(paramRecentTabHaloPresenter);
  }
  
  public void a(@NonNull RecentTabHaloPresenter paramRecentTabHaloPresenter, @NonNull RecentTabHaloBatchLoader.RecentTabHaloEvent paramRecentTabHaloEvent)
  {
    if (paramRecentTabHaloPresenter.a()) {
      return;
    }
    if (paramRecentTabHaloEvent.jdField_a_of_type_Boolean)
    {
      RecentTabHaloPresenter.a(paramRecentTabHaloPresenter);
      return;
    }
    if ((paramRecentTabHaloEvent.a() != null) && (!paramRecentTabHaloEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      RecentTabHaloPresenter.a(paramRecentTabHaloPresenter);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRecentTabHaloPresenter = new StringBuilder();
      paramRecentTabHaloPresenter.append("onEvent: failed. Message: exception: ");
      paramRecentTabHaloPresenter.append(paramRecentTabHaloEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
      QLog.e("HaloResponseReceiver", 2, paramRecentTabHaloPresenter.toString());
    }
  }
  
  public Class acceptEventClass()
  {
    return RecentTabHaloBatchLoader.RecentTabHaloEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.HaloResponseReceiver
 * JD-Core Version:    0.7.0.1
 */