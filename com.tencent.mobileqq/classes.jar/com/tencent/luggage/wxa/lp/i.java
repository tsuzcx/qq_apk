package com.tencent.luggage.wxa.lp;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface i<PipVideoContainer extends View>
{
  @MainThread
  @NonNull
  public abstract PipVideoContainer a(@NonNull Context paramContext);
  
  @NonNull
  public abstract e a();
  
  public abstract void a(@NonNull PipVideoContainer paramPipVideoContainer);
  
  @MainThread
  public abstract void b(@NonNull PipVideoContainer paramPipVideoContainer);
  
  @MainThread
  public abstract void b(@NonNull PipVideoContainer paramPipVideoContainer, @Nullable Runnable paramRunnable);
  
  @MainThread
  public abstract void c(@NonNull PipVideoContainer paramPipVideoContainer, @Nullable Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lp.i
 * JD-Core Version:    0.7.0.1
 */