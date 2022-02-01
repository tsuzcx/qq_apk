package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.os.Handler;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.JumpImage;
import com.tencent.mobileqq.activity.aio.anim.LottieAnimationInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService.IGetTroopHonorListCallback;
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class DragonKingEggsPlayer$1
  implements ITroopHonorService.IGetTroopHonorListCallback
{
  DragonKingEggsPlayer$1(DragonKingEggsPlayer paramDragonKingEggsPlayer, String paramString, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AioAnimationRule paramAioAnimationRule, AioAnimationRule.JumpImage paramJumpImage, Handler paramHandler, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt) {}
  
  public void a(List<TroopHonor> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      int j = 0;
      for (;;)
      {
        bool1 = bool2;
        if (j >= paramList.size()) {
          break;
        }
        if (((TroopHonor)paramList.get(j)).a == 1)
        {
          bool1 = true;
          break;
        }
        j += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("bIsDragonKing : ");
      paramList.append(bool1);
      paramList.append(" curTroopUin : ");
      paramList.append(this.a);
      QLog.d("DragonKingEggsPlayer", 2, paramList.toString());
    }
    if (bool1)
    {
      Object localObject2 = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject1 = "";
      paramList = null;
      if (localObject2 != null) {
        paramList = ((TroopManager)localObject2).f(this.a);
      }
      if (paramList != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramList.dwGroupClassExt);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (this.b.getCurrentAccountUin().equals(this.c.senderuin))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("report 0X800AF7C curTroopUin : ");
          ((StringBuilder)localObject2).append(this.a);
          QLog.d("DragonKingEggsPlayer", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = this.b;
        ReportController.b((AppRuntime)localObject2, "dc00898", "", ((QQAppInterface)localObject2).getCurrentAccountUin(), "0X800AF7C", "0X800AF7C", this.d.b, 0, this.a, (String)localObject1, "", "");
      }
      localObject1 = this.e.h;
      paramList = new LottieAnimationInfo(1, this.b.getCurrentAccountUin(), paramList);
      this.f.postDelayed(new DragonKingEggsPlayer.1.1(this, (String)localObject1, paramList), this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.DragonKingEggsPlayer.1
 * JD-Core Version:    0.7.0.1
 */