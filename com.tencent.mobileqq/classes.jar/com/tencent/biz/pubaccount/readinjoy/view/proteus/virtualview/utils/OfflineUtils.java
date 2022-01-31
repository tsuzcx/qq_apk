package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.OfflineComplementFileStringLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import mqx;
import mqy;
import mqz;
import org.json.JSONException;

public class OfflineUtils
{
  private static AsyncBack jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = new mqx();
  private static volatile TemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory;
  private static String jdField_a_of_type_JavaLangString = "0";
  private static volatile boolean jdField_a_of_type_Boolean;
  private static String b = "2937";
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public static String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 40	java/io/BufferedReader
    //   3: dup
    //   4: new 42	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 45	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 48	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 50	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 54	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +30 -> 60
    //   33: aload_1
    //   34: aload_3
    //   35: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: goto -15 -> 24
    //   42: astore_2
    //   43: ldc 60
    //   45: iconst_2
    //   46: ldc 62
    //   48: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: invokevirtual 73	java/io/InputStream:close	()V
    //   55: aload_1
    //   56: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: areturn
    //   60: aload_0
    //   61: invokevirtual 73	java/io/InputStream:close	()V
    //   64: goto -9 -> 55
    //   67: astore_0
    //   68: goto -13 -> 55
    //   71: astore_1
    //   72: ldc 60
    //   74: iconst_2
    //   75: ldc 78
    //   77: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: invokevirtual 73	java/io/InputStream:close	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aload_0
    //   91: invokevirtual 73	java/io/InputStream:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: astore_0
    //   97: goto -42 -> 55
    //   100: astore_0
    //   101: goto -7 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramInputStream	java.io.InputStream
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
    String str = OfflineEnvHelper.a(b);
    if (str == null) {
      QLog.d("OfflineUtils", 2, "tryGetImagePathFromOfflineDir: offline root dir is null");
    }
    do
    {
      return null;
      paramString = str + b + "/" + paramString;
    } while (!new File(paramString).exists());
    return paramString;
  }
  
  public static void a()
  {
    b = ReadInJoyHelper.a();
    QLog.d("OfflineUtils", 2, "bid : " + b);
    HtmlOffline.a();
    ThreadManager.executeOnFileThread(new mqy());
  }
  
  /* Error */
  private static boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   6: lstore_3
    //   7: invokestatic 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   10: invokevirtual 133	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:b	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   13: astore 6
    //   15: aload 6
    //   17: invokevirtual 134	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	()V
    //   20: aload_0
    //   21: invokevirtual 140	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   24: astore 7
    //   26: aload 7
    //   28: ldc 142
    //   30: invokevirtual 148	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore 8
    //   35: ldc 60
    //   37: iconst_2
    //   38: ldc 150
    //   40: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload 8
    //   45: ifnull +224 -> 269
    //   48: aload 7
    //   50: ldc 152
    //   52: invokevirtual 156	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   55: invokestatic 158	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/OfflineUtils:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   58: invokestatic 162	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:a	(Ljava/lang/String;)V
    //   61: aload 8
    //   63: arraylength
    //   64: istore_2
    //   65: iconst_0
    //   66: istore_1
    //   67: iload_1
    //   68: iload_2
    //   69: if_icmpge +148 -> 217
    //   72: aload 8
    //   74: iload_1
    //   75: aaload
    //   76: astore 9
    //   78: aload 9
    //   80: ldc 164
    //   82: invokevirtual 170	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   85: istore 5
    //   87: iload 5
    //   89: ifeq +51 -> 140
    //   92: aload 6
    //   94: aload 7
    //   96: new 50	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   103: ldc 142
    //   105: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 87
    //   110: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 9
    //   115: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokevirtual 156	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   124: invokestatic 158	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/OfflineUtils:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   127: new 172	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/AssetsComplementFileStringLoader
    //   130: dup
    //   131: aload_0
    //   132: ldc 142
    //   134: invokespecial 175	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/AssetsComplementFileStringLoader:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   137: invokestatic 178	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   140: iload_1
    //   141: iconst_1
    //   142: iadd
    //   143: istore_1
    //   144: goto -77 -> 67
    //   147: astore 10
    //   149: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq -12 -> 140
    //   155: ldc 60
    //   157: iconst_2
    //   158: new 50	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   165: ldc 183
    //   167: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 9
    //   172: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload 10
    //   183: invokevirtual 186	org/json/JSONException:printStackTrace	()V
    //   186: goto -46 -> 140
    //   189: astore_0
    //   190: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +15 -> 208
    //   196: ldc 60
    //   198: iconst_2
    //   199: ldc 188
    //   201: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_0
    //   205: invokevirtual 189	java/io/IOException:printStackTrace	()V
    //   208: iconst_0
    //   209: istore 5
    //   211: ldc 2
    //   213: monitorexit
    //   214: iload 5
    //   216: ireturn
    //   217: iconst_1
    //   218: putstatic 22	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/OfflineUtils:jdField_a_of_type_Boolean	Z
    //   221: aload 6
    //   223: getstatic 16	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/OfflineUtils:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   226: invokevirtual 190	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	(Ljava/lang/String;)V
    //   229: aload 6
    //   231: putstatic 192	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/OfflineUtils:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   234: ldc 60
    //   236: iconst_2
    //   237: new 50	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   244: ldc 194
    //   246: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   252: lload_3
    //   253: lsub
    //   254: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   257: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: iconst_1
    //   264: istore 5
    //   266: goto -55 -> 211
    //   269: ldc 60
    //   271: iconst_2
    //   272: ldc 199
    //   274: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: iconst_0
    //   278: istore 5
    //   280: goto -69 -> 211
    //   283: astore_0
    //   284: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +15 -> 302
    //   290: ldc 60
    //   292: iconst_2
    //   293: ldc 201
    //   295: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload_0
    //   299: invokevirtual 186	org/json/JSONException:printStackTrace	()V
    //   302: iconst_0
    //   303: istore 5
    //   305: goto -94 -> 211
    //   308: astore_0
    //   309: ldc 2
    //   311: monitorexit
    //   312: aload_0
    //   313: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramContext	android.content.Context
    //   66	78	1	i	int
    //   64	6	2	j	int
    //   6	247	3	l	long
    //   85	219	5	bool	boolean
    //   13	217	6	localTemplateFactory	TemplateFactory
    //   24	71	7	localAssetManager	android.content.res.AssetManager
    //   33	40	8	arrayOfString	String[]
    //   76	95	9	str	String
    //   147	35	10	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   92	140	147	org/json/JSONException
    //   7	43	189	java/io/IOException
    //   48	65	189	java/io/IOException
    //   78	87	189	java/io/IOException
    //   92	140	189	java/io/IOException
    //   149	186	189	java/io/IOException
    //   217	234	189	java/io/IOException
    //   269	277	189	java/io/IOException
    //   7	43	283	org/json/JSONException
    //   48	65	283	org/json/JSONException
    //   78	87	283	org/json/JSONException
    //   149	186	283	org/json/JSONException
    //   217	234	283	org/json/JSONException
    //   269	277	283	org/json/JSONException
    //   3	7	308	finally
    //   7	43	308	finally
    //   48	65	308	finally
    //   78	87	308	finally
    //   92	140	308	finally
    //   149	186	308	finally
    //   190	208	308	finally
    //   217	234	308	finally
    //   234	263	308	finally
    //   269	277	308	finally
    //   284	302	308	finally
  }
  
  public static void b()
  {
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        if (!ReadInJoyHelper.a().equals(b)) {
          jdField_a_of_type_Boolean = true;
        }
        a();
        if (jdField_a_of_type_Boolean)
        {
          if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory == null) {
            e();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("OfflineUtils", 2, "initTemplateFactory  spent: " + (System.currentTimeMillis() - l));
          }
          return;
        }
        if (b.equals(jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory.a())) {
          TemplateFactory.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory);
        } else {
          e();
        }
      }
      finally {}
    }
  }
  
  private static boolean b()
  {
    boolean bool2 = false;
    label443:
    for (;;)
    {
      boolean bool1;
      try
      {
        long l = System.currentTimeMillis();
        TemplateFactory localTemplateFactory1 = TemplateFactory.a().b();
        localTemplateFactory1.a();
        String str1 = OfflineEnvHelper.a(b);
        QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir:" + str1);
        if (str1 == null)
        {
          QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: offline root dir is null");
          bool1 = bool2;
          return bool1;
        }
        String str2 = str1 + b;
        if (!OfflineSecurity.a(str2, b))
        {
          QLog.d("OfflineUtils", 2, "tryReadJsonFromOfflineDir: verification failed");
          bool1 = bool2;
          continue;
        }
        try
        {
          str1 = str2 + "/" + "styles";
          arrayOfString = new File(str1).list();
          if (arrayOfString != null)
          {
            ProteusParser.a(a(new FileInputStream(new File(str2 + "/" + "style_map.geojson"))));
            j = arrayOfString.length;
            i = 0;
            if (i < j)
            {
              str2 = arrayOfString[i];
              if (str2.endsWith(".geojson")) {
                ProteusParser.a(localTemplateFactory2, a(new FileInputStream(new File(str1 + "/" + str2))), new OfflineComplementFileStringLoader(str1));
              }
            }
            else
            {
              jdField_a_of_type_Boolean = true;
              localTemplateFactory2.a(b);
              jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory = localTemplateFactory2;
              QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: spent " + (System.currentTimeMillis() - l));
              QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: successfully load template from Offline Dir.");
              bool1 = true;
            }
          }
          else
          {
            QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: styles folder is empty");
            bool1 = bool2;
          }
        }
        catch (IOException localIOException)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: fail to read from file");
          localIOException.printStackTrace();
          bool1 = bool2;
        }
        catch (JSONException localJSONException)
        {
          bool1 = bool2;
        }
      }
      finally {}
      for (;;)
      {
        String[] arrayOfString;
        int j;
        int i;
        if (!QLog.isColorLevel()) {
          break label443;
        }
        QLog.d("OfflineUtils", 2, "tryLoadTemplateFromOfflineDir: fail to parse JSON");
        localJSONException.printStackTrace();
        bool1 = bool2;
        break;
        i += 1;
      }
    }
  }
  
  public static void c()
  {
    ThreadManager.executeOnFileThread(new mqz());
  }
  
  private static void e()
  {
    jdField_a_of_type_Boolean = false;
    f();
    if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory != null)) {
      TemplateFactory.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory);
    }
    for (;;)
    {
      jdField_a_of_type_Boolean = false;
      return;
      QLog.d("OfflineUtils", 2, "changeTemplateFactory: fail");
    }
  }
  
  private static void f()
  {
    if (!b())
    {
      QLog.d("OfflineUtils", 2, "fail to read from offline dir, fall back to assets styles");
      if (!a(BaseApplicationImpl.getContext())) {
        QLog.d("OfflineUtils", 2, "fail to load from asset folder, fall back to native styles");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils
 * JD-Core Version:    0.7.0.1
 */