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

public class aptb
  implements bdvw, Manager
{
  static bdvv jdField_a_of_type_Bdvv = new aptc();
  apsy jdField_a_of_type_Apsy;
  private bdvu jdField_a_of_type_Bdvu;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<apte> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public aptb(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bdvu = paramAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Apsy = new apsy();
  }
  
  private String a(aptd paramaptd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramaptd);
    }
    String str = this.jdField_a_of_type_Apsy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaptd.jdField_a_of_type_Int).a(paramaptd);
    if (!bgmg.a(str)) {}
    try
    {
      bgmg.a(this.jdField_a_of_type_Apsy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaptd.jdField_a_of_type_Int).b(paramaptd), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      bgmg.a(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramaptd + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(aptd paramaptd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramaptd);
    }
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = this;
    localbdvs.jdField_a_of_type_JavaLangString = paramaptd.jdField_a_of_type_JavaLangString;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = this.jdField_a_of_type_Apsy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaptd.jdField_a_of_type_Int).b(paramaptd);
    localbdvs.d = 1;
    localbdvs.a(paramaptd);
    localbdvs.jdField_a_of_type_Bdvv = jdField_a_of_type_Bdvv;
    this.jdField_a_of_type_Bdvu.a(localbdvs);
  }
  
  private boolean b(aptd paramaptd)
  {
    return this.jdField_a_of_type_Apsy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaptd.jdField_a_of_type_Int).a(paramaptd);
  }
  
  public void a(apte paramapte)
  {
    if (paramapte == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramapte)) {
        this.jdField_a_of_type_JavaUtilList.add(paramapte);
      }
      return;
    }
  }
  
  /* Error */
  public boolean a(aptd arg1)
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
    //   36: getfield 60	aptb:jdField_a_of_type_Apsy	Lapsy;
    //   39: aload_0
    //   40: getfield 47	aptb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   43: aload_1
    //   44: getfield 96	aptd:jdField_a_of_type_Int	I
    //   47: invokevirtual 99	apsy:a	(Lcom/tencent/common/app/AppInterface;I)Lapta;
    //   50: astore 6
    //   52: aload_1
    //   53: getfield 177	aptd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +52 -> 111
    //   62: aload_0
    //   63: getfield 45	aptb:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   66: aload_1
    //   67: getfield 177	aptd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   113: invokespecial 190	aptb:b	(Laptd;)Z
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
    //   151: getfield 195	aptd:jdField_a_of_type_Boolean	Z
    //   154: ifeq +166 -> 320
    //   157: aload 6
    //   159: aload_1
    //   160: invokeinterface 103 2 0
    //   165: astore 5
    //   167: aload 5
    //   169: invokestatic 108	bgmg:a	(Ljava/lang/String;)Z
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
    //   220: invokestatic 122	bgmg:a	(Ljava/lang/String;)V
    //   223: aload_0
    //   224: aload_1
    //   225: invokespecial 201	aptb:a	(Laptd;)Ljava/lang/String;
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
    //   248: getfield 34	aptb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   251: astore 6
    //   253: aload 6
    //   255: monitorenter
    //   256: iconst_0
    //   257: istore_3
    //   258: iload_3
    //   259: aload_0
    //   260: getfield 34	aptb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   263: invokeinterface 212 1 0
    //   268: if_icmpge +65 -> 333
    //   271: aload_0
    //   272: getfield 34	aptb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   275: iload_3
    //   276: invokeinterface 216 2 0
    //   281: checkcast 218	apte
    //   284: astore 7
    //   286: aload 7
    //   288: ifnull +25 -> 313
    //   291: aload 7
    //   293: aload_1
    //   294: getfield 144	aptd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: aload_1
    //   298: getfield 177	aptd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   301: iload_2
    //   302: aload 5
    //   304: aload_1
    //   305: getfield 221	aptd:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
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
    //   337: getfield 227	aptd:jdField_a_of_type_Apte	Lapte;
    //   340: ifnull +27 -> 367
    //   343: aload_1
    //   344: getfield 227	aptd:jdField_a_of_type_Apte	Lapte;
    //   347: aload_1
    //   348: getfield 144	aptd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   351: aload_1
    //   352: getfield 177	aptd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   355: iload_2
    //   356: aload 5
    //   358: aload_1
    //   359: getfield 221	aptd:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   362: invokeinterface 224 6 0
    //   367: iconst_1
    //   368: ireturn
    //   369: astore_1
    //   370: aload 6
    //   372: monitorexit
    //   373: aload_1
    //   374: athrow
    //   375: aload_0
    //   376: getfield 45	aptb:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   379: aload_1
    //   380: getfield 177	aptd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   383: invokeinterface 228 2 0
    //   388: pop
    //   389: aload_0
    //   390: getfield 47	aptb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   393: sipush 179
    //   396: invokevirtual 232	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   399: checkcast 234	azcg
    //   402: astore 5
    //   404: aload 5
    //   406: ifnonnull +257 -> 663
    //   409: aconst_null
    //   410: astore 5
    //   412: aload 5
    //   414: ifnull +72 -> 486
    //   417: aload 5
    //   419: aload_1
    //   420: getfield 177	aptd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   423: invokevirtual 237	azci:a	(Ljava/lang/String;)Z
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
    //   460: getfield 177	aptd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   463: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: iload 4
    //   474: ifeq +12 -> 486
    //   477: aload 5
    //   479: aload_1
    //   480: getfield 177	aptd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   483: invokevirtual 245	azci:a	(Ljava/lang/String;)V
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
    //   508: getfield 144	aptd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   511: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload_1
    //   521: getfield 96	aptd:jdField_a_of_type_Int	I
    //   524: iconst_4
    //   525: if_icmpne +10 -> 535
    //   528: aload_1
    //   529: getfield 177	aptd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   532: invokestatic 250	ltb:a	(Ljava/lang/String;)V
    //   535: new 137	bdvs
    //   538: dup
    //   539: invokespecial 138	bdvs:<init>	()V
    //   542: astore 5
    //   544: aload 5
    //   546: aload_0
    //   547: putfield 141	bdvs:jdField_a_of_type_Bdvw	Lbdvw;
    //   550: aload 5
    //   552: aload_1
    //   553: getfield 144	aptd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   556: putfield 145	bdvs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   559: aload 5
    //   561: iconst_0
    //   562: putfield 146	bdvs:jdField_a_of_type_Int	I
    //   565: aload 5
    //   567: aload 6
    //   569: aload_1
    //   570: invokeinterface 111 2 0
    //   575: putfield 149	bdvs:c	Ljava/lang/String;
    //   578: aload 5
    //   580: iconst_1
    //   581: putfield 151	bdvs:d	I
    //   584: aload 5
    //   586: aload_1
    //   587: invokevirtual 154	bdvs:a	(Ljava/lang/Object;)V
    //   590: aload 5
    //   592: getstatic 26	aptb:jdField_a_of_type_Bdvv	Lbdvv;
    //   595: putfield 155	bdvs:jdField_a_of_type_Bdvv	Lbdvv;
    //   598: aload_0
    //   599: getfield 55	aptb:jdField_a_of_type_Bdvu	Lbdvu;
    //   602: aload 5
    //   604: invokeinterface 160 2 0
    //   609: aload_0
    //   610: getfield 34	aptb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   613: astore_1
    //   614: aload_1
    //   615: monitorenter
    //   616: iload_2
    //   617: aload_0
    //   618: getfield 34	aptb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   621: invokeinterface 212 1 0
    //   626: if_icmpge +63 -> 689
    //   629: aload_0
    //   630: getfield 34	aptb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   633: iload_2
    //   634: invokeinterface 216 2 0
    //   639: checkcast 218	apte
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
    //   665: invokevirtual 255	azcg:a	()Lazci;
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
    //   0	705	0	this	aptb
    //   1	701	2	i	int
    //   3	314	3	j	int
    //   426	47	4	bool	boolean
    //   165	504	5	localObject1	Object
    //   673	9	5	localException	Exception
    //   693	5	5	localObject2	Object
    //   50	518	6	localObject3	Object
    //   284	8	7	localapte	apte
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
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, apte paramapte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    aptd localaptd = new aptd();
    localaptd.jdField_a_of_type_Int = paramInt;
    localaptd.jdField_a_of_type_JavaLangString = paramString1;
    localaptd.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localaptd.c = str;
    localaptd.jdField_a_of_type_Boolean = paramBoolean;
    localaptd.jdField_a_of_type_JavaLangObject = paramObject;
    localaptd.jdField_a_of_type_Apte = paramapte;
    if (TextUtils.isEmpty(paramString2)) {
      localaptd.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localaptd.jdField_b_of_type_Boolean = false;; localaptd.jdField_b_of_type_Boolean = true)
    {
      return a(localaptd);
      localaptd.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(apte paramapte)
  {
    if (paramapte == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramapte);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onResp(bdwt parambdwt)
  {
    boolean bool1;
    bdvs localbdvs;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label57:
    int k;
    Object localObject3;
    boolean bool2;
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localbdvs = (bdvs)parambdwt.jdField_a_of_type_Bdws;
      localObject1 = new File(localbdvs.c);
      localObject2 = localbdvs.a();
      i = parambdwt.jdField_b_of_type_Int;
      if (parambdwt.jdField_a_of_type_JavaLangString != null) {
        break label447;
      }
      str = "0";
      k = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof aptd))) {
        break label608;
      }
      localObject4 = (aptd)localObject2;
      localObject3 = this.jdField_a_of_type_Apsy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((aptd)localObject4).jdField_a_of_type_Int);
      localObject2 = ((aptd)localObject4).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label456;
      }
      if (!((aptd)localObject4).jdField_b_of_type_Boolean) {
        break label1198;
      }
      if (((apta)localObject3).b((aptd)localObject4)) {
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
      localObject3 = ((apta)localObject3).a((aptd)localObject4);
      if ((!bool2) || (!((aptd)localObject4).jdField_a_of_type_Boolean)) {
        break label1184;
      }
      bgmg.a((String)localObject3);
      a((aptd)localObject4);
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
        QLog.i("ResDownloadManager", 2, "onResp url:" + localbdvs.jdField_a_of_type_JavaLangString + " result:" + parambdwt.jdField_a_of_type_Int + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (k == 0) {
        break label660;
      }
      label440:
      return;
      bool1 = false;
      break;
      label447:
      str = parambdwt.jdField_a_of_type_JavaLangString;
      break label57;
      label456:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + parambdwt.jdField_a_of_type_Int + "|errCode:" + 3 + "|errDesc:" + str + "|params:" + localObject4);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((aptd)localObject4).jdField_b_of_type_Int > 0)
      {
        ((aptd)localObject4).jdField_b_of_type_Int -= 1;
        a((aptd)localObject4);
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
          apte localapte = (apte)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localapte == null) || (localObject1 == null)) {
            break label1205;
          }
          localapte.a(localbdvs.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((aptd)localObject1).jdField_a_of_type_JavaLangObject);
          break label1205;
        }
        if ((localObject1 != null) && (((aptd)localObject1).jdField_a_of_type_Apte != null)) {
          ((aptd)localObject1).jdField_a_of_type_Apte.a(localbdvs.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((aptd)localObject1).jdField_a_of_type_JavaLangObject);
        }
        if ((bool1) || (localObject1 == null)) {
          break label440;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + parambdwt.c);
        if ((parambdwt.jdField_a_of_type_JavaUtilHashMap != null) && (parambdwt.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", azcm.b(((aptd)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((aptd)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((aptd)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((aptd)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((aptd)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((aptd)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((aptd)localObject1).jdField_b_of_type_Boolean + "");
          ((HashMap)localObject3).put("httpCode", parambdwt.c + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          bctj.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
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
  
  public void onUpdateProgeress(bdws arg1, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((??? == null) || (!(??? instanceof bdvs))) {}
    String str1;
    do
    {
      return;
      str1 = ((bdvs)???).jdField_a_of_type_JavaLangString;
      ??? = ???.a();
    } while ((??? == null) || (!(??? instanceof aptd)));
    aptd localaptd = (aptd)???;
    String str2 = localaptd.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + localaptd);
    }
    if (localaptd.jdField_a_of_type_Boolean) {}
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
            apte localapte = (apte)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localapte == null) {
              break label235;
            }
            localapte.a(str1, str2, i);
            break label235;
          }
          if (localaptd.jdField_a_of_type_Apte == null) {
            break;
          }
          localaptd.jdField_a_of_type_Apte.a(str1, str2, i);
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
 * Qualified Name:     aptb
 * JD-Core Version:    0.7.0.1
 */