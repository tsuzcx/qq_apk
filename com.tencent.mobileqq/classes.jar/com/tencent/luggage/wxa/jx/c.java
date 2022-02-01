package com.tencent.luggage.wxa.jx;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import java.util.Map;

public abstract interface c
{
  @Nullable
  public abstract <T extends com.tencent.luggage.wxa.ba.b> T a(Class<T> paramClass);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(ah paramah);
  
  public abstract void a(ah paramah, com.tencent.mm.plugin.appbrand.jsruntime.o paramo);
  
  public abstract void a(ah paramah, int[] paramArrayOfInt);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract boolean a(@Nullable k paramk);
  
  public abstract <T extends j> T b(Class<T> paramClass);
  
  @Nullable
  public abstract <T extends k> T c(@NonNull Class<T> paramClass);
  
  public abstract boolean d();
  
  public abstract boolean e();
  
  public abstract Map<String, m> g();
  
  public abstract String getAppId();
  
  public abstract com.tencent.luggage.wxa.ix.b getAppState();
  
  public abstract Handler getAsyncHandler();
  
  public abstract int getComponentId();
  
  public abstract Context getContext();
  
  @Nullable
  public abstract l getDialogContainer();
  
  @Nullable
  public abstract com.tencent.mm.plugin.appbrand.appstorage.o getFileSystem();
  
  public abstract i getJsRuntime();
  
  public abstract i h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.c
 * JD-Core Version:    0.7.0.1
 */