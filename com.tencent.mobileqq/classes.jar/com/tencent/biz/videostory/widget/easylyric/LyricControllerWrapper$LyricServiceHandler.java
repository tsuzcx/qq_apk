package com.tencent.biz.videostory.widget.easylyric;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class LyricControllerWrapper$LyricServiceHandler
  extends Handler
{
  private WeakReference<LyricControllerWrapper> a;
  
  public LyricControllerWrapper$LyricServiceHandler(LyricControllerWrapper paramLyricControllerWrapper, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramLyricControllerWrapper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (LyricControllerWrapper localLyricControllerWrapper = (LyricControllerWrapper)this.a.get();; localLyricControllerWrapper = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof LyricControllerWrapper.CommonData)) {
          localObject1 = (LyricControllerWrapper.CommonData)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localLyricControllerWrapper != null) && (localObject1 != null))
        {
          ((LyricControllerWrapper)this.a.get()).d();
          continue;
          if ((localLyricControllerWrapper != null) && (localObject1 != null))
          {
            ((LyricControllerWrapper)this.a.get()).e();
            continue;
            if ((localLyricControllerWrapper != null) && (localObject1 != null))
            {
              ((LyricControllerWrapper)this.a.get()).c(((LyricControllerWrapper.CommonData)localObject1).a);
              continue;
              if ((localLyricControllerWrapper != null) && (localObject1 != null))
              {
                ((LyricControllerWrapper)this.a.get()).f();
                continue;
                if ((localLyricControllerWrapper != null) && (localObject1 != null)) {
                  ((LyricControllerWrapper)this.a.get()).b(((LyricControllerWrapper.CommonData)localObject1).a);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.LyricControllerWrapper.LyricServiceHandler
 * JD-Core Version:    0.7.0.1
 */