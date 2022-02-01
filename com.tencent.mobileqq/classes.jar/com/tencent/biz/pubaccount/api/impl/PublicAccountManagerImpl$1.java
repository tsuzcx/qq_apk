package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountManager.InitDoneObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;

class PublicAccountManagerImpl$1
  implements Runnable
{
  PublicAccountManagerImpl$1(PublicAccountManagerImpl paramPublicAccountManagerImpl, String paramString, AppInterface paramAppInterface, IPublicAccountManager.InitDoneObserver paramInitDoneObserver, Context paramContext) {}
  
  public void run()
  {
    Object localObject2;
    if (!this.this$0.mPublicAccountMenuButtonLists.containsKey(this.a))
    {
      localObject2 = (PublicAccountMenuEntity)this.b.getEntityManagerFactory().createEntityManager().find(PublicAccountMenuEntity.class, this.a);
      if (localObject2 == null) {}
    }
    try
    {
      localObject1 = new mobileqq_mp.GetPublicAccountMenuResponse();
    }
    catch (Exception localException1)
    {
      Object localObject1;
      label71:
      label74:
      Object localObject3;
      StringBuilder localStringBuilder;
      long l;
      int i;
      break label71;
    }
    try
    {
      ((mobileqq_mp.GetPublicAccountMenuResponse)localObject1).mergeFrom(((PublicAccountMenuEntity)localObject2).data);
    }
    catch (Exception localException2)
    {
      break label74;
    }
    localObject1 = null;
    if ((localObject1 != null) && (((mobileqq_mp.GetPublicAccountMenuResponse)localObject1).button_info.has()))
    {
      localObject3 = ((mobileqq_mp.GetPublicAccountMenuResponse)localObject1).button_info.get();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Got cached buttonInfos ");
        localStringBuilder.append(((List)localObject3).size());
        QLog.i("PublicAccountManager", 2, localStringBuilder.toString());
      }
      l = ((PublicAccountMenuEntity)localObject2).savedDateTime;
      i = ((PublicAccountMenuEntity)localObject2).seqno;
      this.this$0.menuSettingLastSaveDateTimeMap.put(this.a, Long.valueOf(l));
      this.this$0.updateMenuSettingLocalSeqno(this.a, i);
      this.this$0.mPublicAccountMenuButtonLists.put(this.a, localObject3);
      localObject2 = this.this$0.mPublicAccountMenuType;
      localObject3 = this.a;
      if (((mobileqq_mp.GetPublicAccountMenuResponse)localObject1).menu_type.has()) {
        i = ((mobileqq_mp.GetPublicAccountMenuResponse)localObject1).menu_type.get();
      } else {
        i = 0;
      }
      ((Map)localObject2).put(localObject3, Integer.valueOf(i));
    }
    this.c.a();
    return;
    localObject1 = new PublicAccountManagerImpl.1.1(this);
    this.this$0.getMenuSetting(this.d, this.b, this.a, (BusinessObserver)localObject1, false);
    return;
    this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */