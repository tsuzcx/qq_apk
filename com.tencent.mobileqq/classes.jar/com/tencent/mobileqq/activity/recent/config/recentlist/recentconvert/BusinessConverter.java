package com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert;

import android.util.SparseArray;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentDataConvertProcessor;
import com.tencent.mobileqq.data.RecentUser;

public class BusinessConverter
  implements IRecentDataConvertProcessor
{
  private static final SparseArray<Class<? extends RecentBaseData>> a = new BusinessConverter.1();
  
  public RecentBaseData a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    return ConversationDataFactory.a((Class)a.get(paramRecentUser.getType()), paramRecentUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert.BusinessConverter
 * JD-Core Version:    0.7.0.1
 */