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
  static boolean jdField_a_of_type_Boolean = false;
  static boolean b = false;
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new AccountDetailVideoManager.6(this);
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView = null;
  public AccountDetailVideoManager.OnVideoPlayListener a;
  TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
  TVK_PlayerVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = null;
  TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = null;
  public boolean c = true;
  
  public AccountDetailVideoManager(Activity paramActivity, AccountDetailVideoManager.OnVideoPlayListener paramOnVideoPlayListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager$OnVideoPlayListener = paramOnVideoPlayListener;
    a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.intent.action.SCREEN_OFF");
    paramActivity.addAction("tencent.av.v2q.StartVideoChat");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramActivity);
  }
  
  private View a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        return null;
      }
    }
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this.jdField_a_of_type_AndroidContentContext);
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
    if (!b)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      TVK_SDKMgr.setDebugEnable(true);
      b = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      jdField_a_of_type_Boolean = true;
    }
    else
    {
      jdField_a_of_type_Boolean = false;
      c();
    }
    return jdField_a_of_type_Boolean;
  }
  
  private static void c()
  {
    ThreadManager.post(new AccountDetailVideoManager.5(), 2, null, false);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if ((localObject != null) && (((TVK_IMediaPlayer)localObject).isPlaying()))
    {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pausePlayVideo , mCurrentPosition = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("AccountDetailVideoManager", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  void a(FrameLayout paramFrameLayout)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a();
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setBackgroundColor(-1);
        localObject = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (this.c) && (((View)localObject).getParent() != null))
    {
      localObject = this.jdField_a_of_type_AndroidViewView.getParent();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
        paramFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    if (QLog.isColorLevel())
    {
      paramFrameLayout = new StringBuilder();
      paramFrameLayout.append("onCreateVideoSdkView needRemoveAndAdd = ");
      paramFrameLayout.append(this.c);
      QLog.d("AccountDetailVideoManager", 2, paramFrameLayout.toString());
    }
  }
  
  void a(PublicAccountConfigAttrImpl paramPublicAccountConfigAttrImpl)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new AccountDetailVideoManager.1(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new AccountDetailVideoManager.2(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new AccountDetailVideoManager.3(this));
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo("", "");
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramPublicAccountConfigAttrImpl.configs != null)
      {
        localObject1 = localObject2;
        if (paramPublicAccountConfigAttrImpl.configs.size() != 0) {
          localObject1 = ((IPublicAccountConfigAttr.PaConfigInfo)paramPublicAccountConfigAttrImpl.configs.get(0)).j;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, (String)localObject1, "");
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(true);
        paramPublicAccountConfigAttrImpl = new HashMap();
        paramPublicAccountConfigAttrImpl.put("shouq_bus_type", "bus_type_account_detail");
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(paramPublicAccountConfigAttrImpl);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, "", 0L, 0L);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
      }
    }
  }
  
  public void a(PublicAccountConfigAttrImpl paramPublicAccountConfigAttrImpl, FrameLayout paramFrameLayout)
  {
    if (jdField_a_of_type_Boolean)
    {
      a(paramFrameLayout);
      a(paramPublicAccountConfigAttrImpl);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localObject != null)
    {
      if (((TVK_IMediaPlayer)localObject).isPauseing())
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(this.jdField_a_of_type_Int);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("restartPlayVideo , mCurrentPosition = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
          QLog.d("AccountDetailVideoManager", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager$OnVideoPlayListener.f();
        return;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager$OnVideoPlayListener.g();
      }
    }
  }
  
  public void b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailVideoManager", 2, "releaseMediaPlayer");
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager
 * JD-Core Version:    0.7.0.1
 */