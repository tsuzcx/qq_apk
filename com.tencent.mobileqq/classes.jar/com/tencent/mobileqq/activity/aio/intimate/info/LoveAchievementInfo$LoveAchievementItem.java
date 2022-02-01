package com.tencent.mobileqq.activity.aio.intimate.info;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveAchievementItem;

public class LoveAchievementInfo$LoveAchievementItem
{
  public int a;
  public String a;
  public int b;
  
  public static LoveAchievementItem a(oidb_0xcf4.LoveAchievementItem paramLoveAchievementItem)
  {
    Object localObject;
    if ((paramLoveAchievementItem == null) || (!paramLoveAchievementItem.has())) {
      localObject = null;
    }
    LoveAchievementItem localLoveAchievementItem;
    do
    {
      return localObject;
      localLoveAchievementItem = new LoveAchievementItem();
      if (paramLoveAchievementItem.uint32_achievement_id.has()) {
        localLoveAchievementItem.jdField_a_of_type_Int = paramLoveAchievementItem.uint32_achievement_id.get();
      }
      if (paramLoveAchievementItem.str_achievement_backurl.has()) {
        localLoveAchievementItem.jdField_a_of_type_JavaLangString = paramLoveAchievementItem.str_achievement_backurl.get();
      }
      localObject = localLoveAchievementItem;
    } while (!paramLoveAchievementItem.clockState.has());
    localLoveAchievementItem.b = paramLoveAchievementItem.clockState.get();
    return localLoveAchievementItem;
  }
  
  public String toString()
  {
    return "LoveAchievementItem{id=" + this.jdField_a_of_type_Int + ", backUrl=" + this.jdField_a_of_type_JavaLangString + ", clockStatus=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.LoveAchievementInfo.LoveAchievementItem
 * JD-Core Version:    0.7.0.1
 */