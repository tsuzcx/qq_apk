package com.tencent.mobileqq.activity.aio.intimate.info;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveAchievementItem;

public class LoveAchievementInfo$LoveAchievementItem
{
  public int a;
  public String b;
  public int c;
  
  public static LoveAchievementItem a(oidb_0xcf4.LoveAchievementItem paramLoveAchievementItem)
  {
    if ((paramLoveAchievementItem != null) && (paramLoveAchievementItem.has()))
    {
      LoveAchievementItem localLoveAchievementItem = new LoveAchievementItem();
      if (paramLoveAchievementItem.uint32_achievement_id.has()) {
        localLoveAchievementItem.a = paramLoveAchievementItem.uint32_achievement_id.get();
      }
      if (paramLoveAchievementItem.str_achievement_backurl.has()) {
        localLoveAchievementItem.b = paramLoveAchievementItem.str_achievement_backurl.get();
      }
      if (paramLoveAchievementItem.clockState.has()) {
        localLoveAchievementItem.c = paramLoveAchievementItem.clockState.get();
      }
      return localLoveAchievementItem;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoveAchievementItem{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", backUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", clockStatus=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.LoveAchievementInfo.LoveAchievementItem
 * JD-Core Version:    0.7.0.1
 */