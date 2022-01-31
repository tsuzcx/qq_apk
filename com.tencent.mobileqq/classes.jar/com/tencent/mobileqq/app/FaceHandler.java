package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.util.FaceManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FaceHandler
  extends BusinessHandler
{
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private Hashtable b;
  
  public FaceHandler(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.jdField_b_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  private void a(int paramInt, ArrayList paramArrayList)
  {
    int k = 0;
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((StringBuilder)localObject1).append("realGetStrangerFace").append(", size=");
      if (paramArrayList != null) {}
      for (i = paramArrayList.size();; i = 0)
      {
        ((StringBuilder)localObject2).append(i);
        if (paramArrayList == null) {
          break;
        }
        i = 0;
        while (i < paramArrayList.size())
        {
          ((StringBuilder)localObject1).append(',').append(paramArrayList.get(i));
          i += 1;
        }
      }
      QLog.i("Q.qqhead.FaceHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    if (paramInt == 202) {}
    for (int i = 1;; i = 0)
    {
      localObject1 = new MultiHeadUrl.MultiBusidUrlReq();
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUidType.set(0);
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.add(Integer.valueOf(1));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.add(Integer.valueOf(32));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUidType.set(i);
      int j = 0;
      if (j < paramArrayList.size())
      {
        localObject2 = (FaceInfo)paramArrayList.get(j);
        MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
        if (i == 0) {}
        for (;;)
        {
          try
          {
            localReqUsrInfo.dstUin.set(Long.parseLong(((FaceInfo)localObject2).jdField_a_of_type_JavaLangString));
            ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrInfos.add(localReqUsrInfo);
            ((FaceInfo)localObject2).a(FaceInfo.l);
          }
          catch (Exception localException)
          {
            continue;
          }
          j += 1;
          break;
          if (i == 1) {
            localReqUsrInfo.dstTid.set(Long.parseLong(((FaceInfo)localObject2).jdField_a_of_type_JavaLangString));
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("QQHead_Stranger request.srcUidType=" + ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUidType.get()).append(";srcUin=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).append("\n\n").append(";dstUsrType=" + ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.get()).append(";dstUidType=" + ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUidType.get()).append("\n\n").append(";uinset={");
        if (paramArrayList != null)
        {
          i = k;
          while (i < paramArrayList.size())
          {
            ((StringBuilder)localObject3).append(paramArrayList.get(i) + ",");
            i += 1;
          }
        }
        ((StringBuilder)localObject3).append("}");
        QLog.i("Q.qqhead.FaceHandler", 2, ((StringBuilder)localObject3).toString());
      }
      Object localObject3 = a("MultibusidURLSvr.HeadUrlReq", null);
      ((ToServiceMsg)localObject3).extraData.putParcelableArrayList("list", paramArrayList);
      ((ToServiceMsg)localObject3).extraData.putLong("startTime", System.currentTimeMillis());
      ((ToServiceMsg)localObject3).extraData.putInt("idType", paramInt);
      ((ToServiceMsg)localObject3).putWupBuffer(((MultiHeadUrl.MultiBusidUrlReq)localObject1).toByteArray());
      b((ToServiceMsg)localObject3);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("list");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localStringBuilder.append("handleGetQQHeadError, result=").append(paramInt).append(", listSize=");
    if (paramToServiceMsg != null) {}
    for (paramInt = paramToServiceMsg.size();; paramInt = -1)
    {
      ((StringBuilder)localObject).append(paramInt);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() != 0)) {
        break;
      }
      QLog.i("Q.qqhead.FaceHandler", 1, localStringBuilder.toString());
      return;
    }
    paramInt = 0;
    while (paramInt < paramToServiceMsg.size())
    {
      localObject = (FaceInfo)paramToServiceMsg.get(paramInt);
      a(((FaceInfo)localObject).b(), false);
      localStringBuilder.append("info=").append(localObject);
      paramInt += 1;
    }
    QLog.i("Q.qqhead.FaceHandler", 1, localStringBuilder.toString());
  }
  
  private void b()
  {
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin();
        Enumeration localEnumeration = this.jdField_a_of_type_JavaUtilHashtable.keys();
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        i = ((Integer)localEnumeration.nextElement()).intValue();
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i));
        if ((i == 200) || (i == 202))
        {
          a(i, localArrayList);
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      QLog.d("Q.qqhead.FaceHandler", 2, "checkWaitingRequests,key =" + i);
    }
    this.jdField_a_of_type_JavaUtilHashtable.clear();
  }
  
  protected Class a()
  {
    return FaceObserver.class;
  }
  
  public void a(FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceHandler", 2, "getStrangerFaceInfo.faceInfo=" + paramFaceInfo);
    }
    Object localObject = paramFaceInfo.b();
    if (b((String)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceHandler", 2, "getStrangerFaceInfo|repeat info=" + paramFaceInfo);
      }
      return;
    }
    a((String)localObject, true);
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(paramFaceInfo.b));
    localObject = localArrayList;
    if (localArrayList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(paramFaceInfo.b), localObject);
    }
    ((ArrayList)localObject).add(paramFaceInfo);
    b();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (a(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    while (!"MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {
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
          localArrayList.add(paramString);
        }
      }
    }
    for (;;)
    {
      int i;
      if (i < localArrayList.size())
      {
        localObject2 = (String)localArrayList.get(i);
        this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
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
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("MultibusidURLSvr.HeadUrlReq");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject3;
    }
    int i;
    Object localObject2;
    Object localObject4;
    label786:
    label804:
    int k;
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject3;
        if (paramObject != null)
        {
          localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
          ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramObject = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.FaceHandler", 2, "handleStrangerFaceResp multiBusidUrlRsp mergeFrom exception..." + localException.getMessage());
        }
        localException.printStackTrace();
        continue;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      if (!QLog.isColorLevel()) {
        break label804;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("start ====================================================================================\n\n");
      paramFromServiceMsg.append("QQHead_Stranger response.srcUidType=" + paramObject.srcUidType.get()).append(";srcUin=" + paramObject.srcUin.get()).append("\n\n").append(";srcTid=" + paramObject.srcTid.get()).append(";srcOpenid=" + paramObject.srcOpenid.get()).append("\n\n").append(";dstUidType=" + paramObject.dstUidType.get()).append(";result=" + paramObject.result.get()).append("\n\n");
      localObject2 = paramObject.dstUsrHeadInfos.get();
      if (localObject2 == null) {
        break label786;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiHeadUrl.RspUsrHeadInfo)((Iterator)localObject2).next();
        paramFromServiceMsg.append("-------------------------------------------------------------------------------------\n\n");
        paramFromServiceMsg.append("RspUsrHeadInfo.dstUin=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstUin.get()).append(";dstTid=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstTid.get()).append(";dstOpenid=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstOpenid.get()).append("\n\n");
        localObject3 = ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstHeadInfos.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (MultiHeadUrl.RspHeadInfo)((Iterator)localObject3).next();
          paramFromServiceMsg.append("RspHeadInfo.usrType=" + ((MultiHeadUrl.RspHeadInfo)localObject4).usrType.get()).append("\n\n").append(";faceType=" + ((MultiHeadUrl.RspHeadInfo)localObject4).faceType.get()).append("\n\n").append(";timestamp=" + ((MultiHeadUrl.RspHeadInfo)localObject4).timestamp.get()).append("\n\n").append(";faceFlag=" + ((MultiHeadUrl.RspHeadInfo)localObject4).faceFlag.get()).append("\n\n").append(";url=" + ((MultiHeadUrl.RspHeadInfo)localObject4).url.get()).append("\n\n").append(";sysid=" + ((MultiHeadUrl.RspHeadInfo)localObject4).sysid.get()).append("\n\n");
        }
      }
      paramFromServiceMsg.append("end ====================================================================================\n\n");
      QLog.i("Q.qqhead.FaceHandler", 2, paramFromServiceMsg.toString());
      localObject4 = paramObject.dstUsrHeadInfos.get();
      localObject3 = new ArrayList();
      paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("list");
      localArrayList = new ArrayList();
      k = paramObject.dstUidType.get();
      j = paramToServiceMsg.extraData.getInt("idType");
      localFaceManager = (FaceManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(215);
      localIterator1 = paramFromServiceMsg.iterator();
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
    ArrayList localArrayList;
    int j;
    FaceManager localFaceManager;
    Iterator localIterator1;
    FaceInfo localFaceInfo;
    if (localIterator1.hasNext())
    {
      localFaceInfo = (FaceInfo)localIterator1.next();
      localFaceInfo.a(FaceInfo.m);
      Iterator localIterator2 = ((List)localObject4).iterator();
      label921:
      if (localIterator2.hasNext())
      {
        paramToServiceMsg = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        if (k == 0)
        {
          paramObject = String.valueOf(paramToServiceMsg.dstUin.get());
          label958:
          if (!localFaceInfo.jdField_a_of_type_JavaLangString.equals(paramObject)) {
            break label1065;
          }
          localObject2 = paramToServiceMsg.dstHeadInfos.get();
          paramFromServiceMsg = null;
          paramToServiceMsg = null;
          Iterator localIterator3 = ((List)localObject2).iterator();
          label992:
          if (!localIterator3.hasNext()) {
            break label1091;
          }
          localObject2 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
          i = ((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get();
          if (i != 1) {
            break label1067;
          }
          paramFromServiceMsg = (FromServiceMsg)localObject2;
        }
      }
    }
    label1158:
    for (;;)
    {
      break label992;
      if (k == 1)
      {
        paramObject = String.valueOf(paramToServiceMsg.dstTid.get());
        break label958;
      }
      paramObject = paramToServiceMsg.dstOpenid.get();
      break label958;
      label1065:
      break label921;
      label1067:
      if ((i == 32) && (((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get() != 0))
      {
        paramToServiceMsg = (ToServiceMsg)localObject2;
        continue;
        label1091:
        if (paramToServiceMsg != null)
        {
          label1095:
          i = 0;
          paramFromServiceMsg = localFaceManager.a("stranger_" + String.valueOf(localFaceInfo.b) + "_" + localFaceInfo.jdField_a_of_type_JavaLangString);
          if (localFaceManager.a(localFaceInfo)) {
            break label1353;
          }
          i = 1;
          if (i == 0) {
            break label1396;
          }
          paramFromServiceMsg = new QQHeadInfo();
          paramFromServiceMsg.headLevel = localFaceInfo.jdField_a_of_type_Byte;
          paramFromServiceMsg.idType = j;
          paramFromServiceMsg.phoneNum = paramObject;
          paramFromServiceMsg.dwTimestamp = paramToServiceMsg.timestamp.get();
          paramFromServiceMsg.cHeadType = ((byte)paramToServiceMsg.faceType.get());
          paramFromServiceMsg.dstUsrType = 32;
          paramFromServiceMsg.dwFaceFlgas = ((byte)paramToServiceMsg.faceFlag.get());
          paramFromServiceMsg.downLoadUrl = paramToServiceMsg.url.get();
          paramFromServiceMsg.systemHeadID = ((short)paramToServiceMsg.sysid.get());
          paramFromServiceMsg.originUsrType = paramToServiceMsg.usrType.get();
          if (!paramToServiceMsg.headVerify.has()) {
            break label1398;
          }
        }
        label1353:
        label1396:
        label1398:
        for (paramToServiceMsg = paramToServiceMsg.headVerify.get();; paramToServiceMsg = "")
        {
          paramFromServiceMsg.headVerify = paramToServiceMsg;
          localFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo = paramFromServiceMsg;
          localArrayList.add(localFaceInfo);
          break label921;
          if (paramFromServiceMsg != null)
          {
            paramToServiceMsg = paramFromServiceMsg;
            break label1095;
          }
          if (!QLog.isColorLevel()) {
            break label921;
          }
          QLog.d("Q.qqhead.FaceHandler", 2, "there is no headinfo uin=" + paramObject);
          break label921;
          break;
          if (paramFromServiceMsg != null)
          {
            if (paramFromServiceMsg.headImgTimestamp != paramToServiceMsg.timestamp.get())
            {
              i = 1;
              break label1158;
            }
            ((List)localObject3).add(localFaceInfo);
            break label1158;
          }
          i = 1;
          break label1158;
          break label921;
        }
        i = 0;
        while (i < localArrayList.size())
        {
          localFaceManager.a((FaceInfo)localArrayList.get(i));
          i += 1;
        }
        if (((List)localObject3).size() <= 0) {
          break;
        }
        try
        {
          paramToServiceMsg = new ArrayList();
          i = 0;
          while (i < ((List)localObject3).size())
          {
            paramFromServiceMsg = (FaceInfo)((List)localObject3).get(i);
            paramToServiceMsg.add("stranger_" + String.valueOf(j) + "_" + paramFromServiceMsg.jdField_a_of_type_JavaLangString);
            a(paramFromServiceMsg.b(), false);
            i += 1;
          }
          localFaceManager.a(paramToServiceMsg, System.currentTimeMillis());
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          return;
        }
      }
    }
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      boolean bool1;
      boolean bool3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramString)) {
          break label212;
        }
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
          bool1 = false;
          bool2 = bool1;
          if (!bool1)
          {
            bool3 = SystemUtil.a();
            if (((bool3) && (SystemUtil.a() < 2048L)) || ((!bool3) && (SystemUtil.b() < 102400L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.FaceHandler", 2, "getQQHead|fail, storage is not enough. key=" + paramString + ", isExistSDCard=" + bool3);
              }
              bool2 = true;
            }
          }
          else
          {
            return bool2;
          }
        }
        else
        {
          bool1 = true;
        }
      }
      boolean bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getApp().getApplicationContext(), true);
          return bool1;
          label212:
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FaceHandler
 * JD-Core Version:    0.7.0.1
 */