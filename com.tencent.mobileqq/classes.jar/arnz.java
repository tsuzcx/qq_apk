import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

public abstract class arnz
{
  static final String jdField_a_of_type_JavaLangString = anhk.ba + "pddata/prd/early";
  public QQAppInterface a;
  private XmlData jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  protected ArrayList<arnr> a;
  protected boolean a;
  protected String b;
  protected boolean b;
  protected boolean c;
  
  public arnz(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public final XmlData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData == null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData = arnn.a(a());
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
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      XmlData localXmlData = a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((arnr)localIterator.next()).a(localXmlData, paramLong1, paramLong2);
      }
    }
  }
  
  public void a(arnr paramarnr)
  {
    if (paramarnr != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramarnr)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramarnr);
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
    //   7: ldc 203
    //   9: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 59	arnz:a	()Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;
    //   17: astore 10
    //   19: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +91 -> 113
    //   25: ldc 112
    //   27: iconst_2
    //   28: new 17	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   35: ldc 208
    //   37: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: getfield 122	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   44: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 210
    //   49: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_1
    //   53: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   56: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: ldc 212
    //   61: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 10
    //   66: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   69: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 214
    //   74: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 10
    //   79: getfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   82: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: ldc 219
    //   87: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 10
    //   92: getfield 222	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   95: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 224
    //   100: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aconst_null
    //   114: astore 8
    //   116: aconst_null
    //   117: astore 6
    //   119: aconst_null
    //   120: astore 9
    //   122: new 229	java/io/File
    //   125: dup
    //   126: aload_0
    //   127: invokevirtual 231	arnz:c	()Ljava/lang/String;
    //   130: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: astore 7
    //   135: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +45 -> 183
    //   141: ldc 112
    //   143: iconst_2
    //   144: new 17	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   151: ldc 234
    //   153: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 7
    //   158: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 239
    //   166: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 7
    //   171: invokevirtual 242	java/io/File:exists	()Z
    //   174: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   177: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload 8
    //   185: astore 5
    //   187: aload 7
    //   189: invokevirtual 242	java/io/File:exists	()Z
    //   192: ifeq +89 -> 281
    //   195: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +32 -> 230
    //   201: ldc 112
    //   203: iconst_2
    //   204: new 17	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   211: ldc 247
    //   213: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 7
    //   218: invokevirtual 250	java/io/File:length	()J
    //   221: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload 7
    //   232: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   235: invokestatic 259	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   238: invokestatic 265	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   241: astore 4
    //   243: aload 4
    //   245: ifnull +734 -> 979
    //   248: aload_1
    //   249: getfield 268	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   252: ifnull +727 -> 979
    //   255: aload 4
    //   257: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   260: aload_1
    //   261: getfield 268	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   264: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   267: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   270: ifeq +709 -> 979
    //   273: aload 7
    //   275: astore 5
    //   277: aload 4
    //   279: astore 6
    //   281: new 229	java/io/File
    //   284: dup
    //   285: aload_0
    //   286: invokevirtual 276	arnz:d	()Ljava/lang/String;
    //   289: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   292: astore 8
    //   294: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +46 -> 343
    //   300: ldc 112
    //   302: iconst_2
    //   303: new 17	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 278
    //   313: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 8
    //   318: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   321: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 239
    //   326: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 8
    //   331: invokevirtual 242	java/io/File:exists	()Z
    //   334: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   337: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload 5
    //   345: ifnonnull +892 -> 1237
    //   348: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +33 -> 384
    //   354: ldc 112
    //   356: iconst_2
    //   357: new 17	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 280
    //   367: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 8
    //   372: invokevirtual 250	java/io/File:length	()J
    //   375: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   378: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: new 229	java/io/File
    //   387: dup
    //   388: new 17	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   395: getstatic 25	anhk:ba	Ljava/lang/String;
    //   398: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: ldc_w 282
    //   404: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_0
    //   408: getfield 42	arnz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   411: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: astore 4
    //   422: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +46 -> 471
    //   428: ldc 112
    //   430: iconst_2
    //   431: new 17	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 284
    //   441: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 4
    //   446: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   449: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc 239
    //   454: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 4
    //   459: invokevirtual 242	java/io/File:exists	()Z
    //   462: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   465: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: aload 8
    //   473: invokevirtual 242	java/io/File:exists	()Z
    //   476: ifne +51 -> 527
    //   479: aload 4
    //   481: invokevirtual 242	java/io/File:exists	()Z
    //   484: ifeq +43 -> 527
    //   487: aload 4
    //   489: aload 8
    //   491: invokestatic 289	bgmg:a	(Ljava/io/File;Ljava/io/File;)Z
    //   494: istore_2
    //   495: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq +29 -> 527
    //   501: ldc 112
    //   503: iconst_2
    //   504: new 17	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 291
    //   514: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: iload_2
    //   518: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   521: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   527: aload 4
    //   529: invokevirtual 242	java/io/File:exists	()Z
    //   532: ifeq +41 -> 573
    //   535: aload 4
    //   537: invokevirtual 294	java/io/File:delete	()Z
    //   540: istore_2
    //   541: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +29 -> 573
    //   547: ldc 112
    //   549: iconst_2
    //   550: new 17	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 296
    //   560: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: iload_2
    //   564: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   567: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: aload 8
    //   575: invokevirtual 242	java/io/File:exists	()Z
    //   578: ifeq +659 -> 1237
    //   581: aload 8
    //   583: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   586: invokestatic 259	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   589: invokestatic 265	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   592: astore 4
    //   594: aload 4
    //   596: ifnull +631 -> 1227
    //   599: aload_1
    //   600: getfield 268	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   603: ifnull +624 -> 1227
    //   606: aload 4
    //   608: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   611: aload_1
    //   612: getfield 268	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   615: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   618: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   621: ifeq +606 -> 1227
    //   624: aload 8
    //   626: astore 4
    //   628: aload 4
    //   630: ifnonnull +960 -> 1590
    //   633: aload 10
    //   635: iconst_0
    //   636: putfield 299	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   639: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +32 -> 674
    //   645: ldc 112
    //   647: iconst_2
    //   648: new 17	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 301
    //   658: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_0
    //   662: getfield 42	arnz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   665: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: aload 10
    //   676: iconst_1
    //   677: anewarray 66	java/lang/String
    //   680: dup
    //   681: iconst_0
    //   682: ldc_w 302
    //   685: aastore
    //   686: invokestatic 305	arnn:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   689: iconst_0
    //   690: istore_3
    //   691: aload_0
    //   692: invokevirtual 308	arnz:h	()Z
    //   695: ifne +549 -> 1244
    //   698: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   701: ifeq +32 -> 733
    //   704: ldc 112
    //   706: iconst_2
    //   707: new 17	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   714: ldc_w 310
    //   717: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload_0
    //   721: getfield 42	arnz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   724: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: aload 10
    //   735: aload_1
    //   736: invokevirtual 313	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   739: aload 10
    //   741: iconst_1
    //   742: putfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   745: aload 10
    //   747: iconst_0
    //   748: anewarray 66	java/lang/String
    //   751: invokestatic 305	arnn:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   754: iload_3
    //   755: istore_2
    //   756: iload_2
    //   757: ifne -745 -> 12
    //   760: aload_0
    //   761: getfield 44	arnz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   764: bipush 77
    //   766: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   769: checkcast 321	arno
    //   772: aload 10
    //   774: invokevirtual 324	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   777: invokevirtual 326	arno:b	(Ljava/lang/String;)V
    //   780: aload_0
    //   781: aload 10
    //   783: invokevirtual 328	arnz:d	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   786: return
    //   787: astore 4
    //   789: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   792: ifeq +32 -> 824
    //   795: ldc 112
    //   797: iconst_2
    //   798: iconst_2
    //   799: anewarray 4	java/lang/Object
    //   802: dup
    //   803: iconst_0
    //   804: ldc_w 330
    //   807: aastore
    //   808: dup
    //   809: iconst_1
    //   810: aload 4
    //   812: invokevirtual 333	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   815: aastore
    //   816: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   819: aload 4
    //   821: invokevirtual 339	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   824: aload 7
    //   826: invokestatic 344	bkcx:a	(Ljava/io/File;)Ljava/lang/String;
    //   829: astore 4
    //   831: goto -588 -> 243
    //   834: astore 4
    //   836: aload 9
    //   838: astore 4
    //   840: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq -600 -> 243
    //   846: ldc 112
    //   848: iconst_2
    //   849: new 17	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 346
    //   859: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload 7
    //   864: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   867: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aload 9
    //   878: astore 4
    //   880: goto -637 -> 243
    //   883: astore 4
    //   885: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   888: ifeq +32 -> 920
    //   891: ldc 112
    //   893: iconst_2
    //   894: iconst_2
    //   895: anewarray 4	java/lang/Object
    //   898: dup
    //   899: iconst_0
    //   900: ldc_w 348
    //   903: aastore
    //   904: dup
    //   905: iconst_1
    //   906: aload 4
    //   908: invokevirtual 349	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   911: aastore
    //   912: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   915: aload 4
    //   917: invokevirtual 350	java/lang/OutOfMemoryError:printStackTrace	()V
    //   920: aload 7
    //   922: invokestatic 344	bkcx:a	(Ljava/io/File;)Ljava/lang/String;
    //   925: astore 4
    //   927: goto -684 -> 243
    //   930: astore 4
    //   932: aload 9
    //   934: astore 4
    //   936: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   939: ifeq -696 -> 243
    //   942: ldc 112
    //   944: iconst_2
    //   945: new 17	java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   952: ldc_w 346
    //   955: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: aload 7
    //   960: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   963: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   969: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   972: aload 9
    //   974: astore 4
    //   976: goto -733 -> 243
    //   979: aload 7
    //   981: invokevirtual 294	java/io/File:delete	()Z
    //   984: pop
    //   985: aload_0
    //   986: invokevirtual 352	arnz:c	()V
    //   989: aload 4
    //   991: astore 6
    //   993: aload 8
    //   995: astore 5
    //   997: goto -716 -> 281
    //   1000: astore 4
    //   1002: ldc 112
    //   1004: iconst_1
    //   1005: new 17	java/lang/StringBuilder
    //   1008: dup
    //   1009: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1012: ldc_w 354
    //   1015: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: aload 4
    //   1020: invokevirtual 355	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1023: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1032: goto -459 -> 573
    //   1035: astore 4
    //   1037: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1040: ifeq +32 -> 1072
    //   1043: ldc 112
    //   1045: iconst_2
    //   1046: iconst_2
    //   1047: anewarray 4	java/lang/Object
    //   1050: dup
    //   1051: iconst_0
    //   1052: ldc_w 357
    //   1055: aastore
    //   1056: dup
    //   1057: iconst_1
    //   1058: aload 4
    //   1060: invokevirtual 333	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1063: aastore
    //   1064: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1067: aload 4
    //   1069: invokevirtual 339	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   1072: aload 8
    //   1074: invokestatic 344	bkcx:a	(Ljava/io/File;)Ljava/lang/String;
    //   1077: astore 4
    //   1079: goto -485 -> 594
    //   1082: astore 4
    //   1084: aload 6
    //   1086: astore 4
    //   1088: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1091: ifeq -497 -> 594
    //   1094: ldc 112
    //   1096: iconst_2
    //   1097: new 17	java/lang/StringBuilder
    //   1100: dup
    //   1101: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1104: ldc_w 346
    //   1107: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: aload 8
    //   1112: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1115: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1124: aload 6
    //   1126: astore 4
    //   1128: goto -534 -> 594
    //   1131: astore 4
    //   1133: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1136: ifeq +32 -> 1168
    //   1139: ldc 112
    //   1141: iconst_2
    //   1142: iconst_2
    //   1143: anewarray 4	java/lang/Object
    //   1146: dup
    //   1147: iconst_0
    //   1148: ldc_w 359
    //   1151: aastore
    //   1152: dup
    //   1153: iconst_1
    //   1154: aload 4
    //   1156: invokevirtual 349	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1159: aastore
    //   1160: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1163: aload 4
    //   1165: invokevirtual 350	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1168: aload 8
    //   1170: invokestatic 344	bkcx:a	(Ljava/io/File;)Ljava/lang/String;
    //   1173: astore 4
    //   1175: goto -581 -> 594
    //   1178: astore 4
    //   1180: aload 6
    //   1182: astore 4
    //   1184: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1187: ifeq -593 -> 594
    //   1190: ldc 112
    //   1192: iconst_2
    //   1193: new 17	java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1200: ldc_w 346
    //   1203: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: aload 8
    //   1208: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1211: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1220: aload 6
    //   1222: astore 4
    //   1224: goto -630 -> 594
    //   1227: aload 8
    //   1229: invokevirtual 294	java/io/File:delete	()Z
    //   1232: pop
    //   1233: aload_0
    //   1234: invokevirtual 352	arnz:c	()V
    //   1237: aload 5
    //   1239: astore 4
    //   1241: goto -613 -> 628
    //   1244: iload_3
    //   1245: istore_2
    //   1246: aload_1
    //   1247: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1250: aload 10
    //   1252: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1255: if_icmplt -499 -> 756
    //   1258: aload_1
    //   1259: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1262: aload 10
    //   1264: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1267: if_icmpne +185 -> 1452
    //   1270: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1273: ifeq +46 -> 1319
    //   1276: ldc 112
    //   1278: iconst_2
    //   1279: new 17	java/lang/StringBuilder
    //   1282: dup
    //   1283: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1286: ldc_w 361
    //   1289: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: aload 10
    //   1294: getfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1297: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1300: ldc_w 363
    //   1303: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: aload_0
    //   1307: getfield 42	arnz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1310: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1316: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1319: iload_3
    //   1320: istore_2
    //   1321: aload 10
    //   1323: getfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1326: iconst_1
    //   1327: if_icmpeq -571 -> 756
    //   1330: aload 10
    //   1332: aload_1
    //   1333: invokevirtual 313	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1336: aload 10
    //   1338: iconst_0
    //   1339: anewarray 66	java/lang/String
    //   1342: invokestatic 305	arnn:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1345: aload_0
    //   1346: getfield 44	arnz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1349: bipush 77
    //   1351: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1354: checkcast 321	arno
    //   1357: astore_1
    //   1358: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq +60 -> 1421
    //   1364: ldc 112
    //   1366: iconst_2
    //   1367: new 17	java/lang/StringBuilder
    //   1370: dup
    //   1371: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1374: ldc_w 365
    //   1377: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: aload 10
    //   1382: getfield 368	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1385: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1388: ldc_w 370
    //   1391: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: aload 10
    //   1396: getfield 373	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1399: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1402: ldc_w 375
    //   1405: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: aload_1
    //   1409: invokevirtual 377	arno:a	()Z
    //   1412: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1415: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1421: aload 10
    //   1423: getfield 368	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1426: ifne +18 -> 1444
    //   1429: aload 10
    //   1431: getfield 373	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1434: ifeq +10 -> 1444
    //   1437: aload_1
    //   1438: invokevirtual 377	arno:a	()Z
    //   1441: ifne +724 -> 2165
    //   1444: aload_0
    //   1445: invokevirtual 379	arnz:e	()Z
    //   1448: istore_2
    //   1449: goto -693 -> 756
    //   1452: iload_3
    //   1453: istore_2
    //   1454: aload_1
    //   1455: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1458: aload 10
    //   1460: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1463: if_icmple -707 -> 756
    //   1466: aload 10
    //   1468: aload_1
    //   1469: invokevirtual 313	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1472: aload 10
    //   1474: iconst_0
    //   1475: anewarray 66	java/lang/String
    //   1478: invokestatic 305	arnn:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1481: aload_0
    //   1482: getfield 44	arnz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1485: bipush 77
    //   1487: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1490: checkcast 321	arno
    //   1493: astore_1
    //   1494: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1497: ifeq +60 -> 1557
    //   1500: ldc 112
    //   1502: iconst_2
    //   1503: new 17	java/lang/StringBuilder
    //   1506: dup
    //   1507: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1510: ldc_w 381
    //   1513: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: aload 10
    //   1518: getfield 368	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1521: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1524: ldc_w 370
    //   1527: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: aload 10
    //   1532: getfield 373	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1535: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1538: ldc_w 375
    //   1541: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: aload_1
    //   1545: invokevirtual 377	arno:a	()Z
    //   1548: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1551: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1557: aload 10
    //   1559: getfield 368	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1562: ifne +20 -> 1582
    //   1565: aload 10
    //   1567: getfield 373	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1570: ifeq +12 -> 1582
    //   1573: iload_3
    //   1574: istore_2
    //   1575: aload_1
    //   1576: invokevirtual 377	arno:a	()Z
    //   1579: ifne -823 -> 756
    //   1582: aload_0
    //   1583: invokevirtual 379	arnz:e	()Z
    //   1586: istore_2
    //   1587: goto -831 -> 756
    //   1590: aload 10
    //   1592: aload_1
    //   1593: invokevirtual 313	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1596: aload 10
    //   1598: aload_1
    //   1599: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1602: putfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1605: aload 10
    //   1607: iconst_1
    //   1608: putfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1611: aload 10
    //   1613: iconst_1
    //   1614: putfield 299	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   1617: aload 10
    //   1619: iconst_1
    //   1620: anewarray 66	java/lang/String
    //   1623: dup
    //   1624: iconst_0
    //   1625: ldc_w 302
    //   1628: aastore
    //   1629: invokestatic 305	arnn:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1632: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1635: ifeq +32 -> 1667
    //   1638: ldc 112
    //   1640: iconst_2
    //   1641: new 17	java/lang/StringBuilder
    //   1644: dup
    //   1645: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1648: ldc_w 383
    //   1651: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: aload_0
    //   1655: getfield 42	arnz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1658: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1664: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1667: aload 7
    //   1669: invokevirtual 242	java/io/File:exists	()Z
    //   1672: ifne +74 -> 1746
    //   1675: aload_0
    //   1676: invokevirtual 384	arnz:a	()Z
    //   1679: ifne +67 -> 1746
    //   1682: aload 4
    //   1684: aload 7
    //   1686: invokestatic 289	bgmg:a	(Ljava/io/File;Ljava/io/File;)Z
    //   1689: pop
    //   1690: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1693: ifeq +53 -> 1746
    //   1696: ldc 112
    //   1698: iconst_2
    //   1699: new 17	java/lang/StringBuilder
    //   1702: dup
    //   1703: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1706: ldc_w 386
    //   1709: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: aload 4
    //   1714: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1717: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: ldc_w 388
    //   1723: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1726: aload 7
    //   1728: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1731: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1734: ldc_w 390
    //   1737: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1740: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1743: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1746: aload 10
    //   1748: iconst_0
    //   1749: anewarray 66	java/lang/String
    //   1752: invokestatic 305	arnn:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1755: aload_0
    //   1756: aload 4
    //   1758: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1761: invokevirtual 392	arnz:a	(Ljava/lang/String;)V
    //   1764: aload_0
    //   1765: getfield 44	arnz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1768: bipush 77
    //   1770: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1773: checkcast 321	arno
    //   1776: aload 10
    //   1778: invokevirtual 324	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   1781: invokevirtual 326	arno:b	(Ljava/lang/String;)V
    //   1784: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1787: ifeq +53 -> 1840
    //   1790: ldc 112
    //   1792: iconst_2
    //   1793: new 17	java/lang/StringBuilder
    //   1796: dup
    //   1797: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1800: ldc_w 394
    //   1803: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: aload 10
    //   1808: getfield 122	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1811: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: ldc_w 396
    //   1817: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1820: aload 4
    //   1822: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1825: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1828: ldc_w 390
    //   1831: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1837: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1840: aload_0
    //   1841: getfield 398	arnz:c	Z
    //   1844: ifeq +145 -> 1989
    //   1847: new 400	android/content/Intent
    //   1850: dup
    //   1851: ldc_w 402
    //   1854: invokespecial 403	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1857: astore 5
    //   1859: aload 5
    //   1861: ldc_w 404
    //   1864: aload_0
    //   1865: getfield 42	arnz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1868: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1871: pop
    //   1872: aload 5
    //   1874: ldc_w 409
    //   1877: aload 10
    //   1879: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   1882: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1885: pop
    //   1886: aload 5
    //   1888: ldc_w 410
    //   1891: iconst_1
    //   1892: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1895: pop
    //   1896: aload 5
    //   1898: ldc_w 415
    //   1901: aload 10
    //   1903: getfield 417	com/tencent/mobileqq/earlydownload/xmldata/XmlData:totalSize	J
    //   1906: invokevirtual 420	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1909: pop
    //   1910: aload 5
    //   1912: ldc_w 422
    //   1915: aload 10
    //   1917: getfield 424	com/tencent/mobileqq/earlydownload/xmldata/XmlData:downSize	J
    //   1920: invokevirtual 420	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1923: pop
    //   1924: aload 5
    //   1926: ldc_w 426
    //   1929: aload 4
    //   1931: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1934: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1937: pop
    //   1938: invokestatic 432	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1941: aload 5
    //   1943: ldc_w 434
    //   1946: invokevirtual 440	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1949: aload_0
    //   1950: iconst_0
    //   1951: putfield 398	arnz:c	Z
    //   1954: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1957: ifeq +32 -> 1989
    //   1960: ldc 112
    //   1962: iconst_2
    //   1963: new 17	java/lang/StringBuilder
    //   1966: dup
    //   1967: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1970: ldc_w 442
    //   1973: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: aload_0
    //   1977: getfield 42	arnz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1980: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1983: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1986: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1989: new 444	java/util/HashMap
    //   1992: dup
    //   1993: invokespecial 445	java/util/HashMap:<init>	()V
    //   1996: astore 5
    //   1998: aload 5
    //   2000: ldc_w 447
    //   2003: aload 10
    //   2005: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   2008: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2011: pop
    //   2012: aload 5
    //   2014: ldc_w 453
    //   2017: getstatic 459	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2020: invokevirtual 460	java/lang/Boolean:toString	()Ljava/lang/String;
    //   2023: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2026: pop
    //   2027: aload_0
    //   2028: invokevirtual 462	arnz:a	()Ljava/lang/String;
    //   2031: astore 6
    //   2033: aload 6
    //   2035: ifnull +43 -> 2078
    //   2038: aload 6
    //   2040: invokevirtual 69	java/lang/String:length	()I
    //   2043: ifle +35 -> 2078
    //   2046: invokestatic 432	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2049: invokestatic 467	bctj:a	(Landroid/content/Context;)Lbctj;
    //   2052: aload_0
    //   2053: getfield 44	arnz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2056: invokevirtual 470	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2059: aload 6
    //   2061: iconst_1
    //   2062: ldc2_w 471
    //   2065: aload 7
    //   2067: invokevirtual 250	java/io/File:length	()J
    //   2070: aload 5
    //   2072: ldc_w 474
    //   2075: invokevirtual 477	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2078: aload 8
    //   2080: invokevirtual 242	java/io/File:exists	()Z
    //   2083: ifne -2071 -> 12
    //   2086: aload_1
    //   2087: getfield 480	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   2090: ifeq -2078 -> 12
    //   2093: aload 4
    //   2095: aload 8
    //   2097: invokestatic 289	bgmg:a	(Ljava/io/File;Ljava/io/File;)Z
    //   2100: pop
    //   2101: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2104: ifeq -2092 -> 12
    //   2107: ldc 112
    //   2109: iconst_2
    //   2110: new 17	java/lang/StringBuilder
    //   2113: dup
    //   2114: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   2117: ldc_w 386
    //   2120: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: aload 4
    //   2125: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2128: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2131: ldc_w 388
    //   2134: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: aload 8
    //   2139: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2142: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2145: ldc_w 390
    //   2148: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2151: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2154: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2157: return
    //   2158: astore_1
    //   2159: return
    //   2160: astore 5
    //   2162: goto -416 -> 1746
    //   2165: iconst_0
    //   2166: istore_2
    //   2167: goto -718 -> 1449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2170	0	this	arnz
    //   0	2170	1	paramXmlData	XmlData
    //   494	1673	2	bool1	boolean
    //   690	884	3	bool2	boolean
    //   241	388	4	localObject1	Object
    //   787	33	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   829	1	4	str1	String
    //   834	1	4	localException1	Exception
    //   838	41	4	localObject2	Object
    //   883	33	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   925	1	4	str2	String
    //   930	1	4	localException2	Exception
    //   934	56	4	localObject3	Object
    //   1000	19	4	localThrowable	java.lang.Throwable
    //   1035	33	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   1077	1	4	str3	String
    //   1082	1	4	localException3	Exception
    //   1086	41	4	localObject4	Object
    //   1131	33	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1173	1	4	str4	String
    //   1178	1	4	localException4	Exception
    //   1182	942	4	localObject5	Object
    //   185	1886	5	localObject6	Object
    //   2160	1	5	localException5	Exception
    //   117	1943	6	localObject7	Object
    //   133	1933	7	localFile1	File
    //   114	2024	8	localFile2	File
    //   120	853	9	localObject8	Object
    //   17	1987	10	localXmlData	XmlData
    // Exception table:
    //   from	to	target	type
    //   230	243	787	java/lang/UnsatisfiedLinkError
    //   824	831	834	java/lang/Exception
    //   230	243	883	java/lang/OutOfMemoryError
    //   920	927	930	java/lang/Exception
    //   384	471	1000	java/lang/Throwable
    //   471	527	1000	java/lang/Throwable
    //   527	573	1000	java/lang/Throwable
    //   581	594	1035	java/lang/UnsatisfiedLinkError
    //   1072	1079	1082	java/lang/Exception
    //   581	594	1131	java/lang/OutOfMemoryError
    //   1168	1175	1178	java/lang/Exception
    //   2093	2157	2158	java/lang/Exception
    //   1682	1746	2160	java/lang/Exception
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
      arnn.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download Successful, hasResDownloaded=true, resName=" + this.jdField_b_of_type_JavaLangString + "this=" + this);
      }
      a(paramString);
      ((beaw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193)).a(paramXmlData.strResURL_big, paramXmlData.downSize);
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
      arnn.a(paramXmlData, new String[] { "hasResDownloaded" });
      QLog.d("EarlyDown", 1, "EarlyHandler, onDownloadFinish,download failed, hasResDownloaded=false, resName=" + this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((arnr)((Iterator)localObject).next()).a(paramXmlData, paramBoolean, paramInt, a(), paramString);
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
        ((arnr)localIterator.next()).a(a(), true, 0, a(), paramString);
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
    arnn.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail", "hasResDownloaded" });
    localXmlData.isUserClick = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "restartDownload(), this.strResName=" + this.jdField_b_of_type_JavaLangString + ", resName=" + localXmlData.strResName + ", user=" + paramBoolean);
    }
    Intent localIntent = new Intent();
    GetResourceReqInfo localGetResourceReqInfo = a();
    if (localGetResourceReqInfo != null)
    {
      arno localarno = (arno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(77);
      if ((localarno != null) && (!localarno.a(localXmlData.getStrResName())))
      {
        localIntent.putExtra("reqResult", true);
        localarno.a(localXmlData.getStrResName());
        ((anjo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).a(null, new GetResourceReqInfo[] { localGetResourceReqInfo });
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
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadBegin()");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((arnr)localIterator.next()).a(paramXmlData);
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
      if (bgnt.h(BaseApplicationImpl.getContext())) {
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
      if (bgnt.b(BaseApplicationImpl.getContext())) {
        if (bgnt.c(BaseApplicationImpl.getContext())) {
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
  
  public void c() {}
  
  public void c(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EarlyDown", 2, "onDownloadCancel");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((arnr)localIterator.next()).b(paramXmlData);
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
      arnn.a(localXmlData, new String[] { "loadState", "Version", "hasResDownloaded" });
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
    String str = bhgg.a(jdField_a_of_type_JavaLangString);
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
    if (!a()) {
      new File(c()).delete();
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
          bctj.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actEarlyDownUse", paramBoolean, 0L, 0L, localHashMap, "");
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
  
  public void e(boolean paramBoolean) {}
  
  public boolean e()
  {
    boolean bool2 = false;
    XmlData localXmlData = a();
    boolean bool3 = b();
    boolean bool1;
    if (!d()) {
      if (bgnt.h(BaseApplicationImpl.getContext()))
      {
        if (!QLog.isColorLevel()) {
          break label141;
        }
        QLog.d("EarlyDown", 2, "wifi connected,reset timeValid=true");
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((bool3) && (bool1))
      {
        ((arno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(77)).a(localXmlData, c());
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
      label141:
      bool1 = true;
    }
  }
  
  public void f()
  {
    String str = c();
    try
    {
      new File(str).delete();
      label17:
      arnn.a(a());
      return;
    }
    catch (Exception localException)
    {
      break label17;
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
          d();
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
        arnn.a(localXmlData, new String[] { "Version" });
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
 * Qualified Name:     arnz
 * JD-Core Version:    0.7.0.1
 */