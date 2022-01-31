import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Random;

public class aujo
{
  private static HashMap<String, aujp> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "1234567890twstest", "123AppShadowQQ", "gwatchdm2016" };
  static final String[] b = { "com.tencent.tws.devicemanager", "com.tencent.shadowqq", "com.tencent.tws.gdevicemanager" };
  static final String[] c = { "E63D0E11EF7837C5A1BEB948742B0CB6", "CCD4AD38DC6669F875BC37E3F8840648", "E63D0E11EF7837C5A1BEB948742B0CB6" };
  
  /* Error */
  public static final aujp a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 19	aujo:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: getstatic 19	aujo:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   9: aload_1
    //   10: invokevirtual 51	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   13: ifeq +18 -> 31
    //   16: getstatic 19	aujo:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: aload_1
    //   20: invokevirtual 55	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 57	aujp
    //   26: astore_0
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: aload_2
    //   32: monitorexit
    //   33: new 59	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: invokevirtual 65	android/content/Context:getFilesDir	()Ljava/io/File;
    //   41: new 67	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 74
    //   54: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 81	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore 7
    //   65: aload 7
    //   67: invokevirtual 85	java/io/File:exists	()Z
    //   70: ifeq +13 -> 83
    //   73: aload 7
    //   75: invokevirtual 89	java/io/File:length	()J
    //   78: lconst_0
    //   79: lcmp
    //   80: ifne +42 -> 122
    //   83: aload_0
    //   84: aload_1
    //   85: invokestatic 91	aujo:b	(Landroid/content/Context;Ljava/lang/String;)Laujp;
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +591 -> 681
    //   93: getstatic 19	aujo:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   96: astore_2
    //   97: aload_2
    //   98: monitorenter
    //   99: getstatic 19	aujo:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   102: aload_1
    //   103: aload_0
    //   104: invokevirtual 95	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_2
    //   109: monitorexit
    //   110: aload_0
    //   111: areturn
    //   112: astore_0
    //   113: aload_2
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: aload_2
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    //   122: new 57	aujp
    //   125: dup
    //   126: invokespecial 96	aujp:<init>	()V
    //   129: astore_3
    //   130: new 98	java/io/ByteArrayInputStream
    //   133: dup
    //   134: aload 7
    //   136: invokestatic 103	bbdj:a	(Ljava/io/File;)[B
    //   139: invokespecial 106	java/io/ByteArrayInputStream:<init>	([B)V
    //   142: astore_0
    //   143: new 108	java/io/ObjectInputStream
    //   146: dup
    //   147: aload_0
    //   148: invokespecial 111	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   151: astore 6
    //   153: aload_0
    //   154: astore 4
    //   156: aload 6
    //   158: astore_2
    //   159: aload_3
    //   160: aload 6
    //   162: invokevirtual 115	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   165: checkcast 21	java/lang/String
    //   168: putfield 118	aujp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   171: aload_0
    //   172: astore 4
    //   174: aload 6
    //   176: astore_2
    //   177: aload_3
    //   178: aload 6
    //   180: invokevirtual 121	java/io/ObjectInputStream:readBoolean	()Z
    //   183: putfield 124	aujp:jdField_a_of_type_Boolean	Z
    //   186: aload_0
    //   187: astore 4
    //   189: aload 6
    //   191: astore_2
    //   192: aload_3
    //   193: getfield 124	aujp:jdField_a_of_type_Boolean	Z
    //   196: ifeq +310 -> 506
    //   199: aload_0
    //   200: astore 4
    //   202: aload 6
    //   204: astore_2
    //   205: aload_3
    //   206: aload 6
    //   208: invokevirtual 115	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   211: checkcast 21	java/lang/String
    //   214: putfield 126	aujp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   217: aload_0
    //   218: astore 4
    //   220: aload 6
    //   222: astore_2
    //   223: aload_3
    //   224: aload 6
    //   226: invokevirtual 115	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   229: checkcast 21	java/lang/String
    //   232: putfield 128	aujp:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   235: aload_0
    //   236: astore 4
    //   238: aload 6
    //   240: astore_2
    //   241: aload_3
    //   242: aload 6
    //   244: invokevirtual 132	java/io/ObjectInputStream:readInt	()I
    //   247: putfield 135	aujp:jdField_a_of_type_Int	I
    //   250: aload_0
    //   251: astore 4
    //   253: aload 6
    //   255: astore_2
    //   256: aload_3
    //   257: aload 6
    //   259: invokevirtual 132	java/io/ObjectInputStream:readInt	()I
    //   262: putfield 137	aujp:jdField_b_of_type_Int	I
    //   265: aload_0
    //   266: astore 4
    //   268: aload 6
    //   270: astore_2
    //   271: aload_3
    //   272: aload 6
    //   274: invokevirtual 132	java/io/ObjectInputStream:readInt	()I
    //   277: putfield 139	aujp:jdField_c_of_type_Int	I
    //   280: aload_0
    //   281: astore 4
    //   283: aload 6
    //   285: astore_2
    //   286: aload_3
    //   287: aload 6
    //   289: invokevirtual 142	java/io/ObjectInputStream:readLong	()J
    //   292: putfield 145	aujp:jdField_b_of_type_Long	J
    //   295: aload_0
    //   296: astore 4
    //   298: aload 6
    //   300: astore_2
    //   301: aload_3
    //   302: aload 6
    //   304: invokevirtual 142	java/io/ObjectInputStream:readLong	()J
    //   307: putfield 147	aujp:jdField_a_of_type_Long	J
    //   310: aload_0
    //   311: astore 4
    //   313: aload 6
    //   315: astore_2
    //   316: invokestatic 152	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   319: aload_3
    //   320: getfield 145	aujp:jdField_b_of_type_Long	J
    //   323: lsub
    //   324: invokestatic 158	java/lang/Math:abs	(J)J
    //   327: ldc2_w 159
    //   330: lcmp
    //   331: ifle +105 -> 436
    //   334: aload_0
    //   335: astore 4
    //   337: aload 6
    //   339: astore_2
    //   340: aload_3
    //   341: iconst_1
    //   342: putfield 162	aujp:jdField_b_of_type_Boolean	Z
    //   345: aload_0
    //   346: astore 4
    //   348: aload 6
    //   350: astore_2
    //   351: aload_3
    //   352: invokestatic 152	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   355: putfield 165	aujp:d	J
    //   358: aload_0
    //   359: astore 4
    //   361: aload 6
    //   363: astore_2
    //   364: aload_3
    //   365: new 167	java/util/Random
    //   368: dup
    //   369: invokespecial 168	java/util/Random:<init>	()V
    //   372: invokevirtual 171	java/util/Random:nextLong	()J
    //   375: putfield 173	aujp:jdField_c_of_type_Long	J
    //   378: aload_0
    //   379: astore 4
    //   381: aload 6
    //   383: astore_2
    //   384: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +49 -> 436
    //   390: aload_0
    //   391: astore 4
    //   393: aload 6
    //   395: astore_2
    //   396: ldc 180
    //   398: iconst_2
    //   399: new 67	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   406: ldc 182
    //   408: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_3
    //   412: getfield 145	aujp:jdField_b_of_type_Long	J
    //   415: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   418: ldc 187
    //   420: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_3
    //   424: getfield 165	aujp:d	J
    //   427: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   430: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aload_0
    //   437: astore 4
    //   439: aload 6
    //   441: astore_2
    //   442: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +61 -> 506
    //   448: aload_0
    //   449: astore 4
    //   451: aload 6
    //   453: astore_2
    //   454: ldc 180
    //   456: iconst_2
    //   457: new 67	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   464: ldc 192
    //   466: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_3
    //   470: getfield 126	aujp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   473: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc 194
    //   478: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_3
    //   482: getfield 137	aujp:jdField_b_of_type_Int	I
    //   485: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: ldc 194
    //   490: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload_3
    //   494: getfield 139	aujp:jdField_c_of_type_Int	I
    //   497: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: aload 6
    //   508: ifnull +8 -> 516
    //   511: aload 6
    //   513: invokevirtual 200	java/io/ObjectInputStream:close	()V
    //   516: aload_0
    //   517: ifnull +159 -> 676
    //   520: aload_0
    //   521: invokevirtual 201	java/io/ByteArrayInputStream:close	()V
    //   524: aload_3
    //   525: astore_0
    //   526: goto -437 -> 89
    //   529: astore_0
    //   530: aload_3
    //   531: astore_0
    //   532: goto -443 -> 89
    //   535: astore 5
    //   537: aconst_null
    //   538: astore_3
    //   539: aconst_null
    //   540: astore_0
    //   541: aload_3
    //   542: astore 4
    //   544: aload_0
    //   545: astore_2
    //   546: ldc 180
    //   548: iconst_1
    //   549: ldc 203
    //   551: aload 5
    //   553: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   556: aload_3
    //   557: astore 4
    //   559: aload_0
    //   560: astore_2
    //   561: aload 7
    //   563: invokevirtual 209	java/io/File:delete	()Z
    //   566: pop
    //   567: aload_0
    //   568: ifnull +7 -> 575
    //   571: aload_0
    //   572: invokevirtual 200	java/io/ObjectInputStream:close	()V
    //   575: aload_3
    //   576: ifnull +95 -> 671
    //   579: aload_3
    //   580: invokevirtual 201	java/io/ByteArrayInputStream:close	()V
    //   583: aconst_null
    //   584: astore_0
    //   585: goto -496 -> 89
    //   588: astore_0
    //   589: aconst_null
    //   590: astore_0
    //   591: goto -502 -> 89
    //   594: astore_1
    //   595: aconst_null
    //   596: astore_0
    //   597: aconst_null
    //   598: astore_2
    //   599: aload_2
    //   600: ifnull +7 -> 607
    //   603: aload_2
    //   604: invokevirtual 200	java/io/ObjectInputStream:close	()V
    //   607: aload_0
    //   608: ifnull +7 -> 615
    //   611: aload_0
    //   612: invokevirtual 201	java/io/ByteArrayInputStream:close	()V
    //   615: aload_1
    //   616: athrow
    //   617: astore_2
    //   618: goto -102 -> 516
    //   621: astore_2
    //   622: goto -55 -> 567
    //   625: astore_0
    //   626: goto -51 -> 575
    //   629: astore_2
    //   630: goto -23 -> 607
    //   633: astore_0
    //   634: goto -19 -> 615
    //   637: astore_1
    //   638: aconst_null
    //   639: astore_2
    //   640: goto -41 -> 599
    //   643: astore_1
    //   644: aload 4
    //   646: astore_0
    //   647: goto -48 -> 599
    //   650: astore 5
    //   652: aconst_null
    //   653: astore_2
    //   654: aload_0
    //   655: astore_3
    //   656: aload_2
    //   657: astore_0
    //   658: goto -117 -> 541
    //   661: astore 5
    //   663: aload_0
    //   664: astore_3
    //   665: aload 6
    //   667: astore_0
    //   668: goto -127 -> 541
    //   671: aconst_null
    //   672: astore_0
    //   673: goto -584 -> 89
    //   676: aload_3
    //   677: astore_0
    //   678: goto -589 -> 89
    //   681: aload_0
    //   682: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	paramContext	Context
    //   0	683	1	paramString	String
    //   3	601	2	localObject1	Object
    //   617	1	2	localException1	Exception
    //   621	1	2	localException2	Exception
    //   629	1	2	localException3	Exception
    //   639	18	2	localObject2	Object
    //   129	548	3	localObject3	Object
    //   154	491	4	localObject4	Object
    //   535	17	5	localException4	Exception
    //   650	1	5	localException5	Exception
    //   661	1	5	localException6	Exception
    //   151	515	6	localObjectInputStream	java.io.ObjectInputStream
    //   63	499	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   99	110	112	finally
    //   113	115	112	finally
    //   6	29	117	finally
    //   31	33	117	finally
    //   118	120	117	finally
    //   520	524	529	java/lang/Exception
    //   130	143	535	java/lang/Exception
    //   579	583	588	java/lang/Exception
    //   130	143	594	finally
    //   511	516	617	java/lang/Exception
    //   561	567	621	java/lang/Exception
    //   571	575	625	java/lang/Exception
    //   603	607	629	java/lang/Exception
    //   611	615	633	java/lang/Exception
    //   143	153	637	finally
    //   159	171	643	finally
    //   177	186	643	finally
    //   192	199	643	finally
    //   205	217	643	finally
    //   223	235	643	finally
    //   241	250	643	finally
    //   256	265	643	finally
    //   271	280	643	finally
    //   286	295	643	finally
    //   301	310	643	finally
    //   316	334	643	finally
    //   340	345	643	finally
    //   351	358	643	finally
    //   364	378	643	finally
    //   384	390	643	finally
    //   396	436	643	finally
    //   442	448	643	finally
    //   454	506	643	finally
    //   546	556	643	finally
    //   561	567	643	finally
    //   143	153	650	java/lang/Exception
    //   159	171	661	java/lang/Exception
    //   177	186	661	java/lang/Exception
    //   192	199	661	java/lang/Exception
    //   205	217	661	java/lang/Exception
    //   223	235	661	java/lang/Exception
    //   241	250	661	java/lang/Exception
    //   256	265	661	java/lang/Exception
    //   271	280	661	java/lang/Exception
    //   286	295	661	java/lang/Exception
    //   301	310	661	java/lang/Exception
    //   316	334	661	java/lang/Exception
    //   340	345	661	java/lang/Exception
    //   351	358	661	java/lang/Exception
    //   364	378	661	java/lang/Exception
    //   384	390	661	java/lang/Exception
    //   396	436	661	java/lang/Exception
    //   442	448	661	java/lang/Exception
    //   454	506	661	java/lang/Exception
  }
  
  public static final void a(Context paramContext, aujp paramaujp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Config", 2, "saveNewKey, " + paramaujp.jdField_b_of_type_Long + " to " + paramaujp.d);
    }
    if (paramaujp.jdField_b_of_type_Boolean)
    {
      paramaujp.jdField_b_of_type_Long = paramaujp.d;
      paramaujp.jdField_a_of_type_Long = paramaujp.jdField_c_of_type_Long;
      paramaujp.jdField_b_of_type_Boolean = false;
      b(paramContext, paramaujp);
    }
  }
  
  public static final boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64).signatures;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramContext[0].toByteArray());
      paramContext = bbdm.a(localMessageDigest.digest()).toUpperCase();
      boolean bool = paramString2.equals(paramContext);
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.d("OpenApi.Config", 2, "verifysig fail, pkg = " + paramString1 + ", sign = " + paramContext);
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Config", 2, "verifysig", paramContext);
      }
    }
    return false;
  }
  
  private static aujp b(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    int j = jdField_a_of_type_ArrayOfJavaLangString.length;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        if (jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString))
        {
          localObject1 = new aujp();
          ((aujp)localObject1).jdField_a_of_type_JavaLangString = paramString;
          ((aujp)localObject1).jdField_a_of_type_Boolean = true;
          ((aujp)localObject1).jdField_b_of_type_JavaLangString = b[i];
          ((aujp)localObject1).jdField_c_of_type_JavaLangString = c[i];
          ((aujp)localObject1).jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
          ((aujp)localObject1).jdField_a_of_type_Long = new Random().nextLong();
          ((aujp)localObject1).jdField_a_of_type_Int = 1073741823;
          ((aujp)localObject1).jdField_b_of_type_Int = 2147483647;
          ((aujp)localObject1).jdField_c_of_type_Int = 7;
          b(paramContext, (aujp)localObject1);
        }
      }
      else {
        return localObject1;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static final void b(Context paramContext, aujp paramaujp)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	aujo:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: getstatic 19	aujo:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   12: aload_1
    //   13: getfield 118	aujp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 95	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   20: pop
    //   21: aload_2
    //   22: monitorexit
    //   23: new 272	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: invokespecial 273	java/io/ByteArrayOutputStream:<init>	()V
    //   30: astore 4
    //   32: new 275	java/io/ObjectOutputStream
    //   35: dup
    //   36: aload 4
    //   38: invokespecial 278	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: aload_1
    //   46: getfield 118	aujp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: invokevirtual 282	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: aload_1
    //   56: getfield 124	aujp:jdField_a_of_type_Boolean	Z
    //   59: invokevirtual 286	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   62: aload_3
    //   63: astore_2
    //   64: aload_1
    //   65: getfield 124	aujp:jdField_a_of_type_Boolean	Z
    //   68: ifeq +73 -> 141
    //   71: aload_3
    //   72: astore_2
    //   73: aload_3
    //   74: aload_1
    //   75: getfield 126	aujp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   78: invokevirtual 282	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   81: aload_3
    //   82: astore_2
    //   83: aload_3
    //   84: aload_1
    //   85: getfield 128	aujp:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   88: invokevirtual 282	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   91: aload_3
    //   92: astore_2
    //   93: aload_3
    //   94: aload_1
    //   95: getfield 135	aujp:jdField_a_of_type_Int	I
    //   98: invokevirtual 290	java/io/ObjectOutputStream:writeInt	(I)V
    //   101: aload_3
    //   102: astore_2
    //   103: aload_3
    //   104: aload_1
    //   105: getfield 137	aujp:jdField_b_of_type_Int	I
    //   108: invokevirtual 290	java/io/ObjectOutputStream:writeInt	(I)V
    //   111: aload_3
    //   112: astore_2
    //   113: aload_3
    //   114: aload_1
    //   115: getfield 139	aujp:jdField_c_of_type_Int	I
    //   118: invokevirtual 290	java/io/ObjectOutputStream:writeInt	(I)V
    //   121: aload_3
    //   122: astore_2
    //   123: aload_3
    //   124: aload_1
    //   125: getfield 145	aujp:jdField_b_of_type_Long	J
    //   128: invokevirtual 294	java/io/ObjectOutputStream:writeLong	(J)V
    //   131: aload_3
    //   132: astore_2
    //   133: aload_3
    //   134: aload_1
    //   135: getfield 147	aujp:jdField_a_of_type_Long	J
    //   138: invokevirtual 294	java/io/ObjectOutputStream:writeLong	(J)V
    //   141: aload_3
    //   142: astore_2
    //   143: aload_3
    //   144: invokevirtual 297	java/io/ObjectOutputStream:flush	()V
    //   147: aload_3
    //   148: astore_2
    //   149: new 59	java/io/File
    //   152: dup
    //   153: aload_0
    //   154: invokevirtual 65	android/content/Context:getFilesDir	()Ljava/io/File;
    //   157: new 67	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   164: aload_1
    //   165: getfield 118	aujp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc 74
    //   173: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 81	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   182: invokevirtual 300	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   185: aload 4
    //   187: invokevirtual 301	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   190: iconst_0
    //   191: invokestatic 304	bbdj:a	(Ljava/lang/String;[BZ)Z
    //   194: pop
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 305	java/io/ObjectOutputStream:close	()V
    //   203: ldc 2
    //   205: monitorexit
    //   206: return
    //   207: astore_0
    //   208: aload_2
    //   209: monitorexit
    //   210: aload_0
    //   211: athrow
    //   212: astore_0
    //   213: ldc 2
    //   215: monitorexit
    //   216: aload_0
    //   217: athrow
    //   218: astore_1
    //   219: aconst_null
    //   220: astore_0
    //   221: aload_0
    //   222: astore_2
    //   223: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +15 -> 241
    //   229: aload_0
    //   230: astore_2
    //   231: ldc 180
    //   233: iconst_2
    //   234: ldc_w 307
    //   237: aload_1
    //   238: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_0
    //   242: ifnull -39 -> 203
    //   245: aload_0
    //   246: invokevirtual 305	java/io/ObjectOutputStream:close	()V
    //   249: goto -46 -> 203
    //   252: astore_0
    //   253: goto -50 -> 203
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_2
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 305	java/io/ObjectOutputStream:close	()V
    //   267: aload_0
    //   268: athrow
    //   269: astore_0
    //   270: goto -67 -> 203
    //   273: astore_1
    //   274: goto -7 -> 267
    //   277: astore_0
    //   278: goto -19 -> 259
    //   281: astore_1
    //   282: aload_3
    //   283: astore_0
    //   284: goto -63 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramContext	Context
    //   0	287	1	paramaujp	aujp
    //   6	258	2	localObject	Object
    //   41	242	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   30	156	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	23	207	finally
    //   208	210	207	finally
    //   3	9	212	finally
    //   199	203	212	finally
    //   210	212	212	finally
    //   245	249	212	finally
    //   263	267	212	finally
    //   267	269	212	finally
    //   23	42	218	java/lang/Exception
    //   245	249	252	java/lang/Exception
    //   23	42	256	finally
    //   199	203	269	java/lang/Exception
    //   263	267	273	java/lang/Exception
    //   44	52	277	finally
    //   54	62	277	finally
    //   64	71	277	finally
    //   73	81	277	finally
    //   83	91	277	finally
    //   93	101	277	finally
    //   103	111	277	finally
    //   113	121	277	finally
    //   123	131	277	finally
    //   133	141	277	finally
    //   143	147	277	finally
    //   149	195	277	finally
    //   223	229	277	finally
    //   231	241	277	finally
    //   44	52	281	java/lang/Exception
    //   54	62	281	java/lang/Exception
    //   64	71	281	java/lang/Exception
    //   73	81	281	java/lang/Exception
    //   83	91	281	java/lang/Exception
    //   93	101	281	java/lang/Exception
    //   103	111	281	java/lang/Exception
    //   113	121	281	java/lang/Exception
    //   123	131	281	java/lang/Exception
    //   133	141	281	java/lang/Exception
    //   143	147	281	java/lang/Exception
    //   149	195	281	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujo
 * JD-Core Version:    0.7.0.1
 */