package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;

public class LebaIconDownloader
{
  /* Error */
  public static Drawable a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 15	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 21	android/content/Context:getFilesDir	()Ljava/io/File;
    //   14: aload_1
    //   15: invokespecial 24	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 28	java/io/File:exists	()Z
    //   23: ifeq +113 -> 136
    //   26: new 30	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: new 35	android/graphics/drawable/BitmapDrawable
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 38	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 41	java/io/FileInputStream:close	()V
    //   50: aload_2
    //   51: areturn
    //   52: astore_2
    //   53: goto +12 -> 65
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_0
    //   59: goto +67 -> 126
    //   62: astore_2
    //   63: aconst_null
    //   64: astore_1
    //   65: aload_1
    //   66: astore_0
    //   67: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +45 -> 115
    //   73: aload_1
    //   74: astore_0
    //   75: new 48	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   82: astore_3
    //   83: aload_1
    //   84: astore_0
    //   85: aload_3
    //   86: ldc 51
    //   88: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_1
    //   93: astore_0
    //   94: aload_3
    //   95: aload_2
    //   96: invokevirtual 59	java/lang/Exception:toString	()Ljava/lang/String;
    //   99: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: astore_0
    //   105: ldc 61
    //   107: iconst_2
    //   108: aload_3
    //   109: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_1
    //   116: ifnull +64 -> 180
    //   119: aload_1
    //   120: invokevirtual 41	java/io/FileInputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_1
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 41	java/io/FileInputStream:close	()V
    //   134: aload_1
    //   135: athrow
    //   136: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +41 -> 180
    //   142: new 48	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   149: astore_0
    //   150: aload_0
    //   151: ldc 68
    //   153: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_0
    //   158: aload_1
    //   159: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_0
    //   164: ldc 70
    //   166: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: ldc 61
    //   172: iconst_2
    //   173: aload_0
    //   174: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_0
    //   183: goto -133 -> 50
    //   186: astore_0
    //   187: aconst_null
    //   188: areturn
    //   189: astore_0
    //   190: goto -56 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramContext	Context
    //   0	193	1	paramString	String
    //   45	6	2	localBitmapDrawable	BitmapDrawable
    //   52	1	2	localException1	java.lang.Exception
    //   62	34	2	localException2	java.lang.Exception
    //   82	27	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	46	52	java/lang/Exception
    //   26	35	56	finally
    //   26	35	62	java/lang/Exception
    //   37	46	125	finally
    //   67	73	125	finally
    //   75	83	125	finally
    //   85	92	125	finally
    //   94	103	125	finally
    //   105	115	125	finally
    //   46	50	182	java/lang/Exception
    //   119	123	186	java/lang/Exception
    //   130	134	189	java/lang/Exception
  }
  
  public static Drawable a(String paramString)
  {
    paramString = GlobalImageCache.a.get(paramString);
    if (paramString == null) {
      return null;
    }
    if ((!(paramString instanceof Drawable)) && (!(paramString instanceof BitmapDrawable))) {
      return null;
    }
    return (Drawable)paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    if (paramContext == null) {
      return;
    }
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return;
      }
      if (paramQQAppInterface == null) {
        return;
      }
      ThreadManager.post(new LebaIconDownloader.1(paramContext, paramString, paramQQAppInterface, paramHttpDownloadListener), 5, null, true);
    }
  }
  
  public static void a(String paramString, Drawable paramDrawable)
  {
    GlobalImageCache.a.put(paramString, paramDrawable);
  }
  
  public static Drawable b(Context paramContext, String paramString)
  {
    if (a(paramString) != null) {
      return a(paramString);
    }
    if (a(paramContext, paramString) != null)
    {
      a(paramString, a(paramContext, paramString));
      return a(paramContext, paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaIconDownloader
 * JD-Core Version:    0.7.0.1
 */