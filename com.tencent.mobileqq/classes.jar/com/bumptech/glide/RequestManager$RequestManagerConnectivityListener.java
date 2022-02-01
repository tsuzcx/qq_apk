package com.bumptech.glide;

import android.support.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;
import com.bumptech.glide.manager.RequestTracker;

class RequestManager$RequestManagerConnectivityListener
  implements ConnectivityMonitor.ConnectivityListener
{
  private final RequestTracker a;
  
  RequestManager$RequestManagerConnectivityListener(@NonNull RequestTracker paramRequestTracker)
  {
    this.a = paramRequestTracker;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.RequestManager.RequestManagerConnectivityListener
 * JD-Core Version:    0.7.0.1
 */