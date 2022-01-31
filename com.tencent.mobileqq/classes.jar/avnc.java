class avnc
  extends nac
{
  avnc(avmf paramavmf) {}
  
  /* Error */
  public void a(int paramInt, byte[] paramArrayOfByte, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifne +510 -> 511
    //   4: new 19	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   7: dup
    //   8: invokespecial 20	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   11: astore_3
    //   12: aload_3
    //   13: aload_2
    //   14: checkcast 22	[B
    //   17: invokevirtual 26	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   20: checkcast 19	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull +42 -> 67
    //   28: aload_2
    //   29: getfield 30	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   32: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   35: istore_1
    //   36: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +28 -> 67
    //   42: ldc 44
    //   44: iconst_2
    //   45: new 46	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   52: ldc 49
    //   54: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload_1
    //   58: invokevirtual 56	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: new 66	tencent/im/oidb/cmd0x66b/Oidb_0x66b$RspBody
    //   70: dup
    //   71: invokespecial 67	tencent/im/oidb/cmd0x66b/Oidb_0x66b$RspBody:<init>	()V
    //   74: astore_3
    //   75: aload_3
    //   76: aload_2
    //   77: getfield 71	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   80: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   83: invokevirtual 82	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   86: invokevirtual 83	tencent/im/oidb/cmd0x66b/Oidb_0x66b$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   89: pop
    //   90: new 85	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   93: dup
    //   94: invokespecial 86	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   97: astore 4
    //   99: new 88	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard
    //   102: dup
    //   103: invokespecial 89	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:<init>	()V
    //   106: astore_2
    //   107: aload_3
    //   108: getfield 92	tencent/im/oidb/cmd0x66b/Oidb_0x66b$RspBody:bytes_rspbody_5eb	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   111: invokevirtual 95	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   114: ifeq +142 -> 256
    //   117: aload_3
    //   118: getfield 92	tencent/im/oidb/cmd0x66b/Oidb_0x66b$RspBody:bytes_rspbody_5eb	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 82	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   127: astore 5
    //   129: aload 4
    //   131: aload 5
    //   133: invokevirtual 96	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: pop
    //   137: aload 4
    //   139: getfield 100	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   142: invokevirtual 103	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   145: ifeq +111 -> 256
    //   148: aload 4
    //   150: getfield 100	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   153: invokevirtual 106	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   156: ifle +100 -> 256
    //   159: aload 4
    //   161: getfield 100	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   164: invokevirtual 109	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   167: iconst_0
    //   168: invokeinterface 114 2 0
    //   173: checkcast 116	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   176: astore 4
    //   178: aload_2
    //   179: aload 4
    //   181: getfield 120	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   184: invokevirtual 125	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   187: invokestatic 131	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   190: putfield 135	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:uin	Ljava/lang/Long;
    //   193: aload_2
    //   194: aload 4
    //   196: getfield 138	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:bytes_stranger_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   202: invokevirtual 141	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   205: putfield 145	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:nickName	Ljava/lang/String;
    //   208: aload_2
    //   209: aload 4
    //   211: getfield 148	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_profession	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   214: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   217: putfield 152	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:carrier	I
    //   220: aload_2
    //   221: aload 4
    //   223: getfield 155	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   226: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   229: putfield 158	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:gender	I
    //   232: aload_2
    //   233: aload 4
    //   235: getfield 161	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   238: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   241: putfield 164	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:age	I
    //   244: aload_2
    //   245: aload 4
    //   247: getfield 167	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_god_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   250: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   253: putfield 170	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:godFlag	I
    //   256: aload_3
    //   257: getfield 173	tencent/im/oidb/cmd0x66b/Oidb_0x66b$RspBody:bytes_rspbody_gift	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   260: invokevirtual 95	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   263: ifeq +89 -> 352
    //   266: aload_3
    //   267: getfield 173	tencent/im/oidb/cmd0x66b/Oidb_0x66b$RspBody:bytes_rspbody_gift	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   270: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   273: invokevirtual 82	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   276: astore 5
    //   278: new 175	tencent/sso/accretion/flower_info$SFlowerInfoRsp
    //   281: dup
    //   282: invokespecial 176	tencent/sso/accretion/flower_info$SFlowerInfoRsp:<init>	()V
    //   285: astore 4
    //   287: aload 4
    //   289: aload 5
    //   291: invokevirtual 177	tencent/sso/accretion/flower_info$SFlowerInfoRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   294: pop
    //   295: aload_2
    //   296: aload 4
    //   298: getfield 180	tencent/sso/accretion/flower_info$SFlowerInfoRsp:num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   301: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   304: putfield 183	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:giftNum	I
    //   307: aload_0
    //   308: getfield 10	avnc:a	Lavmf;
    //   311: aload 4
    //   313: getfield 187	tencent/sso/accretion/flower_info$SFlowerInfoRsp:rpt_flower_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   316: invokevirtual 190	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   319: putfield 195	avmf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   322: aload_0
    //   323: getfield 10	avnc:a	Lavmf;
    //   326: aload 4
    //   328: getfield 199	tencent/sso/accretion/flower_info$SFlowerInfoRsp:flower_msg_tips	Lcom/tencent/mobileqq/pb/PBStringField;
    //   331: invokevirtual 203	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   334: putfield 205	avmf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   337: aload_0
    //   338: getfield 10	avnc:a	Lavmf;
    //   341: aload 4
    //   343: getfield 208	tencent/sso/accretion/flower_info$SFlowerInfoRsp:flower_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   346: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   349: putfield 210	avmf:d	I
    //   352: aload_3
    //   353: getfield 213	tencent/im/oidb/cmd0x66b/Oidb_0x66b$RspBody:rpt_msg_vistor_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   356: invokevirtual 103	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   359: ifeq +251 -> 610
    //   362: aload_2
    //   363: getfield 216	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:visitors	Ljava/util/List;
    //   366: invokeinterface 219 1 0
    //   371: aload_3
    //   372: getfield 213	tencent/im/oidb/cmd0x66b/Oidb_0x66b$RspBody:rpt_msg_vistor_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   375: invokevirtual 109	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   378: invokeinterface 223 1 0
    //   383: astore_3
    //   384: aload_3
    //   385: invokeinterface 228 1 0
    //   390: ifeq +170 -> 560
    //   393: aload_3
    //   394: invokeinterface 232 1 0
    //   399: checkcast 234	appoint/define/appoint_define$PublisherInfo
    //   402: astore 4
    //   404: aload 4
    //   406: ifnull -22 -> 384
    //   409: aload 4
    //   411: invokestatic 240	com/tencent/mobileqq/data/StrangerInfo:convertFrom	(Lappoint/define/appoint_define$PublisherInfo;)Lcom/tencent/mobileqq/data/StrangerInfo;
    //   414: astore 4
    //   416: aload 4
    //   418: ifnull -34 -> 384
    //   421: aload_2
    //   422: getfield 216	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:visitors	Ljava/util/List;
    //   425: aload 4
    //   427: invokeinterface 244 2 0
    //   432: pop
    //   433: goto -49 -> 384
    //   436: astore_2
    //   437: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   440: ifeq +31 -> 471
    //   443: ldc 44
    //   445: iconst_2
    //   446: new 46	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   453: ldc 246
    //   455: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_2
    //   459: invokevirtual 247	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   462: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: aload_3
    //   472: astore_2
    //   473: goto -449 -> 24
    //   476: astore_2
    //   477: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +31 -> 511
    //   483: ldc 44
    //   485: iconst_2
    //   486: new 46	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   493: ldc 246
    //   495: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_2
    //   499: invokevirtual 247	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   502: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: return
    //   512: astore 4
    //   514: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq -261 -> 256
    //   520: ldc 249
    //   522: iconst_2
    //   523: ldc 251
    //   525: aload 4
    //   527: invokestatic 255	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   530: goto -274 -> 256
    //   533: astore 5
    //   535: aload_2
    //   536: iconst_0
    //   537: putfield 183	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:giftNum	I
    //   540: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq -248 -> 295
    //   546: ldc 249
    //   548: iconst_2
    //   549: ldc_w 257
    //   552: aload 5
    //   554: invokestatic 255	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   557: goto -262 -> 295
    //   560: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   563: ifeq +35 -> 598
    //   566: ldc 44
    //   568: iconst_2
    //   569: new 46	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   576: ldc_w 259
    //   579: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload_2
    //   583: getfield 216	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:visitors	Ljava/util/List;
    //   586: invokevirtual 262	java/lang/Object:toString	()Ljava/lang/String;
    //   589: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 265	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: aload_0
    //   599: getfield 10	avnc:a	Lavmf;
    //   602: aload_2
    //   603: getfield 216	com/tencent/mobileqq/nearpeople/mytab/NearbyMyTabCard:visitors	Ljava/util/List;
    //   606: invokestatic 268	avmf:a	(Lavmf;Ljava/util/List;)V
    //   609: return
    //   610: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   613: ifeq -15 -> 598
    //   616: ldc 44
    //   618: iconst_2
    //   619: ldc_w 270
    //   622: invokestatic 265	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   625: goto -27 -> 598
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	avnc
    //   0	628	1	paramInt	int
    //   0	628	2	paramArrayOfByte	byte[]
    //   0	628	3	paramBundle	android.os.Bundle
    //   97	329	4	localObject	java.lang.Object
    //   512	14	4	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   127	163	5	arrayOfByte	byte[]
    //   533	20	5	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   12	24	436	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   75	90	476	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   129	256	512	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   287	295	533	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avnc
 * JD-Core Version:    0.7.0.1
 */