package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatUtil
{
  private static final String CACHE_FILE_PREFIX = ".font";
  private static final String TAG = "TypefaceCompatUtil";
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  @Nullable
  @RequiresApi(19)
  public static ByteBuffer copyToDirectBuffer(Context paramContext, Resources paramResources, int paramInt)
  {
    paramContext = getTempFile(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = copyToFile(paramContext, paramResources, paramInt);
      if (!bool) {
        return null;
      }
      paramResources = mmap(paramContext);
      return paramResources;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  public static boolean copyToFile(File paramFile, Resources paramResources, int paramInt)
  {
    Resources localResources = null;
    try
    {
      paramResources = paramResources.openRawResource(paramInt);
      localResources = paramResources;
      boolean bool = copyToFile(paramFile, paramResources);
      return bool;
    }
    finally
    {
      closeQuietly(localResources);
    }
  }
  
  /* Error */
  public static boolean copyToFile(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 70	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore 4
    //   5: new 72	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: iconst_0
    //   11: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   14: astore_3
    //   15: aload_3
    //   16: astore_0
    //   17: sipush 1024
    //   20: newarray byte
    //   22: astore 5
    //   24: aload_3
    //   25: astore_0
    //   26: aload_1
    //   27: aload 5
    //   29: invokevirtual 81	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: iconst_m1
    //   35: if_icmpeq +62 -> 97
    //   38: aload_3
    //   39: astore_0
    //   40: aload_3
    //   41: aload 5
    //   43: iconst_0
    //   44: iload_2
    //   45: invokevirtual 85	java/io/FileOutputStream:write	([BII)V
    //   48: goto -24 -> 24
    //   51: astore_0
    //   52: aload_3
    //   53: astore_1
    //   54: aload_0
    //   55: astore_3
    //   56: aload_1
    //   57: astore_0
    //   58: ldc 15
    //   60: new 87	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   67: ldc 90
    //   69: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_3
    //   73: invokevirtual 98	java/io/IOException:getMessage	()Ljava/lang/String;
    //   76: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   85: pop
    //   86: aload_1
    //   87: invokestatic 64	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   90: aload 4
    //   92: invokestatic 111	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_3
    //   98: invokestatic 64	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   101: aload 4
    //   103: invokestatic 111	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   106: iconst_1
    //   107: ireturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: invokestatic 64	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   115: aload 4
    //   117: invokestatic 111	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: goto -12 -> 111
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_1
    //   129: goto -73 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramFile	File
    //   0	132	1	paramInputStream	java.io.InputStream
    //   32	13	2	i	int
    //   14	84	3	localObject	Object
    //   126	1	3	localIOException	IOException
    //   3	113	4	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    //   22	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	24	51	java/io/IOException
    //   26	33	51	java/io/IOException
    //   40	48	51	java/io/IOException
    //   5	15	108	finally
    //   17	24	122	finally
    //   26	33	122	finally
    //   40	48	122	finally
    //   58	86	122	finally
    //   5	15	126	java/io/IOException
  }
  
  @Nullable
  public static File getTempFile(Context paramContext)
  {
    paramContext = paramContext.getCacheDir();
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
      int i = 0;
      while (i < 100)
      {
        File localFile = new File(paramContext, str + i);
        try
        {
          boolean bool = localFile.createNewFile();
          if (bool) {
            return localFile;
          }
        }
        catch (IOException localIOException)
        {
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  @Nullable
  @RequiresApi(19)
  public static ByteBuffer mmap(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 144	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc 146
    //   9: aload_1
    //   10: invokevirtual 152	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +35 -> 50
    //   18: aload_2
    //   19: ifnull +11 -> 30
    //   22: iconst_0
    //   23: ifeq +20 -> 43
    //   26: aload_2
    //   27: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   30: aconst_null
    //   31: astore_1
    //   32: aload_1
    //   33: areturn
    //   34: astore_0
    //   35: new 157	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 158	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: aload_2
    //   44: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   47: goto -17 -> 30
    //   50: new 160	java/io/FileInputStream
    //   53: dup
    //   54: aload_2
    //   55: invokevirtual 164	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   58: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   61: astore 5
    //   63: aload 5
    //   65: invokevirtual 171	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 177	java/nio/channels/FileChannel:size	()J
    //   73: lstore_3
    //   74: aload_0
    //   75: getstatic 183	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   78: lconst_0
    //   79: lload_3
    //   80: invokevirtual 187	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   83: astore_0
    //   84: aload 5
    //   86: ifnull +12 -> 98
    //   89: iconst_0
    //   90: ifeq +60 -> 150
    //   93: aload 5
    //   95: invokevirtual 188	java/io/FileInputStream:close	()V
    //   98: aload_0
    //   99: astore_1
    //   100: aload_2
    //   101: ifnull -69 -> 32
    //   104: iconst_0
    //   105: ifeq +59 -> 164
    //   108: aload_2
    //   109: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   112: aload_0
    //   113: areturn
    //   114: astore_0
    //   115: new 157	java/lang/NullPointerException
    //   118: dup
    //   119: invokespecial 158	java/lang/NullPointerException:<init>	()V
    //   122: athrow
    //   123: astore_0
    //   124: new 157	java/lang/NullPointerException
    //   127: dup
    //   128: invokespecial 158	java/lang/NullPointerException:<init>	()V
    //   131: athrow
    //   132: astore_0
    //   133: aload_0
    //   134: athrow
    //   135: astore_1
    //   136: aload_2
    //   137: ifnull +11 -> 148
    //   140: aload_0
    //   141: ifnull +77 -> 218
    //   144: aload_2
    //   145: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   148: aload_1
    //   149: athrow
    //   150: aload 5
    //   152: invokevirtual 188	java/io/FileInputStream:close	()V
    //   155: goto -57 -> 98
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_0
    //   161: goto -25 -> 136
    //   164: aload_2
    //   165: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   168: aload_0
    //   169: areturn
    //   170: astore_0
    //   171: aload_0
    //   172: athrow
    //   173: astore_1
    //   174: aload 5
    //   176: ifnull +12 -> 188
    //   179: aload_0
    //   180: ifnull +21 -> 201
    //   183: aload 5
    //   185: invokevirtual 188	java/io/FileInputStream:close	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore 5
    //   192: aload_0
    //   193: aload 5
    //   195: invokevirtual 192	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   198: goto -10 -> 188
    //   201: aload 5
    //   203: invokevirtual 188	java/io/FileInputStream:close	()V
    //   206: goto -18 -> 188
    //   209: astore_2
    //   210: aload_0
    //   211: aload_2
    //   212: invokevirtual 192	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   215: goto -67 -> 148
    //   218: aload_2
    //   219: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   222: goto -74 -> 148
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_0
    //   228: goto -54 -> 174
    //   231: astore_0
    //   232: aconst_null
    //   233: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramContext	Context
    //   0	234	1	paramCancellationSignal	android.os.CancellationSignal
    //   0	234	2	paramUri	android.net.Uri
    //   73	7	3	l	long
    //   61	123	5	localFileInputStream	java.io.FileInputStream
    //   190	12	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   26	30	34	java/lang/Throwable
    //   108	112	114	java/lang/Throwable
    //   93	98	123	java/lang/Throwable
    //   50	63	132	java/lang/Throwable
    //   124	132	132	java/lang/Throwable
    //   150	155	132	java/lang/Throwable
    //   188	190	132	java/lang/Throwable
    //   192	198	132	java/lang/Throwable
    //   201	206	132	java/lang/Throwable
    //   133	135	135	finally
    //   50	63	158	finally
    //   93	98	158	finally
    //   124	132	158	finally
    //   150	155	158	finally
    //   183	188	158	finally
    //   188	190	158	finally
    //   192	198	158	finally
    //   201	206	158	finally
    //   63	84	170	java/lang/Throwable
    //   171	173	173	finally
    //   183	188	190	java/lang/Throwable
    //   144	148	209	java/lang/Throwable
    //   63	84	225	finally
    //   5	14	231	java/io/IOException
    //   26	30	231	java/io/IOException
    //   35	43	231	java/io/IOException
    //   43	47	231	java/io/IOException
    //   108	112	231	java/io/IOException
    //   115	123	231	java/io/IOException
    //   144	148	231	java/io/IOException
    //   148	150	231	java/io/IOException
    //   164	168	231	java/io/IOException
    //   210	215	231	java/io/IOException
    //   218	222	231	java/io/IOException
  }
  
  /* Error */
  @Nullable
  @RequiresApi(19)
  private static ByteBuffer mmap(File paramFile)
  {
    // Byte code:
    //   0: new 160	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 195	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 171	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 177	java/nio/channels/FileChannel:size	()J
    //   20: lstore_1
    //   21: aload_0
    //   22: getstatic 183	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   25: lconst_0
    //   26: lload_1
    //   27: invokevirtual 187	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   30: astore_0
    //   31: aload 4
    //   33: ifnull +12 -> 45
    //   36: iconst_0
    //   37: ifeq +19 -> 56
    //   40: aload 4
    //   42: invokevirtual 188	java/io/FileInputStream:close	()V
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: new 157	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 158	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: aload 4
    //   58: invokevirtual 188	java/io/FileInputStream:close	()V
    //   61: aload_0
    //   62: areturn
    //   63: astore_3
    //   64: aload_3
    //   65: athrow
    //   66: astore_0
    //   67: aload 4
    //   69: ifnull +12 -> 81
    //   72: aload_3
    //   73: ifnull +21 -> 94
    //   76: aload 4
    //   78: invokevirtual 188	java/io/FileInputStream:close	()V
    //   81: aload_0
    //   82: athrow
    //   83: astore 4
    //   85: aload_3
    //   86: aload 4
    //   88: invokevirtual 192	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   91: goto -10 -> 81
    //   94: aload 4
    //   96: invokevirtual 188	java/io/FileInputStream:close	()V
    //   99: goto -18 -> 81
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_3
    //   105: goto -38 -> 67
    //   108: astore_0
    //   109: aconst_null
    //   110: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramFile	File
    //   20	7	1	l	long
    //   63	23	3	localThrowable1	java.lang.Throwable
    //   104	1	3	localObject	Object
    //   8	69	4	localFileInputStream	java.io.FileInputStream
    //   83	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   40	45	47	java/lang/Throwable
    //   10	31	63	java/lang/Throwable
    //   64	66	66	finally
    //   76	81	83	java/lang/Throwable
    //   10	31	102	finally
    //   0	10	108	java/io/IOException
    //   40	45	108	java/io/IOException
    //   48	56	108	java/io/IOException
    //   56	61	108	java/io/IOException
    //   76	81	108	java/io/IOException
    //   81	83	108	java/io/IOException
    //   85	91	108	java/io/IOException
    //   94	99	108	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatUtil
 * JD-Core Version:    0.7.0.1
 */