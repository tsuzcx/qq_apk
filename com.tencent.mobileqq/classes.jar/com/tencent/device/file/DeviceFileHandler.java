package com.tencent.device.file;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.FTNNotify;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x211;
import com.tencent.litetransfersdk.MsgCSBody0x211_0x7;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import qcj;

public class DeviceFileHandler
  extends RouterHandler
  implements INetEngine.INetEngineListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new qcj(this, Looper.getMainLooper());
  private DeviceFileHandler.DeviceNotifyReceiver jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  protected HashMap a;
  protected HashSet a;
  protected HashMap b;
  protected HashSet b;
  protected HashMap c;
  private HashMap f;
  
  public DeviceFileHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = "Device";
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.c = new HashMap();
    this.f = new HashMap();
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("SmartDevice_OnMiniFileTransferComplete");
    paramQQAppInterface.addAction("SmartDevice_OnMiniFileTransferProgress");
    paramQQAppInterface.addAction("SmartDevice_OnDataPointFileMsgProgress");
    paramQQAppInterface.addAction("SmartDevice_OnDataPointFileMsgSendRet");
    paramQQAppInterface.addAction("CloudPrintJobNotifyEvent");
    this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver = new DeviceFileHandler.DeviceNotifyReceiver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver, paramQQAppInterface);
  }
  
  private long a(byte[] paramArrayOfByte, MsgCSBody paramMsgCSBody, Long paramLong)
  {
    try
    {
      paramArrayOfByte = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
        }
        return 0L;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      paramMsgCSBody.uMsgType = 529;
      paramMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
      paramMsgCSBody.msgBody0x211.uMsgSubType = 7;
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 1;
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramArrayOfByte.uint32_appid.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramArrayOfByte.uint32_instid.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramArrayOfByte.uint64_src_uin.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_uin_type = paramArrayOfByte.uint32_uin_type.get();
      paramLong = new ArrayList();
      FTNNotify localFTNNotify = new FTNNotify();
      localFTNNotify.uint64_sessionid = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
      localFTNNotify.str_file_name = paramArrayOfByte.str_file_name.get();
      localFTNNotify.str_file_index = new String(paramArrayOfByte.bytes_file_index.get().toByteArray());
      localFTNNotify.bytes_file_md5 = paramArrayOfByte.bytes_file_md5.get().toByteArray();
      localFTNNotify.uint64_file_len = paramArrayOfByte.uint64_file_length.get();
      localFTNNotify.bytes_originfile_md5 = paramArrayOfByte.bytes_file_md5.get().toByteArray();
      localFTNNotify.uint32_originfiletype = 0;
      localFTNNotify.uint32_group_id = 0;
      localFTNNotify.uint32_group_size = 0;
      localFTNNotify.uint32_group_curindex = 0;
      localFTNNotify.msg_ActionInfo = new ActionInfo();
      localFTNNotify.msg_ActionInfo.strServiceName = this.jdField_a_of_type_JavaLangString;
      localFTNNotify.msg_ActionInfo.vServiceInfo = null;
      localFTNNotify.uint32_batchID = 0;
      localFTNNotify.uint32_groupflag = 0;
      long l = localFTNNotify.uint64_sessionid;
      paramLong.add(localFTNNotify);
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])paramLong.toArray(new FTNNotify[paramLong.size()]));
      return localFTNNotify.uint64_sessionid;
    }
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    QLog.d("Device.file", 1, "OnSessionComplete uSessionID=" + paramLong + " retCode=" + paramInt2 + " TaskStatus=" + paramInt1);
    Session localSession = (Session)this.e.get(Long.valueOf(paramLong));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionComplete no session for uSessionID=" + paramLong);
      }
      return;
    }
    if (paramInt1 == 2) {}
    for (;;)
    {
      super.a(103, bool, localSession);
      return;
      bool = false;
    }
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      if (paramSession.actionInfo.vServiceInfo != null) {}
      do
      {
        try
        {
          DeviceProto.MsgActionInfo localMsgActionInfo = (DeviceProto.MsgActionInfo)new DeviceProto.MsgActionInfo().mergeFrom(paramSession.actionInfo.vServiceInfo);
          if (localMsgActionInfo == null)
          {
            QLog.w("Device.file", 1, "OnSessionNew decode bussiness name error");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          Object localObject;
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
            localObject = null;
          }
          paramSession.actionInfo.strServiceName = localObject.str_bussiness_name.get();
          paramSession.actionInfo.vServiceInfo = localObject.bytes_buff_with_file.get().toByteArray();
        }
        this.e.put(Long.valueOf(paramSession.uSessionID), paramSession);
      } while (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramSession.uSessionID)));
      if ((!paramSession.bSend) && ((DeviceMsgHandle.d.equalsIgnoreCase(paramSession.actionInfo.strServiceName)) || (DeviceMsgHandle.h.equalsIgnoreCase(paramSession.actionInfo.strServiceName)) || (DeviceMsgHandle.b.equalsIgnoreCase(paramSession.actionInfo.strServiceName))))
      {
        super.a(paramSession, paramNFCInfo, paramFTNInfo, false);
        super.b(paramSession);
      }
      super.a(100, true, paramSession);
    }
    QLog.d("Device.file", 1, "OnSessionNew uSessionID=" + paramSession.uSessionID + " bussiness=" + paramSession.actionInfo.strServiceName);
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "OnSessionProgress uSessionID=" + paramLong1 + "=====" + (float)((float)paramLong2 * 1.0D / paramLong3));
    }
    Session localSession = (Session)this.e.get(Long.valueOf(paramLong1));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionProgress no session for uSessionID=" + paramLong1);
      }
      return;
    }
    super.a(102, true, new Object[] { localSession, Float.valueOf((float)((float)paramLong2 * 1.0D / (float)paramLong3)) });
  }
  
  public void OnSessionStart(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "OnSessionStart uSessionID=" + paramLong);
    }
    Session localSession = (Session)this.e.get(Long.valueOf(paramLong));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionStart no session for uSessionID=" + paramLong);
      }
      return;
    }
    super.a(101, true, localSession);
  }
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString) {}
  
  public int a(long paramLong)
  {
    int i = 0;
    if (this.c.containsKey(Long.valueOf(paramLong)))
    {
      i = ((Integer)this.c.get(Long.valueOf(paramLong))).intValue();
      this.c.remove(Long.valueOf(paramLong));
    }
    return i;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt1 == 3) {
      l = ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(paramString, paramInt2);
    }
    return l;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt1 == 1)
    {
      paramQQAppInterface = new MsgCSBody();
      l = a(Base64.decode(paramString1, 2), paramQQAppInterface, Long.valueOf(0L));
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramQQAppInterface);
    }
    do
    {
      return l;
      if (paramInt1 == 2)
      {
        l = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
        paramString2 = MD5Utils.d(paramString1) + paramString1.substring(paramString1.lastIndexOf("."));
        paramString2 = AppConstants.aK + "smartdevice/" + paramString2;
        if (FileUtils.b(paramString2))
        {
          paramQQAppInterface = new Message();
          paramQQAppInterface.what = 0;
          paramString1 = new Session();
          paramString1.uSessionID = l;
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(paramString1, DeviceMsgHandle.g, null);
          paramString1.strFilePathSrc = paramString2;
          paramString1.uFileSizeSrc = FileUtils.a(paramString2);
          paramQQAppInterface.obj = paramString1;
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramQQAppInterface, 100L);
          return l;
        }
        Object localObject = new Session();
        ((Session)localObject).uSessionID = l;
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, DeviceMsgHandle.g, null);
        this.e.put(Long.valueOf(l), localObject);
        a(101, true, localObject);
        localObject = new HttpNetReq();
        ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
        ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((HttpNetReq)localObject).jdField_a_of_type_Int = 0;
        ((HttpNetReq)localObject).c = paramString2;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localObject);
        paramQQAppInterface.getNetEngine(0).a((NetReq)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        return l;
      }
    } while (paramInt1 != 3);
    l = ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(paramString1, paramString2, paramInt2);
    paramQQAppInterface = new Session();
    paramQQAppInterface.uSessionID = l;
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(paramQQAppInterface, DeviceMsgHandle.g, null);
    this.e.put(Long.valueOf(l), paramQQAppInterface);
    a(101, true, paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(l));
    return l;
  }
  
  public DeviceProto.MsgFileKey a(String paramString)
  {
    try
    {
      paramString = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(Base64.decode(paramString, 2));
      if ((paramString == null) && (QLog.isColorLevel())) {
        QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
      }
      return paramString;
    }
    catch (InvalidProtocolBufferMicroException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public Session a(Session paramSession)
  {
    Session localSession = new Session();
    localSession.uSessionID = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
    localSession.emFileType = paramSession.emFileType;
    localSession.strFileNameSrc = paramSession.strFileNameSrc;
    localSession.uFileSizeSrc = paramSession.uFileSizeSrc;
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, DeviceMsgHandle.c, null);
    this.e.put(Long.valueOf(localSession.uSessionID), localSession);
    return localSession;
  }
  
  public Session a(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "send file path=" + paramString1 + " servicename=" + paramString2 + " to " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    Session localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, paramString1, null, 0, 0, 0L, 0, 0, 0);
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "session create failed");
      }
      return null;
    }
    int i;
    if (paramString2.equalsIgnoreCase(DeviceMsgHandle.c))
    {
      i = 2251;
      switch (FileManagerUtil.a(paramString1))
      {
      default: 
        localSession.uSessionID = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 3, i);
        localSession.emFileType = i;
        localSession.strFileNameSrc = FileManagerUtil.a(paramString1);
        localSession.uFileSizeSrc = FileUtils.a(paramString1);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, DeviceMsgHandle.c, null);
        this.e.put(Long.valueOf(localSession.uSessionID), localSession);
        a(101, true, localSession);
      }
    }
    for (;;)
    {
      return localSession;
      i = 2154;
      break;
      i = 2201;
      break;
      i = 2108;
      break;
      localArrayList.add(localSession);
      localSession.uSessionID = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
      localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong);
      paramString1 = new DeviceProto.MsgActionInfo();
      paramString1.str_bussiness_name.set(paramString2);
      if (paramArrayOfByte != null) {
        paramString1.bytes_buff_with_file.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      paramString1 = paramString1.toByteArray();
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, this.jdField_a_of_type_JavaLangString, paramString1);
      if (localArrayList.size() > 0) {
        super.a(localArrayList, false);
      }
    }
  }
  
  protected Class a()
  {
    return DeviceFileObserver.class;
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver);
      this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver = null;
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          if ((((Long)((Map.Entry)localObject).getKey()).longValue() != paramLong) && (((HttpNetReq)((Map.Entry)localObject).getValue()).jdField_a_of_type_JavaLangString.equals(((HttpNetReq)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b((NetReq)((Map.Entry)localObject).getValue());
            localObject = (Session)this.e.get(((Map.Entry)localObject).getKey());
            if (localObject != null) {
              break;
            }
          }
        }
      }
    }
    while (this.jdField_b_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong)))
    {
      for (;;)
      {
        Iterator localIterator;
        Object localObject;
        return;
        super.a(103, false, localObject);
        localIterator.remove();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b((NetReq)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)));
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
      return;
    }
    super.a(paramInt, paramLong, paramBoolean);
  }
  
  public void a(Session paramSession)
  {
    if (paramSession != null) {
      this.e.put(Long.valueOf(paramSession.uSessionID), paramSession);
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    for (;;)
    {
      Map.Entry localEntry;
      Session localSession;
      if (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if (!((HttpNetReq)localEntry.getValue()).jdField_a_of_type_JavaLangString.equals(((HttpNetReq)paramNetReq).jdField_a_of_type_JavaLangString)) {
          continue;
        }
        int i = 0;
        if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramNetReq)) {
          i = ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramNetReq)).intValue();
        }
        if (i < 10)
        {
          this.jdField_b_of_type_JavaUtilHashMap.put((HttpNetReq)paramNetReq, Integer.valueOf(i + 1));
          continue;
        }
        this.jdField_b_of_type_JavaUtilHashMap.put((HttpNetReq)paramNetReq, Integer.valueOf(0));
        localSession = (Session)this.e.get(localEntry.getKey());
        if (localSession != null) {}
      }
      else
      {
        return;
      }
      localSession.uSessionID = ((Long)localEntry.getKey()).longValue();
      if (localSession.uFileSizeSrc == 0L) {
        localSession.uFileSizeSrc = paramLong2;
      }
      super.a(102, true, new Object[] { localSession, Float.valueOf((float)((float)paramLong1 * 1.0D / (float)paramLong2)) });
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 3) {}
    Iterator localIterator;
    label22:
    Object localObject;
    do
    {
      return;
      localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (!((HttpNetReq)((Map.Entry)localObject).getValue()).jdField_a_of_type_JavaLangString.equals(((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString));
      localObject = (Session)this.e.get(((Map.Entry)localObject).getKey());
    } while (localObject == null);
    ((Session)localObject).strFilePathSrc = paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c;
    ((Session)localObject).uFileSizeSrc = paramNetResp.jdField_a_of_type_Long;
    if (paramNetResp.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.a(103, bool, localObject);
      localIterator.remove();
      break label22;
      break;
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.f.containsKey(Long.valueOf(paramLong)))
    {
      bool1 = bool2;
      if (this.f.get(Long.valueOf(paramLong)) != null) {
        bool1 = ((Boolean)this.f.get(Long.valueOf(paramLong))).booleanValue();
      }
    }
    return bool1;
  }
  
  public boolean getAutoDownload()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileHandler
 * JD-Core Version:    0.7.0.1
 */