package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnCompletionListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class MediaPlayer
  implements IMediaPlayer
{
  protected IMediaPlayer.OnSeekCompleteListener A;
  protected IMediaPlayer.OnErrorListener B;
  protected IMediaPlayer.OnInfoListener C;
  protected IMediaPlayer.OnVideoSizeChangedListener D;
  protected IMediaPlayer.OnBufferingUpdateListener E;
  protected PowerManager.WakeLock F = null;
  protected boolean G;
  protected boolean H;
  protected boolean I;
  protected AudioPlayback J;
  protected Decoders K;
  protected boolean L;
  protected boolean M = false;
  protected int N = 0;
  protected int O = 1;
  protected int P = 1;
  protected final Object Q = new Object();
  private CountDownLatch R;
  protected MediaPlayer.SeekMode a = MediaPlayer.SeekMode.a(4);
  protected Surface b;
  protected SurfaceHolder c;
  protected MediaExtractor d;
  protected MediaExtractor e;
  protected int f;
  protected MediaFormat g;
  protected long h;
  protected int i;
  protected MediaFormat j;
  protected long k;
  protected int l = 0;
  protected int m = 3;
  protected float n = 1.0F;
  protected float o = 1.0F;
  protected MediaPlayer.PlaybackThread p = null;
  protected long q;
  protected long r;
  protected boolean s;
  protected int t;
  protected TimeBase u = new TimeBase();
  protected Uri v;
  protected MediaPlayer.EventHandler w = new MediaPlayer.EventHandler(this, null);
  protected IMediaPlayer.OnPreparedListener x;
  protected IMediaPlayer.OnCompletionListener y;
  protected IMediaPlayer.OnSeekListener z;
  
  public static boolean n()
  {
    return Build.VERSION.SDK_INT <= 19;
  }
  
  private void p()
  {
    SurfaceHolder localSurfaceHolder = this.c;
    if (localSurfaceHolder != null)
    {
      boolean bool;
      if ((this.G) && (this.H)) {
        bool = true;
      } else {
        bool = false;
      }
      localSurfaceHolder.setKeepScreenOn(bool);
    }
  }
  
  protected void a()
  {
    if (this.j != null)
    {
      this.J = new AudioPlayback();
      this.J.a(this.l);
      a(this.n, this.o);
    }
    Object localObject3 = new MediaPlayer.1(this);
    if (this.P == 6) {
      return;
    }
    this.K = new Decoders();
    int i1 = this.f;
    if (i1 != -1) {
      try
      {
        MediaCodecVideoDecoder localMediaCodecVideoDecoder = new MediaCodecVideoDecoder(this.d, false, i1, (MediaCodecDecoder.OnDecoderEventListener)localObject3, this.b, MediaPlayer.VideoRenderTimingMode.a(this.O));
        this.K.a(localMediaCodecVideoDecoder);
      }
      catch (Exception localException1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cannot create video decoder: ");
        localStringBuilder.append(localException1.getMessage());
        Log.e("Story-MediaPlayer", localStringBuilder.toString());
      }
    }
    if (this.i != -1) {}
    for (;;)
    {
      try
      {
        if (this.e == this.d) {
          break label563;
        }
        if (this.e != null) {
          break label557;
        }
      }
      catch (Exception localException2)
      {
        Object localObject1;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("cannot create audio decoder: ");
        ((StringBuilder)localObject3).append(localException2.getMessage());
        Log.e("Story-MediaPlayer", ((StringBuilder)localObject3).toString());
      }
      if (this.e != null) {
        localObject1 = this.e;
      } else {
        localObject1 = this.d;
      }
      localObject1 = new MediaCodecAudioDecoder((MediaExtractor)localObject1, bool, this.i, (MediaCodecDecoder.OnDecoderEventListener)localObject3, this.J);
      this.K.a((MediaCodecDecoder)localObject1);
      if (!this.K.a().isEmpty())
      {
        Object localObject2 = this.J;
        if (localObject2 != null)
        {
          this.l = ((AudioPlayback)localObject2).a();
          this.m = this.J.b();
        }
        if (this.K.b() != null)
        {
          int i3 = this.K.b().o();
          i1 = this.K.b().p();
          int i5 = this.N;
          int i4 = i3;
          int i2 = i1;
          if (i5 > 0)
          {
            i4 = i3;
            i2 = i1;
            if (i5 != 180)
            {
              this.M = true;
              i2 = i3;
              i4 = i1;
            }
          }
          localObject2 = this.w;
          ((MediaPlayer.EventHandler)localObject2).sendMessage(((MediaPlayer.EventHandler)localObject2).obtainMessage(5, i4, i2));
        }
        if (this.P == 6) {
          return;
        }
        if (this.K.b() != null)
        {
          localObject2 = this.K.a(true);
          this.K.b().b((MediaCodecDecoder.FrameInfo)localObject2);
        }
        else
        {
          this.K.a(false);
        }
        localObject2 = this.J;
        if (localObject2 != null) {
          ((AudioPlayback)localObject2).a(true);
        }
        this.K.a(MediaPlayer.SeekMode.a(0), 0L);
        if (this.P == 6) {
          return;
        }
        this.p = new MediaPlayer.PlaybackThread(this);
        this.p.start();
        this.P = 4;
        return;
      }
      throw new IOException("cannot decode any stream");
      label557:
      boolean bool = false;
      continue;
      label563:
      bool = true;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.n = paramFloat1;
    this.o = paramFloat2;
    AudioPlayback localAudioPlayback = this.J;
    if (localAudioPlayback != null) {
      localAudioPlayback.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt * 1000L);
  }
  
  public void a(long paramLong)
  {
    int i1 = this.P;
    if ((i1 < 4) && (i1 >= 6))
    {
      this.P = 8;
      throw new IllegalStateException();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seekTo ");
    ((StringBuilder)localObject).append(paramLong);
    Log.d("Story-MediaPlayer", ((StringBuilder)localObject).toString());
    localObject = this.z;
    if (localObject != null) {
      ((IMediaPlayer.OnSeekListener)localObject).a(this);
    }
    this.s = true;
    this.r = Math.max(this.h, paramLong);
    this.p.a(4, Long.valueOf(this.r));
  }
  
  @Deprecated
  public void a(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.v = paramUri;
    a(new UriSource(paramContext, paramUri, paramMap));
  }
  
  public void a(Surface paramSurface)
  {
    this.b = paramSurface;
    if ((this.G) && (paramSurface != null)) {
      Log.w("Story-MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
    }
    this.c = null;
    paramSurface = this.p;
    if (paramSurface == null)
    {
      d(2);
      p();
      return;
    }
    paramSurface.a(this.b);
  }
  
  @TargetApi(16)
  public void a(MediaSource paramMediaSource)
  {
    String str;
    if (this.P == 1)
    {
      this.d = paramMediaSource.a();
      this.e = paramMediaSource.b();
      this.f = -1;
      this.i = -1;
      int i2 = 0;
      int i1 = 0;
      while (i1 < this.d.c())
      {
        paramMediaSource = this.d.a(i1);
        Log.d("Story-MediaPlayer", paramMediaSource.toString());
        str = paramMediaSource.getString("mime");
        if ((this.f < 0) && (str.startsWith("video/")))
        {
          this.d.b(i1);
          this.f = i1;
          this.g = paramMediaSource;
          this.h = this.d.f();
        }
        else if ((this.e == null) && (this.i < 0) && (str.startsWith("audio/")))
        {
          this.d.b(i1);
          this.i = i1;
          this.j = paramMediaSource;
          this.k = this.d.f();
          this.e = this.d;
        }
        i1 += 1;
      }
      if ((this.e != null) && (this.i == -1))
      {
        i1 = i2;
        while (i1 < this.e.c())
        {
          paramMediaSource = this.e.a(i1);
          Log.d("Story-MediaPlayer", paramMediaSource.toString());
          str = paramMediaSource.getString("mime");
          if ((this.i < 0) && (str.startsWith("audio/")))
          {
            this.e.b(i1);
            this.i = i1;
            this.j = paramMediaSource;
            this.k = this.e.f();
          }
          i1 += 1;
        }
      }
      if (this.f == -1) {
        this.d = null;
      }
      if ((this.f == -1) && (this.i == -1)) {
        throw new IOException("invalid data source, no supported stream found");
      }
      if ((this.f != -1) && (this.p == null) && (this.b == null)) {
        Log.i("Story-MediaPlayer", "no video output surface specified");
      }
      this.P = 2;
      if (!this.g.containsKey("rotation-degrees"))
      {
        paramMediaSource = new MediaMetadataRetriever();
        paramMediaSource.setDataSource(this.v.getPath());
        str = paramMediaSource.extractMetadata(24);
      }
    }
    try
    {
      this.N = Integer.parseInt(str);
      this.g.setInteger("rotation-degrees", this.N);
      label452:
      paramMediaSource.release();
      return;
      this.N = this.g.getInteger("rotation-degrees");
      return;
      paramMediaSource = new IllegalStateException();
      for (;;)
      {
        throw paramMediaSource;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label452;
    }
  }
  
  public void a(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.E = paramOnBufferingUpdateListener;
  }
  
  public void a(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.y = paramOnCompletionListener;
  }
  
  public void a(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.B = paramOnErrorListener;
  }
  
  public void a(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.C = paramOnInfoListener;
  }
  
  public void a(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.x = paramOnPreparedListener;
  }
  
  public void a(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.A = paramOnSeekCompleteListener;
  }
  
  public void a(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.D = paramOnVideoSizeChangedListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void b()
  {
    int i1 = this.P;
    if ((i1 != 2) && (i1 != 5)) {
      throw new IllegalStateException();
    }
    this.R = new CountDownLatch(1);
    this.P = 3;
    new Thread(new MediaPlayer.2(this)).start();
  }
  
  public void b(int paramInt)
  {
    if (this.P == 1)
    {
      this.l = paramInt;
      return;
    }
    throw new IllegalStateException();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.G != paramBoolean)
    {
      if ((paramBoolean) && (this.c == null)) {
        Log.w("Story-MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
      }
      this.G = paramBoolean;
      p();
    }
  }
  
  public void c()
  {
    if (this.P == 4)
    {
      this.p.a(1, null);
      c(true);
      return;
    }
    this.P = 8;
    throw new IllegalStateException();
  }
  
  public void c(int paramInt)
  {
    this.m = paramInt;
  }
  
  protected void c(boolean paramBoolean)
  {
    PowerManager.WakeLock localWakeLock = this.F;
    if (localWakeLock != null) {
      if ((paramBoolean) && (!localWakeLock.isHeld())) {
        this.F.acquire();
      } else if ((!paramBoolean) && (this.F.isHeld())) {
        this.F.release();
      }
    }
    this.H = paramBoolean;
    p();
  }
  
  public void d()
  {
    if (this.P == 4)
    {
      this.p.a(2, null);
      c(false);
      return;
    }
    this.P = 8;
    throw new IllegalStateException();
  }
  
  void d(int paramInt)
  {
    if (this.p == null)
    {
      if ((paramInt == 3) && (Build.VERSION.SDK_INT < 21)) {
        throw new IllegalArgumentException("this mode needs min API 21");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVideoRenderTimingMode ");
      localStringBuilder.append(paramInt);
      Log.d("Story-MediaPlayer", localStringBuilder.toString());
      this.O = paramInt;
      return;
    }
    throw new IllegalStateException("called after prepare/prepareAsync");
  }
  
  public boolean e()
  {
    if (this.P < 6)
    {
      MediaPlayer.PlaybackThread localPlaybackThread = this.p;
      return (localPlaybackThread != null) && (!localPlaybackThread.a());
    }
    this.P = 8;
    throw new IllegalStateException();
  }
  
  public void f()
  {
    g();
    this.P = 5;
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 6
    //   3: putfield 114	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:P	I
    //   6: aload_0
    //   7: getfield 122	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:R	Ljava/util/concurrent/CountDownLatch;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +23 -> 35
    //   15: aload_1
    //   16: invokevirtual 500	java/util/concurrent/CountDownLatch:await	()V
    //   19: goto +11 -> 30
    //   22: astore_1
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 122	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:R	Ljava/util/concurrent/CountDownLatch;
    //   28: aload_1
    //   29: athrow
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 122	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:R	Ljava/util/concurrent/CountDownLatch;
    //   35: aload_0
    //   36: getfield 98	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:p	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +15 -> 56
    //   44: aload_1
    //   45: invokestatic 503	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:a	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;)V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 98	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:p	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   53: goto +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 505	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:i	()V
    //   60: aload_0
    //   61: iconst_0
    //   62: invokevirtual 469	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:c	(Z)V
    //   65: aload_0
    //   66: bipush 7
    //   68: putfield 114	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:P	I
    //   71: return
    //   72: astore_1
    //   73: goto -43 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	MediaPlayer
    //   10	6	1	localCountDownLatch	CountDownLatch
    //   22	7	1	localObject	Object
    //   39	6	1	localPlaybackThread	MediaPlayer.PlaybackThread
    //   72	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   15	19	22	finally
    //   15	19	72	java/lang/InterruptedException
  }
  
  public void h()
  {
    f();
    this.P = 1;
  }
  
  protected void i()
  {
    Object localObject = this.K;
    if (localObject != null) {
      ((Decoders)localObject).c();
    }
    localObject = this.J;
    if (localObject != null) {
      ((AudioPlayback)localObject).g();
    }
    localObject = this.e;
    int i2 = 1;
    int i1;
    if (localObject != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.e == this.d) {
      i2 = 0;
    }
    if ((i1 & i2) != 0) {
      this.e.b();
    }
    localObject = this.d;
    if (localObject != null) {
      ((MediaExtractor)localObject).b();
    }
  }
  
  @TargetApi(16)
  public int j()
  {
    int i1 = this.P;
    if ((i1 <= 3) && (i1 >= 6))
    {
      this.P = 8;
      throw new IllegalStateException();
    }
    MediaFormat localMediaFormat = this.g;
    if (localMediaFormat != null) {}
    for (long l1 = localMediaFormat.getLong("durationUs") / 1000L;; l1 = this.j.getLong("durationUs") / 1000L)
    {
      return (int)l1;
      localMediaFormat = this.j;
      if ((localMediaFormat == null) || (!localMediaFormat.containsKey("durationUs"))) {
        break;
      }
    }
    return 0;
  }
  
  public int k()
  {
    if (this.P < 6)
    {
      long l1;
      if (this.s) {
        l1 = this.r;
      } else {
        l1 = this.q;
      }
      return (int)(l1 / 1000L);
    }
    this.P = 8;
    throw new IllegalStateException();
  }
  
  @TargetApi(16)
  public int l()
  {
    int i3 = this.P;
    int i2 = 0;
    int i1 = 0;
    if (i3 >= 6)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVideoWidth() with wrong state: ");
      ((StringBuilder)localObject).append(this.P);
      ((StringBuilder)localObject).append("!");
      SLog.c("Story-MediaPlayer", ((StringBuilder)localObject).toString(), new IllegalStateException());
      this.P = 8;
      return 0;
    }
    if ((this.M) && (!n()))
    {
      localObject = this.g;
      if (localObject != null) {
        i1 = ((MediaFormat)localObject).getInteger("height");
      }
      return i1;
    }
    Object localObject = this.g;
    i1 = i2;
    if (localObject != null) {
      i1 = (int)(((MediaFormat)localObject).getInteger("height") * this.g.getFloat("mpx-dar"));
    }
    return i1;
  }
  
  @TargetApi(16)
  public int m()
  {
    int i3 = this.P;
    int i2 = 0;
    int i1 = 0;
    if (i3 >= 6)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVideoHeight() with wrong state: ");
      ((StringBuilder)localObject).append(this.P);
      ((StringBuilder)localObject).append("!");
      SLog.c("Story-MediaPlayer", ((StringBuilder)localObject).toString(), new IllegalStateException());
      this.P = 8;
      return 0;
    }
    if ((this.M) && (!n()))
    {
      localObject = this.g;
      if (localObject != null) {
        i1 = (int)(((MediaFormat)localObject).getInteger("height") * this.g.getFloat("mpx-dar"));
      }
      return i1;
    }
    Object localObject = this.g;
    i1 = i2;
    if (localObject != null) {
      i1 = ((MediaFormat)localObject).getInteger("height");
    }
    return i1;
  }
  
  public int o()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer
 * JD-Core Version:    0.7.0.1
 */