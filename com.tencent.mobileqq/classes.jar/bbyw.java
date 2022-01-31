import com.tencent.open.agent.QuickLoginAuthorityActivity;
import mqq.observer.BusinessObserver;

public class bbyw
  implements BusinessObserver
{
  public bbyw(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 24
    //   2: iconst_1
    //   3: new 26	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   10: ldc 29
    //   12: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_2
    //   16: invokevirtual 36	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19: ldc 38
    //   21: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_3
    //   25: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 12	bbyw:a	Lcom/tencent/open/agent/QuickLoginAuthorityActivity;
    //   38: invokevirtual 57	com/tencent/open/agent/QuickLoginAuthorityActivity:isFinishing	()Z
    //   41: ifeq +12 -> 53
    //   44: ldc 24
    //   46: iconst_1
    //   47: ldc 59
    //   49: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: return
    //   53: aload_3
    //   54: ldc 61
    //   56: invokevirtual 67	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 7
    //   61: aload_0
    //   62: getfield 12	bbyw:a	Lcom/tencent/open/agent/QuickLoginAuthorityActivity;
    //   65: getfield 70	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   68: aload 7
    //   70: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifne +12 -> 85
    //   76: ldc 24
    //   78: iconst_1
    //   79: ldc 78
    //   81: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: return
    //   85: iload_2
    //   86: ifeq -34 -> 52
    //   89: new 80	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse
    //   92: dup
    //   93: invokespecial 81	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:<init>	()V
    //   96: astore 7
    //   98: aload_3
    //   99: ldc 83
    //   101: invokevirtual 87	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull -54 -> 52
    //   109: aload 7
    //   111: aload_3
    //   112: invokevirtual 91	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: pop
    //   116: aload 7
    //   118: invokevirtual 94	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:has	()Z
    //   121: ifeq -69 -> 52
    //   124: aload 7
    //   126: getfield 98	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 104	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   132: ifne -80 -> 52
    //   135: aload 7
    //   137: ifnull +80 -> 217
    //   140: aload 7
    //   142: getfield 108	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:appName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   145: ifnull +72 -> 217
    //   148: aload 7
    //   150: getfield 108	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:appName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   153: invokevirtual 112	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   156: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +58 -> 217
    //   162: aload 7
    //   164: getfield 108	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:appName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   167: invokevirtual 112	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   170: astore_3
    //   171: ldc 24
    //   173: iconst_1
    //   174: new 26	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   181: ldc 120
    //   183: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_3
    //   187: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: getfield 12	bbyw:a	Lcom/tencent/open/agent/QuickLoginAuthorityActivity;
    //   200: iconst_1
    //   201: invokestatic 123	com/tencent/open/agent/QuickLoginAuthorityActivity:a	(Lcom/tencent/open/agent/QuickLoginAuthorityActivity;Z)Z
    //   204: pop
    //   205: aload_0
    //   206: getfield 12	bbyw:a	Lcom/tencent/open/agent/QuickLoginAuthorityActivity;
    //   209: getfield 126	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   212: aload_3
    //   213: aconst_null
    //   214: invokevirtual 131	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   217: aload 7
    //   219: ifnull -167 -> 52
    //   222: aload 7
    //   224: getfield 135	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:iconsURL	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   227: ifnull -175 -> 52
    //   230: aload 7
    //   232: getfield 135	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:iconsURL	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   235: invokevirtual 138	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   238: ifeq -186 -> 52
    //   241: iconst_0
    //   242: istore_1
    //   243: iconst_0
    //   244: istore 4
    //   246: iconst_0
    //   247: istore 5
    //   249: iload_1
    //   250: aload 7
    //   252: getfield 135	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:iconsURL	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   255: invokevirtual 141	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   258: invokeinterface 146 1 0
    //   263: if_icmpge +171 -> 434
    //   266: aload 7
    //   268: getfield 135	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:iconsURL	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   271: iload_1
    //   272: invokevirtual 149	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   275: checkcast 151	com/tencent/protofile/getappinfo/GetAppInfoProto$MsgIconsurl
    //   278: astore_3
    //   279: aload_3
    //   280: getfield 153	com/tencent/protofile/getappinfo/GetAppInfoProto$MsgIconsurl:size	Lcom/tencent/mobileqq/pb/PBStringField;
    //   283: invokevirtual 112	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   286: invokestatic 159	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   289: istore 6
    //   291: iload 6
    //   293: bipush 100
    //   295: if_icmplt +115 -> 410
    //   298: aload 7
    //   300: getfield 135	com/tencent/protofile/getappinfo/GetAppInfoProto$GetAppinfoResponse:iconsURL	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   303: iload_1
    //   304: invokevirtual 149	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   307: checkcast 151	com/tencent/protofile/getappinfo/GetAppInfoProto$MsgIconsurl
    //   310: astore_3
    //   311: aload_3
    //   312: ifnull -260 -> 52
    //   315: aload_3
    //   316: getfield 162	com/tencent/protofile/getappinfo/GetAppInfoProto$MsgIconsurl:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   319: invokevirtual 112	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   322: astore_3
    //   323: ldc 24
    //   325: iconst_1
    //   326: new 26	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   333: ldc 164
    //   335: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_3
    //   339: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aload_3
    //   349: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifne -300 -> 52
    //   355: aload_0
    //   356: getfield 12	bbyw:a	Lcom/tencent/open/agent/QuickLoginAuthorityActivity;
    //   359: iconst_1
    //   360: invokestatic 167	com/tencent/open/agent/QuickLoginAuthorityActivity:b	(Lcom/tencent/open/agent/QuickLoginAuthorityActivity;Z)Z
    //   363: pop
    //   364: invokestatic 173	android/os/Message:obtain	()Landroid/os/Message;
    //   367: astore 7
    //   369: aload 7
    //   371: sipush 1001
    //   374: putfield 177	android/os/Message:what	I
    //   377: aload 7
    //   379: aload_3
    //   380: putfield 181	android/os/Message:obj	Ljava/lang/Object;
    //   383: aload_0
    //   384: getfield 12	bbyw:a	Lcom/tencent/open/agent/QuickLoginAuthorityActivity;
    //   387: getfield 184	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   390: aload 7
    //   392: invokevirtual 190	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   395: pop
    //   396: return
    //   397: astore_3
    //   398: aload_3
    //   399: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   402: return
    //   403: astore_3
    //   404: iconst_0
    //   405: istore 6
    //   407: goto -116 -> 291
    //   410: iload 6
    //   412: iload 5
    //   414: if_icmple +17 -> 431
    //   417: iload 6
    //   419: istore 5
    //   421: iload_1
    //   422: istore 4
    //   424: iload_1
    //   425: iconst_1
    //   426: iadd
    //   427: istore_1
    //   428: goto -179 -> 249
    //   431: goto -7 -> 424
    //   434: iload 4
    //   436: istore_1
    //   437: goto -139 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	bbyw
    //   0	440	1	paramInt	int
    //   0	440	2	paramBoolean	boolean
    //   0	440	3	paramBundle	android.os.Bundle
    //   244	191	4	i	int
    //   247	173	5	j	int
    //   289	129	6	k	int
    //   59	332	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   98	105	397	java/lang/Exception
    //   109	135	397	java/lang/Exception
    //   140	217	397	java/lang/Exception
    //   222	241	397	java/lang/Exception
    //   249	279	397	java/lang/Exception
    //   279	291	397	java/lang/Exception
    //   298	311	397	java/lang/Exception
    //   315	396	397	java/lang/Exception
    //   279	291	403	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbyw
 * JD-Core Version:    0.7.0.1
 */