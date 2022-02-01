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

public class bmhq
{
  private static final bmgv<bmhq, Void> jdField_a_of_type_Bmgv = new bmhr();
  private LinkedHashMap<Long, WebAppIpRecord> jdField_a_of_type_JavaUtilLinkedHashMap;
  
  public static bmhq a()
  {
    return (bmhq)jdField_a_of_type_Bmgv.b(null);
  }
  
  private File a()
  {
    File localFile = new File(blwf.n() + File.separator + "webapp_iplist");
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
    //   5: getfield 159	bmhq:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   8: ifnull +17 -> 25
    //   11: aload_0
    //   12: getfield 159	bmhq:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
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
    //   50: getfield 159	bmhq:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
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
    //   94: getfield 159	bmhq:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   97: iload_2
    //   98: sipush 1000
    //   101: imul
    //   102: i2l
    //   103: invokespecial 191	bmhq:a	(Ljava/util/LinkedHashMap;J)Ljava/util/LinkedHashMap;
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
    //   509: invokespecial 277	bmhq:a	()Ljava/io/File;
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
    //   0	616	0	this	bmhq
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
    //   19: invokestatic 39	blwf:n	()Ljava/lang/String;
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
    //   49: ifeq +550 -> 599
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
    //   81: invokestatic 314	bmij:a	(Ljava/io/File;)Z
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
    //   260: astore 4
    //   262: aload 4
    //   264: invokeinterface 235 1 0
    //   269: ifeq -159 -> 110
    //   272: aload 4
    //   274: invokeinterface 239 1 0
    //   279: checkcast 84	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   282: astore_3
    //   283: aload_3
    //   284: ifnull -22 -> 262
    //   287: aload_3
    //   288: getfield 101	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   291: ifnull -29 -> 262
    //   294: aload_3
    //   295: getfield 101	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   298: invokevirtual 338	cooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap:keySet	()Ljava/util/Set;
    //   301: invokeinterface 339 1 0
    //   306: astore 5
    //   308: aload 5
    //   310: invokeinterface 235 1 0
    //   315: ifeq -53 -> 262
    //   318: aload 5
    //   320: invokeinterface 239 1 0
    //   325: checkcast 111	java/lang/Integer
    //   328: astore 6
    //   330: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   333: ifeq +43 -> 376
    //   336: ldc 166
    //   338: iconst_2
    //   339: new 32	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 341
    //   349: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload 6
    //   354: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   357: ldc_w 346
    //   360: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_3
    //   364: getfield 130	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_Long	J
    //   367: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   370: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 252	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: aload 6
    //   378: invokevirtual 349	java/lang/Integer:intValue	()I
    //   381: aload_3
    //   382: getfield 130	cooperation/qzone/statistic/serverip/WebAppIpRecord:jdField_a_of_type_Long	J
    //   385: invokestatic 354	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   388: invokestatic 360	bmgu:c	(ILjava/lang/String;)V
    //   391: goto -83 -> 308
    //   394: astore_3
    //   395: aload_3
    //   396: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   399: goto -163 -> 236
    //   402: astore 5
    //   404: aconst_null
    //   405: astore_3
    //   406: aconst_null
    //   407: astore 4
    //   409: aload 5
    //   411: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   414: aload 4
    //   416: ifnull +8 -> 424
    //   419: aload 4
    //   421: invokevirtual 315	java/io/FileInputStream:close	()V
    //   424: aload 6
    //   426: ifnull +170 -> 596
    //   429: aload 6
    //   431: invokevirtual 275	android/os/Parcel:recycle	()V
    //   434: goto -182 -> 252
    //   437: astore 4
    //   439: aload 4
    //   441: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   444: goto -20 -> 424
    //   447: astore 4
    //   449: aconst_null
    //   450: astore_3
    //   451: aload 7
    //   453: astore 6
    //   455: aload_3
    //   456: ifnull +7 -> 463
    //   459: aload_3
    //   460: invokevirtual 315	java/io/FileInputStream:close	()V
    //   463: aload 6
    //   465: ifnull +8 -> 473
    //   468: aload 6
    //   470: invokevirtual 275	android/os/Parcel:recycle	()V
    //   473: aload 4
    //   475: athrow
    //   476: astore_3
    //   477: aload_3
    //   478: invokestatic 260	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   481: goto -18 -> 463
    //   484: astore 4
    //   486: aload 7
    //   488: astore 6
    //   490: goto -35 -> 455
    //   493: astore 4
    //   495: aload 7
    //   497: astore 6
    //   499: goto -44 -> 455
    //   502: astore 5
    //   504: aload 4
    //   506: astore 6
    //   508: aload 5
    //   510: astore 4
    //   512: goto -57 -> 455
    //   515: astore 5
    //   517: aload 4
    //   519: astore_3
    //   520: aload 5
    //   522: astore 4
    //   524: goto -69 -> 455
    //   527: astore 5
    //   529: aload_3
    //   530: astore 4
    //   532: aconst_null
    //   533: astore_3
    //   534: goto -125 -> 409
    //   537: astore 5
    //   539: aconst_null
    //   540: astore 7
    //   542: aload_3
    //   543: astore 4
    //   545: aload 7
    //   547: astore_3
    //   548: goto -139 -> 409
    //   551: astore 5
    //   553: aload_3
    //   554: astore 7
    //   556: aconst_null
    //   557: astore_3
    //   558: aload 4
    //   560: astore 6
    //   562: aload 7
    //   564: astore 4
    //   566: goto -157 -> 409
    //   569: astore 8
    //   571: aload 4
    //   573: astore 6
    //   575: aload 5
    //   577: astore 4
    //   579: aload_3
    //   580: astore 7
    //   582: aload 8
    //   584: astore 5
    //   586: aload 4
    //   588: astore_3
    //   589: aload 7
    //   591: astore 4
    //   593: goto -184 -> 409
    //   596: goto -344 -> 252
    //   599: aconst_null
    //   600: astore 5
    //   602: aconst_null
    //   603: astore_3
    //   604: goto -519 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	this	bmhq
    //   196	29	1	i	int
    //   153	47	2	j	int
    //   71	24	3	localFileInputStream	java.io.FileInputStream
    //   113	2	3	localIOException1	java.io.IOException
    //   121	112	3	localObject1	Object
    //   238	144	3	localObject2	Object
    //   394	2	3	localIOException2	java.io.IOException
    //   405	55	3	localObject3	Object
    //   476	2	3	localIOException3	java.io.IOException
    //   519	85	3	localObject4	Object
    //   42	378	4	localObject5	Object
    //   437	3	4	localIOException4	java.io.IOException
    //   447	27	4	localObject6	Object
    //   484	1	4	localObject7	Object
    //   493	12	4	localObject8	Object
    //   510	82	4	localObject9	Object
    //   60	259	5	localObject10	Object
    //   402	8	5	localException1	java.lang.Exception
    //   502	7	5	localObject11	Object
    //   515	6	5	localObject12	Object
    //   527	1	5	localException2	java.lang.Exception
    //   537	1	5	localException3	java.lang.Exception
    //   551	25	5	localException4	java.lang.Exception
    //   584	17	5	localObject13	Object
    //   4	570	6	localObject14	Object
    //   1	589	7	localObject15	Object
    //   569	14	8	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   94	98	113	java/io/IOException
    //   94	98	121	finally
    //   102	110	121	finally
    //   114	118	121	finally
    //   232	236	121	finally
    //   244	249	121	finally
    //   256	262	121	finally
    //   262	283	121	finally
    //   287	308	121	finally
    //   308	376	121	finally
    //   376	391	121	finally
    //   395	399	121	finally
    //   419	424	121	finally
    //   429	434	121	finally
    //   439	444	121	finally
    //   459	463	121	finally
    //   468	473	121	finally
    //   473	476	121	finally
    //   477	481	121	finally
    //   232	236	394	java/io/IOException
    //   8	72	402	java/lang/Exception
    //   419	424	437	java/io/IOException
    //   8	72	447	finally
    //   459	463	476	java/io/IOException
    //   72	85	484	finally
    //   126	131	493	finally
    //   131	186	502	finally
    //   186	195	502	finally
    //   202	221	502	finally
    //   409	414	515	finally
    //   72	85	527	java/lang/Exception
    //   126	131	537	java/lang/Exception
    //   131	186	551	java/lang/Exception
    //   186	195	551	java/lang/Exception
    //   202	221	569	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhq
 * JD-Core Version:    0.7.0.1
 */