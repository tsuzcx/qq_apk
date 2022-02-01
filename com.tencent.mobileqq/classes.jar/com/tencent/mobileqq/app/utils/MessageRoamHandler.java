package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class MessageRoamHandler
  extends BusinessHandler
{
  public int a;
  public SparseArray<MessageRoamHandler.ChatHistoryMessageObserver> a;
  private QQAppInterface a;
  
  public MessageRoamHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Object localObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
          return;
        }
        int i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handle_oidb_0x42e_3 ret = ");
          ((StringBuilder)localObject).append(i);
          QLog.i("Q.roammsg", 2, ((StringBuilder)localObject).toString());
        }
        if (i == 0)
        {
          a(paramFromServiceMsg, paramToServiceMsg, paramObject);
          return;
        }
        a(paramFromServiceMsg, i, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 error: ", paramToServiceMsg);
        }
        paramObject.a(16, null);
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handle_oidb_0x42e_3 error: ");
        if (paramFromServiceMsg != null) {
          paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode());
        } else {
          paramToServiceMsg = "null";
        }
        ((StringBuilder)localObject).append(paramToServiceMsg);
        QLog.d("Q.roammsg", 2, ((StringBuilder)localObject).toString());
      }
      paramObject.a(16, null);
    }
  }
  
  private void a(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, int paramInt, MessageRoamManager paramMessageRoamManager)
  {
    paramOIDBSSOPkg = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    int j = paramOIDBSSOPkg.length;
    int i = 0;
    if (1 <= j) {
      i = (short)paramOIDBSSOPkg[0];
    }
    if (1 + i <= j) {
      paramOIDBSSOPkg = PkgTools.getUTFString(paramOIDBSSOPkg, 1, i);
    } else {
      paramOIDBSSOPkg = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle_oidb_0x42e_3 ret = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      if (paramOIDBSSOPkg == null) {
        paramOIDBSSOPkg = "null";
      }
      localStringBuilder.append(paramOIDBSSOPkg);
      QLog.d("Q.roammsg", 2, localStringBuilder.toString());
    }
    paramMessageRoamManager.a(16, null);
  }
  
  private void a(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, ToServiceMsg paramToServiceMsg, MessageRoamManager paramMessageRoamManager)
  {
    Object localObject = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    int i4 = localObject.length;
    long l;
    if (4 <= i4) {
      l = PkgTools.getLongData((byte[])localObject, 0);
    } else {
      l = 0L;
    }
    int k;
    if (6 <= i4) {
      k = PkgTools.getShortData((byte[])localObject, 4);
    } else {
      k = 0;
    }
    int m;
    if (8 <= i4) {
      m = PkgTools.getShortData((byte[])localObject, 6);
    } else {
      m = 0;
    }
    if (10 <= i4) {
      i = PkgTools.getShortData((byte[])localObject, 8);
    } else {
      i = 0;
    }
    int i1 = 12;
    if (12 <= i4) {
      j = PkgTools.getShortData((byte[])localObject, 10);
    } else {
      j = 0;
    }
    if ((i == 0) && (j == 0) && (k == 0) && (m == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 : wYearEnd = wMonthEnd = wYearStart = wMonthStart = 0");
      }
      paramMessageRoamManager.a(2002);
      paramMessageRoamManager.a(17, null);
      return;
    }
    int i5 = (i - k) * 12 + (j - m) + 1;
    paramOIDBSSOPkg = new long[i5];
    int n = 0;
    while (n < i5)
    {
      i3 = i1 + 4;
      i2 = i1;
      if (i3 <= i4)
      {
        paramOIDBSSOPkg[n] = PkgTools.getLongData((byte[])localObject, i1);
        i2 = i3;
      }
      n += 1;
      i1 = i2;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle_oidb_0x42e_3 Begin: ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(", End: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" : dwIndexes = ");
      ((StringBuilder)localObject).append(Arrays.toString(paramOIDBSSOPkg));
      QLog.d("Q.roammsg", 2, ((StringBuilder)localObject).toString());
    }
    i5 = paramToServiceMsg.extraData.getInt("EndRoamYearKey");
    int i6 = paramToServiceMsg.extraData.getInt("EndRoamMonthKey");
    i4 = paramToServiceMsg.extraData.getInt("EndRoamDayKey");
    paramMessageRoamManager.a().d();
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 : clearRoamDateSerIndex...");
    }
    int i2 = j;
    n = i;
    int i3 = 0;
    i1 = i;
    int i = n;
    n = j;
    int j = i2;
    i2 = i3;
    for (;;)
    {
      if ((i == i5) && (j == i6)) {
        i3 = i4;
      } else {
        i3 = 31;
      }
      paramMessageRoamManager.a().a(l, i, j, (int)paramOIDBSSOPkg[i2], i3);
      if (j - 1 > 0)
      {
        j -= 1;
      }
      else
      {
        i -= 1;
        j = 12;
      }
      if ((i < k) || ((i == k) && (j < m))) {
        break;
      }
      i2 += 1;
    }
    paramMessageRoamManager.b(i5, i6, i4);
    paramMessageRoamManager.a().a(String.valueOf(l), k, m, i1, n);
    paramMessageRoamManager.m();
    paramMessageRoamManager.c();
    paramMessageRoamManager.a(2003);
    paramMessageRoamManager.a(18, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    int k = paramToServiceMsg.extraData.getShort("authMode");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle_roam_message_auth_mode retCode: ");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(", mode: ");
      paramToServiceMsg.append(k);
      QLog.d("Q.roammsg", 2, paramToServiceMsg.toString());
    }
    if (1000 == i)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        int j = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handle_roam_message_auth_mode ret=");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(", authMode: ");
          paramToServiceMsg.append(k);
          QLog.i("Q.roammsg", 2, paramToServiceMsg.toString());
        }
        i = j;
        if (j == 0)
        {
          paramToServiceMsg = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
          i = j;
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.d(k);
            i = j;
          }
        }
      }
      else
      {
        i = 0;
      }
    }
    else
    {
      i = -1;
    }
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatHistoryAuthDevForRoamMsgFragment.class);
    if (paramToServiceMsg != null)
    {
      paramFromServiceMsg = paramToServiceMsg.obtainMessage();
      paramFromServiceMsg.what = 1;
      paramFromServiceMsg.arg1 = i;
      paramFromServiceMsg.arg2 = k;
      paramToServiceMsg.sendMessage(paramFromServiceMsg);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle_get_roam_msg_auth_mode isSuccess: ");
      paramToServiceMsg.append(bool1);
      QLog.d("Q.roammsg", 2, paramToServiceMsg.toString());
    }
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramToServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        i = -1;
        if (paramFromServiceMsg.uint32_result.has()) {
          i = paramFromServiceMsg.uint32_result.get();
        }
        if (i == 0)
        {
          long l = paramToServiceMsg.getInt();
          paramToServiceMsg.get();
          int j = paramToServiceMsg.getShort();
          if (!QLog.isColorLevel()) {
            break label524;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_get_roam_msg_auth_mode, request success, tlvCount = ");
          paramFromServiceMsg.append(j);
          QLog.d("Q.roammsg", 2, paramFromServiceMsg.toString());
          break label524;
          if ((paramToServiceMsg.hasRemaining()) && (i < j))
          {
            int k = paramToServiceMsg.getShort();
            int m = paramToServiceMsg.getShort();
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("handle_get_roam_msg_auth_mode, TLV type: ");
              paramFromServiceMsg.append(k);
              paramFromServiceMsg.append(",legnth: ");
              paramFromServiceMsg.append(m);
              QLog.d("Q.roammsg", 2, paramFromServiceMsg.toString());
            }
            if (k == -23723)
            {
              i = paramToServiceMsg.getShort();
              paramToServiceMsg = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
              if (paramToServiceMsg != null) {
                paramToServiceMsg.d(i);
              }
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append("handle_get_roam_msg_auth_mode authMode is :");
                paramFromServiceMsg.append(i);
                paramFromServiceMsg.append(", manager is null: ");
                if (paramToServiceMsg != null) {
                  break label530;
                }
                bool1 = bool2;
                paramFromServiceMsg.append(bool1);
                QLog.i("Q.roammsg", 2, paramFromServiceMsg.toString());
              }
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break label536;
              }
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("handle_get_roam_msg_auth_mode TLV error T: ");
              paramFromServiceMsg.append(k);
              QLog.i("Q.roammsg", 2, paramFromServiceMsg.toString());
              break label536;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handle_get_roam_msg_auth_mode pkg_result: ");
          paramToServiceMsg.append(i);
          QLog.d("Q.roammsg", 2, paramToServiceMsg.toString());
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_get_roam_msg_auth_mode exception: ");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.d("Q.roammsg", 2, paramFromServiceMsg.toString());
        }
      }
      ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a(34, null);
      return;
      label524:
      int i = 0;
      continue;
      label530:
      bool1 = false;
      continue;
      label536:
      i += 1;
    }
  }
  
  public MessageObserver a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      MessageRoamHandler.ChatHistoryMessageObserver localChatHistoryMessageObserver = new MessageRoamHandler.ChatHistoryMessageObserver(this, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localChatHistoryMessageObserver);
    }
    return (MessageObserver)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "get_roam_msg_auth_mode begin...");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject = ByteBuffer.allocate(9);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    ((ByteBuffer)localObject).put((byte)0);
    ((ByteBuffer)localObject).putShort((short)1);
    ((ByteBuffer)localObject).putShort((short)-23723);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x480_9");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("reqFromMessageRoamHandler", true);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[12];
      PkgTools.dWord2Byte(paramString, 0, l);
      PkgTools.dWordTo2Bytes(paramString, 4, paramInt1);
      PkgTools.dWordTo2Bytes(paramString, 6, paramInt2);
      PkgTools.dWordTo2Bytes(paramString, 8, paramInt3);
      PkgTools.dWordTo2Bytes(paramString, 10, paramInt4);
      paramString = makeOIDBPkg("OidbSvc.0x42e_3", 1070, 3, paramString);
      paramString.extraData.putInt("EndRoamYearKey", paramInt3);
      paramString.extraData.putInt("EndRoamMonthKey", paramInt4);
      paramString.extraData.putInt("EndRoamDayKey", paramInt5);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "send_oidb_0x42e_3 error: ", paramString);
      }
    }
  }
  
  public void a(String paramString, Calendar paramCalendar, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(String paramString, Calendar paramCalendar, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    a(paramString, paramCalendar, paramBoolean1, paramInt, paramBoolean2, true);
  }
  
  public void a(String paramString, Calendar paramCalendar, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
    if (localMessageRoamManager.b() == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vip_message_roam_last_request_timestamp");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      if ((System.currentTimeMillis() - l1 > 7200000L) || (l1 == 0L))
      {
        paramString = new StringBuilder();
        paramString.append("getRoamHistoryForSomeDay open password lastRequestTime = ");
        paramString.append(l1);
        QLog.d("Q.roammsg", 1, paramString.toString());
        localMessageRoamManager.a(3, 2, null);
        paramString = localSharedPreferences.edit();
        paramCalendar = new StringBuilder();
        paramCalendar.append("vip_message_roam_last_request_timestamp");
        paramCalendar.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramString.putLong(paramCalendar.toString(), System.currentTimeMillis());
        paramString.commit();
        return;
      }
    }
    paramCalendar = localMessageRoamManager.a((Calendar)paramCalendar.clone());
    long l1 = ((Long)paramCalendar.first).longValue();
    long l2 = ((Long)paramCalendar.second).longValue();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramString, l1, 0L, l2, (short)0, 0L, 1, localMessageRoamManager.a(), localMessageRoamManager.b(), paramBoolean1, paramInt, paramBoolean2, paramBoolean3);
  }
  
  public void a(short paramShort)
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set_roam_message_auth_mode_0x4ff_9  authMode: ");
        ((StringBuilder)localObject).append(paramShort);
        QLog.d("Q.roammsg", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new byte[13];
      PkgTools.dWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.word2Byte((byte[])localObject, 5, (short)1);
      PkgTools.dWordTo2Bytes((byte[])localObject, 7, 41813);
      PkgTools.word2Byte((byte[])localObject, 9, (short)2);
      PkgTools.word2Byte((byte[])localObject, 11, paramShort);
      localObject = makeOIDBPkg("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromMessageRoamHandler", true);
      ((ToServiceMsg)localObject).extraData.putShort("authMode", paramShort);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.roammsg", 2, "set_roam_message_auth_mode_0x4ff_9  error", localException);
      }
    }
  }
  
  public boolean a(String paramString, Calendar paramCalendar, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    paramCalendar = ((MessageRoamManager)localObject1).a(paramCalendar);
    if (paramCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage next date is null");
      }
      return false;
    }
    Object localObject2 = paramCalendar.getString("MSG_TYPE");
    int i = paramCalendar.getInt("DATE_YEAR");
    int j = paramCalendar.getInt("DATE_MONTH");
    int k = paramCalendar.getInt("DATE_DAY");
    paramCalendar = Calendar.getInstance();
    paramCalendar.set(1, i);
    paramCalendar.set(2, j - 1);
    paramCalendar.set(5, k);
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
    if ("server".equals(localObject2))
    {
      ((MessageRoamManager)localObject1).a(paramCalendar);
      QLog.d("Q.roammsg", 1, "fetchMoreRoamMessage getRoamHistoryForSomeDay");
      a(paramString, paramCalendar, paramBoolean, paramInt, false);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("fetchMoreRoamMessage from server date: ");
        paramString.append(i);
        paramString.append("-");
        paramString.append(j);
        paramString.append("-");
        paramString.append(k);
        paramString.append(", fetchNum: ");
        paramString.append(paramInt);
        QLog.d("Q.roammsg", 2, paramString.toString());
      }
      return true;
    }
    if ("local".equals(localObject2))
    {
      ((MessageRoamManager)localObject1).a(paramCalendar);
      localObject2 = ((MessageRoamManager)localObject1).a((Calendar)paramCalendar.clone());
      int m = ((MessageRoamManager)localObject1).a(paramString, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("fetchMoreRoamMessage from local date: ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(",msgcount: ");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(", fetchNum: ");
        ((StringBuilder)localObject1).append(paramInt - m);
        QLog.d("Q.roammsg", 2, ((StringBuilder)localObject1).toString());
      }
      if ((m >= 0) && (m < paramInt)) {
        return a(paramString, paramCalendar, paramBoolean, paramInt - m);
      }
      return false;
    }
    return false;
  }
  
  public MessageObserver b(int paramInt)
  {
    MessageObserver localMessageObserver = (MessageObserver)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    return localMessageObserver;
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x42e_3");
      this.allowCmdSet.add("OidbSvc.0x4ff_9");
      this.allowCmdSet.add("OidbSvc.0x480_9");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(", serviceCmd: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", resultCode: ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.roammsg", 2, localStringBuilder.toString());
    }
    if ("OidbSvc.0x42e_3".equals(str))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x4ff_9".equals(str))
    {
      if (paramToServiceMsg.extraData.getBoolean("reqFromMessageRoamHandler")) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else if (("OidbSvc.0x480_9".equals(str)) && (paramToServiceMsg.extraData.getBoolean("reqFromMessageRoamHandler"))) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.MessageRoamHandler
 * JD-Core Version:    0.7.0.1
 */