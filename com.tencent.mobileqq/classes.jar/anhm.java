import AvatarInfo.QQHeadInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.app.face.FaceInfo;>;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class anhm
  extends BusinessHandler
{
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Hashtable<Integer, ArrayList<FaceInfo>> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private Hashtable<String, Long> b = new Hashtable();
  
  public anhm(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  private String a(int paramInt, MultiHeadUrl.RspUsrHeadInfo paramRspUsrHeadInfo)
  {
    if (paramInt == 0) {
      return String.valueOf(paramRspUsrHeadInfo.dstUin.get());
    }
    if (paramInt == 1) {
      return String.valueOf(paramRspUsrHeadInfo.dstTid.get());
    }
    return paramRspUsrHeadInfo.dstOpenid.get();
  }
  
  private void a()
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
  
  private void a(int paramInt, ArrayList<FaceInfo> paramArrayList)
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
      Object localObject3 = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
      ((ToServiceMsg)localObject3).extraData.putParcelableArrayList("list", paramArrayList);
      ((ToServiceMsg)localObject3).extraData.putLong("startTime", System.currentTimeMillis());
      ((ToServiceMsg)localObject3).extraData.putInt("idType", paramInt);
      ((ToServiceMsg)localObject3).putWupBuffer(((MultiHeadUrl.MultiBusidUrlReq)localObject1).toByteArray());
      sendPbReq((ToServiceMsg)localObject3);
      return;
    }
  }
  
  private void a(MultiHeadUrl.MultiBusidUrlRsp paramMultiBusidUrlRsp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start ====================================================================================\n\n");
      localStringBuilder.append("QQHead_Stranger response.srcUidType=" + paramMultiBusidUrlRsp.srcUidType.get()).append(";srcUin=" + paramMultiBusidUrlRsp.srcUin.get()).append("\n\n").append(";srcTid=" + paramMultiBusidUrlRsp.srcTid.get()).append(";srcOpenid=" + paramMultiBusidUrlRsp.srcOpenid.get()).append("\n\n").append(";dstUidType=" + paramMultiBusidUrlRsp.dstUidType.get()).append(";result=" + paramMultiBusidUrlRsp.result.get()).append("\n\n");
      paramMultiBusidUrlRsp = paramMultiBusidUrlRsp.dstUsrHeadInfos.get();
      if (paramMultiBusidUrlRsp != null)
      {
        paramMultiBusidUrlRsp = paramMultiBusidUrlRsp.iterator();
        while (paramMultiBusidUrlRsp.hasNext())
        {
          Object localObject = (MultiHeadUrl.RspUsrHeadInfo)paramMultiBusidUrlRsp.next();
          localStringBuilder.append("-------------------------------------------------------------------------------------\n\n");
          localStringBuilder.append("RspUsrHeadInfo.dstUin=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject).dstUin.get()).append(";dstTid=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject).dstTid.get()).append(";dstOpenid=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject).dstOpenid.get()).append("\n\n");
          localObject = ((MultiHeadUrl.RspUsrHeadInfo)localObject).dstHeadInfos.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            MultiHeadUrl.RspHeadInfo localRspHeadInfo = (MultiHeadUrl.RspHeadInfo)((Iterator)localObject).next();
            localStringBuilder.append("RspHeadInfo.usrType=" + localRspHeadInfo.usrType.get()).append("\n\n").append(";faceType=" + localRspHeadInfo.faceType.get()).append("\n\n").append(";timestamp=" + localRspHeadInfo.timestamp.get()).append("\n\n").append(";faceFlag=" + localRspHeadInfo.faceFlag.get()).append("\n\n").append(";url=" + localRspHeadInfo.url.get()).append("\n\n").append(";sysid=" + localRspHeadInfo.sysid.get()).append("\n\n");
          }
        }
      }
      localStringBuilder.append("end ====================================================================================\n\n");
      QLog.i("Q.qqhead.FaceHandler", 2, localStringBuilder.toString());
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
  
  private void a(List<MultiHeadUrl.RspUsrHeadInfo> paramList, List<FaceInfo> paramList1, ArrayList<FaceInfo> paramArrayList, List<FaceInfo> paramList2, int paramInt1, int paramInt2, anho paramanho)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    FaceInfo localFaceInfo;
    label44:
    String str;
    Object localObject2;
    Object localObject1;
    label110:
    int i;
    if (localIterator1.hasNext())
    {
      localFaceInfo = (FaceInfo)localIterator1.next();
      localFaceInfo.a(FaceInfo.m);
      Iterator localIterator2 = paramList.iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          paramArrayList = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
          str = a(paramInt1, paramArrayList);
          if (localFaceInfo.jdField_a_of_type_JavaLangString.equals(str))
          {
            localObject2 = paramArrayList.dstHeadInfos.get();
            localObject1 = null;
            paramArrayList = null;
            Iterator localIterator3 = ((List)localObject2).iterator();
            if (localIterator3.hasNext())
            {
              localObject2 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
              i = ((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get();
              if (i == 1) {
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break label110;
      if ((i == 32) && (((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get() != 0))
      {
        paramArrayList = (ArrayList<FaceInfo>)localObject2;
        continue;
        if (paramArrayList != null)
        {
          label183:
          i = 0;
          localObject1 = paramanho.a("stranger_" + String.valueOf(localFaceInfo.b) + "_" + localFaceInfo.jdField_a_of_type_JavaLangString);
          if (paramanho.a(localFaceInfo)) {
            break label459;
          }
          i = 1;
          label247:
          if (i == 0) {
            break label503;
          }
          localObject1 = new QQHeadInfo();
          ((QQHeadInfo)localObject1).headLevel = localFaceInfo.jdField_a_of_type_Byte;
          ((QQHeadInfo)localObject1).idType = paramInt2;
          ((QQHeadInfo)localObject1).phoneNum = str;
          ((QQHeadInfo)localObject1).dwTimestamp = paramArrayList.timestamp.get();
          ((QQHeadInfo)localObject1).cHeadType = ((byte)paramArrayList.faceType.get());
          ((QQHeadInfo)localObject1).dstUsrType = 32;
          ((QQHeadInfo)localObject1).dwFaceFlgas = ((byte)paramArrayList.faceFlag.get());
          ((QQHeadInfo)localObject1).downLoadUrl = paramArrayList.url.get();
          ((QQHeadInfo)localObject1).systemHeadID = ((short)paramArrayList.sysid.get());
          ((QQHeadInfo)localObject1).originUsrType = paramArrayList.usrType.get();
          if (!paramArrayList.headVerify.has()) {
            break label505;
          }
        }
        label459:
        label503:
        label505:
        for (paramArrayList = paramArrayList.headVerify.get();; paramArrayList = "")
        {
          ((QQHeadInfo)localObject1).headVerify = paramArrayList;
          localFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo = ((QQHeadInfo)localObject1);
          paramList2.add(localFaceInfo);
          break label44;
          if (localObject1 != null)
          {
            paramArrayList = (ArrayList<FaceInfo>)localObject1;
            break label183;
          }
          if (!QLog.isColorLevel()) {
            break label44;
          }
          QLog.d("Q.qqhead.FaceHandler", 2, "there is no headinfo uin=" + str);
          break label44;
          break;
          if (localObject1 != null)
          {
            if (((Setting)localObject1).headImgTimestamp != paramArrayList.timestamp.get())
            {
              i = 1;
              break label247;
            }
            paramList1.add(localFaceInfo);
            break label247;
          }
          i = 1;
          break label247;
          break label44;
        }
        return;
      }
    }
  }
  
  public void a(FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceHandler", 2, "getStrangerFaceInfo.faceInfo=" + paramFaceInfo);
    }
    Object localObject = paramFaceInfo.b();
    if (a((String)localObject))
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
    a();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {
          break label413;
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
        QLog.d("Q.qqhead.FaceHandler", 2, "handleStrangerFaceResp multiBusidUrlRsp mergeFrom exception..." + paramObject.getMessage());
        paramObject.printStackTrace();
        paramObject = null;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int i = paramFromServiceMsg.getResultCode();
        continue;
        a(paramObject);
        Object localObject = paramObject.dstUsrHeadInfos.get();
        paramFromServiceMsg = new ArrayList();
        ArrayList localArrayList1 = paramToServiceMsg.extraData.getParcelableArrayList("list");
        ArrayList localArrayList2 = new ArrayList();
        i = paramObject.dstUidType.get();
        int k = paramToServiceMsg.extraData.getInt("idType");
        paramToServiceMsg = (anho)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(216);
        a((List)localObject, paramFromServiceMsg, localArrayList1, localArrayList2, i, k, paramToServiceMsg);
        i = 0;
        if (i >= localArrayList2.size()) {
          continue;
        }
        paramToServiceMsg.a((FaceInfo)localArrayList2.get(i));
        i += 1;
        continue;
        if (paramFromServiceMsg.size() <= 0) {
          continue;
        }
        try
        {
          paramObject = new ArrayList();
          i = j;
          if (i >= paramFromServiceMsg.size()) {
            continue;
          }
          localObject = (FaceInfo)paramFromServiceMsg.get(i);
          paramObject.add("stranger_" + String.valueOf(k) + "_" + ((FaceInfo)localObject).jdField_a_of_type_JavaLangString);
          a(((FaceInfo)localObject).b(), false);
          i += 1;
          continue;
          paramToServiceMsg.a(paramObject, System.currentTimeMillis());
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          return;
        }
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
      label413:
      paramObject = null;
    }
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
        this.b.remove(paramString);
        return;
      }
      finally {}
    }
    ArrayList localArrayList;
    Object localObject2;
    if (this.b.size() > 30)
    {
      long l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.b.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l - ((Long)this.b.get(str)).longValue()) > 60000L) {
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
        this.b.remove(paramString);
        i += 1;
      }
      else
      {
        this.b.put(paramString, Long.valueOf(System.currentTimeMillis()));
        break;
        i = 0;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      boolean bool1;
      boolean bool3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!this.b.containsKey(paramString)) {
          break label212;
        }
        long l = ((Long)this.b.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.b.remove(paramString);
          bool1 = false;
          bool2 = bool1;
          if (!bool1)
          {
            bool3 = SystemUtil.isExistSDCard();
            if (((bool3) && (SystemUtil.getSDCardAvailableSize() < 2048L)) || ((!bool3) && (SystemUtil.getSystemAvailableSize() < 102400L)))
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
          bful.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getApp().getApplicationContext(), true);
          return bool1;
          label212:
          bool1 = false;
        }
      }
    }
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return anhs.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    while (!"MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhm
 * JD-Core Version:    0.7.0.1
 */