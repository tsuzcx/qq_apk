package com.tencent.mobileqq.activity;

import com.tencent.biz.ProtoUtils.TroopProtocolObserver;

class LoginInfoActivity$18
  extends ProtoUtils.TroopProtocolObserver
{
  LoginInfoActivity$18(LoginInfoActivity paramLoginInfoActivity) {}
  
  /* Error */
  public void onResult(int paramInt, byte[] paramArrayOfByte, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iload_1
    //   4: ifne +15 -> 19
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: goto +8 -> 19
    //   14: iconst_1
    //   15: istore_1
    //   16: goto +55 -> 71
    //   19: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +47 -> 69
    //   25: new 28	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_3
    //   34: ldc 31
    //   36: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: iload_1
    //   42: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: ldc 40
    //   49: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: aload_2
    //   55: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 45
    //   61: iconst_2
    //   62: aload_3
    //   63: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iconst_0
    //   70: istore_1
    //   71: iload_1
    //   72: istore 4
    //   74: iload_1
    //   75: ifeq +623 -> 698
    //   78: new 55	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse
    //   81: dup
    //   82: invokespecial 56	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:<init>	()V
    //   85: astore 8
    //   87: aload 8
    //   89: aload_2
    //   90: invokevirtual 60	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: pop
    //   94: aload 8
    //   96: getfield 64	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:uint32_sec_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   99: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   102: ifeq +841 -> 943
    //   105: aload 8
    //   107: getfield 64	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:uint32_sec_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: istore 4
    //   115: goto +3 -> 118
    //   118: iload 4
    //   120: iconst_1
    //   121: if_icmpne +444 -> 565
    //   124: aload 8
    //   126: getfield 77	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:str_no_risk_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   129: invokevirtual 80	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   132: ifeq +28 -> 160
    //   135: aload 8
    //   137: getfield 77	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:str_no_risk_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   140: invokevirtual 82	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   143: astore_2
    //   144: aload_2
    //   145: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +12 -> 160
    //   151: aload_0
    //   152: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   155: aload_2
    //   156: invokestatic 94	com/tencent/mobileqq/activity/LoginInfoActivity:access$3402	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   159: pop
    //   160: aload 8
    //   162: getfield 97	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:str_risk_tip_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   165: invokevirtual 80	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   168: ifeq +58 -> 226
    //   171: aload 8
    //   173: getfield 97	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:str_risk_tip_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   176: invokevirtual 82	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   179: astore_2
    //   180: aload_2
    //   181: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: ifne +42 -> 226
    //   187: aload_0
    //   188: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   191: astore_3
    //   192: new 28	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   199: astore 9
    //   201: aload 9
    //   203: aload_2
    //   204: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 9
    //   210: ldc 99
    //   212: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_3
    //   217: aload 9
    //   219: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 102	com/tencent/mobileqq/activity/LoginInfoActivity:access$3502	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   225: pop
    //   226: aload 8
    //   228: getfield 106	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:risk_info_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   231: invokevirtual 109	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   234: ifeq +301 -> 535
    //   237: aload 8
    //   239: getfield 106	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:risk_info_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   242: invokevirtual 111	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   245: ifne +290 -> 535
    //   248: iconst_0
    //   249: istore 4
    //   251: iload 4
    //   253: aload 8
    //   255: getfield 106	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:risk_info_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   258: invokevirtual 114	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   261: if_icmpge +274 -> 535
    //   264: new 116	com/tencent/ims/QQProtectRisks$RiskInfo
    //   267: dup
    //   268: invokespecial 117	com/tencent/ims/QQProtectRisks$RiskInfo:<init>	()V
    //   271: pop
    //   272: aload 8
    //   274: getfield 106	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:risk_info_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   277: iload 4
    //   279: invokevirtual 120	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   282: checkcast 116	com/tencent/ims/QQProtectRisks$RiskInfo
    //   285: astore_2
    //   286: aload_2
    //   287: getfield 123	com/tencent/ims/QQProtectRisks$RiskInfo:uint32_item_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   290: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   293: ifeq +17 -> 310
    //   296: aload_2
    //   297: getfield 123	com/tencent/ims/QQProtectRisks$RiskInfo:uint32_item_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   300: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   303: iconst_1
    //   304: if_icmpne +6 -> 310
    //   307: goto +642 -> 949
    //   310: new 125	com/tencent/mobileqq/activity/RiskInfoItem
    //   313: dup
    //   314: invokespecial 126	com/tencent/mobileqq/activity/RiskInfoItem:<init>	()V
    //   317: astore_3
    //   318: aload_3
    //   319: aload_2
    //   320: getfield 129	com/tencent/ims/QQProtectRisks$RiskInfo:str_left_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   323: invokevirtual 82	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   326: putfield 132	com/tencent/mobileqq/activity/RiskInfoItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   329: aload_3
    //   330: aload_2
    //   331: getfield 135	com/tencent/ims/QQProtectRisks$RiskInfo:str_jump_target	Lcom/tencent/mobileqq/pb/PBStringField;
    //   334: invokevirtual 82	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   337: putfield 138	com/tencent/mobileqq/activity/RiskInfoItem:d	Ljava/lang/String;
    //   340: aload_3
    //   341: getfield 132	com/tencent/mobileqq/activity/RiskInfoItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   347: ifne +602 -> 949
    //   350: aload_3
    //   351: getfield 138	com/tencent/mobileqq/activity/RiskInfoItem:d	Ljava/lang/String;
    //   354: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifeq +6 -> 363
    //   360: goto +589 -> 949
    //   363: aload_3
    //   364: aload_2
    //   365: getfield 141	com/tencent/ims/QQProtectRisks$RiskInfo:str_right_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   368: invokevirtual 82	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   371: putfield 144	com/tencent/mobileqq/activity/RiskInfoItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   374: aload_3
    //   375: aload_2
    //   376: getfield 147	com/tencent/ims/QQProtectRisks$RiskInfo:str_desc_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   379: invokevirtual 82	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   382: putfield 150	com/tencent/mobileqq/activity/RiskInfoItem:c	Ljava/lang/String;
    //   385: aload_3
    //   386: aload_2
    //   387: getfield 153	com/tencent/ims/QQProtectRisks$RiskInfo:uint32_click_report_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   390: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   393: putfield 156	com/tencent/mobileqq/activity/RiskInfoItem:jdField_a_of_type_Int	I
    //   396: aload_2
    //   397: getfield 159	com/tencent/ims/QQProtectRisks$RiskInfo:uint32_item_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   400: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   403: ifeq +14 -> 417
    //   406: aload_3
    //   407: aload_2
    //   408: getfield 159	com/tencent/ims/QQProtectRisks$RiskInfo:uint32_item_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   411: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   414: putfield 161	com/tencent/mobileqq/activity/RiskInfoItem:jdField_b_of_type_Int	I
    //   417: aload_2
    //   418: getfield 164	com/tencent/ims/QQProtectRisks$RiskInfo:str_right_text_open	Lcom/tencent/mobileqq/pb/PBStringField;
    //   421: invokevirtual 80	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   424: ifeq +14 -> 438
    //   427: aload_3
    //   428: aload_2
    //   429: getfield 164	com/tencent/ims/QQProtectRisks$RiskInfo:str_right_text_open	Lcom/tencent/mobileqq/pb/PBStringField;
    //   432: invokevirtual 82	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   435: putfield 167	com/tencent/mobileqq/activity/RiskInfoItem:e	Ljava/lang/String;
    //   438: aload_0
    //   439: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   442: invokestatic 171	com/tencent/mobileqq/activity/LoginInfoActivity:access$3200	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Z
    //   445: ifne +15 -> 460
    //   448: aload_0
    //   449: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   452: invokestatic 175	com/tencent/mobileqq/activity/LoginInfoActivity:access$3600	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Ljava/util/ArrayList;
    //   455: aload_3
    //   456: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   459: pop
    //   460: ldc 45
    //   462: iconst_1
    //   463: ldc 183
    //   465: bipush 7
    //   467: anewarray 185	java/lang/Object
    //   470: dup
    //   471: iconst_0
    //   472: aload_3
    //   473: getfield 132	com/tencent/mobileqq/activity/RiskInfoItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: aastore
    //   477: dup
    //   478: iconst_1
    //   479: aload_3
    //   480: getfield 144	com/tencent/mobileqq/activity/RiskInfoItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   483: aastore
    //   484: dup
    //   485: iconst_2
    //   486: aload_3
    //   487: getfield 150	com/tencent/mobileqq/activity/RiskInfoItem:c	Ljava/lang/String;
    //   490: aastore
    //   491: dup
    //   492: iconst_3
    //   493: aload_3
    //   494: getfield 138	com/tencent/mobileqq/activity/RiskInfoItem:d	Ljava/lang/String;
    //   497: aastore
    //   498: dup
    //   499: iconst_4
    //   500: aload_3
    //   501: getfield 156	com/tencent/mobileqq/activity/RiskInfoItem:jdField_a_of_type_Int	I
    //   504: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: aastore
    //   508: dup
    //   509: iconst_5
    //   510: aload_3
    //   511: getfield 161	com/tencent/mobileqq/activity/RiskInfoItem:jdField_b_of_type_Int	I
    //   514: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: aastore
    //   518: dup
    //   519: bipush 6
    //   521: aload_3
    //   522: getfield 167	com/tencent/mobileqq/activity/RiskInfoItem:e	Ljava/lang/String;
    //   525: aastore
    //   526: invokestatic 197	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   529: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: goto +417 -> 949
    //   535: aload 8
    //   537: getfield 202	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:uint32_qpim_switches	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   540: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   543: ifeq +22 -> 565
    //   546: aload 8
    //   548: getfield 202	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:uint32_qpim_switches	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   551: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   554: istore 4
    //   556: aload_0
    //   557: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   560: iload 4
    //   562: invokestatic 206	com/tencent/mobileqq/activity/LoginInfoActivity:access$3700	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;I)V
    //   565: ldc2_w 207
    //   568: lstore 6
    //   570: ldc 210
    //   572: astore_2
    //   573: aload 8
    //   575: getfield 213	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:uint32_cache_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   578: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   581: ifeq +14 -> 595
    //   584: aload 8
    //   586: getfield 213	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:uint32_cache_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   589: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   592: i2l
    //   593: lstore 6
    //   595: aload 8
    //   597: getfield 216	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:str_risk_exist	Lcom/tencent/mobileqq/pb/PBStringField;
    //   600: invokevirtual 80	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   603: ifeq +12 -> 615
    //   606: aload 8
    //   608: getfield 216	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:str_risk_exist	Lcom/tencent/mobileqq/pb/PBStringField;
    //   611: invokevirtual 82	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   614: astore_2
    //   615: aload_2
    //   616: astore_3
    //   617: aload_2
    //   618: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   621: ifeq +39 -> 660
    //   624: aload_2
    //   625: astore_3
    //   626: aload 8
    //   628: getfield 106	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:risk_info_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   631: invokevirtual 109	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   634: ifeq +26 -> 660
    //   637: aload_2
    //   638: astore_3
    //   639: aload 8
    //   641: getfield 106	com/tencent/ims/QQProtectRisks$QQProtectRisksResponse:risk_info_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   644: invokevirtual 111	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   647: ifne +13 -> 660
    //   650: aload_0
    //   651: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   654: ldc 217
    //   656: invokevirtual 221	com/tencent/mobileqq/activity/LoginInfoActivity:getString	(I)Ljava/lang/String;
    //   659: astore_3
    //   660: aload_0
    //   661: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   664: lload 6
    //   666: aload_3
    //   667: invokestatic 225	com/tencent/mobileqq/activity/LoginInfoActivity:access$3800	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;JLjava/lang/String;)V
    //   670: iload_1
    //   671: istore 4
    //   673: goto +25 -> 698
    //   676: astore_2
    //   677: aload_2
    //   678: invokevirtual 228	java/lang/Throwable:printStackTrace	()V
    //   681: iload_1
    //   682: istore 4
    //   684: goto +14 -> 698
    //   687: ldc 45
    //   689: iconst_1
    //   690: ldc 230
    //   692: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   695: iconst_0
    //   696: istore 4
    //   698: aload_0
    //   699: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   702: invokestatic 175	com/tencent/mobileqq/activity/LoginInfoActivity:access$3600	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Ljava/util/ArrayList;
    //   705: ifnull +106 -> 811
    //   708: aload_0
    //   709: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   712: invokestatic 175	com/tencent/mobileqq/activity/LoginInfoActivity:access$3600	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Ljava/util/ArrayList;
    //   715: invokevirtual 231	java/util/ArrayList:isEmpty	()Z
    //   718: ifne +93 -> 811
    //   721: aload_0
    //   722: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   725: invokestatic 235	com/tencent/mobileqq/activity/LoginInfoActivity:access$3500	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Ljava/lang/String;
    //   728: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   731: ifeq +69 -> 800
    //   734: aload_0
    //   735: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   738: invokestatic 175	com/tencent/mobileqq/activity/LoginInfoActivity:access$3600	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Ljava/util/ArrayList;
    //   741: iconst_0
    //   742: invokevirtual 238	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   745: checkcast 125	com/tencent/mobileqq/activity/RiskInfoItem
    //   748: getfield 132	com/tencent/mobileqq/activity/RiskInfoItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   751: astore_2
    //   752: aload_0
    //   753: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   756: invokestatic 175	com/tencent/mobileqq/activity/LoginInfoActivity:access$3600	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Ljava/util/ArrayList;
    //   759: invokevirtual 239	java/util/ArrayList:size	()I
    //   762: istore_1
    //   763: aload_0
    //   764: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   767: ldc 240
    //   769: invokevirtual 221	com/tencent/mobileqq/activity/LoginInfoActivity:getString	(I)Ljava/lang/String;
    //   772: astore_3
    //   773: aload_0
    //   774: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   777: aload_3
    //   778: iconst_2
    //   779: anewarray 185	java/lang/Object
    //   782: dup
    //   783: iconst_0
    //   784: aload_2
    //   785: aastore
    //   786: dup
    //   787: iconst_1
    //   788: iload_1
    //   789: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   792: aastore
    //   793: invokestatic 197	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   796: invokestatic 102	com/tencent/mobileqq/activity/LoginInfoActivity:access$3502	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   799: pop
    //   800: aload_0
    //   801: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   804: invokestatic 235	com/tencent/mobileqq/activity/LoginInfoActivity:access$3500	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Ljava/lang/String;
    //   807: astore_2
    //   808: goto +43 -> 851
    //   811: aload_0
    //   812: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   815: invokestatic 243	com/tencent/mobileqq/activity/LoginInfoActivity:access$3400	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Ljava/lang/String;
    //   818: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   821: ifeq +19 -> 840
    //   824: aload_0
    //   825: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   828: astore_2
    //   829: aload_2
    //   830: aload_2
    //   831: ldc 244
    //   833: invokevirtual 221	com/tencent/mobileqq/activity/LoginInfoActivity:getString	(I)Ljava/lang/String;
    //   836: invokestatic 94	com/tencent/mobileqq/activity/LoginInfoActivity:access$3402	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   839: pop
    //   840: aload_0
    //   841: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   844: invokestatic 243	com/tencent/mobileqq/activity/LoginInfoActivity:access$3400	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Ljava/lang/String;
    //   847: astore_2
    //   848: iconst_1
    //   849: istore 5
    //   851: iload 4
    //   853: ifne +13 -> 866
    //   856: aload_0
    //   857: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   860: ldc 245
    //   862: invokevirtual 221	com/tencent/mobileqq/activity/LoginInfoActivity:getString	(I)Ljava/lang/String;
    //   865: astore_2
    //   866: aload_0
    //   867: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   870: iload 5
    //   872: invokestatic 249	com/tencent/mobileqq/activity/LoginInfoActivity:access$3902	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;Z)Z
    //   875: pop
    //   876: aload_0
    //   877: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   880: invokestatic 253	com/tencent/mobileqq/activity/LoginInfoActivity:access$1700	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Lmqq/os/MqqHandler;
    //   883: ldc 254
    //   885: invokevirtual 260	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   888: astore_3
    //   889: new 262	android/os/Bundle
    //   892: dup
    //   893: invokespecial 263	android/os/Bundle:<init>	()V
    //   896: astore 8
    //   898: aload 8
    //   900: ldc_w 265
    //   903: iload 5
    //   905: invokevirtual 269	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   908: aload 8
    //   910: ldc_w 271
    //   913: aload_2
    //   914: invokevirtual 275	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   917: aload_3
    //   918: aload 8
    //   920: invokevirtual 281	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   923: aload_0
    //   924: getfield 10	com/tencent/mobileqq/activity/LoginInfoActivity$18:a	Lcom/tencent/mobileqq/activity/LoginInfoActivity;
    //   927: invokestatic 253	com/tencent/mobileqq/activity/LoginInfoActivity:access$1700	(Lcom/tencent/mobileqq/activity/LoginInfoActivity;)Lmqq/os/MqqHandler;
    //   930: aload_3
    //   931: ldc2_w 282
    //   934: invokevirtual 287	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   937: pop
    //   938: return
    //   939: astore_2
    //   940: goto -253 -> 687
    //   943: iconst_0
    //   944: istore 4
    //   946: goto -828 -> 118
    //   949: iload 4
    //   951: iconst_1
    //   952: iadd
    //   953: istore 4
    //   955: goto -704 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	958	0	this	18
    //   0	958	1	paramInt	int
    //   0	958	2	paramArrayOfByte	byte[]
    //   0	958	3	paramBundle	android.os.Bundle
    //   72	882	4	i	int
    //   1	903	5	bool	boolean
    //   568	97	6	l	long
    //   85	834	8	localObject	java.lang.Object
    //   199	19	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   78	115	676	java/lang/Throwable
    //   124	160	676	java/lang/Throwable
    //   160	226	676	java/lang/Throwable
    //   226	248	676	java/lang/Throwable
    //   251	307	676	java/lang/Throwable
    //   310	360	676	java/lang/Throwable
    //   363	417	676	java/lang/Throwable
    //   417	438	676	java/lang/Throwable
    //   438	460	676	java/lang/Throwable
    //   460	532	676	java/lang/Throwable
    //   535	565	676	java/lang/Throwable
    //   573	595	676	java/lang/Throwable
    //   595	615	676	java/lang/Throwable
    //   617	624	676	java/lang/Throwable
    //   626	637	676	java/lang/Throwable
    //   639	660	676	java/lang/Throwable
    //   660	670	676	java/lang/Throwable
    //   78	115	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   124	160	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   160	226	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   226	248	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   251	307	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   310	360	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   363	417	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   417	438	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   438	460	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   460	532	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   535	565	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   573	595	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   595	615	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   617	624	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   626	637	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   639	660	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   660	670	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.18
 * JD-Core Version:    0.7.0.1
 */