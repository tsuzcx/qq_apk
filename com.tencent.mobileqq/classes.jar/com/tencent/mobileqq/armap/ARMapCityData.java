package com.tencent.mobileqq.armap;

import abiw;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

public class ARMapCityData
  implements INetEngine.INetEngineListener
{
  private static String jdField_a_of_type_JavaLangString;
  private static String b = "http://qqgamevector.map.qq.com/mobile_newmap?fn=ver.xml";
  ARMapCityData.IGetCityDataVersionCallback jdField_a_of_type_ComTencentMobileqqArmapARMapCityData$IGetCityDataVersionCallback = null;
  private ArMapInterface jdField_a_of_type_ComTencentMobileqqArmapArMapInterface;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  
  public ARMapCityData(ArMapInterface paramArMapInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      if (!SystemUtil.a()) {
        break label61;
      }
    }
    label61:
    for (jdField_a_of_type_JavaLangString = AppConstants.aK + "armap/";; jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "armap/") {
      return jdField_a_of_type_JavaLangString + "cityver.dat";
    }
  }
  
  private List a(InputStream paramInputStream)
  {
    ArrayList localArrayList = new ArrayList();
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    localXmlPullParser.setInput(paramInputStream, "ASCII");
    int i = localXmlPullParser.getEventType();
    if (i != 1)
    {
      switch (i)
      {
      }
      for (;;)
      {
        i = localXmlPullParser.next();
        break;
        if (localXmlPullParser.getName().equals("citylist"))
        {
          localXmlPullParser.next();
        }
        else if (localXmlPullParser.getName().equals("city"))
        {
          paramInputStream = new abiw(this);
          paramInputStream.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(null, "idx")).intValue();
          paramInputStream.b = Integer.valueOf(localXmlPullParser.getAttributeValue(null, "ver")).intValue();
          if ((paramInputStream.jdField_a_of_type_Int != 0) && (paramInputStream.b != 0)) {
            localArrayList.add(paramInputStream);
          }
          localXmlPullParser.next();
        }
      }
    }
    return localArrayList;
  }
  
  public void a(ARMapCityData.IGetCityDataVersionCallback paramIGetCityDataVersionCallback)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getApplication().getSharedPreferences("lastGetVersionTimeSP", 0).getLong("lastGetVersionTime", 0L);
        Object localObject = (ARMapManager)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getManager(209);
        if (localObject != null)
        {
          localObject = ((ARMapManager)localObject).a(true);
          int i;
          if (localObject != null)
          {
            i = ((ARMapConfig)localObject).mapForceUpdate;
            if (QLog.isColorLevel()) {
              QLog.i("ARMapCityData", 2, "getCityVersionData: " + i + "," + l1 + "," + l2);
            }
            if ((l1 - l2 >= 43200000L) && (i != 0)) {}
          }
          else
          {
            i = 0;
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqArmapARMapCityData$IGetCityDataVersionCallback = paramIGetCityDataVersionCallback;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getNetEngine(0);
          }
          paramIGetCityDataVersionCallback = new HttpNetReq();
          paramIGetCityDataVersionCallback.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
          paramIGetCityDataVersionCallback.jdField_a_of_type_JavaLangString = b;
          paramIGetCityDataVersionCallback.jdField_a_of_type_Int = 0;
          paramIGetCityDataVersionCallback.c = a();
          paramIGetCityDataVersionCallback.e = 1;
          this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(paramIGetCityDataVersionCallback);
          continue;
        }
        localObject = null;
      }
      finally {}
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  /* Error */
  public void a(com.tencent.mobileqq.transfile.NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 10
    //   6: aload_1
    //   7: getfield 249	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   10: ifne +240 -> 250
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_1
    //   16: getfield 252	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   19: checkcast 221	com/tencent/mobileqq/transfile/HttpNetReq
    //   22: astore 5
    //   24: aload 5
    //   26: getfield 226	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: astore 11
    //   31: iload_2
    //   32: ifeq +385 -> 417
    //   35: new 75	java/io/File
    //   38: dup
    //   39: new 75	java/io/File
    //   42: dup
    //   43: aload 5
    //   45: getfield 232	com/tencent/mobileqq/transfile/HttpNetReq:c	Ljava/lang/String;
    //   48: invokespecial 255	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: invokevirtual 258	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   54: invokespecial 255	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 5
    //   59: new 260	java/io/FileInputStream
    //   62: dup
    //   63: aload 5
    //   65: invokespecial 263	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: astore 6
    //   70: aload 6
    //   72: invokevirtual 266	java/io/FileInputStream:available	()I
    //   75: iconst_4
    //   76: isub
    //   77: newarray byte
    //   79: astore 5
    //   81: aload 6
    //   83: aload 5
    //   85: iconst_0
    //   86: aload 6
    //   88: invokevirtual 266	java/io/FileInputStream:available	()I
    //   91: iconst_4
    //   92: isub
    //   93: invokevirtual 270	java/io/FileInputStream:read	([BII)I
    //   96: pop
    //   97: new 272	java/io/ByteArrayInputStream
    //   100: dup
    //   101: aload 5
    //   103: invokespecial 275	java/io/ByteArrayInputStream:<init>	([B)V
    //   106: astore 5
    //   108: aload 5
    //   110: astore 8
    //   112: aload 6
    //   114: astore 7
    //   116: aload_0
    //   117: aload 5
    //   119: invokespecial 277	com/tencent/mobileqq/armap/ARMapCityData:a	(Ljava/io/InputStream;)Ljava/util/List;
    //   122: astore 9
    //   124: aload 9
    //   126: astore 7
    //   128: aload 6
    //   130: ifnull +8 -> 138
    //   133: aload 6
    //   135: invokevirtual 280	java/io/FileInputStream:close	()V
    //   138: aload 7
    //   140: astore 6
    //   142: aload 5
    //   144: ifnull +12 -> 156
    //   147: aload 5
    //   149: invokevirtual 283	java/io/InputStream:close	()V
    //   152: aload 7
    //   154: astore 6
    //   156: aload 6
    //   158: ifnull +259 -> 417
    //   161: aload 6
    //   163: invokeinterface 286 1 0
    //   168: iconst_1
    //   169: if_icmple +248 -> 417
    //   172: aload 6
    //   174: invokeinterface 286 1 0
    //   179: newarray int
    //   181: astore 5
    //   183: aload 6
    //   185: invokeinterface 286 1 0
    //   190: newarray int
    //   192: astore 7
    //   194: iconst_0
    //   195: istore_2
    //   196: iload_2
    //   197: aload 6
    //   199: invokeinterface 286 1 0
    //   204: if_icmpge +142 -> 346
    //   207: aload 5
    //   209: iload_2
    //   210: aload 6
    //   212: iload_2
    //   213: invokeinterface 290 2 0
    //   218: checkcast 118	abiw
    //   221: getfield 139	abiw:jdField_a_of_type_Int	I
    //   224: iastore
    //   225: aload 7
    //   227: iload_2
    //   228: aload 6
    //   230: iload_2
    //   231: invokeinterface 290 2 0
    //   236: checkcast 118	abiw
    //   239: getfield 143	abiw:b	I
    //   242: iastore
    //   243: iload_2
    //   244: iconst_1
    //   245: iadd
    //   246: istore_2
    //   247: goto -51 -> 196
    //   250: iconst_0
    //   251: istore_2
    //   252: goto -237 -> 15
    //   255: astore 9
    //   257: aconst_null
    //   258: astore 5
    //   260: aconst_null
    //   261: astore 6
    //   263: aload 5
    //   265: astore 8
    //   267: aload 6
    //   269: astore 7
    //   271: aload 9
    //   273: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   276: aload 6
    //   278: ifnull +8 -> 286
    //   281: aload 6
    //   283: invokevirtual 280	java/io/FileInputStream:close	()V
    //   286: aload 10
    //   288: astore 6
    //   290: aload 5
    //   292: ifnull -136 -> 156
    //   295: aload 5
    //   297: invokevirtual 283	java/io/InputStream:close	()V
    //   300: aload 10
    //   302: astore 6
    //   304: goto -148 -> 156
    //   307: astore 5
    //   309: aload 10
    //   311: astore 6
    //   313: goto -157 -> 156
    //   316: astore_1
    //   317: aconst_null
    //   318: astore 6
    //   320: aload 7
    //   322: astore 5
    //   324: aload 6
    //   326: ifnull +8 -> 334
    //   329: aload 6
    //   331: invokevirtual 280	java/io/FileInputStream:close	()V
    //   334: aload 5
    //   336: ifnull +8 -> 344
    //   339: aload 5
    //   341: invokevirtual 283	java/io/InputStream:close	()V
    //   344: aload_1
    //   345: athrow
    //   346: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   349: lstore_3
    //   350: aload_0
    //   351: getfield 27	com/tencent/mobileqq/armap/ARMapCityData:jdField_a_of_type_ComTencentMobileqqArmapArMapInterface	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   354: invokevirtual 160	com/tencent/mobileqq/armap/ArMapInterface:getApplication	()Lmqq/app/MobileQQ;
    //   357: ldc 162
    //   359: iconst_0
    //   360: invokevirtual 168	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   363: invokeinterface 297 1 0
    //   368: astore 8
    //   370: aload 8
    //   372: ldc 170
    //   374: lload_3
    //   375: invokeinterface 303 4 0
    //   380: pop
    //   381: aload 8
    //   383: invokeinterface 306 1 0
    //   388: pop
    //   389: aload_0
    //   390: getfield 25	com/tencent/mobileqq/armap/ARMapCityData:jdField_a_of_type_ComTencentMobileqqArmapARMapCityData$IGetCityDataVersionCallback	Lcom/tencent/mobileqq/armap/ARMapCityData$IGetCityDataVersionCallback;
    //   393: ifnull +24 -> 417
    //   396: aload_0
    //   397: getfield 25	com/tencent/mobileqq/armap/ARMapCityData:jdField_a_of_type_ComTencentMobileqqArmapARMapCityData$IGetCityDataVersionCallback	Lcom/tencent/mobileqq/armap/ARMapCityData$IGetCityDataVersionCallback;
    //   400: iconst_1
    //   401: aload 5
    //   403: aload 7
    //   405: aload 6
    //   407: invokeinterface 286 1 0
    //   412: invokeinterface 312 5 0
    //   417: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +80 -> 500
    //   423: ldc 197
    //   425: iconst_2
    //   426: new 43	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   433: ldc_w 314
    //   436: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 11
    //   441: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 316
    //   447: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 11
    //   452: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: ldc_w 318
    //   458: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload_1
    //   462: getfield 249	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   465: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: ldc_w 320
    //   471: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_1
    //   475: getfield 322	com/tencent/mobileqq/transfile/NetResp:c	I
    //   478: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: ldc_w 324
    //   484: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload_1
    //   488: getfield 325	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   491: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 211	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: return
    //   501: astore 6
    //   503: goto -365 -> 138
    //   506: astore 5
    //   508: aload 7
    //   510: astore 6
    //   512: goto -356 -> 156
    //   515: astore 6
    //   517: goto -231 -> 286
    //   520: astore 6
    //   522: goto -188 -> 334
    //   525: astore 5
    //   527: goto -183 -> 344
    //   530: astore_1
    //   531: aload 7
    //   533: astore 5
    //   535: goto -211 -> 324
    //   538: astore_1
    //   539: aload 8
    //   541: astore 5
    //   543: aload 7
    //   545: astore 6
    //   547: goto -223 -> 324
    //   550: astore 9
    //   552: aconst_null
    //   553: astore 5
    //   555: goto -292 -> 263
    //   558: astore 9
    //   560: goto -297 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	ARMapCityData
    //   0	563	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   14	238	2	i	int
    //   349	26	3	l	long
    //   22	274	5	localObject1	Object
    //   307	1	5	localIOException1	java.io.IOException
    //   322	80	5	localObject2	Object
    //   506	1	5	localIOException2	java.io.IOException
    //   525	1	5	localIOException3	java.io.IOException
    //   533	21	5	localObject3	Object
    //   68	338	6	localObject4	Object
    //   501	1	6	localIOException4	java.io.IOException
    //   510	1	6	localObject5	Object
    //   515	1	6	localIOException5	java.io.IOException
    //   520	1	6	localIOException6	java.io.IOException
    //   545	1	6	localObject6	Object
    //   1	543	7	localObject7	Object
    //   110	430	8	localObject8	Object
    //   122	3	9	localList	List
    //   255	17	9	localException1	java.lang.Exception
    //   550	1	9	localException2	java.lang.Exception
    //   558	1	9	localException3	java.lang.Exception
    //   4	306	10	localObject9	Object
    //   29	422	11	str	String
    // Exception table:
    //   from	to	target	type
    //   59	70	255	java/lang/Exception
    //   295	300	307	java/io/IOException
    //   59	70	316	finally
    //   133	138	501	java/io/IOException
    //   147	152	506	java/io/IOException
    //   281	286	515	java/io/IOException
    //   329	334	520	java/io/IOException
    //   339	344	525	java/io/IOException
    //   70	108	530	finally
    //   116	124	538	finally
    //   271	276	538	finally
    //   70	108	550	java/lang/Exception
    //   116	124	558	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapCityData
 * JD-Core Version:    0.7.0.1
 */