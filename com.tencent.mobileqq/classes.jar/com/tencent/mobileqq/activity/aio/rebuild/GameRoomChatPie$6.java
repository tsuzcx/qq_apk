package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class GameRoomChatPie$6
  implements WerewolvesHandler.Callback<oidb_0x8ed.RspBody>
{
  GameRoomChatPie$6(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (this.a.J))
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, HardCodeUtil.a(2131705221), 0).a();
      SharedPreUtils.f(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).reset(this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.6
 * JD-Core Version:    0.7.0.1
 */