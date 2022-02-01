package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnCompletionListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class GuideVideoHandler
  implements IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPreparedListener
{
  private static final String[] m = { "N1T", "ZTE A2015", "MI 1S", "GT-S7568I", "ZTE N909" };
  private static final String[] n = { "SM-A7000", "HM NOTE 1S", "MI 2S" };
  private static final String[] o = { "vivo X6D" };
  private static final String[] p = { "MI 4" };
  private static final String[] q = { "Nexus 5" };
  private static final String[] r = { "Nexus 5" };
  private static final String[] s = { "OPPO R7sm" };
  private Uri a;
  private BaseActivity b;
  private TextureVideoView c;
  private MqqHandler d;
  private boolean e;
  private int f;
  private int g;
  private boolean h;
  private boolean i;
  private GuideVideoHandler.GuideVideoCallBack j;
  private long k;
  private volatile boolean l;
  
  public static boolean a(String[] paramArrayOfString)
  {
    String str = Build.MODEL;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNotSupportLoopVideo model=");
      localStringBuilder.append(str);
      QLog.d("LoginActivity.GuideVideoHandler", 2, localStringBuilder.toString());
    }
    if (str != null)
    {
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (str.equals(paramArrayOfString[i1])) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "handleError");
    }
    GuideVideoHandler.GuideVideoCallBack localGuideVideoCallBack = this.j;
    if (localGuideVideoCallBack != null) {
      localGuideVideoCallBack.a();
    }
  }
  
  public void a()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((TextureVideoView)localObject).isPlaying()))
    {
      this.f = this.c.getCurrentPosition();
      this.g = this.f;
      this.e = true;
      this.c.pause();
      a(this.b, this.d, this.f);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#pause# , mCurrentPosition = ");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("LoginActivity.GuideVideoHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @TargetApi(10)
  public void a(Context paramContext, MqqHandler paramMqqHandler, int paramInt)
  {
    if (this.l)
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("getVideoFrame isRetrieve=");
        paramContext.append(this.l);
        QLog.d("LoginActivity.GuideVideoHandler", 2, paramContext.toString());
      }
      return;
    }
    if (Build.VERSION.SDK_INT < 10)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD_MR1");
      }
      paramMqqHandler.sendEmptyMessage(101);
      return;
    }
    this.l = true;
    ThreadManager.postImmediately(new GuideVideoHandler.2(this, paramContext, paramInt, paramMqqHandler), null, false);
  }
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MediaPlayer onCompletion has been called.   at ");
      localStringBuilder.append(paramIMediaPlayer.k());
      localStringBuilder.append(" mIsPause");
      localStringBuilder.append(this.e);
      QLog.d("LoginActivity.GuideVideoHandler", 2, localStringBuilder.toString());
    }
    this.f = paramIMediaPlayer.k();
    if (!this.e)
    {
      paramIMediaPlayer.c();
      paramIMediaPlayer.a(true);
    }
    if ((a(o)) && (!this.e))
    {
      this.c.setVideoURI(this.a);
      this.c.start();
    }
  }
  
  public boolean a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    paramIMediaPlayer = new StringBuilder(64);
    paramIMediaPlayer.append("bgVideo error-- what=");
    paramIMediaPlayer.append(paramInt1);
    paramIMediaPlayer.append(" extra=");
    paramIMediaPlayer.append(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, paramIMediaPlayer.toString());
    }
    e();
    paramIMediaPlayer = Build.MODEL;
    if (paramIMediaPlayer != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("crashModel", paramIMediaPlayer);
      StatisticCollector.getInstance(this.b.getApplicationContext()).collectPerformance(null, "newHandGuide_error", true, 0L, 0L, localHashMap, "", false);
    }
    return true;
  }
  
  public void a_(IMediaPlayer paramIMediaPlayer)
  {
    if (this.b.app != null) {
      this.b.app.setTalkbackSwitch();
    }
    if (QLog.isColorLevel())
    {
      paramIMediaPlayer = new StringBuilder();
      paramIMediaPlayer.append("MediaPlayer onPrepared has been called. talkback=");
      paramIMediaPlayer.append(AppSetting.e);
      paramIMediaPlayer.append(" videoPrepareTime=");
      paramIMediaPlayer.append(System.currentTimeMillis() - this.k);
      QLog.d("LoginActivity.GuideVideoHandler", 2, paramIMediaPlayer.toString());
    }
  }
  
  public boolean a_(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      if (QLog.isColorLevel())
      {
        paramIMediaPlayer = new StringBuilder();
        paramIMediaPlayer.append("onInfo what===>");
        paramIMediaPlayer.append(paramInt1);
        QLog.d("LoginActivity.GuideVideoHandler", 2, paramIMediaPlayer.toString());
      }
      if (a(r)) {
        this.d.sendEmptyMessage(103);
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("play has been called. pause :");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" isStartVideo:");
      ((StringBuilder)localObject).append(this.h);
      QLog.d("LoginActivity.GuideVideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (this.e)
    {
      this.c.start();
      this.c.seekTo(this.f);
      this.e = false;
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "resume play.");
      }
      this.d.sendEmptyMessageDelayed(102, 100L);
      return;
    }
    if ((this.c.isPlaying()) && ((this.g != this.c.getCurrentPosition()) || (a(r))))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playing. mVideoViewPosition=");
        ((StringBuilder)localObject).append(this.c.getCurrentPosition());
        ((StringBuilder)localObject).append(" mPausePosition=");
        ((StringBuilder)localObject).append(this.g);
        QLog.d("LoginActivity.GuideVideoHandler", 2, ((StringBuilder)localObject).toString());
      }
      if ((!a(r)) || (this.i))
      {
        this.d.sendEmptyMessage(103);
        this.i = false;
      }
    }
    else if (!this.h)
    {
      localObject = this.a;
      if (localObject != null)
      {
        this.c.setVideoURI((Uri)localObject);
        this.c.start();
        this.h = true;
        this.k = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start to play. videoStarTime=");
          ((StringBuilder)localObject).append(this.k);
          QLog.d("LoginActivity.GuideVideoHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (localObject == null)
      {
        e();
      }
    }
    else if (this.b.isResume())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "not playing.");
      }
      this.d.sendEmptyMessageDelayed(102, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideVideoHandler
 * JD-Core Version:    0.7.0.1
 */