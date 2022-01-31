import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class bcuk
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  private static JSONObject a(File paramFile)
  {
    int m = 0;
    int i;
    int j;
    if (paramFile.isDirectory())
    {
      i = 8;
      if (!paramFile.canWrite()) {
        break label104;
      }
      j = 4;
      label22:
      if (!paramFile.canRead()) {
        break label109;
      }
    }
    label104:
    label109:
    for (int k = 2;; k = 0)
    {
      if (paramFile.canExecute()) {
        m = 1;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("permission", Integer.toOctalString(k | 0x0 | i | j | m));
      localJSONObject.put("lastModified", a.format(new Date(paramFile.lastModified())));
      return localJSONObject;
      i = 0;
      break;
      j = 0;
      break label22;
    }
  }
  
  /* Error */
  public static void a(File paramFile, List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: aload_0
    //   13: ifnull +16 -> 29
    //   16: aload_1
    //   17: ifnull +12 -> 29
    //   20: aload_1
    //   21: invokeinterface 73 1 0
    //   26: ifeq +4 -> 30
    //   29: return
    //   30: new 75	java/io/FileOutputStream
    //   33: dup
    //   34: new 22	java/io/File
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore_2
    //   46: new 81	java/util/zip/ZipOutputStream
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 84	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore 6
    //   56: aload_1
    //   57: invokeinterface 88 1 0
    //   62: astore_1
    //   63: aload_1
    //   64: invokeinterface 93 1 0
    //   69: ifeq +101 -> 170
    //   72: aload 6
    //   74: new 22	java/io/File
    //   77: dup
    //   78: aload_0
    //   79: aload_1
    //   80: invokeinterface 97 1 0
    //   85: checkcast 99	java/lang/String
    //   88: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   91: aload_0
    //   92: invokevirtual 106	java/io/File:getPath	()Ljava/lang/String;
    //   95: invokevirtual 110	java/lang/String:length	()I
    //   98: iconst_1
    //   99: iadd
    //   100: invokestatic 113	bcuk:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;I)V
    //   103: goto -40 -> 63
    //   106: astore_0
    //   107: aload 6
    //   109: astore_1
    //   110: ldc 115
    //   112: iconst_1
    //   113: new 117	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   120: ldc 120
    //   122: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: invokevirtual 127	java/io/IOException:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_0
    //   139: invokevirtual 140	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   142: astore_0
    //   143: iconst_0
    //   144: istore_3
    //   145: iload_3
    //   146: aload_0
    //   147: arraylength
    //   148: if_icmpge +102 -> 250
    //   151: ldc 115
    //   153: iconst_1
    //   154: aload_0
    //   155: iload_3
    //   156: aaload
    //   157: invokevirtual 143	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   160: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: iload_3
    //   164: iconst_1
    //   165: iadd
    //   166: istore_3
    //   167: goto -22 -> 145
    //   170: aload 6
    //   172: ifnull +8 -> 180
    //   175: aload 6
    //   177: invokevirtual 146	java/util/zip/ZipOutputStream:close	()V
    //   180: aload_2
    //   181: ifnull -152 -> 29
    //   184: aload_2
    //   185: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   188: return
    //   189: astore_0
    //   190: ldc 115
    //   192: iconst_1
    //   193: new 117	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   200: ldc 120
    //   202: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: invokevirtual 127	java/io/IOException:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: invokevirtual 140	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   222: astore_0
    //   223: iconst_0
    //   224: istore_3
    //   225: iload_3
    //   226: aload_0
    //   227: arraylength
    //   228: if_icmpge -199 -> 29
    //   231: ldc 115
    //   233: iconst_1
    //   234: aload_0
    //   235: iload_3
    //   236: aaload
    //   237: invokevirtual 143	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   240: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iload_3
    //   244: iconst_1
    //   245: iadd
    //   246: istore_3
    //   247: goto -22 -> 225
    //   250: aload_1
    //   251: ifnull +7 -> 258
    //   254: aload_1
    //   255: invokevirtual 146	java/util/zip/ZipOutputStream:close	()V
    //   258: aload_2
    //   259: ifnull -230 -> 29
    //   262: aload_2
    //   263: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   266: return
    //   267: astore_0
    //   268: ldc 115
    //   270: iconst_1
    //   271: new 117	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   278: ldc 120
    //   280: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_0
    //   284: invokevirtual 127	java/io/IOException:getMessage	()Ljava/lang/String;
    //   287: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload_0
    //   297: invokevirtual 140	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   300: astore_0
    //   301: iload 4
    //   303: istore_3
    //   304: iload_3
    //   305: aload_0
    //   306: arraylength
    //   307: if_icmpge -278 -> 29
    //   310: ldc 115
    //   312: iconst_1
    //   313: aload_0
    //   314: iload_3
    //   315: aaload
    //   316: invokevirtual 143	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   319: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: iload_3
    //   323: iconst_1
    //   324: iadd
    //   325: istore_3
    //   326: goto -22 -> 304
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_1
    //   332: aload 7
    //   334: astore_2
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 146	java/util/zip/ZipOutputStream:close	()V
    //   343: aload_2
    //   344: ifnull +7 -> 351
    //   347: aload_2
    //   348: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   351: aload_0
    //   352: athrow
    //   353: astore_1
    //   354: ldc 115
    //   356: iconst_1
    //   357: new 117	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   364: ldc 120
    //   366: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_1
    //   370: invokevirtual 127	java/io/IOException:getMessage	()Ljava/lang/String;
    //   373: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload_1
    //   383: invokevirtual 140	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   386: astore_1
    //   387: iload 5
    //   389: istore_3
    //   390: iload_3
    //   391: aload_1
    //   392: arraylength
    //   393: if_icmpge -42 -> 351
    //   396: ldc 115
    //   398: iconst_1
    //   399: aload_1
    //   400: iload_3
    //   401: aaload
    //   402: invokevirtual 143	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   405: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: iload_3
    //   409: iconst_1
    //   410: iadd
    //   411: istore_3
    //   412: goto -22 -> 390
    //   415: astore_0
    //   416: aconst_null
    //   417: astore_1
    //   418: goto -83 -> 335
    //   421: astore_0
    //   422: aload 6
    //   424: astore_1
    //   425: goto -90 -> 335
    //   428: astore_0
    //   429: goto -94 -> 335
    //   432: astore_0
    //   433: aconst_null
    //   434: astore_1
    //   435: aload 6
    //   437: astore_2
    //   438: goto -328 -> 110
    //   441: astore_0
    //   442: aconst_null
    //   443: astore_1
    //   444: goto -334 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramFile	File
    //   0	447	1	paramList	List<String>
    //   0	447	2	paramString	String
    //   144	268	3	i	int
    //   10	292	4	j	int
    //   7	381	5	k	int
    //   4	432	6	localZipOutputStream	ZipOutputStream
    //   1	332	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	63	106	java/io/IOException
    //   63	103	106	java/io/IOException
    //   175	180	189	java/io/IOException
    //   184	188	189	java/io/IOException
    //   254	258	267	java/io/IOException
    //   262	266	267	java/io/IOException
    //   30	46	329	finally
    //   339	343	353	java/io/IOException
    //   347	351	353	java/io/IOException
    //   46	56	415	finally
    //   56	63	421	finally
    //   63	103	421	finally
    //   110	143	428	finally
    //   145	163	428	finally
    //   30	46	432	java/io/IOException
    //   46	56	441	java/io/IOException
  }
  
  public static void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        File localFile = new File((String)paramList.next());
        if ((localFile.exists()) && (localFile.isFile())) {
          localFile.delete();
        }
      }
    }
  }
  
  /* Error */
  public static void a(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_0
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 81	java/util/zip/ZipOutputStream
    //   11: dup
    //   12: new 75	java/io/FileOutputStream
    //   15: dup
    //   16: new 22	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: invokespecial 84	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore 9
    //   32: aload_0
    //   33: invokeinterface 88 1 0
    //   38: astore 11
    //   40: aload 11
    //   42: invokeinterface 93 1 0
    //   47: ifeq +313 -> 360
    //   50: aload 11
    //   52: invokeinterface 97 1 0
    //   57: checkcast 99	java/lang/String
    //   60: astore 12
    //   62: new 22	java/io/File
    //   65: dup
    //   66: aload 12
    //   68: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 10
    //   73: aload 10
    //   75: invokevirtual 153	java/io/File:exists	()Z
    //   78: ifeq -38 -> 40
    //   81: aload 10
    //   83: invokevirtual 163	java/io/File:length	()J
    //   86: lstore 7
    //   88: new 165	java/io/FileInputStream
    //   91: dup
    //   92: aload 10
    //   94: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: astore_1
    //   98: aload_1
    //   99: astore_0
    //   100: aload 9
    //   102: new 168	java/util/zip/ZipEntry
    //   105: dup
    //   106: aload 10
    //   108: invokevirtual 171	java/io/File:getName	()Ljava/lang/String;
    //   111: invokespecial 172	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   114: invokevirtual 176	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   117: aload_1
    //   118: astore_0
    //   119: aload 9
    //   121: bipush 9
    //   123: invokevirtual 180	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   126: aload_1
    //   127: astore_0
    //   128: sipush 20480
    //   131: newarray byte
    //   133: astore 10
    //   135: lconst_0
    //   136: lstore_3
    //   137: aload_1
    //   138: astore_0
    //   139: aload_1
    //   140: aload 10
    //   142: iconst_0
    //   143: sipush 20480
    //   146: invokevirtual 184	java/io/FileInputStream:read	([BII)I
    //   149: istore_2
    //   150: iload_2
    //   151: iconst_m1
    //   152: if_icmpeq +31 -> 183
    //   155: aload_1
    //   156: astore_0
    //   157: aload 9
    //   159: aload 10
    //   161: iconst_0
    //   162: iload_2
    //   163: invokevirtual 188	java/util/zip/ZipOutputStream:write	([BII)V
    //   166: lload_3
    //   167: iload_2
    //   168: i2l
    //   169: ladd
    //   170: lstore 5
    //   172: lload 5
    //   174: lstore_3
    //   175: lload 5
    //   177: lload 7
    //   179: lcmp
    //   180: iflt -43 -> 137
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 189	java/io/FileInputStream:close	()V
    //   191: aload 9
    //   193: invokevirtual 192	java/util/zip/ZipOutputStream:flush	()V
    //   196: aload 9
    //   198: invokevirtual 195	java/util/zip/ZipOutputStream:closeEntry	()V
    //   201: goto -161 -> 40
    //   204: astore_1
    //   205: aload 9
    //   207: astore_0
    //   208: ldc 115
    //   210: iconst_1
    //   211: ldc 197
    //   213: aload_1
    //   214: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_0
    //   218: ifnull +7 -> 225
    //   221: aload_0
    //   222: invokevirtual 146	java/util/zip/ZipOutputStream:close	()V
    //   225: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +11 -> 239
    //   231: ldc 115
    //   233: iconst_2
    //   234: ldc 205
    //   236: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq -235 -> 7
    //   245: ldc 115
    //   247: iconst_2
    //   248: ldc 210
    //   250: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: return
    //   254: astore 10
    //   256: aconst_null
    //   257: astore_1
    //   258: aload_1
    //   259: astore_0
    //   260: ldc 115
    //   262: iconst_1
    //   263: new 117	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   270: ldc 215
    //   272: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 12
    //   277: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: aload 10
    //   285: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: aload_1
    //   289: ifnull +7 -> 296
    //   292: aload_1
    //   293: invokevirtual 189	java/io/FileInputStream:close	()V
    //   296: aload 9
    //   298: invokevirtual 192	java/util/zip/ZipOutputStream:flush	()V
    //   301: aload 9
    //   303: invokevirtual 195	java/util/zip/ZipOutputStream:closeEntry	()V
    //   306: goto -266 -> 40
    //   309: astore_0
    //   310: aload 9
    //   312: astore_1
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokevirtual 146	java/util/zip/ZipOutputStream:close	()V
    //   321: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq +11 -> 335
    //   327: ldc 115
    //   329: iconst_2
    //   330: ldc 205
    //   332: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_0
    //   336: athrow
    //   337: astore_1
    //   338: aconst_null
    //   339: astore_0
    //   340: aload_0
    //   341: ifnull +7 -> 348
    //   344: aload_0
    //   345: invokevirtual 189	java/io/FileInputStream:close	()V
    //   348: aload 9
    //   350: invokevirtual 192	java/util/zip/ZipOutputStream:flush	()V
    //   353: aload 9
    //   355: invokevirtual 195	java/util/zip/ZipOutputStream:closeEntry	()V
    //   358: aload_1
    //   359: athrow
    //   360: aload 9
    //   362: ifnull +8 -> 370
    //   365: aload 9
    //   367: invokevirtual 146	java/util/zip/ZipOutputStream:close	()V
    //   370: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq -134 -> 239
    //   376: ldc 115
    //   378: iconst_2
    //   379: ldc 205
    //   381: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: goto -145 -> 239
    //   387: astore_0
    //   388: goto -18 -> 370
    //   391: astore_0
    //   392: goto -167 -> 225
    //   395: astore_1
    //   396: goto -75 -> 321
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_1
    //   402: goto -89 -> 313
    //   405: astore 9
    //   407: aload_0
    //   408: astore_1
    //   409: aload 9
    //   411: astore_0
    //   412: goto -99 -> 313
    //   415: astore_1
    //   416: aload 10
    //   418: astore_0
    //   419: goto -211 -> 208
    //   422: astore_1
    //   423: goto -83 -> 340
    //   426: astore 10
    //   428: goto -170 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	paramList	List<String>
    //   0	431	1	paramString	String
    //   149	19	2	i	int
    //   136	39	3	l1	long
    //   170	6	5	l2	long
    //   86	92	7	l3	long
    //   30	336	9	localZipOutputStream	ZipOutputStream
    //   405	5	9	localObject1	Object
    //   1	159	10	localObject2	Object
    //   254	163	10	localIOException1	IOException
    //   426	1	10	localIOException2	IOException
    //   38	13	11	localIterator	Iterator
    //   60	216	12	str	String
    // Exception table:
    //   from	to	target	type
    //   32	40	204	java/io/IOException
    //   40	88	204	java/io/IOException
    //   187	191	204	java/io/IOException
    //   191	201	204	java/io/IOException
    //   292	296	204	java/io/IOException
    //   296	306	204	java/io/IOException
    //   344	348	204	java/io/IOException
    //   348	360	204	java/io/IOException
    //   88	98	254	java/io/IOException
    //   32	40	309	finally
    //   40	88	309	finally
    //   187	191	309	finally
    //   191	201	309	finally
    //   292	296	309	finally
    //   296	306	309	finally
    //   344	348	309	finally
    //   348	360	309	finally
    //   88	98	337	finally
    //   365	370	387	java/io/IOException
    //   221	225	391	java/io/IOException
    //   317	321	395	java/io/IOException
    //   8	32	399	finally
    //   208	217	405	finally
    //   8	32	415	java/io/IOException
    //   100	117	422	finally
    //   119	126	422	finally
    //   128	135	422	finally
    //   139	150	422	finally
    //   157	166	422	finally
    //   260	288	422	finally
    //   100	117	426	java/io/IOException
    //   119	126	426	java/io/IOException
    //   128	135	426	java/io/IOException
    //   139	150	426	java/io/IOException
    //   157	166	426	java/io/IOException
  }
  
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, int paramInt)
  {
    int j = 0;
    try
    {
      Object localObject1;
      Object localObject2;
      if (paramFile.exists()) {
        if (paramFile.isFile())
        {
          paramZipOutputStream.putNextEntry(new ZipEntry(paramFile.getPath().substring(paramInt)));
          paramZipOutputStream.setLevel(9);
          long l3 = paramFile.length();
          localObject1 = new FileInputStream(paramFile);
          try
          {
            localObject2 = new byte[20480];
            long l1 = 0L;
            long l2;
            do
            {
              paramInt = ((FileInputStream)localObject1).read((byte[])localObject2, 0, 20480);
              if (paramInt == -1) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("UnifiedFileUtil", 2, "read " + paramInt + " from " + paramFile.getName());
              }
              paramZipOutputStream.write((byte[])localObject2, 0, paramInt);
              l2 = l1 + paramInt;
              l1 = l2;
            } while (l2 < l3);
            return;
          }
          finally
          {
            ((FileInputStream)localObject1).close();
            paramZipOutputStream.closeEntry();
          }
        }
      }
      int k;
      int i;
      File localFile;
      return;
    }
    catch (IOException paramZipOutputStream)
    {
      QLog.e("UnifiedFileUtil", 1, "zipFile errror: " + paramZipOutputStream.getMessage());
      paramZipOutputStream = paramZipOutputStream.getStackTrace();
      paramInt = j;
      while (paramInt < paramZipOutputStream.length)
      {
        QLog.e("UnifiedFileUtil", 1, paramZipOutputStream[paramInt].toString());
        paramInt += 1;
      }
      paramZipOutputStream.putNextEntry(new ZipEntry(paramFile.getPath().substring(paramInt) + "/"));
      localObject1 = paramFile.listFiles();
      localObject2 = new JSONObject();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        k = localObject1.length;
        i = 0;
        while (i < k)
        {
          localFile = localObject1[i];
          a(paramZipOutputStream, localFile, paramInt);
          ((JSONObject)localObject2).put(localFile.getName(), a(localFile));
          i += 1;
        }
      }
      ((JSONObject)localObject2).put(".", a(paramFile));
      localObject1 = "properties.json";
      if (new File(paramFile, "properties.json").exists()) {
        localObject1 = "properties_" + System.currentTimeMillis() + ".json";
      }
      paramZipOutputStream.putNextEntry(new ZipEntry(paramFile.getPath().substring(paramInt) + "/" + (String)localObject1));
      paramZipOutputStream.write(((JSONObject)localObject2).toString(4).getBytes("utf-8"));
      paramZipOutputStream.closeEntry();
      return;
    }
    catch (JSONException paramZipOutputStream)
    {
      QLog.e("UnifiedFileUtil", 1, "zipFile: ", paramZipOutputStream);
    }
  }
  
  public static String[] a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory())) {
      return paramString.list();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcuk
 * JD-Core Version:    0.7.0.1
 */