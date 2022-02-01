package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.JumpImage;
import com.tencent.mobileqq.activity.aio.anim.config.TroopDragonKingAnimEntryConfig;
import com.tencent.mobileqq.activity.aio.anim.egg.IEggBizPlayer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class DragonKingEggsPlayer
  implements IEggBizPlayer
{
  public int a()
  {
    return 7;
  }
  
  public void a() {}
  
  public void a(QQAppInterface paramQQAppInterface, Handler paramHandler, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    int j = paramAioAnimationRule.b.size();
    int i = 0;
    for (;;)
    {
      ChatMessage localChatMessage = paramChatMessage;
      if (i >= j) {
        break;
      }
      AioAnimationRule.JumpImage localJumpImage = (AioAnimationRule.JumpImage)paramAioAnimationRule.b.get(i);
      String str = localChatMessage.frienduin;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("curTroopUin : ");
        ((StringBuilder)localObject).append(str);
        QLog.d("DragonKingEggsPlayer", 2, ((StringBuilder)localObject).toString());
      }
      if (TextUtils.isEmpty(str)) {
        return;
      }
      boolean bool2 = AnonymousChatHelper.a().a(str);
      Object localObject = (TroopDragonKingAnimEntryConfig)QConfigManager.a().a(609);
      boolean bool1;
      if ((localObject != null) && (((TroopDragonKingAnimEntryConfig)localObject).a(str))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bManageOpen : ");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" curTroopUin : ");
        ((StringBuilder)localObject).append(str);
        QLog.d("DragonKingEggsPlayer", 2, ((StringBuilder)localObject).toString());
      }
      if ((bool1) && (!bool2)) {
        ((ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "")).asyncGetTroopHonorListByDirect(str, localChatMessage.senderuin, new DragonKingEggsPlayer.1(this, str, paramQQAppInterface, paramChatMessage, paramAioAnimationRule, localJumpImage, paramHandler, paramAIOAnimationConatiner, paramInt));
      }
      i += 1;
    }
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void a(List<ChatMessage> paramList) {}
  
  public int b()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.DragonKingEggsPlayer
 * JD-Core Version:    0.7.0.1
 */