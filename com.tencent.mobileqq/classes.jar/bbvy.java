import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.videoplatform.VideoPlayerProxy.1;
import com.tencent.mobileqq.videoplatform.VideoPlayerProxy.2;
import com.tencent.mobileqq.videoplatform.VideoPlayerProxy.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class bbvy
  implements bbvq, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bbvo jdField_a_of_type_Bbvo;
  private bbvp jdField_a_of_type_Bbvp;
  private bbvs jdField_a_of_type_Bbvs;
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  public AtomicInteger a;
  private long b;
  private long c;
  
  public bbvy(Context paramContext, long paramLong, bbvs parambbvs, bbvo parambbvo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bbvs = parambbvs;
    this.jdField_a_of_type_Bbvo = parambbvo;
    f();
  }
  
  private View b()
  {
    return (View)SuperPlayerFactory.createPlayerVideoView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Bbvp != null)
      {
        this.jdField_a_of_type_Bbvp.jdField_a_of_type_Boolean = true;
        MediaInfo localMediaInfo = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getMediaInfo();
        if (localMediaInfo != null)
        {
          this.jdField_a_of_type_Bbvp.i = localMediaInfo.getDurationMs();
          this.jdField_a_of_type_Bbvp.jdField_k_of_type_Int = localMediaInfo.getVideoWidth();
          this.jdField_a_of_type_Bbvp.jdField_l_of_type_Int = localMediaInfo.getVideoHeight();
          this.jdField_a_of_type_Bbvp.jdField_j_of_type_Long = localMediaInfo.getVideoBitRate();
          this.jdField_a_of_type_Bbvp.jdField_c_of_type_JavaLangString = localMediaInfo.getVideoCodec();
          this.jdField_a_of_type_Bbvp.jdField_d_of_type_JavaLangString = localMediaInfo.getVideoProfile();
          this.jdField_a_of_type_Bbvp.jdField_k_of_type_Long = localMediaInfo.getAudioBitRate();
          this.jdField_a_of_type_Bbvp.m = localMediaInfo.getChannels();
          this.jdField_a_of_type_Bbvp.e = localMediaInfo.getAudioCodec();
          this.jdField_a_of_type_Bbvp.f = localMediaInfo.getAudioProfile();
          this.jdField_a_of_type_Bbvp.jdField_l_of_type_Long = localMediaInfo.getSampleRate();
          this.jdField_a_of_type_Bbvp.jdField_g_of_type_JavaLangString = localMediaInfo.getContainerFormat();
        }
        this.jdField_a_of_type_Bbvp.jdField_d_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
      {
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
        a(4);
      }
      return;
    }
    finally {}
  }
  
  private void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "createMediaPlayer");
      }
      a(3);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_Bbvs.jdField_a_of_type_Int, (ISPlayerVideoView)this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setXYaxis(2);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
      return;
    }
    finally {}
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "openPlayer ");
        }
        this.jdField_a_of_type_Bbvp = new bbvp();
        this.jdField_a_of_type_Bbvp.jdField_a_of_type_Bbvs = this.jdField_a_of_type_Bbvs;
        this.jdField_a_of_type_Bbvp.jdField_g_of_type_Long = System.currentTimeMillis();
        if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_Bbvs != null))
        {
          a(3);
          if (this.jdField_a_of_type_Bbvs.jdField_b_of_type_Long <= 0L) {
            continue;
          }
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(this.jdField_a_of_type_Bbvs.jdField_a_of_type_Boolean, 0L, this.jdField_a_of_type_Bbvs.jdField_b_of_type_Long);
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(this.jdField_a_of_type_Bbvs.jdField_c_of_type_Boolean);
          if (!this.jdField_a_of_type_Bbvs.jdField_b_of_type_Boolean) {
            break label249;
          }
          if (this.jdField_a_of_type_Bbvs.jdField_a_of_type_JavaLangString != null)
          {
            SuperPlayerVideoInfo localSuperPlayerVideoInfo = new SuperPlayerVideoInfo(3, 3, null);
            localSuperPlayerVideoInfo.setVideoInfo(this.jdField_a_of_type_Bbvs.jdField_a_of_type_JavaLangString, 101);
            this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, localSuperPlayerVideoInfo, 0L);
            this.jdField_a_of_type_Bbvs.jdField_c_of_type_Long = 0L;
            QLog.d(a(), 2, "openPlayer, videoPath = " + this.jdField_a_of_type_Bbvs.jdField_a_of_type_JavaLangString);
          }
        }
        return;
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(this.jdField_a_of_type_Bbvs.jdField_a_of_type_Boolean);
        continue;
        if (this.jdField_a_of_type_Bbvs.jdField_a_of_type_ArrayOfJavaLangString == null) {
          continue;
        }
      }
      finally {}
      label249:
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bbvs.jdField_a_of_type_ArrayOfJavaLangString, 0L, this.jdField_a_of_type_Bbvs.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bbvs.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Bbvs.jdField_c_of_type_Long = 0L;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = this.jdField_a_of_type_Bbvs.jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append(arrayOfString[i]).append(" ; ");
          i += 1;
        }
        QLog.d(a(), 2, "openPlayer, mVideoParam.mSavePath = " + this.jdField_a_of_type_Bbvs.jdField_b_of_type_JavaLangString + " urls = " + localStringBuilder.toString());
      }
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 292	bbvt:a	()Lbbvt;
    //   5: invokevirtual 294	bbvt:a	()Z
    //   8: ifeq +14 -> 22
    //   11: aload_0
    //   12: aload_0
    //   13: invokespecial 296	bbvy:b	()Landroid/view/View;
    //   16: putfield 191	bbvy:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 41	bbvy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   26: instanceof 298
    //   29: ifeq -10 -> 19
    //   32: aload_0
    //   33: iconst_1
    //   34: invokevirtual 172	bbvy:a	(I)V
    //   37: invokestatic 292	bbvt:a	()Lbbvt;
    //   40: aload_0
    //   41: getfield 41	bbvy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   44: checkcast 298	android/app/Activity
    //   47: aload_0
    //   48: invokevirtual 301	bbvt:a	(Landroid/app/Activity;Lbbvq;)V
    //   51: goto -32 -> 19
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	bbvy
    //   54	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	54	finally
    //   22	51	54	finally
  }
  
  public long a()
  {
    l2 = -1L;
    l1 = l2;
    try
    {
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()) {
          l1 = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "getCurPlayingPos() curPosi = " + l1);
    }
    return l1;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bbvs a()
  {
    return this.jdField_a_of_type_Bbvs;
  }
  
  public String a()
  {
    return "[VideoPlatForm]VideoPlayerProxy[" + b() + "][state:" + bbvn.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + "]";
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "play");
        }
        if (!bbvt.a().a())
        {
          if (QLog.isColorLevel()) {
            QLog.d(a(), 2, "play, sdk not ready, return.");
          }
          return;
        }
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3))
        {
          if (QLog.isColorLevel()) {
            QLog.d(a(), 2, "play, do nothing.");
          }
          if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) || (!QLog.isColorLevel())) {
            continue;
          }
          QLog.d(a(), 2, "play, mPlayer.isPlaying() = " + this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying());
          continue;
        }
        if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
          break label264;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "play, mPlayer != null ");
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 6)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "play, mPlayer.isPauseing() =  " + this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPausing());
        }
        c();
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "play, startPlayer() ");
        }
      }
      else
      {
        e();
        continue;
        label264:
        d();
        e();
      }
    }
  }
  
  protected void a(int paramInt)
  {
    VideoPlayerProxy.3 local3;
    if (paramInt != this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "changeState() , newState = " + bbvn.a(paramInt));
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      local3 = new VideoPlayerProxy.3(this, paramInt);
      if (paramInt == 4) {
        ThreadManager.getUIHandler().postDelayed(local3, 300L);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(local3);
  }
  
  public void a(bbvs parambbvs)
  {
    this.jdField_a_of_type_Bbvs = parambbvs;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "onSDKInited, isSucceed =  " + paramBoolean);
      }
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a(), 2, "mVideoView == null, createVideoView.  ");
          }
          this.jdField_a_of_type_AndroidViewView = b();
        }
        a(2);
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "releasePlayer");
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 9)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a(), 2, "has released, do nothing.");
          }
          return;
        }
        a(9);
        if (this.jdField_a_of_type_Bbvp != null)
        {
          bbvp localbbvp = this.jdField_a_of_type_Bbvp;
          if (!paramBoolean2)
          {
            paramBoolean2 = true;
            localbbvp.a(paramBoolean2);
          }
        }
        else
        {
          ThreadManagerV2.executeOnFileThread(new VideoPlayerProxy.1(this, paramBoolean1));
          return;
        }
      }
      finally {}
      paramBoolean2 = false;
    }
  }
  
  protected long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "pause");
    }
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)) {
        a(6);
      }
      ThreadManagerV2.executeOnFileThread(new VideoPlayerProxy.2(this));
      return;
    }
    finally {}
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "onCompletion.");
      }
      a(8);
      if (this.jdField_a_of_type_Bbvp != null) {
        this.jdField_a_of_type_Bbvp.a(true);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 259	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 425
    //   12: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_2
    //   16: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 430
    //   22: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_3
    //   26: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 432
    //   32: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload 4
    //   37: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc_w 434
    //   43: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload 5
    //   48: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore_1
    //   55: aload_0
    //   56: invokevirtual 180	bbvy:a	()Ljava/lang/String;
    //   59: iconst_1
    //   60: new 259	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 436
    //   70: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifne +97 -> 183
    //   89: aload_0
    //   90: bipush 7
    //   92: invokevirtual 172	bbvy:a	(I)V
    //   95: aload_0
    //   96: getfield 45	bbvy:jdField_a_of_type_Bbvs	Lbbvs;
    //   99: ifnull +33 -> 132
    //   102: aload_0
    //   103: getfield 45	bbvy:jdField_a_of_type_Bbvs	Lbbvs;
    //   106: getfield 439	bbvs:jdField_a_of_type_Bbvx	Lbbvx;
    //   109: ifnull +23 -> 132
    //   112: aload_0
    //   113: getfield 45	bbvy:jdField_a_of_type_Bbvs	Lbbvs;
    //   116: getfield 439	bbvs:jdField_a_of_type_Bbvx	Lbbvx;
    //   119: aload_0
    //   120: getfield 43	bbvy:jdField_a_of_type_Long	J
    //   123: iload 4
    //   125: aload 5
    //   127: invokeinterface 444 5 0
    //   132: aload_0
    //   133: getfield 74	bbvy:jdField_a_of_type_Bbvp	Lbbvp;
    //   136: ifnull +37 -> 173
    //   139: aload_0
    //   140: getfield 74	bbvy:jdField_a_of_type_Bbvp	Lbbvp;
    //   143: iload 4
    //   145: putfield 446	bbvp:jdField_c_of_type_Int	I
    //   148: aload_0
    //   149: getfield 74	bbvy:jdField_a_of_type_Bbvp	Lbbvp;
    //   152: iload_3
    //   153: putfield 447	bbvp:jdField_a_of_type_Int	I
    //   156: aload_0
    //   157: getfield 74	bbvy:jdField_a_of_type_Bbvp	Lbbvp;
    //   160: iload_2
    //   161: putfield 449	bbvp:jdField_b_of_type_Int	I
    //   164: aload_0
    //   165: getfield 74	bbvy:jdField_a_of_type_Bbvp	Lbbvp;
    //   168: aload 5
    //   170: putfield 450	bbvp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   173: aload_0
    //   174: iconst_0
    //   175: iconst_1
    //   176: invokevirtual 452	bbvy:a	(ZZ)V
    //   179: aload_0
    //   180: monitorexit
    //   181: iconst_0
    //   182: ireturn
    //   183: ldc_w 454
    //   186: aload_1
    //   187: invokestatic 459	axrb:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: goto -101 -> 89
    //   193: astore_1
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	bbvy
    //   0	198	1	paramISuperPlayer	ISuperPlayer
    //   0	198	2	paramInt1	int
    //   0	198	3	paramInt2	int
    //   0	198	4	paramInt3	int
    //   0	198	5	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	89	193	finally
    //   89	132	193	finally
    //   132	173	193	finally
    //   173	181	193	finally
    //   183	190	193	finally
    //   194	196	193	finally
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "onInfo, msg = " + paramInt);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED ");
      }
      if ((this.jdField_a_of_type_Bbvp != null) && (this.jdField_a_of_type_Bbvp.h == 0L))
      {
        this.jdField_a_of_type_Bbvp.h = System.currentTimeMillis();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_VIDEO_DECODER_TYPE ");
        }
        if ((paramLong1 == 102L) && (this.jdField_a_of_type_Bbvp != null))
        {
          this.jdField_a_of_type_Bbvp.jdField_g_of_type_Int = 102;
          this.jdField_a_of_type_Bbvp.jdField_j_of_type_Int = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_BUFFERING_START ");
        }
        if (this.jdField_a_of_type_Bbvp != null)
        {
          paramISuperPlayer = this.jdField_a_of_type_Bbvp;
          paramISuperPlayer.jdField_b_of_type_Long += 1L;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_BUFFERING_END ");
        }
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_c_of_type_Long > 0L) && (this.jdField_a_of_type_Bbvp != null))
        {
          paramISuperPlayer = this.jdField_a_of_type_Bbvp;
          paramISuperPlayer.jdField_c_of_type_Long += this.jdField_c_of_type_Long - this.jdField_b_of_type_Long;
        }
        this.jdField_b_of_type_Long = 0L;
        this.jdField_c_of_type_Long = 0L;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_ALL_DOWNLOAD_FINISH ");
        }
        if ((this.jdField_a_of_type_Bbvs != null) && (this.jdField_a_of_type_Bbvs.jdField_a_of_type_Bbvx != null))
        {
          this.jdField_a_of_type_Bbvs.jdField_a_of_type_Bbvx.a(this.jdField_a_of_type_Long);
          continue;
          if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo))
          {
            paramLong1 = ((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).currentDownloadSize;
            if (QLog.isColorLevel()) {
              QLog.d(a(), 2, "onInfo, SuperPlayerMsg.TP_PLAYER_INFO_OBJECT_DOWNLOAD_PROGRESS_UPDATE, currentDownloadSize =  " + paramLong1);
            }
            if ((this.jdField_a_of_type_Bbvs != null) && (this.jdField_a_of_type_Bbvs.jdField_a_of_type_Bbvx != null))
            {
              this.jdField_a_of_type_Bbvs.jdField_a_of_type_Bbvx.b(this.jdField_a_of_type_Long, paramLong1);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d(a(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_CURRENT_LOOP_END ");
              }
              if ((this.jdField_a_of_type_Bbvs != null) && (this.jdField_a_of_type_Bbvs.jdField_a_of_type_Bbvx != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)) {
                this.jdField_a_of_type_Bbvs.jdField_a_of_type_Bbvx.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
              }
            }
          }
        }
      }
    }
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "onSeekComplete");
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramISuperPlayer = a();
      localStringBuilder = new StringBuilder().append("onVideoPrepared, mPlayer == null ? ");
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(paramISuperPlayer, 2, bool);
      try
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3))
        {
          if (QLog.isColorLevel()) {
            QLog.d(a(), 2, "onVideoPrepared, startPlayer.");
          }
          c();
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbvy
 * JD-Core Version:    0.7.0.1
 */