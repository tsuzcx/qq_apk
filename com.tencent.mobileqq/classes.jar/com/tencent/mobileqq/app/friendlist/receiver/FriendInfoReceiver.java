package com.tencent.mobileqq.app.friendlist.receiver;

import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateResp;
import KQQ.SetRichSigRes;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.BindContactsFriendInfo;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.RspBody;

public class FriendInfoReceiver
  extends BaseHandlerReceiver
{
  private short a;
  
  public FriendInfoReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
    this.jdField_a_of_type_Short = 20002;
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, CheckUpdateResp paramCheckUpdateResp)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("uin");
    String str2 = paramToServiceMsg.extraData.getString("com_value");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("notify_plugin");
    paramToServiceMsg = new Object[3];
    boolean bool1 = false;
    paramToServiceMsg[0] = str1;
    paramToServiceMsg[1] = str2;
    int i = paramFromServiceMsg.getResultCode();
    paramFromServiceMsg = Byte.valueOf((byte)-1);
    if (1000 == i)
    {
      paramObject = (ChangeFriendNameRes)paramObject;
      if ((paramObject != null) && (paramObject.cResult == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setFriendComment(str1, str2, true);
        paramToServiceMsg[2] = Byte.valueOf(paramObject.cResult);
        a(27, true, paramToServiceMsg);
        bool1 = true;
      }
      else
      {
        if (paramObject != null) {
          paramToServiceMsg[2] = Byte.valueOf(paramObject.cResult);
        } else {
          paramToServiceMsg[2] = paramFromServiceMsg;
        }
        a(27, false, paramToServiceMsg);
      }
    }
    else
    {
      paramToServiceMsg[2] = paramFromServiceMsg;
      a(27, false, paramToServiceMsg);
    }
    if (bool2)
    {
      paramToServiceMsg = new Intent("action_set_remark_plugin");
      paramToServiceMsg.putExtra("uin", str1);
      paramToServiceMsg.putExtra("remark", str2);
      paramToServiceMsg.putExtra("is_suc", bool1);
      BaseApplicationImpl.getContext().sendBroadcast(paramToServiceMsg);
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (SetRichSigRes)paramObject;
      if (paramObject.cResult == 0)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localFriendsManager != null)
        {
          byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("sig_value");
          if (paramObject.dwTime == 0L) {
            paramObject.dwTime = 1L;
          }
          paramFromServiceMsg = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          }
          if (paramToServiceMsg.timestamp != paramObject.dwTime)
          {
            ExtensionRichStatus.a(paramToServiceMsg, arrayOfByte, paramObject.dwTime);
            localFriendsManager.a(paramToServiceMsg);
          }
        }
        a(28, true, null);
        return;
      }
      a(28, false, Integer.valueOf(paramObject.cResult));
      return;
    }
    a(28, false, null);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0xcf0.RspBody localRspBody = new cmd0xcf0.RspBody();
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int k = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = null;
    paramFromServiceMsg = null;
    int i;
    if (k == 0)
    {
      int j = localRspBody.uint32_total_bind_contacts_frd_num.get();
      paramObject = localRspBody.rpt_msg_bind_contacts_frds.get();
      paramToServiceMsg = paramFromServiceMsg;
      if (paramObject != null)
      {
        paramToServiceMsg = paramFromServiceMsg;
        if (paramObject.size() > 0)
        {
          paramFromServiceMsg = new ArrayList(paramObject.size());
          paramObject = paramObject.iterator();
          for (;;)
          {
            paramToServiceMsg = paramFromServiceMsg;
            if (!paramObject.hasNext()) {
              break;
            }
            paramToServiceMsg = (cmd0xcf0.BindContactsFriendInfo)paramObject.next();
            if ((paramToServiceMsg != null) && (paramToServiceMsg.uint64_uin.get() != 0L)) {
              paramFromServiceMsg.add(String.valueOf(paramToServiceMsg.uint64_uin.get()));
            }
          }
        }
      }
      paramObject = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
      paramFromServiceMsg = paramToServiceMsg;
      i = j;
      if (paramObject != null)
      {
        paramObject.onGetFriendsHasBindPhone(j, paramToServiceMsg);
        paramFromServiceMsg = paramToServiceMsg;
        i = j;
      }
    }
    else
    {
      i = 0;
      paramFromServiceMsg = paramToServiceMsg;
    }
    if (QLog.isColorLevel())
    {
      if (paramFromServiceMsg == null) {
        paramToServiceMsg = "null";
      } else {
        paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.size());
      }
      QLog.i("FriendListHandler.BaseHandlerReceiver", 2, String.format("handleGetFriendsHasBindPhone [%s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramToServiceMsg }));
    }
    boolean bool;
    if (k == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(118, bool, new Object[] { Integer.valueOf(i), paramFromServiceMsg });
  }
  
  /* Error */
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 112	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 9
    //   6: iconst_1
    //   7: istore 5
    //   9: iconst_1
    //   10: istore 6
    //   12: iload 9
    //   14: ifeq +13 -> 27
    //   17: aload_3
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore 9
    //   24: goto +6 -> 30
    //   27: iconst_0
    //   28: istore 9
    //   30: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +37 -> 70
    //   36: new 280	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   43: astore_1
    //   44: aload_1
    //   45: ldc_w 283
    //   48: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_1
    //   53: iload 9
    //   55: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc_w 263
    //   62: iconst_2
    //   63: aload_1
    //   64: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: iload 9
    //   72: ifeq +683 -> 755
    //   75: new 297	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: dup
    //   79: invokespecial 298	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   82: aload_3
    //   83: checkcast 300	[B
    //   86: checkcast 300	[B
    //   89: invokevirtual 304	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   92: checkcast 297	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: astore_1
    //   96: aload_1
    //   97: getfield 307	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   100: invokevirtual 310	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   103: ifeq +689 -> 792
    //   106: aload_1
    //   107: getfield 307	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 190	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: ifne +679 -> 792
    //   116: iconst_1
    //   117: istore 9
    //   119: goto +3 -> 122
    //   122: aload_1
    //   123: getfield 307	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 310	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   129: ifeq +669 -> 798
    //   132: aload_1
    //   133: getfield 307	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   136: invokevirtual 190	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   139: istore 4
    //   141: goto +3 -> 144
    //   144: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +37 -> 184
    //   150: new 280	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   157: astore_2
    //   158: aload_2
    //   159: ldc_w 312
    //   162: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_2
    //   167: iload 9
    //   169: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc_w 263
    //   176: iconst_2
    //   177: aload_2
    //   178: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iload 9
    //   186: ifeq +410 -> 596
    //   189: aload_1
    //   190: getfield 316	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   193: ifnull +403 -> 596
    //   196: aload_1
    //   197: getfield 316	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   200: invokevirtual 319	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   203: ifeq +393 -> 596
    //   206: aload_1
    //   207: getfield 316	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   210: invokevirtual 322	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   213: ifnull +383 -> 596
    //   216: aload_1
    //   217: getfield 316	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 322	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   223: invokevirtual 328	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   226: invokestatic 334	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 337	java/nio/ByteBuffer:get	()B
    //   234: istore 4
    //   236: aload_1
    //   237: invokevirtual 340	java/nio/ByteBuffer:getInt	()I
    //   240: istore 8
    //   242: aload_1
    //   243: invokevirtual 344	java/nio/ByteBuffer:getShort	()S
    //   246: istore 7
    //   248: new 346	java/util/HashMap
    //   251: dup
    //   252: iload 7
    //   254: invokespecial 347	java/util/HashMap:<init>	(I)V
    //   257: astore_2
    //   258: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +67 -> 328
    //   264: new 280	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   271: astore_3
    //   272: aload_3
    //   273: ldc_w 349
    //   276: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_3
    //   281: iload 4
    //   283: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_3
    //   288: ldc_w 354
    //   291: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_3
    //   296: iload 8
    //   298: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_3
    //   303: ldc_w 356
    //   306: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_3
    //   311: iload 7
    //   313: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: ldc_w 263
    //   320: iconst_2
    //   321: aload_3
    //   322: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: iload 8
    //   330: iconst_m1
    //   331: if_icmpne +483 -> 814
    //   334: new 358	java/lang/StringBuffer
    //   337: dup
    //   338: invokespecial 359	java/lang/StringBuffer:<init>	()V
    //   341: astore_3
    //   342: iconst_0
    //   343: istore 4
    //   345: iload 4
    //   347: iload 7
    //   349: if_icmpge +168 -> 517
    //   352: aload_1
    //   353: invokevirtual 340	java/nio/ByteBuffer:getInt	()I
    //   356: invokestatic 364	com/tencent/mobileqq/util/Utils:a	(I)J
    //   359: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   362: astore 11
    //   364: aload_1
    //   365: invokevirtual 344	java/nio/ByteBuffer:getShort	()S
    //   368: istore 8
    //   370: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +18 -> 391
    //   376: aload_3
    //   377: ldc_w 366
    //   380: invokevirtual 369	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   383: pop
    //   384: aload_3
    //   385: iload 8
    //   387: invokevirtual 372	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   390: pop
    //   391: iload 8
    //   393: iconst_1
    //   394: if_icmpne +410 -> 804
    //   397: aload_1
    //   398: invokevirtual 344	java/nio/ByteBuffer:getShort	()S
    //   401: istore 8
    //   403: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +18 -> 424
    //   409: aload_3
    //   410: ldc_w 374
    //   413: invokevirtual 369	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   416: pop
    //   417: aload_3
    //   418: iload 8
    //   420: invokevirtual 372	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   423: pop
    //   424: iload 8
    //   426: aload_0
    //   427: getfield 12	com/tencent/mobileqq/app/friendlist/receiver/FriendInfoReceiver:jdField_a_of_type_Short	S
    //   430: if_icmpne +374 -> 804
    //   433: aload_1
    //   434: invokevirtual 344	java/nio/ByteBuffer:getShort	()S
    //   437: newarray byte
    //   439: astore 12
    //   441: aload_1
    //   442: aload 12
    //   444: invokevirtual 376	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   447: pop
    //   448: new 235	java/lang/String
    //   451: dup
    //   452: aload 12
    //   454: invokespecial 379	java/lang/String:<init>	([B)V
    //   457: astore 12
    //   459: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +41 -> 503
    //   465: aload_3
    //   466: ldc_w 381
    //   469: invokevirtual 369	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   472: pop
    //   473: aload_3
    //   474: aload 11
    //   476: iconst_0
    //   477: iconst_4
    //   478: invokevirtual 385	java/lang/String:substring	(II)Ljava/lang/String;
    //   481: invokevirtual 369	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   484: pop
    //   485: aload_3
    //   486: ldc_w 387
    //   489: invokevirtual 369	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   492: pop
    //   493: aload_3
    //   494: aload 12
    //   496: invokestatic 391	com/tencent/mobileqq/util/MessageRecordUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   499: invokevirtual 369	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   502: pop
    //   503: aload_2
    //   504: aload 11
    //   506: aload 12
    //   508: invokeinterface 397 3 0
    //   513: pop
    //   514: goto +290 -> 804
    //   517: iload 9
    //   519: istore 10
    //   521: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +21 -> 545
    //   527: ldc_w 263
    //   530: iconst_2
    //   531: aload_3
    //   532: invokevirtual 398	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   535: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: iload 9
    //   540: istore 10
    //   542: goto +3 -> 545
    //   545: aload_0
    //   546: bipush 74
    //   548: iload 10
    //   550: aload_2
    //   551: invokevirtual 79	com/tencent/mobileqq/app/friendlist/receiver/FriendInfoReceiver:a	(IZLjava/lang/Object;)V
    //   554: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +38 -> 595
    //   560: new 280	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   567: astore_1
    //   568: aload_1
    //   569: ldc_w 400
    //   572: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload_1
    //   577: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   580: invokevirtual 408	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: ldc_w 263
    //   587: iconst_2
    //   588: aload_1
    //   589: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: return
    //   596: goto +162 -> 758
    //   599: astore_1
    //   600: goto +112 -> 712
    //   603: astore_1
    //   604: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   607: ifeq +14 -> 621
    //   610: ldc_w 263
    //   613: iconst_2
    //   614: ldc_w 410
    //   617: aload_1
    //   618: invokestatic 414	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   621: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   624: ifeq +155 -> 779
    //   627: new 280	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   634: astore_1
    //   635: iload 6
    //   637: istore 4
    //   639: aload_1
    //   640: ldc_w 400
    //   643: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload_1
    //   648: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   651: invokevirtual 408	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: ldc_w 263
    //   658: iconst_2
    //   659: aload_1
    //   660: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: iload 4
    //   668: istore 5
    //   670: goto +109 -> 779
    //   673: astore_1
    //   674: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   677: ifeq +14 -> 691
    //   680: ldc_w 263
    //   683: iconst_2
    //   684: ldc_w 416
    //   687: aload_1
    //   688: invokestatic 414	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   691: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   694: ifeq +85 -> 779
    //   697: new 280	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   704: astore_1
    //   705: iload 6
    //   707: istore 4
    //   709: goto -70 -> 639
    //   712: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   715: ifeq +38 -> 753
    //   718: new 280	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   725: astore_2
    //   726: aload_2
    //   727: ldc_w 400
    //   730: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload_2
    //   735: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   738: invokevirtual 408	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: ldc_w 263
    //   745: iconst_2
    //   746: aload_2
    //   747: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: aload_1
    //   754: athrow
    //   755: iconst_0
    //   756: istore 4
    //   758: iload 4
    //   760: istore 5
    //   762: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   765: ifeq +14 -> 779
    //   768: new 280	java/lang/StringBuilder
    //   771: dup
    //   772: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   775: astore_1
    //   776: goto -137 -> 639
    //   779: aload_0
    //   780: bipush 74
    //   782: iconst_0
    //   783: iload 5
    //   785: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: invokevirtual 79	com/tencent/mobileqq/app/friendlist/receiver/FriendInfoReceiver:a	(IZLjava/lang/Object;)V
    //   791: return
    //   792: iconst_0
    //   793: istore 9
    //   795: goto -673 -> 122
    //   798: iconst_m1
    //   799: istore 4
    //   801: goto -657 -> 144
    //   804: iload 4
    //   806: iconst_1
    //   807: iadd
    //   808: i2s
    //   809: istore 4
    //   811: goto -466 -> 345
    //   814: iconst_0
    //   815: istore 10
    //   817: goto -272 -> 545
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	820	0	this	FriendInfoReceiver
    //   0	820	1	paramToServiceMsg	ToServiceMsg
    //   0	820	2	paramFromServiceMsg	FromServiceMsg
    //   0	820	3	paramObject	Object
    //   139	671	4	i	int
    //   7	777	5	j	int
    //   10	696	6	k	int
    //   246	104	7	m	int
    //   240	191	8	n	int
    //   4	790	9	bool1	boolean
    //   519	297	10	bool2	boolean
    //   362	143	11	str	String
    //   439	68	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   75	116	599	finally
    //   122	141	599	finally
    //   144	184	599	finally
    //   189	328	599	finally
    //   334	342	599	finally
    //   352	391	599	finally
    //   397	424	599	finally
    //   424	503	599	finally
    //   503	514	599	finally
    //   521	538	599	finally
    //   545	554	599	finally
    //   604	621	599	finally
    //   674	691	599	finally
    //   75	116	603	java/lang/Exception
    //   122	141	603	java/lang/Exception
    //   144	184	603	java/lang/Exception
    //   189	328	603	java/lang/Exception
    //   334	342	603	java/lang/Exception
    //   352	391	603	java/lang/Exception
    //   397	424	603	java/lang/Exception
    //   424	503	603	java/lang/Exception
    //   503	514	603	java/lang/Exception
    //   521	538	603	java/lang/Exception
    //   545	554	603	java/lang/Exception
    //   75	116	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	141	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   144	184	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   189	328	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   334	342	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   352	391	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   397	424	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   424	503	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   503	514	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   521	538	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   545	554	673	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("dwReqType", 1L);
    if (l == 0L) {
      paramToServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("dwUin"));
    } else {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("strMobile");
    }
    if (paramObject == null)
    {
      a(67, false, new Object[] { Long.valueOf(l), paramToServiceMsg });
      return;
    }
    if ((paramObject instanceof GetOnlineInfoResp))
    {
      paramFromServiceMsg = (GetOnlineInfoResp)paramObject;
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleOnlineInfo, uin = ");
        paramObject.append(StringUtil.e(paramToServiceMsg));
        paramObject.append(", result = ");
        paramObject.append(paramFromServiceMsg.result);
        paramObject.append(", itermType = ");
        paramObject.append(paramFromServiceMsg.iTermType);
        paramObject.append(", netType = ");
        paramObject.append(paramFromServiceMsg.eNetworkType);
        paramObject.append(", abi = ");
        paramObject.append(paramFromServiceMsg.uAbiFlag);
        paramObject.append(", status = ");
        paramObject.append(paramFromServiceMsg.dwStatus);
        paramObject.append(", strTermDesc = ");
        paramObject.append(paramFromServiceMsg.strTermDesc);
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramObject.toString());
      }
      if ((l == 0L) && (paramFromServiceMsg.result == 0)) {
        ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramToServiceMsg, paramFromServiceMsg);
      } else if ((l == 1L) && (paramFromServiceMsg.result == 0)) {
        ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).updateOnlineStatus(paramToServiceMsg, paramFromServiceMsg);
      }
      paramFromServiceMsg.dwInterval *= 1000L;
      if (paramFromServiceMsg.dwInterval < 15000L) {
        paramFromServiceMsg.dwInterval = 15000L;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.intervalGetOnlineInfo = paramFromServiceMsg.dwInterval;
      a(67, true, new Object[] { Long.valueOf(l), paramToServiceMsg, paramFromServiceMsg });
    }
  }
  
  public boolean a(String paramString)
  {
    return ("ProfileService.ChangeFriendName".equals(paramString)) || ("ProfileService.SetRichSig".equals(paramString)) || ("OidbSvc.0x77c".equals(paramString)) || ("ProfileService.CheckUpdateReq".equals(paramString)) || ("OidbSvc.0xcf0_0".equals(paramString)) || ("OidbSvc.0x49d_107".equals(paramString)) || ("friendlist.GetOnlineInfoReq".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("ProfileService.ChangeFriendName".equals(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("ProfileService.SetRichSig".equals(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x77c".equals(str)) {
      return;
    }
    if ("ProfileService.CheckUpdateReq".equals(str))
    {
      a(paramFromServiceMsg, (CheckUpdateResp)paramObject);
      return;
    }
    if ("OidbSvc.0xcf0_0".equals(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x49d_107".equals(str))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("friendlist.GetOnlineInfoReq".equals(str)) {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.FriendInfoReceiver
 * JD-Core Version:    0.7.0.1
 */