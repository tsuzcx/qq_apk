package com.tencent.av.wtogether.api.impl;

import android.content.Context;
import com.tencent.av.wtogether.api.IUIProxy;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.view.WatchTogetherAdminControlView;
import com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView;

public class UIProxyImpl
  implements IUIProxy
{
  public WatchTogetherUIProxy getAdminControlView(Context paramContext)
  {
    return new WatchTogetherAdminControlView(paramContext);
  }
  
  public WatchTogetherUIProxy getOrdinaryControlView(Context paramContext)
  {
    return new WatchTogetherOrdinaryControlView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.api.impl.UIProxyImpl
 * JD-Core Version:    0.7.0.1
 */