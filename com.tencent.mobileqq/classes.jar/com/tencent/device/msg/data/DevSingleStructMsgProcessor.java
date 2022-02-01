package com.tencent.device.msg.data;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.file.DeviceProto.MsgFileKey;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.DeviceSingleStructItemCallback;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.device.MiniFileProto.MiniFile;

public class DevSingleStructMsgProcessor
  extends DeviceFileObserver
{
  private final QQAppInterface a;
  private ConcurrentHashMap<Long, DevSingleStructMsgProcessor.SessionPack> b = new ConcurrentHashMap(20);
  private ArrayList<DevSingleStructMsgProcessor.CallbackPack> c = new ArrayList();
  private ConcurrentHashMap<Long, Long> d = new ConcurrentHashMap(10);
  
  public DevSingleStructMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.b.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new DevSingleStructMsgProcessor.SessionPack(this, paramString, paramInt, paramLong2);
      this.b.put(Long.valueOf(paramLong1), paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DevSingleStructMsgProcessor", 2, "found resume");
    }
  }
  
  private void d(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    int i = 0;
    while (i < this.c.size())
    {
      Object localObject = (DevSingleStructMsgProcessor.CallbackPack)this.c.get(i);
      View localView = ((DevSingleStructMsgProcessor.CallbackPack)localObject).a();
      localObject = ((DevSingleStructMsgProcessor.CallbackPack)localObject).b();
      if ((localView != null) && (localObject != null))
      {
        ((MessageForDeviceSingleStruct.DeviceSingleStructItemCallback)localObject).a(localView, paramMessageForDeviceSingleStruct);
      }
      else
      {
        this.c.remove(i);
        i -= 1;
      }
      i += 1;
    }
  }
  
  public long a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, View paramView, MessageForDeviceSingleStruct.DeviceSingleStructItemCallback paramDeviceSingleStructItemCallback)
  {
    if ((paramMessageForDeviceSingleStruct != null) && (!TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strCoverKey)))
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        return 0L;
      }
      if (paramView != null)
      {
        int j = 0;
        Iterator localIterator = this.c.iterator();
        DevSingleStructMsgProcessor.CallbackPack localCallbackPack;
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localCallbackPack = (DevSingleStructMsgProcessor.CallbackPack)localIterator.next();
        } while (localCallbackPack.a() != paramView);
        localCallbackPack.b = new WeakReference(paramDeviceSingleStructItemCallback);
        int i = 1;
        if (i == 0) {
          this.c.add(new DevSingleStructMsgProcessor.CallbackPack(this, paramView, paramDeviceSingleStructItemCallback));
        }
      }
      if (this.b.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nCoverSessionID))) {
        return paramMessageForDeviceSingleStruct.nCoverSessionID;
      }
      if (this.d.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.uniseq)))
      {
        l = ((Long)this.d.get(Long.valueOf(paramMessageForDeviceSingleStruct.uniseq))).longValue();
        if (MessageCache.c() - l < 3600L) {
          return paramMessageForDeviceSingleStruct.nCoverSessionID;
        }
      }
      long l = ((DeviceFileHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(this.a, paramMessageForDeviceSingleStruct.strCoverKey, paramMessageForDeviceSingleStruct.strCoverKey2, paramMessageForDeviceSingleStruct.nCoverChannelType, 2154);
      paramView = this.a.getMessageFacade().a(paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      if ((paramView instanceof MessageForDeviceSingleStruct)) {
        ((MessageForDeviceSingleStruct)paramView).nCoverSessionID = l;
      }
      paramMessageForDeviceSingleStruct.nCoverSessionID = l;
      if (l != 0L) {
        a(l, paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      }
      return l;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DevSingleStructMsgProcessor", 2, "mr is null or strCoverKey is empty in downloadCoverFile!");
    }
    return 0L;
  }
  
  public MessageForDeviceSingleStruct a(Long paramLong)
  {
    paramLong = (DevSingleStructMsgProcessor.SessionPack)this.b.get(paramLong);
    if (paramLong == null) {
      return null;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramLong = ((QQAppInterface)localAppRuntime).getMessageFacade().a(paramLong.a, paramLong.b, paramLong.c);
      if (paramLong == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevSingleStructMsgProcessor", 2, "device file msg null");
        }
        return null;
      }
      if ((paramLong instanceof MessageForDeviceSingleStruct)) {
        return (MessageForDeviceSingleStruct)paramLong;
      }
    }
    return null;
  }
  
  public String a(DataPoint paramDataPoint)
  {
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct = (MessageForDeviceSingleStruct)MessageRecordFactory.a(-4502);
    localMessageForDeviceSingleStruct.msgtype = -4502;
    localMessageForDeviceSingleStruct.istroop = 9501;
    localMessageForDeviceSingleStruct.issend = 0;
    localMessageForDeviceSingleStruct.isread = false;
    localMessageForDeviceSingleStruct.selfuin = this.a.getCurrentAccountUin();
    localMessageForDeviceSingleStruct.senderuin = Long.toString(paramDataPoint.mDin);
    localMessageForDeviceSingleStruct.frienduin = Long.toString(paramDataPoint.mDin);
    localMessageForDeviceSingleStruct.nDataType = 1;
    localMessageForDeviceSingleStruct.parseFromJson(paramDataPoint.mValue);
    localMessageForDeviceSingleStruct.msg = localMessageForDeviceSingleStruct.strTitle;
    Object localObject = (DeviceFileHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER);
    StringBuilder localStringBuilder2;
    if ((!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverKey)) && (localMessageForDeviceSingleStruct.nCoverChannelType == 1))
    {
      DeviceProto.MsgFileKey localMsgFileKey = ((DeviceFileHandler)localObject).a(localMessageForDeviceSingleStruct.strCoverKey);
      try
      {
        localMessageForDeviceSingleStruct.strCoverMD5 = new BigInteger(1, localMsgFileKey.bytes_file_md5.get().toByteArray()).toString(16);
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label351;
        }
      }
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Exception in onReceiveSingleStructMsg: ");
      localStringBuilder2.append(localException2.getMessage());
      QLog.d("DevSingleStructMsgProcessor", 2, localStringBuilder2.toString());
    }
    else if ((!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverKey)) && (localMessageForDeviceSingleStruct.nCoverChannelType == 3))
    {
      try
      {
        localMessageForDeviceSingleStruct.strCoverMD5 = new BigInteger(1, ((MiniFileProto.MiniFile)new MiniFileProto.MiniFile().mergeFrom(Base64.decode(localMessageForDeviceSingleStruct.strCoverKey2, 2))).md5.get().toByteArray()).toString(16);
      }
      catch (Exception localException3)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("Exception in onReceiveSingleStructMsg: ");
          localStringBuilder2.append(localException3.getMessage());
          QLog.d("DevSingleStructMsgProcessor", 2, localStringBuilder2.toString());
        }
      }
    }
    label351:
    if ((!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaKey)) && (localMessageForDeviceSingleStruct.nMediaChannelType == 1))
    {
      localObject = ((DeviceFileHandler)localObject).a(localMessageForDeviceSingleStruct.strMediaKey);
      if (localObject != null)
      {
        localMessageForDeviceSingleStruct.strMediaFileName = ((DeviceProto.MsgFileKey)localObject).str_file_name.get();
        localMessageForDeviceSingleStruct.nMediaFileSize = ((DeviceProto.MsgFileKey)localObject).uint64_file_length.get();
      }
    }
    else if ((!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaKey)) && (localMessageForDeviceSingleStruct.nMediaChannelType == 3))
    {
      try
      {
        localObject = (MiniFileProto.MiniFile)new MiniFileProto.MiniFile().mergeFrom(Base64.decode(localMessageForDeviceSingleStruct.strFileKey2, 2));
        localMessageForDeviceSingleStruct.strMediaFileName = ((MiniFileProto.MiniFile)localObject).name.get();
        localMessageForDeviceSingleStruct.nMediaFileSize = ((MiniFileProto.MiniFile)localObject).length.get();
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("Exception in onReceiveSingleStructMsg: ");
          localStringBuilder1.append(localException1.getMessage());
          QLog.d("DevSingleStructMsgProcessor", 2, localStringBuilder1.toString());
        }
      }
    }
    this.a.getMessageFacade().a(localMessageForDeviceSingleStruct, this.a.getCurrentAccountUin());
    int i;
    if (localMessageForDeviceSingleStruct.nDataType == 2) {
      i = 4;
    } else {
      i = 3;
    }
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(paramDataPoint.mDin);
    int j;
    if (localDeviceInfo != null) {
      j = localDeviceInfo.productId;
    } else {
      j = 0;
    }
    SmartDeviceReport.a(this.a, paramDataPoint.mDin, "Usr_AIO_ReceiveMsg", i, 0, j);
    if ((localDeviceInfo != null) && (localDeviceInfo.isAdmin == 1) && (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.faceRect))) {
      SmartDeviceReport.a(this.a, paramDataPoint.mDin, "FR_StrangerComming", 0, 0, 0);
    }
    return localMessageForDeviceSingleStruct.msg;
  }
  
  public void a()
  {
    this.d.clear();
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (!paramSession.bSend)
    {
      MessageForDeviceSingleStruct localMessageForDeviceSingleStruct = a(Long.valueOf(paramSession.uSessionID));
      if (localMessageForDeviceSingleStruct == null) {
        return;
      }
      if (localMessageForDeviceSingleStruct.nMediaSessionID == paramSession.uSessionID)
      {
        localMessageForDeviceSingleStruct.nMediaFileStatus = 3;
        localMessageForDeviceSingleStruct.nMediaProgress = paramFloat;
        if (localMessageForDeviceSingleStruct.nMediaFileSize == 0L) {
          localMessageForDeviceSingleStruct.nMediaFileSize = paramSession.uFileSizeSrc;
        }
      }
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (!paramSession.bSend)
    {
      MessageForDeviceSingleStruct localMessageForDeviceSingleStruct = a(Long.valueOf(paramSession.uSessionID));
      if (localMessageForDeviceSingleStruct == null) {
        return;
      }
      if (localMessageForDeviceSingleStruct.nCoverSessionID == paramSession.uSessionID)
      {
        localMessageForDeviceSingleStruct.strCoverPath = paramSession.strFilePathSrc;
        if (paramBoolean) {
          this.d.remove(Long.valueOf(localMessageForDeviceSingleStruct.uniseq));
        } else {
          this.d.put(Long.valueOf(localMessageForDeviceSingleStruct.uniseq), Long.valueOf(MessageCache.c()));
        }
      }
      else
      {
        if (localMessageForDeviceSingleStruct.nMediaSessionID != paramSession.uSessionID) {
          break label310;
        }
        localMessageForDeviceSingleStruct.strMediaPath = paramSession.strFilePathSrc;
        localMessageForDeviceSingleStruct.nMediaProgress = 1.0F;
        if (paramBoolean) {
          localMessageForDeviceSingleStruct.nMediaFileStatus = 5;
        } else {
          localMessageForDeviceSingleStruct.nMediaFileStatus = 6;
        }
        if (TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverKey))
        {
          localMessageForDeviceSingleStruct.strCoverPath = paramSession.strFilePathSrc;
          try
          {
            localMessageForDeviceSingleStruct.strCoverMD5 = new BigInteger(1, paramSession.vFileMD5Src).toString(16);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("error get file md5 in : onServiceSessionComplete");
              localStringBuilder.append(localException.getMessage());
              QLog.d("DevSingleStructMsgProcessor", 2, localStringBuilder.toString());
            }
          }
        }
      }
      localMessageForDeviceSingleStruct.serial();
      this.a.getMessageFacade().a(localMessageForDeviceSingleStruct.frienduin, 9501, localMessageForDeviceSingleStruct.uniseq, localMessageForDeviceSingleStruct.msgData);
      if ((localMessageForDeviceSingleStruct.nCoverSessionID == paramSession.uSessionID) && (paramBoolean)) {
        d(localMessageForDeviceSingleStruct);
      }
      if ((localMessageForDeviceSingleStruct.nMediaSessionID == paramSession.uSessionID) && (paramBoolean)) {
        d(localMessageForDeviceSingleStruct);
      }
      this.b.remove(Long.valueOf(paramSession.uSessionID));
      return;
      label310:
      if (QLog.isColorLevel()) {
        QLog.d("DevSingleStructMsgProcessor", 2, "error:can not find session id in message record");
      }
    }
  }
  
  public boolean a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    return this.b.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID));
  }
  
  public long b(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if ((paramMessageForDeviceSingleStruct != null) && (!TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strMediaKey)))
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramMessageForDeviceSingleStruct = Looper.getMainLooper();
        if (Thread.currentThread() == paramMessageForDeviceSingleStruct.getThread())
        {
          FMToastUtil.a(2131891334);
          return 0L;
        }
        new Handler(paramMessageForDeviceSingleStruct).post(new DevSingleStructMsgProcessor.1(this));
        return 0L;
      }
      if (this.b.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID))) {
        return paramMessageForDeviceSingleStruct.nMediaSessionID;
      }
      Object localObject = (DeviceFileHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER);
      int i = paramMessageForDeviceSingleStruct.nDataType;
      if (i != 1)
      {
        if (i != 2) {
          i = 0;
        } else {
          i = 2201;
        }
      }
      else {
        i = 2154;
      }
      long l = ((DeviceFileHandler)localObject).a(this.a, paramMessageForDeviceSingleStruct.strMediaKey, paramMessageForDeviceSingleStruct.strFileKey2, paramMessageForDeviceSingleStruct.nMediaChannelType, i);
      localObject = this.a.getMessageFacade().a(paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      if ((localObject instanceof MessageForDeviceSingleStruct)) {
        ((MessageForDeviceSingleStruct)localObject).nMediaSessionID = l;
      }
      paramMessageForDeviceSingleStruct.nMediaSessionID = l;
      if (l != 0L) {
        a(l, paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      }
      return l;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DevSingleStructMsgProcessor", 2, "mr is null or strMediaKey is empty in downloadMediaFile!");
    }
    return 0L;
  }
  
  public void b(Session paramSession)
  {
    if (!paramSession.bSend)
    {
      MessageForDeviceSingleStruct localMessageForDeviceSingleStruct = a(Long.valueOf(paramSession.uSessionID));
      if (localMessageForDeviceSingleStruct == null) {
        return;
      }
      if (localMessageForDeviceSingleStruct.nMediaSessionID == paramSession.uSessionID) {
        localMessageForDeviceSingleStruct.nMediaFileStatus = 2;
      }
    }
  }
  
  public boolean c(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if (this.b.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID))) {
      this.b.remove(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID));
    }
    paramMessageForDeviceSingleStruct.nMediaFileStatus = 6;
    paramMessageForDeviceSingleStruct.nMediaProgress = 0.0F;
    paramMessageForDeviceSingleStruct.serial();
    this.a.getMessageFacade().a(paramMessageForDeviceSingleStruct.frienduin, 9501, paramMessageForDeviceSingleStruct.uniseq, paramMessageForDeviceSingleStruct.msgData);
    ((DeviceFileHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(0, paramMessageForDeviceSingleStruct.nMediaSessionID, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.DevSingleStructMsgProcessor
 * JD-Core Version:    0.7.0.1
 */