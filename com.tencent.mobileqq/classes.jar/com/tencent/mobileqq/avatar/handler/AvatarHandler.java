package com.tencent.mobileqq.avatar.handler;

import AvatarInfo.QQHeadInfo;
import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceConstant.Apollo;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.face.bean.QQHeadDetails;
import com.tencent.mobileqq.app.face.bean.QQHeadStat;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQClassicAvatarService;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.avatar.utils.AvatarImplUtil;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadOptimizer;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.app.face.bean.QQHeadDetails;>;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xedb.oidb_0xedb.ReqBody;
import tencent.im.oidb.cmd0xedb.oidb_0xedb.ReqUsrInfo;
import tencent.im.oidb.cmd0xedb.oidb_0xedb.RspBody;
import tencent.im.oidb.cmd0xedb.oidb_0xedb.RspHeadInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class AvatarHandler
  extends BusinessHandler
{
  public AppInterface a;
  private MqqHandler b;
  private int c = 0;
  private Hashtable<Integer, ArrayList<QQHeadDetails>> d = new Hashtable();
  private Hashtable<String, Long> e = new Hashtable();
  private Object f = new Object();
  private QQHeadDownloadHandler g;
  private Object h = new Object();
  private Hashtable<String, QQHeadStat> i = new Hashtable();
  private boolean j = false;
  private boolean k = false;
  
  protected AvatarHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
    a();
  }
  
  public static oidb_0xedb.ReqBody a(ArrayList<QQHeadDetails> paramArrayList)
  {
    if (paramArrayList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (QQHeadDetails)paramArrayList.next();
        long l = Long.parseLong(((QQHeadDetails)localObject).b);
        int m = (int)((QQHeadDetails)localObject).c;
        localObject = new oidb_0xedb.ReqUsrInfo();
        ((oidb_0xedb.ReqUsrInfo)localObject).dstUin.set(l);
        ((oidb_0xedb.ReqUsrInfo)localObject).timestamp.set(m);
        localArrayList.add(localObject);
      }
      if (!localArrayList.isEmpty())
      {
        paramArrayList = new oidb_0xedb.ReqBody();
        paramArrayList.dstUsrType.set(3);
        paramArrayList.dstUsrInfos.addAll(localArrayList);
        return paramArrayList;
      }
    }
    return null;
  }
  
  private void a(byte paramByte1, byte paramByte2, QQHeadUrl.QQHeadUrlRsp paramQQHeadUrlRsp, ArrayList<QQHeadDetails> paramArrayList, List<QQHeadDetails> paramList, List<QQHeadInfo> paramList1)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      List localList = paramQQHeadUrlRsp.dstHeadInfos.get();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.next();
        int n = 0;
        Object localObject = localList.iterator();
        QQHeadUrl.RspHeadInfo localRspHeadInfo;
        do
        {
          m = n;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((Iterator)localObject).next();
          if (paramByte2 == 1) {
            paramQQHeadUrlRsp = localRspHeadInfo.dstUid.get();
          } else {
            paramQQHeadUrlRsp = String.valueOf(localRspHeadInfo.dstUin.get());
          }
        } while (!localQQHeadDetails.b.equals(paramQQHeadUrlRsp));
        localObject = new QQHeadInfo();
        ((QQHeadInfo)localObject).headLevel = localQQHeadDetails.d;
        if (paramByte2 == 1) {
          ((QQHeadInfo)localObject).phoneNum = localRspHeadInfo.dstUid.get();
        } else {
          ((QQHeadInfo)localObject).uin = localRspHeadInfo.dstUin.get();
        }
        ((QQHeadInfo)localObject).dwTimestamp = localRspHeadInfo.timestamp.get();
        ((QQHeadInfo)localObject).cHeadType = ((byte)localRspHeadInfo.faceType.get());
        ((QQHeadInfo)localObject).dstUsrType = paramByte1;
        ((QQHeadInfo)localObject).dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
        ((QQHeadInfo)localObject).downLoadUrl = localRspHeadInfo.url.get();
        ((QQHeadInfo)localObject).systemHeadID = ((short)localRspHeadInfo.sysid.get());
        if (localRspHeadInfo.headVerify.has()) {
          paramQQHeadUrlRsp = localRspHeadInfo.headVerify.get();
        } else {
          paramQQHeadUrlRsp = "";
        }
        ((QQHeadInfo)localObject).headVerify = paramQQHeadUrlRsp;
        paramList1.add(localObject);
        int m = 1;
        if (m == 0) {
          paramList.add(localQQHeadDetails);
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, List<QQHeadDetails> paramList)
  {
    EntityManager localEntityManager;
    EntityTransaction localEntityTransaction;
    int m;
    if (paramList.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, "handleQQHead_New noChangeQQHeadInfoList");
      }
      localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
      m = 0;
    }
    try
    {
      while (m < paramList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramList.get(m);
        Setting localSetting = (Setting)localEntityManager.find(Setting.class, AvatarUtil.a(paramInt1, localQQHeadDetails.b, paramInt2));
        if (localSetting != null)
        {
          localSetting.updateTimestamp = System.currentTimeMillis();
          ((IQQAvatarDataService)this.a.getRuntimeService(IQQAvatarDataService.class, "")).updateSettingTableCache(localSetting);
          localEntityManager.update(localSetting);
        }
        a(AvatarUtil.a(paramInt1, localQQHeadDetails.b, paramInt2, localQQHeadDetails.e), true);
        m += 1;
      }
    }
    catch (Exception paramList)
    {
      label169:
      break label169;
    }
    localEntityTransaction.commit();
    localEntityTransaction.end();
  }
  
  private void a(int paramInt1, int paramInt2, List<MultiHeadUrl.RspUsrHeadInfo> paramList, ArrayList<QQHeadDetails> paramArrayList, List<QQHeadDetails> paramList1, List<QQHeadInfo> paramList2)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    while (localIterator1.hasNext())
    {
      QQHeadDetails localQQHeadDetails = (QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        Object localObject1 = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        int m = 1;
        if (paramInt2 == 0) {
          paramArrayList = String.valueOf(((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstUin.get());
        } else if (paramInt2 == 1) {
          paramArrayList = String.valueOf(((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstTid.get());
        } else {
          paramArrayList = ((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstOpenid.get();
        }
        if (localQQHeadDetails.b.equals(paramArrayList))
        {
          Object localObject4 = ((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstHeadInfos.get().iterator();
          Object localObject2 = null;
          localObject1 = null;
          Object localObject3;
          while (((Iterator)localObject4).hasNext())
          {
            localObject3 = (MultiHeadUrl.RspHeadInfo)((Iterator)localObject4).next();
            int n = ((MultiHeadUrl.RspHeadInfo)localObject3).usrType.get();
            if (n == 1) {
              localObject1 = localObject3;
            } else if ((n == 32) && (((MultiHeadUrl.RspHeadInfo)localObject3).faceType.get() != 0)) {
              localObject2 = localObject3;
            }
          }
          if (localObject2 == null)
          {
            if (localObject1 != null) {
              localObject2 = localObject1;
            }
          }
          else
          {
            localObject3 = this.a;
            localObject1 = "";
            localObject3 = (IQQAvatarDataService)((AppInterface)localObject3).getRuntimeService(IQQAvatarDataService.class, "");
            localObject4 = ((IQQAvatarDataService)localObject3).getQQHeadSetting(32, paramArrayList, paramInt1);
            if (((IQQAvatarDataService)localObject3).isFaceFileExist(32, paramArrayList, paramInt1, 0))
            {
              while (localObject4 != null)
              {
                localObject3 = (Setting)((Pair)localObject4).second;
                if (localObject3 != null) {
                  if (((Setting)localObject3).headImgTimestamp == localObject2.timestamp.get())
                  {
                    paramList1.add(localQQHeadDetails);
                    m = 0;
                    break label355;
                  }
                }
              }
              m = 1;
            }
            label355:
            if (m != 0)
            {
              localObject3 = new QQHeadInfo();
              ((QQHeadInfo)localObject3).headLevel = localQQHeadDetails.d;
              ((QQHeadInfo)localObject3).idType = paramInt1;
              ((QQHeadInfo)localObject3).phoneNum = paramArrayList;
              ((QQHeadInfo)localObject3).dwTimestamp = localObject2.timestamp.get();
              ((QQHeadInfo)localObject3).cHeadType = ((byte)localObject2.faceType.get());
              ((QQHeadInfo)localObject3).dstUsrType = 32;
              ((QQHeadInfo)localObject3).dwFaceFlgas = ((byte)localObject2.faceFlag.get());
              ((QQHeadInfo)localObject3).downLoadUrl = localObject2.url.get();
              ((QQHeadInfo)localObject3).systemHeadID = ((short)localObject2.sysid.get());
              ((QQHeadInfo)localObject3).originUsrType = localObject2.usrType.get();
              paramArrayList = (ArrayList<QQHeadDetails>)localObject1;
              if (localObject2.headVerify.has()) {
                paramArrayList = localObject2.headVerify.get();
              }
              ((QQHeadInfo)localObject3).headVerify = paramArrayList;
              paramList2.add(localObject3);
              continue;
            }
            notifyUI(4, true, new Object[] { localQQHeadDetails.b, Integer.valueOf(paramInt1), Boolean.valueOf(true) });
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("there is no headinfo uin=");
            ((StringBuilder)localObject1).append(paramArrayList);
            QLog.d("headstranger", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, int paramInt3, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new AvatarHandler.3(this, paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramInt3, paramBoolean), 8, null, false);
      return;
    }
    b(paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramInt3, paramBoolean);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new AvatarHandler.2(this, paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean), 8, null, false);
      return;
    }
    b(paramInt1, paramString, paramInt2, paramByte1, paramByte2, 0, paramBoolean);
  }
  
  private void a(int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
      localMultiBusidUrlReq.srcUidType.set(0);
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.a.getAccount()));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(16));
      localMultiBusidUrlReq.dstUidType.set(0);
      int m = 0;
      while (m < paramArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(m);
        MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
        try
        {
          localReqUsrInfo.dstUin.set(AvatarImplUtil.b(localQQHeadDetails.b));
          a(0, localQQHeadDetails.b, localQQHeadDetails.a, 1);
          localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ERROR", 2, localException.getMessage());
          }
        }
        m += 1;
      }
      new HashMap().put("connum", String.valueOf(paramArrayList.size()));
      ToServiceMsg localToServiceMsg = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
      localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
      localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
      localToServiceMsg.extraData.putInt("idType", paramInt);
      localToServiceMsg.extraData.putInt("qqHeadType", 16);
      localToServiceMsg.putWupBuffer(localMultiBusidUrlReq.toByteArray());
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("realGetQQHead_QCall .  idType = ");
        paramArrayList.append(paramInt);
        QLog.i("AvatarHandler", 2, paramArrayList.toString());
      }
      sendPbReq(localToServiceMsg);
    }
  }
  
  private void a(int paramInt, List<MultiHeadUrl.RspUsrHeadInfo> paramList, ArrayList<QQHeadDetails> paramArrayList, List<QQHeadDetails> paramList1, List<QQHeadInfo> paramList2)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    while (localIterator1.hasNext())
    {
      QQHeadDetails localQQHeadDetails = (QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        paramArrayList = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        String str = AvatarImplUtil.a(paramArrayList.dstUin.get());
        if (localQQHeadDetails.b.equals(str))
        {
          Object localObject1 = paramArrayList.dstHeadInfos.get();
          paramArrayList = null;
          Object localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (MultiHeadUrl.RspHeadInfo)((Iterator)localObject2).next();
            ((MultiHeadUrl.RspHeadInfo)localObject1).usrType.get();
            if (((MultiHeadUrl.RspHeadInfo)localObject1).faceType.get() != 0) {
              paramArrayList = (ArrayList<QQHeadDetails>)localObject1;
            }
          }
          if (paramArrayList != null)
          {
            localObject2 = this.a;
            localObject1 = "";
            localObject2 = (IQQAvatarDataService)((AppInterface)localObject2).getRuntimeService(IQQAvatarDataService.class, "");
            Object localObject3 = ((IQQAvatarDataService)localObject2).getQQHeadSetting(16, str, paramInt);
            if (!((IQQAvatarDataService)localObject2).isFaceFileExist(16, str, paramInt, 0)) {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handleQQHead_QCALL file not exist.id=");
                ((StringBuilder)localObject2).append(str);
                ((StringBuilder)localObject2).append(",idType=");
                ((StringBuilder)localObject2).append(paramInt);
                QLog.i("Q.qqhead.", 2, ((StringBuilder)localObject2).toString());
              }
            }
            do
            {
              do
              {
                m = 1;
                break;
              } while (localObject3 == null);
              localObject2 = (Setting)((Pair)localObject3).second;
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("handleQQHead_QCALL setting=");
                ((StringBuilder)localObject3).append(localObject2);
                ((StringBuilder)localObject3).append("targetInfo.timestamp=");
                ((StringBuilder)localObject3).append(paramArrayList.timestamp.get());
                QLog.i("Q.qqhead.", 2, ((StringBuilder)localObject3).toString());
              }
            } while ((localObject2 == null) || (((Setting)localObject2).headImgTimestamp != paramArrayList.timestamp.get()));
            paramList1.add(localQQHeadDetails);
            int m = 0;
            if (m != 0)
            {
              localObject2 = new QQHeadInfo();
              ((QQHeadInfo)localObject2).headLevel = localQQHeadDetails.d;
              ((QQHeadInfo)localObject2).idType = paramInt;
              ((QQHeadInfo)localObject2).phoneNum = str;
              ((QQHeadInfo)localObject2).dwTimestamp = paramArrayList.timestamp.get();
              ((QQHeadInfo)localObject2).cHeadType = ((byte)paramArrayList.faceType.get());
              ((QQHeadInfo)localObject2).dstUsrType = 16;
              ((QQHeadInfo)localObject2).dwFaceFlgas = ((byte)paramArrayList.faceFlag.get());
              ((QQHeadInfo)localObject2).downLoadUrl = paramArrayList.url.get();
              ((QQHeadInfo)localObject2).systemHeadID = ((short)paramArrayList.sysid.get());
              ((QQHeadInfo)localObject2).originUsrType = paramArrayList.usrType.get();
              if (paramArrayList.headVerify.has()) {
                localObject1 = paramArrayList.headVerify.get();
              }
              ((QQHeadInfo)localObject2).headVerify = ((String)localObject1);
              paramList2.add(localObject2);
            }
          }
          else if (QLog.isColorLevel())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("there is no headinfo uin=");
            paramArrayList.append(str);
            QLog.d("headqcall", 2, paramArrayList.toString());
          }
        }
      }
    }
  }
  
  private void a(long paramLong, int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      ToServiceMsg localToServiceMsg = createToServiceMsg("AvatarInfoSvr.QQHeadUrlReq", null);
      Object localObject = new ArrayList();
      int m = 0;
      while (m < paramArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(m);
        ((ArrayList)localObject).add(localQQHeadDetails.a());
        a(0, localQQHeadDetails.b, localQQHeadDetails.a, 1);
        m += 1;
      }
      localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
      localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
      paramArrayList = new QQHeadUrlReq(paramLong, (ArrayList)localObject, (byte)paramInt);
      localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("UTF-8");
      paramArrayList.writeTo((JceOutputStream)localObject);
      localToServiceMsg.extraData.putByteArray("QQHeadUrlReq", ((JceOutputStream)localObject).toByteArray());
      send(localToServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleGetQQHeadError, result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", uinListSize=");
    int m;
    if (localArrayList != null) {
      m = localArrayList.size();
    } else {
      m = -1;
    }
    localStringBuilder.append(m);
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      m = 0;
      while (m < localArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)localArrayList.get(m);
        int n = paramToServiceMsg.extraData.getInt("idType", 0);
        Object localObject = AvatarUtil.a(localQQHeadDetails.a, localQQHeadDetails.b, n, 0);
        a((String)localObject, true);
        a(9201, (String)localObject, localQQHeadDetails.a, 2, 0, null, paramInt, 0L);
        localStringBuilder.append("; uin=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", timestamp=");
        localStringBuilder.append(localQQHeadDetails.c);
        localObject = (IQQClassicAvatarService)this.a.getRuntimeService(IQQClassicAvatarService.class, "");
        if ((localObject != null) && (((IQQClassicAvatarService)localObject).isClassicHeadActivityActivate())) {
          ((IQQClassicAvatarService)localObject).handleGetHeadError(localQQHeadDetails.b);
        }
        m += 1;
      }
      QLog.i("AvatarHandler", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("AvatarHandler", 1, localStringBuilder.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, QQHeadUrlResp paramQQHeadUrlResp)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000) && (paramQQHeadUrlResp != null) && (paramQQHeadUrlResp.result == 0) && (paramQQHeadUrlResp.UserHeadInfoList != null))
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      Object localObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        paramToServiceMsg = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        for (;;)
        {
          if (!paramFromServiceMsg.hasNext()) {
            break label196;
          }
          localObject = (QQHeadDetails)paramFromServiceMsg.next();
          Iterator localIterator = paramQQHeadUrlResp.UserHeadInfoList.iterator();
          if (localIterator.hasNext())
          {
            QQHeadInfo localQQHeadInfo = (QQHeadInfo)localIterator.next();
            if (((localQQHeadInfo.dstUsrType == 11) || (!((QQHeadDetails)localObject).b.equals(Long.toString(localQQHeadInfo.uin)))) && ((localQQHeadInfo.dstUsrType != 11) || (!((QQHeadDetails)localObject).b.equals(localQQHeadInfo.phoneNum)))) {
              break;
            }
            localQQHeadInfo.headLevel = ((QQHeadDetails)localObject).d;
            paramToServiceMsg.add(localQQHeadInfo);
          }
        }
        label196:
        paramQQHeadUrlResp.UserHeadInfoList = paramToServiceMsg;
      }
      f();
      paramToServiceMsg = new StringBuilder("handleQQHead handleResp for QQHeadInfo");
      m = 0;
      while (m < paramQQHeadUrlResp.UserHeadInfoList.size())
      {
        paramFromServiceMsg = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(m);
        a(0, a(paramFromServiceMsg.dstUsrType, paramFromServiceMsg.uin, paramFromServiceMsg.phoneNum), paramFromServiceMsg.dstUsrType, 2);
        paramToServiceMsg.append(" qqHeadUrlResp id=");
        paramToServiceMsg.append(m);
        paramToServiceMsg.append(" QQHeadInfo.uin=");
        paramToServiceMsg.append(StringUtil.getSimpleUinForPrint(Long.toString(paramFromServiceMsg.uin)));
        paramToServiceMsg.append(" QQHeadInfo.systemId=");
        paramToServiceMsg.append(paramFromServiceMsg.systemHeadID);
        paramToServiceMsg.append("  QQHeadInfo.headtype=");
        paramToServiceMsg.append(paramFromServiceMsg.cHeadType);
        paramToServiceMsg.append("|");
        localObject = new FaceInfo();
        ((FaceInfo)localObject).p = paramFromServiceMsg;
        this.g.addDownloadRequest((FaceInfo)localObject);
        m += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    int m = 65535;
    if (paramQQHeadUrlResp != null) {
      m = paramQQHeadUrlResp.result;
    } else if (paramFromServiceMsg != null) {
      m = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, m);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleQQHead handleResp for QQHeadInfo appear error and error code =");
      paramToServiceMsg.append(m);
      QLog.d("AvatarHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localStringBuilder2 = null;
    Object localObject = localStringBuilder2;
    if (paramFromServiceMsg != null) {
      localObject = localStringBuilder2;
    }
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject = localStringBuilder2;
        if (paramObject != null)
        {
          localObject = new QQHeadUrl.QQHeadUrlRsp();
          ((QQHeadUrl.QQHeadUrlRsp)localObject).mergeFrom((byte[])paramObject);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m;
        byte b1;
        StringBuilder localStringBuilder1 = localStringBuilder2;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("handleQQHead_New qqHeadUrlResp=");
      localStringBuilder2.append(localObject);
      localStringBuilder2.append(" qqHeadUrlRespData = ");
      localStringBuilder2.append(paramObject);
      QLog.d("AvatarHandler", 2, localStringBuilder2.toString());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000) && (localObject != null) && (((QQHeadUrl.QQHeadUrlRsp)localObject).result.get() == 0))
    {
      m = ((QQHeadUrl.QQHeadUrlRsp)localObject).dstUsrType.get();
      if (m == 8) {
        m = 4;
      }
      b1 = (byte)((QQHeadUrl.QQHeadUrlRsp)localObject).dstEncryptType.get();
      paramObject = new ArrayList();
      paramFromServiceMsg = new ArrayList();
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      a((byte)m, b1, (QQHeadUrl.QQHeadUrlRsp)localObject, paramToServiceMsg, paramFromServiceMsg, paramObject);
      a(paramObject, false);
      a(m, 0, paramFromServiceMsg);
      if ((paramFromServiceMsg.size() > 0) && ((m == 1) || (m == 32)))
      {
        paramToServiceMsg = new ArrayList(paramFromServiceMsg.size());
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext()) {
          paramToServiceMsg.add(((QQHeadDetails)paramFromServiceMsg.next()).b);
        }
        notifyUI(6, true, new Object[] { Integer.valueOf(0), paramToServiceMsg });
      }
      return;
    }
    m = 65535;
    if (localObject != null) {
      m = ((QQHeadUrl.QQHeadUrlRsp)localObject).result.get();
    } else if (paramFromServiceMsg != null) {
      m = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, m);
    m = paramToServiceMsg.extraData.getInt("dstUsrType", 1);
    if ((m == 1) || (m == 32))
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      paramToServiceMsg = new ArrayList();
      if ((paramFromServiceMsg instanceof ArrayList))
      {
        paramFromServiceMsg = ((ArrayList)paramFromServiceMsg).iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = paramFromServiceMsg.next();
          if ((paramObject instanceof QQHeadDetails)) {
            paramToServiceMsg.add(((QQHeadDetails)paramObject).b);
          }
        }
      }
      notifyUI(6, false, new Object[] { Integer.valueOf(0), paramToServiceMsg });
    }
  }
  
  private void a(List<QQHeadInfo> paramList, boolean paramBoolean)
  {
    f();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadQQHead count = ");
    ((StringBuilder)localObject).append(paramList.size());
    QLog.i("Q.qqhead.", 1, ((StringBuilder)localObject).toString());
    int m = 0;
    while (m < paramList.size())
    {
      QQHeadInfo localQQHeadInfo = (QQHeadInfo)paramList.get(m);
      a(0, a(localQQHeadInfo.uin, localQQHeadInfo.phoneNum), localQQHeadInfo.dstUsrType, 2);
      FaceInfo localFaceInfo = new FaceInfo();
      if (paramBoolean) {
        localObject = localQQHeadInfo.phoneNum;
      } else {
        localObject = String.valueOf(localQQHeadInfo.uin);
      }
      localFaceInfo.c = ((String)localObject);
      localFaceInfo.d = localQQHeadInfo.idType;
      localFaceInfo.b = localQQHeadInfo.dstUsrType;
      localFaceInfo.j = localQQHeadInfo.sizeType;
      localFaceInfo.p = localQQHeadInfo;
      localFaceInfo.e = AvatarImplUtil.a(AvatarImplUtil.b(localFaceInfo.j), AvatarImplUtil.c(localFaceInfo.j));
      this.g.addDownloadRequest(localFaceInfo);
      m += 1;
    }
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, int paramInt3, boolean paramBoolean)
  {
    label640:
    for (;;)
    {
      int m;
      try
      {
        if (QLog.isColorLevel())
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getQQHead, uin=");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(",headType=");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(",idType=");
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append(",level=");
          ((StringBuilder)localObject1).append(paramByte1);
          ((StringBuilder)localObject1).append(",faceFileType=");
          ((StringBuilder)localObject1).append(paramByte2);
          QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
          if (!TextUtils.isEmpty(paramString))
          {
            paramBoolean = true;
            if ((paramInt1 != 1) || (StringUtil.isValideUin(paramString)))
            {
              localObject1 = AvatarUtil.a(paramInt1, paramString, paramInt2, paramInt3);
              if (!e((String)localObject1))
              {
                if (QLog.isColorLevel())
                {
                  paramString = new StringBuilder();
                  paramString.append("markDownloadedQQHead, noNeedDownload= ");
                  paramString.append((String)localObject1);
                  QLog.d("AvatarHandler", 2, paramString.toString());
                }
                return;
              }
              a((String)localObject1, false);
              boolean bool = ((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isInRealActionLoginB();
              if (!QLog.isColorLevel()) {
                break label622;
              }
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("markDownloadedQQHead end keyStr = ");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(",isImmediatelyGet=");
              ((StringBuilder)localObject2).append(this.k);
              ((StringBuilder)localObject2).append(",InActionLoginB=");
              ((StringBuilder)localObject2).append(bool);
              QLog.d("AvatarHandler", 2, ((StringBuilder)localObject2).toString());
              break label622;
              this.c += 1;
              localObject2 = (ArrayList)this.d.get(Integer.valueOf(m));
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = new ArrayList();
                this.d.put(Integer.valueOf(m), localObject2);
                localObject1 = localObject2;
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("FaceConstant.HeadType.QQHEAD_TYPE_QCALL destQQHeadInfoTable.put(keyType, destQQHeadInfoList); keyType = ");
                  ((StringBuilder)localObject1).append(m);
                  ((StringBuilder)localObject1).append("destQQHeadInfoTable.size = ");
                  ((StringBuilder)localObject1).append(this.d.size());
                  QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
                  localObject1 = localObject2;
                }
              }
              if (paramByte2 != 1)
              {
                if (paramByte2 == 2) {
                  break label640;
                }
                paramBoolean = ((IQQAvatarDataService)this.a.getRuntimeService(IQQAvatarDataService.class, "")).isFaceFileExist(paramInt1, paramString, paramInt2, paramInt3);
              }
              long l2 = 0L;
              long l1 = l2;
              if (paramBoolean)
              {
                localObject2 = ((IQQAvatarDataService)this.a.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(paramInt1, paramString, paramInt2);
                l1 = l2;
                if (localObject2 != null)
                {
                  l1 = l2;
                  if (((Pair)localObject2).second != null) {
                    l1 = ((Setting)((Pair)localObject2).second).headImgTimestamp;
                  }
                }
              }
              ((ArrayList)localObject1).add(new QQHeadDetails(paramInt1, paramString, l1, paramByte1, paramInt3));
              if ((!this.k) && (bool))
              {
                paramBoolean = TextUtils.equals(paramString, this.a.getAccount());
                if (!paramBoolean) {
                  return;
                }
              }
              e();
              return;
            }
          }
          return;
        }
      }
      finally {}
      continue;
      label622:
      if (paramInt1 == 32)
      {
        m = paramInt2;
      }
      else
      {
        m = paramInt1;
        continue;
        paramBoolean = false;
      }
    }
  }
  
  private void b(int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int m;
      if (paramInt != 202)
      {
        if (paramInt != 204) {
          m = 0;
        } else {
          m = 2;
        }
      }
      else {
        m = 1;
      }
      MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
      localMultiBusidUrlReq.srcUidType.set(0);
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.a.getAccount()));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(1));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(32));
      localMultiBusidUrlReq.dstUidType.set(m);
      int n = 0;
      while (n < paramArrayList.size())
      {
        Object localObject2 = (QQHeadDetails)paramArrayList.get(n);
        localObject1 = new MultiHeadUrl.ReqUsrInfo();
        if (m == 0) {}
        try
        {
          ((MultiHeadUrl.ReqUsrInfo)localObject1).dstUin.set(Long.parseLong(((QQHeadDetails)localObject2).b));
          break label205;
          if (m == 1) {
            ((MultiHeadUrl.ReqUsrInfo)localObject1).dstTid.set(Long.parseLong(((QQHeadDetails)localObject2).b));
          } else if (m == 2) {
            ((MultiHeadUrl.ReqUsrInfo)localObject1).dstOpenid.set(((QQHeadDetails)localObject2).b);
          }
          label205:
          a(0, ((QQHeadDetails)localObject2).b, ((QQHeadDetails)localObject2).a, 1);
          localMultiBusidUrlReq.dstUsrInfos.add((MessageMicro)localObject1);
          if (!QLog.isColorLevel()) {
            break label339;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" multiBusidUrlReq.dstUsrInfos reqUsrInfo.dstUin = ");
          ((StringBuilder)localObject2).append(((MultiHeadUrl.ReqUsrInfo)localObject1).dstUin);
          ((StringBuilder)localObject2).append(" ,reqUsrInfo.dstTid = ");
          ((StringBuilder)localObject2).append(((MultiHeadUrl.ReqUsrInfo)localObject1).dstTid);
          ((StringBuilder)localObject2).append(" ,reqUsrInfo.dstOpenid = ");
          ((StringBuilder)localObject2).append(((MultiHeadUrl.ReqUsrInfo)localObject1).dstOpenid);
          QLog.i("multiBusidUrlReq.dstUsrInfos", 2, ((StringBuilder)localObject2).toString());
        }
        catch (Exception localException)
        {
          label321:
          break label321;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ERROR", 2, ((Exception)localObject1).getMessage());
        }
        label339:
        n += 1;
      }
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("connum", String.valueOf(paramArrayList.size()));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getAccount(), "actNearbyHeadConNum", true, 0L, 0L, (HashMap)localObject1, "");
      localObject1 = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
      ((ToServiceMsg)localObject1).extraData.putParcelableArrayList("uinList", paramArrayList);
      ((ToServiceMsg)localObject1).extraData.putLong("startTime", System.currentTimeMillis());
      ((ToServiceMsg)localObject1).extraData.putInt("idType", paramInt);
      ((ToServiceMsg)localObject1).putWupBuffer(localMultiBusidUrlReq.toByteArray());
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("realGetQQHead_Stranger .  idType = ");
        paramArrayList.append(paramInt);
        QLog.i("AvatarHandler", 2, paramArrayList.toString());
      }
      sendPbReq((ToServiceMsg)localObject1);
    }
    else
    {
      return;
    }
  }
  
  private void b(long paramLong, int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int m = paramInt;
      if (paramInt == 4) {
        m = 8;
      }
      ToServiceMsg localToServiceMsg = createToServiceMsg("IncreaseURLSvr.QQHeadUrlReq", null);
      QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
      localQQHeadUrlReq.srcUsrType.set(1);
      localQQHeadUrlReq.srcUin.set(Long.parseLong(this.a.getAccount()));
      localQQHeadUrlReq.dstUsrType.set(m);
      paramInt = 0;
      while (paramInt < paramArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(paramInt);
        QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
        try
        {
          localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.b));
          a(0, localQQHeadDetails.b, localQQHeadDetails.a, 1);
          localReqUsrInfo.timestamp.set((int)localQQHeadDetails.c);
          localQQHeadUrlReq.dstUsrInfos.add(localReqUsrInfo);
        }
        catch (Exception localException)
        {
          label169:
          break label169;
        }
        paramInt += 1;
      }
      localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
      localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
      localToServiceMsg.extraData.putInt("dstUsrType", m);
      localToServiceMsg.putWupBuffer(localQQHeadUrlReq.toByteArray());
      sendPbReq(localToServiceMsg);
    }
    else
    {
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarHandler", 2, "handleQQHead_QCall ....");
    }
    ArrayList localArrayList1 = null;
    Object localObject = localArrayList1;
    if (paramFromServiceMsg != null)
    {
      localObject = localArrayList1;
      try
      {
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          localObject = localArrayList1;
          if (paramObject != null)
          {
            localObject = new MultiHeadUrl.MultiBusidUrlRsp();
            ((MultiHeadUrl.MultiBusidUrlRsp)localObject).mergeFrom((byte[])paramObject);
          }
        }
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception...");
          ((StringBuilder)localObject).append(paramObject.getMessage());
          QLog.d("AvatarHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject.printStackTrace();
        localObject = localArrayList1;
      }
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000) && (localObject != null) && (((MultiHeadUrl.MultiBusidUrlRsp)localObject).result.get() == 0))
    {
      paramFromServiceMsg = ((MultiHeadUrl.MultiBusidUrlRsp)localObject).dstUsrHeadInfos.get();
      paramObject = new ArrayList();
      localArrayList1 = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      ArrayList localArrayList2 = new ArrayList();
      ((MultiHeadUrl.MultiBusidUrlRsp)localObject).dstUidType.get();
      m = paramToServiceMsg.extraData.getInt("idType");
      a(m, paramFromServiceMsg, localArrayList1, paramObject, localArrayList2);
      a(localArrayList2, true);
      a(16, m, paramObject);
      return;
    }
    int m = 65535;
    if (localObject != null) {
      m = ((MultiHeadUrl.MultiBusidUrlRsp)localObject).result.get();
    } else if (paramFromServiceMsg != null) {
      m = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, m);
  }
  
  private void c(long paramLong, int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new ArrayList();
      if (paramArrayList != null)
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject).add(((QQHeadDetails)localIterator.next()).b);
        }
      }
      QLog.d("AvatarHandler", 2, String.format("realGetQQHead_Apollo selfUin=%s headType=%s uinList=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Arrays.toString(((List)localObject).toArray()) }));
    }
    Object localObject = a(paramArrayList);
    if (localObject != null)
    {
      localObject = makeOIDBPkg("OidbSvc.0xedb", 3803, 0, ((oidb_0xedb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putParcelableArrayList("key_request_list", paramArrayList);
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarHandler", 2, "handleQQHead_Stranger ....");
    }
    ArrayList localArrayList1 = null;
    Object localObject = localArrayList1;
    if (paramFromServiceMsg != null)
    {
      localObject = localArrayList1;
      try
      {
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          localObject = localArrayList1;
          if (paramObject != null)
          {
            localObject = new MultiHeadUrl.MultiBusidUrlRsp();
            ((MultiHeadUrl.MultiBusidUrlRsp)localObject).mergeFrom((byte[])paramObject);
          }
        }
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception...");
          ((StringBuilder)localObject).append(paramObject.getMessage());
          QLog.d("AvatarHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject.printStackTrace();
        localObject = localArrayList1;
      }
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000) && (localObject != null) && (((MultiHeadUrl.MultiBusidUrlRsp)localObject).result.get() == 0))
    {
      paramFromServiceMsg = ((MultiHeadUrl.MultiBusidUrlRsp)localObject).dstUsrHeadInfos.get();
      paramObject = new ArrayList();
      localArrayList1 = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      ArrayList localArrayList2 = new ArrayList();
      m = ((MultiHeadUrl.MultiBusidUrlRsp)localObject).dstUidType.get();
      int n = paramToServiceMsg.extraData.getInt("idType");
      a(n, m, paramFromServiceMsg, localArrayList1, paramObject, localArrayList2);
      a(localArrayList2, true);
      a(32, n, paramObject);
      return;
    }
    int m = 65535;
    if (localObject != null) {
      m = ((MultiHeadUrl.MultiBusidUrlRsp)localObject).result.get();
    } else if (paramFromServiceMsg != null) {
      m = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, m);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramToServiceMsg.extraData.getParcelableArrayList("key_request_list");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (localObject2 != null)) {}
    for (;;)
    {
      byte b1;
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label665;
        }
        m = 1;
        if (m != 0)
        {
          paramFromServiceMsg = new oidb_0xedb.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramObject = new HashMap();
          Object localObject3;
          if (paramFromServiceMsg.dstHeadInfos.has())
          {
            paramToServiceMsg = paramFromServiceMsg.dstHeadInfos.get().iterator();
            if (paramToServiceMsg.hasNext())
            {
              paramFromServiceMsg = (oidb_0xedb.RspHeadInfo)paramToServiceMsg.next();
              b1 = (byte)paramFromServiceMsg.faceType.get();
              byte b2 = (byte)paramFromServiceMsg.faceFlag.get();
              localObject3 = new QQHeadInfo();
              ((QQHeadInfo)localObject3).uin = paramFromServiceMsg.dstUin.get();
              ((QQHeadInfo)localObject3).dwTimestamp = paramFromServiceMsg.timestamp.get();
              ((QQHeadInfo)localObject3).cHeadType = b1;
              ((QQHeadInfo)localObject3).dstUsrType = 116;
              ((QQHeadInfo)localObject3).dwFaceFlgas = b2;
              ((QQHeadInfo)localObject3).downLoadUrl = paramFromServiceMsg.url.get();
              paramObject.put(String.valueOf(((QQHeadInfo)localObject3).uin), localObject3);
              continue;
            }
          }
          paramToServiceMsg = new ArrayList();
          paramFromServiceMsg = new ArrayList();
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (QQHeadDetails)((Iterator)localObject2).next();
            if (!paramObject.containsKey(((QQHeadDetails)localObject3).b))
            {
              paramToServiceMsg.add(localObject3);
              continue;
            }
            QQHeadInfo localQQHeadInfo = (QQHeadInfo)paramObject.get(((QQHeadDetails)localObject3).b);
            localQQHeadInfo.headLevel = ((QQHeadDetails)localObject3).d;
            localQQHeadInfo.sizeType = ((QQHeadDetails)localObject3).e;
            localQQHeadInfo.idType = 200;
            paramFromServiceMsg.add(localQQHeadInfo);
            continue;
          }
          bool = true;
          paramObject = paramToServiceMsg;
          paramToServiceMsg = paramFromServiceMsg;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("AvatarHandler", 1, "handleGetApolloHead fail.", paramToServiceMsg);
      }
      boolean bool = false;
      paramToServiceMsg = localArrayList;
      paramObject = localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, String.format("handleGetApolloHead success=%s noChangeSize=%s changeSize=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramObject.size()), Integer.valueOf(paramToServiceMsg.size()) }));
      }
      if (bool)
      {
        a(paramToServiceMsg, false);
        a(116, 200, paramObject);
      }
      paramFromServiceMsg = paramObject.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        localObject1 = (QQHeadDetails)paramFromServiceMsg.next();
        paramObject = ((QQHeadDetails)localObject1).b;
        localObject1 = (Setting)((IQQAvatarDataService)this.a.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(((QQHeadDetails)localObject1).a, ((QQHeadDetails)localObject1).b, 200).second;
        if (localObject1 != null) {
          b1 = ((Setting)localObject1).bHeadType;
        } else {
          b1 = 0;
        }
        notifyUI(7, bool, new Object[] { paramObject, Byte.valueOf(b1) });
      }
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramFromServiceMsg = (QQHeadInfo)paramToServiceMsg.next();
        notifyUI(7, bool, new Object[] { String.valueOf(paramFromServiceMsg.uin), Byte.valueOf(paramFromServiceMsg.cHeadType) });
      }
      return;
      label665:
      int m = 0;
    }
  }
  
  private void e()
  {
    try
    {
      this.b.removeMessages(0);
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, "doExecuteGetQQHead start !!! ");
      }
      if (this.c > 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("doExecuteGetQQHead destQQHeadInfoCount = ");
          ((StringBuilder)localObject1).append(this.c);
          QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = this.a.getAccount();
        if (localObject1 == null) {}
      }
    }
    finally
    {
      Object localObject1;
      long l;
      label103:
      Object localObject3;
      Enumeration localEnumeration;
      for (;;)
      {
        throw localObject2;
      }
    }
    try
    {
      l = Long.valueOf((String)localObject1).longValue();
    }
    catch (Exception localException)
    {
      break label103;
    }
    l = -1L;
    if (l == -1L)
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doExecuteGetQQHead|myUin error: myUin=");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.d("AvatarHandler", 2, ((StringBuilder)localObject3).toString());
      }
      return;
    }
    localEnumeration = this.d.keys();
    while (localEnumeration.hasMoreElements())
    {
      int m = ((Integer)localEnumeration.nextElement()).intValue();
      Object localObject4 = (List)this.d.get(Integer.valueOf(m));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("em.hasMoreElements() QQHeadDetails head_or_id = ");
        ((StringBuilder)localObject1).append(m);
        QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder("doExecuteGetQQHead sendRequests for QQHeadInfo head_or_id=");
        ((StringBuilder)localObject1).append(m);
        localObject3 = ((List)localObject4).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          QQHeadDetails localQQHeadDetails = (QQHeadDetails)((Iterator)localObject3).next();
          ((StringBuilder)localObject1).append(" QQheadDetail uinOrMobile=");
          ((StringBuilder)localObject1).append(StringUtil.getSimpleUinForPrint(localQQHeadDetails.b));
          ((StringBuilder)localObject1).append(",Timestamp=");
          ((StringBuilder)localObject1).append(localQQHeadDetails.c);
          ((StringBuilder)localObject1).append("|");
        }
        ((StringBuilder)localObject1).append(" QQHeadDetailList length = ");
        ((StringBuilder)localObject1).append(((List)localObject4).size());
        QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
      }
      localObject3 = null;
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = localObject3;
        if (!((List)localObject4).isEmpty()) {
          localObject1 = AvatarImplUtil.a((List)localObject4, 50);
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = new ArrayList((List)((Iterator)localObject1).next());
          if (m == 11)
          {
            a(l, m, (ArrayList)localObject3);
          }
          else if (m == 116)
          {
            c(l, m, (ArrayList)localObject3);
          }
          else if (m >= 200)
          {
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("realGetQQHead_Stranger = ");
              ((StringBuilder)localObject4).append(m);
              QLog.d("AvatarHandler", 2, ((StringBuilder)localObject4).toString());
            }
            b(m, (ArrayList)localObject3);
          }
          else if (m == 16)
          {
            a(m, (ArrayList)localObject3);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("FaceConstant.HeadType.QQHEAD_TYPE_QCALL = ");
              ((StringBuilder)localObject3).append(m);
              QLog.d("AvatarHandler", 2, ((StringBuilder)localObject3).toString());
            }
          }
          else
          {
            b(l, m, (ArrayList)localObject3);
          }
        }
      }
    }
    this.c = 0;
    this.d.clear();
  }
  
  private void f()
  {
    if (this.g == null) {
      synchronized (this.h)
      {
        if (this.g == null) {
          this.g = new QQHeadDownloadHandler(this.a, this);
        }
        return;
      }
    }
  }
  
  public String a(int paramInt, long paramLong, String paramString)
  {
    if (paramInt == 11) {
      return paramString;
    }
    return Long.toString(paramLong);
  }
  
  public String a(long paramLong, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return String.valueOf(paramLong);
  }
  
  protected void a()
  {
    this.b = new AvatarHandler.1(this, this.a.getApplication().getMainLooper());
  }
  
  public void a(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.qqhead.changed");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("faceType", paramInt);
    this.a.getApplication().sendBroadcast(localIntent);
    QLog.d("AvatarHandler", 1, String.format("sendBroadCastHeadChanged faceType=%d uin=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramString, paramInt2, paramInt3, 0, null, 0, 0L);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, long paramLong)
  {
    boolean bool;
    if (paramInt1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    QQHeadStat localQQHeadStat = null;
    long l1 = 0L;
    if (paramLong == 0L) {
      paramLong = System.currentTimeMillis();
    }
    if (paramInt3 == 1)
    {
      if (this.i.containsKey(paramString1)) {
        this.i.remove(paramString1);
      }
      localQQHeadStat = new QQHeadStat();
      localQQHeadStat.a = paramLong;
      localQQHeadStat.h = paramInt2;
      this.i.put(paramString1, localQQHeadStat);
    }
    else if (this.i.containsKey(paramString1))
    {
      localQQHeadStat = (QQHeadStat)this.i.get(paramString1);
      if (localQQHeadStat == null) {
        return;
      }
      if (paramInt3 != 2)
      {
        if (paramInt3 != 3)
        {
          if (paramInt3 == 4)
          {
            localQQHeadStat.d = paramLong;
            localQQHeadStat.e = paramInt4;
            localQQHeadStat.f = paramString2;
            localQQHeadStat.g = (localQQHeadStat.d - localQQHeadStat.a);
            this.i.remove(paramString1);
          }
        }
        else {
          localQQHeadStat.c = paramLong;
        }
      }
      else
      {
        localQQHeadStat.b = paramLong;
        if (!bool) {
          this.i.remove(paramString1);
        }
        localQQHeadStat.g = (localQQHeadStat.b - localQQHeadStat.a);
      }
    }
    if (((!bool) || (paramInt3 == 4)) && (localQQHeadStat != null))
    {
      long l2 = localQQHeadStat.b - localQQHeadStat.a;
      paramLong = l1;
      if (localQQHeadStat.c > localQQHeadStat.b)
      {
        paramLong = l1;
        if (localQQHeadStat.b > 0L) {
          paramLong = localQQHeadStat.c - localQQHeadStat.b;
        }
      }
      l1 = localQQHeadStat.d - localQQHeadStat.c;
      if ((!QLog.isColorLevel()) && ((!bool) || (paramInt3 != 4) || (localQQHeadStat.g <= 3000L))) {
        break label607;
      }
      paramString2 = new StringBuffer(200);
      paramString2.append("===QQHeadStat resultCode=");
      paramString2.append(paramInt1);
      paramString2.append(", uin=");
      paramInt3 = 1;
      paramString2.append(String.format("%11s", new Object[] { paramString1 }));
      paramString2.append(", totalTime=");
      paramString2.append(String.format("%-5s", new Object[] { Long.valueOf(localQQHeadStat.g) }));
      paramString2.append(", picSize=");
      paramString2.append(String.format("%-6s", new Object[] { Integer.valueOf(localQQHeadStat.e) }));
      paramString2.append(", downInfoTime=");
      paramString2.append(l2);
      paramString2.append(", intervalTime=");
      paramString2.append(paramLong);
      paramString2.append(", downPicTime=");
      paramString2.append(l1);
      paramString2.append(", reasonCode=");
      paramString2.append(paramInt5);
      paramString2.append(", downUrl=");
      paramString2.append(localQQHeadStat.f);
      if (QLog.isColorLevel()) {
        paramInt3 = 2;
      }
      QLog.d("QQHeadCostTime", paramInt3, paramString2.toString());
      label607:
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramString2 = new HashMap();
        paramString2.put("qqhead_uin", paramString1);
        paramString2.put("downInfo_time", String.valueOf(l2));
        paramString2.put("interval_time", String.valueOf(paramLong));
        paramString2.put("downPic_time", String.valueOf(l1));
        paramString2.put("downPic_size", String.valueOf(localQQHeadStat.e));
        paramString2.put("download_url", localQQHeadStat.f);
        paramString2.put("param_FailCode", Integer.toString(paramInt1));
        paramString2.put("fail_reason", Integer.toString(paramInt5));
        paramString2.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().c()));
        paramString1 = AvatarImplUtil.d(paramInt2);
        if (!TextUtils.isEmpty(paramString1)) {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getAccount(), paramString1, bool, localQQHeadStat.g, localQQHeadStat.e, paramString2, "");
        }
        paramString1 = AvatarImplUtil.e(paramInt2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getAccount(), paramString1, bool, localQQHeadStat.g, localQQHeadStat.e, paramString2, "");
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    a(1, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void a(String paramString, byte paramByte)
  {
    a(4, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void a(String paramString, byte paramByte1, byte paramByte2)
  {
    a(1, paramString, 0, paramByte1, paramByte2, false);
  }
  
  public void a(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarHandler", 2, String.format("getApolloHead(2) uin=%s sizeType=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    a(116, paramString, 200, paramByte1, paramByte2, paramInt, false);
  }
  
  public void a(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    a(32, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("markDownloadedQQHead, uinOrMobile= ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",isRemove=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("downloadSize=");
      ((StringBuilder)localObject1).append(this.e.size());
      QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject1 = this.f;
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        this.e.remove(paramString);
        continue;
        if (this.e.size() > 30)
        {
          long l = System.currentTimeMillis();
          ArrayList localArrayList = new ArrayList();
          Object localObject2 = this.e.keys();
          if (!((Enumeration)localObject2).hasMoreElements()) {
            break label287;
          }
          String str = (String)((Enumeration)localObject2).nextElement();
          if (Math.abs(l - ((Long)this.e.get(str)).longValue()) <= 60000L) {
            continue;
          }
          localArrayList.add(str);
          continue;
          if (m < localArrayList.size())
          {
            localObject2 = (String)localArrayList.get(m);
            this.e.remove(localObject2);
            a(9205, (String)localObject2, -1, 4);
            m += 1;
            continue;
          }
        }
        this.e.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
      finally {}
      return;
      label287:
      int m = 0;
    }
  }
  
  public void b()
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.what = 0;
    this.b.sendMessage(localMessage);
  }
  
  public void b(String paramString)
  {
    a(4, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void b(String paramString, byte paramByte)
  {
    a(11, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void b(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQCallHead FaceConstant.HeadType.QQHEAD_TYPE_QCALL uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" idType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", level =  faceFileType = ");
      localStringBuilder.append(paramByte2);
      QLog.d("AvatarHandler", 2, localStringBuilder.toString());
    }
    a(16, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public String c()
  {
    f();
    return this.g.getChoosedIP();
  }
  
  public void c(String paramString)
  {
    a(11, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public String d()
  {
    f();
    return this.g.getChoosedStrangerGroupIp();
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarHandler", 2, String.format("getApolloHead(1) uin=%s", new Object[] { paramString }));
    }
    a(116, paramString, 200, (byte)1, (byte)0, FaceConstant.Apollo.FACE_DEFAULT_SIZE_SPEC, false);
  }
  
  public boolean e(String paramString)
  {
    for (;;)
    {
      synchronized (this.f)
      {
        bool1 = this.e.containsKey(paramString);
        m = -1;
        if (!bool1) {
          break label298;
        }
        long l = ((Long)this.e.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.e.remove(paramString);
          a(9205, paramString, -1, 4);
          bool1 = true;
          m = 0;
          boolean bool2 = bool1;
          if (bool1)
          {
            boolean bool3 = SystemUtil.a();
            if (((bool3) && (SystemUtil.b() < 2048L)) || ((!bool3) && (SystemUtil.c() < 102400L)))
            {
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("getQQHead|fail, storage is not enough. uinOrMobile=");
                ((StringBuilder)???).append(paramString);
                ((StringBuilder)???).append(", isExistSDCard=");
                ((StringBuilder)???).append(bool3);
                QLog.d("AvatarHandler", 2, ((StringBuilder)???).toString());
              }
              bool2 = false;
            }
            else
            {
              bool2 = bool1;
              if (!bool3)
              {
                bool2 = bool1;
                if (!this.j)
                {
                  this.j = true;
                  AvatarImplUtil.a(this.a.getApplication(), true);
                  bool2 = bool1;
                }
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("markDownloadedQQHead, whatIf= ");
            paramString.append(m);
            paramString.append(", NeedDownload=");
            paramString.append(bool2);
            QLog.d("AvatarHandler", 2, paramString.toString());
          }
          return bool2;
        }
      }
      boolean bool1 = false;
      int m = 1;
      continue;
      label298:
      bool1 = true;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("AvatarInfoSvr.QQHeadUrlReq");
      this.allowCmdSet.add("IncreaseURLSvr.QQHeadUrlReq");
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
      this.allowCmdSet.add("OidbSvc.0xedb");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return AvatarObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQHeadDownloadHandler localQQHeadDownloadHandler = this.g;
    if (localQQHeadDownloadHandler != null) {
      localQQHeadDownloadHandler.close();
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("AvatarHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("AvatarInfoSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, (QQHeadUrlResp)paramObject);
      return;
    }
    if ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramToServiceMsg.extraData.getInt("qqHeadType") == 16)
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xedb".equals(paramFromServiceMsg.getServiceCmd())) {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.handler.AvatarHandler
 * JD-Core Version:    0.7.0.1
 */