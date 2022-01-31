package com.tencent.biz.pubaccount.Advertisement.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kuc;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.PhoneInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.ReqBody;

public class AdvertisementRecentUserManager
{
  private static AdvertisementRecentUserManager jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementRecentUserManager;
  private ReadInJoyMSFService jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = ReadInJoyMSFService.a();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static AdvertisementRecentUserManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementRecentUserManager == null) {
      jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementRecentUserManager = new AdvertisementRecentUserManager();
    }
    return jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementRecentUserManager;
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService.a(paramToServiceMsg);
    }
  }
  
  public AdvertisementItem a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "getAdvertisementItem uin:" + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          AdvertisementItem localAdvertisementItem = (AdvertisementItem)localIterator.next();
          if (paramString.equals(localAdvertisementItem.jdField_a_of_type_JavaLangString)) {
            return localAdvertisementItem;
          }
        }
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "getTrueUin uin:" + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        AdvertisementItem localAdvertisementItem = (AdvertisementItem)localIterator.next();
        if (localAdvertisementItem.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          paramString = localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString;
          return paramString;
        }
      }
      return null;
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AdvertisementItem)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "putAdvertisementItem uin:" + paramAdvertisementItem.jdField_a_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAdvertisementItem);
      return;
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, AdvertisementItem paramAdvertisementItem)
  {
    if ((paramAdvertisementItem == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      oidb_cmd0x886.PhoneInfo localPhoneInfo = PublicAccountAdUtil.a();
      try
      {
        l1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
        paramAppInterface = paramAdvertisementItem.a(paramInt);
        long l2 = NetConnInfoCenter.getServerTimeMillis();
        String str = MD5Utils.d(l1 + paramAdvertisementItem.c + paramInt + l2);
        oidb_cmd0x886.ReqBody localReqBody = new oidb_cmd0x886.ReqBody();
        localReqBody.uint64_uin.set(l1);
        localReqBody.msg_phone_info.set(localPhoneInfo);
        localReqBody.msg_ad_info.set(paramAppInterface);
        localReqBody.uint64_client_time.set(l2);
        localReqBody.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str));
        localReqBody.enum_ad_display.set(1);
        a(ReadInJoyOidbHelper.a("OidbSvc.0x886", 2182, 0, localReqBody.toByteArray()));
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramAppInterface = new StringBuilder("AdReport(");
        paramAppInterface.append(paramInt).append(") msgID=").append(paramAdvertisementItem.c);
        QLog.d("AdvertisementRecentUserManager", 2, paramAppInterface.toString());
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          long l1 = 0L;
          paramAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if ((paramRecentUser != null) && (paramRecentUser.uin != null)) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        AdvertisementItem localAdvertisementItem = a(paramRecentUser.uin);
        if ((localAdvertisementItem != null) && (NetConnInfoCenter.getServerTimeMillis() - localAdvertisementItem.jdField_a_of_type_Long > 86400000L))
        {
          localObject1 = (ProxyManager)paramQQAppInterface.getManager(17);
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementRecentUserManager", 2, "deleteItem uin:" + paramRecentUser.uin);
              }
              RecentDataListManager.a().a(paramRecentUser.uin + "-" + paramRecentUser.type);
              ((RecentUserProxy)localObject1).b(paramRecentUser);
              RecentUtil.b(paramQQAppInterface, localAdvertisementItem.jdField_a_of_type_JavaLangString, 1008);
              paramQQAppInterface.a().c(localAdvertisementItem.jdField_a_of_type_JavaLangString, 1008);
            }
            ThreadManager.executeOnFileThread(new kuc(this, localAdvertisementItem));
          }
        }
        else
        {
          return;
        }
        Object localObject1 = ((ProxyManager)localObject1).a();
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "removeUinItem uin:" + paramString);
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        AdvertisementItem localAdvertisementItem = (AdvertisementItem)localIterator.next();
        if (paramString.equals(localAdvertisementItem.jdField_a_of_type_JavaLangString)) {
          localArrayList.add(localAdvertisementItem);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager
 * JD-Core Version:    0.7.0.1
 */