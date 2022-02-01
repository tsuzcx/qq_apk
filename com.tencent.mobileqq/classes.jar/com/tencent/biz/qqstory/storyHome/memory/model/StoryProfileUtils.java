package com.tencent.biz.qqstory.storyHome.memory.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class StoryProfileUtils
{
  public static boolean a(QQUserUIItem paramQQUserUIItem)
  {
    return (paramQQUserUIItem != null) && (paramQQUserUIItem.isVip()) && (!paramQQUserUIItem.isMe()) && (!paramQQUserUIItem.isFriend()) && (!paramQQUserUIItem.isSubscribe());
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.equals("0_1000", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileUtils
 * JD-Core Version:    0.7.0.1
 */