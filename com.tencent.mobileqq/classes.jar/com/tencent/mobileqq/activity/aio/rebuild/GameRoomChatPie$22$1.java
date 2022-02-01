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
      paramRspBody = this.a.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exitRoom: errorCode = ");
      localStringBuilder.append(paramInt);
      QLog.d(paramRspBody, 2, localStringBuilder.toString());
    }
    if ((paramInt != 0) && (paramInt != 1285))
    {
      if ((this.a.a.d != null) && (this.a.a.d.isShowing())) {
        this.a.a.d.dismiss();
      }
      QQToast.a(this.a.a.a(), 1, HardCodeUtil.a(2131705174), 0).b(this.a.a.a());
      return;
    }
    if ((this.a.a.d != null) && (this.a.a.d.isShowing())) {
      this.a.a.d.dismiss();
    }
    new Intent().putExtra("isNeedFinish", true);
    SharedPreUtils.f(this.a.a.a(), this.a.a.a.getCurrentAccountUin(), false);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
    this.a.a.I = true;
    this.a.a.b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.22.1
 * JD-Core Version:    0.7.0.1
 */