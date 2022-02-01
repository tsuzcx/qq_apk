package com.tencent.image;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.concurrent.Executor;

public class Utils
{
  public static final String AIO_PIC_DISPATCH_WAIT = "AioPicDispatchWait";
  public static final String AIO_PIC_DOWNLOAD_WAIT = "AioPicDownloadWait";
  private static long[] CRCTable = new long[256];
  public static final byte[] HEIF_SIGNATURE = { 0, 0, 0, 24, 102, 116, 121, 112, 104, 101, 105, 99 };
  private static final long INITIALCRC = -1L;
  private static final long POLY64REV = -7661587058870466123L;
  public static final String PROTOCOL_CHAT_THUMB = "chatthumb";
  public static final String TAG = "URLDrawable.Utils";
  private static boolean init = false;
  private static ThreadLocal<LinkedList<Long>> sBeginTimeList = new ThreadLocal();
  
  public static final long Crc64Long(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      long l2 = -1L;
      boolean bool = init;
      int k = 0;
      if (!bool)
      {
        i = 0;
        while (i < 256)
        {
          l1 = i;
          j = 0;
          while (j < 8)
          {
            if (((int)l1 & 0x1) != 0) {
              l1 = l1 >> 1 ^ 0xAC4BC9B5;
            } else {
              l1 >>= 1;
            }
            j += 1;
          }
          CRCTable[i] = l1;
          i += 1;
        }
        init = true;
      }
      int j = paramString.length();
      int i = k;
      long l1 = l2;
      while (i < j)
      {
        k = paramString.charAt(i);
        l1 = l1 >> 8 ^ CRCTable[((k ^ (int)l1) & 0xFF)];
        i += 1;
      }
      return l1;
    }
    return 0L;
  }
  
  public static final String Crc64String(String paramString)
  {
    return Long.toString(Crc64Long(paramString), 16);
  }
  
  public static void beginPile()
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      LinkedList localLinkedList2 = (LinkedList)sBeginTimeList.get();
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        sBeginTimeList.set(localLinkedList1);
      }
      localLinkedList1.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return calculateInSampleSize(new Rect(0, 0, paramOptions.outWidth, paramOptions.outHeight), paramInt1, paramInt2);
  }
  
  public static int calculateInSampleSize(Rect paramRect, int paramInt1, int paramInt2)
  {
    int j = 1;
    if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != -1) && (paramInt2 != -1))
    {
      int k = paramRect.width();
      int i = paramRect.height();
      while ((i > paramInt2) || (k > paramInt1))
      {
        int m = Math.round(i / paramInt2);
        int n = Math.round(k / paramInt1);
        if (m <= n) {
          m = n;
        }
        if (m < 2) {
          break;
        }
        k /= 2;
        i /= 2;
        j *= 2;
      }
      return j;
    }
    if (paramRect.width() * paramRect.height() > 5000000)
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        ILog localILog = URLDrawable.depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("calculateInSampleSize options.outWidth*options.outHeight=");
        localStringBuilder.append(paramRect.width() * paramRect.height());
        localILog.d("URLDrawable.Utils", 2, localStringBuilder.toString());
      }
      return 2;
    }
    return 1;
  }
  
  public static final void copyFile(File paramFile1, File paramFile2)
  {
    paramFile1 = new FileInputStream(paramFile1);
    paramFile2 = new FileOutputStream(paramFile2);
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramFile1.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      paramFile2.write(arrayOfByte, 0, i);
    }
    paramFile2.flush();
    paramFile1.close();
    paramFile2.close();
  }
  
  public static void disableConnectionReuseIfNecessary()
  {
    if (hasHttpConnectionBug()) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  public static void endPile(String paramString1, String paramString2)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      Object localObject2 = (LinkedList)sBeginTimeList.get();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedList();
        sBeginTimeList.set(localObject1);
        ((LinkedList)localObject1).addFirst(Long.valueOf(SystemClock.uptimeMillis()));
      }
      localObject2 = new StringBuilder();
      int i = 1;
      while (i < ((LinkedList)localObject1).size())
      {
        ((StringBuilder)localObject2).append("    ");
        i += 1;
      }
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(":cost ");
      ((StringBuilder)localObject2).append(SystemClock.uptimeMillis() - ((Long)((LinkedList)sBeginTimeList.get()).removeFirst()).longValue());
      ((StringBuilder)localObject2).append("ms");
      URLDrawable.depImp.mLog.i(paramString1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  @TargetApi(11)
  public static <Params, Progress, Result> void executeAsyncTaskOnNewThreadPool(Executor paramExecutor, AsyncTask<Params, Progress, Result> paramAsyncTask, Params... paramVarArgs)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (paramExecutor != null))
    {
      paramAsyncTask.executeOnExecutor(paramExecutor, paramVarArgs);
      return;
    }
    paramAsyncTask.execute(paramVarArgs);
  }
  
  @TargetApi(11)
  public static <Params, Progress, Result> void executeAsyncTaskOnSerialExcuter(AsyncTask<Params, Progress, Result> paramAsyncTask, Params... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramAsyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, paramVarArgs);
      return;
    }
    paramAsyncTask.execute(paramVarArgs);
  }
  
  @TargetApi(11)
  public static <Params, Progress, Result> void executeAsyncTaskOnThreadPool(AsyncTask<Params, Progress, Result> paramAsyncTask, Params... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
      return;
    }
    paramAsyncTask.execute(paramVarArgs);
  }
  
  @SuppressLint({"NewApi"})
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  @SuppressLint({"NewApi"})
  public static File getExternalCacheDir(Context paramContext)
  {
    if (hasExternalCacheDir()) {
      return paramContext.getExternalCacheDir();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/Android/data/");
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("/imagecache/");
    paramContext = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append(paramContext);
    return new File(localStringBuilder.toString());
  }
  
  public static int getHeifOrientation(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
    }
    catch (IOException paramString)
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.e("URLDrawable.Utils", 2, "new ExifInterface", paramString);
      }
      paramString = null;
    }
    if (paramString == null) {
      return 1;
    }
    return paramString.getAttributeInt("Orientation", 1);
  }
  
  public static int getMemoryClass(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  @SuppressLint({"NewApi"})
  public static long getUsableSpace(File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return paramFile.getUsableSpace();
    }
    paramFile = new StatFs(paramFile.getPath());
    return paramFile.getBlockSize() * paramFile.getAvailableBlocks();
  }
  
  public static boolean hasActionBar()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean hasExternalCacheDir()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public static boolean hasHttpConnectionBug()
  {
    return Build.VERSION.SDK_INT < 8;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean isExternalStorageRemovable()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
  
  /* Error */
  public static boolean isHeifFile(String paramString)
  {
    // Byte code:
    //   0: new 315	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 321	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore_0
    //   15: new 375	java/io/RandomAccessFile
    //   18: dup
    //   19: aload 4
    //   21: ldc_w 377
    //   24: invokespecial 380	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore 4
    //   29: getstatic 47	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   32: arraylength
    //   33: newarray byte
    //   35: astore_0
    //   36: aload 4
    //   38: aload_0
    //   39: invokevirtual 381	java/io/RandomAccessFile:read	([B)I
    //   42: pop
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: getstatic 47	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   49: arraylength
    //   50: if_icmpge +39 -> 89
    //   53: aload_0
    //   54: iload_1
    //   55: baload
    //   56: istore_2
    //   57: getstatic 47	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   60: iload_1
    //   61: baload
    //   62: istore_3
    //   63: iload_2
    //   64: iload_3
    //   65: if_icmpeq +17 -> 82
    //   68: aload 4
    //   70: invokevirtual 382	java/io/RandomAccessFile:close	()V
    //   73: iconst_0
    //   74: ireturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 385	java/lang/Exception:printStackTrace	()V
    //   80: iconst_0
    //   81: ireturn
    //   82: iload_1
    //   83: iconst_1
    //   84: iadd
    //   85: istore_1
    //   86: goto -41 -> 45
    //   89: aload 4
    //   91: invokevirtual 382	java/io/RandomAccessFile:close	()V
    //   94: goto +8 -> 102
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 385	java/lang/Exception:printStackTrace	()V
    //   102: iconst_1
    //   103: ireturn
    //   104: astore_0
    //   105: goto +49 -> 154
    //   108: astore 5
    //   110: goto +22 -> 132
    //   113: astore 5
    //   115: aload_0
    //   116: astore 4
    //   118: aload 5
    //   120: astore_0
    //   121: goto +33 -> 154
    //   124: astore_0
    //   125: aload 5
    //   127: astore 4
    //   129: aload_0
    //   130: astore 5
    //   132: aload 4
    //   134: astore_0
    //   135: aload 5
    //   137: invokevirtual 386	java/io/IOException:printStackTrace	()V
    //   140: aload 4
    //   142: invokevirtual 382	java/io/RandomAccessFile:close	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 385	java/lang/Exception:printStackTrace	()V
    //   152: iconst_0
    //   153: ireturn
    //   154: aload 4
    //   156: invokevirtual 382	java/io/RandomAccessFile:close	()V
    //   159: goto +10 -> 169
    //   162: astore 4
    //   164: aload 4
    //   166: invokevirtual 385	java/lang/Exception:printStackTrace	()V
    //   169: goto +5 -> 174
    //   172: aload_0
    //   173: athrow
    //   174: goto -2 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString	String
    //   44	42	1	i	int
    //   56	10	2	j	int
    //   62	4	3	k	int
    //   8	147	4	localObject1	Object
    //   162	3	4	localException	java.lang.Exception
    //   11	1	5	localObject2	Object
    //   108	1	5	localIOException	IOException
    //   113	13	5	localObject3	Object
    //   130	6	5	str	String
    // Exception table:
    //   from	to	target	type
    //   68	73	75	java/lang/Exception
    //   89	94	97	java/lang/Exception
    //   29	43	104	finally
    //   45	53	104	finally
    //   57	63	104	finally
    //   29	43	108	java/io/IOException
    //   45	53	108	java/io/IOException
    //   57	63	108	java/io/IOException
    //   15	29	113	finally
    //   135	140	113	finally
    //   15	29	124	java/io/IOException
    //   140	145	147	java/lang/Exception
    //   154	159	162	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.Utils
 * JD-Core Version:    0.7.0.1
 */