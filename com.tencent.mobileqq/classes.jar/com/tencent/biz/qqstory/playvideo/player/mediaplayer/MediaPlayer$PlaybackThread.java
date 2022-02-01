package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;

class MediaPlayer$PlaybackThread
  extends HandlerThread
  implements Handler.Callback
{
  private Handler a;
  private boolean b = true;
  private boolean c = false;
  private MediaCodecDecoder.FrameInfo d;
  private boolean e;
  private boolean f;
  private double g;
  private boolean h;
  
  public MediaPlayer$PlaybackThread(MediaPlayer paramMediaPlayer)
  {
    super(localStringBuilder.toString(), -16);
    this.e = MediaPlayer.VideoRenderTimingMode.a(paramMediaPlayer.O);
    this.f = true;
    this.h = false;
  }
  
  private void a(long paramLong)
  {
    if (this.d != null)
    {
      this.this$0.K.b().a(this.d);
      this.d = null;
    }
    if (this.this$0.J != null) {
      this.this$0.J.a(true);
    }
    this.this$0.K.a(this.this$0.a, paramLong);
    this.this$0.u.a(this.this$0.K.f());
    boolean bool = this.a.hasMessages(4);
    if (bool) {
      this.this$0.K.e();
    } else {
      this.this$0.K.d();
    }
    if (!bool)
    {
      MediaPlayer localMediaPlayer = this.this$0;
      localMediaPlayer.q = localMediaPlayer.K.f();
      localMediaPlayer = this.this$0;
      localMediaPlayer.s = false;
      this.h = false;
      localMediaPlayer.w.sendEmptyMessage(4);
      if (!this.b) {
        c();
      }
    }
  }
  
  private void a(MediaCodecDecoder.FrameInfo paramFrameInfo)
  {
    if (paramFrameInfo.d)
    {
      this.this$0.K.b().a(paramFrameInfo);
      return;
    }
    long l = this.this$0.u.b(paramFrameInfo.c);
    if (l < -1000L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LAGGING ");
      localStringBuilder.append(l);
      Log.d("Story-MediaPlayer", localStringBuilder.toString());
      this.this$0.w.sendMessage(this.this$0.w.obtainMessage(200, 700, 0));
    }
    if (paramFrameInfo.e) {
      if (this.this$0.M) {
        this.this$0.w.sendMessage(this.this$0.w.obtainMessage(5, this.this$0.K.b().p(), this.this$0.K.b().o()));
      } else {
        this.this$0.w.sendMessage(this.this$0.w.obtainMessage(5, this.this$0.K.b().o(), this.this$0.K.b().p()));
      }
    }
    if ((!this.e) && (l > 5000L)) {
      Thread.sleep(l / 1000L);
    }
    this.this$0.K.b().a(paramFrameInfo, l);
  }
  
  private void a(boolean paramBoolean)
  {
    this.a.removeMessages(3);
    if (this.this$0.J != null)
    {
      if (paramBoolean)
      {
        this.a.sendEmptyMessageDelayed(6, (this.this$0.J.h() + this.this$0.J.i()) / 1000L + 1L);
        return;
      }
      this.this$0.J.a(false);
    }
  }
  
  private void b()
  {
    if (!isAlive()) {
      return;
    }
    this.b = true;
    synchronized (this.this$0.Q)
    {
      this.c = true;
      boolean bool = this.a.sendEmptyMessage(5);
      if (bool) {
        try
        {
          this.this$0.Q.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("Story-MediaPlayer", "wait lock interrupted", localInterruptedException);
        }
      }
      Log.d("Story-MediaPlayer", "PlaybackThread released");
      return;
    }
  }
  
  private void b(Surface paramSurface)
  {
    if ((this.this$0.K != null) && (this.this$0.K.b() != null))
    {
      if (this.d != null)
      {
        this.this$0.K.b().a(this.d);
        this.d = null;
      }
      this.this$0.K.b().a(paramSurface);
    }
  }
  
  private void c()
  {
    if (this.this$0.K.g())
    {
      MediaPlayer localMediaPlayer = this.this$0;
      localMediaPlayer.q = 0L;
      localMediaPlayer.K.a(MediaPlayer.SeekMode.a(0), 0L);
    }
    this.this$0.u.a(this.this$0.K.f());
    if (this.this$0.J != null)
    {
      this.a.removeMessages(6);
      this.this$0.J.d();
    }
    this.g = this.this$0.u.c();
    if (this.this$0.J != null) {
      this.this$0.J.a((float)this.g);
    }
    this.a.removeMessages(3);
    f();
  }
  
  private void d()
  {
    a(false);
  }
  
  private void e()
  {
    if (this.this$0.J != null) {
      this.this$0.J.e();
    }
  }
  
  private void f()
  {
    long l1 = this.this$0.K.h();
    double d1;
    double d2;
    if (l1 != -1L)
    {
      localObject = this.this$0.w;
      MediaPlayer.EventHandler localEventHandler = this.this$0.w;
      d1 = this.this$0.j() * 1000;
      Double.isNaN(d1);
      d1 = 100.0D / d1;
      d2 = this.this$0.q + l1;
      Double.isNaN(d2);
      ((MediaPlayer.EventHandler)localObject).sendMessage(localEventHandler.obtainMessage(3, (int)(d1 * d2), 0));
    }
    if ((this.this$0.L) && (l1 > -1L) && (l1 < 2000000L) && (!this.this$0.K.i()))
    {
      this.a.sendEmptyMessageDelayed(3, 100L);
      return;
    }
    if ((this.this$0.K.b() != null) && (this.d == null))
    {
      this.d = this.this$0.K.a(false);
      if ((this.d == null) && (!this.this$0.K.g()))
      {
        this.a.sendEmptyMessageDelayed(3, 10L);
        return;
      }
    }
    l1 = SystemClock.elapsedRealtime();
    if (this.this$0.L)
    {
      localObject = this.this$0;
      ((MediaPlayer)localObject).L = false;
      ((MediaPlayer)localObject).w.sendMessage(this.this$0.w.obtainMessage(200, 702, 0));
      this.this$0.u.a(this.this$0.K.f());
    }
    if ((this.d != null) && (this.this$0.u.b(this.d.c) > 60000L))
    {
      this.a.sendEmptyMessageDelayed(3, 50L);
      return;
    }
    Object localObject = this.this$0;
    ((MediaPlayer)localObject).q = ((MediaPlayer)localObject).K.f();
    if (this.this$0.K.b() != null)
    {
      localObject = this.d;
      if (localObject != null)
      {
        a((MediaCodecDecoder.FrameInfo)localObject);
        this.d = null;
        if (this.f)
        {
          this.f = false;
          this.this$0.w.sendMessage(this.this$0.w.obtainMessage(200, 3, 0));
        }
      }
    }
    if (this.this$0.J != null)
    {
      if (this.g != this.this$0.u.c())
      {
        this.g = this.this$0.u.c();
        this.this$0.J.a((float)this.g);
      }
      long l2 = this.this$0.J.j();
      if (l2 > AudioPlayback.a) {
        this.this$0.u.a(l2);
      }
    }
    if (this.this$0.K.g())
    {
      this.this$0.w.sendEmptyMessage(2);
      if (this.this$0.I)
      {
        if (this.this$0.J != null) {
          this.this$0.J.f();
        }
        this.this$0.K.a(MediaPlayer.SeekMode.a(0), 0L);
        this.this$0.K.d();
      }
      else
      {
        this.b = true;
        a(true);
      }
    }
    else
    {
      this.d = this.this$0.K.a(false);
    }
    if (!this.b)
    {
      d1 = 10L;
      d2 = this.this$0.u.c();
      Double.isNaN(d1);
      l1 = (d1 / d2) - (SystemClock.elapsedRealtime() - l1);
      if (l1 > 0L)
      {
        this.a.sendEmptyMessageDelayed(3, l1);
        return;
      }
      this.a.sendEmptyMessage(3);
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 304	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:interrupt	()V
    //   4: aload_0
    //   5: invokevirtual 307	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:quit	()Z
    //   8: pop
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 49	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:b	Z
    //   14: aload_0
    //   15: getfield 24	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   18: getfield 76	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:K	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/Decoders;
    //   21: ifnull +32 -> 53
    //   24: aload_0
    //   25: getfield 72	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:d	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecDecoder$FrameInfo;
    //   28: ifnull +25 -> 53
    //   31: aload_0
    //   32: getfield 24	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   35: getfield 76	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:K	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/Decoders;
    //   38: invokevirtual 81	com/tencent/biz/qqstory/playvideo/player/mediaplayer/Decoders:b	()Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecVideoDecoder;
    //   41: aload_0
    //   42: getfield 72	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:d	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecDecoder$FrameInfo;
    //   45: invokevirtual 309	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecVideoDecoder:b	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecDecoder$FrameInfo;)V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 72	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:d	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecDecoder$FrameInfo;
    //   53: aload_0
    //   54: getfield 24	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   57: invokevirtual 311	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:i	()V
    //   60: ldc 158
    //   62: ldc_w 313
    //   65: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   68: pop
    //   69: aload_0
    //   70: getfield 24	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   73: getfield 220	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:Q	Ljava/lang/Object;
    //   76: astore_1
    //   77: aload_1
    //   78: monitorenter
    //   79: aload_0
    //   80: getfield 24	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   83: getfield 220	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:Q	Ljava/lang/Object;
    //   86: invokevirtual 316	java/lang/Object:notify	()V
    //   89: aload_1
    //   90: monitorexit
    //   91: return
    //   92: astore_2
    //   93: aload_1
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: ldc 158
    //   100: ldc_w 313
    //   103: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: aload_0
    //   108: getfield 24	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   111: getfield 220	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:Q	Ljava/lang/Object;
    //   114: astore_1
    //   115: aload_1
    //   116: monitorenter
    //   117: aload_0
    //   118: getfield 24	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   121: getfield 220	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:Q	Ljava/lang/Object;
    //   124: invokevirtual 316	java/lang/Object:notify	()V
    //   127: aload_1
    //   128: monitorexit
    //   129: aload_2
    //   130: athrow
    //   131: astore_2
    //   132: aload_1
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	PlaybackThread
    //   76	57	1	localObject1	Object
    //   92	4	2	localObject2	Object
    //   97	33	2	localObject3	Object
    //   131	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   79	91	92	finally
    //   93	95	92	finally
    //   0	53	97	finally
    //   53	60	97	finally
    //   117	129	131	finally
    //   132	134	131	finally
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 4)
        {
          this.a.removeMessages(4);
          this.a.obtainMessage(4, paramObject).sendToTarget();
          return;
        }
        throw new IllegalArgumentException("Message should be Play or Pause or Seek");
      }
      this.b = true;
      this.a.sendEmptyMessage(2);
      return;
    }
    this.b = false;
    this.a.sendEmptyMessage(1);
  }
  
  public void a(Surface paramSurface)
  {
    Handler localHandler = this.a;
    localHandler.sendMessage(localHandler.obtainMessage(100, paramSurface));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.c)
    {
      g();
      return true;
    }
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        if (i != 100) {}
        switch (i)
        {
        case 6: 
          Log.d("Story-MediaPlayer", "unknown/invalid message");
          return false;
          e();
          return true;
        case 5: 
          g();
          return true;
        case 4: 
          a(((Long)paramMessage.obj).longValue());
          return true;
        case 3: 
          f();
          return true;
        case 2: 
          d();
          return true;
        case 1: 
          c();
          return true;
          b((Surface)paramMessage.obj);
          return true;
        }
      }
      catch (IOException paramMessage)
      {
        Log.e("Story-MediaPlayer", "decoder error, codec can not be created", paramMessage);
        this.this$0.w.sendMessage(this.this$0.w.obtainMessage(100, 1, -1004));
      }
      catch (IllegalStateException paramMessage)
      {
        Log.e("Story-MediaPlayer", "decoder error, too many instances?", paramMessage);
        this.this$0.w.sendMessage(this.this$0.w.obtainMessage(100, 1, 0));
      }
      catch (InterruptedException paramMessage)
      {
        Log.d("Story-MediaPlayer", "decoder interrupted", paramMessage);
        this.this$0.w.sendMessage(this.this$0.w.obtainMessage(100, 1, 0));
      }
      g();
      return true;
    }
  }
  
  public void start()
  {
    try
    {
      super.start();
      this.a = new Handler(getLooper(), this);
      Log.d("Story-MediaPlayer", "PlaybackThread started");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread
 * JD-Core Version:    0.7.0.1
 */