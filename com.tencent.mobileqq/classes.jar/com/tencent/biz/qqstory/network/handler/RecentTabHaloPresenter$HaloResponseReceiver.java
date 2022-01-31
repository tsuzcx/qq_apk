package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class RecentTabHaloPresenter$HaloResponseReceiver
  extends QQUIEventReceiver
{
  public RecentTabHaloPresenter$HaloResponseReceiver(RecentTabHaloPresenter paramRecentTabHaloPresenter)
  {
    super(paramRecentTabHaloPresenter);
  }
  
  public void a(@NonNull RecentTabHaloPresenter paramRecentTabHaloPresenter, @NonNull RecentTabHaloBatchLoader.RecentTabHaloEvent paramRecentTabHaloEvent)
  {
    if (paramRecentTabHaloPresenter.a()) {}
    do
    {
      return;
      if (paramRecentTabHaloEvent.a)
      {
        RecentTabHaloPresenter.a(paramRecentTabHaloPresenter);
        return;
      }
      if ((paramRecentTabHaloEvent.a() != null) && (!paramRecentTabHaloEvent.errorInfo.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramRecentTabHaloEvent.errorInfo);
    return;
    RecentTabHaloPresenter.a(paramRecentTabHaloPresenter);
  }
  
  public Class acceptEventClass()
  {
    return RecentTabHaloBatchLoader.RecentTabHaloEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.HaloResponseReceiver
 * JD-Core Version:    0.7.0.1
 */