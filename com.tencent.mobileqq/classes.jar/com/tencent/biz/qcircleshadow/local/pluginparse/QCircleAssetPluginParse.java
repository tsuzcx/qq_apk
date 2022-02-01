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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import mqq.app.MobileQQ;

public class QCircleAssetPluginParse
  extends QCircleBasePluginParse
{
  private final String f;
  private final String g;
  private String h;
  private String i;
  
  public QCircleAssetPluginParse(String paramString, QCirclePluginInfo paramQCirclePluginInfo)
  {
    super(paramString, paramQCirclePluginInfo);
    paramString = new StringBuilder();
    paramString.append(QCircleBasePluginParse.b);
    paramString.append(QCircleHostConstants._AppSetting.getVersion());
    paramString.append("/");
    paramString.append("qcircle-plugin.jpg".replace(".jpg", ".zip"));
    this.f = paramString.toString();
    paramString = new StringBuilder();
    paramString.append(QCircleBasePluginParse.b);
    paramString.append(QCircleHostConstants._AppSetting.getVersion());
    paramString.append("/");
    paramString.append("qcircle-pluginmanager.jpg".replace(".jpg", ".apk"));
    this.g = paramString.toString();
  }
  
  private Map<String, String> a()
  {
    Object localObject1 = b();
    if (localObject1 != null)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset# getAssetFileName with pluginInfoXml");
      return localObject1;
    }
    for (;;)
    {
      int j;
      try
      {
        long l = System.currentTimeMillis();
        localObject1 = MobileQQ.sMobileQQ.getAssets().list("qqcircle");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parsetAsset# assets list cost:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject2).toString());
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          localObject2 = new HashMap();
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          int k = localObject1.length;
          j = 0;
          if (j < k)
          {
            String str = localObject1[j];
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("file");
            localStringBuilder.append(str);
            QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
            boolean bool = str.contains("qcircle-pluginmanager");
            if ((bool) && (str.endsWith(".jpg"))) {
              localArrayList1.add(str);
            } else if ((str.contains("qcircle-plugin")) && (str.endsWith(".jpg"))) {
              localArrayList2.add(str);
            }
          }
          else
          {
            a(localArrayList1, "qcircle-pluginmanager");
            a(localArrayList2, "qcircle-plugin");
            if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
            {
              ((Map)localObject2).put("qcircle-pluginmanager", localArrayList1.get(0));
              ((Map)localObject2).put("qcircle-plugin", localArrayList2.get(0));
              return localObject2;
            }
            QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:asset empty list");
            return null;
          }
        }
        else
        {
          QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:can not list file");
          return null;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseAsset#exception:");
        ((StringBuilder)localObject2).append(localIOException.toString());
        QLog.e("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject2).toString());
        return null;
      }
      j += 1;
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
        String str = (String)localIterator.next();
        Object localObject = str.substring(paramString.length(), str.indexOf(".jpg"));
        paramList = (List<String>)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramList = "0";
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseAsset#");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(paramList);
        QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
    catch (Exception paramList)
    {
      paramString = new StringBuilder();
      paramString.append("parseAsset#sort exception:");
      paramString.append(paramList.toString());
      QLog.i("QCIRCLE_PLUGIN", 1, paramString.toString());
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0);
    if (paramBoolean) {
      str = "qcircle-plugin";
    } else {
      str = "qcircle-pluginmanager";
    }
    String str = ((SharedPreferences)localObject).getString(str, "");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseAsset#checkAssetFileUpdate :");
    ((StringBuilder)localObject).append(paramString.equals(str) ^ true);
    ((StringBuilder)localObject).append(" ,isZip:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
    return paramString.equals(str) ^ true;
  }
  
  private boolean a(Map<String, String> paramMap)
  {
    this.h = ((String)paramMap.get("qcircle-plugin"));
    this.i = ((String)paramMap.get("qcircle-pluginmanager"));
    paramMap = this.h;
    boolean bool2 = true;
    boolean bool3 = a(paramMap, true);
    boolean bool4 = a(this.i, false);
    int j;
    if ((((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(this.f)) && (((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(this.g))) {
      j = 0;
    } else {
      j = 1;
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!bool4)
      {
        if (j != 0) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private QCircleSampleInfo b()
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:no asset info");
      return null;
    }
    StringBuilder localStringBuilder;
    if (!a((Map)localObject))
    {
      localObject = new File(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip.a("", new File(this.f)), "config.json").getAbsolutePath();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseAsset#:current file asset has unzip already,version:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("configPath:");
      localStringBuilder.append((String)localObject);
      QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
      return a((String)localObject, this.f, this.g, "");
    }
    if (!a())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseAsset#:copy asset plugin fail");
      return null;
    }
    localObject = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip;
    localObject = QCircleUnZip.a(new File(this.f));
    boolean bool = a((String)localObject, this.f, "parseAsset#");
    localObject = new File(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip.a((String)localObject, new File(this.f)), "config.json").getAbsolutePath();
    if (bool)
    {
      a(this.h, this.i);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseAsset#:unZip asset plugin success\n");
      localStringBuilder.append((String)localObject);
      QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    }
    return a((String)localObject, this.f, this.g, "");
  }
  
  /* Error */
  private Map<String, String> b()
  {
    // Byte code:
    //   0: getstatic 84	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   3: invokevirtual 88	mqq/app/MobileQQ:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc_w 339
    //   9: invokevirtual 343	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_2
    //   13: aload_2
    //   14: astore_1
    //   15: aload_0
    //   16: aload_2
    //   17: invokevirtual 346	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleAssetPluginParse:a	(Ljava/io/InputStream;)Ljava/util/HashMap;
    //   20: astore_3
    //   21: aload_0
    //   22: aload_2
    //   23: invokevirtual 349	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleAssetPluginParse:a	(Ljava/io/InputStream;)V
    //   26: aload_3
    //   27: areturn
    //   28: astore_3
    //   29: goto +12 -> 41
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_2
    //   35: goto +72 -> 107
    //   38: astore_3
    //   39: aconst_null
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   47: aload_2
    //   48: astore_1
    //   49: new 15	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   56: astore 4
    //   58: aload_2
    //   59: astore_1
    //   60: aload 4
    //   62: ldc_w 352
    //   65: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: astore_1
    //   71: aload 4
    //   73: aload_3
    //   74: invokevirtual 355	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_2
    //   82: astore_1
    //   83: ldc 65
    //   85: iconst_1
    //   86: aload 4
    //   88: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: aload_3
    //   92: invokestatic 358	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_0
    //   96: aload_2
    //   97: invokevirtual 349	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleAssetPluginParse:a	(Ljava/io/InputStream;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_3
    //   103: aload_1
    //   104: astore_2
    //   105: aload_3
    //   106: astore_1
    //   107: aload_0
    //   108: aload_2
    //   109: invokevirtual 349	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleAssetPluginParse:a	(Ljava/io/InputStream;)V
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	QCircleAssetPluginParse
    //   14	1	1	localObject1	Object
    //   32	1	1	localObject2	Object
    //   42	71	1	localObject3	Object
    //   12	97	2	localObject4	Object
    //   20	7	3	localHashMap	HashMap
    //   28	1	3	localException1	Exception
    //   38	54	3	localException2	Exception
    //   102	4	3	localObject5	Object
    //   56	31	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	21	28	java/lang/Exception
    //   0	13	32	finally
    //   0	13	38	java/lang/Exception
    //   15	21	102	finally
    //   43	47	102	finally
    //   49	58	102	finally
    //   60	69	102	finally
    //   71	81	102	finally
    //   83	95	102	finally
  }
  
  public QCircleSampleInfo a()
  {
    return b();
  }
  
  protected QCircleSampleInfo a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = a(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = a((String)localObject);
    if (localObject != null)
    {
      ((QCircleSampleInfo)localObject).a(paramString2);
      ((QCircleSampleInfo)localObject).d(this.e);
      ((QCircleSampleInfo)localObject).b(paramString3);
      ((QCircleSampleInfo)localObject).e(paramString4);
      ((QCircleSampleInfo)localObject).c(paramString1);
    }
    return localObject;
  }
  
  /* Error */
  protected boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 224	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +415 -> 419
    //   7: aload_2
    //   8: invokestatic 224	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 291	java/io/File
    //   19: dup
    //   20: aload_2
    //   21: invokespecial 297	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 384	java/io/File:exists	()Z
    //   31: ifeq +9 -> 40
    //   34: aload 8
    //   36: invokevirtual 386	java/io/File:delete	()Z
    //   39: pop
    //   40: new 15	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   47: astore 6
    //   49: aload 6
    //   51: aload_2
    //   52: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 6
    //   58: ldc_w 388
    //   61: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: new 291	java/io/File
    //   68: dup
    //   69: aload 6
    //   71: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 297	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 9
    //   79: aconst_null
    //   80: astore 6
    //   82: aconst_null
    //   83: astore_2
    //   84: aload 9
    //   86: invokevirtual 384	java/io/File:exists	()Z
    //   89: ifeq +9 -> 98
    //   92: aload 9
    //   94: invokevirtual 386	java/io/File:delete	()Z
    //   97: pop
    //   98: ldc 238
    //   100: invokestatic 244	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   103: checkcast 238	com/tencent/mobileqq/qqcommon/api/IFileUtilsApi
    //   106: aload 9
    //   108: invokevirtual 310	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: invokeinterface 391 2 0
    //   116: getstatic 84	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   119: invokevirtual 88	mqq/app/MobileQQ:getAssets	()Landroid/content/res/AssetManager;
    //   122: astore 7
    //   124: new 15	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   131: astore 10
    //   133: aload 10
    //   135: ldc_w 393
    //   138: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 10
    //   144: aload_1
    //   145: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 7
    //   151: aload 10
    //   153: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 343	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   159: astore_1
    //   160: new 395	java/io/FileOutputStream
    //   163: dup
    //   164: aload 9
    //   166: invokespecial 398	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   169: astore_2
    //   170: sipush 8192
    //   173: newarray byte
    //   175: astore 6
    //   177: aload_1
    //   178: aload 6
    //   180: invokevirtual 404	java/io/InputStream:read	([B)I
    //   183: istore_3
    //   184: iload_3
    //   185: iconst_m1
    //   186: if_icmpeq +14 -> 200
    //   189: aload_2
    //   190: aload 6
    //   192: iconst_0
    //   193: iload_3
    //   194: invokevirtual 410	java/io/OutputStream:write	([BII)V
    //   197: goto -20 -> 177
    //   200: aload_1
    //   201: invokestatic 416	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   204: aload_2
    //   205: astore_1
    //   206: goto +109 -> 315
    //   209: astore 7
    //   211: aload_1
    //   212: astore 6
    //   214: aload_2
    //   215: astore_1
    //   216: aload 7
    //   218: astore_2
    //   219: goto +189 -> 408
    //   222: astore 6
    //   224: aload_1
    //   225: astore 7
    //   227: aload_2
    //   228: astore_1
    //   229: aload 7
    //   231: astore_2
    //   232: goto +39 -> 271
    //   235: astore_2
    //   236: aconst_null
    //   237: astore 7
    //   239: aload_1
    //   240: astore 6
    //   242: aload 7
    //   244: astore_1
    //   245: goto +163 -> 408
    //   248: astore 6
    //   250: aconst_null
    //   251: astore 7
    //   253: aload_1
    //   254: astore_2
    //   255: aload 7
    //   257: astore_1
    //   258: goto +13 -> 271
    //   261: astore_2
    //   262: aconst_null
    //   263: astore_1
    //   264: goto +144 -> 408
    //   267: astore 6
    //   269: aconst_null
    //   270: astore_1
    //   271: new 15	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   278: astore 7
    //   280: aload 7
    //   282: ldc_w 418
    //   285: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 7
    //   291: aload 6
    //   293: invokevirtual 233	java/lang/Exception:toString	()Ljava/lang/String;
    //   296: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: ldc 65
    //   302: iconst_1
    //   303: aload 7
    //   305: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: aload_2
    //   312: invokestatic 416	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   315: aload_1
    //   316: invokestatic 416	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   319: aload 8
    //   321: invokevirtual 384	java/io/File:exists	()Z
    //   324: ifeq +13 -> 337
    //   327: aload 8
    //   329: invokevirtual 386	java/io/File:delete	()Z
    //   332: istore 4
    //   334: goto +6 -> 340
    //   337: iconst_1
    //   338: istore 4
    //   340: aload 9
    //   342: aload 8
    //   344: invokevirtual 422	java/io/File:renameTo	(Ljava/io/File;)Z
    //   347: istore 5
    //   349: new 15	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   356: astore_1
    //   357: aload_1
    //   358: ldc_w 424
    //   361: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload_1
    //   366: iload 5
    //   368: invokevirtual 270	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_1
    //   373: ldc_w 426
    //   376: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: iload 4
    //   383: invokevirtual 270	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: ldc 65
    //   389: iconst_1
    //   390: aload_1
    //   391: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: iload 5
    //   399: ireturn
    //   400: astore 7
    //   402: aload_2
    //   403: astore 6
    //   405: aload 7
    //   407: astore_2
    //   408: aload 6
    //   410: invokestatic 416	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   413: aload_1
    //   414: invokestatic 416	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   417: aload_2
    //   418: athrow
    //   419: iconst_0
    //   420: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	QCircleAssetPluginParse
    //   0	421	1	paramString1	String
    //   0	421	2	paramString2	String
    //   183	11	3	j	int
    //   332	50	4	bool1	boolean
    //   347	51	5	bool2	boolean
    //   47	166	6	localObject1	Object
    //   222	1	6	localException1	Exception
    //   240	1	6	str1	String
    //   248	1	6	localException2	Exception
    //   267	25	6	localException3	Exception
    //   403	6	6	str2	String
    //   122	28	7	localAssetManager	AssetManager
    //   209	8	7	localObject2	Object
    //   225	79	7	localObject3	Object
    //   400	6	7	localObject4	Object
    //   24	319	8	localFile1	File
    //   77	264	9	localFile2	File
    //   131	21	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   170	177	209	finally
    //   177	184	209	finally
    //   189	197	209	finally
    //   170	177	222	java/lang/Exception
    //   177	184	222	java/lang/Exception
    //   189	197	222	java/lang/Exception
    //   160	170	235	finally
    //   160	170	248	java/lang/Exception
    //   84	98	261	finally
    //   98	160	261	finally
    //   84	98	267	java/lang/Exception
    //   98	160	267	java/lang/Exception
    //   271	311	400	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleAssetPluginParse
 * JD-Core Version:    0.7.0.1
 */