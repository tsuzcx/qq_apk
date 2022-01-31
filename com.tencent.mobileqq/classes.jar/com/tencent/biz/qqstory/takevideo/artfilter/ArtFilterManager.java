package com.tencent.biz.qqstory.takevideo.artfilter;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import ogn;
import ogp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ArtFilterManager
  implements Manager
{
  public static int a;
  public static final String a;
  public static final String b = AppConstants.aJ + "pddata/prd/picedit/artfilter/";
  public ArtFilterLoading a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "artfilter/";
  }
  
  /* Error */
  public ArtFilterManager(AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 49	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: new 51	ogo
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 54	ogo:<init>	(Lcom/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager;)V
    //   16: putfield 56	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_ComTencentMobileqqVipDownloadListener	Lcom/tencent/mobileqq/vip/DownloadListener;
    //   19: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +11 -> 33
    //   25: ldc 64
    //   27: iconst_2
    //   28: ldc 66
    //   30: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 72	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   38: aload_0
    //   39: new 74	com/tencent/util/MqqWeakReferenceHandler
    //   42: dup
    //   43: invokestatic 80	com/tencent/mobileqq/app/ThreadManager:getFileThreadLooper	()Landroid/os/Looper;
    //   46: aconst_null
    //   47: invokespecial 83	com/tencent/util/MqqWeakReferenceHandler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   50: putfield 85	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler	Lcom/tencent/util/MqqWeakReferenceHandler;
    //   53: aload_1
    //   54: invokevirtual 90	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   57: invokestatic 93	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:b	(Ljava/lang/String;)Z
    //   60: ifeq +146 -> 206
    //   63: new 95	java/io/File
    //   66: dup
    //   67: new 20	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   74: getstatic 40	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 90	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   84: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 97
    //   89: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 104	java/io/File:length	()J
    //   103: l2i
    //   104: newarray byte
    //   106: astore 5
    //   108: new 106	java/io/FileInputStream
    //   111: dup
    //   112: aload_1
    //   113: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   116: astore_2
    //   117: new 111	java/io/BufferedInputStream
    //   120: dup
    //   121: aload_2
    //   122: invokespecial 114	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   125: astore_1
    //   126: aload_1
    //   127: astore 4
    //   129: aload_2
    //   130: astore_3
    //   131: aload_1
    //   132: aload 5
    //   134: invokevirtual 118	java/io/BufferedInputStream:read	([B)I
    //   137: pop
    //   138: aload_1
    //   139: astore 4
    //   141: aload_2
    //   142: astore_3
    //   143: new 120	java/lang/String
    //   146: dup
    //   147: aload 5
    //   149: invokespecial 123	java/lang/String:<init>	([B)V
    //   152: astore 5
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   162: aload 5
    //   164: astore_1
    //   165: aload_2
    //   166: ifnull +10 -> 176
    //   169: aload_2
    //   170: invokevirtual 127	java/io/FileInputStream:close	()V
    //   173: aload 5
    //   175: astore_1
    //   176: aload_0
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual 130	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Ljava/lang/String;)Ljava/util/List;
    //   182: putfield 132	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   185: aload_0
    //   186: getfield 132	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   189: ifnonnull +145 -> 334
    //   192: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +11 -> 206
    //   198: ldc 64
    //   200: iconst_2
    //   201: ldc 134
    //   203: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +11 -> 220
    //   212: ldc 64
    //   214: iconst_2
    //   215: ldc 136
    //   217: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: return
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   226: goto -64 -> 162
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   234: aload 5
    //   236: astore_1
    //   237: goto -61 -> 176
    //   240: astore 5
    //   242: aconst_null
    //   243: astore_1
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_1
    //   247: astore 4
    //   249: aload_2
    //   250: astore_3
    //   251: aload 5
    //   253: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   264: aload_2
    //   265: ifnull +99 -> 364
    //   268: aload_2
    //   269: invokevirtual 127	java/io/FileInputStream:close	()V
    //   272: aconst_null
    //   273: astore_1
    //   274: goto -98 -> 176
    //   277: astore_1
    //   278: aload_1
    //   279: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   282: goto -18 -> 264
    //   285: astore_1
    //   286: aload_1
    //   287: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   290: aconst_null
    //   291: astore_1
    //   292: goto -116 -> 176
    //   295: astore_1
    //   296: aconst_null
    //   297: astore_2
    //   298: aload 4
    //   300: ifnull +8 -> 308
    //   303: aload 4
    //   305: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 127	java/io/FileInputStream:close	()V
    //   316: aload_1
    //   317: athrow
    //   318: astore_3
    //   319: aload_3
    //   320: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   323: goto -15 -> 308
    //   326: astore_2
    //   327: aload_2
    //   328: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   331: goto -15 -> 316
    //   334: aload_0
    //   335: iconst_0
    //   336: invokevirtual 142	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Z)V
    //   339: goto -133 -> 206
    //   342: astore_1
    //   343: goto -45 -> 298
    //   346: astore_1
    //   347: aload_3
    //   348: astore_2
    //   349: goto -51 -> 298
    //   352: astore 5
    //   354: aconst_null
    //   355: astore_1
    //   356: goto -110 -> 246
    //   359: astore 5
    //   361: goto -115 -> 246
    //   364: aconst_null
    //   365: astore_1
    //   366: goto -190 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	ArtFilterManager
    //   0	369	1	paramAppInterface	AppInterface
    //   116	197	2	localFileInputStream1	java.io.FileInputStream
    //   326	2	2	localIOException1	IOException
    //   348	1	2	localObject1	Object
    //   130	121	3	localFileInputStream2	java.io.FileInputStream
    //   318	30	3	localIOException2	IOException
    //   1	303	4	localAppInterface	AppInterface
    //   106	129	5	localObject2	Object
    //   240	12	5	localIOException3	IOException
    //   352	1	5	localIOException4	IOException
    //   359	1	5	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   158	162	221	java/io/IOException
    //   169	173	229	java/io/IOException
    //   63	117	240	java/io/IOException
    //   260	264	277	java/io/IOException
    //   268	272	285	java/io/IOException
    //   63	117	295	finally
    //   303	308	318	java/io/IOException
    //   312	316	326	java/io/IOException
    //   117	126	342	finally
    //   131	138	346	finally
    //   143	154	346	finally
    //   251	256	346	finally
    //   117	126	352	java/io/IOException
    //   131	138	359	java/io/IOException
    //   143	154	359	java/io/IOException
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
    paramString3 = new ogn(this, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString2, paramString1, paramString2, localFile, paramString3);
    boolean bool = ((PreDownloadController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(192)).a(10015, "prd", paramString1, 0, paramString1, paramString2, 2, 0, true, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "PreDownloadController ret:" + bool);
    }
  }
  
  private void a(List paramList, ArtFilterLoading paramArtFilterLoading)
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
      FileUtils.a(b);
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
    ArtFilter localArtFilter;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!localObject2.isDirectory()) {
        break label680;
      }
      str = localObject2.getName();
      if (str.equals("loading"))
      {
        if (paramArtFilterLoading != null)
        {
          m = paramArtFilterLoading.b;
          str = paramArtFilterLoading.b + ".zip";
          localObject3 = localObject2.listFiles();
          if (localObject3 != null)
          {
            n = localObject3.length;
            j = 0;
            if (j < n)
            {
              localArtFilter = localObject3[j];
              if (localArtFilter.isDirectory()) {
                if (!localArtFilter.getName().equals(String.valueOf(m)))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old loading dir: " + localObject2.getName() + File.separator + localArtFilter.getName());
                  }
                  FileUtils.a(localArtFilter.getAbsolutePath());
                }
              }
              for (;;)
              {
                j += 1;
                break;
                if (!localArtFilter.getName().equals(str))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old loading file: " + localObject2.getName() + File.separator + localArtFilter.getName());
                  }
                  localArtFilter.delete();
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
          localArtFilter = (ArtFilter)((Iterator)localObject3).next();
          if (str.equals(localArtFilter.c))
          {
            m = localArtFilter.jdField_a_of_type_Int;
            str = localArtFilter.jdField_a_of_type_Int + ".zip";
            localObject3 = localObject2.listFiles();
            if (localObject3 != null)
            {
              n = localObject3.length;
              j = 0;
              if (j < n)
              {
                localArtFilter = localObject3[j];
                if (localArtFilter.isDirectory()) {
                  if (!localArtFilter.getName().equals(String.valueOf(m)))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old dir: " + localObject2.getName() + File.separator + localArtFilter.getName());
                    }
                    FileUtils.a(localArtFilter.getAbsolutePath());
                  }
                }
                for (;;)
                {
                  j += 1;
                  break;
                  if (!localArtFilter.getName().equals(str))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ArtFilterManager", 2, "[updateFilterResource] delete old file: " + localObject2.getName() + File.separator + localArtFilter.getName());
                    }
                    localArtFilter.delete();
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
        FileUtils.a(localObject2.getAbsolutePath());
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
  
  public static boolean a(String paramString)
  {
    try
    {
      BaseApplicationImpl.getApplication().getAppRuntime(paramString).getManager(187);
      return b(paramString);
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      for (;;)
      {
        localAccountNotMatchException.printStackTrace();
      }
    }
  }
  
  private static boolean b(String paramString)
  {
    return new File(jdField_a_of_type_JavaLangString + paramString + "artfilter.config").exists();
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterLoading != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterLoading.a();
    }
    return null;
  }
  
  public String a(String paramString)
  {
    try
    {
      str1 = PortalUtils.a(paramString);
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
          paramString = MD5FileUtil.a(paramString);
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
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public List a(String paramString)
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterLoading = ArtFilterLoading.a(paramString.getJSONObject("artisticFilter_loading"));
      jdField_a_of_type_Int = Integer.parseInt(paramString.getString("artisticFilter_maxside"));
      paramString = paramString.getJSONArray("artisticFilter_templates");
      localObject = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        ((List)localObject).add(new ArtFilter(localJSONObject.getString("id"), localJSONObject.getInt("version"), localJSONObject.getInt("priority"), localJSONObject.getString("url"), localJSONObject.getString("name"), localJSONObject.optString("md5"), localJSONObject.optString("pron")));
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
      FileUtils.a(paramString, str, false);
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
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.post(new ogp(this, this.jdField_a_of_type_JavaUtilList, paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterLoading));
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +29 -> 38
    //   12: ldc 64
    //   14: iconst_2
    //   15: new 20	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 411
    //   25: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: new 95	java/io/File
    //   41: dup
    //   42: getstatic 40	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 6
    //   50: aload 6
    //   52: invokevirtual 183	java/io/File:exists	()Z
    //   55: ifne +9 -> 64
    //   58: aload 6
    //   60: invokevirtual 414	java/io/File:mkdir	()Z
    //   63: pop
    //   64: new 95	java/io/File
    //   67: dup
    //   68: new 20	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 40	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_2
    //   82: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 97
    //   87: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore_2
    //   97: aload_2
    //   98: invokevirtual 183	java/io/File:exists	()Z
    //   101: ifeq +8 -> 109
    //   104: aload_2
    //   105: invokevirtual 229	java/io/File:delete	()Z
    //   108: pop
    //   109: aload_2
    //   110: invokevirtual 417	java/io/File:createNewFile	()Z
    //   113: pop
    //   114: new 419	java/io/FileOutputStream
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 420	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   122: astore_2
    //   123: new 422	java/io/BufferedOutputStream
    //   126: dup
    //   127: aload_2
    //   128: invokespecial 425	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   131: astore 4
    //   133: aload 4
    //   135: aload_1
    //   136: invokevirtual 429	java/lang/String:getBytes	()[B
    //   139: invokevirtual 432	java/io/BufferedOutputStream:write	([B)V
    //   142: aload 4
    //   144: ifnull +8 -> 152
    //   147: aload 4
    //   149: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   152: aload_2
    //   153: ifnull +7 -> 160
    //   156: aload_2
    //   157: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   160: aload_0
    //   161: aload_0
    //   162: aload_1
    //   163: invokevirtual 130	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Ljava/lang/String;)Ljava/util/List;
    //   166: putfield 132	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   169: aload_0
    //   170: getfield 132	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   173: ifnonnull +136 -> 309
    //   176: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +12 -> 191
    //   182: ldc 64
    //   184: iconst_2
    //   185: ldc_w 436
    //   188: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iconst_1
    //   192: istore_3
    //   193: iload_3
    //   194: ireturn
    //   195: astore 4
    //   197: aload 4
    //   199: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   202: goto -50 -> 152
    //   205: astore_2
    //   206: aload_2
    //   207: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   210: goto -50 -> 160
    //   213: astore 5
    //   215: aconst_null
    //   216: astore_1
    //   217: aload 4
    //   219: astore_2
    //   220: aload 5
    //   222: astore 4
    //   224: aload 4
    //   226: invokevirtual 380	java/lang/Exception:printStackTrace	()V
    //   229: iconst_0
    //   230: istore_3
    //   231: aload_1
    //   232: ifnull +7 -> 239
    //   235: aload_1
    //   236: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   239: aload_2
    //   240: ifnull -47 -> 193
    //   243: aload_2
    //   244: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   254: iconst_0
    //   255: ireturn
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   261: goto -22 -> 239
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_2
    //   267: aload 5
    //   269: astore 4
    //   271: aload 4
    //   273: ifnull +8 -> 281
    //   276: aload 4
    //   278: invokevirtual 433	java/io/BufferedOutputStream:close	()V
    //   281: aload_2
    //   282: ifnull +7 -> 289
    //   285: aload_2
    //   286: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   289: aload_1
    //   290: athrow
    //   291: astore 4
    //   293: aload 4
    //   295: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   298: goto -17 -> 281
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   306: goto -17 -> 289
    //   309: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +61 -> 373
    //   315: aload_0
    //   316: getfield 132	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   319: invokeinterface 237 1 0
    //   324: astore_1
    //   325: aload_1
    //   326: invokeinterface 242 1 0
    //   331: ifeq +42 -> 373
    //   334: aload_1
    //   335: invokeinterface 246 1 0
    //   340: checkcast 248	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilter
    //   343: astore_2
    //   344: ldc 64
    //   346: iconst_2
    //   347: new 20	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 441
    //   357: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_2
    //   361: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: goto -45 -> 325
    //   373: aload_0
    //   374: iconst_1
    //   375: invokevirtual 142	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Z)V
    //   378: iconst_1
    //   379: ireturn
    //   380: astore_1
    //   381: aload 5
    //   383: astore 4
    //   385: goto -114 -> 271
    //   388: astore_1
    //   389: goto -118 -> 271
    //   392: astore 5
    //   394: aload_1
    //   395: astore 4
    //   397: aload 5
    //   399: astore_1
    //   400: goto -129 -> 271
    //   403: astore 4
    //   405: aconst_null
    //   406: astore_1
    //   407: goto -183 -> 224
    //   410: astore 5
    //   412: aload 4
    //   414: astore_1
    //   415: aload 5
    //   417: astore 4
    //   419: goto -195 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	ArtFilterManager
    //   0	422	1	paramString1	String
    //   0	422	2	paramString2	String
    //   192	39	3	bool	boolean
    //   4	144	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   195	23	4	localIOException1	IOException
    //   222	55	4	localException1	Exception
    //   291	3	4	localIOException2	IOException
    //   383	13	4	localObject1	Object
    //   403	10	4	localException2	Exception
    //   417	1	4	localException3	Exception
    //   1	1	5	localObject2	Object
    //   213	169	5	localException4	Exception
    //   392	6	5	localObject3	Object
    //   410	6	5	localException5	Exception
    //   48	11	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   147	152	195	java/io/IOException
    //   156	160	205	java/io/IOException
    //   38	64	213	java/lang/Exception
    //   64	109	213	java/lang/Exception
    //   109	123	213	java/lang/Exception
    //   243	247	249	java/io/IOException
    //   235	239	256	java/io/IOException
    //   38	64	264	finally
    //   64	109	264	finally
    //   109	123	264	finally
    //   276	281	291	java/io/IOException
    //   285	289	301	java/io/IOException
    //   123	133	380	finally
    //   133	142	388	finally
    //   224	229	392	finally
    //   123	133	403	java/lang/Exception
    //   133	142	410	java/lang/Exception
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager
 * JD-Core Version:    0.7.0.1
 */