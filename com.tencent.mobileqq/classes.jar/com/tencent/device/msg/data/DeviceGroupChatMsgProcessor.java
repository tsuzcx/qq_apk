package com.tencent.device.msg.data;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.file.DeviceFileObserver.CallbackPack;
import com.tencent.device.file.DeviceFileObserver.SessionPack;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceGroupChatMsgProcessor
  extends DeviceFileObserver
{
  private QQAppInterface a;
  private ConcurrentHashMap<Long, DeviceFileObserver.SessionPack> b = new ConcurrentHashMap(20);
  private ArrayList<DeviceFileObserver.CallbackPack> c = new ArrayList();
  private ConcurrentHashMap<Long, Long> d = new ConcurrentHashMap(10);
  
  public DeviceGroupChatMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private long a(MessageForDeviceFile paramMessageForDeviceFile, View paramView, MessageForDeviceFile.DeviceFileItemCallback paramDeviceFileItemCallback)
  {
    if ((paramMessageForDeviceFile != null) && (!TextUtils.isEmpty(paramMessageForDeviceFile.strMediaKey)))
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        return 0L;
      }
      int j = 0;
      Iterator localIterator = this.c.iterator();
      DeviceFileObserver.CallbackPack localCallbackPack;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localCallbackPack = (DeviceFileObserver.CallbackPack)localIterator.next();
      } while (localCallbackPack.a() != paramView);
      localCallbackPack.b = new WeakReference(paramDeviceFileItemCallback);
      int i = 1;
      if (i == 0) {
        this.c.add(new DeviceFileObserver.CallbackPack(this, paramView, paramDeviceFileItemCallback));
      }
      if (this.b.containsKey(Long.valueOf(paramMessageForDeviceFile.uSessionID))) {
        return paramMessageForDeviceFile.uSessionID;
      }
      if (this.d.containsKey(Long.valueOf(paramMessageForDeviceFile.uniseq)))
      {
        l = ((Long)this.d.get(Long.valueOf(paramMessageForDeviceFile.uniseq))).longValue();
        if (MessageCache.c() - l < 3600L) {
          return paramMessageForDeviceFile.uSessionID;
        }
      }
      long l = ((DeviceFileHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(this.a, paramMessageForDeviceFile.strMediaKey, paramMessageForDeviceFile.strFileKey2, 3, 2154);
      paramView = this.a.getMessageFacade().a(paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
      if ((paramView instanceof MessageForDeviceFile)) {
        ((MessageForDeviceFile)paramView).uSessionID = l;
      }
      paramMessageForDeviceFile.uSessionID = l;
      if (l != 0L) {
        a(l, paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
      }
      return l;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceGroupChatMsgProcessor", 2, "mr is null or strCoverKey is empty in downloadCoverFile!");
    }
    return 0L;
  }
  
  private MessageRecord a(long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("duration", 0);
    Object localObject = paramJSONObject.optString("file_key", "");
    String str = paramJSONObject.optString("fkey2", "");
    paramJSONObject = (MessageForDevPtt)MessageRecordFactory.f(this.a, Long.toString(paramLong2), null, 9501);
    paramJSONObject.url = "";
    paramJSONObject.urlAtServer = ((String)localObject);
    paramJSONObject.strFileKey2 = str;
    paramJSONObject.channeltype = 3;
    paramJSONObject.itemType = 2;
    paramJSONObject.sttAbility = 0;
    paramJSONObject.longPttVipFlag = 0;
    paramJSONObject.c2cViaOffline = true;
    paramJSONObject.msgtype = -4501;
    paramJSONObject.istroop = 9501;
    paramJSONObject.issend = 0;
    paramJSONObject.isread = false;
    paramJSONObject.selfuin = this.a.getCurrentAccountUin();
    paramJSONObject.senderuin = Long.toString(paramLong1);
    paramJSONObject.frienduin = Long.toString(paramLong2);
    paramJSONObject.time = MessageCache.c();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ContactUtils.a(this.a, paramJSONObject.senderuin, true));
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(this.a.getApp().getString(2131888237));
    paramJSONObject.msg = ((StringBuilder)localObject).toString();
    paramJSONObject.voiceLength = i;
    paramJSONObject.extStr = "device_groupchat";
    paramJSONObject.serial();
    return paramJSONObject;
  }
  
  private void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.b.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new DeviceFileObserver.SessionPack(this, paramString, paramInt, paramLong2);
      this.b.put(Long.valueOf(paramLong1), paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceGroupChatMsgProcessor", 2, "found resume");
    }
  }
  
  private MessageRecord b(long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("media_key", "");
    String str2 = paramJSONObject.optString("cover_key", "");
    String str3 = paramJSONObject.optString("fkey2", "");
    paramJSONObject = paramJSONObject.optString("ckey2", "");
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)MessageRecordFactory.a(-4500);
    localMessageForDeviceFile.strServiceName = DeviceMsgHandle.d;
    localMessageForDeviceFile.msgtype = -4500;
    localMessageForDeviceFile.istroop = 9501;
    localMessageForDeviceFile.filePath = "";
    localMessageForDeviceFile.issend = 0;
    localMessageForDeviceFile.isread = false;
    localMessageForDeviceFile.selfuin = this.a.getCurrentAccountUin();
    localMessageForDeviceFile.senderuin = Long.toString(paramLong1);
    localMessageForDeviceFile.frienduin = Long.toString(paramLong2);
    localMessageForDeviceFile.msgStatus = 3;
    localMessageForDeviceFile.nFileStatus = 1;
    localMessageForDeviceFile.time = MessageCache.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ContactUtils.a(this.a, localMessageForDeviceFile.senderuin, true));
    localStringBuilder.append(": ");
    localStringBuilder.append(this.a.getApp().getString(2131888525));
    localMessageForDeviceFile.msg = localStringBuilder.toString();
    localMessageForDeviceFile.nFileMsgType = 2;
    localMessageForDeviceFile.extStr = "device_groupchat";
    localMessageForDeviceFile.strCoverKey = str2;
    localMessageForDeviceFile.strMediaKey = str1;
    localMessageForDeviceFile.strFileKey2 = str3;
    localMessageForDeviceFile.strCoverKey2 = paramJSONObject;
    localMessageForDeviceFile.serial();
    return localMessageForDeviceFile;
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    int j;
    for (int i = 0; i < this.c.size(); i = j + 1)
    {
      Object localObject = (DeviceFileObserver.CallbackPack)this.c.get(i);
      View localView = ((DeviceFileObserver.CallbackPack)localObject).a();
      localObject = ((DeviceFileObserver.CallbackPack)localObject).b();
      if ((localView != null) && (localObject != null))
      {
        j = i;
        if ((paramMessageRecord instanceof MessageForDeviceFile))
        {
          ((MessageForDeviceFile.DeviceFileItemCallback)localObject).a(localView, (MessageForDeviceFile)paramMessageRecord);
          j = i;
        }
      }
      else
      {
        this.c.remove(i);
        j = i - 1;
      }
    }
  }
  
  public long a(MessageRecord paramMessageRecord, View paramView, MessageForDeviceFile.DeviceFileItemCallback paramDeviceFileItemCallback)
  {
    if ((paramMessageRecord instanceof MessageForDeviceFile)) {
      return a((MessageForDeviceFile)paramMessageRecord, paramView, paramDeviceFileItemCallback);
    }
    return 0L;
  }
  
  protected MessageRecord a(long paramLong)
  {
    Object localObject = (DeviceFileObserver.SessionPack)this.b.get(Long.valueOf(paramLong));
    if (localObject == null) {
      return null;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localAppRuntime).getMessageFacade().a(((DeviceFileObserver.SessionPack)localObject).a, ((DeviceFileObserver.SessionPack)localObject).b, ((DeviceFileObserver.SessionPack)localObject).c);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceGroupChatMsgProcessor", 2, "device file msg null");
        }
        return null;
      }
      return localObject;
    }
    return null;
  }
  
  public void a(DataPoint paramDataPoint)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramDataPoint.mValue);
      long l2 = localJSONObject.optLong("from_uin");
      long l1 = l2;
      if (0L == l2) {
        l1 = paramDataPoint.mDin;
      }
      long l3 = localJSONObject.optLong("to_din");
      l2 = l3;
      if (0L == l3) {
        l2 = paramDataPoint.mDin;
      }
      if ((!TextUtils.isEmpty(this.a.getCurrentAccountUin())) && (String.valueOf(l1).equals(this.a.getCurrentAccountUin()))) {
        return;
      }
      localObject = null;
      if (10011 == paramDataPoint.mProperityId) {
        localObject = a(l1, l2, localJSONObject);
      } else if (10010 == paramDataPoint.mProperityId) {
        localObject = b(l1, l2, localJSONObject);
      }
      this.a.getMessageFacade().a((MessageRecord)localObject, this.a.getCurrentAccountUin());
      return;
    }
    catch (JSONException paramDataPoint)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getString from json error:");
        ((StringBuilder)localObject).append(paramDataPoint.getMessage());
        QLog.d("DeviceGroupChatMsgProcessor", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (!paramSession.bSend)
    {
      MessageRecord localMessageRecord = a(paramSession.uSessionID);
      if (localMessageRecord == null) {
        return;
      }
      if ((localMessageRecord instanceof MessageForDeviceFile))
      {
        MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)localMessageRecord;
        if (localMessageForDeviceFile.uSessionID == paramSession.uSessionID)
        {
          localMessageForDeviceFile.filePath = paramSession.strFilePathSrc;
          localMessageForDeviceFile.progress = 1.0F;
          if (paramBoolean)
          {
            localMessageForDeviceFile.nFileStatus = 5;
            this.d.remove(Long.valueOf(localMessageRecord.uniseq));
          }
          else
          {
            localMessageForDeviceFile.nFileStatus = 6;
            this.d.put(Long.valueOf(localMessageRecord.uniseq), Long.valueOf(MessageCache.c()));
          }
          localMessageForDeviceFile.serial();
          this.a.getMessageFacade().a(localMessageRecord.frienduin, 9501, localMessageRecord.uniseq, localMessageRecord.msgData);
          if ((localMessageForDeviceFile.uSessionID == paramSession.uSessionID) && (paramBoolean)) {
            b(localMessageForDeviceFile);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("DeviceGroupChatMsgProcessor", 2, "error:can not find session id in message record");
          }
          return;
        }
      }
      this.b.remove(Long.valueOf(paramSession.uSessionID));
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject = (DeviceFileHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER);
    long l;
    if ((paramMessageRecord instanceof MessageForDeviceFile))
    {
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramMessageRecord;
      l = ((DeviceFileHandler)localObject).a(this.a, localMessageForDeviceFile.strMediaKey, localMessageForDeviceFile.strFileKey2, 3, 2154);
      localObject = this.a.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      if ((localObject instanceof MessageForDeviceFile)) {
        ((MessageForDeviceFile)localObject).uSessionID = l;
      }
      localMessageForDeviceFile.uSessionID = l;
    }
    else
    {
      l = 0L;
    }
    if (l != 0L) {
      a(l, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    }
  }
  
  public void b(Session paramSession)
  {
    if (!paramSession.bSend)
    {
      Object localObject = a(paramSession.uSessionID);
      if (localObject == null) {
        return;
      }
      if ((localObject instanceof MessageForDeviceFile))
      {
        localObject = (MessageForDeviceFile)localObject;
        if (((MessageForDeviceFile)localObject).uSessionID == paramSession.uSessionID) {
          ((MessageForDeviceFile)localObject).nFileStatus = 2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceGroupChatMsgProcessor
 * JD-Core Version:    0.7.0.1
 */