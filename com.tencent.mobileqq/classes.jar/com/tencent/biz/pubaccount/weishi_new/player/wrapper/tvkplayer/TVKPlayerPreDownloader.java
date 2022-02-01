package com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer;

import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader.Listener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;

public class TVKPlayerPreDownloader
  implements IWSPlayerPreDownloader<TVK_UserInfo, TVK_PlayerVideoInfo>, TVK_ICacheMgr.IPreloadCallback
{
  private IWSPlayerPreDownloader.Listener jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  
  public TVKPlayerPreDownloader(TVK_ICacheMgr paramTVK_ICacheMgr)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = paramTVK_ICacheMgr;
  }
  
  public void a()
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return;
    }
    localTVK_ICacheMgr.stopCacheData(WSPlayerUtils.a);
  }
  
  public void a(AbsWSPlayerInfo<TVK_UserInfo, TVK_PlayerVideoInfo> paramAbsWSPlayerInfo)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr != null)
    {
      if (paramAbsWSPlayerInfo == null) {
        return;
      }
      localTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramAbsWSPlayerInfo.b, (TVK_UserInfo)paramAbsWSPlayerInfo.b(), (TVK_PlayerVideoInfo)paramAbsWSPlayerInfo.d());
    }
  }
  
  public void a(IWSPlayerPreDownloader.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener = paramListener;
    paramListener = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (paramListener != null) {
      paramListener.setPreloadCallback(this);
    }
  }
  
  public boolean a(AbsWSPlayerInfo<TVK_UserInfo, TVK_PlayerVideoInfo> paramAbsWSPlayerInfo)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr != null)
    {
      if (paramAbsWSPlayerInfo == null) {
        return false;
      }
      try
      {
        int i = localTVK_ICacheMgr.isVideoCached(BaseApplicationImpl.getContext(), paramAbsWSPlayerInfo.b, (TVK_UserInfo)paramAbsWSPlayerInfo.b(), (TVK_PlayerVideoInfo)paramAbsWSPlayerInfo.d(), "");
        boolean bool = true;
        if (i != 2)
        {
          if (i == 1) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSVideoPreDownloadManager.java][checkIsCached] Exception url:");
        localStringBuilder.append(paramAbsWSPlayerInfo.b);
        localStringBuilder.append(", cacheMgr.isVideoCached Exception:");
        localStringBuilder.append(localException.getMessage());
        WSLog.d("TVKPlayerPreDownloader", localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public void b()
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return;
    }
    localTVK_ICacheMgr.removePreloadCallback();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(WSPlayerUtils.a);
  }
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    IWSPlayerPreDownloader.Listener localListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener;
    if (localListener == null) {
      return;
    }
    localListener.a(paramString1, paramInt, paramString2);
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    IWSPlayerPreDownloader.Listener localListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener;
    if (localListener == null) {
      return;
    }
    localListener.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer.TVKPlayerPreDownloader
 * JD-Core Version:    0.7.0.1
 */