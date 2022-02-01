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
  
  public void a(QQAppInterface paramQQAppInterface, Handler paramHandler, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, AioAnimationRule paramAioAnimationRule, boolean paramBoolean, ArrayList<AioAnimationRule> paramArrayList, int paramInt2)
  {
    int i = paramAioAnimationRule.j.size();
    paramInt2 = 0;
    for (;;)
    {
      paramArrayList = paramChatMessage;
      if (paramInt2 >= i) {
        break;
      }
      AioAnimationRule.JumpImage localJumpImage = (AioAnimationRule.JumpImage)paramAioAnimationRule.j.get(paramInt2);
      String str = paramArrayList.frienduin;
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
      boolean bool = AnonymousChatHelper.a().a(str);
      Object localObject = (TroopDragonKingAnimEntryConfig)QConfigManager.b().b(609);
      if ((localObject != null) && (((TroopDragonKingAnimEntryConfig)localObject).b(str))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bManageOpen : ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" curTroopUin : ");
        ((StringBuilder)localObject).append(str);
        QLog.d("DragonKingEggsPlayer", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramBoolean) && (!bool)) {
        ((ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "")).asyncGetTroopHonorListByDirect(str, paramArrayList.senderuin, new DragonKingEggsPlayer.1(this, str, paramQQAppInterface, paramChatMessage, paramAioAnimationRule, localJumpImage, paramHandler, paramAIOAnimationConatiner, paramInt1));
      }
      paramInt2 += 1;
    }
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void a(List<ChatMessage> paramList) {}
  
  public int b()
  {
    return 2;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.DragonKingEggsPlayer
 * JD-Core Version:    0.7.0.1
 */