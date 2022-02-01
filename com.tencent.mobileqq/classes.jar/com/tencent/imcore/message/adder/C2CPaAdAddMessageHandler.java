package com.tencent.imcore.message.adder;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class C2CPaAdAddMessageHandler
  implements IC2CAddMessageHandler
{
  private void a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    Object localObject = PublicAccountAdUtil.a(paramAppRuntime, paramMessageRecord, false);
    if ((localObject != null) && (!TextUtils.isEmpty(((AdvertisementItem)localObject).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString)))
    {
      AdvertisementRecentUserManager.a().a(((AdvertisementItem)localObject).jdField_a_of_type_JavaLangString);
      AdvertisementRecentUserManager.a().a((AdvertisementItem)localObject);
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((AdvertisementItem)localObject).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString);
      if (((AdvertisementItem)localObject).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.b != null) {
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((AdvertisementItem)localObject).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.b);
      }
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
      paramMessageRecord = paramEntityManager.query(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
      if (paramMessageRecord != null) {
        paramMessageRecord = paramMessageRecord.iterator();
      }
    }
    else
    {
      while (paramMessageRecord.hasNext())
      {
        localObject = (MessageRecord)paramMessageRecord.next();
        paramEntityManager.remove((Entity)localObject);
        RecentUtil.b(paramAppRuntime, ((MessageRecord)localObject).senderuin, ((MessageRecord)localObject).istroop);
        RecentUser localRecentUser = paramRecentUserProxy.a(paramString, paramInt);
        if (localRecentUser != null)
        {
          RecentDataListManager localRecentDataListManager = RecentDataListManager.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("-");
          localStringBuilder.append(paramInt);
          localRecentDataListManager.a(localStringBuilder.toString());
          paramRecentUserProxy.a(localRecentUser);
        }
        paramIMessageFacade.setReaded(((MessageRecord)localObject).senderuin, 1008, true, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "isAdMessage:recent_list_advertisement_message change 0");
        }
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
      }
    }
  }
  
  public boolean[] a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = paramBoolean;
    if (paramInt2 == 1008)
    {
      bool = paramBoolean;
      if (PublicAccountAdUtil.a(paramMessageRecord)) {
        bool = true;
      }
    }
    if (bool)
    {
      a(paramAppRuntime, paramIMessageFacade, paramMessageRecord, paramEntityManager, paramRecentUserProxy, paramString, paramInt1);
      return new boolean[] { bool, true };
    }
    return new boolean[] { bool, false };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.adder.C2CPaAdAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */