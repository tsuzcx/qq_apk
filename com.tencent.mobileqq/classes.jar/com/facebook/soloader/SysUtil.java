package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public final class SysUtil
{
  private static final byte APK_SIGNATURE_VERSION = 1;
  
  static int copyBytes(RandomAccessFile paramRandomAccessFile, InputStream paramInputStream, int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(paramArrayOfByte, 0, Math.min(paramArrayOfByte.length, paramInt - i));
      if (j == -1) {
        break;
      }
      paramRandomAccessFile.write(paramArrayOfByte, 0, j);
      i += j;
    }
    return i;
  }
  
  public static void deleteOrThrow(File paramFile)
    throws IOException
  {
    if (!paramFile.delete()) {
      throw new IOException("could not delete file " + paramFile);
    }
  }
  
  public static void dumbDeleteRecursive(File paramFile)
    throws IOException
  {
    if (paramFile.isDirectory())
    {
      arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null) {}
    }
    while ((paramFile.delete()) || (!paramFile.exists()))
    {
      File[] arrayOfFile;
      return;
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        dumbDeleteRecursive(arrayOfFile[i]);
        i += 1;
      }
    }
    throw new IOException("could not delete: " + paramFile);
  }
  
  public static void fallocateIfSupported(FileDescriptor paramFileDescriptor, long paramLong)
    throws IOException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      LollipopSysdeps.fallocateIfSupported(paramFileDescriptor, paramLong);
    }
  }
  
  public static int findAbiScore(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if ((paramArrayOfString[i] != null) && (paramString.equals(paramArrayOfString[i]))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  /* Error */
  static void fsyncRecursive(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 69	java/io/File:isDirectory	()Z
    //   4: ifeq +60 -> 64
    //   7: aload_0
    //   8: invokevirtual 73	java/io/File:listFiles	()[Ljava/io/File;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnonnull +30 -> 43
    //   16: new 19	java/io/IOException
    //   19: dup
    //   20: new 48	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   27: ldc 103
    //   29: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 65	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   42: athrow
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: aload_2
    //   47: arraylength
    //   48: if_icmpge +28 -> 76
    //   51: aload_2
    //   52: iload_1
    //   53: aaload
    //   54: invokestatic 105	com/facebook/soloader/SysUtil:fsyncRecursive	(Ljava/io/File;)V
    //   57: iload_1
    //   58: iconst_1
    //   59: iadd
    //   60: istore_1
    //   61: goto -16 -> 45
    //   64: aload_0
    //   65: invokevirtual 108	java/io/File:getPath	()Ljava/lang/String;
    //   68: ldc 110
    //   70: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   73: ifeq +4 -> 77
    //   76: return
    //   77: new 33	java/io/RandomAccessFile
    //   80: dup
    //   81: aload_0
    //   82: ldc 116
    //   84: invokespecial 119	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 123	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   94: invokevirtual 128	java/io/FileDescriptor:sync	()V
    //   97: aload_3
    //   98: ifnull -22 -> 76
    //   101: iconst_0
    //   102: ifeq +17 -> 119
    //   105: aload_3
    //   106: invokevirtual 131	java/io/RandomAccessFile:close	()V
    //   109: return
    //   110: astore_0
    //   111: new 133	java/lang/NullPointerException
    //   114: dup
    //   115: invokespecial 134	java/lang/NullPointerException:<init>	()V
    //   118: athrow
    //   119: aload_3
    //   120: invokevirtual 131	java/io/RandomAccessFile:close	()V
    //   123: return
    //   124: astore_0
    //   125: aload_0
    //   126: athrow
    //   127: astore_2
    //   128: aload_3
    //   129: ifnull +11 -> 140
    //   132: aload_0
    //   133: ifnull +18 -> 151
    //   136: aload_3
    //   137: invokevirtual 131	java/io/RandomAccessFile:close	()V
    //   140: aload_2
    //   141: athrow
    //   142: astore_3
    //   143: aload_0
    //   144: aload_3
    //   145: invokevirtual 138	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   148: goto -8 -> 140
    //   151: aload_3
    //   152: invokevirtual 131	java/io/RandomAccessFile:close	()V
    //   155: goto -15 -> 140
    //   158: astore_2
    //   159: goto -31 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramFile	File
    //   44	17	1	i	int
    //   11	41	2	arrayOfFile	File[]
    //   127	14	2	localObject1	Object
    //   158	1	2	localObject2	Object
    //   87	50	3	localRandomAccessFile	RandomAccessFile
    //   142	10	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   105	109	110	java/lang/Throwable
    //   90	97	124	java/lang/Throwable
    //   125	127	127	finally
    //   136	140	142	java/lang/Throwable
    //   90	97	158	finally
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    int i = 0;
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null) {}
    try
    {
      i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (RuntimeException paramContext)
    {
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return 0;
  }
  
  public static String[] getSupportedAbis()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return new String[] { Build.CPU_ABI, Build.CPU_ABI2 };
    }
    return LollipopSysdeps.getSupportedAbis();
  }
  
  public static byte[] makeApkDepBlock(File paramFile, Context paramContext)
    throws IOException
  {
    File localFile = paramFile.getCanonicalFile();
    paramFile = Parcel.obtain();
    try
    {
      paramFile.writeByte((byte)1);
      paramFile.writeString(localFile.getPath());
      paramFile.writeLong(localFile.lastModified());
      paramFile.writeInt(getAppVersionCode(paramContext));
      paramContext = paramFile.marshall();
      return paramContext;
    }
    finally
    {
      paramFile.recycle();
    }
  }
  
  static void mkdirOrThrow(File paramFile)
    throws IOException
  {
    if ((!paramFile.mkdirs()) && (!paramFile.isDirectory())) {
      throw new IOException("cannot mkdir: " + paramFile);
    }
  }
  
  private static final class LollipopSysdeps
  {
    @DoNotOptimize
    public static void fallocateIfSupported(FileDescriptor paramFileDescriptor, long paramLong)
      throws IOException
    {
      try
      {
        Os.posix_fallocate(paramFileDescriptor, 0L, paramLong);
        return;
      }
      catch (ErrnoException paramFileDescriptor)
      {
        while ((paramFileDescriptor.errno == OsConstants.EOPNOTSUPP) || (paramFileDescriptor.errno == OsConstants.ENOSYS) || (paramFileDescriptor.errno == OsConstants.EINVAL)) {}
        throw new IOException(paramFileDescriptor.toString(), paramFileDescriptor);
      }
    }
    
    @DoNotOptimize
    public static String[] getSupportedAbis()
    {
      return Build.SUPPORTED_ABIS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.soloader.SysUtil
 * JD-Core Version:    0.7.0.1
 */