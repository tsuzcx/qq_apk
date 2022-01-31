package com.tencent.beacon.core.c;

import android.content.Context;
import com.tencent.beacon.core.d.b;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

final class f$b
  extends f
{
  private Context a;
  
  public f$b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static byte[] a(Socket paramSocket)
  {
    b.b("[net] begin waiting server response.", new Object[0]);
    paramSocket = paramSocket.getInputStream();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[2048];
    for (;;)
    {
      int i = paramSocket.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    b.b("[net] server response length: %d [need >= 4]", new Object[] { Integer.valueOf(arrayOfByte.length) });
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length - 4);
    localByteBuffer.put(arrayOfByte, 2, arrayOfByte.length - 4);
    arrayOfByte = localByteBuffer.array();
    localByteArrayOutputStream.close();
    paramSocket.close();
    return arrayOfByte;
  }
  
  public final boolean a()
  {
    return true;
  }
  
  /* Error */
  public final byte[] a(java.lang.String paramString, int paramInt, byte[] paramArrayOfByte, a parama, e parame)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: iload_2
    //   5: ifgt +14 -> 19
    //   8: ldc 88
    //   10: iconst_0
    //   11: anewarray 19	java/lang/Object
    //   14: invokestatic 91	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aconst_null
    //   18: areturn
    //   19: ldc 93
    //   21: iconst_3
    //   22: anewarray 19	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload 4
    //   29: getfield 98	com/tencent/beacon/core/c/a:a	I
    //   32: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload 4
    //   40: getfield 100	com/tencent/beacon/core/c/a:b	I
    //   43: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: dup
    //   48: iconst_2
    //   49: aload 4
    //   51: getfield 103	com/tencent/beacon/core/c/a:e	I
    //   54: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 25	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc 105
    //   63: astore 12
    //   65: iconst_0
    //   66: istore 6
    //   68: iload 6
    //   70: iconst_1
    //   71: iadd
    //   72: istore 7
    //   74: iload 6
    //   76: iconst_3
    //   77: if_icmpge +1050 -> 1127
    //   80: iload 7
    //   82: iconst_1
    //   83: if_icmple +51 -> 134
    //   86: new 107	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 109
    //   92: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: iload 7
    //   97: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: iconst_0
    //   104: anewarray 19	java/lang/Object
    //   107: invokestatic 123	com/tencent/beacon/core/d/b:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: iload 7
    //   112: iconst_2
    //   113: if_icmpne +18 -> 131
    //   116: aload 4
    //   118: invokevirtual 127	com/tencent/beacon/core/c/a:c	()I
    //   121: iconst_2
    //   122: if_icmpne +9 -> 131
    //   125: aload 4
    //   127: iconst_0
    //   128: invokevirtual 130	com/tencent/beacon/core/c/a:b	(Z)V
    //   131: invokestatic 132	com/tencent/beacon/core/c/f$b:b	()V
    //   134: aload_3
    //   135: ifnonnull +654 -> 789
    //   138: lconst_0
    //   139: lstore 8
    //   141: aload 5
    //   143: new 107	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   150: aload_1
    //   151: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 138
    //   156: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload_2
    //   160: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: lload 8
    //   168: aload_0
    //   169: getfield 13	com/tencent/beacon/core/c/f$b:a	Landroid/content/Context;
    //   172: invokestatic 143	com/tencent/beacon/core/d/d:c	(Landroid/content/Context;)Ljava/lang/String;
    //   175: iload 7
    //   177: invokeinterface 148 6 0
    //   182: new 150	java/util/Date
    //   185: dup
    //   186: invokespecial 151	java/util/Date:<init>	()V
    //   189: invokevirtual 155	java/util/Date:getTime	()J
    //   192: lstore 8
    //   194: aload_1
    //   195: invokestatic 161	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   198: astore 13
    //   200: ldc 163
    //   202: iconst_2
    //   203: anewarray 19	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload 13
    //   210: invokevirtual 166	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: iload_2
    //   217: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   220: aastore
    //   221: invokestatic 25	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aconst_null
    //   225: astore 14
    //   227: aconst_null
    //   228: astore 15
    //   230: new 27	java/net/Socket
    //   233: dup
    //   234: aload 13
    //   236: invokevirtual 166	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   239: iload_2
    //   240: invokespecial 169	java/net/Socket:<init>	(Ljava/lang/String;I)V
    //   243: astore 13
    //   245: aload 13
    //   247: astore 14
    //   249: aload 13
    //   251: sipush 30000
    //   254: invokevirtual 173	java/net/Socket:setSoTimeout	(I)V
    //   257: aload 13
    //   259: astore 14
    //   261: ldc 175
    //   263: iconst_3
    //   264: anewarray 19	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload 13
    //   271: invokevirtual 179	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
    //   274: invokevirtual 182	java/net/InetAddress:getHostName	()Ljava/lang/String;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: aload 13
    //   282: invokevirtual 185	java/net/Socket:getLocalPort	()I
    //   285: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: aload_3
    //   292: arraylength
    //   293: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: invokestatic 25	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: aload 13
    //   302: astore 14
    //   304: new 187	java/util/HashMap
    //   307: dup
    //   308: invokespecial 188	java/util/HashMap:<init>	()V
    //   311: astore 15
    //   313: aload 13
    //   315: astore 14
    //   317: aload 4
    //   319: invokevirtual 190	com/tencent/beacon/core/c/a:d	()Ljava/lang/String;
    //   322: astore 16
    //   324: aload 16
    //   326: ifnull +36 -> 362
    //   329: aload 13
    //   331: astore 14
    //   333: ldc 105
    //   335: aload 16
    //   337: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   340: ifne +22 -> 362
    //   343: aload 13
    //   345: astore 14
    //   347: aload 15
    //   349: ldc 198
    //   351: aload 4
    //   353: invokevirtual 190	com/tencent/beacon/core/c/a:d	()Ljava/lang/String;
    //   356: invokeinterface 203 3 0
    //   361: pop
    //   362: aload 13
    //   364: astore 14
    //   366: invokestatic 208	com/tencent/beacon/core/strategy/a:a	()Lcom/tencent/beacon/core/strategy/a;
    //   369: invokevirtual 211	com/tencent/beacon/core/strategy/a:p	()Ljava/lang/String;
    //   372: astore 16
    //   374: aload 16
    //   376: ifnull +33 -> 409
    //   379: aload 13
    //   381: astore 14
    //   383: ldc 105
    //   385: aload 16
    //   387: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: ifne +19 -> 409
    //   393: aload 13
    //   395: astore 14
    //   397: aload 15
    //   399: ldc 213
    //   401: aload 16
    //   403: invokeinterface 203 3 0
    //   408: pop
    //   409: aload 13
    //   411: astore 14
    //   413: aload 15
    //   415: ldc 215
    //   417: ldc 217
    //   419: invokeinterface 203 3 0
    //   424: pop
    //   425: aload 13
    //   427: astore 14
    //   429: aload 15
    //   431: ldc 219
    //   433: ldc 221
    //   435: invokeinterface 203 3 0
    //   440: pop
    //   441: aload 13
    //   443: astore 14
    //   445: aload 15
    //   447: ldc 223
    //   449: ldc 225
    //   451: invokeinterface 203 3 0
    //   456: pop
    //   457: aload 13
    //   459: astore 14
    //   461: invokestatic 208	com/tencent/beacon/core/strategy/a:a	()Lcom/tencent/beacon/core/strategy/a;
    //   464: astore 16
    //   466: aload 16
    //   468: ifnull +22 -> 490
    //   471: aload 13
    //   473: astore 14
    //   475: aload 15
    //   477: ldc 227
    //   479: aload 16
    //   481: invokevirtual 230	com/tencent/beacon/core/strategy/a:n	()Ljava/lang/String;
    //   484: invokeinterface 203 3 0
    //   489: pop
    //   490: aload 13
    //   492: astore 14
    //   494: new 232	com/tencent/beacon/core/protocol/common/SocketRequestPackage
    //   497: dup
    //   498: aload 15
    //   500: aload_3
    //   501: invokespecial 235	com/tencent/beacon/core/protocol/common/SocketRequestPackage:<init>	(Ljava/util/Map;[B)V
    //   504: astore 15
    //   506: aload 13
    //   508: astore 14
    //   510: new 237	com/tencent/beacon/core/wup/b
    //   513: dup
    //   514: invokespecial 238	com/tencent/beacon/core/wup/b:<init>	()V
    //   517: astore 16
    //   519: aload 13
    //   521: astore 14
    //   523: aload 15
    //   525: aload 16
    //   527: invokevirtual 242	com/tencent/beacon/core/protocol/common/SocketRequestPackage:writeTo	(Lcom/tencent/beacon/core/wup/b;)V
    //   530: aload 13
    //   532: astore 14
    //   534: aload 13
    //   536: invokevirtual 246	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   539: astore 15
    //   541: aload 13
    //   543: astore 14
    //   545: aload 16
    //   547: invokevirtual 248	com/tencent/beacon/core/wup/b:b	()[B
    //   550: astore 16
    //   552: aload 13
    //   554: astore 14
    //   556: aload 16
    //   558: arraylength
    //   559: istore 6
    //   561: aload 13
    //   563: astore 14
    //   565: ldc 250
    //   567: iconst_2
    //   568: anewarray 19	java/lang/Object
    //   571: dup
    //   572: iconst_0
    //   573: aload_3
    //   574: arraylength
    //   575: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   578: aastore
    //   579: dup
    //   580: iconst_1
    //   581: iload 6
    //   583: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   586: aastore
    //   587: invokestatic 25	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   590: aload 13
    //   592: astore 14
    //   594: iload 6
    //   596: iconst_4
    //   597: iadd
    //   598: invokestatic 65	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   601: astore 17
    //   603: aload 13
    //   605: astore 14
    //   607: aload 17
    //   609: getstatic 256	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   612: invokevirtual 260	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   615: pop
    //   616: aload 13
    //   618: astore 14
    //   620: aload 17
    //   622: iload 6
    //   624: iconst_4
    //   625: iadd
    //   626: i2s
    //   627: invokevirtual 264	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   630: pop
    //   631: aload 13
    //   633: astore 14
    //   635: aload 17
    //   637: aload 16
    //   639: invokevirtual 267	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   642: pop
    //   643: aload 13
    //   645: astore 14
    //   647: aload 17
    //   649: bipush 13
    //   651: invokevirtual 270	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   654: pop
    //   655: aload 13
    //   657: astore 14
    //   659: aload 17
    //   661: bipush 10
    //   663: invokevirtual 270	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   666: pop
    //   667: iload 6
    //   669: ldc_w 271
    //   672: if_icmplt +17 -> 689
    //   675: aload 13
    //   677: astore 14
    //   679: ldc_w 273
    //   682: iconst_0
    //   683: anewarray 19	java/lang/Object
    //   686: invokestatic 91	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   689: aload 13
    //   691: astore 14
    //   693: aload 15
    //   695: aload 17
    //   697: invokevirtual 72	java/nio/ByteBuffer:array	()[B
    //   700: invokevirtual 278	java/io/OutputStream:write	([B)V
    //   703: aload 13
    //   705: astore 14
    //   707: aload 15
    //   709: invokevirtual 279	java/io/OutputStream:flush	()V
    //   712: aload 13
    //   714: astore 14
    //   716: aload 13
    //   718: invokestatic 281	com/tencent/beacon/core/c/f$b:a	(Ljava/net/Socket;)[B
    //   721: astore 15
    //   723: aload 15
    //   725: astore 14
    //   727: ldc_w 283
    //   730: iconst_0
    //   731: anewarray 19	java/lang/Object
    //   734: invokestatic 25	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   737: aload 13
    //   739: invokevirtual 284	java/net/Socket:close	()V
    //   742: aload 14
    //   744: astore 13
    //   746: aload 13
    //   748: ifnonnull +364 -> 1112
    //   751: iconst_0
    //   752: istore 6
    //   754: new 150	java/util/Date
    //   757: dup
    //   758: invokespecial 151	java/util/Date:<init>	()V
    //   761: invokevirtual 155	java/util/Date:getTime	()J
    //   764: lstore 10
    //   766: aload 5
    //   768: iload 6
    //   770: i2l
    //   771: lload 10
    //   773: lload 8
    //   775: lsub
    //   776: invokeinterface 287 5 0
    //   781: aload 13
    //   783: ifnull +337 -> 1120
    //   786: aload 13
    //   788: areturn
    //   789: aload_3
    //   790: arraylength
    //   791: i2l
    //   792: lstore 8
    //   794: goto -653 -> 141
    //   797: astore 13
    //   799: aload 14
    //   801: astore 13
    //   803: goto -57 -> 746
    //   806: astore 13
    //   808: aconst_null
    //   809: astore 15
    //   811: aload 15
    //   813: astore 14
    //   815: aload 5
    //   817: invokeinterface 289 1 0
    //   822: aload 15
    //   824: astore 14
    //   826: new 107	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   833: aload 12
    //   835: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: iload 7
    //   840: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc_w 291
    //   846: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: astore 13
    //   854: ldc_w 283
    //   857: iconst_0
    //   858: anewarray 19	java/lang/Object
    //   861: invokestatic 25	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   864: aload 13
    //   866: astore 12
    //   868: aload 15
    //   870: ifnull +306 -> 1176
    //   873: aload 15
    //   875: invokevirtual 284	java/net/Socket:close	()V
    //   878: aconst_null
    //   879: astore 14
    //   881: aload 13
    //   883: astore 12
    //   885: aload 14
    //   887: astore 13
    //   889: goto -143 -> 746
    //   892: astore 12
    //   894: aconst_null
    //   895: astore 14
    //   897: aload 13
    //   899: astore 12
    //   901: aload 14
    //   903: astore 13
    //   905: goto -159 -> 746
    //   908: astore 13
    //   910: aconst_null
    //   911: astore 15
    //   913: aload 15
    //   915: astore 14
    //   917: new 107	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   924: aload 12
    //   926: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: iload 7
    //   931: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   934: ldc_w 293
    //   937: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   943: astore 13
    //   945: ldc_w 283
    //   948: iconst_0
    //   949: anewarray 19	java/lang/Object
    //   952: invokestatic 25	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   955: aload 13
    //   957: astore 12
    //   959: aload 15
    //   961: ifnull +215 -> 1176
    //   964: aload 15
    //   966: invokevirtual 284	java/net/Socket:close	()V
    //   969: aconst_null
    //   970: astore 14
    //   972: aload 13
    //   974: astore 12
    //   976: aload 14
    //   978: astore 13
    //   980: goto -234 -> 746
    //   983: astore 12
    //   985: aconst_null
    //   986: astore 14
    //   988: aload 13
    //   990: astore 12
    //   992: aload 14
    //   994: astore 13
    //   996: goto -250 -> 746
    //   999: astore 13
    //   1001: aload 15
    //   1003: astore 14
    //   1005: new 107	java/lang/StringBuilder
    //   1008: dup
    //   1009: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   1012: aload 12
    //   1014: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: ldc 138
    //   1019: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: aload 13
    //   1024: invokevirtual 296	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1027: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1033: astore 13
    //   1035: ldc_w 283
    //   1038: iconst_0
    //   1039: anewarray 19	java/lang/Object
    //   1042: invokestatic 25	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1045: aload 13
    //   1047: astore 12
    //   1049: aload 15
    //   1051: ifnull +125 -> 1176
    //   1054: aload 15
    //   1056: invokevirtual 284	java/net/Socket:close	()V
    //   1059: aconst_null
    //   1060: astore 14
    //   1062: aload 13
    //   1064: astore 12
    //   1066: aload 14
    //   1068: astore 13
    //   1070: goto -324 -> 746
    //   1073: astore 12
    //   1075: aconst_null
    //   1076: astore 14
    //   1078: aload 13
    //   1080: astore 12
    //   1082: aload 14
    //   1084: astore 13
    //   1086: goto -340 -> 746
    //   1089: astore_1
    //   1090: ldc_w 283
    //   1093: iconst_0
    //   1094: anewarray 19	java/lang/Object
    //   1097: invokestatic 25	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1100: aload 14
    //   1102: ifnull +8 -> 1110
    //   1105: aload 14
    //   1107: invokevirtual 284	java/net/Socket:close	()V
    //   1110: aload_1
    //   1111: athrow
    //   1112: aload 13
    //   1114: arraylength
    //   1115: istore 6
    //   1117: goto -363 -> 754
    //   1120: iload 7
    //   1122: istore 6
    //   1124: goto -1056 -> 68
    //   1127: new 82	java/net/ConnectException
    //   1130: dup
    //   1131: aload 12
    //   1133: invokespecial 297	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   1136: athrow
    //   1137: astore_3
    //   1138: goto -28 -> 1110
    //   1141: astore_1
    //   1142: goto -52 -> 1090
    //   1145: astore 14
    //   1147: aload 13
    //   1149: astore 15
    //   1151: aload 14
    //   1153: astore 13
    //   1155: goto -154 -> 1001
    //   1158: astore 14
    //   1160: aload 13
    //   1162: astore 15
    //   1164: goto -251 -> 913
    //   1167: astore 14
    //   1169: aload 13
    //   1171: astore 15
    //   1173: goto -362 -> 811
    //   1176: aconst_null
    //   1177: astore 13
    //   1179: goto -433 -> 746
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1182	0	this	b
    //   0	1182	1	paramString	java.lang.String
    //   0	1182	2	paramInt	int
    //   0	1182	3	paramArrayOfByte	byte[]
    //   0	1182	4	parama	a
    //   0	1182	5	parame	e
    //   66	1057	6	i	int
    //   72	1049	7	j	int
    //   139	654	8	l1	long
    //   764	8	10	l2	long
    //   63	821	12	localObject1	Object
    //   892	1	12	localIOException1	java.io.IOException
    //   899	76	12	localObject2	Object
    //   983	1	12	localIOException2	java.io.IOException
    //   990	75	12	localObject3	Object
    //   1073	1	12	localIOException3	java.io.IOException
    //   1080	52	12	localObject4	Object
    //   198	589	13	localObject5	Object
    //   797	1	13	localIOException4	java.io.IOException
    //   801	1	13	localObject6	Object
    //   806	1	13	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   852	52	13	localObject7	Object
    //   908	1	13	localConnectException1	java.net.ConnectException
    //   943	52	13	localObject8	Object
    //   999	24	13	localException1	java.lang.Exception
    //   1033	145	13	localObject9	Object
    //   225	881	14	localObject10	Object
    //   1145	7	14	localException2	java.lang.Exception
    //   1158	1	14	localConnectException2	java.net.ConnectException
    //   1167	1	14	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   228	944	15	localObject11	Object
    //   322	316	16	localObject12	Object
    //   601	95	17	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   737	742	797	java/io/IOException
    //   230	245	806	java/net/SocketTimeoutException
    //   873	878	892	java/io/IOException
    //   230	245	908	java/net/ConnectException
    //   964	969	983	java/io/IOException
    //   230	245	999	java/lang/Exception
    //   1054	1059	1073	java/io/IOException
    //   230	245	1089	finally
    //   1005	1035	1089	finally
    //   1105	1110	1137	java/io/IOException
    //   249	257	1141	finally
    //   261	300	1141	finally
    //   304	313	1141	finally
    //   317	324	1141	finally
    //   333	343	1141	finally
    //   347	362	1141	finally
    //   366	374	1141	finally
    //   383	393	1141	finally
    //   397	409	1141	finally
    //   413	425	1141	finally
    //   429	441	1141	finally
    //   445	457	1141	finally
    //   461	466	1141	finally
    //   475	490	1141	finally
    //   494	506	1141	finally
    //   510	519	1141	finally
    //   523	530	1141	finally
    //   534	541	1141	finally
    //   545	552	1141	finally
    //   556	561	1141	finally
    //   565	590	1141	finally
    //   594	603	1141	finally
    //   607	616	1141	finally
    //   620	631	1141	finally
    //   635	643	1141	finally
    //   647	655	1141	finally
    //   659	667	1141	finally
    //   679	689	1141	finally
    //   693	703	1141	finally
    //   707	712	1141	finally
    //   716	723	1141	finally
    //   815	822	1141	finally
    //   826	854	1141	finally
    //   917	945	1141	finally
    //   249	257	1145	java/lang/Exception
    //   261	300	1145	java/lang/Exception
    //   304	313	1145	java/lang/Exception
    //   317	324	1145	java/lang/Exception
    //   333	343	1145	java/lang/Exception
    //   347	362	1145	java/lang/Exception
    //   366	374	1145	java/lang/Exception
    //   383	393	1145	java/lang/Exception
    //   397	409	1145	java/lang/Exception
    //   413	425	1145	java/lang/Exception
    //   429	441	1145	java/lang/Exception
    //   445	457	1145	java/lang/Exception
    //   461	466	1145	java/lang/Exception
    //   475	490	1145	java/lang/Exception
    //   494	506	1145	java/lang/Exception
    //   510	519	1145	java/lang/Exception
    //   523	530	1145	java/lang/Exception
    //   534	541	1145	java/lang/Exception
    //   545	552	1145	java/lang/Exception
    //   556	561	1145	java/lang/Exception
    //   565	590	1145	java/lang/Exception
    //   594	603	1145	java/lang/Exception
    //   607	616	1145	java/lang/Exception
    //   620	631	1145	java/lang/Exception
    //   635	643	1145	java/lang/Exception
    //   647	655	1145	java/lang/Exception
    //   659	667	1145	java/lang/Exception
    //   679	689	1145	java/lang/Exception
    //   693	703	1145	java/lang/Exception
    //   707	712	1145	java/lang/Exception
    //   716	723	1145	java/lang/Exception
    //   249	257	1158	java/net/ConnectException
    //   261	300	1158	java/net/ConnectException
    //   304	313	1158	java/net/ConnectException
    //   317	324	1158	java/net/ConnectException
    //   333	343	1158	java/net/ConnectException
    //   347	362	1158	java/net/ConnectException
    //   366	374	1158	java/net/ConnectException
    //   383	393	1158	java/net/ConnectException
    //   397	409	1158	java/net/ConnectException
    //   413	425	1158	java/net/ConnectException
    //   429	441	1158	java/net/ConnectException
    //   445	457	1158	java/net/ConnectException
    //   461	466	1158	java/net/ConnectException
    //   475	490	1158	java/net/ConnectException
    //   494	506	1158	java/net/ConnectException
    //   510	519	1158	java/net/ConnectException
    //   523	530	1158	java/net/ConnectException
    //   534	541	1158	java/net/ConnectException
    //   545	552	1158	java/net/ConnectException
    //   556	561	1158	java/net/ConnectException
    //   565	590	1158	java/net/ConnectException
    //   594	603	1158	java/net/ConnectException
    //   607	616	1158	java/net/ConnectException
    //   620	631	1158	java/net/ConnectException
    //   635	643	1158	java/net/ConnectException
    //   647	655	1158	java/net/ConnectException
    //   659	667	1158	java/net/ConnectException
    //   679	689	1158	java/net/ConnectException
    //   693	703	1158	java/net/ConnectException
    //   707	712	1158	java/net/ConnectException
    //   716	723	1158	java/net/ConnectException
    //   249	257	1167	java/net/SocketTimeoutException
    //   261	300	1167	java/net/SocketTimeoutException
    //   304	313	1167	java/net/SocketTimeoutException
    //   317	324	1167	java/net/SocketTimeoutException
    //   333	343	1167	java/net/SocketTimeoutException
    //   347	362	1167	java/net/SocketTimeoutException
    //   366	374	1167	java/net/SocketTimeoutException
    //   383	393	1167	java/net/SocketTimeoutException
    //   397	409	1167	java/net/SocketTimeoutException
    //   413	425	1167	java/net/SocketTimeoutException
    //   429	441	1167	java/net/SocketTimeoutException
    //   445	457	1167	java/net/SocketTimeoutException
    //   461	466	1167	java/net/SocketTimeoutException
    //   475	490	1167	java/net/SocketTimeoutException
    //   494	506	1167	java/net/SocketTimeoutException
    //   510	519	1167	java/net/SocketTimeoutException
    //   523	530	1167	java/net/SocketTimeoutException
    //   534	541	1167	java/net/SocketTimeoutException
    //   545	552	1167	java/net/SocketTimeoutException
    //   556	561	1167	java/net/SocketTimeoutException
    //   565	590	1167	java/net/SocketTimeoutException
    //   594	603	1167	java/net/SocketTimeoutException
    //   607	616	1167	java/net/SocketTimeoutException
    //   620	631	1167	java/net/SocketTimeoutException
    //   635	643	1167	java/net/SocketTimeoutException
    //   647	655	1167	java/net/SocketTimeoutException
    //   659	667	1167	java/net/SocketTimeoutException
    //   679	689	1167	java/net/SocketTimeoutException
    //   693	703	1167	java/net/SocketTimeoutException
    //   707	712	1167	java/net/SocketTimeoutException
    //   716	723	1167	java/net/SocketTimeoutException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.c.f.b
 * JD-Core Version:    0.7.0.1
 */