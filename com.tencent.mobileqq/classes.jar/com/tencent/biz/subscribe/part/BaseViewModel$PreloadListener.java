package com.tencent.biz.subscribe.part;

import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import java.lang.ref.WeakReference;

public class BaseViewModel$PreloadListener
  implements OnTaskListener
{
  private WeakReference<BaseViewModel> a;
  
  public void onComplete(Object[] paramArrayOfObject)
  {
    if (this.a != null)
    {
      BaseViewModel localBaseViewModel = (BaseViewModel)this.a.get();
      if (localBaseViewModel != null) {
        localBaseViewModel.a(paramArrayOfObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.BaseViewModel.PreloadListener
 * JD-Core Version:    0.7.0.1
 */