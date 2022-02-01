package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.ptt.temp.api.IAudioPanelTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvp.IBasePresenterView;
import mqq.util.WeakReference;

public class CircleProcessViewPresenterImpl
  implements ICircleProcessViewPresenter
{
  private WeakReference<IBasePresenterView> a;
  
  public void a(IBasePresenterView paramIBasePresenterView)
  {
    this.a = new WeakReference(paramIBasePresenterView);
  }
  
  public void a(String paramString, IBasePresenterView paramIBasePresenterView, Object paramObject)
  {
    if ((paramString.equalsIgnoreCase("startPlayAnim")) && (paramIBasePresenterView != null) && ((paramIBasePresenterView instanceof CircleProgressView))) {
      ((IAudioPanelTempApi)QRoute.api(IAudioPanelTempApi.class)).ListenPanel_startPlayAnimByType_RecordStopToPlayType((CircleProgressView)paramIBasePresenterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CircleProcessViewPresenterImpl
 * JD-Core Version:    0.7.0.1
 */