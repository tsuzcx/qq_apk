package com.tencent.biz.pubaccount.weishi_new.presenter;

import android.support.annotation.UiThread;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.IWSBaseView;
import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import java.lang.ref.WeakReference;

public class WSBasePresenter<V extends IWSBaseView>
  implements IWSPresenter<V>
{
  private boolean presenterDestroyed = false;
  private WeakReference<V> viewRef;
  
  @UiThread
  public void attachView(V paramV)
  {
    this.viewRef = new WeakReference(paramV);
    this.presenterDestroyed = false;
  }
  
  public void destroy()
  {
    this.presenterDestroyed = true;
  }
  
  public void detachView()
  {
    WeakReference localWeakReference = this.viewRef;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      this.viewRef = null;
    }
  }
  
  @UiThread
  @Nullable
  public V getView()
  {
    WeakReference localWeakReference = this.viewRef;
    if (localWeakReference == null) {
      return null;
    }
    return (IWSBaseView)localWeakReference.get();
  }
  
  @UiThread
  public boolean isViewAttached()
  {
    WeakReference localWeakReference = this.viewRef;
    return (localWeakReference != null) && (localWeakReference.get() != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter
 * JD-Core Version:    0.7.0.1
 */