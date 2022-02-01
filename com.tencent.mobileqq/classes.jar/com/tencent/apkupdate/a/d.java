package com.tencent.apkupdate.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;

public final class d
{
  private final byte[] a = new byte[4096];
  
  private void a(b paramb, DataInputStream paramDataInputStream, DataOutputStream paramDataOutputStream)
  {
    f.a(paramb, paramDataOutputStream);
    int i = paramb.h;
    int j;
    for (;;)
    {
      j = 0;
      if (i <= 0) {
        break;
      }
      j = 4096;
      if (i <= 4096) {
        j = i;
      }
      j = paramDataInputStream.read(this.a, 0, j);
      if (j > 0)
      {
        paramDataOutputStream.write(this.a, 0, j);
        i -= j;
      }
    }
    i = j;
    if ((paramb.c & 0x8) != 0) {
      i = 1;
    }
    if (i != 0) {
      a.a(paramb, paramDataOutputStream);
    }
  }
  
  private void a(b paramb, RandomAccessFile paramRandomAccessFile, g paramg, DataOutputStream paramDataOutputStream)
  {
    String str = new String(paramb.s, "utf-8");
    b localb = (b)paramg.b.get(str);
    if (localb != null)
    {
      paramb.d = localb.d;
      paramb.h = localb.h;
      paramb.g = localb.g;
      paramb.k = localb.k;
      paramb.t = localb.t;
      paramb.l = localb.l;
      paramb.u = localb.u;
      f.a(paramb, paramDataOutputStream);
      int i = paramb.h;
      int k = 0;
      if (i > 0)
      {
        localb = (b)paramg.b.get(str);
        if (localb != null)
        {
          paramg = (f)paramg.a.get(str);
          if (paramg != null)
          {
            paramRandomAccessFile.seek(paramg.b + 30 + paramg.c + localb.q);
            while (i > 0)
            {
              int j = 4096;
              if (i <= 4096) {
                j = i;
              }
              j = paramRandomAccessFile.read(this.a, 0, j);
              if (j > 0)
              {
                paramDataOutputStream.write(this.a, 0, j);
                i -= j;
              }
            }
          }
          throw new FileNotFoundException();
        }
        throw new FileNotFoundException();
      }
      i = k;
      if ((paramb.c & 0x8) != 0) {
        i = 1;
      }
      if (i != 0) {
        a.a(paramb, paramDataOutputStream);
      }
      return;
    }
    paramb = new Exception();
    for (;;)
    {
      throw paramb;
    }
  }
  
