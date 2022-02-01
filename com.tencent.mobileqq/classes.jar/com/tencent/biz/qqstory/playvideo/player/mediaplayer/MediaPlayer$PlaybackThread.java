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
  private double jdField_a_of_type_Double;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MediaCodecDecoder.FrameInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public MediaPlayer$PlaybackThread(MediaPlayer paramMediaPlayer)
  {
    super("Story-MediaPlayer#" + PlaybackThread.class.getSimpleName(), -16);
    this.c = MediaPlayer.VideoRenderTimingMode.a(paramMediaPlayer.g);
    this.d = true;
    this.e = false;
  }
  
  private void a()
  {
    if (!isAlive()) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.b = true;
      boolean bool = this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      if (bool) {}
      try
      {
        this.this$0.jdField_a_of_type_JavaLangObject.wait();
        Log.d("Story-MediaPlayer", "PlaybackThread released");
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.e("Story-MediaPlayer", "wait lock interrupted", localInterruptedException);
        }
      }
    }
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo != null)
    {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo = null;
    }
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a(true);
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$SeekMode, paramLong);
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a());
    boolean bool = this.jdField_a_of_type_AndroidOsHandler.hasMessages(4);
    if (bool) {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.c();
    }
    for (;;)
    {
      if (!bool)
      {
        this.this$0.c = this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a();
        this.this$0.jdField_a_of_type_Boolean = false;
        this.e = false;
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendEmptyMessage(4);
        if (!this.jdField_a_of_type_Boolean) {
          b();
        }
      }
      return;
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.b();
    }
  }
  
  private void a(MediaCodecDecoder.FrameInfo paramFrameInfo)
  {
    if (paramFrameInfo.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().a(paramFrameInfo);
      return;
    }
    long l = this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a(paramFrameInfo.jdField_a_of_type_Long);
    if (l < -1000L)
    {
      Log.d("Story-MediaPlayer", "LAGGING " + l);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(200, 700, 0));
    }
    if (paramFrameInfo.b)
    {
      if (!this.this$0.f) {
        break label202;
      }
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(5, this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().b(), this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().a()));
    }
    for (;;)
    {
      if ((!this.c) && (l > 5000L)) {
        Thread.sleep(l / 1000L);
      }
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().a(paramFrameInfo, l);
      return;
      label202:
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(5, this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().a(), this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().b()));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a() + this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.b()) / 1000L + 1L);
      }
    }
    else {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a(false);
  }
  
  private void b()
  {
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a())
    {
      this.this$0.c = 0L;
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a(MediaPlayer.SeekMode.a(0), 0L);
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a());
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a();
    }
    this.jdField_a_of_type_Double = this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a();
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a((float)this.jdField_a_of_type_Double);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    e();
  }
  
  private void b(Surface paramSurface)
  {
    if ((this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders != null) && (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a() != null))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo != null)
      {
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo = null;
      }
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().a(paramSurface);
    }
  }
  
  private void c()
  {
    a(false);
  }
  
  private void d()
  {
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.b();
    }
  }
  
  private void e()
  {
    long l1 = this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.b();
    if (l1 != -1L) {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(3, (int)(100.0D / (this.this$0.a() * 1000) * (this.this$0.c + l1)), 0));
    }
    if ((this.this$0.e) && (l1 > -1L) && (l1 < 2000000L) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.b())) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 100L);
    }
    for (;;)
    {
      return;
      if ((this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a() != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo == null))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo = this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a(false);
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo == null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a()))
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 10L);
          return;
        }
      }
      l1 = SystemClock.elapsedRealtime();
      if (this.this$0.e)
      {
        this.this$0.e = false;
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(200, 702, 0));
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a());
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo != null) && (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo.jdField_a_of_type_Long) > 60000L))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 50L);
        return;
      }
      this.this$0.c = this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a();
      if ((this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a() != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo != null))
      {
        a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo = null;
        if (this.d)
        {
          this.d = false;
          this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(200, 3, 0));
        }
      }
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null)
      {
        if (this.jdField_a_of_type_Double != this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a())
        {
          this.jdField_a_of_type_Double = this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a();
          this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a((float)this.jdField_a_of_type_Double);
        }
        long l2 = this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.c();
        if (l2 > AudioPlayback.jdField_a_of_type_Long) {
          this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a(l2);
        }
      }
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a())
      {
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendEmptyMessage(2);
        if (this.this$0.d)
        {
          if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
            this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.c();
          }
          this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a(MediaPlayer.SeekMode.a(0), 0L);
          this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.b();
        }
      }
      while (!this.jdField_a_of_type_Boolean)
      {
        l1 = (10L / this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase.a()) - (SystemClock.elapsedRealtime() - l1);
        if (l1 <= 0L) {
          break label637;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, l1);
        return;
        this.jdField_a_of_type_Boolean = true;
        a(true);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo = this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a(false);
      }
    }
    label637:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 276	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:interrupt	()V
    //   4: aload_0
    //   5: invokevirtual 279	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:quit	()Z
    //   8: pop
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 46	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:jdField_a_of_type_Boolean	Z
    //   14: aload_0
    //   15: getfield 21	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   18: getfield 107	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/Decoders;
    //   21: ifnull +32 -> 53
    //   24: aload_0
    //   25: getfield 104	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecDecoder$FrameInfo;
    //   28: ifnull +25 -> 53
    //   31: aload_0
    //   32: getfield 21	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   35: getfield 107	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/Decoders;
    //   38: invokevirtual 112	com/tencent/biz/qqstory/playvideo/player/mediaplayer/Decoders:a	()Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecVideoDecoder;
    //   41: aload_0
    //   42: getfield 104	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecDecoder$FrameInfo;
    //   45: invokevirtual 281	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecVideoDecoder:b	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecDecoder$FrameInfo;)V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 104	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaCodecDecoder$FrameInfo;
    //   53: aload_0
    //   54: getfield 21	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   57: invokevirtual 284	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:h	()V
    //   60: ldc 89
    //   62: ldc_w 286
    //   65: invokestatic 96	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   68: pop
    //   69: aload_0
    //   70: getfield 21	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   73: getfield 75	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   76: astore_1
    //   77: aload_1
    //   78: monitorenter
    //   79: aload_0
    //   80: getfield 21	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   83: getfield 75	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   86: invokevirtual 289	java/lang/Object:notify	()V
    //   89: aload_1
    //   90: monitorexit
    //   91: return
    //   92: astore_2
    //   93: aload_1
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: ldc 89
    //   100: ldc_w 286
    //   103: invokestatic 96	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: aload_0
    //   108: getfield 21	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   111: getfield 75	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   114: astore_1
    //   115: aload_1
    //   116: monitorenter
    //   117: aload_0
    //   118: getfield 21	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   121: getfield 75	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   124: invokevirtual 289	java/lang/Object:notify	()V
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
    switch (paramInt)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("Message should be Play or Pause or Seek");
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    case 2: 
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramObject).sendToTarget();
  }
  
  public void a(Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100, paramSurface));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.b)
    {
      f();
      return true;
    }
    try
    {
      switch (paramMessage.what)
      {
      case 1: 
        Log.d("Story-MediaPlayer", "unknown/invalid message");
        return false;
        b();
        return true;
      case 2: 
        c();
        return true;
      case 6: 
        d();
        return true;
      case 3: 
        e();
        return true;
      case 4: 
        a(((Long)paramMessage.obj).longValue());
        return true;
      case 5: 
        f();
        return true;
      case 100: 
        b((Surface)paramMessage.obj);
        return true;
      }
    }
    catch (InterruptedException paramMessage)
    {
      Log.d("Story-MediaPlayer", "decoder interrupted", paramMessage);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(100, 1, 0));
      f();
      return true;
    }
    catch (IllegalStateException paramMessage)
    {
      for (;;)
      {
        Log.e("Story-MediaPlayer", "decoder error, too many instances?", paramMessage);
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(100, 1, 0));
      }
    }
    catch (IOException paramMessage)
    {
      for (;;)
      {
        Log.e("Story-MediaPlayer", "decoder error, codec can not be created", paramMessage);
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(100, 1, -1004));
      }
    }
  }
  
  public void start()
  {
    try
    {
      super.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(getLooper(), this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread
 * JD-Core Version:    0.7.0.1
 */