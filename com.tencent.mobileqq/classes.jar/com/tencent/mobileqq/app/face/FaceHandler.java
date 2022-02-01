package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.pb.MessageMicro;
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

public class FaceHandler
  extends BusinessHandler
{
  AppInterface a;
  private Hashtable<Integer, ArrayList<FaceInfo>> b = new Hashtable();
  private Hashtable<String, Long> c = new Hashtable();
  private Object d = new Object();
  private boolean e = false;
  
  public FaceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
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
    try
    {
      this.a.getCurrentAccountUin();
      Enumeration localEnumeration = this.b.keys();
      while (localEnumeration.hasMoreElements())
      {
        int i = ((Integer)localEnumeration.nextElement()).intValue();
        Object localObject2 = (ArrayList)this.b.get(Integer.valueOf(i));
        if ((i != 200) && (i != 202))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkWaitingRequests,key =");
            ((StringBuilder)localObject2).append(i);
            QLog.d("Q.qqhead.FaceHandler", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else {
          a(i, (ArrayList)localObject2);
        }
      }
      this.b.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void a(int paramInt, ArrayList<FaceInfo> paramArrayList)
  {
    boolean bool = QLog.isColorLevel();
    int k = 0;
    Object localObject1;
    int i;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("realGetStrangerFace");
      ((StringBuilder)localObject1).append(", size=");
      if (paramArrayList != null) {
        i = paramArrayList.size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject1).append(i);
      if (paramArrayList != null)
      {
        i = 0;
        while (i < paramArrayList.size())
        {
          ((StringBuilder)localObject1).append(',');
          ((StringBuilder)localObject1).append(paramArrayList.get(i));
          i += 1;
        }
      }
      QLog.i("Q.qqhead.FaceHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      if (paramInt == 202) {
        i = 1;
      } else {
        i = 0;
      }
      localObject1 = new MultiHeadUrl.MultiBusidUrlReq();
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUidType.set(0);
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUin.set(Long.parseLong(this.a.getCurrentAccountUin()));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.add(Integer.valueOf(1));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.add(Integer.valueOf(32));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUidType.set(i);
      int j = 0;
      Object localObject3;
      while (j < paramArrayList.size())
      {
        localObject2 = (FaceInfo)paramArrayList.get(j);
        localObject3 = new MultiHeadUrl.ReqUsrInfo();
        if (i == 0) {}
        try
        {
          ((MultiHeadUrl.ReqUsrInfo)localObject3).dstUin.set(Long.parseLong(((FaceInfo)localObject2).c));
          if (i == 1)
          {
            ((MultiHeadUrl.ReqUsrInfo)localObject3).dstTid.set(Long.parseLong(((FaceInfo)localObject2).c));
            ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrInfos.add((MessageMicro)localObject3);
            ((FaceInfo)localObject2).a(FaceInfo.x);
          }
        }
        catch (Exception localException)
        {
          label300:
          break label300;
        }
        j += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("QQHead_Stranger request.srcUidType=");
        ((StringBuilder)localObject3).append(((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUidType.get());
        ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(";srcUin=");
        ((StringBuilder)localObject3).append(this.a.getCurrentAccountUin());
        ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
        ((StringBuilder)localObject2).append("\n\n");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(";dstUsrType=");
        ((StringBuilder)localObject3).append(((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.get());
        ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(";dstUidType=");
        ((StringBuilder)localObject3).append(((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUidType.get());
        ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
        ((StringBuilder)localObject2).append("\n\n");
        ((StringBuilder)localObject2).append(";uinset={");
        if (paramArrayList != null)
        {
          i = k;
          while (i < paramArrayList.size())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramArrayList.get(i));
            ((StringBuilder)localObject3).append(",");
            ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
            i += 1;
          }
        }
        ((StringBuilder)localObject2).append("}");
        QLog.i("Q.qqhead.FaceHandler", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
      ((ToServiceMsg)localObject2).extraData.putParcelableArrayList("list", paramArrayList);
      ((ToServiceMsg)localObject2).extraData.putLong("startTime", System.currentTimeMillis());
      ((ToServiceMsg)localObject2).extraData.putInt("idType", paramInt);
      ((ToServiceMsg)localObject2).putWupBuffer(((MultiHeadUrl.MultiBusidUrlReq)localObject1).toByteArray());
      sendPbReq((ToServiceMsg)localObject2);
    }
    else
    {
      return;
    }
  }
  
  private void a(MultiHeadUrl.MultiBusidUrlRsp paramMultiBusidUrlRsp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("start ====================================================================================\n\n");
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QQHead_Stranger response.srcUidType=");
      ((StringBuilder)localObject1).append(paramMultiBusidUrlRsp.srcUidType.get());
      localStringBuilder1.append(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(";srcUin=");
      ((StringBuilder)localObject1).append(paramMultiBusidUrlRsp.srcUin.get());
      localStringBuilder1.append(((StringBuilder)localObject1).toString());
      localStringBuilder1.append("\n\n");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(";srcTid=");
      ((StringBuilder)localObject1).append(paramMultiBusidUrlRsp.srcTid.get());
      localStringBuilder1.append(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(";srcOpenid=");
      ((StringBuilder)localObject1).append(paramMultiBusidUrlRsp.srcOpenid.get());
      localStringBuilder1.append(((StringBuilder)localObject1).toString());
      localStringBuilder1.append("\n\n");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(";dstUidType=");
      ((StringBuilder)localObject1).append(paramMultiBusidUrlRsp.dstUidType.get());
      localStringBuilder1.append(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(";result=");
      ((StringBuilder)localObject1).append(paramMultiBusidUrlRsp.result.get());
      localStringBuilder1.append(((StringBuilder)localObject1).toString());
      localStringBuilder1.append("\n\n");
      paramMultiBusidUrlRsp = paramMultiBusidUrlRsp.dstUsrHeadInfos.get();
      if (paramMultiBusidUrlRsp != null)
      {
        paramMultiBusidUrlRsp = paramMultiBusidUrlRsp.iterator();
        while (paramMultiBusidUrlRsp.hasNext())
        {
          localObject1 = (MultiHeadUrl.RspUsrHeadInfo)paramMultiBusidUrlRsp.next();
          localStringBuilder1.append("-------------------------------------------------------------------------------------\n\n");
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RspUsrHeadInfo.dstUin=");
          ((StringBuilder)localObject2).append(((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstUin.get());
          localStringBuilder1.append(((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(";dstTid=");
          ((StringBuilder)localObject2).append(((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstTid.get());
          localStringBuilder1.append(((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(";dstOpenid=");
          ((StringBuilder)localObject2).append(((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstOpenid.get());
          localStringBuilder1.append(((StringBuilder)localObject2).toString());
          localStringBuilder1.append("\n\n");
          localObject1 = ((MultiHeadUrl.RspUsrHeadInfo)localObject1).dstHeadInfos.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MultiHeadUrl.RspHeadInfo)((Iterator)localObject1).next();
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("RspHeadInfo.usrType=");
            localStringBuilder2.append(((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get());
            localStringBuilder1.append(localStringBuilder2.toString());
            localStringBuilder1.append("\n\n");
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(";faceType=");
            localStringBuilder2.append(((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get());
            localStringBuilder1.append(localStringBuilder2.toString());
            localStringBuilder1.append("\n\n");
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(";timestamp=");
            localStringBuilder2.append(((MultiHeadUrl.RspHeadInfo)localObject2).timestamp.get());
            localStringBuilder1.append(localStringBuilder2.toString());
            localStringBuilder1.append("\n\n");
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(";faceFlag=");
            localStringBuilder2.append(((MultiHeadUrl.RspHeadInfo)localObject2).faceFlag.get());
            localStringBuilder1.append(localStringBuilder2.toString());
            localStringBuilder1.append("\n\n");
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(";url=");
            localStringBuilder2.append(((MultiHeadUrl.RspHeadInfo)localObject2).url.get());
            localStringBuilder1.append(localStringBuilder2.toString());
            localStringBuilder1.append("\n\n");
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(";sysid=");
            localStringBuilder2.append(((MultiHeadUrl.RspHeadInfo)localObject2).sysid.get());
            localStringBuilder1.append(localStringBuilder2.toString());
            localStringBuilder1.append("\n\n");
          }
        }
      }
      localStringBuilder1.append("end ====================================================================================\n\n");
      QLog.i("Q.qqhead.FaceHandler", 2, localStringBuilder1.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("list");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleGetQQHeadError, result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", listSize=");
    if (paramToServiceMsg != null) {
      paramInt = paramToServiceMsg.size();
    } else {
      paramInt = -1;
    }
    localStringBuilder.append(paramInt);
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() != 0))
    {
      paramInt = 0;
      while (paramInt < paramToServiceMsg.size())
      {
        FaceInfo localFaceInfo = (FaceInfo)paramToServiceMsg.get(paramInt);
        a(localFaceInfo.b(), false);
        localStringBuilder.append("info=");
        localStringBuilder.append(localFaceInfo);
        paramInt += 1;
      }
      QLog.i("Q.qqhead.FaceHandler", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("Q.qqhead.FaceHandler", 1, localStringBuilder.toString());
  }
  
  private void a(List<MultiHeadUrl.RspUsrHeadInfo> paramList, List<FaceInfo> paramList1, ArrayList<FaceInfo> paramArrayList, List<FaceInfo> paramList2, int paramInt1, int paramInt2, IQQAvatarManagerService paramIQQAvatarManagerService)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    while (localIterator1.hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)localIterator1.next();
      localFaceInfo.a(FaceInfo.y);
      Iterator localIterator2 = paramList.iterator();
      label529:
      while (localIterator2.hasNext())
      {
        paramArrayList = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        String str = a(paramInt1, paramArrayList);
        if (localFaceInfo.c.equals(str))
        {
          Iterator localIterator3 = paramArrayList.dstHeadInfos.get().iterator();
          Object localObject1 = null;
          paramArrayList = null;
          int i;
          Object localObject2;
          for (;;)
          {
            boolean bool = localIterator3.hasNext();
            i = 1;
            if (!bool) {
              break;
            }
            localObject2 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
            i = ((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get();
            if (i == 1) {
              paramArrayList = (ArrayList<FaceInfo>)localObject2;
            } else if ((i == 32) && (((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get() != 0)) {
              localObject1 = localObject2;
            }
          }
          if (localObject1 == null)
          {
            if (paramArrayList != null) {
              localObject1 = paramArrayList;
            }
          }
          else
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("stranger_");
            paramArrayList.append(String.valueOf(localFaceInfo.d));
            paramArrayList.append("_");
            paramArrayList.append(localFaceInfo.c);
            paramArrayList = paramIQQAvatarManagerService.getFaceSetting(paramArrayList.toString());
            if (paramIQQAvatarManagerService.isFaceFileExist(localFaceInfo))
            {
              while ((paramArrayList == null) || (paramArrayList.headImgTimestamp != ((MultiHeadUrl.RspHeadInfo)localObject1).timestamp.get())) {}
              paramList1.add(localFaceInfo);
              i = 0;
            }
            if (i == 0) {
              break label529;
            }
            localObject2 = new QQHeadInfo();
            ((QQHeadInfo)localObject2).headLevel = localFaceInfo.f;
            ((QQHeadInfo)localObject2).idType = paramInt2;
            ((QQHeadInfo)localObject2).phoneNum = str;
            ((QQHeadInfo)localObject2).dwTimestamp = ((MultiHeadUrl.RspHeadInfo)localObject1).timestamp.get();
            ((QQHeadInfo)localObject2).cHeadType = ((byte)((MultiHeadUrl.RspHeadInfo)localObject1).faceType.get());
            ((QQHeadInfo)localObject2).dstUsrType = 32;
            ((QQHeadInfo)localObject2).dwFaceFlgas = ((byte)((MultiHeadUrl.RspHeadInfo)localObject1).faceFlag.get());
            ((QQHeadInfo)localObject2).downLoadUrl = ((MultiHeadUrl.RspHeadInfo)localObject1).url.get();
            ((QQHeadInfo)localObject2).systemHeadID = ((short)((MultiHeadUrl.RspHeadInfo)localObject1).sysid.get());
            ((QQHeadInfo)localObject2).originUsrType = ((MultiHeadUrl.RspHeadInfo)localObject1).usrType.get();
            if (((MultiHeadUrl.RspHeadInfo)localObject1).headVerify.has()) {
              paramArrayList = ((MultiHeadUrl.RspHeadInfo)localObject1).headVerify.get();
            } else {
              paramArrayList = "";
            }
            ((QQHeadInfo)localObject2).headVerify = paramArrayList;
            localFaceInfo.p = ((QQHeadInfo)localObject2);
            paramList2.add(localFaceInfo);
            continue;
          }
          if (QLog.isColorLevel())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("there is no headinfo uin=");
            paramArrayList.append(str);
            QLog.d("Q.qqhead.FaceHandler", 2, paramArrayList.toString());
          }
        }
      }
    }
  }
  
  public void a(FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getStrangerFaceInfo.faceInfo=");
      ((StringBuilder)localObject).append(paramFaceInfo);
      QLog.d("Q.qqhead.FaceHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramFaceInfo.b();
    if (a((String)localObject))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStrangerFaceInfo|repeat info=");
        ((StringBuilder)localObject).append(paramFaceInfo);
        QLog.d("Q.qqhead.FaceHandler", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    a((String)localObject, true);
    ArrayList localArrayList = (ArrayList)this.b.get(Integer.valueOf(paramFaceInfo.d));
    localObject = localArrayList;
    if (localArrayList == null)
    {
      localObject = new ArrayList();
      this.b.put(Integer.valueOf(paramFaceInfo.d), localObject);
    }
    ((ArrayList)localObject).add(paramFaceInfo);
    a();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null)
    {
      localObject1 = localObject2;
      try
      {
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          localObject1 = localObject2;
          if (paramObject != null)
          {
            localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
            ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
          }
        }
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleStrangerFaceResp multiBusidUrlRsp mergeFrom exception...");
          ((StringBuilder)localObject1).append(paramObject.getMessage());
          QLog.d("Q.qqhead.FaceHandler", 2, ((StringBuilder)localObject1).toString());
        }
        paramObject.printStackTrace();
        localObject1 = localObject2;
      }
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000) && (localObject1 != null) && (((MultiHeadUrl.MultiBusidUrlRsp)localObject1).result.get() == 0))
    {
      a((MultiHeadUrl.MultiBusidUrlRsp)localObject1);
      paramObject = ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).dstUsrHeadInfos.get();
      paramFromServiceMsg = new ArrayList();
      localObject2 = paramToServiceMsg.extraData.getParcelableArrayList("list");
      ArrayList localArrayList = new ArrayList();
      i = ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).dstUidType.get();
      int j = paramToServiceMsg.extraData.getInt("idType");
      paramToServiceMsg = (QQAvatarManagerServiceImpl)this.a.getRuntimeService(IQQAvatarManagerService.class, "nearby");
      a(paramObject, paramFromServiceMsg, (ArrayList)localObject2, localArrayList, i, j, paramToServiceMsg);
      i = 0;
      while (i < localArrayList.size())
      {
        paramToServiceMsg.downloadFace((FaceInfo)localArrayList.get(i));
        i += 1;
      }
      if (paramFromServiceMsg.size() > 0) {
        try
        {
          paramObject = new ArrayList();
          i = 0;
          while (i < paramFromServiceMsg.size())
          {
            localObject1 = (FaceInfo)paramFromServiceMsg.get(i);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("stranger_");
            ((StringBuilder)localObject2).append(String.valueOf(j));
            ((StringBuilder)localObject2).append("_");
            ((StringBuilder)localObject2).append(((FaceInfo)localObject1).c);
            paramObject.add(((StringBuilder)localObject2).toString());
            a(((FaceInfo)localObject1).b(), false);
            i += 1;
          }
          paramToServiceMsg.updateFaceTimestamp(paramObject, System.currentTimeMillis());
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
        }
      }
      return;
    }
    int i = 65535;
    if (localObject1 != null) {
      i = ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).result.get();
    } else if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, i);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject1 = this.d;
    if (!paramBoolean) {}
    try
    {
      this.c.remove(paramString);
    }
    finally
    {
      for (;;)
      {
        long l;
        ArrayList localArrayList;
        Object localObject2;
        for (;;)
        {
          throw paramString;
        }
        int i = 0;
      }
    }
    if (this.c.size() > 30)
    {
      l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.c.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l - ((Long)this.c.get(str)).longValue()) > 60000L) {
          localArrayList.add(paramString);
        }
      }
      while (i < localArrayList.size())
      {
        localObject2 = (String)localArrayList.get(i);
        this.c.remove(paramString);
        i += 1;
      }
    }
    this.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if (!this.c.containsKey(paramString)) {
          break label212;
        }
        long l = ((Long)this.c.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.c.remove(paramString);
          break label212;
          if (!bool1)
          {
            boolean bool2 = SystemUtil.a();
            if (((bool2) && (SystemUtil.b() < 2048L)) || ((!bool2) && (SystemUtil.c() < 102400L)))
            {
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("getQQHead|fail, storage is not enough. key=");
                ((StringBuilder)???).append(paramString);
                ((StringBuilder)???).append(", isExistSDCard=");
                ((StringBuilder)???).append(bool2);
                QLog.d("Q.qqhead.FaceHandler", 2, ((StringBuilder)???).toString());
              }
              return true;
            }
            if ((!bool2) && (!this.e))
            {
              this.e = true;
              FaceUtil.a(this.a.getApp().getApplicationContext(), true);
            }
          }
          return bool1;
        }
      }
      boolean bool1 = true;
      continue;
      label212:
      bool1 = false;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return FaceObserver.class;
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
        QLog.d("Q.qqhead.FaceHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceHandler
 * JD-Core Version:    0.7.0.1
 */