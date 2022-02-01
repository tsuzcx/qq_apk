package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.os.Handler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.mobileqq.app.ThreadManager;

class VipForwardVideoInfoController$1
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  VipForwardVideoInfoController$1(VipForwardVideoInfoController paramVipForwardVideoInfoController, BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder) {}
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    ThreadManager.getUIHandlerV2().post(new VipForwardVideoInfoController.1.1(this, paramUpdateUserInfoEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.VipForwardVideoInfoController.1
 * JD-Core Version:    0.7.0.1
 */