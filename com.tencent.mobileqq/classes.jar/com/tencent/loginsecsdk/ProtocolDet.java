package com.tencent.loginsecsdk;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProtocolDet
{
  private static final String DET_CACHE_FILE_NAME = "pd.dat";
  private static final int EXTRA_DATA_ITEM_SIZE = 20;
  private static final int MAX_CACHED_FILE_SIZE = 4096;
  private static final int MAX_CACHED_ITEM_COUNT = 3;
  
  /* Error */
  private static byte[] convertExtraDataListToBuffer(List<LoginExtraData> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 6
    //   15: new 29	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 30	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore_3
    //   23: new 32	java/io/DataOutputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 35	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 4
    //   33: aload_0
    //   34: invokeinterface 41 1 0
    //   39: istore_2
    //   40: iconst_0
    //   41: istore_1
    //   42: iload_1
    //   43: iload_2
    //   44: if_icmplt +28 -> 72
    //   47: aload_3
    //   48: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   51: astore_0
    //   52: aload_3
    //   53: ifnull +7 -> 60
    //   56: aload_3
    //   57: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   60: aload 4
    //   62: ifnull +8 -> 70
    //   65: aload 4
    //   67: invokevirtual 49	java/io/DataOutputStream:close	()V
    //   70: aload_0
    //   71: areturn
    //   72: aload 4
    //   74: aload_0
    //   75: iload_1
    //   76: invokeinterface 53 2 0
    //   81: checkcast 6	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   84: getfield 57	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   87: invokevirtual 61	java/io/DataOutputStream:writeLong	(J)V
    //   90: aload 4
    //   92: aload_0
    //   93: iload_1
    //   94: invokeinterface 53 2 0
    //   99: checkcast 6	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   102: getfield 64	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	I
    //   105: invokevirtual 68	java/io/DataOutputStream:writeInt	(I)V
    //   108: aload 4
    //   110: aload_0
    //   111: iload_1
    //   112: invokeinterface 53 2 0
    //   117: checkcast 6	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   120: getfield 71	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   123: invokevirtual 68	java/io/DataOutputStream:writeInt	(I)V
    //   126: aload 4
    //   128: aload_0
    //   129: iload_1
    //   130: invokeinterface 53 2 0
    //   135: checkcast 6	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   138: getfield 74	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   141: invokevirtual 68	java/io/DataOutputStream:writeInt	(I)V
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -106 -> 42
    //   151: astore_3
    //   152: aload_3
    //   153: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   156: goto -96 -> 60
    //   159: astore_3
    //   160: aload_3
    //   161: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   164: goto -94 -> 70
    //   167: astore_3
    //   168: aload 8
    //   170: astore_0
    //   171: aload_0
    //   172: astore 4
    //   174: aload 6
    //   176: astore 5
    //   178: aload_3
    //   179: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   190: aload 6
    //   192: ifnull +8 -> 200
    //   195: aload 6
    //   197: invokevirtual 49	java/io/DataOutputStream:close	()V
    //   200: aconst_null
    //   201: areturn
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   207: goto -17 -> 190
    //   210: astore_0
    //   211: aload_0
    //   212: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   215: goto -15 -> 200
    //   218: astore_0
    //   219: aload 4
    //   221: ifnull +8 -> 229
    //   224: aload 4
    //   226: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   229: aload 5
    //   231: ifnull +8 -> 239
    //   234: aload 5
    //   236: invokevirtual 49	java/io/DataOutputStream:close	()V
    //   239: aload_0
    //   240: athrow
    //   241: astore_3
    //   242: aload_3
    //   243: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   246: goto -17 -> 229
    //   249: astore_3
    //   250: aload_3
    //   251: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   254: goto -15 -> 239
    //   257: astore_0
    //   258: aload_3
    //   259: astore 4
    //   261: aload 7
    //   263: astore 5
    //   265: goto -46 -> 219
    //   268: astore_0
    //   269: aload 4
    //   271: astore 5
    //   273: aload_3
    //   274: astore 4
    //   276: goto -57 -> 219
    //   279: astore 4
    //   281: aload_3
    //   282: astore_0
    //   283: aload 4
    //   285: astore_3
    //   286: goto -115 -> 171
    //   289: astore 5
    //   291: aload_3
    //   292: astore_0
    //   293: aload 5
    //   295: astore_3
    //   296: aload 4
    //   298: astore 6
    //   300: goto -129 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramList	List<LoginExtraData>
    //   41	107	1	i	int
    //   39	6	2	j	int
    //   22	35	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   151	2	3	localIOException1	java.io.IOException
    //   159	2	3	localIOException2	java.io.IOException
    //   167	12	3	localIOException3	java.io.IOException
    //   241	2	3	localIOException4	java.io.IOException
    //   249	33	3	localIOException5	java.io.IOException
    //   285	11	3	localIOException6	java.io.IOException
    //   1	274	4	localObject1	Object
    //   279	18	4	localIOException7	java.io.IOException
    //   7	265	5	localObject2	Object
    //   289	5	5	localIOException8	java.io.IOException
    //   13	286	6	localIOException9	java.io.IOException
    //   10	252	7	localObject3	Object
    //   4	165	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   56	60	151	java/io/IOException
    //   65	70	159	java/io/IOException
    //   15	23	167	java/io/IOException
    //   186	190	202	java/io/IOException
    //   195	200	210	java/io/IOException
    //   15	23	218	finally
    //   178	182	218	finally
    //   224	229	241	java/io/IOException
    //   234	239	249	java/io/IOException
    //   23	33	257	finally
    //   33	40	268	finally
    //   47	52	268	finally
    //   72	144	268	finally
    //   23	33	279	java/io/IOException
    //   33	40	289	java/io/IOException
    //   47	52	289	java/io/IOException
    //   72	144	289	java/io/IOException
  }
  
  private static String getCachedDetFileFullPath(Context paramContext)
  {
    return paramContext.getFilesDir() + File.separator + "pd.dat";
  }
  
  /* Error */
  private static LoginExtraData getExtraDataFromBuffer(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_2
    //   6: new 6	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   9: dup
    //   10: aconst_null
    //   11: invokespecial 111	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:<init>	(Lcom/tencent/loginsecsdk/ProtocolDet$LoginExtraData;)V
    //   14: astore 4
    //   16: new 113	java/io/DataInputStream
    //   19: dup
    //   20: new 115	java/io/ByteArrayInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 118	java/io/ByteArrayInputStream:<init>	([B)V
    //   28: invokespecial 121	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_0
    //   32: aload 4
    //   34: aload_0
    //   35: invokevirtual 125	java/io/DataInputStream:readLong	()J
    //   38: putfield 57	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   41: aload 4
    //   43: aload_0
    //   44: invokevirtual 128	java/io/DataInputStream:readInt	()I
    //   47: putfield 64	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	I
    //   50: aload 4
    //   52: aload_0
    //   53: invokevirtual 128	java/io/DataInputStream:readInt	()I
    //   56: putfield 71	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   59: aload 4
    //   61: aload_0
    //   62: invokevirtual 128	java/io/DataInputStream:readInt	()I
    //   65: putfield 74	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   68: aload_0
    //   69: ifnull +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 129	java/io/DataInputStream:close	()V
    //   76: aload 4
    //   78: areturn
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   84: goto -8 -> 76
    //   87: astore_0
    //   88: aload_2
    //   89: astore_1
    //   90: aload_0
    //   91: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 129	java/io/DataInputStream:close	()V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   109: goto -7 -> 102
    //   112: astore_0
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 129	java/io/DataInputStream:close	()V
    //   121: aload_0
    //   122: athrow
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   128: goto -7 -> 121
    //   131: astore_0
    //   132: aload_3
    //   133: astore_1
    //   134: goto -21 -> 113
    //   137: astore_2
    //   138: aload_0
    //   139: astore_1
    //   140: aload_2
    //   141: astore_0
    //   142: goto -29 -> 113
    //   145: astore_0
    //   146: goto -58 -> 88
    //   149: astore_1
    //   150: aload_0
    //   151: astore_2
    //   152: aload_1
    //   153: astore_0
    //   154: goto -66 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramArrayOfByte	byte[]
    //   1	117	1	localObject1	Object
    //   123	2	1	localIOException1	java.io.IOException
    //   133	7	1	localObject2	Object
    //   149	4	1	localIOException2	java.io.IOException
    //   5	94	2	localObject3	Object
    //   137	4	2	localObject4	Object
    //   151	1	2	arrayOfByte	byte[]
    //   3	130	3	localObject5	Object
    //   14	63	4	localLoginExtraData	LoginExtraData
    // Exception table:
    //   from	to	target	type
    //   72	76	79	java/io/IOException
    //   6	16	87	java/io/IOException
    //   98	102	104	java/io/IOException
    //   6	16	112	finally
    //   90	94	112	finally
    //   117	121	123	java/io/IOException
    //   16	32	131	finally
    //   32	68	137	finally
    //   16	32	145	java/io/IOException
    //   32	68	149	java/io/IOException
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
    return packExtraData(convertExtraDataListToBuffer(paramContext));
  }
  
  /* Error */
  private static List<LoginExtraData> loadExtraDataFromFile(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 143	com/tencent/loginsecsdk/ProtocolDet:getCachedDetFileFullPath	(Landroid/content/Context;)Ljava/lang/String;
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: new 145	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 146	java/util/ArrayList:<init>	()V
    //   19: astore 6
    //   21: aload 4
    //   23: astore_0
    //   24: aload 7
    //   26: invokestatic 150	com/tencent/loginsecsdk/ProtocolDet:loadFileContent	(Ljava/lang/String;)[B
    //   29: astore 7
    //   31: aload 7
    //   33: ifnonnull +27 -> 60
    //   36: iconst_0
    //   37: ifeq +11 -> 48
    //   40: new 152	java/lang/NullPointerException
    //   43: dup
    //   44: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   47: athrow
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   57: goto -9 -> 48
    //   60: aload 4
    //   62: astore_0
    //   63: new 113	java/io/DataInputStream
    //   66: dup
    //   67: new 115	java/io/ByteArrayInputStream
    //   70: dup
    //   71: aload 7
    //   73: invokespecial 118	java/io/ByteArrayInputStream:<init>	([B)V
    //   76: invokespecial 121	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: astore 4
    //   81: aload 7
    //   83: arraylength
    //   84: bipush 20
    //   86: idiv
    //   87: istore_3
    //   88: iconst_0
    //   89: istore_2
    //   90: iload_2
    //   91: iload_3
    //   92: if_icmplt +16 -> 108
    //   95: aload 4
    //   97: ifnull +147 -> 244
    //   100: aload 4
    //   102: invokevirtual 129	java/io/DataInputStream:close	()V
    //   105: aload 6
    //   107: areturn
    //   108: iload_1
    //   109: ifeq +8 -> 117
    //   112: iload_2
    //   113: iload_1
    //   114: if_icmpge -19 -> 95
    //   117: new 6	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   120: dup
    //   121: aconst_null
    //   122: invokespecial 111	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:<init>	(Lcom/tencent/loginsecsdk/ProtocolDet$LoginExtraData;)V
    //   125: astore_0
    //   126: aload_0
    //   127: aload 4
    //   129: invokevirtual 125	java/io/DataInputStream:readLong	()J
    //   132: putfield 57	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   135: aload_0
    //   136: aload 4
    //   138: invokevirtual 128	java/io/DataInputStream:readInt	()I
    //   141: putfield 64	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	I
    //   144: aload_0
    //   145: aload 4
    //   147: invokevirtual 128	java/io/DataInputStream:readInt	()I
    //   150: putfield 71	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   153: aload_0
    //   154: aload 4
    //   156: invokevirtual 128	java/io/DataInputStream:readInt	()I
    //   159: putfield 74	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   162: aload 6
    //   164: aload_0
    //   165: invokeinterface 157 2 0
    //   170: pop
    //   171: iload_2
    //   172: iconst_1
    //   173: iadd
    //   174: istore_2
    //   175: goto -85 -> 90
    //   178: astore_0
    //   179: aload 5
    //   181: astore 4
    //   183: aload_0
    //   184: astore 5
    //   186: aload 4
    //   188: astore_0
    //   189: aload 5
    //   191: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   194: aload 6
    //   196: astore_0
    //   197: aload 4
    //   199: ifnull -149 -> 50
    //   202: aload 4
    //   204: invokevirtual 129	java/io/DataInputStream:close	()V
    //   207: aload 6
    //   209: areturn
    //   210: astore_0
    //   211: aload_0
    //   212: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   215: aload 6
    //   217: areturn
    //   218: astore 4
    //   220: aload_0
    //   221: ifnull +7 -> 228
    //   224: aload_0
    //   225: invokevirtual 129	java/io/DataInputStream:close	()V
    //   228: aload 4
    //   230: athrow
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   236: goto -8 -> 228
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   244: aload 6
    //   246: areturn
    //   247: astore 5
    //   249: aload 4
    //   251: astore_0
    //   252: aload 5
    //   254: astore 4
    //   256: goto -36 -> 220
    //   259: astore 5
    //   261: goto -75 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   0	264	1	paramInt	int
    //   89	86	2	i	int
    //   87	6	3	j	int
    //   7	196	4	localObject1	Object
    //   218	32	4	localObject2	Object
    //   254	1	4	localObject3	Object
    //   10	180	5	localContext	Context
    //   247	6	5	localObject4	Object
    //   259	1	5	localIOException	java.io.IOException
    //   19	226	6	localArrayList	ArrayList
    //   4	78	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   40	48	52	java/io/IOException
    //   24	31	178	java/io/IOException
    //   63	81	178	java/io/IOException
    //   202	207	210	java/io/IOException
    //   24	31	218	finally
    //   63	81	218	finally
    //   189	194	218	finally
    //   224	228	231	java/io/IOException
    //   100	105	239	java/io/IOException
    //   81	88	247	finally
    //   117	171	247	finally
    //   81	88	259	java/io/IOException
    //   117	171	259	java/io/IOException
  }
  
  /* Error */
  private static byte[] loadFileContent(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 96	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 165	java/io/File:exists	()Z
    //   20: ifne +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: aload_3
    //   26: astore_0
    //   27: new 167	java/io/FileInputStream
    //   30: dup
    //   31: aload 5
    //   33: invokespecial 170	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 173	java/io/FileInputStream:available	()I
    //   41: istore_2
    //   42: iload_2
    //   43: istore_1
    //   44: iload_2
    //   45: sipush 4096
    //   48: if_icmple +7 -> 55
    //   51: sipush 4096
    //   54: istore_1
    //   55: iload_1
    //   56: newarray byte
    //   58: astore_0
    //   59: aload_3
    //   60: aload_0
    //   61: invokevirtual 177	java/io/FileInputStream:read	([B)I
    //   64: pop
    //   65: aload_3
    //   66: ifnull +64 -> 130
    //   69: aload_3
    //   70: invokevirtual 178	java/io/FileInputStream:close	()V
    //   73: aload_0
    //   74: areturn
    //   75: astore_0
    //   76: aload 4
    //   78: astore_3
    //   79: aload_0
    //   80: astore 4
    //   82: aload_3
    //   83: astore_0
    //   84: aload 4
    //   86: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   89: aload_3
    //   90: ifnull -67 -> 23
    //   93: aload_3
    //   94: invokevirtual 178	java/io/FileInputStream:close	()V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_3
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 178	java/io/FileInputStream:close	()V
    //   115: aload_3
    //   116: athrow
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   130: aload_0
    //   131: areturn
    //   132: astore 4
    //   134: aload_3
    //   135: astore_0
    //   136: aload 4
    //   138: astore_3
    //   139: goto -32 -> 107
    //   142: astore 4
    //   144: goto -62 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   43	13	1	i	int
    //   41	8	2	j	int
    //   1	93	3	localObject1	Object
    //   106	10	3	localObject2	Object
    //   125	10	3	localIOException1	java.io.IOException
    //   138	1	3	localObject3	Object
    //   3	82	4	str	String
    //   132	5	4	localObject4	Object
    //   142	1	4	localIOException2	java.io.IOException
    //   13	19	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   27	37	75	java/io/IOException
    //   93	97	99	java/io/IOException
    //   27	37	106	finally
    //   84	89	106	finally
    //   111	115	117	java/io/IOException
    //   69	73	125	java/io/IOException
    //   37	42	132	finally
    //   55	65	132	finally
    //   37	42	142	java/io/IOException
    //   55	65	142	java/io/IOException
  }
  
  /* Error */
  private static byte[] packExtraData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 6
    //   15: new 29	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 30	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore_3
    //   23: new 32	java/io/DataOutputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 35	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 4
    //   33: aload 4
    //   35: iconst_1
    //   36: invokevirtual 181	java/io/DataOutputStream:writeByte	(I)V
    //   39: iconst_0
    //   40: istore_1
    //   41: aload_0
    //   42: ifnull +15 -> 57
    //   45: aload_0
    //   46: arraylength
    //   47: i2b
    //   48: istore_2
    //   49: iload_2
    //   50: istore_1
    //   51: iload_2
    //   52: ifge +5 -> 57
    //   55: iconst_0
    //   56: istore_1
    //   57: aload 4
    //   59: iload_1
    //   60: invokevirtual 181	java/io/DataOutputStream:writeByte	(I)V
    //   63: iload_1
    //   64: ifle +11 -> 75
    //   67: aload 4
    //   69: aload_0
    //   70: iconst_0
    //   71: iload_1
    //   72: invokevirtual 185	java/io/DataOutputStream:write	([BII)V
    //   75: aload_3
    //   76: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   79: astore_0
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   88: aload 4
    //   90: ifnull +8 -> 98
    //   93: aload 4
    //   95: invokevirtual 49	java/io/DataOutputStream:close	()V
    //   98: aload_0
    //   99: areturn
    //   100: astore_3
    //   101: aload_3
    //   102: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   105: goto -17 -> 88
    //   108: astore_3
    //   109: aload_3
    //   110: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   113: goto -15 -> 98
    //   116: astore_3
    //   117: aload 8
    //   119: astore_0
    //   120: aload 6
    //   122: astore 4
    //   124: aload_0
    //   125: astore 5
    //   127: aload_3
    //   128: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   139: aload 6
    //   141: ifnull +8 -> 149
    //   144: aload 6
    //   146: invokevirtual 49	java/io/DataOutputStream:close	()V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_0
    //   152: aload_0
    //   153: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   156: goto -17 -> 139
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   164: goto -15 -> 149
    //   167: astore_0
    //   168: aload 5
    //   170: ifnull +8 -> 178
    //   173: aload 5
    //   175: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   178: aload 4
    //   180: ifnull +8 -> 188
    //   183: aload 4
    //   185: invokevirtual 49	java/io/DataOutputStream:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_3
    //   191: aload_3
    //   192: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   195: goto -17 -> 178
    //   198: astore_3
    //   199: aload_3
    //   200: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   203: goto -15 -> 188
    //   206: astore_0
    //   207: aload 7
    //   209: astore 4
    //   211: aload_3
    //   212: astore 5
    //   214: goto -46 -> 168
    //   217: astore_0
    //   218: aload_3
    //   219: astore 5
    //   221: goto -53 -> 168
    //   224: astore 4
    //   226: aload_3
    //   227: astore_0
    //   228: aload 4
    //   230: astore_3
    //   231: goto -111 -> 120
    //   234: astore 5
    //   236: aload_3
    //   237: astore_0
    //   238: aload 5
    //   240: astore_3
    //   241: aload 4
    //   243: astore 6
    //   245: goto -125 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramArrayOfByte	byte[]
    //   40	32	1	i	int
    //   48	4	2	j	int
    //   22	63	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   100	2	3	localIOException1	java.io.IOException
    //   108	2	3	localIOException2	java.io.IOException
    //   116	12	3	localIOException3	java.io.IOException
    //   190	2	3	localIOException4	java.io.IOException
    //   198	29	3	localIOException5	java.io.IOException
    //   230	11	3	localIOException6	java.io.IOException
    //   7	203	4	localObject1	Object
    //   224	18	4	localIOException7	java.io.IOException
    //   1	219	5	localObject2	Object
    //   234	5	5	localIOException8	java.io.IOException
    //   13	231	6	localIOException9	java.io.IOException
    //   10	198	7	localObject3	Object
    //   4	114	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   84	88	100	java/io/IOException
    //   93	98	108	java/io/IOException
    //   15	23	116	java/io/IOException
    //   135	139	151	java/io/IOException
    //   144	149	159	java/io/IOException
    //   15	23	167	finally
    //   127	131	167	finally
    //   173	178	190	java/io/IOException
    //   183	188	198	java/io/IOException
    //   23	33	206	finally
    //   33	39	217	finally
    //   45	49	217	finally
    //   57	63	217	finally
    //   67	75	217	finally
    //   75	80	217	finally
    //   23	33	224	java/io/IOException
    //   33	39	234	java/io/IOException
    //   45	49	234	java/io/IOException
    //   57	63	234	java/io/IOException
    //   67	75	234	java/io/IOException
    //   75	80	234	java/io/IOException
  }
  
  public static int setLoginExtraData(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length < 20)) {}
    do
    {
      return -1;
      paramArrayOfByte = getExtraDataFromBuffer(paramArrayOfByte);
    } while (paramArrayOfByte == null);
    return updateCachedExtraDataFile(paramContext, paramArrayOfByte);
  }
  
  private static int updateCachedExtraDataFile(Context paramContext, LoginExtraData paramLoginExtraData)
  {
    List localList = loadExtraDataFromFile(paramContext, 0);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    if (((List)localObject).size() < 3)
    {
      ((List)localObject).add(paramLoginExtraData);
      return updateFile(paramContext, (List)localObject);
    }
    int m = 0;
    int j = ((LoginExtraData)((List)localObject).get(0)).mTime;
    int n = ((List)localObject).size();
    int i = 1;
    for (;;)
    {
      if (i >= n)
      {
        ((List)localObject).set(m, paramLoginExtraData);
        break;
      }
      int k = j;
      if (j > ((LoginExtraData)((List)localObject).get(i)).mTime)
      {
        k = ((LoginExtraData)((List)localObject).get(i)).mTime;
        m = i;
      }
      i += 1;
      j = k;
    }
  }
  
  /* Error */
  private static int updateFile(Context paramContext, List<LoginExtraData> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 143	com/tencent/loginsecsdk/ProtocolDet:getCachedDetFileFullPath	(Landroid/content/Context;)Ljava/lang/String;
    //   4: astore_3
    //   5: aload_1
    //   6: invokestatic 141	com/tencent/loginsecsdk/ProtocolDet:convertExtraDataListToBuffer	(Ljava/util/List;)[B
    //   9: astore 4
    //   11: aload 4
    //   13: ifnonnull +5 -> 18
    //   16: iconst_m1
    //   17: ireturn
    //   18: aconst_null
    //   19: astore_0
    //   20: aconst_null
    //   21: astore_2
    //   22: new 203	java/io/FileOutputStream
    //   25: dup
    //   26: aload_3
    //   27: invokespecial 204	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: aload 4
    //   34: invokevirtual 206	java/io/FileOutputStream:write	([B)V
    //   37: aload_1
    //   38: ifnull +63 -> 101
    //   41: aload_1
    //   42: invokevirtual 207	java/io/FileOutputStream:close	()V
    //   45: iconst_0
    //   46: ireturn
    //   47: astore_0
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: astore_2
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   58: aload_1
    //   59: ifnull -14 -> 45
    //   62: aload_1
    //   63: invokevirtual 207	java/io/FileOutputStream:close	()V
    //   66: goto -21 -> 45
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   74: goto -29 -> 45
    //   77: astore_1
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 207	java/io/FileOutputStream:close	()V
    //   86: aload_1
    //   87: athrow
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   93: goto -7 -> 86
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   101: goto -56 -> 45
    //   104: astore_2
    //   105: aload_1
    //   106: astore_0
    //   107: aload_2
    //   108: astore_1
    //   109: goto -31 -> 78
    //   112: astore_2
    //   113: goto -61 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramContext	Context
    //   0	116	1	paramList	List<LoginExtraData>
    //   21	34	2	localContext	Context
    //   104	4	2	localObject	Object
    //   112	1	2	localIOException	java.io.IOException
    //   4	23	3	str	String
    //   9	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	31	47	java/io/IOException
    //   62	66	69	java/io/IOException
    //   22	31	77	finally
    //   54	58	77	finally
    //   82	86	88	java/io/IOException
    //   41	45	96	java/io/IOException
    //   31	37	104	finally
    //   31	37	112	java/io/IOException
  }
  
  private static class LoginExtraData
  {
    int mIp;
    int mTime;
    long mUin;
    int mVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.loginsecsdk.ProtocolDet
 * JD-Core Version:    0.7.0.1
 */