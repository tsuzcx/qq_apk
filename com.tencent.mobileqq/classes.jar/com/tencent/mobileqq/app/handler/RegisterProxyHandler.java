package com.tencent.mobileqq.app.handler;

import GeneralSettings.Setting;
import RegisterProxySvcPack.RegisterPushNotice;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.RegPrxyCache;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import msf.registerproxy.register_proxy.DiscussList;
import msf.registerproxy.register_proxy.GroupList;
import msf.registerproxy.register_proxy.SvcPbResponsePullDisMsgProxy;
import msf.registerproxy.register_proxy.SvcRegisterProxyMsgResp;
import msf.registerproxy.register_proxy.SvcResponseMsgInfo;
import msf.registerproxy.register_proxy.SvcResponsePbPullGroupMsgProxy;
import org.json.JSONArray;
import org.json.JSONObject;

public class RegisterProxyHandler
{
  public static int a = 7;
  public static int b = 2;
  public static boolean c = true;
  public static boolean d = true;
  public static boolean l = false;
  private MessageHandleThread[] A = null;
  private Object B = new Object();
  private BaseMessageHandler C;
  private RegisterProxyHandler.Callback D;
  public ArrayList<MessageObject> e = null;
  public ArrayList<MessageObject> f = null;
  public volatile Pair<RegisterPushNotice, Long> g = null;
  public String[] h = null;
  public String[] i = null;
  public int j = 0;
  public int k = 0;
  public boolean m = false;
  public int n = 0;
  public boolean o = false;
  public boolean p = false;
  public final AtomicBoolean q = new AtomicBoolean(false);
  public int r = 0;
  public int s = 0;
  public int t = 0;
  public int u = 0;
  public HashMap<String, Boolean> v = new HashMap();
  public HashMap<String, Boolean> w = new HashMap();
  public long x = 0L;
  public ArrayList<Setting> y = null;
  public List<register_proxy.GroupList> z;
  
  public RegisterProxyHandler(BaseMessageHandler paramBaseMessageHandler)
  {
    this.C = paramBaseMessageHandler;
  }
  
