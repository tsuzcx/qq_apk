package com.tencent.mobileqq.activity.aio.intimate.info;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveAchievementInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveAchievementItem;

public class LoveAchievementInfo
{
  public int a;
  public int b;
  public ArrayList<LoveAchievementInfo.LoveAchievementItem> c;
  
  public static LoveAchievementInfo a(oidb_0xcf4.LoveAchievementInfo paramLoveAchievementInfo)
  {
    if (paramLoveAchievementInfo == null) {
      return null;
    }
    LoveAchievementInfo localLoveAchievementInfo = new LoveAchievementInfo();
    if (paramLoveAchievementInfo.uint32_total_count.has()) {
      localLoveAchievementInfo.a = paramLoveAchievementInfo.uint32_total_count.get();
    }
    if (paramLoveAchievementInfo.uint32_completed_count.has()) {
      localLoveAchievementInfo.b = paramLoveAchievementInfo.uint32_completed_count.get();
    }
    if (paramLoveAchievementInfo.rpt_life_ach_item.has())
    {
      paramLoveAchievementInfo = paramLoveAchievementInfo.rpt_life_ach_item.get().iterator();
      while (paramLoveAchievementInfo.hasNext())
      {
        oidb_0xcf4.LoveAchievementItem localLoveAchievementItem = (oidb_0xcf4.LoveAchievementItem)paramLoveAchievementInfo.next();
        LoveAchievementInfo.LoveAchievementItem localLoveAchievementItem1 = LoveAchievementInfo.LoveAchievementItem.a(localLoveAchievementItem);
        if (localLoveAchievementItem != null)
        {
          if (localLoveAchievementInfo.c == null) {
            localLoveAchievementInfo.c = new ArrayList();
          }
          localLoveAchievementInfo.c.add(localLoveAchievementItem1);
        }
      }
    }
    return localLoveAchievementInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoveAchievementInfo{totalCount=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", completedCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", achievements=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.LoveAchievementInfo
 * JD-Core Version:    0.7.0.1
 */