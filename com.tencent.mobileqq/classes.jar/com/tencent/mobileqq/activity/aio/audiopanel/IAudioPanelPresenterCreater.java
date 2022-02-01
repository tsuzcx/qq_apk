package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mvp.IBasePresenterView;

@QAPI(process={"all"})
public abstract interface IAudioPanelPresenterCreater
  extends QRouteApi
{
  public abstract ICircleProcessViewPresenter createCircleProcessViewPresenter(IBasePresenterView paramIBasePresenterView);
  
  public abstract ICommonRecordSoundPanelPresenter createCommonRecordSoundPanelPresenter(ICommonRecordSoundPanelView paramICommonRecordSoundPanelView);
  
  public abstract IThemeViewPresenter createThemeViewPresenter(IBasePresenterView paramIBasePresenterView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater
 * JD-Core Version:    0.7.0.1
 */