package com.tencent.biz.qqstory.takevideo.shareto;

import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class ShareToActivity$CommonlyUsedTroopCompator
  implements Comparator
{
  protected ShareToActivity$CommonlyUsedTroopCompator(ShareToActivity paramShareToActivity) {}
  
  public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    if (paramRecentUser1.lastmsgtime > paramRecentUser2.lastmsgtime) {
      return -1;
    }
    if (paramRecentUser1.lastmsgtime < paramRecentUser2.lastmsgtime) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity.CommonlyUsedTroopCompator
 * JD-Core Version:    0.7.0.1
 */