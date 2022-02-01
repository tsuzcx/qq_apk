package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManager.IGetMiniCardCallback;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.List;
import mqq.os.MqqHandler;

class NearbyChatPie$7
  implements MiniCardManager.IGetMiniCardCallback
{
  NearbyChatPie$7(NearbyChatPie paramNearbyChatPie) {}
  
  public void a(int paramInt, List<NowSummaryCard.MiniCard> paramList, String paramString)
  {
    if ((paramInt == 0) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new NearbyChatPie.7.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.7
 * JD-Core Version:    0.7.0.1
 */