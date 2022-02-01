package com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerListener;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.Properties;

public class TVKPlayerImpl
  implements IWSPlayer<TVK_UserInfo, TVK_PlayerVideoInfo>, TVK_IMediaPlayer.OnCaptureImageListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private IWSPlayerListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  
  public TVKPlayerImpl(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = paramTVK_IMediaPlayer;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 6;
  }
  
  private void a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      b(paramView);
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      WSLog.e("WS_VIDEO_PLAYER", "[TVKPlayerImpl.java][removeVideoViewFromParent] remove scroll view parents!");
      c(paramView);
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 21: 
      return 112;
    case 22: 
      return 113;
    case 28: 
      return 28;
    case 39: 
      return 39;
    case 41: 
      return 41;
    }
    return 42;
  }
  
  private void b(View paramView)
  {
    if ((paramView instanceof IVideoViewBase)) {
      ((IVideoViewBase)paramView).doCacheSurfaceTexture();
    }
  }
  
  private void c(View paramView)
  {
    if ((paramView instanceof IVideoViewBase)) {
      ((IVideoViewBase)paramView).doRecoverSurfaceTexture();
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener.a(paramString);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getStreamDumpInfo();
    }
    return "";
  }
  
  public Properties a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getPlayDetailsTime();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(a(paramInt));
    }
  }
  
  public void a(Context paramContext, long paramLong, int paramInt, AbsWSPlayerInfo<TVK_UserInfo, TVK_PlayerVideoInfo> paramAbsWSPlayerInfo)
  {
    TVK_UserInfo localTVK_UserInfo = (TVK_UserInfo)paramAbsWSPlayerInfo.a();
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = (TVK_PlayerVideoInfo)paramAbsWSPlayerInfo.c();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, paramAbsWSPlayerInfo.b, paramLong, paramInt, localTVK_UserInfo, localTVK_PlayerVideoInfo);
    }
  }
  
  public void a(IWSPlayerListener paramIWSPlayerListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener = paramIWSPlayerListener;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCaptureImageListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    }
  }
  
  public void a(IWSVideoView paramIWSVideoView)
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (paramIWSVideoView != null))
    {
      paramIWSVideoView = paramIWSVideoView.a();
      if ((paramIWSVideoView instanceof IVideoViewBase)) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView((IVideoViewBase)paramIWSVideoView);
      }
    }
  }
  
  public void a(IWSVideoView paramIWSVideoView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramIWSVideoView != null)
    {
      localView = paramIWSVideoView.a();
      if (localView != null) {}
    }
    else
    {
      return;
    }
    a(localView);
    paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    a(paramIWSVideoView);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pauseDownload();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.resumeDownload();
    }
  }
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener.a(this, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener.a(this, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener.b(this);
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener.a(this, 3, paramInt1, paramInt2, paramString);
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener.a(this, b(paramInt), paramObject);
    }
    return false;
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener.c(this);
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerListener.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer.TVKPlayerImpl
 * JD-Core Version:    0.7.0.1
 */