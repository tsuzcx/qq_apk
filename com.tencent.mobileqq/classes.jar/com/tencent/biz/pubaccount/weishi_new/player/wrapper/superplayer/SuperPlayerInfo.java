package com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer;

import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class SuperPlayerInfo
  extends AbsWSPlayerInfo<Object, SuperPlayerVideoInfo>
{
  public int a(int paramInt)
  {
    if (paramInt == 101) {
      return 101;
    }
    return 103;
  }
  
  public SuperPlayerVideoInfo c()
  {
    return SuperPlayerFactory.createVideoInfoForUrl(this.b, a(this.c), null);
  }
  
  public SuperPlayerVideoInfo d()
  {
    return SuperPlayerFactory.createVideoInfoForUrl(this.b, a(this.c), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerInfo
 * JD-Core Version:    0.7.0.1
 */