package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.player.report.IWSPlayerReport;
import com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class WSPlayerManager
  implements WSVideoPluginInstall.OnVideoPluginInstallListener
{
  private static final Object a = new Object();
  private boolean A = false;
  private int B;
  private int C;
  private int D = -1;
  private QQAppInterface b;
  private Context c = BaseApplicationImpl.getApplication().getApplicationContext();
  private WSVideoPluginInstall d;
  private WSPlayerParam e;
  private WSPlayerParam f;
  private ArrayList<WSPlayerStatusListener> g;
  private WSVideoPreDownloadManager h;
  private WSPlayerForNetInfoHandler i;
  private WSPlayerManager.MediaPlayListenerAdapterImpl j = new WSPlayerManager.MediaPlayListenerAdapterImpl(this, null);
  private ConcurrentHashMap<WSPlayerWrapper, Object> k = new ConcurrentHashMap();
  private Handler l = new WSPlayerManager.PlayerHandler(this, Looper.getMainLooper());
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = true;
  private boolean s = false;
  private boolean t;
  private boolean u;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private boolean z = false;
  
  public WSPlayerManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.d = new WSVideoPluginInstall();
    this.d.a(this);
    this.g = new ArrayList();
    this.i = new WSPlayerForNetInfoHandler(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.c, this.i);
    this.t = true;
  }
  
  private void a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (paramWSPlayerWrapper == null) {
      return;
    }
    paramWSPlayerWrapper.M();
    int i1 = paramWSPlayerWrapper.E();
    if ((i1 != 7) && (i1 != 8) && (i1 != 0))
    {
      if (i1 == 6) {
        return;
      }
      paramWSPlayerWrapper.k();
      ThreadManager.excute(new WSPlayerManager.6(this, paramWSPlayerWrapper), 16, null, true);
    }
  }
  
  private WSPlayerWrapper b(WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (paramWSPlayerWrapper == y()) {
      return paramWSPlayerWrapper;
    }
    return null;
  }
  
  private String b(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam == null) {
      return "WSPlayerParam is null!";
    }
    if (paramWSPlayerParam.c == null) {
      return "VideoInfo is null!";
    }
    return paramWSPlayerParam.c.e;
  }
  
  private void c(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam != null) {
      a(paramWSPlayerParam.d);
    }
  }
  
  private void c(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if (paramWSPlayerParam == null) {
      return;
    }
    if (paramWSPlayerParam.b != null)
    {
      localObject = paramWSPlayerParam.b.a();
      if ((localObject != null) && (((View)localObject).getParent() != paramWSPlayerParam.a))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:");
        localStringBuilder.append(((View)localObject).getParent());
        localStringBuilder.append(", playerParam.mVideoLayout:");
        localStringBuilder.append(paramWSPlayerParam.a);
        WSLog.d("WS_VIDEO_PLAYER", localStringBuilder.toString());
        paramWSPlayerParam.d = null;
        paramWSPlayerParam.b = null;
      }
    }
    Object localObject = d(paramWSPlayerParam);
    if ((localObject != null) && (((WSPlayerWrapper)localObject).o() == null))
    {
      WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
      paramWSPlayerParam.d.a(paramWSPlayerParam.c);
      d(paramWSPlayerParam, paramBoolean);
      return;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((WSPlayerWrapper)localObject).o() != null)
      {
        ((WSPlayerWrapper)localObject).b(false);
        WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] videoPlayer.tag isn't null!");
        bool1 = true;
      }
    }
    ThreadManager.post(new WSPlayerManager.2(this, new WeakReference(paramWSPlayerParam), bool1, paramBoolean), 5, null, true);
  }
  
  private boolean c(WSPlayerWrapper paramWSPlayerWrapper)
  {
    return b(paramWSPlayerWrapper) != null;
  }
  
  private WSPlayerWrapper d(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam != null) {
      return paramWSPlayerParam.d;
    }
    return null;
  }
  
  private void d(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    Object localObject1 = d(paramWSPlayerParam);
    if ((paramWSPlayerParam != null) && (localObject1 != null) && (paramWSPlayerParam.a != null))
    {
      paramWSPlayerParam.a.setKeepScreenOn(true);
      if (paramWSPlayerParam.b == null)
      {
        WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] videoView null. goto getVideoViewScroll.");
        localObject2 = ((WSPlayerWrapper)localObject1).c();
        if (localObject2 != null)
        {
          View localView = ((IWSVideoView)localObject2).a();
          if (localView != null)
          {
            paramWSPlayerParam.b = ((IWSVideoView)localObject2);
            paramWSPlayerParam.a.addView(localView, new ViewGroup.LayoutParams(-1, -1));
            ((WSPlayerWrapper)localObject1).a((IWSVideoView)localObject2);
            if (paramWSPlayerParam.k != null) {
              paramWSPlayerParam.k.b(paramWSPlayerParam);
            }
            if ((paramWSPlayerParam.c == null) || (paramWSPlayerParam.c.b <= 0) || (paramWSPlayerParam.c.c <= 0) || (paramWSPlayerParam.c.c >= 10000) || (paramWSPlayerParam.c.b >= 10000)) {
              break label234;
            }
            ((IWSVideoView)localObject2).a(paramWSPlayerParam.c.b, paramWSPlayerParam.c.c);
            break label234;
          }
        }
        if (paramWSPlayerParam.k != null) {
          paramWSPlayerParam.k.a(paramWSPlayerParam, 999, 999, null);
        }
        paramWSPlayerParam.d = null;
        return;
      }
      label234:
      int i1;
      if (this.m) {
        i1 = 2;
      } else {
        i1 = paramWSPlayerParam.e;
      }
      ((WSPlayerWrapper)localObject1).b(i1);
      boolean bool;
      if ((!this.w) && (!this.s)) {
        bool = false;
      } else {
        bool = true;
      }
      ((WSPlayerWrapper)localObject1).d(bool);
      ((WSPlayerWrapper)localObject1).a(this.t);
      ((WSPlayerWrapper)localObject1).e(paramWSPlayerParam.i);
      ((WSPlayerWrapper)localObject1).b().b(this.u);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[WSPlayerManager.java][innerPlayVideo] xyAxis:");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", isMuted:");
      ((StringBuilder)localObject2).append(this.u);
      ((StringBuilder)localObject2).append(", mPreOutputFirstFrame:");
      ((StringBuilder)localObject2).append(this.t);
      WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject2).toString());
      localObject2 = paramWSPlayerParam.b.a();
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      ThreadManager.excute(new WSPlayerManager.PlayStartVideoRunnable(this, paramWSPlayerParam, (WSPlayerWrapper)localObject1, paramBoolean), 16, null, true);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[WSPlayerManager.java][innerPlayVideo] playParam:");
    ((StringBuilder)localObject1).append(paramWSPlayerParam);
    WSLog.d("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject1).toString());
  }
  
  private IWSPlayerReport e(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam != null) {
      return paramWSPlayerParam.l;
    }
    return null;
  }
  
  private void e(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if (paramWSPlayerParam != null)
    {
      if (paramWSPlayerParam.l == null) {
        paramWSPlayerParam.l = new WSPlayerReportImpl();
      }
      IWSPlayerReport localIWSPlayerReport = paramWSPlayerParam.l;
      String str;
      if (paramWSPlayerParam.c != null) {
        str = paramWSPlayerParam.c.a;
      } else {
        str = "";
      }
      localIWSPlayerReport.a(str, paramBoolean, paramWSPlayerParam.j);
    }
  }
  
  private String f(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam == null) {
      return "WSPlayerParam is null.";
    }
    if (paramWSPlayerParam.c == null) {
      return "VideoInfo is null.";
    }
    return paramWSPlayerParam.c.g;
  }
  
  private WSPlayerParam g(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam == this.e) {
      return paramWSPlayerParam;
    }
    return null;
  }
  
  private boolean h(WSPlayerParam paramWSPlayerParam)
  {
    return g(paramWSPlayerParam) != null;
  }
  
  private WSPlayerWrapper v()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return null;
    }
    localObject = new WSPlayerWrapper((Context)localObject);
    ((WSPlayerWrapper)localObject).a(this.j);
    return localObject;
  }
  
  private void w()
  {
    if (f())
    {
      d();
      return;
    }
    if ((e()) || (i()) || (h()) || (l())) {
      b(this.e, false);
    }
  }
  
  private void x()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<------------------------------- [WSPlayerManager.java][onVideoStart] title:");
    ((StringBuilder)localObject).append(f(this.e));
    WSLog.g("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    this.l.removeMessages(-2);
    this.l.sendEmptyMessage(-2);
    this.l.post(new WSPlayerManager.4(this));
    localObject = e(this.e);
    if (localObject != null) {
      ((IWSPlayerReport)localObject).b(d(this.e));
    }
  }
  
  private WSPlayerWrapper y()
  {
    return d(this.e);
  }
  
  public long a()
  {
    if ((this.e != null) && (y() != null)) {
      return y().m();
    }
    return 0L;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.e != null) && (y() != null))
    {
      this.v = true;
      y().a(paramInt);
      if (paramBoolean)
      {
        WSPlayerParam localWSPlayerParam = this.e;
        if ((localWSPlayerParam != null) && (localWSPlayerParam.k != null))
        {
          long l1 = y().s();
          this.e.k.a(this.e, paramInt, l1);
        }
      }
      this.l.removeMessages(-2);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("===============================> [WSPlayerManager.java][prePlayVideo] title:");
    ((StringBuilder)localObject).append(f(paramWSPlayerParam));
    WSLog.g("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject).toString());
    if (paramWSPlayerParam == null)
    {
      WSLog.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
      return;
    }
    localObject = d(paramWSPlayerParam);
    if ((localObject != null) && (paramWSPlayerParam.h) && (((WSPlayerWrapper)localObject).o() == paramWSPlayerParam.c)) {
      return;
    }
    WSVideoPluginInstall localWSVideoPluginInstall = this.d;
    if ((localWSVideoPluginInstall != null) && (!localWSVideoPluginInstall.b()))
    {
      this.d.a();
      return;
    }
    if ((localObject == null) || (((WSPlayerWrapper)localObject).d()) || (((WSPlayerWrapper)localObject).E() == 6) || (((WSPlayerWrapper)localObject).E() == 7))
    {
      paramWSPlayerParam.h = true;
      this.f = paramWSPlayerParam;
      e(paramWSPlayerParam, true);
      if (this.f.k != null) {
        this.f.k.a(this.f);
      }
      c(paramWSPlayerParam, true);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][switchPlayerVideoViewLayout] startTime:");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    if (paramWSPlayerParam == null)
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
      return;
    }
    if ((paramWSPlayerParam.b != null) && (paramWSPlayerParam.a != null))
    {
      localObject = d(paramWSPlayerParam);
      if (localObject == null)
      {
        WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
        return;
      }
      this.e = paramWSPlayerParam;
      ((WSPlayerWrapper)localObject).b(paramWSPlayerParam.e);
      ((WSPlayerWrapper)localObject).a(paramWSPlayerParam.b, paramWSPlayerParam.a);
      paramWSPlayerParam.a.setKeepScreenOn(true);
      ((WSPlayerWrapper)localObject).a(this.j);
      this.l.removeMessages(-2);
      this.l.sendEmptyMessage(-2);
      if (paramBoolean) {
        w();
      }
      this.k.put(localObject, a);
      ((WSPlayerWrapper)localObject).y();
      this.l.post(new WSPlayerManager.1(this, paramWSPlayerParam));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:");
    ((StringBuilder)localObject).append(paramWSPlayerParam.b);
    ((StringBuilder)localObject).append(", videoLayout:");
    ((StringBuilder)localObject).append(paramWSPlayerParam.a);
    WSLog.d("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
  }
  
  public void a(WSPlayerStatusListener paramWSPlayerStatusListener)
  {
    ArrayList localArrayList = this.g;
    if ((localArrayList != null) && (!localArrayList.contains(paramWSPlayerStatusListener))) {
      this.g.add(paramWSPlayerStatusListener);
    }
  }
  
  public void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    this.h = paramWSVideoPreDownloadManager;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][onInstallComplete] success:");
    ((StringBuilder)localObject).append(paramBoolean);
    WSLog.d("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = this.e;
      if (localObject != null) {
        b((WSPlayerParam)localObject, false);
      }
    }
    else
    {
      this.e = null;
    }
  }
  
  public void b()
  {
    if (y() != null)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new WSPlayerManager.3(this));
        return;
      }
      WSPlayerWrapper localWSPlayerWrapper = y();
      if (localWSPlayerWrapper != null)
      {
        WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
        localWSPlayerWrapper.f();
        x();
      }
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("-------------------------------> [WSPlayerManager.java][playVideo] title:");
    ((StringBuilder)localObject1).append(f(paramWSPlayerParam));
    WSLog.g("WS_VIDEO_PLAYER", ((StringBuilder)localObject1).toString());
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.c != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[WSPlayerManager.java][playVideo] videoUrl:");
      ((StringBuilder)localObject1).append(paramWSPlayerParam.c.e);
      WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject1).toString());
      this.o = false;
      this.B = 0;
      this.p = false;
      this.q = false;
      this.v = false;
      this.e = paramWSPlayerParam;
      this.C = 0;
      localObject1 = this.g;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((WSPlayerStatusListener)((Iterator)localObject1).next()).a(this.e);
        }
      }
      if (this.e.k != null) {
        this.e.k.a(this.e, paramBoolean);
      }
      this.l.removeMessages(-3);
      this.l.removeMessages(-4);
      localObject1 = d(paramWSPlayerParam);
      Object localObject2 = e(paramWSPlayerParam);
      if ((localObject1 != null) && (((WSPlayerWrapper)localObject1).p()) && (((WSPlayerWrapper)localObject1).o() == paramWSPlayerParam.c))
      {
        paramWSPlayerParam.h = false;
        this.A = false;
        this.f = null;
        paramWSPlayerParam.d.l();
        if (localObject2 != null)
        {
          ((IWSPlayerReport)localObject2).a(true);
          ((IWSPlayerReport)localObject2).a(2);
          ((IWSPlayerReport)localObject2).a(d(paramWSPlayerParam));
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:");
        ((StringBuilder)localObject1).append(f(paramWSPlayerParam));
        WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject1).toString());
        this.j.a();
        return;
      }
      if ((paramWSPlayerParam.h) && ((localObject1 == null) || (((WSPlayerWrapper)localObject1).o() == paramWSPlayerParam.c)))
      {
        if (localObject1 != null) {
          ((WSPlayerWrapper)localObject1).l();
        }
        this.y = true;
        if (localObject2 != null)
        {
          ((IWSPlayerReport)localObject2).a(false);
          ((IWSPlayerReport)localObject2).a(1);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
        if (localObject1 != null) {
          localObject1 = Integer.valueOf(((WSPlayerWrapper)localObject1).E());
        } else {
          localObject1 = " ";
        }
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(", title:");
        ((StringBuilder)localObject2).append(f(paramWSPlayerParam));
        WSLog.d("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject2).toString());
        this.l.sendEmptyMessageDelayed(-3, 150L);
        return;
      }
      this.A = false;
      this.f = null;
      e(this.e, false);
      localObject1 = this.d;
      if ((localObject1 != null) && (!((WSVideoPluginInstall)localObject1).b()))
      {
        WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] installPlugin!");
        this.d.a();
        return;
      }
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] createVideoPlayerAndPlay!");
      c(paramWSPlayerParam, false);
      return;
    }
    WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.m != paramBoolean)
    {
      this.m = paramBoolean;
      if (y() != null)
      {
        WSPlayerParam localWSPlayerParam = this.e;
        if (localWSPlayerParam != null)
        {
          int i1;
          if (this.m) {
            i1 = 2;
          } else {
            i1 = localWSPlayerParam.e;
          }
          y().b(i1);
        }
      }
    }
  }
  
  public void c()
  {
    if ((this.e != null) && (y() != null) && ((y().E() == 3) || (y().E() == 4)))
    {
      y().g();
      if (this.e.k != null) {
        this.e.k.e(this.e);
      }
      Object localObject = this.g;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((WSPlayerStatusListener)((Iterator)localObject).next()).d(this.e);
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
    if ((y() != null) && (y().b() != null)) {
      y().b().b(paramBoolean);
    }
    WSPlayerWrapper localWSPlayerWrapper = d(this.f);
    if ((localWSPlayerWrapper != null) && (localWSPlayerWrapper.b() != null)) {
      localWSPlayerWrapper.b().b(paramBoolean);
    }
  }
  
  public void d()
  {
    this.l.post(new WSPlayerManager.5(this));
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][doOnDestroy] isStopVideo:");
    ((StringBuilder)localObject).append(paramBoolean);
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    this.n = true;
    localObject = this.h;
    if (localObject != null)
    {
      ((WSVideoPreDownloadManager)localObject).a();
      this.h = null;
    }
    if (paramBoolean) {
      n();
    }
    this.l.removeCallbacksAndMessages(this.e);
    this.l.removeCallbacksAndMessages(this.f);
    if ((this.e != null) && (paramBoolean))
    {
      if (y() != null)
      {
        y().n();
        this.e.d = null;
      }
      this.e = null;
    }
    localObject = this.f;
    if ((localObject != null) && (localObject != this.e))
    {
      localObject = d((WSPlayerParam)localObject);
      if (localObject != null)
      {
        ((WSPlayerWrapper)localObject).n();
        this.f.d = null;
      }
      this.A = false;
      this.f = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WSPlayerWrapper localWSPlayerWrapper = (WSPlayerWrapper)((Iterator)localObject).next();
        if ((localWSPlayerWrapper != null) && (localWSPlayerWrapper.E() != 8) && ((localWSPlayerWrapper != y()) || (paramBoolean))) {
          localWSPlayerWrapper.n();
        }
      }
      this.k.clear();
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((WSVideoPluginInstall)localObject).c();
      this.d = null;
    }
    this.l.removeCallbacksAndMessages(null);
    localObject = this.g;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.g = null;
    }
    localObject = this.i;
    if (localObject != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
      this.i = null;
    }
    this.b = null;
    this.c = null;
  }
  
  public void e(boolean paramBoolean)
  {
    this.s = paramBoolean;
    WSPlayerWrapper localWSPlayerWrapper = y();
    if (localWSPlayerWrapper != null) {
      localWSPlayerWrapper.d(paramBoolean);
    }
    localWSPlayerWrapper = d(this.f);
    if (localWSPlayerWrapper != null) {
      localWSPlayerWrapper.d(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return m() == 2;
  }
  
  public void f(boolean paramBoolean)
  {
    this.w = paramBoolean;
    WSPlayerWrapper localWSPlayerWrapper = y();
    boolean bool2 = false;
    if (localWSPlayerWrapper != null)
    {
      boolean bool1;
      if ((!paramBoolean) && (!this.s)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      localWSPlayerWrapper.d(bool1);
    }
    localWSPlayerWrapper = d(this.f);
    if (localWSPlayerWrapper != null)
    {
      if (!paramBoolean)
      {
        paramBoolean = bool2;
        if (!this.s) {}
      }
      else
      {
        paramBoolean = true;
      }
      localWSPlayerWrapper.d(paramBoolean);
    }
  }
  
  public boolean f()
  {
    return m() == 5;
  }
  
  public boolean g()
  {
    return m() == 3;
  }
  
  public boolean h()
  {
    return m() == 7;
  }
  
  public boolean i()
  {
    return m() == 6;
  }
  
  public boolean j()
  {
    return m() == 1;
  }
  
  public boolean k()
  {
    return m() == 4;
  }
  
  public boolean l()
  {
    return m() == 0;
  }
  
  public int m()
  {
    if (y() != null) {
      return y().E();
    }
    return 0;
  }
  
  public void n()
  {
    if ((this.e != null) && (y() != null))
    {
      Object localObject = e(this.e);
      if (localObject != null) {
        ((IWSPlayerReport)localObject).a(this.e.d, this.o);
      }
      localObject = this.e;
      ((WSPlayerParam)localObject).h = false;
      if (((WSPlayerParam)localObject).k != null) {
        this.e.k.g(this.e);
      }
      localObject = this.g;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((WSPlayerStatusListener)((Iterator)localObject).next()).a(this.e, this.o);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSPlayerManager.java][stop] title:");
      ((StringBuilder)localObject).append(f(this.e));
      WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
      c(this.e);
    }
    if (this.e != null) {
      this.e = null;
    }
    this.B = 0;
    this.p = false;
    this.l.removeMessages(-2);
  }
  
  public boolean o()
  {
    return this.u;
  }
  
  public void p()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][doOnResume] mIsNeedStartOnResume:");
    ((StringBuilder)localObject).append(this.z);
    ((StringBuilder)localObject).append(", mIsNeedRestartOnResume:");
    ((StringBuilder)localObject).append(this.x);
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    this.r = true;
    if ((this.z) && (y() != null) && (y().p()))
    {
      b();
    }
    else if (this.x)
    {
      localObject = this.b;
      boolean bool;
      if (localObject != null) {
        bool = ((QQAppInterface)localObject).isVideoChatting();
      } else {
        bool = false;
      }
      if (!bool)
      {
        this.y = true;
        d();
      }
    }
    this.x = false;
    this.z = false;
  }
  
  public void q()
  {
    this.r = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerManager.java][doOnPause] isPlaying:");
    localStringBuilder.append(g());
    WSLog.e("WS_VIDEO_PLAYER", localStringBuilder.toString());
    if (g())
    {
      this.x = true;
      this.y = false;
      c();
    }
  }
  
  public WSPlayerParam r()
  {
    return this.e;
  }
  
  public boolean s()
  {
    return this.s;
  }
  
  public void t()
  {
    WSPlayerWrapper localWSPlayerWrapper = y();
    if (localWSPlayerWrapper != null) {
      localWSPlayerWrapper.y();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager
 * JD-Core Version:    0.7.0.1
 */