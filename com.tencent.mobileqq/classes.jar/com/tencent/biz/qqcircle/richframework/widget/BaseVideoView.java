package com.tencent.biz.qqcircle.richframework.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.report.QCircleVideoReporter;
import com.tencent.biz.qqcircle.richframework.video.QCirclePlayer;
import com.tencent.biz.qqcircle.richframework.video.QCirclePlayerCallback;
import com.tencent.biz.qqcircle.richframework.widget.timer.IVideoTimerListener;
import com.tencent.biz.qqcircle.richframework.widget.timer.QCircleVideoTimerManager;
import com.tencent.biz.qqcircle.richframework.widget.video.QCircleVideoManager;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.sender.aspect.SenderAspectProcessor;
import com.tencent.richframework.sender.aspect.ThrottlingDelay;
import com.tencent.richframework.sender.util.EventControlUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import feedcloud.FeedCloudCommon.Entry;
import java.lang.reflect.Method;
import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.Factory;

public abstract class BaseVideoView
  extends BaseWidgetView
  implements Handler.Callback, SeekBar.OnSeekBarChangeListener, QCirclePlayerCallback, IVideoTimerListener
{
  protected boolean a;
  protected boolean b;
  protected boolean c;
  protected URLImageView d;
  protected BaseVideoViewListenerSets e;
  private Handler f;
  private boolean g;
  private QCirclePlayer h;
  private volatile String i;
  private BaseVideoView.InitListener j;
  
  static {}
  
  public BaseVideoView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void A()
  {
    View localView = getChildAt(0);
    if ((localView instanceof ISPlayerVideoView))
    {
      removeView(localView);
      QLog.d("BaseVideoView", 1, "remove is player");
    }
  }
  
  private void B()
  {
    QCircleVideoTimerManager.a().b(this);
  }
  
  private int a(int paramInt)
  {
    return Math.max(Math.min(paramInt / 100, 340), 60);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = -1001;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = Boolean.valueOf(true);
    getMainHandler().sendMessage(localMessage);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("BaseVideoView", 1, "generateUniqueKey():playUrl is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    this.i = localStringBuilder.toString();
  }
  
  private void a(boolean paramBoolean)
  {
    getMainHandler().post(new BaseVideoView.3(this, paramBoolean));
  }
  
  private void b(int paramInt)
  {
    getMainHandler().post(new BaseVideoView.2(this, paramInt));
  }
  
  private QCirclePlayer getQCirclePlayer()
  {
    return this.h;
  }
  
  @ThrottlingDelay(a="setSeekBar", b=100L)
  private void setSeekBarDuration(SeekBar paramSeekBar)
  {
    Object localObject = Factory.makeJP(k, this, this, paramSeekBar);
    SenderAspectProcessor localSenderAspectProcessor = SenderAspectProcessor.a();
    ProceedingJoinPoint localProceedingJoinPoint = new BaseVideoView.AjcClosure1(new Object[] { this, paramSeekBar, localObject }).linkClosureAndJoinPoint(69648);
    localObject = l;
    paramSeekBar = (SeekBar)localObject;
    if (localObject == null)
    {
      paramSeekBar = BaseVideoView.class.getDeclaredMethod("setSeekBarDuration", new Class[] { SeekBar.class }).getAnnotation(ThrottlingDelay.class);
      l = paramSeekBar;
    }
    localSenderAspectProcessor.a(localProceedingJoinPoint, (ThrottlingDelay)paramSeekBar);
  }
  
  private void y()
  {
    if (getProgressBar() != null) {
      getProgressBar().setOnSeekBarChangeListener(this);
    }
  }
  
  private void z()
  {
    if (a()) {
      return;
    }
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("BaseVideoView", 1, "[addVideoView] player not ready");
      return;
    }
    A();
    addView(getQCirclePlayer().k(), 0, new FrameLayout.LayoutParams(-1, -1));
    QLog.w("BaseVideoView", 1, "[addVideoView] player  ready");
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    b(paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void a(long paramLong)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("BaseVideoView", 1, "[seek] player not ready");
      return;
    }
    getQCirclePlayer().a(paramLong);
  }
  
  protected abstract void a(long paramLong1, long paramLong2);
  
  protected void a(long paramLong, String paramString, Object paramObject, List<FeedCloudCommon.Entry> paramList)
  {
    QCircleVideoReporter.a().a(paramLong, paramString, paramObject, paramList);
  }
  
  public void a(Bitmap paramBitmap)
  {
    URLImageView localURLImageView = this.d;
    if ((localURLImageView != null) && (paramBitmap != null))
    {
      localURLImageView.setImageBitmap(paramBitmap);
      r();
    }
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    if ((getProgressBar() != null) && (getSuperPlayer() != null))
    {
      y();
      getProgressBar().setMax((int)paramISuperPlayer.getDurationMs());
    }
    BaseVideoViewListenerSets localBaseVideoViewListenerSets = this.e;
    if (localBaseVideoViewListenerSets != null) {
      localBaseVideoViewListenerSets.a(paramISuperPlayer);
    }
  }
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    b(paramSuperPlayerVideoInfo);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected void afterInflateView(Context paramContext, int paramInt)
  {
    y();
  }
  
  public void b()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("BaseVideoView", 1, "[pause] player not ready");
      return;
    }
    if (getQCirclePlayer().n())
    {
      getQCirclePlayer().b();
      this.a = true;
      b(getQCirclePlayer().j(), getQCirclePlayer().o());
      a(false);
    }
  }
  
  protected abstract void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  protected abstract void b(long paramLong1, long paramLong2);
  
  public void b(ISuperPlayer paramISuperPlayer) {}
  
  protected void b(SuperPlayerVideoInfo paramSuperPlayerVideoInfo) {}
  
  public void c()
  {
    BaseVideoView.InitListener localInitListener = this.j;
    if (localInitListener != null) {
      localInitListener.a();
    }
    z();
    if (!this.g) {
      i();
    }
  }
  
  public void d()
  {
    l();
  }
  
  public void e() {}
  
  public void f()
  {
    BaseVideoViewListenerSets localBaseVideoViewListenerSets = this.e;
    if (localBaseVideoViewListenerSets != null) {
      localBaseVideoViewListenerSets.b();
    }
  }
  
  public void g()
  {
    BaseVideoViewListenerSets localBaseVideoViewListenerSets = this.e;
    if (localBaseVideoViewListenerSets != null) {
      localBaseVideoViewListenerSets.c();
    }
  }
  
  public Handler getMainHandler()
  {
    if (this.f == null) {
      this.f = new Handler(Looper.getMainLooper(), this);
    }
    return this.f;
  }
  
  public boolean getOutPutMute()
  {
    if (getQCirclePlayer() == null) {
      return false;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("BaseVideoView", 1, "[getOutPutMute] player not ready");
      return false;
    }
    return getQCirclePlayer().l();
  }
  
  public abstract SeekBar getProgressBar();
  
  public Object getReportData()
  {
    return getData();
  }
  
  public ISuperPlayer getSuperPlayer()
  {
    if (getQCirclePlayer() == null) {
      return null;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("BaseVideoView", 1, "[getSuperPlayer] player not ready");
      return null;
    }
    return getQCirclePlayer().i();
  }
  
  public URLImageView getVideoCover()
  {
    return this.d;
  }
  
  public long getVideoPlayId()
  {
    if (getQCirclePlayer() != null) {
      return getQCirclePlayer().p();
    }
    return -1L;
  }
  
  public void h()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("BaseVideoView", 1, "[start] player not ready");
      return;
    }
    if (!getQCirclePlayer().n())
    {
      setInterrupt(false);
      getQCirclePlayer().a();
      this.a = false;
      u();
      j();
      a(true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == -1001)
    {
      BaseVideoViewListenerSets localBaseVideoViewListenerSets = this.e;
      if (localBaseVideoViewListenerSets != null) {
        localBaseVideoViewListenerSets.a("", paramMessage.arg2, paramMessage.arg1);
      }
    }
    return false;
  }
  
  public void i()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("BaseVideoView", 1, "[replay] player not ready");
      return;
    }
    getQCirclePlayer().d();
    this.a = false;
  }
  
  protected abstract void j();
  
  protected boolean k()
  {
    return false;
  }
  
  protected void l()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((URLImageView)localObject).setVisibility(8);
    }
    localObject = this.e;
    if (localObject != null) {
      ((BaseVideoViewListenerSets)localObject).a();
    }
  }
  
  protected boolean m()
  {
    QLog.w("BaseVideoView", 1, "biz has cancel perf report");
    return false;
  }
  
  public void n()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    getQCirclePlayer().r();
    getQCirclePlayer().a(m() ^ true);
    getQCirclePlayer().a(this, null);
  }
  
  public boolean o()
  {
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.g = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g = true;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.c)
    {
      setSeekBarDuration(paramSeekBar);
      BaseVideoViewListenerSets localBaseVideoViewListenerSets = this.e;
      if (localBaseVideoViewListenerSets != null) {
        localBaseVideoViewListenerSets.a(paramSeekBar, paramInt, paramBoolean);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    this.c = true;
    if (!getQCirclePlayer().h())
    {
      QLog.w("BaseVideoView", 1, "[onStartTrackingTouch] player not ready");
      return;
    }
    getQCirclePlayer().g();
    a(getQCirclePlayer().j(), getQCirclePlayer().o());
    BaseVideoViewListenerSets localBaseVideoViewListenerSets = this.e;
    if (localBaseVideoViewListenerSets != null) {
      localBaseVideoViewListenerSets.a(paramSeekBar);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (getQCirclePlayer() != null)
    {
      this.c = false;
      if (!getQCirclePlayer().h())
      {
        QLog.w("BaseVideoView", 1, "[onStopTrackingTouch] player not ready");
      }
      else
      {
        getQCirclePlayer().a(paramSeekBar.getProgress(), paramSeekBar.getMax());
        BaseVideoViewListenerSets localBaseVideoViewListenerSets = this.e;
        if (localBaseVideoViewListenerSets != null) {
          localBaseVideoViewListenerSets.b(paramSeekBar);
        }
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  protected void p()
  {
    B();
    getMainHandler().removeCallbacksAndMessages(null);
    getMainHandler().post(new BaseVideoView.1(this));
  }
  
  protected void q()
  {
    URLImageView localURLImageView = this.d;
    if (localURLImageView != null) {
      localURLImageView.setVisibility(0);
    }
  }
  
  public void r()
  {
    URLImageView localURLImageView = this.d;
    if (localURLImageView != null) {
      localURLImageView.setVisibility(0);
    }
  }
  
  public void release()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    QCircleVideoManager.a().a(this.i);
    A();
    B();
    this.a = false;
    if (getProgressBar() != null)
    {
      getProgressBar().setProgress(0);
      getProgressBar().setOnSeekBarChangeListener(null);
    }
    this.d = null;
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public void s()
  {
    URLImageView localURLImageView = this.d;
    if (localURLImageView != null) {
      localURLImageView.setVisibility(8);
    }
  }
  
  public void setBaseVideoViewListenerSets(BaseVideoViewListenerSets paramBaseVideoViewListenerSets)
  {
    this.e = paramBaseVideoViewListenerSets;
  }
  
  public void setInitListener(BaseVideoView.InitListener paramInitListener)
  {
    this.j = paramInitListener;
  }
  
  public void setInterrupt(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h()) {
      QLog.w("BaseVideoView", 1, "[setLoopBack] player not ready");
    }
    getQCirclePlayer().b(paramBoolean);
  }
  
  public void setLoopBack(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h()) {
      QLog.w("BaseVideoView", 1, "[setLoopBack] player not ready");
    }
    getQCirclePlayer().a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("BaseVideoView", 1, "[setOutPutMute] player not ready");
      return;
    }
    getQCirclePlayer().c(paramBoolean);
  }
  
  public void setVideoCover(URLImageView paramURLImageView)
  {
    this.d = paramURLImageView;
  }
  
  public void setVideoPath(String paramString1, String paramString2, int paramInt)
  {
    a(paramString2);
    p();
    this.h = QCircleVideoManager.a().a(this.i, a());
    if (getQCirclePlayer() == null) {
      return;
    }
    n();
    getQCirclePlayer().a(paramString1, paramString2, paramInt);
  }
  
  public void t()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    getQCirclePlayer().c();
    this.a = false;
    B();
  }
  
  public void u()
  {
    B();
    QCircleVideoTimerManager.a().a(this);
  }
  
  @CallSuper
  protected void v()
  {
    ISuperPlayer localISuperPlayer = getSuperPlayer();
    if (localISuperPlayer == null) {
      return;
    }
    double d2 = localISuperPlayer.getCurrentPositionMs();
    float f1 = (float)localISuperPlayer.getDurationMs();
    int m = 0;
    if ((f1 == 0.0F) && (getProgressBar() != null)) {
      getProgressBar().setProgress(0);
    }
    if ((!this.c) && (d2 != 0.0D))
    {
      if (localISuperPlayer.isPausing()) {
        return;
      }
      int n = (int)f1;
      if (EventControlUtils.a("BaseVideoVieweventControl", a(n)))
      {
        a((int)d2, n);
        if (getProgressBar() != null)
        {
          double d1 = getProgressBar().getMax();
          double d3 = f1;
          Double.isNaN(d2);
          Double.isNaN(d3);
          d2 /= d3;
          Double.isNaN(d1);
          m = (int)(d1 * d2);
        }
        b(m);
      }
    }
  }
  
  public boolean w()
  {
    return this.b;
  }
  
  public void x()
  {
    v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */