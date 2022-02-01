package com.tencent.biz.pubaccount.weishi_new.player.wrapper;

import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerCreateFactory;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerSdkMgr;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer.TVKPlayerFactory;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer.TVKPlayerSdkMgr;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSPlayerWrapHelper
{
  public static WSPlayerWrapHelper a()
  {
    return WSPlayerWrapHelper.SingletonHolder.a();
  }
  
  private boolean a()
  {
    int i = WSExpABTestManager.a().a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerWrapHelper.java][isSuperPlayer] playerType:");
    localStringBuilder.append(i);
    WSLog.d("WS_VIDEO_PLAYER", localStringBuilder.toString());
    return i == 1;
  }
  
  public IWSPlayerFactory a()
  {
    if (a()) {
      return new SuperPlayerCreateFactory();
    }
    return new TVKPlayerFactory();
  }
  
  public IWSPlayerSdkMgr a()
  {
    if (a()) {
      return new SuperPlayerSdkMgr();
    }
    return new TVKPlayerSdkMgr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerWrapHelper
 * JD-Core Version:    0.7.0.1
 */