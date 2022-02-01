package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.ResourceInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.ResourceInfo_17;

public class ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public String g;
  public long h;
  
  public ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  /* Error */
  public static MutualMarkPushInfo a(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 42	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo
    //   6: dup
    //   7: invokespecial 43	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:<init>	()V
    //   10: astore 6
    //   12: aload 6
    //   14: aload_2
    //   15: invokevirtual 47	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   18: pop
    //   19: new 2	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo
    //   22: dup
    //   23: invokespecial 48	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:<init>	()V
    //   26: astore 5
    //   28: aload 5
    //   30: lload_0
    //   31: putfield 50	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_a_of_type_Long	J
    //   34: aload 6
    //   36: getfield 54	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   39: invokevirtual 60	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   42: ifeq +17 -> 59
    //   45: aload 5
    //   47: aload 6
    //   49: getfield 54	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   52: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   55: i2l
    //   56: putfield 66	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_b_of_type_Long	J
    //   59: aload 6
    //   61: getfield 70	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_action_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   64: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   67: ifeq +16 -> 83
    //   70: aload 5
    //   72: aload 6
    //   74: getfield 70	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_action_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   77: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   80: putfield 78	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_c_of_type_Long	J
    //   83: aload 6
    //   85: getfield 81	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_change_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   88: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   91: ifeq +16 -> 107
    //   94: aload 5
    //   96: aload 6
    //   98: getfield 81	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_change_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   101: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   104: putfield 83	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_d_of_type_Long	J
    //   107: aload 6
    //   109: getfield 86	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_continue_days	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 60	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   115: ifeq +16 -> 131
    //   118: aload 5
    //   120: aload 6
    //   122: getfield 86	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_continue_days	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: putfield 88	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_a_of_type_Int	I
    //   131: aload 6
    //   133: getfield 92	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_wildcard_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   136: invokevirtual 95	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   139: ifeq +19 -> 158
    //   142: aload 5
    //   144: aload 6
    //   146: getfield 92	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_wildcard_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   149: invokevirtual 98	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   152: invokevirtual 104	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   155: putfield 106	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   158: aload 6
    //   160: getfield 109	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_duplicate_removal_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   163: invokevirtual 95	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   166: ifeq +19 -> 185
    //   169: aload 5
    //   171: aload 6
    //   173: getfield 109	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_duplicate_removal_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   176: invokevirtual 98	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   179: invokevirtual 104	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   182: putfield 111	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   185: aload 6
    //   187: getfield 114	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_notify_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   190: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   193: ifeq +16 -> 209
    //   196: aload 5
    //   198: aload 6
    //   200: getfield 114	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_notify_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   203: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   206: putfield 116	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_e_of_type_Long	J
    //   209: aload 6
    //   211: getfield 119	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   214: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   217: ifeq +16 -> 233
    //   220: aload 5
    //   222: aload 6
    //   224: getfield 119	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   227: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   230: putfield 121	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_f_of_type_Long	J
    //   233: aload 6
    //   235: getfield 124	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   238: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   241: ifeq +16 -> 257
    //   244: aload 5
    //   246: aload 6
    //   248: getfield 124	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   251: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   254: putfield 126	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_g_of_type_Long	J
    //   257: aload 6
    //   259: getfield 129	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_sub_level	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   262: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   265: ifeq +16 -> 281
    //   268: aload 5
    //   270: aload 6
    //   272: getfield 129	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_sub_level	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   275: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   278: putfield 131	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:h	J
    //   281: aload 6
    //   283: getfield 134	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_graytip_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   286: invokevirtual 60	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   289: ifeq +16 -> 305
    //   292: aload 5
    //   294: aload 6
    //   296: getfield 134	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_graytip_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   299: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   302: putfield 136	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_b_of_type_Int	I
    //   305: aload 6
    //   307: getfield 139	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_close_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   310: invokevirtual 60	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   313: ifeq +22 -> 335
    //   316: aload 6
    //   318: getfield 139	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_close_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   321: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   324: ifeq +159 -> 483
    //   327: iconst_1
    //   328: istore_3
    //   329: aload 5
    //   331: iload_3
    //   332: putfield 34	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:jdField_a_of_type_Boolean	Z
    //   335: aload 6
    //   337: getfield 142	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   340: invokevirtual 95	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   343: ifeq +33 -> 376
    //   346: new 144	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17
    //   349: dup
    //   350: invokespecial 145	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:<init>	()V
    //   353: astore_2
    //   354: aload_2
    //   355: aload 6
    //   357: getfield 142	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   360: invokevirtual 98	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   363: invokevirtual 149	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   366: invokevirtual 150	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   369: pop
    //   370: aload 5
    //   372: aload_2
    //   373: invokestatic 153	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:a	(Lcom/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo;Ltencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17;)V
    //   376: aload 6
    //   378: getfield 156	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_grade_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   381: invokevirtual 95	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   384: ifeq +33 -> 417
    //   387: new 158	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo
    //   390: dup
    //   391: invokespecial 159	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo:<init>	()V
    //   394: astore_2
    //   395: aload_2
    //   396: aload 6
    //   398: getfield 156	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_grade_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   401: invokevirtual 98	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   404: invokevirtual 149	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   407: invokevirtual 160	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   410: pop
    //   411: aload 5
    //   413: aload_2
    //   414: invokestatic 163	com/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo:a	(Lcom/tencent/mobileqq/activity/aio/ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo;Ltencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo;)V
    //   417: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +29 -> 449
    //   423: ldc 170
    //   425: iconst_1
    //   426: new 172	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   433: ldc 175
    //   435: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 5
    //   440: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: aload 5
    //   451: areturn
    //   452: astore_2
    //   453: ldc 170
    //   455: iconst_1
    //   456: new 172	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   463: ldc 191
    //   465: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_2
    //   469: invokevirtual 194	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   472: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   481: aconst_null
    //   482: areturn
    //   483: iconst_0
    //   484: istore_3
    //   485: goto -156 -> 329
    //   488: astore_2
    //   489: ldc 170
    //   491: iconst_1
    //   492: new 172	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   499: ldc 196
    //   501: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_2
    //   505: invokevirtual 194	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   508: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: aconst_null
    //   518: astore_2
    //   519: goto -149 -> 370
    //   522: astore_2
    //   523: ldc 170
    //   525: iconst_1
    //   526: new 172	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   533: ldc 198
    //   535: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_2
    //   539: invokevirtual 194	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   542: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: aload 4
    //   553: astore_2
    //   554: goto -143 -> 411
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	557	0	paramLong	long
    //   0	557	2	paramArrayOfByte	byte[]
    //   328	157	3	bool	boolean
    //   1	551	4	localObject	Object
    //   26	424	5	localMutualMarkPushInfo	MutualMarkPushInfo
    //   10	387	6	localMutualmarkInfo	tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.MutualmarkInfo
    // Exception table:
    //   from	to	target	type
    //   12	19	452	java/lang/Throwable
    //   354	370	488	java/lang/Throwable
    //   395	411	522	java/lang/Throwable
  }
  
  private static void a(MutualMarkPushInfo paramMutualMarkPushInfo, mutualmark.ResourceInfo paramResourceInfo)
  {
    boolean bool = true;
    if (paramResourceInfo != null)
    {
      if (paramResourceInfo.bytes_static_url.has())
      {
        paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString = paramResourceInfo.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_dynamic_url.has())
      {
        paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString = paramResourceInfo.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_cartoon_url.has())
      {
        paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString = paramResourceInfo.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_cartoon_md5.has()) {
        paramMutualMarkPushInfo.jdField_f_of_type_JavaLangString = paramResourceInfo.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo.bytes_word.has()) {
        paramMutualMarkPushInfo.jdField_g_of_type_JavaLangString = paramResourceInfo.bytes_word.get().toStringUtf8();
      }
      if (paramResourceInfo.uint32_play_cartoon.has()) {
        if (paramResourceInfo.uint32_play_cartoon.get() != 1) {
          break label186;
        }
      }
    }
    for (;;)
    {
      paramMutualMarkPushInfo.jdField_b_of_type_Boolean = bool;
      return;
      label186:
      bool = false;
    }
  }
  
  private static void a(MutualMarkPushInfo paramMutualMarkPushInfo, mutualmark.ResourceInfo_17 paramResourceInfo_17)
  {
    boolean bool = true;
    if (paramResourceInfo_17 != null)
    {
      if (paramResourceInfo_17.bytes_static_url.has())
      {
        paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString = paramResourceInfo_17.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_dynamic_url.has())
      {
        paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString = paramResourceInfo_17.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_cartoon_url.has())
      {
        paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString = paramResourceInfo_17.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_cartoon_md5.has()) {
        paramMutualMarkPushInfo.jdField_f_of_type_JavaLangString = paramResourceInfo_17.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo_17.bytes_word.has()) {
        paramMutualMarkPushInfo.jdField_g_of_type_JavaLangString = paramResourceInfo_17.bytes_word.get().toStringUtf8();
      }
      if (paramResourceInfo_17.uint32_play_cartoon.has()) {
        if (paramResourceInfo_17.uint32_play_cartoon.get() != 1) {
          break label186;
        }
      }
    }
    for (;;)
    {
      paramMutualMarkPushInfo.jdField_b_of_type_Boolean = bool;
      return;
      label186:
      bool = false;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsMutualMarkPushInfo{");
    localStringBuilder.append("relation_type:").append(this.jdField_a_of_type_Long).append(", ");
    localStringBuilder.append("relation_level:").append(this.jdField_b_of_type_Long).append(", ");
    localStringBuilder.append("last_action_time:").append(this.jdField_c_of_type_Long).append(", ");
    localStringBuilder.append("last_change_time:").append(this.jdField_d_of_type_Long).append(", ");
    localStringBuilder.append("continue_days:").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder.append("notify_time:").append(this.jdField_e_of_type_Long).append(", ");
    localStringBuilder.append("icon_status:").append(this.jdField_f_of_type_Long).append(", ");
    localStringBuilder.append("icon_status_end_time:").append(this.jdField_g_of_type_Long).append(", ");
    localStringBuilder.append("sub_level:").append(this.h).append(", ");
    localStringBuilder.append("grayTipType:").append(this.jdField_b_of_type_Int).append(", ");
    localStringBuilder.append("wildcard_wording:").append(this.jdField_a_of_type_JavaLangString).append(", ");
    localStringBuilder.append("gray_tip_duplicate_key:").append(this.jdField_b_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_static_url:").append(this.jdField_c_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_dynamic_url:").append(this.jdField_d_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_url:").append(this.jdField_e_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_md5:").append(this.jdField_f_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_name:").append(this.jdField_g_of_type_JavaLangString).append(", ");
    localStringBuilder.append("user_close_flag:").append(this.jdField_a_of_type_Boolean).append(", ");
    localStringBuilder.append("play_cartoon:").append(this.jdField_b_of_type_Boolean).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.MutualMarkPushInfo
 * JD-Core Version:    0.7.0.1
 */