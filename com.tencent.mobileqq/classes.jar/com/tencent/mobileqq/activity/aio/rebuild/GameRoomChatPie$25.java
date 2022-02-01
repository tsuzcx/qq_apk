package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
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
    if (paramRspBody == null)
    {
      if (QLog.isColorLevel())
      {
        paramRspBody = this.a.c;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startAnotherRound failed! errorCode = ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d(paramRspBody, 2, ((StringBuilder)localObject1).toString());
      }
      QQToast.makeText(this.a.aX(), 1, HardCodeUtil.a(2131903083), 1).show();
      return;
    }
    Object localObject2 = paramRspBody.poi_info;
    HotChatInfo localHotChatInfo = HotChatInfo.createHotChat((Common.WifiPOIInfo)localObject2, false, 0);
    localHotChatInfo.isGameRoom = true;
    paramRspBody = this.a.d.getHotChatMng(true);
    Object localObject1 = paramRspBody.c();
    if ((localObject1 != null) && (!((List)localObject1).contains(localHotChatInfo))) {
      ((List)localObject1).add(localHotChatInfo);
    }
    paramRspBody.a(localHotChatInfo, 4);
    localObject1 = this.a.aX().getIntent();
    paramRspBody = (oidb_0x8e4.RspBody)localObject1;
    if (localObject1 == null) {
      paramRspBody = new Intent();
    }
    localObject1 = ((Common.WifiPOIInfo)localObject2).bytes_uid.get().toStringUtf8();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localHotChatInfo.troopUin);
    ((StringBuilder)localObject2).append("");
    paramRspBody.putExtra("uin", ((StringBuilder)localObject2).toString());
    paramRspBody.putExtra("uintype", 1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localHotChatInfo.troopUin);
    ((StringBuilder)localObject2).append("");
    paramRspBody.putExtra("troop_uin", ((StringBuilder)localObject2).toString());
    paramRspBody.putExtra("uinname", localHotChatInfo.name);
    paramRspBody.putExtra("hotnamecode", (String)localObject1);
    paramRspBody.putExtra("isNeedShowLoading", false);
    paramRspBody.putExtra("leftViewText", this.a.aX().getString(2131887440));
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.d.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(MessageCache.c()));
    paramInt = AIOUtils.a(this.a.d, this.a.f, paramRspBody);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "openAIO by start SplashAct");
      }
      localObject1 = this.a.bC.c();
      if (localObject1 != null) {
        ((WerewolvesPluginInterface)localObject1).a();
      }
      this.a.f.startActivity(paramRspBody);
    }
    else if (paramInt == 2)
    {
      QLog.e(this.a.c, 1, "openAIO rediectToAIOWithMt 2");
      return;
    }
    if ((paramRspBody.getBooleanExtra("finishAIO", false)) && ((this.a.f instanceof ChatActivity))) {
      this.a.f.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.25
 * JD-Core Version:    0.7.0.1
 */