package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.BlockListNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.BlockUinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.MsgBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.BlockUinInfo;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyAddBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyDelBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyGetBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.RspBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.RspBodyGetBlockList;
import tencent.im.sso2sns.sso2sns_comm_info.Sso2SnsCommInfo;

public class ShieldListHandler
  extends BusinessHandler
{
  private ConcurrentLinkedQueue<ShieldOperationItem> a = new ConcurrentLinkedQueue();
  private volatile boolean b = false;
  private volatile int c = -1;
  private ConcurrentHashMap<String, ShieldListInfo> d = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ShieldListInfo> e = new ConcurrentHashMap();
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private String l = null;
  private String m = null;
  private String n = null;
  private QQAppInterface o;
  
  ShieldListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.o = paramQQAppInterface;
    this.f = paramQQAppInterface.getApplication().getString(2131916592);
    this.g = paramQQAppInterface.getApplication().getString(2131916593);
    this.h = paramQQAppInterface.getApplication().getString(2131916590);
    this.i = paramQQAppInterface.getApplication().getString(2131916594);
    this.k = paramQQAppInterface.getApplication().getString(2131916588);
    this.l = paramQQAppInterface.getApplication().getString(2131916586);
    this.m = paramQQAppInterface.getApplication().getString(2131916589);
    this.j = paramQQAppInterface.getApplication().getString(2131916591);
    this.n = paramQQAppInterface.getApplication().getString(2131916587);
  }
  
  private String a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    Object localObject1 = "";
    if (paramInt != 1006)
    {
      Object localObject2;
      Object localObject3;
      if (paramBoolean)
      {
        localObject1 = this.f;
        localObject2 = ChatActivityUtils.b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append("");
        if (((Queue)localObject2).contains(((StringBuilder)localObject3).toString()))
        {
          localObject1 = this.g;
          localObject2 = ChatActivityUtils.b;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramLong);
          ((StringBuilder)localObject3).append("");
          ((Queue)localObject2).remove(((StringBuilder)localObject3).toString());
        }
        localObject2 = localObject1;
        if (paramInt == 1024)
        {
          localObject3 = (QidianManager)this.o.getManager(QQManagerFactory.QIDIAN_MANAGER);
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (!((QidianManager)localObject3).e(paramString))
            {
              localObject2 = localObject1;
              if (((QidianManager)localObject3).m(paramString)) {}
            }
          }
          else
          {
            localObject2 = this.i;
          }
        }
        localObject1 = localObject2;
        if ((paramInt == 1044) || (paramInt == 1045)) {
          return this.j;
        }
      }
      else
      {
        localObject2 = this.k;
        localObject1 = localObject2;
        if (paramInt == 1024)
        {
          localObject3 = (QidianManager)this.o.getManager(QQManagerFactory.QIDIAN_MANAGER);
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (!((QidianManager)localObject3).e(paramString))
            {
              localObject1 = localObject2;
              if (((QidianManager)localObject3).m(paramString)) {}
            }
          }
          else
          {
            localObject1 = this.m;
          }
        }
        if ((paramInt == 1044) || (paramInt == 1045)) {
          return this.n;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShieldListHandler", 2, "<---insertShieldMsgIntoMsgPool : isContactMsgType!");
      }
      if (paramString != null)
      {
        if (paramBoolean) {
          return this.h;
        }
        localObject1 = this.l;
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt)
  {
    this.c = paramInt;
    if (this.o.getCurrentAccountUin() != null)
    {
      Object localObject = this.o.getApp().getSharedPreferences(this.o.getCurrentAccountUin(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("lastGetShieldListTime", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setLastGetShieldListTime lastTime = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<shield_get><S> : sendGetShieldListReqInternal : queue size:");
      ((StringBuilder)localObject1).append(this.a.size());
      QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject3 = Long.valueOf(this.o.getCurrentAccountUin());
    int i1 = e();
    Object localObject1 = createToServiceMsg("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList");
    Object localObject2 = new sso2sns_comm_info.Sso2SnsCommInfo();
    ((sso2sns_comm_info.Sso2SnsCommInfo)localObject2).uint32_seq.set(1234);
    sso2sns_0x3_blocklist.ReqBodyGetBlockList localReqBodyGetBlockList = new sso2sns_0x3_blocklist.ReqBodyGetBlockList();
    localReqBodyGetBlockList.uint64_uin.set(((Long)localObject3).longValue());
    localReqBodyGetBlockList.uint32_get_type.set(paramInt1);
    localReqBodyGetBlockList.uint32_start_pos.set(paramInt2);
    localReqBodyGetBlockList.uint32_want_num.set(1000);
    localReqBodyGetBlockList.fixed32_last_get_time.set(i1);
    localObject3 = new sso2sns_0x3_blocklist.ReqBody();
    ((sso2sns_0x3_blocklist.ReqBody)localObject3).msg_body_get_blocklist.set(localReqBodyGetBlockList);
    localObject2 = a((sso2sns_comm_info.Sso2SnsCommInfo)localObject2, (sso2sns_0x3_blocklist.ReqBody)localObject3);
    ((ToServiceMsg)localObject1).setTimeout(60000L);
    ((ToServiceMsg)localObject1).putWupBuffer((byte[])localObject2);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  private void a(ShieldOperationItem paramShieldOperationItem)
  {
    synchronized (this.a)
    {
      this.a.add(paramShieldOperationItem);
      b();
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield><TO><---handleOperatingShieldList time out.");
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (str != null)
    {
      if (str.length() == 0) {
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str)) {
        e(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, long[] paramArrayOfLong)
  {
    String str1 = this.o.getCurrentAccountUin();
    ArrayList localArrayList = new ArrayList();
    int i1 = paramArrayOfLong.length;
    int i2 = 0;
    while (i2 < i1)
    {
      long l1 = paramArrayOfLong[i2];
      long l2 = MessageCache.c();
      int i3 = ShieldListInfo.SOURCE_ID_2_AIO_TYPE(paramInt);
      Object localObject = String.valueOf(l1);
      if (i3 == 1006) {
        localObject = ContactUtils.c(this.o, String.valueOf(l1));
      }
      String str2 = a(paramBoolean, l1, i3, (String)localObject);
      if (!TextUtils.isEmpty(str2))
      {
        MessageRecord localMessageRecord = MessageRecordFactory.a(-2012);
        localMessageRecord.init(str1, (String)localObject, str1, str2, l2, 0, i3, 0L);
        localMessageRecord.msgtype = -2012;
        int i4 = 1;
        localMessageRecord.isread = true;
        localObject = this.o.getMessageFacade().h((String)localObject, i3);
        if ((localObject != null) && (((List)localObject).size() > 0) && (MsgProxyUtils.a((MessageRecord)((List)localObject).get(((List)localObject).size() - 1), localMessageRecord, false)))
        {
          i3 = i4;
          if (QLog.isColorLevel())
          {
            QLog.w("ShieldListHandler", 2, "insertShieldMsgIntoMsgPool filtered!");
            i3 = i4;
          }
        }
        else
        {
          i3 = 0;
        }
        if (i3 == 0) {
          localArrayList.add(localMessageRecord);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("<---insertShieldMsgIntoMsgPool : insert:");
          ((StringBuilder)localObject).append(localMessageRecord.toString());
          QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
      i2 += 1;
    }
    this.o.getMessageFacade().a(localArrayList, String.valueOf(str1), false);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte1 = (byte[])paramObject;
    Object localObject = paramFromServiceMsg.getServiceCmd();
    paramObject = new sso2sns_comm_info.Sso2SnsCommInfo();
    sso2sns_0x3_blocklist.RspBody localRspBody = new sso2sns_0x3_blocklist.RspBody();
    if (arrayOfByte1.length < 8)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return false;
    }
    long l1 = PkgTools.getLongData(arrayOfByte1, 0);
    long l2 = PkgTools.getLongData(arrayOfByte1, 4);
    int i1 = (int)l1;
    byte[] arrayOfByte3 = new byte[i1];
    int i2 = (int)l2;
    byte[] arrayOfByte2 = new byte[i2];
    System.arraycopy(arrayOfByte1, 8, arrayOfByte3, 0, i1);
    try
    {
      paramObject = (sso2sns_comm_info.Sso2SnsCommInfo)paramObject.mergeFrom(arrayOfByte3);
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception : parse Sso2SnsCommInfo failed.", paramObject);
      }
      paramObject = null;
    }
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: error: commInfo is null.");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return false;
    }
    if ((paramObject.uint32_result.has()) && (paramObject.uint32_result.get() == 0))
    {
      System.arraycopy(arrayOfByte1, (int)(l1 + 8L), arrayOfByte2, 0, i2);
      try
      {
        paramObject = (sso2sns_0x3_blocklist.RspBody)localRspBody.mergeFrom(arrayOfByte2);
        if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase((String)localObject)) {
          return a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase((String)localObject))
        {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return false;
        }
        if ("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase((String)localObject)) {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        return false;
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception : parse RspBody failed.", paramObject);
        }
        b(paramToServiceMsg, paramFromServiceMsg);
        return false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<---decodeSso2SnsCommInfo: error resultCode :");
      ((StringBuilder)localObject).append(paramObject.uint32_result.get());
      QLog.e("ShieldListHandler", 2, ((StringBuilder)localObject).toString());
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, sso2sns_0x3_blocklist.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><R><---handleGetShieldListResp.");
    }
    if (paramRspBody != null)
    {
      if (!paramRspBody.msg_body_get_blocklist.has()) {
        return false;
      }
      paramToServiceMsg = (sso2sns_0x3_blocklist.RspBodyGetBlockList)paramRspBody.msg_body_get_blocklist.get();
      int i2 = paramToServiceMsg.fixed32_get_time.get();
      int i3 = paramToServiceMsg.uint32_completed.get();
      int i4 = paramToServiceMsg.uint32_now_pos.get();
      int i5 = paramToServiceMsg.uint32_get_type.get();
      paramRspBody = paramToServiceMsg.rpt_msg_block_uin_info.get();
      paramToServiceMsg = (ShieldMsgManger)this.o.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      int i1;
      if (paramRspBody != null) {
        i1 = paramRspBody.size();
      } else {
        i1 = 0;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("<---handleGetShieldListResp : lastGetTime:");
        paramFromServiceMsg.append(i2);
        paramFromServiceMsg.append(",isComplete:");
        paramFromServiceMsg.append(i3);
        paramFromServiceMsg.append(",nowPos:");
        paramFromServiceMsg.append(i4);
        paramFromServiceMsg.append(",getType:");
        paramFromServiceMsg.append(i5);
        paramFromServiceMsg.append(",respSize:");
        paramFromServiceMsg.append(i1);
        QLog.d("ShieldListHandler", 2, paramFromServiceMsg.toString());
      }
      Object localObject1;
      if (i5 == 2)
      {
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          paramFromServiceMsg = paramRspBody.iterator();
          while (paramFromServiceMsg.hasNext())
          {
            localObject1 = (sso2sns_0x3_blocklist.BlockUinInfo)paramFromServiceMsg.next();
            paramRspBody = new ShieldListInfo();
            paramRspBody.uin = String.valueOf(((sso2sns_0x3_blocklist.BlockUinInfo)localObject1).uint64_block_uin.get());
            paramRspBody.flags = 1;
            paramRspBody.source_id = ((sso2sns_0x3_blocklist.BlockUinInfo)localObject1).uint32_source_id.get();
            paramRspBody.source_sub_id = ((sso2sns_0x3_blocklist.BlockUinInfo)localObject1).uint32_source_sub_id.get();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("<---handleGetShieldListResp : total data : shieldUin:");
              ((StringBuilder)localObject1).append(paramRspBody.uin);
              ((StringBuilder)localObject1).append(",source_id:");
              ((StringBuilder)localObject1).append(paramRspBody.source_id);
              ((StringBuilder)localObject1).append(",sub_ource_id:");
              ((StringBuilder)localObject1).append(paramRspBody.source_sub_id);
              QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject1).toString());
            }
            this.e.put(paramRspBody.uin, paramRspBody);
          }
        }
        if (i3 == 1)
        {
          bool = paramToServiceMsg.a(this.e);
          this.e.clear();
          break label620;
        }
      }
      else if (i5 == 1)
      {
        paramFromServiceMsg = new ArrayList();
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          paramRspBody = paramRspBody.iterator();
          while (paramRspBody.hasNext())
          {
            Object localObject2 = (sso2sns_0x3_blocklist.BlockUinInfo)paramRspBody.next();
            localObject1 = new ShieldListInfo();
            ((ShieldListInfo)localObject1).uin = String.valueOf(((sso2sns_0x3_blocklist.BlockUinInfo)localObject2).uint64_block_uin.get());
            ((ShieldListInfo)localObject1).flags = 1;
            ((ShieldListInfo)localObject1).source_id = ((sso2sns_0x3_blocklist.BlockUinInfo)localObject2).uint32_source_id.get();
            ((ShieldListInfo)localObject1).source_sub_id = ((sso2sns_0x3_blocklist.BlockUinInfo)localObject2).uint32_source_sub_id.get();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("<---handleGetShieldListResp : add data :");
              ((StringBuilder)localObject2).append(localObject1.toString());
              QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject2).toString());
            }
            paramFromServiceMsg.add(localObject1);
          }
        }
        bool = paramToServiceMsg.a(paramFromServiceMsg);
        break label620;
      }
      boolean bool = false;
      label620:
      if (i3 == 0)
      {
        a(i5, i4);
        return true;
      }
      if ((i3 == 1) && (bool)) {
        a(i2);
      }
    }
    return false;
  }
  
  private byte[] a(sso2sns_comm_info.Sso2SnsCommInfo paramSso2SnsCommInfo, sso2sns_0x3_blocklist.ReqBody paramReqBody)
  {
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[4];
    paramSso2SnsCommInfo = paramSso2SnsCommInfo.toByteArray();
    paramReqBody = paramReqBody.toByteArray();
    long l1 = paramSso2SnsCommInfo.length;
    long l2 = paramReqBody.length;
    PkgTools.dWord2Byte(arrayOfByte1, 0, l1);
    PkgTools.dWord2Byte(arrayOfByte2, 0, l2);
    ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer((int)(8L + l1 + l2));
    localByteArrayBuffer.append(arrayOfByte1, 0, 4);
    localByteArrayBuffer.append(arrayOfByte2, 0, 4);
    localByteArrayBuffer.append(paramSso2SnsCommInfo, 0, (int)l1);
    localByteArrayBuffer.append(paramReqBody, 0, (int)l2);
    return localByteArrayBuffer.toByteArray();
  }
  
  private void b()
  {
    synchronized (this.a)
    {
      boolean bool = this.a.isEmpty();
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("--->execNextShieldOperation : isShieldOperating:");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(",isEmpty:");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!this.b) && (!bool))
      {
        localObject1 = (ShieldOperationItem)this.a.poll();
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShieldListHandler", 2, "--->execNextShieldOperation : queque is empty.");
          }
          return;
        }
        int i1 = ((ShieldOperationItem)localObject1).a;
        this.b = true;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 == 3) {
              c((ShieldOperationItem)localObject1);
            }
          }
          else {
            b((ShieldOperationItem)localObject1);
          }
        }
        else {
          a(0, 0);
        }
        return;
      }
      return;
    }
  }
  
  private void b(ShieldOperationItem paramShieldOperationItem)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<shield_add><S> : sendGetShieldListReqInternal : queue size:");
      ((StringBuilder)localObject1).append(this.a.size());
      QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    long l1 = Long.valueOf(this.o.getCurrentAccountUin()).longValue();
    Object localObject1 = createToServiceMsg("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList");
    Object localObject2 = new sso2sns_comm_info.Sso2SnsCommInfo();
    ((sso2sns_comm_info.Sso2SnsCommInfo)localObject2).uint32_seq.set(1234);
    sso2sns_0x3_blocklist.ReqBodyAddBlockList localReqBodyAddBlockList = new sso2sns_0x3_blocklist.ReqBodyAddBlockList();
    localReqBodyAddBlockList.uint64_uin.set(l1);
    Object localObject3 = paramShieldOperationItem.d;
    int i2 = localObject3.length;
    int i1 = 0;
    while (i1 < i2)
    {
      l1 = localObject3[i1];
      sso2sns_0x3_blocklist.BlockUinInfo localBlockUinInfo = new sso2sns_0x3_blocklist.BlockUinInfo();
      localBlockUinInfo.uint64_block_uin.set(Long.valueOf(l1).longValue());
      localBlockUinInfo.uint32_source_id.set(paramShieldOperationItem.b);
      localBlockUinInfo.uint32_source_sub_id.set(0);
      localReqBodyAddBlockList.rpt_msg_block_uin_info.add(localBlockUinInfo);
      i1 += 1;
    }
    localObject3 = new sso2sns_0x3_blocklist.ReqBody();
    ((sso2sns_0x3_blocklist.ReqBody)localObject3).msg_body_add_blocklist.set(localReqBodyAddBlockList);
    localObject2 = a((sso2sns_comm_info.Sso2SnsCommInfo)localObject2, (sso2sns_0x3_blocklist.ReqBody)localObject3);
    ((ToServiceMsg)localObject1).setTimeout(60000L);
    ((ToServiceMsg)localObject1).extraData.putInt("opType", paramShieldOperationItem.a);
    ((ToServiceMsg)localObject1).extraData.putInt("source_id", paramShieldOperationItem.b);
    ((ToServiceMsg)localObject1).extraData.putInt("source_sub_id", paramShieldOperationItem.c);
    ((ToServiceMsg)localObject1).extraData.putLongArray("uinList", paramShieldOperationItem.d);
    ((ToServiceMsg)localObject1).extraData.putInt("fromType", paramShieldOperationItem.e);
    ((ToServiceMsg)localObject1).putWupBuffer((byte[])localObject2);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str != null)
    {
      if (str.length() == 0) {
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str)) {
        e(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, sso2sns_0x3_blocklist.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><R><---handleAddShieldListResp.");
    }
    paramRspBody = new ArrayList();
    paramFromServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
    int i2 = paramToServiceMsg.extraData.getInt("source_id");
    int i3 = paramToServiceMsg.extraData.getInt("source_sub_id");
    int i4 = paramToServiceMsg.extraData.getInt("fromType");
    int i5 = paramFromServiceMsg.length;
    int i1 = 0;
    while (i1 < i5)
    {
      long l1 = paramFromServiceMsg[i1];
      paramToServiceMsg = new ShieldListInfo();
      paramToServiceMsg.uin = String.valueOf(Long.valueOf(l1));
      paramToServiceMsg.source_id = i2;
      paramToServiceMsg.source_sub_id = i3;
      paramToServiceMsg.flags = 1;
      paramRspBody.add(paramToServiceMsg);
      i1 += 1;
    }
    ((ShieldMsgManger)this.o.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(paramRspBody);
    a(true, i2, paramFromServiceMsg);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<shield_add><R> : ");
      paramToServiceMsg.append(Arrays.toString(paramFromServiceMsg));
      QLog.d("ShieldListHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(2, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i4) });
  }
  
  private void c()
  {
    this.b = false;
    d();
    b();
  }
  
  private void c(ShieldOperationItem paramShieldOperationItem)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<shield_del><S> : sendDeleteShieldListReqInternal : queue size:");
      ((StringBuilder)localObject1).append(this.a.size());
      QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    long l1 = Long.valueOf(this.o.getCurrentAccountUin()).longValue();
    Object localObject1 = createToServiceMsg("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList");
    Object localObject2 = new sso2sns_comm_info.Sso2SnsCommInfo();
    ((sso2sns_comm_info.Sso2SnsCommInfo)localObject2).uint32_seq.set(1234);
    sso2sns_0x3_blocklist.ReqBodyDelBlockList localReqBodyDelBlockList = new sso2sns_0x3_blocklist.ReqBodyDelBlockList();
    localReqBodyDelBlockList.uint64_uin.set(l1);
    Object localObject3 = paramShieldOperationItem.d;
    int i2 = localObject3.length;
    int i1 = 0;
    while (i1 < i2)
    {
      l1 = localObject3[i1];
      localReqBodyDelBlockList.rpt_uint64_del_uin.add(Long.valueOf(l1));
      i1 += 1;
    }
    localObject3 = new sso2sns_0x3_blocklist.ReqBody();
    ((sso2sns_0x3_blocklist.ReqBody)localObject3).msg_body_del_blocklist.set(localReqBodyDelBlockList);
    localObject2 = a((sso2sns_comm_info.Sso2SnsCommInfo)localObject2, (sso2sns_0x3_blocklist.ReqBody)localObject3);
    ((ToServiceMsg)localObject1).extraData.putInt("opType", paramShieldOperationItem.a);
    ((ToServiceMsg)localObject1).extraData.putInt("source_id", paramShieldOperationItem.b);
    ((ToServiceMsg)localObject1).extraData.putInt("source_sub_id", paramShieldOperationItem.c);
    ((ToServiceMsg)localObject1).extraData.putLongArray("uinList", paramShieldOperationItem.d);
    ((ToServiceMsg)localObject1).extraData.putInt("fromType", paramShieldOperationItem.e);
    ((ToServiceMsg)localObject1).setTimeout(60000L);
    ((ToServiceMsg)localObject1).putWupBuffer((byte[])localObject2);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><E><---handleGetShieldListError.");
    }
    notifyUI(1, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, sso2sns_0x3_blocklist.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><R><---handleDeleteShieldListResp.");
    }
    paramRspBody = new ArrayList();
    paramFromServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
    int i2 = paramToServiceMsg.extraData.getInt("source_id");
    int i3 = paramToServiceMsg.extraData.getInt("source_sub_id");
    int i4 = paramToServiceMsg.extraData.getInt("fromType");
    int i5 = paramFromServiceMsg.length;
    int i1 = 0;
    while (i1 < i5)
    {
      long l1 = paramFromServiceMsg[i1];
      paramToServiceMsg = new ShieldListInfo();
      paramToServiceMsg.uin = String.valueOf(Long.valueOf(l1));
      paramToServiceMsg.source_id = i2;
      paramToServiceMsg.source_sub_id = i3;
      paramToServiceMsg.flags = 0;
      paramRspBody.add(paramToServiceMsg);
      i1 += 1;
    }
    ((ShieldMsgManger)this.o.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(paramRspBody);
    a(false, i2, paramFromServiceMsg);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<shield_del><R> : ");
      paramToServiceMsg.append(Arrays.toString(paramFromServiceMsg));
      QLog.d("ShieldListHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(3, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i4) });
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("flushPushCacheIntoDB : pushCache size");
      ((StringBuilder)localObject).append(this.d.size());
      QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (this.d.isEmpty()) {
      return;
    }
    Object localObject = new ArrayList();
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((ArrayList)localObject).add((ShieldListInfo)this.d.get(str));
    }
    ((ShieldMsgManger)this.o.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a((List)localObject);
    this.d.clear();
    notifyUI(4, true, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
    int i1 = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<shield_add><E> : handleAddShieldListError :");
      paramToServiceMsg.append(Arrays.toString(paramFromServiceMsg));
      QLog.d("ShieldListHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(2, false, new Object[] { paramFromServiceMsg, Integer.valueOf(i1) });
  }
  
  private int e()
  {
    if (this.c == -1) {
      this.c = this.o.getApp().getSharedPreferences(this.o.getCurrentAccountUin(), 0).getInt("lastGetShieldListTime", 0);
    }
    return this.c;
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
    int i1 = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<shield_del><E> : handleDeleteShieldListError : ");
      paramToServiceMsg.append(Arrays.toString(paramFromServiceMsg));
      QLog.d("ShieldListHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(3, false, new Object[] { paramFromServiceMsg, Integer.valueOf(i1) });
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><S> : sendGetShieldListReq");
    }
    ShieldOperationItem localShieldOperationItem = new ShieldOperationItem();
    localShieldOperationItem.a = 1;
    localShieldOperationItem.d = null;
    a(localShieldOperationItem);
  }
  
  public void a(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<shield_add><S> : msgType ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",uinList:");
      ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfLong));
      QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramArrayOfLong.length <= 0) {
      return;
    }
    Object localObject = new ShieldOperationItem();
    ((ShieldOperationItem)localObject).a = 2;
    ((ShieldOperationItem)localObject).b = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(paramInt1);
    ((ShieldOperationItem)localObject).d = paramArrayOfLong;
    ((ShieldOperationItem)localObject).e = paramInt2;
    if (((ShieldOperationItem)localObject).b != -1) {
      a((ShieldOperationItem)localObject);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    long[] arrayOfLong = new long[1];
    long l1;
    if (paramInt == 1006)
    {
      paramString = ContactUtils.b(this.o, paramString);
      if ((paramString != null) && (paramString.length() > 0))
      {
        l1 = Long.valueOf(paramString).longValue();
      }
      else
      {
        l1 = -1L;
        bool = false;
        break label76;
      }
    }
    else
    {
      l1 = Long.valueOf(paramString).longValue();
    }
    boolean bool = true;
    label76:
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("<---handleSendMsgErrorWhileShield : msgType:");
      paramString.append(paramInt);
      paramString.append(Arrays.toString(arrayOfLong));
      paramString.append(",hasUin:");
      paramString.append(bool);
      QLog.d("ShieldListHandler", 2, paramString.toString());
    }
    if (bool)
    {
      arrayOfLong[0] = l1;
      paramString = new ShieldListInfo();
      paramString.uin = String.valueOf(l1);
      paramString.source_id = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(paramInt);
      paramString.source_sub_id = 0;
      paramString.flags = 1;
      localArrayList.add(paramString);
      ((ShieldMsgManger)this.o.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(localArrayList);
      a(true, paramString.source_id, arrayOfLong);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_push><R><---handleShieldListOnlinePush.");
    }
    Object localObject1 = new SubMsgType0x30.MsgBody();
    try
    {
      paramArrayOfByte = (SubMsgType0x30.MsgBody)((SubMsgType0x30.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      label37:
      Object localObject2;
      ShieldListInfo localShieldListInfo;
      break label37;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ShieldListHandler", 2, "<---handleShieldListOnlinePush : fail to parse SubMsgType0x30.");
    }
    paramArrayOfByte = null;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_sub_cmd.has()) && (paramArrayOfByte.uint32_sub_cmd.get() == 1))
    {
      if (paramArrayOfByte.msg_s2c_blocklist_notify.has())
      {
        paramArrayOfByte = (SubMsgType0x30.BlockListNotify)paramArrayOfByte.msg_s2c_blocklist_notify.get();
        localObject1 = paramArrayOfByte.rpt_msg_block_uin_info.get();
        paramArrayOfByte = paramArrayOfByte.rpt_uint64_del_uin.get();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SubMsgType0x30.BlockUinInfo)((Iterator)localObject1).next();
            localShieldListInfo = new ShieldListInfo();
            localShieldListInfo.uin = String.valueOf(((SubMsgType0x30.BlockUinInfo)localObject2).uint64_block_uin.get());
            localShieldListInfo.source_id = ((SubMsgType0x30.BlockUinInfo)localObject2).uint32_source_id.get();
            localShieldListInfo.source_sub_id = ((SubMsgType0x30.BlockUinInfo)localObject2).uint32_source_sub_id.get();
            localShieldListInfo.flags = 1;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("<---handleShieldListOnlinePush : add: uin:");
              ((StringBuilder)localObject2).append(localShieldListInfo.uin);
              ((StringBuilder)localObject2).append(",source_id:");
              ((StringBuilder)localObject2).append(localShieldListInfo.source_id);
              QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject2).toString());
            }
            this.d.put(localShieldListInfo.uin, localShieldListInfo);
          }
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          localObject1 = paramArrayOfByte.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            long l1 = ((Long)((Iterator)localObject1).next()).longValue();
            localShieldListInfo = new ShieldListInfo();
            localShieldListInfo.uin = String.valueOf(l1);
            localShieldListInfo.flags = 0;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("<---handleShieldListOnlinePush : del: uin:");
              ((StringBuilder)localObject2).append(localShieldListInfo.uin);
              ((StringBuilder)localObject2).append(",source_id:");
              ((StringBuilder)localObject2).append(localShieldListInfo.source_id);
              QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject2).toString());
            }
            this.d.put(localShieldListInfo.uin, localShieldListInfo);
          }
        }
        localObject1 = this.o.getMsgHandler();
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShieldListHandler", 2, "handleShieldListOnlinePush, removeFriendFromBlackList");
          }
          ((MessageHandler)localObject1).a(paramArrayOfByte);
        }
      }
      if (!this.b)
      {
        d();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShieldListHandler", 2, "<---handleShieldListOnlinePush : is shield operating, put into cache.");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<---handleShieldListOnlinePush : msgBody is null or NotSupportSubCMd :");
      if (paramArrayOfByte == null) {
        paramArrayOfByte = "null";
      } else {
        paramArrayOfByte = Integer.valueOf(paramArrayOfByte.uint32_sub_cmd.get());
      }
      ((StringBuilder)localObject1).append(paramArrayOfByte);
      QLog.e("ShieldListHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void b(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<shield_del><S> : msgType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",uinList:");
      ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfLong));
      QLog.d("ShieldListHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramArrayOfLong != null)
    {
      if (paramArrayOfLong.length <= 0) {
        return;
      }
      localObject = new ShieldOperationItem();
      ((ShieldOperationItem)localObject).a = 3;
      ((ShieldOperationItem)localObject).b = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(paramInt1);
      ((ShieldOperationItem)localObject).d = paramArrayOfLong;
      ((ShieldOperationItem)localObject).e = paramInt2;
      if (((ShieldOperationItem)localObject).b != -1) {
        a((ShieldOperationItem)localObject);
      }
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ShieldListObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (str != null)
    {
      if (str.length() == 0) {
        return;
      }
      if (("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str)) || ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str)) || ("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str)))
      {
        boolean bool2 = false;
        boolean bool1;
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          try
          {
            bool1 = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          catch (Exception paramToServiceMsg)
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break label151;
            }
          }
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception.", paramToServiceMsg);
          bool1 = bool2;
        }
        else if ((paramFromServiceMsg.getResultCode() != 1002) && (paramFromServiceMsg.getResultCode() != 1013))
        {
          b(paramToServiceMsg, paramFromServiceMsg);
          bool1 = bool2;
        }
        else
        {
          a(paramToServiceMsg, paramFromServiceMsg);
          bool1 = bool2;
        }
        label151:
        if (!bool1) {
          c();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShieldListHandler
 * JD-Core Version:    0.7.0.1
 */