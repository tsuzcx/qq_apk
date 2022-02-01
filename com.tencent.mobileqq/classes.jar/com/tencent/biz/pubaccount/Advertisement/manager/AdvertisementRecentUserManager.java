package com.tencent.biz.pubaccount.Advertisement.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.base.msf.api.IReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.PhoneInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.ReqBody;

public class AdvertisementRecentUserManager
{
  private static AdvertisementRecentUserManager jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementRecentUserManager;
  private IReadInJoyMSFService jdField_a_of_type_ComTencentMobileqqKandianBaseMsfApiIReadInJoyMSFService = (IReadInJoyMSFService)QRoute.api(IReadInJoyMSFService.class);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<AdvertisementItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
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
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfApiIReadInJoyMSFService.handleRequest(paramToServiceMsg);
    }
  }
  
  public AdvertisementItem a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("getAdvertisementItem uin:");
      ((StringBuilder)???).append(paramString);
      QLog.d("AdvertisementRecentUserManager", 2, ((StringBuilder)???).toString());
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
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("getTrueUin uin:");
      ((StringBuilder)???).append(paramString);
      QLog.d("AdvertisementRecentUserManager", 2, ((StringBuilder)???).toString());
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
    for (;;)
    {
      throw paramString;
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
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("putAdvertisementItem uin:");
      ((StringBuilder)???).append(paramAdvertisementItem.jdField_a_of_type_JavaLangString);
      QLog.d("AdvertisementRecentUserManager", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAdvertisementItem);
      return;
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, AdvertisementItem paramAdvertisementItem)
  {
    if (paramAdvertisementItem != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      oidb_cmd0x886.PhoneInfo localPhoneInfo = PublicAccountAdUtil.a();
      long l1;
      try
      {
        l1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
      }
      catch (Exception paramAppInterface)
      {
        l1 = 0L;
        paramAppInterface.printStackTrace();
      }
      paramAppInterface = paramAdvertisementItem.a(paramInt);
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(paramAdvertisementItem.c);
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(l2);
      localObject = MD5Utils.toMD5(((StringBuilder)localObject).toString());
      oidb_cmd0x886.ReqBody localReqBody = new oidb_cmd0x886.ReqBody();
      localReqBody.uint64_uin.set(l1);
      localReqBody.msg_phone_info.set(localPhoneInfo);
      localReqBody.msg_ad_info.set(paramAppInterface);
      localReqBody.uint64_client_time.set(l2);
      localReqBody.bytes_uuid.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localReqBody.enum_ad_display.set(1);
      a(((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).makeOIDBPkg("OidbSvc.0x886", 2182, 0, localReqBody.toByteArray()));
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder("AdReport(");
        paramAppInterface.append(paramInt);
        paramAppInterface.append(") msgID=");
        paramAppInterface.append(paramAdvertisementItem.c);
        QLog.d("AdvertisementRecentUserManager", 2, paramAppInterface.toString());
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
          Object localObject1 = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((ProxyManager)localObject1).a();
          }
          if (localObject1 != null)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("deleteItem uin:");
              ((StringBuilder)localObject3).append(paramRecentUser.uin);
              QLog.d("AdvertisementRecentUserManager", 2, ((StringBuilder)localObject3).toString());
            }
            Object localObject3 = RecentDataListManager.a();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramRecentUser.uin);
            localStringBuilder.append("-");
            localStringBuilder.append(paramRecentUser.getType());
            ((RecentDataListManager)localObject3).a(localStringBuilder.toString());
            ((RecentUserProxy)localObject1).a(paramRecentUser);
            RecentUtil.b(paramQQAppInterface, localAdvertisementItem.jdField_a_of_type_JavaLangString, 1008);
            paramQQAppInterface.getMessageFacade().a(localAdvertisementItem.jdField_a_of_type_JavaLangString, 1008);
          }
          ThreadManager.executeOnFileThread(new AdvertisementRecentUserManager.1(this, localAdvertisementItem));
        }
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("removeUinItem uin:");
      ((StringBuilder)???).append(paramString);
      QLog.d("AdvertisementRecentUserManager", 2, ((StringBuilder)???).toString());
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
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager
 * JD-Core Version:    0.7.0.1
 */