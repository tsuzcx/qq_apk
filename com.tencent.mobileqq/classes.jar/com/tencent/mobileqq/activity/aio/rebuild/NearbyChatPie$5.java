package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.IGetMiniCardCallback;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.List;
import mqq.os.MqqHandler;

class NearbyChatPie$5
  implements IGetMiniCardCallback
{
  NearbyChatPie$5(NearbyChatPie paramNearbyChatPie) {}
  
  public void a(int paramInt, List<NowSummaryCard.MiniCard> paramList, String paramString)
  {
    if ((paramInt == 0) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new NearbyChatPie.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.5
 * JD-Core Version:    0.7.0.1
 */