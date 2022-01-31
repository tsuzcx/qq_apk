package com.tencent.biz.pubaccount.Advertisement.util;

import android.text.TextUtils;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
import kvk;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.PhoneInfo;

public class PublicAccountAdUtil
{
  public static int a()
  {
    switch (NetworkUtil.a(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 1;
  }
  
  public static AdvertisementItem a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "getAdvertisementItem:" + paramMessageRecord.senderuin);
    }
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg instanceof AbsShareMsg)))
      {
        Object localObject2 = (AbsShareMsg)localMessageForStructing.structingMsg;
        Object localObject1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        int i = 0;
        localObject2 = ((AbsShareMsg)localObject2).mStructMsgItemLists.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
          int j = i;
          if ((localObject3 instanceof AbsStructMsgItem))
          {
            localObject3 = (AbsStructMsgItem)localObject3;
            j = i;
            if (((AbsStructMsgItem)localObject3).a != null)
            {
              j = i;
              if (((AbsStructMsgItem)localObject3).a.size() > 0)
              {
                localObject3 = ((AbsStructMsgItem)localObject3).a.iterator();
                for (;;)
                {
                  j = i;
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  Object localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
                  if ((localObject4 instanceof StructMsgItemVideo))
                  {
                    localObject4 = (StructMsgItemVideo)localObject4;
                    if ((!TextUtils.isEmpty(((StructMsgItemVideo)localObject4).u)) && (!TextUtils.isEmpty(((StructMsgItemVideo)localObject4).v)))
                    {
                      localObject4 = new VideoCoverItem(i, ((StructMsgItemVideo)localObject4).u, ((StructMsgItemVideo)localObject4).v);
                      i += 1;
                      ((ArrayList)localObject1).add(localObject4);
                      localArrayList2.add(((VideoCoverItem)localObject4).b);
                      localArrayList1.add(((VideoCoverItem)localObject4).a);
                    }
                  }
                }
              }
            }
          }
          i = j;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AD_Util", 2, "messageRecord.senderuin:" + paramMessageRecord.senderuin + "messageForStructing.structingMsg.mCommonData:" + localMessageForStructing.structingMsg.mCommonData + "list.size():" + ((ArrayList)localObject1).size());
        }
        if ((!TextUtils.isEmpty(paramMessageRecord.senderuin)) && (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mCommonData)) && (((ArrayList)localObject1).size() > 0))
        {
          localObject1 = new AdvertisementItem(paramMessageRecord.senderuin, localMessageForStructing.structingMsg.mMsgUrl, (ArrayList)localObject1, localMessageForStructing.structingMsg.mCommonData);
          if (((AdvertisementItem)localObject1).b())
          {
            ((AdvertisementItem)localObject1).c = String.valueOf(localMessageForStructing.structingMsg.msgId);
            if (!paramBoolean)
            {
              ((AdvertisementItem)localObject1).a = NetConnInfoCenter.getServerTimeMillis();
              paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_push_time", String.valueOf(((AdvertisementItem)localObject1).a));
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AD_Util", 2, "start preload msgid:" + ((AdvertisementItem)localObject1).c);
              }
              ThreadManager.executeOnSubThread(new kvk(localArrayList1));
              if (paramQQAppInterface == null) {
                break;
              }
              paramQQAppInterface = (AdvertisementVideoPreloadManager)paramQQAppInterface.getManager(237);
              if (paramQQAppInterface != null) {
                paramQQAppInterface.a((AdvertisementItem)localObject1);
              }
              return localObject1;
              paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("recent_list_advertisement_message_push_time");
              try
              {
                ((AdvertisementItem)localObject1).a = Long.parseLong(paramMessageRecord);
              }
              catch (Exception paramMessageRecord)
              {
                ((AdvertisementItem)localObject1).a = 0L;
              }
            }
          }
          return null;
          return localObject1;
        }
      }
    }
    return null;
  }
  
  public static String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis()));
  }
  
  public static oidb_cmd0x886.PhoneInfo a()
  {
    oidb_cmd0x886.PhoneInfo localPhoneInfo = new oidb_cmd0x886.PhoneInfo();
    Object localObject = DeviceInfoUtil.a();
    String str = DeviceInfoUtil.c(BaseApplication.getContext());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = MD5Utils.d(((String)localObject).toLowerCase()).toLowerCase();
      localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPhoneInfo.uint32_muid_type.set(1);
      localObject = str;
    }
    for (;;)
    {
      int i = a();
      localPhoneInfo.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = DeviceInfoUtil.e();
        i = j;
      }
      catch (Exception localException)
      {
        label82:
        break label82;
      }
      localPhoneInfo.uint32_carrier.set(i);
      str = DeviceInfoUtil.f();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
      str = DeviceInfoUtil.d();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
      i = AppSetting.a;
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      str = DatalineMathUtil.a(DatalineMathUtil.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localPhoneInfo.bytes_client_mac.set(ByteStringMicro.copyFromUtf8((String)localObject));
      }
      localPhoneInfo.uint32_os_type.set(2);
      return localPhoneInfo;
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str.replaceAll(":", "").toUpperCase();
        str = MD5Utils.d((String)localObject).toLowerCase();
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
        localPhoneInfo.uint32_muid_type.set(3);
      }
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if ("1".equalsIgnoreCase(paramMessageRecord.getExtInfoFromExtStr("recent_list_advertisement_message"))) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil
 * JD-Core Version:    0.7.0.1
 */