package com.tencent.biz.subscribe.part;

import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import java.lang.ref.WeakReference;

public class BaseViewModel$PreloadListener
  implements OnTaskListener
{
  private WeakReference<BaseViewModel> a;
  
  public void onComplete(Object[] paramArrayOfObject)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (BaseViewModel)((WeakReference)localObject).get();
      if (localObject != null) {
        ((BaseViewModel)localObject).a(paramArrayOfObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.BaseViewModel.PreloadListener
 * JD-Core Version:    0.7.0.1
 */