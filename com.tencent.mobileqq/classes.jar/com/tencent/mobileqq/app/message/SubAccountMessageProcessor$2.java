package com.tencent.mobileqq.app.message;

import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.RspBody;

class SubAccountMessageProcessor$2
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  SubAccountMessageProcessor$2(SubAccountMessageProcessor paramSubAccountMessageProcessor, Oidb_0x5d0.RspBody paramRspBody, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  /* Error */
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: new 44	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 45	java/util/ArrayList:<init>	()V
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 21	com/tencent/mobileqq/app/message/SubAccountMessageProcessor$2:a	Ltencent/im/oidb/cmd0x5d0/Oidb_0x5d0$RspBody;
    //   16: getfield 51	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$RspBody:rpt_msg_contentItem	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   19: invokevirtual 57	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   22: invokeinterface 63 1 0
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 69 1 0
    //   36: ifeq +246 -> 282
    //   39: aload 4
    //   41: invokeinterface 73 1 0
    //   46: checkcast 75	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$ContentItem
    //   49: astore 6
    //   51: aload 6
    //   53: getfield 79	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$ContentItem:msg_general_buffer	Ltencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer;
    //   56: getfield 85	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer:bytes_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   59: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   62: ifnull -33 -> 29
    //   65: aload 6
    //   67: getfield 79	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$ContentItem:msg_general_buffer	Ltencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer;
    //   70: getfield 85	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer:bytes_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   73: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   76: invokevirtual 96	com/tencent/mobileqq/pb/ByteStringMicro:size	()I
    //   79: ifle -50 -> 29
    //   82: new 98	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer
    //   85: dup
    //   86: invokespecial 99	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:<init>	()V
    //   89: astore 5
    //   91: aload 5
    //   93: aload 6
    //   95: getfield 79	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$ContentItem:msg_general_buffer	Ltencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer;
    //   98: getfield 85	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer:bytes_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   101: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   104: invokevirtual 103	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   107: invokevirtual 107	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: pop
    //   111: aload 5
    //   113: getfield 110	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:rpt_msg_sns_update_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   119: ifeq -90 -> 29
    //   122: aload 5
    //   124: getfield 110	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:rpt_msg_sns_update_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   127: invokevirtual 57	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   130: invokeinterface 63 1 0
    //   135: astore 6
    //   137: aload 6
    //   139: invokeinterface 69 1 0
    //   144: ifeq -115 -> 29
    //   147: aload 6
    //   149: invokeinterface 73 1 0
    //   154: checkcast 115	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpdateItem
    //   157: astore 7
    //   159: aload 7
    //   161: ifnull -24 -> 137
    //   164: aload 7
    //   166: getfield 119	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpdateItem:uint32_update_sns_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   169: invokevirtual 122	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   172: ifeq -35 -> 137
    //   175: aload 7
    //   177: getfield 123	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpdateItem:bytes_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   180: invokevirtual 124	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   183: ifeq -46 -> 137
    //   186: aload 7
    //   188: getfield 119	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpdateItem:uint32_update_sns_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   191: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   194: sipush 13573
    //   197: if_icmpne -60 -> 137
    //   200: aload 5
    //   202: getfield 130	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   205: invokevirtual 134	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   208: invokestatic 140	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   211: astore 7
    //   213: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +39 -> 255
    //   219: new 147	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   226: astore 8
    //   228: aload 8
    //   230: ldc 150
    //   232: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 8
    //   238: aload 7
    //   240: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 156
    //   246: iconst_2
    //   247: aload 8
    //   249: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload 7
    //   257: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   260: ifne -123 -> 137
    //   263: aload_1
    //   264: aload 7
    //   266: invokevirtual 173	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   269: ifne -132 -> 137
    //   272: aload_1
    //   273: aload 7
    //   275: invokevirtual 176	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   278: pop
    //   279: goto -142 -> 137
    //   282: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +50 -> 335
    //   288: new 147	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   295: astore 4
    //   297: aload 4
    //   299: ldc 178
    //   301: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 4
    //   307: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   310: lload_2
    //   311: lsub
    //   312: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 4
    //   318: ldc 183
    //   320: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: ldc 156
    //   326: iconst_2
    //   327: aload 4
    //   329: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_1
    //   336: areturn
    //   337: astore_1
    //   338: goto +72 -> 410
    //   341: astore_1
    //   342: aload_1
    //   343: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   346: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +11 -> 360
    //   352: ldc 156
    //   354: iconst_2
    //   355: ldc 188
    //   357: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +45 -> 408
    //   366: new 147	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   373: astore_1
    //   374: aload_1
    //   375: ldc 178
    //   377: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_1
    //   382: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   385: lload_2
    //   386: lsub
    //   387: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_1
    //   392: ldc 183
    //   394: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: ldc 156
    //   400: iconst_2
    //   401: aload_1
    //   402: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aconst_null
    //   409: areturn
    //   410: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq +50 -> 463
    //   416: new 147	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   423: astore 4
    //   425: aload 4
    //   427: ldc 178
    //   429: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 4
    //   435: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   438: lload_2
    //   439: lsub
    //   440: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 4
    //   446: ldc 183
    //   448: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: ldc 156
    //   454: iconst_2
    //   455: aload 4
    //   457: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: goto +5 -> 468
    //   466: aload_1
    //   467: athrow
    //   468: goto -2 -> 466
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	2
    //   0	471	1	paramVarArgs	Void[]
    //   3	436	2	l	long
    //   27	429	4	localObject1	java.lang.Object
    //   89	112	5	localSnsUpateBuffer	tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer
    //   49	99	6	localObject2	java.lang.Object
    //   157	117	7	localObject3	java.lang.Object
    //   226	22	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	29	337	finally
    //   29	137	337	finally
    //   137	159	337	finally
    //   164	255	337	finally
    //   255	279	337	finally
    //   342	360	337	finally
    //   4	29	341	java/lang/Exception
    //   29	137	341	java/lang/Exception
    //   137	159	341	java/lang/Exception
    //   164	255	341	java/lang/Exception
    //   255	279	341	java/lang/Exception
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null) {
      ((ISubAccountControlService)SubAccountMessageProcessor.a(this.f).getRuntimeService(ISubAccountControlService.class, "")).storeSubAccountSpecialCareList(this.b, this.c, paramArrayList, this.d, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SubAccountMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */