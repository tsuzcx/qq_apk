import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfServerInfo;
import cooperation.qzone.statistic.serverip.WebAppIpRecord;
import cooperation.qzone.statistic.serverip.WebAppIpRecord.FixedSizeLinkedHashMap;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class bgek
{
  private static final bgdp<bgek, Void> jdField_a_of_type_Bgdp = new bgel();
  private LinkedHashMap<Long, WebAppIpRecord> jdField_a_of_type_JavaUtilLinkedHashMap;
  
  public static bgek a()
  {
    return (bgek)jdField_a_of_type_Bgdp.b(null);
  }
  
  private File a()
  {
    File localFile = new File(bftg.n() + File.separator + "webapp_iplist");
    if (!localFile.exists())
    {
      if (localFile.getParentFile().exists()) {
        break label69;
      }
      if (localFile.getParentFile().mkdirs()) {
        localFile.createNewFile();
      }
    }
    return localFile;
    label69:
    localFile.createNewFile();
    return localFile;
  }
  
  private LinkedHashMap<Long, WebAppIpRecord> a(LinkedHashMap<Long, WebAppIpRecord> paramLinkedHashMap, long paramLong)
  {
    if ((paramLinkedHashMap == null) || (paramLinkedHashMap.isEmpty()) || (paramLong == 0L)) {
      return paramLinkedHashMap;
    }
    WebAppIpRecord[] arrayOfWebAppIpRecord = (WebAppIpRecord[])paramLinkedHashMap.values().toArray(new WebAppIpRecord[paramLinkedHashMap.size()]);
    long l = System.currentTimeMillis();
    int k = arrayOfWebAppIpRecord.length;
    int i = 0;
    label53:
    WebAppIpRecord localWebAppIpRecord;
    WebAppIpRecord.FixedSizeLinkedHashMap localFixedSizeLinkedHashMap;
    if (i < k)
    {
      localWebAppIpRecord = arrayOfWebAppIpRecord[i];
      localFixedSizeLinkedHashMap = localWebAppIpRecord.jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap;
      if (!localFixedSizeLinkedHashMap.isEmpty()) {
        break label91;
      }
    }
    for (;;)
    {
      i += 1;
      break label53;
      break;
      label91:
      Integer[] arrayOfInteger = (Integer[])localFixedSizeLinkedHashMap.keySet().toArray(new Integer[localFixedSizeLinkedHashMap.size()]);
      int m = arrayOfInteger.length;
      int j = 0;
      while (j < m)
      {
        Integer localInteger = arrayOfInteger[j];
        if (l - ((Long)localFixedSizeLinkedHashMap.get(localInteger)).longValue() > paramLong) {
          localFixedSizeLinkedHashMap.remove(localInteger);
        }
        if ((j == m - 1) && (localFixedSizeLinkedHashMap.isEmpty())) {
          paramLinkedHashMap.remove(Long.valueOf(localWebAppIpRecord.jdField_a_of_type_Long));
        }
        j += 1;
      }
    }
  }
  
  public static boolean a(QmfServerInfo paramQmfServerInfo)
  {
    if ((paramQmfServerInfo == null) || (paramQmfServerInfo.ipWebapp == null)) {}
    while ((paramQmfServerInfo.changeTime == 0L) || (paramQmfServerInfo.ipWebapp.ClientIpv4 == 0)) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 159	bgek:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   8: ifnull +17 -> 25
    //   11: aload_0
    //   12: getfield 159	bgek:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   15: invokevirtual 74	java/util/LinkedHashMap:isEmpty	()Z
    //   18: istore 4
    //   20: iload 4
    //   22: ifeq +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   31: ifeq +34 -> 65
    //   34: ldc 166
    //   36: iconst_2
    //   37: new 32	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   44: ldc 168
    //   46: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: getfield 159	bgek:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   53: invokevirtual 82	java/util/LinkedHashMap:size	()I
    //   56: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 175	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aconst_null
    //   66: astore 6
    //   68: aconst_null
    //   69: astore 7
    //   71: aload 6
    //   73: astore 5
    //   75: invokestatic 181	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   78: ldc 183
    //   80: ldc 185
    //   82: bipush 60
    //   84: invokevirtual 189	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   87: istore_2
    //   88: aload 6
    //   90: astore 5
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 159	bgek:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   97: iload_2
    //   98: sipush 1000
    //   101: imul
    //   102: i2l
    //   103: invokespecial 191	bgek:a	(Ljava/util/LinkedHashMap;J)Ljava/util/LinkedHashMap;
    //   106: astore 8
    //   108: aload 6
    //   110: astore 5
    //   112: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   115: ifeq +55 -> 170
    //   118: aload 6
    //   120: astore 5
    //   122: new 32	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   129: ldc 193
    //   131: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: astore 9
    //   136: aload 8
    //   138: ifnull +13 -> 151
    //   141: aload 6
    //   143: astore 5
    //   145: aload 8
    //   147: invokevirtual 82	java/util/LinkedHashMap:size	()I
    //   150: istore_1
    //   151: aload 6
    //   153: astore 5
    //   155: ldc 166
    //   157: iconst_2
    //   158: aload 9
    //   160: iload_1
    //   161: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 175	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 6
    //   172: astore 5
    //   174: invokestatic 181	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   177: ldc 183
    //   179: ldc 195
    //   181: iconst_3
    //   182: invokevirtual 189	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   185: istore_1
    //   186: aload 6
    //   188: astore 5
    //   190: aload 8
    //   192: invokevirtual 196	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   195: aload 8
    //   197: invokevirtual 82	java/util/LinkedHashMap:size	()I
    //   200: anewarray 121	java/lang/Long
    //   203: invokeinterface 114 2 0
    //   208: checkcast 198	[Ljava/lang/Long;
    //   211: astore 10
    //   213: aload 6
    //   215: astore 5
    //   217: aload 10
    //   219: invokestatic 204	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   222: aload 6
    //   224: astore 5
    //   226: aload 10
    //   228: arraylength
    //   229: istore_3
    //   230: iload_1
    //   231: iload_3
    //   232: if_icmple +381 -> 613
    //   235: iload_3
    //   236: istore_1
    //   237: aload 6
    //   239: astore 5
    //   241: new 206	java/util/ArrayList
    //   244: dup
    //   245: invokespecial 207	java/util/ArrayList:<init>	()V
    //   248: astore 9
    //   250: iload_3
    //   251: iconst_1
    //   252: isub
    //   253: istore_2
    //   254: iload_2
    //   255: iload_3
    //   256: iload_1
    //   257: isub
    //   258: if_icmplt +29 -> 287
    //   261: aload 6
    //   263: astore 5
    //   265: aload 9
    //   267: aload 8
    //   269: aload 10
    //   271: iload_2
    //   272: aaload
    //   273: invokevirtual 208	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: invokevirtual 212	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   279: pop
    //   280: iload_2
    //   281: iconst_1
    //   282: isub
    //   283: istore_2
    //   284: goto -30 -> 254
    //   287: aload 6
    //   289: astore 5
    //   291: invokestatic 218	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   294: astore 8
    //   296: aload 6
    //   298: astore 5
    //   300: aload 8
    //   302: iconst_0
    //   303: invokevirtual 222	android/os/Parcel:setDataPosition	(I)V
    //   306: aload 6
    //   308: astore 5
    //   310: aload 8
    //   312: aload 9
    //   314: invokevirtual 223	java/util/ArrayList:size	()I
    //   317: invokevirtual 226	android/os/Parcel:writeInt	(I)V
    //   320: aload 6
    //   322: astore 5
    //   324: aload 9
    //   326: invokevirtual 230	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   329: astore 9
    //   331: aload 6
    //   333: astore 5
    //   335: aload 9
    //   337: invokeinterface 235 1 0
    //   342: ifeq +142 -> 484
    //   345: aload 6
    //   347: astore 5
    //   349: aload 9
    //   351: invokeinterface 239 1 0
    //   356: checkcast 84	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   359: astore 10
    //   361: aload 6
    //   363: astore 5
    //   365: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   368: ifeq +52 -> 420
    //   371: aload 6
    //   373: astore 5
    //   375: ldc 166
    //   377: iconst_2
    //   378: new 32	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   385: ldc 241
    //   387: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 10
    //   392: getfield 130	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_Long	J
    //   395: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   398: ldc 246
    //   400: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload 10
    //   405: getfield 101	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   408: invokevirtual 249	cooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap:toString	()Ljava/lang/String;
    //   411: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 252	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload 6
    //   422: astore 5
    //   424: aload 10
    //   426: aload 8
    //   428: iconst_0
    //   429: invokevirtual 256	cooperation/qzone/statistic/serverip/WebAppIpRecord:writeToParcel	(Landroid/os/Parcel;I)V
    //   432: goto -101 -> 331
    //   435: astore 5
    //   437: aload 7
    //   439: astore 6
    //   441: aload 5
    //   443: astore 7
    //   445: aload 6
    //   447: astore 5
    //   449: aload 7
    //   451: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   454: aload 6
    //   456: ifnull -431 -> 25
    //   459: aload 6
    //   461: invokevirtual 265	java/io/FileOutputStream:close	()V
    //   464: goto -439 -> 25
    //   467: astore 5
    //   469: aload 5
    //   471: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   474: goto -449 -> 25
    //   477: astore 5
    //   479: aload_0
    //   480: monitorexit
    //   481: aload 5
    //   483: athrow
    //   484: aload 6
    //   486: astore 5
    //   488: aload 8
    //   490: invokevirtual 272	android/os/Parcel:marshall	()[B
    //   493: astore 9
    //   495: aload 6
    //   497: astore 5
    //   499: aload 8
    //   501: invokevirtual 275	android/os/Parcel:recycle	()V
    //   504: aload 6
    //   506: astore 5
    //   508: aload_0
    //   509: invokespecial 277	bgek:a	()Ljava/io/File;
    //   512: astore 8
    //   514: aload 8
    //   516: ifnull +91 -> 607
    //   519: aload 6
    //   521: astore 5
    //   523: new 262	java/io/FileOutputStream
    //   526: dup
    //   527: aload 8
    //   529: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   532: astore 6
    //   534: aload 6
    //   536: aload 9
    //   538: invokevirtual 284	java/io/FileOutputStream:write	([B)V
    //   541: aload 6
    //   543: ifnull -518 -> 25
    //   546: aload 6
    //   548: invokevirtual 265	java/io/FileOutputStream:close	()V
    //   551: goto -526 -> 25
    //   554: astore 5
    //   556: aload 5
    //   558: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   561: goto -536 -> 25
    //   564: astore 7
    //   566: aload 5
    //   568: astore 6
    //   570: aload 7
    //   572: astore 5
    //   574: aload 6
    //   576: ifnull +8 -> 584
    //   579: aload 6
    //   581: invokevirtual 265	java/io/FileOutputStream:close	()V
    //   584: aload 5
    //   586: athrow
    //   587: astore 6
    //   589: aload 6
    //   591: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   594: goto -10 -> 584
    //   597: astore 5
    //   599: goto -25 -> 574
    //   602: astore 7
    //   604: goto -159 -> 445
    //   607: aconst_null
    //   608: astore 6
    //   610: goto -69 -> 541
    //   613: goto -376 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	this	bgek
    //   1	257	1	i	int
    //   87	197	2	j	int
    //   229	29	3	k	int
    //   18	3	4	bool	boolean
    //   73	350	5	localObject1	Object
    //   435	7	5	localThrowable1	java.lang.Throwable
    //   447	1	5	localObject2	Object
    //   467	3	5	localIOException1	java.io.IOException
    //   477	5	5	localObject3	Object
    //   486	36	5	localObject4	Object
    //   554	13	5	localIOException2	java.io.IOException
    //   572	13	5	localObject5	Object
    //   597	1	5	localObject6	Object
    //   66	514	6	localObject7	Object
    //   587	3	6	localIOException3	java.io.IOException
    //   608	1	6	localObject8	Object
    //   69	381	7	localObject9	Object
    //   564	7	7	localObject10	Object
    //   602	1	7	localThrowable2	java.lang.Throwable
    //   106	422	8	localObject11	Object
    //   134	403	9	localObject12	Object
    //   211	214	10	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   75	88	435	java/lang/Throwable
    //   92	108	435	java/lang/Throwable
    //   112	118	435	java/lang/Throwable
    //   122	136	435	java/lang/Throwable
    //   145	151	435	java/lang/Throwable
    //   155	170	435	java/lang/Throwable
    //   174	186	435	java/lang/Throwable
    //   190	213	435	java/lang/Throwable
    //   217	222	435	java/lang/Throwable
    //   226	230	435	java/lang/Throwable
    //   241	250	435	java/lang/Throwable
    //   265	280	435	java/lang/Throwable
    //   291	296	435	java/lang/Throwable
    //   300	306	435	java/lang/Throwable
    //   310	320	435	java/lang/Throwable
    //   324	331	435	java/lang/Throwable
    //   335	345	435	java/lang/Throwable
    //   349	361	435	java/lang/Throwable
    //   365	371	435	java/lang/Throwable
    //   375	420	435	java/lang/Throwable
    //   424	432	435	java/lang/Throwable
    //   488	495	435	java/lang/Throwable
    //   499	504	435	java/lang/Throwable
    //   508	514	435	java/lang/Throwable
    //   523	534	435	java/lang/Throwable
    //   459	464	467	java/io/IOException
    //   4	20	477	finally
    //   28	65	477	finally
    //   459	464	477	finally
    //   469	474	477	finally
    //   546	551	477	finally
    //   556	561	477	finally
    //   579	584	477	finally
    //   584	587	477	finally
    //   589	594	477	finally
    //   546	551	554	java/io/IOException
    //   75	88	564	finally
    //   92	108	564	finally
    //   112	118	564	finally
    //   122	136	564	finally
    //   145	151	564	finally
    //   155	170	564	finally
    //   174	186	564	finally
    //   190	213	564	finally
    //   217	222	564	finally
    //   226	230	564	finally
    //   241	250	564	finally
    //   265	280	564	finally
    //   291	296	564	finally
    //   300	306	564	finally
    //   310	320	564	finally
    //   324	331	564	finally
    //   335	345	564	finally
    //   349	361	564	finally
    //   365	371	564	finally
    //   375	420	564	finally
    //   424	432	564	finally
    //   449	454	564	finally
    //   488	495	564	finally
    //   499	504	564	finally
    //   508	514	564	finally
    //   523	534	564	finally
    //   579	584	587	java/io/IOException
    //   534	541	597	finally
    //   534	541	602	java/lang/Throwable
  }
  
  public void a(QmfServerInfo paramQmfServerInfo)
  {
    try
    {
      if (QZLog.isColorLevel()) {
        QZLog.d("WebAppIpManager", 2, "addWebAppIpRecord--changeTime:" + paramQmfServerInfo.changeTime + ", Ipv4:" + paramQmfServerInfo.ipWebapp.ClientIpv4);
      }
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      }
      WebAppIpRecord localWebAppIpRecord2 = (WebAppIpRecord)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramQmfServerInfo.changeTime));
      WebAppIpRecord localWebAppIpRecord1 = localWebAppIpRecord2;
      if (localWebAppIpRecord2 == null)
      {
        localWebAppIpRecord1 = new WebAppIpRecord();
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramQmfServerInfo.changeTime), localWebAppIpRecord1);
      }
      localWebAppIpRecord1.jdField_a_of_type_Long = paramQmfServerInfo.changeTime;
      localWebAppIpRecord1.a(paramQmfServerInfo.ipWebapp.ClientIpv4);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: new 30	java/io/File
    //   11: dup
    //   12: new 32	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 39	bftg:n	()Ljava/lang/String;
    //   22: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: getstatic 47	java/io/File:separator	Ljava/lang/String;
    //   28: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 49
    //   33: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 59	java/io/File:exists	()Z
    //   49: ifeq +549 -> 598
    //   52: aload 4
    //   54: invokevirtual 302	java/io/File:length	()J
    //   57: l2i
    //   58: newarray byte
    //   60: astore 5
    //   62: new 304	java/io/FileInputStream
    //   65: dup
    //   66: aload 4
    //   68: invokespecial 305	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_3
    //   72: aload_3
    //   73: aload 5
    //   75: invokevirtual 309	java/io/FileInputStream:read	([B)I
    //   78: pop
    //   79: aload 4
    //   81: invokestatic 314	bgfb:a	(Ljava/io/File;)Z
    //   84: pop
    //   85: aload 5
    //   87: ifnonnull +39 -> 126
    //   90: aload_3
    //   91: ifnull +7 -> 98
    //   94: aload_3
    //   95: invokevirtual 315	java/io/FileInputStream:close	()V
    //   98: iconst_0
    //   99: ifeq +11 -> 110
    //   102: new 317	java/lang/NullPointerException
    //   105: dup
    //   106: invokespecial 318	java/lang/NullPointerException:<init>	()V
    //   109: athrow
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_3
    //   114: aload_3
    //   115: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   118: goto -20 -> 98
    //   121: astore_3
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_3
    //   125: athrow
    //   126: invokestatic 218	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   129: astore 4
    //   131: aload 4
    //   133: aload 5
    //   135: iconst_0
    //   136: aload 5
    //   138: arraylength
    //   139: invokevirtual 322	android/os/Parcel:unmarshall	([BII)V
    //   142: aload 4
    //   144: iconst_0
    //   145: invokevirtual 222	android/os/Parcel:setDataPosition	(I)V
    //   148: aload 4
    //   150: invokevirtual 325	android/os/Parcel:readInt	()I
    //   153: istore_2
    //   154: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   157: ifeq +29 -> 186
    //   160: ldc 166
    //   162: iconst_2
    //   163: new 32	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 327
    //   173: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload_2
    //   177: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 252	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: new 206	java/util/ArrayList
    //   189: dup
    //   190: invokespecial 207	java/util/ArrayList:<init>	()V
    //   193: astore 5
    //   195: iconst_0
    //   196: istore_1
    //   197: iload_1
    //   198: iload_2
    //   199: if_icmpge +29 -> 228
    //   202: aload 5
    //   204: getstatic 331	cooperation/qzone/statistic/serverip/WebAppIpRecord:CREATOR	Landroid/os/Parcelable$Creator;
    //   207: aload 4
    //   209: invokeinterface 337 2 0
    //   214: checkcast 84	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   217: invokevirtual 212	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   220: pop
    //   221: iload_1
    //   222: iconst_1
    //   223: iadd
    //   224: istore_1
    //   225: goto -28 -> 197
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 315	java/io/FileInputStream:close	()V
    //   236: aload 5
    //   238: astore_3
    //   239: aload 4
    //   241: ifnull +11 -> 252
    //   244: aload 4
    //   246: invokevirtual 275	android/os/Parcel:recycle	()V
    //   249: aload 5
    //   251: astore_3
    //   252: aload_3
    //   253: ifnull -143 -> 110
    //   256: aload_3
    //   257: invokevirtual 230	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   260: astore_3
    //   261: aload_3
    //   262: invokeinterface 235 1 0
    //   267: ifeq -157 -> 110
    //   270: aload_3
    //   271: invokeinterface 239 1 0
    //   276: checkcast 84	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   279: astore 5
    //   281: aload 5
    //   283: ifnull -22 -> 261
    //   286: aload 5
    //   288: getfield 101	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   291: ifnull -30 -> 261
    //   294: aload 5
    //   296: getfield 101	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   299: invokevirtual 338	cooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap:keySet	()Ljava/util/Set;
    //   302: invokeinterface 339 1 0
    //   307: astore 6
    //   309: aload 6
    //   311: invokeinterface 235 1 0
    //   316: ifeq -55 -> 261
    //   319: aload 6
    //   321: invokeinterface 239 1 0
    //   326: checkcast 111	java/lang/Integer
    //   329: astore 4
    //   331: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   334: ifeq +44 -> 378
    //   337: ldc 166
    //   339: iconst_2
    //   340: new 32	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 341
    //   350: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 4
    //   355: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   358: ldc_w 346
    //   361: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload 5
    //   366: getfield 130	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_Long	J
    //   369: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   372: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 252	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload 4
    //   380: invokevirtual 349	java/lang/Integer:intValue	()I
    //   383: aload 5
    //   385: getfield 130	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_Long	J
    //   388: invokestatic 354	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   391: invokestatic 360	bgdo:c	(ILjava/lang/String;)V
    //   394: goto -85 -> 309
    //   397: astore_3
    //   398: aload_3
    //   399: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   402: goto -166 -> 236
    //   405: astore 5
    //   407: aconst_null
    //   408: astore_3
    //   409: aconst_null
    //   410: astore 4
    //   412: aload 5
    //   414: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   417: aload 4
    //   419: ifnull +8 -> 427
    //   422: aload 4
    //   424: invokevirtual 315	java/io/FileInputStream:close	()V
    //   427: aload 6
    //   429: ifnull +166 -> 595
    //   432: aload 6
    //   434: invokevirtual 275	android/os/Parcel:recycle	()V
    //   437: goto -185 -> 252
    //   440: astore 4
    //   442: aload 4
    //   444: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   447: goto -20 -> 427
    //   450: astore 4
    //   452: aconst_null
    //   453: astore_3
    //   454: aload 7
    //   456: astore 6
    //   458: aload_3
    //   459: ifnull +7 -> 466
    //   462: aload_3
    //   463: invokevirtual 315	java/io/FileInputStream:close	()V
    //   466: aload 6
    //   468: ifnull +8 -> 476
    //   471: aload 6
    //   473: invokevirtual 275	android/os/Parcel:recycle	()V
    //   476: aload 4
    //   478: athrow
    //   479: astore_3
    //   480: aload_3
    //   481: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   484: goto -18 -> 466
    //   487: astore 4
    //   489: aload 7
    //   491: astore 6
    //   493: goto -35 -> 458
    //   496: astore 4
    //   498: aload 7
    //   500: astore 6
    //   502: goto -44 -> 458
    //   505: astore 5
    //   507: aload 4
    //   509: astore 6
    //   511: aload 5
    //   513: astore 4
    //   515: goto -57 -> 458
    //   518: astore 5
    //   520: aload 4
    //   522: astore_3
    //   523: aload 5
    //   525: astore 4
    //   527: goto -69 -> 458
    //   530: astore 5
    //   532: aload_3
    //   533: astore 4
    //   535: aconst_null
    //   536: astore_3
    //   537: goto -125 -> 412
    //   540: astore 5
    //   542: aconst_null
    //   543: astore 7
    //   545: aload_3
    //   546: astore 4
    //   548: aload 7
    //   550: astore_3
    //   551: goto -139 -> 412
    //   554: astore 5
    //   556: aload_3
    //   557: astore 7
    //   559: aconst_null
    //   560: astore_3
    //   561: aload 4
    //   563: astore 6
    //   565: aload 7
    //   567: astore 4
    //   569: goto -157 -> 412
    //   572: astore 8
    //   574: aload 4
    //   576: astore 6
    //   578: aload 5
    //   580: astore 7
    //   582: aload_3
    //   583: astore 4
    //   585: aload 8
    //   587: astore 5
    //   589: aload 7
    //   591: astore_3
    //   592: goto -180 -> 412
    //   595: goto -343 -> 252
    //   598: aconst_null
    //   599: astore 5
    //   601: aconst_null
    //   602: astore_3
    //   603: goto -518 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	bgek
    //   196	29	1	i	int
    //   153	47	2	j	int
    //   71	24	3	localFileInputStream	java.io.FileInputStream
    //   113	2	3	localIOException1	java.io.IOException
    //   121	112	3	localObject1	Object
    //   238	33	3	localObject2	Object
    //   397	2	3	localIOException2	java.io.IOException
    //   408	55	3	localObject3	Object
    //   479	2	3	localIOException3	java.io.IOException
    //   522	81	3	localObject4	Object
    //   42	381	4	localObject5	Object
    //   440	3	4	localIOException4	java.io.IOException
    //   450	27	4	localObject6	Object
    //   487	1	4	localObject7	Object
    //   496	12	4	localObject8	Object
    //   513	71	4	localObject9	Object
    //   60	324	5	localObject10	Object
    //   405	8	5	localException1	java.lang.Exception
    //   505	7	5	localObject11	Object
    //   518	6	5	localObject12	Object
    //   530	1	5	localException2	java.lang.Exception
    //   540	1	5	localException3	java.lang.Exception
    //   554	25	5	localException4	java.lang.Exception
    //   587	13	5	localObject13	Object
    //   4	573	6	localObject14	Object
    //   1	589	7	localObject15	Object
    //   572	14	8	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   94	98	113	java/io/IOException
    //   94	98	121	finally
    //   102	110	121	finally
    //   114	118	121	finally
    //   232	236	121	finally
    //   244	249	121	finally
    //   256	261	121	finally
    //   261	281	121	finally
    //   286	309	121	finally
    //   309	378	121	finally
    //   378	394	121	finally
    //   398	402	121	finally
    //   422	427	121	finally
    //   432	437	121	finally
    //   442	447	121	finally
    //   462	466	121	finally
    //   471	476	121	finally
    //   476	479	121	finally
    //   480	484	121	finally
    //   232	236	397	java/io/IOException
    //   8	72	405	java/lang/Exception
    //   422	427	440	java/io/IOException
    //   8	72	450	finally
    //   462	466	479	java/io/IOException
    //   72	85	487	finally
    //   126	131	496	finally
    //   131	186	505	finally
    //   186	195	505	finally
    //   202	221	505	finally
    //   412	417	518	finally
    //   72	85	530	java/lang/Exception
    //   126	131	540	java/lang/Exception
    //   131	186	554	java/lang/Exception
    //   186	195	554	java/lang/Exception
    //   202	221	572	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgek
 * JD-Core Version:    0.7.0.1
 */