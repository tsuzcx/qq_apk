package com.tencent.mobileqq.armap;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
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

public class ResDownloadManager
  implements INetEngineListener, Manager
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ResDownloadHandler jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  private List<ResDownloadManager.IResDownloadListener> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public ResDownloadManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler = new ResDownloadHandler();
  }
  
  private String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramDownloadParam);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).a(paramDownloadParam);
    if (!FileUtils.a(str)) {}
    try
    {
      FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).b(paramDownloadParam), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      FileUtils.a(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramDownloadParam + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramDownloadParam);
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = paramDownloadParam.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).b(paramDownloadParam);
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.setUserData(paramDownloadParam);
    localHttpNetReq.mSupportBreakResume = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq(localHttpNetReq);
  }
  
  private boolean b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    return this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).a(paramDownloadParam);
  }
  
  public void a(ResDownloadManager.IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramIResDownloadListener)) {
        this.jdField_a_of_type_JavaUtilList.add(paramIResDownloadListener);
      }
      return;
    }
  }
  
  /* Error */
  public boolean a(ResDownloadManager.DownloadParam arg1)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_2
    //   3: istore_3
    //   4: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +28 -> 35
    //   10: ldc 68
    //   12: iconst_2
    //   13: new 70	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   20: ldc 181
    //   22: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 56	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler	Lcom/tencent/mobileqq/armap/ResDownloadHandler;
    //   39: aload_0
    //   40: getfield 39	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   43: aload_1
    //   44: getfield 93	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_Int	I
    //   47: invokevirtual 96	com/tencent/mobileqq/armap/ResDownloadHandler:a	(Lcom/tencent/common/app/AppInterface;I)Lcom/tencent/mobileqq/armap/ResDownloadHandler$RDHandler;
    //   50: astore 6
    //   52: aload_1
    //   53: getfield 183	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokestatic 189	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +52 -> 111
    //   62: aload_0
    //   63: getfield 37	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   66: aload_1
    //   67: getfield 183	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: invokeinterface 192 2 0
    //   75: ifeq +36 -> 111
    //   78: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +28 -> 109
    //   84: ldc 68
    //   86: iconst_2
    //   87: new 70	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   94: ldc 194
    //   96: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: iconst_0
    //   110: ireturn
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 196	com/tencent/mobileqq/armap/ResDownloadManager:b	(Lcom/tencent/mobileqq/armap/ResDownloadManager$DownloadParam;)Z
    //   116: ifne +259 -> 375
    //   119: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +28 -> 150
    //   125: ldc 68
    //   127: iconst_2
    //   128: new 70	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   135: ldc 198
    //   137: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_1
    //   151: getfield 200	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_Boolean	Z
    //   154: ifeq +166 -> 320
    //   157: aload 6
    //   159: aload_1
    //   160: invokeinterface 100 2 0
    //   165: astore 5
    //   167: aload 5
    //   169: invokestatic 105	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   172: ifeq +51 -> 223
    //   175: aload 6
    //   177: aload_1
    //   178: iconst_1
    //   179: invokeinterface 203 3 0
    //   184: ifne +39 -> 223
    //   187: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +28 -> 218
    //   193: ldc 68
    //   195: iconst_2
    //   196: new 70	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   203: ldc 205
    //   205: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload 5
    //   220: invokestatic 119	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   223: aload_0
    //   224: aload_1
    //   225: invokespecial 206	com/tencent/mobileqq/armap/ResDownloadManager:a	(Lcom/tencent/mobileqq/armap/ResDownloadManager$DownloadParam;)Ljava/lang/String;
    //   228: astore 5
    //   230: new 208	java/io/File
    //   233: dup
    //   234: aload 5
    //   236: invokespecial 210	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: invokevirtual 213	java/io/File:exists	()Z
    //   242: ifne +457 -> 699
    //   245: iload_3
    //   246: istore_2
    //   247: aload_0
    //   248: getfield 26	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   251: astore 6
    //   253: aload 6
    //   255: monitorenter
    //   256: iconst_0
    //   257: istore_3
    //   258: iload_3
    //   259: aload_0
    //   260: getfield 26	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   263: invokeinterface 217 1 0
    //   268: if_icmpge +65 -> 333
    //   271: aload_0
    //   272: getfield 26	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   275: iload_3
    //   276: invokeinterface 221 2 0
    //   281: checkcast 223	com/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener
    //   284: astore 7
    //   286: aload 7
    //   288: ifnull +25 -> 313
    //   291: aload 7
    //   293: aload_1
    //   294: getfield 142	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: aload_1
    //   298: getfield 183	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   301: iload_2
    //   302: aload 5
    //   304: aload_1
    //   305: getfield 226	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   308: invokeinterface 229 6 0
    //   313: iload_3
    //   314: iconst_1
    //   315: iadd
    //   316: istore_3
    //   317: goto -59 -> 258
    //   320: aload 6
    //   322: aload_1
    //   323: invokeinterface 108 2 0
    //   328: astore 5
    //   330: goto -100 -> 230
    //   333: aload 6
    //   335: monitorexit
    //   336: aload_1
    //   337: getfield 232	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   340: ifnull +27 -> 367
    //   343: aload_1
    //   344: getfield 232	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   347: aload_1
    //   348: getfield 142	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   351: aload_1
    //   352: getfield 183	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   355: iload_2
    //   356: aload 5
    //   358: aload_1
    //   359: getfield 226	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   362: invokeinterface 229 6 0
    //   367: iconst_1
    //   368: ireturn
    //   369: astore_1
    //   370: aload 6
    //   372: monitorexit
    //   373: aload_1
    //   374: athrow
    //   375: aload_0
    //   376: getfield 37	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   379: aload_1
    //   380: getfield 183	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   383: invokeinterface 233 2 0
    //   388: pop
    //   389: aload_0
    //   390: getfield 39	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   393: getstatic 238	com/tencent/mobileqq/app/QQManagerFactory:PRECOVER_MANAGER	I
    //   396: invokevirtual 242	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   399: checkcast 244	com/tencent/mobileqq/precover/PrecoverManager
    //   402: astore 5
    //   404: aload 5
    //   406: ifnonnull +256 -> 662
    //   409: aconst_null
    //   410: astore 5
    //   412: aload 5
    //   414: ifnull +72 -> 486
    //   417: aload 5
    //   419: aload_1
    //   420: getfield 183	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   423: invokevirtual 247	com/tencent/mobileqq/precover/PrecoverResDownloader:a	(Ljava/lang/String;)Z
    //   426: istore 4
    //   428: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +41 -> 472
    //   434: ldc 68
    //   436: iconst_2
    //   437: new 70	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   444: ldc 249
    //   446: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: iload 4
    //   451: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   454: ldc 254
    //   456: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_1
    //   460: getfield 183	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   463: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: iload 4
    //   474: ifeq +12 -> 486
    //   477: aload 5
    //   479: aload_1
    //   480: getfield 183	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   483: invokevirtual 255	com/tencent/mobileqq/precover/PrecoverResDownloader:a	(Ljava/lang/String;)V
    //   486: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +32 -> 521
    //   492: ldc 68
    //   494: iconst_2
    //   495: new 70	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 257
    //   505: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_1
    //   509: getfield 142	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   512: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aload_1
    //   522: getfield 93	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_Int	I
    //   525: iconst_4
    //   526: if_icmpne +10 -> 536
    //   529: aload_1
    //   530: getfield 183	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   533: invokestatic 260	com/tencent/av/redpacket/AVRedPacketDataCollector:a	(Ljava/lang/String;)V
    //   536: new 134	com/tencent/mobileqq/transfile/HttpNetReq
    //   539: dup
    //   540: invokespecial 135	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   543: astore 5
    //   545: aload 5
    //   547: aload_0
    //   548: putfield 139	com/tencent/mobileqq/transfile/HttpNetReq:mCallback	Lcom/tencent/mobileqq/transfile/INetEngineListener;
    //   551: aload 5
    //   553: aload_1
    //   554: getfield 142	com/tencent/mobileqq/armap/ResDownloadManager$DownloadParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   557: putfield 145	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   560: aload 5
    //   562: iconst_0
    //   563: putfield 148	com/tencent/mobileqq/transfile/HttpNetReq:mHttpMethod	I
    //   566: aload 5
    //   568: aload 6
    //   570: aload_1
    //   571: invokeinterface 108 2 0
    //   576: putfield 151	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   579: aload 5
    //   581: iconst_1
    //   582: putfield 154	com/tencent/mobileqq/transfile/HttpNetReq:mPrioty	I
    //   585: aload 5
    //   587: aload_1
    //   588: invokevirtual 158	com/tencent/mobileqq/transfile/HttpNetReq:setUserData	(Ljava/lang/Object;)V
    //   591: aload 5
    //   593: iconst_1
    //   594: putfield 162	com/tencent/mobileqq/transfile/HttpNetReq:mSupportBreakResume	Z
    //   597: aload_0
    //   598: getfield 51	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService	Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;
    //   601: aload 5
    //   603: invokeinterface 166 2 0
    //   608: aload_0
    //   609: getfield 26	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   612: astore_1
    //   613: aload_1
    //   614: monitorenter
    //   615: iload_2
    //   616: aload_0
    //   617: getfield 26	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   620: invokeinterface 217 1 0
    //   625: if_icmpge +63 -> 688
    //   628: aload_0
    //   629: getfield 26	com/tencent/mobileqq/armap/ResDownloadManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   632: iload_2
    //   633: invokeinterface 221 2 0
    //   638: checkcast 223	com/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener
    //   641: astore 5
    //   643: aload 5
    //   645: ifnull +10 -> 655
    //   648: aload 5
    //   650: invokeinterface 262 1 0
    //   655: iload_2
    //   656: iconst_1
    //   657: iadd
    //   658: istore_2
    //   659: goto -44 -> 615
    //   662: aload 5
    //   664: invokevirtual 265	com/tencent/mobileqq/precover/PrecoverManager:a	()Lcom/tencent/mobileqq/precover/PrecoverResDownloader;
    //   667: astore 5
    //   669: goto -257 -> 412
    //   672: astore 5
    //   674: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   677: ifeq -191 -> 486
    //   680: aload 5
    //   682: invokevirtual 268	java/lang/Exception:printStackTrace	()V
    //   685: goto -199 -> 486
    //   688: aload_1
    //   689: monitorexit
    //   690: iconst_1
    //   691: ireturn
    //   692: astore 5
    //   694: aload_1
    //   695: monitorexit
    //   696: aload 5
    //   698: athrow
    //   699: iconst_0
    //   700: istore_2
    //   701: goto -454 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	ResDownloadManager
    //   1	700	2	i	int
    //   3	314	3	j	int
    //   426	47	4	bool	boolean
    //   165	503	5	localObject1	Object
    //   672	9	5	localException	Exception
    //   692	5	5	localObject2	Object
    //   50	519	6	localObject3	Object
    //   284	8	7	localIResDownloadListener	ResDownloadManager.IResDownloadListener
    // Exception table:
    //   from	to	target	type
    //   258	286	369	finally
    //   291	313	369	finally
    //   333	336	369	finally
    //   370	373	369	finally
    //   389	404	672	java/lang/Exception
    //   417	472	672	java/lang/Exception
    //   477	486	672	java/lang/Exception
    //   662	669	672	java/lang/Exception
    //   615	643	692	finally
    //   648	655	692	finally
    //   688	690	692	finally
    //   694	696	692	finally
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, ResDownloadManager.IResDownloadListener paramIResDownloadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    ResDownloadManager.DownloadParam localDownloadParam = new ResDownloadManager.DownloadParam();
    localDownloadParam.jdField_a_of_type_Int = paramInt;
    localDownloadParam.jdField_a_of_type_JavaLangString = paramString1;
    localDownloadParam.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localDownloadParam.c = str;
    localDownloadParam.jdField_a_of_type_Boolean = paramBoolean;
    localDownloadParam.jdField_a_of_type_JavaLangObject = paramObject;
    localDownloadParam.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener = paramIResDownloadListener;
    if (TextUtils.isEmpty(paramString2)) {
      localDownloadParam.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localDownloadParam.jdField_b_of_type_Boolean = false;; localDownloadParam.jdField_b_of_type_Boolean = true)
    {
      return a(localDownloadParam);
      localDownloadParam.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(ResDownloadManager.IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramIResDownloadListener);
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
      if ((localObject2 == null) || (!(localObject2 instanceof ResDownloadManager.DownloadParam))) {
        break label608;
      }
      localObject4 = (ResDownloadManager.DownloadParam)localObject2;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((ResDownloadManager.DownloadParam)localObject4).jdField_a_of_type_Int);
      localObject2 = ((ResDownloadManager.DownloadParam)localObject4).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label456;
      }
      if (!((ResDownloadManager.DownloadParam)localObject4).jdField_b_of_type_Boolean) {
        break label1198;
      }
      if (((ResDownloadHandler.RDHandler)localObject3).b((ResDownloadManager.DownloadParam)localObject4)) {
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
      localObject3 = ((ResDownloadHandler.RDHandler)localObject3).a((ResDownloadManager.DownloadParam)localObject4);
      if ((!bool2) || (!((ResDownloadManager.DownloadParam)localObject4).jdField_a_of_type_Boolean)) {
        break label1184;
      }
      FileUtils.a((String)localObject3);
      a((ResDownloadManager.DownloadParam)localObject4);
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
      if (((ResDownloadManager.DownloadParam)localObject4).jdField_b_of_type_Int > 0)
      {
        ((ResDownloadManager.DownloadParam)localObject4).jdField_b_of_type_Int -= 1;
        a((ResDownloadManager.DownloadParam)localObject4);
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
          ResDownloadManager.IResDownloadListener localIResDownloadListener = (ResDownloadManager.IResDownloadListener)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localIResDownloadListener == null) || (localObject1 == null)) {
            break label1205;
          }
          localIResDownloadListener.a(localHttpNetReq.mReqUrl, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangObject);
          break label1205;
        }
        if ((localObject1 != null) && (((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener != null)) {
          ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener.a(localHttpNetReq.mReqUrl, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangObject);
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
          ((HashMap)localObject3).put("url", PrecoverUtils.b(((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((ResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((ResDownloadManager.DownloadParam)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((ResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((ResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_Boolean + "");
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
    } while ((??? == null) || (!(??? instanceof ResDownloadManager.DownloadParam)));
    ResDownloadManager.DownloadParam localDownloadParam = (ResDownloadManager.DownloadParam)???;
    String str2 = localDownloadParam.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + localDownloadParam);
    }
    if (localDownloadParam.jdField_a_of_type_Boolean) {}
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
            ResDownloadManager.IResDownloadListener localIResDownloadListener = (ResDownloadManager.IResDownloadListener)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localIResDownloadListener == null) {
              break label235;
            }
            localIResDownloadListener.a(str1, str2, i);
            break label235;
          }
          if (localDownloadParam.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener == null) {
            break;
          }
          localDownloadParam.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener.a(str1, str2, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadManager
 * JD-Core Version:    0.7.0.1
 */