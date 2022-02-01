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
    if (paramRecentTabHaloPresenter.b()) {
      return;
    }
    if (paramRecentTabHaloEvent.a)
    {
      RecentTabHaloPresenter.a(paramRecentTabHaloPresenter);
      return;
    }
    if ((paramRecentTabHaloEvent.b() != null) && (!paramRecentTabHaloEvent.g.isFail()))
    {
      RecentTabHaloPresenter.a(paramRecentTabHaloPresenter);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRecentTabHaloPresenter = new StringBuilder();
      paramRecentTabHaloPresenter.append("onEvent: failed. Message: exception: ");
      paramRecentTabHaloPresenter.append(paramRecentTabHaloEvent.g);
      QLog.e("HaloResponseReceiver", 2, paramRecentTabHaloPresenter.toString());
    }
  }
  
  public Class acceptEventClass()
  {
    return RecentTabHaloBatchLoader.RecentTabHaloEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.HaloResponseReceiver
 * JD-Core Version:    0.7.0.1
 */