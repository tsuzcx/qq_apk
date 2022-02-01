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
  private static AdvertisementRecentUserManager a;
  private ArrayList<AdvertisementItem> b = new ArrayList();
  private IReadInJoyMSFService c = (IReadInJoyMSFService)QRoute.api(IReadInJoyMSFService.class);
  private final Object d = new Object();
  
  public static AdvertisementRecentUserManager a()
  {
    if (a == null) {
      a = new AdvertisementRecentUserManager();
    }
    return a;
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l);
      this.c.handleRequest(paramToServiceMsg);
    }
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("putAdvertisementItem uin:");
      ((StringBuilder)???).append(paramAdvertisementItem.a);
      QLog.d("AdvertisementRecentUserManager", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.d)
    {
      this.b.add(paramAdvertisementItem);
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
      oidb_cmd0x886.PhoneInfo localPhoneInfo = PublicAccountAdUtil.b();
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
      ((StringBuilder)localObject).append(paramAdvertisementItem.d);
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
        paramAppInterface.append(paramAdvertisementItem.d);
        QLog.d("AdvertisementRecentUserManager", 2, paramAppInterface.toString());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if ((paramRecentUser != null) && (paramRecentUser.uin != null)) {
      synchronized (this.d)
      {
        AdvertisementItem localAdvertisementItem = b(paramRecentUser.uin);
        if ((localAdvertisementItem != null) && (NetConnInfoCenter.getServerTimeMillis() - localAdvertisementItem.e > 86400000L))
        {
          Object localObject1 = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((ProxyManager)localObject1).g();
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
            ((RecentDataListManager)localObject3).b(localStringBuilder.toString());
            ((RecentUserProxy)localObject1).a(paramRecentUser);
            RecentUtil.b(paramQQAppInterface, localAdvertisementItem.a, 1008);
            paramQQAppInterface.getMessageFacade().a(localAdvertisementItem.a, 1008);
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
    synchronized (this.d)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        AdvertisementItem localAdvertisementItem = (AdvertisementItem)localIterator.next();
        if (paramString.equals(localAdvertisementItem.a)) {
          localArrayList.add(localAdvertisementItem);
        }
      }
      this.b.removeAll(localArrayList);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public AdvertisementItem b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("getAdvertisementItem uin:");
      ((StringBuilder)???).append(paramString);
      QLog.d("AdvertisementRecentUserManager", 2, ((StringBuilder)???).toString());
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.d)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          AdvertisementItem localAdvertisementItem = (AdvertisementItem)localIterator.next();
          if (paramString.equals(localAdvertisementItem.a)) {
            return localAdvertisementItem;
          }
        }
      }
    }
    return null;
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((AdvertisementItem)localIterator.next()).f = false;
    }
  }
  
  public String c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("getTrueUin uin:");
      ((StringBuilder)???).append(paramString);
      QLog.d("AdvertisementRecentUserManager", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.d)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        AdvertisementItem localAdvertisementItem = (AdvertisementItem)localIterator.next();
        if (localAdvertisementItem.a.equals(paramString))
        {
          paramString = localAdvertisementItem.g.a;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager
 * JD-Core Version:    0.7.0.1
 */