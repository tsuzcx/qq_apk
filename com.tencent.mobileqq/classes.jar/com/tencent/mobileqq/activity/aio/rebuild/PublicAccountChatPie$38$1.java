package com.tencent.mobileqq.activity.aio.rebuild;

import aido;
import aiem;
import anty;
import anvx;
import bjxa;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

public class PublicAccountChatPie$38$1
  implements Runnable
{
  public PublicAccountChatPie$38$1(aiem paramaiem) {}
  
  public void run()
  {
    Object localObject = this.a.a.app.getEntityManagerFactory().createEntityManager();
    EqqDetail localEqqDetail = (EqqDetail)((EntityManager)localObject).find(EqqDetail.class, this.a.a.sessionInfo.curFriendUin);
    ((EntityManager)localObject).close();
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
          if (localConfigInfo.title.get().equals(anvx.a(2131708214))) {
            localConfigInfo.state.set(1);
          }
        }
      }
      localEqqDetail.accountData = ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).toByteArray();
      ((anty)this.a.a.app.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)).a(localEqqDetail);
      this.a.a.a.a(true);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.38.1
 * JD-Core Version:    0.7.0.1
 */