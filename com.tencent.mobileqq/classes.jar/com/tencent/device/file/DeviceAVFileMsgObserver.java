package com.tencent.device.file;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceCommonMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAVFileMsgObserver
  extends DeviceFileObserver
{
  DevAudioMsgProcessor jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor = new DevAudioMsgProcessor();
  DevVideoMsgProcessor jdField_a_of_type_ComTencentDeviceFileDevVideoMsgProcessor = new DevVideoMsgProcessor();
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new DeviceAVFileMsgObserver.1(this, Looper.getMainLooper());
  private final ArrayList<DeviceAVFileMsgObserver.CallbackPack> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet(10);
  private ConcurrentHashMap<String, DeviceAVFileMsgObserver.SessionPack> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  private ConcurrentHashMap<Long, Long> b = new ConcurrentHashMap(10);
  
  private void a(long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("");
    if (!localConcurrentHashMap.containsKey(localStringBuilder.toString()))
    {
      paramString = new DeviceAVFileMsgObserver.SessionPack(this, paramString, paramLong2, paramInt, "", 0L);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(paramLong1), paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "found resume");
    }
  }
  
  private void b(Session paramSession, boolean paramBoolean)
  {
    DeviceAVFileMsgObserver.SessionPack localSessionPack = (DeviceAVFileMsgObserver.SessionPack)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    if (localSessionPack == null) {
      return;
    }
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.e)) {
      this.jdField_a_of_type_ComTencentDeviceFileDevVideoMsgProcessor.a(paramSession, localSessionPack.jdField_a_of_type_JavaLangString, localSessionPack.jdField_a_of_type_Long, localSessionPack.jdField_a_of_type_Int, paramBoolean);
    } else if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.f)) {
      this.jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor.a(paramSession, localSessionPack.jdField_a_of_type_JavaLangString, localSessionPack.jdField_a_of_type_Long, localSessionPack.jdField_a_of_type_Int, paramBoolean);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    int i;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = ((SmartDeviceProxyMgr)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(localSessionPack.jdField_a_of_type_JavaLangString));
      if (localObject2 != null) {
        i = ((DeviceInfo)localObject2).productId;
      } else {
        i = 0;
      }
      long l;
      if (localObject2 != null) {
        l = ((DeviceInfo)localObject2).din;
      } else {
        l = 0L;
      }
      if (paramSession.actionInfo.strServiceName.compareTo(DeviceMsgHandle.f) == 0) {
        SmartDeviceReport.a((AppRuntime)localObject1, l, "Net_SendMsg_Audio", 0, paramBoolean ^ true, i);
      } else if (paramSession.actionInfo.strServiceName.compareTo(DeviceMsgHandle.e) == 0) {
        SmartDeviceReport.a((AppRuntime)localObject1, l, "Net_SendMsg_Video", 0, paramBoolean ^ true, i);
      }
      localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    Object localObject2 = new DeviceAVFileMsgObserver.DevMsgViewData(this);
    if (paramBoolean) {
      i = 1003;
    } else {
      i = 1005;
    }
    ((DeviceAVFileMsgObserver.DevMsgViewData)localObject2).jdField_a_of_type_Int = i;
    ((DeviceAVFileMsgObserver.DevMsgViewData)localObject2).jdField_a_of_type_Long = localSessionPack.jdField_a_of_type_Long;
    ((Message)localObject1).obj = localObject2;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject1, 0L);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(String.valueOf(paramSession.uSessionID));
  }
  
  private void c(Session paramSession)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = (MessageForDevShortVideo)MessageRecordFactory.a(-4503);
      ((MessageForDevShortVideo)localObject).videoFileName = paramSession.strFilePathSrc;
      ((MessageForDevShortVideo)localObject).msgtype = -4503;
      ((MessageForDevShortVideo)localObject).istroop = 9501;
      ((MessageForDevShortVideo)localObject).issend = 0;
      ((MessageForDevShortVideo)localObject).isread = false;
      ((MessageForDevShortVideo)localObject).selfuin = localQQAppInterface.getCurrentAccountUin();
      ((MessageForDevShortVideo)localObject).senderuin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      ((MessageForDevShortVideo)localObject).frienduin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      ((MessageForDevShortVideo)localObject).uuid = "";
      ((MessageForDevShortVideo)localObject).videoFileFormat = 2;
      ((MessageForDevShortVideo)localObject).videoFileSize = ((int)paramSession.uFileSizeSrc);
      ((MessageForDevShortVideo)localObject).videoFileStatus = 2000;
      ((MessageForDevShortVideo)localObject).videoFileProgress = 0;
      ((MessageForDevShortVideo)localObject).fileType = 19;
      ((MessageForDevShortVideo)localObject).lastModified = 0L;
      ((MessageForDevShortVideo)localObject).fileSessionId = paramSession.uSessionID;
      ((MessageForDevShortVideo)localObject).msg = ((MessageForDevShortVideo)localObject).getSummary();
      ((MessageForDevShortVideo)localObject).serial();
      a(paramSession.uSessionID, ((MessageForDevShortVideo)localObject).frienduin, ((MessageForDevShortVideo)localObject).uniseq, ((MessageForDevShortVideo)localObject).istroop);
      localQQAppInterface.getMessageFacade().a((MessageRecord)localObject, localQQAppInterface.getCurrentAccountUin());
      if (QLog.isColorLevel())
      {
        paramSession = new StringBuilder();
        paramSession.append("recievemsg msg.uniseq:");
        paramSession.append(((MessageForDevShortVideo)localObject).uniseq);
        paramSession.append(" ===> filesize:");
        paramSession.append(((MessageForDevShortVideo)localObject).videoFileSize);
        paramSession.append(" fileStatus:");
        paramSession.append(SVUtils.b(((MessageForDevShortVideo)localObject).videoFileStatus));
        QLog.d("DeviceAVFileMsgObserver", 2, paramSession.toString());
      }
    }
  }
  
  public String a(DataPoint paramDataPoint)
  {
    try
    {
      Object localObject2 = new JSONObject(paramDataPoint.mValue);
      long l1 = ((JSONObject)localObject2).optLong("msg_time", MessageCache.a());
      long l2 = ((JSONObject)localObject2).optLong("duration", 0L);
      String str2 = ((JSONObject)localObject2).optString("file_key", "");
      String str3 = ((JSONObject)localObject2).optString("file_url", "");
      String str1 = ((JSONObject)localObject2).optString("file_mini", "");
      localObject1 = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject1 = ((JSONObject)localObject2).optString("media_mini", "");
      }
      str1 = ((JSONObject)localObject2).optString("fkey2", "");
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (QQAppInterface)localObject2;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("receive audiomsg length:");
          ((StringBuilder)localObject3).append(l2);
          QLog.d("DeviceAVFileMsgObserver", 2, ((StringBuilder)localObject3).toString());
        }
        Object localObject3 = (MessageForDevPtt)MessageRecordFactory.a(-4501);
        ((MessageForDevPtt)localObject3).url = "";
        ((MessageForDevPtt)localObject3).channeltype = 1;
        ((MessageForDevPtt)localObject3).urlAtServer = str2;
        if (!TextUtils.isEmpty(str3))
        {
          ((MessageForDevPtt)localObject3).channeltype = 2;
          ((MessageForDevPtt)localObject3).urlAtServer = str3;
        }
        else if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          ((MessageForDevPtt)localObject3).channeltype = 3;
          ((MessageForDevPtt)localObject3).urlAtServer = ((String)localObject1);
          ((MessageForDevPtt)localObject3).strFileKey2 = str1;
        }
        ((MessageForDevPtt)localObject3).itemType = 2;
        ((MessageForDevPtt)localObject3).sttAbility = 0;
        ((MessageForDevPtt)localObject3).longPttVipFlag = 0;
        ((MessageForDevPtt)localObject3).c2cViaOffline = true;
        ((MessageForDevPtt)localObject3).msgtype = -4501;
        ((MessageForDevPtt)localObject3).istroop = 9501;
        ((MessageForDevPtt)localObject3).issend = 0;
        ((MessageForDevPtt)localObject3).isread = false;
        ((MessageForDevPtt)localObject3).selfuin = ((QQAppInterface)localObject2).getCurrentAccountUin();
        ((MessageForDevPtt)localObject3).senderuin = Long.toString(paramDataPoint.mDin);
        ((MessageForDevPtt)localObject3).frienduin = Long.toString(paramDataPoint.mDin);
        ((MessageForDevPtt)localObject3).time = l1;
        ((MessageForDevPtt)localObject3).msg = ((MessageForDevPtt)localObject3).getSummary();
        ((MessageForDevPtt)localObject3).voiceLength = ((int)l2);
        if (QLog.isColorLevel())
        {
          paramDataPoint = new StringBuilder();
          paramDataPoint.append("voiceLength onReceiveAudioMsg ");
          paramDataPoint.append(((MessageForDevPtt)localObject3).voiceLength);
          QLog.d("DeviceAVFileMsgObserver", 2, paramDataPoint.toString());
        }
        ((MessageForDevPtt)localObject3).serial();
        ((MessageForDevPtt)localObject3).saveExtInfoToExtStr("smartdevice_ptt_channeltype", String.valueOf(((MessageForDevPtt)localObject3).channeltype));
        ((QQAppInterface)localObject2).getMessageFacade().a((MessageRecord)localObject3, ((QQAppInterface)localObject2).getCurrentAccountUin());
        paramDataPoint = ((MessageForDevPtt)localObject3).msg;
        return paramDataPoint;
      }
    }
    catch (JSONException paramDataPoint)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getString from json error:");
        ((StringBuilder)localObject1).append(paramDataPoint.getMessage());
        QLog.d("DeviceAVFileMsgObserver", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return "";
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt("cookie", 0);
    float f = paramBundle.getFloat("percent", 0.0F);
    Object localObject = new Session();
    ((Session)localObject).uSessionID = i;
    paramBundle = (DeviceAVFileMsgObserver.SessionPack)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(i));
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor.a((Session)localObject, paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_a_of_type_Long, paramBundle.jdField_a_of_type_Int, f);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
      DeviceAVFileMsgObserver.DevMsgViewData localDevMsgViewData = new DeviceAVFileMsgObserver.DevMsgViewData(this);
      localDevMsgViewData.jdField_a_of_type_Int = 1002;
      localDevMsgViewData.jdField_a_of_type_Float = f;
      localDevMsgViewData.jdField_a_of_type_Long = paramBundle.jdField_a_of_type_Long;
      ((Message)localObject).obj = localDevMsgViewData;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject, 0L);
    }
  }
  
  void a(Message paramMessage)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMessage");
      ((StringBuilder)localObject1).append(((DeviceAVFileMsgObserver.DevMsgViewData)paramMessage.obj).jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append(" status ");
      ((StringBuilder)localObject1).append(paramMessage.what);
      ((StringBuilder)localObject1).append("retCode ");
      ((StringBuilder)localObject1).append(paramMessage.arg1);
      QLog.d("DeviceAVFileMsgObserver", 2, ((StringBuilder)localObject1).toString());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject2 = (DeviceAVFileMsgObserver.CallbackPack)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localObject1 = ((DeviceAVFileMsgObserver.CallbackPack)localObject2).a();
      localObject2 = ((DeviceAVFileMsgObserver.CallbackPack)localObject2).a();
      if ((localObject1 != null) && (localObject2 != null))
      {
        ((DeviceAVFileMsgObserver.DevMsgViewCallback)localObject2).a((View)localObject1, (DeviceAVFileMsgObserver.DevMsgViewData)paramMessage.obj);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
      }
      i += 1;
    }
  }
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewCallback paramDevMsgViewCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      DeviceAVFileMsgObserver.CallbackPack localCallbackPack = (DeviceAVFileMsgObserver.CallbackPack)localIterator.next();
      if (localCallbackPack.a() == paramView)
      {
        localCallbackPack.b = new WeakReference(paramDevMsgViewCallback);
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new DeviceAVFileMsgObserver.CallbackPack(this, paramView, paramDevMsgViewCallback));
  }
  
  public void a(MessageForDevPtt paramMessageForDevPtt)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramMessageForDevPtt.uniseq))) {
      return;
    }
    long l;
    if (this.b.containsKey(Long.valueOf(paramMessageForDevPtt.uniseq)))
    {
      l = ((Long)this.b.get(Long.valueOf(paramMessageForDevPtt.uniseq))).longValue();
      if (MessageCache.a() - l < 3600L) {
        return;
      }
    }
    if (TextUtils.isEmpty(paramMessageForDevPtt.urlAtServer)) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      DeviceFileHandler localDeviceFileHandler = (DeviceFileHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER);
      if (paramMessageForDevPtt.channeltype == 0) {
        try
        {
          paramMessageForDevPtt.channeltype = Integer.parseInt(paramMessageForDevPtt.getExtInfoFromExtStr("smartdevice_ptt_channeltype"));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      l = localDeviceFileHandler.a((QQAppInterface)localObject, paramMessageForDevPtt.urlAtServer, paramMessageForDevPtt.strFileKey2, paramMessageForDevPtt.channeltype, 2108);
      this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramMessageForDevPtt.uniseq));
      localObject = String.valueOf(l);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
      {
        paramMessageForDevPtt = new DeviceAVFileMsgObserver.SessionPack(this, paramMessageForDevPtt.frienduin, paramMessageForDevPtt.uniseq, paramMessageForDevPtt.istroop, "", 0L);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, paramMessageForDevPtt);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DeviceAVFileMsgObserver", 2, "found resume");
      }
    }
  }
  
  public void a(Session paramSession)
  {
    if (paramSession.isFileAssist) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceSessionNew : service@");
      localStringBuilder.append(paramSession.actionInfo.strServiceName);
      QLog.d("DeviceAVFileMsgObserver", 2, localStringBuilder.toString());
    }
    if ((!paramSession.bSend) && (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.e))) {
      c(paramSession);
    }
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onServiceSessionProgress : service@");
      ((StringBuilder)localObject).append(paramSession.actionInfo.strServiceName);
      QLog.d("DeviceAVFileMsgObserver", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (DeviceAVFileMsgObserver.SessionPack)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    if (localObject != null)
    {
      if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.e)) {
        this.jdField_a_of_type_ComTencentDeviceFileDevVideoMsgProcessor.a(paramSession, ((DeviceAVFileMsgObserver.SessionPack)localObject).jdField_a_of_type_JavaLangString, ((DeviceAVFileMsgObserver.SessionPack)localObject).jdField_a_of_type_Long, ((DeviceAVFileMsgObserver.SessionPack)localObject).jdField_a_of_type_Int, paramFloat);
      } else if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.f)) {
        this.jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor.a(paramSession, ((DeviceAVFileMsgObserver.SessionPack)localObject).jdField_a_of_type_JavaLangString, ((DeviceAVFileMsgObserver.SessionPack)localObject).jdField_a_of_type_Long, ((DeviceAVFileMsgObserver.SessionPack)localObject).jdField_a_of_type_Int, paramFloat);
      }
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
      DeviceAVFileMsgObserver.DevMsgViewData localDevMsgViewData = new DeviceAVFileMsgObserver.DevMsgViewData(this);
      if (paramSession.bSend) {
        localDevMsgViewData.jdField_a_of_type_Int = 1002;
      } else {
        localDevMsgViewData.jdField_a_of_type_Int = 2002;
      }
      localDevMsgViewData.jdField_a_of_type_Float = paramFloat;
      localDevMsgViewData.jdField_a_of_type_Long = ((DeviceAVFileMsgObserver.SessionPack)localObject).jdField_a_of_type_Long;
      localMessage.obj = localDevMsgViewData;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onServiceSessionComplete : service@");
      ((StringBuilder)localObject1).append(paramSession.actionInfo.strServiceName);
      QLog.d("DeviceAVFileMsgObserver", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramSession == null)
    {
      QLog.e("DeviceAVFileMsgObserver", 1, "onServiceSessionComplete, session == null !!!!!");
      return;
    }
    if (paramSession.bSend)
    {
      b(paramSession, paramBoolean);
      return;
    }
    Object localObject1 = (DeviceAVFileMsgObserver.SessionPack)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    if (localObject1 == null) {
      return;
    }
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.e))
    {
      DeviceCommonMsgProcessor.a(paramSession, paramBoolean);
      this.jdField_a_of_type_ComTencentDeviceFileDevVideoMsgProcessor.a(paramSession, ((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_JavaLangString, ((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_Long, ((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_Int, paramBoolean);
    }
    else if ((!paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.f)) && (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.g)))
    {
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (QQAppInterface)localObject2;
        localObject3 = ((QQAppInterface)localObject2).getMessageFacade().a(((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_JavaLangString, ((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_Int, ((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_Long);
        if (localObject3 == null) {
          return;
        }
        if ((localObject3 instanceof MessageForDevPtt))
        {
          MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)localObject3;
          localMessageForDevPtt.url = paramSession.strFilePathSrc;
          if (paramBoolean) {
            localMessageForDevPtt.fileSize = FileManagerUtil.a(paramSession.strFilePathSrc);
          } else {
            localMessageForDevPtt.fileSize = -1L;
          }
          localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
          localMessageForDevPtt.serial();
          ((QQAppInterface)localObject2).getMessageFacade().a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq, localMessageForDevPtt.msgData);
        }
      }
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    Object localObject3 = new DeviceAVFileMsgObserver.DevMsgViewData(this);
    int i;
    if (paramBoolean) {
      i = 2003;
    } else {
      i = 2005;
    }
    ((DeviceAVFileMsgObserver.DevMsgViewData)localObject3).jdField_a_of_type_Int = i;
    ((DeviceAVFileMsgObserver.DevMsgViewData)localObject3).jdField_a_of_type_Long = ((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_Long;
    ((Message)localObject2).obj = localObject3;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject2, 0L);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(String.valueOf(paramSession.uSessionID));
    this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_Long));
    if (paramBoolean)
    {
      this.b.remove(Long.valueOf(((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_Long));
      return;
    }
    this.b.put(Long.valueOf(((DeviceAVFileMsgObserver.SessionPack)localObject1).jdField_a_of_type_Long), Long.valueOf(MessageCache.a()));
  }
  
  public void a(MessageRecord paramMessageRecord, float paramFloat)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    DeviceAVFileMsgObserver.DevMsgViewData localDevMsgViewData = new DeviceAVFileMsgObserver.DevMsgViewData(this);
    localDevMsgViewData.jdField_a_of_type_Int = 1002;
    localDevMsgViewData.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localDevMsgViewData.jdField_a_of_type_Float = paramFloat;
    localMessage.obj = localDevMsgViewData;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
  }
  
  public void a(MessageRecord paramMessageRecord, Boolean paramBoolean)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    DeviceAVFileMsgObserver.DevMsgViewData localDevMsgViewData = new DeviceAVFileMsgObserver.DevMsgViewData(this);
    int i;
    if (paramBoolean.booleanValue()) {
      i = 1003;
    } else {
      i = 1005;
    }
    localDevMsgViewData.jdField_a_of_type_Int = i;
    localDevMsgViewData.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    float f;
    if (paramBoolean.booleanValue()) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    localDevMsgViewData.jdField_a_of_type_Float = f;
    localMessage.obj = localDevMsgViewData;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)localObject1;
      Object localObject2 = (SmartDeviceProxyMgr)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((paramString1.equalsIgnoreCase(DeviceMsgHandle.f)) && (localObject2 != null) && (((SmartDeviceProxyMgr)localObject2).b(paramLong1)))
      {
        localObject1 = new Session();
        ((Session)localObject1).uSessionID = ((SmartDeviceProxyMgr)localObject2).a(paramLong1, paramString2, paramInt2);
        ((Session)localObject1).strFilePathSrc = paramString2;
        ((Session)localObject1).uFileSizeSrc = FileManagerUtil.a(paramString2);
      }
      else
      {
        localObject2 = ((DeviceFileHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(paramString2, paramString1, null, paramLong1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          return;
        }
      }
      localObject2 = String.valueOf(((Session)localObject1).uSessionID);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject2))
      {
        paramString2 = new DeviceAVFileMsgObserver.SessionPack(this, String.valueOf(paramLong1), paramLong2, paramInt1, paramString2, ((Session)localObject1).uFileSizeSrc);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, paramString2);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("DeviceAVFileMsgObserver", 2, "found resume");
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        if (paramString1.equalsIgnoreCase(DeviceMsgHandle.e))
        {
          this.jdField_a_of_type_ComTencentDeviceFileDevVideoMsgProcessor.a((Session)localObject1, String.valueOf(paramLong1), paramLong2, paramInt1, false);
          return;
        }
        if (paramString1.equalsIgnoreCase(DeviceMsgHandle.f)) {
          this.jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor.a((Session)localObject1, String.valueOf(paramLong1), paramLong2, paramInt1, false);
        }
      }
    }
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((DeviceAVFileMsgObserver.SessionPack)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Long == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int j = paramBundle.getInt("cookie", 0);
    int i = paramBundle.getInt("err_code", 1);
    paramBundle = new Session();
    paramBundle.uSessionID = j;
    DeviceAVFileMsgObserver.SessionPack localSessionPack = (DeviceAVFileMsgObserver.SessionPack)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramBundle.uSessionID));
    if (localSessionPack == null) {
      return;
    }
    paramBundle.strFilePathSrc = localSessionPack.jdField_b_of_type_JavaLangString;
    paramBundle.uFileSizeSrc = localSessionPack.jdField_b_of_type_Long;
    Object localObject1 = this.jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor;
    Object localObject2 = localSessionPack.jdField_a_of_type_JavaLangString;
    long l = localSessionPack.jdField_a_of_type_Long;
    j = localSessionPack.jdField_a_of_type_Int;
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((DevAudioMsgProcessor)localObject1).a(paramBundle, (String)localObject2, l, j, bool);
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = ((SmartDeviceProxyMgr)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(localSessionPack.jdField_a_of_type_JavaLangString));
      if (localObject2 != null) {
        j = ((DeviceInfo)localObject2).productId;
      }
      if (localObject2 != null) {
        l = ((DeviceInfo)localObject2).din;
      }
      localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    localObject2 = new DeviceAVFileMsgObserver.DevMsgViewData(this);
    if (i == 0) {
      i = 1003;
    } else {
      i = 1005;
    }
    ((DeviceAVFileMsgObserver.DevMsgViewData)localObject2).jdField_a_of_type_Int = i;
    ((DeviceAVFileMsgObserver.DevMsgViewData)localObject2).jdField_a_of_type_Long = localSessionPack.jdField_a_of_type_Long;
    ((Message)localObject1).obj = localObject2;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject1, 0L);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(String.valueOf(paramBundle.uSessionID));
  }
  
  public void b(Session paramSession)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onServiceSessionStart : service@");
      ((StringBuilder)localObject).append(paramSession.actionInfo.strServiceName);
      QLog.d("DeviceAVFileMsgObserver", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (DeviceAVFileMsgObserver.SessionPack)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    if (localObject == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    DeviceAVFileMsgObserver.DevMsgViewData localDevMsgViewData = new DeviceAVFileMsgObserver.DevMsgViewData(this);
    if (paramSession.bSend) {
      localDevMsgViewData.jdField_a_of_type_Int = 1001;
    } else {
      localDevMsgViewData.jdField_a_of_type_Int = 2001;
    }
    localDevMsgViewData.jdField_a_of_type_Long = ((DeviceAVFileMsgObserver.SessionPack)localObject).jdField_a_of_type_Long;
    localMessage.obj = localDevMsgViewData;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
  }
  
  public void b(MessageRecord paramMessageRecord, float paramFloat)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    DeviceAVFileMsgObserver.DevMsgViewData localDevMsgViewData = new DeviceAVFileMsgObserver.DevMsgViewData(this);
    int i;
    if (paramMessageRecord.isSendFromLocal()) {
      i = 1002;
    } else {
      i = 2002;
    }
    localDevMsgViewData.jdField_a_of_type_Int = i;
    localDevMsgViewData.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localDevMsgViewData.jdField_a_of_type_Float = paramFloat;
    localMessage.obj = localDevMsgViewData;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
  }
  
  public void b(MessageRecord paramMessageRecord, Boolean paramBoolean)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
    DeviceAVFileMsgObserver.DevMsgViewData localDevMsgViewData = new DeviceAVFileMsgObserver.DevMsgViewData(this);
    int i;
    if (paramMessageRecord.isSendFromLocal())
    {
      if (paramBoolean.booleanValue()) {
        i = 1003;
      } else {
        i = 1005;
      }
    }
    else if (paramBoolean.booleanValue()) {
      i = 2003;
    } else {
      i = 2005;
    }
    localDevMsgViewData.jdField_a_of_type_Int = i;
    localDevMsgViewData.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    float f;
    if (paramBoolean.booleanValue()) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    localDevMsgViewData.jdField_a_of_type_Float = f;
    localMessage.obj = localDevMsgViewData;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(localMessage, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.file.DeviceAVFileMsgObserver
 * JD-Core Version:    0.7.0.1
 */