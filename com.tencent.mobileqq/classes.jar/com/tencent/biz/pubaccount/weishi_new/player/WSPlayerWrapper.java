package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerFactory;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerListener;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerWrapHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class WSPlayerWrapper
  implements WSPlayerState, IWSPlayerListener
{
  private WSPlayerListenerAdapter A;
  private Context B;
  private Object C;
  private AtomicInteger a = new AtomicInteger(0);
  private int b = 0;
  private boolean c;
  private boolean d;
  private boolean e = false;
  private boolean f = false;
  private int g;
  private int h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private long p = -1L;
  private long q;
  private long r = 0L;
  private long s;
  private String t;
  private String u;
  private IWSPlayer v;
  private IWSPlayerFactory w;
  private IWSVideoView x;
  private volatile ArrayList<Integer> y;
  private final Object z = new Object();
  
  public WSPlayerWrapper(Context paramContext)
  {
    this.B = paramContext;
    a();
  }
  
  private void N()
  {
    this.w = WSPlayerWrapHelper.a().b();
  }
  
  private IWSVideoView O()
  {
    if (this.w == null)
    {
      a();
      if (this.w == null) {
        return null;
      }
    }
    Context localContext = this.B;
    if (localContext == null)
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][createVideoViewScroll]: error, mContext null");
      return null;
    }
    return this.w.a(localContext, VersionUtils.d());
  }
  
  private void P()
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((IWSVideoView)localObject).a();
      if ((localObject instanceof IVideoViewBase)) {
        ((IVideoViewBase)localObject).doCacheSurfaceTexture();
      }
    }
  }
  
  private void Q()
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((IWSVideoView)localObject).a();
      if ((localObject instanceof IVideoViewBase)) {
        ((IVideoViewBase)localObject).doRecoverSurfaceTexture();
      }
    }
  }
  
  private boolean R()
  {
    if ((!this.a.compareAndSet(0, 1)) && (!this.a.compareAndSet(7, 1)) && (!this.a.compareAndSet(6, 1)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSPlayerWrapper.java][checkPlayerStartState] not idle or complete state, should't reopen media player mState:");
      localStringBuilder.append(WSPlayerUtils.a(this.a.get()));
      WSLog.e("WS_VIDEO_PLAYER", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  private int a(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (paramArrayList != null) {
      try
      {
        paramInt = ((Integer)paramArrayList.get(paramInt)).intValue();
        return paramInt;
      }
      catch (Exception paramArrayList)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSPlayerWrapper.java][getSpeedFromListCache] e:");
        localStringBuilder.append(paramArrayList.getMessage());
        WSLog.e("WS_VIDEO_PLAYER", localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  private AbsWSPlayerInfo a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AbsWSPlayerInfo localAbsWSPlayerInfo = this.w.a();
    localAbsWSPlayerInfo.a(paramString1, paramString2, paramInt1, paramLong, paramInt2, paramBoolean1, paramBoolean2, this.e, this.d);
    return localAbsWSPlayerInfo;
  }
  
  private boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    paramString3 = new StringBuilder();
    paramString3.append("[WSPlayerWrapper.java][innerPlayerStartByUrl] url:");
    paramString3.append(paramString2);
    paramString3.append(", fileSize:");
    paramString3.append(paramLong2);
    paramString3.append(", videoDuration:");
    paramString3.append(paramInt2);
    paramString3.append(", mState:");
    paramString3.append(WSPlayerUtils.a(this.a.get()));
    WSLog.e("WS_VIDEO_PLAYER", paramString3.toString());
    if (R())
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] checkPlayerStartState return true.");
      return false;
    }
    paramString1 = a(paramString1, paramString2, paramInt1, paramLong2, paramInt2, paramBoolean1, paramBoolean2);
    if ((this.B != null) && (this.v != null))
    {
      paramString3 = new StringBuilder();
      paramString3.append("[WSPlayerWrapper.java][innerPlayerStartByUrl] url:");
      paramString3.append(paramString2);
      paramString3.append(", fileSize:");
      paramString3.append(paramLong2);
      paramString3.append(", videoDuration:");
      paramString3.append(paramInt2);
      paramString3.append(", mState:");
      paramString3.append(WSPlayerUtils.a(this.a.get()));
      WSLog.e("WS_VIDEO_PLAYER", paramString3.toString());
      try
      {
        this.v.a(this.B, paramLong1, 0, paramString1);
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("[WSPlayerWrapper.java][innerPlayerStartByUrl] openMediaPlayerByUrl error:");
        paramString2.append(paramString1.getMessage());
        WSLog.d("WS_VIDEO_PLAYER", paramString2.toString());
      }
    }
    this.j = paramInt2;
    this.k = 0L;
    this.i = 0L;
    this.l = 0L;
    this.m = paramLong1;
    return true;
  }
  
  private void c(int paramInt)
  {
    if (this.y == null) {
      synchronized (this.z)
      {
        if (this.y == null) {
          this.y = new ArrayList();
        }
      }
    }
    ??? = this.y;
    if ((??? != null) && (((ArrayList)???).size() <= 20)) {
      ((ArrayList)???).add(Integer.valueOf(paramInt));
    }
  }
  
  private void d(IWSPlayer paramIWSPlayer)
  {
    ThreadManager.post(new WSPlayerWrapper.1(this, paramIWSPlayer), 5, null, false);
  }
  
  public int A()
  {
    return this.h;
  }
  
  public long B()
  {
    return this.l + c(i());
  }
  
  public void C()
  {
    long l2 = s();
    long l3 = this.m;
    long l1 = 0L;
    if (l2 - l3 > 0L) {
      l1 = l2 - l3;
    }
    this.k += l1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerWrapper.java][addTotalPlayTimeForLoop] mTotalPlayTime:");
    localStringBuilder.append(this.k);
    WSLog.g("WS_VIDEO_PLAY_TIME", localStringBuilder.toString());
  }
  
  public void D()
  {
    this.m = 0L;
  }
  
  public int E()
  {
    return this.a.get();
  }
  
  public long F()
  {
    if (this.p == -1L) {
      synchronized (this.z)
      {
        if ((this.y != null) && (this.y.size() > 0))
        {
          int i3 = Math.min(10, this.y.size());
          int i1 = 0;
          int i2 = 0;
          while (i1 < i3)
          {
            i2 += ((Integer)this.y.get(i1)).intValue();
            i1 += 1;
          }
          if (i3 != 0) {
            this.p = (i2 / i3);
          }
        }
      }
    }
    return this.p;
  }
  
  public String G()
  {
    int i1;
    synchronized (this.z)
    {
      if ((this.y != null) && (this.y.size() > 0))
      {
        Object localObject2 = new StringBuilder();
        int i2 = Math.min(20, this.y.size());
        i1 = 0;
        if (i1 < i2)
        {
          ((StringBuilder)localObject2).append(a(this.y, i1));
          if (i1 != i2 - 1) {
            ((StringBuilder)localObject2).append(",");
          }
        }
        else
        {
          localObject2 = ((StringBuilder)localObject2).toString();
          return localObject2;
        }
      }
      else
      {
        return "";
      }
    }
  }
  
  public long H()
  {
    int i1;
    label115:
    synchronized (this.z)
    {
      ArrayList localArrayList = this.y;
      long l1 = -1L;
      long l2 = l1;
      if (localArrayList != null)
      {
        l2 = l1;
        if (this.y.size() > 0)
        {
          int i2 = this.y.size();
          i1 = 0;
          l2 = l1;
          if (i1 < i2)
          {
            int i3 = a(this.y, i1);
            if (i1 == 0)
            {
              l1 = i3;
              break label115;
            }
            l1 = Math.min(i3, l1);
            break label115;
          }
        }
      }
      return l2;
    }
  }
  
  public long I()
  {
    int i1;
    label115:
    synchronized (this.z)
    {
      ArrayList localArrayList = this.y;
      long l1 = -1L;
      long l2 = l1;
      if (localArrayList != null)
      {
        l2 = l1;
        if (this.y.size() > 0)
        {
          int i2 = this.y.size();
          i1 = 0;
          l2 = l1;
          if (i1 < i2)
          {
            int i3 = a(this.y, i1);
            if (i1 == 0)
            {
              l1 = i3;
              break label115;
            }
            l1 = Math.max(i3, l1);
            break label115;
          }
        }
      }
      return l2;
    }
  }
  
  public long J()
  {
    long l1 = this.q;
    if (l1 > 0L)
    {
      long l2 = this.r;
      if (l2 > 0L) {
        return l2 / l1;
      }
    }
    return 0L;
  }
  
  public boolean K()
  {
    return this.c;
  }
  
  public boolean L()
  {
    return this.f;
  }
  
  public void M()
  {
    this.c = false;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.m = 0L;
    this.l = 0L;
    this.n = 0L;
    this.o = 0L;
    this.h = 0;
    this.q = 0L;
    this.s = 0L;
    this.p = -1L;
    this.r = 0L;
    this.t = "";
    this.u = "";
    synchronized (this.z)
    {
      this.y = null;
      return;
    }
  }
  
  public void a()
  {
    N();
    if ((this.w != null) && (this.B != null))
    {
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][initMediaPlayer] success!");
      this.v = this.w.a(this.B, null);
      this.v.b(false);
      this.v.a(this);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.v != null) && (this.a.get() != 0) && (this.a.get() != 2) && (this.a.get() != 1) && (this.a.get() != 4) && (this.a.get() != 8))
    {
      long l1 = m();
      long l2 = this.m;
      if (l1 - l2 > 0L) {
        this.k += l1 - l2;
      }
      this.m = paramInt;
      this.v.b(paramInt);
      this.c = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSPlayerWrapper.java][seekTo] mTotalPlayTime:");
      localStringBuilder.append(this.k);
      localStringBuilder.append(", mLastPlayPosition:");
      localStringBuilder.append(this.m);
      WSLog.g("WS_VIDEO_PLAY_TIME", localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    this.s = paramLong;
    c(paramInt);
    for (;;)
    {
      try
      {
        paramInt = new JSONObject(paramString).optInt("hitDownloaded");
        bool = true;
        if (paramInt == 1)
        {
          this.f = bool;
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      P();
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][removeVideoViewFromParent] remove scroll view parents!");
      Q();
    }
  }
  
  public void a(WSPlayerListenerAdapter paramWSPlayerListenerAdapter)
  {
    this.A = paramWSPlayerListenerAdapter;
  }
  
  public void a(IWSPlayer paramIWSPlayer)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerWrapper.java][onVideoPrepared] streamDumpInfo:");
    ((StringBuilder)localObject).append(paramIWSPlayer.m());
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    this.a.set(2);
    localObject = this.A;
    if (localObject != null) {
      ((WSPlayerListenerAdapter)localObject).a(this, this.C);
    }
    localObject = this.v;
    if (localObject != null) {
      this.i = ((IWSPlayer)localObject).i();
    }
    d(paramIWSPlayer);
  }
  
  public void a(IWSPlayer paramIWSPlayer, int paramInt1, int paramInt2)
  {
    paramIWSPlayer = this.A;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void a(IWSPlayer paramIWSPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    paramIWSPlayer = this.A;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void a(IWSVideoView paramIWSVideoView)
  {
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer == null) {
      return;
    }
    this.x = paramIWSVideoView;
    localIWSPlayer.a(paramIWSVideoView);
    this.v.a(this.b);
  }
  
  public void a(IWSVideoView paramIWSVideoView, ViewGroup paramViewGroup)
  {
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer != null)
    {
      if (paramViewGroup == null) {
        return;
      }
      localIWSPlayer.a(paramIWSVideoView, paramViewGroup);
    }
  }
  
  public void a(Object paramObject)
  {
    this.C = paramObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a(IWSPlayer paramIWSPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onError]!!");
    this.a.set(6);
    paramIWSPlayer = this.A;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this, paramInt2, paramInt3, paramInt1, paramString, null);
    }
    return false;
  }
  
  public boolean a(IWSPlayer paramIWSPlayer, int paramInt, Object paramObject)
  {
    if (paramInt != 40)
    {
      if (paramInt != 112)
      {
        if (paramInt == 113)
        {
          paramIWSPlayer = new StringBuilder();
          paramIWSPlayer.append("[WSPlayerWrapper.java][onInfo] end buffering <=== isSeeking:");
          paramIWSPlayer.append(this.c);
          WSLog.g("WS_VIDEO_PLAYER", paramIWSPlayer.toString());
          if (this.a.get() != 5) {
            this.a.set(3);
          }
          if (!this.c)
          {
            this.h += 1;
            this.o += System.currentTimeMillis() - this.n;
          }
        }
      }
      else
      {
        paramIWSPlayer = new StringBuilder();
        paramIWSPlayer.append("[WSPlayerWrapper.java][onInfo] start buffering ===> isSeeking:");
        paramIWSPlayer.append(this.c);
        WSLog.g("WS_VIDEO_PLAYER", paramIWSPlayer.toString());
        if (this.a.get() != 5) {
          this.a.set(4);
        }
        this.n = System.currentTimeMillis();
      }
    }
    else if ((paramObject instanceof String))
    {
      int i1;
      try
      {
        i1 = new JSONObject((String)paramObject).optInt("skipFrameCount", 1);
      }
      catch (JSONException paramIWSPlayer)
      {
        paramIWSPlayer.printStackTrace();
        i1 = 0;
      }
      if (i1 > 0) {
        this.g += i1;
      }
    }
    paramIWSPlayer = this.A;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this, paramInt, paramObject);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, null);
  }
  
  public IWSPlayer b()
  {
    return this.v;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
    Object localObject = this.v;
    if (localObject != null) {
      ((IWSPlayer)localObject).a(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerWrapper.java][setXYAxis] value:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
  }
  
  public void b(IWSPlayer paramIWSPlayer)
  {
    this.a.set(7);
    paramIWSPlayer = this.A;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.set(8);
    ??? = this.v;
    if (??? != null) {
      ThreadManager.executeOnSubThread(new WSPlayerWrapper.2(this, (IWSPlayer)???));
    }
    if (paramBoolean)
    {
      ??? = this.x;
      if (??? != null)
      {
        ??? = ((IWSVideoView)???).a();
        if ((??? != null) && (((View)???).getParent() != null))
        {
          ViewParent localViewParent = ((View)???).getParent();
          if ((localViewParent instanceof ViewGroup)) {
            ((ViewGroup)localViewParent).removeView((View)???);
          }
        }
      }
    }
    this.A = null;
    this.x = null;
    this.B = null;
    synchronized (this.z)
    {
      this.y = null;
      this.p = 0L;
      this.r = 0L;
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][destroy]");
      return;
    }
  }
  
  public long c(boolean paramBoolean)
  {
    long l3 = this.k;
    long l1;
    if (paramBoolean) {
      l1 = s();
    } else {
      l1 = m();
    }
    long l4 = this.m;
    long l2 = l3;
    if (l1 - l4 > 0L) {
      l2 = l3 + (l1 - l4);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerWrapper.java][getTotalPlayTime] result:");
    localStringBuilder.append(l2);
    WSLog.g("WS_VIDEO_PLAY_TIME", localStringBuilder.toString());
    return l2;
  }
  
  public IWSVideoView c()
  {
    if (this.x == null) {
      try
      {
        if (this.x == null) {
          this.x = O();
        }
      }
      finally {}
    }
    Object localObject2 = this.x;
    if (localObject2 != null)
    {
      localObject2 = ((IWSVideoView)localObject2).a();
      if (localObject2 != null) {
        a((View)localObject2);
      }
    }
    return this.x;
  }
  
  public void c(IWSPlayer paramIWSPlayer)
  {
    paramIWSPlayer = new StringBuilder();
    paramIWSPlayer.append("[WSPlayerWrapper.java][onSeekComplete] isPause:");
    paramIWSPlayer.append(h());
    WSLog.e("WS_VIDEO_PLAYER", paramIWSPlayer.toString());
    paramIWSPlayer = this.A;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.b(this);
    }
    this.c = false;
  }
  
  public void d(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new WSPlayerWrapper.3(this, paramBoolean), 16, null, false);
      return;
    }
    if ((this.v != null) && (this.a.get() != 6) && (this.a.get() != 8)) {
      this.v.a(paramBoolean);
    }
  }
  
  public boolean d()
  {
    return this.a.get() == 0;
  }
  
  public void e(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean e()
  {
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer != null) {
      return localIWSPlayer.g();
    }
    return false;
  }
  
  public void f()
  {
    if (this.v != null)
    {
      this.a.set(3);
      this.v.a();
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][start]");
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void g()
  {
    if (this.v != null)
    {
      this.a.set(5);
      this.v.b();
    }
  }
  
  public boolean h()
  {
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer != null) {
      return localIWSPlayer.h();
    }
    return false;
  }
  
  public boolean i()
  {
    return this.a.get() == 7;
  }
  
  @WorkerThread
  public void j()
  {
    if (this.v == null) {
      return;
    }
    if (this.a.get() == 8)
    {
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][stop] player had destroyed! return!");
      return;
    }
    this.a.set(0);
    this.v.c();
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][stop]");
  }
  
  public void k()
  {
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer != null) {
      localIWSPlayer.e();
    }
  }
  
  public void l()
  {
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer != null) {
      localIWSPlayer.f();
    }
  }
  
  public long m()
  {
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer == null) {
      return 0L;
    }
    return localIWSPlayer.j();
  }
  
  public void n()
  {
    b(true);
  }
  
  public Object o()
  {
    return this.C;
  }
  
  public boolean p()
  {
    return this.a.get() == 2;
  }
  
  public int q()
  {
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer != null) {
      return localIWSPlayer.k();
    }
    return -1;
  }
  
  public int r()
  {
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer != null) {
      return localIWSPlayer.l();
    }
    return -1;
  }
  
  public long s()
  {
    long l1 = this.i;
    if (l1 > 0L) {
      return l1;
    }
    IWSPlayer localIWSPlayer = this.v;
    if (localIWSPlayer != null)
    {
      if (localIWSPlayer.i() > 0L) {
        return this.v.i();
      }
      return this.j;
    }
    return -1L;
  }
  
  public long t()
  {
    return this.s;
  }
  
  public long u()
  {
    return this.q;
  }
  
  public String v()
  {
    return this.u;
  }
  
  public int w()
  {
    return this.g;
  }
  
  public String x()
  {
    return this.t;
  }
  
  public void y()
  {
    this.l += c(i());
    this.m = m();
    this.k = 0L;
  }
  
  public long z()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */