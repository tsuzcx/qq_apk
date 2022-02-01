package com.tencent.biz.qqcircle.richframework.util.preloadview;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools.SynchronizedPool;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;

public class RFAsyncLayoutInflater
{
  LayoutInflater a;
  Handler b;
  private final int c;
  private Pools.SynchronizedPool<RFAsyncLayoutInflater.InflateRequest> d = new Pools.SynchronizedPool(10);
  private Handler.Callback e = new RFAsyncLayoutInflater.1(this);
  
  public RFAsyncLayoutInflater(@NonNull Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      this.a = ((Activity)paramContext).getLayoutInflater();
    } else {
      this.a = new RFAsyncLayoutInflater.BasicInflater(paramContext);
    }
    this.b = new Handler(this.e);
    this.c = paramContext.hashCode();
  }
  
  public RFAsyncLayoutInflater.InflateRequest a()
  {
    RFAsyncLayoutInflater.InflateRequest localInflateRequest2 = (RFAsyncLayoutInflater.InflateRequest)this.d.acquire();
    RFAsyncLayoutInflater.InflateRequest localInflateRequest1 = localInflateRequest2;
    if (localInflateRequest2 == null) {
      localInflateRequest1 = new RFAsyncLayoutInflater.InflateRequest();
    }
    return localInflateRequest1;
  }
  
  @UiThread
  public void a(@LayoutRes int paramInt, @Nullable ViewGroup paramViewGroup, @NonNull RFAsyncLayoutInflater.OnInflateFinishedListener paramOnInflateFinishedListener)
  {
    if (paramOnInflateFinishedListener != null)
    {
      RFAsyncLayoutInflater.InflateRequest localInflateRequest = a();
      localInflateRequest.a = this;
      localInflateRequest.c = paramInt;
      localInflateRequest.b = paramViewGroup;
      localInflateRequest.e = paramOnInflateFinishedListener;
      RFThreadManager.execute(new RFAsyncLayoutInflater.InflateRunnable(localInflateRequest));
      return;
    }
    throw new NullPointerException("callback argument may not be null!");
  }
  
  public void a(RFAsyncLayoutInflater.InflateRequest paramInflateRequest)
  {
    paramInflateRequest.e = null;
    paramInflateRequest.a = null;
    paramInflateRequest.b = null;
    paramInflateRequest.c = 0;
    paramInflateRequest.d = null;
    this.d.release(paramInflateRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.preloadview.RFAsyncLayoutInflater
 * JD-Core Version:    0.7.0.1
 */