package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import com.tencent.android.gldrawable.api.ILoaderCallback;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/android/gldrawable/api/base/InternalApiImpl$realLoadApk$callback$1", "Lcom/tencent/android/gldrawable/api/ILoaderCallback;", "onLoadFailed", "", "onLoadSucceed", "api_release"}, k=1, mv={1, 1, 16})
public final class InternalApiImpl$realLoadApk$callback$1
  implements ILoaderCallback
{
  public void onLoadFailed() {}
  
  public void onLoadSucceed()
  {
    if (!this.this$0.getLoader().isLoaded()) {
      return;
    }
    try
    {
      if (!this.this$0.isDynamicReady()) {
        this.this$0.setDynamicReady(this.this$0.getLoader().getClassLoader());
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.InternalApiImpl.realLoadApk.callback.1
 * JD-Core Version:    0.7.0.1
 */