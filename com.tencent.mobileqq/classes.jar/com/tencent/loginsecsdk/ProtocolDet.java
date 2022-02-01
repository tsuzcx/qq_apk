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
  private static byte cNum;
  
  /* Error */
  private static byte[] convertExtraDataListToBuffer(List<ProtocolDet.LoginExtraData> paramList)
  {
    // Byte code:
    //   0: new 35	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 36	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 7
    //   9: new 38	java/io/DataOutputStream
    //   12: dup
    //   13: aload 7
    //   15: invokespecial 41	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 9
    //   20: aload 7
    //   22: astore 6
    //   24: aload 9
    //   26: astore 8
    //   28: aload_0
    //   29: invokeinterface 47 1 0
    //   34: istore_2
    //   35: iconst_0
    //   36: istore_1
    //   37: iload_1
    //   38: iload_2
    //   39: if_icmpge +235 -> 274
    //   42: aload 7
    //   44: astore 6
    //   46: aload 9
    //   48: astore 8
    //   50: aload_0
    //   51: iload_1
    //   52: invokeinterface 51 2 0
    //   57: checkcast 53	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   60: getfield 57	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   63: lstore 4
    //   65: aload 7
    //   67: astore 6
    //   69: aload 9
    //   71: astore 8
    //   73: aload_0
    //   74: iload_1
    //   75: invokeinterface 51 2 0
    //   80: checkcast 53	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   83: getfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   86: istore_3
    //   87: aload 7
    //   89: astore 6
    //   91: aload 9
    //   93: astore 8
    //   95: aload_0
    //   96: iload_1
    //   97: invokeinterface 51 2 0
    //   102: checkcast 53	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   105: getfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   108: iconst_4
    //   109: if_icmpeq +51 -> 160
    //   112: aload 7
    //   114: astore 6
    //   116: aload 9
    //   118: astore 8
    //   120: aload_0
    //   121: iload_1
    //   122: invokeinterface 51 2 0
    //   127: checkcast 53	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   130: getfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   133: bipush 16
    //   135: if_icmpne +6 -> 141
    //   138: goto +22 -> 160
    //   141: aload 7
    //   143: astore 6
    //   145: aload 9
    //   147: astore 8
    //   149: ldc 62
    //   151: ldc 64
    //   153: invokestatic 70	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: goto +117 -> 274
    //   160: aload 7
    //   162: astore 6
    //   164: aload 9
    //   166: astore 8
    //   168: aload 9
    //   170: lload 4
    //   172: invokevirtual 74	java/io/DataOutputStream:writeLong	(J)V
    //   175: aload 7
    //   177: astore 6
    //   179: aload 9
    //   181: astore 8
    //   183: aload 9
    //   185: iload_3
    //   186: invokevirtual 78	java/io/DataOutputStream:writeByte	(I)V
    //   189: aload 7
    //   191: astore 6
    //   193: aload 9
    //   195: astore 8
    //   197: aload 9
    //   199: aload_0
    //   200: iload_1
    //   201: invokeinterface 51 2 0
    //   206: checkcast 53	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   209: getfield 82	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   212: invokevirtual 86	java/io/DataOutputStream:write	([B)V
    //   215: aload 7
    //   217: astore 6
    //   219: aload 9
    //   221: astore 8
    //   223: aload 9
    //   225: aload_0
    //   226: iload_1
    //   227: invokeinterface 51 2 0
    //   232: checkcast 53	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   235: getfield 89	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   238: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   241: aload 7
    //   243: astore 6
    //   245: aload 9
    //   247: astore 8
    //   249: aload 9
    //   251: aload_0
    //   252: iload_1
    //   253: invokeinterface 51 2 0
    //   258: checkcast 53	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   261: getfield 95	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   264: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   267: iload_1
    //   268: iconst_1
    //   269: iadd
    //   270: istore_1
    //   271: goto -234 -> 37
    //   274: aload 7
    //   276: astore 6
    //   278: aload 9
    //   280: astore 8
    //   282: aload 7
    //   284: invokevirtual 99	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   287: astore_0
    //   288: aload 7
    //   290: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   293: goto +10 -> 303
    //   296: astore 6
    //   298: aload 6
    //   300: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   303: aload 9
    //   305: invokevirtual 106	java/io/DataOutputStream:close	()V
    //   308: aload_0
    //   309: areturn
    //   310: astore 6
    //   312: aload 6
    //   314: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   317: aload_0
    //   318: areturn
    //   319: astore 6
    //   321: aload 9
    //   323: astore_0
    //   324: aload 6
    //   326: astore 9
    //   328: goto +40 -> 368
    //   331: astore_0
    //   332: aconst_null
    //   333: astore 8
    //   335: aload 7
    //   337: astore 6
    //   339: goto +79 -> 418
    //   342: astore 9
    //   344: aconst_null
    //   345: astore_0
    //   346: goto +22 -> 368
    //   349: astore_0
    //   350: aconst_null
    //   351: astore 6
    //   353: aload 6
    //   355: astore 8
    //   357: goto +61 -> 418
    //   360: astore 9
    //   362: aconst_null
    //   363: astore 7
    //   365: aload 7
    //   367: astore_0
    //   368: aload 7
    //   370: astore 6
    //   372: aload_0
    //   373: astore 8
    //   375: aload 9
    //   377: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   380: aload 7
    //   382: ifnull +18 -> 400
    //   385: aload 7
    //   387: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   390: goto +10 -> 400
    //   393: astore 6
    //   395: aload 6
    //   397: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   400: aload_0
    //   401: ifnull +14 -> 415
    //   404: aload_0
    //   405: invokevirtual 106	java/io/DataOutputStream:close	()V
    //   408: aconst_null
    //   409: areturn
    //   410: astore_0
    //   411: aload_0
    //   412: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   415: aconst_null
    //   416: areturn
    //   417: astore_0
    //   418: aload 6
    //   420: ifnull +18 -> 438
    //   423: aload 6
    //   425: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   428: goto +10 -> 438
    //   431: astore 6
    //   433: aload 6
    //   435: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   438: aload 8
    //   440: ifnull +18 -> 458
    //   443: aload 8
    //   445: invokevirtual 106	java/io/DataOutputStream:close	()V
    //   448: goto +10 -> 458
    //   451: astore 6
    //   453: aload 6
    //   455: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   458: goto +5 -> 463
    //   461: aload_0
    //   462: athrow
    //   463: goto -2 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	paramList	List<ProtocolDet.LoginExtraData>
    //   36	235	1	i	int
    //   34	6	2	j	int
    //   86	100	3	k	int
    //   63	108	4	l	long
    //   22	255	6	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   296	3	6	localException1	Exception
    //   310	3	6	localException2	Exception
    //   319	6	6	localException3	Exception
    //   337	34	6	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   393	31	6	localException4	Exception
    //   431	3	6	localException5	Exception
    //   451	3	6	localException6	Exception
    //   7	379	7	localByteArrayOutputStream3	java.io.ByteArrayOutputStream
    //   26	418	8	localObject1	Object
    //   18	309	9	localObject2	Object
    //   342	1	9	localException7	Exception
    //   360	16	9	localException8	Exception
    // Exception table:
    //   from	to	target	type
    //   288	293	296	java/lang/Exception
    //   303	308	310	java/lang/Exception
    //   28	35	319	java/lang/Exception
    //   50	65	319	java/lang/Exception
    //   73	87	319	java/lang/Exception
    //   95	112	319	java/lang/Exception
    //   120	138	319	java/lang/Exception
    //   149	157	319	java/lang/Exception
    //   168	175	319	java/lang/Exception
    //   183	189	319	java/lang/Exception
    //   197	215	319	java/lang/Exception
    //   223	241	319	java/lang/Exception
    //   249	267	319	java/lang/Exception
    //   282	288	319	java/lang/Exception
    //   9	20	331	finally
    //   9	20	342	java/lang/Exception
    //   0	9	349	finally
    //   0	9	360	java/lang/Exception
    //   385	390	393	java/lang/Exception
    //   404	408	410	java/lang/Exception
    //   28	35	417	finally
    //   50	65	417	finally
    //   73	87	417	finally
    //   95	112	417	finally
    //   120	138	417	finally
    //   149	157	417	finally
    //   168	175	417	finally
    //   183	189	417	finally
    //   197	215	417	finally
    //   223	241	417	finally
    //   249	267	417	finally
    //   282	288	417	finally
    //   375	380	417	finally
    //   423	428	431	java/lang/Exception
    //   443	448	451	java/lang/Exception
  }
  
  private static String getCachedDetFileFullPath(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("pd2.dat");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static ProtocolDet.LoginExtraData getExtraDataFromBuffer(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 53	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   3: dup
    //   4: aconst_null
    //   5: invokespecial 140	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:<init>	(Lcom/tencent/loginsecsdk/ProtocolDet$1;)V
    //   8: astore_2
    //   9: new 142	java/io/DataInputStream
    //   12: dup
    //   13: new 144	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 146	java/io/ByteArrayInputStream:<init>	([B)V
    //   21: invokespecial 149	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore_1
    //   25: aload_1
    //   26: astore_0
    //   27: aload_2
    //   28: aload_1
    //   29: invokevirtual 153	java/io/DataInputStream:readLong	()J
    //   32: putfield 57	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   35: aload_1
    //   36: astore_0
    //   37: aload_2
    //   38: aload_1
    //   39: invokevirtual 157	java/io/DataInputStream:readByte	()B
    //   42: putfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   45: aload_1
    //   46: astore_0
    //   47: aload_2
    //   48: getfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   51: iconst_4
    //   52: if_icmpeq +40 -> 92
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: getfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   61: bipush 16
    //   63: if_icmpne +6 -> 69
    //   66: goto +26 -> 92
    //   69: aload_1
    //   70: astore_0
    //   71: ldc 62
    //   73: ldc 64
    //   75: invokestatic 70	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: aload_1
    //   80: invokevirtual 158	java/io/DataInputStream:close	()V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   90: aconst_null
    //   91: areturn
    //   92: aload_1
    //   93: astore_0
    //   94: aload_2
    //   95: aload_2
    //   96: getfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   99: newarray byte
    //   101: putfield 82	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   104: aload_1
    //   105: astore_0
    //   106: aload_1
    //   107: aload_2
    //   108: getfield 82	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   111: invokevirtual 162	java/io/DataInputStream:read	([B)I
    //   114: pop
    //   115: aload_1
    //   116: astore_0
    //   117: aload_2
    //   118: aload_1
    //   119: invokevirtual 165	java/io/DataInputStream:readInt	()I
    //   122: putfield 89	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   125: aload_1
    //   126: astore_0
    //   127: aload_2
    //   128: aload_1
    //   129: invokevirtual 165	java/io/DataInputStream:readInt	()I
    //   132: putfield 95	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   135: aload_1
    //   136: invokevirtual 158	java/io/DataInputStream:close	()V
    //   139: aload_2
    //   140: areturn
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   146: aload_2
    //   147: areturn
    //   148: astore_2
    //   149: goto +12 -> 161
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_0
    //   155: goto +30 -> 185
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   167: aload_1
    //   168: ifnull +14 -> 182
    //   171: aload_1
    //   172: invokevirtual 158	java/io/DataInputStream:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_1
    //   185: aload_0
    //   186: ifnull +15 -> 201
    //   189: aload_0
    //   190: invokevirtual 158	java/io/DataInputStream:close	()V
    //   193: goto +8 -> 201
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   201: aload_1
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramArrayOfByte	byte[]
    //   24	112	1	localDataInputStream	java.io.DataInputStream
    //   152	1	1	localObject1	Object
    //   160	12	1	localObject2	Object
    //   184	18	1	localObject3	Object
    //   8	139	2	localLoginExtraData	ProtocolDet.LoginExtraData
    //   148	1	2	localException1	Exception
    //   158	6	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   79	83	85	java/lang/Exception
    //   135	139	141	java/lang/Exception
    //   27	35	148	java/lang/Exception
    //   37	45	148	java/lang/Exception
    //   47	55	148	java/lang/Exception
    //   57	66	148	java/lang/Exception
    //   71	79	148	java/lang/Exception
    //   94	104	148	java/lang/Exception
    //   106	115	148	java/lang/Exception
    //   117	125	148	java/lang/Exception
    //   127	135	148	java/lang/Exception
    //   0	25	152	finally
    //   0	25	158	java/lang/Exception
    //   171	175	177	java/lang/Exception
    //   27	35	184	finally
    //   37	45	184	finally
    //   47	55	184	finally
    //   57	66	184	finally
    //   71	79	184	finally
    //   94	104	184	finally
    //   106	115	184	finally
    //   117	125	184	finally
    //   127	135	184	finally
    //   163	167	184	finally
    //   189	193	196	java/lang/Exception
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
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: aload_0
    //   17: invokestatic 184	com/tencent/loginsecsdk/ProtocolDet:getCachedDetFileFullPath	(Landroid/content/Context;)Ljava/lang/String;
    //   20: invokestatic 188	com/tencent/loginsecsdk/ProtocolDet:loadFileContent	(Ljava/lang/String;)[B
    //   23: astore_0
    //   24: aload_0
    //   25: ifnonnull +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: aload_3
    //   31: astore_2
    //   32: new 142	java/io/DataInputStream
    //   35: dup
    //   36: new 144	java/io/ByteArrayInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 146	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: invokespecial 149	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 191	java/io/DataInputStream:available	()I
    //   52: ifeq +124 -> 176
    //   55: aload 5
    //   57: invokeinterface 47 1 0
    //   62: iload_1
    //   63: if_icmplt +10 -> 73
    //   66: iload_1
    //   67: ifle +6 -> 73
    //   70: goto +106 -> 176
    //   73: new 53	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   76: dup
    //   77: aconst_null
    //   78: invokespecial 140	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:<init>	(Lcom/tencent/loginsecsdk/ProtocolDet$1;)V
    //   81: astore_2
    //   82: aload_2
    //   83: aload_0
    //   84: invokevirtual 153	java/io/DataInputStream:readLong	()J
    //   87: putfield 57	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   90: aload_2
    //   91: aload_0
    //   92: invokevirtual 157	java/io/DataInputStream:readByte	()B
    //   95: putfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   98: aload_2
    //   99: getfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   102: iconst_4
    //   103: if_icmpeq +26 -> 129
    //   106: aload_2
    //   107: getfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   110: bipush 16
    //   112: if_icmpne +6 -> 118
    //   115: goto +14 -> 129
    //   118: ldc 62
    //   120: ldc 64
    //   122: invokestatic 70	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   125: pop
    //   126: goto +50 -> 176
    //   129: aload_2
    //   130: aload_2
    //   131: getfield 60	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   134: newarray byte
    //   136: putfield 82	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   139: aload_0
    //   140: aload_2
    //   141: getfield 82	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   144: invokevirtual 162	java/io/DataInputStream:read	([B)I
    //   147: pop
    //   148: aload_2
    //   149: aload_0
    //   150: invokevirtual 165	java/io/DataInputStream:readInt	()I
    //   153: putfield 89	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   156: aload_2
    //   157: aload_0
    //   158: invokevirtual 165	java/io/DataInputStream:readInt	()I
    //   161: putfield 95	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   164: aload 5
    //   166: aload_2
    //   167: invokeinterface 195 2 0
    //   172: pop
    //   173: goto -125 -> 48
    //   176: aload_0
    //   177: invokevirtual 158	java/io/DataInputStream:close	()V
    //   180: aload 5
    //   182: areturn
    //   183: astore_2
    //   184: goto +44 -> 228
    //   187: astore_3
    //   188: goto +15 -> 203
    //   191: astore_3
    //   192: aload_2
    //   193: astore_0
    //   194: aload_3
    //   195: astore_2
    //   196: goto +32 -> 228
    //   199: astore_3
    //   200: aload 4
    //   202: astore_0
    //   203: aload_0
    //   204: astore_2
    //   205: aload_3
    //   206: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   209: aload_0
    //   210: ifnull +15 -> 225
    //   213: aload_0
    //   214: invokevirtual 158	java/io/DataInputStream:close	()V
    //   217: aload 5
    //   219: areturn
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   225: aload 5
    //   227: areturn
    //   228: aload_0
    //   229: ifnull +15 -> 244
    //   232: aload_0
    //   233: invokevirtual 158	java/io/DataInputStream:close	()V
    //   236: goto +8 -> 244
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   244: goto +5 -> 249
    //   247: aload_2
    //   248: athrow
    //   249: goto -2 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramContext	Context
    //   0	252	1	paramInt	int
    //   15	152	2	localObject1	Object
    //   183	10	2	localObject2	Object
    //   195	53	2	localObject3	Object
    //   13	18	3	localObject4	Object
    //   187	1	3	localException1	Exception
    //   191	4	3	localObject5	Object
    //   199	7	3	localException2	Exception
    //   10	191	4	localObject6	Object
    //   7	219	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   48	66	183	finally
    //   73	115	183	finally
    //   118	126	183	finally
    //   129	173	183	finally
    //   48	66	187	java/lang/Exception
    //   73	115	187	java/lang/Exception
    //   118	126	187	java/lang/Exception
    //   129	173	187	java/lang/Exception
    //   16	24	191	finally
    //   32	48	191	finally
    //   205	209	191	finally
    //   16	24	199	java/lang/Exception
    //   32	48	199	java/lang/Exception
    //   176	180	220	java/lang/Exception
    //   213	217	220	java/lang/Exception
    //   232	236	239	java/lang/Exception
  }
  
  /* Error */
  private static byte[] loadFileContent(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 125	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 199	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 203	java/io/File:exists	()Z
    //   16: ifne +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 205	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 208	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_3
    //   30: aload_3
    //   31: astore_0
    //   32: aload_3
    //   33: invokevirtual 209	java/io/FileInputStream:available	()I
    //   36: istore_2
    //   37: iload_2
    //   38: istore_1
    //   39: iload_2
    //   40: sipush 4096
    //   43: if_icmple +7 -> 50
    //   46: sipush 4096
    //   49: istore_1
    //   50: aload_3
    //   51: astore_0
    //   52: iload_1
    //   53: newarray byte
    //   55: astore 4
    //   57: aload_3
    //   58: astore_0
    //   59: aload_3
    //   60: aload 4
    //   62: invokevirtual 210	java/io/FileInputStream:read	([B)I
    //   65: pop
    //   66: aload_3
    //   67: invokevirtual 211	java/io/FileInputStream:close	()V
    //   70: goto +8 -> 78
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   78: aload 4
    //   80: areturn
    //   81: astore 4
    //   83: goto +14 -> 97
    //   86: astore_3
    //   87: aload 4
    //   89: astore_0
    //   90: goto +32 -> 122
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_3
    //   97: aload_3
    //   98: astore_0
    //   99: aload 4
    //   101: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   104: aload_3
    //   105: ifnull +14 -> 119
    //   108: aload_3
    //   109: invokevirtual 211	java/io/FileInputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_3
    //   122: aload_0
    //   123: ifnull +15 -> 138
    //   126: aload_0
    //   127: invokevirtual 211	java/io/FileInputStream:close	()V
    //   130: goto +8 -> 138
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   138: aload_3
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   38	15	1	i	int
    //   36	8	2	j	int
    //   29	38	3	localFileInputStream	java.io.FileInputStream
    //   86	1	3	localObject1	Object
    //   96	13	3	localObject2	Object
    //   121	18	3	localObject3	Object
    //   1	78	4	arrayOfByte	byte[]
    //   81	7	4	localException1	Exception
    //   93	7	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   66	70	73	java/lang/Exception
    //   32	37	81	java/lang/Exception
    //   52	57	81	java/lang/Exception
    //   59	66	81	java/lang/Exception
    //   3	19	86	finally
    //   21	30	86	finally
    //   3	19	93	java/lang/Exception
    //   21	30	93	java/lang/Exception
    //   108	112	114	java/lang/Exception
    //   32	37	121	finally
    //   52	57	121	finally
    //   59	66	121	finally
    //   99	104	121	finally
    //   126	130	133	java/lang/Exception
  }
  
  /* Error */
  private static byte[] packExtraData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 35	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 36	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 38	java/io/DataOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 41	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 6
    //   20: aload 4
    //   22: astore_3
    //   23: aload 6
    //   25: astore 5
    //   27: aload 6
    //   29: iconst_1
    //   30: invokevirtual 78	java/io/DataOutputStream:writeByte	(I)V
    //   33: aload_0
    //   34: ifnull +23 -> 57
    //   37: aload 4
    //   39: astore_3
    //   40: aload 6
    //   42: astore 5
    //   44: aload_0
    //   45: arraylength
    //   46: i2b
    //   47: istore_2
    //   48: iload_2
    //   49: istore_1
    //   50: iload_2
    //   51: ifge +20 -> 71
    //   54: goto +218 -> 272
    //   57: aload 4
    //   59: astore_3
    //   60: aload 6
    //   62: astore 5
    //   64: iconst_0
    //   65: putstatic 177	com/tencent/loginsecsdk/ProtocolDet:cNum	B
    //   68: goto +204 -> 272
    //   71: aload 4
    //   73: astore_3
    //   74: aload 6
    //   76: astore 5
    //   78: aload 6
    //   80: getstatic 177	com/tencent/loginsecsdk/ProtocolDet:cNum	B
    //   83: invokevirtual 78	java/io/DataOutputStream:writeByte	(I)V
    //   86: iload_1
    //   87: ifle +18 -> 105
    //   90: aload 4
    //   92: astore_3
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: aload_0
    //   100: iconst_0
    //   101: iload_1
    //   102: invokevirtual 214	java/io/DataOutputStream:write	([BII)V
    //   105: aload 4
    //   107: astore_3
    //   108: aload 6
    //   110: astore 5
    //   112: aload 4
    //   114: invokevirtual 99	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   117: astore_0
    //   118: aload 4
    //   120: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   123: goto +8 -> 131
    //   126: astore_3
    //   127: aload_3
    //   128: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   131: aload 6
    //   133: invokevirtual 106	java/io/DataOutputStream:close	()V
    //   136: aload_0
    //   137: areturn
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   143: aload_0
    //   144: areturn
    //   145: astore_3
    //   146: aload 6
    //   148: astore_0
    //   149: aload_3
    //   150: astore 6
    //   152: goto +37 -> 189
    //   155: astore_0
    //   156: aconst_null
    //   157: astore 5
    //   159: aload 4
    //   161: astore_3
    //   162: goto +74 -> 236
    //   165: astore 6
    //   167: aconst_null
    //   168: astore_0
    //   169: goto +20 -> 189
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_3
    //   175: aload_3
    //   176: astore 5
    //   178: goto +58 -> 236
    //   181: astore 6
    //   183: aconst_null
    //   184: astore 4
    //   186: aload 4
    //   188: astore_0
    //   189: aload 4
    //   191: astore_3
    //   192: aload_0
    //   193: astore 5
    //   195: aload 6
    //   197: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   200: aload 4
    //   202: ifnull +16 -> 218
    //   205: aload 4
    //   207: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   210: goto +8 -> 218
    //   213: astore_3
    //   214: aload_3
    //   215: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   218: aload_0
    //   219: ifnull +14 -> 233
    //   222: aload_0
    //   223: invokevirtual 106	java/io/DataOutputStream:close	()V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_0
    //   236: aload_3
    //   237: ifnull +15 -> 252
    //   240: aload_3
    //   241: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   244: goto +8 -> 252
    //   247: astore_3
    //   248: aload_3
    //   249: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   252: aload 5
    //   254: ifnull +16 -> 270
    //   257: aload 5
    //   259: invokevirtual 106	java/io/DataOutputStream:close	()V
    //   262: goto +8 -> 270
    //   265: astore_3
    //   266: aload_3
    //   267: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   270: aload_0
    //   271: athrow
    //   272: iconst_0
    //   273: istore_1
    //   274: goto -203 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramArrayOfByte	byte[]
    //   49	225	1	i	int
    //   47	4	2	j	int
    //   22	86	3	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   126	2	3	localException1	Exception
    //   138	2	3	localException2	Exception
    //   145	5	3	localException3	Exception
    //   161	31	3	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   213	28	3	localException4	Exception
    //   247	2	3	localException5	Exception
    //   265	2	3	localException6	Exception
    //   7	199	4	localByteArrayOutputStream3	java.io.ByteArrayOutputStream
    //   25	233	5	localObject1	Object
    //   18	133	6	localObject2	Object
    //   165	1	6	localException7	Exception
    //   181	15	6	localException8	Exception
    // Exception table:
    //   from	to	target	type
    //   118	123	126	java/lang/Exception
    //   131	136	138	java/lang/Exception
    //   27	33	145	java/lang/Exception
    //   44	48	145	java/lang/Exception
    //   64	68	145	java/lang/Exception
    //   78	86	145	java/lang/Exception
    //   97	105	145	java/lang/Exception
    //   112	118	145	java/lang/Exception
    //   9	20	155	finally
    //   9	20	165	java/lang/Exception
    //   0	9	172	finally
    //   0	9	181	java/lang/Exception
    //   205	210	213	java/lang/Exception
    //   222	226	228	java/lang/Exception
    //   27	33	235	finally
    //   44	48	235	finally
    //   64	68	235	finally
    //   78	86	235	finally
    //   97	105	235	finally
    //   112	118	235	finally
    //   195	200	235	finally
    //   240	244	247	java/lang/Exception
    //   257	262	265	java/lang/Exception
  }
  
  public static int setLoginExtraData(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null))
    {
      if ((paramArrayOfByte.length != 21) && (paramArrayOfByte.length != 33)) {
        return -1;
      }
      paramArrayOfByte = getExtraDataFromBuffer(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return -1;
      }
      return updateCachedExtraDataFile(paramContext, paramArrayOfByte);
    }
    return -1;
  }
  
  private static int updateCachedExtraDataFile(Context paramContext, ProtocolDet.LoginExtraData paramLoginExtraData)
  {
    int k = 0;
    List localList = loadExtraDataFromFile(paramContext, 0);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      int i;
      int m;
      try
      {
        if (((List)localObject).size() < 3)
        {
          ((List)localObject).add(paramLoginExtraData);
        }
        else
        {
          j = ((ProtocolDet.LoginExtraData)((List)localObject).get(0)).mTime;
          int n = ((List)localObject).size();
          i = 1;
          if (i < n)
          {
            m = j;
            if (j <= ((ProtocolDet.LoginExtraData)((List)localObject).get(i)).mTime) {
              break label152;
            }
            m = ((ProtocolDet.LoginExtraData)((List)localObject).get(i)).mTime;
            k = i;
            break label152;
          }
          ((List)localObject).set(k, paramLoginExtraData);
        }
      }
      catch (Exception paramLoginExtraData)
      {
        paramLoginExtraData.printStackTrace();
      }
      return updateFile(paramContext, (List)localObject);
      label152:
      i += 1;
      int j = m;
    }
  }
  
  /* Error */
  private static int updateFile(Context paramContext, List<ProtocolDet.LoginExtraData> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload 4
    //   7: astore_2
    //   8: aload_0
    //   9: invokestatic 184	com/tencent/loginsecsdk/ProtocolDet:getCachedDetFileFullPath	(Landroid/content/Context;)Ljava/lang/String;
    //   12: astore_0
    //   13: aload 4
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 179	com/tencent/loginsecsdk/ProtocolDet:convertExtraDataListToBuffer	(Ljava/util/List;)[B
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +5 -> 27
    //   25: iconst_m1
    //   26: ireturn
    //   27: aload 4
    //   29: astore_2
    //   30: new 232	java/io/FileOutputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   38: astore_0
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 234	java/io/FileOutputStream:write	([B)V
    //   44: aload_0
    //   45: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   48: goto +44 -> 92
    //   51: astore_1
    //   52: aload_0
    //   53: astore_2
    //   54: aload_1
    //   55: astore_0
    //   56: goto +38 -> 94
    //   59: astore_1
    //   60: goto +10 -> 70
    //   63: astore_0
    //   64: goto +30 -> 94
    //   67: astore_1
    //   68: aload_3
    //   69: astore_0
    //   70: aload_0
    //   71: astore_2
    //   72: aload_1
    //   73: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   76: aload_0
    //   77: ifnull +15 -> 92
    //   80: aload_0
    //   81: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   84: goto +8 -> 92
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: aload_2
    //   95: ifnull +15 -> 110
    //   98: aload_2
    //   99: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   102: goto +8 -> 110
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   110: aload_0
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramContext	Context
    //   0	112	1	paramList	List<ProtocolDet.LoginExtraData>
    //   7	92	2	localObject1	Object
    //   1	68	3	localObject2	Object
    //   3	25	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	44	51	finally
    //   39	44	59	java/lang/Exception
    //   8	13	63	finally
    //   16	21	63	finally
    //   30	39	63	finally
    //   72	76	63	finally
    //   8	13	67	java/lang/Exception
    //   16	21	67	java/lang/Exception
    //   30	39	67	java/lang/Exception
    //   44	48	87	java/lang/Exception
    //   80	84	87	java/lang/Exception
    //   98	102	105	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.loginsecsdk.ProtocolDet
 * JD-Core Version:    0.7.0.1
 */