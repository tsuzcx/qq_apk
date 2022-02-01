package com.bumptech.glide.manager;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

public abstract interface RequestManagerRetriever$RequestManagerFactory
{
  @NonNull
  public abstract RequestManager a(@NonNull Glide paramGlide, @NonNull Lifecycle paramLifecycle, @NonNull RequestManagerTreeNode paramRequestManagerTreeNode, @NonNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
 * JD-Core Version:    0.7.0.1
 */