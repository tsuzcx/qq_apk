package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class GameRoomChatPie$22$1
  implements WerewolvesHandler.Callback<oidb_0x8ed.RspBody>
{
  GameRoomChatPie$22$1(GameRoomChatPie.22 param22) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (QLog.isColorLevel())
    {
      paramRspBody = this.a.b.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exitRoom: errorCode = ");
      localStringBuilder.append(paramInt);
      QLog.d(paramRspBody, 2, localStringBuilder.toString());
    }
    if ((paramInt != 0) && (paramInt != 1285))
    {
      if ((this.a.b.bD != null) && (this.a.b.bD.isShowing())) {
        this.a.b.bD.dismiss();
      }
      QQToast.makeText(this.a.b.aX(), 1, HardCodeUtil.a(2131903064), 0).show(this.a.b.A());
      return;
    }
    if ((this.a.b.bD != null) && (this.a.b.bD.isShowing())) {
      this.a.b.bD.dismiss();
    }
    new Intent().putExtra("isNeedFinish", true);
    SharedPreUtils.e(this.a.b.aX(), this.a.b.d.getCurrentAccountUin(), false);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
    this.a.b.bz = true;
    this.a.b.f(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.22.1
 * JD-Core Version:    0.7.0.1
 */