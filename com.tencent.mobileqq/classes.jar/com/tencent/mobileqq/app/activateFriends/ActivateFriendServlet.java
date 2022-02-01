package com.tencent.mobileqq.app.activateFriends;

import QTimedMessage.QTimedMessage.C2CMessage;
import QTimedMessage.QTimedMessage.C2CMessage.RichText;
import QTimedMessage.QTimedMessage.Client;
import QTimedMessage.QTimedMessage.Content;
import QTimedMessage.QTimedMessage.Message;
import QTimedMessage.QTimedMessage.Timer;
import QTimedMessage.QTimedMessage.User;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x75f.cmd0x75f.AddBatchReq;
import tencent.im.oidb.cmd0x75f.cmd0x75f.AddBatchRsp;
import tencent.im.oidb.cmd0x75f.cmd0x75f.ReqBody;
import tencent.im.oidb.cmd0x75f.cmd0x75f.RspBody;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9.RspBody;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9.RspHelloContent;
import tencent.im.oidb.cmd0x82a.cmd0x82a.MsgInfo;
import tencent.im.oidb.cmd0x82a.cmd0x82a.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ActivateFriendServlet
  extends MSFServlet
{
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long[] arrayOfLong = paramIntent.getExtras().getLongArray("p_uin_list");
    ArrayList localArrayList = new ArrayList();
    ActivateFriendsManager localActivateFriendsManager = (ActivateFriendsManager)getAppRuntime().getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("rspSendMessage response.getResultCode()=");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append("send count = ");
      localStringBuilder.append(arrayOfLong.length);
    }
    else
    {
      localStringBuilder = null;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    int j = 0;
    Object localObject1;
    int i;
    byte[] arrayOfByte;
    if (bool)
    {
      Object localObject2;
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        try
        {
          ByteBuffer localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          localObject2 = new byte[localByteBuffer.getInt() - 4];
          localByteBuffer.get((byte[])localObject2);
          ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])localObject2);
          localObject2 = localObject1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
        localObject2 = localObject1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        localObject1 = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ActivateFriends.Servlet", 2, "rspSendMessage|oidb_sso parseFrom byte", localInvalidProtocolBufferMicroException2);
        localObject2 = localObject1;
      }
      i = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
      if (localStringBuilder != null)
      {
        localStringBuilder.append(" respGetBirthday|oidb_sso.OIDBSSOPkg.result=");
        localStringBuilder.append(i);
      }
      if (((i != 0) && (i != 1401)) || (!((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get() == null)) {
        break label583;
      }
      arrayOfByte = ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray();
    }
    for (;;)
    {
      try
      {
        localObject1 = new cmd0x75f.RspBody();
        ((cmd0x75f.RspBody)localObject1).mergeFrom(arrayOfByte);
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get(arrayOfByte);
        ((cmd0x75f.RspBody)localObject1).mergeFrom(arrayOfByte);
        paramFromServiceMsg = (cmd0x75f.AddBatchRsp)((cmd0x75f.RspBody)localObject1).msg_add_batch_rsp.get();
        if (localStringBuilder == null) {
          break label723;
        }
        localStringBuilder.append(" rpt_messages size=");
        localStringBuilder.append(paramFromServiceMsg.rpt_messages.get().size());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        int k;
        if (!QLog.isColorLevel()) {
          break label583;
        }
      }
      k = paramFromServiceMsg.rpt_messages.get().size();
      if (i < k) {}
      try
      {
        long l = ((QTimedMessage.Message)paramFromServiceMsg.rpt_messages.get().get(i)).msg_content.msg_c2c_message.msg_to_user.uint64_uin.get();
        localArrayList.add(Long.valueOf(l));
        if (localStringBuilder == null) {
          continue;
        }
        localStringBuilder.append("{");
        localStringBuilder.append(l);
        localStringBuilder.append("}");
      }
      catch (Exception localException)
      {
        continue;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("respSendMessage index=");
        ((StringBuilder)localObject1).append(i);
        QLog.d("ActivateFriends.Servlet", 2, ((StringBuilder)localObject1).toString());
      }
      i += 1;
      continue;
      QLog.d("ActivateFriends.Servlet", 2, "respSendTimingMsg erro ", paramFromServiceMsg);
      break label583;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("respSendMsg | response.result = ");
        ((StringBuilder)localObject1).append(paramFromServiceMsg.getResultCode());
        QLog.d("ActivateFriends.Servlet", 2, ((StringBuilder)localObject1).toString());
      }
      label583:
      if (localArrayList.size() == arrayOfLong.length) {
        i = 0;
      } else if (localArrayList.size() > 0) {
        i = 1;
      } else {
        i = 2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Servlet", 2, localStringBuilder.toString());
      }
      if (i != 2)
      {
        paramFromServiceMsg = new long[localArrayList.size()];
        while (j < localArrayList.size())
        {
          paramFromServiceMsg[j] = ((Long)localArrayList.get(j)).longValue();
          j += 1;
        }
        localActivateFriendsManager.a(paramFromServiceMsg, 2);
      }
      localBundle.putInt("key_rt_type", i);
      notifyObserver(paramIntent, 113, true, localBundle, ActivateFriendsObserver.class);
      return;
      label723:
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList<String> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ActivateFriendServlet.class);
    localNewIntent.putExtra("param_req_type", 116);
    localNewIntent.putStringArrayListExtra("data", paramArrayList);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ActivateFriendServlet.class);
    localNewIntent.putExtra("param_req_type", 114);
    localNewIntent.putExtra("param_req_birthday", paramBoolean1);
    localNewIntent.putExtra("param_req_memorial", paramBoolean2);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Servlet", 2, "sendGetBirthDayMsgForce");
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ActivateFriendServlet.class);
    localNewIntent.putExtra("param_req_type", 114);
    localNewIntent.putExtra("param_has_birthday_data", paramBoolean1);
    localNewIntent.putExtra("param_has_memorial_data", paramBoolean3);
    localNewIntent.putExtra("param_req_birthday", paramBoolean2);
    localNewIntent.putExtra("param_req_memorial", paramBoolean4);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2, int paramInt)
  {
    if ((paramArrayOfLong1.length != 0) && (paramArrayOfLong1.length == paramArrayOfLong2.length))
    {
      NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ActivateFriendServlet.class);
      localNewIntent.putExtra("param_req_type", 113);
      localNewIntent.putExtra("p_msg", paramString);
      localNewIntent.putExtra("p_uin_list", paramArrayOfLong1);
      localNewIntent.putExtra("p_time_list", paramArrayOfLong2);
      localNewIntent.putExtra("p_gift_id", paramInt);
      paramQQAppInterface.startServlet(localNewIntent);
      return true;
    }
    return false;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("response.getResultCode()=");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
    }
    else
    {
      localStringBuilder = null;
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      Object localObject;
      try
      {
        paramIntent = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          localObject = new byte[paramFromServiceMsg.getInt() - 4];
          paramFromServiceMsg.get((byte[])localObject);
          paramIntent.mergeFrom((byte[])localObject);
          localObject = paramIntent;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
        localObject = paramIntent;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramIntent = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ActivateFriends.Servlet", 2, "respGetBirthday|oidb_sso parseFrom byte", paramFromServiceMsg);
        localObject = paramIntent;
      }
      if (localObject != null)
      {
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (localStringBuilder != null)
        {
          localStringBuilder.append(" respGetBirthday|oidb_sso.OIDBSSOPkg.result=");
          localStringBuilder.append(i);
        }
        if ((i == 0) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null))
        {
          paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
          try
          {
            paramFromServiceMsg = new cmd0x7c9.RspBody();
            paramFromServiceMsg.mergeFrom(paramIntent);
            if (paramFromServiceMsg.rpt_hello_content.has())
            {
              paramIntent = (ActivateFriendsManager)getAppRuntime().getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
              paramFromServiceMsg = paramFromServiceMsg.rpt_hello_content.get().iterator();
              while (paramFromServiceMsg.hasNext())
              {
                localObject = (cmd0x7c9.RspHelloContent)paramFromServiceMsg.next();
                i = ((cmd0x7c9.RspHelloContent)localObject).uint32_next_time_gap.get();
                int j = ((cmd0x7c9.RspHelloContent)localObject).uint32_req_type.get();
                if (localStringBuilder != null)
                {
                  localStringBuilder.append(" type=");
                  localStringBuilder.append(j);
                  localStringBuilder.append(" interval=");
                  localStringBuilder.append(i);
                }
                if (j == 1) {
                  paramIntent.a(i * 1000);
                } else if (j == 2) {
                  paramIntent.b(i * 1000);
                }
              }
            }
            if (localStringBuilder == null) {
              break label444;
            }
            localStringBuilder.append(" rspBody.rpt_hello_content hasno ");
          }
          catch (Exception paramIntent)
          {
            if (!QLog.isColorLevel()) {
              break label444;
            }
          }
          QLog.d("ActivateFriends.Servlet", 2, "respGetBirthday|oidb_sso parseFrom byte", paramIntent);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("respGetBirthday | response.result = ");
      paramIntent.append(paramFromServiceMsg.getResultCode());
      QLog.d("ActivateFriends.Servlet", 2, paramIntent.toString());
    }
    label444:
    if (localStringBuilder != null) {
      QLog.d("ActivateFriends.Servlet", 2, localStringBuilder.toString());
    }
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("activiate_friends|response.getResultCode()=");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      Object localObject;
      try
      {
        paramIntent = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          localObject = new byte[paramFromServiceMsg.getInt() - 4];
          paramFromServiceMsg.get((byte[])localObject);
          paramIntent.mergeFrom((byte[])localObject);
          localObject = paramIntent;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
        localObject = paramIntent;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramIntent = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ActivateFriends.Servlet", 2, "respSendReadedActivateFriends|oidb_sso parseFrom byte", paramFromServiceMsg);
        localObject = paramIntent;
      }
      if (localObject != null)
      {
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        localStringBuilder.append(" respSendReadedActivateFriends|oidb_sso.OIDBSSOPkg.result=");
        localStringBuilder.append(i);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("respSendReadedActivateFriends | response.result = ");
      paramIntent.append(paramFromServiceMsg.getResultCode());
      QLog.d("ActivateFriends.Servlet", 2, paramIntent.toString());
    }
    QLog.d("ActivateFriends.Servlet", 2, localStringBuilder.toString());
  }
  
  private void c(Intent paramIntent, Packet paramPacket)
  {
    long[] arrayOfLong1 = paramIntent.getLongArrayExtra("p_uin_list");
    long[] arrayOfLong2 = paramIntent.getLongArrayExtra("p_time_list");
    String str = paramIntent.getStringExtra("p_msg");
    int j = paramIntent.getIntExtra("p_gift_id", -1);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("reqSendMessage | uin = ");
      paramIntent.append(Arrays.toString(arrayOfLong1));
      paramIntent.append(" | time = ");
      paramIntent.append(Arrays.toString(arrayOfLong2));
      QLog.d("ActivateFriends.Servlet", 2, paramIntent.toString());
    }
    paramIntent = new cmd0x75f.ReqBody();
    paramIntent.uint64_appid.set(1800000011L);
    paramIntent.uint32_subcmd.set(6);
    Object localObject1 = new cmd0x75f.AddBatchReq();
    ArrayList localArrayList = new ArrayList(arrayOfLong1.length);
    int i = 0;
    while (i < arrayOfLong1.length)
    {
      QTimedMessage.Message localMessage = new QTimedMessage.Message();
      localMessage.uint64_appid.set(1800000011L);
      Object localObject2 = new QTimedMessage.User();
      ((QTimedMessage.User)localObject2).enum_uin_type.set(3);
      ((QTimedMessage.User)localObject2).uint64_uin.set(getAppRuntime().getLongAccountUin());
      localMessage.msg_author.set((MessageMicro)localObject2);
      localMessage.uint32_main_type.set(100);
      localMessage.uint32_sub_type.set(1);
      localMessage.uint64_create_time.set(System.currentTimeMillis());
      localObject2 = new QTimedMessage.Timer();
      ((QTimedMessage.Timer)localObject2).uint64_time.set(arrayOfLong2[i] * 1000L);
      localMessage.msg_timer.set((MessageMicro)localObject2);
      localObject2 = new QTimedMessage.Content();
      QTimedMessage.C2CMessage localC2CMessage = new QTimedMessage.C2CMessage();
      Object localObject3 = new QTimedMessage.User();
      ((QTimedMessage.User)localObject3).enum_uin_type.set(3);
      ((QTimedMessage.User)localObject3).uint64_uin.set(getAppRuntime().getLongAccountUin());
      localC2CMessage.msg_from_user.set((MessageMicro)localObject3);
      localObject3 = new QTimedMessage.User();
      ((QTimedMessage.User)localObject3).enum_uin_type.set(3);
      ((QTimedMessage.User)localObject3).uint64_uin.set(arrayOfLong1[i]);
      localC2CMessage.msg_to_user.set((MessageMicro)localObject3);
      localObject3 = new QTimedMessage.Client();
      ((QTimedMessage.Client)localObject3).uint32_Mobile.set(1);
      ((QTimedMessage.Client)localObject3).uint32_PC.set(1);
      localC2CMessage.msg_recv_client.set((MessageMicro)localObject3);
      if (j != -1)
      {
        localObject3 = new QTimedMessage.C2CMessage.RichText();
        ((QTimedMessage.C2CMessage.RichText)localObject3).uint32_service_id.set(51);
        ((QTimedMessage.C2CMessage.RichText)localObject3).uint32_gift_id.set(j);
        localC2CMessage.msg_rich_text.set((MessageMicro)localObject3);
        localC2CMessage.uint32_send_rich_text_standalone.set(1);
        localC2CMessage.bytes_text.set(ByteStringMicro.copyFrom(str.getBytes()));
        localC2CMessage.uint32_send_text_standalone.set(1);
      }
      else
      {
        localC2CMessage.bytes_text.set(ByteStringMicro.copyFrom(str.getBytes()));
        localC2CMessage.uint32_send_text_standalone.set(1);
      }
      ((QTimedMessage.Content)localObject2).msg_c2c_message.set(localC2CMessage);
      localMessage.msg_content.set((MessageMicro)localObject2);
      localArrayList.add(localMessage);
      i += 1;
    }
    ((cmd0x75f.AddBatchReq)localObject1).rpt_messages.set(localArrayList);
    paramIntent.msg_add_batch_req.set((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1887);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(3);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0x75f");
    localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject1).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject1).array());
  }
  
  public void a(Intent paramIntent, Packet paramPacket)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringArrayListExtra("data");
    if (localObject1 == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("activiate_friends|reqSendReadedActivateFriends size:");
      paramIntent.append(((List)localObject1).size());
      QLog.i("ActivateFriends.Servlet", 2, paramIntent.toString());
    }
    cmd0x82a.ReqBody localReqBody = new cmd0x82a.ReqBody();
    localReqBody.uint32_app_id.set(1001);
    localReqBody.uint32_inst_id.set(AppSetting.a());
    ArrayList localArrayList = new ArrayList(((List)localObject1).size());
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      paramIntent = (String)((List)localObject1).get(i);
      try
      {
        Object localObject3 = new JSONObject(paramIntent);
        Object localObject2 = ((JSONObject)localObject3).optString("key_msg_ext_from_uin", "");
        paramIntent = ((JSONObject)localObject3).optString("key_msg_ext_to_uin", "");
        String str1 = ((JSONObject)localObject3).optString("key_msg_ext_msg_seq", "");
        String str2 = ((JSONObject)localObject3).optString("key_msg_ext_msg_type", "");
        localObject3 = ((JSONObject)localObject3).optString("key_msg_ext_msg_sub_type", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(paramIntent)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          cmd0x82a.MsgInfo localMsgInfo = new cmd0x82a.MsgInfo();
          PBUInt64Field localPBUInt64Field = localMsgInfo.uint64_from_uin;
          localObject2 = Long.valueOf((String)localObject2);
          try
          {
            localPBUInt64Field.set(((Long)localObject2).longValue());
            localMsgInfo.uint64_to_uin.set(Long.valueOf(paramIntent).longValue());
            localMsgInfo.uint32_msg_seq.set(Integer.valueOf(str1).intValue());
            localMsgInfo.uint32_type.set(Integer.valueOf(str2).intValue());
            localMsgInfo.uint32_subtype.set(Integer.valueOf((String)localObject3).intValue());
            localArrayList.add(localMsgInfo);
          }
          catch (Exception paramIntent) {}catch (JSONException paramIntent) {}
        }
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ActivateFriends.Servlet", 2, paramIntent.getMessage(), paramIntent);
        }
      }
      catch (JSONException paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ActivateFriends.Servlet", 2, paramIntent.getMessage(), paramIntent);
        }
      }
      i += 1;
    }
    localReqBody.msg_info.set(localArrayList);
    paramIntent = new oidb_sso.OIDBSSOPkg();
    paramIntent.uint32_command.set(2090);
    paramIntent.uint32_service_type.set(1);
    paramIntent.uint32_result.set(0);
    paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramPacket.setSSOCommand("OidbSvc.0x82a_1");
    paramIntent = paramIntent.toByteArray();
    localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject1).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject1).array());
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resp:");
      localStringBuilder.append(str2);
      localStringBuilder.append(" is ");
      String str1;
      if (bool) {
        str1 = "";
      } else {
        str1 = "not";
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(" success");
      QLog.d("ActivateFriends.Servlet", 2, localStringBuilder.toString());
    }
    if (str2.equals("OidbSvc.0x7c9_2"))
    {
      b(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str2.equals("OidbSvc.0x75f"))
    {
      a(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str2.equals("OidbSvc.0x82a_1")) {
      c(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    int i = localBundle.getInt("param_req_type", 0);
    if (i != 113)
    {
      if (i != 114)
      {
        if (i != 116) {
          return;
        }
        b(paramIntent, paramPacket);
        return;
      }
      a(paramIntent, paramPacket);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Servlet", 2, "req send timing message");
    }
    c(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet
 * JD-Core Version:    0.7.0.1
 */