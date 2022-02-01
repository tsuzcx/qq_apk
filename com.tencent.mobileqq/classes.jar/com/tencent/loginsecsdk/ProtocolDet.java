package com.tencent.loginsecsdk;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProtocolDet
{
  private static final String DET_CACHE_FILE_NAME = "pd2.dat";
  private static final int EXTRA_IPV4_DATA_ITEM_SIZE = 21;
  private static final int EXTRA_IPV6_DATA_ITEM_SIZE = 33;
  private static final int IPV4_LEN = 4;
  private static final int IPV6_LEN = 16;
  private static final int MAX_CACHED_FILE_SIZE = 4096;
  private static final int MAX_CACHED_ITEM_COUNT = 3;
  private static byte cNum = 0;
  
  /* Error */
  private static byte[] convertExtraDataListToBuffer(List<ProtocolDet.LoginExtraData> paramList)
  {
    // Byte code:
    //   0: new 37	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 38	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 6
    //   9: new 40	java/io/DataOutputStream
    //   12: dup
    //   13: aload 6
    //   15: invokespecial 43	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 10
    //   20: aload 10
    //   22: astore 8
    //   24: aload 6
    //   26: astore 7
    //   28: aload_0
    //   29: invokeinterface 49 1 0
    //   34: istore_2
    //   35: iconst_0
    //   36: istore_1
    //   37: iload_1
    //   38: iload_2
    //   39: if_icmpge +229 -> 268
    //   42: aload 10
    //   44: astore 8
    //   46: aload 6
    //   48: astore 7
    //   50: aload_0
    //   51: iload_1
    //   52: invokeinterface 53 2 0
    //   57: checkcast 55	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   60: getfield 59	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   63: lstore 4
    //   65: aload 10
    //   67: astore 8
    //   69: aload 6
    //   71: astore 7
    //   73: aload_0
    //   74: iload_1
    //   75: invokeinterface 53 2 0
    //   80: checkcast 55	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   83: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   86: istore_3
    //   87: aload 10
    //   89: astore 8
    //   91: aload 6
    //   93: astore 7
    //   95: aload_0
    //   96: iload_1
    //   97: invokeinterface 53 2 0
    //   102: checkcast 55	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   105: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   108: iconst_4
    //   109: if_icmpeq +29 -> 138
    //   112: aload 10
    //   114: astore 8
    //   116: aload 6
    //   118: astore 7
    //   120: aload_0
    //   121: iload_1
    //   122: invokeinterface 53 2 0
    //   127: checkcast 55	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   130: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   133: bipush 16
    //   135: if_icmpne +117 -> 252
    //   138: aload 10
    //   140: astore 8
    //   142: aload 6
    //   144: astore 7
    //   146: aload 10
    //   148: lload 4
    //   150: invokevirtual 66	java/io/DataOutputStream:writeLong	(J)V
    //   153: aload 10
    //   155: astore 8
    //   157: aload 6
    //   159: astore 7
    //   161: aload 10
    //   163: iload_3
    //   164: invokevirtual 70	java/io/DataOutputStream:writeByte	(I)V
    //   167: aload 10
    //   169: astore 8
    //   171: aload 6
    //   173: astore 7
    //   175: aload 10
    //   177: aload_0
    //   178: iload_1
    //   179: invokeinterface 53 2 0
    //   184: checkcast 55	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   187: getfield 74	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   190: invokevirtual 78	java/io/DataOutputStream:write	([B)V
    //   193: aload 10
    //   195: astore 8
    //   197: aload 6
    //   199: astore 7
    //   201: aload 10
    //   203: aload_0
    //   204: iload_1
    //   205: invokeinterface 53 2 0
    //   210: checkcast 55	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   213: getfield 81	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   216: invokevirtual 84	java/io/DataOutputStream:writeInt	(I)V
    //   219: aload 10
    //   221: astore 8
    //   223: aload 6
    //   225: astore 7
    //   227: aload 10
    //   229: aload_0
    //   230: iload_1
    //   231: invokeinterface 53 2 0
    //   236: checkcast 55	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   239: getfield 87	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   242: invokevirtual 84	java/io/DataOutputStream:writeInt	(I)V
    //   245: iload_1
    //   246: iconst_1
    //   247: iadd
    //   248: istore_1
    //   249: goto -212 -> 37
    //   252: aload 10
    //   254: astore 8
    //   256: aload 6
    //   258: astore 7
    //   260: ldc 89
    //   262: ldc 91
    //   264: invokestatic 97	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   267: pop
    //   268: aload 10
    //   270: astore 8
    //   272: aload 6
    //   274: astore 7
    //   276: aload 6
    //   278: invokevirtual 101	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   281: astore_0
    //   282: aload 6
    //   284: ifnull +8 -> 292
    //   287: aload 6
    //   289: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   292: aload 10
    //   294: ifnull +8 -> 302
    //   297: aload 10
    //   299: invokevirtual 105	java/io/DataOutputStream:close	()V
    //   302: aload_0
    //   303: areturn
    //   304: astore 6
    //   306: aload 6
    //   308: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   311: goto -19 -> 292
    //   314: astore 6
    //   316: aload 6
    //   318: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   321: aload_0
    //   322: areturn
    //   323: astore 9
    //   325: aconst_null
    //   326: astore_0
    //   327: aconst_null
    //   328: astore 6
    //   330: aload_0
    //   331: astore 8
    //   333: aload 6
    //   335: astore 7
    //   337: aload 9
    //   339: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   342: aload 6
    //   344: ifnull +8 -> 352
    //   347: aload 6
    //   349: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   352: aload_0
    //   353: ifnull +7 -> 360
    //   356: aload_0
    //   357: invokevirtual 105	java/io/DataOutputStream:close	()V
    //   360: aconst_null
    //   361: areturn
    //   362: astore 6
    //   364: aload 6
    //   366: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   369: goto -17 -> 352
    //   372: astore_0
    //   373: aload_0
    //   374: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   377: goto -17 -> 360
    //   380: astore_0
    //   381: aconst_null
    //   382: astore 8
    //   384: aconst_null
    //   385: astore 6
    //   387: aload 6
    //   389: ifnull +8 -> 397
    //   392: aload 6
    //   394: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   397: aload 8
    //   399: ifnull +8 -> 407
    //   402: aload 8
    //   404: invokevirtual 105	java/io/DataOutputStream:close	()V
    //   407: aload_0
    //   408: athrow
    //   409: astore 6
    //   411: aload 6
    //   413: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   416: goto -19 -> 397
    //   419: astore 6
    //   421: aload 6
    //   423: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   426: goto -19 -> 407
    //   429: astore_0
    //   430: aconst_null
    //   431: astore 8
    //   433: goto -46 -> 387
    //   436: astore_0
    //   437: aload 7
    //   439: astore 6
    //   441: goto -54 -> 387
    //   444: astore 9
    //   446: aconst_null
    //   447: astore_0
    //   448: goto -118 -> 330
    //   451: astore 9
    //   453: aload 10
    //   455: astore_0
    //   456: goto -126 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramList	List<ProtocolDet.LoginExtraData>
    //   36	213	1	i	int
    //   34	6	2	j	int
    //   86	78	3	k	int
    //   63	86	4	l	long
    //   7	281	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   304	3	6	localException1	Exception
    //   314	3	6	localException2	Exception
    //   328	20	6	localObject1	Object
    //   362	3	6	localException3	Exception
    //   385	8	6	localObject2	Object
    //   409	3	6	localException4	Exception
    //   419	3	6	localException5	Exception
    //   439	1	6	localObject3	Object
    //   26	412	7	localObject4	Object
    //   22	410	8	localObject5	Object
    //   323	15	9	localException6	Exception
    //   444	1	9	localException7	Exception
    //   451	1	9	localException8	Exception
    //   18	436	10	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   287	292	304	java/lang/Exception
    //   297	302	314	java/lang/Exception
    //   0	9	323	java/lang/Exception
    //   347	352	362	java/lang/Exception
    //   356	360	372	java/lang/Exception
    //   0	9	380	finally
    //   392	397	409	java/lang/Exception
    //   402	407	419	java/lang/Exception
    //   9	20	429	finally
    //   28	35	436	finally
    //   50	65	436	finally
    //   73	87	436	finally
    //   95	112	436	finally
    //   120	138	436	finally
    //   146	153	436	finally
    //   161	167	436	finally
    //   175	193	436	finally
    //   201	219	436	finally
    //   227	245	436	finally
    //   260	268	436	finally
    //   276	282	436	finally
    //   337	342	436	finally
    //   9	20	444	java/lang/Exception
    //   28	35	451	java/lang/Exception
    //   50	65	451	java/lang/Exception
    //   73	87	451	java/lang/Exception
    //   95	112	451	java/lang/Exception
    //   120	138	451	java/lang/Exception
    //   146	153	451	java/lang/Exception
    //   161	167	451	java/lang/Exception
    //   175	193	451	java/lang/Exception
    //   201	219	451	java/lang/Exception
    //   227	245	451	java/lang/Exception
    //   260	268	451	java/lang/Exception
    //   276	282	451	java/lang/Exception
  }
  
  private static String getCachedDetFileFullPath(Context paramContext)
  {
    return paramContext.getFilesDir() + File.separator + "pd2.dat";
  }
  
  /* Error */
  private static ProtocolDet.LoginExtraData getExtraDataFromBuffer(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 55	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   5: dup
    //   6: aconst_null
    //   7: invokespecial 142	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:<init>	(Lcom/tencent/loginsecsdk/ProtocolDet$1;)V
    //   10: astore_2
    //   11: new 144	java/io/DataInputStream
    //   14: dup
    //   15: new 146	java/io/ByteArrayInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 148	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: invokespecial 151	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: aload_1
    //   31: invokevirtual 155	java/io/DataInputStream:readLong	()J
    //   34: putfield 59	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   37: aload_1
    //   38: astore_0
    //   39: aload_2
    //   40: aload_1
    //   41: invokevirtual 159	java/io/DataInputStream:readByte	()B
    //   44: putfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   47: aload_1
    //   48: astore_0
    //   49: aload_2
    //   50: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   53: iconst_4
    //   54: if_icmpeq +14 -> 68
    //   57: aload_1
    //   58: astore_0
    //   59: aload_2
    //   60: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   63: bipush 16
    //   65: if_icmpne +66 -> 131
    //   68: aload_1
    //   69: astore_0
    //   70: aload_2
    //   71: aload_2
    //   72: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   75: newarray byte
    //   77: putfield 74	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   80: aload_1
    //   81: astore_0
    //   82: aload_1
    //   83: aload_2
    //   84: getfield 74	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   87: invokevirtual 163	java/io/DataInputStream:read	([B)I
    //   90: pop
    //   91: aload_1
    //   92: astore_0
    //   93: aload_2
    //   94: aload_1
    //   95: invokevirtual 166	java/io/DataInputStream:readInt	()I
    //   98: putfield 81	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   101: aload_1
    //   102: astore_0
    //   103: aload_2
    //   104: aload_1
    //   105: invokevirtual 166	java/io/DataInputStream:readInt	()I
    //   108: putfield 87	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 167	java/io/DataInputStream:close	()V
    //   119: aload_2
    //   120: astore_0
    //   121: aload_0
    //   122: areturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   128: goto -9 -> 119
    //   131: aload_1
    //   132: astore_0
    //   133: ldc 89
    //   135: ldc 91
    //   137: invokestatic 97	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   140: pop
    //   141: aload_3
    //   142: astore_0
    //   143: aload_1
    //   144: ifnull -23 -> 121
    //   147: aload_1
    //   148: invokevirtual 167	java/io/DataInputStream:close	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: astore_0
    //   165: aload_2
    //   166: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   169: aload_3
    //   170: astore_0
    //   171: aload_1
    //   172: ifnull -51 -> 121
    //   175: aload_1
    //   176: invokevirtual 167	java/io/DataInputStream:close	()V
    //   179: aconst_null
    //   180: areturn
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_0
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 167	java/io/DataInputStream:close	()V
    //   199: aload_1
    //   200: athrow
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   206: goto -7 -> 199
    //   209: astore_1
    //   210: goto -19 -> 191
    //   213: astore_2
    //   214: goto -51 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramArrayOfByte	byte[]
    //   26	150	1	localDataInputStream	java.io.DataInputStream
    //   188	12	1	localObject1	Object
    //   209	1	1	localObject2	Object
    //   10	110	2	localLoginExtraData	ProtocolDet.LoginExtraData
    //   160	6	2	localException1	Exception
    //   213	1	2	localException2	Exception
    //   1	169	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   115	119	123	java/lang/Exception
    //   147	151	153	java/lang/Exception
    //   2	27	160	java/lang/Exception
    //   175	179	181	java/lang/Exception
    //   2	27	188	finally
    //   195	199	201	java/lang/Exception
    //   29	37	209	finally
    //   39	47	209	finally
    //   49	57	209	finally
    //   59	68	209	finally
    //   70	80	209	finally
    //   82	91	209	finally
    //   93	101	209	finally
    //   103	111	209	finally
    //   133	141	209	finally
    //   165	169	209	finally
    //   29	37	213	java/lang/Exception
    //   39	47	213	java/lang/Exception
    //   49	57	213	java/lang/Exception
    //   59	68	213	java/lang/Exception
    //   70	80	213	java/lang/Exception
    //   82	91	213	java/lang/Exception
    //   93	101	213	java/lang/Exception
    //   103	111	213	java/lang/Exception
    //   133	141	213	java/lang/Exception
  }
  
  public static byte[] getLoginExtraData(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = loadExtraDataFromFile(paramContext, 3);
    if (paramContext == null) {
      return packExtraData(null);
    }
    cNum = (byte)paramContext.size();
    return packExtraData(convertExtraDataListToBuffer(paramContext));
  }
  
  /* Error */
  private static List<ProtocolDet.LoginExtraData> loadExtraDataFromFile(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: new 181	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 182	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokestatic 184	com/tencent/loginsecsdk/ProtocolDet:getCachedDetFileFullPath	(Landroid/content/Context;)Ljava/lang/String;
    //   13: invokestatic 188	com/tencent/loginsecsdk/ProtocolDet:loadFileContent	(Ljava/lang/String;)[B
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +24 -> 42
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 190	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 191	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: aconst_null
    //   34: areturn
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   40: aconst_null
    //   41: areturn
    //   42: new 144	java/io/DataInputStream
    //   45: dup
    //   46: new 146	java/io/ByteArrayInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 148	java/io/ByteArrayInputStream:<init>	([B)V
    //   54: invokespecial 151	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_3
    //   58: aload_3
    //   59: astore_0
    //   60: aload_3
    //   61: invokevirtual 194	java/io/DataInputStream:available	()I
    //   64: ifeq +22 -> 86
    //   67: aload_3
    //   68: astore_0
    //   69: aload 5
    //   71: invokeinterface 49 1 0
    //   76: istore_2
    //   77: iload_2
    //   78: iload_1
    //   79: if_icmplt +18 -> 97
    //   82: iload_1
    //   83: ifle +14 -> 97
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 167	java/io/DataInputStream:close	()V
    //   94: aload 5
    //   96: areturn
    //   97: aload_3
    //   98: astore_0
    //   99: new 55	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   102: dup
    //   103: aconst_null
    //   104: invokespecial 142	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:<init>	(Lcom/tencent/loginsecsdk/ProtocolDet$1;)V
    //   107: astore 4
    //   109: aload_3
    //   110: astore_0
    //   111: aload 4
    //   113: aload_3
    //   114: invokevirtual 155	java/io/DataInputStream:readLong	()J
    //   117: putfield 59	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   120: aload_3
    //   121: astore_0
    //   122: aload 4
    //   124: aload_3
    //   125: invokevirtual 159	java/io/DataInputStream:readByte	()B
    //   128: putfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   131: aload_3
    //   132: astore_0
    //   133: aload 4
    //   135: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   138: iconst_4
    //   139: if_icmpeq +15 -> 154
    //   142: aload_3
    //   143: astore_0
    //   144: aload 4
    //   146: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   149: bipush 16
    //   151: if_icmpne +94 -> 245
    //   154: aload_3
    //   155: astore_0
    //   156: aload 4
    //   158: aload 4
    //   160: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   163: newarray byte
    //   165: putfield 74	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   168: aload_3
    //   169: astore_0
    //   170: aload_3
    //   171: aload 4
    //   173: getfield 74	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   176: invokevirtual 163	java/io/DataInputStream:read	([B)I
    //   179: pop
    //   180: aload_3
    //   181: astore_0
    //   182: aload 4
    //   184: aload_3
    //   185: invokevirtual 166	java/io/DataInputStream:readInt	()I
    //   188: putfield 81	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   191: aload_3
    //   192: astore_0
    //   193: aload 4
    //   195: aload_3
    //   196: invokevirtual 166	java/io/DataInputStream:readInt	()I
    //   199: putfield 87	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   202: aload_3
    //   203: astore_0
    //   204: aload 5
    //   206: aload 4
    //   208: invokeinterface 198 2 0
    //   213: pop
    //   214: goto -156 -> 58
    //   217: astore 4
    //   219: aload_3
    //   220: astore_0
    //   221: aload 4
    //   223: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   226: aload_3
    //   227: ifnull -133 -> 94
    //   230: aload_3
    //   231: invokevirtual 167	java/io/DataInputStream:close	()V
    //   234: goto -140 -> 94
    //   237: astore_0
    //   238: aload_0
    //   239: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   242: goto -148 -> 94
    //   245: aload_3
    //   246: astore_0
    //   247: ldc 89
    //   249: ldc 91
    //   251: invokestatic 97	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   254: pop
    //   255: goto -169 -> 86
    //   258: astore 4
    //   260: aload_0
    //   261: astore_3
    //   262: aload 4
    //   264: astore_0
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 167	java/io/DataInputStream:close	()V
    //   273: aload_0
    //   274: athrow
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   280: goto -186 -> 94
    //   283: astore_3
    //   284: aload_3
    //   285: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   288: goto -15 -> 273
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_3
    //   294: goto -29 -> 265
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_3
    //   301: goto -82 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramInt	int
    //   76	4	2	i	int
    //   57	213	3	localObject1	Object
    //   283	2	3	localException1	Exception
    //   293	8	3	localObject2	Object
    //   107	100	4	localLoginExtraData	ProtocolDet.LoginExtraData
    //   217	5	4	localException2	Exception
    //   258	5	4	localObject3	Object
    //   297	1	4	localException3	Exception
    //   7	198	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   25	33	35	java/lang/Exception
    //   60	67	217	java/lang/Exception
    //   69	77	217	java/lang/Exception
    //   99	109	217	java/lang/Exception
    //   111	120	217	java/lang/Exception
    //   122	131	217	java/lang/Exception
    //   133	142	217	java/lang/Exception
    //   144	154	217	java/lang/Exception
    //   156	168	217	java/lang/Exception
    //   170	180	217	java/lang/Exception
    //   182	191	217	java/lang/Exception
    //   193	202	217	java/lang/Exception
    //   204	214	217	java/lang/Exception
    //   247	255	217	java/lang/Exception
    //   230	234	237	java/lang/Exception
    //   60	67	258	finally
    //   69	77	258	finally
    //   99	109	258	finally
    //   111	120	258	finally
    //   122	131	258	finally
    //   133	142	258	finally
    //   144	154	258	finally
    //   156	168	258	finally
    //   170	180	258	finally
    //   182	191	258	finally
    //   193	202	258	finally
    //   204	214	258	finally
    //   221	226	258	finally
    //   247	255	258	finally
    //   90	94	275	java/lang/Exception
    //   269	273	283	java/lang/Exception
    //   9	17	291	finally
    //   42	58	291	finally
    //   9	17	297	java/lang/Exception
    //   42	58	297	java/lang/Exception
  }
  
  /* Error */
  private static byte[] loadFileContent(String paramString)
  {
    // Byte code:
    //   0: sipush 4096
    //   3: istore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: new 127	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 206	java/io/File:exists	()Z
    //   20: istore_3
    //   21: iload_3
    //   22: ifne +24 -> 46
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 190	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 191	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: aconst_null
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   44: aconst_null
    //   45: areturn
    //   46: new 208	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 211	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore 4
    //   56: aload 4
    //   58: astore_0
    //   59: aload 4
    //   61: invokevirtual 212	java/io/FileInputStream:available	()I
    //   64: istore_1
    //   65: iload_1
    //   66: sipush 4096
    //   69: if_icmple +139 -> 208
    //   72: iload_2
    //   73: istore_1
    //   74: aload 4
    //   76: astore_0
    //   77: iload_1
    //   78: newarray byte
    //   80: astore 5
    //   82: aload 4
    //   84: astore_0
    //   85: aload 4
    //   87: aload 5
    //   89: invokevirtual 213	java/io/FileInputStream:read	([B)I
    //   92: pop
    //   93: aload 5
    //   95: astore_0
    //   96: aload 4
    //   98: ifnull +11 -> 109
    //   101: aload 4
    //   103: invokevirtual 214	java/io/FileInputStream:close	()V
    //   106: aload 5
    //   108: astore_0
    //   109: aload_0
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   116: aload 5
    //   118: astore_0
    //   119: goto -10 -> 109
    //   122: astore 5
    //   124: aconst_null
    //   125: astore 4
    //   127: aload 4
    //   129: astore_0
    //   130: aload 5
    //   132: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   135: aload 4
    //   137: ifnull +66 -> 203
    //   140: aload 4
    //   142: invokevirtual 214	java/io/FileInputStream:close	()V
    //   145: aconst_null
    //   146: astore_0
    //   147: goto -38 -> 109
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   155: aconst_null
    //   156: astore_0
    //   157: goto -48 -> 109
    //   160: astore_0
    //   161: aload 5
    //   163: astore 4
    //   165: aload 4
    //   167: ifnull +8 -> 175
    //   170: aload 4
    //   172: invokevirtual 214	java/io/FileInputStream:close	()V
    //   175: aload_0
    //   176: athrow
    //   177: astore 4
    //   179: aload 4
    //   181: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   184: goto -9 -> 175
    //   187: astore 5
    //   189: aload_0
    //   190: astore 4
    //   192: aload 5
    //   194: astore_0
    //   195: goto -30 -> 165
    //   198: astore 5
    //   200: goto -73 -> 127
    //   203: aconst_null
    //   204: astore_0
    //   205: goto -96 -> 109
    //   208: goto -134 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramString	String
    //   64	14	1	i	int
    //   3	70	2	j	int
    //   20	2	3	bool	boolean
    //   54	117	4	localObject1	Object
    //   177	3	4	localException1	Exception
    //   190	1	4	str	String
    //   5	112	5	arrayOfByte	byte[]
    //   122	40	5	localException2	Exception
    //   187	6	5	localObject2	Object
    //   198	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   29	37	39	java/lang/Exception
    //   101	106	111	java/lang/Exception
    //   7	21	122	java/lang/Exception
    //   46	56	122	java/lang/Exception
    //   140	145	150	java/lang/Exception
    //   7	21	160	finally
    //   46	56	160	finally
    //   170	175	177	java/lang/Exception
    //   59	65	187	finally
    //   77	82	187	finally
    //   85	93	187	finally
    //   130	135	187	finally
    //   59	65	198	java/lang/Exception
    //   77	82	198	java/lang/Exception
    //   85	93	198	java/lang/Exception
  }
  
  /* Error */
  private static byte[] packExtraData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore_1
    //   5: new 37	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 38	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_3
    //   13: new 40	java/io/DataOutputStream
    //   16: dup
    //   17: aload_3
    //   18: invokespecial 43	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore 6
    //   23: aload 6
    //   25: astore 5
    //   27: aload_3
    //   28: astore 4
    //   30: aload 6
    //   32: iconst_1
    //   33: invokevirtual 70	java/io/DataOutputStream:writeByte	(I)V
    //   36: aload_0
    //   37: ifnull +88 -> 125
    //   40: aload 6
    //   42: astore 5
    //   44: aload_3
    //   45: astore 4
    //   47: aload_0
    //   48: arraylength
    //   49: i2b
    //   50: istore_2
    //   51: iload_2
    //   52: ifge +230 -> 282
    //   55: aload 6
    //   57: astore 5
    //   59: aload_3
    //   60: astore 4
    //   62: aload 6
    //   64: getstatic 27	com/tencent/loginsecsdk/ProtocolDet:cNum	B
    //   67: invokevirtual 70	java/io/DataOutputStream:writeByte	(I)V
    //   70: iload_1
    //   71: ifle +18 -> 89
    //   74: aload 6
    //   76: astore 5
    //   78: aload_3
    //   79: astore 4
    //   81: aload 6
    //   83: aload_0
    //   84: iconst_0
    //   85: iload_1
    //   86: invokevirtual 217	java/io/DataOutputStream:write	([BII)V
    //   89: aload 6
    //   91: astore 5
    //   93: aload_3
    //   94: astore 4
    //   96: aload_3
    //   97: invokevirtual 101	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   100: astore_0
    //   101: aload_3
    //   102: ifnull +7 -> 109
    //   105: aload_3
    //   106: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   109: aload_0
    //   110: astore_3
    //   111: aload 6
    //   113: ifnull +10 -> 123
    //   116: aload 6
    //   118: invokevirtual 105	java/io/DataOutputStream:close	()V
    //   121: aload_0
    //   122: astore_3
    //   123: aload_3
    //   124: areturn
    //   125: aload 6
    //   127: astore 5
    //   129: aload_3
    //   130: astore 4
    //   132: iconst_0
    //   133: putstatic 27	com/tencent/loginsecsdk/ProtocolDet:cNum	B
    //   136: goto -81 -> 55
    //   139: astore 4
    //   141: aload 6
    //   143: astore_0
    //   144: aload 4
    //   146: astore 6
    //   148: aload_0
    //   149: astore 5
    //   151: aload_3
    //   152: astore 4
    //   154: aload 6
    //   156: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   159: aload_3
    //   160: ifnull +7 -> 167
    //   163: aload_3
    //   164: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   167: aload 7
    //   169: astore_3
    //   170: aload_0
    //   171: ifnull -48 -> 123
    //   174: aload_0
    //   175: invokevirtual 105	java/io/DataOutputStream:close	()V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   185: aconst_null
    //   186: areturn
    //   187: astore_3
    //   188: aload_3
    //   189: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   192: goto -83 -> 109
    //   195: astore_3
    //   196: aload_3
    //   197: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   200: aload_0
    //   201: areturn
    //   202: astore_3
    //   203: aload_3
    //   204: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   207: goto -40 -> 167
    //   210: astore_0
    //   211: aconst_null
    //   212: astore 5
    //   214: aconst_null
    //   215: astore_3
    //   216: aload_3
    //   217: ifnull +7 -> 224
    //   220: aload_3
    //   221: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   224: aload 5
    //   226: ifnull +8 -> 234
    //   229: aload 5
    //   231: invokevirtual 105	java/io/DataOutputStream:close	()V
    //   234: aload_0
    //   235: athrow
    //   236: astore_3
    //   237: aload_3
    //   238: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   241: goto -17 -> 224
    //   244: astore_3
    //   245: aload_3
    //   246: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   249: goto -15 -> 234
    //   252: astore_0
    //   253: aconst_null
    //   254: astore 5
    //   256: goto -40 -> 216
    //   259: astore_0
    //   260: aload 4
    //   262: astore_3
    //   263: goto -47 -> 216
    //   266: astore 6
    //   268: aconst_null
    //   269: astore_0
    //   270: aconst_null
    //   271: astore_3
    //   272: goto -124 -> 148
    //   275: astore 6
    //   277: aconst_null
    //   278: astore_0
    //   279: goto -131 -> 148
    //   282: iload_2
    //   283: istore_1
    //   284: goto -229 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramArrayOfByte	byte[]
    //   4	280	1	i	int
    //   50	233	2	j	int
    //   12	158	3	localObject1	Object
    //   187	2	3	localException1	Exception
    //   195	2	3	localException2	Exception
    //   202	2	3	localException3	Exception
    //   215	6	3	localObject2	Object
    //   236	2	3	localException4	Exception
    //   244	2	3	localException5	Exception
    //   262	10	3	localObject3	Object
    //   28	103	4	localObject4	Object
    //   139	6	4	localException6	Exception
    //   152	109	4	localObject5	Object
    //   25	230	5	localObject6	Object
    //   21	134	6	localObject7	Object
    //   266	1	6	localException7	Exception
    //   275	1	6	localException8	Exception
    //   1	167	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   30	36	139	java/lang/Exception
    //   47	51	139	java/lang/Exception
    //   62	70	139	java/lang/Exception
    //   81	89	139	java/lang/Exception
    //   96	101	139	java/lang/Exception
    //   132	136	139	java/lang/Exception
    //   174	178	180	java/lang/Exception
    //   105	109	187	java/lang/Exception
    //   116	121	195	java/lang/Exception
    //   163	167	202	java/lang/Exception
    //   5	13	210	finally
    //   220	224	236	java/lang/Exception
    //   229	234	244	java/lang/Exception
    //   13	23	252	finally
    //   30	36	259	finally
    //   47	51	259	finally
    //   62	70	259	finally
    //   81	89	259	finally
    //   96	101	259	finally
    //   132	136	259	finally
    //   154	159	259	finally
    //   5	13	266	java/lang/Exception
    //   13	23	275	java/lang/Exception
  }
  
  public static int setLoginExtraData(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext == null) || (paramArrayOfByte == null) || ((paramArrayOfByte.length != 21) && (paramArrayOfByte.length != 33))) {}
    do
    {
      return -1;
      paramArrayOfByte = getExtraDataFromBuffer(paramArrayOfByte);
    } while (paramArrayOfByte == null);
    return updateCachedExtraDataFile(paramContext, paramArrayOfByte);
  }
  
  private static int updateCachedExtraDataFile(Context paramContext, ProtocolDet.LoginExtraData paramLoginExtraData)
  {
    int j = 0;
    Object localObject = loadExtraDataFromFile(paramContext, 0);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      int i;
      try
      {
        if (((List)localObject).size() < 3)
        {
          ((List)localObject).add(paramLoginExtraData);
          return updateFile(paramContext, (List)localObject);
        }
        k = ((ProtocolDet.LoginExtraData)((List)localObject).get(0)).mTime;
        int n = ((List)localObject).size();
        i = 1;
        if (i < n)
        {
          if (k > ((ProtocolDet.LoginExtraData)((List)localObject).get(i)).mTime)
          {
            j = ((ProtocolDet.LoginExtraData)((List)localObject).get(i)).mTime;
            k = i;
            break label160;
          }
        }
        else
        {
          ((List)localObject).set(j, paramLoginExtraData);
          continue;
        }
      }
      catch (Exception paramLoginExtraData)
      {
        paramLoginExtraData.printStackTrace();
        continue;
        m = j;
        j = k;
        k = m;
      }
      continue;
      label160:
      i += 1;
      int m = k;
      int k = j;
      j = m;
    }
  }
  
  /* Error */
  private static int updateFile(Context paramContext, List<ProtocolDet.LoginExtraData> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 184	com/tencent/loginsecsdk/ProtocolDet:getCachedDetFileFullPath	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore_0
    //   7: aload_1
    //   8: invokestatic 179	com/tencent/loginsecsdk/ProtocolDet:convertExtraDataListToBuffer	(Ljava/util/List;)[B
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +24 -> 37
    //   16: iconst_0
    //   17: ifeq +11 -> 28
    //   20: new 190	java/lang/NullPointerException
    //   23: dup
    //   24: invokespecial 191	java/lang/NullPointerException:<init>	()V
    //   27: athrow
    //   28: iconst_m1
    //   29: ireturn
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   35: iconst_m1
    //   36: ireturn
    //   37: new 235	java/io/FileOutputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 236	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: aload_3
    //   50: invokevirtual 237	java/io/FileOutputStream:write	([B)V
    //   53: aload_1
    //   54: ifnull +7 -> 61
    //   57: aload_1
    //   58: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   61: iconst_0
    //   62: ireturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   68: goto -7 -> 61
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   80: aload_1
    //   81: ifnull -20 -> 61
    //   84: aload_1
    //   85: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   88: goto -27 -> 61
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   96: goto -35 -> 61
    //   99: astore_0
    //   100: aload_2
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   110: aload_0
    //   111: athrow
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   117: goto -7 -> 110
    //   120: astore_2
    //   121: aload_0
    //   122: astore_1
    //   123: aload_2
    //   124: astore_0
    //   125: goto -23 -> 102
    //   128: astore_2
    //   129: goto -55 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramContext	Context
    //   0	132	1	paramList	List<ProtocolDet.LoginExtraData>
    //   1	1	2	localObject1	Object
    //   71	30	2	localException1	Exception
    //   120	4	2	localObject2	Object
    //   128	1	2	localException2	Exception
    //   11	39	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   20	28	30	java/lang/Exception
    //   57	61	63	java/lang/Exception
    //   2	12	71	java/lang/Exception
    //   37	46	71	java/lang/Exception
    //   84	88	91	java/lang/Exception
    //   2	12	99	finally
    //   37	46	99	finally
    //   106	110	112	java/lang/Exception
    //   48	53	120	finally
    //   76	80	120	finally
    //   48	53	128	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.loginsecsdk.ProtocolDet
 * JD-Core Version:    0.7.0.1
 */