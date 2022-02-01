package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.os.Handler;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.JumpImage;
import com.tencent.mobileqq.activity.aio.anim.egg.IEggBizPlayer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public class BusinessEggsPlayer
  implements IEggBizPlayer
{
  public int a()
  {
    return 8;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Handler paramHandler, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, AioAnimationRule paramAioAnimationRule, boolean paramBoolean, ArrayList<AioAnimationRule> paramArrayList, int paramInt2)
  {
    paramInt2 = paramAioAnimationRule.j.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramArrayList = (AioAnimationRule.JumpImage)paramAioAnimationRule.j.get(paramInt1);
      paramArrayList = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), paramArrayList);
      if (paramAioAnimationRule.a == 8) {
        paramHandler.post(new BusinessEggsPlayer.1(this, paramQQAppInterface, paramAIOAnimationConatiner, paramArrayList, paramAioAnimationRule, paramChatMessage));
      }
      paramInt1 += 1;
    }
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void a(List<ChatMessage> paramList) {}
  
  public int b()
  {
    return 3;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsPlayer
 * JD-Core Version:    0.7.0.1
 */