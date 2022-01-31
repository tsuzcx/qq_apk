package com.tencent.mobileqq.activity.aio.rebuild;

import agti;
import agug;
import alrt;
import alud;
import awgf;
import awgg;
import bfyh;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;

public class PublicAccountChatPie$35$1
  implements Runnable
{
  public PublicAccountChatPie$35$1(agug paramagug) {}
  
  public void run()
  {
    Object localObject = this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    EqqDetail localEqqDetail = (EqqDetail)((awgf)localObject).a(EqqDetail.class, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    ((awgf)localObject).a();
    if (localEqqDetail == null) {
      return;
    }
    try
    {
      localObject = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).mergeFrom(localEqqDetail.accountData);
      localEqqDetail.groupInfoList = ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).config_group_info.get();
      localEqqDetail.mIsAgreeSyncLbs = true;
      localEqqDetail.mIsSyncLbsSelected = true;
      Iterator localIterator1 = localEqqDetail.groupInfoList.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((mobileqq_mp.ConfigGroupInfo)localIterator1.next()).config_info.get().iterator();
        while (localIterator2.hasNext())
        {
          mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)localIterator2.next();
          if (localConfigInfo.title.get().equals(alud.a(2131709150))) {
            localConfigInfo.state.set(1);
          }
        }
      }
      localEqqDetail.accountData = ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).toByteArray();
      ((alrt)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).a(localEqqDetail);
      this.a.a.jdField_a_of_type_Bfyh.a(true);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.35.1
 * JD-Core Version:    0.7.0.1
 */