package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

class SnackbarManager
{
  private static SnackbarManager a;
  @NonNull
  private final Object b = new Object();
  @NonNull
  private final Handler c = new Handler(Looper.getMainLooper(), new SnackbarManager.1(this));
  @Nullable
  private SnackbarManager.SnackbarRecord d;
  @Nullable
  private SnackbarManager.SnackbarRecord e;
  
  static SnackbarManager a()
  {
    if (a == null) {
      a = new SnackbarManager();
    }
    return a;
  }
  
  private boolean a(@NonNull SnackbarManager.SnackbarRecord paramSnackbarRecord, int paramInt)
  {
    SnackbarManager.Callback localCallback = (SnackbarManager.Callback)paramSnackbarRecord.a.get();
    if (localCallback != null)
    {
      this.c.removeCallbacksAndMessages(paramSnackbarRecord);
      localCallback.a(paramInt);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      this.d = ((SnackbarManager.SnackbarRecord)localObject);
      this.e = null;
      localObject = (SnackbarManager.Callback)this.d.a.get();
      if (localObject != null)
      {
        ((SnackbarManager.Callback)localObject).a();
        return;
      }
      this.d = null;
    }
  }
  
  private void b(@NonNull SnackbarManager.SnackbarRecord paramSnackbarRecord)
  {
    if (paramSnackbarRecord.b == -2) {
      return;
    }
    int i = 2750;
    if (paramSnackbarRecord.b > 0) {
      i = paramSnackbarRecord.b;
    } else if (paramSnackbarRecord.b == -1) {
      i = 1500;
    }
    this.c.removeCallbacksAndMessages(paramSnackbarRecord);
    Handler localHandler = this.c;
    localHandler.sendMessageDelayed(Message.obtain(localHandler, 0, paramSnackbarRecord), i);
  }
  
  private boolean f(SnackbarManager.Callback paramCallback)
  {
    SnackbarManager.SnackbarRecord localSnackbarRecord = this.d;
    return (localSnackbarRecord != null) && (localSnackbarRecord.a(paramCallback));
  }
  
  private boolean g(SnackbarManager.Callback paramCallback)
  {
    SnackbarManager.SnackbarRecord localSnackbarRecord = this.e;
    return (localSnackbarRecord != null) && (localSnackbarRecord.a(paramCallback));
  }
  
  public void a(SnackbarManager.Callback paramCallback)
  {
    synchronized (this.b)
    {
      if (f(paramCallback))
      {
        this.d = null;
        if (this.e != null) {
          b();
        }
      }
      return;
    }
  }
  
  public void a(SnackbarManager.Callback paramCallback, int paramInt)
  {
    synchronized (this.b)
    {
      if (f(paramCallback)) {
        a(this.d, paramInt);
      } else if (g(paramCallback)) {
        a(this.e, paramInt);
      }
      return;
    }
  }
  
  void a(@NonNull SnackbarManager.SnackbarRecord paramSnackbarRecord)
  {
    synchronized (this.b)
    {
      if ((this.d == paramSnackbarRecord) || (this.e == paramSnackbarRecord)) {
        a(paramSnackbarRecord, 2);
      }
      return;
    }
  }
  
  public void b(SnackbarManager.Callback paramCallback)
  {
    synchronized (this.b)
    {
      if (f(paramCallback)) {
        b(this.d);
      }
      return;
    }
  }
  
  public void c(SnackbarManager.Callback paramCallback)
  {
    synchronized (this.b)
    {
      if ((f(paramCallback)) && (!this.d.c))
      {
        this.d.c = true;
        this.c.removeCallbacksAndMessages(this.d);
      }
      return;
    }
  }
  
  public void d(SnackbarManager.Callback paramCallback)
  {
    synchronized (this.b)
    {
      if ((f(paramCallback)) && (this.d.c))
      {
        this.d.c = false;
        b(this.d);
      }
      return;
    }
  }
  
  public boolean e(SnackbarManager.Callback paramCallback)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (f(paramCallback)) {
          break label40;
        }
        if (g(paramCallback))
        {
          break label40;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label40:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.SnackbarManager
 * JD-Core Version:    0.7.0.1
 */