  private ToServiceMsg a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendNewRegisterProxy , isGetPassword = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" ,randomSeq");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", isWakeFromDeepSleep = ");
    ((StringBuilder)localObject).append(paramBoolean2);
    QLog.d("MessageHandler", 1, ((StringBuilder)localObject).toString());
    localObject = this.C.createToServiceMsg("RegPrxySvc.infoSync");
    ((ToServiceMsg)localObject).extraData.putLong("requestOptional", 90562L);
    ((ToServiceMsg)localObject).extraData.putInt("endSeq", paramInt);
    ((ToServiceMsg)localObject).extraData.putInt("type", 1);
    ((ToServiceMsg)localObject).extraData.putBoolean("isGetPassword", paramBoolean1);
    long l1;
    if (paramBoolean2) {
      l1 = 1L;
    } else {
      l1 = 0L;
    }
    ((ToServiceMsg)localObject).extraData.putLong("ulReportFlag", l1);
    if (paramLong != 0L)
    {
      ((ToServiceMsg)localObject).getAttributes().put("_attr_regprxy_random_code", Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ReSendProxy] currentRegisterProxyRandom = ");
      localStringBuilder.append(paramLong);
      QLog.d("MessageHandler", 1, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private register_proxy.SvcRegisterProxyMsgResp a(byte[] paramArrayOfByte)
  {
    Object localObject = new register_proxy.SvcRegisterProxyMsgResp();
    try
    {
      paramArrayOfByte = (register_proxy.SvcRegisterProxyMsgResp)((register_proxy.SvcRegisterProxyMsgResp)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RegisterProxyHandler", 2, "handleNewRegisterProxyMsg : decode SvcRegisterProxyMsgResp pb:", paramArrayOfByte);
      }
      paramArrayOfByte = null;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.result.has()))
    {
      if ((paramArrayOfByte.seq.has()) && (paramArrayOfByte.seq.get() != this.j) && (paramArrayOfByte.seq.get() != this.k))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).setLength(0);
          ((StringBuilder)localObject).append("handleNewRegisterProxyMsg endSeq wrong! seq=");
          ((StringBuilder)localObject).append(paramArrayOfByte.seq.get());
          ((StringBuilder)localObject).append(" registerProxyEndSeq=");
          ((StringBuilder)localObject).append(this.j);
          ((StringBuilder)localObject).append(" registerProxyEndSeq_numTroop=");
          ((StringBuilder)localObject).append(this.k);
          QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject).toString());
        }
        return null;
      }
      return paramArrayOfByte;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxyHandler", 2, "handleNewRegisterProxyMsg package error!");
    }
    this.C.notifyUI(4004, false, null);
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(4, true, 0L, false);
    if (QLog.isColorLevel())
    {
      MessageCache localMessageCache = (MessageCache)this.C.b().getMsgCache();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needPullTroopNum:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" ,needPullDiscNum:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ,regPrxyError:");
      localStringBuilder.append(localMessageCache.d(false));
      QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if ((paramInt & 0x8) == 8)
    {
      QLog.d("RegisterProxyHandler", 1, "handleNewRegisterProxyMsg--> handleRestEnding!");
      this.p = true;
      ((IRegisterProxyService)QRoute.api(IRegisterProxyService.class)).onNewRegisterProxyRestPacketEnd();
      if ((this.p) && (c()) && (d())) {
        synchronized (this.q)
        {
          if (!this.q.get())
          {
            this.q.set(true);
            this.q.notifyAll();
          }
        }
      }
      long l1 = ((Long)paramFromServiceMsg.getAttribute("infoSync_timestamp")).longValue();
      paramFromServiceMsg = this.C.createToServiceMsg("RegPrxySvc.PbSyncMsg", null);
      paramFromServiceMsg.addAttribute("infoSync_timestamp", Long.valueOf(l1));
      paramFromServiceMsg.setMsfCommand(MsfCommand.msf_pbSyncMsg);
      this.C.send(paramFromServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.group_list.has())
    {
      QLog.d("RegisterProxyHandler", 1, "handleNewRegisterProxyMsg--> handleTroopList!");
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.group_list.get();
      this.z = paramSvcRegisterProxyMsgResp;
      MessageCache localMessageCache = (MessageCache)this.C.b().getMsgCache();
      MessageCache.d.a = paramSvcRegisterProxyMsgResp;
      int i1 = 0;
      while (i1 < paramSvcRegisterProxyMsgResp.size())
      {
        register_proxy.GroupList localGroupList = (register_proxy.GroupList)paramSvcRegisterProxyMsgResp.get(i1);
        if (localGroupList != null)
        {
          String str = String.valueOf(localGroupList.group_code.get());
          Object localObject = localMessageCache.B(str);
          long l2 = localMessageCache.M(str);
          long l1;
          if ((localObject != null) && (localObject.length > 0)) {
            l1 = ((Long)localObject[0]).longValue();
          } else {
            l1 = 0L;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).setLength(0);
          ((StringBuilder)localObject).append("handleNewRegisterProxyMsg getGroupList groupCode=");
          ((StringBuilder)localObject).append(localGroupList.group_code.get());
          ((StringBuilder)localObject).append(" groupSeq=");
          ((StringBuilder)localObject).append(localGroupList.group_seq.get());
          ((StringBuilder)localObject).append(" memberSeq=");
          ((StringBuilder)localObject).append(localGroupList.member_seq.get());
          ((StringBuilder)localObject).append(" mask=");
          ((StringBuilder)localObject).append(localGroupList.mask.get());
          ((StringBuilder)localObject).append(" localMemberMsgSeq=");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(" localLastSeq=");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(" redpack_time=");
          ((StringBuilder)localObject).append(localGroupList.redpack_time.get());
          ((StringBuilder)localObject).append(" hasMsg=");
          ((StringBuilder)localObject).append(localGroupList.has_msg.get());
          QLog.d("RegisterProxyHandler", 1, ((StringBuilder)localObject).toString());
          if ((localGroupList.mask.get() == 1L) || (localGroupList.mask.get() == 4L) || ((localGroupList.mask.get() == 3L) && (str.equals(k()))))
          {
            localMessageCache.c(str, new Object[] { Long.valueOf(localGroupList.member_seq.get()), Long.valueOf(localGroupList.group_seq.get()) });
            if (l1 < localGroupList.member_seq.get()) {
              if (localGroupList.group_seq.get() <= l2) {
                a(4, paramToServiceMsg, paramFromServiceMsg, localGroupList);
              } else {
                localMessageCache.a(str, 1);
              }
            }
          }
          if (localGroupList.mask.get() != 0L)
          {
            if (this.y == null) {
              this.y = new ArrayList();
            }
            localObject = new Setting();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("message.group.policy.");
            localStringBuilder.append(str);
            ((Setting)localObject).Path = localStringBuilder.toString();
            ((Setting)localObject).Value = String.valueOf(localGroupList.mask.get());
            this.y.add(localObject);
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PBBytesField paramPBBytesField)
  {
    if (paramPBBytesField.has()) {
      try
      {
        Object localObject = paramPBBytesField.get().toByteArray();
        int i1 = localObject.length - 4;
        paramPBBytesField = new byte[i1];
        PkgTools.copyData(paramPBBytesField, 0, (byte[])localObject, 4, i1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleNewRegisterProxyMsg--> decode ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", hashCode:");
        ((StringBuilder)localObject).append(paramPBBytesField.hashCode());
        QLog.e("RegisterProxyHandler", 1, ((StringBuilder)localObject).toString());
        a(1, paramToServiceMsg, paramFromServiceMsg, paramPBBytesField);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleNewRegisterProxyMsg--> decode ");
        paramFromServiceMsg.append(paramString);
        paramFromServiceMsg.append("error:");
        QLog.e("RegisterProxyHandler", 1, paramFromServiceMsg.toString(), paramToServiceMsg);
      }
    }
  }
  
  private boolean a(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    int i1 = paramSvcRegisterProxyMsgResp.result.get();
    if (QLog.isColorLevel())
    {
      paramSvcRegisterProxyMsgResp = new StringBuilder();
      paramSvcRegisterProxyMsgResp.append("handleNewRegisterProxyResultCode resultCode = ");
      paramSvcRegisterProxyMsgResp.append(i1);
      QLog.d("RegisterProxyHandler", 2, paramSvcRegisterProxyMsgResp.toString());
    }
    if (i1 != 0) {
      if (i1 != 1)
      {
        switch (i1)
        {
        default: 
          return false;
        case 104: 
          this.C.b(false);
          this.C.a(true, 0);
          break;
        case 103: 
          this.C.c(false);
          this.C.a(true, 2);
          break;
        case 102: 
          this.C.b(false);
          this.C.a(true, 1);
          break;
        case 100: 
          c = false;
          BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", false).commit();
          this.C.notifyUI(4004, false, null);
          return false;
        case 99: 
        case 101: 
          this.C.h();
          i1 = new Random().nextInt(3000);
          ThreadManager.getSubThreadHandler().postDelayed(new RegisterProxyHandler.1(this), i1);
          return false;
        }
      }
      else
      {
        this.C.notifyUI(4001, false, null);
        this.C.notifyUI(4016, false, null);
        this.C.notifyUI(4003, false, null);
        this.C.notifyUI(4002, false, null);
        return false;
      }
    }
    return true;
  }
  
  private long[] a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("--->>initBeforGetPullTroopMsgNumber, troopUinArray.length=");
      localStringBuilder.append(paramArrayOfString.length);
      localStringBuilder.append(", list=");
    }
    long[] arrayOfLong = new long[paramArrayOfString.length];
    MessageCache localMessageCache = (MessageCache)this.C.b().getMsgCache();
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      localMessageCache.a(paramArrayOfString[i1], 0);
      localMessageCache.P(paramArrayOfString[i1]);
      arrayOfLong[i1] = localMessageCache.M(paramArrayOfString[i1]);
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(paramArrayOfString[i1]);
        localStringBuilder.append(":");
        localStringBuilder.append(arrayOfLong[i1]);
        localStringBuilder.append(", ");
      }
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
    }
    return arrayOfLong;
  }
  
  private void b(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNewRegisterProxyMsg--> handleFirstEnding! isPullCircleStop: ");
      localStringBuilder.append(this.m);
      QLog.d("RegisterProxyHandler", 1, localStringBuilder.toString());
      this.o = true;
      if (e()) {
        this.C.notifyUI(4017, true, null);
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.gourp_msg.has())
    {
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.gourp_msg.get();
      int i2 = paramSvcRegisterProxyMsgResp.size();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNewRegisterProxyMsg--> handleTroopMsgResp_PB, gourp_msg size:");
      ((StringBuilder)localObject).append(i2);
      QLog.d("RegisterProxyHandler", 1, ((StringBuilder)localObject).toString());
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = (register_proxy.SvcResponsePbPullGroupMsgProxy)paramSvcRegisterProxyMsgResp.get(i1);
        if (this.o) {
          a(2, paramToServiceMsg, paramFromServiceMsg, localObject, false);
        } else {
          a(2, paramToServiceMsg, paramFromServiceMsg, localObject, true);
        }
        i1 += 1;
      }
    }
  }
  
  private void b(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.msg_info.has())
    {
      this.r = ((register_proxy.SvcResponseMsgInfo)paramSvcRegisterProxyMsgResp.msg_info.get()).group_num.get();
      this.s = ((register_proxy.SvcResponseMsgInfo)paramSvcRegisterProxyMsgResp.msg_info.get()).discuss_num.get();
      paramSvcRegisterProxyMsgResp = new StringBuilder();
      paramSvcRegisterProxyMsgResp.append("handleNewRegisterProxyMsg ,groupNum=");
      paramSvcRegisterProxyMsgResp.append(this.r);
      paramSvcRegisterProxyMsgResp.append(",discussionNum=");
      paramSvcRegisterProxyMsgResp.append(this.s);
      QLog.e("RegisterProxyHandler", 1, paramSvcRegisterProxyMsgResp.toString());
      int i1 = this.r;
      if ((i1 == 0) || (this.t >= i1)) {
        this.C.notifyUI(4003, true, null);
      }
      i1 = this.s;
      if ((i1 == 0) || (this.u >= i1)) {
        this.C.notifyUI(4002, true, null);
      }
    }
  }
  
  private HashMap<Integer, String[]> c(int paramInt)
  {
    return this.D.a(paramInt);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.discuss_msg.has())
    {
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.discuss_msg.get();
      int i2 = paramSvcRegisterProxyMsgResp.size();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNewRegisterProxyMsg--> handleDiscussMsgResp_PB, discuss_msg size:");
      ((StringBuilder)localObject).append(i2);
      QLog.d("RegisterProxyHandler", 1, ((StringBuilder)localObject).toString());
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = (register_proxy.SvcPbResponsePullDisMsgProxy)paramSvcRegisterProxyMsgResp.get(i1);
        if (this.o) {
          a(3, paramToServiceMsg, paramFromServiceMsg, localObject, false);
        } else {
          a(3, paramToServiceMsg, paramFromServiceMsg, localObject, true);
        }
        i1 += 1;
      }
    }
  }
  
  private void c(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    boolean bool;
    if ((paramSvcRegisterProxyMsgResp.discuss_list_flag.has()) && (paramSvcRegisterProxyMsgResp.discuss_list_flag.get() == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleNewRegisterProxyMsg needDealDiscussList=");
    ((StringBuilder)localObject1).append(bool);
    QLog.d("RegisterProxyHandler", 1, ((StringBuilder)localObject1).toString());
    if (bool)
    {
      localObject1 = (MessageCache)this.C.b().getMsgCache();
      if (paramSvcRegisterProxyMsgResp.discuss_list.has())
      {
        QLog.d("RegisterProxyHandler", 1, "handleNewRegisterProxyMsg--> handleDiscussList!");
        paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.discuss_list.get();
        MessageCache.d.b = paramSvcRegisterProxyMsgResp;
        int i1 = 0;
        while (i1 < paramSvcRegisterProxyMsgResp.size())
        {
          register_proxy.DiscussList localDiscussList = (register_proxy.DiscussList)paramSvcRegisterProxyMsgResp.get(i1);
          if (localDiscussList != null)
          {
            String str = String.valueOf(localDiscussList.discuss_code.get());
            Object localObject2 = ((MessageCache)localObject1).A(str);
            long l3 = ((MessageCache)localObject1).L(str);
            long l2 = 0L;
            long l1 = l2;
            if (localObject2 != null)
            {
              l1 = l2;
              if (localObject2.length > 0) {
                l1 = ((Long)localObject2[0]).longValue();
              }
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).setLength(0);
            ((StringBuilder)localObject2).append("handleNewRegisterProxyMsg getDiscussList discussCode=");
            ((StringBuilder)localObject2).append(localDiscussList.discuss_code.get());
            ((StringBuilder)localObject2).append(" discussSeq=");
            ((StringBuilder)localObject2).append(localDiscussList.discuss_seq.get());
            ((StringBuilder)localObject2).append(" memberSeq=");
            ((StringBuilder)localObject2).append(localDiscussList.member_seq.get());
            ((StringBuilder)localObject2).append(" info_seq=");
            ((StringBuilder)localObject2).append(localDiscussList.info_seq.get());
            ((StringBuilder)localObject2).append(" isHotDiscuss=");
            ((StringBuilder)localObject2).append(localDiscussList.bHotGroup.get());
            ((StringBuilder)localObject2).append(" localMemberMsgSeq=");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append(" localLastSeq=");
            ((StringBuilder)localObject2).append(l3);
            ((StringBuilder)localObject2).append(" redpack_time=");
            ((StringBuilder)localObject2).append(localDiscussList.redpack_time.get());
            ((StringBuilder)localObject2).append(" hasMsg=");
            ((StringBuilder)localObject2).append(localDiscussList.has_msg.get());
            QLog.d("RegisterProxyHandler", 1, ((StringBuilder)localObject2).toString());
            ((MessageCache)localObject1).b(str, new Object[] { Long.valueOf(localDiscussList.member_seq.get()), Long.valueOf(localDiscussList.discuss_seq.get()) });
            if (localDiscussList.member_seq.get() > l1) {
              if (localDiscussList.discuss_seq.get() <= l3) {
                a(5, null, null, localDiscussList);
              } else {
                ((MessageCache)localObject1).c(str, 1);
              }
            }
          }
          i1 += 1;
        }
      }
      QLog.d("RegisterProxyHandler", 1, "handleNewRegisterProxyMsg--> handleDiscussList! noDiscussList return...");
      l();
    }
  }
  
  private String k()
  {
    return this.C.i();
  }
  
  private void l()
  {
    this.C.j();
  }
  
  private Object[] m()
  {
    MessageCache localMessageCache = (MessageCache)this.C.b().getMsgCache();
    Object localObject = this.D.a();
    String[] arrayOfString = new String[((List)localObject).size()];
    long[] arrayOfLong = new long[((List)localObject).size()];
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("--->>initBeforGetPullDiscussionMsgNum: discussLength:");
      localStringBuilder.append(((List)localObject).size());
      localStringBuilder.append(", discussionUinArray: ");
    }
    localObject = ((List)localObject).iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      arrayOfString[i1] = str;
      arrayOfLong[i1] = localMessageCache.L(str);
      localMessageCache.c(str, 0);
      localMessageCache.R(str);
      localMessageCache.C(str);
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(str);
        localStringBuilder.append(":");
        localStringBuilder.append(arrayOfLong[i1]);
        localStringBuilder.append(", ");
      }
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
    }
    if (i1 == 0)
    {
      this.C.notifyUI(4002, true, null);
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxyHandler", 2, "--->>initBeforGetPullDiscussionMsgNum, get discussionUin is null or length is 0, notifyUI NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
      }
      return null;
    }
    return new Object[] { arrayOfString, arrayOfLong, Integer.valueOf(i1) };
  }
  
  public void a()
  {
    if (!d) {
      return;
    }
    int i1;
    label223:
    label228:
    synchronized (this.B)
    {
      if (this.A == null)
      {
        this.e = new ArrayList(20);
        this.f = new ArrayList(10);
        this.A = new MessageHandleThread[a];
        break label223;
        if (i1 < this.A.length)
        {
          if ((this.A[i1] != null) && (!this.A[i1].b())) {
            break label228;
          }
          if (i1 < b) {
            this.A[i1] = new MessageHandleThread(this, this.C, this.f);
          } else {
            this.A[i1] = new MessageHandleThread(this, this.C, this.e);
          }
          MessageHandleThread localMessageHandleThread = this.A[i1];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MessageHandleThread");
          localStringBuilder.append(i1 + 1);
          localMessageHandleThread.setName(localStringBuilder.toString());
          this.A[i1].setPriority(5);
          this.A[i1].start();
          break label228;
        }
        return;
      }
    }
  }
  
  public void a(int paramInt)
  {
    MessageCache localMessageCache = (MessageCache)this.C.b().getMsgCache();
    if (paramInt == 1)
    {
      localObject1 = (String[])c(-2).get(Integer.valueOf(-2));
      a((String[])localObject1);
      this.h = ((String[])localObject1);
    }
    else
    {
      Object localObject2 = c(-1);
      String[] arrayOfString1 = (String[])((HashMap)localObject2).get(Integer.valueOf(1));
      String[] arrayOfString2 = (String[])((HashMap)localObject2).get(Integer.valueOf(4));
      int i1;
      if (arrayOfString1 != null) {
        i1 = arrayOfString1.length + 0;
      } else {
        i1 = 0;
      }
      int i2 = i1;
      if (arrayOfString2 != null) {
        i2 = i1 + arrayOfString2.length;
      }
      if (i2 > 0)
      {
        localObject1 = new String[i2];
        if (arrayOfString1 != null)
        {
          System.arraycopy(arrayOfString1, 0, localObject1, 0, arrayOfString1.length);
          i1 = arrayOfString1.length;
        }
        else
        {
          i1 = 0;
        }
        if (arrayOfString2 != null) {
          System.arraycopy(arrayOfString2, 0, localObject1, i1, arrayOfString2.length);
        }
        a((String[])localObject1);
      }
      else
      {
        localObject1 = null;
      }
      this.h = ((String[])localObject1);
      localObject1 = (String[])((HashMap)localObject2).get(Integer.valueOf(2));
      if ((localObject1 != null) && (localObject1.length > 0) && (localMessageCache != null))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("enableTroopMsgPushCache type=2, 1st uin=");
          ((StringBuilder)localObject2).append(localObject1[0]);
          QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject2).toString());
        }
        i1 = 0;
      }
      while (i1 < localObject1.length)
      {
        localMessageCache.a(localObject1[i1], 0);
        i1 += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.w("RegisterProxyHandler", 2, "enableTroopMsgPushCache num troop list is empty!");
        }
      }
    }
    Object localObject1 = m();
    if (localObject1 != null) {
      this.i = ((String[])localObject1[0]);
    } else {
      this.i = null;
    }
    if (paramInt == 1) {
      j();
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject)
  {
    a();
    paramToServiceMsg = new MessageObject(paramInt, paramToServiceMsg, ???, paramObject);
    if (paramInt == 1) {
      synchronized (this.f)
      {
        this.f.add(paramToServiceMsg);
        this.f.notify();
        return;
      }
    }
    synchronized (this.e)
    {
      this.e.add(paramToServiceMsg);
      this.e.notify();
      return;
    }
  }
  
  protected void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject, boolean paramBoolean)
  {
    a();
    paramToServiceMsg = new MessageObject(paramInt, paramToServiceMsg, ???, paramObject, paramBoolean);
    if (paramInt == 1) {
      synchronized (this.f)
      {
        this.f.add(paramToServiceMsg);
        this.f.notify();
        return;
      }
    }
    synchronized (this.e)
    {
      this.e.add(paramToServiceMsg);
      this.e.notify();
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    f();
    int i1 = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendRegisterProxy , type = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" , needEndPkg = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" , registerProxyRandom = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" , isGetPassword = ");
    ((StringBuilder)localObject).append(paramBoolean2);
    QLog.d("MessageHandler", 1, ((StringBuilder)localObject).toString());
    long l2;
    long l1;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt == 3) && (paramBoolean1))
      {
        this.k = i1;
      }
      else if (paramInt == 4)
      {
        l2 = 384L;
        this.j = i1;
        l1 = l2;
        if (!((MessageCache)this.C.b().getMsgCache()).d(false)) {
          break label222;
        }
        this.n = i1;
        l1 = l2;
        break label222;
      }
      l1 = 128L;
    }
    else
    {
      l2 = 65986L;
      l1 = l2;
      if (paramBoolean1)
      {
        this.j = i1;
        l1 = l2;
      }
    }
    label222:
    if (paramInt == 1) {
      localObject = "RegPrxySvc.infoLogin";
    } else {
      localObject = "RegPrxySvc.getOffMsg";
    }
    localObject = this.C.createToServiceMsg((String)localObject);
    ((ToServiceMsg)localObject).extraData.putLong("requestOptional", l1);
    if (paramBoolean1) {
      ((ToServiceMsg)localObject).extraData.putInt("endSeq", i1);
    }
    if (paramLong != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ReSendProxy] RegisterProxyRandom = ");
      localStringBuilder.append(paramLong);
      QLog.d("MessageHandler", 1, localStringBuilder.toString());
      this.x = paramLong;
      ((ToServiceMsg)localObject).getAttributes().put("_attr_regprxy_random_code", Long.valueOf(paramLong));
    }
    ((ToServiceMsg)localObject).extraData.putInt("type", paramInt);
    ((ToServiceMsg)localObject).extraData.putBoolean("isGetPassword", paramBoolean2);
    this.C.send((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.q.set(false);
    f();
    int i1 = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    this.j = i1;
    if (paramLong != 0L) {
      this.x = paramLong;
    }
    ToServiceMsg localToServiceMsg = a(paramBoolean1, i1, paramLong, paramBoolean2);
    this.C.send(localToServiceMsg);
  }
  
  public void a(RegisterProxyHandler.Callback paramCallback)
  {
    this.D = paramCallback;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PbSyncMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      QLog.d("RegisterProxyHandler", 1, "handleNewRegisterProxyMsg begin!");
      long l1 = System.currentTimeMillis();
      paramObject = a((byte[])paramObject);
      if (paramObject == null) {
        return;
      }
      if (!a(paramObject)) {
        return;
      }
      if ((paramObject.flag.has()) && (paramObject.flag.get() != 0))
      {
        int i1 = paramObject.flag.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---handleNewRegisterProxyMsg flag = ");
        localStringBuilder.append(i1);
        QLog.d("RegisterProxyHandler", 1, localStringBuilder.toString());
        if (MessageCache.d == null) {
          MessageCache.d = new MessageCache.RegPrxyCache();
        }
        b(paramObject);
        a("c2c_msg", paramToServiceMsg, paramFromServiceMsg, paramObject.c2c_msg);
        a("pub_account_msg", paramToServiceMsg, paramFromServiceMsg, paramObject.pub_account_msg);
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        c(paramObject);
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        b(i1);
        a(paramFromServiceMsg, i1);
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleNewRegisterProxyMsg end! cost :");
          paramToServiceMsg.append(System.currentTimeMillis() - l1);
          QLog.d("RegisterProxyHandler", 2, paramToServiceMsg.toString());
        }
      }
      else
      {
        QLog.d("RegisterProxyHandler", 1, "<---handleNewRegisterProxyMsg-->flag error!");
        this.C.notifyUI(4004, false, null);
      }
    }
  }
  
  public void b()
  {
    synchronized (this.B)
    {
      if (this.A != null)
      {
        int i1 = 0;
        while (i1 < this.A.length)
        {
          this.A[i1].a();
          i1 += 1;
        }
        synchronized (this.e)
        {
          this.e.notifyAll();
        }
      }
      this.f = null;
      this.e = null;
      this.A = null;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean c()
  {
    int i1;
    label64:
    label79:
    label84:
    synchronized (this.B)
    {
      if (this.A != null)
      {
        if (this.A.length > 1) {
          break label79;
        }
        break label64;
        if (i1 < this.A.length)
        {
          if ((this.A[i1] == null) || (!this.A[i1].c())) {
            break label84;
          }
          return false;
        }
        return true;
      }
      return true;
    }
  }
  
  public boolean d()
  {
    ArrayList localArrayList = this.e;
    if (localArrayList == null) {
      return true;
    }
    for (;;)
    {
      try
      {
        try
        {
          if (this.e.size() == 0)
          {
            bool = true;
            return bool;
          }
        }
        finally {}
        boolean bool = false;
      }
      catch (Exception localException)
      {
        return true;
      }
    }
  }
  
  public boolean e()
  {
    Object localObject1;
    if ((this.o) && (!this.m))
    {
      localObject1 = this.e;
      if (localObject1 == null) {
        return true;
      }
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = this.e.iterator();
        if (!localIterator.hasNext()) {
          break label122;
        }
        if (!((MessageObject)localIterator.next()).e) {
          continue;
        }
        bool = true;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("hasFirstGroupMsg flag =");
          ((StringBuilder)localObject1).append(bool);
          QLog.d("MessageHandler", 2, ((StringBuilder)localObject1).toString());
        }
        if (!bool)
        {
          this.o = false;
          return true;
        }
      }
      finally {}
      return false;
      label122:
      boolean bool = false;
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "[ReSendProxy] cleanRegisterProxyRandom");
    }
    this.x = 0L;
  }
  
  public boolean g()
  {
    return ((c()) && (d())) || (!d);
  }
  
  public void h()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxyHandler", 2, "handlePullLackGroupMsg-> New RegisterProxy End!");
      }
      this.C.k();
      synchronized (this.q)
      {
        if (!this.q.get())
        {
          long l1 = System.currentTimeMillis();
          this.q.wait(10000L);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("AllMsgThreadEndLock wait = ");
            localStringBuilder.append(System.currentTimeMillis() - l1);
            QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
          }
        }
        this.p = false;
        this.o = false;
        i();
        this.q.set(false);
        return;
      }
    }
    catch (Exception localException)
    {
      label131:
      break label131;
    }
    QLog.e("RegisterProxyHandler", 1, "handlePullLackGroupMsg exception!");
  }
  
  public void i()
  {
    Object localObject1 = new StringBuilder();
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject1).setLength(0);
      ((StringBuilder)localObject1).append("checkGroupMsgComplete-> troopNum:");
      ((StringBuilder)localObject1).append(this.r);
      ((StringBuilder)localObject1).append(" ,discussionNum:");
      ((StringBuilder)localObject1).append(this.s);
      ((StringBuilder)localObject1).append(" ,recvTroopNum:");
      ((StringBuilder)localObject1).append(this.t);
      ((StringBuilder)localObject1).append(" ,recvDiscNum");
      ((StringBuilder)localObject1).append(this.u);
      QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!((MessageCache)this.C.b().getMsgCache()).d(false)) && (this.r == 0) && (this.s == 0)) {
      return;
    }
    this.h = null;
    this.i = null;
    Object localObject2 = this.v;
    int i2;
    int i1;
    if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
    {
      localObject2 = new RegisterProxyHandler.CheckTroopMsgComplete(this, (StringBuilder)localObject1, 0).c();
      i2 = ((RegisterProxyHandler.CheckTroopMsgComplete)localObject2).a();
      i1 = ((RegisterProxyHandler.CheckTroopMsgComplete)localObject2).b();
    }
    else
    {
      i1 = 0;
      i2 = 0;
    }
    localObject2 = this.w;
    int i4;
    int i3;
    if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
    {
      localObject1 = new RegisterProxyHandler.CheckDisMsgComplete(this, (StringBuilder)localObject1, 0).c();
      i4 = ((RegisterProxyHandler.CheckDisMsgComplete)localObject1).a();
      i3 = ((RegisterProxyHandler.CheckDisMsgComplete)localObject1).b();
    }
    else
    {
      i3 = 0;
      i4 = 0;
    }
    if ((this.h != null) || (this.i != null)) {
      a(i2, i4, i1, i3);
    }
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.u = 0;
  }
  
  public void j()
  {
    AppInterface localAppInterface = this.C.b();
    if (localAppInterface.getCurrentAccountUin() != null)
    {
      Object localObject1 = localAppInterface.getApp();
      Object localObject2 = localAppInterface.getCurrentAccountUin();
      int i1 = 0;
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences((String)localObject2, 0);
      Object localObject3 = ((SharedPreferences)localObject1).getString("msgSending", null);
      localObject2 = (MessageCache)localAppInterface.getMsgCache();
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("msgSending:init,read msgSending file,");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(" msgCache:");
        ((StringBuilder)localObject4).append(localObject2.hashCode());
        QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject4).toString());
      }
      if (localObject3 != null) {
        try
        {
          localObject3 = new JSONArray((String)localObject3);
          while (i1 < ((JSONArray)localObject3).length())
          {
            if (!((JSONArray)localObject3).isNull(i1))
            {
              Object localObject5 = ((JSONArray)localObject3).getJSONObject(i1);
              localObject4 = ((JSONObject)localObject5).getString("uin");
              int i2 = ((JSONObject)localObject5).getInt("type");
              long l1 = ((JSONObject)localObject5).getLong("uniseq");
              ((MessageCache)localObject2).c((String)localObject4, i2, l1);
              localObject5 = (IMessageFacade)localAppInterface.getRuntimeService(IMessageFacade.class, "");
              localObject4 = ((IMessageFacade)localObject5).queryMsgItemByUniseq((String)localObject4, i2, l1);
              if (localObject4 != null)
              {
                ((MessageCache)localObject2).e((MessageRecord)localObject4);
                ((IMessageFacade)localObject5).setChangeAndNotify(localObject4);
                this.D.a((MessageRecord)localObject4);
              }
            }
            i1 += 1;
          }
          return;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("msgSending:init,read msgSending file,");
            ((StringBuilder)localObject2).append(localException.getMessage());
            QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject2).toString());
          }
          localException.printStackTrace();
          ((SharedPreferences)localObject1).edit().remove("msgSending").commit();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.RegisterProxyHandler
 * JD-Core Version:    0.7.0.1
 */