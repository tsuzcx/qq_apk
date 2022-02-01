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
  
  /* Error */
  public static boolean copyToFile(File paramFile, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokevirtual 59	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   5: astore_1
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 62	androidx/core/graphics/TypefaceCompatUtil:copyToFile	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   11: istore_3
    //   12: aload_1
    //   13: invokestatic 64	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   16: iload_3
    //   17: ireturn
    //   18: astore_0
    //   19: goto +6 -> 25
    //   22: astore_0
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 64	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   29: aload_0
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	paramFile	File
    //   0	31	1	paramResources	Resources
    //   0	31	2	paramInt	int
    //   11	6	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	12	18	finally
    //   0	6	22	finally
  }
  
  /* Error */
  public static boolean copyToFile(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 70	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: new 72	java/io/FileOutputStream
    //   13: dup
    //   14: aload_0
    //   15: iconst_0
    //   16: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   19: astore_0
    //   20: sipush 1024
    //   23: newarray byte
    //   25: astore_3
    //   26: aload_1
    //   27: aload_3
    //   28: invokevirtual 81	java/io/InputStream:read	([B)I
    //   31: istore_2
    //   32: iload_2
    //   33: iconst_m1
    //   34: if_icmpeq +13 -> 47
    //   37: aload_0
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 85	java/io/FileOutputStream:write	([BII)V
    //   44: goto -18 -> 26
    //   47: aload_0
    //   48: invokestatic 64	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   51: aload 5
    //   53: invokestatic 89	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   56: iconst_1
    //   57: ireturn
    //   58: astore_1
    //   59: aload_0
    //   60: astore_3
    //   61: aload_1
    //   62: astore_0
    //   63: goto +72 -> 135
    //   66: astore_1
    //   67: goto +11 -> 78
    //   70: astore_0
    //   71: goto +64 -> 135
    //   74: astore_1
    //   75: aload 4
    //   77: astore_0
    //   78: aload_0
    //   79: astore_3
    //   80: new 91	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   87: astore 4
    //   89: aload_0
    //   90: astore_3
    //   91: aload 4
    //   93: ldc 94
    //   95: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_0
    //   100: astore_3
    //   101: aload 4
    //   103: aload_1
    //   104: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_0
    //   112: astore_3
    //   113: ldc 15
    //   115: aload 4
    //   117: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 111	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   123: pop
    //   124: aload_0
    //   125: invokestatic 64	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   128: aload 5
    //   130: invokestatic 89	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload_3
    //   136: invokestatic 64	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   139: aload 5
    //   141: invokestatic 89	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   144: goto +5 -> 149
    //   147: aload_0
    //   148: athrow
    //   149: goto -2 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramFile	File
    //   0	152	1	paramInputStream	java.io.InputStream
    //   31	10	2	i	int
    //   9	127	3	localObject	Object
    //   6	110	4	localStringBuilder	StringBuilder
    //   3	137	5	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    // Exception table:
    //   from	to	target	type
    //   20	26	58	finally
    //   26	32	58	finally
    //   37	44	58	finally
    //   20	26	66	java/io/IOException
    //   26	32	66	java/io/IOException
    //   37	44	66	java/io/IOException
    //   10	20	70	finally
    //   80	89	70	finally
    //   91	99	70	finally
    //   101	111	70	finally
    //   113	124	70	finally
    //   10	20	74	java/io/IOException
  }
  
  @Nullable
  public static File getTempFile(Context paramContext)
  {
    paramContext = paramContext.getCacheDir();
    if (paramContext == null) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(".font");
    ((StringBuilder)localObject1).append(Process.myPid());
    ((StringBuilder)localObject1).append("-");
    ((StringBuilder)localObject1).append(Process.myTid());
    ((StringBuilder)localObject1).append("-");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 0;
    while (i < 100)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(i);
      localObject2 = new File(paramContext, ((StringBuilder)localObject2).toString());
      try
      {
        boolean bool = ((File)localObject2).createNewFile();
        if (bool) {
          return localObject2;
        }
      }
      catch (IOException localIOException)
      {
        label120:
        break label120;
      }
      i += 1;
    }
    return null;
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
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +13 -> 28
    //   18: aload_0
    //   19: ifnull +7 -> 26
    //   22: aload_0
    //   23: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   26: aconst_null
    //   27: areturn
    //   28: new 157	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 161	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   36: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 168	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 174	java/nio/channels/FileChannel:size	()J
    //   49: lstore_3
    //   50: aload_2
    //   51: getstatic 180	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   54: lconst_0
    //   55: lload_3
    //   56: invokevirtual 184	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   59: astore_2
    //   60: aload_1
    //   61: invokevirtual 185	java/io/FileInputStream:close	()V
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aload_1
    //   76: invokevirtual 185	java/io/FileInputStream:close	()V
    //   79: aload_2
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   90: aload_1
    //   91: athrow
    //   92: astore_0
    //   93: aconst_null
    //   94: areturn
    //   95: astore_1
    //   96: goto -17 -> 79
    //   99: astore_0
    //   100: goto -10 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramContext	Context
    //   0	103	1	paramCancellationSignal	android.os.CancellationSignal
    //   0	103	2	paramUri	android.net.Uri
    //   49	7	3	l	long
    // Exception table:
    //   from	to	target	type
    //   40	60	74	java/lang/Throwable
    //   28	40	81	java/lang/Throwable
    //   60	64	81	java/lang/Throwable
    //   79	81	81	java/lang/Throwable
    //   5	14	92	java/io/IOException
    //   22	26	92	java/io/IOException
    //   28	40	92	java/io/IOException
    //   40	60	92	java/io/IOException
    //   60	64	92	java/io/IOException
    //   68	72	92	java/io/IOException
    //   75	79	92	java/io/IOException
    //   79	81	92	java/io/IOException
    //   86	90	92	java/io/IOException
    //   90	92	92	java/io/IOException
    //   75	79	95	java/lang/Throwable
    //   86	90	99	java/lang/Throwable
  }
  
  /* Error */
  @Nullable
  @RequiresApi(19)
  private static ByteBuffer mmap(File paramFile)
  {
    // Byte code:
    //   0: new 157	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 168	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 174	java/nio/channels/FileChannel:size	()J
    //   18: lstore_1
    //   19: aload_3
    //   20: getstatic 180	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   23: lconst_0
    //   24: lload_1
    //   25: invokevirtual 184	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   28: astore_3
    //   29: aload_0
    //   30: invokevirtual 185	java/io/FileInputStream:close	()V
    //   33: aload_3
    //   34: areturn
    //   35: astore_3
    //   36: aload_0
    //   37: invokevirtual 185	java/io/FileInputStream:close	()V
    //   40: aload_3
    //   41: athrow
    //   42: aconst_null
    //   43: areturn
    //   44: astore_0
    //   45: goto -3 -> 42
    //   48: astore_0
    //   49: goto -9 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramFile	File
    //   18	7	1	l	long
    //   13	21	3	localObject	Object
    //   35	6	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   9	29	35	java/lang/Throwable
    //   0	9	44	java/io/IOException
    //   9	29	44	java/io/IOException
    //   29	33	44	java/io/IOException
    //   36	40	44	java/io/IOException
    //   40	42	44	java/io/IOException
    //   36	40	48	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatUtil
 * JD-Core Version:    0.7.0.1
 */