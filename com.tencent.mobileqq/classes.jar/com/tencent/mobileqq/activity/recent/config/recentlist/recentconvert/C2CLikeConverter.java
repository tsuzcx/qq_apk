package com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentDataConvertProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class C2CLikeConverter
  implements IRecentDataConvertProcessor
{
  private static final ArrayList<Integer> a = new C2CLikeConverter.1();
  
  public RecentBaseData a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    int i = paramRecentUser.getType();
    boolean bool = a.contains(Integer.valueOf(i));
    paramBaseQQAppInterface = null;
    if (!bool) {
      return null;
    }
    if ((!TextUtils.equals(paramRecentUser.uin, AppConstants.NEW_KANDIAN_UIN)) || (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()))
    {
      if (paramRecentUser.lFlag == 16L) {
        return new RecentItemPublicAccountADFolderData(paramRecentUser);
      }
      if (i == 1008) {
        return new RecentItemPublicAccountChatMsgData(paramRecentUser);
      }
      paramBaseQQAppInterface = new RecentItemChatMsgData(paramRecentUser);
    }
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert.C2CLikeConverter
 * JD-Core Version:    0.7.0.1
 */