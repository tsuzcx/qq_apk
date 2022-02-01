package com.tencent.biz.qqstory.takevideo.artfilter;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ArtFilterManager
  implements Manager
{
  public static int a;
  public static final String a;
  public static final String b = AppConstants.SDCARD_PATH + "pddata/prd/picedit/artfilter/";
  public ArtFilterLoading a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private List<ArtFilter> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "artfilter/";
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
    //   8: iconst_0
    //   9: putfield 52	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_Boolean	Z
    //   12: aload_0
    //   13: new 54	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager$2
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 57	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager$2:<init>	(Lcom/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager;)V
    //   21: putfield 59	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_ComTencentMobileqqVipDownloadListener	Lcom/tencent/mobileqq/vip/DownloadListener;
    //   24: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +11 -> 38
    //   30: ldc 67
    //   32: iconst_2
    //   33: ldc 69
    //   35: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: aload_1
    //   40: putfield 75	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   43: aload_0
    //   44: new 77	com/tencent/util/MqqWeakReferenceHandler
    //   47: dup
    //   48: invokestatic 83	com/tencent/mobileqq/app/ThreadManager:getFileThreadLooper	()Landroid/os/Looper;
    //   51: aconst_null
    //   52: invokespecial 86	com/tencent/util/MqqWeakReferenceHandler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   55: putfield 88	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler	Lcom/tencent/util/MqqWeakReferenceHandler;
    //   58: aload_1
    //   59: invokevirtual 93	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   62: invokestatic 96	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Ljava/lang/String;)Z
    //   65: ifeq +139 -> 204
    //   68: new 98	java/io/File
    //   71: dup
    //   72: new 21	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   79: getstatic 41	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   82: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 100
    //   87: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 107	java/io/File:length	()J
    //   101: l2i
    //   102: newarray byte
    //   104: astore 5
    //   106: new 109	java/io/FileInputStream
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: astore_2
    //   115: new 114	java/io/BufferedInputStream
    //   118: dup
    //   119: aload_2
    //   120: invokespecial 117	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore_1
    //   124: aload_1
    //   125: astore 4
    //   127: aload_2
    //   128: astore_3
    //   129: aload_1
    //   130: aload 5
    //   132: invokevirtual 121	java/io/BufferedInputStream:read	([B)I
    //   135: pop
    //   136: aload_1
    //   137: astore 4
    //   139: aload_2
    //   140: astore_3
    //   141: new 123	java/lang/String
    //   144: dup
    //   145: aload 5
    //   147: invokespecial 126	java/lang/String:<init>	([B)V
    //   150: astore 5
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   160: aload 5
    //   162: astore_1
    //   163: aload_2
    //   164: ifnull +10 -> 174
    //   167: aload_2
    //   168: invokevirtual 130	java/io/FileInputStream:close	()V
    //   171: aload 5
    //   173: astore_1
    //   174: aload_0
    //   175: aload_0
    //   176: aload_1
    //   177: invokevirtual 133	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Ljava/lang/String;)Ljava/util/List;
    //   180: putfield 135	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   183: aload_0
    //   184: getfield 135	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   187: ifnonnull +145 -> 332
    //   190: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +11 -> 204
    //   196: ldc 67
    //   198: iconst_2
    //   199: ldc 137
    //   201: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +11 -> 218
    //   210: ldc 67
    //   212: iconst_2
    //   213: ldc 139
    //   215: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: return
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   224: goto -64 -> 160
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   232: aload 5
    //   234: astore_1
    //   235: goto -61 -> 174
    //   238: astore 5
    //   240: aconst_null
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_2
    //   244: aload_1
    //   245: astore 4
    //   247: aload_2
    //   248: astore_3
    //   249: aload 5
    //   251: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   254: aload_1
    //   255: ifnull +7 -> 262
    //   258: aload_1
    //   259: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   262: aload_2
    //   263: ifnull +99 -> 362
    //   266: aload_2
    //   267: invokevirtual 130	java/io/FileInputStream:close	()V
    //   270: aconst_null
    //   271: astore_1
    //   272: goto -98 -> 174
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   280: goto -18 -> 262
    //   283: astore_1
    //   284: aload_1
    //   285: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   288: aconst_null
    //   289: astore_1
    //   290: goto -116 -> 174
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_2
    //   296: aload 4
    //   298: ifnull +8 -> 306
    //   301: aload 4
    //   303: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   306: aload_2
    //   307: ifnull +7 -> 314
    //   310: aload_2
    //   311: invokevirtual 130	java/io/FileInputStream:close	()V
    //   314: aload_1
    //   315: athrow
    //   316: astore_3
    //   317: aload_3
    //   318: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   321: goto -15 -> 306
    //   324: astore_2
    //   325: aload_2
    //   326: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   329: goto -15 -> 314
    //   332: aload_0
    //   333: iconst_0
    //   334: invokevirtual 145	com/tencent/biz/qqstory/takevideo/artfilter/ArtFilterManager:a	(Z)V
    //   337: goto -133 -> 204
    //   340: astore_1
    //   341: goto -45 -> 296
    //   344: astore_1
    //   345: aload_3
    //   346: astore_2
    //   347: goto -51 -> 296
    //   350: astore 5
    //   352: aconst_null
    //   353: astore_1
    //   354: goto -110 -> 244
    //   357: astore 5
    //   359: goto -115 -> 244
    //   362: aconst_null
    //   363: astore_1
    //   364: goto -190 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	ArtFilterManager
    //   0	367	1	paramAppInterface	AppInterface
    //   114	197	2	localFileInputStream1	java.io.FileInputStream
    //   324	2	2	localIOException1	IOException
    //   346	1	2	localObject1	Object
    //   128	121	3	localFileInputStream2	java.io.FileInputStream
    //   316	30	3	localIOException2	IOException
    //   1	301	4	localAppInterface	AppInterface
    //   104	129	5	localObject2	Object
    //   238	12	5	localIOException3	IOException
    //   350	1	5	localIOException4	IOException
    //   357	1	5	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   156	160	219	java/io/IOException
    //   167	171	227	java/io/IOException
    //   68	115	238	java/io/IOException
    //   258	262	275	java/io/IOException
    //   266	270	283	java/io/IOException
    //   68	115	293	finally
    //   301	306	316	java/io/IOException
    //   310	314	324	java/io/IOException
    //   115	124	340	finally
    //   129	136	344	finally
    //   141	152	344	finally
    //   249	254	344	finally
    //   115	124	350	java/io/IOException
    //   129	136	357	java/io/IOException
    //   141	152	357	java/io/IOException
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
    paramString3 = new ArtFilterManager.1(this, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString2, paramString1, paramString2, localFile, paramString3);
    boolean bool = ((PreDownloadController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).requestPreDownload(10015, "prd", paramString1, 0, paramString1, paramString2, 2, 0, true, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "PreDownloadController ret:" + bool);
    }
  }
  
  private void a(List<ArtFilter> paramList, ArtFilterLoading paramArtFilterLoading)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "[deleteOldResources] start");
    }
    Object localObject1 = new File(b);
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isDirectory()) {
        break label740;
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
        break label682;
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
    label740:
    label766:
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
          break label766;
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
  
  private static boolean a(String paramString)
  {
    return new File(jdField_a_of_type_JavaLangString + "artfilter.config").exists();
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterLoading != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterLoading.a();
    }
    return null;
  }
  
  String a(String paramString)
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
  
  public List<ArtFilter> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public List<ArtFilter> a(String paramString)
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
  
  void a(String paramString)
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
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.post(new ArtFilterManager.UpdateTask(this, this.jdField_a_of_type_JavaUtilList, paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterLoading));
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