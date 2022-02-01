package com.tencent.biz.qqstory.boundaries.implement.staticmethods;

import android.content.SharedPreferences;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.common.app.AppInterface;
import mqq.app.MobileQQ;

public class StaticMethods$QimUtil
{
  public static String a(QQUserUIItem paramQQUserUIItem)
  {
    paramQQUserUIItem = PlayModeUtils.b();
    MobileQQ localMobileQQ = paramQQUserUIItem.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("public_account_qq_mail_");
    localStringBuilder.append(paramQQUserUIItem.getCurrentAccountUin());
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString("key_story_qim_online_icon_url", null);
  }
  
  public static String b(QQUserUIItem paramQQUserUIItem)
  {
    paramQQUserUIItem = PlayModeUtils.b();
    MobileQQ localMobileQQ = paramQQUserUIItem.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("public_account_qq_mail_");
    localStringBuilder.append(paramQQUserUIItem.getCurrentAccountUin());
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString("profile_card_qim_online_url", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.staticmethods.StaticMethods.QimUtil
 * JD-Core Version:    0.7.0.1
 */