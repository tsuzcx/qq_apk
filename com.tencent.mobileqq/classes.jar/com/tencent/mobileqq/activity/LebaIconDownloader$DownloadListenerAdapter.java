package com.tencent.mobileqq.activity;

import android.content.Context;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class LebaIconDownloader$DownloadListenerAdapter
  implements HttpDownloadUtil.HttpDownloadListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LebaIconDownloader.IDownloadListener jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  
  public LebaIconDownloader$DownloadListenerAdapter(Context paramContext, LebaIconDownloader.IDownloadListener paramIDownloadListener, Object... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener = paramIDownloadListener;
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaListViewAdapter", 2, "--onHttpStart");
    }
    LebaIconDownloader.IDownloadListener localIDownloadListener = this.jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener;
    if (localIDownloadListener != null) {
      localIDownloadListener.a(0, paramString, null, this.jdField_a_of_type_ArrayOfJavaLangObject);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaListViewAdapter", 2, "--onHttpProgress");
    }
    LebaIconDownloader.IDownloadListener localIDownloadListener = this.jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener;
    if (localIDownloadListener != null) {
      localIDownloadListener.a(1, paramString, null, this.jdField_a_of_type_ArrayOfJavaLangObject);
    }
  }
  
  /* Error */
  public void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 56	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 59
    //   17: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: iload_2
    //   23: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 37
    //   29: iconst_2
    //   30: aload_3
    //   31: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aconst_null
    //   38: astore 5
    //   40: iload_2
    //   41: ifne +323 -> 364
    //   44: new 72	java/io/File
    //   47: dup
    //   48: aload_0
    //   49: getfield 27	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   52: invokevirtual 76	android/content/Context:getFilesDir	()Ljava/io/File;
    //   55: aload_1
    //   56: invokespecial 79	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   59: astore_3
    //   60: aload_3
    //   61: invokevirtual 82	java/io/File:exists	()Z
    //   64: ifne +93 -> 157
    //   67: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +41 -> 111
    //   73: new 56	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   80: astore_3
    //   81: aload_3
    //   82: ldc 84
    //   84: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: aload_1
    //   90: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: ldc 86
    //   97: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 37
    //   103: iconst_2
    //   104: aload_3
    //   105: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   115: ifnull +19 -> 134
    //   118: aload_0
    //   119: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   122: iconst_2
    //   123: aload_1
    //   124: aconst_null
    //   125: aload_0
    //   126: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   129: invokeinterface 48 5 0
    //   134: aload_0
    //   135: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   138: astore_3
    //   139: aload_3
    //   140: ifnull +16 -> 156
    //   143: aload_3
    //   144: iconst_2
    //   145: aload_1
    //   146: aconst_null
    //   147: aload_0
    //   148: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   151: invokeinterface 48 5 0
    //   156: return
    //   157: new 88	java/io/FileInputStream
    //   160: dup
    //   161: aload_3
    //   162: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   165: astore_3
    //   166: new 93	android/graphics/drawable/BitmapDrawable
    //   169: dup
    //   170: aload_3
    //   171: invokespecial 96	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   174: astore 4
    //   176: aload_1
    //   177: aload 4
    //   179: invokestatic 101	com/tencent/mobileqq/activity/LebaIconDownloader:a	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   182: aload_0
    //   183: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   186: astore 6
    //   188: aload_3
    //   189: astore 5
    //   191: aload 6
    //   193: ifnull +21 -> 214
    //   196: aload 6
    //   198: iconst_2
    //   199: aload_1
    //   200: aload 4
    //   202: aload_0
    //   203: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   206: invokeinterface 48 5 0
    //   211: aload_3
    //   212: astore 5
    //   214: aload 5
    //   216: invokevirtual 104	java/io/FileInputStream:close	()V
    //   219: return
    //   220: astore 6
    //   222: aload 4
    //   224: astore 5
    //   226: aload 6
    //   228: astore 4
    //   230: goto +97 -> 327
    //   233: astore 5
    //   235: goto +30 -> 265
    //   238: astore 4
    //   240: goto +87 -> 327
    //   243: astore 5
    //   245: aconst_null
    //   246: astore 4
    //   248: goto +17 -> 265
    //   251: astore 4
    //   253: aconst_null
    //   254: astore_3
    //   255: goto +72 -> 327
    //   258: astore 5
    //   260: aconst_null
    //   261: astore_3
    //   262: aload_3
    //   263: astore 4
    //   265: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +14 -> 282
    //   271: ldc 37
    //   273: iconst_2
    //   274: aload 5
    //   276: invokevirtual 105	java/lang/Exception:toString	()Ljava/lang/String;
    //   279: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_0
    //   283: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   286: astore 4
    //   288: aload 4
    //   290: ifnull +17 -> 307
    //   293: aload 4
    //   295: iconst_2
    //   296: aload_1
    //   297: aconst_null
    //   298: aload_0
    //   299: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   302: invokeinterface 48 5 0
    //   307: aload_3
    //   308: ifnull +78 -> 386
    //   311: aload_3
    //   312: astore 5
    //   314: goto -100 -> 214
    //   317: astore 6
    //   319: aload 4
    //   321: astore 5
    //   323: aload 6
    //   325: astore 4
    //   327: aload_0
    //   328: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   331: astore 6
    //   333: aload 6
    //   335: ifnull +18 -> 353
    //   338: aload 6
    //   340: iconst_2
    //   341: aload_1
    //   342: aload 5
    //   344: aload_0
    //   345: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   348: invokeinterface 48 5 0
    //   353: aload_3
    //   354: ifnull +7 -> 361
    //   357: aload_3
    //   358: invokevirtual 104	java/io/FileInputStream:close	()V
    //   361: aload 4
    //   363: athrow
    //   364: aload_0
    //   365: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   368: astore_3
    //   369: aload_3
    //   370: ifnull +16 -> 386
    //   373: aload_3
    //   374: iconst_2
    //   375: aload_1
    //   376: aconst_null
    //   377: aload_0
    //   378: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   381: invokeinterface 48 5 0
    //   386: return
    //   387: astore_1
    //   388: return
    //   389: astore_1
    //   390: goto -29 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	DownloadListenerAdapter
    //   0	393	1	paramString	String
    //   0	393	2	paramInt	int
    //   13	361	3	localObject1	Object
    //   174	55	4	localObject2	Object
    //   238	1	4	localObject3	Object
    //   246	1	4	localObject4	Object
    //   251	1	4	localObject5	Object
    //   263	99	4	localObject6	Object
    //   38	187	5	localObject7	Object
    //   233	1	5	localException1	java.lang.Exception
    //   243	1	5	localException2	java.lang.Exception
    //   258	17	5	localException3	java.lang.Exception
    //   312	31	5	localObject8	Object
    //   186	11	6	localIDownloadListener1	LebaIconDownloader.IDownloadListener
    //   220	7	6	localObject9	Object
    //   317	7	6	localObject10	Object
    //   331	8	6	localIDownloadListener2	LebaIconDownloader.IDownloadListener
    // Exception table:
    //   from	to	target	type
    //   176	182	220	finally
    //   176	182	233	java/lang/Exception
    //   166	176	238	finally
    //   166	176	243	java/lang/Exception
    //   44	111	251	finally
    //   111	134	251	finally
    //   157	166	251	finally
    //   44	111	258	java/lang/Exception
    //   111	134	258	java/lang/Exception
    //   157	166	258	java/lang/Exception
    //   265	282	317	finally
    //   214	219	387	java/lang/Exception
    //   357	361	389	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaIconDownloader.DownloadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */