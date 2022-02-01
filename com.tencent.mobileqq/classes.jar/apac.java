import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

public class apac
  implements INetEngine.INetEngineListener, Manager
{
  static INetEngine.IBreakDownFix jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new apad();
  aozz jdField_a_of_type_Aozz;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private List<apaf> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public apac(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = paramAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Aozz = new aozz();
  }
  
  private String a(apae paramapae)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramapae);
    }
    String str = this.jdField_a_of_type_Aozz.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramapae.jdField_a_of_type_Int).a(paramapae);
    if (!FileUtils.fileExists(str)) {}
    try
    {
      FileUtils.uncompressZip(this.jdField_a_of_type_Aozz.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramapae.jdField_a_of_type_Int).b(paramapae), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      FileUtils.deleteDirectory(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramapae + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(apae paramapae)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramapae);
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = paramapae.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = this.jdField_a_of_type_Aozz.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramapae.jdField_a_of_type_Int).b(paramapae);
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.setUserData(paramapae);
    localHttpNetReq.mBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.sendReq(localHttpNetReq);
  }
  
  private boolean b(apae paramapae)
  {
    return this.jdField_a_of_type_Aozz.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramapae.jdField_a_of_type_Int).a(paramapae);
  }
  
  public void a(apaf paramapaf)
  {
    if (paramapaf == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramapaf)) {
        this.jdField_a_of_type_JavaUtilList.add(paramapaf);
      }
      return;
    }
  }
  
  /* Error */
  public boolean a(apae arg1)
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
    //   20: ldc 188
    //   22: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 60	apac:jdField_a_of_type_Aozz	Laozz;
    //   39: aload_0
    //   40: getfield 47	apac:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   43: aload_1
    //   44: getfield 96	apae:jdField_a_of_type_Int	I
    //   47: invokevirtual 99	aozz:a	(Lcom/tencent/common/app/AppInterface;I)Lapab;
    //   50: astore 6
    //   52: aload_1
    //   53: getfield 190	apae:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +52 -> 111
    //   62: aload_0
    //   63: getfield 45	apac:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   66: aload_1
    //   67: getfield 190	apae:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: invokeinterface 199 2 0
    //   75: ifeq +36 -> 111
    //   78: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +28 -> 109
    //   84: ldc 71
    //   86: iconst_2
    //   87: new 73	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   94: ldc 201
    //   96: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: iconst_0
    //   110: ireturn
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 203	apac:b	(Lapae;)Z
    //   116: ifne +259 -> 375
    //   119: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +28 -> 150
    //   125: ldc 71
    //   127: iconst_2
    //   128: new 73	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   135: ldc 205
    //   137: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_1
    //   151: getfield 208	apae:jdField_a_of_type_Boolean	Z
    //   154: ifeq +166 -> 320
    //   157: aload 6
    //   159: aload_1
    //   160: invokeinterface 103 2 0
    //   165: astore 5
    //   167: aload 5
    //   169: invokestatic 109	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   172: ifeq +51 -> 223
    //   175: aload 6
    //   177: aload_1
    //   178: iconst_1
    //   179: invokeinterface 211 3 0
    //   184: ifne +39 -> 223
    //   187: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +28 -> 218
    //   193: ldc 71
    //   195: iconst_2
    //   196: new 73	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   203: ldc 213
    //   205: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload 5
    //   220: invokestatic 125	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   223: aload_0
    //   224: aload_1
    //   225: invokespecial 214	apac:a	(Lapae;)Ljava/lang/String;
    //   228: astore 5
    //   230: new 216	java/io/File
    //   233: dup
    //   234: aload 5
    //   236: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: invokevirtual 221	java/io/File:exists	()Z
    //   242: ifne +460 -> 702
    //   245: iload_3
    //   246: istore_2
    //   247: aload_0
    //   248: getfield 34	apac:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   251: astore 6
    //   253: aload 6
    //   255: monitorenter
    //   256: iconst_0
    //   257: istore_3
    //   258: iload_3
    //   259: aload_0
    //   260: getfield 34	apac:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   263: invokeinterface 225 1 0
    //   268: if_icmpge +65 -> 333
    //   271: aload_0
    //   272: getfield 34	apac:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   275: iload_3
    //   276: invokeinterface 229 2 0
    //   281: checkcast 231	apaf
    //   284: astore 7
    //   286: aload 7
    //   288: ifnull +25 -> 313
    //   291: aload 7
    //   293: aload_1
    //   294: getfield 148	apae:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: aload_1
    //   298: getfield 190	apae:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   301: iload_2
    //   302: aload 5
    //   304: aload_1
    //   305: getfield 234	apae:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   308: invokeinterface 237 6 0
    //   313: iload_3
    //   314: iconst_1
    //   315: iadd
    //   316: istore_3
    //   317: goto -59 -> 258
    //   320: aload 6
    //   322: aload_1
    //   323: invokeinterface 112 2 0
    //   328: astore 5
    //   330: goto -100 -> 230
    //   333: aload 6
    //   335: monitorexit
    //   336: aload_1
    //   337: getfield 240	apae:jdField_a_of_type_Apaf	Lapaf;
    //   340: ifnull +27 -> 367
    //   343: aload_1
    //   344: getfield 240	apae:jdField_a_of_type_Apaf	Lapaf;
    //   347: aload_1
    //   348: getfield 148	apae:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   351: aload_1
    //   352: getfield 190	apae:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   355: iload_2
    //   356: aload 5
    //   358: aload_1
    //   359: getfield 234	apae:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   362: invokeinterface 237 6 0
    //   367: iconst_1
    //   368: ireturn
    //   369: astore_1
    //   370: aload 6
    //   372: monitorexit
    //   373: aload_1
    //   374: athrow
    //   375: aload_0
    //   376: getfield 45	apac:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   379: aload_1
    //   380: getfield 190	apae:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   383: invokeinterface 241 2 0
    //   388: pop
    //   389: aload_0
    //   390: getfield 47	apac:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   393: sipush 179
    //   396: invokevirtual 245	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   399: checkcast 247	ayji
    //   402: astore 5
    //   404: aload 5
    //   406: ifnonnull +259 -> 665
    //   409: aconst_null
    //   410: astore 5
    //   412: aload 5
    //   414: ifnull +73 -> 487
    //   417: aload 5
    //   419: aload_1
    //   420: getfield 190	apae:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   423: invokevirtual 251	ayjk:a	(Ljava/lang/String;)Z
    //   426: istore 4
    //   428: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +42 -> 473
    //   434: ldc 71
    //   436: iconst_2
    //   437: new 73	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   444: ldc 253
    //   446: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: iload 4
    //   451: invokevirtual 256	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   454: ldc_w 258
    //   457: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_1
    //   461: getfield 190	apae:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   464: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: iload 4
    //   475: ifeq +12 -> 487
    //   478: aload 5
    //   480: aload_1
    //   481: getfield 190	apae:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   484: invokevirtual 260	ayjk:a	(Ljava/lang/String;)V
    //   487: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   490: ifeq +32 -> 522
    //   493: ldc 71
    //   495: iconst_2
    //   496: new 73	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 262
    //   506: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_1
    //   510: getfield 148	apae:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   513: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: aload_1
    //   523: getfield 96	apae:jdField_a_of_type_Int	I
    //   526: iconst_4
    //   527: if_icmpne +10 -> 537
    //   530: aload_1
    //   531: getfield 190	apae:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   534: invokestatic 265	ltf:a	(Ljava/lang/String;)V
    //   537: new 140	com/tencent/mobileqq/transfile/HttpNetReq
    //   540: dup
    //   541: invokespecial 141	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   544: astore 5
    //   546: aload 5
    //   548: aload_0
    //   549: putfield 145	com/tencent/mobileqq/transfile/HttpNetReq:mCallback	Lcom/tencent/mobileqq/transfile/INetEngine$INetEngineListener;
    //   552: aload 5
    //   554: aload_1
    //   555: getfield 148	apae:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   558: putfield 151	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   561: aload 5
    //   563: iconst_0
    //   564: putfield 154	com/tencent/mobileqq/transfile/HttpNetReq:mHttpMethod	I
    //   567: aload 5
    //   569: aload 6
    //   571: aload_1
    //   572: invokeinterface 112 2 0
    //   577: putfield 157	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   580: aload 5
    //   582: iconst_1
    //   583: putfield 160	com/tencent/mobileqq/transfile/HttpNetReq:mPrioty	I
    //   586: aload 5
    //   588: aload_1
    //   589: invokevirtual 164	com/tencent/mobileqq/transfile/HttpNetReq:setUserData	(Ljava/lang/Object;)V
    //   592: aload 5
    //   594: getstatic 26	apac:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix	Lcom/tencent/mobileqq/transfile/INetEngine$IBreakDownFix;
    //   597: putfield 167	com/tencent/mobileqq/transfile/HttpNetReq:mBreakDownFix	Lcom/tencent/mobileqq/transfile/INetEngine$IBreakDownFix;
    //   600: aload_0
    //   601: getfield 55	apac:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine	Lcom/tencent/mobileqq/transfile/INetEngine;
    //   604: aload 5
    //   606: invokeinterface 173 2 0
    //   611: aload_0
    //   612: getfield 34	apac:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   615: astore_1
    //   616: aload_1
    //   617: monitorenter
    //   618: iload_2
    //   619: aload_0
    //   620: getfield 34	apac:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   623: invokeinterface 225 1 0
    //   628: if_icmpge +63 -> 691
    //   631: aload_0
    //   632: getfield 34	apac:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   635: iload_2
    //   636: invokeinterface 229 2 0
    //   641: checkcast 231	apaf
    //   644: astore 5
    //   646: aload 5
    //   648: ifnull +10 -> 658
    //   651: aload 5
    //   653: invokeinterface 267 1 0
    //   658: iload_2
    //   659: iconst_1
    //   660: iadd
    //   661: istore_2
    //   662: goto -44 -> 618
    //   665: aload 5
    //   667: invokevirtual 270	ayji:a	()Layjk;
    //   670: astore 5
    //   672: goto -260 -> 412
    //   675: astore 5
    //   677: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq -193 -> 487
    //   683: aload 5
    //   685: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   688: goto -201 -> 487
    //   691: aload_1
    //   692: monitorexit
    //   693: iconst_1
    //   694: ireturn
    //   695: astore 5
    //   697: aload_1
    //   698: monitorexit
    //   699: aload 5
    //   701: athrow
    //   702: iconst_0
    //   703: istore_2
    //   704: goto -457 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	apac
    //   1	703	2	i	int
    //   3	314	3	j	int
    //   426	48	4	bool	boolean
    //   165	506	5	localObject1	Object
    //   675	9	5	localException	Exception
    //   695	5	5	localObject2	Object
    //   50	520	6	localObject3	Object
    //   284	8	7	localapaf	apaf
    // Exception table:
    //   from	to	target	type
    //   258	286	369	finally
    //   291	313	369	finally
    //   333	336	369	finally
    //   370	373	369	finally
    //   389	404	675	java/lang/Exception
    //   417	473	675	java/lang/Exception
    //   478	487	675	java/lang/Exception
    //   665	672	675	java/lang/Exception
    //   618	646	695	finally
    //   651	658	695	finally
    //   691	693	695	finally
    //   697	699	695	finally
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, apaf paramapaf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    apae localapae = new apae();
    localapae.jdField_a_of_type_Int = paramInt;
    localapae.jdField_a_of_type_JavaLangString = paramString1;
    localapae.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localapae.c = str;
    localapae.jdField_a_of_type_Boolean = paramBoolean;
    localapae.jdField_a_of_type_JavaLangObject = paramObject;
    localapae.jdField_a_of_type_Apaf = paramapaf;
    if (TextUtils.isEmpty(paramString2)) {
      localapae.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localapae.jdField_b_of_type_Boolean = false;; localapae.jdField_b_of_type_Boolean = true)
    {
      return a(localapae);
      localapae.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(apaf paramapaf)
  {
    if (paramapaf == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramapaf);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool1;
    HttpNetReq localHttpNetReq;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label57:
    int k;
    Object localObject3;
    boolean bool2;
    if (paramNetResp.mResult == 0)
    {
      bool1 = true;
      localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
      localObject1 = new File(localHttpNetReq.mOutPath);
      localObject2 = localHttpNetReq.getUserData();
      i = paramNetResp.mErrCode;
      if (paramNetResp.mErrDesc != null) {
        break label447;
      }
      str = "0";
      k = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof apae))) {
        break label608;
      }
      localObject4 = (apae)localObject2;
      localObject3 = this.jdField_a_of_type_Aozz.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((apae)localObject4).jdField_a_of_type_Int);
      localObject2 = ((apae)localObject4).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label456;
      }
      if (!((apae)localObject4).jdField_b_of_type_Boolean) {
        break label1198;
      }
      if (((apab)localObject3).b((apae)localObject4)) {
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
      localObject3 = ((apab)localObject3).a((apae)localObject4);
      if ((!bool2) || (!((apae)localObject4).jdField_a_of_type_Boolean)) {
        break label1184;
      }
      FileUtils.deleteDirectory((String)localObject3);
      a((apae)localObject4);
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
        QLog.i("ResDownloadManager", 2, "onResp url:" + localHttpNetReq.mReqUrl + " result:" + paramNetResp.mResult + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (k == 0) {
        break label660;
      }
      label440:
      return;
      bool1 = false;
      break;
      label447:
      str = paramNetResp.mErrDesc;
      break label57;
      label456:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + paramNetResp.mResult + "|errCode:" + 3 + "|errDesc:" + str + "|params:" + localObject4);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((apae)localObject4).jdField_b_of_type_Int > 0)
      {
        ((apae)localObject4).jdField_b_of_type_Int -= 1;
        a((apae)localObject4);
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
          apaf localapaf = (apaf)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localapaf == null) || (localObject1 == null)) {
            break label1205;
          }
          localapaf.a(localHttpNetReq.mReqUrl, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((apae)localObject1).jdField_a_of_type_JavaLangObject);
          break label1205;
        }
        if ((localObject1 != null) && (((apae)localObject1).jdField_a_of_type_Apaf != null)) {
          ((apae)localObject1).jdField_a_of_type_Apaf.a(localHttpNetReq.mReqUrl, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((apae)localObject1).jdField_a_of_type_JavaLangObject);
        }
        if ((bool1) || (localObject1 == null)) {
          break label440;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + paramNetResp.mHttpCode);
        if ((paramNetResp.mRespProperties != null) && (paramNetResp.mRespProperties.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)paramNetResp.mRespProperties.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", ayjo.b(((apae)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((apae)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((apae)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((apae)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((apae)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((apae)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((apae)localObject1).jdField_b_of_type_Boolean + "");
          ((HashMap)localObject3).put("httpCode", paramNetResp.mHttpCode + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
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
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((??? == null) || (!(??? instanceof HttpNetReq))) {}
    String str1;
    do
    {
      return;
      str1 = ((HttpNetReq)???).mReqUrl;
      ??? = ???.getUserData();
    } while ((??? == null) || (!(??? instanceof apae)));
    apae localapae = (apae)???;
    String str2 = localapae.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + localapae);
    }
    if (localapae.jdField_a_of_type_Boolean) {}
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
            apaf localapaf = (apaf)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localapaf == null) {
              break label235;
            }
            localapaf.a(str1, str2, i);
            break label235;
          }
          if (localapae.jdField_a_of_type_Apaf == null) {
            break;
          }
          localapae.jdField_a_of_type_Apaf.a(str1, str2, i);
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
 * Qualified Name:     apac
 * JD-Core Version:    0.7.0.1
 */