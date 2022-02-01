package com.bumptech.glide.manager;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

class RequestManagerRetriever$1
  implements RequestManagerRetriever.RequestManagerFactory
{
  @NonNull
  public RequestManager a(@NonNull Glide paramGlide, @NonNull Lifecycle paramLifecycle, @NonNull RequestManagerTreeNode paramRequestManagerTreeNode, @NonNull Context paramContext)
  {
    return new RequestManager(paramGlide, paramLifecycle, paramRequestManagerTreeNode, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.RequestManagerRetriever.1
 * JD-Core Version:    0.7.0.1
 */