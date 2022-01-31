package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.AssetsComplementFileStringLoader;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.OfflineComplementFileStringLoader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import mpq;
import mpr;
import mps;
import org.json.JSONException;

public class OfflineUtils
{
  private static AsyncBack jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = new mpq();
  private static volatile TemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory;
  private static String jdField_a_of_type_JavaLangString = "2937";
  private static volatile boolean jdField_a_of_type_Boolean = true;
  
  /* Error */
  public static String a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 35	java/io/BufferedReader
    //   3: dup
    //   4: new 37	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 40	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 43	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 45	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 49	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +30 -> 60
    //   33: aload_1
    //   34: aload_3
    //   35: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: goto -15 -> 24
    //   42: astore_2
    //   43: ldc 55
    //   45: iconst_2
    //   46: ldc 57
    //   48: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: invokevirtual 68	java/io/InputStream:close	()V
    //   55: aload_1
    //   56: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: areturn
    //   60: aload_0
    //   61: invokevirtual 68	java/io/InputStream:close	()V
    //   64: goto -9 -> 55
    //   67: astore_0
    //   68: goto -13 -> 55
    //   71: astore_1
    //   72: ldc 55
    //   74: iconst_2
    //   75: ldc 73
    //   77: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: invokevirtual 68	java/io/InputStream:close	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aload_0
    //   91: invokevirtual 68	java/io/InputStream:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: astore_0
    //   97: goto -42 -> 55
    //   100: astore_0
    //   101: goto -7 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramInputStream	InputStream
    //   23	33	1	localStringBuilder	java.lang.StringBuilder
    //   71	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   89	6	1	localObject	Object
    //   15	10	2	localBufferedReader	java.io.BufferedReader
    //   42	1	2	localIOException	IOException
    //   28	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   24	29	42	java/io/IOException
    //   33	39	42	java/io/IOException
    //   60	64	67	java/io/IOException
    //   24	29	71	java/lang/OutOfMemoryError
    //   33	39	71	java/lang/OutOfMemoryError
    //   80	84	86	java/io/IOException
    //   24	29	89	finally
    //   33	39	89	finally
    //   43	51	89	finally
    //   72	80	89	finally
    //   51	55	96	java/io/IOException
    //   90	94	100	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    String str = OfflineEnvHelper.a(jdField_a_of_type_JavaLangString);
    if (str == null) {
      QLog.d("OfflineUtils", 2, "tryGetImagePathFromOfflineDir: offline root dir is null");
    }
    do
    {
      return null;
      paramString = str + jdField_a_of_type_JavaLangString + "/" + paramString;
    } while (!new File(paramString).exists());
    return paramString;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaLangString = ReadInJoyHelper.a();
    QLog.d("OfflineUtils", 2, "bid : " + jdField_a_of_type_JavaLangString);
    HtmlOffline.a();
    if (jdField_a_of_type_Boolean)
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory != null) {
        break label66;
      }
      jdField_a_of_type_Boolean = false;
      b();
    }
    for (;;)
    {
      ThreadManager.executeOnFileThread(new mpr());
      return;
      label66:
      TemplateFactory.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory);
    }
  }
  
  private static void b()
  {
    ThreadManager.executeOnFileThread(new mps());
  }
  
  private static boolean b()
  {
    TemplateFactory localTemplateFactory = TemplateFactory.a().b();
    localTemplateFactory.a();
    String str1 = OfflineEnvHelper.a(jdField_a_of_type_JavaLangString);
    QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir:" + str1);
    if (str1 == null)
    {
      QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: offline root dir is null");
      return false;
    }
    String str2 = str1 + jdField_a_of_type_JavaLangString;
    if (!OfflineSecurity.a(str2, jdField_a_of_type_JavaLangString))
    {
      QLog.d("OfflineUtils", 2, "tryReadJsonFromOfflineDir: verification failed");
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        str1 = str2 + "/" + "styles";
        String[] arrayOfString = new File(str1).list();
        if (arrayOfString != null)
        {
          ProteusParser.a(a(new FileInputStream(new File(str2 + "/" + "style_map.geojson"))));
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            str2 = arrayOfString[i];
            if (!str2.endsWith(".geojson")) {
              break label349;
            }
            ProteusParser.a(localTemplateFactory, a(new FileInputStream(new File(str1 + "/" + str2))), new OfflineComplementFileStringLoader(str1));
            break label349;
          }
          jdField_a_of_type_Boolean = true;
          localTemplateFactory.a(jdField_a_of_type_JavaLangString);
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory = localTemplateFactory;
          QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: successfully load template from Offline Dir.");
          return true;
        }
        QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: styles folder is empty");
        return false;
      }
      catch (IOException localIOException)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: fail to read from file");
        localIOException.printStackTrace();
        return false;
      }
      catch (JSONException localJSONException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: fail to parse JSON");
      localJSONException.printStackTrace();
      return false;
      label349:
      i += 1;
    }
  }
  
  private static boolean b(Context paramContext)
  {
    try
    {
      AssetManager localAssetManager = paramContext.getAssets();
      String[] arrayOfString = localAssetManager.list("proteus/styles");
      QLog.d("OfflineUtils", 2, "tryLoadTemplateFromAssets");
      if (arrayOfString != null)
      {
        ProteusParser.a(a(localAssetManager.open("proteus/style_map.geojson")));
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String str = arrayOfString[i];
            boolean bool = str.endsWith(".geojson");
            if (bool) {}
            try
            {
              InputStream localInputStream = localAssetManager.open("proteus/styles" + "/" + str);
              ProteusParser.a(TemplateFactory.a(), a(localInputStream), new AssetsComplementFileStringLoader(paramContext, "proteus/styles"));
              i += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  QLog.d("OfflineUtils", 2, "tryLoadTemplateFromAssets: fail to parse " + str);
                  localJSONException.printStackTrace();
                }
              }
            }
          }
        }
      }
      QLog.d("OfflineUtils", 2, "tryLoadTemplateFromAssets: successfully load templates from Assets Dir");
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OfflineUtils", 2, "tryLoadTemplateFromAssets: fail to read from file");
        paramContext.printStackTrace();
      }
      return false;
      QLog.d("OfflineUtils", 2, "tryLoadTemplateFromAssets: styles folder is empty");
      return false;
    }
    catch (JSONException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("OfflineUtils", 2, "tryLoadTemplateFromAssets: fail to parse JSON");
      paramContext.printStackTrace();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils
 * JD-Core Version:    0.7.0.1
 */