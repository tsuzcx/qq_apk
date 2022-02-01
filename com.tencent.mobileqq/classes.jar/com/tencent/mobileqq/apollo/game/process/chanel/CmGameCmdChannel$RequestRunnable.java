package com.tencent.mobileqq.apollo.game.process.chanel;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class CmGameCmdChannel$RequestRunnable
  implements Runnable
{
  private WeakReference<CmGameCmdChannel> a;
  private String b;
  private String c;
  private int d;
  private int e;
  
  CmGameCmdChannel$RequestRunnable(CmGameCmdChannel paramCmGameCmdChannel, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.a = new WeakReference(paramCmGameCmdChannel);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void run()
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    CmGameCmdChannel localCmGameCmdChannel = (CmGameCmdChannel)((WeakReference)???).get();
    if (localCmGameCmdChannel == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.b))
    {
      if (TextUtils.isEmpty(this.c)) {
        return;
      }
      synchronized (localCmGameCmdChannel.a)
      {
        Iterator localIterator = localCmGameCmdChannel.a.iterator();
        while (localIterator.hasNext())
        {
          HandleResult localHandleResult = ((CmGameCmdChannel.IRequestHandler)localIterator.next()).a(this.b, this.c, this.d, this.e);
          if (localHandleResult != null)
          {
            if (localHandleResult.b) {
              localIterator.remove();
            }
            if (localHandleResult.c) {
              localCmGameCmdChannel.a(0, this.b, localHandleResult.a, this.d);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel.RequestRunnable
 * JD-Core Version:    0.7.0.1
 */