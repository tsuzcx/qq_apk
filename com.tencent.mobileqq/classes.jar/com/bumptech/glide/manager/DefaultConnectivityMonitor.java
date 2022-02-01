package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;

final class DefaultConnectivityMonitor
  implements ConnectivityMonitor
{
  final ConnectivityMonitor.ConnectivityListener a;
  boolean b;
  private final Context c;
  private boolean d;
  private final BroadcastReceiver e = new DefaultConnectivityMonitor.1(this);
  
  DefaultConnectivityMonitor(@NonNull Context paramContext, @NonNull ConnectivityMonitor.ConnectivityListener paramConnectivityListener)
  {
    this.c = paramContext.getApplicationContext();
    this.a = paramConnectivityListener;
  }
  
  private void a()
  {
    if (this.d) {
      return;
    }
    this.b = a(this.c);
    try
    {
      this.c.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      this.d = true;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      if (Log.isLoggable("ConnectivityMonitor", 5)) {
        Log.w("ConnectivityMonitor", "Failed to register", localSecurityException);
      }
    }
  }
  
  private void b()
  {
    if (!this.d) {
      return;
    }
    this.c.unregisterReceiver(this.e);
    this.d = false;
  }
  
  @SuppressLint({"MissingPermission"})
  boolean a(@NonNull Context paramContext)
  {
    paramContext = (ConnectivityManager)Preconditions.a((ConnectivityManager)paramContext.getSystemService("connectivity"));
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      return (paramContext != null) && (paramContext.isConnected());
    }
    catch (RuntimeException paramContext)
    {
      if (Log.isLoggable("ConnectivityMonitor", 5)) {
        Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", paramContext);
      }
    }
    return true;
  }
  
  public void c()
  {
    a();
  }
  
  public void d()
  {
    b();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.DefaultConnectivityMonitor
 * JD-Core Version:    0.7.0.1
 */