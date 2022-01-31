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
import com.tencent.qphone.base.util.QLog;
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
  private static long[] CRCTable;
  public static final byte[] HEIF_SIGNATURE = { 0, 0, 0, 24, 102, 116, 121, 112, 104, 101, 105, 99 };
  private static final long INITIALCRC = -1L;
  private static final long POLY64REV = -7661587058870466123L;
  public static final String PROTOCOL_CHAT_THUMB = "chatthumb";
  public static final String TAG = "URLDrawable.Utils";
  private static boolean init = false;
  private static ThreadLocal<LinkedList<Long>> sBeginTimeList;
  
  static
  {
    CRCTable = new long[256];
    sBeginTimeList = new ThreadLocal();
  }
  
  public static final long Crc64Long(String paramString)
  {
    int k = 0;
    long l2;
    if ((paramString == null) || (paramString.length() == 0))
    {
      l2 = 0L;
      return l2;
    }
    if (!init)
    {
      i = 0;
      while (i < 256)
      {
        l1 = i;
        j = 0;
        if (j < 8)
        {
          if (((int)l1 & 0x1) != 0) {}
          for (l1 = l1 >> 1 ^ 0xAC4BC9B5;; l1 >>= 1)
          {
            j += 1;
            break;
          }
        }
        CRCTable[i] = l1;
        i += 1;
      }
      init = true;
    }
    int j = paramString.length();
    long l1 = -1L;
    int i = k;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      k = paramString.charAt(i);
      l2 = CRCTable[((k ^ (int)l1) & 0xFF)];
      i += 1;
      l1 = l2 ^ l1 >> 8;
    }
  }
  
  public static final String Crc64String(String paramString)
  {
    return Long.toString(Crc64Long(paramString), 16);
  }
  
  public static void beginPile()
  {
    if (QLog.isColorLevel())
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
    int i = 1;
    int j = 1;
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      if (paramRect.width() * paramRect.height() > 5000000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("URLDrawable.Utils", 2, "calculateInSampleSize options.outWidth*options.outHeight=" + paramRect.width() * paramRect.height());
        }
        j = 2;
      }
    }
    int m;
    int k;
    label94:
    do
    {
      return j;
      m = paramRect.width();
      k = paramRect.height();
      if (k > paramInt2) {
        break;
      }
      j = i;
    } while (m <= paramInt1);
    int n = Math.round(k / paramInt2);
    j = Math.round(m / paramInt1);
    if (n > j) {}
    for (;;)
    {
      j = i;
      if (n < 2) {
        break;
      }
      m /= 2;
      k /= 2;
      i *= 2;
      break label94;
      n = j;
    }
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
    if (QLog.isColorLevel())
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
      QLog.i(paramString1, 2, ((StringBuilder)localObject2).toString());
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
    paramContext = "/Android/data/" + paramContext.getPackageName() + "/imagecache/";
    return new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
  }
  
  public static int getHeifOrientation(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      if (paramString == null) {
        return 1;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("URLDrawable.Utils", 2, "new ExifInterface", paramString);
        }
        paramString = null;
      }
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
    long l = paramFile.getBlockSize();
    return paramFile.getAvailableBlocks() * l;
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
    //   0: new 298	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 309	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 363	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc_w 365
    //   17: invokespecial 368	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore 4
    //   22: aload 4
    //   24: astore_0
    //   25: getstatic 58	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   28: arraylength
    //   29: newarray byte
    //   31: astore 5
    //   33: aload 4
    //   35: astore_0
    //   36: aload 4
    //   38: aload 5
    //   40: invokevirtual 369	java/io/RandomAccessFile:read	([B)I
    //   43: pop
    //   44: iconst_0
    //   45: istore_1
    //   46: aload 4
    //   48: astore_0
    //   49: iload_1
    //   50: getstatic 58	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   53: arraylength
    //   54: if_icmpge +43 -> 97
    //   57: aload 5
    //   59: iload_1
    //   60: baload
    //   61: istore_2
    //   62: aload 4
    //   64: astore_0
    //   65: getstatic 58	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   68: iload_1
    //   69: baload
    //   70: istore_3
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmpeq +17 -> 90
    //   76: aload 4
    //   78: invokevirtual 370	java/io/RandomAccessFile:close	()V
    //   81: iconst_0
    //   82: ireturn
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   88: iconst_0
    //   89: ireturn
    //   90: iload_1
    //   91: iconst_1
    //   92: iadd
    //   93: istore_1
    //   94: goto -48 -> 46
    //   97: aload 4
    //   99: invokevirtual 370	java/io/RandomAccessFile:close	()V
    //   102: iconst_1
    //   103: ireturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   109: iconst_1
    //   110: ireturn
    //   111: astore 5
    //   113: aconst_null
    //   114: astore 4
    //   116: aload 4
    //   118: astore_0
    //   119: aload 5
    //   121: invokevirtual 374	java/io/IOException:printStackTrace	()V
    //   124: aload 4
    //   126: invokevirtual 370	java/io/RandomAccessFile:close	()V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 370	java/io/RandomAccessFile:close	()V
    //   146: aload 4
    //   148: athrow
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   154: goto -8 -> 146
    //   157: astore 4
    //   159: goto -17 -> 142
    //   162: astore 5
    //   164: goto -48 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramString	String
    //   45	49	1	i	int
    //   61	13	2	j	int
    //   70	4	3	k	int
    //   20	105	4	localRandomAccessFile	java.io.RandomAccessFile
    //   138	9	4	localObject1	Object
    //   157	1	4	localObject2	Object
    //   31	27	5	arrayOfByte	byte[]
    //   111	9	5	localIOException1	IOException
    //   162	1	5	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   76	81	83	java/lang/Exception
    //   97	102	104	java/lang/Exception
    //   9	22	111	java/io/IOException
    //   124	129	131	java/lang/Exception
    //   9	22	138	finally
    //   142	146	149	java/lang/Exception
    //   25	33	157	finally
    //   36	44	157	finally
    //   49	57	157	finally
    //   65	71	157	finally
    //   119	124	157	finally
    //   25	33	162	java/io/IOException
    //   36	44	162	java/io/IOException
    //   49	57	162	java/io/IOException
    //   65	71	162	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.Utils
 * JD-Core Version:    0.7.0.1
 */