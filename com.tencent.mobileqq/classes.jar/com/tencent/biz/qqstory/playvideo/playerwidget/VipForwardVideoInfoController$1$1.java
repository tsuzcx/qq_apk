package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;

class VipForwardVideoInfoController$1$1
  implements Runnable
{
  VipForwardVideoInfoController$1$1(VipForwardVideoInfoController.1 param1, GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent) {}
  
  public void run()
  {
    QQUserUIItem localQQUserUIItem = this.a.a;
    if (localQQUserUIItem != null)
    {
      this.b.b.a.z();
      VipForwardVideoInfoController.a(this.b.b, localQQUserUIItem, this.b.a);
      return;
    }
    this.b.b.a.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.VipForwardVideoInfoController.1.1
 * JD-Core Version:    0.7.0.1
 */