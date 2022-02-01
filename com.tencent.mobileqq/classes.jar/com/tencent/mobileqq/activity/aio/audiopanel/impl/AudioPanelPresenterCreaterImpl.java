package com.tencent.mobileqq.activity.aio.audiopanel.impl;

import com.tencent.mobileqq.activity.aio.audiopanel.CircleProcessViewPresenterImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.activity.aio.audiopanel.ICircleProcessViewPresenter;
import com.tencent.mobileqq.activity.aio.audiopanel.ICommonRecordSoundPanelPresenter;
import com.tencent.mobileqq.activity.aio.audiopanel.ICommonRecordSoundPanelView;
import com.tencent.mobileqq.activity.aio.audiopanel.IThemeViewPresenter;
import com.tencent.mobileqq.activity.aio.audiopanel.ThemeViewPrresenterImpl;
import com.tencent.mvp.IBasePresenterView;

public class AudioPanelPresenterCreaterImpl
  implements IAudioPanelPresenterCreater
{
  public ICircleProcessViewPresenter createCircleProcessViewPresenter(IBasePresenterView paramIBasePresenterView)
  {
    CircleProcessViewPresenterImpl localCircleProcessViewPresenterImpl = new CircleProcessViewPresenterImpl();
    localCircleProcessViewPresenterImpl.a(paramIBasePresenterView);
    return localCircleProcessViewPresenterImpl;
  }
  
  public ICommonRecordSoundPanelPresenter createCommonRecordSoundPanelPresenter(ICommonRecordSoundPanelView paramICommonRecordSoundPanelView)
  {
    CommonRecordSoundPanelPresenterImpl localCommonRecordSoundPanelPresenterImpl = new CommonRecordSoundPanelPresenterImpl();
    localCommonRecordSoundPanelPresenterImpl.a(paramICommonRecordSoundPanelView);
    return localCommonRecordSoundPanelPresenterImpl;
  }
  
  public IThemeViewPresenter createThemeViewPresenter(IBasePresenterView paramIBasePresenterView)
  {
    ThemeViewPrresenterImpl localThemeViewPrresenterImpl = new ThemeViewPrresenterImpl();
    localThemeViewPrresenterImpl.a(paramIBasePresenterView);
    return localThemeViewPrresenterImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.impl.AudioPanelPresenterCreaterImpl
 * JD-Core Version:    0.7.0.1
 */