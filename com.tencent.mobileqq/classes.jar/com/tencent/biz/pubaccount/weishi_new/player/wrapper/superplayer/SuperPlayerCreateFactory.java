package com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerFactory;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class SuperPlayerCreateFactory
  implements IWSPlayerFactory<Object, SuperPlayerVideoInfo>
{
  public AbsWSPlayerInfo<Object, SuperPlayerVideoInfo> a()
  {
    return new SuperPlayerInfo();
  }
  
  public IWSPlayer a(Context paramContext, IWSVideoView paramIWSVideoView)
  {
    boolean bool = QQVideoPlaySDKManager.isSDKReady();
    paramIWSVideoView = null;
    if (bool) {
      paramIWSVideoView = SuperPlayerFactory.createMediaPlayer(paramContext, 112, null);
    }
    return new SuperPlayerImpl(paramIWSVideoView);
  }
  
  public IWSPlayerPreDownloader a(Context paramContext)
  {
    if (QQVideoPlaySDKManager.isSDKReady()) {
      paramContext = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getContext(), 112);
    } else {
      paramContext = null;
    }
    return new SuperPlayerPreDownloader(paramContext);
  }
  
  public IWSVideoView a(Context paramContext, boolean paramBoolean)
  {
    if (QQVideoPlaySDKManager.isSDKReady()) {
      paramContext = SuperPlayerFactory.createPlayerVideoView(paramContext);
    } else {
      paramContext = null;
    }
    return new SuperPlayerVideoView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerCreateFactory
 * JD-Core Version:    0.7.0.1
 */