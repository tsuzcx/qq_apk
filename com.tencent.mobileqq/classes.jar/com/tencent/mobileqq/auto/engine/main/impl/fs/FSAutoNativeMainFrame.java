package com.tencent.mobileqq.auto.engine.main.impl.fs;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.auto.engine.main.IASBaseFrame;
import com.tencent.mobileqq.flashshow.api.IFlashShowServiceApi;
import com.tencent.mobileqq.flashshow.api.interfaces.IFlashShowController;
import com.tencent.mobileqq.qroute.QRoute;

public class FSAutoNativeMainFrame
  extends IASBaseFrame
{
  public Fragment a(View paramView)
  {
    return ((IFlashShowServiceApi)QRoute.api(IFlashShowServiceApi.class)).getFlashShowController().getFragmentInstance();
  }
  
  public void a()
  {
    ((IFlashShowServiceApi)QRoute.api(IFlashShowServiceApi.class)).getFlashShowController().onPageSelected();
  }
  
  public void a(boolean paramBoolean)
  {
    ((IFlashShowServiceApi)QRoute.api(IFlashShowServiceApi.class)).getFlashShowController().onAccountChange(paramBoolean);
  }
  
  public void b()
  {
    ((IFlashShowServiceApi)QRoute.api(IFlashShowServiceApi.class)).getFlashShowController().onPageUnSelected();
  }
  
  public void c()
  {
    ((IFlashShowServiceApi)QRoute.api(IFlashShowServiceApi.class)).getFlashShowController().onPageDestroy();
  }
  
  public boolean d()
  {
    return ((IFlashShowServiceApi)QRoute.api(IFlashShowServiceApi.class)).getFlashShowController().onBackPressed();
  }
  
  public void e()
  {
    ((IFlashShowServiceApi)QRoute.api(IFlashShowServiceApi.class)).getFlashShowController().onPageClickSelf();
  }
  
  public void f()
  {
    ((IFlashShowServiceApi)QRoute.api(IFlashShowServiceApi.class)).getFlashShowController().onPageDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.main.impl.fs.FSAutoNativeMainFrame
 * JD-Core Version:    0.7.0.1
 */