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
  private int jdField_a_of_type_Int = 0;
  public AppInterface a;
  private QQHeadDownloadHandler jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Hashtable<Integer, ArrayList<QQHeadDetails>> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Hashtable<String, Long> jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_b_of_type_Boolean = false;
  private Hashtable<String, QQHeadStat> c = new Hashtable();
  
  protected AvatarHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
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
        long l = Long.parseLong(((QQHeadDetails)localObject).jdField_a_of_type_JavaLangString);
        int i = (int)((QQHeadDetails)localObject).jdField_a_of_type_Long;
        localObject = new oidb_0xedb.ReqUsrInfo();
        ((oidb_0xedb.ReqUsrInfo)localObject).dstUin.set(l);
        ((oidb_0xedb.ReqUsrInfo)localObject).timestamp.set(i);
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
        int j = 0;
        Object localObject = localList.iterator();
        QQHeadUrl.RspHeadInfo localRspHeadInfo;
        do
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((Iterator)localObject).next();
          if (paramByte2 == 1) {
            paramQQHeadUrlRsp = localRspHeadInfo.dstUid.get();
          } else {
            paramQQHeadUrlRsp = String.valueOf(localRspHeadInfo.dstUin.get());
          }
        } while (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(paramQQHeadUrlRsp));
        localObject = new QQHeadInfo();
        ((QQHeadInfo)localObject).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
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
        int i = 1;
        if (i == 0) {
          paramList.add(localQQHeadDetails);
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, List<QQHeadDetails> paramList)
  {
    EntityManager localEntityManager;
    EntityTransaction localEntityTransaction;
    int i;
    if (paramList.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, "handleQQHead_New noChangeQQHeadInfoList");
      }
      localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
      i = 0;
    }
    try
    {
      while (i < paramList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramList.get(i);
        Setting localSetting = (Setting)localEntityManager.find(Setting.class, AvatarUtil.a(paramInt1, localQQHeadDetails.jdField_a_of_type_JavaLangString, paramInt2));
        if (localSetting != null)
        {
          localSetting.updateTimestamp = System.currentTimeMillis();
          ((IQQAvatarDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).updateSettingTableCache(localSetting);
          localEntityManager.update(localSetting);
        }
        a(AvatarUtil.a(paramInt1, localQQHeadDetails.jdField_a_of_type_JavaLangString, paramInt2, localQQHeadDetails.jdField_b_of_type_Int), true);
        i += 1;
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
        int i = 1;
        if (paramInt2 == 0) {
          paramArrayList = String.valueOf(((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstUin.get());
        } else if (paramInt2 == 1) {
          paramArrayList = String.valueOf(((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstTid.get());
        } else {
          paramArrayList = ((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstOpenid.get();
        }
        if (localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(paramArrayList))
        {
          Object localObject4 = ((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstHeadInfos.get().iterator();
          Object localObject2 = null;
          localObject1 = null;
          Object localObject3;
          while (((Iterator)localObject4).hasNext())
          {
            localObject3 = (MultiHeadUrl.RspHeadInfo)((Iterator)localObject4).next();
            int j = ((MultiHeadUrl.RspHeadInfo)localObject3).usrType.get();
            if (j == 1) {
              localObject1 = localObject3;
            } else if ((j == 32) && (((MultiHeadUrl.RspHeadInfo)localObject3).faceType.get() != 0)) {
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
            localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
                    i = 0;
                    break label355;
                  }
                }
              }
              i = 1;
            }
            label355:
            if (i != 0)
            {
              localObject3 = new QQHeadInfo();
              ((QQHeadInfo)localObject3).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
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
            notifyUI(4, true, new Object[] { localQQHeadDetails.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt1), Boolean.valueOf(true) });
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
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(16));
      localMultiBusidUrlReq.dstUidType.set(0);
      int i = 0;
      while (i < paramArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(i);
        MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
        try
        {
          localReqUsrInfo.dstUin.set(AvatarImplUtil.a(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
          localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ERROR", 2, localException.getMessage());
          }
        }
        i += 1;
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
        if (localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(str))
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
            localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
                i = 1;
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
            int i = 0;
            if (i != 0)
            {
              localObject2 = new QQHeadInfo();
              ((QQHeadInfo)localObject2).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
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
      int i = 0;
      while (i < paramArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(i);
        ((ArrayList)localObject).add(localQQHeadDetails.a());
        a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
        i += 1;
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
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = -1;
    }
    localStringBuilder.append(i);
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      i = 0;
      while (i < localArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)localArrayList.get(i);
        int j = paramToServiceMsg.extraData.getInt("idType", 0);
        Object localObject = AvatarUtil.a(localQQHeadDetails.jdField_a_of_type_Int, localQQHeadDetails.jdField_a_of_type_JavaLangString, j, 0);
        a((String)localObject, true);
        a(9201, (String)localObject, localQQHeadDetails.jdField_a_of_type_Int, 2, 0, null, paramInt, 0L);
        localStringBuilder.append("; uin=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", timestamp=");
        localStringBuilder.append(localQQHeadDetails.jdField_a_of_type_Long);
        localObject = (IQQClassicAvatarService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQClassicAvatarService.class, "");
        if ((localObject != null) && (((IQQClassicAvatarService)localObject).isClassicHeadActivityActivate())) {
          ((IQQClassicAvatarService)localObject).handleGetHeadError(localQQHeadDetails.jdField_a_of_type_JavaLangString);
        }
        i += 1;
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
            if (((localQQHeadInfo.dstUsrType == 11) || (!((QQHeadDetails)localObject).jdField_a_of_type_JavaLangString.equals(Long.toString(localQQHeadInfo.uin)))) && ((localQQHeadInfo.dstUsrType != 11) || (!((QQHeadDetails)localObject).jdField_a_of_type_JavaLangString.equals(localQQHeadInfo.phoneNum)))) {
              break;
            }
            localQQHeadInfo.headLevel = ((QQHeadDetails)localObject).jdField_a_of_type_Byte;
            paramToServiceMsg.add(localQQHeadInfo);
          }
        }
        label196:
        paramQQHeadUrlResp.UserHeadInfoList = paramToServiceMsg;
      }
      d();
      paramToServiceMsg = new StringBuilder("handleQQHead handleResp for QQHeadInfo");
      i = 0;
      while (i < paramQQHeadUrlResp.UserHeadInfoList.size())
      {
        paramFromServiceMsg = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(i);
        a(0, a(paramFromServiceMsg.dstUsrType, paramFromServiceMsg.uin, paramFromServiceMsg.phoneNum), paramFromServiceMsg.dstUsrType, 2);
        paramToServiceMsg.append(" qqHeadUrlResp id=");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append(" QQHeadInfo.uin=");
        paramToServiceMsg.append(StringUtil.e(Long.toString(paramFromServiceMsg.uin)));
        paramToServiceMsg.append(" QQHeadInfo.systemId=");
        paramToServiceMsg.append(paramFromServiceMsg.systemHeadID);
        paramToServiceMsg.append("  QQHeadInfo.headtype=");
        paramToServiceMsg.append(paramFromServiceMsg.cHeadType);
        paramToServiceMsg.append("|");
        localObject = new FaceInfo();
        ((FaceInfo)localObject).jdField_a_of_type_AvatarInfoQQHeadInfo = paramFromServiceMsg;
        this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.addDownloadRequest((FaceInfo)localObject);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    int i = 65535;
    if (paramQQHeadUrlResp != null) {
      i = paramQQHeadUrlResp.result;
    } else if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, i);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleQQHead handleResp for QQHeadInfo appear error and error code =");
      paramToServiceMsg.append(i);
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
        int i;
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
      i = ((QQHeadUrl.QQHeadUrlRsp)localObject).dstUsrType.get();
      if (i == 8) {
        i = 4;
      }
      b1 = (byte)((QQHeadUrl.QQHeadUrlRsp)localObject).dstEncryptType.get();
      paramObject = new ArrayList();
      paramFromServiceMsg = new ArrayList();
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      a((byte)i, b1, (QQHeadUrl.QQHeadUrlRsp)localObject, paramToServiceMsg, paramFromServiceMsg, paramObject);
      a(paramObject, false);
      a(i, 0, paramFromServiceMsg);
      if ((paramFromServiceMsg.size() > 0) && ((i == 1) || (i == 32)))
      {
        paramToServiceMsg = new ArrayList(paramFromServiceMsg.size());
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext()) {
          paramToServiceMsg.add(((QQHeadDetails)paramFromServiceMsg.next()).jdField_a_of_type_JavaLangString);
        }
        notifyUI(6, true, new Object[] { Integer.valueOf(0), paramToServiceMsg });
      }
      return;
    }
    i = 65535;
    if (localObject != null) {
      i = ((QQHeadUrl.QQHeadUrlRsp)localObject).result.get();
    } else if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, i);
    i = paramToServiceMsg.extraData.getInt("dstUsrType", 1);
    if ((i == 1) || (i == 32))
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
            paramToServiceMsg.add(((QQHeadDetails)paramObject).jdField_a_of_type_JavaLangString);
          }
        }
      }
      notifyUI(6, false, new Object[] { Integer.valueOf(0), paramToServiceMsg });
    }
  }
  
  private void a(List<QQHeadInfo> paramList, boolean paramBoolean)
  {
    d();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadQQHead count = ");
    ((StringBuilder)localObject).append(paramList.size());
    QLog.i("Q.qqhead.", 1, ((StringBuilder)localObject).toString());
    int i = 0;
    while (i < paramList.size())
    {
      QQHeadInfo localQQHeadInfo = (QQHeadInfo)paramList.get(i);
      a(0, a(localQQHeadInfo.uin, localQQHeadInfo.phoneNum), localQQHeadInfo.dstUsrType, 2);
      FaceInfo localFaceInfo = new FaceInfo();
      if (paramBoolean) {
        localObject = localQQHeadInfo.phoneNum;
      } else {
        localObject = String.valueOf(localQQHeadInfo.uin);
      }
      localFaceInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      localFaceInfo.jdField_b_of_type_Int = localQQHeadInfo.idType;
      localFaceInfo.jdField_a_of_type_Int = localQQHeadInfo.dstUsrType;
      localFaceInfo.d = localQQHeadInfo.sizeType;
      localFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo = localQQHeadInfo;
      localFaceInfo.c = AvatarImplUtil.a(AvatarImplUtil.a(localFaceInfo.d), AvatarImplUtil.b(localFaceInfo.d));
      this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.addDownloadRequest(localFaceInfo);
      i += 1;
    }
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, int paramInt3, boolean paramBoolean)
  {
    label640:
    for (;;)
    {
      int i;
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
            if ((paramInt1 != 1) || (StringUtil.c(paramString)))
            {
              localObject1 = AvatarUtil.a(paramInt1, paramString, paramInt2, paramInt3);
              if (!a((String)localObject1))
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
              ((StringBuilder)localObject2).append(this.jdField_b_of_type_Boolean);
              ((StringBuilder)localObject2).append(",InActionLoginB=");
              ((StringBuilder)localObject2).append(bool);
              QLog.d("AvatarHandler", 2, ((StringBuilder)localObject2).toString());
              break label622;
              this.jdField_a_of_type_Int += 1;
              localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i));
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = new ArrayList();
                this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(i), localObject2);
                localObject1 = localObject2;
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("FaceConstant.HeadType.QQHEAD_TYPE_QCALL destQQHeadInfoTable.put(keyType, destQQHeadInfoList); keyType = ");
                  ((StringBuilder)localObject1).append(i);
                  ((StringBuilder)localObject1).append("destQQHeadInfoTable.size = ");
                  ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilHashtable.size());
                  QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
                  localObject1 = localObject2;
                }
              }
              if (paramByte2 != 1)
              {
                if (paramByte2 == 2) {
                  break label640;
                }
                paramBoolean = ((IQQAvatarDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).isFaceFileExist(paramInt1, paramString, paramInt2, paramInt3);
              }
              long l2 = 0L;
              long l1 = l2;
              if (paramBoolean)
              {
                localObject2 = ((IQQAvatarDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(paramInt1, paramString, paramInt2);
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
              if ((!this.jdField_b_of_type_Boolean) && (bool))
              {
                paramBoolean = TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
                if (!paramBoolean) {
                  return;
                }
              }
              c();
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
        i = paramInt2;
      }
      else
      {
        i = paramInt1;
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
      int i;
      if (paramInt != 202)
      {
        if (paramInt != 204) {
          i = 0;
        } else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
      MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
      localMultiBusidUrlReq.srcUidType.set(0);
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(1));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(32));
      localMultiBusidUrlReq.dstUidType.set(i);
      int j = 0;
      while (j < paramArrayList.size())
      {
        Object localObject2 = (QQHeadDetails)paramArrayList.get(j);
        localObject1 = new MultiHeadUrl.ReqUsrInfo();
        if (i == 0) {}
        try
        {
          ((MultiHeadUrl.ReqUsrInfo)localObject1).dstUin.set(Long.parseLong(((QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString));
          break label205;
          if (i == 1) {
            ((MultiHeadUrl.ReqUsrInfo)localObject1).dstTid.set(Long.parseLong(((QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString));
          } else if (i == 2) {
            ((MultiHeadUrl.ReqUsrInfo)localObject1).dstOpenid.set(((QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString);
          }
          label205:
          a(0, ((QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString, ((QQHeadDetails)localObject2).jdField_a_of_type_Int, 1);
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
        j += 1;
      }
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("connum", String.valueOf(paramArrayList.size()));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "actNearbyHeadConNum", true, 0L, 0L, (HashMap)localObject1, "");
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
      int i = paramInt;
      if (paramInt == 4) {
        i = 8;
      }
      ToServiceMsg localToServiceMsg = createToServiceMsg("IncreaseURLSvr.QQHeadUrlReq", null);
      QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
      localQQHeadUrlReq.srcUsrType.set(1);
      localQQHeadUrlReq.srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
      localQQHeadUrlReq.dstUsrType.set(i);
      paramInt = 0;
      while (paramInt < paramArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(paramInt);
        QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
        try
        {
          localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
          localReqUsrInfo.timestamp.set((int)localQQHeadDetails.jdField_a_of_type_Long);
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
      localToServiceMsg.extraData.putInt("dstUsrType", i);
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
      i = paramToServiceMsg.extraData.getInt("idType");
      a(i, paramFromServiceMsg, localArrayList1, paramObject, localArrayList2);
      a(localArrayList2, true);
      a(16, i, paramObject);
      return;
    }
    int i = 65535;
    if (localObject != null) {
      i = ((MultiHeadUrl.MultiBusidUrlRsp)localObject).result.get();
    } else if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, i);
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, "doExecuteGetQQHead start !!! ");
      }
      if (this.jdField_a_of_type_Int > 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("doExecuteGetQQHead destQQHeadInfoCount = ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
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
    localEnumeration = this.jdField_a_of_type_JavaUtilHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      int i = ((Integer)localEnumeration.nextElement()).intValue();
      Object localObject4 = (List)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("em.hasMoreElements() QQHeadDetails head_or_id = ");
        ((StringBuilder)localObject1).append(i);
        QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder("doExecuteGetQQHead sendRequests for QQHeadInfo head_or_id=");
        ((StringBuilder)localObject1).append(i);
        localObject3 = ((List)localObject4).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          QQHeadDetails localQQHeadDetails = (QQHeadDetails)((Iterator)localObject3).next();
          ((StringBuilder)localObject1).append(" QQheadDetail uinOrMobile=");
          ((StringBuilder)localObject1).append(StringUtil.e(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          ((StringBuilder)localObject1).append(",Timestamp=");
          ((StringBuilder)localObject1).append(localQQHeadDetails.jdField_a_of_type_Long);
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
          if (i == 11)
          {
            a(l, i, (ArrayList)localObject3);
          }
          else if (i == 116)
          {
            c(l, i, (ArrayList)localObject3);
          }
          else if (i >= 200)
          {
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("realGetQQHead_Stranger = ");
              ((StringBuilder)localObject4).append(i);
              QLog.d("AvatarHandler", 2, ((StringBuilder)localObject4).toString());
            }
            b(i, (ArrayList)localObject3);
          }
          else if (i == 16)
          {
            a(i, (ArrayList)localObject3);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("FaceConstant.HeadType.QQHEAD_TYPE_QCALL = ");
              ((StringBuilder)localObject3).append(i);
              QLog.d("AvatarHandler", 2, ((StringBuilder)localObject3).toString());
            }
          }
          else
          {
            b(l, i, (ArrayList)localObject3);
          }
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashtable.clear();
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
          ((List)localObject).add(((QQHeadDetails)localIterator.next()).jdField_a_of_type_JavaLangString);
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
      i = ((MultiHeadUrl.MultiBusidUrlRsp)localObject).dstUidType.get();
      int j = paramToServiceMsg.extraData.getInt("idType");
      a(j, i, paramFromServiceMsg, localArrayList1, paramObject, localArrayList2);
      a(localArrayList2, true);
      a(32, j, paramObject);
      return;
    }
    int i = 65535;
    if (localObject != null) {
      i = ((MultiHeadUrl.MultiBusidUrlRsp)localObject).result.get();
    } else if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, i);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
        }
        return;
      }
    }
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
        i = 1;
        if (i != 0)
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
            if (!paramObject.containsKey(((QQHeadDetails)localObject3).jdField_a_of_type_JavaLangString))
            {
              paramToServiceMsg.add(localObject3);
              continue;
            }
            QQHeadInfo localQQHeadInfo = (QQHeadInfo)paramObject.get(((QQHeadDetails)localObject3).jdField_a_of_type_JavaLangString);
            localQQHeadInfo.headLevel = ((QQHeadDetails)localObject3).jdField_a_of_type_Byte;
            localQQHeadInfo.sizeType = ((QQHeadDetails)localObject3).jdField_b_of_type_Int;
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
        paramObject = ((QQHeadDetails)localObject1).jdField_a_of_type_JavaLangString;
        localObject1 = (Setting)((IQQAvatarDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(((QQHeadDetails)localObject1).jdField_a_of_type_Int, ((QQHeadDetails)localObject1).jdField_a_of_type_JavaLangString, 200).second;
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
      int i = 0;
    }
  }
  
  public String a()
  {
    d();
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.getChoosedIP();
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
    this.jdField_a_of_type_MqqOsMqqHandler = new AvatarHandler.1(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getMainLooper());
  }
  
  public void a(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.qqhead.changed");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("faceType", paramInt);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().sendBroadcast(localIntent);
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
      if (this.c.containsKey(paramString1)) {
        this.c.remove(paramString1);
      }
      localQQHeadStat = new QQHeadStat();
      localQQHeadStat.jdField_a_of_type_Long = paramLong;
      localQQHeadStat.jdField_b_of_type_Int = paramInt2;
      this.c.put(paramString1, localQQHeadStat);
    }
    else if (this.c.containsKey(paramString1))
    {
      localQQHeadStat = (QQHeadStat)this.c.get(paramString1);
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
            localQQHeadStat.jdField_a_of_type_Int = paramInt4;
            localQQHeadStat.jdField_a_of_type_JavaLangString = paramString2;
            localQQHeadStat.e = (localQQHeadStat.d - localQQHeadStat.jdField_a_of_type_Long);
            this.c.remove(paramString1);
          }
        }
        else {
          localQQHeadStat.c = paramLong;
        }
      }
      else
      {
        localQQHeadStat.jdField_b_of_type_Long = paramLong;
        if (!bool) {
          this.c.remove(paramString1);
        }
        localQQHeadStat.e = (localQQHeadStat.jdField_b_of_type_Long - localQQHeadStat.jdField_a_of_type_Long);
      }
    }
    if (((!bool) || (paramInt3 == 4)) && (localQQHeadStat != null))
    {
      long l2 = localQQHeadStat.jdField_b_of_type_Long - localQQHeadStat.jdField_a_of_type_Long;
      paramLong = l1;
      if (localQQHeadStat.c > localQQHeadStat.jdField_b_of_type_Long)
      {
        paramLong = l1;
        if (localQQHeadStat.jdField_b_of_type_Long > 0L) {
          paramLong = localQQHeadStat.c - localQQHeadStat.jdField_b_of_type_Long;
        }
      }
      l1 = localQQHeadStat.d - localQQHeadStat.c;
      if ((!QLog.isColorLevel()) && ((!bool) || (paramInt3 != 4) || (localQQHeadStat.e <= 3000L))) {
        break label607;
      }
      paramString2 = new StringBuffer(200);
      paramString2.append("===QQHeadStat resultCode=");
      paramString2.append(paramInt1);
      paramString2.append(", uin=");
      paramInt3 = 1;
      paramString2.append(String.format("%11s", new Object[] { paramString1 }));
      paramString2.append(", totalTime=");
      paramString2.append(String.format("%-5s", new Object[] { Long.valueOf(localQQHeadStat.e) }));
      paramString2.append(", picSize=");
      paramString2.append(String.format("%-6s", new Object[] { Integer.valueOf(localQQHeadStat.jdField_a_of_type_Int) }));
      paramString2.append(", downInfoTime=");
      paramString2.append(l2);
      paramString2.append(", intervalTime=");
      paramString2.append(paramLong);
      paramString2.append(", downPicTime=");
      paramString2.append(l1);
      paramString2.append(", reasonCode=");
      paramString2.append(paramInt5);
      paramString2.append(", downUrl=");
      paramString2.append(localQQHeadStat.jdField_a_of_type_JavaLangString);
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
        paramString2.put("downPic_size", String.valueOf(localQQHeadStat.jdField_a_of_type_Int));
        paramString2.put("download_url", localQQHeadStat.jdField_a_of_type_JavaLangString);
        paramString2.put("param_FailCode", Integer.toString(paramInt1));
        paramString2.put("fail_reason", Integer.toString(paramInt5));
        paramString2.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
        paramString1 = AvatarImplUtil.a(paramInt2);
        if (!TextUtils.isEmpty(paramString1)) {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), paramString1, bool, localQQHeadStat.e, localQQHeadStat.jdField_a_of_type_Int, paramString2, "");
        }
        paramString1 = AvatarImplUtil.b(paramInt2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), paramString1, bool, localQQHeadStat.e, localQQHeadStat.jdField_a_of_type_Int, paramString2, "");
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
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaUtilHashtable.size());
      QLog.d("AvatarHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject1 = this.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
        continue;
        if (this.jdField_b_of_type_JavaUtilHashtable.size() > 30)
        {
          long l = System.currentTimeMillis();
          ArrayList localArrayList = new ArrayList();
          Object localObject2 = this.jdField_b_of_type_JavaUtilHashtable.keys();
          if (!((Enumeration)localObject2).hasMoreElements()) {
            break label287;
          }
          String str = (String)((Enumeration)localObject2).nextElement();
          if (Math.abs(l - ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(str)).longValue()) <= 60000L) {
            continue;
          }
          localArrayList.add(str);
          continue;
          if (i < localArrayList.size())
          {
            localObject2 = (String)localArrayList.get(i);
            this.jdField_b_of_type_JavaUtilHashtable.remove(localObject2);
            a(9205, (String)localObject2, -1, 4);
            i += 1;
            continue;
          }
        }
        this.jdField_b_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
      finally {}
      return;
      label287:
      int i = 0;
    }
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        bool1 = this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramString);
        i = -1;
        if (!bool1) {
          break label298;
        }
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
          a(9205, paramString, -1, 4);
          bool1 = true;
          i = 0;
          boolean bool2 = bool1;
          if (bool1)
          {
            boolean bool3 = SystemUtil.a();
            if (((bool3) && (SystemUtil.a() < 2048L)) || ((!bool3) && (SystemUtil.b() < 102400L)))
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
                if (!this.jdField_a_of_type_Boolean)
                {
                  this.jdField_a_of_type_Boolean = true;
                  AvatarImplUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), true);
                  bool2 = bool1;
                }
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("markDownloadedQQHead, whatIf= ");
            paramString.append(i);
            paramString.append(", NeedDownload=");
            paramString.append(bool2);
            QLog.d("AvatarHandler", 2, paramString.toString());
          }
          return bool2;
        }
      }
      boolean bool1 = false;
      int i = 1;
      continue;
      label298:
      bool1 = true;
    }
  }
  
  public String b()
  {
    d();
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.getChoosedStrangerGroupIp();
  }
  
  public void b()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.what = 0;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
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
  
  public void c(String paramString)
  {
    a(11, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarHandler", 2, String.format("getApolloHead(1) uin=%s", new Object[] { paramString }));
    }
    a(116, paramString, 200, (byte)1, (byte)0, FaceConstant.Apollo.FACE_DEFAULT_SIZE_SPEC, false);
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
    QQHeadDownloadHandler localQQHeadDownloadHandler = this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.handler.AvatarHandler
 * JD-Core Version:    0.7.0.1
 */