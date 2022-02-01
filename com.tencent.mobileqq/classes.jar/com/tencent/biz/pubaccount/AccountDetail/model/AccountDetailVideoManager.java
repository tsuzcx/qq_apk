package com.tencent.biz.pubaccount.accountdetail.model;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDetailVideoManager
{
  static boolean c = false;
  static boolean d = false;
  Context a;
  Activity b;
  TVK_IProxyFactory e = null;
  View f = null;
  TVK_IMediaPlayer g = null;
  TVK_UserInfo h = null;
  TVK_PlayerVideoInfo i = null;
  int j;
  public AccountDetailVideoManager.OnVideoPlayListener k;
  public boolean l = true;
  BroadcastReceiver m = new AccountDetailVideoManager.6(this);
  
  public AccountDetailVideoManager(Activity paramActivity, AccountDetailVideoManager.OnVideoPlayListener paramOnVideoPlayListener)
  {
    this.a = paramActivity.getApplicationContext();
    this.b = paramActivity;
    this.k = paramOnVideoPlayListener;
    a(this.a.getApplicationContext());
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.intent.action.SCREEN_OFF");
    paramActivity.addAction("tencent.av.v2q.StartVideoChat");
    this.a.registerReceiver(this.m, paramActivity);
  }
  
  private static boolean a(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailVideoManager", 2, "isSDKloaded context= null");
      }
      return false;
    }
    if (!d)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      TVK_SDKMgr.setDebugEnable(true);
      d = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      c = true;
    }
    else
    {
      c = false;
      d();
    }
    return c;
  }
  
  private View c()
  {
    if (this.e == null)
    {
      this.e = TVK_SDKMgr.getProxyFactory();
      if (this.e == null) {
        return null;
      }
    }
    return (View)this.e.createVideoView(this.a);
  }
  
  private static void d()
  {
    ThreadManager.post(new AccountDetailVideoManager.5(), 2, null, false);
  }
  
  public void a()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((TVK_IMediaPlayer)localObject).isPlaying()))
    {
      this.j = ((int)this.g.getCurrentPostion());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pausePlayVideo , mCurrentPosition = ");
        ((StringBuilder)localObject).append(this.j);
        QLog.d("AccountDetailVideoManager", 2, ((StringBuilder)localObject).toString());
      }
      this.g.pause();
    }
  }
  
  void a(FrameLayout paramFrameLayout)
  {
    if (this.f == null)
    {
      this.f = c();
      localObject = this.f;
      if (localObject != null)
      {
        ((View)localObject).setBackgroundColor(-1);
        localObject = new FrameLayout.LayoutParams(-1, -1);
        this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramFrameLayout.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    Object localObject = this.f;
    if ((localObject != null) && (this.l) && (((View)localObject).getParent() != null))
    {
      localObject = this.f.getParent();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).removeView(this.f);
        paramFrameLayout.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    if (QLog.isColorLevel())
    {
      paramFrameLayout = new StringBuilder();
      paramFrameLayout.append("onCreateVideoSdkView needRemoveAndAdd = ");
      paramFrameLayout.append(this.l);
      QLog.d("AccountDetailVideoManager", 2, paramFrameLayout.toString());
    }
  }
  
  void a(PublicAccountConfigAttrImpl paramPublicAccountConfigAttrImpl)
  {
    int n;
    if (this.g == null)
    {
      this.g = this.e.createMediaPlayer(this.a, (IVideoViewBase)this.f);
      this.g.setOnVideoPreparedListener(new AccountDetailVideoManager.1(this));
      this.g.setOnCompletionListener(new AccountDetailVideoManager.2(this));
      this.g.setOnErrorListener(new AccountDetailVideoManager.3(this));
      n = 1;
    }
    else
    {
      n = 0;
    }
    if (n != 0)
    {
      this.h = new TVK_UserInfo("", "");
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramPublicAccountConfigAttrImpl.configs != null)
      {
        localObject1 = localObject2;
        if (paramPublicAccountConfigAttrImpl.configs.size() != 0) {
          localObject1 = ((IPublicAccountConfigAttr.PaConfigInfo)paramPublicAccountConfigAttrImpl.configs.get(0)).r;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        this.i = new TVK_PlayerVideoInfo(2, (String)localObject1, "");
        this.g.setLoopback(true);
        paramPublicAccountConfigAttrImpl = new HashMap();
        paramPublicAccountConfigAttrImpl.put("shouq_bus_type", "bus_type_account_detail");
        this.i.setReportInfoMap(paramPublicAccountConfigAttrImpl);
        this.g.openMediaPlayer(this.a, this.h, this.i, "", 0L, 0L);
        this.g.setXYaxis(2);
      }
    }
  }
  
  public void a(PublicAccountConfigAttrImpl paramPublicAccountConfigAttrImpl, FrameLayout paramFrameLayout)
  {
    if (c)
    {
      a(paramFrameLayout);
      a(paramPublicAccountConfigAttrImpl);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if (((TVK_IMediaPlayer)localObject).isPauseing())
      {
        this.g.seekTo(this.j);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("restartPlayVideo , mCurrentPosition = ");
          ((StringBuilder)localObject).append(this.j);
          QLog.d("AccountDetailVideoManager", 2, ((StringBuilder)localObject).toString());
        }
        this.g.start();
        this.k.m();
        return;
      }
      if (paramBoolean) {
        this.k.n();
      }
    }
  }
  
  public void b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.g;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.g.release();
      this.g = null;
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailVideoManager", 2, "releaseMediaPlayer");
      }
    }
    try
    {
      this.a.unregisterReceiver(this.m);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager
 * JD-Core Version:    0.7.0.1
 */