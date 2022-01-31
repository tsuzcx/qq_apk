package com.tencent.biz.qqstory.takevideo.artfilter;

import ajsd;
import aurn;
import ayxs;
import bbdx;
import bbwt;
import bfko;
import bfnk;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import vjs;
import vju;
import vjv;

public class ArtFilterManager
  implements Manager
{
  public static int a;
  public static final String a;
  public static final String b = ajsd.aW + "pddata/prd/picedit/artfilter/";
  private bbwt jdField_a_of_type_Bbwt;
  private bfnk jdField_a_of_type_Bfnk;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<vjs> jdField_a_of_type_JavaUtilList;
  public vju a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajsd.aW + "artfilter/";
  }
  
  /* Error */
  public ArtFilterManager(AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 50	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: new 52	vjw
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 55	vjw:<init>	(Lcom/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager;)V
    //   16: putfield 57	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_Bbwt	Lbbwt;
    //   19: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +11 -> 33
    //   25: ldc 65
    //   27: iconst_2
    //   28: ldc 67
    //   30: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 73	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   38: aload_0
    //   39: new 75	bfnk
    //   42: dup
    //   43: invokestatic 81	com/tencent/mobileqq/app/ThreadManager:getFileThreadLooper	()Landroid/os/Looper;
    //   46: aconst_null
    //   47: invokespecial 84	bfnk:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   50: putfield 86	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_Bfnk	Lbfnk;
    //   53: aload_1
    //   54: invokevirtual 91	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   57: invokestatic 94	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Ljava/lang/String;)Z
    //   60: ifeq +139 -> 199
    //   63: new 96	java/io/File
    //   66: dup
    //   67: new 21	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   74: getstatic 41	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 98
    //   82: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 105	java/io/File:length	()J
    //   96: l2i
    //   97: newarray byte
    //   99: astore 5
    //   101: new 107	java/io/FileInputStream
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   109: astore_2
    //   110: new 112	java/io/BufferedInputStream
    //   113: dup
    //   114: aload_2
    //   115: invokespecial 115	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   118: astore_1
    //   119: aload_1
    //   120: astore 4
    //   122: aload_2
    //   123: astore_3
    //   124: aload_1
    //   125: aload 5
    //   127: invokevirtual 119	java/io/BufferedInputStream:read	([B)I
    //   130: pop
    //   131: aload_1
    //   132: astore 4
    //   134: aload_2
    //   135: astore_3
    //   136: new 121	java/lang/String
    //   139: dup
    //   140: aload 5
    //   142: invokespecial 124	java/lang/String:<init>	([B)V
    //   145: astore 5
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   155: aload 5
    //   157: astore_1
    //   158: aload_2
    //   159: ifnull +10 -> 169
    //   162: aload_2
    //   163: invokevirtual 128	java/io/FileInputStream:close	()V
    //   166: aload 5
    //   168: astore_1
    //   169: aload_0
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual 131	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Ljava/lang/String;)Ljava/util/List;
    //   175: putfield 133	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   178: aload_0
    //   179: getfield 133	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   182: ifnonnull +145 -> 327
    //   185: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +11 -> 199
    //   191: ldc 65
    //   193: iconst_2
    //   194: ldc 135
    //   196: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +11 -> 213
    //   205: ldc 65
    //   207: iconst_2
    //   208: ldc 137
    //   210: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: return
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   219: goto -64 -> 155
    //   222: astore_1
    //   223: aload_1
    //   224: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   227: aload 5
    //   229: astore_1
    //   230: goto -61 -> 169
    //   233: astore 5
    //   235: aconst_null
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_1
    //   240: astore 4
    //   242: aload_2
    //   243: astore_3
    //   244: aload 5
    //   246: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   257: aload_2
    //   258: ifnull +99 -> 357
    //   261: aload_2
    //   262: invokevirtual 128	java/io/FileInputStream:close	()V
    //   265: aconst_null
    //   266: astore_1
    //   267: goto -98 -> 169
    //   270: astore_1
    //   271: aload_1
    //   272: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   275: goto -18 -> 257
    //   278: astore_1
    //   279: aload_1
    //   280: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   283: aconst_null
    //   284: astore_1
    //   285: goto -116 -> 169
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_2
    //   291: aload 4
    //   293: ifnull +8 -> 301
    //   296: aload 4
    //   298: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 128	java/io/FileInputStream:close	()V
    //   309: aload_1
    //   310: athrow
    //   311: astore_3
    //   312: aload_3
    //   313: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   316: goto -15 -> 301
    //   319: astore_2
    //   320: aload_2
    //   321: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   324: goto -15 -> 309
    //   327: aload_0
    //   328: iconst_0
    //   329: invokevirtual 143	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Z)V
    //   332: goto -133 -> 199
    //   335: astore_1
    //   336: goto -45 -> 291
    //   339: astore_1
    //   340: aload_3
    //   341: astore_2
    //   342: goto -51 -> 291
    //   345: astore 5
    //   347: aconst_null
    //   348: astore_1
    //   349: goto -110 -> 239
    //   352: astore 5
    //   354: goto -115 -> 239
    //   357: aconst_null
    //   358: astore_1
    //   359: goto -190 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	ArtFilterManager
    //   0	362	1	paramAppInterface	AppInterface
    //   109	197	2	localFileInputStream1	java.io.FileInputStream
    //   319	2	2	localIOException1	IOException
    //   341	1	2	localObject1	Object
    //   123	121	3	localFileInputStream2	java.io.FileInputStream
    //   311	30	3	localIOException2	IOException
    //   1	296	4	localAppInterface	AppInterface
    //   99	129	5	localObject2	Object
    //   233	12	5	localIOException3	IOException
    //   345	1	5	localIOException4	IOException
    //   352	1	5	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   151	155	214	java/io/IOException
    //   162	166	222	java/io/IOException
    //   63	110	233	java/io/IOException
    //   253	257	270	java/io/IOException
    //   261	265	278	java/io/IOException
    //   63	110	288	finally
    //   296	301	311	java/io/IOException
    //   305	309	319	java/io/IOException
    //   110	119	335	finally
    //   124	131	339	finally
    //   136	147	339	finally
    //   244	249	339	finally
    //   110	119	345	java/io/IOException
    //   124	131	352	java/io/IOException
    //   136	147	352	java/io/IOException
  }
  
  public static int a()
  {
    if (jdField_a_of_type_Int < 640) {
      return 640;
    }
    return jdField_a_of_type_Int;
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    File localFile = new File(paramString2);
    paramString3 = new vjv(this, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString2, paramString1, paramString2, localFile, paramString3);
    boolean bool = ((ayxs)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(193)).a(10015, "prd", paramString1, 0, paramString1, paramString2, 2, 0, true, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "PreDownloadController ret:" + bool);
    }
  }
  
  private void a(List<vjs> paramList, vju paramvju)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "[deleteOldResources] start");
    }
    Object localObject1 = new File(b);
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isDirectory()) {
        break label738;
      }
      if (paramList != null) {
        break label53;
      }
      bbdx.a(b);
    }
    label53:
    do
    {
      return;
      localObject1 = ((File)localObject1).listFiles();
    } while (localObject1 == null);
    int k = localObject1.length;
    int i = 0;
    label72:
    Object localObject2;
    String str;
    int m;
    Object localObject3;
    int n;
    int j;
    vjs localvjs;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!localObject2.isDirectory()) {
        break label680;
      }
      str = localObject2.getName();
      if (str.equals("loading"))
      {
        if (paramvju != null)
        {
          m = paramvju.b;
          str = paramvju.b + ".zip";
          localObject3 = localObject2.listFiles();
          if (localObject3 != null)
          {
            n = localObject3.length;
            j = 0;
            if (j < n)
            {
              localvjs = localObject3[j];
              if (localvjs.isDirectory()) {
                if (!localvjs.getName().equals(String.valueOf(m)))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old loading dir: " + localObject2.getName() + File.separator + localvjs.getName());
                  }
                  bbdx.a(localvjs.getAbsolutePath());
                }
              }
              for (;;)
              {
                j += 1;
                break;
                if (!localvjs.getName().equals(str))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old loading file: " + localObject2.getName() + File.separator + localvjs.getName());
                  }
                  localvjs.delete();
                }
              }
            }
          }
        }
      }
      else {
        if (!str.equals("artfiltertemp")) {
          break label355;
        }
      }
    }
    label355:
    label764:
    for (;;)
    {
      i += 1;
      break label72;
      break;
      localObject3 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localvjs = (vjs)((Iterator)localObject3).next();
          if (str.equals(localvjs.c))
          {
            m = localvjs.jdField_a_of_type_Int;
            str = localvjs.jdField_a_of_type_Int + ".zip";
            localObject3 = localObject2.listFiles();
            if (localObject3 != null)
            {
              n = localObject3.length;
              j = 0;
              if (j < n)
              {
                localvjs = localObject3[j];
                if (localvjs.isDirectory()) {
                  if (!localvjs.getName().equals(String.valueOf(m)))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old dir: " + localObject2.getName() + File.separator + localvjs.getName());
                    }
                    bbdx.a(localvjs.getAbsolutePath());
                  }
                }
                for (;;)
                {
                  j += 1;
                  break;
                  if (!localvjs.getName().equals(str))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old file: " + localObject2.getName() + File.separator + localvjs.getName());
                    }
                    localvjs.delete();
                  }
                }
              }
            }
          }
        }
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label764;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old dir: " + localObject2.getName());
        }
        bbdx.a(localObject2.getAbsolutePath());
        break;
        if (localObject2.getName().endsWith("artfilter.config")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete error file: " + localObject2.getName());
        }
        localObject2.delete();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete photo plus root directory");
        }
        ((File)localObject1).delete();
        return;
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    return new File(jdField_a_of_type_JavaLangString + "artfilter.config").exists();
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Vju != null) {
      return this.jdField_a_of_type_Vju.a();
    }
    return null;
  }
  
  public String a(String paramString)
  {
    try
    {
      str1 = aurn.a(paramString);
      paramString = str1;
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str1;
      paramString = new File(paramString);
      bool = paramString.exists();
      if (!bool) {
        break label81;
      }
      for (;;)
      {
        try
        {
          paramString = bfko.a(paramString);
          if (paramString == null) {
            continue;
          }
        }
        catch (IOException paramString)
        {
          paramString = null;
          continue;
        }
        str2 = paramString;
        if (paramString != null) {
          break;
        }
        return "";
        paramString = "";
      }
    }
    finally
    {
      if (0 != 0) {
        break label79;
      }
      return "";
      label79:
      return null;
    }
    return str1;
    for (;;)
    {
      boolean bool;
      String str2;
      label81:
      paramString = null;
    }
  }
  
  public List<vjs> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public List<vjs> a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      Object localObject = paramString.getString("artisticFilter_switch");
      if ((localObject != null) && (((String)localObject).equals("1"))) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (!this.jdField_a_of_type_Boolean) {
        return null;
      }
      this.jdField_a_of_type_Vju = vju.a(paramString.getJSONObject("artisticFilter_loading"));
      jdField_a_of_type_Int = Integer.parseInt(paramString.getString("artisticFilter_maxside"));
      paramString = paramString.getJSONArray("artisticFilter_templates");
      localObject = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        ((List)localObject).add(new vjs(localJSONObject.getString("id"), localJSONObject.getInt("version"), localJSONObject.getInt("priority"), localJSONObject.getString("url"), localJSONObject.getString("name"), localJSONObject.optString("md5"), localJSONObject.optString("pron")));
        i += 1;
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
  }
  
  public void a(String paramString)
  {
    String str = paramString.substring(0, paramString.indexOf(".zip")) + File.separator;
    try
    {
      bbdx.a(paramString, str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterManager", 2, "[unzip] success: " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArtFilterManager", 2, "[unzip]", paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "[updateFilterResource] isDelete=" + paramBoolean);
    }
    this.jdField_a_of_type_Bfnk.post(new ArtFilterManager.UpdateTask(this, this.jdField_a_of_type_JavaUtilList, paramBoolean, this.jdField_a_of_type_Vju));
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bfnk != null)
    {
      this.jdField_a_of_type_Bfnk.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bfnk = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager
 * JD-Core Version:    0.7.0.1
 */