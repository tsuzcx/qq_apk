package com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerFactory;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;

public class TVKPlayerFactory
  implements IWSPlayerFactory<TVK_UserInfo, TVK_PlayerVideoInfo>
{
  public AbsWSPlayerInfo<TVK_UserInfo, TVK_PlayerVideoInfo> a()
  {
    return new TVKPlayerInfo();
  }
  
  public IWSPlayer a(Context paramContext, IWSVideoView paramIWSVideoView)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    paramIWSVideoView = null;
    if (localTVK_IProxyFactory != null) {
      paramIWSVideoView = localTVK_IProxyFactory.createMediaPlayer(paramContext, null);
    }
    return new TVKPlayerImpl(paramIWSVideoView);
  }
  
  public IWSPlayerPreDownloader a(Context paramContext)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null) {
      return new TVKPlayerPreDownloader(localTVK_IProxyFactory.getCacheMgr(paramContext));
    }
    return null;
  }
  
  public IWSVideoView a(Context paramContext, boolean paramBoolean)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      if (paramBoolean) {
        paramContext = localTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      } else {
        paramContext = localTVK_IProxyFactory.createVideoView(paramContext);
      }
    }
    else {
      paramContext = null;
    }
    return new TVKPlayerVideoView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer.TVKPlayerFactory
 * JD-Core Version:    0.7.0.1
 */