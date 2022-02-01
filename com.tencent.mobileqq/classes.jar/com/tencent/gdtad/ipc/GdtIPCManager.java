package com.tencent.gdtad.ipc;

import android.content.Context;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.gdtad.util.GdtManager;
import java.lang.ref.WeakReference;

public final class GdtIPCManager
{
  private static volatile GdtIPCManager a;
  
  public static GdtIPCManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GdtIPCManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Context paramContext)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(GdtManager.a().b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.ipc.GdtIPCManager
 * JD-Core Version:    0.7.0.1
 */