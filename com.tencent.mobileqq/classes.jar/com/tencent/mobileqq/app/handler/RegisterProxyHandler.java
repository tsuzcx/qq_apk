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
  public static boolean a = true;
  public static int b = 2;
  public static boolean b = true;
  public static boolean c = false;
  public long a;
  public volatile Pair<RegisterPushNotice, Long> a;
  private BaseMessageHandler jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler;
  private RegisterProxyHandler.Callback jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler$Callback;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public ArrayList<MessageObject> a;
  public HashMap<String, Boolean> a;
  public List<register_proxy.GroupList> a;
  public final AtomicBoolean a;
  private MessageHandleThread[] jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread = null;
  public String[] a;
  public ArrayList<MessageObject> b;
  public HashMap<String, Boolean> b;
  public String[] b;
  public int c;
  public ArrayList<Setting> c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  
  public RegisterProxyHandler(BaseMessageHandler paramBaseMessageHandler)
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidUtilPair = null;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler = paramBaseMessageHandler;
  }
  
  private ToServiceMsg a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendNewRegisterProxy , isGetPassword = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" ,randomSeq");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", isWakeFromDeepSleep = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg("RegPrxySvc.infoSync");
    ((ToServiceMsg)localObject).extraData.putLong("requestOptional", 90562L);
    ((ToServiceMsg)localObject).extraData.putInt("endSeq", paramInt);
    ((ToServiceMsg)localObject).extraData.putInt("type", 1);
    ((ToServiceMsg)localObject).extraData.putBoolean("isGetPassword", paramBoolean1);
    long l;
    if (paramBoolean2) {
      l = 1L;
    } else {
      l = 0L;
    }
    ((ToServiceMsg)localObject).extraData.putLong("ulReportFlag", l);
    if (paramLong != 0L)
    {
      ((ToServiceMsg)localObject).getAttributes().put("_attr_regprxy_random_code", Long.valueOf(paramLong));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ReSendProxy] currentRegisterProxyRandom = ");
        localStringBuilder.append(paramLong);
        QLog.d("MessageHandler", 2, localStringBuilder.toString());
      }
    }
    return localObject;
  }
  
  private String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a();
  }
  
  private HashMap<Integer, String[]> a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler$Callback.a(paramInt);
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
      if ((paramArrayOfByte.seq.has()) && (paramArrayOfByte.seq.get() != this.jdField_c_of_type_Int) && (paramArrayOfByte.seq.get() != this.jdField_d_of_type_Int))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).setLength(0);
          ((StringBuilder)localObject).append("handleNewRegisterProxyMsg endSeq wrong! seq=");
          ((StringBuilder)localObject).append(paramArrayOfByte.seq.get());
          ((StringBuilder)localObject).append(" registerProxyEndSeq=");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
          ((StringBuilder)localObject).append(" registerProxyEndSeq_numTroop=");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
          QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject).toString());
        }
        return null;
      }
      return paramArrayOfByte;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxyHandler", 2, "handleNewRegisterProxyMsg package error!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4004, false, null);
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(4, true, 0L, false);
    if (QLog.isColorLevel())
    {
      MessageCache localMessageCache = (MessageCache)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getMsgCache();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needPullTroopNum:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" ,needPullDiscNum:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ,regPrxyError:");
      localStringBuilder.append(localMessageCache.a(false));
      QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if ((paramInt & 0x8) == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxyHandler", 2, "handleNewRegisterProxyMsg--> handleRestEnding!");
      }
      this.jdField_f_of_type_Boolean = true;
      if ((this.jdField_f_of_type_Boolean) && (a()) && (b())) {
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
        {
          if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
          }
        }
      }
      long l = ((Long)paramFromServiceMsg.getAttribute("infoSync_timestamp")).longValue();
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg("RegPrxySvc.PbSyncMsg", null);
      paramFromServiceMsg.addAttribute("infoSync_timestamp", Long.valueOf(l));
      paramFromServiceMsg.setMsfCommand(MsfCommand.msf_pbSyncMsg);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.send(paramFromServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.group_list.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxyHandler", 2, "handleNewRegisterProxyMsg--> handleTroopList!");
      }
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.group_list.get();
      this.jdField_a_of_type_JavaUtilList = paramSvcRegisterProxyMsgResp;
      MessageCache localMessageCache = (MessageCache)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getMsgCache();
      MessageCache.a.jdField_a_of_type_JavaUtilList = paramSvcRegisterProxyMsgResp;
      int j = 0;
      while (j < paramSvcRegisterProxyMsgResp.size())
      {
        register_proxy.GroupList localGroupList = (register_proxy.GroupList)paramSvcRegisterProxyMsgResp.get(j);
        if (localGroupList != null)
        {
          String str = String.valueOf(localGroupList.group_code.get());
          Object localObject = localMessageCache.b(str);
          long l2 = localMessageCache.j(str);
          long l1;
          if ((localObject != null) && (localObject.length > 0)) {
            l1 = ((Long)localObject[0]).longValue();
          } else {
            l1 = 0L;
          }
          if (QLog.isColorLevel())
          {
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
            QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject).toString());
          }
          if ((localGroupList.mask.get() == 1L) || (localGroupList.mask.get() == 4L) || ((localGroupList.mask.get() == 3L) && (str.equals(a()))))
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
            if (this.jdField_c_of_type_JavaUtilArrayList == null) {
              this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
            }
            localObject = new Setting();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("message.group.policy.");
            localStringBuilder.append(str);
            ((Setting)localObject).Path = localStringBuilder.toString();
            ((Setting)localObject).Value = String.valueOf(localGroupList.mask.get());
            this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
          }
        }
        j += 1;
      }
    }
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PBBytesField paramPBBytesField)
  {
    if (paramPBBytesField.has()) {
      try
      {
        Object localObject = paramPBBytesField.get().toByteArray();
        int j = localObject.length - 4;
        paramPBBytesField = new byte[j];
        PkgTools.copyData(paramPBBytesField, 0, (byte[])localObject, 4, j);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleNewRegisterProxyMsg--> decode ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", hashCode:");
          ((StringBuilder)localObject).append(paramPBBytesField.hashCode());
          QLog.e("RegisterProxyHandler", 2, ((StringBuilder)localObject).toString());
        }
        a(1, paramToServiceMsg, paramFromServiceMsg, paramPBBytesField);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleNewRegisterProxyMsg--> decode ");
          paramFromServiceMsg.append(paramString);
          paramFromServiceMsg.append("error:");
          QLog.e("RegisterProxyHandler", 2, paramFromServiceMsg.toString(), paramToServiceMsg);
        }
      }
    }
  }
  
  private void a(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.msg_info.has())
    {
      this.jdField_f_of_type_Int = ((register_proxy.SvcResponseMsgInfo)paramSvcRegisterProxyMsgResp.msg_info.get()).group_num.get();
      this.g = ((register_proxy.SvcResponseMsgInfo)paramSvcRegisterProxyMsgResp.msg_info.get()).discuss_num.get();
      if (QLog.isColorLevel())
      {
        paramSvcRegisterProxyMsgResp = new StringBuilder();
        paramSvcRegisterProxyMsgResp.append("handleNewRegisterProxyMsg ,groupNum=");
        paramSvcRegisterProxyMsgResp.append(this.jdField_f_of_type_Int);
        paramSvcRegisterProxyMsgResp.append(",discussionNum=");
        paramSvcRegisterProxyMsgResp.append(this.g);
        QLog.e("RegisterProxyHandler", 2, paramSvcRegisterProxyMsgResp.toString());
      }
      int j = this.jdField_f_of_type_Int;
      if ((j == 0) || (this.h >= j)) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4003, true, null);
      }
      j = this.g;
      if ((j == 0) || (this.i >= j)) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4002, true, null);
      }
    }
  }
  
  private boolean a(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    int j = paramSvcRegisterProxyMsgResp.result.get();
    if (QLog.isColorLevel())
    {
      paramSvcRegisterProxyMsgResp = new StringBuilder();
      paramSvcRegisterProxyMsgResp.append("handleNewRegisterProxyResultCode resultCode = ");
      paramSvcRegisterProxyMsgResp.append(j);
      QLog.d("RegisterProxyHandler", 2, paramSvcRegisterProxyMsgResp.toString());
    }
    if (j != 0) {
      if (j != 1)
      {
        switch (j)
        {
        default: 
          return false;
        case 104: 
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(false);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(true, 0);
          break;
        case 103: 
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(false);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(true, 2);
          break;
        case 102: 
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(false);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(true, 1);
          break;
        case 100: 
          jdField_a_of_type_Boolean = false;
          BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", false).commit();
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4004, false, null);
          return false;
        case 99: 
        case 101: 
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.e();
          j = new Random().nextInt(3000);
          ThreadManager.getSubThreadHandler().postDelayed(new RegisterProxyHandler.1(this), j);
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4001, false, null);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4016, false, null);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4003, false, null);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4002, false, null);
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
    MessageCache localMessageCache = (MessageCache)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getMsgCache();
    int j = 0;
    while (j < paramArrayOfString.length)
    {
      localMessageCache.a(paramArrayOfString[j], 0);
      localMessageCache.e(paramArrayOfString[j]);
      arrayOfLong[j] = localMessageCache.j(paramArrayOfString[j]);
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(paramArrayOfString[j]);
        localStringBuilder.append(":");
        localStringBuilder.append(arrayOfLong[j]);
        localStringBuilder.append(", ");
      }
      j += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
    }
    return arrayOfLong;
  }
  
  private Object[] a()
  {
    MessageCache localMessageCache = (MessageCache)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getMsgCache();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler$Callback.a();
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
    int j = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      arrayOfString[j] = str;
      arrayOfLong[j] = localMessageCache.i(str);
      localMessageCache.b(str, 0);
      localMessageCache.g(str);
      localMessageCache.c(str);
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(str);
        localStringBuilder.append(":");
        localStringBuilder.append(arrayOfLong[j]);
        localStringBuilder.append(", ");
      }
      j += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
    }
    if (j == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4002, true, null);
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxyHandler", 2, "--->>initBeforGetPullDiscussionMsgNum, get discussionUin is null or length is 0, notifyUI NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
      }
      return null;
    }
    return new Object[] { arrayOfString, arrayOfLong, Integer.valueOf(j) };
  }
  
  private void b(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleNewRegisterProxyMsg--> handleFirstEnding! isPullCircleStop: ");
        localStringBuilder.append(this.jdField_d_of_type_Boolean);
        QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
      }
      this.jdField_e_of_type_Boolean = true;
      if (c()) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4017, true, null);
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.gourp_msg.has())
    {
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.gourp_msg.get();
      int k = paramSvcRegisterProxyMsgResp.size();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleNewRegisterProxyMsg--> handleTroopMsgResp_PB, gourp_msg size:");
        ((StringBuilder)localObject).append(k);
        QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject).toString());
      }
      int j = 0;
      while (j < k)
      {
        localObject = (register_proxy.SvcResponsePbPullGroupMsgProxy)paramSvcRegisterProxyMsgResp.get(j);
        if (this.jdField_e_of_type_Boolean) {
          a(2, paramToServiceMsg, paramFromServiceMsg, localObject, false);
        } else {
          a(2, paramToServiceMsg, paramFromServiceMsg, localObject, true);
        }
        j += 1;
      }
    }
  }
  
  private void b(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    boolean bool;
    if ((paramSvcRegisterProxyMsgResp.discuss_list_flag.has()) && (paramSvcRegisterProxyMsgResp.discuss_list_flag.get() == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleNewRegisterProxyMsg needDealDiscussList=");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool)
    {
      localObject1 = (MessageCache)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getMsgCache();
      if (paramSvcRegisterProxyMsgResp.discuss_list.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("RegisterProxyHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussList!");
        }
        paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.discuss_list.get();
        MessageCache.a.b = paramSvcRegisterProxyMsgResp;
        int j = 0;
        while (j < paramSvcRegisterProxyMsgResp.size())
        {
          register_proxy.DiscussList localDiscussList = (register_proxy.DiscussList)paramSvcRegisterProxyMsgResp.get(j);
          if (localDiscussList != null)
          {
            String str = String.valueOf(localDiscussList.discuss_code.get());
            Object localObject2 = ((MessageCache)localObject1).a(str);
            long l3 = ((MessageCache)localObject1).i(str);
            long l2 = 0L;
            long l1 = l2;
            if (localObject2 != null)
            {
              l1 = l2;
              if (localObject2.length > 0) {
                l1 = ((Long)localObject2[0]).longValue();
              }
            }
            if (QLog.isColorLevel())
            {
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
              QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject2).toString());
            }
            ((MessageCache)localObject1).b(str, new Object[] { Long.valueOf(localDiscussList.member_seq.get()), Long.valueOf(localDiscussList.discuss_seq.get()) });
            if (localDiscussList.member_seq.get() > l1) {
              if (localDiscussList.discuss_seq.get() <= l3) {
                a(5, null, null, localDiscussList);
              } else {
                ((MessageCache)localObject1).b(str, 1);
              }
            }
          }
          j += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxyHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussList! noDiscussList return...");
      }
      g();
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.discuss_msg.has())
    {
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.discuss_msg.get();
      int k = paramSvcRegisterProxyMsgResp.size();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleNewRegisterProxyMsg--> handleDiscussMsgResp_PB, discuss_msg size:");
        ((StringBuilder)localObject).append(k);
        QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject).toString());
      }
      int j = 0;
      while (j < k)
      {
        localObject = (register_proxy.SvcPbResponsePullDisMsgProxy)paramSvcRegisterProxyMsgResp.get(j);
        if (this.jdField_e_of_type_Boolean) {
          a(3, paramToServiceMsg, paramFromServiceMsg, localObject, false);
        } else {
          a(3, paramToServiceMsg, paramFromServiceMsg, localObject, true);
        }
        j += 1;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.f();
  }
  
  public void a()
  {
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    int j;
    label223:
    label228:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread == null)
      {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(10);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread = new MessageHandleThread[jdField_a_of_type_Int];
        break label223;
        if (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread.length)
        {
          if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j] != null) && (!this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j].a())) {
            break label228;
          }
          if (j < jdField_b_of_type_Int) {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j] = new MessageHandleThread(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler, this.jdField_b_of_type_JavaUtilArrayList);
          } else {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j] = new MessageHandleThread(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler, this.jdField_a_of_type_JavaUtilArrayList);
          }
          MessageHandleThread localMessageHandleThread = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MessageHandleThread");
          localStringBuilder.append(j + 1);
          localMessageHandleThread.setName(localStringBuilder.toString());
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j].setPriority(5);
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j].start();
          break label228;
        }
        return;
      }
    }
  }
  
  public void a(int paramInt)
  {
    MessageCache localMessageCache = (MessageCache)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getMsgCache();
    if (paramInt == 1)
    {
      localObject1 = (String[])a(-2).get(Integer.valueOf(-2));
      a((String[])localObject1);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
    }
    else
    {
      Object localObject2 = a(-1);
      String[] arrayOfString1 = (String[])((HashMap)localObject2).get(Integer.valueOf(1));
      String[] arrayOfString2 = (String[])((HashMap)localObject2).get(Integer.valueOf(4));
      int j;
      if (arrayOfString1 != null) {
        j = arrayOfString1.length + 0;
      } else {
        j = 0;
      }
      int k = j;
      if (arrayOfString2 != null) {
        k = j + arrayOfString2.length;
      }
      if (k > 0)
      {
        localObject1 = new String[k];
        if (arrayOfString1 != null)
        {
          System.arraycopy(arrayOfString1, 0, localObject1, 0, arrayOfString1.length);
          j = arrayOfString1.length;
        }
        else
        {
          j = 0;
        }
        if (arrayOfString2 != null) {
          System.arraycopy(arrayOfString2, 0, localObject1, j, arrayOfString2.length);
        }
        a((String[])localObject1);
      }
      else
      {
        localObject1 = null;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
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
        j = 0;
      }
      while (j < localObject1.length)
      {
        localMessageCache.a(localObject1[j], 0);
        j += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.w("RegisterProxyHandler", 2, "enableTroopMsgPushCache num troop list is empty!");
        }
      }
    }
    Object localObject1 = a();
    if (localObject1 != null) {
      this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject1[0]);
    } else {
      this.jdField_b_of_type_ArrayOfJavaLangString = null;
    }
    if (paramInt == 1) {
      f();
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject)
  {
    a();
    paramToServiceMsg = new MessageObject(paramInt, paramToServiceMsg, ???, paramObject);
    if (paramInt == 1) {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(paramToServiceMsg);
        this.jdField_b_of_type_JavaUtilArrayList.notify();
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramToServiceMsg);
      this.jdField_a_of_type_JavaUtilArrayList.notify();
      return;
    }
  }
  
  protected void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject, boolean paramBoolean)
  {
    a();
    paramToServiceMsg = new MessageObject(paramInt, paramToServiceMsg, ???, paramObject, paramBoolean);
    if (paramInt == 1) {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(paramToServiceMsg);
        this.jdField_b_of_type_JavaUtilArrayList.notify();
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramToServiceMsg);
      this.jdField_a_of_type_JavaUtilArrayList.notify();
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    c();
    int j = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendRegisterProxy , type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" , needEndPkg = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" , registerProxyRandom = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" , isGetPassword = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = 128L;
    long l2;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt == 3) && (paramBoolean1))
      {
        this.jdField_d_of_type_Int = j;
      }
      else if (paramInt == 4)
      {
        l2 = 384L;
        this.jdField_c_of_type_Int = j;
        l1 = l2;
        if (((MessageCache)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getMsgCache()).a(false))
        {
          this.jdField_e_of_type_Int = j;
          l1 = l2;
        }
      }
    }
    else
    {
      l2 = 65986L;
      l1 = l2;
      if (paramBoolean1)
      {
        this.jdField_c_of_type_Int = j;
        l1 = l2;
      }
    }
    if (paramInt == 1) {
      localObject = "RegPrxySvc.infoLogin";
    } else {
      localObject = "RegPrxySvc.getOffMsg";
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg((String)localObject);
    ((ToServiceMsg)localObject).extraData.putLong("requestOptional", l1);
    if (paramBoolean1) {
      ((ToServiceMsg)localObject).extraData.putInt("endSeq", j);
    }
    if (paramLong != 0L)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ReSendProxy] RegisterProxyRandom = ");
        localStringBuilder.append(paramLong);
        QLog.d("MessageHandler", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Long = paramLong;
      ((ToServiceMsg)localObject).getAttributes().put("_attr_regprxy_random_code", Long.valueOf(paramLong));
    }
    ((ToServiceMsg)localObject).extraData.putInt("type", paramInt);
    ((ToServiceMsg)localObject).extraData.putBoolean("isGetPassword", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.send((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    c();
    int j = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    this.jdField_c_of_type_Int = j;
    if (paramLong != 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
    ToServiceMsg localToServiceMsg = a(paramBoolean1, j, paramLong, paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.send(localToServiceMsg);
  }
  
  public void a(RegisterProxyHandler.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler$Callback = paramCallback;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PbSyncMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      QLog.d("RegisterProxyHandler", 2, "handleNewRegisterProxyMsg begin!");
      long l = System.currentTimeMillis();
      paramObject = a((byte[])paramObject);
      if (paramObject == null) {
        return;
      }
      if (!a(paramObject)) {
        return;
      }
      if ((paramObject.flag.has()) && (paramObject.flag.get() != 0))
      {
        int j = paramObject.flag.get();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("<---handleNewRegisterProxyMsg flag = ");
          localStringBuilder.append(j);
          QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
        }
        if (MessageCache.a == null) {
          MessageCache.a = new MessageCache.RegPrxyCache();
        }
        a(paramObject);
        a("c2c_msg", paramToServiceMsg, paramFromServiceMsg, paramObject.c2c_msg);
        a("pub_account_msg", paramToServiceMsg, paramFromServiceMsg, paramObject.pub_account_msg);
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        b(paramObject);
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        b(j);
        a(paramFromServiceMsg, j);
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleNewRegisterProxyMsg end! cost :");
          paramToServiceMsg.append(System.currentTimeMillis() - l);
          QLog.d("RegisterProxyHandler", 2, paramToServiceMsg.toString());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("RegisterProxyHandler", 2, "<---handleNewRegisterProxyMsg-->flag error!");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(4004, false, null);
      }
    }
  }
  
  public boolean a()
  {
    int j;
    label64:
    label79:
    label84:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread != null)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread.length > 1) {
          break label79;
        }
        break label64;
        if (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread.length)
        {
          if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j] == null) || (!this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j].b())) {
            break label84;
          }
          return false;
        }
        return true;
      }
      return true;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread != null)
      {
        int j = 0;
        while (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread[j].a();
          j += 1;
        }
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.notifyAll();
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList = null;
      this.jdField_a_of_type_JavaUtilArrayList = null;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppHandlerMessageHandleThread = null;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean b()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return true;
    }
    for (;;)
    {
      try
      {
        try
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
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
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "[ReSendProxy] cleanRegisterProxyRandom");
    }
    this.jdField_a_of_type_Long = 0L;
  }
  
  public boolean c()
  {
    Object localObject1;
    if ((this.jdField_e_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject1 == null) {
        return true;
      }
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label122;
        }
        if (!((MessageObject)localIterator.next()).jdField_a_of_type_Boolean) {
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
          this.jdField_e_of_type_Boolean = false;
          return true;
        }
      }
      finally {}
      return false;
      label122:
      boolean bool = false;
    }
  }
  
  public void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxyHandler", 2, "handlePullLackGroupMsg-> New RegisterProxy End!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.g();
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          long l = System.currentTimeMillis();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait(10000L);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("AllMsgThreadEndLock wait = ");
            localStringBuilder.append(System.currentTimeMillis() - l);
            QLog.d("RegisterProxyHandler", 2, localStringBuilder.toString());
          }
        }
        this.jdField_f_of_type_Boolean = false;
        this.jdField_e_of_type_Boolean = false;
        e();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
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
  
  public boolean d()
  {
    return ((a()) && (b())) || (!jdField_b_of_type_Boolean);
  }
  
  public void e()
  {
    Object localObject1 = new StringBuilder();
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject1).setLength(0);
      ((StringBuilder)localObject1).append("checkGroupMsgComplete-> troopNum:");
      ((StringBuilder)localObject1).append(this.jdField_f_of_type_Int);
      ((StringBuilder)localObject1).append(" ,discussionNum:");
      ((StringBuilder)localObject1).append(this.g);
      ((StringBuilder)localObject1).append(" ,recvTroopNum:");
      ((StringBuilder)localObject1).append(this.h);
      ((StringBuilder)localObject1).append(" ,recvDiscNum");
      ((StringBuilder)localObject1).append(this.i);
      QLog.d("RegisterProxyHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!((MessageCache)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getMsgCache()).a(false)) && (this.jdField_f_of_type_Int == 0) && (this.g == 0)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
    int k;
    int j;
    if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
    {
      localObject2 = new RegisterProxyHandler.CheckTroopMsgComplete(this, (StringBuilder)localObject1, 0).a();
      k = ((RegisterProxyHandler.CheckTroopMsgComplete)localObject2).a();
      j = ((RegisterProxyHandler.CheckTroopMsgComplete)localObject2).b();
    }
    else
    {
      j = 0;
      k = 0;
    }
    localObject2 = this.jdField_b_of_type_JavaUtilHashMap;
    int n;
    int m;
    if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
    {
      localObject1 = new RegisterProxyHandler.CheckDisMsgComplete(this, (StringBuilder)localObject1, 0).a();
      n = ((RegisterProxyHandler.CheckDisMsgComplete)localObject1).a();
      m = ((RegisterProxyHandler.CheckDisMsgComplete)localObject1).b();
    }
    else
    {
      m = 0;
      n = 0;
    }
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) || (this.jdField_b_of_type_ArrayOfJavaLangString != null)) {
      a(k, n, j, m);
    }
    this.jdField_f_of_type_Int = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
  }
  
  public void f()
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a();
    if (localAppInterface.getCurrentAccountUin() != null)
    {
      Object localObject1 = localAppInterface.getApp();
      Object localObject2 = localAppInterface.getCurrentAccountUin();
      int j = 0;
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
          while (j < ((JSONArray)localObject3).length())
          {
            if (!((JSONArray)localObject3).isNull(j))
            {
              Object localObject5 = ((JSONArray)localObject3).getJSONObject(j);
              localObject4 = ((JSONObject)localObject5).getString("uin");
              int k = ((JSONObject)localObject5).getInt("type");
              long l = ((JSONObject)localObject5).getLong("uniseq");
              ((MessageCache)localObject2).b((String)localObject4, k, l);
              localObject5 = (IMessageFacade)localAppInterface.getRuntimeService(IMessageFacade.class, "");
              localObject4 = ((IMessageFacade)localObject5).queryMsgItemByUniseq((String)localObject4, k, l);
              if (localObject4 != null)
              {
                ((MessageCache)localObject2).a((MessageRecord)localObject4);
                ((IMessageFacade)localObject5).setChangeAndNotify(localObject4);
                this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler$Callback.a((MessageRecord)localObject4);
              }
            }
            j += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.RegisterProxyHandler
 * JD-Core Version:    0.7.0.1
 */