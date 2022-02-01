package com.tencent.biz.pubaccount.Advertisement.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.net.URL;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class VideoCoverView
  extends RelativeLayout
{
  private TroopMemberApiClient A = null;
  private int B;
  private int C;
  private boolean D = false;
  private ValueAnimator E = null;
  private VideoCoverView.RotateAnimaterListener F = null;
  private AnimatorListenerAdapter G = null;
  private boolean H = false;
  private boolean I = false;
  public TVK_UserInfo a;
  public TVK_PlayerVideoInfo b;
  public boolean c;
  public boolean d;
  public String e;
  public int f;
  public long g;
  boolean h = false;
  Runnable i = new VideoCoverView.11(this);
  private TVK_IProxyFactory j;
  private TVK_IMediaPlayer k;
  private RelativeLayout l;
  private ResizeURLImageView m;
  private View n;
  private View o;
  private View p;
  private View q;
  private AdvertisementSplitedProgressBar r;
  private int s;
  private int t;
  private long u = 0L;
  private Context v;
  private ArrayList<VideoCoverItem> w;
  private TVK_IMediaPlayer.OnCompletionListener x;
  private Handler y = new Handler(Looper.getMainLooper());
  private AdvertisementItem z;
  
  public VideoCoverView(Context paramContext, VideoCoverItem paramVideoCoverItem, int paramInt, AdvertisementSplitedProgressBar paramAdvertisementSplitedProgressBar, TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener, ArrayList<VideoCoverItem> paramArrayList, AdvertisementItem paramAdvertisementItem, TroopMemberApiClient paramTroopMemberApiClient)
  {
    super(paramContext);
    this.v = paramContext;
    LayoutInflater.from(getContext()).inflate(2131625619, this);
    this.l = ((RelativeLayout)findViewById(2131449603));
    this.m = ((ResizeURLImageView)findViewById(2131449520));
    this.o = findViewById(2131437664);
    this.p = findViewById(2131432778);
    this.p.setOnClickListener(new VideoCoverView.1(this, paramContext));
    this.q = findViewById(2131446396);
    this.q.setOnClickListener(new VideoCoverView.2(this));
    this.t = paramVideoCoverItem.a;
    this.e = paramVideoCoverItem.c;
    this.s = paramInt;
    this.r = paramAdvertisementSplitedProgressBar;
    this.x = paramOnCompletionListener;
    this.w = paramArrayList;
    this.r.setTotalCount(this.s);
    paramContext = getResources().getDisplayMetrics();
    this.C = paramContext.widthPixels;
    this.B = paramContext.heightPixels;
    this.z = paramAdvertisementItem;
    this.h = this.z.g.g;
    this.A = paramTroopMemberApiClient;
    this.E = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.F = new VideoCoverView.RotateAnimaterListener(this);
    this.G = new VideoCoverView.3(this);
    if (this.h)
    {
      paramContext = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      paramInt = this.C;
      paramContext.width = paramInt;
      paramContext.height = ((int)(paramInt * 0.5626F));
    }
    if (!TextUtils.isEmpty(paramVideoCoverItem.b)) {
      try
      {
        paramContext = new URL(paramVideoCoverItem.b);
        this.m.setImage(paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!VideoCoverFragment.c)
    {
      b(paramBoolean);
      return;
    }
    if (VideoCoverFragment.b)
    {
      b(this.v);
      return;
    }
    b(paramBoolean);
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool = AdvertisementVideoPreloadManager.b(this.e);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append(" playByNet hasCache:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" isStop");
      localStringBuilder.append(paramBoolean);
      QLog.d("VideoCoverView", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      b(this.v);
      return;
    }
    int i1 = NetUtil.a(null);
    if (i1 == 0)
    {
      FMToastUtil.a(2131886196);
      this.f = 6;
      g();
      return;
    }
    if (i1 == 1)
    {
      if ((paramBoolean) && (this.f == 5))
      {
        d();
        return;
      }
      b(this.v);
      return;
    }
    a();
  }
  
  private void c(Context paramContext)
  {
    this.f = 1;
    ThreadManager.post(new VideoCoverView.5(this, paramContext), 2, null, false);
  }
  
  private void d(Context paramContext)
  {
    QLog.i("VideoCoverView", 1, "initVideo");
    this.f = 2;
    this.j = TVK_SDKMgr.getProxyFactory();
    Object localObject = this.j;
    if (localObject != null)
    {
      this.n = ((View)((TVK_IProxyFactory)localObject).createVideoView_Scroll(paramContext));
      localObject = this.n;
      if (localObject != null)
      {
        ((View)localObject).setBackgroundColor(-16777216);
        if (this.h)
        {
          int i1 = this.C;
          localObject = new RelativeLayout.LayoutParams(i1, (int)(i1 * 0.5626F));
        }
        else
        {
          localObject = new RelativeLayout.LayoutParams(-1, -1);
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
        this.n.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.l.addView(this.n);
        this.k = this.j.createMediaPlayer(paramContext, (IVideoViewBase)this.n);
        this.k.setOnVideoPreparedListener(new VideoCoverView.6(this));
        if (this.h)
        {
          this.E.addUpdateListener(this.F);
          this.E.addListener(this.G);
          this.y.postDelayed(new VideoCoverView.7(this), 3000L);
        }
        this.k.setOnCompletionListener(this.x);
        this.k.setOnErrorListener(new VideoCoverView.8(this));
        a(false);
      }
    }
  }
  
  private void h() {}
  
  public void a()
  {
    if ((PublicAccountAdvertisementActivity.class.isInstance(this.v)) && (!((PublicAccountAdvertisementActivity)this.v).isFinishing()))
    {
      this.D = true;
      FMDialogUtil.a(this.v, 2131889584, 2131886194, new VideoCoverView.9(this));
    }
  }
  
  public void a(Context paramContext)
  {
    if (!this.c)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      h();
      this.c = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      this.d = true;
      QLog.i("VideoCoverView", 1, "initSDK isInstalled");
      d(paramContext);
      return;
    }
    QLog.i("VideoCoverView", 1, "initSDK no isInstalled");
    this.d = false;
    c(paramContext);
  }
  
  public void b()
  {
    if (this.k != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopVideo mVideoPlayer.isPlaying() =");
        localStringBuilder.append(this.k.isPlaying());
        QLog.d("VideoCoverView", 2, localStringBuilder.toString());
      }
      this.k.stop();
      this.f = 6;
      g();
    }
    this.y.removeCallbacksAndMessages(null);
    this.I = true;
  }
  
  public void b(Context paramContext)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.k;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.pause();
      this.f = 5;
      g();
    }
    this.y.removeCallbacksAndMessages(null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, "resumeVideo ");
    }
    if (this.k != null)
    {
      if ((!VideoCoverFragment.c) || (VideoCoverFragment.b))
      {
        this.f = 4;
        g();
        this.k.start();
      }
      if (!this.H) {
        this.E.start();
      }
      if (this.s == 1) {
        PublicAccountAdvertisementActivity.b = System.currentTimeMillis();
      }
    }
    this.y.post(this.i);
  }
  
  public void e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.k;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.k.release();
      this.k = null;
    }
  }
  
  public void f()
  {
    e();
    this.r = null;
    this.y.removeCallbacksAndMessages(null);
    this.y = null;
    this.A = null;
    this.E.removeAllUpdateListeners();
    this.E.removeAllListeners();
  }
  
  public void g()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new VideoCoverView.10(this));
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateView mVideoState=");
      localStringBuilder.append(this.f);
      QLog.d("VideoCoverView", 2, localStringBuilder.toString());
    }
    int i1 = this.f;
    if (i1 != 4)
    {
      if (i1 != 5)
      {
        if (i1 != 6)
        {
          if (i1 != 7)
          {
            if (AdvertisementVideoPreloadManager.b(this.e)) {
              this.o.setVisibility(8);
            } else {
              this.o.setVisibility(0);
            }
            this.p.setVisibility(8);
            this.m.setVisibility(0);
            this.q.setVisibility(8);
            return;
          }
          this.o.setVisibility(8);
          this.p.setVisibility(0);
          this.m.setVisibility(8);
          this.q.setVisibility(8);
          return;
        }
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.m.setVisibility(0);
        this.q.setVisibility(0);
        return;
      }
      this.o.setVisibility(8);
      this.p.setVisibility(8);
      this.m.setVisibility(0);
      this.q.setVisibility(0);
      return;
    }
    this.o.setVisibility(8);
    this.p.setVisibility(8);
    this.m.setVisibility(8);
    this.q.setVisibility(8);
  }
  
  public long getPlayVideoProgress()
  {
    Object localObject = this.k;
    long l1;
    if ((localObject != null) && (((TVK_IMediaPlayer)localObject).isPlaying())) {
      l1 = this.k.getCurrentPostion();
    } else {
      l1 = 0L;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("time = ");
      ((StringBuilder)localObject).append(l1);
      QLog.d("Timer", 2, ((StringBuilder)localObject).toString());
    }
    return l1;
  }
  
  public TVK_IMediaPlayer getVideoPlayer()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView
 * JD-Core Version:    0.7.0.1
 */