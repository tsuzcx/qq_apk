package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public final class VFSFileOp
{
  private static final String TAG = "MicroMsg.VFSFileOp";
  
  public static int appendToFile(String paramString, byte[] paramArrayOfByte)
  {
    return appendToFile(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int appendToFile(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length < paramInt1 + paramInt2)) {
      return -2;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      OutputStream localOutputStream = openWrite(paramString, true);
      localObject1 = localOutputStream;
      localObject2 = localOutputStream;
      localOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      return 0;
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        QLog.w("MicroMsg.VFSFileOp", 2, String.format("file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localException.getClass().getSimpleName(), localException.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) + localException);
      }
      return -1;
    }
    finally
    {
      VFSUtils.closeQuietly(localObject2);
    }
  }
  
  public static boolean copyDir(String paramString1, String paramString2)
  {
    paramString1 = VFSUtils.parseUri(paramString1);
    paramString1 = FileSystemManager.instance().resolve(paramString1);
    paramString2 = VFSUtils.parseUri(paramString2);
    return recursiveCopyOrMove(paramString1, FileSystemManager.instance().resolve(paramString2), false);
  }
  
  public static long copyFile(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    FileSystemManager.Resolution localResolution1;
    FileSystemManager.Resolution localResolution2;
    do
    {
      do
      {
        return -1L;
      } while (paramString1.equals(paramString2));
      localResolution1 = FileSystemManager.instance().resolve(VFSUtils.parseUri(paramString1));
      localResolution2 = FileSystemManager.instance().resolve(VFSUtils.parseUri(paramString2));
    } while ((!localResolution1.valid()) || (!localResolution2.valid()));
    try
    {
      long l = localResolution2.fileSystem.copyFile(localResolution2.path, localResolution1.fileSystem, localResolution1.path);
      return l;
    }
    catch (IOException localIOException)
    {
      QLog.e("MicroMsg.VFSFileOp", 1, "Failed to copy file " + paramString1 + " -> " + paramString2 + ": " + localIOException.getMessage());
    }
    return -1L;
  }
  
  public static boolean createNewFile(String paramString)
  {
    boolean bool1 = false;
    try
    {
      paramString = new VFSFile(paramString);
      if (!paramString.exists())
      {
        boolean bool2 = paramString.createNewFile();
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public static boolean deleteDir(String paramString)
  {
    return deleteDir(paramString, true);
  }
  
  public static boolean deleteDir(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = VFSUtils.parseUri(paramString);
      paramString = FileSystemManager.instance().resolve(paramString);
    } while (!paramString.valid());
    return paramString.fileSystem.deleteDir(paramString.path, paramBoolean);
  }
  
  public static boolean deleteFile(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return new VFSFile(paramString).delete();
  }
  
  public static String exportExternalPath(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      QLog.d("MicroMsg.VFSFileOp", 1, "exportExternalPath is called! path is null");
      return null;
    }
    return VFSUtils.resolveRealPath(VFSUtils.parseUri(paramString), paramBoolean);
  }
  
  public static Uri exportExternalUri(VFSFile paramVFSFile, String paramString)
  {
    paramVFSFile = paramVFSFile.getUri();
    Uri localUri = FileSystemManager.instance().exportUri(paramVFSFile);
    if (localUri == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MicroMsg.VFSFileOp", 2, "Cannot get URI for export: " + paramVFSFile);
      }
      paramVFSFile = null;
    }
    do
    {
      do
      {
        return paramVFSFile;
        paramString = VFSFileProvider.vfsUriToContentUri(localUri, paramString);
        paramVFSFile = paramString;
      } while (paramString != null);
      paramVFSFile = paramString;
    } while (!QLog.isColorLevel());
    QLog.w("MicroMsg.VFSFileOp", 2, "Cannot convert export URI to content URI: " + localUri);
    return paramString;
  }
  
  public static boolean fileExists(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      return false;
      paramString = VFSUtils.parseUri(paramString);
      paramString = FileSystemManager.instance().resolve(paramString);
    } while (!paramString.valid());
    return paramString.fileSystem.exists(paramString.path);
  }
  
  public static long fileLength(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      do
      {
        return 0L;
        paramString = VFSUtils.parseUri(paramString);
        paramString = FileSystemManager.instance().resolve(paramString);
      } while (!paramString.valid());
      paramString = paramString.fileSystem.stat(paramString.path);
    } while (paramString == null);
    return paramString.size;
  }
  
  public static long fileModifyTime(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      do
      {
        return 0L;
        paramString = VFSUtils.parseUri(paramString);
        paramString = FileSystemManager.instance().resolve(paramString);
      } while (!paramString.valid());
      paramString = paramString.fileSystem.stat(paramString.path);
    } while (paramString == null);
    return paramString.modifiedTime;
  }
  
  public static String getFileExt(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    paramString = new VFSFile(paramString).getName();
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1)) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  /* Error */
  public static byte[] getFileMD5(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokestatic 242	com/tencent/mm/vfs/VFSFileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: ldc 244
    //   13: invokestatic 250	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   16: astore_2
    //   17: sipush 2048
    //   20: newarray byte
    //   22: astore_3
    //   23: aload_0
    //   24: aload_3
    //   25: invokevirtual 256	java/io/InputStream:read	([B)I
    //   28: istore_1
    //   29: iload_1
    //   30: iflt +20 -> 50
    //   33: aload_2
    //   34: aload_3
    //   35: iconst_0
    //   36: iload_1
    //   37: invokevirtual 259	java/security/MessageDigest:update	([BII)V
    //   40: goto -17 -> 23
    //   43: astore_2
    //   44: aload_0
    //   45: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   48: aconst_null
    //   49: areturn
    //   50: aload_2
    //   51: invokevirtual 263	java/security/MessageDigest:digest	()[B
    //   54: astore_2
    //   55: aload_0
    //   56: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   59: aload_2
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_3
    //   64: aload_0
    //   65: astore_2
    //   66: aload_3
    //   67: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   70: aload_2
    //   71: athrow
    //   72: astore_2
    //   73: aload_0
    //   74: astore_3
    //   75: goto -9 -> 66
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_0
    //   81: goto -37 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    //   28	9	1	i	int
    //   16	18	2	localMessageDigest	java.security.MessageDigest
    //   43	8	2	localException	Exception
    //   54	17	2	localObject1	Object
    //   72	1	2	localObject2	Object
    //   22	53	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	23	43	java/lang/Exception
    //   23	29	43	java/lang/Exception
    //   33	40	43	java/lang/Exception
    //   50	55	43	java/lang/Exception
    //   6	11	61	finally
    //   11	23	72	finally
    //   23	29	72	finally
    //   33	40	72	finally
    //   50	55	72	finally
    //   6	11	78	java/lang/Exception
  }
  
  public static String getFileMD5String(String paramString)
  {
    paramString = getFileMD5(paramString);
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuilder.append(Integer.toString((paramString[i] & 0xFF) + 256, 16).substring(1));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static final String getNameWithoutExt(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      paramString = "";
    }
    String str;
    int i;
    do
    {
      return paramString;
      str = new VFSFile(paramString).getName();
      i = str.lastIndexOf('.');
    } while (i < 0);
    if (i == 0) {
      return "";
    }
    return str.substring(0, i);
  }
  
  public static String getParentAbsolutePath(String paramString)
  {
    return new VFSFile(paramString).getAbsoluteFile().getParent();
  }
  
  public static Iterable<FileSystem.FileEntry> listFiles(String paramString, boolean paramBoolean)
  {
    paramString = VFSUtils.parseUri(paramString);
    paramString = FileSystemManager.instance().resolve(paramString);
    if (!paramString.valid()) {
      return null;
    }
    return paramString.fileSystem.list(paramString.path, paramBoolean);
  }
  
  public static void markNoMedia(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      return;
      paramString = VFSUtils.parseUri(paramString);
      paramString = FileSystemManager.instance().resolve(paramString);
    } while ((!paramString.valid()) || ((paramString.fileSystem.capabilityFlags() & 0x2) == 0) || (paramString.fileSystem.realPath(paramString.path, true) == null));
    try
    {
      paramString.fileSystem.openWrite(paramString.path + "/.nomedia", false).close();
      return;
    }
    catch (IOException paramString) {}
  }
  
  public static boolean mkdirs(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = new VFSFile(paramString);
    } while ((!paramString.mkdirs()) && (!paramString.isDirectory()));
    return true;
  }
  
  public static boolean moveDir(String paramString1, String paramString2)
  {
    Object localObject1 = VFSUtils.parseUri(paramString1);
    localObject1 = FileSystemManager.instance().resolve((Uri)localObject1);
    paramString2 = VFSUtils.parseUri(paramString2);
    paramString2 = FileSystemManager.instance().resolve(paramString2);
    if ((((FileSystemManager.Resolution)localObject1).valid()) && (paramString2.valid()))
    {
      Object localObject3 = ((FileSystemManager.Resolution)localObject1).fileSystem;
      Object localObject2 = paramString2.fileSystem;
      if (((((FileSystem)localObject3).capabilityFlags() & 0xA) == 10) && ((((FileSystem)localObject2).capabilityFlags() & 0xA) == 10))
      {
        localObject3 = ((FileSystem)localObject3).realPath(((FileSystemManager.Resolution)localObject1).path, false);
        localObject2 = ((FileSystem)localObject2).realPath(paramString2.path, true);
        if ((localObject3 == null) || (localObject2 == null) || (!new File((String)localObject3).renameTo(new File((String)localObject2)))) {}
      }
    }
    while ((recursiveCopyOrMove((FileSystemManager.Resolution)localObject1, paramString2, true)) && (deleteDir(paramString1, false))) {
      return true;
    }
    return false;
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    boolean bool1;
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      bool1 = false;
      return bool1;
    }
    FileSystemManager.Resolution localResolution1 = FileSystemManager.instance().resolve(VFSUtils.parseUri(paramString1));
    FileSystemManager.Resolution localResolution2 = FileSystemManager.instance().resolve(VFSUtils.parseUri(paramString2));
    if ((!localResolution1.valid()) || (!localResolution2.valid())) {
      return false;
    }
    for (;;)
    {
      try
      {
        bool2 = localResolution2.fileSystem.moveFile(localResolution2.path, localResolution1.fileSystem, localResolution1.path);
        bool1 = bool2;
        if (bool2) {
          break;
        }
        if (localResolution2.fileSystem.copyFile(localResolution2.path, localResolution1.fileSystem, localResolution1.path) >= 0L)
        {
          bool2 = true;
          bool1 = bool2;
          if (!bool2) {
            break;
          }
          localResolution1.fileSystem.delete(localResolution1.path);
          return bool2;
        }
      }
      catch (IOException localIOException)
      {
        QLog.e("MicroMsg.VFSFileOp", 1, "Failed to move file " + paramString1 + " -> " + paramString2 + ": " + localIOException.getMessage());
        return false;
      }
      boolean bool2 = false;
    }
  }
  
  static ParcelFileDescriptor openFileDescriptor(Uri paramUri, FileSystemManager.Resolution paramResolution, String paramString)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (!paramResolution.valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + paramUri);
    }
    return paramResolution.fileSystem.openParcelFd(paramResolution.path, paramString);
  }
  
  public static ParcelFileDescriptor openFileDescriptor(Uri paramUri, String paramString)
  {
    return openFileDescriptor(paramUri, null, paramString);
  }
  
  public static ParcelFileDescriptor openFileDescriptor(VFSFile paramVFSFile, String paramString)
  {
    return openFileDescriptor(paramVFSFile.getUri(), paramVFSFile.resolve(), paramString);
  }
  
  public static ParcelFileDescriptor openFileDescriptor(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      throw new FileNotFoundException("path is empty");
    }
    return openFileDescriptor(VFSUtils.parseUri(paramString1), null, paramString2);
  }
  
  public static RandomAccessFile openRandomAccess(Uri paramUri, boolean paramBoolean)
  {
    String str = VFSUtils.resolveRealPath(paramUri, paramBoolean);
    if (str == null) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + paramUri);
    }
    if (paramBoolean) {}
    for (paramUri = "rw";; paramUri = "r") {
      return new RandomAccessFile(str, paramUri);
    }
  }
  
  public static RandomAccessFile openRandomAccess(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      throw new FileNotFoundException("path is empty");
    }
    return openRandomAccess(VFSUtils.parseUri(paramString), paramBoolean);
  }
  
  public static InputStream openRead(Uri paramUri)
  {
    return openRead(paramUri, null);
  }
  
  static InputStream openRead(Uri paramUri, FileSystemManager.Resolution paramResolution)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (!paramResolution.valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + paramUri);
    }
    return paramResolution.fileSystem.openRead(paramResolution.path);
  }
  
  public static InputStream openRead(VFSFile paramVFSFile)
  {
    return openRead(paramVFSFile.getUri(), paramVFSFile.resolve());
  }
  
  public static InputStream openRead(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      throw new FileNotFoundException("path is empty");
    }
    return openRead(VFSUtils.parseUri(paramString));
  }
  
  public static ReadableByteChannel openReadChannel(Uri paramUri)
  {
    return openReadChannel(paramUri, null);
  }
  
  static ReadableByteChannel openReadChannel(Uri paramUri, FileSystemManager.Resolution paramResolution)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (!paramResolution.valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + paramUri);
    }
    return paramResolution.fileSystem.openReadChannel(paramResolution.path);
  }
  
  public static ReadableByteChannel openReadChannel(VFSFile paramVFSFile)
  {
    return openReadChannel(paramVFSFile.getUri(), paramVFSFile.resolve());
  }
  
  public static ReadableByteChannel openReadChannel(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      throw new FileNotFoundException("path is empty");
    }
    return openReadChannel(VFSUtils.parseUri(paramString));
  }
  
  public static OutputStream openWrite(Uri paramUri)
  {
    return openWrite(paramUri, false);
  }
  
  static OutputStream openWrite(Uri paramUri, FileSystemManager.Resolution paramResolution, boolean paramBoolean)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (!paramResolution.valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + paramUri);
    }
    return paramResolution.fileSystem.openWrite(paramResolution.path, paramBoolean);
  }
  
  public static OutputStream openWrite(Uri paramUri, boolean paramBoolean)
  {
    return openWrite(paramUri, null, paramBoolean);
  }
  
  public static OutputStream openWrite(VFSFile paramVFSFile)
  {
    return openWrite(paramVFSFile.getUri(), paramVFSFile.resolve(), false);
  }
  
  public static OutputStream openWrite(VFSFile paramVFSFile, boolean paramBoolean)
  {
    return openWrite(paramVFSFile.getUri(), paramVFSFile.resolve(), paramBoolean);
  }
  
  public static OutputStream openWrite(String paramString)
  {
    return openWrite(paramString, false);
  }
  
  public static OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      throw new FileNotFoundException("path is empty");
    }
    return openWrite(VFSUtils.parseUri(paramString), paramBoolean);
  }
  
  public static WritableByteChannel openWriteChannel(Uri paramUri)
  {
    return openWriteChannel(paramUri, false);
  }
  
  static WritableByteChannel openWriteChannel(Uri paramUri, FileSystemManager.Resolution paramResolution, boolean paramBoolean)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (!paramResolution.valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + paramUri);
    }
    return paramResolution.fileSystem.openWriteChannel(paramResolution.path, paramBoolean);
  }
  
  public static WritableByteChannel openWriteChannel(Uri paramUri, boolean paramBoolean)
  {
    return openWriteChannel(paramUri, null, paramBoolean);
  }
  
  public static WritableByteChannel openWriteChannel(VFSFile paramVFSFile)
  {
    return openWriteChannel(paramVFSFile.getUri(), paramVFSFile.resolve(), false);
  }
  
  public static WritableByteChannel openWriteChannel(VFSFile paramVFSFile, boolean paramBoolean)
  {
    return openWriteChannel(paramVFSFile.getUri(), paramVFSFile.resolve(), paramBoolean);
  }
  
  public static WritableByteChannel openWriteChannel(String paramString)
  {
    return openWriteChannel(paramString, false);
  }
  
  public static WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      throw new FileNotFoundException("path is empty");
    }
    return openWriteChannel(VFSUtils.parseUri(paramString), null, paramBoolean);
  }
  
  /* Error */
  public static String readFileAsString(String paramString)
  {
    // Byte code:
    //   0: new 44	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: new 409	java/io/InputStreamReader
    //   12: dup
    //   13: aload_0
    //   14: invokestatic 242	com/tencent/mm/vfs/VFSFileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: invokespecial 412	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: sipush 512
    //   26: newarray char
    //   28: astore 5
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: aload 5
    //   35: invokevirtual 415	java/io/InputStreamReader:read	([C)I
    //   38: istore_1
    //   39: iload_1
    //   40: iconst_m1
    //   41: if_icmpeq +62 -> 103
    //   44: aload_3
    //   45: astore_2
    //   46: aload 4
    //   48: aload 5
    //   50: iconst_0
    //   51: iload_1
    //   52: invokevirtual 418	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: goto -26 -> 30
    //   59: astore 4
    //   61: aload_3
    //   62: astore_2
    //   63: ldc 8
    //   65: iconst_1
    //   66: iconst_3
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: ldc_w 420
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload_0
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: aload 4
    //   84: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
    //   87: aastore
    //   88: invokestatic 423	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   91: aload_3
    //   92: astore_2
    //   93: aload 4
    //   95: athrow
    //   96: astore_0
    //   97: aload_2
    //   98: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   101: aload_0
    //   102: athrow
    //   103: aload_3
    //   104: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   107: aload 4
    //   109: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: areturn
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_2
    //   116: goto -19 -> 97
    //   119: astore 4
    //   121: aconst_null
    //   122: astore_3
    //   123: goto -62 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramString	String
    //   38	14	1	i	int
    //   22	94	2	localInputStreamReader1	java.io.InputStreamReader
    //   20	103	3	localInputStreamReader2	java.io.InputStreamReader
    //   7	40	4	localStringBuilder	StringBuilder
    //   59	49	4	localIOException1	IOException
    //   119	1	4	localIOException2	IOException
    //   28	21	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   23	30	59	java/io/IOException
    //   32	39	59	java/io/IOException
    //   46	56	59	java/io/IOException
    //   23	30	96	finally
    //   32	39	96	finally
    //   46	56	96	finally
    //   63	91	96	finally
    //   93	96	96	finally
    //   9	21	113	finally
    //   9	21	119	java/io/IOException
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +9 -> 10
    //   4: aconst_null
    //   5: astore 6
    //   7: aload 6
    //   9: areturn
    //   10: iload_2
    //   11: iflt +10 -> 21
    //   14: iload_2
    //   15: ldc_w 426
    //   18: if_icmple +263 -> 281
    //   21: sipush 4096
    //   24: istore_3
    //   25: new 428	java/io/ByteArrayOutputStream
    //   28: dup
    //   29: iload_3
    //   30: invokespecial 429	java/io/ByteArrayOutputStream:<init>	(I)V
    //   33: astore 8
    //   35: aload_0
    //   36: invokestatic 242	com/tencent/mm/vfs/VFSFileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore 7
    //   41: iload_1
    //   42: i2l
    //   43: lstore 4
    //   45: lload 4
    //   47: lconst_0
    //   48: lcmp
    //   49: ifle +22 -> 71
    //   52: aload 7
    //   54: astore 6
    //   56: lload 4
    //   58: aload 7
    //   60: lload 4
    //   62: invokevirtual 433	java/io/InputStream:skip	(J)J
    //   65: lsub
    //   66: lstore 4
    //   68: goto -23 -> 45
    //   71: aload 7
    //   73: astore 6
    //   75: sipush 1024
    //   78: newarray byte
    //   80: astore 9
    //   82: iload_2
    //   83: istore_1
    //   84: iload_2
    //   85: ifge +7 -> 92
    //   88: ldc_w 434
    //   91: istore_1
    //   92: aload 7
    //   94: astore 6
    //   96: aload 7
    //   98: aload 9
    //   100: iconst_0
    //   101: iload_1
    //   102: aload 9
    //   104: arraylength
    //   105: invokestatic 440	java/lang/Math:min	(II)I
    //   108: invokevirtual 443	java/io/InputStream:read	([BII)I
    //   111: istore_2
    //   112: iload_2
    //   113: iconst_m1
    //   114: if_icmpeq +27 -> 141
    //   117: iload_1
    //   118: ifle +23 -> 141
    //   121: aload 7
    //   123: astore 6
    //   125: aload 8
    //   127: aload 9
    //   129: iconst_0
    //   130: iload_2
    //   131: invokevirtual 444	java/io/ByteArrayOutputStream:write	([BII)V
    //   134: iload_1
    //   135: iload_2
    //   136: isub
    //   137: istore_1
    //   138: goto -46 -> 92
    //   141: aload 7
    //   143: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   146: aload 8
    //   148: invokevirtual 447	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   151: astore 7
    //   153: aload 8
    //   155: invokevirtual 448	java/io/ByteArrayOutputStream:close	()V
    //   158: aload 7
    //   160: astore 6
    //   162: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq -158 -> 7
    //   168: ldc 8
    //   170: iconst_2
    //   171: ldc_w 450
    //   174: iconst_2
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_0
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload 7
    //   186: arraylength
    //   187: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 72	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokestatic 86	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload 7
    //   199: areturn
    //   200: astore 8
    //   202: aconst_null
    //   203: astore 7
    //   205: aload 7
    //   207: astore 6
    //   209: ldc 8
    //   211: iconst_1
    //   212: new 44	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 452
    //   222: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc_w 454
    //   232: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 8
    //   237: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
    //   240: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload 7
    //   251: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_0
    //   257: aconst_null
    //   258: astore 6
    //   260: aload 6
    //   262: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   265: aload_0
    //   266: athrow
    //   267: astore 6
    //   269: goto -111 -> 158
    //   272: astore_0
    //   273: goto -13 -> 260
    //   276: astore 8
    //   278: goto -73 -> 205
    //   281: iload_2
    //   282: istore_3
    //   283: goto -258 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramString	String
    //   0	286	1	paramInt1	int
    //   0	286	2	paramInt2	int
    //   24	259	3	i	int
    //   43	24	4	l	long
    //   5	256	6	localObject1	Object
    //   267	1	6	localIOException1	IOException
    //   39	211	7	localObject2	Object
    //   33	121	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   200	36	8	localIOException2	IOException
    //   276	1	8	localIOException3	IOException
    //   80	48	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   35	41	200	java/io/IOException
    //   35	41	256	finally
    //   153	158	267	java/io/IOException
    //   56	68	272	finally
    //   75	82	272	finally
    //   96	112	272	finally
    //   125	134	272	finally
    //   209	249	272	finally
    //   56	68	276	java/io/IOException
    //   75	82	276	java/io/IOException
    //   96	112	276	java/io/IOException
    //   125	134	276	java/io/IOException
  }
  
  private static boolean recursiveCopyOrMove(FileSystemManager.Resolution paramResolution1, FileSystemManager.Resolution paramResolution2, boolean paramBoolean)
  {
    if ((!paramResolution1.valid()) || (!paramResolution2.valid())) {
      return false;
    }
    Object localObject = paramResolution1.fileSystem.list(paramResolution1.path, true);
    if (localObject == null) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    paramResolution2.fileSystem.mkdirs(paramResolution2.path);
    localHashSet.add(paramResolution2.path);
    Iterator localIterator = ((Iterable)localObject).iterator();
    FileSystem.FileEntry localFileEntry;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label366;
      }
      localFileEntry = (FileSystem.FileEntry)localIterator.next();
      int i = paramResolution1.path.length();
      String str = localFileEntry.relPath.substring(i);
      localObject = str;
      if (!str.startsWith("/")) {
        localObject = "/" + str;
      }
      localObject = paramResolution2.path + (String)localObject;
      if (localFileEntry.isDirectory)
      {
        if (localHashSet.add(localObject)) {
          paramResolution2.fileSystem.mkdirs((String)localObject);
        }
      }
      else
      {
        i = ((String)localObject).lastIndexOf('/');
        if (i > 0)
        {
          str = ((String)localObject).substring(0, i);
          if (localHashSet.add(str)) {
            paramResolution2.fileSystem.mkdirs(str);
          }
        }
        if (paramBoolean) {
          try
          {
            paramResolution2.fileSystem.moveFile((String)localObject, localFileEntry.fileSystem, localFileEntry.relPath);
          }
          catch (IOException paramResolution1)
          {
            paramResolution2 = new StringBuilder().append("Failed to ");
            if (!paramBoolean) {}
          }
        }
      }
    }
    for (paramResolution1 = "move";; paramResolution1 = "copy")
    {
      QLog.e("MicroMsg.VFSFileOp", 1, paramResolution1 + " files.");
      return false;
      paramResolution2.fileSystem.copyFile((String)localObject, localFileEntry.fileSystem, localFileEntry.relPath);
      break;
    }
    label366:
    return true;
  }
  
  public static boolean renameFile(String paramString1, String paramString2, String paramString3)
  {
    return moveFile(paramString1 + paramString2, paramString1 + paramString3);
  }
  
  /* Error */
  public static int unzipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 505	java/util/zip/ZipInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokestatic 242	com/tencent/mm/vfs/VFSFileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: invokespecial 506	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_0
    //   14: aload_3
    //   15: invokevirtual 510	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +242 -> 264
    //   25: aload_3
    //   26: astore_0
    //   27: aload 4
    //   29: invokevirtual 513	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   32: astore 5
    //   34: aload_3
    //   35: astore_0
    //   36: aload 5
    //   38: ldc_w 515
    //   41: invokevirtual 519	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: ifne -32 -> 12
    //   47: aload_3
    //   48: astore_0
    //   49: aload 5
    //   51: ldc_w 521
    //   54: invokevirtual 519	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   57: ifne -45 -> 12
    //   60: aload_3
    //   61: astore_0
    //   62: aload 4
    //   64: invokevirtual 522	java/util/zip/ZipEntry:isDirectory	()Z
    //   67: ifeq +80 -> 147
    //   70: aload_3
    //   71: astore_0
    //   72: aload 5
    //   74: iconst_0
    //   75: aload 5
    //   77: invokevirtual 114	java/lang/String:length	()I
    //   80: iconst_1
    //   81: isub
    //   82: invokevirtual 275	java/lang/String:substring	(II)Ljava/lang/String;
    //   85: astore 4
    //   87: aload_3
    //   88: astore_0
    //   89: new 151	com/tencent/mm/vfs/VFSFile
    //   92: dup
    //   93: new 44	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   100: aload_1
    //   101: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 482
    //   107: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 4
    //   112: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 154	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 306	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   124: pop
    //   125: goto -113 -> 12
    //   128: astore_1
    //   129: aload_3
    //   130: astore_0
    //   131: ldc 8
    //   133: iconst_1
    //   134: ldc_w 524
    //   137: aload_1
    //   138: invokestatic 527	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload_3
    //   142: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   145: iconst_m1
    //   146: ireturn
    //   147: aload_3
    //   148: astore_0
    //   149: new 151	com/tencent/mm/vfs/VFSFile
    //   152: dup
    //   153: new 44	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   160: aload_1
    //   161: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 482
    //   167: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 5
    //   172: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 154	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   181: invokestatic 529	com/tencent/mm/vfs/VFSFileOp:openWrite	(Lcom/tencent/mm/vfs/VFSFile;)Ljava/io/OutputStream;
    //   184: astore 4
    //   186: aload_3
    //   187: astore_0
    //   188: sipush 1024
    //   191: newarray byte
    //   193: astore 5
    //   195: aload_3
    //   196: astore_0
    //   197: aload_3
    //   198: aload 5
    //   200: invokevirtual 530	java/util/zip/ZipInputStream:read	([B)I
    //   203: istore_2
    //   204: iload_2
    //   205: iconst_m1
    //   206: if_icmpeq +37 -> 243
    //   209: aload_3
    //   210: astore_0
    //   211: aload 4
    //   213: aload 5
    //   215: iconst_0
    //   216: iload_2
    //   217: invokevirtual 30	java/io/OutputStream:write	([BII)V
    //   220: goto -25 -> 195
    //   223: astore_1
    //   224: aload_3
    //   225: astore_0
    //   226: ldc 8
    //   228: iconst_1
    //   229: ldc_w 532
    //   232: aload_1
    //   233: invokestatic 527	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_3
    //   237: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   240: bipush 254
    //   242: ireturn
    //   243: aload_3
    //   244: astore_0
    //   245: aload 4
    //   247: invokevirtual 303	java/io/OutputStream:close	()V
    //   250: goto -238 -> 12
    //   253: astore_3
    //   254: aload_0
    //   255: astore_1
    //   256: aload_3
    //   257: astore_0
    //   258: aload_1
    //   259: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   262: aload_0
    //   263: athrow
    //   264: aload_3
    //   265: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_0
    //   271: aconst_null
    //   272: astore_1
    //   273: goto -15 -> 258
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_3
    //   279: goto -55 -> 224
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_3
    //   285: goto -156 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramString1	String
    //   0	288	1	paramString2	String
    //   203	14	2	i	int
    //   11	233	3	localZipInputStream	java.util.zip.ZipInputStream
    //   253	12	3	localCloseable	java.io.Closeable
    //   278	7	3	localObject1	Object
    //   18	228	4	localObject2	Object
    //   32	182	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	20	128	java/io/FileNotFoundException
    //   27	34	128	java/io/FileNotFoundException
    //   36	47	128	java/io/FileNotFoundException
    //   49	60	128	java/io/FileNotFoundException
    //   62	70	128	java/io/FileNotFoundException
    //   72	87	128	java/io/FileNotFoundException
    //   89	125	128	java/io/FileNotFoundException
    //   149	186	128	java/io/FileNotFoundException
    //   188	195	128	java/io/FileNotFoundException
    //   197	204	128	java/io/FileNotFoundException
    //   211	220	128	java/io/FileNotFoundException
    //   245	250	128	java/io/FileNotFoundException
    //   14	20	223	java/io/IOException
    //   27	34	223	java/io/IOException
    //   36	47	223	java/io/IOException
    //   49	60	223	java/io/IOException
    //   62	70	223	java/io/IOException
    //   72	87	223	java/io/IOException
    //   89	125	223	java/io/IOException
    //   149	186	223	java/io/IOException
    //   188	195	223	java/io/IOException
    //   197	204	223	java/io/IOException
    //   211	220	223	java/io/IOException
    //   245	250	223	java/io/IOException
    //   14	20	253	finally
    //   27	34	253	finally
    //   36	47	253	finally
    //   49	60	253	finally
    //   62	70	253	finally
    //   72	87	253	finally
    //   89	125	253	finally
    //   131	141	253	finally
    //   149	186	253	finally
    //   188	195	253	finally
    //   197	204	253	finally
    //   211	220	253	finally
    //   226	236	253	finally
    //   245	250	253	finally
    //   0	12	270	finally
    //   0	12	276	java/io/IOException
    //   0	12	282	java/io/FileNotFoundException
  }
  
  public static int writeFile(String paramString, byte[] paramArrayOfByte)
  {
    return writeFile(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int writeFile(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return -2;
    }
    if (paramArrayOfByte.length < paramInt1 + paramInt2) {
      return -3;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      OutputStream localOutputStream = openWrite(paramString);
      localObject1 = localOutputStream;
      localObject2 = localOutputStream;
      localOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      return 0;
    }
    catch (IOException paramArrayOfByte)
    {
      localObject2 = localObject1;
      QLog.e("MicroMsg.VFSFileOp", 1, new Object[] { "writeFile '%s' Failed: %s", paramString, paramArrayOfByte.getMessage() });
      return -1;
    }
    finally
    {
      VFSUtils.closeQuietly(localObject2);
    }
  }
  
  public static boolean zipFolder(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      return false;
    }
    return zipFolders(Collections.singletonList(paramString1), paramString2);
  }
  
  /* Error */
  public static boolean zipFolders(java.util.List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 173	java/lang/String:isEmpty	()Z
    //   14: ifeq +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_1
    //   20: invokestatic 552	com/tencent/mm/vfs/VFSFileOp:getParentAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 553	com/tencent/mm/vfs/VFSFileOp:mkdirs	(Ljava/lang/String;)Z
    //   26: pop
    //   27: sipush 4096
    //   30: newarray byte
    //   32: astore 7
    //   34: new 555	java/util/zip/ZipOutputStream
    //   37: dup
    //   38: aload_1
    //   39: invokestatic 537	com/tencent/mm/vfs/VFSFileOp:openWrite	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   42: invokespecial 558	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   45: astore_1
    //   46: aload_0
    //   47: invokeinterface 561 1 0
    //   52: astore 8
    //   54: aload 8
    //   56: invokeinterface 473 1 0
    //   61: ifeq +289 -> 350
    //   64: aload 8
    //   66: invokeinterface 477 1 0
    //   71: checkcast 68	java/lang/String
    //   74: invokestatic 92	com/tencent/mm/vfs/VFSUtils:parseUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   77: astore_0
    //   78: invokestatic 98	com/tencent/mm/vfs/FileSystemManager:instance	()Lcom/tencent/mm/vfs/FileSystemManager;
    //   81: aload_0
    //   82: invokevirtual 102	com/tencent/mm/vfs/FileSystemManager:resolve	(Landroid/net/Uri;)Lcom/tencent/mm/vfs/FileSystemManager$Resolution;
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 125	com/tencent/mm/vfs/FileSystemManager$Resolution:valid	()Z
    //   90: ifeq -36 -> 54
    //   93: aload_0
    //   94: getfield 129	com/tencent/mm/vfs/FileSystemManager$Resolution:fileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   97: aload_0
    //   98: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   101: invokeinterface 211 2 0
    //   106: astore 4
    //   108: aload 4
    //   110: ifnull -56 -> 54
    //   113: aload 4
    //   115: getfield 488	com/tencent/mm/vfs/FileSystem$FileEntry:isDirectory	Z
    //   118: ifeq +176 -> 294
    //   121: aload_0
    //   122: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   125: invokevirtual 114	java/lang/String:length	()I
    //   128: istore_3
    //   129: aload_0
    //   130: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   133: ldc_w 482
    //   136: invokevirtual 564	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   139: ifeq +150 -> 289
    //   142: iconst_0
    //   143: istore_2
    //   144: aload_0
    //   145: getfield 129	com/tencent/mm/vfs/FileSystemManager$Resolution:fileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   148: aload_0
    //   149: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   152: iconst_1
    //   153: invokeinterface 288 3 0
    //   158: astore_0
    //   159: aload_0
    //   160: ifnull -106 -> 54
    //   163: iload_2
    //   164: iload_3
    //   165: iadd
    //   166: istore_2
    //   167: aload_0
    //   168: invokeinterface 468 1 0
    //   173: astore 9
    //   175: aload 9
    //   177: invokeinterface 473 1 0
    //   182: ifeq -128 -> 54
    //   185: aload 9
    //   187: invokeinterface 477 1 0
    //   192: checkcast 213	com/tencent/mm/vfs/FileSystem$FileEntry
    //   195: astore_0
    //   196: aload_0
    //   197: getfield 488	com/tencent/mm/vfs/FileSystem$FileEntry:isDirectory	Z
    //   200: ifne -25 -> 175
    //   203: aload_0
    //   204: getfield 480	com/tencent/mm/vfs/FileSystem$FileEntry:relPath	Ljava/lang/String;
    //   207: invokevirtual 114	java/lang/String:length	()I
    //   210: iload_2
    //   211: if_icmpge +106 -> 317
    //   214: aload_0
    //   215: getfield 567	com/tencent/mm/vfs/FileSystem$FileEntry:name	Ljava/lang/String;
    //   218: astore 4
    //   220: aload_0
    //   221: invokevirtual 570	com/tencent/mm/vfs/FileSystem$FileEntry:openRead	()Ljava/io/InputStream;
    //   224: astore_0
    //   225: aload_1
    //   226: new 512	java/util/zip/ZipEntry
    //   229: dup
    //   230: aload 4
    //   232: invokespecial 571	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   235: invokevirtual 575	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   238: aload_0
    //   239: aload 7
    //   241: invokevirtual 256	java/io/InputStream:read	([B)I
    //   244: istore_3
    //   245: iload_3
    //   246: iflt +84 -> 330
    //   249: aload_1
    //   250: aload 7
    //   252: iconst_0
    //   253: iload_3
    //   254: invokevirtual 576	java/util/zip/ZipOutputStream:write	([BII)V
    //   257: goto -19 -> 238
    //   260: astore 4
    //   262: aload_1
    //   263: astore 4
    //   265: aload_0
    //   266: astore_1
    //   267: aload 4
    //   269: astore_0
    //   270: ldc 8
    //   272: iconst_1
    //   273: ldc_w 578
    //   276: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_1
    //   280: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   283: aload_0
    //   284: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   287: iconst_0
    //   288: ireturn
    //   289: iconst_1
    //   290: istore_2
    //   291: goto -147 -> 144
    //   294: aload_0
    //   295: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   298: bipush 47
    //   300: invokevirtual 232	java/lang/String:lastIndexOf	(I)I
    //   303: istore_2
    //   304: aload 4
    //   306: invokestatic 546	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   309: astore_0
    //   310: iload_2
    //   311: iconst_1
    //   312: iadd
    //   313: istore_2
    //   314: goto -147 -> 167
    //   317: aload_0
    //   318: getfield 480	com/tencent/mm/vfs/FileSystem$FileEntry:relPath	Ljava/lang/String;
    //   321: iload_2
    //   322: invokevirtual 236	java/lang/String:substring	(I)Ljava/lang/String;
    //   325: astore 4
    //   327: goto -107 -> 220
    //   330: aload_0
    //   331: invokevirtual 579	java/io/InputStream:close	()V
    //   334: aload_1
    //   335: invokevirtual 582	java/util/zip/ZipOutputStream:closeEntry	()V
    //   338: goto -163 -> 175
    //   341: astore_0
    //   342: aload_1
    //   343: astore_0
    //   344: aload 5
    //   346: astore_1
    //   347: goto -77 -> 270
    //   350: aconst_null
    //   351: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   354: aload_1
    //   355: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   358: iconst_1
    //   359: ireturn
    //   360: astore_0
    //   361: aconst_null
    //   362: astore 4
    //   364: aload 6
    //   366: astore_1
    //   367: aload_1
    //   368: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   371: aload 4
    //   373: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   376: aload_0
    //   377: athrow
    //   378: astore_0
    //   379: aload_1
    //   380: astore 4
    //   382: aload 6
    //   384: astore_1
    //   385: goto -18 -> 367
    //   388: astore 4
    //   390: aload_0
    //   391: astore 5
    //   393: aload 4
    //   395: astore_0
    //   396: aload_1
    //   397: astore 4
    //   399: aload 5
    //   401: astore_1
    //   402: goto -35 -> 367
    //   405: astore 5
    //   407: aload_0
    //   408: astore 4
    //   410: aload 5
    //   412: astore_0
    //   413: goto -46 -> 367
    //   416: astore_0
    //   417: aconst_null
    //   418: astore_0
    //   419: aload 5
    //   421: astore_1
    //   422: goto -152 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	paramList	java.util.List<String>
    //   0	425	1	paramString	String
    //   143	179	2	i	int
    //   128	126	3	j	int
    //   106	125	4	localObject1	Object
    //   260	1	4	localIOException	IOException
    //   263	118	4	str	String
    //   388	6	4	localObject2	Object
    //   397	12	4	localObject3	Object
    //   4	396	5	localList	java.util.List<String>
    //   405	15	5	localObject4	Object
    //   1	382	6	localObject5	Object
    //   32	219	7	arrayOfByte	byte[]
    //   52	13	8	localIterator1	Iterator
    //   173	13	9	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   225	238	260	java/io/IOException
    //   238	245	260	java/io/IOException
    //   249	257	260	java/io/IOException
    //   330	334	260	java/io/IOException
    //   46	54	341	java/io/IOException
    //   54	108	341	java/io/IOException
    //   113	142	341	java/io/IOException
    //   144	159	341	java/io/IOException
    //   167	175	341	java/io/IOException
    //   175	220	341	java/io/IOException
    //   220	225	341	java/io/IOException
    //   294	310	341	java/io/IOException
    //   317	327	341	java/io/IOException
    //   334	338	341	java/io/IOException
    //   34	46	360	finally
    //   46	54	378	finally
    //   54	108	378	finally
    //   113	142	378	finally
    //   144	159	378	finally
    //   167	175	378	finally
    //   175	220	378	finally
    //   220	225	378	finally
    //   294	310	378	finally
    //   317	327	378	finally
    //   334	338	378	finally
    //   225	238	388	finally
    //   238	245	388	finally
    //   249	257	388	finally
    //   330	334	388	finally
    //   270	279	405	finally
    //   34	46	416	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileOp
 * JD-Core Version:    0.7.0.1
 */