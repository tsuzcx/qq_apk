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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
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
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
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

public class DeviceFileHandler
  extends RouterHandler
  implements INetEngineListener
{
  protected HashSet<Long> a;
  protected HashMap<Long, HttpNetReq> b;
  protected HashMap<HttpNetReq, Integer> c;
  protected HashSet<Long> d;
  protected HashMap<Long, Integer> e;
  QQAppInterface f = null;
  Handler g = new DeviceFileHandler.1(this, Looper.getMainLooper());
  private HashMap<Long, Boolean> p;
  private DeviceFileHandler.DeviceNotifyReceiver q = null;
  
  public DeviceFileHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.f = paramQQAppInterface;
    this.h = "Device";
    this.a = new HashSet();
    this.b = new HashMap();
    this.c = new HashMap();
    this.d = new HashSet();
    this.e = new HashMap();
    this.p = new HashMap();
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("SmartDevice_OnMiniFileTransferComplete");
    paramQQAppInterface.addAction("SmartDevice_OnMiniFileTransferProgress");
    paramQQAppInterface.addAction("SmartDevice_OnDataPointFileMsgProgress");
    paramQQAppInterface.addAction("SmartDevice_OnDataPointFileMsgSendRet");
    paramQQAppInterface.addAction("CloudPrintJobNotifyEvent");
    this.q = new DeviceFileHandler.DeviceNotifyReceiver(this);
    this.f.getApp().registerReceiver(this.q, paramQQAppInterface);
  }
  
  private long a(byte[] paramArrayOfByte, MsgCSBody paramMsgCSBody, Long paramLong)
  {
    try
    {
      paramArrayOfByte = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
      }
      return 0L;
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
    localFTNNotify.uint64_sessionid = this.j.generateSessionID(0);
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
    localFTNNotify.msg_ActionInfo.strServiceName = this.h;
    localFTNNotify.msg_ActionInfo.vServiceInfo = null;
    localFTNNotify.uint32_batchID = 0;
    localFTNNotify.uint32_groupflag = 0;
    long l = localFTNNotify.uint64_sessionid;
    paramLong.add(localFTNNotify);
    paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])paramLong.toArray(new FTNNotify[paramLong.size()]));
    return localFTNNotify.uint64_sessionid;
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnSessionComplete uSessionID=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" retCode=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" TaskStatus=");
    ((StringBuilder)localObject).append(paramInt1);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("Device.file", 1, (String)localObject);
    localObject = (Session)this.o.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnSessionComplete no session for uSessionID=");
        ((StringBuilder)localObject).append(paramLong);
        QLog.w("Device.file", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (paramInt1 != 2) {
        bool = false;
      }
      super.notifyUI(103, bool, localObject);
    }
  }
  
  public void OnSessionConnected(long paramLong, int paramInt1, int paramInt2) {}
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(this.h))
    {
      Object localObject = null;
      if (paramSession.actionInfo.vServiceInfo != null)
      {
        try
        {
          DeviceProto.MsgActionInfo localMsgActionInfo = (DeviceProto.MsgActionInfo)new DeviceProto.MsgActionInfo().mergeFrom(paramSession.actionInfo.vServiceInfo);
          localObject = localMsgActionInfo;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (localObject == null)
        {
          QLog.w("Device.file", 1, "OnSessionNew decode bussiness name error");
          return;
        }
        paramSession.actionInfo.strServiceName = localObject.str_bussiness_name.get();
        paramSession.actionInfo.vServiceInfo = localObject.bytes_buff_with_file.get().toByteArray();
      }
      this.o.put(Long.valueOf(paramSession.uSessionID), paramSession);
      if (this.a.contains(Long.valueOf(paramSession.uSessionID))) {
        return;
      }
      if ((!paramSession.bSend) && ((DeviceMsgHandle.d.equalsIgnoreCase(paramSession.actionInfo.strServiceName)) || (DeviceMsgHandle.h.equalsIgnoreCase(paramSession.actionInfo.strServiceName)) || (DeviceMsgHandle.b.equalsIgnoreCase(paramSession.actionInfo.strServiceName))))
      {
        super.a(paramSession, paramNFCInfo, paramFTNInfo, false);
        super.c(paramSession);
      }
      super.notifyUI(100, true, paramSession);
    }
    paramNFCInfo = new StringBuilder();
    paramNFCInfo.append("OnSessionNew uSessionID=");
    paramNFCInfo.append(paramSession.uSessionID);
    paramNFCInfo.append(" bussiness=");
    paramNFCInfo.append(paramSession.actionInfo.strServiceName);
    QLog.d("Device.file", 1, paramNFCInfo.toString());
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    double d1;
    double d2;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnSessionProgress uSessionID=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("=====");
      d1 = (float)paramLong2;
      Double.isNaN(d1);
      d2 = paramLong3;
      Double.isNaN(d2);
      ((StringBuilder)localObject).append((float)(d1 * 1.0D / d2));
      QLog.d("Device.file", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Session)this.o.get(Long.valueOf(paramLong1));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnSessionProgress no session for uSessionID=");
        ((StringBuilder)localObject).append(paramLong1);
        QLog.w("Device.file", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      d1 = (float)paramLong2;
      Double.isNaN(d1);
      d2 = (float)paramLong3;
      Double.isNaN(d2);
      super.notifyUI(102, true, new Object[] { localObject, Float.valueOf((float)(d1 * 1.0D / d2)) });
    }
  }
  
  public void OnSessionStart(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnSessionStart uSessionID=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("Device.file", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Session)this.o.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnSessionStart no session for uSessionID=");
        ((StringBuilder)localObject).append(paramLong);
        QLog.w("Device.file", 2, ((StringBuilder)localObject).toString());
      }
    }
    else {
      super.notifyUI(101, true, localObject);
    }
  }
  
  public void OnSessionStartRun(long paramLong) {}
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString) {}
  
  public int a(long paramLong)
  {
    if (this.e.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((Integer)this.e.get(Long.valueOf(paramLong))).intValue();
      this.e.remove(Long.valueOf(paramLong));
      return i;
    }
    return 0;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3) {
      return ((SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).b(paramString, paramInt2);
    }
    return 0L;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt1 == 1)
    {
      paramQQAppInterface = new MsgCSBody();
      l = a(Base64.decode(paramString1, 2), paramQQAppInterface, Long.valueOf(0L));
      this.a.add(Long.valueOf(l));
      this.j.OnPbMsgReceive(paramQQAppInterface);
      return l;
    }
    if (paramInt1 == 2)
    {
      l = this.j.generateSessionID(0);
      paramString2 = new StringBuilder();
      paramString2.append(MD5Utils.toMD5(paramString1));
      paramString2.append(paramString1.substring(paramString1.lastIndexOf(".")));
      paramString2 = paramString2.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject).append("smartdevice/");
      ((StringBuilder)localObject).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
      if (FileUtils.fileExistsAndNotEmpty(paramString2))
      {
        paramQQAppInterface = new Message();
        paramQQAppInterface.what = 0;
        paramString1 = new Session();
        paramString1.uSessionID = l;
        this.k.fillService(paramString1, DeviceMsgHandle.g, null);
        paramString1.strFilePathSrc = paramString2;
        paramString1.uFileSizeSrc = FileUtils.getFileSizes(paramString2);
        paramQQAppInterface.obj = paramString1;
        this.g.sendMessageDelayed(paramQQAppInterface, 100L);
        return l;
      }
      localObject = new Session();
      ((Session)localObject).uSessionID = l;
      this.k.fillService((Session)localObject, DeviceMsgHandle.g, null);
      this.o.put(Long.valueOf(l), localObject);
      notifyUI(101, true, localObject);
      localObject = new HttpNetReq();
      ((HttpNetReq)localObject).mCallback = this;
      ((HttpNetReq)localObject).mReqUrl = paramString1;
      ((HttpNetReq)localObject).mHttpMethod = 0;
      ((HttpNetReq)localObject).mOutPath = paramString2;
      this.b.put(Long.valueOf(l), localObject);
      ((IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
      this.f = paramQQAppInterface;
      return l;
    }
    if (paramInt1 == 3)
    {
      l = ((SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramString1, paramString2, paramInt2);
      paramQQAppInterface = new Session();
      paramQQAppInterface.uSessionID = l;
      this.k.fillService(paramQQAppInterface, DeviceMsgHandle.g, null);
      this.o.put(Long.valueOf(l), paramQQAppInterface);
      notifyUI(101, true, paramQQAppInterface);
      this.d.add(Long.valueOf(l));
    }
    return l;
  }
  
  public DeviceProto.MsgFileKey a(String paramString)
  {
    try
    {
      paramString = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(Base64.decode(paramString, 2));
    }
    catch (InvalidProtocolBufferMicroException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    if ((paramString == null) && (QLog.isColorLevel())) {
      QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
    }
    return paramString;
  }
  
  public Session a(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send file path=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" servicename=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" to ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("Device.file", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    Session localSession = this.k.genSession(0, paramString1, null, 0, 0, 0L, 0, 0, 0);
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "session create failed");
      }
      return null;
    }
    if (paramString2.equalsIgnoreCase(DeviceMsgHandle.c))
    {
      int i = 2251;
      int j = FileManagerUtil.c(paramString1);
      if (j != 0)
      {
        if (j != 1)
        {
          if (j == 2) {
            i = 2201;
          }
        }
        else {
          i = 2108;
        }
      }
      else {
        i = 2154;
      }
      localSession.uSessionID = a(this.f, paramString1, 3, i);
      localSession.emFileType = i;
      localSession.strFileNameSrc = FileManagerUtil.a(paramString1);
      localSession.uFileSizeSrc = FileUtils.getFileSizes(paramString1);
      this.k.fillService(localSession, DeviceMsgHandle.c, null);
      this.o.put(Long.valueOf(localSession.uSessionID), localSession);
      notifyUI(101, true, localSession);
      return localSession;
    }
    ((ArrayList)localObject).add(localSession);
    localSession.uSessionID = this.j.generateSessionID(0);
    localSession.msgHeader = this.k.msgHeader(paramLong);
    paramString1 = new DeviceProto.MsgActionInfo();
    paramString1.str_bussiness_name.set(paramString2);
    if (paramArrayOfByte != null) {
      paramString1.bytes_buff_with_file.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramString1 = paramString1.toByteArray();
    this.k.fillService(localSession, this.h, paramString1);
    if (((ArrayList)localObject).size() > 0) {
      super.a((ArrayList)localObject, false);
    }
    return localSession;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((this.b.containsKey(Long.valueOf(paramLong))) && (this.f != null))
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if ((((Long)((Map.Entry)localObject).getKey()).longValue() != paramLong) && (((HttpNetReq)((Map.Entry)localObject).getValue()).mReqUrl.equals(((HttpNetReq)this.b.get(Long.valueOf(paramLong))).mReqUrl)))
        {
          ((IHttpEngineService)this.f.getRuntimeService(IHttpEngineService.class, "all")).cancelReq((NetReq)((Map.Entry)localObject).getValue());
          localObject = (Session)this.o.get(((Map.Entry)localObject).getKey());
          if (localObject == null) {
            return;
          }
          super.notifyUI(103, false, localObject);
          localIterator.remove();
        }
      }
      ((IHttpEngineService)this.f.getRuntimeService(IHttpEngineService.class, "all")).cancelReq((NetReq)this.b.get(Long.valueOf(paramLong)));
      this.b.remove(Long.valueOf(paramLong));
      return;
    }
    if (this.d.contains(Long.valueOf(paramLong))) {
      return;
    }
    super.a(paramInt, paramLong, paramBoolean);
  }
  
  public void a(Session paramSession)
  {
    if (paramSession != null) {
      this.o.put(Long.valueOf(paramSession.uSessionID), paramSession);
    }
  }
  
  public Session b(Session paramSession)
  {
    Session localSession = new Session();
    localSession.uSessionID = this.j.generateSessionID(0);
    localSession.emFileType = paramSession.emFileType;
    localSession.strFileNameSrc = paramSession.strFileNameSrc;
    localSession.uFileSizeSrc = paramSession.uFileSizeSrc;
    this.k.fillService(localSession, DeviceMsgHandle.c, null);
    this.o.put(Long.valueOf(localSession.uSessionID), localSession);
    return localSession;
  }
  
  public boolean b(long paramLong)
  {
    if ((this.p.containsKey(Long.valueOf(paramLong))) && (this.p.get(Long.valueOf(paramLong)) != null)) {
      return ((Boolean)this.p.get(Long.valueOf(paramLong))).booleanValue();
    }
    return false;
  }
  
  public boolean getAutoDownload()
  {
    return true;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return DeviceFileObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQAppInterface localQQAppInterface = this.f;
    if ((localQQAppInterface != null) && (localQQAppInterface.getApp() != null) && (this.q != null))
    {
      this.f.getApp().unregisterReceiver(this.q);
      this.q = null;
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {
      return;
    }
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (((HttpNetReq)((Map.Entry)localObject).getValue()).mReqUrl.equals(((HttpNetReq)paramNetResp.mReq).mReqUrl))
      {
        localObject = (Session)this.o.get(((Map.Entry)localObject).getKey());
        if (localObject == null) {
          return;
        }
        ((Session)localObject).strFilePathSrc = paramNetResp.mReq.mOutPath;
        ((Session)localObject).uFileSizeSrc = paramNetResp.mTotalFileLen;
        boolean bool;
        if (paramNetResp.mResult == 0) {
          bool = true;
        } else {
          bool = false;
        }
        super.notifyUI(103, bool, localObject);
        localIterator.remove();
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = ((HttpNetReq)localEntry.getValue()).mReqUrl;
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      if (((String)localObject).equals(localHttpNetReq.mReqUrl))
      {
        int i;
        if (this.c.containsKey(paramNetReq)) {
          i = ((Integer)this.c.get(paramNetReq)).intValue();
        } else {
          i = 0;
        }
        if (i < 10)
        {
          this.c.put(localHttpNetReq, Integer.valueOf(i + 1));
        }
        else
        {
          this.c.put(localHttpNetReq, Integer.valueOf(0));
          localObject = (Session)this.o.get(localEntry.getKey());
          if (localObject == null) {
            return;
          }
          ((Session)localObject).uSessionID = ((Long)localEntry.getKey()).longValue();
          if (((Session)localObject).uFileSizeSrc == 0L) {
            ((Session)localObject).uFileSizeSrc = paramLong2;
          }
          double d1 = (float)paramLong1;
          Double.isNaN(d1);
          double d2 = (float)paramLong2;
          Double.isNaN(d2);
          super.notifyUI(102, true, new Object[] { localObject, Float.valueOf((float)(d1 * 1.0D / d2)) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileHandler
 * JD-Core Version:    0.7.0.1
 */