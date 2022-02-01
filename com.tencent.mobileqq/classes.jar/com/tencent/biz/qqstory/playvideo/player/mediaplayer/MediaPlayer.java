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
  protected float a;
  protected int a;
  protected long a;
  protected MediaFormat a;
  protected Uri a;
  protected PowerManager.WakeLock a;
  protected Surface a;
  protected SurfaceHolder a;
  protected AudioPlayback a;
  protected Decoders a;
  protected MediaExtractor a;
  protected MediaPlayer.EventHandler a;
  protected MediaPlayer.PlaybackThread a;
  protected MediaPlayer.SeekMode a;
  protected TimeBase a;
  protected IMediaPlayer.OnBufferingUpdateListener a;
  protected IMediaPlayer.OnCompletionListener a;
  protected IMediaPlayer.OnErrorListener a;
  protected IMediaPlayer.OnInfoListener a;
  protected IMediaPlayer.OnPreparedListener a;
  protected IMediaPlayer.OnSeekCompleteListener a;
  protected IMediaPlayer.OnSeekListener a;
  protected IMediaPlayer.OnVideoSizeChangedListener a;
  protected final Object a;
  private CountDownLatch a;
  protected boolean a;
  protected float b;
  protected int b;
  protected long b;
  protected MediaFormat b;
  protected MediaExtractor b;
  protected boolean b;
  protected int c;
  protected long c;
  protected boolean c;
  protected int d;
  protected long d;
  protected boolean d;
  protected int e;
  protected boolean e;
  protected int f;
  protected boolean f;
  protected int g = 1;
  protected int h = 1;
  
  public MediaPlayer()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$SeekMode = MediaPlayer.SeekMode.a(4);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread = null;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler = new MediaPlayer.EventHandler(this, null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerTimeBase = new TimeBase();
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 3;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT <= 19;
  }
  
  private void i()
  {
    SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceHolder;
    if (localSurfaceHolder != null)
    {
      boolean bool;
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
        bool = true;
      } else {
        bool = false;
      }
      localSurfaceHolder.setKeepScreenOn(bool);
    }
  }
  
  @TargetApi(16)
  public int a()
  {
    int i = this.h;
    if ((i <= 3) && (i >= 6))
    {
      this.h = 8;
      throw new IllegalStateException();
    }
    MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaFormat;
    if (localMediaFormat != null) {}
    for (long l = localMediaFormat.getLong("durationUs") / 1000L;; l = this.jdField_b_of_type_AndroidMediaMediaFormat.getLong("durationUs") / 1000L)
    {
      return (int)l;
      localMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
      if ((localMediaFormat == null) || (!localMediaFormat.containsKey("durationUs"))) {
        break;
      }
    }
    return 0;
  }
  
  protected void a()
  {
    if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback = new AudioPlayback();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a(this.jdField_c_of_type_Int);
      a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    }
    Object localObject3 = new MediaPlayer.1(this);
    if (this.h == 6) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders = new Decoders();
    int i = this.jdField_a_of_type_Int;
    if (i != -1) {
      try
      {
        MediaCodecVideoDecoder localMediaCodecVideoDecoder = new MediaCodecVideoDecoder(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor, false, i, (MediaCodecDecoder.OnDecoderEventListener)localObject3, this.jdField_a_of_type_AndroidViewSurface, MediaPlayer.VideoRenderTimingMode.a(this.g));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a(localMediaCodecVideoDecoder);
      }
      catch (Exception localException1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cannot create video decoder: ");
        localStringBuilder.append(localException1.getMessage());
        Log.e("Story-MediaPlayer", localStringBuilder.toString());
      }
    }
    if (this.jdField_b_of_type_Int != -1) {}
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor) {
          break label563;
        }
        if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor != null) {
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
      if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor != null) {
        localObject1 = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor;
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor;
      }
      localObject1 = new MediaCodecAudioDecoder((MediaExtractor)localObject1, bool, this.jdField_b_of_type_Int, (MediaCodecDecoder.OnDecoderEventListener)localObject3, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a((MediaCodecDecoder)localObject1);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().isEmpty())
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback;
        if (localObject2 != null)
        {
          this.jdField_c_of_type_Int = ((AudioPlayback)localObject2).a();
          this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a() != null)
        {
          int k = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().a();
          i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().b();
          int n = this.jdField_f_of_type_Int;
          int m = k;
          int j = i;
          if (n > 0)
          {
            m = k;
            j = i;
            if (n != 180)
            {
              this.jdField_f_of_type_Boolean = true;
              j = k;
              m = i;
            }
          }
          localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler;
          ((MediaPlayer.EventHandler)localObject2).sendMessage(((MediaPlayer.EventHandler)localObject2).obtainMessage(5, m, j));
        }
        if (this.h == 6) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a() != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a(true);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a().b((MediaCodecDecoder.FrameInfo)localObject2);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a(false);
        }
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback;
        if (localObject2 != null) {
          ((AudioPlayback)localObject2).a(true);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.a(MediaPlayer.SeekMode.a(0), 0L);
        if (this.h == 6) {
          return;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread = new MediaPlayer.PlaybackThread(this);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.start();
        this.h = 4;
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
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    AudioPlayback localAudioPlayback = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback;
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
    int i = this.h;
    if ((i < 4) && (i >= 6))
    {
      this.h = 8;
      throw new IllegalStateException();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seekTo ");
    ((StringBuilder)localObject).append(paramLong);
    Log.d("Story-MediaPlayer", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekListener;
    if (localObject != null) {
      ((IMediaPlayer.OnSeekListener)localObject).a(this);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Long = Math.max(this.jdField_a_of_type_Long, paramLong);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a(4, Long.valueOf(this.jdField_d_of_type_Long));
  }
  
  @Deprecated
  public void a(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_AndroidNetUri = paramUri;
    a(new UriSource(paramContext, paramUri, paramMap));
  }
  
  public void a(Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if ((this.jdField_b_of_type_Boolean) && (paramSurface != null)) {
      Log.w("Story-MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
    }
    this.jdField_a_of_type_AndroidViewSurfaceHolder = null;
    paramSurface = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread;
    if (paramSurface == null)
    {
      d(2);
      i();
      return;
    }
    paramSurface.a(this.jdField_a_of_type_AndroidViewSurface);
  }
  
  @TargetApi(16)
  public void a(MediaSource paramMediaSource)
  {
    String str;
    if (this.h == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor = paramMediaSource.a();
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor = paramMediaSource.b();
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      int j = 0;
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a())
      {
        paramMediaSource = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a(i);
        Log.d("Story-MediaPlayer", paramMediaSource.toString());
        str = paramMediaSource.getString("mime");
        if ((this.jdField_a_of_type_Int < 0) && (str.startsWith("video/")))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a(i);
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaSource;
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
        }
        else if ((this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor == null) && (this.jdField_b_of_type_Int < 0) && (str.startsWith("audio/")))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a(i);
          this.jdField_b_of_type_Int = i;
          this.jdField_b_of_type_AndroidMediaMediaFormat = paramMediaSource;
          this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
          this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor;
        }
        i += 1;
      }
      if ((this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor != null) && (this.jdField_b_of_type_Int == -1))
      {
        i = j;
        while (i < this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a())
        {
          paramMediaSource = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a(i);
          Log.d("Story-MediaPlayer", paramMediaSource.toString());
          str = paramMediaSource.getString("mime");
          if ((this.jdField_b_of_type_Int < 0) && (str.startsWith("audio/")))
          {
            this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a(i);
            this.jdField_b_of_type_Int = i;
            this.jdField_b_of_type_AndroidMediaMediaFormat = paramMediaSource;
            this.jdField_b_of_type_Long = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor = null;
      }
      if ((this.jdField_a_of_type_Int == -1) && (this.jdField_b_of_type_Int == -1)) {
        throw new IOException("invalid data source, no supported stream found");
      }
      if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread == null) && (this.jdField_a_of_type_AndroidViewSurface == null)) {
        Log.i("Story-MediaPlayer", "no video output surface specified");
      }
      this.h = 2;
      if (!this.jdField_a_of_type_AndroidMediaMediaFormat.containsKey("rotation-degrees"))
      {
        paramMediaSource = new MediaMetadataRetriever();
        paramMediaSource.setDataSource(this.jdField_a_of_type_AndroidNetUri.getPath());
        str = paramMediaSource.extractMetadata(24);
      }
    }
    try
    {
      this.jdField_f_of_type_Int = Integer.parseInt(str);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("rotation-degrees", this.jdField_f_of_type_Int);
      label452:
      paramMediaSource.release();
      return;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("rotation-degrees");
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnBufferingUpdateListener = paramOnBufferingUpdateListener;
  }
  
  public void a(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener = paramOnCompletionListener;
  }
  
  public void a(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener = paramOnErrorListener;
  }
  
  public void a(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnInfoListener = paramOnInfoListener;
  }
  
  public void a(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener = paramOnPreparedListener;
  }
  
  public void a(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void a(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.h < 6)
    {
      MediaPlayer.PlaybackThread localPlaybackThread = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread;
      return (localPlaybackThread != null) && (!localPlaybackThread.a());
    }
    this.h = 8;
    throw new IllegalStateException();
  }
  
  public int b()
  {
    if (this.h < 6)
    {
      long l;
      if (this.jdField_a_of_type_Boolean) {
        l = this.jdField_d_of_type_Long;
      } else {
        l = this.jdField_c_of_type_Long;
      }
      return (int)(l / 1000L);
    }
    this.h = 8;
    throw new IllegalStateException();
  }
  
  public void b()
  {
    int i = this.h;
    if ((i != 2) && (i != 5)) {
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
    this.h = 3;
    new Thread(new MediaPlayer.2(this)).start();
  }
  
  public void b(int paramInt)
  {
    if (this.h == 1)
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
    throw new IllegalStateException();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewSurfaceHolder == null)) {
        Log.w("Story-MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
      i();
    }
  }
  
  @TargetApi(16)
  public int c()
  {
    int k = this.h;
    int j = 0;
    int i = 0;
    if (k >= 6)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVideoWidth() with wrong state: ");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append("!");
      SLog.c("Story-MediaPlayer", ((StringBuilder)localObject).toString(), new IllegalStateException());
      this.h = 8;
      return 0;
    }
    if ((this.jdField_f_of_type_Boolean) && (!b()))
    {
      localObject = this.jdField_a_of_type_AndroidMediaMediaFormat;
      if (localObject != null) {
        i = ((MediaFormat)localObject).getInteger("height");
      }
      return i;
    }
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaFormat;
    i = j;
    if (localObject != null) {
      i = (int)(((MediaFormat)localObject).getInteger("height") * this.jdField_a_of_type_AndroidMediaMediaFormat.getFloat("mpx-dar"));
    }
    return i;
  }
  
  public void c()
  {
    if (this.h == 4)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a(1, null);
      c(true);
      return;
    }
    this.h = 8;
    throw new IllegalStateException();
  }
  
  public void c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  protected void c(boolean paramBoolean)
  {
    PowerManager.WakeLock localWakeLock = this.jdField_a_of_type_AndroidOsPowerManager$WakeLock;
    if (localWakeLock != null) {
      if ((paramBoolean) && (!localWakeLock.isHeld())) {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      } else if ((!paramBoolean) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      }
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    i();
  }
  
  @TargetApi(16)
  public int d()
  {
    int k = this.h;
    int j = 0;
    int i = 0;
    if (k >= 6)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVideoHeight() with wrong state: ");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append("!");
      SLog.c("Story-MediaPlayer", ((StringBuilder)localObject).toString(), new IllegalStateException());
      this.h = 8;
      return 0;
    }
    if ((this.jdField_f_of_type_Boolean) && (!b()))
    {
      localObject = this.jdField_a_of_type_AndroidMediaMediaFormat;
      if (localObject != null) {
        i = (int)(((MediaFormat)localObject).getInteger("height") * this.jdField_a_of_type_AndroidMediaMediaFormat.getFloat("mpx-dar"));
      }
      return i;
    }
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaFormat;
    i = j;
    if (localObject != null) {
      i = ((MediaFormat)localObject).getInteger("height");
    }
    return i;
  }
  
  public void d()
  {
    if (this.h == 4)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a(2, null);
      c(false);
      return;
    }
    this.h = 8;
    throw new IllegalStateException();
  }
  
  void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread == null)
    {
      if ((paramInt == 3) && (Build.VERSION.SDK_INT < 21)) {
        throw new IllegalArgumentException("this mode needs min API 21");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVideoRenderTimingMode ");
      localStringBuilder.append(paramInt);
      Log.d("Story-MediaPlayer", localStringBuilder.toString());
      this.g = paramInt;
      return;
    }
    throw new IllegalStateException("called after prepare/prepareAsync");
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void e()
  {
    f();
    this.h = 5;
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 6
    //   3: putfield 81	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:h	I
    //   6: aload_0
    //   7: getfield 89	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +23 -> 35
    //   15: aload_1
    //   16: invokevirtual 494	java/util/concurrent/CountDownLatch:await	()V
    //   19: goto +11 -> 30
    //   22: astore_1
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 89	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   28: aload_1
    //   29: athrow
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 89	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   35: aload_0
    //   36: getfield 65	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +15 -> 56
    //   44: aload_1
    //   45: invokestatic 497	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:a	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;)V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 65	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   53: goto +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 499	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:h	()V
    //   60: aload_0
    //   61: iconst_0
    //   62: invokevirtual 466	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:c	(Z)V
    //   65: aload_0
    //   66: bipush 7
    //   68: putfield 81	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:h	I
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
  
  public void g()
  {
    e();
    this.h = 1;
  }
  
  protected void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders;
    if (localObject != null) {
      ((Decoders)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback;
    if (localObject != null) {
      ((AudioPlayback)localObject).d();
    }
    localObject = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor;
    int j = 1;
    int i;
    if (localObject != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor) {
      j = 0;
    }
    if ((i & j) != 0) {
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor;
    if (localObject != null) {
      ((MediaExtractor)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer
 * JD-Core Version:    0.7.0.1
 */