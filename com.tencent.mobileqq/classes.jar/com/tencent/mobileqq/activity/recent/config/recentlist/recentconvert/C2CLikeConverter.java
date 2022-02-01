package com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentDataConvertProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;

public class C2CLikeConverter
  implements IRecentDataConvertProcessor
{
  private static final ArrayList<Integer> a = new C2CLikeConverter.1();
  
  public RecentBaseData a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    int i = paramRecentUser.getType();
    if (!a.contains(Integer.valueOf(i))) {}
    while ((TextUtils.equals(paramRecentUser.uin, AppConstants.NEW_KANDIAN_UIN)) && (ReadInJoyHelper.a((QQAppInterface)paramBaseQQAppInterface))) {
      return null;
    }
    if (paramRecentUser.lFlag == 16L) {
      return new RecentItemPublicAccountADFolderData(paramRecentUser);
    }
    if (i == 1008) {
      return new RecentItemPublicAccountChatMsgData(paramRecentUser);
    }
    return new RecentItemChatMsgData(paramRecentUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert.C2CLikeConverter
 * JD-Core Version:    0.7.0.1
 */