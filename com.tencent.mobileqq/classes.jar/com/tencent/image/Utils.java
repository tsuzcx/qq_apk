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
    //   0: iconst_0
    //   1: istore 4
    //   3: new 298	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 309	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 363	java/io/RandomAccessFile
    //   15: dup
    //   16: aload_0
    //   17: ldc_w 365
    //   20: invokespecial 368	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 5
    //   25: aload 5
    //   27: astore_0
    //   28: getstatic 58	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   31: arraylength
    //   32: newarray byte
    //   34: astore 6
    //   36: aload 5
    //   38: astore_0
    //   39: aload 5
    //   41: aload 6
    //   43: invokevirtual 369	java/io/RandomAccessFile:read	([B)I
    //   46: pop
    //   47: iconst_0
    //   48: istore_1
    //   49: aload 5
    //   51: astore_0
    //   52: iload_1
    //   53: getstatic 58	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   56: arraylength
    //   57: if_icmpge +36 -> 93
    //   60: aload 6
    //   62: iload_1
    //   63: baload
    //   64: istore_2
    //   65: aload 5
    //   67: astore_0
    //   68: getstatic 58	com/tencent/image/Utils:HEIF_SIGNATURE	[B
    //   71: iload_1
    //   72: baload
    //   73: istore_3
    //   74: iload_2
    //   75: iload_3
    //   76: if_icmpeq +10 -> 86
    //   79: aload 5
    //   81: invokevirtual 370	java/io/RandomAccessFile:close	()V
    //   84: iconst_0
    //   85: ireturn
    //   86: iload_1
    //   87: iconst_1
    //   88: iadd
    //   89: istore_1
    //   90: goto -41 -> 49
    //   93: iconst_1
    //   94: istore 4
    //   96: aload 5
    //   98: invokevirtual 370	java/io/RandomAccessFile:close	()V
    //   101: iconst_1
    //   102: ireturn
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   108: iload 4
    //   110: ireturn
    //   111: astore 6
    //   113: aconst_null
    //   114: astore 5
    //   116: aload 5
    //   118: astore_0
    //   119: aload 6
    //   121: invokevirtual 374	java/io/IOException:printStackTrace	()V
    //   124: aload 5
    //   126: invokevirtual 370	java/io/RandomAccessFile:close	()V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: goto -28 -> 104
    //   135: astore 5
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 370	java/io/RandomAccessFile:close	()V
    //   143: aload 5
    //   145: athrow
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   151: goto -8 -> 143
    //   154: astore_0
    //   155: goto -51 -> 104
    //   158: astore 5
    //   160: goto -21 -> 139
    //   163: astore 6
    //   165: goto -49 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   48	42	1	i	int
    //   64	13	2	j	int
    //   73	4	3	k	int
    //   1	108	4	bool	boolean
    //   23	102	5	localRandomAccessFile	java.io.RandomAccessFile
    //   135	9	5	localObject1	Object
    //   158	1	5	localObject2	Object
    //   34	27	6	arrayOfByte	byte[]
    //   111	9	6	localIOException1	IOException
    //   163	1	6	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   96	101	103	java/lang/Exception
    //   12	25	111	java/io/IOException
    //   124	129	131	java/lang/Exception
    //   12	25	135	finally
    //   139	143	146	java/lang/Exception
    //   79	84	154	java/lang/Exception
    //   28	36	158	finally
    //   39	47	158	finally
    //   52	60	158	finally
    //   68	74	158	finally
    //   119	124	158	finally
    //   28	36	163	java/io/IOException
    //   39	47	163	java/io/IOException
    //   52	60	163	java/io/IOException
    //   68	74	163	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.Utils
 * JD-Core Version:    0.7.0.1
 */