  public static int b(String paramString1, String paramString2, String paramString3)
  {
    PackageManager localPackageManager = com.tencent.apkupdate.logic.protocol.a.a().b().getPackageManager();
    try
    {
      paramString1 = localPackageManager.getPackageInfo(paramString1, 0);
      if (paramString1 == null) {
        return -1;
      }
      paramString1 = paramString1.applicationInfo.sourceDir;
      int j = new d().a(paramString1, paramString2, paramString3);
      int i = j;
      if (j == 0)
      {
        i = j;
        if (localPackageManager.getPackageArchiveInfo(paramString3, 1) == null) {
          i = -11;
        }
      }
      return i;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  /* Error */
  public final int a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 158
    //   2: ldc 160
    //   4: invokestatic 166	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: aconst_null
    //   9: astore 14
    //   11: aconst_null
    //   12: astore 13
    //   14: iconst_0
    //   15: istore 6
    //   17: iconst_0
    //   18: istore 5
    //   20: new 57	com/tencent/apkupdate/a/g
    //   23: dup
    //   24: invokespecial 167	com/tencent/apkupdate/a/g:<init>	()V
    //   27: astore 15
    //   29: aload 15
    //   31: aload_1
    //   32: invokevirtual 170	com/tencent/apkupdate/a/g:a	(Ljava/lang/String;)V
    //   35: ldc 158
    //   37: ldc 172
    //   39: invokestatic 166	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: new 27	java/io/DataInputStream
    //   46: dup
    //   47: new 174	java/io/BufferedInputStream
    //   50: dup
    //   51: new 176	java/io/FileInputStream
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   59: invokespecial 181	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: invokespecial 182	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore_2
    //   66: new 33	java/io/DataOutputStream
    //   69: dup
    //   70: new 184	java/io/BufferedOutputStream
    //   73: dup
    //   74: new 186	java/io/FileOutputStream
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 187	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 190	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   85: invokespecial 191	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   88: astore 9
    //   90: aload 14
    //   92: astore 12
    //   94: aload_2
    //   95: astore 10
    //   97: aload 9
    //   99: astore 11
    //   101: new 95	java/io/RandomAccessFile
    //   104: dup
    //   105: aload_1
    //   106: ldc 193
    //   108: invokespecial 196	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: astore_1
    //   112: new 198	java/util/LinkedList
    //   115: dup
    //   116: invokespecial 199	java/util/LinkedList:<init>	()V
    //   119: astore_3
    //   120: aload_2
    //   121: invokevirtual 203	java/io/DataInputStream:readInt	()I
    //   124: istore 7
    //   126: iconst_0
    //   127: istore 4
    //   129: iload 4
    //   131: iload 7
    //   133: if_icmpge +352 -> 485
    //   136: new 21	com/tencent/apkupdate/a/b
    //   139: dup
    //   140: invokespecial 204	com/tencent/apkupdate/a/b:<init>	()V
    //   143: astore 10
    //   145: aload 10
    //   147: aload_2
    //   148: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   151: putfield 210	com/tencent/apkupdate/a/b:a	S
    //   154: aload 10
    //   156: aload_2
    //   157: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   160: putfield 211	com/tencent/apkupdate/a/b:b	S
    //   163: aload 10
    //   165: aload_2
    //   166: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   169: putfield 41	com/tencent/apkupdate/a/b:c	S
    //   172: aload 10
    //   174: aload_2
    //   175: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   178: putfield 70	com/tencent/apkupdate/a/b:d	S
    //   181: aload 10
    //   183: aload_2
    //   184: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   187: putfield 214	com/tencent/apkupdate/a/b:e	S
    //   190: aload 10
    //   192: aload_2
    //   193: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   196: putfield 217	com/tencent/apkupdate/a/b:f	S
    //   199: aload 10
    //   201: aload_2
    //   202: invokevirtual 203	java/io/DataInputStream:readInt	()I
    //   205: putfield 73	com/tencent/apkupdate/a/b:g	I
    //   208: aload 10
    //   210: aload_2
    //   211: invokevirtual 203	java/io/DataInputStream:readInt	()I
    //   214: putfield 25	com/tencent/apkupdate/a/b:h	I
    //   217: aload 10
    //   219: aload_2
    //   220: invokevirtual 203	java/io/DataInputStream:readInt	()I
    //   223: putfield 219	com/tencent/apkupdate/a/b:i	I
    //   226: aload 10
    //   228: aload_2
    //   229: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   232: putfield 222	com/tencent/apkupdate/a/b:j	S
    //   235: aload 10
    //   237: aload_2
    //   238: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   241: putfield 76	com/tencent/apkupdate/a/b:k	S
    //   244: aload 10
    //   246: aload_2
    //   247: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   250: putfield 82	com/tencent/apkupdate/a/b:l	S
    //   253: aload 10
    //   255: aload_2
    //   256: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   259: putfield 225	com/tencent/apkupdate/a/b:m	S
    //   262: aload 10
    //   264: aload_2
    //   265: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   268: putfield 228	com/tencent/apkupdate/a/b:n	S
    //   271: aload 10
    //   273: aload_2
    //   274: invokevirtual 208	java/io/DataInputStream:readShort	()S
    //   277: putfield 231	com/tencent/apkupdate/a/b:o	S
    //   280: aload 10
    //   282: aload_2
    //   283: invokevirtual 203	java/io/DataInputStream:readInt	()I
    //   286: putfield 234	com/tencent/apkupdate/a/b:p	I
    //   289: aload 10
    //   291: aload_2
    //   292: invokevirtual 203	java/io/DataInputStream:readInt	()I
    //   295: putfield 93	com/tencent/apkupdate/a/b:q	I
    //   298: aload 10
    //   300: aload_2
    //   301: invokevirtual 238	java/io/DataInputStream:readBoolean	()Z
    //   304: putfield 241	com/tencent/apkupdate/a/b:r	Z
    //   307: aload 10
    //   309: aload 10
    //   311: getfield 222	com/tencent/apkupdate/a/b:j	S
    //   314: newarray byte
    //   316: putfield 50	com/tencent/apkupdate/a/b:s	[B
    //   319: aload 10
    //   321: aload 10
    //   323: getfield 76	com/tencent/apkupdate/a/b:k	S
    //   326: newarray byte
    //   328: putfield 79	com/tencent/apkupdate/a/b:t	[B
    //   331: aload 10
    //   333: aload 10
    //   335: getfield 82	com/tencent/apkupdate/a/b:l	S
    //   338: newarray byte
    //   340: putfield 85	com/tencent/apkupdate/a/b:u	[B
    //   343: aload 10
    //   345: aload 10
    //   347: getfield 225	com/tencent/apkupdate/a/b:m	S
    //   350: newarray byte
    //   352: putfield 244	com/tencent/apkupdate/a/b:v	[B
    //   355: aload_2
    //   356: aload 10
    //   358: getfield 50	com/tencent/apkupdate/a/b:s	[B
    //   361: iconst_0
    //   362: aload 10
    //   364: getfield 222	com/tencent/apkupdate/a/b:j	S
    //   367: invokevirtual 31	java/io/DataInputStream:read	([BII)I
    //   370: pop
    //   371: aload_2
    //   372: aload 10
    //   374: getfield 79	com/tencent/apkupdate/a/b:t	[B
    //   377: iconst_0
    //   378: aload 10
    //   380: getfield 76	com/tencent/apkupdate/a/b:k	S
    //   383: invokevirtual 31	java/io/DataInputStream:read	([BII)I
    //   386: pop
    //   387: aload_2
    //   388: aload 10
    //   390: getfield 85	com/tencent/apkupdate/a/b:u	[B
    //   393: iconst_0
    //   394: aload 10
    //   396: getfield 82	com/tencent/apkupdate/a/b:l	S
    //   399: invokevirtual 31	java/io/DataInputStream:read	([BII)I
    //   402: pop
    //   403: aload_2
    //   404: aload 10
    //   406: getfield 244	com/tencent/apkupdate/a/b:v	[B
    //   409: iconst_0
    //   410: aload 10
    //   412: getfield 225	com/tencent/apkupdate/a/b:m	S
    //   415: invokevirtual 31	java/io/DataInputStream:read	([BII)I
    //   418: pop
    //   419: aload_3
    //   420: aload 10
    //   422: invokevirtual 248	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   425: pop
    //   426: iload 4
    //   428: iconst_1
    //   429: iadd
    //   430: istore 4
    //   432: goto -303 -> 129
    //   435: astore_3
    //   436: aload_3
    //   437: invokevirtual 249	java/lang/ClassNotFoundException:printStackTrace	()V
    //   440: new 152	java/lang/Throwable
    //   443: dup
    //   444: invokespecial 250	java/lang/Throwable:<init>	()V
    //   447: athrow
    //   448: bipush 250
    //   450: istore 4
    //   452: aload_2
    //   453: astore_3
    //   454: aload 9
    //   456: astore_2
    //   457: goto +1263 -> 1720
    //   460: astore_3
    //   461: aload_3
    //   462: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   465: new 152	java/lang/Throwable
    //   468: dup
    //   469: invokespecial 250	java/lang/Throwable:<init>	()V
    //   472: athrow
    //   473: bipush 251
    //   475: istore 4
    //   477: aload_2
    //   478: astore_3
    //   479: aload 9
    //   481: astore_2
    //   482: goto +1238 -> 1720
    //   485: ldc 158
    //   487: ldc 253
    //   489: invokestatic 166	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   492: pop
    //   493: aload_3
    //   494: invokevirtual 257	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   497: astore 10
    //   499: aload 10
    //   501: invokeinterface 262 1 0
    //   506: ifeq +55 -> 561
    //   509: aload 10
    //   511: invokeinterface 266 1 0
    //   516: checkcast 21	com/tencent/apkupdate/a/b
    //   519: astore 11
    //   521: aload 11
    //   523: iconst_0
    //   524: putfield 41	com/tencent/apkupdate/a/b:c	S
    //   527: aload 11
    //   529: getfield 241	com/tencent/apkupdate/a/b:r	Z
    //   532: ifeq +15 -> 547
    //   535: aload_0
    //   536: aload 11
    //   538: aload_2
    //   539: aload 9
    //   541: invokespecial 268	com/tencent/apkupdate/a/d:a	(Lcom/tencent/apkupdate/a/b;Ljava/io/DataInputStream;Ljava/io/DataOutputStream;)V
    //   544: goto -45 -> 499
    //   547: aload_0
    //   548: aload 11
    //   550: aload_1
    //   551: aload 15
    //   553: aload 9
    //   555: invokespecial 270	com/tencent/apkupdate/a/d:a	(Lcom/tencent/apkupdate/a/b;Ljava/io/RandomAccessFile;Lcom/tencent/apkupdate/a/g;Ljava/io/DataOutputStream;)V
    //   558: goto -59 -> 499
    //   561: ldc 158
    //   563: ldc_w 272
    //   566: invokestatic 166	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   569: pop
    //   570: aload 9
    //   572: invokevirtual 275	java/io/DataOutputStream:size	()I
    //   575: istore 4
    //   577: aload_3
    //   578: invokevirtual 257	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   581: astore_3
    //   582: aload_3
    //   583: invokeinterface 262 1 0
    //   588: ifeq +496 -> 1084
    //   591: aload_3
    //   592: invokeinterface 266 1 0
    //   597: checkcast 21	com/tencent/apkupdate/a/b
    //   600: astore 10
    //   602: aload 9
    //   604: ldc_w 276
    //   607: invokevirtual 280	java/io/DataOutputStream:writeInt	(I)V
    //   610: aload 10
    //   612: getfield 210	com/tencent/apkupdate/a/b:a	S
    //   615: istore 7
    //   617: aload 9
    //   619: iload 7
    //   621: bipush 8
    //   623: ishr
    //   624: sipush 255
    //   627: iand
    //   628: iload 7
    //   630: sipush 255
    //   633: iand
    //   634: bipush 8
    //   636: ishl
    //   637: ior
    //   638: i2s
    //   639: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   642: aload 10
    //   644: getfield 211	com/tencent/apkupdate/a/b:b	S
    //   647: istore 7
    //   649: aload 9
    //   651: iload 7
    //   653: bipush 8
    //   655: ishr
    //   656: sipush 255
    //   659: iand
    //   660: iload 7
    //   662: sipush 255
    //   665: iand
    //   666: bipush 8
    //   668: ishl
    //   669: ior
    //   670: i2s
    //   671: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   674: aload 10
    //   676: getfield 41	com/tencent/apkupdate/a/b:c	S
    //   679: istore 7
    //   681: aload 9
    //   683: iload 7
    //   685: bipush 8
    //   687: ishr
    //   688: sipush 255
    //   691: iand
    //   692: iload 7
    //   694: sipush 255
    //   697: iand
    //   698: bipush 8
    //   700: ishl
    //   701: ior
    //   702: i2s
    //   703: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   706: aload 10
    //   708: getfield 70	com/tencent/apkupdate/a/b:d	S
    //   711: istore 7
    //   713: aload 9
    //   715: iload 7
    //   717: bipush 8
    //   719: ishr
    //   720: sipush 255
    //   723: iand
    //   724: iload 7
    //   726: sipush 255
    //   729: iand
    //   730: bipush 8
    //   732: ishl
    //   733: ior
    //   734: i2s
    //   735: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   738: aload 10
    //   740: getfield 214	com/tencent/apkupdate/a/b:e	S
    //   743: istore 7
    //   745: aload 9
    //   747: iload 7
    //   749: bipush 8
    //   751: ishr
    //   752: sipush 255
    //   755: iand
    //   756: iload 7
    //   758: sipush 255
    //   761: iand
    //   762: bipush 8
    //   764: ishl
    //   765: ior
    //   766: i2s
    //   767: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   770: aload 10
    //   772: getfield 217	com/tencent/apkupdate/a/b:f	S
    //   775: istore 7
    //   777: aload 9
    //   779: iload 7
    //   781: bipush 8
    //   783: ishr
    //   784: sipush 255
    //   787: iand
    //   788: iload 7
    //   790: sipush 255
    //   793: iand
    //   794: bipush 8
    //   796: ishl
    //   797: ior
    //   798: i2s
    //   799: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   802: aload 9
    //   804: aload 10
    //   806: getfield 73	com/tencent/apkupdate/a/b:g	I
    //   809: invokestatic 286	com/tencent/apkupdate/a/a:a	(I)I
    //   812: invokevirtual 280	java/io/DataOutputStream:writeInt	(I)V
    //   815: aload 9
    //   817: aload 10
    //   819: getfield 25	com/tencent/apkupdate/a/b:h	I
    //   822: invokestatic 286	com/tencent/apkupdate/a/a:a	(I)I
    //   825: invokevirtual 280	java/io/DataOutputStream:writeInt	(I)V
    //   828: aload 9
    //   830: aload 10
    //   832: getfield 219	com/tencent/apkupdate/a/b:i	I
    //   835: invokestatic 286	com/tencent/apkupdate/a/a:a	(I)I
    //   838: invokevirtual 280	java/io/DataOutputStream:writeInt	(I)V
    //   841: aload 10
    //   843: getfield 222	com/tencent/apkupdate/a/b:j	S
    //   846: istore 7
    //   848: aload 9
    //   850: iload 7
    //   852: bipush 8
    //   854: ishr
    //   855: sipush 255
    //   858: iand
    //   859: iload 7
    //   861: sipush 255
    //   864: iand
    //   865: bipush 8
    //   867: ishl
    //   868: ior
    //   869: i2s
    //   870: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   873: aload 10
    //   875: getfield 82	com/tencent/apkupdate/a/b:l	S
    //   878: istore 7
    //   880: aload 9
    //   882: iload 7
    //   884: bipush 8
    //   886: ishr
    //   887: sipush 255
    //   890: iand
    //   891: iload 7
    //   893: sipush 255
    //   896: iand
    //   897: bipush 8
    //   899: ishl
    //   900: ior
    //   901: i2s
    //   902: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   905: aload 10
    //   907: getfield 225	com/tencent/apkupdate/a/b:m	S
    //   910: istore 7
    //   912: aload 9
    //   914: iload 7
    //   916: bipush 8
    //   918: ishr
    //   919: sipush 255
    //   922: iand
    //   923: iload 7
    //   925: sipush 255
    //   928: iand
    //   929: bipush 8
    //   931: ishl
    //   932: ior
    //   933: i2s
    //   934: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   937: aload 10
    //   939: getfield 228	com/tencent/apkupdate/a/b:n	S
    //   942: istore 7
    //   944: aload 9
    //   946: iload 7
    //   948: bipush 8
    //   950: ishr
    //   951: sipush 255
    //   954: iand
    //   955: iload 7
    //   957: sipush 255
    //   960: iand
    //   961: bipush 8
    //   963: ishl
    //   964: ior
    //   965: i2s
    //   966: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   969: aload 10
    //   971: getfield 231	com/tencent/apkupdate/a/b:o	S
    //   974: istore 7
    //   976: aload 9
    //   978: iload 7
    //   980: bipush 8
    //   982: ishr
    //   983: sipush 255
    //   986: iand
    //   987: iload 7
    //   989: sipush 255
    //   992: iand
    //   993: bipush 8
    //   995: ishl
    //   996: ior
    //   997: i2s
    //   998: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   1001: aload 9
    //   1003: aload 10
    //   1005: getfield 234	com/tencent/apkupdate/a/b:p	I
    //   1008: invokestatic 286	com/tencent/apkupdate/a/a:a	(I)I
    //   1011: invokevirtual 280	java/io/DataOutputStream:writeInt	(I)V
    //   1014: aload 9
    //   1016: aload 10
    //   1018: getfield 93	com/tencent/apkupdate/a/b:q	I
    //   1021: invokestatic 286	com/tencent/apkupdate/a/a:a	(I)I
    //   1024: invokevirtual 280	java/io/DataOutputStream:writeInt	(I)V
    //   1027: aload 10
    //   1029: getfield 222	com/tencent/apkupdate/a/b:j	S
    //   1032: ifle +13 -> 1045
    //   1035: aload 9
    //   1037: aload 10
    //   1039: getfield 50	com/tencent/apkupdate/a/b:s	[B
    //   1042: invokevirtual 289	java/io/DataOutputStream:write	([B)V
    //   1045: aload 10
    //   1047: getfield 82	com/tencent/apkupdate/a/b:l	S
    //   1050: ifle +13 -> 1063
    //   1053: aload 9
    //   1055: aload 10
    //   1057: getfield 85	com/tencent/apkupdate/a/b:u	[B
    //   1060: invokevirtual 289	java/io/DataOutputStream:write	([B)V
    //   1063: aload 10
    //   1065: getfield 225	com/tencent/apkupdate/a/b:m	S
    //   1068: ifle -486 -> 582
    //   1071: aload 9
    //   1073: aload 10
    //   1075: getfield 244	com/tencent/apkupdate/a/b:v	[B
    //   1078: invokevirtual 289	java/io/DataOutputStream:write	([B)V
    //   1081: goto -499 -> 582
    //   1084: aload_2
    //   1085: invokevirtual 203	java/io/DataInputStream:readInt	()I
    //   1088: istore 7
    //   1090: aload 9
    //   1092: invokevirtual 275	java/io/DataOutputStream:size	()I
    //   1095: istore 8
    //   1097: iload 7
    //   1099: ldc_w 290
    //   1102: if_icmpne +282 -> 1384
    //   1105: new 292	com/tencent/apkupdate/a/c
    //   1108: dup
    //   1109: invokespecial 293	com/tencent/apkupdate/a/c:<init>	()V
    //   1112: astore_3
    //   1113: aload_3
    //   1114: aload_2
    //   1115: invokevirtual 296	com/tencent/apkupdate/a/c:a	(Ljava/io/DataInputStream;)V
    //   1118: aload_3
    //   1119: iload 4
    //   1121: putfield 298	com/tencent/apkupdate/a/c:f	I
    //   1124: aload_3
    //   1125: iload 8
    //   1127: iload 4
    //   1129: isub
    //   1130: putfield 300	com/tencent/apkupdate/a/c:e	I
    //   1133: aload 9
    //   1135: ldc_w 290
    //   1138: invokevirtual 280	java/io/DataOutputStream:writeInt	(I)V
    //   1141: aload_3
    //   1142: getfield 301	com/tencent/apkupdate/a/c:a	S
    //   1145: istore 4
    //   1147: aload 9
    //   1149: iload 4
    //   1151: bipush 8
    //   1153: ishr
    //   1154: sipush 255
    //   1157: iand
    //   1158: iload 4
    //   1160: sipush 255
    //   1163: iand
    //   1164: bipush 8
    //   1166: ishl
    //   1167: ior
    //   1168: i2s
    //   1169: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   1172: aload_3
    //   1173: getfield 302	com/tencent/apkupdate/a/c:b	S
    //   1176: istore 4
    //   1178: aload 9
    //   1180: iload 4
    //   1182: bipush 8
    //   1184: ishr
    //   1185: sipush 255
    //   1188: iand
    //   1189: iload 4
    //   1191: sipush 255
    //   1194: iand
    //   1195: bipush 8
    //   1197: ishl
    //   1198: ior
    //   1199: i2s
    //   1200: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   1203: aload_3
    //   1204: getfield 303	com/tencent/apkupdate/a/c:c	S
    //   1207: istore 4
    //   1209: aload 9
    //   1211: iload 4
    //   1213: bipush 8
    //   1215: ishr
    //   1216: sipush 255
    //   1219: iand
    //   1220: iload 4
    //   1222: sipush 255
    //   1225: iand
    //   1226: bipush 8
    //   1228: ishl
    //   1229: ior
    //   1230: i2s
    //   1231: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   1234: aload_3
    //   1235: getfield 304	com/tencent/apkupdate/a/c:d	S
    //   1238: istore 4
    //   1240: aload 9
    //   1242: iload 4
    //   1244: bipush 8
    //   1246: ishr
    //   1247: sipush 255
    //   1250: iand
    //   1251: iload 4
    //   1253: sipush 255
    //   1256: iand
    //   1257: bipush 8
    //   1259: ishl
    //   1260: ior
    //   1261: i2s
    //   1262: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   1265: aload 9
    //   1267: aload_3
    //   1268: getfield 300	com/tencent/apkupdate/a/c:e	I
    //   1271: invokestatic 286	com/tencent/apkupdate/a/a:a	(I)I
    //   1274: invokevirtual 280	java/io/DataOutputStream:writeInt	(I)V
    //   1277: aload 9
    //   1279: aload_3
    //   1280: getfield 298	com/tencent/apkupdate/a/c:f	I
    //   1283: invokestatic 286	com/tencent/apkupdate/a/a:a	(I)I
    //   1286: invokevirtual 280	java/io/DataOutputStream:writeInt	(I)V
    //   1289: aload_3
    //   1290: getfield 306	com/tencent/apkupdate/a/c:g	S
    //   1293: istore 4
    //   1295: aload 9
    //   1297: iload 4
    //   1299: bipush 8
    //   1301: ishr
    //   1302: sipush 255
    //   1305: iand
    //   1306: iload 4
    //   1308: sipush 255
    //   1311: iand
    //   1312: bipush 8
    //   1314: ishl
    //   1315: ior
    //   1316: i2s
    //   1317: invokevirtual 283	java/io/DataOutputStream:writeShort	(I)V
    //   1320: aload_3
    //   1321: getfield 306	com/tencent/apkupdate/a/c:g	S
    //   1324: ifle +12 -> 1336
    //   1327: aload 9
    //   1329: aload_3
    //   1330: getfield 308	com/tencent/apkupdate/a/c:h	[B
    //   1333: invokevirtual 289	java/io/DataOutputStream:write	([B)V
    //   1336: ldc 158
    //   1338: ldc_w 310
    //   1341: invokestatic 166	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1344: pop
    //   1345: aload_1
    //   1346: invokevirtual 313	java/io/RandomAccessFile:close	()V
    //   1349: goto +8 -> 1357
    //   1352: astore_1
    //   1353: aload_1
    //   1354: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1357: aload 9
    //   1359: invokevirtual 314	java/io/DataOutputStream:close	()V
    //   1362: goto +8 -> 1370
    //   1365: astore_1
    //   1366: aload_1
    //   1367: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1370: aload_2
    //   1371: invokevirtual 315	java/io/DataInputStream:close	()V
    //   1374: iconst_0
    //   1375: ireturn
    //   1376: astore_1
    //   1377: aload_1
    //   1378: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1381: iload 5
    //   1383: ireturn
    //   1384: bipush 248
    //   1386: istore 4
    //   1388: new 152	java/lang/Throwable
    //   1391: dup
    //   1392: invokespecial 250	java/lang/Throwable:<init>	()V
    //   1395: athrow
    //   1396: bipush 248
    //   1398: istore 4
    //   1400: aload_2
    //   1401: astore_3
    //   1402: aload 9
    //   1404: astore_2
    //   1405: goto +315 -> 1720
    //   1408: astore_3
    //   1409: goto +7 -> 1416
    //   1412: astore_3
    //   1413: iconst_0
    //   1414: istore 4
    //   1416: aload_3
    //   1417: invokevirtual 316	java/lang/Exception:printStackTrace	()V
    //   1420: new 152	java/lang/Throwable
    //   1423: dup
    //   1424: invokespecial 250	java/lang/Throwable:<init>	()V
    //   1427: athrow
    //   1428: bipush 247
    //   1430: istore 4
    //   1432: aload_2
    //   1433: astore_3
    //   1434: aload 9
    //   1436: astore_2
    //   1437: goto +283 -> 1720
    //   1440: aload_2
    //   1441: astore_3
    //   1442: aload 9
    //   1444: astore_2
    //   1445: goto +275 -> 1720
    //   1448: astore_3
    //   1449: aload_3
    //   1450: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1453: new 152	java/lang/Throwable
    //   1456: dup
    //   1457: invokespecial 250	java/lang/Throwable:<init>	()V
    //   1460: athrow
    //   1461: bipush 249
    //   1463: istore 4
    //   1465: aload_2
    //   1466: astore_3
    //   1467: aload 9
    //   1469: astore_2
    //   1470: goto +250 -> 1720
    //   1473: astore_3
    //   1474: aload_3
    //   1475: invokevirtual 316	java/lang/Exception:printStackTrace	()V
    //   1478: new 152	java/lang/Throwable
    //   1481: dup
    //   1482: invokespecial 250	java/lang/Throwable:<init>	()V
    //   1485: athrow
    //   1486: bipush 246
    //   1488: istore 4
    //   1490: aload_2
    //   1491: astore_3
    //   1492: aload 9
    //   1494: astore_2
    //   1495: goto +225 -> 1720
    //   1498: astore_3
    //   1499: aload_3
    //   1500: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1503: new 152	java/lang/Throwable
    //   1506: dup
    //   1507: invokespecial 250	java/lang/Throwable:<init>	()V
    //   1510: athrow
    //   1511: bipush 252
    //   1513: istore 4
    //   1515: aload_2
    //   1516: astore_3
    //   1517: aload 9
    //   1519: astore_2
    //   1520: goto +200 -> 1720
    //   1523: astore_3
    //   1524: aload_2
    //   1525: astore 10
    //   1527: aload_3
    //   1528: astore_2
    //   1529: goto +304 -> 1833
    //   1532: iload 6
    //   1534: istore 4
    //   1536: aload_2
    //   1537: astore_3
    //   1538: aload 9
    //   1540: astore_2
    //   1541: goto +179 -> 1720
    //   1544: astore_1
    //   1545: aload 14
    //   1547: astore 12
    //   1549: aload_2
    //   1550: astore 10
    //   1552: aload 9
    //   1554: astore 11
    //   1556: aload_1
    //   1557: invokevirtual 317	java/io/FileNotFoundException:printStackTrace	()V
    //   1560: aload 14
    //   1562: astore 12
    //   1564: aload_2
    //   1565: astore 10
    //   1567: aload 9
    //   1569: astore 11
    //   1571: new 152	java/lang/Throwable
    //   1574: dup
    //   1575: invokespecial 250	java/lang/Throwable:<init>	()V
    //   1578: athrow
    //   1579: astore_3
    //   1580: aconst_null
    //   1581: astore 9
    //   1583: aload 9
    //   1585: astore_1
    //   1586: aload_2
    //   1587: astore 10
    //   1589: aload_3
    //   1590: astore_2
    //   1591: goto +242 -> 1833
    //   1594: aconst_null
    //   1595: astore 9
    //   1597: aload 13
    //   1599: astore_1
    //   1600: iload 6
    //   1602: istore 4
    //   1604: aload_2
    //   1605: astore_3
    //   1606: aload 9
    //   1608: astore_2
    //   1609: goto +111 -> 1720
    //   1612: astore_1
    //   1613: aload_1
    //   1614: invokevirtual 317	java/io/FileNotFoundException:printStackTrace	()V
    //   1617: new 152	java/lang/Throwable
    //   1620: dup
    //   1621: invokespecial 250	java/lang/Throwable:<init>	()V
    //   1624: athrow
    //   1625: aconst_null
    //   1626: astore 9
    //   1628: bipush 253
    //   1630: istore 4
    //   1632: aload 13
    //   1634: astore_1
    //   1635: aload_2
    //   1636: astore_3
    //   1637: aload 9
    //   1639: astore_2
    //   1640: goto +80 -> 1720
    //   1643: astore_1
    //   1644: aload_1
    //   1645: invokevirtual 317	java/io/FileNotFoundException:printStackTrace	()V
    //   1648: new 152	java/lang/Throwable
    //   1651: dup
    //   1652: invokespecial 250	java/lang/Throwable:<init>	()V
    //   1655: athrow
    //   1656: aconst_null
    //   1657: astore_2
    //   1658: aload_2
    //   1659: astore_3
    //   1660: bipush 254
    //   1662: istore 4
    //   1664: aload 13
    //   1666: astore_1
    //   1667: goto +53 -> 1720
    //   1670: astore_1
    //   1671: aload_1
    //   1672: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1675: new 152	java/lang/Throwable
    //   1678: dup
    //   1679: invokespecial 250	java/lang/Throwable:<init>	()V
    //   1682: athrow
    //   1683: aconst_null
    //   1684: astore_2
    //   1685: aload_2
    //   1686: astore_3
    //   1687: iconst_m1
    //   1688: istore 4
    //   1690: aload 13
    //   1692: astore_1
    //   1693: goto +27 -> 1720
    //   1696: astore_2
    //   1697: aconst_null
    //   1698: astore 9
    //   1700: aload 9
    //   1702: astore_1
    //   1703: aload_1
    //   1704: astore 10
    //   1706: goto +127 -> 1833
    //   1709: aconst_null
    //   1710: astore_2
    //   1711: aload_2
    //   1712: astore_3
    //   1713: iload 6
    //   1715: istore 4
    //   1717: aload 13
    //   1719: astore_1
    //   1720: aload_1
    //   1721: astore 12
    //   1723: aload_3
    //   1724: astore 10
    //   1726: aload_2
    //   1727: astore 11
    //   1729: new 319	java/lang/StringBuilder
    //   1732: dup
    //   1733: ldc_w 321
    //   1736: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1739: astore 9
    //   1741: aload_1
    //   1742: astore 12
    //   1744: aload_3
    //   1745: astore 10
    //   1747: aload_2
    //   1748: astore 11
    //   1750: aload 9
    //   1752: iload 4
    //   1754: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1757: pop
    //   1758: aload_1
    //   1759: astore 12
    //   1761: aload_3
    //   1762: astore 10
    //   1764: aload_2
    //   1765: astore 11
    //   1767: ldc 158
    //   1769: aload 9
    //   1771: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: invokestatic 166	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1777: pop
    //   1778: aload_1
    //   1779: ifnull +15 -> 1794
    //   1782: aload_1
    //   1783: invokevirtual 313	java/io/RandomAccessFile:close	()V
    //   1786: goto +8 -> 1794
    //   1789: astore_1
    //   1790: aload_1
    //   1791: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1794: aload_2
    //   1795: ifnull +15 -> 1810
    //   1798: aload_2
    //   1799: invokevirtual 314	java/io/DataOutputStream:close	()V
    //   1802: goto +8 -> 1810
    //   1805: astore_1
    //   1806: aload_1
    //   1807: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1810: aload_3
    //   1811: ifnull +11 -> 1822
    //   1814: iload 4
    //   1816: istore 5
    //   1818: aload_3
    //   1819: invokevirtual 315	java/io/DataInputStream:close	()V
    //   1822: iload 4
    //   1824: ireturn
    //   1825: astore_2
    //   1826: aload 12
    //   1828: astore_1
    //   1829: aload 11
    //   1831: astore 9
    //   1833: aload_1
    //   1834: ifnull +15 -> 1849
    //   1837: aload_1
    //   1838: invokevirtual 313	java/io/RandomAccessFile:close	()V
    //   1841: goto +8 -> 1849
    //   1844: astore_1
    //   1845: aload_1
    //   1846: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1849: aload 9
    //   1851: ifnull +16 -> 1867
    //   1854: aload 9
    //   1856: invokevirtual 314	java/io/DataOutputStream:close	()V
    //   1859: goto +8 -> 1867
    //   1862: astore_1
    //   1863: aload_1
    //   1864: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1867: aload 10
    //   1869: ifnull +16 -> 1885
    //   1872: aload 10
    //   1874: invokevirtual 315	java/io/DataInputStream:close	()V
    //   1877: goto +8 -> 1885
    //   1880: astore_1
    //   1881: aload_1
    //   1882: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1885: goto +5 -> 1890
    //   1888: aload_2
    //   1889: athrow
    //   1890: goto -2 -> 1888
    //   1893: astore_1
    //   1894: goto -185 -> 1709
    //   1897: astore_1
    //   1898: goto -304 -> 1594
    //   1901: astore_1
    //   1902: aload 13
    //   1904: astore_1
    //   1905: iload 6
    //   1907: istore 4
    //   1909: aload_2
    //   1910: astore_3
    //   1911: aload 9
    //   1913: astore_2
    //   1914: goto -194 -> 1720
    //   1917: astore_3
    //   1918: goto -386 -> 1532
    //   1921: astore_3
    //   1922: goto -1474 -> 448
    //   1925: astore_3
    //   1926: goto -1453 -> 473
    //   1929: astore_3
    //   1930: goto -534 -> 1396
    //   1933: astore_3
    //   1934: goto -494 -> 1440
    //   1937: astore_3
    //   1938: goto -510 -> 1428
    //   1941: astore_3
    //   1942: goto -481 -> 1461
    //   1945: astore_3
    //   1946: goto -460 -> 1486
    //   1949: astore_3
    //   1950: goto -439 -> 1511
    //   1953: astore_1
    //   1954: aload_2
    //   1955: astore_3
    //   1956: aload 9
    //   1958: astore_2
    //   1959: goto -272 -> 1687
    //   1962: astore_1
    //   1963: goto -338 -> 1625
    //   1966: astore_1
    //   1967: goto -311 -> 1656
    //   1970: astore_1
    //   1971: goto -288 -> 1683
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1974	0	this	d
    //   0	1974	1	paramString1	String
    //   0	1974	2	paramString2	String
    //   0	1974	3	paramString3	String
    //   127	1781	4	i	int
    //   18	1799	5	j	int
    //   15	1891	6	k	int
    //   124	979	7	m	int
    //   1095	35	8	n	int
    //   88	1869	9	localObject1	Object
    //   95	1778	10	localObject2	Object
    //   99	1731	11	localObject3	Object
    //   92	1735	12	localObject4	Object
    //   12	1891	13	localObject5	Object
    //   9	1552	14	localObject6	Object
    //   27	525	15	localg	g
    // Exception table:
    //   from	to	target	type
    //   136	426	435	java/lang/ClassNotFoundException
    //   136	426	460	java/io/IOException
    //   1345	1349	1352	java/io/IOException
    //   1357	1362	1365	java/io/IOException
    //   1370	1374	1376	java/io/IOException
    //   1818	1822	1376	java/io/IOException
    //   1388	1396	1408	java/lang/Exception
    //   1084	1097	1412	java/lang/Exception
    //   1105	1336	1412	java/lang/Exception
    //   577	582	1448	java/io/IOException
    //   582	1045	1448	java/io/IOException
    //   1045	1063	1448	java/io/IOException
    //   1063	1081	1448	java/io/IOException
    //   493	499	1473	java/lang/Exception
    //   499	544	1473	java/lang/Exception
    //   547	558	1473	java/lang/Exception
    //   120	126	1498	java/io/IOException
    //   112	120	1523	finally
    //   120	126	1523	finally
    //   136	426	1523	finally
    //   436	440	1523	finally
    //   440	448	1523	finally
    //   461	465	1523	finally
    //   465	473	1523	finally
    //   485	493	1523	finally
    //   493	499	1523	finally
    //   499	544	1523	finally
    //   547	558	1523	finally
    //   561	577	1523	finally
    //   577	582	1523	finally
    //   582	1045	1523	finally
    //   1045	1063	1523	finally
    //   1063	1081	1523	finally
    //   1084	1097	1523	finally
    //   1105	1336	1523	finally
    //   1336	1345	1523	finally
    //   1388	1396	1523	finally
    //   1416	1420	1523	finally
    //   1420	1428	1523	finally
    //   1449	1453	1523	finally
    //   1453	1461	1523	finally
    //   1474	1478	1523	finally
    //   1478	1486	1523	finally
    //   1499	1503	1523	finally
    //   1503	1511	1523	finally
    //   101	112	1544	java/io/FileNotFoundException
    //   66	90	1579	finally
    //   1613	1617	1579	finally
    //   1617	1625	1579	finally
    //   66	90	1612	java/io/FileNotFoundException
    //   43	66	1643	java/io/FileNotFoundException
    //   29	35	1670	java/io/IOException
    //   20	29	1696	finally
    //   29	35	1696	finally
    //   35	43	1696	finally
    //   43	66	1696	finally
    //   1644	1648	1696	finally
    //   1648	1656	1696	finally
    //   1671	1675	1696	finally
    //   1675	1683	1696	finally
    //   1782	1786	1789	java/io/IOException
    //   1798	1802	1805	java/io/IOException
    //   101	112	1825	finally
    //   1556	1560	1825	finally
    //   1571	1579	1825	finally
    //   1729	1741	1825	finally
    //   1750	1758	1825	finally
    //   1767	1778	1825	finally
    //   1837	1841	1844	java/io/IOException
    //   1854	1859	1862	java/io/IOException
    //   1872	1877	1880	java/io/IOException
    //   20	29	1893	java/lang/Throwable
    //   29	35	1893	java/lang/Throwable
    //   35	43	1893	java/lang/Throwable
    //   43	66	1893	java/lang/Throwable
    //   1644	1648	1893	java/lang/Throwable
    //   1671	1675	1893	java/lang/Throwable
    //   66	90	1897	java/lang/Throwable
    //   1613	1617	1897	java/lang/Throwable
    //   101	112	1901	java/lang/Throwable
    //   1556	1560	1901	java/lang/Throwable
    //   112	120	1917	java/lang/Throwable
    //   120	126	1917	java/lang/Throwable
    //   136	426	1917	java/lang/Throwable
    //   436	440	1917	java/lang/Throwable
    //   461	465	1917	java/lang/Throwable
    //   485	493	1917	java/lang/Throwable
    //   493	499	1917	java/lang/Throwable
    //   499	544	1917	java/lang/Throwable
    //   547	558	1917	java/lang/Throwable
    //   561	577	1917	java/lang/Throwable
    //   577	582	1917	java/lang/Throwable
    //   582	1045	1917	java/lang/Throwable
    //   1045	1063	1917	java/lang/Throwable
    //   1063	1081	1917	java/lang/Throwable
    //   1084	1097	1917	java/lang/Throwable
    //   1105	1336	1917	java/lang/Throwable
    //   1336	1345	1917	java/lang/Throwable
    //   1449	1453	1917	java/lang/Throwable
    //   1474	1478	1917	java/lang/Throwable
    //   1499	1503	1917	java/lang/Throwable
    //   440	448	1921	java/lang/Throwable
    //   465	473	1925	java/lang/Throwable
    //   1388	1396	1929	java/lang/Throwable
    //   1416	1420	1933	java/lang/Throwable
    //   1420	1428	1937	java/lang/Throwable
    //   1453	1461	1941	java/lang/Throwable
    //   1478	1486	1945	java/lang/Throwable
    //   1503	1511	1949	java/lang/Throwable
    //   1571	1579	1953	java/lang/Throwable
    //   1617	1625	1962	java/lang/Throwable
    //   1648	1656	1966	java/lang/Throwable
    //   1675	1683	1970	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.a.d
 * JD-Core Version:    0.7.0.1
 */