package com.tencent.biz.pubaccount.weishi_new.player.wrapper;

import com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerCreateFactory;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerSdkMgr;

public class WSPlayerWrapHelper
{
  public static WSPlayerWrapHelper a()
  {
    return WSPlayerWrapHelper.SingletonHolder.a();
  }
  
  public IWSPlayerFactory b()
  {
    return new SuperPlayerCreateFactory();
  }
  
  public IWSPlayerSdkMgr c()
  {
    return new SuperPlayerSdkMgr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerWrapHelper
 * JD-Core Version:    0.7.0.1
 */