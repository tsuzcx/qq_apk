import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

public abstract class asbv
{
  static final String jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "pddata/prd/early";
  public QQAppInterface a;
  private XmlData jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  protected ArrayList<asbp> a;
  protected boolean a;
  protected String b;
  protected boolean b;
  protected boolean c;
  
  public asbv(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public final XmlData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData == null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData = asbl.a(a());
    }
    return this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  }
  
  public abstract Class<? extends XmlData> a();
  
  public abstract String a();
  
  public GetResourceReqInfo a()
  {
    Object localObject = null;
    XmlData localXmlData = a();
    if ((localXmlData != null) && (localXmlData.strPkgName != null) && (localXmlData.strPkgName.length() > 0))
    {
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = localXmlData.strPkgName;
      ((GetResourceReqInfo)localObject).uiCurVer = b();
      ((GetResourceReqInfo)localObject).sResType = 512;
      ((GetResourceReqInfo)localObject).sLanType = 1;
      ((GetResourceReqInfo)localObject).sReqType = 1;
    }
    while (!QLog.isColorLevel()) {
      return localObject;
    }
    localObject = new StringBuffer("getResourceReqInfo() return null.");
    if (localXmlData == null) {
      ((StringBuffer)localObject).append("data==null");
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
      return null;
      ((StringBuffer)localObject).append("resName=" + localXmlData.strResName);
      ((StringBuffer)localObject).append(".pkgName=" + localXmlData.strPkgName);
    }
  }
  
  public GetResourceReqInfoV2 a(String paramString)
  {
    long l = 0L;
    XmlData localXmlData = a();
    GetResourceReqInfoV2 localGetResourceReqInfoV2;
    if (localXmlData == null)
    {
      localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = 1;
      localGetResourceReqInfoV2.strPkgName = paramString;
      localGetResourceReqInfoV2.uiCurVer = 0L;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuffer("getResourceReqInfoV2(), strPkgName=" + paramString);
        if (localXmlData != null) {
          break label168;
        }
        paramString.append(",data==null");
      }
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, paramString.toString());
      return localGetResourceReqInfoV2;
      localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = 1;
      localGetResourceReqInfoV2.strPkgName = paramString;
      if (f()) {}
      for (;;)
      {
        localGetResourceReqInfoV2.uiCurVer = l;
        break;
        l = b();
      }
      label168:
      paramString.append(",this.strResName=[" + this.jdField_b_of_type_JavaLangString);
      paramString.append("], resName=[" + localXmlData.strResName);
      paramString.append("], pkgName=[" + localXmlData.strPkgName);
      paramString.append("], version=[" + localXmlData.Version);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      XmlData localXmlData = a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((asbp)localIterator.next()).a(localXmlData, paramLong1, paramLong2);
      }
    }
  }
  
  public void a(asbp paramasbp)
  {
    if (paramasbp != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramasbp)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramasbp);
      }
    }
  }
  
  /* Error */
  public void a(XmlData paramXmlData)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +12 -> 13
    //   4: ldc 112
    //   6: iconst_1
    //   7: ldc 206
    //   9: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 59	asbv:a	()Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;
    //   17: astore 10
    //   19: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +91 -> 113
    //   25: ldc 112
    //   27: iconst_2
    //   28: new 17	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   35: ldc 211
    //   37: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: getfield 122	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   44: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 213
    //   49: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_1
    //   53: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   56: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: ldc 215
    //   61: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 10
    //   66: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   69: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 217
    //   74: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 10
    //   79: getfield 220	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   82: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: ldc 222
    //   87: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 10
    //   92: getfield 225	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   95: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 227
    //   100: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aconst_null
    //   114: astore 8
    //   116: aconst_null
    //   117: astore 6
    //   119: aconst_null
    //   120: astore 9
    //   122: new 232	java/io/File
    //   125: dup
    //   126: aload_0
    //   127: invokevirtual 234	asbv:c	()Ljava/lang/String;
    //   130: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: astore 7
    //   135: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +45 -> 183
    //   141: ldc 112
    //   143: iconst_2
    //   144: new 17	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   151: ldc 237
    //   153: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 7
    //   158: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 242
    //   166: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 7
    //   171: invokevirtual 245	java/io/File:exists	()Z
    //   174: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   177: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload 8
    //   185: astore 5
    //   187: aload 7
    //   189: invokevirtual 245	java/io/File:exists	()Z
    //   192: ifeq +89 -> 281
    //   195: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +32 -> 230
    //   201: ldc 112
    //   203: iconst_2
    //   204: new 17	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   211: ldc 250
    //   213: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 7
    //   218: invokevirtual 253	java/io/File:length	()J
    //   221: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload 7
    //   232: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   235: invokestatic 262	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   238: invokestatic 268	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   241: astore 4
    //   243: aload 4
    //   245: ifnull +735 -> 980
    //   248: aload_1
    //   249: getfield 271	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   252: ifnull +728 -> 980
    //   255: aload 4
    //   257: invokevirtual 274	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   260: aload_1
    //   261: getfield 271	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   264: invokevirtual 274	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   267: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   270: ifeq +710 -> 980
    //   273: aload 7
    //   275: astore 5
    //   277: aload 4
    //   279: astore 6
    //   281: new 232	java/io/File
    //   284: dup
    //   285: aload_0
    //   286: invokevirtual 279	asbv:d	()Ljava/lang/String;
    //   289: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   292: astore 8
    //   294: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +46 -> 343
    //   300: ldc 112
    //   302: iconst_2
    //   303: new 17	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 281
    //   313: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 8
    //   318: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   321: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 242
    //   326: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 8
    //   331: invokevirtual 245	java/io/File:exists	()Z
    //   334: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   337: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload 5
    //   345: ifnonnull +893 -> 1238
    //   348: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +33 -> 384
    //   354: ldc 112
    //   356: iconst_2
    //   357: new 17	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 283
    //   367: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 8
    //   372: invokevirtual 253	java/io/File:length	()J
    //   375: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   378: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: new 232	java/io/File
    //   387: dup
    //   388: new 17	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   395: getstatic 25	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   398: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: ldc_w 285
    //   404: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_0
    //   408: getfield 42	asbv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   411: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: astore 4
    //   422: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +46 -> 471
    //   428: ldc 112
    //   430: iconst_2
    //   431: new 17	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 287
    //   441: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 4
    //   446: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   449: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc 242
    //   454: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 4
    //   459: invokevirtual 245	java/io/File:exists	()Z
    //   462: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   465: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: aload 8
    //   473: invokevirtual 245	java/io/File:exists	()Z
    //   476: ifne +51 -> 527
    //   479: aload 4
    //   481: invokevirtual 245	java/io/File:exists	()Z
    //   484: ifeq +43 -> 527
    //   487: aload 4
    //   489: aload 8
    //   491: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   494: istore_2
    //   495: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq +29 -> 527
    //   501: ldc 112
    //   503: iconst_2
    //   504: new 17	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 295
    //   514: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: iload_2
    //   518: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   521: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   527: aload 4
    //   529: invokevirtual 245	java/io/File:exists	()Z
    //   532: ifeq +41 -> 573
    //   535: aload 4
    //   537: invokevirtual 298	java/io/File:delete	()Z
    //   540: istore_2
    //   541: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +29 -> 573
    //   547: ldc 112
    //   549: iconst_2
    //   550: new 17	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 300
    //   560: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: iload_2
    //   564: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   567: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: aload 8
    //   575: invokevirtual 245	java/io/File:exists	()Z
    //   578: ifeq +660 -> 1238
    //   581: aload 8
    //   583: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   586: invokestatic 262	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   589: invokestatic 268	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   592: astore 4
    //   594: aload 4
    //   596: ifnull +632 -> 1228
    //   599: aload_1
    //   600: getfield 271	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   603: ifnull +625 -> 1228
    //   606: aload 4
    //   608: invokevirtual 274	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   611: aload_1
    //   612: getfield 271	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   615: invokevirtual 274	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   618: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   621: ifeq +607 -> 1228
    //   624: aload 8
    //   626: astore 4
    //   628: aload 4
    //   630: ifnonnull +963 -> 1593
    //   633: aload 10
    //   635: iconst_0
    //   636: putfield 303	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   639: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +32 -> 674
    //   645: ldc 112
    //   647: iconst_2
    //   648: new 17	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 305
    //   658: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_0
    //   662: getfield 42	asbv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   665: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: aload 10
    //   676: iconst_1
    //   677: anewarray 66	java/lang/String
    //   680: dup
    //   681: iconst_0
    //   682: ldc_w 306
    //   685: aastore
    //   686: invokestatic 309	asbl:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   689: iconst_0
    //   690: istore_3
    //   691: aload_0
    //   692: invokevirtual 312	asbv:h	()Z
    //   695: ifne +550 -> 1245
    //   698: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   701: ifeq +32 -> 733
    //   704: ldc 112
    //   706: iconst_2
    //   707: new 17	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   714: ldc_w 314
    //   717: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload_0
    //   721: getfield 42	asbv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   724: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: aload 10
    //   735: aload_1
    //   736: invokevirtual 317	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   739: aload 10
    //   741: iconst_1
    //   742: putfield 220	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   745: aload 10
    //   747: iconst_0
    //   748: anewarray 66	java/lang/String
    //   751: invokestatic 309	asbl:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   754: iload_3
    //   755: istore_2
    //   756: iload_2
    //   757: ifne -745 -> 12
    //   760: aload_0
    //   761: getfield 44	asbv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   764: getstatic 322	com/tencent/mobileqq/app/QQManagerFactory:EARLY_DOWNLOAD_MANAGER	I
    //   767: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   770: checkcast 330	asbm
    //   773: aload 10
    //   775: invokevirtual 333	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   778: invokevirtual 335	asbm:b	(Ljava/lang/String;)V
    //   781: aload_0
    //   782: aload 10
    //   784: invokevirtual 337	asbv:d	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   787: return
    //   788: astore 4
    //   790: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   793: ifeq +32 -> 825
    //   796: ldc 112
    //   798: iconst_2
    //   799: iconst_2
    //   800: anewarray 4	java/lang/Object
    //   803: dup
    //   804: iconst_0
    //   805: ldc_w 339
    //   808: aastore
    //   809: dup
    //   810: iconst_1
    //   811: aload 4
    //   813: invokevirtual 342	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   816: aastore
    //   817: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   820: aload 4
    //   822: invokevirtual 348	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   825: aload 7
    //   827: invokestatic 353	bkvq:a	(Ljava/io/File;)Ljava/lang/String;
    //   830: astore 4
    //   832: goto -589 -> 243
    //   835: astore 4
    //   837: aload 9
    //   839: astore 4
    //   841: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   844: ifeq -601 -> 243
    //   847: ldc 112
    //   849: iconst_2
    //   850: new 17	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   857: ldc_w 355
    //   860: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload 7
    //   865: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   868: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   874: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   877: aload 9
    //   879: astore 4
    //   881: goto -638 -> 243
    //   884: astore 4
    //   886: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +32 -> 921
    //   892: ldc 112
    //   894: iconst_2
    //   895: iconst_2
    //   896: anewarray 4	java/lang/Object
    //   899: dup
    //   900: iconst_0
    //   901: ldc_w 357
    //   904: aastore
    //   905: dup
    //   906: iconst_1
    //   907: aload 4
    //   909: invokevirtual 358	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   912: aastore
    //   913: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   916: aload 4
    //   918: invokevirtual 359	java/lang/OutOfMemoryError:printStackTrace	()V
    //   921: aload 7
    //   923: invokestatic 353	bkvq:a	(Ljava/io/File;)Ljava/lang/String;
    //   926: astore 4
    //   928: goto -685 -> 243
    //   931: astore 4
    //   933: aload 9
    //   935: astore 4
    //   937: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   940: ifeq -697 -> 243
    //   943: ldc 112
    //   945: iconst_2
    //   946: new 17	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   953: ldc_w 355
    //   956: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: aload 7
    //   961: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   964: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   973: aload 9
    //   975: astore 4
    //   977: goto -734 -> 243
    //   980: aload 7
    //   982: invokevirtual 298	java/io/File:delete	()Z
    //   985: pop
    //   986: aload_0
    //   987: invokevirtual 361	asbv:b	()V
    //   990: aload 4
    //   992: astore 6
    //   994: aload 8
    //   996: astore 5
    //   998: goto -717 -> 281
    //   1001: astore 4
    //   1003: ldc 112
    //   1005: iconst_1
    //   1006: new 17	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1013: ldc_w 363
    //   1016: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: aload 4
    //   1021: invokevirtual 364	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1024: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1033: goto -460 -> 573
    //   1036: astore 4
    //   1038: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1041: ifeq +32 -> 1073
    //   1044: ldc 112
    //   1046: iconst_2
    //   1047: iconst_2
    //   1048: anewarray 4	java/lang/Object
    //   1051: dup
    //   1052: iconst_0
    //   1053: ldc_w 366
    //   1056: aastore
    //   1057: dup
    //   1058: iconst_1
    //   1059: aload 4
    //   1061: invokevirtual 342	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1064: aastore
    //   1065: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1068: aload 4
    //   1070: invokevirtual 348	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   1073: aload 8
    //   1075: invokestatic 353	bkvq:a	(Ljava/io/File;)Ljava/lang/String;
    //   1078: astore 4
    //   1080: goto -486 -> 594
    //   1083: astore 4
    //   1085: aload 6
    //   1087: astore 4
    //   1089: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1092: ifeq -498 -> 594
    //   1095: ldc 112
    //   1097: iconst_2
    //   1098: new 17	java/lang/StringBuilder
    //   1101: dup
    //   1102: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1105: ldc_w 355
    //   1108: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload 8
    //   1113: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1116: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1122: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1125: aload 6
    //   1127: astore 4
    //   1129: goto -535 -> 594
    //   1132: astore 4
    //   1134: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1137: ifeq +32 -> 1169
    //   1140: ldc 112
    //   1142: iconst_2
    //   1143: iconst_2
    //   1144: anewarray 4	java/lang/Object
    //   1147: dup
    //   1148: iconst_0
    //   1149: ldc_w 368
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_1
    //   1155: aload 4
    //   1157: invokevirtual 358	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1160: aastore
    //   1161: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1164: aload 4
    //   1166: invokevirtual 359	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1169: aload 8
    //   1171: invokestatic 353	bkvq:a	(Ljava/io/File;)Ljava/lang/String;
    //   1174: astore 4
    //   1176: goto -582 -> 594
    //   1179: astore 4
    //   1181: aload 6
    //   1183: astore 4
    //   1185: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1188: ifeq -594 -> 594
    //   1191: ldc 112
    //   1193: iconst_2
    //   1194: new 17	java/lang/StringBuilder
    //   1197: dup
    //   1198: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1201: ldc_w 355
    //   1204: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: aload 8
    //   1209: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1212: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1218: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1221: aload 6
    //   1223: astore 4
    //   1225: goto -631 -> 594
    //   1228: aload 8
    //   1230: invokevirtual 298	java/io/File:delete	()Z
    //   1233: pop
    //   1234: aload_0
    //   1235: invokevirtual 361	asbv:b	()V
    //   1238: aload 5
    //   1240: astore 4
    //   1242: goto -614 -> 628
    //   1245: iload_3
    //   1246: istore_2
    //   1247: aload_1
    //   1248: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1251: aload 10
    //   1253: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1256: if_icmplt -500 -> 756
    //   1259: aload_1
    //   1260: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1263: aload 10
    //   1265: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1268: if_icmpne +186 -> 1454
    //   1271: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1274: ifeq +46 -> 1320
    //   1277: ldc 112
    //   1279: iconst_2
    //   1280: new 17	java/lang/StringBuilder
    //   1283: dup
    //   1284: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1287: ldc_w 370
    //   1290: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: aload 10
    //   1295: getfield 220	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1298: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1301: ldc_w 372
    //   1304: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload_0
    //   1308: getfield 42	asbv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1311: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1317: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1320: iload_3
    //   1321: istore_2
    //   1322: aload 10
    //   1324: getfield 220	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1327: iconst_1
    //   1328: if_icmpeq -572 -> 756
    //   1331: aload 10
    //   1333: aload_1
    //   1334: invokevirtual 317	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1337: aload 10
    //   1339: iconst_0
    //   1340: anewarray 66	java/lang/String
    //   1343: invokestatic 309	asbl:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1346: aload_0
    //   1347: getfield 44	asbv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1350: getstatic 322	com/tencent/mobileqq/app/QQManagerFactory:EARLY_DOWNLOAD_MANAGER	I
    //   1353: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1356: checkcast 330	asbm
    //   1359: astore_1
    //   1360: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1363: ifeq +60 -> 1423
    //   1366: ldc 112
    //   1368: iconst_2
    //   1369: new 17	java/lang/StringBuilder
    //   1372: dup
    //   1373: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1376: ldc_w 374
    //   1379: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: aload 10
    //   1384: getfield 377	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1387: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1390: ldc_w 379
    //   1393: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: aload 10
    //   1398: getfield 382	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1401: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1404: ldc_w 384
    //   1407: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: aload_1
    //   1411: invokevirtual 386	asbm:a	()Z
    //   1414: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1417: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1420: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1423: aload 10
    //   1425: getfield 377	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1428: ifne +18 -> 1446
    //   1431: aload 10
    //   1433: getfield 382	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1436: ifeq +10 -> 1446
    //   1439: aload_1
    //   1440: invokevirtual 386	asbm:a	()Z
    //   1443: ifne +726 -> 2169
    //   1446: aload_0
    //   1447: invokevirtual 388	asbv:e	()Z
    //   1450: istore_2
    //   1451: goto -695 -> 756
    //   1454: iload_3
    //   1455: istore_2
    //   1456: aload_1
    //   1457: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1460: aload 10
    //   1462: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1465: if_icmple -709 -> 756
    //   1468: aload 10
    //   1470: aload_1
    //   1471: invokevirtual 317	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1474: aload 10
    //   1476: iconst_0
    //   1477: anewarray 66	java/lang/String
    //   1480: invokestatic 309	asbl:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1483: aload_0
    //   1484: getfield 44	asbv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1487: getstatic 322	com/tencent/mobileqq/app/QQManagerFactory:EARLY_DOWNLOAD_MANAGER	I
    //   1490: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1493: checkcast 330	asbm
    //   1496: astore_1
    //   1497: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1500: ifeq +60 -> 1560
    //   1503: ldc 112
    //   1505: iconst_2
    //   1506: new 17	java/lang/StringBuilder
    //   1509: dup
    //   1510: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1513: ldc_w 390
    //   1516: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: aload 10
    //   1521: getfield 377	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1524: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1527: ldc_w 379
    //   1530: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: aload 10
    //   1535: getfield 382	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1538: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1541: ldc_w 384
    //   1544: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: aload_1
    //   1548: invokevirtual 386	asbm:a	()Z
    //   1551: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1554: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1557: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1560: aload 10
    //   1562: getfield 377	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1565: ifne +20 -> 1585
    //   1568: aload 10
    //   1570: getfield 382	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1573: ifeq +12 -> 1585
    //   1576: iload_3
    //   1577: istore_2
    //   1578: aload_1
    //   1579: invokevirtual 386	asbm:a	()Z
    //   1582: ifne -826 -> 756
    //   1585: aload_0
    //   1586: invokevirtual 388	asbv:e	()Z
    //   1589: istore_2
    //   1590: goto -834 -> 756
    //   1593: aload 10
    //   1595: aload_1
    //   1596: invokevirtual 317	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1599: aload 10
    //   1601: aload_1
    //   1602: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1605: putfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1608: aload 10
    //   1610: iconst_1
    //   1611: putfield 220	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1614: aload 10
    //   1616: iconst_1
    //   1617: putfield 303	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   1620: aload 10
    //   1622: iconst_1
    //   1623: anewarray 66	java/lang/String
    //   1626: dup
    //   1627: iconst_0
    //   1628: ldc_w 306
    //   1631: aastore
    //   1632: invokestatic 309	asbl:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1635: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1638: ifeq +32 -> 1670
    //   1641: ldc 112
    //   1643: iconst_2
    //   1644: new 17	java/lang/StringBuilder
    //   1647: dup
    //   1648: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1651: ldc_w 392
    //   1654: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1657: aload_0
    //   1658: getfield 42	asbv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1661: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1667: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1670: aload 7
    //   1672: invokevirtual 245	java/io/File:exists	()Z
    //   1675: ifne +74 -> 1749
    //   1678: aload_0
    //   1679: invokevirtual 393	asbv:a	()Z
    //   1682: ifne +67 -> 1749
    //   1685: aload 4
    //   1687: aload 7
    //   1689: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   1692: pop
    //   1693: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1696: ifeq +53 -> 1749
    //   1699: ldc 112
    //   1701: iconst_2
    //   1702: new 17	java/lang/StringBuilder
    //   1705: dup
    //   1706: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1709: ldc_w 395
    //   1712: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: aload 4
    //   1717: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1720: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: ldc_w 397
    //   1726: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: aload 7
    //   1731: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1734: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: ldc_w 399
    //   1740: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1746: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1749: aload 10
    //   1751: iconst_0
    //   1752: anewarray 66	java/lang/String
    //   1755: invokestatic 309	asbl:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1758: aload_0
    //   1759: aload 4
    //   1761: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1764: invokevirtual 401	asbv:a	(Ljava/lang/String;)V
    //   1767: aload_0
    //   1768: getfield 44	asbv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1771: getstatic 322	com/tencent/mobileqq/app/QQManagerFactory:EARLY_DOWNLOAD_MANAGER	I
    //   1774: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1777: checkcast 330	asbm
    //   1780: aload 10
    //   1782: invokevirtual 333	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   1785: invokevirtual 335	asbm:b	(Ljava/lang/String;)V
    //   1788: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1791: ifeq +53 -> 1844
    //   1794: ldc 112
    //   1796: iconst_2
    //   1797: new 17	java/lang/StringBuilder
    //   1800: dup
    //   1801: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1804: ldc_w 403
    //   1807: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1810: aload 10
    //   1812: getfield 122	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1815: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: ldc_w 405
    //   1821: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: aload 4
    //   1826: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1829: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: ldc_w 399
    //   1835: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1841: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1844: aload_0
    //   1845: getfield 407	asbv:c	Z
    //   1848: ifeq +145 -> 1993
    //   1851: new 409	android/content/Intent
    //   1854: dup
    //   1855: ldc_w 411
    //   1858: invokespecial 412	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1861: astore 5
    //   1863: aload 5
    //   1865: ldc_w 413
    //   1868: aload_0
    //   1869: getfield 42	asbv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1872: invokevirtual 417	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1875: pop
    //   1876: aload 5
    //   1878: ldc_w 418
    //   1881: aload 10
    //   1883: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   1886: invokevirtual 417	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1889: pop
    //   1890: aload 5
    //   1892: ldc_w 419
    //   1895: iconst_1
    //   1896: invokevirtual 422	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1899: pop
    //   1900: aload 5
    //   1902: ldc_w 424
    //   1905: aload 10
    //   1907: getfield 426	com/tencent/mobileqq/earlydownload/xmldata/XmlData:totalSize	J
    //   1910: invokevirtual 429	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1913: pop
    //   1914: aload 5
    //   1916: ldc_w 431
    //   1919: aload 10
    //   1921: getfield 433	com/tencent/mobileqq/earlydownload/xmldata/XmlData:downSize	J
    //   1924: invokevirtual 429	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1927: pop
    //   1928: aload 5
    //   1930: ldc_w 435
    //   1933: aload 4
    //   1935: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1938: invokevirtual 417	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1941: pop
    //   1942: invokestatic 441	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1945: aload 5
    //   1947: ldc_w 443
    //   1950: invokevirtual 449	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1953: aload_0
    //   1954: iconst_0
    //   1955: putfield 407	asbv:c	Z
    //   1958: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1961: ifeq +32 -> 1993
    //   1964: ldc 112
    //   1966: iconst_2
    //   1967: new 17	java/lang/StringBuilder
    //   1970: dup
    //   1971: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1974: ldc_w 451
    //   1977: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: aload_0
    //   1981: getfield 42	asbv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1984: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1987: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1990: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1993: new 453	java/util/HashMap
    //   1996: dup
    //   1997: invokespecial 454	java/util/HashMap:<init>	()V
    //   2000: astore 5
    //   2002: aload 5
    //   2004: ldc_w 456
    //   2007: aload 10
    //   2009: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   2012: invokevirtual 460	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2015: pop
    //   2016: aload 5
    //   2018: ldc_w 462
    //   2021: getstatic 468	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2024: invokevirtual 469	java/lang/Boolean:toString	()Ljava/lang/String;
    //   2027: invokevirtual 460	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2030: pop
    //   2031: aload_0
    //   2032: invokevirtual 471	asbv:a	()Ljava/lang/String;
    //   2035: astore 6
    //   2037: aload 6
    //   2039: ifnull +43 -> 2082
    //   2042: aload 6
    //   2044: invokevirtual 69	java/lang/String:length	()I
    //   2047: ifle +35 -> 2082
    //   2050: invokestatic 441	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2053: invokestatic 477	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2056: aload_0
    //   2057: getfield 44	asbv:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2060: invokevirtual 480	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2063: aload 6
    //   2065: iconst_1
    //   2066: ldc2_w 481
    //   2069: aload 7
    //   2071: invokevirtual 253	java/io/File:length	()J
    //   2074: aload 5
    //   2076: ldc_w 484
    //   2079: invokevirtual 488	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2082: aload 8
    //   2084: invokevirtual 245	java/io/File:exists	()Z
    //   2087: ifne -2075 -> 12
    //   2090: aload_1
    //   2091: getfield 491	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   2094: ifeq -2082 -> 12
    //   2097: aload 4
    //   2099: aload 8
    //   2101: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   2104: pop
    //   2105: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2108: ifeq -2096 -> 12
    //   2111: ldc 112
    //   2113: iconst_2
    //   2114: new 17	java/lang/StringBuilder
    //   2117: dup
    //   2118: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   2121: ldc_w 395
    //   2124: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2127: aload 4
    //   2129: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2132: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: ldc_w 397
    //   2138: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2141: aload 8
    //   2143: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2146: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2149: ldc_w 399
    //   2152: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2155: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2158: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2161: return
    //   2162: astore_1
    //   2163: return
    //   2164: astore 5
    //   2166: goto -417 -> 1749
    //   2169: iconst_0
    //   2170: istore_2
    //   2171: goto -720 -> 1451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2174	0	this	asbv
    //   0	2174	1	paramXmlData	XmlData
    //   494	1677	2	bool1	boolean
    //   690	887	3	bool2	boolean
    //   241	388	4	localObject1	Object
    //   788	33	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   830	1	4	str1	String
    //   835	1	4	localException1	Exception
    //   839	41	4	localObject2	Object
    //   884	33	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   926	1	4	str2	String
    //   931	1	4	localException2	Exception
    //   935	56	4	localObject3	Object
    //   1001	19	4	localThrowable	java.lang.Throwable
    //   1036	33	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   1078	1	4	str3	String
    //   1083	1	4	localException3	Exception
    //   1087	41	4	localObject4	Object
    //   1132	33	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1174	1	4	str4	String
    //   1179	1	4	localException4	Exception
    //   1183	945	4	localObject5	Object
    //   185	1890	5	localObject6	Object
    //   2164	1	5	localException5	Exception
    //   117	1947	6	localObject7	Object
    //   133	1937	7	localFile1	File
    //   114	2028	8	localFile2	File
    //   120	854	9	localObject8	Object
    //   17	1991	10	localXmlData	XmlData
    // Exception table:
    //   from	to	target	type
    //   230	243	788	java/lang/UnsatisfiedLinkError
    //   825	832	835	java/lang/Exception
    //   230	243	884	java/lang/OutOfMemoryError
    //   921	928	931	java/lang/Exception
    //   384	471	1001	java/lang/Throwable
    //   471	527	1001	java/lang/Throwable
    //   527	573	1001	java/lang/Throwable
    //   581	594	1036	java/lang/UnsatisfiedLinkError
    //   1073	1080	1083	java/lang/Exception
    //   581	594	1132	java/lang/OutOfMemoryError
    //   1169	1176	1179	java/lang/Exception
    //   2097	2161	2162	java/lang/Exception
    //   1685	1749	2164	java/lang/Exception
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadFinish() result=" + paramBoolean + " filePath=" + paramString);
    }
    Object localObject;
    if (paramBoolean)
    {
      paramXmlData.hasResDownloaded = true;
      asbl.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download Successful, hasResDownloaded=true, resName=" + this.jdField_b_of_type_JavaLangString + "this=" + this);
      }
      a(paramString);
      ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).preDownloadSuccess(paramXmlData.strResURL_big, paramXmlData.downSize);
      if (this.c)
      {
        localObject = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
        if (paramInt != 9037) {
          break label396;
        }
        ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_CANCEL");
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("strResName", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("strPkgName", a().strPkgName);
      ((Intent)localObject).putExtra("loadState", a().loadState);
      ((Intent)localObject).putExtra("totalSize", paramXmlData.totalSize);
      ((Intent)localObject).putExtra("downSize", paramXmlData.downSize);
      ((Intent)localObject).putExtra("errCode", paramInt);
      ((Intent)localObject).putExtra("resPath", paramString);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
      this.c = false;
      return;
      paramXmlData.hasResDownloaded = false;
      asbl.a(paramXmlData, new String[] { "hasResDownloaded" });
      QLog.d("EarlyDown", 1, "EarlyHandler, onDownloadFinish,download failed, hasResDownloaded=false, resName=" + this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((asbp)((Iterator)localObject).next()).a(paramXmlData, paramBoolean, paramInt, a(), paramString);
      }
      break;
      label396:
      ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_QUERY");
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((asbp)localIterator.next()).a(a(), true, 0, a(), paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    new File(c()).delete();
    XmlData localXmlData = a();
    localXmlData.Version = 0;
    localXmlData.tLoadFail = 0L;
    localXmlData.loadState = 0;
    localXmlData.hasResDownloaded = false;
    asbl.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail", "hasResDownloaded" });
    localXmlData.isUserClick = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "restartDownload(), this.strResName=" + this.jdField_b_of_type_JavaLangString + ", resName=" + localXmlData.strResName + ", user=" + paramBoolean);
    }
    Intent localIntent = new Intent();
    GetResourceReqInfo localGetResourceReqInfo = a();
    if (localGetResourceReqInfo != null)
    {
      asbm localasbm = (asbm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      if ((localasbm != null) && (!localasbm.a(localXmlData.getStrResName())))
      {
        localIntent.putExtra("reqResult", true);
        localasbm.a(localXmlData.getStrResName());
        ((ansg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a(null, new GetResourceReqInfo[] { localGetResourceReqInfo });
      }
    }
    for (;;)
    {
      if (this.c)
      {
        localIntent.setAction("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
        localIntent.putExtra("strResName", this.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("strPkgName", localXmlData.strPkgName);
        BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, String.format("restartDownload() res[%s] is downloading", new Object[] { localXmlData.getStrResName() }));
      }
      localIntent.putExtra("reqResult", false);
      localIntent.putExtra("resultReason", "strPkgName=" + localXmlData.strPkgName);
      continue;
      localIntent.putExtra("reqResult", false);
      localIntent.putExtra("resultReason", "strPkgName=" + localXmlData.strPkgName);
    }
  }
  
  public abstract boolean a();
  
  public int b()
  {
    int i = 0;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      i = localXmlData.Version;
    }
    return i;
  }
  
  public abstract String b();
  
  public void b() {}
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadBegin()");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((asbp)localIterator.next()).a(paramXmlData);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "setIsBroadcast() " + paramBoolean);
      }
    }
  }
  
  public boolean b()
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      if (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) {
        if (!localXmlData.loadWifi) {
          break label310;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " isWifiConn=true, " + localXmlData.strResName + ":loadWifi=" + localXmlData.loadWifi);
        bool1 = bool2;
      }
      return bool1;
      if (NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) {
        if (NetworkUtil.is3Gor4G(BaseApplicationImpl.getContext())) {
          if (!localXmlData.load3G) {
            break label305;
          }
        }
      }
      label305:
      for (bool2 = bool1;; bool2 = false)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is3Gor4G=true, " + localXmlData.strResName + ":load3G=" + localXmlData.load3G);
        return bool2;
        if (localXmlData.load2G) {}
        for (bool2 = bool3;; bool2 = false)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is2G=true, " + localXmlData.strResName + ":load2G=" + localXmlData.load2G);
          return bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, "isNetValid2Down() return:false, no wifi and no MobileNet.");
            return false;
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "isNetValid2Download() return false, data == null");
            }
          }
          return false;
        }
      }
      label310:
      bool2 = false;
    }
  }
  
  public String c()
  {
    File localFile = new File(BaseApplicationImpl.getContext().getFilesDir() + "/pddata/prd/early");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (!a()) {
      new File(c()).delete();
    }
  }
  
  public void c(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EarlyDown", 2, "onDownloadCancel");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((asbp)localIterator.next()).b(paramXmlData);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "setFail() resName:" + this.jdField_b_of_type_JavaLangString);
    }
    XmlData localXmlData = a();
    if (localXmlData != null)
    {
      if (localXmlData.loadState != 1) {
        break label94;
      }
      localXmlData.loadState = 0;
      localXmlData.Version = 0;
    }
    for (;;)
    {
      localXmlData.hasResDownloaded = false;
      asbl.a(localXmlData, new String[] { "loadState", "Version", "hasResDownloaded" });
      return;
      label94:
      if ((localXmlData.loadState == 2) && (paramBoolean)) {
        localXmlData.loadState = 0;
      }
    }
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public String d()
  {
    String str = VFSAssistantUtils.getSDKPrivatePath(jdField_a_of_type_JavaLangString);
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath() + File.separator + this.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyHandler", 2, "getBackupPath ,SDCARD_DIR = " + jdField_a_of_type_JavaLangString + ",vfsDir = " + str + ",filepath = " + (String)localObject);
    }
    return localObject;
  }
  
  public void d()
  {
    if (a())
    {
      File localFile = new File(c());
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "doAfterFinish() deleteResouceAfterDownload==true, delete storage:" + localFile.getAbsolutePath() + " bool=" + bool);
        }
      }
    }
  }
  
  public void d(XmlData paramXmlData) {}
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          i = 1;
        }
        if (i == 1)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_strResName", this.jdField_b_of_type_JavaLangString);
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actEarlyDownUse", paramBoolean, 0L, 0L, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "statisticUsage() strResName=" + this.jdField_b_of_type_JavaLangString + " inUse=" + paramBoolean);
          }
        }
        return;
      }
      finally {}
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        i = 1;
      }
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    XmlData localXmlData = a();
    if (localXmlData != null)
    {
      long l = System.currentTimeMillis();
      boolean bool1;
      if (localXmlData.tLoadFail != 0L)
      {
        bool1 = bool3;
        if (localXmlData.tLoadFail > 0L)
        {
          bool1 = bool3;
          if (localXmlData.tLoadFail + 43200000L >= l) {}
        }
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isTimeValid() " + bool1 + " res=" + localXmlData.strResName + " tLoadFail=" + localXmlData.tLoadFail);
        bool2 = bool1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "isTimeValid() = false,  data = null");
    }
    return bool2;
  }
  
  public void e()
  {
    String str = c();
    try
    {
      new File(str).delete();
      label17:
      asbl.a(a());
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public boolean e()
  {
    boolean bool2 = false;
    XmlData localXmlData = a();
    boolean bool3 = b();
    boolean bool1;
    if (!d()) {
      if (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))
      {
        if (!QLog.isColorLevel()) {
          break label142;
        }
        QLog.d("EarlyDown", 2, "wifi connected,reset timeValid=true");
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((bool3) && (bool1))
      {
        ((asbm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a(localXmlData, c());
        bool2 = true;
      }
      while (!QLog.isColorLevel())
      {
        return bool2;
        bool1 = false;
        break;
      }
      QLog.d("EarlyDown", 2, "downloadResource() return false, netValid=" + bool3 + " timeValid=" + bool1 + " strResName=" + this.jdField_b_of_type_JavaLangString);
      return false;
      label142:
      bool1 = true;
    }
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    int i = 1;
    XmlData localXmlData = a();
    int j = -1;
    boolean bool1;
    if (localXmlData == null)
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "isNeedServerInfo(), " + a().strResName + ", need=" + bool1 + ", needTrueReasonCode =" + i);
      }
      return bool1;
    }
    System.currentTimeMillis();
    if (localXmlData.loadState == 1)
    {
      i = j;
      bool1 = bool2;
      if (!a())
      {
        i = j;
        bool1 = bool2;
        if (!new File(c()).exists())
        {
          c(false);
          c();
          i = 2;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (!localXmlData.hasResDownloaded)
      {
        bool1 = true;
        i = 4;
        break;
        if ((localXmlData.Version == 0) || (localXmlData.loadState == 2)) {
          break label203;
        }
        localXmlData.Version = 0;
        asbl.a(localXmlData, new String[] { "Version" });
        i = 3;
        bool1 = true;
        continue;
      }
      break;
      label203:
      bool1 = true;
      i = j;
    }
  }
  
  public boolean g()
  {
    XmlData localXmlData = a();
    if (localXmlData != null) {
      return localXmlData.loadState == 1;
    }
    return false;
  }
  
  public boolean h()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbv
 * JD-Core Version:    0.7.0.1
 */