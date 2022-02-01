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
    List localList;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localList = paramQQHeadUrlRsp.dstHeadInfos.get();
      paramArrayList = paramArrayList.iterator();
    }
    label60:
    label319:
    for (;;)
    {
      QQHeadDetails localQQHeadDetails;
      Object localObject;
      QQHeadUrl.RspHeadInfo localRspHeadInfo;
      if (paramArrayList.hasNext())
      {
        localQQHeadDetails = (QQHeadDetails)paramArrayList.next();
        localObject = localList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label315;
        }
        localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((Iterator)localObject).next();
        if (paramByte2 == 1)
        {
          paramQQHeadUrlRsp = localRspHeadInfo.dstUid.get();
          label96:
          if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(paramQQHeadUrlRsp)) {
            break label290;
          }
          localObject = new QQHeadInfo();
          ((QQHeadInfo)localObject).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
          if (paramByte2 != 1) {
            break label292;
          }
          ((QQHeadInfo)localObject).phoneNum = localRspHeadInfo.dstUid.get();
          ((QQHeadInfo)localObject).dwTimestamp = localRspHeadInfo.timestamp.get();
          ((QQHeadInfo)localObject).cHeadType = ((byte)localRspHeadInfo.faceType.get());
          ((QQHeadInfo)localObject).dstUsrType = paramByte1;
          ((QQHeadInfo)localObject).dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
          ((QQHeadInfo)localObject).downLoadUrl = localRspHeadInfo.url.get();
          ((QQHeadInfo)localObject).systemHeadID = ((short)localRspHeadInfo.sysid.get());
          if (!localRspHeadInfo.headVerify.has()) {
            break label308;
          }
          paramQQHeadUrlRsp = localRspHeadInfo.headVerify.get();
          label240:
          ((QQHeadInfo)localObject).headVerify = paramQQHeadUrlRsp;
          paramList1.add(localObject);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label319;
        }
        paramList.add(localQQHeadDetails);
        break;
        paramQQHeadUrlRsp = String.valueOf(localRspHeadInfo.dstUin.get());
        break label96;
        break label60;
        ((QQHeadInfo)localObject).uin = localRspHeadInfo.dstUin.get();
        break label145;
        paramQQHeadUrlRsp = "";
        break label240;
        return;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, List<QQHeadDetails> paramList)
  {
    if (paramList.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, "handleQQHead_New noChangeQQHeadInfoList");
      }
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
      EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
      int i = 0;
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
        return;
      }
      catch (Exception paramList)
      {
        localEntityTransaction.commit();
        localEntityTransaction.end();
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, List<MultiHeadUrl.RspUsrHeadInfo> paramList, ArrayList<QQHeadDetails> paramArrayList, List<QQHeadDetails> paramList1, List<QQHeadInfo> paramList2)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    QQHeadDetails localQQHeadDetails;
    label37:
    String str;
    label76:
    Object localObject2;
    Object localObject1;
    label114:
    int i;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      if (localIterator2.hasNext())
      {
        paramArrayList = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        if (paramInt2 == 0)
        {
          str = String.valueOf(paramArrayList.dstUin.get());
          if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(str)) {
            break label191;
          }
          localObject2 = paramArrayList.dstHeadInfos.get();
          localObject1 = null;
          paramArrayList = null;
          Iterator localIterator3 = ((List)localObject2).iterator();
          if (!localIterator3.hasNext()) {
            break label218;
          }
          localObject2 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
          i = ((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get();
          if (i != 1) {
            break label193;
          }
          localObject1 = localObject2;
        }
      }
    }
    label273:
    label561:
    label568:
    for (;;)
    {
      break label114;
      if (paramInt2 == 1)
      {
        str = String.valueOf(paramArrayList.dstTid.get());
        break label76;
      }
      str = paramArrayList.dstOpenid.get();
      break label76;
      label191:
      break label37;
      label193:
      if ((i == 32) && (((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get() != 0))
      {
        paramArrayList = (ArrayList<QQHeadDetails>)localObject2;
        continue;
        label218:
        if (paramArrayList != null)
        {
          label223:
          localObject1 = (IQQAvatarDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarDataService.class, "");
          localObject2 = ((IQQAvatarDataService)localObject1).getQQHeadSetting(32, str, paramInt1);
          if (((IQQAvatarDataService)localObject1).isFaceFileExist(32, str, paramInt1, 0)) {
            break label489;
          }
          i = 1;
          if (i == 0) {
            break label568;
          }
          localObject1 = new QQHeadInfo();
          ((QQHeadInfo)localObject1).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
          ((QQHeadInfo)localObject1).idType = paramInt1;
          ((QQHeadInfo)localObject1).phoneNum = str;
          ((QQHeadInfo)localObject1).dwTimestamp = paramArrayList.timestamp.get();
          ((QQHeadInfo)localObject1).cHeadType = ((byte)paramArrayList.faceType.get());
          ((QQHeadInfo)localObject1).dstUsrType = 32;
          ((QQHeadInfo)localObject1).dwFaceFlgas = ((byte)paramArrayList.faceFlag.get());
          ((QQHeadInfo)localObject1).downLoadUrl = paramArrayList.url.get();
          ((QQHeadInfo)localObject1).systemHeadID = ((short)paramArrayList.sysid.get());
          ((QQHeadInfo)localObject1).originUsrType = paramArrayList.usrType.get();
          if (!paramArrayList.headVerify.has()) {
            break label561;
          }
        }
        for (paramArrayList = paramArrayList.headVerify.get();; paramArrayList = "")
        {
          ((QQHeadInfo)localObject1).headVerify = paramArrayList;
          paramList2.add(localObject1);
          break;
          if (localObject1 != null)
          {
            paramArrayList = (ArrayList<QQHeadDetails>)localObject1;
            break label223;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("headstranger", 2, "there is no headinfo uin=" + str);
          break;
          label489:
          if (localObject2 != null)
          {
            localObject1 = (Setting)((Pair)localObject2).second;
            if (localObject1 == null)
            {
              i = 1;
              break label273;
            }
            if (((Setting)localObject1).headImgTimestamp != paramArrayList.timestamp.get())
            {
              i = 1;
              break label273;
            }
            paramList1.add(localQQHeadDetails);
            i = 0;
            break label273;
          }
          i = 1;
          break label273;
        }
        notifyUI(4, true, new Object[] { localQQHeadDetails.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt1), Boolean.valueOf(true) });
        break label37;
        break;
        return;
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
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
    localMultiBusidUrlReq.srcUidType.set(0);
    localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
    localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(16));
    localMultiBusidUrlReq.dstUidType.set(0);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label171;
      }
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
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ERROR", 2, localException.getMessage());
          }
        }
      }
      i += 1;
    }
    label171:
    new HashMap().put("connum", String.valueOf(paramArrayList.size()));
    ToServiceMsg localToServiceMsg = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("idType", paramInt);
    localToServiceMsg.extraData.putInt("qqHeadType", 16);
    localToServiceMsg.putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("AvatarHandler", 2, "realGetQQHead_QCall .  idType = " + paramInt);
    }
    sendPbReq(localToServiceMsg);
  }
  
  private void a(int paramInt, List<MultiHeadUrl.RspUsrHeadInfo> paramList, ArrayList<QQHeadDetails> paramArrayList, List<QQHeadDetails> paramList1, List<QQHeadInfo> paramList2)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    QQHeadDetails localQQHeadDetails;
    label36:
    String str;
    Object localObject1;
    Object localObject2;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          paramArrayList = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
          str = AvatarImplUtil.a(paramArrayList.dstUin.get());
          if (localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(str))
          {
            localObject1 = paramArrayList.dstHeadInfos.get();
            paramArrayList = null;
            localObject2 = ((List)localObject1).iterator();
            label102:
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (MultiHeadUrl.RspHeadInfo)((Iterator)localObject2).next();
              ((MultiHeadUrl.RspHeadInfo)localObject1).usrType.get();
              if (((MultiHeadUrl.RspHeadInfo)localObject1).faceType.get() == 0) {
                break label587;
              }
              paramArrayList = (ArrayList<QQHeadDetails>)localObject1;
            }
          }
        }
      }
    }
    label154:
    label578:
    label580:
    label587:
    for (;;)
    {
      break label102;
      int i;
      if (paramArrayList != null)
      {
        localObject1 = (IQQAvatarDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarDataService.class, "");
        localObject2 = ((IQQAvatarDataService)localObject1).getQQHeadSetting(16, str, paramInt);
        if (((IQQAvatarDataService)localObject1).isFaceFileExist(16, str, paramInt, 0)) {
          break label459;
        }
        int j = 1;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL file not exist.id=" + str + ",idType=" + paramInt);
          i = j;
        }
        if (i == 0) {
          break label578;
        }
        localObject1 = new QQHeadInfo();
        ((QQHeadInfo)localObject1).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
        ((QQHeadInfo)localObject1).idType = paramInt;
        ((QQHeadInfo)localObject1).phoneNum = str;
        ((QQHeadInfo)localObject1).dwTimestamp = paramArrayList.timestamp.get();
        ((QQHeadInfo)localObject1).cHeadType = ((byte)paramArrayList.faceType.get());
        ((QQHeadInfo)localObject1).dstUsrType = 16;
        ((QQHeadInfo)localObject1).dwFaceFlgas = ((byte)paramArrayList.faceFlag.get());
        ((QQHeadInfo)localObject1).downLoadUrl = paramArrayList.url.get();
        ((QQHeadInfo)localObject1).systemHeadID = ((short)paramArrayList.sysid.get());
        ((QQHeadInfo)localObject1).originUsrType = paramArrayList.usrType.get();
        if (!paramArrayList.headVerify.has()) {
          break label580;
        }
      }
      for (paramArrayList = paramArrayList.headVerify.get();; paramArrayList = "")
      {
        ((QQHeadInfo)localObject1).headVerify = paramArrayList;
        paramList2.add(localObject1);
        break label36;
        if (0 != 0)
        {
          paramArrayList = null;
          break label154;
        }
        if (!QLog.isColorLevel()) {
          break label36;
        }
        QLog.d("headqcall", 2, "there is no headinfo uin=" + str);
        break label36;
        break;
        label459:
        if (localObject2 != null)
        {
          localObject1 = (Setting)((Pair)localObject2).second;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL setting=" + localObject1 + "targetInfo.timestamp=" + paramArrayList.timestamp.get());
          }
          if (localObject1 == null)
          {
            i = 1;
            break label256;
          }
          if (((Setting)localObject1).headImgTimestamp != paramArrayList.timestamp.get())
          {
            i = 1;
            break label256;
          }
          paramList1.add(localQQHeadDetails);
          i = 0;
          break label256;
        }
        i = 1;
        break label256;
        break label36;
      }
      return;
    }
  }
  
  private void a(long paramLong, int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
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
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = localStringBuilder.append("handleGetQQHeadError, result=").append(paramInt).append(", uinListSize=");
    if (localArrayList != null) {}
    for (int i = localArrayList.size();; i = -1)
    {
      ((StringBuilder)localObject1).append(i);
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        break;
      }
      QLog.i("AvatarHandler", 1, localStringBuilder.toString());
      return;
    }
    i = 0;
    while (i < localArrayList.size())
    {
      localObject1 = (QQHeadDetails)localArrayList.get(i);
      int j = paramToServiceMsg.extraData.getInt("idType", 0);
      Object localObject2 = AvatarUtil.a(((QQHeadDetails)localObject1).jdField_a_of_type_Int, ((QQHeadDetails)localObject1).jdField_a_of_type_JavaLangString, j, 0);
      a((String)localObject2, true);
      a(9201, (String)localObject2, ((QQHeadDetails)localObject1).jdField_a_of_type_Int, 2, 0, null, paramInt, 0L);
      localStringBuilder.append("; uin=").append((String)localObject2).append(", timestamp=").append(((QQHeadDetails)localObject1).jdField_a_of_type_Long);
      localObject2 = (IQQClassicAvatarService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQClassicAvatarService.class, "");
      if ((localObject2 != null) && (((IQQClassicAvatarService)localObject2).isClassicHeadActivityActivate())) {
        ((IQQClassicAvatarService)localObject2).handleGetHeadError(((QQHeadDetails)localObject1).jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
    QLog.i("AvatarHandler", 1, localStringBuilder.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, QQHeadUrlResp paramQQHeadUrlResp)
  {
    int i;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramQQHeadUrlResp == null) || (paramQQHeadUrlResp.result != 0) || (paramQQHeadUrlResp.UserHeadInfoList == null))
    {
      i = 65535;
      if (paramQQHeadUrlResp != null) {
        i = paramQQHeadUrlResp.result;
      }
    }
    label262:
    do
    {
      for (;;)
      {
        a(paramToServiceMsg, i);
        if (QLog.isColorLevel()) {
          QLog.d("AvatarHandler", 2, "handleQQHead handleResp for QQHeadInfo appear error and error code =" + i);
        }
        return;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      Object localObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        paramToServiceMsg = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        for (;;)
        {
          if (!paramFromServiceMsg.hasNext()) {
            break label262;
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
        paramQQHeadUrlResp.UserHeadInfoList = paramToServiceMsg;
      }
      d();
      paramToServiceMsg = new StringBuilder("handleQQHead handleResp for QQHeadInfo");
      i = 0;
      while (i < paramQQHeadUrlResp.UserHeadInfoList.size())
      {
        paramFromServiceMsg = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(i);
        a(0, a(paramFromServiceMsg.dstUsrType, paramFromServiceMsg.uin, paramFromServiceMsg.phoneNum), paramFromServiceMsg.dstUsrType, 2);
        paramToServiceMsg.append(" qqHeadUrlResp id=").append(i).append(" QQHeadInfo.uin=").append(StringUtil.e(Long.toString(paramFromServiceMsg.uin))).append(" QQHeadInfo.systemId=").append(paramFromServiceMsg.systemHeadID).append("  QQHeadInfo.headtype=").append(paramFromServiceMsg.cHeadType).append("|");
        localObject = new FaceInfo();
        ((FaceInfo)localObject).jdField_a_of_type_AvatarInfoQQHeadInfo = paramFromServiceMsg;
        this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.addDownloadRequest((FaceInfo)localObject);
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AvatarHandler", 2, paramToServiceMsg.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = new QQHeadUrl.QQHeadUrlRsp();
          ((QQHeadUrl.QQHeadUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localQQHeadUrlRsp = null;
        continue;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      notifyUI(6, false, new Object[] { Integer.valueOf(0), paramToServiceMsg });
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarHandler", 2, "handleQQHead_New qqHeadUrlResp=" + localObject1 + " qqHeadUrlRespData = " + paramObject);
    }
    QQHeadUrl.QQHeadUrlRsp localQQHeadUrlRsp;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (localObject1 == null) || (((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get() != 0))
    {
      i = 65535;
      if (localObject1 != null)
      {
        i = ((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get();
        a(paramToServiceMsg, i);
        i = paramToServiceMsg.extraData.getInt("dstUsrType", 1);
        if ((i != 1) && (i != 32)) {
          break label296;
        }
        paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
        paramToServiceMsg = new ArrayList();
        if (!(paramFromServiceMsg instanceof ArrayList)) {
          break label274;
        }
        paramFromServiceMsg = ((ArrayList)paramFromServiceMsg).iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = paramFromServiceMsg.next();
          if ((paramObject instanceof QQHeadDetails)) {
            paramToServiceMsg.add(((QQHeadDetails)paramObject).jdField_a_of_type_JavaLangString);
          }
        }
      }
      label274:
      label296:
      return;
    }
    int i = localQQHeadUrlRsp.dstUsrType.get();
    if (i == 8) {
      i = 4;
    }
    for (;;)
    {
      byte b1 = (byte)localQQHeadUrlRsp.dstEncryptType.get();
      paramObject = new ArrayList();
      paramFromServiceMsg = new ArrayList();
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      a((byte)i, b1, localQQHeadUrlRsp, paramToServiceMsg, paramFromServiceMsg, paramObject);
      a(paramObject, false);
      a(i, 0, paramFromServiceMsg);
      if ((paramFromServiceMsg.size() <= 0) || ((i != 1) && (i != 32))) {
        break;
      }
      paramToServiceMsg = new ArrayList(paramFromServiceMsg.size());
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext()) {
        paramToServiceMsg.add(((QQHeadDetails)paramFromServiceMsg.next()).jdField_a_of_type_JavaLangString);
      }
      notifyUI(6, true, new Object[] { Integer.valueOf(0), paramToServiceMsg });
      return;
    }
  }
  
  private void a(List<QQHeadInfo> paramList, boolean paramBoolean)
  {
    d();
    int i = 0;
    if (i < paramList.size())
    {
      QQHeadInfo localQQHeadInfo = (QQHeadInfo)paramList.get(i);
      a(0, a(localQQHeadInfo.uin, localQQHeadInfo.phoneNum), localQQHeadInfo.dstUsrType, 2);
      FaceInfo localFaceInfo = new FaceInfo();
      if (paramBoolean) {}
      for (String str = localQQHeadInfo.phoneNum;; str = String.valueOf(localQQHeadInfo.uin))
      {
        localFaceInfo.jdField_a_of_type_JavaLangString = str;
        localFaceInfo.jdField_b_of_type_Int = localQQHeadInfo.idType;
        localFaceInfo.jdField_a_of_type_Int = localQQHeadInfo.dstUsrType;
        localFaceInfo.d = localQQHeadInfo.sizeType;
        localFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo = localQQHeadInfo;
        localFaceInfo.c = AvatarImplUtil.a(AvatarImplUtil.a(localFaceInfo.d), AvatarImplUtil.b(localFaceInfo.d));
        this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.addDownloadRequest(localFaceInfo);
        i += 1;
        break;
      }
    }
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, int paramInt3, boolean paramBoolean)
  {
    label102:
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, "getQQHead, uin=" + paramString + ",headType=" + paramInt1 + ",idType=" + paramInt2 + ",level=" + paramByte1 + ",faceFileType=" + paramByte2);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramInt1 != 1) {
          break label102;
        }
        paramBoolean = StringUtil.c(paramString);
        if (paramBoolean) {
          break label102;
        }
      }
      for (;;)
      {
        return;
        localObject = AvatarUtil.a(paramInt1, paramString, paramInt2, paramInt3);
        if (a((String)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AvatarHandler", 2, "markDownloadedQQHead, noNeedDownload= " + (String)localObject);
        }
      }
      a((String)localObject, false);
    }
    finally {}
    boolean bool = ((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isInRealActionLoginB();
    label245:
    int i;
    if (QLog.isColorLevel())
    {
      QLog.d("AvatarHandler", 2, "markDownloadedQQHead end keyStr = " + (String)localObject + ",isImmediatelyGet=" + this.jdField_b_of_type_Boolean + ",InActionLoginB=" + bool);
      break label526;
      this.jdField_a_of_type_Int += 1;
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i));
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(i), localObject);
        if (!QLog.isColorLevel()) {
          break label538;
        }
        QLog.d("AvatarHandler", 2, "FaceConstant.HeadType.QQHEAD_TYPE_QCALL destQQHeadInfoTable.put(keyType, destQQHeadInfoList); keyType = " + i + "destQQHeadInfoTable.size = " + this.jdField_a_of_type_JavaUtilHashtable.size());
        break label538;
      }
    }
    for (;;)
    {
      paramBoolean = ((IQQAvatarDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).isFaceFileExist(paramInt1, paramString, paramInt2, paramInt3);
      for (;;)
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramBoolean)
        {
          Pair localPair = ((IQQAvatarDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(paramInt1, paramString, paramInt2);
          l1 = l2;
          if (localPair != null)
          {
            l1 = l2;
            if (localPair.second != null) {
              l1 = ((Setting)localPair.second).headImgTimestamp;
            }
          }
        }
        ((ArrayList)localObject).add(new QQHeadDetails(paramInt1, paramString, l1, paramByte1, paramInt3));
        if ((!this.jdField_b_of_type_Boolean) && (bool) && (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()))) {
          break;
        }
        c();
        break;
        paramBoolean = true;
        continue;
        paramBoolean = false;
      }
      break label538;
      label526:
      do
      {
        i = paramInt1;
        break;
      } while (paramInt1 != 32);
      i = paramInt2;
      break label245;
      label538:
      switch (paramByte2)
      {
      }
    }
  }
  
  private void b(int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i;
    switch (paramInt)
    {
    case 203: 
    default: 
      i = 0;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq;
    label321:
    for (;;)
    {
      localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
      localMultiBusidUrlReq.srcUidType.set(0);
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(1));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(32));
      localMultiBusidUrlReq.dstUidType.set(i);
      int j = 0;
      label115:
      if (j < paramArrayList.size())
      {
        QQHeadDetails localQQHeadDetails = (QQHeadDetails)paramArrayList.get(j);
        MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
        if (i == 0) {}
        try
        {
          localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          for (;;)
          {
            a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
            localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
            if (QLog.isColorLevel()) {
              QLog.i("multiBusidUrlReq.dstUsrInfos", 2, " multiBusidUrlReq.dstUsrInfos reqUsrInfo.dstUin = " + localReqUsrInfo.dstUin + " ,reqUsrInfo.dstTid = " + localReqUsrInfo.dstTid + " ,reqUsrInfo.dstOpenid = " + localReqUsrInfo.dstOpenid);
            }
            j += 1;
            break label115;
            i = 2;
            break;
            i = 1;
            break;
            if (i != 1) {
              break label321;
            }
            localReqUsrInfo.dstTid.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.i("ERROR", 2, localException.getMessage());
              continue;
              if (i == 2) {
                localReqUsrInfo.dstOpenid.set(localException.jdField_a_of_type_JavaLangString);
              }
            }
          }
        }
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("connum", String.valueOf(paramArrayList.size()));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "actNearbyHeadConNum", true, 0L, 0L, (HashMap)localObject, "");
    localObject = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
    ((ToServiceMsg)localObject).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putLong("startTime", System.currentTimeMillis());
    ((ToServiceMsg)localObject).extraData.putInt("idType", paramInt);
    ((ToServiceMsg)localObject).putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("AvatarHandler", 2, "realGetQQHead_Stranger .  idType = " + paramInt);
    }
    sendPbReq((ToServiceMsg)localObject);
  }
  
  private void b(long paramLong, int paramInt, ArrayList<QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
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
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ArrayList localArrayList1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("AvatarHandler", 2, "handleQQHead_QCall ....");
    }
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {
          break label263;
        }
        localObject = new MultiHeadUrl.MultiBusidUrlRsp();
        ((MultiHeadUrl.MultiBusidUrlRsp)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (Exception paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AvatarHandler", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + paramObject.getMessage());
        paramObject.printStackTrace();
        paramObject = localArrayList1;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int i = paramFromServiceMsg.getResultCode();
        continue;
        paramFromServiceMsg = paramObject.dstUsrHeadInfos.get();
        localArrayList1 = new ArrayList();
        Object localObject = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
        ArrayList localArrayList2 = new ArrayList();
        paramObject.dstUidType.get();
        i = paramToServiceMsg.extraData.getInt("idType");
        a(i, paramFromServiceMsg, (ArrayList)localObject, localArrayList1, localArrayList2);
        a(localArrayList2, true);
        a(16, i, localArrayList1);
        return;
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
      {
        i = 65535;
        if (paramObject != null)
        {
          i = paramObject.result.get();
          a(paramToServiceMsg, i);
          return;
        }
      }
      label263:
      paramObject = null;
    }
  }
  
  private void c()
  {
    for (;;)
    {
      label152:
      int i;
      Object localObject3;
      try
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
        if (QLog.isColorLevel()) {
          QLog.d("AvatarHandler", 2, "doExecuteGetQQHead start !!! ");
        }
        if (this.jdField_a_of_type_Int > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AvatarHandler", 2, "doExecuteGetQQHead destQQHeadInfoCount = " + this.jdField_a_of_type_Int);
          }
          localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
          if (localObject1 == null) {
            break label587;
          }
        }
        Enumeration localEnumeration;
        try
        {
          l = Long.valueOf((String)localObject1).longValue();
          if (l == -1L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AvatarHandler", 2, "doExecuteGetQQHead|myUin error: myUin=" + (String)localObject1);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          l = -1L;
          continue;
          localEnumeration = this.jdField_a_of_type_JavaUtilHashtable.keys();
        }
        if (!localEnumeration.hasMoreElements()) {
          break label566;
        }
        i = ((Integer)localEnumeration.nextElement()).intValue();
        Object localObject1 = (List)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("AvatarHandler", 2, "em.hasMoreElements() QQHeadDetails head_or_id = " + i);
        }
        if (!QLog.isColorLevel()) {
          break label357;
        }
        localObject3 = new StringBuilder("doExecuteGetQQHead sendRequests for QQHeadInfo head_or_id=").append(i);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          QQHeadDetails localQQHeadDetails = (QQHeadDetails)localIterator.next();
          ((StringBuilder)localObject3).append(" QQheadDetail uinOrMobile=").append(StringUtil.e(localQQHeadDetails.jdField_a_of_type_JavaLangString)).append(",Timestamp=").append(localQQHeadDetails.jdField_a_of_type_Long).append("|");
          continue;
        }
        ((StringBuilder)localObject3).append(" QQHeadDetailList length = ").append(localList.size());
      }
      finally {}
      QLog.d("AvatarHandler", 2, ((StringBuilder)localObject3).toString());
      label357:
      if ((localList != null) && (!localList.isEmpty())) {}
      for (Object localObject2 = AvatarImplUtil.a(localList, 50);; localObject2 = null)
      {
        if (localObject2 == null) {
          break label585;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = new ArrayList((List)((Iterator)localObject2).next());
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
            if (QLog.isColorLevel()) {
              QLog.d("AvatarHandler", 2, "realGetQQHead_Stranger = " + i);
            }
            b(i, (ArrayList)localObject3);
          }
          else if (i == 16)
          {
            a(i, (ArrayList)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("AvatarHandler", 2, "FaceConstant.HeadType.QQHEAD_TYPE_QCALL = " + i);
            }
          }
          else
          {
            b(l, i, (ArrayList)localObject3);
          }
        }
        break label152;
        label566:
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilHashtable.clear();
        break;
      }
      label585:
      continue;
      label587:
      long l = -1L;
    }
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
    ArrayList localArrayList1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("AvatarHandler", 2, "handleQQHead_Stranger ....");
    }
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {
          break label266;
        }
        localObject = new MultiHeadUrl.MultiBusidUrlRsp();
        ((MultiHeadUrl.MultiBusidUrlRsp)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (Exception paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AvatarHandler", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + paramObject.getMessage());
        paramObject.printStackTrace();
        paramObject = localArrayList1;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int i = paramFromServiceMsg.getResultCode();
        continue;
        paramFromServiceMsg = paramObject.dstUsrHeadInfos.get();
        localArrayList1 = new ArrayList();
        Object localObject = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
        ArrayList localArrayList2 = new ArrayList();
        i = paramObject.dstUidType.get();
        int j = paramToServiceMsg.extraData.getInt("idType");
        a(j, i, paramFromServiceMsg, (ArrayList)localObject, localArrayList1, localArrayList2);
        a(localArrayList2, true);
        a(32, j, localArrayList1);
        return;
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
      {
        i = 65535;
        if (paramObject != null)
        {
          i = paramObject.result.get();
          a(paramToServiceMsg, i);
          return;
        }
      }
      label266:
      paramObject = null;
    }
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
    boolean bool2 = false;
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramToServiceMsg.extraData.getParcelableArrayList("key_request_list");
    paramToServiceMsg = localArrayList;
    Object localObject2 = localObject1;
    boolean bool1 = bool2;
    if (paramFromServiceMsg != null)
    {
      paramToServiceMsg = localArrayList;
      localObject2 = localObject1;
      bool1 = bool2;
      if (paramFromServiceMsg.isSuccess())
      {
        paramToServiceMsg = localArrayList;
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject3 == null) {}
      }
    }
    byte b1;
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label505;
        }
        i = 1;
        if (i == 0) {
          break label707;
        }
        paramFromServiceMsg = new oidb_0xedb.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = new HashMap();
        if (!paramFromServiceMsg.dstHeadInfos.has()) {
          break;
        }
        paramToServiceMsg = paramFromServiceMsg.dstHeadInfos.get().iterator();
        if (!paramToServiceMsg.hasNext()) {
          break;
        }
        paramFromServiceMsg = (oidb_0xedb.RspHeadInfo)paramToServiceMsg.next();
        b1 = (byte)paramFromServiceMsg.faceType.get();
        byte b2 = (byte)paramFromServiceMsg.faceFlag.get();
        localObject2 = new QQHeadInfo();
        ((QQHeadInfo)localObject2).uin = paramFromServiceMsg.dstUin.get();
        ((QQHeadInfo)localObject2).dwTimestamp = paramFromServiceMsg.timestamp.get();
        ((QQHeadInfo)localObject2).cHeadType = b1;
        ((QQHeadInfo)localObject2).dstUsrType = 116;
        ((QQHeadInfo)localObject2).dwFaceFlgas = b2;
        ((QQHeadInfo)localObject2).downLoadUrl = paramFromServiceMsg.url.get();
        paramObject.put(String.valueOf(((QQHeadInfo)localObject2).uin), localObject2);
        continue;
        if (!QLog.isColorLevel()) {
          break label371;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("AvatarHandler", 1, "handleGetApolloHead fail.", paramToServiceMsg);
        bool1 = bool2;
        localObject2 = localObject1;
        paramToServiceMsg = localArrayList;
      }
      QLog.d("AvatarHandler", 2, String.format("handleGetApolloHead success=%s noChangeSize=%s changeSize=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(((ArrayList)localObject2).size()), Integer.valueOf(paramToServiceMsg.size()) }));
      label371:
      if (bool1)
      {
        a(paramToServiceMsg, false);
        a(116, 200, (List)localObject2);
      }
      paramFromServiceMsg = ((ArrayList)localObject2).iterator();
      while (paramFromServiceMsg.hasNext())
      {
        localObject1 = (QQHeadDetails)paramFromServiceMsg.next();
        paramObject = ((QQHeadDetails)localObject1).jdField_a_of_type_JavaLangString;
        localObject1 = (Setting)((IQQAvatarDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(((QQHeadDetails)localObject1).jdField_a_of_type_Int, ((QQHeadDetails)localObject1).jdField_a_of_type_JavaLangString, 200).second;
        if (localObject1 == null) {
          break label701;
        }
        b1 = ((Setting)localObject1).bHeadType;
        label478:
        notifyUI(7, bool1, new Object[] { paramObject, Byte.valueOf(b1) });
      }
      label505:
      int i = 0;
    }
    paramToServiceMsg = new ArrayList();
    paramFromServiceMsg = new ArrayList();
    localObject2 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (QQHeadDetails)((Iterator)localObject2).next();
      if (!paramObject.containsKey(((QQHeadDetails)localObject3).jdField_a_of_type_JavaLangString))
      {
        paramToServiceMsg.add(localObject3);
      }
      else
      {
        QQHeadInfo localQQHeadInfo = (QQHeadInfo)paramObject.get(((QQHeadDetails)localObject3).jdField_a_of_type_JavaLangString);
        localQQHeadInfo.headLevel = ((QQHeadDetails)localObject3).jdField_a_of_type_Byte;
        localQQHeadInfo.sizeType = ((QQHeadDetails)localObject3).jdField_b_of_type_Int;
        localQQHeadInfo.idType = 200;
        paramFromServiceMsg.add(localQQHeadInfo);
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      localObject2 = paramToServiceMsg;
      paramToServiceMsg = paramFromServiceMsg;
      break;
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramFromServiceMsg = (QQHeadInfo)paramToServiceMsg.next();
        notifyUI(7, bool1, new Object[] { String.valueOf(paramFromServiceMsg.uin), Byte.valueOf(paramFromServiceMsg.cHeadType) });
      }
      return;
      label701:
      b1 = 0;
      break label478;
      label707:
      paramFromServiceMsg = localArrayList;
      paramToServiceMsg = (ToServiceMsg)localObject1;
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
    long l1;
    if (paramInt1 == 0)
    {
      bool = true;
      l1 = paramLong;
      if (paramLong == 0L) {
        l1 = System.currentTimeMillis();
      }
      if (paramInt3 != 1) {
        break label651;
      }
      if (this.c.containsKey(paramString1)) {
        this.c.remove(paramString1);
      }
      paramString2 = new QQHeadStat();
      paramString2.jdField_a_of_type_Long = l1;
      paramString2.jdField_b_of_type_Int = paramInt2;
      this.c.put(paramString1, paramString2);
    }
    for (;;)
    {
      long l2;
      Object localObject;
      if (((!bool) || (paramInt3 == 4)) && (paramString2 != null))
      {
        l2 = paramString2.jdField_b_of_type_Long - paramString2.jdField_a_of_type_Long;
        l1 = 0L;
        paramLong = l1;
        if (paramString2.c > paramString2.jdField_b_of_type_Long)
        {
          paramLong = l1;
          if (paramString2.jdField_b_of_type_Long > 0L) {
            paramLong = paramString2.c - paramString2.jdField_b_of_type_Long;
          }
        }
        l1 = paramString2.d - paramString2.c;
        if ((QLog.isColorLevel()) || ((bool) && (paramInt3 == 4) && (paramString2.e > 3000L)))
        {
          localObject = new StringBuffer(200);
          ((StringBuffer)localObject).append("===QQHeadStat resultCode=").append(paramInt1);
          ((StringBuffer)localObject).append(", uin=").append(String.format("%11s", new Object[] { paramString1 }));
          ((StringBuffer)localObject).append(", totalTime=").append(String.format("%-5s", new Object[] { Long.valueOf(paramString2.e) }));
          ((StringBuffer)localObject).append(", picSize=").append(String.format("%-6s", new Object[] { Integer.valueOf(paramString2.jdField_a_of_type_Int) }));
          ((StringBuffer)localObject).append(", downInfoTime=").append(l2);
          ((StringBuffer)localObject).append(", intervalTime=").append(paramLong);
          ((StringBuffer)localObject).append(", downPicTime=").append(l1);
          ((StringBuffer)localObject).append(", reasonCode=").append(paramInt5);
          ((StringBuffer)localObject).append(", downUrl=").append(paramString2.jdField_a_of_type_JavaLangString);
          if (!QLog.isColorLevel()) {
            break label822;
          }
        }
      }
      label651:
      label822:
      for (paramInt3 = 2;; paramInt3 = 1)
      {
        QLog.d("QQHeadCostTime", paramInt3, ((StringBuffer)localObject).toString());
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("qqhead_uin", paramString1);
          ((HashMap)localObject).put("downInfo_time", String.valueOf(l2));
          ((HashMap)localObject).put("interval_time", String.valueOf(paramLong));
          ((HashMap)localObject).put("downPic_time", String.valueOf(l1));
          ((HashMap)localObject).put("downPic_size", String.valueOf(paramString2.jdField_a_of_type_Int));
          ((HashMap)localObject).put("download_url", paramString2.jdField_a_of_type_JavaLangString);
          ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt1));
          ((HashMap)localObject).put("fail_reason", Integer.toString(paramInt5));
          ((HashMap)localObject).put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
          paramString1 = AvatarImplUtil.a(paramInt2);
          if (!TextUtils.isEmpty(paramString1)) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), paramString1, bool, paramString2.e, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
          }
          paramString1 = AvatarImplUtil.b(paramInt2);
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), paramString1, bool, paramString2.e, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
        }
        do
        {
          return;
          bool = false;
          break;
          if (!this.c.containsKey(paramString1)) {
            break label828;
          }
          localObject = (QQHeadStat)this.c.get(paramString1);
        } while (localObject == null);
        switch (paramInt3)
        {
        }
        for (;;)
        {
          paramString2 = (String)localObject;
          break;
          ((QQHeadStat)localObject).jdField_b_of_type_Long = l1;
          if (!bool) {
            this.c.remove(paramString1);
          }
          ((QQHeadStat)localObject).e = (((QQHeadStat)localObject).jdField_b_of_type_Long - ((QQHeadStat)localObject).jdField_a_of_type_Long);
          paramString2 = (String)localObject;
          break;
          ((QQHeadStat)localObject).c = l1;
          paramString2 = (String)localObject;
          break;
          ((QQHeadStat)localObject).d = l1;
          ((QQHeadStat)localObject).jdField_a_of_type_Int = paramInt4;
          ((QQHeadStat)localObject).jdField_a_of_type_JavaLangString = paramString2;
          ((QQHeadStat)localObject).e = (((QQHeadStat)localObject).d - ((QQHeadStat)localObject).jdField_a_of_type_Long);
          this.c.remove(paramString1);
        }
      }
      label828:
      paramString2 = null;
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
    if (QLog.isColorLevel()) {
      QLog.d("AvatarHandler", 2, "markDownloadedQQHead, uinOrMobile= " + paramString + ",isRemove=" + paramBoolean + "downloadSize=" + this.jdField_b_of_type_JavaUtilHashtable.size());
    }
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramBoolean) {
      try
      {
        this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
        return;
      }
      finally {}
    }
    ArrayList localArrayList;
    Object localObject2;
    if (this.jdField_b_of_type_JavaUtilHashtable.size() > 30)
    {
      long l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.jdField_b_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l - ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(str)).longValue()) > 60000L) {
          localArrayList.add(str);
        }
      }
    }
    for (;;)
    {
      int i;
      if (i < localArrayList.size())
      {
        localObject2 = (String)localArrayList.get(i);
        this.jdField_b_of_type_JavaUtilHashtable.remove(localObject2);
        a(9205, (String)localObject2, -1, 4);
        i += 1;
      }
      else
      {
        this.jdField_b_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(System.currentTimeMillis()));
        break;
        i = 0;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      int i;
      boolean bool1;
      boolean bool3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramString)) {
          break label270;
        }
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
          a(9205, paramString, -1, 4);
          i = 0;
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool3 = SystemUtil.a();
            if (((bool3) && (SystemUtil.a() < 2048L)) || ((!bool3) && (SystemUtil.b() < 102400L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("AvatarHandler", 2, "getQQHead|fail, storage is not enough. uinOrMobile=" + paramString + ", isExistSDCard=" + bool3);
              }
              bool2 = false;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("AvatarHandler", 2, "markDownloadedQQHead, whatIf= " + i + ", NeedDownload=" + bool2);
            }
            return bool2;
          }
        }
        else
        {
          i = 1;
          bool1 = false;
        }
      }
      boolean bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          AvatarImplUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), true);
          bool2 = bool1;
          continue;
          label270:
          i = -1;
          bool1 = true;
        }
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("AvatarHandler", 2, "getQCallHead FaceConstant.HeadType.QQHEAD_TYPE_QCALL uin = " + paramString + " idType = " + paramInt + ", level =  faceFileType = " + paramByte2);
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
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return AvatarObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceQQHeadDownloadHandler.close();
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    do
    {
      return;
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
    } while (!"OidbSvc.0xedb".equals(paramFromServiceMsg.getServiceCmd()));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.handler.AvatarHandler
 * JD-Core Version:    0.7.0.1
 */