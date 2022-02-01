class awqf
  implements awrb
{
  awqf(awqd paramawqd) {}
  
  /* Error */
  public void a(int paramInt, byte[] paramArrayOfByte, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 27
    //   8: iconst_2
    //   9: new 29	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   16: ldc 32
    //   18: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_1
    //   22: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 47	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: iload_1
    //   32: ifne +359 -> 391
    //   35: aload_2
    //   36: ifnull +355 -> 391
    //   39: new 49	tencent/im/oidb/cmd0xada/oidb_0xada$RspBody
    //   42: dup
    //   43: invokespecial 50	tencent/im/oidb/cmd0xada/oidb_0xada$RspBody:<init>	()V
    //   46: astore_3
    //   47: aload_3
    //   48: aload_2
    //   49: invokevirtual 54	tencent/im/oidb/cmd0xada/oidb_0xada$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   52: pop
    //   53: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +34 -> 90
    //   59: ldc 27
    //   61: iconst_2
    //   62: new 29	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   69: ldc 56
    //   71: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_3
    //   75: getfield 60	tencent/im/oidb/cmd0xada/oidb_0xada$RspBody:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   78: invokevirtual 65	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   81: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 47	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_3
    //   91: getfield 69	tencent/im/oidb/cmd0xada/oidb_0xada$RspBody:busi_buf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   94: invokevirtual 74	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   97: ifeq +281 -> 378
    //   100: new 76	com/tencent/pb/now/FeedsProtocol$GetMediaDetailRsp
    //   103: dup
    //   104: invokespecial 77	com/tencent/pb/now/FeedsProtocol$GetMediaDetailRsp:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: aload_3
    //   110: getfield 69	tencent/im/oidb/cmd0xada/oidb_0xada$RspBody:busi_buf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 80	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: invokevirtual 86	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   119: invokevirtual 87	com/tencent/pb/now/FeedsProtocol$GetMediaDetailRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   122: pop
    //   123: aload_0
    //   124: getfield 12	awqf:a	Lawqd;
    //   127: astore_3
    //   128: aload_2
    //   129: getfield 91	com/tencent/pb/now/FeedsProtocol$GetMediaDetailRsp:is_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 96	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: ifeq +299 -> 434
    //   138: iconst_1
    //   139: istore 5
    //   141: aload_3
    //   142: iload 5
    //   144: putfield 101	awqd:jdField_a_of_type_Boolean	Z
    //   147: aload_0
    //   148: getfield 12	awqf:a	Lawqd;
    //   151: aload_2
    //   152: getfield 104	com/tencent/pb/now/FeedsProtocol$GetMediaDetailRsp:total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   155: invokevirtual 96	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   158: putfield 107	awqd:jdField_a_of_type_Int	I
    //   161: aload_0
    //   162: getfield 12	awqf:a	Lawqd;
    //   165: aload_2
    //   166: invokestatic 110	awqd:a	(Lawqd;Lcom/tencent/pb/now/FeedsProtocol$GetMediaDetailRsp;)V
    //   169: aload_0
    //   170: getfield 12	awqf:a	Lawqd;
    //   173: invokestatic 113	awqd:a	(Lawqd;)Ljava/lang/String;
    //   176: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne +105 -> 284
    //   182: iconst_0
    //   183: istore_1
    //   184: iload_1
    //   185: aload_0
    //   186: getfield 12	awqf:a	Lawqd;
    //   189: getfield 122	awqd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   192: invokevirtual 127	java/util/ArrayList:size	()I
    //   195: if_icmpge +231 -> 426
    //   198: aload_0
    //   199: getfield 12	awqf:a	Lawqd;
    //   202: invokestatic 113	awqd:a	(Lawqd;)Ljava/lang/String;
    //   205: aload_0
    //   206: getfield 12	awqf:a	Lawqd;
    //   209: getfield 122	awqd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   212: iload_1
    //   213: invokevirtual 130	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   216: checkcast 132	com/tencent/mobileqq/nearby/now/model/VideoData
    //   219: getfield 135	com/tencent/mobileqq/nearby/now/model/VideoData:a	Ljava/lang/String;
    //   222: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   225: ifeq +215 -> 440
    //   228: aload_0
    //   229: getfield 12	awqf:a	Lawqd;
    //   232: getfield 144	awqd:jdField_a_of_type_Awpz	Lawpz;
    //   235: aload_0
    //   236: getfield 12	awqf:a	Lawqd;
    //   239: getfield 122	awqd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   242: iload_1
    //   243: invokevirtual 130	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   246: checkcast 132	com/tencent/mobileqq/nearby/now/model/VideoData
    //   249: invokeinterface 149 2 0
    //   254: goto +174 -> 428
    //   257: iload 4
    //   259: iload_1
    //   260: if_icmpgt +24 -> 284
    //   263: aload_0
    //   264: getfield 12	awqf:a	Lawqd;
    //   267: getfield 122	awqd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   270: iconst_0
    //   271: invokevirtual 152	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   274: pop
    //   275: iload 4
    //   277: iconst_1
    //   278: iadd
    //   279: istore 4
    //   281: goto -24 -> 257
    //   284: aload_0
    //   285: getfield 12	awqf:a	Lawqd;
    //   288: getfield 144	awqd:jdField_a_of_type_Awpz	Lawpz;
    //   291: astore_3
    //   292: aload_2
    //   293: getfield 155	com/tencent/pb/now/FeedsProtocol$GetMediaDetailRsp:err_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   296: invokevirtual 156	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   299: ifeq +20 -> 319
    //   302: aload_2
    //   303: getfield 155	com/tencent/pb/now/FeedsProtocol$GetMediaDetailRsp:err_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   306: invokevirtual 96	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   309: istore_1
    //   310: aload_3
    //   311: iconst_1
    //   312: iload_1
    //   313: invokeinterface 159 3 0
    //   318: return
    //   319: iconst_0
    //   320: istore_1
    //   321: goto -11 -> 310
    //   324: astore_2
    //   325: ldc 27
    //   327: iconst_1
    //   328: aload_2
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   336: aload_0
    //   337: getfield 12	awqf:a	Lawqd;
    //   340: getfield 144	awqd:jdField_a_of_type_Awpz	Lawpz;
    //   343: invokeinterface 165 1 0
    //   348: return
    //   349: astore_2
    //   350: aload_2
    //   351: invokevirtual 168	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   354: ldc 27
    //   356: iconst_1
    //   357: aload_2
    //   358: iconst_0
    //   359: anewarray 4	java/lang/Object
    //   362: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   365: aload_0
    //   366: getfield 12	awqf:a	Lawqd;
    //   369: getfield 144	awqd:jdField_a_of_type_Awpz	Lawpz;
    //   372: invokeinterface 165 1 0
    //   377: return
    //   378: aload_0
    //   379: getfield 12	awqf:a	Lawqd;
    //   382: getfield 144	awqd:jdField_a_of_type_Awpz	Lawpz;
    //   385: invokeinterface 165 1 0
    //   390: return
    //   391: ldc 27
    //   393: iconst_1
    //   394: new 29	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   401: ldc 170
    //   403: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: iload_1
    //   407: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: ldc 172
    //   412: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_2
    //   416: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 47	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: return
    //   426: iconst_m1
    //   427: istore_1
    //   428: iconst_0
    //   429: istore 4
    //   431: goto -174 -> 257
    //   434: iconst_0
    //   435: istore 5
    //   437: goto -296 -> 141
    //   440: iload_1
    //   441: iconst_1
    //   442: iadd
    //   443: istore_1
    //   444: goto -260 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	awqf
    //   0	447	1	paramInt	int
    //   0	447	2	paramArrayOfByte	byte[]
    //   0	447	3	paramBundle	android.os.Bundle
    //   257	173	4	i	int
    //   139	297	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   108	138	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   141	182	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   184	254	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   263	275	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   284	310	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   310	318	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   47	90	349	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   90	108	349	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   325	348	349	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   378	390	349	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqf
 * JD-Core Version:    0.7.0.1
 */