package com.tencent.biz.qcircleshadow.local.pluginparse;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

public class QCircleAssetPluginParse
  extends QCircleBasePluginParse
{
  private final String f = QCircleBasePluginParse.b + QCircleHostConstants._AppSetting.getVersion() + "/" + "qcircle-plugin.jpg".replace(".jpg", ".zip");
  private final String g = QCircleBasePluginParse.b + QCircleHostConstants._AppSetting.getVersion() + "/" + "qcircle-pluginmanager.jpg".replace(".jpg", ".apk");
  private String h;
  private String i;
  
  public QCircleAssetPluginParse(String paramString, QCirclePluginInfo paramQCirclePluginInfo)
  {
    super(paramString, paramQCirclePluginInfo);
  }
  
  private HashMap<String, String> a(XmlPullParser paramXmlPullParser, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt != 1)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        paramInt = paramXmlPullParser.next();
        break;
        String str = paramXmlPullParser.getName();
        if ("qcirclePlugin".equals(str))
        {
          str = paramXmlPullParser.nextText();
          QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#parseInfoXml pluginFileName:" + str);
          localHashMap.put("qcircle-plugin", str);
        }
        else if ("qcirclePluginManager".equals(str))
        {
          str = paramXmlPullParser.nextText();
          QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#parseInfoXml pluginManagerFileName:" + str);
          localHashMap.put("qcircle-pluginmanager", str);
        }
      }
    }
    return localHashMap;
  }
  
  private Map<String, String> a()
  {
    int j = 0;
    Object localObject = b();
    if (localObject != null)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset# getAssetFileName with pluginInfoXml");
      return localObject;
    }
    for (;;)
    {
      HashMap localHashMap;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        long l = System.currentTimeMillis();
        localObject = MobileQQ.sMobileQQ.getAssets().list("qqcircle");
        QLog.i("QCIRCLE_PLUGIN", 1, "parsetAsset# assets list cost:" + (System.currentTimeMillis() - l));
        if ((localObject == null) || (localObject.length == 0))
        {
          QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:can not list file");
          return null;
        }
        localHashMap = new HashMap();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        int k = localObject.length;
        if (j < k)
        {
          String str = localObject[j];
          QLog.i("QCIRCLE_PLUGIN", 1, "file" + str);
          if ((str.contains("qcircle-pluginmanager")) && (str.endsWith(".jpg"))) {
            localArrayList1.add(str);
          } else if ((str.contains("qcircle-plugin")) && (str.endsWith(".jpg"))) {
            localArrayList2.add(str);
          }
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        QLog.e("QCIRCLE_PLUGIN", 1, "parseAsset#exception:" + localIOException.toString());
      }
      for (;;)
      {
        return null;
        a(localArrayList1, "qcircle-pluginmanager");
        a(localArrayList2, "qcircle-plugin");
        if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
        {
          localHashMap.put("qcircle-pluginmanager", localArrayList1.get(0));
          localHashMap.put("qcircle-plugin", localArrayList2.get(0));
          return localHashMap;
        }
        QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:asset empty list");
      }
      j += 1;
    }
  }
  
  private void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      QLog.e("QCIRCLE_PLUGIN", 1, "closeInputStream#exception:" + paramInputStream.toString());
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0).edit();
    localEditor.putString("qcircle-plugin", paramString1);
    localEditor.putString("qcircle-pluginmanager", paramString2);
    localEditor.commit();
  }
  
  private void a(List<String> paramList, String paramString)
  {
    Collections.sort(paramList, new QCircleAssetPluginParse.1(this, paramString));
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str1 = str2.substring(paramString.length(), str2.indexOf(".jpg"));
        paramList = str1;
        if (TextUtils.isEmpty(str1)) {
          paramList = "0";
        }
        QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#" + str2 + ":" + paramList);
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#sort exception:" + paramList.toString());
    }
  }
  
  private boolean a()
  {
    QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset():current file asset should unzip");
    ((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).delete(QCircleBasePluginParse.b, false);
    boolean bool1 = a(this.h, this.f);
    boolean bool2 = a(this.i, this.g);
    return (bool1) && (bool2);
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0);
    String str;
    boolean bool1;
    if (paramBoolean)
    {
      str = "qcircle-plugin";
      str = ((SharedPreferences)localObject).getString(str, "");
      localObject = new StringBuilder().append("parseAsset#checkAssetFileUpdate :");
      if (paramString.equals(str)) {
        break label117;
      }
      bool1 = true;
      label71:
      QLog.i("QCIRCLE_PLUGIN", 1, bool1 + " ,isZip:" + paramBoolean);
      if (paramString.equals(str)) {
        break label122;
      }
    }
    label117:
    label122:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      return paramBoolean;
      str = "qcircle-pluginmanager";
      break;
      bool1 = false;
      break label71;
    }
  }
  
  private boolean a(Map<String, String> paramMap)
  {
    this.h = ((String)paramMap.get("qcircle-plugin"));
    this.i = ((String)paramMap.get("qcircle-pluginmanager"));
    boolean bool1 = a(this.h, true);
    boolean bool2 = a(this.i, false);
    if ((!((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(this.f)) || (!((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(this.g))) {}
    for (int j = 1; (bool1) || (bool2) || (j != 0); j = 0) {
      return true;
    }
    return false;
  }
  
  private QCircleSampleInfo b()
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:no asset info");
      return null;
    }
    if (!a((Map)localObject))
    {
      localObject = new File(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip.a("", new File(this.f)), "config.json").getAbsolutePath();
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:current file asset has unzip already,version:" + this.jdField_a_of_type_Int + "configPath:" + (String)localObject);
      return a((String)localObject, this.f, this.g, "");
    }
    if (!a())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:copy asset plugin fail");
      return null;
    }
    localObject = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip.a(new File(this.f));
    boolean bool = a((String)localObject, this.f, "parseAsset#");
    localObject = new File(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip.a((String)localObject, new File(this.f)), "config.json").getAbsolutePath();
    if (bool)
    {
      a(this.h, this.i);
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:unZip asset plugin success\n" + (String)localObject);
    }
    return a((String)localObject, this.f, this.g, "");
  }
  
  /* Error */
  private Map<String, String> b()
  {
    // Byte code:
    //   0: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: getstatic 122	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   7: invokevirtual 126	mqq/app/MobileQQ:getAssets	()Landroid/content/res/AssetManager;
    //   10: ldc_w 368
    //   13: invokevirtual 372	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: invokestatic 378	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   24: astore 5
    //   26: aload 4
    //   28: astore_3
    //   29: aload 5
    //   31: iconst_1
    //   32: invokevirtual 382	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
    //   35: aload 4
    //   37: astore_3
    //   38: aload 5
    //   40: invokevirtual 386	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   43: astore 5
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: aload 4
    //   52: ldc_w 388
    //   55: invokeinterface 392 3 0
    //   60: aload 4
    //   62: astore_3
    //   63: aload_0
    //   64: aload 5
    //   66: aload 5
    //   68: invokeinterface 395 1 0
    //   73: invokespecial 397	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleAssetPluginParse:a	(Lorg/xmlpull/v1/XmlPullParser;I)Ljava/util/HashMap;
    //   76: astore 5
    //   78: aload 4
    //   80: astore_3
    //   81: aload 5
    //   83: invokevirtual 398	java/util/HashMap:size	()I
    //   86: iconst_2
    //   87: if_icmpne +45 -> 132
    //   90: aload 4
    //   92: astore_3
    //   93: ldc 82
    //   95: iconst_1
    //   96: new 15	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 400
    //   106: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   112: lload_1
    //   113: lsub
    //   114: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   117: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_0
    //   124: aload 4
    //   126: invokespecial 402	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleAssetPluginParse:a	(Ljava/io/InputStream;)V
    //   129: aload 5
    //   131: areturn
    //   132: aload_0
    //   133: aload 4
    //   135: invokespecial 402	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleAssetPluginParse:a	(Ljava/io/InputStream;)V
    //   138: aconst_null
    //   139: areturn
    //   140: astore 5
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 4
    //   147: astore_3
    //   148: aload 5
    //   150: invokevirtual 403	java/lang/Exception:printStackTrace	()V
    //   153: aload 4
    //   155: astore_3
    //   156: ldc 82
    //   158: iconst_1
    //   159: new 15	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 405
    //   169: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 5
    //   174: invokevirtual 408	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: aload 5
    //   185: invokestatic 411	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload_0
    //   189: aload 4
    //   191: invokespecial 402	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleAssetPluginParse:a	(Ljava/io/InputStream;)V
    //   194: goto -56 -> 138
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_3
    //   201: aload_0
    //   202: aload_3
    //   203: invokespecial 402	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleAssetPluginParse:a	(Ljava/io/InputStream;)V
    //   206: aload 4
    //   208: athrow
    //   209: astore 4
    //   211: goto -10 -> 201
    //   214: astore 5
    //   216: goto -71 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	QCircleAssetPluginParse
    //   3	110	1	l	long
    //   20	183	3	localInputStream1	InputStream
    //   16	174	4	localInputStream2	InputStream
    //   197	10	4	localObject1	Object
    //   209	1	4	localObject2	Object
    //   24	106	5	localObject3	Object
    //   140	44	5	localException1	Exception
    //   214	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	18	140	java/lang/Exception
    //   0	18	197	finally
    //   21	26	209	finally
    //   29	35	209	finally
    //   38	45	209	finally
    //   48	60	209	finally
    //   63	78	209	finally
    //   81	90	209	finally
    //   93	123	209	finally
    //   148	153	209	finally
    //   156	188	209	finally
    //   21	26	214	java/lang/Exception
    //   29	35	214	java/lang/Exception
    //   38	45	214	java/lang/Exception
    //   48	60	214	java/lang/Exception
    //   63	78	214	java/lang/Exception
    //   81	90	214	java/lang/Exception
    //   93	123	214	java/lang/Exception
  }
  
  public QCircleSampleInfo a()
  {
    return b();
  }
  
  protected QCircleSampleInfo a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = a(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = null;
    }
    QCircleSampleInfo localQCircleSampleInfo;
    do
    {
      return localObject;
      localQCircleSampleInfo = a((String)localObject);
      localObject = localQCircleSampleInfo;
    } while (localQCircleSampleInfo == null);
    localQCircleSampleInfo.a(paramString2);
    localQCircleSampleInfo.d(this.e);
    localQCircleSampleInfo.b(paramString3);
    localQCircleSampleInfo.e(paramString4);
    localQCircleSampleInfo.c(paramString1);
    return localQCircleSampleInfo;
  }
  
  /* Error */
  protected boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_1
    //   7: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: new 320	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 8
    //   32: aload 8
    //   34: invokevirtual 437	java/io/File:exists	()Z
    //   37: ifeq +9 -> 46
    //   40: aload 8
    //   42: invokevirtual 439	java/io/File:delete	()Z
    //   45: pop
    //   46: new 320	java/io/File
    //   49: dup
    //   50: new 15	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   57: aload_2
    //   58: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 441
    //   64: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 9
    //   75: aload 9
    //   77: invokevirtual 437	java/io/File:exists	()Z
    //   80: ifeq +9 -> 89
    //   83: aload 9
    //   85: invokevirtual 439	java/io/File:delete	()Z
    //   88: pop
    //   89: ldc_w 270
    //   92: invokestatic 276	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   95: checkcast 270	com/tencent/mobileqq/qqcommon/api/IFileUtilsApi
    //   98: aload 9
    //   100: invokevirtual 339	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: invokeinterface 444 2 0
    //   108: getstatic 122	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   111: invokevirtual 126	mqq/app/MobileQQ:getAssets	()Landroid/content/res/AssetManager;
    //   114: new 15	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 446
    //   124: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_1
    //   128: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokevirtual 372	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   137: astore_1
    //   138: new 448	java/io/FileOutputStream
    //   141: dup
    //   142: aload 9
    //   144: invokespecial 451	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   147: astore_2
    //   148: sipush 8192
    //   151: newarray byte
    //   153: astore 6
    //   155: aload_1
    //   156: aload 6
    //   158: invokevirtual 455	java/io/InputStream:read	([B)I
    //   161: istore_3
    //   162: iload_3
    //   163: iconst_m1
    //   164: if_icmpeq +125 -> 289
    //   167: aload_2
    //   168: aload 6
    //   170: iconst_0
    //   171: iload_3
    //   172: invokevirtual 461	java/io/OutputStream:write	([BII)V
    //   175: goto -20 -> 155
    //   178: astore 7
    //   180: aload_2
    //   181: astore 6
    //   183: aload 7
    //   185: astore_2
    //   186: ldc 82
    //   188: iconst_1
    //   189: new 15	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 463
    //   199: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_2
    //   203: invokevirtual 265	java/lang/Exception:toString	()Ljava/lang/String;
    //   206: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_1
    //   216: invokestatic 469	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   219: aload 6
    //   221: invokestatic 469	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   224: aload 8
    //   226: invokevirtual 437	java/io/File:exists	()Z
    //   229: ifeq +122 -> 351
    //   232: aload 8
    //   234: invokevirtual 439	java/io/File:delete	()Z
    //   237: istore 4
    //   239: aload 9
    //   241: aload 8
    //   243: invokevirtual 473	java/io/File:renameTo	(Ljava/io/File;)Z
    //   246: istore 5
    //   248: ldc 82
    //   250: iconst_1
    //   251: new 15	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 475
    //   261: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: iload 5
    //   266: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   269: ldc_w 477
    //   272: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 4
    //   277: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   280: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: iload 5
    //   288: ireturn
    //   289: aload_1
    //   290: invokestatic 469	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   293: aload_2
    //   294: invokestatic 469	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   297: goto -73 -> 224
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_1
    //   304: invokestatic 469	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   307: aload 6
    //   309: invokestatic 469	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   312: aload_2
    //   313: athrow
    //   314: astore_2
    //   315: goto -12 -> 303
    //   318: astore 7
    //   320: aload_2
    //   321: astore 6
    //   323: aload 7
    //   325: astore_2
    //   326: goto -23 -> 303
    //   329: astore_2
    //   330: goto -27 -> 303
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_1
    //   336: aload 7
    //   338: astore 6
    //   340: goto -154 -> 186
    //   343: astore_2
    //   344: aload 7
    //   346: astore 6
    //   348: goto -162 -> 186
    //   351: iconst_1
    //   352: istore 4
    //   354: goto -115 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	QCircleAssetPluginParse
    //   0	357	1	paramString1	String
    //   0	357	2	paramString2	String
    //   161	11	3	j	int
    //   237	116	4	bool1	boolean
    //   246	41	5	bool2	boolean
    //   1	346	6	localObject1	Object
    //   4	1	7	localObject2	Object
    //   178	6	7	localException	Exception
    //   318	27	7	localObject3	Object
    //   30	212	8	localFile1	File
    //   73	167	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   148	155	178	java/lang/Exception
    //   155	162	178	java/lang/Exception
    //   167	175	178	java/lang/Exception
    //   75	89	300	finally
    //   89	138	300	finally
    //   138	148	314	finally
    //   148	155	318	finally
    //   155	162	318	finally
    //   167	175	318	finally
    //   186	215	329	finally
    //   75	89	333	java/lang/Exception
    //   89	138	333	java/lang/Exception
    //   138	148	343	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleAssetPluginParse
 * JD-Core Version:    0.7.0.1
 */