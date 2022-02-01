package com.tencent.av.wtogether.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerStatusCallback;
import com.tencent.av.wtogether.data.WTVideoInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class WatchTogetherMediaPlayCtrl$CustomHandler
  extends Handler
{
  public WatchTogetherMediaPlayCtrl$CustomHandler(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 265)
    {
      Object localObject;
      if (i != 289)
      {
        boolean bool = false;
        switch (i)
        {
        default: 
          return;
        case 261: 
          if (WatchTogetherMediaPlayCtrl.d(this.a) == null) {
            return;
          }
          WatchTogetherMediaPlayCtrl.p(this.a);
          return;
        case 260: 
          if (WatchTogetherMediaPlayCtrl.d(this.a) != null)
          {
            if ((WatchTogetherMediaPlayCtrl.n(this.a) != null) && (WatchTogetherMediaPlayCtrl.n(this.a).a())) {
              return;
            }
            i = ((Integer)paramMessage.obj).intValue();
            WatchTogetherMediaPlayCtrl.d(this.a).seekTo(i, 3);
            if (paramMessage.arg1 == 1) {
              return;
            }
            WatchTogetherMediaPlayCtrl.a(this.a, false);
            paramMessage = WatchTogetherMediaPlayCtrl.e(this.a).iterator();
            while (paramMessage.hasNext())
            {
              localObject = (WeakReference)paramMessage.next();
              if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
                ((WatchTogetherMediaPlayerStatusCallback)((WeakReference)localObject).get()).a(i, (int)WatchTogetherMediaPlayCtrl.d(this.a).getDurationMs());
              }
            }
          }
          return;
        case 259: 
          if (WatchTogetherMediaPlayCtrl.d(this.a) != null)
          {
            if (WatchTogetherMediaPlayCtrl.o(this.a) == 7) {
              return;
            }
            WatchTogetherMediaPlayCtrl.d(this.a).pause();
            WatchTogetherMediaPlayCtrl.a(this.a, 7);
            paramMessage = WatchTogetherMediaPlayCtrl.e(this.a).iterator();
            while (paramMessage.hasNext())
            {
              localObject = (WeakReference)paramMessage.next();
              if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
                ((WatchTogetherMediaPlayerStatusCallback)((WeakReference)localObject).get()).d();
              }
            }
          }
          return;
        case 258: 
          if (WatchTogetherMediaPlayCtrl.d(this.a) == null) {
            return;
          }
          WatchTogetherMediaPlayCtrl.d(this.a).start();
          WatchTogetherMediaPlayCtrl.a(this.a, 5);
          paramMessage = WatchTogetherMediaPlayCtrl.e(this.a).iterator();
          while (paramMessage.hasNext())
          {
            localObject = (WeakReference)paramMessage.next();
            if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
              ((WatchTogetherMediaPlayerStatusCallback)((WeakReference)localObject).get()).e();
            }
          }
        case 257: 
          WatchTogetherMediaPlayCtrl.a(this.a, 1.0F);
          WatchTogetherMediaPlayCtrl.b(this.a, false);
          if (paramMessage.arg2 == 1) {
            bool = true;
          }
          i = paramMessage.arg1;
          WatchTogetherMediaPlayCtrl.a(this.a, 4);
          WatchTogetherMediaPlayCtrl.a(this.a, i, bool);
          if (bool) {
            return;
          }
          paramMessage = (String)paramMessage.obj;
          localObject = WatchTogetherMediaPlayCtrl.e(this.a).iterator();
          while (((Iterator)localObject).hasNext())
          {
            WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((WatchTogetherMediaPlayerStatusCallback)localWeakReference.get()).a(paramMessage);
            }
          }
        }
        WatchTogetherMediaPlayCtrl.a(this.a, 1);
        return;
      }
      float f = ((Float)paramMessage.obj).floatValue();
      WatchTogetherMediaPlayCtrl.a(this.a, f);
      if (WatchTogetherMediaPlayCtrl.d(this.a) == null) {
        return;
      }
      WatchTogetherMediaPlayCtrl.d(this.a).setPlaySpeedRatio(f);
      paramMessage = WatchTogetherMediaPlayCtrl.e(this.a).iterator();
      while (paramMessage.hasNext())
      {
        localObject = (WeakReference)paramMessage.next();
        if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
          ((WatchTogetherMediaPlayerStatusCallback)((WeakReference)localObject).get()).a(WatchTogetherMediaPlayCtrl.q(this.a));
        }
      }
    }
    WatchTogetherMediaPlayCtrl.r(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.CustomHandler
 * JD-Core Version:    0.7.0.1
 */