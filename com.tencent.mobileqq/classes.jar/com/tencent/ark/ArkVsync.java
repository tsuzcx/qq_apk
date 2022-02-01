package com.tencent.ark;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

class ArkVsync
{
  protected static final ArkEnvironmentManager ENV = ;
  protected static final String TAG = "ArkApp.ArkVsync";
  private static final ArkVsync gInstance = new ArkVsync();
  protected ArkVsync.CallbackItem[] mCallbackArrays;
  protected ArrayList<ArkVsync.CallbackItem> mCallbacks = new ArrayList();
  protected ArkVsync.ArkVsyncImpl mImpl;
  
  private ArkVsync()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      this.mImpl = new ArkVsync.TimerVsync();
      return;
    }
    this.mImpl = new ArkVsync.SystemVsync();
  }
  
  public static ArkVsync getInstance()
  {
    return gInstance;
  }
  
  void addFrameCallback(String paramString, ArkVsync.ArkFrameCallback paramArkFrameCallback)
  {
    if ((paramArkFrameCallback == null) || (!ArkStateCenter.getInstance().isForeground()))
    {
      ENV.logE("ArkApp.ArkVsync", "add frame callback fail. callback:" + paramArkFrameCallback + ",isForeground:" + ArkStateCenter.getInstance().isForeground());
      return;
    }
    synchronized (this.mCallbacks)
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        ArkVsync.CallbackItem localCallbackItem = (ArkVsync.CallbackItem)localIterator.next();
        if (localCallbackItem.callback == paramArkFrameCallback) {
          this.mCallbacks.remove(localCallbackItem);
        }
      }
      this.mCallbacks.add(new ArkVsync.CallbackItem(paramString, paramArkFrameCallback));
      this.mCallbackArrays = null;
      if ((this.mCallbacks.size() == 1) && (this.mImpl != null)) {
        ArkDispatchTask.getInstance().postToArkThread(new ArkVsync.1(this, this));
      }
      return;
    }
  }
  
  void frameCallback()
  {
    for (;;)
    {
      int i;
      synchronized (this.mCallbacks)
      {
        if (this.mCallbacks.size() <= 0) {
          return;
        }
        if (this.mCallbackArrays == null) {
          this.mCallbackArrays = ((ArkVsync.CallbackItem[])this.mCallbacks.toArray(new ArkVsync.CallbackItem[this.mCallbacks.size()]));
        }
        ArkVsync.CallbackItem[] arrayOfCallbackItem = this.mCallbackArrays;
        int j = arrayOfCallbackItem.length;
        i = 0;
        if (i < j)
        {
          ArkVsync.CallbackItem localCallbackItem = arrayOfCallbackItem[i];
          if (localCallbackItem.isCallbacking) {
            break label122;
          }
          localCallbackItem.isCallbacking = true;
          ArkDispatchQueue.asyncRun(localCallbackItem.queueKey, new ArkVsync.3(this, localCallbackItem));
        }
      }
      return;
      label122:
      i += 1;
    }
  }
  
  void removeFrameCallback(ArkVsync.ArkFrameCallback paramArkFrameCallback)
  {
    if (paramArkFrameCallback == null) {
      return;
    }
    synchronized (this.mCallbacks)
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        ArkVsync.CallbackItem localCallbackItem = (ArkVsync.CallbackItem)localIterator.next();
        if (localCallbackItem.callback == paramArkFrameCallback)
        {
          localCallbackItem.callback = null;
          this.mCallbacks.remove(localCallbackItem);
        }
      }
      this.mCallbackArrays = null;
      if ((this.mCallbacks.size() == 0) && (this.mImpl != null)) {
        ArkDispatchTask.getInstance().postToArkThread(new ArkVsync.2(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkVsync
 * JD-Core Version:    0.7.0.1
 */