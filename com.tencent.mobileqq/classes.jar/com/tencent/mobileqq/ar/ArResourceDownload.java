package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ArResourceConfigUtils;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import zyb;

public class ArResourceDownload
  implements INetEngine.INetEngineListener
{
  protected static INetEngine.IBreakDownFix a;
  private long jdField_a_of_type_Long;
  public AppInterface a;
  public ArResourceManager a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new zyb();
  }
  
  public ArResourceDownload(AppInterface paramAppInterface, ArResourceManager paramArResourceManager)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqArArResourceManager = paramArResourceManager;
  }
  
  private void a(ArResourceDownload.DownloadInfo paramDownloadInfo)
  {
    if ((TextUtils.isEmpty(paramDownloadInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramDownloadInfo.jdField_b_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_ArResourceDownload", 2, "downLoad:url=" + paramDownloadInfo.jdField_a_of_type_JavaLangString + ",md5= " + paramDownloadInfo.jdField_b_of_type_JavaLangString);
    }
    paramDownloadInfo.jdField_b_of_type_Int += 1;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.c = paramDownloadInfo.c;
    localHttpNetReq.e = 1;
    localHttpNetReq.a(paramDownloadInfo);
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
    paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
  }
  
  private boolean a(ArConfigInfo paramArConfigInfo)
  {
    if (paramArConfigInfo == null) {
      return true;
    }
    try
    {
      if (!paramArConfigInfo.mArCloudConfigInfos.isEmpty())
      {
        paramArConfigInfo = paramArConfigInfo.mArCloudConfigInfos.iterator();
        while (paramArConfigInfo.hasNext())
        {
          ArCloudConfigInfo localArCloudConfigInfo = (ArCloudConfigInfo)paramArConfigInfo.next();
          if (!FileUtils.a(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c)) {
            return false;
          }
          if (((localArCloudConfigInfo.jdField_d_of_type_Int == 0) || (localArCloudConfigInfo.jdField_d_of_type_Int == 100)) && (localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            boolean bool = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f).exists();
            if (!bool) {
              return false;
            }
          }
        }
      }
    }
    catch (Exception paramArConfigInfo)
    {
      QLog.i("ArConfig_ArResourceDownload", 1, "isResourceReady e=" + paramArConfigInfo.getMessage());
      return true;
    }
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ArResourceDownload.DownloadInfo localDownloadInfo = (ArResourceDownload.DownloadInfo)localIterator.next();
          if (localDownloadInfo.jdField_b_of_type_Long < localDownloadInfo.jdField_a_of_type_Long) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(localDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  /* Error */
  public void a(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 73
    //   10: iconst_2
    //   11: new 75	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   18: ldc 213
    //   20: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 196	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_Boolean	Z
    //   27: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 196	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_Boolean	Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifeq +6 -> 48
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: getfield 31	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_ArrayOfByte	[B
    //   52: astore 12
    //   54: aload 12
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   61: invokevirtual 205	java/util/ArrayList:clear	()V
    //   64: aload_1
    //   65: ifnull +121 -> 186
    //   68: aload_1
    //   69: getfield 142	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   72: ifnull +114 -> 186
    //   75: aload_1
    //   76: getfield 142	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   79: invokevirtual 220	java/util/ArrayList:size	()I
    //   82: ifle +104 -> 186
    //   85: iconst_0
    //   86: istore 4
    //   88: aload_1
    //   89: getfield 142	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   92: invokevirtual 148	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   95: astore 13
    //   97: aload 13
    //   99: invokeinterface 153 1 0
    //   104: ifeq +1811 -> 1915
    //   107: aload 13
    //   109: invokeinterface 157 1 0
    //   114: checkcast 159	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo
    //   117: astore 14
    //   119: aload 14
    //   121: ifnull +25 -> 146
    //   124: aload 14
    //   126: getfield 162	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   129: ifnull +17 -> 146
    //   132: aload 14
    //   134: getfield 162	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   137: getfield 221	com/tencent/mobileqq/ar/model/ArFeatureInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   140: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifeq +223 -> 366
    //   146: ldc 73
    //   148: iconst_1
    //   149: ldc 223
    //   151: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto -57 -> 97
    //   157: astore_1
    //   158: ldc 73
    //   160: iconst_2
    //   161: new 75	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   168: ldc 224
    //   170: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_1
    //   174: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_0
    //   187: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   190: invokevirtual 220	java/util/ArrayList:size	()I
    //   193: ifle +1999 -> 2192
    //   196: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +34 -> 233
    //   202: ldc 73
    //   204: iconst_2
    //   205: new 75	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   212: ldc 228
    //   214: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_0
    //   218: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   221: invokevirtual 220	java/util/ArrayList:size	()I
    //   224: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_0
    //   234: lconst_0
    //   235: putfield 232	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_Long	J
    //   238: aload_0
    //   239: lconst_0
    //   240: putfield 233	com/tencent/mobileqq/ar/ArResourceDownload:jdField_b_of_type_Long	J
    //   243: aload_0
    //   244: iconst_1
    //   245: putfield 196	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_Boolean	Z
    //   248: aload_0
    //   249: iconst_0
    //   250: putfield 235	com/tencent/mobileqq/ar/ArResourceDownload:jdField_b_of_type_Boolean	Z
    //   253: iconst_0
    //   254: istore 5
    //   256: aload_0
    //   257: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   260: invokevirtual 220	java/util/ArrayList:size	()I
    //   263: istore 4
    //   265: iload 4
    //   267: iconst_1
    //   268: isub
    //   269: istore 6
    //   271: iconst_0
    //   272: istore 4
    //   274: iload 6
    //   276: iflt +63 -> 339
    //   279: aload_0
    //   280: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   283: iload 6
    //   285: invokevirtual 239	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   288: checkcast 54	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo
    //   291: astore_1
    //   292: iload_2
    //   293: ifeq +1639 -> 1932
    //   296: aload_1
    //   297: iconst_1
    //   298: putfield 240	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_Boolean	Z
    //   301: aload_0
    //   302: getfield 51	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_ComTencentMobileqqArArResourceManager	Lcom/tencent/mobileqq/ar/ArResourceManager;
    //   305: aload_1
    //   306: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   309: invokevirtual 243	com/tencent/mobileqq/ar/ArResourceManager:a	(Ljava/lang/String;)Z
    //   312: ifne +1620 -> 1932
    //   315: aload_0
    //   316: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   319: iload 6
    //   321: invokevirtual 246	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   324: pop
    //   325: aload_0
    //   326: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   329: aload_1
    //   330: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   333: invokeinterface 249 2 0
    //   338: pop
    //   339: iload 4
    //   341: ifne +8 -> 349
    //   344: aload_0
    //   345: iconst_0
    //   346: putfield 196	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_Boolean	Z
    //   349: aload 12
    //   351: monitorexit
    //   352: goto -307 -> 45
    //   355: astore_1
    //   356: aload 12
    //   358: monitorexit
    //   359: aload_1
    //   360: athrow
    //   361: astore_1
    //   362: aload_0
    //   363: monitorexit
    //   364: aload_1
    //   365: athrow
    //   366: aload 14
    //   368: getfield 162	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   371: getfield 165	com/tencent/mobileqq/ar/model/ArFeatureInfo:c	Ljava/lang/String;
    //   374: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifne +132 -> 509
    //   380: aload 14
    //   382: getfield 162	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   385: getfield 165	com/tencent/mobileqq/ar/model/ArFeatureInfo:c	Ljava/lang/String;
    //   388: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   391: ifne +118 -> 509
    //   394: new 54	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo
    //   397: dup
    //   398: invokespecial 250	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:<init>	()V
    //   401: astore 8
    //   403: aload 8
    //   405: iconst_2
    //   406: putfield 251	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   409: aload 8
    //   411: aload 14
    //   413: getfield 162	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   416: getfield 221	com/tencent/mobileqq/ar/model/ArFeatureInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   419: putfield 57	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   422: aload 8
    //   424: aload 14
    //   426: getfield 162	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   429: getfield 252	com/tencent/mobileqq/ar/model/ArFeatureInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   432: putfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   435: aload 8
    //   437: aload 14
    //   439: getfield 162	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   442: getfield 165	com/tencent/mobileqq/ar/model/ArFeatureInfo:c	Ljava/lang/String;
    //   445: putfield 115	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   448: aload 8
    //   450: aload 14
    //   452: getfield 162	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   455: getfield 253	com/tencent/mobileqq/ar/model/ArFeatureInfo:jdField_a_of_type_Long	J
    //   458: putfield 200	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   461: aload 8
    //   463: iconst_1
    //   464: putfield 254	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   467: aload_0
    //   468: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   471: aload 8
    //   473: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   476: invokeinterface 257 2 0
    //   481: ifne +28 -> 509
    //   484: aload_0
    //   485: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   488: aload 8
    //   490: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   493: invokeinterface 260 2 0
    //   498: pop
    //   499: aload_0
    //   500: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   503: aload 8
    //   505: invokevirtual 261	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   508: pop
    //   509: aload 14
    //   511: getfield 262	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_Int	I
    //   514: iconst_1
    //   515: if_icmpne +249 -> 764
    //   518: aload 14
    //   520: getfield 265	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo	Lcom/tencent/mobileqq/ar/model/ArAwardInfo;
    //   523: ifnull +241 -> 764
    //   526: aload 14
    //   528: getfield 265	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo	Lcom/tencent/mobileqq/ar/model/ArAwardInfo;
    //   531: getfield 269	com/tencent/mobileqq/ar/model/ArAwardInfo:e	Ljava/lang/String;
    //   534: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   537: ifne +108 -> 645
    //   540: new 54	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo
    //   543: dup
    //   544: invokespecial 250	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:<init>	()V
    //   547: astore 8
    //   549: aload 8
    //   551: iconst_1
    //   552: putfield 251	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   555: aload 8
    //   557: aload 14
    //   559: getfield 265	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo	Lcom/tencent/mobileqq/ar/model/ArAwardInfo;
    //   562: getfield 270	com/tencent/mobileqq/ar/model/ArAwardInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   565: putfield 57	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   568: aload 8
    //   570: aload 14
    //   572: getfield 265	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo	Lcom/tencent/mobileqq/ar/model/ArAwardInfo;
    //   575: getfield 270	com/tencent/mobileqq/ar/model/ArAwardInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   578: invokestatic 275	com/tencent/securitysdk/utils/MD5:a	(Ljava/lang/String;)Ljava/lang/String;
    //   581: putfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   584: aload 8
    //   586: aload 14
    //   588: getfield 265	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo	Lcom/tencent/mobileqq/ar/model/ArAwardInfo;
    //   591: getfield 269	com/tencent/mobileqq/ar/model/ArAwardInfo:e	Ljava/lang/String;
    //   594: putfield 115	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   597: aload 8
    //   599: iconst_1
    //   600: putfield 254	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   603: aload_0
    //   604: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   607: aload 8
    //   609: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   612: invokeinterface 257 2 0
    //   617: ifne +28 -> 645
    //   620: aload_0
    //   621: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   624: aload 8
    //   626: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   629: invokeinterface 260 2 0
    //   634: pop
    //   635: aload_0
    //   636: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   639: aload 8
    //   641: invokevirtual 261	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   644: pop
    //   645: aload 14
    //   647: getfield 265	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo	Lcom/tencent/mobileqq/ar/model/ArAwardInfo;
    //   650: getfield 276	com/tencent/mobileqq/ar/model/ArAwardInfo:f	Ljava/lang/String;
    //   653: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   656: ifne +108 -> 764
    //   659: new 54	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo
    //   662: dup
    //   663: invokespecial 250	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:<init>	()V
    //   666: astore 8
    //   668: aload 8
    //   670: iconst_1
    //   671: putfield 251	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   674: aload 8
    //   676: aload 14
    //   678: getfield 265	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo	Lcom/tencent/mobileqq/ar/model/ArAwardInfo;
    //   681: getfield 277	com/tencent/mobileqq/ar/model/ArAwardInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   684: putfield 57	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   687: aload 8
    //   689: aload 14
    //   691: getfield 265	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo	Lcom/tencent/mobileqq/ar/model/ArAwardInfo;
    //   694: getfield 277	com/tencent/mobileqq/ar/model/ArAwardInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   697: invokestatic 275	com/tencent/securitysdk/utils/MD5:a	(Ljava/lang/String;)Ljava/lang/String;
    //   700: putfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   703: aload 8
    //   705: aload 14
    //   707: getfield 265	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo	Lcom/tencent/mobileqq/ar/model/ArAwardInfo;
    //   710: getfield 276	com/tencent/mobileqq/ar/model/ArAwardInfo:f	Ljava/lang/String;
    //   713: putfield 115	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   716: aload 8
    //   718: iconst_1
    //   719: putfield 254	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   722: aload_0
    //   723: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   726: aload 8
    //   728: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   731: invokeinterface 257 2 0
    //   736: ifne +28 -> 764
    //   739: aload_0
    //   740: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   743: aload 8
    //   745: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   748: invokeinterface 260 2 0
    //   753: pop
    //   754: aload_0
    //   755: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   758: aload 8
    //   760: invokevirtual 261	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   763: pop
    //   764: aload 14
    //   766: getfield 173	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   769: bipush 100
    //   771: if_icmpne +425 -> 1196
    //   774: ldc_w 279
    //   777: astore 8
    //   779: aload 14
    //   781: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   784: ifnull +1440 -> 2224
    //   787: new 178	java/io/File
    //   790: dup
    //   791: aload 14
    //   793: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   796: getfield 183	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   799: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   802: astore 10
    //   804: new 75	java/lang/StringBuilder
    //   807: dup
    //   808: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   811: invokestatic 283	com/tencent/mobileqq/ar/ArConfigUtils:a	()Ljava/lang/String;
    //   814: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: ldc_w 285
    //   820: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 14
    //   825: getfield 173	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   828: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   831: getstatic 288	java/io/File:separator	Ljava/lang/String;
    //   834: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: aload 14
    //   839: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   842: getfield 289	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   845: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: ldc_w 291
    //   851: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: astore 8
    //   859: new 178	java/io/File
    //   862: dup
    //   863: aload 8
    //   865: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   868: astore 9
    //   870: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   873: ifeq +44 -> 917
    //   876: ldc 73
    //   878: iconst_2
    //   879: new 75	java/lang/StringBuilder
    //   882: dup
    //   883: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   886: ldc_w 293
    //   889: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: aload 8
    //   894: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: ldc_w 295
    //   900: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: aload 9
    //   905: invokevirtual 189	java/io/File:exists	()Z
    //   908: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   911: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   917: aload 9
    //   919: invokevirtual 189	java/io/File:exists	()Z
    //   922: ifeq +63 -> 985
    //   925: aload 10
    //   927: invokevirtual 189	java/io/File:exists	()Z
    //   930: ifne +55 -> 985
    //   933: aload 10
    //   935: invokevirtual 298	java/io/File:mkdirs	()Z
    //   938: istore_3
    //   939: aload 9
    //   941: aload 10
    //   943: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   946: istore 7
    //   948: ldc 73
    //   950: iconst_1
    //   951: new 75	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   958: ldc_w 303
    //   961: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: iload 7
    //   966: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   969: ldc_w 305
    //   972: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: iload_3
    //   976: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   979: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: ldc_w 279
    //   988: astore 9
    //   990: aload 10
    //   992: invokevirtual 189	java/io/File:exists	()Z
    //   995: istore_3
    //   996: aload 9
    //   998: astore 8
    //   1000: iload_3
    //   1001: ifeq +109 -> 1110
    //   1004: aload 10
    //   1006: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1009: invokestatic 311	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1012: astore 11
    //   1014: aload 11
    //   1016: astore 9
    //   1018: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1021: ifeq +51 -> 1072
    //   1024: aload 11
    //   1026: astore 9
    //   1028: ldc 73
    //   1030: iconst_2
    //   1031: new 75	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1038: ldc_w 313
    //   1041: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload 11
    //   1046: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: ldc_w 315
    //   1052: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload 14
    //   1057: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1060: getfield 289	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1063: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1072: aload 11
    //   1074: astore 8
    //   1076: aload 11
    //   1078: astore 9
    //   1080: aload 14
    //   1082: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1085: getfield 289	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1088: aload 11
    //   1090: invokevirtual 320	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1093: ifne +17 -> 1110
    //   1096: aload 11
    //   1098: astore 9
    //   1100: aload 10
    //   1102: invokevirtual 323	java/io/File:delete	()Z
    //   1105: pop
    //   1106: aload 11
    //   1108: astore 8
    //   1110: aload 10
    //   1112: invokevirtual 189	java/io/File:exists	()Z
    //   1115: istore_3
    //   1116: new 325	java/util/HashMap
    //   1119: dup
    //   1120: invokespecial 326	java/util/HashMap:<init>	()V
    //   1123: astore 9
    //   1125: aload 9
    //   1127: ldc_w 328
    //   1130: aload 8
    //   1132: invokevirtual 332	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1135: pop
    //   1136: aload 9
    //   1138: ldc_w 334
    //   1141: aload_0
    //   1142: getfield 49	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1145: invokevirtual 337	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1148: invokevirtual 332	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1151: pop
    //   1152: iload_3
    //   1153: ifeq +1077 -> 2230
    //   1156: ldc_w 339
    //   1159: astore 8
    //   1161: aload 9
    //   1163: ldc_w 341
    //   1166: aload 8
    //   1168: invokevirtual 332	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1171: pop
    //   1172: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1175: invokestatic 352	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1178: ldc_w 279
    //   1181: ldc_w 354
    //   1184: iload_3
    //   1185: lconst_0
    //   1186: lconst_0
    //   1187: aload 9
    //   1189: ldc_w 279
    //   1192: iconst_1
    //   1193: invokevirtual 357	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1196: aload 14
    //   1198: getfield 173	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   1201: ifeq +13 -> 1214
    //   1204: aload 14
    //   1206: getfield 173	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_d_of_type_Int	I
    //   1209: bipush 100
    //   1211: if_icmpne +474 -> 1685
    //   1214: aload 14
    //   1216: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1219: ifnull +999 -> 2218
    //   1222: new 178	java/io/File
    //   1225: dup
    //   1226: aload 14
    //   1228: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1231: getfield 183	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1234: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   1237: astore 8
    //   1239: aconst_null
    //   1240: astore 10
    //   1242: aload 10
    //   1244: astore 9
    //   1246: aload 8
    //   1248: ifnull +25 -> 1273
    //   1251: aload 10
    //   1253: astore 9
    //   1255: aload 8
    //   1257: invokevirtual 189	java/io/File:exists	()Z
    //   1260: ifeq +13 -> 1273
    //   1263: aload 8
    //   1265: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1268: invokestatic 311	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1271: astore 9
    //   1273: aload 8
    //   1275: ifnull +292 -> 1567
    //   1278: aload 8
    //   1280: invokevirtual 189	java/io/File:exists	()Z
    //   1283: ifeq +284 -> 1567
    //   1286: aload 9
    //   1288: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1291: ifne +276 -> 1567
    //   1294: aload 9
    //   1296: aload 14
    //   1298: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1301: getfield 289	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1304: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1307: istore_3
    //   1308: iload_3
    //   1309: ifeq +258 -> 1567
    //   1312: new 178	java/io/File
    //   1315: dup
    //   1316: aload 14
    //   1318: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1321: getfield 183	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1324: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   1327: astore 8
    //   1329: aload 14
    //   1331: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1334: getfield 183	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1337: new 75	java/lang/StringBuilder
    //   1340: dup
    //   1341: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1344: aload 8
    //   1346: invokevirtual 364	java/io/File:getParentFile	()Ljava/io/File;
    //   1349: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1352: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: getstatic 288	java/io/File:separator	Ljava/lang/String;
    //   1358: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: aload 14
    //   1363: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1366: getfield 289	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1369: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: getstatic 288	java/io/File:separator	Ljava/lang/String;
    //   1375: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: invokestatic 369	com/tencent/mobileqq/ar/arengine/ArResourceConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1384: iconst_1
    //   1385: istore 5
    //   1387: iconst_1
    //   1388: istore 4
    //   1390: ldc 73
    //   1392: iconst_1
    //   1393: ldc_w 371
    //   1396: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1399: goto -1302 -> 97
    //   1402: astore 8
    //   1404: ldc 73
    //   1406: iconst_1
    //   1407: ldc_w 373
    //   1410: aload 8
    //   1412: invokestatic 376	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1415: aload 9
    //   1417: astore 8
    //   1419: goto -309 -> 1110
    //   1422: new 178	java/io/File
    //   1425: dup
    //   1426: aload 14
    //   1428: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1431: getfield 183	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1434: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   1437: invokevirtual 323	java/io/File:delete	()Z
    //   1440: pop
    //   1441: new 54	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo
    //   1444: dup
    //   1445: invokespecial 250	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:<init>	()V
    //   1448: astore 8
    //   1450: aload 8
    //   1452: iconst_3
    //   1453: putfield 251	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   1456: aload 8
    //   1458: aload 14
    //   1460: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1463: getfield 377	com/tencent/mobileqq/ar/model/ArModelResource:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1466: putfield 57	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1469: aload 8
    //   1471: aload 14
    //   1473: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1476: getfield 289	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1479: putfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1482: aload 8
    //   1484: aload 14
    //   1486: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1489: getfield 183	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1492: putfield 115	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   1495: aload 8
    //   1497: aload 14
    //   1499: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1502: getfield 378	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1505: putfield 200	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1508: aload 8
    //   1510: iconst_1
    //   1511: putfield 254	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1514: iload 5
    //   1516: istore 4
    //   1518: aload_0
    //   1519: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1522: aload 8
    //   1524: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1527: invokeinterface 257 2 0
    //   1532: ifne -133 -> 1399
    //   1535: aload_0
    //   1536: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1539: aload 8
    //   1541: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1544: invokeinterface 260 2 0
    //   1549: pop
    //   1550: aload_0
    //   1551: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1554: aload 8
    //   1556: invokevirtual 261	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1559: pop
    //   1560: iload 5
    //   1562: istore 4
    //   1564: goto -165 -> 1399
    //   1567: new 54	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo
    //   1570: dup
    //   1571: invokespecial 250	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:<init>	()V
    //   1574: astore 8
    //   1576: aload 8
    //   1578: iconst_3
    //   1579: putfield 251	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   1582: aload 8
    //   1584: aload 14
    //   1586: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1589: getfield 377	com/tencent/mobileqq/ar/model/ArModelResource:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1592: putfield 57	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1595: aload 8
    //   1597: aload 14
    //   1599: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1602: getfield 289	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1605: putfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1608: aload 8
    //   1610: aload 14
    //   1612: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1615: getfield 183	com/tencent/mobileqq/ar/model/ArModelResource:f	Ljava/lang/String;
    //   1618: putfield 115	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   1621: aload 8
    //   1623: aload 14
    //   1625: getfield 176	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1628: getfield 378	com/tencent/mobileqq/ar/model/ArModelResource:jdField_a_of_type_Long	J
    //   1631: putfield 200	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1634: aload 8
    //   1636: iconst_1
    //   1637: putfield 254	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1640: aload_0
    //   1641: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1644: aload 8
    //   1646: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1649: invokeinterface 257 2 0
    //   1654: ifne +593 -> 2247
    //   1657: aload_0
    //   1658: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1661: aload 8
    //   1663: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1666: invokeinterface 260 2 0
    //   1671: pop
    //   1672: aload_0
    //   1673: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1676: aload 8
    //   1678: invokevirtual 261	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1681: pop
    //   1682: goto +565 -> 2247
    //   1685: aload 14
    //   1687: getfield 379	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1690: ifnull -1593 -> 97
    //   1693: aload 14
    //   1695: getfield 379	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1698: invokevirtual 220	java/util/ArrayList:size	()I
    //   1701: ifle -1604 -> 97
    //   1704: aload 14
    //   1706: getfield 379	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1709: invokevirtual 148	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1712: astore 9
    //   1714: aload 9
    //   1716: invokeinterface 153 1 0
    //   1721: ifeq -1624 -> 97
    //   1724: aload 9
    //   1726: invokeinterface 157 1 0
    //   1731: checkcast 381	com/tencent/mobileqq/ar/model/ArVideoResourceInfo
    //   1734: astore 10
    //   1736: aload 10
    //   1738: getfield 382	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_Int	I
    //   1741: iconst_4
    //   1742: if_icmpeq -28 -> 1714
    //   1745: new 178	java/io/File
    //   1748: dup
    //   1749: aload 10
    //   1751: getfield 383	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:e	Ljava/lang/String;
    //   1754: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   1757: astore 11
    //   1759: aconst_null
    //   1760: astore 8
    //   1762: aload 11
    //   1764: invokevirtual 189	java/io/File:exists	()Z
    //   1767: ifeq +13 -> 1780
    //   1770: aload 11
    //   1772: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1775: invokestatic 311	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1778: astore 8
    //   1780: aload 11
    //   1782: invokevirtual 189	java/io/File:exists	()Z
    //   1785: ifeq +24 -> 1809
    //   1788: aload 8
    //   1790: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1793: ifne +16 -> 1809
    //   1796: aload 8
    //   1798: aload 10
    //   1800: getfield 384	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:c	Ljava/lang/String;
    //   1803: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1806: ifne -92 -> 1714
    //   1809: aload_0
    //   1810: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1813: aload 10
    //   1815: getfield 386	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1818: invokeinterface 257 2 0
    //   1823: ifne -109 -> 1714
    //   1826: new 54	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo
    //   1829: dup
    //   1830: invokespecial 250	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:<init>	()V
    //   1833: astore 8
    //   1835: aload 8
    //   1837: iconst_3
    //   1838: putfield 251	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Int	I
    //   1841: aload 8
    //   1843: aload 10
    //   1845: getfield 386	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1848: putfield 57	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1851: aload 8
    //   1853: aload 10
    //   1855: getfield 384	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:c	Ljava/lang/String;
    //   1858: putfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1861: aload 8
    //   1863: aload 10
    //   1865: getfield 387	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:jdField_a_of_type_Long	J
    //   1868: putfield 200	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1871: aload 8
    //   1873: aload 10
    //   1875: getfield 383	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:e	Ljava/lang/String;
    //   1878: putfield 115	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   1881: aload 8
    //   1883: iconst_1
    //   1884: putfield 254	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1887: aload_0
    //   1888: getfield 47	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1891: aload 8
    //   1893: invokevirtual 261	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1896: pop
    //   1897: aload_0
    //   1898: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1901: aload 10
    //   1903: getfield 384	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:c	Ljava/lang/String;
    //   1906: invokeinterface 260 2 0
    //   1911: pop
    //   1912: goto -198 -> 1714
    //   1915: iload 4
    //   1917: ifeq -1731 -> 186
    //   1920: aload_0
    //   1921: getfield 51	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_ComTencentMobileqqArArResourceManager	Lcom/tencent/mobileqq/ar/ArResourceManager;
    //   1924: aload_1
    //   1925: invokevirtual 389	com/tencent/mobileqq/ar/ArResourceManager:a	(Lcom/tencent/mobileqq/ar/aidl/ArConfigInfo;)Z
    //   1928: pop
    //   1929: goto -1743 -> 186
    //   1932: aload_0
    //   1933: aload_0
    //   1934: getfield 232	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_Long	J
    //   1937: aload_1
    //   1938: getfield 200	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_Long	J
    //   1941: ladd
    //   1942: putfield 232	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_Long	J
    //   1945: aload_0
    //   1946: getfield 49	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1949: sipush 167
    //   1952: invokevirtual 393	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1955: checkcast 242	com/tencent/mobileqq/ar/ArResourceManager
    //   1958: invokevirtual 395	com/tencent/mobileqq/ar/ArResourceManager:d	()I
    //   1961: istore 5
    //   1963: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1966: ifeq +284 -> 2250
    //   1969: ldc 73
    //   1971: iconst_2
    //   1972: new 75	java/lang/StringBuilder
    //   1975: dup
    //   1976: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1979: ldc_w 397
    //   1982: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1985: iload 5
    //   1987: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1990: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1993: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1996: goto +254 -> 2250
    //   1999: new 399	com/tencent/mobileqq/ar/ArResourceDownload$DownloadTask
    //   2002: dup
    //   2003: aload_0
    //   2004: getfield 49	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   2007: checkcast 401	com/tencent/mobileqq/app/QQAppInterface
    //   2010: aload_1
    //   2011: aload_0
    //   2012: invokespecial 404	com/tencent/mobileqq/ar/ArResourceDownload$DownloadTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo;Lcom/tencent/mobileqq/ar/ArResourceDownload;)V
    //   2015: astore 8
    //   2017: aload_0
    //   2018: getfield 49	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   2021: sipush 192
    //   2024: invokevirtual 393	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2027: checkcast 406	com/tencent/mobileqq/transfile/predownload/PreDownloadController
    //   2030: sipush 10067
    //   2033: ldc_w 408
    //   2036: aload_1
    //   2037: getfield 65	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2040: iconst_0
    //   2041: aload_1
    //   2042: getfield 57	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2045: aload_1
    //   2046: getfield 115	com/tencent/mobileqq/ar/ArResourceDownload$DownloadInfo:c	Ljava/lang/String;
    //   2049: iload 5
    //   2051: iconst_0
    //   2052: iconst_1
    //   2053: aload 8
    //   2055: invokevirtual 411	com/tencent/mobileqq/transfile/predownload/PreDownloadController:a	(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZLcom/tencent/mobileqq/transfile/predownload/AbsPreDownloadTask;)Z
    //   2058: istore_3
    //   2059: iload_3
    //   2060: ifeq +155 -> 2215
    //   2063: iload 4
    //   2065: iconst_1
    //   2066: iadd
    //   2067: istore 4
    //   2069: iload 4
    //   2071: istore 5
    //   2073: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2076: ifeq +33 -> 2109
    //   2079: iload 4
    //   2081: istore 5
    //   2083: ldc 73
    //   2085: iconst_2
    //   2086: new 75	java/lang/StringBuilder
    //   2089: dup
    //   2090: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   2093: ldc_w 413
    //   2096: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: iload_3
    //   2100: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2103: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2106: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2109: iload 6
    //   2111: iconst_1
    //   2112: isub
    //   2113: istore 6
    //   2115: goto -1841 -> 274
    //   2118: iconst_2
    //   2119: istore 5
    //   2121: goto -122 -> 1999
    //   2124: iconst_3
    //   2125: istore 5
    //   2127: goto -128 -> 1999
    //   2130: iconst_1
    //   2131: istore 5
    //   2133: goto -134 -> 1999
    //   2136: astore_1
    //   2137: aload_0
    //   2138: getfield 42	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2141: invokeinterface 208 1 0
    //   2146: iload 5
    //   2148: istore 4
    //   2150: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2153: ifeq -1814 -> 339
    //   2156: ldc 73
    //   2158: iconst_2
    //   2159: new 75	java/lang/StringBuilder
    //   2162: dup
    //   2163: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   2166: ldc_w 415
    //   2169: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2172: aload_1
    //   2173: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2176: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2182: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2185: iload 5
    //   2187: istore 4
    //   2189: goto -1850 -> 339
    //   2192: aload_0
    //   2193: getfield 51	com/tencent/mobileqq/ar/ArResourceDownload:jdField_a_of_type_ComTencentMobileqqArArResourceManager	Lcom/tencent/mobileqq/ar/ArResourceManager;
    //   2196: invokevirtual 417	com/tencent/mobileqq/ar/ArResourceManager:d	()V
    //   2199: goto -1850 -> 349
    //   2202: astore_1
    //   2203: iload 4
    //   2205: istore 5
    //   2207: goto -70 -> 2137
    //   2210: astore 8
    //   2212: goto -790 -> 1422
    //   2215: goto -146 -> 2069
    //   2218: aconst_null
    //   2219: astore 8
    //   2221: goto -982 -> 1239
    //   2224: aconst_null
    //   2225: astore 10
    //   2227: goto -1368 -> 859
    //   2230: ldc_w 419
    //   2233: astore 8
    //   2235: goto -1074 -> 1161
    //   2238: astore 8
    //   2240: iload 4
    //   2242: istore 5
    //   2244: goto -822 -> 1422
    //   2247: goto -848 -> 1399
    //   2250: iload 5
    //   2252: tableswitch	default:+28 -> 2280, 1:+-134->2118, 2:+-128->2124, 3:+-122->2130
    //   2281: istore 5
    //   2283: goto -284 -> 1999
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2286	0	this	ArResourceDownload
    //   0	2286	1	paramArConfigInfo	ArConfigInfo
    //   0	2286	2	paramBoolean1	boolean
    //   0	2286	3	paramBoolean2	boolean
    //   86	2155	4	i	int
    //   254	2028	5	j	int
    //   269	1845	6	k	int
    //   946	19	7	bool	boolean
    //   401	944	8	localObject1	Object
    //   1402	9	8	localThrowable	java.lang.Throwable
    //   1417	637	8	localObject2	Object
    //   2210	1	8	localException1	Exception
    //   2219	15	8	str	String
    //   2238	1	8	localException2	Exception
    //   868	857	9	localObject3	Object
    //   802	1424	10	localObject4	Object
    //   1012	769	11	localObject5	Object
    //   52	305	12	arrayOfByte	byte[]
    //   95	13	13	localIterator	Iterator
    //   117	1588	14	localArCloudConfigInfo	ArCloudConfigInfo
    // Exception table:
    //   from	to	target	type
    //   68	85	157	java/lang/Exception
    //   88	97	157	java/lang/Exception
    //   97	119	157	java/lang/Exception
    //   124	146	157	java/lang/Exception
    //   146	154	157	java/lang/Exception
    //   366	509	157	java/lang/Exception
    //   509	645	157	java/lang/Exception
    //   645	764	157	java/lang/Exception
    //   764	774	157	java/lang/Exception
    //   779	859	157	java/lang/Exception
    //   859	917	157	java/lang/Exception
    //   917	985	157	java/lang/Exception
    //   990	996	157	java/lang/Exception
    //   1004	1014	157	java/lang/Exception
    //   1018	1024	157	java/lang/Exception
    //   1028	1072	157	java/lang/Exception
    //   1080	1096	157	java/lang/Exception
    //   1100	1106	157	java/lang/Exception
    //   1110	1152	157	java/lang/Exception
    //   1161	1196	157	java/lang/Exception
    //   1196	1214	157	java/lang/Exception
    //   1214	1239	157	java/lang/Exception
    //   1255	1273	157	java/lang/Exception
    //   1278	1308	157	java/lang/Exception
    //   1404	1415	157	java/lang/Exception
    //   1422	1514	157	java/lang/Exception
    //   1518	1560	157	java/lang/Exception
    //   1567	1682	157	java/lang/Exception
    //   1685	1714	157	java/lang/Exception
    //   1714	1759	157	java/lang/Exception
    //   1762	1780	157	java/lang/Exception
    //   1780	1809	157	java/lang/Exception
    //   1809	1912	157	java/lang/Exception
    //   1920	1929	157	java/lang/Exception
    //   57	64	355	finally
    //   68	85	355	finally
    //   88	97	355	finally
    //   97	119	355	finally
    //   124	146	355	finally
    //   146	154	355	finally
    //   158	186	355	finally
    //   186	233	355	finally
    //   233	253	355	finally
    //   256	265	355	finally
    //   279	292	355	finally
    //   296	339	355	finally
    //   344	349	355	finally
    //   349	352	355	finally
    //   356	359	355	finally
    //   366	509	355	finally
    //   509	645	355	finally
    //   645	764	355	finally
    //   764	774	355	finally
    //   779	859	355	finally
    //   859	917	355	finally
    //   917	985	355	finally
    //   990	996	355	finally
    //   1004	1014	355	finally
    //   1018	1024	355	finally
    //   1028	1072	355	finally
    //   1080	1096	355	finally
    //   1100	1106	355	finally
    //   1110	1152	355	finally
    //   1161	1196	355	finally
    //   1196	1214	355	finally
    //   1214	1239	355	finally
    //   1255	1273	355	finally
    //   1278	1308	355	finally
    //   1312	1384	355	finally
    //   1390	1399	355	finally
    //   1404	1415	355	finally
    //   1422	1514	355	finally
    //   1518	1560	355	finally
    //   1567	1682	355	finally
    //   1685	1714	355	finally
    //   1714	1759	355	finally
    //   1762	1780	355	finally
    //   1780	1809	355	finally
    //   1809	1912	355	finally
    //   1920	1929	355	finally
    //   1932	1996	355	finally
    //   1999	2059	355	finally
    //   2073	2079	355	finally
    //   2083	2109	355	finally
    //   2137	2146	355	finally
    //   2150	2185	355	finally
    //   2192	2199	355	finally
    //   2	36	361	finally
    //   36	41	361	finally
    //   48	57	361	finally
    //   359	361	361	finally
    //   1004	1014	1402	java/lang/Throwable
    //   1018	1024	1402	java/lang/Throwable
    //   1028	1072	1402	java/lang/Throwable
    //   1080	1096	1402	java/lang/Throwable
    //   1100	1106	1402	java/lang/Throwable
    //   256	265	2136	java/lang/Exception
    //   2073	2079	2136	java/lang/Exception
    //   2083	2109	2136	java/lang/Exception
    //   279	292	2202	java/lang/Exception
    //   296	339	2202	java/lang/Exception
    //   1932	1996	2202	java/lang/Exception
    //   1999	2059	2202	java/lang/Exception
    //   1390	1399	2210	java/lang/Exception
    //   1312	1384	2238	java/lang/Exception
  }
  
  public void a(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof ArResourceDownload.DownloadInfo)))
    {
      ??? = (ArResourceDownload.DownloadInfo)???;
      if (???.jdField_a_of_type_Int != 1) {}
    }
    else
    {
      return;
    }
    String str = ???.jdField_b_of_type_JavaLangString;
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArResourceDownload.DownloadInfo localDownloadInfo = (ArResourceDownload.DownloadInfo)localIterator.next();
        if (str.equals(localDownloadInfo.jdField_b_of_type_JavaLangString))
        {
          paramLong2 = localDownloadInfo.jdField_b_of_type_Long;
          localDownloadInfo.jdField_b_of_type_Long = paramLong1;
          this.jdField_b_of_type_Long += paramLong1 - paramLong2;
        }
      }
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_Long);
      }
      return;
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 3)
    {
      QLog.d("ArConfig_ArResourceDownload", 1, "doOnResp is downloading...");
      return;
    }
    boolean bool1;
    label28:
    int i;
    HttpNetReq localHttpNetReq;
    boolean bool2;
    Object localObject3;
    ArResourceDownload.DownloadInfo localDownloadInfo;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      i = paramNetResp.jdField_b_of_type_Int;
      localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      ??? = localHttpNetReq.a();
      bool2 = bool1;
      if (??? != null)
      {
        bool2 = bool1;
        if ((??? instanceof ArResourceDownload.DownloadInfo))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a();
          localDownloadInfo = (ArResourceDownload.DownloadInfo)???;
          if (!TextUtils.isEmpty(localHttpNetReq.c)) {
            break label1267;
          }
          QLog.d("ArConfig_ArResourceDownload", 1, "req.mOutPath is null, md5=" + localDownloadInfo.jdField_b_of_type_JavaLangString);
          if (!bool1) {
            break label766;
          }
          i = 98765;
          label136:
          bool1 = false;
        }
      }
    }
    label264:
    label291:
    label1104:
    label1115:
    label1253:
    label1259:
    label1267:
    for (;;)
    {
      int j;
      if (bool1)
      {
        ??? = new File(localHttpNetReq.c);
        ??? = PortalUtils.a(((File)???).getAbsolutePath());
        if ((!TextUtils.isEmpty((CharSequence)???)) && (!((String)???).equalsIgnoreCase(localDownloadInfo.jdField_b_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceDownload", 2, "Md5 error|fileMD5=" + (String)??? + ", type=" + localDownloadInfo.jdField_a_of_type_Int);
          }
          j = i;
          bool2 = bool1;
          if (localDownloadInfo.jdField_a_of_type_Int != 1)
          {
            ((File)???).delete();
            bool2 = false;
            j = -100001;
          }
          if (localDownloadInfo.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(localDownloadInfo.jdField_b_of_type_JavaLangString, true);
          }
          bool1 = bool2;
          i = j;
          if (this.jdField_a_of_type_JavaUtilSet.contains(localDownloadInfo.jdField_b_of_type_JavaLangString)) {
            this.jdField_a_of_type_JavaUtilSet.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
            this.jdField_a_of_type_Boolean = false;
          }
          if ((localDownloadInfo.jdField_a_of_type_Int != 1) && (localDownloadInfo.jdField_a_of_type_Int != 2) && (localDownloadInfo.jdField_a_of_type_Int != 3) && (localDownloadInfo.jdField_a_of_type_Int != 4)) {
            break label1104;
          }
          j = 1;
          ??? = "0";
          if (!TextUtils.isEmpty(paramNetResp.jdField_a_of_type_JavaLangString))
          {
            ??? = paramNetResp.jdField_a_of_type_JavaLangString;
            ??? = ???;
            if (QLog.isColorLevel())
            {
              QLog.d("ArConfig_ArResourceDownload", 2, "errDesc: " + (String)???);
              ??? = ???;
            }
          }
          ??? = new HashMap();
          ((HashMap)???).put("url", OlympicUtil.a(localHttpNetReq.jdField_a_of_type_JavaLangString));
          ((HashMap)???).put("resultCode", String.valueOf(paramNetResp.jdField_a_of_type_Int));
          ((HashMap)???).put("fileSize", String.valueOf(localDownloadInfo.jdField_a_of_type_Long));
          ((HashMap)???).put("param_errorDesc", ???);
          if (!bool1) {
            break label1115;
          }
          ((HashMap)???).put("param_FailCode", "0");
          if ((j == 0) || (this.jdField_a_of_type_Boolean) || (!a((ArConfigInfo)localObject3))) {}
        }
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          for (;;)
          {
            if (!this.jdField_b_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.d();
              this.jdField_b_of_type_Boolean = true;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArConfig_ArResourceDownload", 2, "onResp:downloadSuccess!");
            }
            ??? = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
            StatisticCollector.a(BaseApplicationImpl.getContext()).a((String)???, "olympic_ar_download", bool1, 0L, 0L, (HashMap)???, null);
            bool2 = bool1;
            ??? = new File(localHttpNetReq.c);
            if ((!bool2) || (!((File)???).exists())) {
              break label1253;
            }
            l = ((File)???).length();
            ??? = (PreDownloadController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(192);
            ??? = localHttpNetReq.jdField_a_of_type_JavaLangString;
            if (!bool2) {
              break label1259;
            }
            ((PreDownloadController)???).a((String)???, l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ArConfig_ArResourceDownload", 2, "onResp:" + localHttpNetReq.jdField_a_of_type_JavaLangString + ", " + paramNetResp.jdField_a_of_type_Int + ", " + paramNetResp.jdField_b_of_type_Int);
            return;
            bool1 = false;
            break label28;
            label766:
            break label136;
            j = i;
            bool2 = bool1;
            if (localDownloadInfo.jdField_a_of_type_Int != 3) {
              break label264;
            }
            try
            {
              synchronized (this.jdField_a_of_type_ArrayOfByte)
              {
                Object localObject4 = ((ArConfigInfo)localObject3).getModelResByMd5(localDownloadInfo.jdField_b_of_type_JavaLangString);
                if ((!TextUtils.isEmpty(localDownloadInfo.c)) && (localObject4 != null) && ((((ArCloudConfigInfo)localObject4).jdField_d_of_type_Int == 0) || (((ArCloudConfigInfo)localObject4).jdField_d_of_type_Int == 100)))
                {
                  localObject4 = new File(localDownloadInfo.c);
                  ArResourceConfigUtils.a(localDownloadInfo.c, ((File)localObject4).getParentFile().getAbsolutePath() + File.separator + localDownloadInfo.jdField_b_of_type_JavaLangString + File.separator);
                  this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a((ArConfigInfo)localObject3);
                }
                j = i;
                bool2 = bool1;
              }
              if (!QLog.isColorLevel()) {
                break label264;
              }
            }
            catch (Exception localException)
            {
              ((File)???).delete();
              if (localDownloadInfo.jdField_a_of_type_Boolean)
              {
                bool1 = false;
                i = -100002;
              }
              j = i;
              bool2 = bool1;
            }
          }
          QLog.d("ArConfig_ArResourceDownload", 2, "e= " + localException.getMessage());
          j = i;
          bool2 = bool1;
          break label264;
          if ((localDownloadInfo.jdField_b_of_type_Int <= 3) && (!localDownloadInfo.jdField_b_of_type_Boolean))
          {
            a(localDownloadInfo);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ArConfig_ArResourceDownload", 2, "retry downLoad:retryUrl=" + localDownloadInfo.jdField_a_of_type_JavaLangString + ",retryMd5= " + localDownloadInfo.jdField_b_of_type_JavaLangString);
            return;
          }
          if (localDownloadInfo.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(localDownloadInfo.jdField_b_of_type_JavaLangString, false);
          }
          break label291;
          j = 0;
        }
        localException.put("param_FailCode", String.valueOf(i));
        this.jdField_a_of_type_JavaUtilSet.clear();
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          this.jdField_a_of_type_Boolean = false;
          localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localDownloadInfo = (ArResourceDownload.DownloadInfo)((Iterator)localObject3).next();
            if (localDownloadInfo.jdField_b_of_type_Long < localDownloadInfo.jdField_a_of_type_Long) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(localDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
            }
          }
        }
        if ((j != 0) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(i, paramNetResp.jdField_a_of_type_Int);
          this.jdField_b_of_type_Boolean = true;
        }
        continue;
        long l = 0L;
        continue;
        l = -1L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceDownload
 * JD-Core Version:    0.7.0.1
 */