package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mvp.IBasePresenterView;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class ThemeViewPrresenterImpl
  implements IThemeViewPresenter
{
  private WeakReference<IBasePresenterView> a;
  
  public void a(IBasePresenterView paramIBasePresenterView)
  {
    this.a = new WeakReference(paramIBasePresenterView);
  }
  
  public boolean a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    return ThemeUtil.isNowThemeIsNight(paramAppRuntime, paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ThemeViewPrresenterImpl
 * JD-Core Version:    0.7.0.1
 */