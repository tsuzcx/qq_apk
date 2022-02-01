package com.tencent.mobileqq.bigbrother;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class TeleScreenObserver
  implements BusinessObserver
{
  private static TeleScreenObserver c;
  private int a;
  private final SparseArray<TeleScreenListenerWrapper> b = new SparseArray();
  
  public static TeleScreenObserver a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new TeleScreenObserver();
        }
      }
      finally {}
    }
    return c;
  }
  
  public int a(Context paramContext, DownloadListener paramDownloadListener)
  {
    return a(new TeleScreenListenerWrapper(paramContext, paramDownloadListener));
  }
  
  public int a(Context paramContext, JumpListener paramJumpListener)
  {
    return a(new TeleScreenListenerWrapper(paramContext, paramJumpListener));
  }
  
  public int a(TeleScreenListenerWrapper paramTeleScreenListenerWrapper)
  {
    synchronized (this.b)
    {
      SparseArray localSparseArray2 = this.b;
      int i = this.a + 1;
      this.a = i;
      localSparseArray2.append(i, paramTeleScreenListenerWrapper);
      i = this.a;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    TeleScreenListenerWrapper localTeleScreenListenerWrapper = (TeleScreenListenerWrapper)this.b.get(i);
    if (paramInt != 3)
    {
      if (paramInt == 4) {
        localTeleScreenListenerWrapper.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
      }
    }
    else {
      localTeleScreenListenerWrapper.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
    }
    this.b.delete(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.TeleScreenObserver
 * JD-Core Version:    0.7.0.1
 */