package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import android.os.Environment;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.file.ReadFile;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.file.ReadSdcardFile;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RealTimeStyleLoaderHelper
{
  private static String jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/pddata/" + "proteus/");
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  
  public RealTimeStyleLoaderHelper(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
  }
  
  /* Error */
  private File a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 60
    //   2: iconst_1
    //   3: new 14	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   10: ldc 62
    //   12: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_2
    //   16: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: new 25	java/io/File
    //   28: dup
    //   29: new 14	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: invokespecial 69	com/tencent/biz/pubaccount/readinjoy/view/proteus/realtime/RealTimeStyleLoaderHelper:a	()Ljava/lang/String;
    //   40: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 71
    //   45: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_2
    //   49: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 6
    //   60: aload 6
    //   62: invokevirtual 77	java/io/File:getParentFile	()Ljava/io/File;
    //   65: invokestatic 82	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/FileUtils:a	(Ljava/io/File;)Z
    //   68: pop
    //   69: aload 6
    //   71: invokevirtual 86	java/io/File:exists	()Z
    //   74: ifne +11 -> 85
    //   77: aload 6
    //   79: invokevirtual 89	java/io/File:isDirectory	()Z
    //   82: ifeq +8 -> 90
    //   85: aload 6
    //   87: invokevirtual 92	java/io/File:deleteOnExit	()V
    //   90: new 94	java/io/BufferedOutputStream
    //   93: dup
    //   94: new 96	java/io/FileOutputStream
    //   97: dup
    //   98: aload 6
    //   100: invokespecial 99	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: invokespecial 102	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   106: astore_3
    //   107: new 104	java/io/ByteArrayInputStream
    //   110: dup
    //   111: aload_1
    //   112: invokevirtual 110	java/lang/String:getBytes	()[B
    //   115: invokespecial 113	java/io/ByteArrayInputStream:<init>	([B)V
    //   118: astore_1
    //   119: aload_1
    //   120: astore 5
    //   122: aload_3
    //   123: astore 4
    //   125: aload_1
    //   126: aload_3
    //   127: invokestatic 116	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/FileUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   130: pop2
    //   131: aload_1
    //   132: invokestatic 119	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   135: aload_3
    //   136: invokestatic 119	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   139: aload 6
    //   141: areturn
    //   142: astore 6
    //   144: aconst_null
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_3
    //   148: aload_1
    //   149: astore 5
    //   151: aload_3
    //   152: astore 4
    //   154: ldc 60
    //   156: iconst_1
    //   157: new 14	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   164: ldc 121
    //   166: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_2
    //   170: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: aload 6
    //   178: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_1
    //   182: invokestatic 119	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   185: aload_3
    //   186: invokestatic 119	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_1
    //   192: aconst_null
    //   193: astore 5
    //   195: aconst_null
    //   196: astore_3
    //   197: aload 5
    //   199: invokestatic 119	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   202: aload_3
    //   203: invokestatic 119	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: aconst_null
    //   210: astore 5
    //   212: goto -15 -> 197
    //   215: astore_1
    //   216: aload 4
    //   218: astore_3
    //   219: goto -22 -> 197
    //   222: astore 6
    //   224: aconst_null
    //   225: astore_1
    //   226: goto -78 -> 148
    //   229: astore 6
    //   231: goto -83 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	RealTimeStyleLoaderHelper
    //   0	234	1	paramString1	String
    //   0	234	2	paramString2	String
    //   106	113	3	localObject1	Object
    //   123	94	4	localObject2	Object
    //   120	91	5	str	String
    //   58	82	6	localFile	File
    //   142	35	6	localException1	Exception
    //   222	1	6	localException2	Exception
    //   229	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   90	107	142	java/lang/Exception
    //   90	107	191	finally
    //   107	119	208	finally
    //   125	131	215	finally
    //   154	181	215	finally
    //   107	119	222	java/lang/Exception
    //   125	131	229	java/lang/Exception
  }
  
  private String a()
  {
    return jdField_a_of_type_JavaLangString + ReadInJoyUtils.a() + "/" + this.c + "/" + "styles";
  }
  
  private boolean a()
  {
    if (this.d == null) {}
    while (!this.d.equals(ReadInJoyUtils.a())) {
      return true;
    }
    return false;
  }
  
  public RealTimeTemplateFactory a()
  {
    return a(true);
  }
  
  public RealTimeTemplateFactory a(boolean paramBoolean)
  {
    Object localObject3;
    Object localObject1;
    if ((paramBoolean) && (this.jdField_a_of_type_Boolean) && (!a()))
    {
      localObject3 = RealTimeTemplateFactory.a(this.jdField_b_of_type_JavaLangString, false);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (!this.jdField_b_of_type_Boolean) {}
      }
    }
    else
    {
      this.d = ReadInJoyUtils.a();
      localObject1 = new RealTimeTemplateFactory();
      ((RealTimeTemplateFactory)localObject1).a(StyleLoaderHelper.a());
      ((RealTimeTemplateFactory)localObject1).b(this.jdField_b_of_type_JavaLangString);
      ((RealTimeTemplateFactory)localObject1).a(3);
      l = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          localObject3 = new ReadSdcardFile(a());
          localObject4 = ((ReadFile)localObject3).a();
          if (localObject4 == null) {
            continue;
          }
          localIterator = ((List)localObject4).iterator();
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject4;
          Iterator localIterator;
          QLog.e("RealTimeTemplateFactory", 1, "tryLoadTemplateFromOfflineDir: oom ", localOutOfMemoryError);
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Boolean = true;
          RealTimeTemplateFactory localRealTimeTemplateFactory = null;
          return localRealTimeTemplateFactory;
          Object localObject5 = OfflineUtils.a((InputStream)localObject5);
          a(localRealTimeTemplateFactory, new JSONObject((String)localObject5), false);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RealTimeTemplateFactory", 1, "加载样式 file: " + (String)localObject4 + "  realTimeStyle: " + (String)localObject5);
          continue;
        }
        catch (Exception localException)
        {
          QLog.e("RealTimeTemplateFactory", 1, "tryLoadTemplateFromOfflineDir:", localException);
          this.jdField_b_of_type_Boolean = false;
          return null;
          QLog.d("RealTimeTemplateFactory", 2, "tryLoadTemplateFromOfflineDir: spent " + (System.currentTimeMillis() - l));
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_Boolean = true;
          QLog.d("RealTimeTemplateFactory", 1, "tryLoadTemplateFromOfflineDir: successfully");
          return localException;
          QLog.d("RealTimeTemplateFactory", 1, "tryLoadTemplateFromOfflineDir: styles folder is empty");
          return null;
        }
        finally
        {
          this.jdField_a_of_type_Boolean = true;
        }
        if (localIterator.hasNext())
        {
          localObject4 = (String)localIterator.next();
          try
          {
            QLog.d("RealTimeTemplateFactory", 1, "加载样式 file: " + (String)localObject4);
            localObject5 = ((ReadFile)localObject3).a((String)localObject4);
            if (localObject5 == null) {
              QLog.d("RealTimeTemplateFactory", 2, "加载样式 readStylesFile == null file: " + (String)localObject4);
            }
          }
          catch (JSONException localJSONException)
          {
            QLog.e("RealTimeTemplateFactory", 1, "tryLoadTemplateFromOfflineDir: 该文件不符合Json格式,请检查 " + (String)localObject4, localJSONException);
            throw localJSONException;
          }
        }
      }
    }
  }
  
  public void a(RealTimeTemplateFactory paramRealTimeTemplateFactory, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {}
    String str1;
    do
    {
      return;
      ProteusParser localProteusParser = new ProteusParser();
      str1 = paramJSONObject.getString("id");
      String str2 = paramJSONObject.getString("version");
      JSONObject localJSONObject = paramJSONObject.getJSONObject("style");
      paramRealTimeTemplateFactory.a(str1, str2, (String)localJSONObject.keys().next());
      localProteusParser.createViewTemplate(paramRealTimeTemplateFactory, localJSONObject, null);
    } while ((!paramBoolean) || (str1 == null));
    a(paramJSONObject.toString(), str1);
  }
  
  public void a(List<String> paramList)
  {
    ThreadManager.executeOnFileThread(new RealTimeStyleLoaderHelper.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeStyleLoaderHelper
 * JD-Core Version:    0.7.0.1
 */