package com.bumptech.glide.manager;

import android.content.Context;
import android.support.annotation.NonNull;

public abstract interface ConnectivityMonitorFactory
{
  @NonNull
  public abstract ConnectivityMonitor a(@NonNull Context paramContext, @NonNull ConnectivityMonitor.ConnectivityListener paramConnectivityListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.ConnectivityMonitorFactory
 * JD-Core Version:    0.7.0.1
 */