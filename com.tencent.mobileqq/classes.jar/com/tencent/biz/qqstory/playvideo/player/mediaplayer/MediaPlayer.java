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
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import tsa;
import tsb;
import tsc;
import tsd;
import tsf;
import tsg;
import tsh;
import tsi;
import tsj;
import tsk;
import tsl;
import tsm;
import tsn;
import tso;
import tsp;
import tsq;
import tsr;
import tss;
import tst;
import tsu;
import tsv;
import tsw;
import urk;

public class MediaPlayer
  implements tso
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
  public MediaPlayer.PlaybackThread a;
  protected final Object a;
  private CountDownLatch a;
  public tsa a;
  protected tsg a;
  public tsi a;
  protected tsj a;
  protected tsm a;
  public tsp a;
  public tsq a;
  public tsr a;
  public tss a;
  public tst a;
  public tsu a;
  protected tsv a;
  public tsw a;
  protected boolean a;
  protected float b;
  protected int b;
  protected long b;
  protected MediaFormat b;
  protected tsg b;
  protected boolean b;
  protected int c;
  protected long c;
  protected boolean c;
  protected int d;
  protected long d;
  protected boolean d;
  public int e;
  public boolean e;
  protected int f;
  protected boolean f;
  protected int g = 1;
  protected int h = 1;
  
  public MediaPlayer()
  {
    this.jdField_a_of_type_Tsj = tsj.a(4);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread = null;
    this.jdField_a_of_type_Tsi = new tsi(this, null);
    this.jdField_a_of_type_Tsm = new tsm();
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 3;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT <= 19;
  }
  
  private void i()
  {
    SurfaceHolder localSurfaceHolder;
    if (this.jdField_a_of_type_AndroidViewSurfaceHolder != null)
    {
      localSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceHolder;
      if ((!this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean)) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      localSurfaceHolder.setKeepScreenOn(bool);
      return;
    }
  }
  
  @TargetApi(16)
  public int a()
  {
    if ((this.h <= 3) && (this.h >= 6))
    {
      this.h = 8;
      throw new IllegalStateException();
    }
    if (this.jdField_a_of_type_AndroidMediaMediaFormat != null) {
      return (int)(this.jdField_a_of_type_AndroidMediaMediaFormat.getLong("durationUs") / 1000L);
    }
    if ((this.jdField_b_of_type_AndroidMediaMediaFormat != null) && (this.jdField_b_of_type_AndroidMediaMediaFormat.containsKey("durationUs"))) {
      return (int)(this.jdField_b_of_type_AndroidMediaMediaFormat.getLong("durationUs") / 1000L);
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
    tsh localtsh = new tsh(this);
    if (this.h == 6) {
      return;
    }
    this.jdField_a_of_type_Tsa = new tsa();
    if (this.jdField_a_of_type_Int != -1) {}
    for (;;)
    {
      try
      {
        Object localObject = new tsf(this.jdField_a_of_type_Tsg, false, this.jdField_a_of_type_Int, localtsh, this.jdField_a_of_type_AndroidViewSurface, tsk.a(this.g));
        this.jdField_a_of_type_Tsa.a((tsc)localObject);
        if (this.jdField_b_of_type_Int != -1) {}
        try
        {
          if (this.jdField_b_of_type_Tsg == this.jdField_a_of_type_Tsg) {
            break label525;
          }
          if (this.jdField_b_of_type_Tsg != null) {
            continue;
          }
        }
        catch (Exception localException2)
        {
          tsg localtsg;
          Log.e("Story-MediaPlayer", "cannot create audio decoder: " + localException2.getMessage());
          continue;
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback == null) {
            break label331;
          }
          this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a();
          this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.b();
          if (this.jdField_a_of_type_Tsa.a() == null) {
            break label406;
          }
          i = this.jdField_a_of_type_Tsa.a().a();
          j = this.jdField_a_of_type_Tsa.a().b();
          k = this.jdField_f_of_type_Int;
          if ((k <= 0) || (k == 180)) {
            break label520;
          }
          this.jdField_f_of_type_Boolean = true;
          k = j;
          j = i;
          this.jdField_a_of_type_Tsi.sendMessage(this.jdField_a_of_type_Tsi.obtainMessage(5, k, j));
        }
        if (this.jdField_b_of_type_Tsg != null)
        {
          localObject = this.jdField_b_of_type_Tsg;
          localObject = new tsb((tsg)localObject, bool, this.jdField_b_of_type_Int, localtsh, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback);
          this.jdField_a_of_type_Tsa.a((tsc)localObject);
          if (!this.jdField_a_of_type_Tsa.a().isEmpty()) {
            break label302;
          }
          throw new IOException("cannot decode any stream");
        }
      }
      catch (Exception localException1)
      {
        Log.e("Story-MediaPlayer", "cannot create video decoder: " + localException1.getMessage());
        continue;
        bool = false;
        continue;
        localtsg = this.jdField_a_of_type_Tsg;
        continue;
      }
      for (;;)
      {
        label302:
        label331:
        int i;
        int j;
        label406:
        if (this.h == 6) {
          break label523;
        }
        if (this.jdField_a_of_type_Tsa.a() != null)
        {
          tsd localtsd = this.jdField_a_of_type_Tsa.a(true);
          this.jdField_a_of_type_Tsa.a().b(localtsd);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a(true);
          }
          this.jdField_a_of_type_Tsa.a(tsj.a(0), 0L);
          if (this.h == 6) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread = new MediaPlayer.PlaybackThread(this);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.start();
          this.h = 4;
          return;
          this.jdField_a_of_type_Tsa.a(false);
        }
        label520:
        int k = i;
      }
      label523:
      break;
      label525:
      boolean bool = true;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt * 1000L);
  }
  
  public void a(long paramLong)
  {
    if ((this.h < 4) && (this.h >= 6))
    {
      this.h = 8;
      throw new IllegalStateException();
    }
    Log.d("Story-MediaPlayer", "seekTo " + paramLong);
    if (this.jdField_a_of_type_Tsv != null) {
      this.jdField_a_of_type_Tsv.a(this);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Long = Math.max(this.jdField_a_of_type_Long, paramLong);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a(4, Long.valueOf(this.jdField_d_of_type_Long));
  }
  
  @Deprecated
  public void a(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_AndroidNetUri = paramUri;
    a(new tsn(paramContext, paramUri, paramMap));
  }
  
  public void a(Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if ((this.jdField_b_of_type_Boolean) && (paramSurface != null)) {
      Log.w("Story-MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
    }
    this.jdField_a_of_type_AndroidViewSurfaceHolder = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread == null)
    {
      d(2);
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a(this.jdField_a_of_type_AndroidViewSurface);
  }
  
  @TargetApi(16)
  public void a(tsl paramtsl)
  {
    int j = 0;
    if (this.h != 1) {
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_Tsg = paramtsl.a();
    this.jdField_b_of_type_Tsg = paramtsl.b();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    int i = 0;
    String str;
    if (i < this.jdField_a_of_type_Tsg.a())
    {
      paramtsl = this.jdField_a_of_type_Tsg.a(i);
      Log.d("Story-MediaPlayer", paramtsl.toString());
      str = paramtsl.getString("mime");
      if ((this.jdField_a_of_type_Int < 0) && (str.startsWith("video/")))
      {
        this.jdField_a_of_type_Tsg.a(i);
        this.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_AndroidMediaMediaFormat = paramtsl;
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Tsg.a();
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_b_of_type_Tsg == null) && (this.jdField_b_of_type_Int < 0) && (str.startsWith("audio/")))
        {
          this.jdField_a_of_type_Tsg.a(i);
          this.jdField_b_of_type_Int = i;
          this.jdField_b_of_type_AndroidMediaMediaFormat = paramtsl;
          this.jdField_b_of_type_Long = this.jdField_a_of_type_Tsg.a();
          this.jdField_b_of_type_Tsg = this.jdField_a_of_type_Tsg;
        }
      }
    }
    if ((this.jdField_b_of_type_Tsg != null) && (this.jdField_b_of_type_Int == -1))
    {
      i = j;
      while (i < this.jdField_b_of_type_Tsg.a())
      {
        paramtsl = this.jdField_b_of_type_Tsg.a(i);
        Log.d("Story-MediaPlayer", paramtsl.toString());
        str = paramtsl.getString("mime");
        if ((this.jdField_b_of_type_Int < 0) && (str.startsWith("audio/")))
        {
          this.jdField_b_of_type_Tsg.a(i);
          this.jdField_b_of_type_Int = i;
          this.jdField_b_of_type_AndroidMediaMediaFormat = paramtsl;
          this.jdField_b_of_type_Long = this.jdField_b_of_type_Tsg.a();
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Tsg = null;
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
      paramtsl = new MediaMetadataRetriever();
      paramtsl.setDataSource(this.jdField_a_of_type_AndroidNetUri.getPath());
      str = paramtsl.extractMetadata(24);
    }
    try
    {
      this.jdField_f_of_type_Int = Integer.parseInt(str);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("rotation-degrees", this.jdField_f_of_type_Int);
      label457:
      paramtsl.release();
      return;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("rotation-degrees");
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label457;
    }
  }
  
  public void a(tsp paramtsp)
  {
    this.jdField_a_of_type_Tsp = paramtsp;
  }
  
  public void a(tsq paramtsq)
  {
    this.jdField_a_of_type_Tsq = paramtsq;
  }
  
  public void a(tsr paramtsr)
  {
    this.jdField_a_of_type_Tsr = paramtsr;
  }
  
  public void a(tss paramtss)
  {
    this.jdField_a_of_type_Tss = paramtss;
  }
  
  public void a(tst paramtst)
  {
    this.jdField_a_of_type_Tst = paramtst;
  }
  
  public void a(tsu paramtsu)
  {
    this.jdField_a_of_type_Tsu = paramtsu;
  }
  
  public void a(tsw paramtsw)
  {
    this.jdField_a_of_type_Tsw = paramtsw;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.h >= 6)
    {
      this.h = 8;
      throw new IllegalStateException();
    }
    return (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a());
  }
  
  public int b()
  {
    if (this.h >= 6)
    {
      this.h = 8;
      throw new IllegalStateException();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (long l = this.jdField_d_of_type_Long;; l = this.jdField_c_of_type_Long) {
      return (int)(l / 1000L);
    }
  }
  
  public void b()
  {
    if ((this.h != 2) && (this.h != 5)) {
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
    this.h = 3;
    new Thread(new MediaPlayer.2(this)).start();
  }
  
  public void b(int paramInt)
  {
    if (this.h != 1) {
      throw new IllegalStateException();
    }
    this.jdField_c_of_type_Int = paramInt;
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
    if (this.h >= 6)
    {
      urk.c("Story-MediaPlayer", "getVideoWidth() with wrong state: " + this.h + "!", new IllegalStateException());
      this.h = 8;
    }
    do
    {
      do
      {
        return 0;
        if ((this.jdField_f_of_type_Boolean) && (!b())) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidMediaMediaFormat == null);
      return (int)(this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("height") * this.jdField_a_of_type_AndroidMediaMediaFormat.getFloat("mpx-dar"));
    } while (this.jdField_a_of_type_AndroidMediaMediaFormat == null);
    return this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("height");
  }
  
  public void c()
  {
    if (this.h != 4)
    {
      this.h = 8;
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a(1, null);
    c(true);
  }
  
  public void c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
        break label38;
      }
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      i();
      return;
      label38:
      if ((!paramBoolean) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      }
    }
  }
  
  @TargetApi(16)
  public int d()
  {
    if (this.h >= 6)
    {
      urk.c("Story-MediaPlayer", "getVideoHeight() with wrong state: " + this.h + "!", new IllegalStateException());
      this.h = 8;
    }
    do
    {
      do
      {
        return 0;
        if ((!this.jdField_f_of_type_Boolean) || (b())) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidMediaMediaFormat == null);
      return (int)(this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("height") * this.jdField_a_of_type_AndroidMediaMediaFormat.getFloat("mpx-dar"));
    } while (this.jdField_a_of_type_AndroidMediaMediaFormat == null);
    return this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("height");
  }
  
  public void d()
  {
    if (this.h != 4)
    {
      this.h = 8;
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a(2, null);
    c(false);
  }
  
  void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) {
      throw new IllegalStateException("called after prepare/prepareAsync");
    }
    if ((paramInt == 3) && (Build.VERSION.SDK_INT < 21)) {
      throw new IllegalArgumentException("this mode needs min API 21");
    }
    Log.d("Story-MediaPlayer", "setVideoRenderTimingMode " + paramInt);
    this.g = paramInt;
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
    //   3: putfield 75	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:h	I
    //   6: aload_0
    //   7: getfield 83	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   10: ifnull +15 -> 25
    //   13: aload_0
    //   14: getfield 83	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   17: invokevirtual 494	java/util/concurrent/CountDownLatch:await	()V
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 83	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   25: aload_0
    //   26: getfield 59	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   29: ifnull +44 -> 73
    //   32: aload_0
    //   33: getfield 59	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   36: invokestatic 497	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:a	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;)V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 59	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   44: aload_0
    //   45: iconst_0
    //   46: invokevirtual 464	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:c	(Z)V
    //   49: aload_0
    //   50: bipush 7
    //   52: putfield 75	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:h	I
    //   55: return
    //   56: astore_1
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 83	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   62: goto -37 -> 25
    //   65: astore_1
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 83	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   71: aload_1
    //   72: athrow
    //   73: aload_0
    //   74: invokevirtual 499	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:h	()V
    //   77: goto -33 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	MediaPlayer
    //   56	1	1	localInterruptedException	java.lang.InterruptedException
    //   65	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	56	java/lang/InterruptedException
    //   13	20	65	finally
  }
  
  public void g()
  {
    e();
    this.h = 1;
  }
  
  protected void h()
  {
    int j = 1;
    if (this.jdField_a_of_type_Tsa != null) {
      this.jdField_a_of_type_Tsa.a();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.d();
    }
    int i;
    if (this.jdField_b_of_type_Tsg != null)
    {
      i = 1;
      if (this.jdField_b_of_type_Tsg == this.jdField_a_of_type_Tsg) {
        break label83;
      }
    }
    for (;;)
    {
      if ((i & j) != 0) {
        this.jdField_b_of_type_Tsg.b();
      }
      if (this.jdField_a_of_type_Tsg != null) {
        this.jdField_a_of_type_Tsg.b();
      }
      return;
      i = 0;
      break;
      label83:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer
 * JD-Core Version:    0.7.0.1
 */