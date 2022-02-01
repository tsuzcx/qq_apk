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
    Object localObject1 = this.a.get();
    Object localObject3 = null;
    if (localObject1 != null) {
      localObject1 = (LyricControllerWrapper)this.a.get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject3;
    if (paramMessage.obj != null)
    {
      localObject2 = localObject3;
      if ((paramMessage.obj instanceof LyricControllerWrapper.CommonData)) {
        localObject2 = (LyricControllerWrapper.CommonData)paramMessage.obj;
      }
    }
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 5)
        {
          if (i != 6)
          {
            if ((i == 7) && (localObject1 != null) && (localObject2 != null)) {
              ((LyricControllerWrapper)this.a.get()).b(((LyricControllerWrapper.CommonData)localObject2).a);
            }
          }
          else if ((localObject1 != null) && (localObject2 != null)) {
            ((LyricControllerWrapper)this.a.get()).c(((LyricControllerWrapper.CommonData)localObject2).a);
          }
        }
        else if ((localObject1 != null) && (localObject2 != null)) {
          ((LyricControllerWrapper)this.a.get()).f();
        }
      }
      else if ((localObject1 != null) && (localObject2 != null)) {
        ((LyricControllerWrapper)this.a.get()).e();
      }
    }
    else if ((localObject1 != null) && (localObject2 != null)) {
      ((LyricControllerWrapper)this.a.get()).d();
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.LyricControllerWrapper.LyricServiceHandler
 * JD-Core Version:    0.7.0.1
 */