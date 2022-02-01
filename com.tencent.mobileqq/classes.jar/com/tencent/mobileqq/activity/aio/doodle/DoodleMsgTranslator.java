package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msg.aio_doodle.DoodleMsgProto.DoodleData;
import msg.aio_doodle.DoodleMsgProto.DoodleHeader;
import msg.aio_doodle.DoodleMsgProto.LineData;

public class DoodleMsgTranslator
{
  public static float a(Context paramContext, float paramFloat)
  {
    return paramFloat / paramContext.getResources().getDisplayMetrics().density;
  }
  
  private static int a(DoodleMsgProto.DoodleData paramDoodleData)
  {
    if (paramDoodleData == null) {
      return -1;
    }
    if (paramDoodleData.uint_line_id.has()) {
      return paramDoodleData.uint_line_id.get();
    }
    return -1;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 3)];
    int j = paramArrayOfByte[(paramInt + 2)];
    int k = paramArrayOfByte[(paramInt + 1)];
    return paramArrayOfByte[paramInt] << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l = l << 8 | paramArrayOfByte[(i + paramInt)] & 0xFF;
      i += 1;
    }
    return l;
  }
  
  /* Error */
  public static DoodleItem a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 64	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 6
    //   15: iload 5
    //   17: ifeq +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: new 66	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 9
    //   32: aload 9
    //   34: invokevirtual 72	java/io/File:exists	()Z
    //   37: ifne +46 -> 83
    //   40: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +38 -> 81
    //   46: new 79	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   53: astore 6
    //   55: aload 6
    //   57: ldc 82
    //   59: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 6
    //   65: aload_0
    //   66: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: ldc 88
    //   72: iconst_2
    //   73: aload 6
    //   75: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aconst_null
    //   82: areturn
    //   83: aload 6
    //   85: astore_0
    //   86: new 98	java/io/BufferedInputStream
    //   89: dup
    //   90: new 100	java/io/FileInputStream
    //   93: dup
    //   94: aload 9
    //   96: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   99: invokespecial 106	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   102: astore 6
    //   104: iconst_4
    //   105: newarray byte
    //   107: astore 8
    //   109: aload 6
    //   111: aload 8
    //   113: invokevirtual 112	java/io/InputStream:read	([B)I
    //   116: istore_3
    //   117: iload_3
    //   118: iconst_4
    //   119: if_icmpge +95 -> 214
    //   122: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +34 -> 159
    //   128: new 79	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   135: astore_0
    //   136: aload_0
    //   137: ldc 114
    //   139: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_0
    //   144: iload_3
    //   145: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: ldc 88
    //   151: iconst_2
    //   152: aload_0
    //   153: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 6
    //   161: invokevirtual 120	java/io/InputStream:close	()V
    //   164: aconst_null
    //   165: areturn
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   171: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +38 -> 212
    //   177: new 79	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   184: astore 6
    //   186: aload 6
    //   188: ldc 125
    //   190: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 6
    //   196: aload_0
    //   197: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc 88
    //   203: iconst_2
    //   204: aload 6
    //   206: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aconst_null
    //   213: areturn
    //   214: aload 8
    //   216: iconst_0
    //   217: invokestatic 130	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	([BI)I
    //   220: istore_3
    //   221: iload_3
    //   222: ifle +590 -> 812
    //   225: iload_3
    //   226: sipush 20000
    //   229: if_icmplt +6 -> 235
    //   232: goto +580 -> 812
    //   235: iload_3
    //   236: newarray byte
    //   238: astore_0
    //   239: aload 6
    //   241: aload_0
    //   242: iconst_0
    //   243: iload_3
    //   244: invokevirtual 133	java/io/InputStream:read	([BII)I
    //   247: istore 4
    //   249: iload 4
    //   251: iload_3
    //   252: if_icmpge +109 -> 361
    //   255: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +48 -> 306
    //   261: new 79	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   268: astore_0
    //   269: aload_0
    //   270: ldc 135
    //   272: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_0
    //   277: iload 4
    //   279: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_0
    //   284: ldc 137
    //   286: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_0
    //   291: iload_3
    //   292: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: ldc 88
    //   298: iconst_2
    //   299: aload_0
    //   300: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 6
    //   308: invokevirtual 120	java/io/InputStream:close	()V
    //   311: aconst_null
    //   312: areturn
    //   313: astore_0
    //   314: aload_0
    //   315: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   318: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +38 -> 359
    //   324: new 79	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   331: astore 6
    //   333: aload 6
    //   335: ldc 125
    //   337: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 6
    //   343: aload_0
    //   344: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: ldc 88
    //   350: iconst_2
    //   351: aload 6
    //   353: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aconst_null
    //   360: areturn
    //   361: new 139	msg/aio_doodle/DoodleMsgProto$DoodleHeader
    //   364: dup
    //   365: invokespecial 140	msg/aio_doodle/DoodleMsgProto$DoodleHeader:<init>	()V
    //   368: astore 7
    //   370: aload 7
    //   372: aload_0
    //   373: checkcast 142	[B
    //   376: invokevirtual 146	msg/aio_doodle/DoodleMsgProto$DoodleHeader:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   379: pop
    //   380: new 148	com/tencent/mobileqq/activity/aio/doodle/DoodleItem
    //   383: dup
    //   384: invokespecial 149	com/tencent/mobileqq/activity/aio/doodle/DoodleItem:<init>	()V
    //   387: astore_0
    //   388: aload_0
    //   389: aload 7
    //   391: invokestatic 152	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(Lcom/tencent/mobileqq/activity/aio/doodle/DoodleItem;Lmsg/aio_doodle/DoodleMsgProto$DoodleHeader;)V
    //   394: aconst_null
    //   395: astore 7
    //   397: iconst_m1
    //   398: istore_3
    //   399: aload 6
    //   401: aload 8
    //   403: invokevirtual 112	java/io/InputStream:read	([B)I
    //   406: istore 4
    //   408: iconst_1
    //   409: istore 5
    //   411: iload 4
    //   413: iconst_4
    //   414: if_icmpne +293 -> 707
    //   417: aload 8
    //   419: iconst_0
    //   420: invokestatic 130	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	([BI)I
    //   423: istore 4
    //   425: iload 4
    //   427: ifle +238 -> 665
    //   430: iload 4
    //   432: sipush 20000
    //   435: if_icmplt +6 -> 441
    //   438: goto +227 -> 665
    //   441: iload 4
    //   443: newarray byte
    //   445: astore 10
    //   447: aload 6
    //   449: aload 10
    //   451: iconst_0
    //   452: iload 4
    //   454: invokevirtual 133	java/io/InputStream:read	([BII)I
    //   457: iload 4
    //   459: if_icmpeq +48 -> 507
    //   462: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq +242 -> 707
    //   468: new 79	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   475: astore 8
    //   477: aload 8
    //   479: ldc 154
    //   481: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 8
    //   487: iload 4
    //   489: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: ldc 88
    //   495: iconst_2
    //   496: aload 8
    //   498: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: goto +203 -> 707
    //   507: new 32	msg/aio_doodle/DoodleMsgProto$DoodleData
    //   510: dup
    //   511: invokespecial 155	msg/aio_doodle/DoodleMsgProto$DoodleData:<init>	()V
    //   514: astore 9
    //   516: aload 9
    //   518: aload 10
    //   520: checkcast 142	[B
    //   523: invokevirtual 156	msg/aio_doodle/DoodleMsgProto$DoodleData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   526: pop
    //   527: aload 9
    //   529: invokestatic 158	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(Lmsg/aio_doodle/DoodleMsgProto$DoodleData;)I
    //   532: istore 4
    //   534: new 79	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   541: astore 10
    //   543: aload 10
    //   545: ldc 160
    //   547: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 10
    //   553: iload 4
    //   555: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: ldc 88
    //   561: iconst_2
    //   562: aload 10
    //   564: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: iload 4
    //   572: iconst_m1
    //   573: if_icmpne +753 -> 1326
    //   576: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   579: ifeq +128 -> 707
    //   582: new 79	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   589: astore 8
    //   591: aload 8
    //   593: ldc 162
    //   595: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 8
    //   601: iload 4
    //   603: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: ldc 88
    //   609: iconst_2
    //   610: aload 8
    //   612: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: goto +89 -> 707
    //   621: aload 7
    //   623: ifnull +11 -> 634
    //   626: aload_0
    //   627: aload 7
    //   629: iconst_1
    //   630: iconst_0
    //   631: invokevirtual 165	com/tencent/mobileqq/activity/aio/doodle/DoodleItem:a	(Lcom/tencent/mobileqq/activity/aio/doodle/PathData;ZZ)V
    //   634: new 167	com/tencent/mobileqq/activity/aio/doodle/PathData
    //   637: dup
    //   638: invokespecial 168	com/tencent/mobileqq/activity/aio/doodle/PathData:<init>	()V
    //   641: astore 7
    //   643: aload 7
    //   645: iload 4
    //   647: putfield 171	com/tencent/mobileqq/activity/aio/doodle/PathData:a	I
    //   650: iload 4
    //   652: istore_3
    //   653: aload 7
    //   655: aload 9
    //   657: iload 5
    //   659: invokestatic 174	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(Lcom/tencent/mobileqq/activity/aio/doodle/PathData;Lmsg/aio_doodle/DoodleMsgProto$DoodleData;Z)V
    //   662: goto -263 -> 399
    //   665: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq +39 -> 707
    //   671: new 79	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   678: astore 8
    //   680: aload 8
    //   682: ldc 176
    //   684: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 8
    //   690: iload 4
    //   692: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: ldc 88
    //   698: iconst_2
    //   699: aload 8
    //   701: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: aload 7
    //   709: ifnull +11 -> 720
    //   712: aload_0
    //   713: aload 7
    //   715: iconst_1
    //   716: iconst_0
    //   717: invokevirtual 165	com/tencent/mobileqq/activity/aio/doodle/DoodleItem:a	(Lcom/tencent/mobileqq/activity/aio/doodle/PathData;ZZ)V
    //   720: aload 6
    //   722: invokevirtual 120	java/io/InputStream:close	()V
    //   725: ldc 88
    //   727: iconst_2
    //   728: ldc 178
    //   730: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: aload 6
    //   735: invokevirtual 120	java/io/InputStream:close	()V
    //   738: aload_0
    //   739: astore 7
    //   741: goto +451 -> 1192
    //   744: astore 8
    //   746: aload 8
    //   748: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   751: aload_0
    //   752: astore 7
    //   754: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   757: ifeq +435 -> 1192
    //   760: new 79	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   767: astore 7
    //   769: aload 7
    //   771: ldc 125
    //   773: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: pop
    //   777: aload 7
    //   779: aload 8
    //   781: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: ldc 88
    //   787: iconst_2
    //   788: aload 7
    //   790: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   796: aload_0
    //   797: astore 7
    //   799: goto +393 -> 1192
    //   802: astore 7
    //   804: goto +102 -> 906
    //   807: astore 7
    //   809: goto +111 -> 920
    //   812: new 79	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   819: astore_0
    //   820: aload_0
    //   821: ldc 180
    //   823: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload_0
    //   828: iload_3
    //   829: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: ldc 88
    //   835: iconst_2
    //   836: aload_0
    //   837: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   843: aload 6
    //   845: invokevirtual 120	java/io/InputStream:close	()V
    //   848: aconst_null
    //   849: areturn
    //   850: astore_0
    //   851: aload_0
    //   852: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   855: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   858: ifeq +38 -> 896
    //   861: new 79	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   868: astore 6
    //   870: aload 6
    //   872: ldc 125
    //   874: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 6
    //   880: aload_0
    //   881: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   884: pop
    //   885: ldc 88
    //   887: iconst_2
    //   888: aload 6
    //   890: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   893: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   896: aconst_null
    //   897: areturn
    //   898: astore_0
    //   899: goto +348 -> 1247
    //   902: astore 7
    //   904: aconst_null
    //   905: astore_0
    //   906: aload 6
    //   908: astore 8
    //   910: aload_0
    //   911: astore 6
    //   913: goto +37 -> 950
    //   916: astore 7
    //   918: aconst_null
    //   919: astore_0
    //   920: aload 6
    //   922: astore 8
    //   924: aload_0
    //   925: astore 6
    //   927: goto +152 -> 1079
    //   930: astore 6
    //   932: aload_0
    //   933: astore 7
    //   935: aload 6
    //   937: astore_0
    //   938: aload 7
    //   940: astore 6
    //   942: goto +305 -> 1247
    //   945: astore 7
    //   947: aconst_null
    //   948: astore 6
    //   950: aload 8
    //   952: astore_0
    //   953: aload 7
    //   955: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   958: aload 8
    //   960: astore_0
    //   961: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   964: ifeq +51 -> 1015
    //   967: aload 8
    //   969: astore_0
    //   970: new 79	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   977: astore 9
    //   979: aload 8
    //   981: astore_0
    //   982: aload 9
    //   984: ldc 182
    //   986: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: aload 8
    //   992: astore_0
    //   993: aload 9
    //   995: aload 7
    //   997: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1000: pop
    //   1001: aload 8
    //   1003: astore_0
    //   1004: ldc 88
    //   1006: iconst_2
    //   1007: aload 9
    //   1009: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1015: aload 6
    //   1017: astore 7
    //   1019: aload 8
    //   1021: ifnull +171 -> 1192
    //   1024: aload 8
    //   1026: invokevirtual 120	java/io/InputStream:close	()V
    //   1029: aload 6
    //   1031: astore 7
    //   1033: goto +159 -> 1192
    //   1036: astore 8
    //   1038: aload 8
    //   1040: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   1043: aload 6
    //   1045: astore 7
    //   1047: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1050: ifeq +142 -> 1192
    //   1053: new 79	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1060: astore 7
    //   1062: aload 6
    //   1064: astore_0
    //   1065: goto -296 -> 769
    //   1068: astore_0
    //   1069: aconst_null
    //   1070: astore 6
    //   1072: aload 7
    //   1074: astore 8
    //   1076: aload_0
    //   1077: astore 7
    //   1079: aload 8
    //   1081: astore_0
    //   1082: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1085: ifeq +54 -> 1139
    //   1088: aload 8
    //   1090: astore_0
    //   1091: new 79	java/lang/StringBuilder
    //   1094: dup
    //   1095: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1098: astore 9
    //   1100: aload 8
    //   1102: astore_0
    //   1103: aload 9
    //   1105: ldc 184
    //   1107: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload 8
    //   1113: astore_0
    //   1114: aload 9
    //   1116: aload 7
    //   1118: invokevirtual 185	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1121: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: pop
    //   1125: aload 8
    //   1127: astore_0
    //   1128: ldc 88
    //   1130: iconst_2
    //   1131: aload 9
    //   1133: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1136: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1139: aload 6
    //   1141: astore 7
    //   1143: aload 8
    //   1145: ifnull +47 -> 1192
    //   1148: aload 8
    //   1150: invokevirtual 120	java/io/InputStream:close	()V
    //   1153: aload 6
    //   1155: astore 7
    //   1157: goto +35 -> 1192
    //   1160: astore 8
    //   1162: aload 8
    //   1164: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   1167: aload 6
    //   1169: astore 7
    //   1171: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1174: ifeq +18 -> 1192
    //   1177: new 79	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1184: astore 7
    //   1186: aload 6
    //   1188: astore_0
    //   1189: goto -420 -> 769
    //   1192: aload 7
    //   1194: ifnull +50 -> 1244
    //   1197: aload 7
    //   1199: invokevirtual 188	com/tencent/mobileqq/activity/aio/doodle/DoodleItem:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleParam;
    //   1202: invokevirtual 193	com/tencent/mobileqq/activity/aio/doodle/DoodleParam:d	()F
    //   1205: fstore_1
    //   1206: aload 7
    //   1208: invokevirtual 188	com/tencent/mobileqq/activity/aio/doodle/DoodleItem:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleParam;
    //   1211: invokevirtual 196	com/tencent/mobileqq/activity/aio/doodle/DoodleParam:c	()F
    //   1214: fstore_2
    //   1215: fload_1
    //   1216: fload_2
    //   1217: fcmpl
    //   1218: ifle +21 -> 1239
    //   1221: aload 7
    //   1223: invokevirtual 188	com/tencent/mobileqq/activity/aio/doodle/DoodleItem:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleParam;
    //   1226: fload_1
    //   1227: invokevirtual 199	com/tencent/mobileqq/activity/aio/doodle/DoodleParam:c	(F)V
    //   1230: aload 7
    //   1232: invokevirtual 188	com/tencent/mobileqq/activity/aio/doodle/DoodleItem:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleParam;
    //   1235: fload_2
    //   1236: invokevirtual 201	com/tencent/mobileqq/activity/aio/doodle/DoodleParam:d	(F)V
    //   1239: aload 7
    //   1241: invokestatic 204	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(Lcom/tencent/mobileqq/activity/aio/doodle/DoodleItem;)V
    //   1244: aload 7
    //   1246: areturn
    //   1247: aload 6
    //   1249: ifnull +60 -> 1309
    //   1252: aload 6
    //   1254: invokevirtual 120	java/io/InputStream:close	()V
    //   1257: goto +52 -> 1309
    //   1260: astore 6
    //   1262: aload 6
    //   1264: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   1267: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1270: ifeq +39 -> 1309
    //   1273: new 79	java/lang/StringBuilder
    //   1276: dup
    //   1277: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1280: astore 7
    //   1282: aload 7
    //   1284: ldc 125
    //   1286: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: pop
    //   1290: aload 7
    //   1292: aload 6
    //   1294: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1297: pop
    //   1298: ldc 88
    //   1300: iconst_2
    //   1301: aload 7
    //   1303: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1306: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1309: goto +5 -> 1314
    //   1312: aload_0
    //   1313: athrow
    //   1314: goto -2 -> 1312
    //   1317: astore_0
    //   1318: goto -938 -> 380
    //   1321: astore 10
    //   1323: goto -796 -> 527
    //   1326: iload 4
    //   1328: iload_3
    //   1329: if_icmpne -708 -> 621
    //   1332: iconst_0
    //   1333: istore 5
    //   1335: goto -682 -> 653
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1338	0	paramString	String
    //   1205	22	1	f1	float
    //   1214	22	2	f2	float
    //   116	1214	3	i	int
    //   247	1083	4	j	int
    //   4	1330	5	bool	boolean
    //   13	913	6	localObject1	Object
    //   930	6	6	localObject2	Object
    //   940	313	6	str1	String
    //   1260	33	6	localException1	Exception
    //   10	788	7	localObject3	Object
    //   802	1	7	localException2	Exception
    //   807	1	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   902	1	7	localException3	Exception
    //   916	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   933	6	7	str2	String
    //   945	51	7	localException4	Exception
    //   1017	285	7	localObject4	Object
    //   7	693	8	localObject5	Object
    //   744	36	8	localException5	Exception
    //   908	117	8	localObject6	Object
    //   1036	3	8	localException6	Exception
    //   1074	75	8	localObject7	Object
    //   1160	3	8	localException7	Exception
    //   30	1102	9	localObject8	Object
    //   445	118	10	localObject9	Object
    //   1321	1	10	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   159	164	166	java/lang/Exception
    //   306	311	313	java/lang/Exception
    //   733	738	744	java/lang/Exception
    //   388	394	802	java/lang/Exception
    //   399	408	802	java/lang/Exception
    //   417	425	802	java/lang/Exception
    //   441	504	802	java/lang/Exception
    //   507	516	802	java/lang/Exception
    //   516	527	802	java/lang/Exception
    //   527	570	802	java/lang/Exception
    //   576	618	802	java/lang/Exception
    //   626	634	802	java/lang/Exception
    //   634	650	802	java/lang/Exception
    //   653	662	802	java/lang/Exception
    //   665	707	802	java/lang/Exception
    //   712	720	802	java/lang/Exception
    //   720	733	802	java/lang/Exception
    //   388	394	807	java/lang/OutOfMemoryError
    //   399	408	807	java/lang/OutOfMemoryError
    //   417	425	807	java/lang/OutOfMemoryError
    //   441	504	807	java/lang/OutOfMemoryError
    //   507	516	807	java/lang/OutOfMemoryError
    //   516	527	807	java/lang/OutOfMemoryError
    //   527	570	807	java/lang/OutOfMemoryError
    //   576	618	807	java/lang/OutOfMemoryError
    //   626	634	807	java/lang/OutOfMemoryError
    //   634	650	807	java/lang/OutOfMemoryError
    //   653	662	807	java/lang/OutOfMemoryError
    //   665	707	807	java/lang/OutOfMemoryError
    //   712	720	807	java/lang/OutOfMemoryError
    //   720	733	807	java/lang/OutOfMemoryError
    //   843	848	850	java/lang/Exception
    //   104	117	898	finally
    //   122	159	898	finally
    //   214	221	898	finally
    //   235	249	898	finally
    //   255	306	898	finally
    //   361	370	898	finally
    //   370	380	898	finally
    //   380	388	898	finally
    //   388	394	898	finally
    //   399	408	898	finally
    //   417	425	898	finally
    //   441	504	898	finally
    //   507	516	898	finally
    //   516	527	898	finally
    //   527	570	898	finally
    //   576	618	898	finally
    //   626	634	898	finally
    //   634	650	898	finally
    //   653	662	898	finally
    //   665	707	898	finally
    //   712	720	898	finally
    //   720	733	898	finally
    //   812	843	898	finally
    //   104	117	902	java/lang/Exception
    //   122	159	902	java/lang/Exception
    //   214	221	902	java/lang/Exception
    //   235	249	902	java/lang/Exception
    //   255	306	902	java/lang/Exception
    //   361	370	902	java/lang/Exception
    //   370	380	902	java/lang/Exception
    //   380	388	902	java/lang/Exception
    //   812	843	902	java/lang/Exception
    //   104	117	916	java/lang/OutOfMemoryError
    //   122	159	916	java/lang/OutOfMemoryError
    //   214	221	916	java/lang/OutOfMemoryError
    //   235	249	916	java/lang/OutOfMemoryError
    //   255	306	916	java/lang/OutOfMemoryError
    //   361	370	916	java/lang/OutOfMemoryError
    //   370	380	916	java/lang/OutOfMemoryError
    //   380	388	916	java/lang/OutOfMemoryError
    //   812	843	916	java/lang/OutOfMemoryError
    //   86	104	930	finally
    //   953	958	930	finally
    //   961	967	930	finally
    //   970	979	930	finally
    //   982	990	930	finally
    //   993	1001	930	finally
    //   1004	1015	930	finally
    //   1082	1088	930	finally
    //   1091	1100	930	finally
    //   1103	1111	930	finally
    //   1114	1125	930	finally
    //   1128	1139	930	finally
    //   86	104	945	java/lang/Exception
    //   1024	1029	1036	java/lang/Exception
    //   86	104	1068	java/lang/OutOfMemoryError
    //   1148	1153	1160	java/lang/Exception
    //   1252	1257	1260	java/lang/Exception
    //   370	380	1317	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   516	527	1321	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private static DoodleMsgProto.DoodleData a(int paramInt, PathData paramPathData)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("formatHeader line header begin :");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("DoodleMsgTranslator", 2, ((StringBuilder)localObject).toString());
    if (paramPathData == null) {
      return null;
    }
    localObject = paramPathData.a();
    DoodleMsgProto.DoodleData localDoodleData = new DoodleMsgProto.DoodleData();
    localDoodleData.uint_line_id.set(paramInt);
    localDoodleData.uint_line_id.setHasFlag(true);
    localDoodleData.uint32_rgba.set(paramPathData.b());
    localDoodleData.uint32_rgba.setHasFlag(true);
    PBUInt32Field localPBUInt32Field = localDoodleData.uint32template_id;
    if (paramPathData.a() < 0) {
      paramInt = 0;
    } else {
      paramInt = paramPathData.a();
    }
    localPBUInt32Field.set(paramInt);
    localDoodleData.uint32template_id.setHasFlag(true);
    long l = 0L;
    if (((List)localObject).size() > 0) {
      l = ((PathData.PointData)((List)localObject).get(((List)localObject).size() - 1)).a();
    }
    localDoodleData.uint32_time.set((int)l);
    localDoodleData.uint32_time.setHasFlag(true);
    return localDoodleData;
  }
  
  private static void a(DoodleItem paramDoodleItem)
  {
    if (paramDoodleItem == null) {
      return;
    }
    Iterator localIterator1 = paramDoodleItem.a().iterator();
    while (localIterator1.hasNext())
    {
      PathData localPathData = (PathData)localIterator1.next();
      if (localPathData.c() >= 500)
      {
        if (QLog.isColorLevel())
        {
          paramDoodleItem = new StringBuilder();
          paramDoodleItem.append("reduce point before:");
          paramDoodleItem.append(localPathData.c());
          QLog.d("DoodleMsgTranslator", 2, paramDoodleItem.toString());
        }
        paramDoodleItem = null;
        Iterator localIterator2 = localPathData.a().iterator();
        while (localIterator2.hasNext())
        {
          PathData.PointData localPointData = (PathData.PointData)localIterator2.next();
          if (!localIterator2.hasNext()) {
            break;
          }
          if (paramDoodleItem == null) {
            paramDoodleItem = localPointData;
          } else if ((Math.abs(localPointData.a() - paramDoodleItem.a()) < 10.0F) && (Math.abs(localPointData.b() - paramDoodleItem.b()) < 10.0F)) {
            localIterator2.remove();
          }
        }
        if (QLog.isColorLevel())
        {
          paramDoodleItem = new StringBuilder();
          paramDoodleItem.append("reduce point end:");
          paramDoodleItem.append(localPathData.c());
          QLog.d("DoodleMsgTranslator", 2, paramDoodleItem.toString());
        }
      }
    }
  }
  
  private static void a(DoodleItem paramDoodleItem, DoodleMsgProto.DoodleHeader paramDoodleHeader)
  {
    if (paramDoodleItem != null)
    {
      if (paramDoodleHeader == null) {
        return;
      }
      Resources localResources = BaseApplication.getContext().getResources();
      if ((paramDoodleHeader.float_draw_area_width.has()) && (paramDoodleHeader.float_draw_area_height.has())) {
        paramDoodleItem.a().a((int)Utils.a(paramDoodleHeader.float_draw_area_width.get(), localResources), (int)Utils.a(paramDoodleHeader.float_draw_area_height.get(), localResources));
      }
      if (paramDoodleHeader.float_line_width_max.has()) {
        paramDoodleItem.a().a(Utils.a(paramDoodleHeader.float_line_width_max.get(), localResources));
      }
      if (paramDoodleHeader.float_line_width_min.has()) {
        paramDoodleItem.a().b(Utils.a(paramDoodleHeader.float_line_width_min.get(), localResources));
      }
      if (paramDoodleHeader.float_comp_factor_max.has()) {
        paramDoodleItem.a().c(paramDoodleHeader.float_comp_factor_max.get());
      }
      if (paramDoodleHeader.float_comp_factor_min.has()) {
        paramDoodleItem.a().d(paramDoodleHeader.float_comp_factor_min.get());
      }
      if (paramDoodleHeader.uint32_time.has()) {
        paramDoodleItem.a(paramDoodleHeader.uint32_time.get());
      }
    }
  }
  
  private static void a(PathData paramPathData, DoodleMsgProto.DoodleData paramDoodleData, boolean paramBoolean)
  {
    if (paramPathData != null)
    {
      if (paramDoodleData == null) {
        return;
      }
      if (paramBoolean)
      {
        if (paramDoodleData.uint32_rgba.has()) {
          paramPathData.b(paramDoodleData.uint32_rgba.get());
        }
        if (paramDoodleData.uint32template_id.has())
        {
          paramPathData.a(paramDoodleData.uint32template_id.get());
          if (paramPathData.a() > 0) {
            paramPathData.b(-1);
          }
        }
      }
      Resources localResources = BaseApplication.getContext().getResources();
      if (paramDoodleData.rpt_line_Data.has())
      {
        paramDoodleData = paramDoodleData.rpt_line_Data.get();
        if (paramDoodleData != null)
        {
          paramDoodleData = paramDoodleData.iterator();
          while (paramDoodleData.hasNext())
          {
            DoodleMsgProto.LineData localLineData = (DoodleMsgProto.LineData)paramDoodleData.next();
            if ((localLineData.float_X.has()) && (localLineData.float_Y.has()) && (localLineData.uint64_tickcount.has())) {
              paramPathData.a(Utils.a(localLineData.float_X.get(), localResources), Utils.a(localLineData.float_Y.get(), localResources), -1.0F, localLineData.uint64_tickcount.get());
            }
          }
        }
      }
    }
  }
  
  private static boolean a(int paramInt, PathData paramPathData, DoodleMsgTranslator.TranslatorListener paramTranslatorListener)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("formatHeader line begin :");
    ((StringBuilder)localObject1).append(paramInt);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = "DoodleMsgTranslator";
    QLog.d("DoodleMsgTranslator", 2, (String)localObject2);
    if ((paramTranslatorListener != null) && (paramPathData != null))
    {
      localObject2 = paramPathData.a();
      int i;
      if (localObject2 != null) {
        i = ((List)localObject2).size();
      } else {
        i = 0;
      }
      BaseApplication localBaseApplication = BaseApplication.getContext();
      boolean bool1 = true;
      int j = 0;
      for (;;)
      {
        DoodleMsgProto.DoodleData localDoodleData = a(paramInt, paramPathData);
        if (localDoodleData == null)
        {
          if (paramTranslatorListener != null) {
            bool1 = paramTranslatorListener.a(null);
          }
          return bool1;
        }
        int k = 0;
        int m;
        for (;;)
        {
          m = k + j;
          if ((m >= i) || (k >= 1000)) {
            break;
          }
          localObject3 = new DoodleMsgProto.LineData();
          PathData.PointData localPointData = (PathData.PointData)((List)localObject2).get(m);
          ((DoodleMsgProto.LineData)localObject3).float_X.set(a(localBaseApplication, localPointData.a()));
          ((DoodleMsgProto.LineData)localObject3).float_X.setHasFlag(true);
          ((DoodleMsgProto.LineData)localObject3).float_Y.set(a(localBaseApplication, localPointData.b()));
          ((DoodleMsgProto.LineData)localObject3).float_Y.setHasFlag(true);
          ((DoodleMsgProto.LineData)localObject3).uint64_tickcount.set(localPointData.a());
          ((DoodleMsgProto.LineData)localObject3).uint64_tickcount.setHasFlag(true);
          localDoodleData.rpt_line_Data.add((MessageMicro)localObject3);
          k += 1;
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("format line pos before:");
        ((StringBuilder)localObject3).append(m);
        ((StringBuilder)localObject3).append(". count:");
        ((StringBuilder)localObject3).append(k);
        localObject3 = ((StringBuilder)localObject3).toString();
        QLog.d((String)localObject1, 2, (String)localObject3);
        boolean bool2 = bool1;
        if (paramTranslatorListener != null)
        {
          if ((paramTranslatorListener.a(localDoodleData)) && (bool1)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          bool2 = bool1;
        }
        if (m >= i) {
          return bool2;
        }
        j = m;
        bool1 = bool2;
      }
    }
    return false;
  }
  
  public static boolean a(DoodleItem paramDoodleItem, DoodleMsgTranslator.TranslatorListener paramTranslatorListener)
  {
    if (paramDoodleItem != null)
    {
      if (paramTranslatorListener == null) {
        return false;
      }
      if (paramDoodleItem.a() == null) {
        return false;
      }
      try
      {
        boolean bool1 = b(paramDoodleItem, paramTranslatorListener);
        paramDoodleItem = paramDoodleItem.a().iterator();
        int i = 0;
        while (paramDoodleItem.hasNext())
        {
          boolean bool2 = a(i, (PathData)paramDoodleItem.next(), paramTranslatorListener);
          if ((bool2) && (bool1)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          i += 1;
        }
        return bool1;
      }
      catch (Exception paramDoodleItem)
      {
        paramDoodleItem.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramTranslatorListener = new StringBuilder();
          paramTranslatorListener.append("translate data exception:");
          paramTranslatorListener.append(paramDoodleItem);
          QLog.e("DoodleMsgTranslator", 2, paramTranslatorListener.toString());
        }
      }
    }
    return false;
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF00 & paramInt) >> 8), (byte)(paramInt & 0xFF) };
  }
  
  public static byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int j;
    for (int i = 0; i < 8; i = j)
    {
      j = i + 1;
      arrayOfByte[i] = ((byte)(int)(paramLong >> 64 - j * 8 & 0xFF));
    }
    return arrayOfByte;
  }
  
  public static boolean b(DoodleItem paramDoodleItem, DoodleMsgTranslator.TranslatorListener paramTranslatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramDoodleItem == null)
    {
      if (paramTranslatorListener != null) {
        bool1 = paramTranslatorListener.a(null);
      }
      return bool1;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    DoodleMsgProto.DoodleHeader localDoodleHeader = new DoodleMsgProto.DoodleHeader();
    localDoodleHeader.uint32_Version.set(1);
    localDoodleHeader.uint32_Version.setHasFlag(true);
    localDoodleHeader.uint32_time.set((int)paramDoodleItem.a());
    localDoodleHeader.uint32_time.setHasFlag(true);
    ArrayList localArrayList = paramDoodleItem.a();
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    paramDoodleItem = paramDoodleItem.a();
    localDoodleHeader.uint32_line_count.set(i);
    localDoodleHeader.uint32_line_count.setHasFlag(true);
    localDoodleHeader.float_line_width_max.set(a(localBaseApplication, paramDoodleItem.a()));
    localDoodleHeader.float_line_width_max.setHasFlag(true);
    localDoodleHeader.float_line_width_min.set(a(localBaseApplication, paramDoodleItem.b()));
    localDoodleHeader.float_line_width_min.setHasFlag(true);
    localDoodleHeader.float_comp_factor_max.set(paramDoodleItem.c());
    localDoodleHeader.float_comp_factor_max.setHasFlag(true);
    localDoodleHeader.float_comp_factor_min.set(paramDoodleItem.d());
    localDoodleHeader.float_comp_factor_min.setHasFlag(true);
    localDoodleHeader.float_draw_area_width.set(a(localBaseApplication, paramDoodleItem.a().width()));
    localDoodleHeader.float_draw_area_width.setHasFlag(true);
    localDoodleHeader.float_draw_area_height.set(a(localBaseApplication, paramDoodleItem.a().height()));
    localDoodleHeader.float_draw_area_height.setHasFlag(true);
    bool1 = bool2;
    if (paramTranslatorListener != null) {
      bool1 = paramTranslatorListener.a(localDoodleHeader);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgTranslator
 * JD-Core Version:    0.7.0.1
 */