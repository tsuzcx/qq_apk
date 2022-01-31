package com.tencent.biz.pubaccount.ecshopassit;

import ajee;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.util.WeakReference;
import nur;

public final class EcshopUtils$1
  implements Runnable
{
  public void run()
  {
    Object localObject;
    try
    {
      if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.b == null))
      {
        QLog.i("EcshopUtils", 2, "【reportQQShopPA】 chatListViewRef or recentAdapterRef is null");
        return;
      }
      FPSSwipListView localFPSSwipListView = (FPSSwipListView)this.jdField_a_of_type_MqqUtilWeakReference.get();
      localObject = (ajee)this.b.get();
      if ((localFPSSwipListView == null) || (localObject == null))
      {
        QLog.i("EcshopUtils", 2, "【reportQQShopPA】 chatListView or recentAdapter is null");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("EcshopUtils", 1, QLog.getStackTraceString(localThrowable));
      return;
    }
    int i = localThrowable.getFirstVisiblePosition();
    int j = localThrowable.getLastVisiblePosition();
    List localList = ((ajee)localObject).b();
    if ((localList != null) && (!localList.isEmpty()))
    {
      j = Math.min(j, localList.size());
      if (i <= j)
      {
        if (!QLog.isColorLevel()) {
          break label275;
        }
        QLog.i("EcshopUtils", 2, "first: " + i + "----last: " + j);
        break label275;
      }
    }
    label275:
    for (;;)
    {
      if (i < j)
      {
        if ((localList.get(i) instanceof RecentItemPublicAccountChatMsgData))
        {
          localObject = (RecentItemPublicAccountChatMsgData)localList.get(i);
          if ("3046055438".equals(((RecentItemPublicAccountChatMsgData)localObject).mUser.uin))
          {
            if (QLog.isColorLevel()) {
              QLog.i("EcshopUtils", 2, "find qqshop item in " + i + "---" + ((RecentItemPublicAccountChatMsgData)localObject).mUser.msg);
            }
            nur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "qgg.push.show");
            return;
          }
        }
        i += 1;
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopUtils.1
 * JD-Core Version:    0.7.0.1
 */