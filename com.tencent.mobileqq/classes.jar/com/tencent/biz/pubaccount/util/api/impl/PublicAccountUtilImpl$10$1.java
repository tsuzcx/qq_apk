package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

class PublicAccountUtilImpl$10$1
  implements Runnable
{
  PublicAccountUtilImpl$10$1(PublicAccountUtilImpl.10 param10, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    int n = 0;
    int i = 0;
    int i1 = 0;
    int m = 0;
    k = i;
    if (bool) {
      j = i1;
    }
    try
    {
      Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("data");
      j = i1;
      int i2 = this.jdField_a_of_type_AndroidOsBundle.getInt("type", 0);
      k = i;
      if (localObject3 != null)
      {
        j = i1;
        mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        j = i1;
        Object localObject4 = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
        if (i2 == 0)
        {
          j = i1;
          localGetPublicAccountDetailInfoResponse.mergeFrom((byte[])localObject3);
          bool = true;
        }
        else
        {
          j = i1;
          bool = PublicAccountUtilImpl.convert0xcf8ToMobileMP((byte[])localObject3, (oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse)localObject4, localGetPublicAccountDetailInfoResponse);
        }
        k = i;
        if (bool)
        {
          k = i;
          j = i1;
          if (localGetPublicAccountDetailInfoResponse.ret_info.has())
          {
            k = i;
            j = i1;
            if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.has())
            {
              k = i;
              j = i1;
              if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
              {
                j = i1;
                localObject3 = new PublicAccountDetailImpl();
                j = i1;
                ((PublicAccountDetailImpl)localObject3).init(localGetPublicAccountDetailInfoResponse);
                j = i1;
                localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountUtilImpl$10.a.getEntityManagerFactory(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountUtilImpl$10.a.getAccount()).createEntityManager();
                k = i;
                if (localObject4 != null)
                {
                  j = i1;
                  ((EntityManager)localObject4).persistOrReplace((Entity)localObject3);
                  j = i1;
                  localObject4 = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountUtilImpl$10.a.getRuntimeService(IPublicAccountDataManager.class, "all");
                  if (localObject4 != null)
                  {
                    j = i1;
                    ((IPublicAccountDataManager)localObject4).saveAccountDetailInfoCache(localObject3);
                    j = i1;
                    if ((PublicAccountInfo)((IPublicAccountDataManager)localObject4).findPublicAccountInfo(((PublicAccountDetailImpl)localObject3).uin) == null)
                    {
                      j = i1;
                      if (((PublicAccountDetailImpl)localObject3).followType == 1)
                      {
                        j = i1;
                        ((IPublicAccountDataManager)localObject4).savePublicAccountInfo(PublicAccountInfo.createPublicAccount((IPublicAccountDetail)localObject3, 0L));
                      }
                    }
                  }
                  j = i1;
                  j = n;
                  try
                  {
                    if (PublicAccountUtilImpl.publicAccountAIOuiHandler != null)
                    {
                      j = n;
                      PublicAccountUtilImpl.publicAccountAIOuiHandler.sendEmptyMessage(36);
                      i = 1;
                    }
                    else
                    {
                      j = n;
                      localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountUtilImpl$10.a.getHandler(Conversation.class);
                      i = m;
                      if (localObject4 != null)
                      {
                        j = n;
                        ((MqqHandler)localObject4).sendEmptyMessage(1014);
                        i = m;
                      }
                    }
                    j = i;
                    if (PublicAccountUtilImpl.access$400() != null)
                    {
                      j = i;
                      if (PublicAccountUtilImpl.access$400().get() != null)
                      {
                        j = i;
                        if (localGetPublicAccountDetailInfoResponse.uin.has())
                        {
                          j = i;
                          localObject4 = Message.obtain();
                          j = i;
                          ((Message)localObject4).obj = String.valueOf(localGetPublicAccountDetailInfoResponse.uin.get());
                          j = i;
                          ((Message)localObject4).what = 200;
                          j = i;
                          ((Handler)PublicAccountUtilImpl.access$400().get()).sendMessage((Message)localObject4);
                        }
                      }
                    }
                    j = i;
                    k = i;
                    j = i;
                    if (localGetPublicAccountDetailInfoResponse.uin.has())
                    {
                      j = i;
                      ServiceAccountFolderManager.a().a((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountUtilImpl$10.a, (IPublicAccountDetail)localObject3);
                      k = i;
                    }
                  }
                  finally {}
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        k = j;
      }
    }
    if (k == 0) {
      try
      {
        if (PublicAccountUtilImpl.publicAccountAIOuiHandler != null) {
          PublicAccountUtilImpl.publicAccountAIOuiHandler.sendEmptyMessage(36);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.10.1
 * JD-Core Version:    0.7.0.1
 */