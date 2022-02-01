package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.LongVideoUrlCacheManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import java.util.HashMap;

public abstract class VideoPlayController
{
  public VideoPlayMedioInfo a;
  View b;
  MediaPlayHelper c = new MediaPlayHelper();
  FrameLayout d;
  VideoPlayController.EventHandler e = new VideoPlayController.EventHandler(this, null);
  Activity f;
  VideoPlayController.VideoPlayerStateListener g;
  protected IAIOImageProvider h;
  protected boolean i = false;
  private final String j = "carverW VideoPlayController";
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private Runnable o = new VideoPlayController.1(this);
  
  private void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "#setupVideoView  ");
    }
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "#setupVideoView  layout is null#");
      }
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.b.setLayoutParams(localLayoutParams);
    this.b.setVisibility(0);
    this.d.addView(this.b);
    b(paramActivity);
  }
  
  private void a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "#initMediaPlayVideo  ");
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.c;
    if (localObject != null)
    {
      this.b = ((MediaPlayHelper)localObject).a(this.f, this.e, paramVideoPlayMedioInfo, this.h);
      if (this.b != null)
      {
        a(this.f);
        paramVideoPlayMedioInfo = new HashMap();
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "previewVideoViewCreateSuc", true, 0L, 0L, paramVideoPlayMedioInfo, null);
      }
    }
  }
  
  private void b(Activity paramActivity)
  {
    if (!this.l)
    {
      View localView = this.b;
      if (localView != null)
      {
        MediaPlayHelper localMediaPlayHelper = this.c;
        if (localMediaPlayHelper != null)
        {
          localMediaPlayHelper.a(paramActivity, (IVideoViewBase)localView);
          this.l = true;
        }
      }
    }
  }
  
  private void w()
  {
    if (this.l)
    {
      localObject = this.c;
      if (localObject != null) {
        ((MediaPlayHelper)localObject).c();
      }
    }
    if (VersionUtils.b())
    {
      localObject = this.f;
      if (localObject != null) {
        ((AudioManager)((Activity)localObject).getSystemService("audio")).abandonAudioFocus(null);
      }
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((Activity)localObject).runOnUiThread(new VideoPlayController.2(this));
    }
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = HardCodeUtil.a(2131913524);
    Object localObject2 = this.f;
    if (localObject2 != null) {
      localObject1 = ((Activity)localObject2).getString(2131916631);
    }
    Object localObject3;
    if (paramInt1 == 101)
    {
      localObject2 = this.a;
      if ((localObject2 != null) && (((VideoPlayMedioInfo)localObject2).c != null) && (!StringUtil.isEmpty(this.a.e)))
      {
        localObject2 = this.a.c;
        int i2 = localObject2.length;
        int i1 = 0;
        while (i1 < i2)
        {
          localObject3 = localObject2[i1];
          if (!StringUtil.isEmpty((String)localObject3)) {
            InnerDns.getInstance().reportBadIp(this.a.e, InnerDns.getHostFromUrl((String)localObject3), 1005);
          }
          i1 += 1;
        }
        LongVideoUrlCacheManager.a().b();
      }
    }
    localObject2 = localObject1;
    if (paramInt1 == 122) {
      if (paramInt2 != 204)
      {
        localObject2 = localObject1;
        if (paramInt2 != 202) {}
      }
      else
      {
        localObject3 = this.f;
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = ((Activity)localObject3).getString(2131916628);
        }
      }
    }
    localObject1 = this.g;
    if (localObject1 != null) {
      ((VideoPlayController.VideoPlayerStateListener)localObject1).a(this.a, paramInt1, paramInt2, (String)localObject2);
    }
  }
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(View paramView);
  
  public void a(View paramView, VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if ((paramView != null) && (paramVideoPlayMedioInfo != null))
    {
      if (this.c == null) {
        return;
      }
      j();
      Object localObject = this.d;
      if (localObject != null) {
        ((FrameLayout)localObject).removeAllViews();
      }
      if (paramView == null)
      {
        a();
        this.d = null;
        this.f = null;
      }
      else
      {
        a(paramView);
        this.d = ((FrameLayout)paramView.findViewById(2131440627));
      }
      localObject = this.b;
      if (localObject != null) {
        ((IVideoViewBase)localObject).removeViewCallBack(this.c);
      }
      this.e.removeCallbacks(this.o);
      this.m = false;
      this.n = false;
      a(false);
      this.b = null;
      this.i = false;
      this.c.a();
      this.l = false;
      this.k = 0;
      this.a = paramVideoPlayMedioInfo;
      if ((this.a != null) && (paramView != null) && (paramView.getContext() != null))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onItemSelect no == ");
          ((StringBuilder)localObject).append(this.a.hashCode());
          ((StringBuilder)localObject).append(" id=");
          ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.k);
          QLog.d("carverW VideoPlayController", 2, ((StringBuilder)localObject).toString());
        }
        this.f = ((Activity)paramView.getContext());
        a(this.a);
      }
    }
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if ((this.a != null) && (paramAIOShortVideoData.L != this.a.k))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetUrl data.id = ");
      ((StringBuilder)localObject).append(paramAIOShortVideoData.L);
      ((StringBuilder)localObject).append(" mInfo,id=");
      ((StringBuilder)localObject).append(this.a.k);
      QLog.d("carverW VideoPlayController", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.g != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetUrl data=");
        ((StringBuilder)localObject).append(paramAIOShortVideoData.L);
        ((StringBuilder)localObject).append(" isNeedShowCenterBtn=");
        ((StringBuilder)localObject).append(paramBoolean2);
        ((StringBuilder)localObject).append(" isStart=");
        ((StringBuilder)localObject).append(paramBoolean1);
        QLog.d("carverW VideoPlayController", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new VideoPlayMedioInfo();
      ((VideoPlayMedioInfo)localObject).k = paramAIOShortVideoData.L;
      ((VideoPlayMedioInfo)localObject).l = paramAIOShortVideoData.M;
      this.g.a((VideoPlayMedioInfo)localObject, paramBoolean1);
      if (paramBoolean2)
      {
        b(0);
        return;
      }
      b(8);
    }
  }
  
  public void a(IAIOImageProvider paramIAIOImageProvider)
  {
    this.h = paramIAIOImageProvider;
  }
  
  public void a(VideoPlayController.VideoPlayerStateListener paramVideoPlayerStateListener)
  {
    this.g = paramVideoPlayerStateListener;
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(int paramInt);
  
  public abstract boolean b();
  
  public void c()
  {
    VideoPlayMedioInfo localVideoPlayMedioInfo = this.a;
    if (localVideoPlayMedioInfo != null) {
      localVideoPlayMedioInfo.j = true;
    }
    b(8);
    a(8, "");
  }
  
  public void c(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void d(int paramInt)
  {
    MediaPlayHelper localMediaPlayHelper = this.c;
    if (localMediaPlayHelper != null) {
      localMediaPlayHelper.b(paramInt);
    }
  }
  
  public boolean d()
  {
    if (this.k == 0) {
      i();
    }
    return this.a.a;
  }
  
  public void e()
  {
    this.i = true;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemClick  onItemClick mCurInfo is null");
      }
      return;
    }
    this.m = true;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemClick curState=");
      localStringBuilder.append(this.k);
      localStringBuilder.append(" no = ");
      localStringBuilder.append(this.a.hashCode());
      localStringBuilder.append(" id=");
      localStringBuilder.append(this.a.k);
      QLog.d("carverW VideoPlayController", 2, localStringBuilder.toString());
    }
    int i1 = this.k;
    if (i1 == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onItemClick  isComplete=");
        localStringBuilder.append(this.n);
        QLog.d("carverW VideoPlayController", 2, localStringBuilder.toString());
      }
      if (this.n)
      {
        if (!this.a.h) {
          i();
        }
        this.n = false;
      }
      a(true);
      return;
    }
    if (i1 == 2)
    {
      a(true);
      return;
    }
    if (i1 == 3)
    {
      n();
      return;
    }
    if (i1 == 1)
    {
      j();
      this.k = 4;
      return;
    }
    if (i1 == 4) {
      n();
    }
  }
  
  public void i()
  {
    if (this.c != null)
    {
      Object localObject = this.a;
      if (localObject != null) {
        if (!((VideoPlayMedioInfo)localObject).a)
        {
          if (this.a.b != null) {
            this.c.a(this.a.b, 0L);
          }
        }
        else
        {
          if (this.a.f == null) {
            localObject = "0";
          } else {
            localObject = String.valueOf(this.a.f.videoFileTime);
          }
          String str;
          if (this.a.f == null) {
            str = "";
          } else {
            str = this.a.f.md5;
          }
          this.c.a(this.a.a(), (String)localObject, this.a.c, 0L, str, this.f);
        }
      }
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = Pasue ");
    }
    this.k = 4;
    w();
  }
  
  public void k()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  play = onResume mVideoState=");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("carverW VideoPlayController", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.l) && (this.k == 1))
    {
      a(true);
      localObject = this.f;
      if (localObject != null) {
        ((Activity)localObject).runOnUiThread(new VideoPlayController.3(this));
      }
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = onDestory ");
    }
    this.a = null;
    Object localObject = this.c;
    if (localObject != null)
    {
      ((MediaPlayHelper)localObject).k();
      this.c.a();
      this.c = null;
    }
    this.l = false;
    this.f = null;
    localObject = this.e;
    if (localObject != null)
    {
      ((VideoPlayController.EventHandler)localObject).removeCallbacksAndMessages(null);
      this.e = null;
    }
  }
  
  public void m() {}
  
  protected void n()
  {
    if ((VersionUtils.b()) && (!this.a.m))
    {
      localActivity = this.f;
      if (localActivity != null) {
        ((AudioManager)localActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    }
    this.c.d();
    Activity localActivity = this.f;
    if (localActivity != null) {
      localActivity.runOnUiThread(new VideoPlayController.4(this));
    }
    this.e.postDelayed(this.o, 200L);
  }
  
  public int o()
  {
    return this.k;
  }
  
  public boolean p()
  {
    MediaPlayHelper localMediaPlayHelper = this.c;
    if (localMediaPlayHelper != null) {
      return localMediaPlayHelper.h();
    }
    return false;
  }
  
  public long q()
  {
    MediaPlayHelper localMediaPlayHelper = this.c;
    if (localMediaPlayHelper != null) {
      return localMediaPlayHelper.f();
    }
    return 0L;
  }
  
  public long r()
  {
    return this.c.g();
  }
  
  public long s()
  {
    return this.c.b();
  }
  
  public long t()
  {
    return this.c.i();
  }
  
  public void u()
  {
    MediaPlayHelper localMediaPlayHelper = this.c;
    if (localMediaPlayHelper != null) {
      localMediaPlayHelper.e();
    }
  }
  
  public void v()
  {
    MediaPlayHelper localMediaPlayHelper = this.c;
    if (localMediaPlayHelper != null) {
      localMediaPlayHelper.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayController
 * JD-Core Version:    0.7.0.1
 */