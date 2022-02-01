package com.tencent.mobileqq.activity.recent.config.cache;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class PublicAccountAssistantProcessor
  extends AbsCacheProcessor
  implements IUpgradeCacheObserver
{
  private void a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("pubaccount_assistant_upgrade_pref" + paramQQAppInterface.getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_pubaccountassistant_when_upgrade", true))
    {
      if (paramList != null) {
        break label66;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "checkPubAccountAssistant | descRecentList == null");
      }
    }
    return;
    label66:
    Iterator localIterator = paramList.iterator();
    RecentUser localRecentUser;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localRecentUser = (RecentUser)localIterator.next();
    } while (!AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN.equals(localRecentUser.uin));
    for (;;)
    {
      if (localRecentUser != null) {
        paramList.remove(localRecentUser);
      }
      paramQQAppInterface.execute(new PublicAccountAssistantProcessor.1(this, paramQQAppInterface, localSharedPreferences));
      return;
      localRecentUser = null;
    }
  }
  
  @NonNull
  String a()
  {
    return "PublicAccountAssistantProcessor";
  }
  
  public void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull List<RecentUser> paramList)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.PublicAccountAssistantProcessor
 * JD-Core Version:    0.7.0.1
 */