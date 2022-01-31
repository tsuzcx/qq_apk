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

public abstract class amza
{
  static final String jdField_a_of_type_JavaLangString = ajed.aU + "pddata/prd/early";
  public QQAppInterface a;
  private XmlData jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  protected ArrayList<amys> a;
  protected boolean a;
  protected String b;
  protected boolean b;
  protected boolean c;
  
  public amza(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public final XmlData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData == null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData = amyo.a(a());
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
        ((amys)localIterator.next()).a(localXmlData, paramLong1, paramLong2);
      }
    }
  }
  
  public void a(amys paramamys)
  {
    if (paramamys != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramamys)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramamys);
      }
    }
  }
  
  /* Error */
  public void a(XmlData paramXmlData)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +18 -> 19
    //   4: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 112
    //   12: iconst_2
    //   13: ldc 203
    //   15: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: return
    //   19: aload_0
    //   20: invokevirtual 59	amza:a	()Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;
    //   23: astore 10
    //   25: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +82 -> 110
    //   31: ldc 112
    //   33: iconst_2
    //   34: new 17	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   41: ldc 208
    //   43: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: getfield 122	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   50: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 210
    //   55: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   62: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 212
    //   67: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload 10
    //   72: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   75: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: ldc 214
    //   80: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 10
    //   85: getfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   88: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: ldc 219
    //   93: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 10
    //   98: getfield 222	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   101: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aconst_null
    //   111: astore 8
    //   113: aconst_null
    //   114: astore 6
    //   116: aconst_null
    //   117: astore 9
    //   119: new 224	java/io/File
    //   122: dup
    //   123: aload_0
    //   124: invokevirtual 226	amza:c	()Ljava/lang/String;
    //   127: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   130: astore 7
    //   132: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +45 -> 180
    //   138: ldc 112
    //   140: iconst_2
    //   141: new 17	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   148: ldc 229
    //   150: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 7
    //   155: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   158: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 234
    //   163: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 7
    //   168: invokevirtual 237	java/io/File:exists	()Z
    //   171: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   174: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload 8
    //   182: astore 5
    //   184: aload 7
    //   186: invokevirtual 237	java/io/File:exists	()Z
    //   189: ifeq +89 -> 278
    //   192: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +32 -> 227
    //   198: ldc 112
    //   200: iconst_2
    //   201: new 17	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   208: ldc 242
    //   210: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 7
    //   215: invokevirtual 245	java/io/File:length	()J
    //   218: invokevirtual 248	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload 7
    //   229: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   232: invokestatic 254	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   235: invokestatic 260	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   238: astore 4
    //   240: aload 4
    //   242: ifnull +734 -> 976
    //   245: aload_1
    //   246: getfield 263	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   249: ifnull +727 -> 976
    //   252: aload 4
    //   254: invokevirtual 266	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   257: aload_1
    //   258: getfield 263	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   261: invokevirtual 266	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   264: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: ifeq +709 -> 976
    //   270: aload 7
    //   272: astore 5
    //   274: aload 4
    //   276: astore 6
    //   278: new 224	java/io/File
    //   281: dup
    //   282: aload_0
    //   283: invokevirtual 271	amza:d	()Ljava/lang/String;
    //   286: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore 8
    //   291: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +46 -> 340
    //   297: ldc 112
    //   299: iconst_2
    //   300: new 17	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 273
    //   310: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 8
    //   315: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   318: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc 234
    //   323: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 8
    //   328: invokevirtual 237	java/io/File:exists	()Z
    //   331: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   334: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload 5
    //   342: ifnonnull +933 -> 1275
    //   345: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +33 -> 381
    //   351: ldc 112
    //   353: iconst_2
    //   354: new 17	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 275
    //   364: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 8
    //   369: invokevirtual 245	java/io/File:length	()J
    //   372: invokevirtual 248	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: new 224	java/io/File
    //   384: dup
    //   385: new 17	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   392: getstatic 25	ajed:aU	Ljava/lang/String;
    //   395: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w 277
    //   401: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_0
    //   405: getfield 42	amza:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   408: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   417: astore 4
    //   419: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +46 -> 468
    //   425: ldc 112
    //   427: iconst_2
    //   428: new 17	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   435: ldc_w 279
    //   438: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 4
    //   443: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   446: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: ldc 234
    //   451: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload 4
    //   456: invokevirtual 237	java/io/File:exists	()Z
    //   459: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   462: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload 8
    //   470: invokevirtual 237	java/io/File:exists	()Z
    //   473: ifne +51 -> 524
    //   476: aload 4
    //   478: invokevirtual 237	java/io/File:exists	()Z
    //   481: ifeq +43 -> 524
    //   484: aload 4
    //   486: aload 8
    //   488: invokestatic 284	bace:a	(Ljava/io/File;Ljava/io/File;)Z
    //   491: istore_2
    //   492: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +29 -> 524
    //   498: ldc 112
    //   500: iconst_2
    //   501: new 17	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   508: ldc_w 286
    //   511: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: iload_2
    //   515: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   518: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: aload 4
    //   526: invokevirtual 237	java/io/File:exists	()Z
    //   529: ifeq +41 -> 570
    //   532: aload 4
    //   534: invokevirtual 289	java/io/File:delete	()Z
    //   537: istore_2
    //   538: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq +29 -> 570
    //   544: ldc 112
    //   546: iconst_2
    //   547: new 17	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   554: ldc_w 291
    //   557: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: iload_2
    //   561: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   564: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 8
    //   572: invokevirtual 237	java/io/File:exists	()Z
    //   575: ifeq +700 -> 1275
    //   578: aload 8
    //   580: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   583: invokestatic 254	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   586: invokestatic 260	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   589: astore 4
    //   591: aload 4
    //   593: ifnull +672 -> 1265
    //   596: aload_1
    //   597: getfield 263	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   600: ifnull +665 -> 1265
    //   603: aload 4
    //   605: invokevirtual 266	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   608: aload_1
    //   609: getfield 263	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   612: invokevirtual 266	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   615: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   618: ifeq +647 -> 1265
    //   621: aload 8
    //   623: astore 4
    //   625: aload 4
    //   627: ifnonnull +1001 -> 1628
    //   630: aload 10
    //   632: iconst_0
    //   633: putfield 294	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   636: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +32 -> 671
    //   642: ldc 112
    //   644: iconst_2
    //   645: new 17	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   652: ldc_w 296
    //   655: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_0
    //   659: getfield 42	amza:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   662: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   671: aload 10
    //   673: iconst_1
    //   674: anewarray 66	java/lang/String
    //   677: dup
    //   678: iconst_0
    //   679: ldc_w 297
    //   682: aastore
    //   683: invokestatic 300	amyo:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   686: iconst_0
    //   687: istore_3
    //   688: aload_0
    //   689: invokevirtual 303	amza:h	()Z
    //   692: ifne +590 -> 1282
    //   695: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   698: ifeq +32 -> 730
    //   701: ldc 112
    //   703: iconst_2
    //   704: new 17	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   711: ldc_w 305
    //   714: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload_0
    //   718: getfield 42	amza:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   721: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: aload 10
    //   732: aload_1
    //   733: invokevirtual 308	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   736: aload 10
    //   738: iconst_1
    //   739: putfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   742: aload 10
    //   744: iconst_0
    //   745: anewarray 66	java/lang/String
    //   748: invokestatic 300	amyo:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   751: iload_3
    //   752: istore_2
    //   753: iload_2
    //   754: ifne -736 -> 18
    //   757: aload_0
    //   758: getfield 44	amza:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   761: bipush 77
    //   763: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   766: checkcast 316	amyp
    //   769: aload 10
    //   771: invokevirtual 319	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   774: invokevirtual 321	amyp:b	(Ljava/lang/String;)V
    //   777: aload_0
    //   778: aload 10
    //   780: invokevirtual 323	amza:d	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   783: return
    //   784: astore 4
    //   786: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   789: ifeq +32 -> 821
    //   792: ldc 112
    //   794: iconst_2
    //   795: iconst_2
    //   796: anewarray 4	java/lang/Object
    //   799: dup
    //   800: iconst_0
    //   801: ldc_w 325
    //   804: aastore
    //   805: dup
    //   806: iconst_1
    //   807: aload 4
    //   809: invokevirtual 328	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   812: aastore
    //   813: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   816: aload 4
    //   818: invokevirtual 334	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   821: aload 7
    //   823: invokestatic 339	bech:a	(Ljava/io/File;)Ljava/lang/String;
    //   826: astore 4
    //   828: goto -588 -> 240
    //   831: astore 4
    //   833: aload 9
    //   835: astore 4
    //   837: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   840: ifeq -600 -> 240
    //   843: ldc 112
    //   845: iconst_2
    //   846: new 17	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   853: ldc_w 341
    //   856: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload 7
    //   861: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   864: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: aload 9
    //   875: astore 4
    //   877: goto -637 -> 240
    //   880: astore 4
    //   882: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   885: ifeq +32 -> 917
    //   888: ldc 112
    //   890: iconst_2
    //   891: iconst_2
    //   892: anewarray 4	java/lang/Object
    //   895: dup
    //   896: iconst_0
    //   897: ldc_w 343
    //   900: aastore
    //   901: dup
    //   902: iconst_1
    //   903: aload 4
    //   905: invokevirtual 344	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   908: aastore
    //   909: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   912: aload 4
    //   914: invokevirtual 345	java/lang/OutOfMemoryError:printStackTrace	()V
    //   917: aload 7
    //   919: invokestatic 339	bech:a	(Ljava/io/File;)Ljava/lang/String;
    //   922: astore 4
    //   924: goto -684 -> 240
    //   927: astore 4
    //   929: aload 9
    //   931: astore 4
    //   933: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq -696 -> 240
    //   939: ldc 112
    //   941: iconst_2
    //   942: new 17	java/lang/StringBuilder
    //   945: dup
    //   946: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   949: ldc_w 341
    //   952: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: aload 7
    //   957: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   960: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   969: aload 9
    //   971: astore 4
    //   973: goto -733 -> 240
    //   976: aload 7
    //   978: invokevirtual 289	java/io/File:delete	()Z
    //   981: pop
    //   982: aload_0
    //   983: invokevirtual 347	amza:c	()V
    //   986: aload 4
    //   988: astore 6
    //   990: aload 8
    //   992: astore 5
    //   994: goto -716 -> 278
    //   997: astore 4
    //   999: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1002: ifeq +38 -> 1040
    //   1005: ldc 112
    //   1007: iconst_2
    //   1008: new 17	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1015: ldc_w 349
    //   1018: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: aload 4
    //   1023: invokevirtual 350	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1026: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: aload 4
    //   1034: invokestatic 353	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1037: goto -467 -> 570
    //   1040: ldc 112
    //   1042: iconst_2
    //   1043: new 17	java/lang/StringBuilder
    //   1046: dup
    //   1047: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1050: ldc_w 349
    //   1053: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: aload 4
    //   1058: invokevirtual 350	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1061: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1070: goto -500 -> 570
    //   1073: astore 4
    //   1075: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1078: ifeq +32 -> 1110
    //   1081: ldc 112
    //   1083: iconst_2
    //   1084: iconst_2
    //   1085: anewarray 4	java/lang/Object
    //   1088: dup
    //   1089: iconst_0
    //   1090: ldc_w 355
    //   1093: aastore
    //   1094: dup
    //   1095: iconst_1
    //   1096: aload 4
    //   1098: invokevirtual 328	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1101: aastore
    //   1102: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1105: aload 4
    //   1107: invokevirtual 334	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   1110: aload 8
    //   1112: invokestatic 339	bech:a	(Ljava/io/File;)Ljava/lang/String;
    //   1115: astore 4
    //   1117: goto -526 -> 591
    //   1120: astore 4
    //   1122: aload 6
    //   1124: astore 4
    //   1126: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1129: ifeq -538 -> 591
    //   1132: ldc 112
    //   1134: iconst_2
    //   1135: new 17	java/lang/StringBuilder
    //   1138: dup
    //   1139: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1142: ldc_w 341
    //   1145: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: aload 8
    //   1150: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1153: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1159: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1162: aload 6
    //   1164: astore 4
    //   1166: goto -575 -> 591
    //   1169: astore 4
    //   1171: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1174: ifeq +32 -> 1206
    //   1177: ldc 112
    //   1179: iconst_2
    //   1180: iconst_2
    //   1181: anewarray 4	java/lang/Object
    //   1184: dup
    //   1185: iconst_0
    //   1186: ldc_w 357
    //   1189: aastore
    //   1190: dup
    //   1191: iconst_1
    //   1192: aload 4
    //   1194: invokevirtual 344	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1197: aastore
    //   1198: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1201: aload 4
    //   1203: invokevirtual 345	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1206: aload 8
    //   1208: invokestatic 339	bech:a	(Ljava/io/File;)Ljava/lang/String;
    //   1211: astore 4
    //   1213: goto -622 -> 591
    //   1216: astore 4
    //   1218: aload 6
    //   1220: astore 4
    //   1222: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1225: ifeq -634 -> 591
    //   1228: ldc 112
    //   1230: iconst_2
    //   1231: new 17	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1238: ldc_w 341
    //   1241: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: aload 8
    //   1246: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1249: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1258: aload 6
    //   1260: astore 4
    //   1262: goto -671 -> 591
    //   1265: aload 8
    //   1267: invokevirtual 289	java/io/File:delete	()Z
    //   1270: pop
    //   1271: aload_0
    //   1272: invokevirtual 347	amza:c	()V
    //   1275: aload 5
    //   1277: astore 4
    //   1279: goto -654 -> 625
    //   1282: iload_3
    //   1283: istore_2
    //   1284: aload_1
    //   1285: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1288: aload 10
    //   1290: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1293: if_icmplt -540 -> 753
    //   1296: aload_1
    //   1297: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1300: aload 10
    //   1302: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1305: if_icmpne +185 -> 1490
    //   1308: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1311: ifeq +46 -> 1357
    //   1314: ldc 112
    //   1316: iconst_2
    //   1317: new 17	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1324: ldc_w 359
    //   1327: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: aload 10
    //   1332: getfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1335: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1338: ldc_w 361
    //   1341: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: aload_0
    //   1345: getfield 42	amza:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1348: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1354: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1357: iload_3
    //   1358: istore_2
    //   1359: aload 10
    //   1361: getfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1364: iconst_1
    //   1365: if_icmpeq -612 -> 753
    //   1368: aload 10
    //   1370: aload_1
    //   1371: invokevirtual 308	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1374: aload 10
    //   1376: iconst_0
    //   1377: anewarray 66	java/lang/String
    //   1380: invokestatic 300	amyo:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1383: aload_0
    //   1384: getfield 44	amza:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1387: bipush 77
    //   1389: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1392: checkcast 316	amyp
    //   1395: astore_1
    //   1396: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1399: ifeq +60 -> 1459
    //   1402: ldc 112
    //   1404: iconst_2
    //   1405: new 17	java/lang/StringBuilder
    //   1408: dup
    //   1409: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1412: ldc_w 363
    //   1415: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: aload 10
    //   1420: getfield 366	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1423: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1426: ldc_w 368
    //   1429: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: aload 10
    //   1434: getfield 371	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1437: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1440: ldc_w 373
    //   1443: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: aload_1
    //   1447: invokevirtual 375	amyp:a	()Z
    //   1450: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1453: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1456: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1459: aload 10
    //   1461: getfield 366	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1464: ifne +18 -> 1482
    //   1467: aload 10
    //   1469: getfield 371	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1472: ifeq +10 -> 1482
    //   1475: aload_1
    //   1476: invokevirtual 375	amyp:a	()Z
    //   1479: ifne +723 -> 2202
    //   1482: aload_0
    //   1483: invokevirtual 377	amza:e	()Z
    //   1486: istore_2
    //   1487: goto -734 -> 753
    //   1490: iload_3
    //   1491: istore_2
    //   1492: aload_1
    //   1493: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1496: aload 10
    //   1498: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1501: if_icmple -748 -> 753
    //   1504: aload 10
    //   1506: aload_1
    //   1507: invokevirtual 308	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1510: aload 10
    //   1512: iconst_0
    //   1513: anewarray 66	java/lang/String
    //   1516: invokestatic 300	amyo:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1519: aload_0
    //   1520: getfield 44	amza:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1523: bipush 77
    //   1525: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1528: checkcast 316	amyp
    //   1531: astore_1
    //   1532: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1535: ifeq +60 -> 1595
    //   1538: ldc 112
    //   1540: iconst_2
    //   1541: new 17	java/lang/StringBuilder
    //   1544: dup
    //   1545: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1548: ldc_w 379
    //   1551: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: aload 10
    //   1556: getfield 366	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1559: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1562: ldc_w 368
    //   1565: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: aload 10
    //   1570: getfield 371	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1573: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1576: ldc_w 373
    //   1579: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: aload_1
    //   1583: invokevirtual 375	amyp:a	()Z
    //   1586: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1589: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1592: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1595: aload 10
    //   1597: getfield 366	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1600: ifne +20 -> 1620
    //   1603: aload 10
    //   1605: getfield 371	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1608: ifeq +12 -> 1620
    //   1611: iload_3
    //   1612: istore_2
    //   1613: aload_1
    //   1614: invokevirtual 375	amyp:a	()Z
    //   1617: ifne -864 -> 753
    //   1620: aload_0
    //   1621: invokevirtual 377	amza:e	()Z
    //   1624: istore_2
    //   1625: goto -872 -> 753
    //   1628: aload 10
    //   1630: aload_1
    //   1631: invokevirtual 308	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1634: aload 10
    //   1636: aload_1
    //   1637: getfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1640: putfield 157	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1643: aload 10
    //   1645: iconst_1
    //   1646: putfield 217	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1649: aload 10
    //   1651: iconst_1
    //   1652: putfield 294	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   1655: aload 10
    //   1657: iconst_1
    //   1658: anewarray 66	java/lang/String
    //   1661: dup
    //   1662: iconst_0
    //   1663: ldc_w 297
    //   1666: aastore
    //   1667: invokestatic 300	amyo:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1670: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1673: ifeq +32 -> 1705
    //   1676: ldc 112
    //   1678: iconst_2
    //   1679: new 17	java/lang/StringBuilder
    //   1682: dup
    //   1683: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1686: ldc_w 381
    //   1689: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: aload_0
    //   1693: getfield 42	amza:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1696: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1699: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1702: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1705: aload 7
    //   1707: invokevirtual 237	java/io/File:exists	()Z
    //   1710: ifne +74 -> 1784
    //   1713: aload_0
    //   1714: invokevirtual 382	amza:a	()Z
    //   1717: ifne +67 -> 1784
    //   1720: aload 4
    //   1722: aload 7
    //   1724: invokestatic 284	bace:a	(Ljava/io/File;Ljava/io/File;)Z
    //   1727: pop
    //   1728: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1731: ifeq +53 -> 1784
    //   1734: ldc 112
    //   1736: iconst_2
    //   1737: new 17	java/lang/StringBuilder
    //   1740: dup
    //   1741: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1744: ldc_w 384
    //   1747: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: aload 4
    //   1752: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1755: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1758: ldc_w 386
    //   1761: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: aload 7
    //   1766: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1769: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1772: ldc_w 388
    //   1775: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1781: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1784: aload 10
    //   1786: iconst_0
    //   1787: anewarray 66	java/lang/String
    //   1790: invokestatic 300	amyo:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1793: aload_0
    //   1794: aload 4
    //   1796: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1799: invokevirtual 390	amza:a	(Ljava/lang/String;)V
    //   1802: aload_0
    //   1803: getfield 44	amza:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1806: bipush 77
    //   1808: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1811: checkcast 316	amyp
    //   1814: aload 10
    //   1816: invokevirtual 319	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   1819: invokevirtual 321	amyp:b	(Ljava/lang/String;)V
    //   1822: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1825: ifeq +52 -> 1877
    //   1828: ldc 112
    //   1830: iconst_2
    //   1831: new 17	java/lang/StringBuilder
    //   1834: dup
    //   1835: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1838: ldc 208
    //   1840: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: aload 10
    //   1845: getfield 122	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1848: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: ldc_w 392
    //   1854: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: aload 4
    //   1859: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1862: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1865: ldc_w 388
    //   1868: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1874: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1877: aload_0
    //   1878: getfield 394	amza:c	Z
    //   1881: ifeq +145 -> 2026
    //   1884: new 396	android/content/Intent
    //   1887: dup
    //   1888: ldc_w 398
    //   1891: invokespecial 399	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1894: astore 5
    //   1896: aload 5
    //   1898: ldc_w 400
    //   1901: aload_0
    //   1902: getfield 42	amza:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1905: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1908: pop
    //   1909: aload 5
    //   1911: ldc_w 405
    //   1914: aload 10
    //   1916: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   1919: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1922: pop
    //   1923: aload 5
    //   1925: ldc_w 406
    //   1928: iconst_1
    //   1929: invokevirtual 409	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1932: pop
    //   1933: aload 5
    //   1935: ldc_w 411
    //   1938: aload 10
    //   1940: getfield 413	com/tencent/mobileqq/earlydownload/xmldata/XmlData:totalSize	J
    //   1943: invokevirtual 416	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1946: pop
    //   1947: aload 5
    //   1949: ldc_w 418
    //   1952: aload 10
    //   1954: getfield 420	com/tencent/mobileqq/earlydownload/xmldata/XmlData:downSize	J
    //   1957: invokevirtual 416	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1960: pop
    //   1961: aload 5
    //   1963: ldc_w 422
    //   1966: aload 4
    //   1968: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1971: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1974: pop
    //   1975: invokestatic 428	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1978: aload 5
    //   1980: ldc_w 430
    //   1983: invokevirtual 436	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1986: aload_0
    //   1987: iconst_0
    //   1988: putfield 394	amza:c	Z
    //   1991: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1994: ifeq +32 -> 2026
    //   1997: ldc 112
    //   1999: iconst_2
    //   2000: new 17	java/lang/StringBuilder
    //   2003: dup
    //   2004: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   2007: ldc_w 438
    //   2010: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2013: aload_0
    //   2014: getfield 42	amza:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2017: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2020: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2023: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2026: new 440	java/util/HashMap
    //   2029: dup
    //   2030: invokespecial 441	java/util/HashMap:<init>	()V
    //   2033: astore 5
    //   2035: aload 5
    //   2037: ldc_w 443
    //   2040: aload 10
    //   2042: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   2045: invokevirtual 447	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2048: pop
    //   2049: aload 5
    //   2051: ldc_w 449
    //   2054: getstatic 455	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2057: invokevirtual 456	java/lang/Boolean:toString	()Ljava/lang/String;
    //   2060: invokevirtual 447	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2063: pop
    //   2064: aload_0
    //   2065: invokevirtual 458	amza:a	()Ljava/lang/String;
    //   2068: astore 6
    //   2070: aload 6
    //   2072: ifnull +43 -> 2115
    //   2075: aload 6
    //   2077: invokevirtual 69	java/lang/String:length	()I
    //   2080: ifle +35 -> 2115
    //   2083: invokestatic 428	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2086: invokestatic 463	awrn:a	(Landroid/content/Context;)Lawrn;
    //   2089: aload_0
    //   2090: getfield 44	amza:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2093: invokevirtual 466	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2096: aload 6
    //   2098: iconst_1
    //   2099: ldc2_w 467
    //   2102: aload 7
    //   2104: invokevirtual 245	java/io/File:length	()J
    //   2107: aload 5
    //   2109: ldc_w 470
    //   2112: invokevirtual 473	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2115: aload 8
    //   2117: invokevirtual 237	java/io/File:exists	()Z
    //   2120: ifne -2102 -> 18
    //   2123: aload_1
    //   2124: getfield 476	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   2127: ifeq -2109 -> 18
    //   2130: aload 4
    //   2132: aload 8
    //   2134: invokestatic 284	bace:a	(Ljava/io/File;Ljava/io/File;)Z
    //   2137: pop
    //   2138: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2141: ifeq -2123 -> 18
    //   2144: ldc 112
    //   2146: iconst_2
    //   2147: new 17	java/lang/StringBuilder
    //   2150: dup
    //   2151: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   2154: ldc_w 384
    //   2157: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2160: aload 4
    //   2162: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2165: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2168: ldc_w 386
    //   2171: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: aload 8
    //   2176: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2179: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: ldc_w 388
    //   2185: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2188: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2191: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2194: return
    //   2195: astore_1
    //   2196: return
    //   2197: astore 5
    //   2199: goto -415 -> 1784
    //   2202: iconst_0
    //   2203: istore_2
    //   2204: goto -717 -> 1487
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2207	0	this	amza
    //   0	2207	1	paramXmlData	XmlData
    //   491	1713	2	bool1	boolean
    //   687	925	3	bool2	boolean
    //   238	388	4	localObject1	Object
    //   784	33	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   826	1	4	str1	String
    //   831	1	4	localException1	Exception
    //   835	41	4	localObject2	Object
    //   880	33	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   922	1	4	str2	String
    //   927	1	4	localException2	Exception
    //   931	56	4	localObject3	Object
    //   997	60	4	localThrowable	java.lang.Throwable
    //   1073	33	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   1115	1	4	str3	String
    //   1120	1	4	localException3	Exception
    //   1124	41	4	localObject4	Object
    //   1169	33	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1211	1	4	str4	String
    //   1216	1	4	localException4	Exception
    //   1220	941	4	localObject5	Object
    //   182	1926	5	localObject6	Object
    //   2197	1	5	localException5	Exception
    //   114	1983	6	localObject7	Object
    //   130	1973	7	localFile1	File
    //   111	2064	8	localFile2	File
    //   117	853	9	localObject8	Object
    //   23	2018	10	localXmlData	XmlData
    // Exception table:
    //   from	to	target	type
    //   227	240	784	java/lang/UnsatisfiedLinkError
    //   821	828	831	java/lang/Exception
    //   227	240	880	java/lang/OutOfMemoryError
    //   917	924	927	java/lang/Exception
    //   381	468	997	java/lang/Throwable
    //   468	524	997	java/lang/Throwable
    //   524	570	997	java/lang/Throwable
    //   578	591	1073	java/lang/UnsatisfiedLinkError
    //   1110	1117	1120	java/lang/Exception
    //   578	591	1169	java/lang/OutOfMemoryError
    //   1206	1213	1216	java/lang/Exception
    //   2130	2194	2195	java/lang/Exception
    //   1720	1784	2197	java/lang/Exception
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
      amyo.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download Successful, hasResDownloaded=true, resName=" + this.jdField_b_of_type_JavaLangString);
      }
      a(paramString);
      ((axxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193)).a(paramXmlData.strResURL_big, paramXmlData.downSize);
      if (this.c)
      {
        localObject = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
        if (paramInt != 9037) {
          break label392;
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
      amyo.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download failed, hasResDownloaded=false, resName=" + this.jdField_b_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((amys)((Iterator)localObject).next()).a(paramXmlData, paramBoolean, paramInt, a(), paramString);
      }
      break;
      label392:
      ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_QUERY");
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((amys)localIterator.next()).a(a(), true, 0, a(), paramString);
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
    amyo.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail", "hasResDownloaded" });
    localXmlData.isUserClick = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "restartDownload(), this.strResName=" + this.jdField_b_of_type_JavaLangString + ", resName=" + localXmlData.strResName + ", user=" + paramBoolean);
    }
    Intent localIntent = new Intent();
    GetResourceReqInfo localGetResourceReqInfo = a();
    if (localGetResourceReqInfo != null)
    {
      amyp localamyp = (amyp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(77);
      if ((localamyp != null) && (!localamyp.a(localXmlData.getStrResName())))
      {
        localIntent.putExtra("reqResult", true);
        localamyp.a(localXmlData.getStrResName());
        ((ajgd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).a(null, new GetResourceReqInfo[] { localGetResourceReqInfo });
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
        ((amys)localIterator.next()).a(paramXmlData);
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
      if (badq.h(BaseApplicationImpl.getContext())) {
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
      if (badq.b(BaseApplicationImpl.getContext())) {
        if (badq.c(BaseApplicationImpl.getContext())) {
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
        ((amys)localIterator.next()).b(paramXmlData);
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
      amyo.a(localXmlData, new String[] { "loadState", "Version", "hasResDownloaded" });
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
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.jdField_b_of_type_JavaLangString;
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
          awrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actEarlyDownUse", paramBoolean, 0L, 0L, localHashMap, "");
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
      if (badq.h(BaseApplicationImpl.getContext()))
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
        ((amyp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(77)).a(localXmlData, c());
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
      amyo.a(a());
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
        amyo.a(localXmlData, new String[] { "Version" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amza
 * JD-Core Version:    0.7.0.1
 */