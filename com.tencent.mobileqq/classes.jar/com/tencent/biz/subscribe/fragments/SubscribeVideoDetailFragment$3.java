package com.tencent.biz.subscribe.fragments;

import com.tencent.biz.subscribe.framework.BaseVideoViewListenerSets;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class SubscribeVideoDetailFragment$3
  extends BaseVideoViewListenerSets
{
  SubscribeVideoDetailFragment$3(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    try
    {
      if (QQPlayerService.a())
      {
        QQPlayerService.c(this.a.getBaseActivity());
        return;
      }
    }
    catch (Exception paramISuperPlayer)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubscribeVideoDetailFragment", 2, "QQPlayerService.stopPlayMusic exception!", paramISuperPlayer);
      }
      paramISuperPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment.3
 * JD-Core Version:    0.7.0.1
 */