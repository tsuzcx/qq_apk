package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class GameRoomChatPie$25
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomChatPie$25(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "startAnotherRound failed! errorCode = " + paramInt);
      }
    }
    do
    {
      QQToast.a(this.a.a(), 1, HardCodeUtil.a(2131705120), 1).a();
      return;
      while ((!paramRspBody.getBooleanExtra("finishAIO", false)) || (!(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)))
      {
        Common.WifiPOIInfo localWifiPOIInfo = paramRspBody.poi_info;
        HotChatInfo localHotChatInfo = HotChatInfo.createHotChat(localWifiPOIInfo, false, 0);
        localHotChatInfo.isGameRoom = true;
        paramRspBody = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);
        Object localObject = paramRspBody.a();
        if ((localObject != null) && (!((List)localObject).contains(localHotChatInfo))) {
          ((List)localObject).add(localHotChatInfo);
        }
        paramRspBody.a(localHotChatInfo, 4);
        localObject = this.a.a().getIntent();
        paramRspBody = (oidb_0x8e4.RspBody)localObject;
        if (localObject == null) {
          paramRspBody = new Intent();
        }
        localObject = localWifiPOIInfo.bytes_uid.get().toStringUtf8();
        paramRspBody.putExtra("uin", localHotChatInfo.troopUin + "");
        paramRspBody.putExtra("uintype", 1);
        paramRspBody.putExtra("troop_uin", localHotChatInfo.troopUin + "");
        paramRspBody.putExtra("uinname", localHotChatInfo.name);
        paramRspBody.putExtra("hotnamecode", (String)localObject);
        paramRspBody.putExtra("isNeedShowLoading", false);
        paramRspBody.putExtra("leftViewText", this.a.a().getString(2131690601));
        NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(MessageCache.a()));
        paramInt = AIOUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramRspBody);
        if (paramInt != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a.b, 2, "openAIO by start SplashAct");
        }
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
        if (localObject != null) {
          ((WerewolvesPluginInterface)localObject).a();
        }
        this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramRspBody);
      }
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    } while (paramInt != 2);
    QLog.e(this.a.b, 1, "openAIO rediectToAIOWithMt 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.25
 * JD-Core Version:    0.7.0.1
 */