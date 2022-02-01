package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
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
    if ((paramInt == 0) && (this.a.W))
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, HardCodeUtil.a(2131705144), 0).a();
      SharedPreUtils.f(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.6
 * JD-Core Version:    0.7.0.1
 */