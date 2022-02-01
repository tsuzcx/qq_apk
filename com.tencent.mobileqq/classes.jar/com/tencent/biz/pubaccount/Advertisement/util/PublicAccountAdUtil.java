package com.tencent.biz.pubaccount.Advertisement.util;

import android.text.TextUtils;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.PhoneInfo;

public class PublicAccountAdUtil
{
  public static int a()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int i = 0;
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j != 5) {
                return 0;
              }
            }
            else {
              return 4;
            }
          }
          else {
            return 3;
          }
        }
        else {
          return 2;
        }
      }
      i = 1;
    }
    return i;
  }
  
  public static AdvertisementItem a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAdvertisementItem:");
      ((StringBuilder)localObject1).append(paramMessageRecord.senderuin);
      QLog.d("AdvertisementRecentUserManager", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = paramMessageRecord instanceof MessageForStructing;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    ArrayList localArrayList;
    if (bool)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      localObject1 = localObject2;
      if (localMessageForStructing.structingMsg != null)
      {
        localObject1 = localObject2;
        if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
        {
          Object localObject4 = (AbsShareMsg)localMessageForStructing.structingMsg;
          localObject3 = new ArrayList();
          localObject1 = new ArrayList();
          localArrayList = new ArrayList();
          int i = 0;
          localObject4 = ((AbsShareMsg)localObject4).mStructMsgItemLists.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            Object localObject5 = (AbsStructMsgElement)((Iterator)localObject4).next();
            if ((localObject5 instanceof AbsStructMsgItem))
            {
              localObject5 = (AbsStructMsgItem)localObject5;
              if ((((AbsStructMsgItem)localObject5).a != null) && (((AbsStructMsgItem)localObject5).a.size() > 0))
              {
                localObject5 = ((AbsStructMsgItem)localObject5).a.iterator();
                int j = i;
                for (;;)
                {
                  i = j;
                  if (!((Iterator)localObject5).hasNext()) {
                    break;
                  }
                  Object localObject6 = (AbsStructMsgElement)((Iterator)localObject5).next();
                  if ((localObject6 instanceof StructMsgItemVideo))
                  {
                    localObject6 = (StructMsgItemVideo)localObject6;
                    if ((!TextUtils.isEmpty(((StructMsgItemVideo)localObject6).ac)) && (!TextUtils.isEmpty(((StructMsgItemVideo)localObject6).ad)))
                    {
                      localObject6 = new VideoCoverItem(j, ((StructMsgItemVideo)localObject6).ac, ((StructMsgItemVideo)localObject6).ad);
                      j += 1;
                      ((ArrayList)localObject3).add(localObject6);
                      ((ArrayList)localObject1).add(((VideoCoverItem)localObject6).b);
                      localArrayList.add(((VideoCoverItem)localObject6).a);
                    }
                  }
                }
              }
            }
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("messageRecord.senderuin:");
            ((StringBuilder)localObject1).append(paramMessageRecord.senderuin);
            ((StringBuilder)localObject1).append("messageForStructing.structingMsg.mCommonData:");
            ((StringBuilder)localObject1).append(localMessageForStructing.structingMsg.mCommonData);
            ((StringBuilder)localObject1).append("list.size():");
            ((StringBuilder)localObject1).append(((ArrayList)localObject3).size());
            QLog.d("AD_Util", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramMessageRecord.senderuin))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mCommonData))
            {
              localObject1 = localObject2;
              if (((ArrayList)localObject3).size() > 0)
              {
                localObject3 = new AdvertisementItem(paramMessageRecord.senderuin, localMessageForStructing.structingMsg.mMsgUrl, (ArrayList)localObject3, localMessageForStructing.structingMsg.mCommonData);
                localObject1 = localObject2;
                if (((AdvertisementItem)localObject3).b())
                {
                  ((AdvertisementItem)localObject3).c = String.valueOf(localMessageForStructing.structingMsg.msgId);
                  if (!paramBoolean)
                  {
                    ((AdvertisementItem)localObject3).a = NetConnInfoCenter.getServerTimeMillis();
                    paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_push_time", String.valueOf(((AdvertisementItem)localObject3).a));
                  }
                  else
                  {
                    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("recent_list_advertisement_message_push_time");
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      ((AdvertisementItem)localObject3).a = Long.parseLong(paramMessageRecord);
    }
    catch (Exception paramMessageRecord)
    {
      label573:
      break label573;
    }
    ((AdvertisementItem)localObject3).a = 0L;
    if (QLog.isColorLevel())
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("start preload msgid:");
      paramMessageRecord.append(((AdvertisementItem)localObject3).c);
      QLog.d("AD_Util", 2, paramMessageRecord.toString());
    }
    ThreadManager.executeOnSubThread(new PublicAccountAdUtil.1(localArrayList));
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (AdvertisementVideoPreloadManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a((AdvertisementItem)localObject3);
      }
    }
    localObject1 = localObject3;
    return localObject1;
  }
  
  public static String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis()));
  }
  
  public static oidb_cmd0x886.PhoneInfo a()
  {
    oidb_cmd0x886.PhoneInfo localPhoneInfo = new oidb_cmd0x886.PhoneInfo();
    Object localObject = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getIMEI();
    String str = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getMAC();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = MD5Utils.toMD5(((String)localObject).toLowerCase()).toLowerCase();
      localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPhoneInfo.uint32_muid_type.set(1);
      localObject = str;
    }
    else
    {
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str.replaceAll(":", "").toUpperCase();
        str = MD5Utils.toMD5((String)localObject).toLowerCase();
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
        localPhoneInfo.uint32_muid_type.set(3);
      }
    }
    int i = a();
    localPhoneInfo.uint32_conn.set(i);
    i = 0;
    try
    {
      int j = DeviceInfoUtil.g();
      i = j;
    }
    catch (Exception localException)
    {
      label154:
      break label154;
    }
    localPhoneInfo.uint32_carrier.set(i);
    str = DeviceInfoUtil.e();
    localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
    str = DeviceInfoUtil.c();
    localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
    i = AppSetting.a();
    localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
    str = DatalineMathUtil.a(DatalineMathUtil.a());
    localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localPhoneInfo.bytes_client_mac.set(ByteStringMicro.copyFromUtf8((String)localObject));
    }
    localPhoneInfo.uint32_os_type.set(2);
    return localPhoneInfo;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return "1".equalsIgnoreCase(paramMessageRecord.getExtInfoFromExtStr("recent_list_advertisement_message"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil
 * JD-Core Version:    0.7.0.1
 */