package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.graphics.drawable.Drawable;
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
  
  public void a() {}
  
  public void a(QQAppInterface paramQQAppInterface, Handler paramHandler, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    int i = paramAioAnimationRule.b.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (AioAnimationRule.JumpImage)paramAioAnimationRule.b.get(paramInt);
      localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
      if (paramAioAnimationRule.a == 8) {
        paramHandler.post(new BusinessEggsPlayer.1(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, paramAioAnimationRule, paramChatMessage));
      }
      paramInt += 1;
    }
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void a(List<ChatMessage> paramList) {}
  
  public int b()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsPlayer
 * JD-Core Version:    0.7.0.1
 */