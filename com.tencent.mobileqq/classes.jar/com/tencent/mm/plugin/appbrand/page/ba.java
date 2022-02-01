package com.tencent.mm.plugin.appbrand.page;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.dt.a;

public abstract interface ba
  extends a, am
{
  @UiThread
  public abstract void a(@NonNull ba.a parama);
  
  @UiThread
  public abstract void a(@NonNull String paramString, @Nullable ValueCallback<String> paramValueCallback);
  
  @UiThread
  public abstract void b(@NonNull Runnable paramRunnable);
  
  public abstract boolean h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract boolean k();
  
  public abstract boolean z_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ba
 * JD-Core Version:    0.7.0.1
 */