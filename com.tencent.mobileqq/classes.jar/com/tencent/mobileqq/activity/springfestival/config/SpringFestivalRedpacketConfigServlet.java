package com.tencent.mobileqq.activity.springfestival.config;

import android.content.Intent;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.zip.InflaterInputStream;
import mqq.app.Packet;

public class SpringFestivalRedpacketConfigServlet
  extends ProtoServlet
{
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("k_req_occasion", 0);
      int j = paramIntent.getIntExtra("k_version", -1);
      int k = paramIntent.getIntExtra("k_peak_version", -1);
      QLog.e("shua2021_SpringFestivalRedpacketConfigServlet", 1, String.format("handleGetConfigFail reqOccasion=%s reqVersion=%s reqPeakVersion=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      ((SpringFestivalRedpacketConfigManager)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).a(false, false, j, k, 0, null, null, i, false, 0L);
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfigServlet", 1, "inflate fail.", paramArrayOfByte);
    }
    return null;
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 19
    //   3: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +41 -> 47
    //   9: new 111	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   16: astore 17
    //   18: aload 17
    //   20: ldc 114
    //   22: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 17
    //   28: aload_2
    //   29: invokevirtual 123	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   32: invokevirtual 126	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc 25
    //   38: iconst_2
    //   39: aload 17
    //   41: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload 19
    //   49: ldc 135
    //   51: iconst_m1
    //   52: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   55: istore 11
    //   57: aload 19
    //   59: ldc 137
    //   61: iconst_0
    //   62: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   65: istore 5
    //   67: aload 19
    //   69: ldc 21
    //   71: iconst_m1
    //   72: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   75: istore 7
    //   77: iload 7
    //   79: istore 6
    //   81: aload 19
    //   83: ldc 23
    //   85: iconst_m1
    //   86: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   89: pop
    //   90: aload 19
    //   92: ldc 139
    //   94: lconst_0
    //   95: invokevirtual 143	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   98: lstore 13
    //   100: aload_2
    //   101: invokevirtual 123	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   104: istore 15
    //   106: ldc 145
    //   108: astore 17
    //   110: iconst_1
    //   111: istore 4
    //   113: iload 15
    //   115: ifeq +1560 -> 1675
    //   118: aload_2
    //   119: invokevirtual 148	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   122: invokestatic 153	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   125: astore_2
    //   126: iload 11
    //   128: iconst_1
    //   129: if_icmpeq +21 -> 150
    //   132: iconst_0
    //   133: istore 7
    //   135: iconst_0
    //   136: istore 15
    //   138: iconst_1
    //   139: istore_3
    //   140: aload 17
    //   142: astore_2
    //   143: iload 5
    //   145: istore 8
    //   147: goto +1298 -> 1445
    //   150: aload_0
    //   151: invokevirtual 51	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   154: checkcast 53	com/tencent/mobileqq/app/QQAppInterface
    //   157: astore 18
    //   159: aload 18
    //   161: ifnonnull +4 -> 165
    //   164: return
    //   165: aload 18
    //   167: getstatic 59	com/tencent/mobileqq/app/QQManagerFactory:SPRING_FESTIVAL_RED_PACKET_MANAGER	I
    //   170: invokevirtual 63	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   173: checkcast 65	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigManager
    //   176: astore 20
    //   178: new 155	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage
    //   181: dup
    //   182: invokespecial 156	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:<init>	()V
    //   185: astore 21
    //   187: aload 21
    //   189: aload_2
    //   190: invokevirtual 160	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   193: pop
    //   194: aload 21
    //   196: getfield 164	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   199: invokevirtual 170	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   202: istore_3
    //   203: aload 21
    //   205: getfield 174	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   208: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   211: istore 4
    //   213: ldc 25
    //   215: iconst_1
    //   216: ldc 179
    //   218: iconst_2
    //   219: anewarray 29	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: iload_3
    //   225: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: iload 4
    //   233: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: invokestatic 41	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iload_3
    //   244: ifeq +92 -> 336
    //   247: new 111	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   254: astore_2
    //   255: aload_2
    //   256: iload_3
    //   257: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_2
    //   262: ldc 145
    //   264: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_2
    //   269: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: astore_2
    //   273: iconst_2
    //   274: iconst_2
    //   275: sipush 1011
    //   278: iload 5
    //   280: iload 6
    //   282: iconst_1
    //   283: iconst_1
    //   284: anewarray 37	java/lang/String
    //   287: dup
    //   288: iconst_0
    //   289: aload_2
    //   290: aastore
    //   291: invokestatic 190	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(IIIIIZ[Ljava/lang/String;)V
    //   294: goto +75 -> 369
    //   297: astore 19
    //   299: ldc 21
    //   301: astore 18
    //   303: aload 17
    //   305: astore_2
    //   306: aload 19
    //   308: astore 17
    //   310: iconst_1
    //   311: istore 15
    //   313: iconst_1
    //   314: istore_3
    //   315: iconst_1
    //   316: istore 4
    //   318: iconst_0
    //   319: istore 8
    //   321: iload 6
    //   323: istore 7
    //   325: iload 5
    //   327: istore 6
    //   329: iload 8
    //   331: istore 5
    //   333: goto +1214 -> 1547
    //   336: ldc 145
    //   338: astore_2
    //   339: iload 4
    //   341: sipush 1011
    //   344: if_icmpeq +65 -> 409
    //   347: iconst_2
    //   348: iconst_2
    //   349: sipush 1011
    //   352: iload 5
    //   354: iload 6
    //   356: iconst_1
    //   357: iconst_1
    //   358: anewarray 37	java/lang/String
    //   361: dup
    //   362: iconst_0
    //   363: ldc 192
    //   365: aastore
    //   366: invokestatic 190	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(IIIIIZ[Ljava/lang/String;)V
    //   369: iconst_1
    //   370: istore 15
    //   372: iconst_1
    //   373: istore 7
    //   375: iconst_1
    //   376: istore_3
    //   377: iconst_0
    //   378: istore 4
    //   380: ldc 145
    //   382: astore_2
    //   383: iload 5
    //   385: istore 8
    //   387: goto +1058 -> 1445
    //   390: astore 17
    //   392: ldc 145
    //   394: astore_2
    //   395: ldc 21
    //   397: astore 18
    //   399: goto -89 -> 310
    //   402: astore_1
    //   403: ldc 21
    //   405: astore_1
    //   406: goto -96 -> 310
    //   409: aload 19
    //   411: ldc 13
    //   413: iconst_0
    //   414: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   417: istore 7
    //   419: aload 19
    //   421: ldc 21
    //   423: iconst_m1
    //   424: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   427: istore 10
    //   429: aload 19
    //   431: ldc 23
    //   433: iconst_m1
    //   434: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   437: istore 8
    //   439: aload 19
    //   441: ldc 194
    //   443: iconst_0
    //   444: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   447: istore 12
    //   449: aload 21
    //   451: getfield 198	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   454: invokevirtual 203	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   457: checkcast 200	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   460: getfield 206	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   463: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   466: istore_3
    //   467: aload 21
    //   469: getfield 198	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   472: invokevirtual 203	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   475: checkcast 200	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   478: getfield 209	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   481: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   484: istore 4
    //   486: aload 21
    //   488: getfield 212	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:stagger_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   491: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   494: istore 9
    //   496: ldc 21
    //   498: astore 18
    //   500: ldc 25
    //   502: iconst_1
    //   503: ldc 214
    //   505: bipush 8
    //   507: anewarray 29	java/lang/Object
    //   510: dup
    //   511: iconst_0
    //   512: iload 7
    //   514: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: aastore
    //   518: dup
    //   519: iconst_1
    //   520: iload 10
    //   522: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: aastore
    //   526: dup
    //   527: iconst_2
    //   528: iload 8
    //   530: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: aastore
    //   534: dup
    //   535: iconst_3
    //   536: iload 12
    //   538: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   541: aastore
    //   542: dup
    //   543: iconst_4
    //   544: iload_3
    //   545: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   548: aastore
    //   549: dup
    //   550: iconst_5
    //   551: iload 9
    //   553: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   556: aastore
    //   557: dup
    //   558: bipush 6
    //   560: iload 4
    //   562: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: aastore
    //   566: dup
    //   567: bipush 7
    //   569: lload 13
    //   571: invokestatic 219	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   574: aastore
    //   575: invokestatic 41	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   578: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: iload 12
    //   583: ifne +161 -> 744
    //   586: iload 10
    //   588: iload_3
    //   589: if_icmpne +155 -> 744
    //   592: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq +11 -> 606
    //   598: ldc 25
    //   600: iconst_2
    //   601: ldc 221
    //   603: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: iload 8
    //   608: iload 9
    //   610: if_icmpeq +9 -> 619
    //   613: iconst_1
    //   614: istore 15
    //   616: goto +6 -> 622
    //   619: iconst_0
    //   620: istore 15
    //   622: aload 21
    //   624: getfield 225	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:delay_time	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   627: invokevirtual 230	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   630: ifeq +1284 -> 1914
    //   633: aload 21
    //   635: getfield 225	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:delay_time	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   638: invokevirtual 233	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   641: checkcast 235	java/util/ArrayList
    //   644: astore 17
    //   646: goto +3 -> 649
    //   649: aload 20
    //   651: iconst_0
    //   652: iload 15
    //   654: iload_3
    //   655: iload 9
    //   657: iload 4
    //   659: aconst_null
    //   660: aload 17
    //   662: iload 7
    //   664: iconst_1
    //   665: lload 13
    //   667: invokevirtual 68	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigManager:a	(ZZIIILjava/lang/String;Ljava/util/List;IZJ)Z
    //   670: ifne +19 -> 689
    //   673: iconst_2
    //   674: iconst_4
    //   675: sipush 1011
    //   678: iload 4
    //   680: iload_3
    //   681: iconst_1
    //   682: iconst_0
    //   683: anewarray 37	java/lang/String
    //   686: invokestatic 190	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(IIIIIZ[Ljava/lang/String;)V
    //   689: iconst_0
    //   690: istore 5
    //   692: iconst_0
    //   693: istore 15
    //   695: iconst_1
    //   696: istore 6
    //   698: goto +722 -> 1420
    //   701: astore 17
    //   703: iconst_0
    //   704: istore 5
    //   706: goto +8 -> 714
    //   709: astore 17
    //   711: iconst_1
    //   712: istore 5
    //   714: iconst_0
    //   715: istore 9
    //   717: iconst_0
    //   718: istore 15
    //   720: iconst_1
    //   721: istore 8
    //   723: iload 4
    //   725: istore 6
    //   727: iload_3
    //   728: istore 7
    //   730: iload 9
    //   732: istore_3
    //   733: iload 5
    //   735: istore 4
    //   737: iload 8
    //   739: istore 5
    //   741: goto -408 -> 333
    //   744: iload 12
    //   746: ifne +9 -> 755
    //   749: iload 10
    //   751: iload_3
    //   752: if_icmpne +14 -> 766
    //   755: iload 12
    //   757: ifeq +654 -> 1411
    //   760: iload 10
    //   762: iload_3
    //   763: if_icmpne +648 -> 1411
    //   766: aload 21
    //   768: getfield 198	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:page_info	Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo;
    //   771: invokevirtual 203	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   774: checkcast 200	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo
    //   777: astore 22
    //   779: aload 19
    //   781: ldc 237
    //   783: invokevirtual 241	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   786: astore 17
    //   788: aload 21
    //   790: getfield 245	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   793: invokevirtual 250	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   796: invokevirtual 253	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   799: astore 19
    //   801: aload 17
    //   803: ifnull +11 -> 814
    //   806: aload 17
    //   808: arraylength
    //   809: istore 5
    //   811: goto +6 -> 817
    //   814: iconst_0
    //   815: istore 5
    //   817: aload 19
    //   819: arraylength
    //   820: istore 6
    //   822: new 255	org/apache/http/util/ByteArrayBuffer
    //   825: dup
    //   826: iload 5
    //   828: iload 6
    //   830: iadd
    //   831: invokespecial 258	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
    //   834: astore 23
    //   836: aload 17
    //   838: ifnull +57 -> 895
    //   841: aload 17
    //   843: arraylength
    //   844: istore 5
    //   846: aload 23
    //   848: aload 17
    //   850: iconst_0
    //   851: iload 5
    //   853: invokevirtual 260	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   856: goto +39 -> 895
    //   859: astore 17
    //   861: goto +5 -> 866
    //   864: astore 17
    //   866: iconst_0
    //   867: istore 5
    //   869: iload 4
    //   871: istore 6
    //   873: iload_3
    //   874: istore 7
    //   876: iconst_0
    //   877: istore 15
    //   879: iconst_1
    //   880: istore 4
    //   882: iconst_1
    //   883: istore 8
    //   885: iload 5
    //   887: istore_3
    //   888: iload 8
    //   890: istore 5
    //   892: goto -559 -> 333
    //   895: aload 23
    //   897: aload 19
    //   899: iconst_0
    //   900: aload 19
    //   902: arraylength
    //   903: invokevirtual 260	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   906: aload 23
    //   908: invokevirtual 263	org/apache/http/util/ByteArrayBuffer:buffer	()[B
    //   911: astore 17
    //   913: aload 22
    //   915: getfield 266	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:next_offset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   918: invokevirtual 170	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   921: istore 5
    //   923: iload 5
    //   925: iconst_m1
    //   926: if_icmpne +360 -> 1286
    //   929: ldc 25
    //   931: iconst_1
    //   932: ldc_w 268
    //   935: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   938: aload 22
    //   940: getfield 272	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   943: invokevirtual 276	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   946: astore 19
    //   948: aload 17
    //   950: invokestatic 281	com/tencent/mobileqq/portal/PortalUtils:a	([B)Ljava/lang/String;
    //   953: astore 23
    //   955: aload 22
    //   957: getfield 284	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:total_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   960: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   963: istore 5
    //   965: aload 17
    //   967: ifnull +284 -> 1251
    //   970: aload 17
    //   972: arraylength
    //   973: ifeq +278 -> 1251
    //   976: iload 5
    //   978: ifne +6 -> 984
    //   981: goto +270 -> 1251
    //   984: iload 5
    //   986: ifle +231 -> 1217
    //   989: aload 23
    //   991: aload 19
    //   993: invokestatic 290	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   996: ifeq +221 -> 1217
    //   999: ldc 25
    //   1001: iconst_1
    //   1002: ldc_w 292
    //   1005: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1008: aload 22
    //   1010: getfield 295	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1013: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1016: istore 5
    //   1018: iload 5
    //   1020: iconst_1
    //   1021: if_icmpne +899 -> 1920
    //   1024: aload_0
    //   1025: aload 17
    //   1027: invokespecial 297	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigServlet:a	([B)[B
    //   1030: astore 17
    //   1032: goto +3 -> 1035
    //   1035: aload 17
    //   1037: ifnull +152 -> 1189
    //   1040: aload 21
    //   1042: getfield 225	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:delay_time	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1045: invokevirtual 230	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   1048: ifeq +875 -> 1923
    //   1051: aload 21
    //   1053: getfield 225	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfigByPage:delay_time	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1056: invokevirtual 233	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   1059: checkcast 235	java/util/ArrayList
    //   1062: astore 19
    //   1064: goto +3 -> 1067
    //   1067: new 37	java/lang/String
    //   1070: dup
    //   1071: aload 17
    //   1073: ldc_w 299
    //   1076: invokespecial 302	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1079: astore_2
    //   1080: iload 8
    //   1082: iload 9
    //   1084: if_icmpeq +9 -> 1093
    //   1087: iconst_1
    //   1088: istore 15
    //   1090: goto +6 -> 1096
    //   1093: iconst_0
    //   1094: istore 15
    //   1096: aload 20
    //   1098: iconst_1
    //   1099: iload 15
    //   1101: iload_3
    //   1102: iload 9
    //   1104: iload 4
    //   1106: aload_2
    //   1107: aload 19
    //   1109: iload 7
    //   1111: iconst_1
    //   1112: lload 13
    //   1114: invokevirtual 68	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigManager:a	(ZZIIILjava/lang/String;Ljava/util/List;IZJ)Z
    //   1117: istore 15
    //   1119: iload 15
    //   1121: ifne +33 -> 1154
    //   1124: iconst_2
    //   1125: iconst_4
    //   1126: sipush 1011
    //   1129: iload 4
    //   1131: iload_3
    //   1132: iconst_1
    //   1133: iconst_0
    //   1134: anewarray 37	java/lang/String
    //   1137: invokestatic 190	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(IIIIIZ[Ljava/lang/String;)V
    //   1140: iconst_0
    //   1141: istore 6
    //   1143: goto +14 -> 1157
    //   1146: astore 17
    //   1148: iconst_0
    //   1149: istore 5
    //   1151: goto +20 -> 1171
    //   1154: iconst_1
    //   1155: istore 6
    //   1157: iconst_1
    //   1158: istore 5
    //   1160: iconst_0
    //   1161: istore 15
    //   1163: goto +257 -> 1420
    //   1166: astore 17
    //   1168: iconst_1
    //   1169: istore 5
    //   1171: iload_3
    //   1172: istore 7
    //   1174: iload 4
    //   1176: istore 6
    //   1178: iconst_1
    //   1179: istore 4
    //   1181: iconst_0
    //   1182: istore_3
    //   1183: iconst_0
    //   1184: istore 15
    //   1186: goto +361 -> 1547
    //   1189: ldc 25
    //   1191: iconst_1
    //   1192: ldc_w 304
    //   1195: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1198: iconst_2
    //   1199: iconst_3
    //   1200: sipush 1011
    //   1203: iload 4
    //   1205: iload_3
    //   1206: iconst_1
    //   1207: iconst_0
    //   1208: anewarray 37	java/lang/String
    //   1211: invokestatic 190	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(IIIIIZ[Ljava/lang/String;)V
    //   1214: goto +158 -> 1372
    //   1217: ldc 25
    //   1219: iconst_1
    //   1220: ldc_w 306
    //   1223: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1226: iconst_2
    //   1227: iconst_2
    //   1228: sipush 1011
    //   1231: iload 4
    //   1233: iload_3
    //   1234: iconst_1
    //   1235: iconst_1
    //   1236: anewarray 37	java/lang/String
    //   1239: dup
    //   1240: iconst_0
    //   1241: ldc_w 308
    //   1244: aastore
    //   1245: invokestatic 190	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(IIIIIZ[Ljava/lang/String;)V
    //   1248: goto +124 -> 1372
    //   1251: ldc 25
    //   1253: iconst_1
    //   1254: ldc_w 310
    //   1257: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1260: aload 20
    //   1262: iconst_1
    //   1263: iconst_1
    //   1264: iload_3
    //   1265: iload 9
    //   1267: iload 4
    //   1269: aconst_null
    //   1270: aconst_null
    //   1271: iload 7
    //   1273: iconst_1
    //   1274: lload 13
    //   1276: invokevirtual 68	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigManager:a	(ZZIIILjava/lang/String;Ljava/util/List;IZJ)Z
    //   1279: pop
    //   1280: iconst_0
    //   1281: istore 5
    //   1283: goto +131 -> 1414
    //   1286: iload 5
    //   1288: ifeq +53 -> 1341
    //   1291: ldc 25
    //   1293: iconst_1
    //   1294: ldc_w 312
    //   1297: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1300: aload 20
    //   1302: iload 7
    //   1304: iload_3
    //   1305: iload 8
    //   1307: iload 5
    //   1309: aload 22
    //   1311: getfield 209	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1314: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1317: aload 22
    //   1319: getfield 315	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$PageRespInfo:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1322: invokevirtual 250	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1325: invokevirtual 253	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1328: aload 17
    //   1330: lload 13
    //   1332: iconst_0
    //   1333: invokevirtual 318	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigManager:a	(IIIII[B[BJZ)V
    //   1336: return
    //   1337: astore_2
    //   1338: goto +133 -> 1471
    //   1341: ldc 25
    //   1343: iconst_1
    //   1344: ldc_w 320
    //   1347: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1350: iconst_2
    //   1351: iconst_2
    //   1352: sipush 1011
    //   1355: iload 4
    //   1357: iload_3
    //   1358: iconst_1
    //   1359: iconst_1
    //   1360: anewarray 37	java/lang/String
    //   1363: dup
    //   1364: iconst_0
    //   1365: ldc_w 322
    //   1368: aastore
    //   1369: invokestatic 190	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(IIIIIZ[Ljava/lang/String;)V
    //   1372: iconst_1
    //   1373: istore 5
    //   1375: iconst_1
    //   1376: istore 15
    //   1378: iconst_0
    //   1379: istore 6
    //   1381: goto +39 -> 1420
    //   1384: astore 17
    //   1386: iload 4
    //   1388: istore 6
    //   1390: iload_3
    //   1391: istore 7
    //   1393: iconst_1
    //   1394: istore 15
    //   1396: iconst_0
    //   1397: istore_3
    //   1398: iconst_1
    //   1399: istore 4
    //   1401: iconst_0
    //   1402: istore 5
    //   1404: goto +143 -> 1547
    //   1407: astore_2
    //   1408: goto +63 -> 1471
    //   1411: iconst_1
    //   1412: istore 5
    //   1414: iconst_0
    //   1415: istore 15
    //   1417: iconst_1
    //   1418: istore 6
    //   1420: iload 6
    //   1422: istore 7
    //   1424: iload_3
    //   1425: istore 6
    //   1427: iload 5
    //   1429: istore_3
    //   1430: iconst_0
    //   1431: istore 5
    //   1433: iload 4
    //   1435: istore 8
    //   1437: iload 7
    //   1439: istore 4
    //   1441: iload 5
    //   1443: istore 7
    //   1445: iload 7
    //   1447: istore 9
    //   1449: iload_3
    //   1450: istore 7
    //   1452: iload 4
    //   1454: istore 5
    //   1456: iload 8
    //   1458: istore 10
    //   1460: iload 6
    //   1462: istore 8
    //   1464: goto +201 -> 1665
    //   1467: astore_2
    //   1468: goto +3 -> 1471
    //   1471: iload 4
    //   1473: istore 5
    //   1475: iload_3
    //   1476: istore 6
    //   1478: goto +12 -> 1490
    //   1481: astore_2
    //   1482: goto +8 -> 1490
    //   1485: astore_2
    //   1486: goto +4 -> 1490
    //   1489: astore_2
    //   1490: ldc 145
    //   1492: astore 18
    //   1494: aload_2
    //   1495: astore 17
    //   1497: aload 18
    //   1499: astore_2
    //   1500: goto +20 -> 1520
    //   1503: astore 18
    //   1505: goto +3 -> 1508
    //   1508: goto +5 -> 1513
    //   1511: astore 18
    //   1513: aload 17
    //   1515: astore_2
    //   1516: aload 18
    //   1518: astore 17
    //   1520: ldc 21
    //   1522: astore 18
    //   1524: iconst_0
    //   1525: istore 15
    //   1527: iconst_0
    //   1528: istore_3
    //   1529: iconst_1
    //   1530: istore 4
    //   1532: iconst_1
    //   1533: istore 8
    //   1535: iload 6
    //   1537: istore 7
    //   1539: iload 5
    //   1541: istore 6
    //   1543: iload 8
    //   1545: istore 5
    //   1547: sipush 303
    //   1550: aload 17
    //   1552: iconst_1
    //   1553: anewarray 37	java/lang/String
    //   1556: dup
    //   1557: iconst_0
    //   1558: aload 17
    //   1560: invokestatic 328	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1563: aastore
    //   1564: invokestatic 331	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   1567: new 111	java/lang/StringBuilder
    //   1570: dup
    //   1571: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1574: astore 19
    //   1576: aload 19
    //   1578: ldc_w 333
    //   1581: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: pop
    //   1585: aload 19
    //   1587: aload 17
    //   1589: invokevirtual 336	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1592: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: pop
    //   1596: ldc 25
    //   1598: iconst_1
    //   1599: aload 19
    //   1601: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1604: aload 17
    //   1606: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1609: aload_1
    //   1610: astore 19
    //   1612: iconst_2
    //   1613: bipush 6
    //   1615: sipush 1011
    //   1618: aload 19
    //   1620: ldc 137
    //   1622: iconst_0
    //   1623: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1626: aload 19
    //   1628: aload 18
    //   1630: iconst_0
    //   1631: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1634: iconst_1
    //   1635: iconst_1
    //   1636: anewarray 37	java/lang/String
    //   1639: dup
    //   1640: iconst_0
    //   1641: aload 17
    //   1643: invokestatic 337	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1646: aastore
    //   1647: invokestatic 190	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(IIIIIZ[Ljava/lang/String;)V
    //   1650: iload 7
    //   1652: istore 8
    //   1654: iload 6
    //   1656: istore 10
    //   1658: iload 4
    //   1660: istore 7
    //   1662: iload_3
    //   1663: istore 9
    //   1665: iload 9
    //   1667: istore_3
    //   1668: iload 7
    //   1670: istore 4
    //   1672: goto +46 -> 1718
    //   1675: iload 11
    //   1677: iconst_1
    //   1678: if_icmpne +14 -> 1692
    //   1681: iconst_1
    //   1682: istore 15
    //   1684: iconst_1
    //   1685: istore_3
    //   1686: iconst_0
    //   1687: istore 4
    //   1689: goto +11 -> 1700
    //   1692: iconst_0
    //   1693: istore 15
    //   1695: iconst_0
    //   1696: istore_3
    //   1697: iconst_1
    //   1698: istore 4
    //   1700: ldc 145
    //   1702: astore_2
    //   1703: iconst_1
    //   1704: istore 6
    //   1706: iload 7
    //   1708: istore 8
    //   1710: iload 5
    //   1712: istore 10
    //   1714: iload 6
    //   1716: istore 5
    //   1718: aload_1
    //   1719: astore 17
    //   1721: iload 11
    //   1723: iconst_1
    //   1724: if_icmpne +35 -> 1759
    //   1727: iload 4
    //   1729: ifeq +30 -> 1759
    //   1732: aload_0
    //   1733: invokevirtual 51	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1736: checkcast 53	com/tencent/mobileqq/app/QQAppInterface
    //   1739: iconst_1
    //   1740: iload 5
    //   1742: iconst_1
    //   1743: ixor
    //   1744: sipush 1011
    //   1747: iload 10
    //   1749: iload 8
    //   1751: iconst_1
    //   1752: aload_2
    //   1753: invokestatic 343	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   1756: invokestatic 346	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(Lcom/tencent/common/app/AppInterface;IIIIIZLjava/lang/String;)V
    //   1759: iload_3
    //   1760: ifne +8 -> 1768
    //   1763: iload 15
    //   1765: ifeq +148 -> 1913
    //   1768: iload_3
    //   1769: ifeq +160 -> 1929
    //   1772: aload 17
    //   1774: ldc_w 348
    //   1777: iconst_0
    //   1778: invokevirtual 19	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1781: istore_3
    //   1782: iload_3
    //   1783: iconst_1
    //   1784: if_icmpge +145 -> 1929
    //   1787: aload 17
    //   1789: ldc_w 348
    //   1792: iload_3
    //   1793: iconst_1
    //   1794: iadd
    //   1795: invokevirtual 352	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1798: pop
    //   1799: aload_0
    //   1800: invokevirtual 51	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1803: aload 17
    //   1805: checkcast 354	mqq/app/NewIntent
    //   1808: invokevirtual 360	mqq/app/AppRuntime:startServlet	(Lmqq/app/NewIntent;)V
    //   1811: iconst_1
    //   1812: istore 16
    //   1814: goto +3 -> 1817
    //   1817: ldc 25
    //   1819: iconst_1
    //   1820: ldc_w 362
    //   1823: iconst_2
    //   1824: anewarray 29	java/lang/Object
    //   1827: dup
    //   1828: iconst_0
    //   1829: iload 16
    //   1831: invokestatic 367	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1834: aastore
    //   1835: dup
    //   1836: iconst_1
    //   1837: iload 15
    //   1839: invokestatic 367	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1842: aastore
    //   1843: invokestatic 41	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1846: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1849: iload 16
    //   1851: ifne +62 -> 1913
    //   1854: iload 15
    //   1856: ifeq +57 -> 1913
    //   1859: aload_0
    //   1860: aload_1
    //   1861: invokespecial 369	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfigServlet:a	(Landroid/content/Intent;)V
    //   1864: return
    //   1865: astore_1
    //   1866: sipush 304
    //   1869: aload_1
    //   1870: iconst_0
    //   1871: anewarray 37	java/lang/String
    //   1874: invokestatic 331	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   1877: new 111	java/lang/StringBuilder
    //   1880: dup
    //   1881: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1884: astore_2
    //   1885: aload_2
    //   1886: ldc_w 371
    //   1889: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1892: pop
    //   1893: aload_2
    //   1894: aload_1
    //   1895: invokevirtual 372	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1898: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: pop
    //   1902: ldc 25
    //   1904: iconst_1
    //   1905: aload_2
    //   1906: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1909: aload_1
    //   1910: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1913: return
    //   1914: aconst_null
    //   1915: astore 17
    //   1917: goto -1268 -> 649
    //   1920: goto -885 -> 1035
    //   1923: aconst_null
    //   1924: astore 19
    //   1926: goto -859 -> 1067
    //   1929: iconst_0
    //   1930: istore 16
    //   1932: goto -115 -> 1817
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1935	0	this	SpringFestivalRedpacketConfigServlet
    //   0	1935	1	paramIntent	Intent
    //   0	1935	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   139	238	3	i	int
    //   111	268	4	j	int
    //   65	319	5	k	int
    //   79	276	6	m	int
    //   75	299	7	n	int
    //   145	241	8	i1	int
    //   55	75	11	i2	int
    //   98	1	13	l	long
    //   104	267	15	bool	boolean
    //   16	293	17	localObject1	Object
    //   390	1	17	localThrowable1	Throwable
    //   157	241	18	localObject2	Object
    //   1	90	19	localIntent	Intent
    //   297	10	19	localThrowable2	Throwable
    //   176	1	20	localSpringFestivalRedpacketConfigManager	SpringFestivalRedpacketConfigManager
    //   185	19	21	localRespGetConfigByPage	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfigByPage
    // Exception table:
    //   from	to	target	type
    //   247	273	297	java/lang/Throwable
    //   273	294	390	java/lang/Throwable
    //   347	369	390	java/lang/Throwable
    //   622	646	701	java/lang/Throwable
    //   649	689	701	java/lang/Throwable
    //   592	606	709	java/lang/Throwable
    //   806	811	709	java/lang/Throwable
    //   846	856	859	java/lang/Throwable
    //   841	846	864	java/lang/Throwable
    //   1124	1140	1146	java/lang/Throwable
    //   1096	1119	1166	java/lang/Throwable
    //   1024	1032	1337	java/lang/Throwable
    //   1040	1064	1337	java/lang/Throwable
    //   1067	1080	1337	java/lang/Throwable
    //   1251	1280	1337	java/lang/Throwable
    //   1291	1336	1337	java/lang/Throwable
    //   1189	1214	1384	java/lang/Throwable
    //   1217	1248	1384	java/lang/Throwable
    //   1341	1372	1384	java/lang/Throwable
    //   822	836	1407	java/lang/Throwable
    //   895	923	1407	java/lang/Throwable
    //   929	965	1407	java/lang/Throwable
    //   970	976	1407	java/lang/Throwable
    //   989	1018	1407	java/lang/Throwable
    //   500	581	1467	java/lang/Throwable
    //   766	801	1467	java/lang/Throwable
    //   817	822	1467	java/lang/Throwable
    //   486	496	1481	java/lang/Throwable
    //   467	486	1485	java/lang/Throwable
    //   409	467	1489	java/lang/Throwable
    //   213	243	1503	java/lang/Throwable
    //   118	126	1511	java/lang/Throwable
    //   150	159	1511	java/lang/Throwable
    //   165	213	1511	java/lang/Throwable
    //   1772	1782	1865	java/lang/Exception
    //   1787	1811	1865	java/lang/Exception
    //   1817	1849	1865	java/lang/Exception
    //   1859	1864	1865	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("k_cmd", -1);
    int j = paramIntent.getIntExtra("k_retry", 0);
    boolean bool = paramIntent.getBooleanExtra("k_new_page", false);
    QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, String.format("onSend cmd=%s retry=%s newPage=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) }));
    Object localObject3;
    Object localObject4;
    if ((j != 0) && (!bool))
    {
      localObject3 = paramIntent.getStringExtra("k_sso_id");
      localObject4 = paramIntent.getByteArrayExtra("k_sso_data");
      paramIntent.putExtra("k_new_page", false);
    }
    else
    {
      Object localObject2 = null;
      Object localObject1;
      if (i != 1)
      {
        localObject1 = null;
      }
      else
      {
        i = paramIntent.getIntExtra("k_id", 0);
        j = paramIntent.getIntExtra("k_offset", 0);
        int k = paramIntent.getIntExtra("k_version", 0);
        int m = paramIntent.getIntExtra("k_peak_version", 0);
        long l = paramIntent.getLongExtra("key_req_adcode", 0L);
        localObject2 = paramIntent.getByteArrayExtra("k_cookie");
        QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, String.format("onSend CMD_GET_CONFIG taskId=%s offset=%s version=%s peakVersion=%s cookie=%s adCode=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Arrays.toString((byte[])localObject2), Long.valueOf(l) }));
        localObject1 = new ConfigurationService.PageReqInfo();
        ((ConfigurationService.PageReqInfo)localObject1).task_id.set(i);
        ((ConfigurationService.PageReqInfo)localObject1).offset.set(j);
        ((ConfigurationService.PageReqInfo)localObject1).version.set(k);
        if (localObject2 != null) {
          ((ConfigurationService.PageReqInfo)localObject1).cookies.set(ByteStringMicro.copyFrom((byte[])localObject2));
        }
        localObject3 = new ConfigurationService.Screen();
        ((ConfigurationService.Screen)localObject3).setHasFlag(true);
        ((ConfigurationService.Screen)localObject3).model.set("");
        ((ConfigurationService.Screen)localObject3).width.set((int)DeviceInfoUtil.g());
        ((ConfigurationService.Screen)localObject3).height.set((int)DeviceInfoUtil.h());
        ((ConfigurationService.Screen)localObject3).dpi.set(DeviceInfoUtil.e());
        ((ConfigurationService.Screen)localObject3).multi_touch.set(DeviceInfoUtil.c());
        localObject2 = new ConfigurationService.DeviceInfo();
        ((ConfigurationService.DeviceInfo)localObject2).setHasFlag(true);
        ((ConfigurationService.DeviceInfo)localObject2).screen = ((ConfigurationService.Screen)localObject3);
        localObject3 = new ConfigurationService.ReqGetConfigByPage();
        ((ConfigurationService.ReqGetConfigByPage)localObject3).page_info.set((MessageMicro)localObject1);
        ((ConfigurationService.ReqGetConfigByPage)localObject3).device_info.set((MessageMicro)localObject2);
        ((ConfigurationService.ReqGetConfigByPage)localObject3).type.set(1011);
        ((ConfigurationService.ReqGetConfigByPage)localObject3).adcode.set(l);
        ((ConfigurationService.ReqGetConfigByPage)localObject3).stagger_version.set(m);
        localObject2 = WupUtil.a(((ConfigurationService.ReqGetConfigByPage)localObject3).toByteArray());
        localObject1 = "ConfigurationService.ReqGetConfigByPage";
      }
      localObject3 = localObject1;
      localObject4 = localObject2;
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (!bool)
        {
          paramIntent.putExtra("k_sso_id", (String)localObject1);
          paramIntent.putExtra("k_sso_data", (byte[])localObject2);
          localObject4 = localObject2;
          localObject3 = localObject1;
        }
      }
    }
    if ((localObject3 != null) && (localObject4 != null))
    {
      paramPacket.setSSOCommand((String)localObject3);
      paramPacket.putSendData((byte[])localObject4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigServlet
 * JD-Core Version:    0.7.0.1
 */