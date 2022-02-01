package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.ILoaderSucessCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/base/AsyncDrawable$MyAsyncLoaderCallback;", "Lcom/tencent/android/gldrawable/api/ILoaderSucessCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/android/gldrawable/api/base/AsyncDrawable;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadSucceed", "", "api_release"}, k=1, mv={1, 1, 16})
final class AsyncDrawable$MyAsyncLoaderCallback
  implements ILoaderSucessCallback
{
  @NotNull
  private final WeakReference<AsyncDrawable> drawableRef;
  
  public AsyncDrawable$MyAsyncLoaderCallback(@NotNull WeakReference<AsyncDrawable> paramWeakReference)
  {
    this.drawableRef = paramWeakReference;
  }
  
  @NotNull
  public final WeakReference<AsyncDrawable> getDrawableRef()
  {
    return this.drawableRef;
  }
  
  public void onLoadSucceed()
  {
    AsyncDrawable localAsyncDrawable = (AsyncDrawable)this.drawableRef.get();
    if (localAsyncDrawable != null) {
      AsyncDrawable.access$getLoaderUtils$p(localAsyncDrawable).postSubTask((Function0)new AsyncDrawable.MyAsyncLoaderCallback.onLoadSucceed.1.1(localAsyncDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AsyncDrawable.MyAsyncLoaderCallback
 * JD-Core Version:    0.7.0.1
 */