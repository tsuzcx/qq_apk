import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

public class aqgr
  implements beuq, Manager
{
  static beup jdField_a_of_type_Beup = new aqgs();
  aqgo jdField_a_of_type_Aqgo;
  private beuo jdField_a_of_type_Beuo;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<aqgu> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public aqgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Beuo = paramAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Aqgo = new aqgo();
  }
  
  private String a(aqgt paramaqgt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramaqgt);
    }
    String str = this.jdField_a_of_type_Aqgo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaqgt.jdField_a_of_type_Int).a(paramaqgt);
    if (!bhmi.a(str)) {}
    try
    {
      bhmi.a(this.jdField_a_of_type_Aqgo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaqgt.jdField_a_of_type_Int).b(paramaqgt), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      bhmi.a(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramaqgt + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(aqgt paramaqgt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramaqgt);
    }
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_JavaLangString = paramaqgt.jdField_a_of_type_JavaLangString;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = this.jdField_a_of_type_Aqgo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaqgt.jdField_a_of_type_Int).b(paramaqgt);
    localbeum.d = 1;
    localbeum.a(paramaqgt);
    localbeum.jdField_a_of_type_Beup = jdField_a_of_type_Beup;
    this.jdField_a_of_type_Beuo.a(localbeum);
  }
  
  private boolean b(aqgt paramaqgt)
  {
    return this.jdField_a_of_type_Aqgo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaqgt.jdField_a_of_type_Int).a(paramaqgt);
  }
  
  public void a(aqgu paramaqgu)
  {
    if (paramaqgu == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramaqgu)) {
        this.jdField_a_of_type_JavaUtilList.add(paramaqgu);
      }
      return;
    }
  }
  
  /* Error */
  public boolean a(aqgt arg1)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_2
    //   3: istore_3
    //   4: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +28 -> 35
    //   10: ldc 71
    //   12: iconst_2
    //   13: new 73	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   20: ldc 175
    //   22: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 60	aqgr:jdField_a_of_type_Aqgo	Laqgo;
    //   39: aload_0
    //   40: getfield 47	aqgr:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   43: aload_1
    //   44: getfield 96	aqgt:jdField_a_of_type_Int	I
    //   47: invokevirtual 99	aqgo:a	(Lcom/tencent/common/app/AppInterface;I)Laqgq;
    //   50: astore 6
    //   52: aload_1
    //   53: getfield 177	aqgt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +52 -> 111
    //   62: aload_0
    //   63: getfield 45	aqgr:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   66: aload_1
    //   67: getfield 177	aqgt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: invokeinterface 186 2 0
    //   75: ifeq +36 -> 111
    //   78: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +28 -> 109
    //   84: ldc 71
    //   86: iconst_2
    //   87: new 73	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   94: ldc 188
    //   96: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: iconst_0
    //   110: ireturn
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 190	aqgr:b	(Laqgt;)Z
    //   116: ifne +259 -> 375
    //   119: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +28 -> 150
    //   125: ldc 71
    //   127: iconst_2
    //   128: new 73	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   135: ldc 192
    //   137: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_1
    //   151: getfield 195	aqgt:jdField_a_of_type_Boolean	Z
    //   154: ifeq +166 -> 320
    //   157: aload 6
    //   159: aload_1
    //   160: invokeinterface 103 2 0
    //   165: astore 5
    //   167: aload 5
    //   169: invokestatic 108	bhmi:a	(Ljava/lang/String;)Z
    //   172: ifeq +51 -> 223
    //   175: aload 6
    //   177: aload_1
    //   178: iconst_1
    //   179: invokeinterface 198 3 0
    //   184: ifne +39 -> 223
    //   187: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +28 -> 218
    //   193: ldc 71
    //   195: iconst_2
    //   196: new 73	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   203: ldc 200
    //   205: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload 5
    //   220: invokestatic 122	bhmi:a	(Ljava/lang/String;)V
    //   223: aload_0
    //   224: aload_1
    //   225: invokespecial 201	aqgr:a	(Laqgt;)Ljava/lang/String;
    //   228: astore 5
    //   230: new 203	java/io/File
    //   233: dup
    //   234: aload 5
    //   236: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: invokevirtual 208	java/io/File:exists	()Z
    //   242: ifne +458 -> 700
    //   245: iload_3
    //   246: istore_2
    //   247: aload_0
    //   248: getfield 34	aqgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   251: astore 6
    //   253: aload 6
    //   255: monitorenter
    //   256: iconst_0
    //   257: istore_3
    //   258: iload_3
    //   259: aload_0
    //   260: getfield 34	aqgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   263: invokeinterface 212 1 0
    //   268: if_icmpge +65 -> 333
    //   271: aload_0
    //   272: getfield 34	aqgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   275: iload_3
    //   276: invokeinterface 216 2 0
    //   281: checkcast 218	aqgu
    //   284: astore 7
    //   286: aload 7
    //   288: ifnull +25 -> 313
    //   291: aload 7
    //   293: aload_1
    //   294: getfield 144	aqgt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: aload_1
    //   298: getfield 177	aqgt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   301: iload_2
    //   302: aload 5
    //   304: aload_1
    //   305: getfield 221	aqgt:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   308: invokeinterface 224 6 0
    //   313: iload_3
    //   314: iconst_1
    //   315: iadd
    //   316: istore_3
    //   317: goto -59 -> 258
    //   320: aload 6
    //   322: aload_1
    //   323: invokeinterface 111 2 0
    //   328: astore 5
    //   330: goto -100 -> 230
    //   333: aload 6
    //   335: monitorexit
    //   336: aload_1
    //   337: getfield 227	aqgt:jdField_a_of_type_Aqgu	Laqgu;
    //   340: ifnull +27 -> 367
    //   343: aload_1
    //   344: getfield 227	aqgt:jdField_a_of_type_Aqgu	Laqgu;
    //   347: aload_1
    //   348: getfield 144	aqgt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   351: aload_1
    //   352: getfield 177	aqgt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   355: iload_2
    //   356: aload 5
    //   358: aload_1
    //   359: getfield 221	aqgt:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   362: invokeinterface 224 6 0
    //   367: iconst_1
    //   368: ireturn
    //   369: astore_1
    //   370: aload 6
    //   372: monitorexit
    //   373: aload_1
    //   374: athrow
    //   375: aload_0
    //   376: getfield 45	aqgr:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   379: aload_1
    //   380: getfield 177	aqgt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   383: invokeinterface 228 2 0
    //   388: pop
    //   389: aload_0
    //   390: getfield 47	aqgr:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   393: sipush 179
    //   396: invokevirtual 232	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   399: checkcast 234	azut
    //   402: astore 5
    //   404: aload 5
    //   406: ifnonnull +257 -> 663
    //   409: aconst_null
    //   410: astore 5
    //   412: aload 5
    //   414: ifnull +72 -> 486
    //   417: aload 5
    //   419: aload_1
    //   420: getfield 177	aqgt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   423: invokevirtual 237	azuv:a	(Ljava/lang/String;)Z
    //   426: istore 4
    //   428: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +41 -> 472
    //   434: ldc 71
    //   436: iconst_2
    //   437: new 73	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   444: ldc 239
    //   446: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: iload 4
    //   451: invokevirtual 242	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   454: ldc 244
    //   456: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_1
    //   460: getfield 177	aqgt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   463: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: iload 4
    //   474: ifeq +12 -> 486
    //   477: aload 5
    //   479: aload_1
    //   480: getfield 177	aqgt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   483: invokevirtual 245	azuv:a	(Ljava/lang/String;)V
    //   486: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +31 -> 520
    //   492: ldc 71
    //   494: iconst_2
    //   495: new 73	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   502: ldc 247
    //   504: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_1
    //   508: getfield 144	aqgt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   511: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload_1
    //   521: getfield 96	aqgt:jdField_a_of_type_Int	I
    //   524: iconst_4
    //   525: if_icmpne +10 -> 535
    //   528: aload_1
    //   529: getfield 177	aqgt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   532: invokestatic 250	ltx:a	(Ljava/lang/String;)V
    //   535: new 137	beum
    //   538: dup
    //   539: invokespecial 138	beum:<init>	()V
    //   542: astore 5
    //   544: aload 5
    //   546: aload_0
    //   547: putfield 141	beum:jdField_a_of_type_Beuq	Lbeuq;
    //   550: aload 5
    //   552: aload_1
    //   553: getfield 144	aqgt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   556: putfield 145	beum:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   559: aload 5
    //   561: iconst_0
    //   562: putfield 146	beum:jdField_a_of_type_Int	I
    //   565: aload 5
    //   567: aload 6
    //   569: aload_1
    //   570: invokeinterface 111 2 0
    //   575: putfield 149	beum:c	Ljava/lang/String;
    //   578: aload 5
    //   580: iconst_1
    //   581: putfield 151	beum:d	I
    //   584: aload 5
    //   586: aload_1
    //   587: invokevirtual 154	beum:a	(Ljava/lang/Object;)V
    //   590: aload 5
    //   592: getstatic 26	aqgr:jdField_a_of_type_Beup	Lbeup;
    //   595: putfield 155	beum:jdField_a_of_type_Beup	Lbeup;
    //   598: aload_0
    //   599: getfield 55	aqgr:jdField_a_of_type_Beuo	Lbeuo;
    //   602: aload 5
    //   604: invokeinterface 160 2 0
    //   609: aload_0
    //   610: getfield 34	aqgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   613: astore_1
    //   614: aload_1
    //   615: monitorenter
    //   616: iload_2
    //   617: aload_0
    //   618: getfield 34	aqgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   621: invokeinterface 212 1 0
    //   626: if_icmpge +63 -> 689
    //   629: aload_0
    //   630: getfield 34	aqgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   633: iload_2
    //   634: invokeinterface 216 2 0
    //   639: checkcast 218	aqgu
    //   642: astore 5
    //   644: aload 5
    //   646: ifnull +10 -> 656
    //   649: aload 5
    //   651: invokeinterface 252 1 0
    //   656: iload_2
    //   657: iconst_1
    //   658: iadd
    //   659: istore_2
    //   660: goto -44 -> 616
    //   663: aload 5
    //   665: invokevirtual 255	azut:a	()Lazuv;
    //   668: astore 5
    //   670: goto -258 -> 412
    //   673: astore 5
    //   675: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   678: ifeq -192 -> 486
    //   681: aload 5
    //   683: invokevirtual 258	java/lang/Exception:printStackTrace	()V
    //   686: goto -200 -> 486
    //   689: aload_1
    //   690: monitorexit
    //   691: iconst_1
    //   692: ireturn
    //   693: astore 5
    //   695: aload_1
    //   696: monitorexit
    //   697: aload 5
    //   699: athrow
    //   700: iconst_0
    //   701: istore_2
    //   702: goto -455 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	705	0	this	aqgr
    //   1	701	2	i	int
    //   3	314	3	j	int
    //   426	47	4	bool	boolean
    //   165	504	5	localObject1	Object
    //   673	9	5	localException	Exception
    //   693	5	5	localObject2	Object
    //   50	518	6	localObject3	Object
    //   284	8	7	localaqgu	aqgu
    // Exception table:
    //   from	to	target	type
    //   258	286	369	finally
    //   291	313	369	finally
    //   333	336	369	finally
    //   370	373	369	finally
    //   389	404	673	java/lang/Exception
    //   417	472	673	java/lang/Exception
    //   477	486	673	java/lang/Exception
    //   663	670	673	java/lang/Exception
    //   616	644	693	finally
    //   649	656	693	finally
    //   689	691	693	finally
    //   695	697	693	finally
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, aqgu paramaqgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    aqgt localaqgt = new aqgt();
    localaqgt.jdField_a_of_type_Int = paramInt;
    localaqgt.jdField_a_of_type_JavaLangString = paramString1;
    localaqgt.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localaqgt.c = str;
    localaqgt.jdField_a_of_type_Boolean = paramBoolean;
    localaqgt.jdField_a_of_type_JavaLangObject = paramObject;
    localaqgt.jdField_a_of_type_Aqgu = paramaqgu;
    if (TextUtils.isEmpty(paramString2)) {
      localaqgt.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localaqgt.jdField_b_of_type_Boolean = false;; localaqgt.jdField_b_of_type_Boolean = true)
    {
      return a(localaqgt);
      localaqgt.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(aqgu paramaqgu)
  {
    if (paramaqgu == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramaqgu);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onResp(bevm parambevm)
  {
    boolean bool1;
    beum localbeum;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label57:
    int k;
    Object localObject3;
    boolean bool2;
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localbeum = (beum)parambevm.jdField_a_of_type_Bevl;
      localObject1 = new File(localbeum.c);
      localObject2 = localbeum.a();
      i = parambevm.jdField_b_of_type_Int;
      if (parambevm.jdField_a_of_type_JavaLangString != null) {
        break label447;
      }
      str = "0";
      k = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof aqgt))) {
        break label608;
      }
      localObject4 = (aqgt)localObject2;
      localObject3 = this.jdField_a_of_type_Aqgo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((aqgt)localObject4).jdField_a_of_type_Int);
      localObject2 = ((aqgt)localObject4).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label456;
      }
      if (!((aqgt)localObject4).jdField_b_of_type_Boolean) {
        break label1198;
      }
      if (((aqgq)localObject3).b((aqgt)localObject4)) {
        break label1193;
      }
      j = -6103066;
      ((File)localObject1).delete();
      bool1 = false;
      i = j;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 1, "onResp.md5 verify suc|" + bool1 + "|" + localObject4);
        bool2 = bool1;
        i = j;
      }
      label199:
      localObject3 = ((aqgq)localObject3).a((aqgt)localObject4);
      if ((!bool2) || (!((aqgt)localObject4).jdField_a_of_type_Boolean)) {
        break label1184;
      }
      bhmi.a((String)localObject3);
      a((aqgt)localObject4);
      localObject3 = new File((String)localObject3);
      bool2 = ((File)localObject3).exists();
      if (!bool2) {
        i = 2;
      }
      j = i;
      localObject1 = localObject3;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 2, "onResp.unCompressZipFile suc|" + bool2 + "|" + localObject4);
        bool1 = bool2;
        localObject1 = localObject3;
        j = i;
      }
      label324:
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject2)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject2);
      }
      i = 0;
      label352:
      localObject3 = localObject1;
      localObject1 = localObject4;
      k = i;
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp url:" + localbeum.jdField_a_of_type_JavaLangString + " result:" + parambevm.jdField_a_of_type_Int + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (k == 0) {
        break label660;
      }
      label440:
      return;
      bool1 = false;
      break;
      label447:
      str = parambevm.jdField_a_of_type_JavaLangString;
      break label57;
      label456:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + parambevm.jdField_a_of_type_Int + "|errCode:" + 3 + "|errDesc:" + str + "|params:" + localObject4);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((aqgt)localObject4).jdField_b_of_type_Int > 0)
      {
        ((aqgt)localObject4).jdField_b_of_type_Int -= 1;
        a((aqgt)localObject4);
        i = 1;
        j = 3;
        break label352;
      }
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject2)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject2);
      }
      j = 3;
      i = 0;
      break label352;
      label608:
      ((File)localObject1).delete();
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp userdata|" + localObject2);
      }
      localObject3 = localObject1;
      localObject2 = null;
      localObject1 = null;
    }
    label660:
    Object localObject4 = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          aqgu localaqgu = (aqgu)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localaqgu == null) || (localObject1 == null)) {
            break label1205;
          }
          localaqgu.a(localbeum.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((aqgt)localObject1).jdField_a_of_type_JavaLangObject);
          break label1205;
        }
        if ((localObject1 != null) && (((aqgt)localObject1).jdField_a_of_type_Aqgu != null)) {
          ((aqgt)localObject1).jdField_a_of_type_Aqgu.a(localbeum.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((aqgt)localObject1).jdField_a_of_type_JavaLangObject);
        }
        if ((bool1) || (localObject1 == null)) {
          break label440;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + parambevm.c);
        if ((parambevm.jdField_a_of_type_JavaUtilHashMap != null) && (parambevm.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", azuz.b(((aqgt)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((aqgt)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((aqgt)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((aqgt)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((aqgt)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((aqgt)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((aqgt)localObject1).jdField_b_of_type_Boolean + "");
          ((HashMap)localObject3).put("httpCode", parambevm.c + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          bdmc.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
          return;
        }
      }
      finally {}
      localObject2 = "0";
      continue;
      label1184:
      bool1 = bool2;
      j = i;
      break label324;
      label1193:
      j = i;
      break;
      label1198:
      bool2 = bool1;
      break label199;
      label1205:
      j += 1;
    }
  }
  
  public void onUpdateProgeress(bevl arg1, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((??? == null) || (!(??? instanceof beum))) {}
    String str1;
    do
    {
      return;
      str1 = ((beum)???).jdField_a_of_type_JavaLangString;
      ??? = ???.a();
    } while ((??? == null) || (!(??? instanceof aqgt)));
    aqgt localaqgt = (aqgt)???;
    String str2 = localaqgt.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + localaqgt);
    }
    if (localaqgt.jdField_a_of_type_Boolean) {}
    for (int i = 90;; i = 100)
    {
      if (paramLong2 > 0L) {
        i = (int)(i * paramLong1 / paramLong2);
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          if (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            aqgu localaqgu = (aqgu)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localaqgu == null) {
              break label235;
            }
            localaqgu.a(str1, str2, i);
            break label235;
          }
          if (localaqgt.jdField_a_of_type_Aqgu == null) {
            break;
          }
          localaqgt.jdField_a_of_type_Aqgu.a(str1, str2, i);
          return;
        }
        i = 0;
        continue;
        label235:
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgr
 * JD-Core Version:    0.7.0.1
 */