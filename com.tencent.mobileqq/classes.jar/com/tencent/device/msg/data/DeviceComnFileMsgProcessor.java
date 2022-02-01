package com.tencent.device.msg.data;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.file.DeviceFileObserver.CallbackPack;
import com.tencent.device.file.DeviceFileObserver.SessionPack;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class DeviceComnFileMsgProcessor
  extends DeviceFileObserver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<DeviceFileObserver.CallbackPack> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<Long, DeviceFileObserver.SessionPack> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  
  public DeviceComnFileMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (QLog.isDevelopLevel())
    {
      paramList = new StringBuilder();
      paramList.append("cost:");
      paramList.append(System.currentTimeMillis() - l);
      QLog.d("DeviceComnFileMsgProcessor", 4, paramList.toString());
    }
  }
  
  private void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (DeviceFileObserver.CallbackPack)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((DeviceFileObserver.CallbackPack)localObject).a();
      localObject = ((DeviceFileObserver.CallbackPack)localObject).a();
      if ((localView != null) && (localObject != null))
      {
        ((MessageForDeviceFile.DeviceFileItemCallback)localObject).a(localView, paramMessageForDeviceFile);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
      }
      i += 1;
    }
  }
  
  public MessageForDeviceFile a(Long paramLong)
  {
    paramLong = (DeviceFileObserver.SessionPack)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    if (paramLong == null) {
      return null;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramLong = ((QQAppInterface)localAppRuntime).getMessageFacade().a(paramLong.jdField_a_of_type_JavaLangString, paramLong.jdField_a_of_type_Int, paramLong.jdField_a_of_type_Long);
      if (paramLong == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceComnFileMsgProcessor", 2, "device file msg null");
        }
        return null;
      }
      if ((paramLong instanceof MessageForDeviceFile)) {
        return (MessageForDeviceFile)paramLong;
      }
    }
    return null;
  }
  
  public MessageForDeviceFile a(String paramString, MessageForDeviceFile paramMessageForDeviceFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
    ArrayList localArrayList = new ArrayList();
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)MessageRecordFactory.a(paramMessageForDeviceFile);
    if ("device_groupchat".equals(paramMessageForDeviceFile.extStr))
    {
      localMessageForDeviceFile.strServiceName = paramString;
      localMessageForDeviceFile.filePath = localMessageForDeviceFile.filePath;
      localMessageForDeviceFile.srcFileName = FileManagerUtil.a(localMessageForDeviceFile.filePath);
      localMessageForDeviceFile.fileSize = FileManagerUtil.a(localMessageForDeviceFile.filePath);
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.progress = 0.0F;
      ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForDeviceFile);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      paramString = ImageUtil.a(BaseApplication.getContext(), Uri.parse(localMessageForDeviceFile.filePath));
      ImageUtil.a(BaseApplication.getContext(), localMessageForDeviceFile.filePath, paramString, 160, 160);
      DeviceMsgChatPie.a(((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(localMessageForDeviceFile.frienduin), localMessageForDeviceFile.filePath, paramString), localMessageForDeviceFile);
    }
    else
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForDeviceFile.uSessionID));
      String str1 = paramMessageForDeviceFile.filePath;
      String str2 = paramMessageForDeviceFile.frienduin;
      localMessageForDeviceFile.strServiceName = paramString;
      localMessageForDeviceFile.filePath = str1;
      localMessageForDeviceFile.srcFileName = paramMessageForDeviceFile.srcFileName;
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.progress = 0.0F;
      localMessageForDeviceFile.nFileMsgType = paramMessageForDeviceFile.nFileMsgType;
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691562);
      if (paramString.compareTo(DeviceMsgHandle.d) == 0)
      {
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691563);
      }
      else if (paramString.compareTo(DeviceMsgHandle.c) == 0)
      {
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691561);
        localMessageForDeviceFile.copies = paramMessageForDeviceFile.copies;
        localMessageForDeviceFile.duplexMode = paramMessageForDeviceFile.duplexMode;
      }
      ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForDeviceFile);
      paramMessageForDeviceFile = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((paramMessageForDeviceFile != null) && (paramMessageForDeviceFile.a(str2)))
      {
        if (paramString.compareTo(DeviceMsgHandle.d) == 0)
        {
          localMessageForDeviceFile.uSessionID = paramMessageForDeviceFile.a(Long.parseLong(str2), str1, null);
        }
        else if (paramString.compareTo(DeviceMsgHandle.f) == 0)
        {
          localMessageForDeviceFile.uSessionID = paramMessageForDeviceFile.a(Long.parseLong(str2), str1, 0);
        }
        else
        {
          paramString = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(str1, paramString, null, Long.parseLong(str2));
          if (paramString == null) {
            return localMessageForDeviceFile;
          }
          localMessageForDeviceFile.uSessionID = paramString.uSessionID;
        }
      }
      else
      {
        paramString = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(str1, paramString, null, Long.parseLong(str2));
        if (paramString == null) {
          return localMessageForDeviceFile;
        }
        localMessageForDeviceFile.uSessionID = paramString.uSessionID;
      }
      localMessageForDeviceFile.fileSize = FileManagerUtil.a(str1);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
    }
    localArrayList.add(localMessageForDeviceFile);
    a(localArrayList);
    return localMessageForDeviceFile;
  }
  
  public void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new DeviceFileObserver.SessionPack(this, paramString, paramInt, paramLong2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceComnFileMsgProcessor", 2, "found resume");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt("cookie", 0);
    float f = paramBundle.getFloat("percent", 0.0F);
    paramBundle = a(Long.valueOf(i));
    if (paramBundle == null) {
      return;
    }
    paramBundle.nFileStatus = 3;
    paramBundle.progress = f;
    b(paramBundle);
  }
  
  public void a(View paramView, MessageForDeviceFile.DeviceFileItemCallback paramDeviceFileItemCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      DeviceFileObserver.CallbackPack localCallbackPack = (DeviceFileObserver.CallbackPack)localIterator.next();
      if (localCallbackPack.a() == paramView)
      {
        localCallbackPack.b = new WeakReference(paramDeviceFileItemCallback);
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new DeviceFileObserver.CallbackPack(this, paramView, paramDeviceFileItemCallback));
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    paramSession = a(Long.valueOf(paramSession.uSessionID));
    if (paramSession == null) {
      return;
    }
    paramSession.nFileStatus = 3;
    paramSession.progress = paramFloat;
    b(paramSession);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (paramSession == null) {
      return;
    }
    if (!paramSession.bSend) {
      DeviceCommonMsgProcessor.a(paramSession, paramBoolean);
    }
    Object localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    MessageForDeviceFile localMessageForDeviceFile = a(Long.valueOf(paramSession.uSessionID));
    if (localMessageForDeviceFile == null) {
      return;
    }
    Object localObject2 = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(localMessageForDeviceFile.frienduin));
    int i;
    long l;
    if (localObject2 != null)
    {
      i = ((DeviceInfo)localObject2).productId;
      l = ((DeviceInfo)localObject2).din;
    }
    else
    {
      l = 0L;
      i = 0;
    }
    if (paramSession.actionInfo.strServiceName.compareTo(DeviceMsgHandle.d) == 0) {
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Net_SendMsg_Pic", 0, paramBoolean ^ true, i);
    }
    if ((paramSession.actionInfo.strServiceName.compareTo(DeviceMsgHandle.c) == 0) && (paramSession.bSend) && (paramBoolean))
    {
      String str = new String(paramSession.vFileMD5Src);
      localObject2 = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(paramSession);
      Bundle localBundle = new Bundle();
      localBundle.putInt("copies", localMessageForDeviceFile.copies);
      localBundle.putInt("duplexMode", localMessageForDeviceFile.duplexMode);
      localBundle.putInt("mediaSize", localMessageForDeviceFile.mediaSize);
      localBundle.putInt("mediaType", localMessageForDeviceFile.mediaType);
      localBundle.putInt("scaling", localMessageForDeviceFile.scaling);
      localBundle.putInt("orientation", localMessageForDeviceFile.orientation);
      localBundle.putInt("color", localMessageForDeviceFile.color);
      localBundle.putInt("quality", localMessageForDeviceFile.quality);
      ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(localMessageForDeviceFile.frienduin), str, String.valueOf(((Session)localObject2).uSessionID), paramSession.strFileNameSrc, paramSession.emFileType, localBundle);
      localObject1 = (MessageForDeviceFile)MessageRecordFactory.a(-4500);
      ((MessageForDeviceFile)localObject1).strServiceName = DeviceMsgHandle.c;
      ((MessageForDeviceFile)localObject1).msgtype = -4500;
      ((MessageForDeviceFile)localObject1).istroop = 9501;
      ((MessageForDeviceFile)localObject1).filePath = paramSession.strFilePathSrc;
      ((MessageForDeviceFile)localObject1).srcFileName = paramSession.strFileNameSrc;
      ((MessageForDeviceFile)localObject1).fileSize = paramSession.uFileSizeSrc;
      ((MessageForDeviceFile)localObject1).issend = 0;
      ((MessageForDeviceFile)localObject1).isread = true;
      ((MessageForDeviceFile)localObject1).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      ((MessageForDeviceFile)localObject1).senderuin = localMessageForDeviceFile.frienduin;
      ((MessageForDeviceFile)localObject1).frienduin = localMessageForDeviceFile.frienduin;
      ((MessageForDeviceFile)localObject1).msgStatus = 2;
      ((MessageForDeviceFile)localObject1).nFileStatus = 1;
      ((MessageForDeviceFile)localObject1).time = MessageCache.a();
      ((MessageForDeviceFile)localObject1).progress = 0.0F;
      ((MessageForDeviceFile)localObject1).uSessionID = ((Session)localObject2).uSessionID;
      ((MessageForDeviceFile)localObject1).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691561);
      ((MessageForDeviceFile)localObject1).nFileMsgType = 1;
      ((MessageForDeviceFile)localObject1).copies = localMessageForDeviceFile.copies;
      ((MessageForDeviceFile)localObject1).duplexMode = localMessageForDeviceFile.duplexMode;
      ((MessageForDeviceFile)localObject1).mediaSize = localMessageForDeviceFile.mediaSize;
      ((MessageForDeviceFile)localObject1).scaling = localMessageForDeviceFile.scaling;
      ((MessageForDeviceFile)localObject1).color = localMessageForDeviceFile.color;
      ((MessageForDeviceFile)localObject1).quality = localMessageForDeviceFile.quality;
      ((MessageForDeviceFile)localObject1).uint32_src_uin_type = 1;
      ((MessageForDeviceFile)localObject1).serial();
      a(((MessageForDeviceFile)localObject1).uSessionID, ((MessageForDeviceFile)localObject1).frienduin, ((MessageForDeviceFile)localObject1).istroop, ((MessageForDeviceFile)localObject1).uniseq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.handleReceivedMessage(1, false, true);
      ThreadManager.getUIHandler().postDelayed(new DeviceComnFileMsgProcessor.1(this, (MessageForDeviceFile)localObject1), 900000L);
    }
    a(paramSession.actionInfo.strServiceName, paramSession.uSessionID, paramBoolean);
  }
  
  public void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageForDeviceFile);
    if (((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(localArrayList)) {
      return;
    }
    FMToastUtil.a(2131693760);
  }
  
  public void a(MessageRecord paramMessageRecord, float paramFloat)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if ((paramMessageRecord instanceof MessageForDeviceFile))
    {
      paramMessageRecord = (MessageForDeviceFile)paramMessageRecord;
      paramMessageRecord.nFileStatus = 3;
      paramMessageRecord.progress = paramFloat;
      b(paramMessageRecord);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, Boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if ((paramMessageRecord instanceof MessageForDeviceFile))
    {
      paramMessageRecord = (MessageForDeviceFile)paramMessageRecord;
      paramMessageRecord.progress = 1.0F;
      if (paramBoolean.booleanValue())
      {
        paramMessageRecord.nFileStatus = 5;
        paramMessageRecord.msgStatus = 0;
      }
      else
      {
        paramMessageRecord.nFileStatus = 6;
        paramMessageRecord.msgStatus = 1;
      }
      paramMessageRecord.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, 9501, paramMessageRecord.uniseq, paramMessageRecord.msgData);
      b(paramMessageRecord);
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (paramMessageRecord != null) {
        paramMessageRecord.sendEmptyMessage(1009);
      }
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    MessageForDeviceFile localMessageForDeviceFile = a(Long.valueOf(paramLong));
    if (localMessageForDeviceFile == null) {
      return;
    }
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(localMessageForDeviceFile.frienduin));
    int i;
    if (localDeviceInfo != null) {
      i = localDeviceInfo.productId;
    } else {
      i = 0;
    }
    localMessageForDeviceFile.progress = 1.0F;
    if (paramBoolean)
    {
      localMessageForDeviceFile.nFileStatus = 5;
      localMessageForDeviceFile.msgStatus = 0;
    }
    else
    {
      localMessageForDeviceFile.nFileStatus = 6;
      localMessageForDeviceFile.msgStatus = 1;
      localMessageForDeviceFile.progress = 0.0F;
    }
    localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691282);
    if (paramString.compareTo(DeviceMsgHandle.d) == 0)
    {
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691286);
    }
    else if (paramString.compareTo(DeviceMsgHandle.c) == 0)
    {
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691561);
      if (!paramBoolean)
      {
        paramString = (DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER);
        if (localMessageForDeviceFile.isSend())
        {
          if (paramString.a(paramLong) == -5103058) {
            localMessageForDeviceFile.nFileStatus = 7;
          }
          if (FileManagerUtil.a(localMessageForDeviceFile.filePath) == 0) {
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 1, 2, i);
          } else {
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 2, 2, i);
          }
        }
        else
        {
          int j = paramString.a(paramLong);
          if (j != 0)
          {
            if (j != 1)
            {
              if (j != 2)
              {
                if (j != 3)
                {
                  if (j != 8001) {
                    switch (j)
                    {
                    default: 
                      localMessageForDeviceFile.nFileStatus = 6;
                      break;
                    case 9011: 
                      localMessageForDeviceFile.nFileStatus = 25;
                      break;
                    case 9009: 
                      localMessageForDeviceFile.nFileStatus = 22;
                    case 9010: 
                      localMessageForDeviceFile.nFileStatus = 24;
                      break;
                    case 9008: 
                      localMessageForDeviceFile.nFileStatus = 21;
                      break;
                    case 9007: 
                      localMessageForDeviceFile.nFileStatus = 20;
                      break;
                    case 9006: 
                      localMessageForDeviceFile.nFileStatus = 17;
                      break;
                    case 9005: 
                      localMessageForDeviceFile.nFileStatus = 16;
                      break;
                    case 9004: 
                      localMessageForDeviceFile.nFileStatus = 15;
                      break;
                    case 9003: 
                      localMessageForDeviceFile.nFileStatus = 14;
                      break;
                    case 9002: 
                      localMessageForDeviceFile.nFileStatus = 13;
                      break;
                    case 9001: 
                      localMessageForDeviceFile.nFileStatus = 12;
                      break;
                    }
                  } else {
                    localMessageForDeviceFile.nFileStatus = 18;
                  }
                }
                else {
                  localMessageForDeviceFile.nFileStatus = 19;
                }
              }
              else {
                localMessageForDeviceFile.nFileStatus = 9;
              }
            }
            else {
              localMessageForDeviceFile.nFileStatus = 8;
            }
          }
          else {
            localMessageForDeviceFile.nFileStatus = 10;
          }
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendPrint", 2, j, i);
        }
      }
      else if (localMessageForDeviceFile.isSend())
      {
        if (FileManagerUtil.a(localMessageForDeviceFile.filePath) == 0) {
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 1, 1, i);
        } else {
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 2, 1, i);
        }
      }
      else
      {
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendPrint", 1, 0, i);
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onServiceSessionComplete:");
      paramString.append(paramLong);
      QLog.d("DeviceComnFileMsgProcessor", 4, paramString.toString());
    }
    localMessageForDeviceFile.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForDeviceFile.frienduin, 9501, localMessageForDeviceFile.uniseq, localMessageForDeviceFile.msgData);
    b(localMessageForDeviceFile);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (paramString != null) {
      paramString.sendEmptyMessage(1009);
    }
  }
  
  public void a(String paramString, AbsStructMsg paramAbsStructMsg)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = MessageRecordFactory.a((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin(), paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 9501, 100L, paramAbsStructMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramString), paramAbsStructMsg);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    Object localObject;
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      localObject = paramBundle;
      if (!paramList.hasNext()) {
        break label807;
      }
      String str1 = (String)paramList.next();
      localMessageForDeviceFile = (MessageForDeviceFile)MessageRecordFactory.a(-4500);
      localMessageForDeviceFile.strServiceName = paramString1;
      localMessageForDeviceFile.msgtype = -4500;
      localMessageForDeviceFile.istroop = 9501;
      localMessageForDeviceFile.filePath = str1;
      localMessageForDeviceFile.srcFileName = FileManagerUtil.a(str1);
      localMessageForDeviceFile.fileSize = FileManagerUtil.a(str1);
      int i1 = 1;
      localMessageForDeviceFile.issend = 1;
      localMessageForDeviceFile.isread = true;
      localMessageForDeviceFile.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.frienduin = paramString2;
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.time = MessageCache.a();
      localMessageForDeviceFile.progress = 0.0F;
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691562);
      localMessageForDeviceFile.nFileMsgType = 1;
      if (paramString1.compareTo(DeviceMsgHandle.d) == 0)
      {
        localMessageForDeviceFile.nFileMsgType = 2;
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691563);
      }
      int i;
      if (paramString1.compareTo(DeviceMsgHandle.c) == 0)
      {
        int j;
        int k;
        int m;
        int n;
        int i2;
        int i3;
        if (localObject != null)
        {
          j = ((Bundle)localObject).getInt("copies", 1);
          k = ((Bundle)localObject).getInt("duplexMode", 1);
          m = ((Bundle)localObject).getInt("mediaSize", 1);
          n = ((Bundle)localObject).getInt("mediaType", 1);
          i2 = ((Bundle)localObject).getInt("scaling", 1);
          i3 = ((Bundle)localObject).getInt("orientation", 1);
          i = ((Bundle)localObject).getInt("color", 1);
          i1 = ((Bundle)localObject).getInt("quality", 1);
        }
        else
        {
          i = 1;
          j = 1;
          k = 1;
          m = 1;
          n = 1;
          i2 = 1;
          i3 = 1;
        }
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691561);
        localMessageForDeviceFile.copies = j;
        localMessageForDeviceFile.duplexMode = k;
        localMessageForDeviceFile.mediaSize = m;
        localMessageForDeviceFile.mediaType = n;
        localMessageForDeviceFile.scaling = i2;
        localMessageForDeviceFile.orientation = i3;
        localMessageForDeviceFile.color = i;
        localMessageForDeviceFile.quality = i1;
      }
      ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForDeviceFile);
      localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((localObject != null) && (((SmartDeviceProxyMgr)localObject).a(paramString2)))
      {
        if (paramString1.compareTo(DeviceMsgHandle.d) == 0)
        {
          String str2 = ImageUtil.a(BaseApplication.getContext(), Uri.parse(str1));
          ImageUtil.a(BaseApplication.getContext(), str1, str2, 160, 160);
          localMessageForDeviceFile.uSessionID = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(paramString2), str1, str2);
          break label743;
        }
        if (paramString1.compareTo(DeviceMsgHandle.f) == 0)
        {
          localMessageForDeviceFile.uSessionID = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(paramString2), str1, 0);
          break label743;
        }
        if (paramString1.compareTo(DeviceMsgHandle.c) == 0)
        {
          localObject = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(paramString2));
          if (localObject != null) {
            i = ((DeviceInfo)localObject).productId;
          } else {
            i = 0;
          }
          if (FileManagerUtil.a(str1) == 0) {
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 1, 0, i);
          } else {
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 2, 0, i);
          }
        }
        localObject = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(str1, paramString1, null, Long.parseLong(paramString2));
        if (localObject == null) {
          break;
        }
        localMessageForDeviceFile.uSessionID = ((Session)localObject).uSessionID;
        break label743;
      }
      localObject = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(str1, paramString1, null, Long.parseLong(paramString2));
    } while (localObject == null);
    for (;;)
    {
      localMessageForDeviceFile.uSessionID = ((Session)localObject).uSessionID;
      label743:
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
      localArrayList.add(localMessageForDeviceFile);
    }
    label807:
    a(localArrayList);
  }
  
  public void a(String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)MessageRecordFactory.a(-4500);
      localMessageForDeviceFile.strServiceName = DeviceMsgHandle.d;
      localMessageForDeviceFile.msgtype = -4500;
      localMessageForDeviceFile.istroop = 9501;
      localMessageForDeviceFile.filePath = ((String)localObject);
      localMessageForDeviceFile.srcFileName = FileManagerUtil.a((String)localObject);
      localMessageForDeviceFile.fileSize = FileManagerUtil.a((String)localObject);
      localMessageForDeviceFile.issend = 1;
      localMessageForDeviceFile.isread = true;
      localMessageForDeviceFile.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.frienduin = paramString;
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.time = MessageCache.a();
      localMessageForDeviceFile.progress = 0.0F;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694384));
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691563));
      localMessageForDeviceFile.msg = ((StringBuilder)localObject).toString();
      localMessageForDeviceFile.nFileMsgType = 2;
      localMessageForDeviceFile.extStr = "device_groupchat";
      ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForDeviceFile);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForDeviceFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject = ImageUtil.a(BaseApplication.getContext(), Uri.parse(localMessageForDeviceFile.filePath));
      ImageUtil.a(BaseApplication.getContext(), localMessageForDeviceFile.filePath, (String)localObject, 160, 160);
      int i = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(localMessageForDeviceFile.frienduin), localMessageForDeviceFile.filePath, (String)localObject);
      localMessageForDeviceFile.uSessionID = i;
      a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
      DeviceMsgChatPie.a(i, localMessageForDeviceFile);
    }
  }
  
  public boolean a(String paramString1, String paramString2, List<String> paramList)
  {
    a(paramString1, paramString2, paramList, null);
    return true;
  }
  
  public boolean a(String paramString, List<FileInfo> paramList)
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    long l;
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l = 0L;
    }
    int i;
    if ((localSmartDeviceProxyMgr != null) && (localSmartDeviceProxyMgr.a(l, 9))) {
      i = 1;
    } else {
      i = 0;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (FileInfo)paramList.next();
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)MessageRecordFactory.a(-4500);
      int j = ((FileInfo)localObject).a();
      if (j == 0) {
        localMessageForDeviceFile.strServiceName = DeviceMsgHandle.d;
      } else if (i != 0)
      {
        if (j == 2) {
          localMessageForDeviceFile.strServiceName = "8001-NASDevVideoFile";
        } else if (j == 1) {
          localMessageForDeviceFile.strServiceName = "8000-NASDevMusicFile";
        } else if (j == 3) {
          localMessageForDeviceFile.strServiceName = "8002-NASDevDocumentFile";
        } else {
          localMessageForDeviceFile.strServiceName = "8003-NASDevCommonFile";
        }
      }
      else {
        localMessageForDeviceFile.strServiceName = DeviceMsgHandle.b;
      }
      localMessageForDeviceFile.msgtype = -4500;
      localMessageForDeviceFile.istroop = 9501;
      localMessageForDeviceFile.filePath = ((FileInfo)localObject).c();
      localMessageForDeviceFile.srcFileName = FileManagerUtil.a(((FileInfo)localObject).c());
      localMessageForDeviceFile.fileSize = FileManagerUtil.a(((FileInfo)localObject).c());
      localMessageForDeviceFile.issend = 1;
      localMessageForDeviceFile.isread = true;
      localMessageForDeviceFile.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.frienduin = paramString;
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.time = MessageCache.a();
      localMessageForDeviceFile.progress = 0.0F;
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691562);
      localMessageForDeviceFile.nFileMsgType = 1;
      if (localMessageForDeviceFile.strServiceName.compareTo(DeviceMsgHandle.d) == 0)
      {
        localMessageForDeviceFile.nFileMsgType = 2;
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691563);
      }
      ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForDeviceFile);
      if ((localSmartDeviceProxyMgr != null) && (localSmartDeviceProxyMgr.a(paramString)))
      {
        if (localMessageForDeviceFile.strServiceName.compareTo(DeviceMsgHandle.d) == 0)
        {
          localMessageForDeviceFile.uSessionID = localSmartDeviceProxyMgr.a(Long.parseLong(paramString), ((FileInfo)localObject).c(), null);
        }
        else if (localMessageForDeviceFile.strServiceName.compareTo(DeviceMsgHandle.f) == 0)
        {
          localMessageForDeviceFile.uSessionID = localSmartDeviceProxyMgr.a(Long.parseLong(paramString), ((FileInfo)localObject).c(), 0);
        }
        else
        {
          localObject = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(((FileInfo)localObject).c(), localMessageForDeviceFile.strServiceName, null, Long.parseLong(paramString));
          if (localObject == null) {
            continue;
          }
          localMessageForDeviceFile.uSessionID = ((Session)localObject).uSessionID;
        }
      }
      else
      {
        localObject = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(((FileInfo)localObject).c(), localMessageForDeviceFile.strServiceName, null, Long.parseLong(paramString));
        if (localObject == null) {
          continue;
        }
        localMessageForDeviceFile.uSessionID = ((Session)localObject).uSessionID;
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
      localArrayList.add(localMessageForDeviceFile);
    }
    a(localArrayList);
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    boolean bool = false;
    int i = paramBundle.getInt("cookie", 0);
    int k = paramBundle.getInt("err_code", 1);
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    long l2 = i;
    paramBundle = a(Long.valueOf(l2));
    if (paramBundle == null) {
      return;
    }
    localObject = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(paramBundle.frienduin));
    long l1;
    if (localObject != null)
    {
      i = ((DeviceInfo)localObject).productId;
      l1 = ((DeviceInfo)localObject).din;
    }
    else
    {
      l1 = 0L;
      i = 0;
    }
    if (paramBundle.strServiceName.compareTo(DeviceMsgHandle.d) == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int j;
      if (k == 0) {
        j = 0;
      } else {
        j = 1;
      }
      SmartDeviceReport.a((AppRuntime)localObject, l1, "Net_SendMsg_Pic", 0, j, i);
    }
    paramBundle = paramBundle.strServiceName;
    if (k == 0) {
      bool = true;
    }
    a(paramBundle, l2, bool);
  }
  
  public void b(Session paramSession)
  {
    paramSession = a(Long.valueOf(paramSession.uSessionID));
    if (paramSession == null) {
      return;
    }
    paramSession.nFileStatus = 2;
    b(paramSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceComnFileMsgProcessor
 * JD-Core Version:    0.7.0.1
 */