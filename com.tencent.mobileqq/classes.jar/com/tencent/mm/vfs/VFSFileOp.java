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
  
  /* Error */
  public static int appendToFile(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +190 -> 191
    //   4: aload_1
    //   5: arraylength
    //   6: ifeq +185 -> 191
    //   9: aload_1
    //   10: arraylength
    //   11: iload_2
    //   12: iload_3
    //   13: iadd
    //   14: if_icmpge +6 -> 20
    //   17: goto +174 -> 191
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore 4
    //   26: aload_0
    //   27: iconst_1
    //   28: invokestatic 24	com/tencent/mm/vfs/VFSFileOp:openWrite	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   31: astore 6
    //   33: aload 6
    //   35: astore 4
    //   37: aload 6
    //   39: astore 5
    //   41: aload 6
    //   43: aload_1
    //   44: iload_2
    //   45: iload_3
    //   46: invokevirtual 30	java/io/OutputStream:write	([BII)V
    //   49: aload 6
    //   51: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   54: iconst_0
    //   55: ireturn
    //   56: astore_0
    //   57: goto +127 -> 184
    //   60: astore 6
    //   62: aload 5
    //   64: astore 4
    //   66: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +108 -> 177
    //   72: aload 5
    //   74: astore 4
    //   76: new 44	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   83: astore 7
    //   85: aload 5
    //   87: astore 4
    //   89: aload 7
    //   91: ldc 47
    //   93: bipush 6
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload 6
    //   102: invokevirtual 51	java/lang/Object:getClass	()Ljava/lang/Class;
    //   105: invokevirtual 57	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload 6
    //   113: invokevirtual 60	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   116: aastore
    //   117: dup
    //   118: iconst_2
    //   119: aload_0
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: aload_1
    //   124: arraylength
    //   125: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: dup
    //   130: iconst_4
    //   131: iload_2
    //   132: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_5
    //   138: iload_3
    //   139: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: aastore
    //   143: invokestatic 72	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   146: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 5
    //   152: astore 4
    //   154: aload 7
    //   156: aload 6
    //   158: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 5
    //   164: astore 4
    //   166: ldc 8
    //   168: iconst_2
    //   169: aload 7
    //   171: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 86	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 5
    //   179: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   182: iconst_m1
    //   183: ireturn
    //   184: aload 4
    //   186: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   189: aload_0
    //   190: athrow
    //   191: bipush 254
    //   193: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramString	String
    //   0	194	1	paramArrayOfByte	byte[]
    //   0	194	2	paramInt1	int
    //   0	194	3	paramInt2	int
    //   24	161	4	localObject1	Object
    //   21	157	5	localObject2	Object
    //   31	19	6	localOutputStream	OutputStream
    //   60	97	6	localException	java.lang.Exception
    //   83	87	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   26	33	56	finally
    //   41	49	56	finally
    //   66	72	56	finally
    //   76	85	56	finally
    //   89	150	56	finally
    //   154	162	56	finally
    //   166	177	56	finally
    //   26	33	60	java/lang/Exception
    //   41	49	60	java/lang/Exception
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
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return -1L;
      }
      if (paramString1.equals(paramString2)) {
        return -1L;
      }
      FileSystemManager.Resolution localResolution = FileSystemManager.instance().resolve(VFSUtils.parseUri(paramString1));
      Object localObject = FileSystemManager.instance().resolve(VFSUtils.parseUri(paramString2));
      if (localResolution.valid())
      {
        if (!((FileSystemManager.Resolution)localObject).valid()) {
          return -1L;
        }
        try
        {
          long l = ((FileSystemManager.Resolution)localObject).fileSystem.copyFile(((FileSystemManager.Resolution)localObject).path, localResolution.fileSystem, localResolution.path);
          return l;
        }
        catch (IOException localIOException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to copy file ");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(" -> ");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(": ");
          ((StringBuilder)localObject).append(localIOException.getMessage());
          QLog.e("MicroMsg.VFSFileOp", 1, ((StringBuilder)localObject).toString());
        }
      }
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
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = VFSUtils.parseUri(paramString);
      paramString = FileSystemManager.instance().resolve(paramString);
      if (!paramString.valid()) {
        return false;
      }
      return paramString.fileSystem.deleteDir(paramString.path, paramBoolean);
    }
    return false;
  }
  
  public static boolean deleteFile(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return new VFSFile(paramString).delete();
    }
    return false;
  }
  
  public static String exportExternalPath(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      String str = VFSUtils.resolveRealPath(VFSUtils.parseUri(paramString), paramBoolean);
      paramString = str;
      if (str != null)
      {
        paramString = str;
        if (!str.startsWith("/"))
        {
          paramString = new StringBuilder();
          paramString.append("/");
          paramString.append(str);
          paramString = paramString.toString();
        }
      }
      return paramString;
    }
    QLog.d("MicroMsg.VFSFileOp", 1, "exportExternalPath is called! path is null");
    return null;
  }
  
  public static Uri exportExternalUri(VFSFile paramVFSFile, String paramString)
  {
    Object localObject = paramVFSFile.getUri();
    paramVFSFile = FileSystemManager.instance().exportUri((Uri)localObject);
    if (paramVFSFile == null)
    {
      if (QLog.isColorLevel())
      {
        paramVFSFile = new StringBuilder();
        paramVFSFile.append("Cannot get URI for export: ");
        paramVFSFile.append(localObject);
        QLog.w("MicroMsg.VFSFileOp", 2, paramVFSFile.toString());
      }
      return null;
    }
    paramString = VFSFileProvider.vfsUriToContentUri(paramVFSFile, paramString);
    if ((paramString == null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot convert export URI to content URI: ");
      ((StringBuilder)localObject).append(paramVFSFile);
      QLog.w("MicroMsg.VFSFileOp", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return false;
      }
      paramString = VFSUtils.parseUri(paramString);
      paramString = FileSystemManager.instance().resolve(paramString);
      if (!paramString.valid()) {
        return false;
      }
      return paramString.fileSystem.exists(paramString.path);
    }
    return false;
  }
  
  public static long fileLength(String paramString)
  {
    long l = 0L;
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return 0L;
      }
      paramString = VFSUtils.parseUri(paramString);
      paramString = FileSystemManager.instance().resolve(paramString);
      if (!paramString.valid()) {
        return 0L;
      }
      paramString = paramString.fileSystem.stat(paramString.path);
      if (paramString == null) {
        return 0L;
      }
      l = paramString.size;
    }
    return l;
  }
  
  public static long fileModifyTime(String paramString)
  {
    long l = 0L;
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return 0L;
      }
      paramString = VFSUtils.parseUri(paramString);
      paramString = FileSystemManager.instance().resolve(paramString);
      if (!paramString.valid()) {
        return 0L;
      }
      paramString = paramString.fileSystem.stat(paramString.path);
      if (paramString == null) {
        return 0L;
      }
      l = paramString.modifiedTime;
    }
    return l;
  }
  
  public static String getFileExt(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "";
      }
      paramString = new VFSFile(paramString).getName();
      int i = paramString.lastIndexOf('.');
      if (i > 0)
      {
        if (i == paramString.length() - 1) {
          return "";
        }
        return paramString.substring(i + 1);
      }
    }
    return "";
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
    //   7: invokestatic 247	com/tencent/mm/vfs/VFSFileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: ldc 249
    //   13: invokestatic 255	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   16: astore_2
    //   17: sipush 2048
    //   20: newarray byte
    //   22: astore_3
    //   23: aload_0
    //   24: aload_3
    //   25: invokevirtual 261	java/io/InputStream:read	([B)I
    //   28: istore_1
    //   29: iload_1
    //   30: iflt +13 -> 43
    //   33: aload_2
    //   34: aload_3
    //   35: iconst_0
    //   36: iload_1
    //   37: invokevirtual 264	java/security/MessageDigest:update	([BII)V
    //   40: goto -17 -> 23
    //   43: aload_2
    //   44: invokevirtual 268	java/security/MessageDigest:digest	()[B
    //   47: astore_2
    //   48: aload_0
    //   49: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   52: aload_2
    //   53: areturn
    //   54: astore_2
    //   55: aload_0
    //   56: astore_3
    //   57: goto +8 -> 65
    //   60: astore_0
    //   61: aconst_null
    //   62: astore_3
    //   63: aload_0
    //   64: astore_2
    //   65: aload_3
    //   66: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   69: aload_2
    //   70: athrow
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: goto -9 -> 71
    //   83: astore_2
    //   84: goto -11 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramString	String
    //   28	9	1	i	int
    //   16	37	2	localObject1	Object
    //   54	1	2	localObject2	Object
    //   64	6	2	str	String
    //   83	1	2	localException	java.lang.Exception
    //   22	44	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	23	54	finally
    //   23	29	54	finally
    //   33	40	54	finally
    //   43	48	54	finally
    //   6	11	60	finally
    //   6	11	79	java/lang/Exception
    //   11	23	83	java/lang/Exception
    //   23	29	83	java/lang/Exception
    //   33	40	83	java/lang/Exception
    //   43	48	83	java/lang/Exception
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
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "";
      }
      String str = new VFSFile(paramString).getName();
      int i = str.lastIndexOf('.');
      if (i < 0) {
        return paramString;
      }
      if (i == 0) {
        return "";
      }
      return str.substring(0, i);
    }
    return "";
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
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return;
      }
      paramString = VFSUtils.parseUri(paramString);
      paramString = FileSystemManager.instance().resolve(paramString);
      if (!paramString.valid()) {
        return;
      }
      if ((paramString.fileSystem.capabilityFlags() & 0x2) == 0) {
        return;
      }
      if (paramString.fileSystem.realPath(paramString.path, true) == null) {
        return;
      }
    }
    try
    {
      FileSystem localFileSystem = paramString.fileSystem;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.path);
      localStringBuilder.append("/.nomedia");
      localFileSystem.openWrite(localStringBuilder.toString(), false).close();
      return;
    }
    catch (IOException paramString) {}
  }
  
  public static boolean mkdirs(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = new VFSFile(paramString);
      if (!paramString.mkdirs())
      {
        bool1 = bool2;
        if (!paramString.isDirectory()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean moveDir(String paramString1, String paramString2)
  {
    Object localObject1 = VFSUtils.parseUri(paramString1);
    localObject1 = FileSystemManager.instance().resolve((Uri)localObject1);
    paramString2 = VFSUtils.parseUri(paramString2);
    paramString2 = FileSystemManager.instance().resolve(paramString2);
    boolean bool1 = ((FileSystemManager.Resolution)localObject1).valid();
    boolean bool2 = false;
    if ((bool1) && (paramString2.valid()))
    {
      Object localObject3 = ((FileSystemManager.Resolution)localObject1).fileSystem;
      Object localObject2 = paramString2.fileSystem;
      if (((((FileSystem)localObject3).capabilityFlags() & 0xA) == 10) && ((((FileSystem)localObject2).capabilityFlags() & 0xA) == 10))
      {
        localObject3 = ((FileSystem)localObject3).realPath(((FileSystemManager.Resolution)localObject1).path, false);
        localObject2 = ((FileSystem)localObject2).realPath(paramString2.path, true);
        if ((localObject3 != null) && (localObject2 != null) && (new File((String)localObject3).renameTo(new File((String)localObject2)))) {
          return true;
        }
      }
    }
    bool1 = bool2;
    if (recursiveCopyOrMove((FileSystemManager.Resolution)localObject1, paramString2, true))
    {
      bool1 = bool2;
      if (deleteDir(paramString1, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    FileSystemManager.Resolution localResolution;
    Object localObject;
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() != 0))
    {
      if (paramString2.length() == 0) {
        return false;
      }
      localResolution = FileSystemManager.instance().resolve(VFSUtils.parseUri(paramString1));
      localObject = FileSystemManager.instance().resolve(VFSUtils.parseUri(paramString2));
      if (localResolution.valid()) {
        if (!((FileSystemManager.Resolution)localObject).valid()) {
          return false;
        }
      }
    }
    for (;;)
    {
      try
      {
        bool1 = ((FileSystemManager.Resolution)localObject).fileSystem.moveFile(((FileSystemManager.Resolution)localObject).path, localResolution.fileSystem, localResolution.path);
        boolean bool2 = bool1;
        if (!bool1)
        {
          if (((FileSystemManager.Resolution)localObject).fileSystem.copyFile(((FileSystemManager.Resolution)localObject).path, localResolution.fileSystem, localResolution.path) < 0L) {
            break label233;
          }
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            localResolution.fileSystem.delete(localResolution.path);
            bool2 = bool1;
          }
        }
        return bool2;
      }
      catch (IOException localIOException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to move file ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" -> ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append(localIOException.getMessage());
        QLog.e("MicroMsg.VFSFileOp", 1, ((StringBuilder)localObject).toString());
      }
      return false;
      label233:
      boolean bool1 = false;
    }
  }
  
  static ParcelFileDescriptor openFileDescriptor(Uri paramUri, FileSystemManager.Resolution paramResolution, String paramString)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (paramResolution.valid()) {
      return paramResolution.fileSystem.openParcelFd(paramResolution.path, paramString);
    }
    paramResolution = new StringBuilder();
    paramResolution.append("Cannot resolve path or URI: ");
    paramResolution.append(paramUri);
    throw new FileNotFoundException(paramResolution.toString());
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
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      return openFileDescriptor(VFSUtils.parseUri(paramString1), null, paramString2);
    }
    throw new FileNotFoundException("path is empty");
  }
  
  public static RandomAccessFile openRandomAccess(Uri paramUri, boolean paramBoolean)
  {
    Object localObject = VFSUtils.resolveRealPath(paramUri, paramBoolean);
    if (localObject != null)
    {
      if (paramBoolean) {
        paramUri = "rw";
      } else {
        paramUri = "r";
      }
      return new RandomAccessFile((String)localObject, paramUri);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot resolve path or URI: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public static RandomAccessFile openRandomAccess(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return openRandomAccess(VFSUtils.parseUri(paramString), paramBoolean);
    }
    throw new FileNotFoundException("path is empty");
  }
  
  public static InputStream openRead(Uri paramUri)
  {
    return openRead(paramUri, null);
  }
  
  static InputStream openRead(Uri paramUri, FileSystemManager.Resolution paramResolution)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (paramResolution.valid()) {
      return paramResolution.fileSystem.openRead(paramResolution.path);
    }
    paramResolution = new StringBuilder();
    paramResolution.append("Cannot resolve path or URI: ");
    paramResolution.append(paramUri);
    throw new FileNotFoundException(paramResolution.toString());
  }
  
  public static InputStream openRead(VFSFile paramVFSFile)
  {
    return openRead(paramVFSFile.getUri(), paramVFSFile.resolve());
  }
  
  public static InputStream openRead(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return openRead(VFSUtils.parseUri(paramString));
    }
    throw new FileNotFoundException("path is empty");
  }
  
  public static ReadableByteChannel openReadChannel(Uri paramUri)
  {
    return openReadChannel(paramUri, null);
  }
  
  static ReadableByteChannel openReadChannel(Uri paramUri, FileSystemManager.Resolution paramResolution)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (paramResolution.valid()) {
      return paramResolution.fileSystem.openReadChannel(paramResolution.path);
    }
    paramResolution = new StringBuilder();
    paramResolution.append("Cannot resolve path or URI: ");
    paramResolution.append(paramUri);
    throw new FileNotFoundException(paramResolution.toString());
  }
  
  public static ReadableByteChannel openReadChannel(VFSFile paramVFSFile)
  {
    return openReadChannel(paramVFSFile.getUri(), paramVFSFile.resolve());
  }
  
  public static ReadableByteChannel openReadChannel(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return openReadChannel(VFSUtils.parseUri(paramString));
    }
    throw new FileNotFoundException("path is empty");
  }
  
  public static OutputStream openWrite(Uri paramUri)
  {
    return openWrite(paramUri, false);
  }
  
  static OutputStream openWrite(Uri paramUri, FileSystemManager.Resolution paramResolution, boolean paramBoolean)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (paramResolution.valid()) {
      return paramResolution.fileSystem.openWrite(paramResolution.path, paramBoolean);
    }
    paramResolution = new StringBuilder();
    paramResolution.append("Cannot resolve path or URI: ");
    paramResolution.append(paramUri);
    throw new FileNotFoundException(paramResolution.toString());
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
    if ((paramString != null) && (!paramString.isEmpty())) {
      return openWrite(VFSUtils.parseUri(paramString), paramBoolean);
    }
    throw new FileNotFoundException("path is empty");
  }
  
  public static WritableByteChannel openWriteChannel(Uri paramUri)
  {
    return openWriteChannel(paramUri, false);
  }
  
  static WritableByteChannel openWriteChannel(Uri paramUri, FileSystemManager.Resolution paramResolution, boolean paramBoolean)
  {
    paramResolution = FileSystemManager.instance().resolve(paramUri, paramResolution);
    if (paramResolution.valid()) {
      return paramResolution.fileSystem.openWriteChannel(paramResolution.path, paramBoolean);
    }
    paramResolution = new StringBuilder();
    paramResolution.append("Cannot resolve path or URI: ");
    paramResolution.append(paramUri);
    throw new FileNotFoundException(paramResolution.toString());
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
    if ((paramString != null) && (!paramString.isEmpty())) {
      return openWriteChannel(VFSUtils.parseUri(paramString), null, paramBoolean);
    }
    throw new FileNotFoundException("path is empty");
  }
  
  /* Error */
  public static String readFileAsString(String paramString)
  {
    // Byte code:
    //   0: new 44	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_2
    //   14: new 414	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokestatic 247	com/tencent/mm/vfs/VFSFileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: invokespecial 417	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: astore_3
    //   26: sipush 512
    //   29: newarray char
    //   31: astore_2
    //   32: aload_3
    //   33: aload_2
    //   34: invokevirtual 420	java/io/InputStreamReader:read	([C)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpeq +15 -> 55
    //   43: aload 5
    //   45: aload_2
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 423	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: goto -20 -> 32
    //   55: aload_3
    //   56: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   59: aload 5
    //   61: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: areturn
    //   65: astore_0
    //   66: aload_3
    //   67: astore_2
    //   68: goto +54 -> 122
    //   71: astore 4
    //   73: goto +14 -> 87
    //   76: astore_0
    //   77: goto +45 -> 122
    //   80: astore_2
    //   81: aload 4
    //   83: astore_3
    //   84: aload_2
    //   85: astore 4
    //   87: aload_3
    //   88: astore_2
    //   89: ldc 8
    //   91: iconst_1
    //   92: iconst_3
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: ldc_w 425
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: aload_0
    //   105: aastore
    //   106: dup
    //   107: iconst_2
    //   108: aload 4
    //   110: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 428	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   117: aload_3
    //   118: astore_2
    //   119: aload 4
    //   121: athrow
    //   122: aload_2
    //   123: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   126: goto +5 -> 131
    //   129: aload_0
    //   130: athrow
    //   131: goto -2 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   37	11	1	i	int
    //   13	55	2	localObject1	Object
    //   80	5	2	localIOException1	IOException
    //   88	35	2	localObject2	Object
    //   25	93	3	localObject3	Object
    //   10	1	4	localObject4	Object
    //   71	11	4	localIOException2	IOException
    //   85	35	4	localObject5	Object
    //   7	53	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   26	32	65	finally
    //   32	38	65	finally
    //   43	52	65	finally
    //   26	32	71	java/io/IOException
    //   32	38	71	java/io/IOException
    //   43	52	71	java/io/IOException
    //   14	26	76	finally
    //   89	117	76	finally
    //   119	122	76	finally
    //   14	26	80	java/io/IOException
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: iload_2
    //   7: iflt +18 -> 25
    //   10: iload_2
    //   11: ldc_w 431
    //   14: if_icmple +6 -> 20
    //   17: goto +8 -> 25
    //   20: iload_2
    //   21: istore_3
    //   22: goto +7 -> 29
    //   25: sipush 4096
    //   28: istore_3
    //   29: new 433	java/io/ByteArrayOutputStream
    //   32: dup
    //   33: iload_3
    //   34: invokespecial 434	java/io/ByteArrayOutputStream:<init>	(I)V
    //   37: astore 8
    //   39: aload_0
    //   40: invokestatic 247	com/tencent/mm/vfs/VFSFileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   43: astore 7
    //   45: iload_1
    //   46: i2l
    //   47: lstore 4
    //   49: lload 4
    //   51: lconst_0
    //   52: lcmp
    //   53: ifle +22 -> 75
    //   56: aload 7
    //   58: astore 6
    //   60: lload 4
    //   62: aload 7
    //   64: lload 4
    //   66: invokevirtual 438	java/io/InputStream:skip	(J)J
    //   69: lsub
    //   70: lstore 4
    //   72: goto -23 -> 49
    //   75: aload 7
    //   77: astore 6
    //   79: sipush 1024
    //   82: newarray byte
    //   84: astore 9
    //   86: iload_2
    //   87: istore_1
    //   88: iload_2
    //   89: ifge +7 -> 96
    //   92: ldc_w 439
    //   95: istore_1
    //   96: aload 7
    //   98: astore 6
    //   100: aload 7
    //   102: aload 9
    //   104: iconst_0
    //   105: iload_1
    //   106: aload 9
    //   108: arraylength
    //   109: invokestatic 445	java/lang/Math:min	(II)I
    //   112: invokevirtual 448	java/io/InputStream:read	([BII)I
    //   115: istore_2
    //   116: iload_2
    //   117: iconst_m1
    //   118: if_icmpeq +27 -> 145
    //   121: iload_1
    //   122: ifle +23 -> 145
    //   125: aload 7
    //   127: astore 6
    //   129: aload 8
    //   131: aload 9
    //   133: iconst_0
    //   134: iload_2
    //   135: invokevirtual 449	java/io/ByteArrayOutputStream:write	([BII)V
    //   138: iload_1
    //   139: iload_2
    //   140: isub
    //   141: istore_1
    //   142: goto -46 -> 96
    //   145: aload 7
    //   147: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   150: aload 8
    //   152: invokevirtual 452	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   155: astore 6
    //   157: aload 8
    //   159: invokevirtual 453	java/io/ByteArrayOutputStream:close	()V
    //   162: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +32 -> 197
    //   168: ldc 8
    //   170: iconst_2
    //   171: ldc_w 455
    //   174: iconst_2
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_0
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload 6
    //   186: arraylength
    //   187: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 72	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokestatic 86	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload 6
    //   199: areturn
    //   200: astore 8
    //   202: goto +15 -> 217
    //   205: astore_0
    //   206: aconst_null
    //   207: astore 6
    //   209: goto +96 -> 305
    //   212: astore 8
    //   214: aconst_null
    //   215: astore 7
    //   217: aload 7
    //   219: astore 6
    //   221: new 44	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   228: astore 9
    //   230: aload 7
    //   232: astore 6
    //   234: aload 9
    //   236: ldc_w 457
    //   239: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 7
    //   245: astore 6
    //   247: aload 9
    //   249: aload_0
    //   250: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 7
    //   256: astore 6
    //   258: aload 9
    //   260: ldc_w 459
    //   263: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 7
    //   269: astore 6
    //   271: aload 9
    //   273: aload 8
    //   275: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 7
    //   284: astore 6
    //   286: ldc 8
    //   288: iconst_1
    //   289: aload 9
    //   291: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload 7
    //   299: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   302: aconst_null
    //   303: areturn
    //   304: astore_0
    //   305: aload 6
    //   307: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   310: goto +5 -> 315
    //   313: aload_0
    //   314: athrow
    //   315: goto -2 -> 313
    //   318: astore 7
    //   320: goto -158 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramString	String
    //   0	323	1	paramInt1	int
    //   0	323	2	paramInt2	int
    //   21	13	3	i	int
    //   47	24	4	l	long
    //   58	248	6	localObject1	Object
    //   43	255	7	localInputStream	InputStream
    //   318	1	7	localIOException1	IOException
    //   37	121	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   200	1	8	localIOException2	IOException
    //   212	62	8	localIOException3	IOException
    //   84	206	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   60	72	200	java/io/IOException
    //   79	86	200	java/io/IOException
    //   100	116	200	java/io/IOException
    //   129	138	200	java/io/IOException
    //   39	45	205	finally
    //   39	45	212	java/io/IOException
    //   60	72	304	finally
    //   79	86	304	finally
    //   100	116	304	finally
    //   129	138	304	finally
    //   221	230	304	finally
    //   234	243	304	finally
    //   247	254	304	finally
    //   258	267	304	finally
    //   271	282	304	finally
    //   286	297	304	finally
    //   157	162	318	java/io/IOException
  }
  
  private static boolean recursiveCopyOrMove(FileSystemManager.Resolution paramResolution1, FileSystemManager.Resolution paramResolution2, boolean paramBoolean)
  {
    if (paramResolution1.valid())
    {
      if (!paramResolution2.valid()) {
        return false;
      }
      Object localObject1 = paramResolution1.fileSystem.list(paramResolution1.path, true);
      if (localObject1 == null) {
        return false;
      }
      HashSet localHashSet = new HashSet();
      paramResolution2.fileSystem.mkdirs(paramResolution2.path);
      localHashSet.add(paramResolution2.path);
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        FileSystem.FileEntry localFileEntry = (FileSystem.FileEntry)localIterator.next();
        int i = paramResolution1.path.length();
        Object localObject2 = localFileEntry.relPath.substring(i);
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("/"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramResolution2.path);
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        if (localFileEntry.isDirectory)
        {
          if (localHashSet.add(localObject1)) {
            paramResolution2.fileSystem.mkdirs((String)localObject1);
          }
        }
        else
        {
          i = ((String)localObject1).lastIndexOf('/');
          if (i > 0)
          {
            localObject2 = ((String)localObject1).substring(0, i);
            if (localHashSet.add(localObject2)) {
              paramResolution2.fileSystem.mkdirs((String)localObject2);
            }
          }
          if (!paramBoolean) {}
        }
        try
        {
          paramResolution2.fileSystem.moveFile((String)localObject1, localFileEntry.fileSystem, localFileEntry.relPath);
        }
        catch (IOException paramResolution1)
        {
          break label332;
        }
        paramResolution2.fileSystem.copyFile((String)localObject1, localFileEntry.fileSystem, localFileEntry.relPath);
        continue;
        label332:
        paramResolution2 = new StringBuilder();
        paramResolution2.append("Failed to ");
        if (paramBoolean) {
          paramResolution1 = "move";
        } else {
          paramResolution1 = "copy";
        }
        paramResolution2.append(paramResolution1);
        paramResolution2.append(" files.");
        QLog.e("MicroMsg.VFSFileOp", 1, paramResolution2.toString());
        return false;
      }
      return true;
    }
    return false;
  }
  
  public static boolean renameFile(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    return moveFile(paramString2, localStringBuilder.toString());
  }
  
  /* Error */
  public static int unzipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: new 505	java/util/zip/ZipInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokestatic 247	com/tencent/mm/vfs/VFSFileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: invokespecial 506	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 510	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   25: astore 5
    //   27: aload 5
    //   29: ifnull +199 -> 228
    //   32: aload 5
    //   34: invokevirtual 513	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 515
    //   44: invokevirtual 519	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   47: ifne -26 -> 21
    //   50: aload 4
    //   52: ldc_w 521
    //   55: invokevirtual 519	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +6 -> 64
    //   61: goto -40 -> 21
    //   64: aload 5
    //   66: invokevirtual 522	java/util/zip/ZipEntry:isDirectory	()Z
    //   69: istore_3
    //   70: iload_3
    //   71: ifeq +69 -> 140
    //   74: aload 4
    //   76: iconst_0
    //   77: aload 4
    //   79: invokevirtual 114	java/lang/String:length	()I
    //   82: iconst_1
    //   83: isub
    //   84: invokevirtual 280	java/lang/String:substring	(II)Ljava/lang/String;
    //   87: astore 4
    //   89: new 44	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   96: astore 5
    //   98: aload 5
    //   100: aload_1
    //   101: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 5
    //   107: ldc 179
    //   109: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 5
    //   115: aload 4
    //   117: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: new 151	com/tencent/mm/vfs/VFSFile
    //   124: dup
    //   125: aload 5
    //   127: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 154	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   133: invokevirtual 311	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   136: pop
    //   137: goto -116 -> 21
    //   140: new 44	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   147: astore 5
    //   149: aload 5
    //   151: aload_1
    //   152: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: ldc 179
    //   160: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 5
    //   166: aload 4
    //   168: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: new 151	com/tencent/mm/vfs/VFSFile
    //   175: dup
    //   176: aload 5
    //   178: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokespecial 154	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   184: invokestatic 524	com/tencent/mm/vfs/VFSFileOp:openWrite	(Lcom/tencent/mm/vfs/VFSFile;)Ljava/io/OutputStream;
    //   187: astore 4
    //   189: sipush 1024
    //   192: newarray byte
    //   194: astore 5
    //   196: aload_0
    //   197: aload 5
    //   199: invokevirtual 525	java/util/zip/ZipInputStream:read	([B)I
    //   202: istore_2
    //   203: iload_2
    //   204: iconst_m1
    //   205: if_icmpeq +15 -> 220
    //   208: aload 4
    //   210: aload 5
    //   212: iconst_0
    //   213: iload_2
    //   214: invokevirtual 30	java/io/OutputStream:write	([BII)V
    //   217: goto -21 -> 196
    //   220: aload 4
    //   222: invokevirtual 308	java/io/OutputStream:close	()V
    //   225: goto -204 -> 21
    //   228: aload_0
    //   229: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   232: iconst_0
    //   233: ireturn
    //   234: astore_1
    //   235: goto +65 -> 300
    //   238: astore_1
    //   239: goto +18 -> 257
    //   242: astore_1
    //   243: goto +38 -> 281
    //   246: astore_1
    //   247: aload 4
    //   249: astore_0
    //   250: goto +50 -> 300
    //   253: astore_1
    //   254: aload 5
    //   256: astore_0
    //   257: aload_0
    //   258: astore 4
    //   260: ldc 8
    //   262: iconst_1
    //   263: ldc_w 527
    //   266: aload_1
    //   267: invokestatic 530	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   270: aload_0
    //   271: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   274: bipush 254
    //   276: ireturn
    //   277: astore_1
    //   278: aload 6
    //   280: astore_0
    //   281: aload_0
    //   282: astore 4
    //   284: ldc 8
    //   286: iconst_1
    //   287: ldc_w 532
    //   290: aload_1
    //   291: invokestatic 530	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload_0
    //   295: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   298: iconst_m1
    //   299: ireturn
    //   300: aload_0
    //   301: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   304: goto +5 -> 309
    //   307: aload_1
    //   308: athrow
    //   309: goto -2 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramString1	String
    //   0	312	1	paramString2	String
    //   202	12	2	i	int
    //   69	2	3	bool	boolean
    //   7	276	4	localObject1	Object
    //   1	254	5	localObject2	Object
    //   4	275	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   21	27	234	finally
    //   32	61	234	finally
    //   64	70	234	finally
    //   74	137	234	finally
    //   140	196	234	finally
    //   196	203	234	finally
    //   208	217	234	finally
    //   220	225	234	finally
    //   21	27	238	java/io/IOException
    //   32	61	238	java/io/IOException
    //   64	70	238	java/io/IOException
    //   74	137	238	java/io/IOException
    //   140	196	238	java/io/IOException
    //   196	203	238	java/io/IOException
    //   208	217	238	java/io/IOException
    //   220	225	238	java/io/IOException
    //   21	27	242	java/io/FileNotFoundException
    //   32	61	242	java/io/FileNotFoundException
    //   64	70	242	java/io/FileNotFoundException
    //   74	137	242	java/io/FileNotFoundException
    //   140	196	242	java/io/FileNotFoundException
    //   196	203	242	java/io/FileNotFoundException
    //   208	217	242	java/io/FileNotFoundException
    //   220	225	242	java/io/FileNotFoundException
    //   9	21	246	finally
    //   260	270	246	finally
    //   284	294	246	finally
    //   9	21	253	java/io/IOException
    //   9	21	277	java/io/FileNotFoundException
  }
  
  public static int writeFile(String paramString, byte[] paramArrayOfByte)
  {
    return writeFile(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  /* Error */
  public static int writeFile(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +6 -> 7
    //   4: bipush 254
    //   6: ireturn
    //   7: aload_1
    //   8: arraylength
    //   9: iload_2
    //   10: iload_3
    //   11: iadd
    //   12: if_icmpge +6 -> 18
    //   15: bipush 253
    //   17: ireturn
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 4
    //   24: aload_0
    //   25: invokestatic 537	com/tencent/mm/vfs/VFSFileOp:openWrite	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   28: astore 6
    //   30: aload 6
    //   32: astore 4
    //   34: aload 6
    //   36: astore 5
    //   38: aload 6
    //   40: aload_1
    //   41: iload_2
    //   42: iload_3
    //   43: invokevirtual 30	java/io/OutputStream:write	([BII)V
    //   46: aload 6
    //   48: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   51: iconst_0
    //   52: ireturn
    //   53: astore_0
    //   54: goto +42 -> 96
    //   57: astore_1
    //   58: aload 5
    //   60: astore 4
    //   62: ldc 8
    //   64: iconst_1
    //   65: iconst_3
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc_w 539
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload_0
    //   78: aastore
    //   79: dup
    //   80: iconst_2
    //   81: aload_1
    //   82: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 428	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   89: aload 5
    //   91: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   94: iconst_m1
    //   95: ireturn
    //   96: aload 4
    //   98: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   101: aload_0
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramString	String
    //   0	103	1	paramArrayOfByte	byte[]
    //   0	103	2	paramInt1	int
    //   0	103	3	paramInt2	int
    //   22	75	4	localObject1	Object
    //   19	71	5	localObject2	Object
    //   28	19	6	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	53	finally
    //   38	46	53	finally
    //   62	89	53	finally
    //   24	30	57	java/io/IOException
    //   38	46	57	java/io/IOException
  }
  
  public static boolean zipFolder(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      return zipFolders(Collections.singletonList(paramString1), paramString2);
    }
    return false;
  }
  
  /* Error */
  public static boolean zipFolders(java.util.List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +547 -> 548
    //   4: aload_1
    //   5: invokevirtual 173	java/lang/String:isEmpty	()Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: invokestatic 552	com/tencent/mm/vfs/VFSFileOp:getParentAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokestatic 553	com/tencent/mm/vfs/VFSFileOp:mkdirs	(Ljava/lang/String;)Z
    //   20: pop
    //   21: sipush 4096
    //   24: newarray byte
    //   26: astore 9
    //   28: aconst_null
    //   29: astore 8
    //   31: aconst_null
    //   32: astore 4
    //   34: aconst_null
    //   35: astore 7
    //   37: new 555	java/util/zip/ZipOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokestatic 537	com/tencent/mm/vfs/VFSFileOp:openWrite	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   45: invokespecial 558	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore_1
    //   49: aload 8
    //   51: astore 4
    //   53: aload_1
    //   54: astore 5
    //   56: aload_0
    //   57: invokeinterface 561 1 0
    //   62: astore 10
    //   64: aload 8
    //   66: astore 4
    //   68: aload_1
    //   69: astore 5
    //   71: aload 10
    //   73: invokeinterface 478 1 0
    //   78: ifeq +409 -> 487
    //   81: aload 8
    //   83: astore 4
    //   85: aload_1
    //   86: astore 5
    //   88: aload 10
    //   90: invokeinterface 482 1 0
    //   95: checkcast 68	java/lang/String
    //   98: invokestatic 92	com/tencent/mm/vfs/VFSUtils:parseUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   101: astore_0
    //   102: aload 8
    //   104: astore 4
    //   106: aload_1
    //   107: astore 5
    //   109: invokestatic 98	com/tencent/mm/vfs/FileSystemManager:instance	()Lcom/tencent/mm/vfs/FileSystemManager;
    //   112: aload_0
    //   113: invokevirtual 102	com/tencent/mm/vfs/FileSystemManager:resolve	(Landroid/net/Uri;)Lcom/tencent/mm/vfs/FileSystemManager$Resolution;
    //   116: astore_0
    //   117: aload 8
    //   119: astore 4
    //   121: aload_1
    //   122: astore 5
    //   124: aload_0
    //   125: invokevirtual 125	com/tencent/mm/vfs/FileSystemManager$Resolution:valid	()Z
    //   128: ifne +6 -> 134
    //   131: goto -67 -> 64
    //   134: aload 8
    //   136: astore 4
    //   138: aload_1
    //   139: astore 5
    //   141: aload_0
    //   142: getfield 129	com/tencent/mm/vfs/FileSystemManager$Resolution:fileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   145: aload_0
    //   146: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   149: invokeinterface 216 2 0
    //   154: astore 6
    //   156: aload 6
    //   158: ifnonnull +6 -> 164
    //   161: goto -97 -> 64
    //   164: aload 8
    //   166: astore 4
    //   168: aload_1
    //   169: astore 5
    //   171: aload 6
    //   173: getfield 488	com/tencent/mm/vfs/FileSystem$FileEntry:isDirectory	Z
    //   176: ifeq +80 -> 256
    //   179: aload 8
    //   181: astore 4
    //   183: aload_1
    //   184: astore 5
    //   186: aload_0
    //   187: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   190: invokevirtual 114	java/lang/String:length	()I
    //   193: istore_3
    //   194: aload 8
    //   196: astore 4
    //   198: aload_1
    //   199: astore 5
    //   201: aload_0
    //   202: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   205: ldc 179
    //   207: invokevirtual 564	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   210: ifeq +356 -> 566
    //   213: iconst_0
    //   214: istore_2
    //   215: goto +3 -> 218
    //   218: iload_3
    //   219: iload_2
    //   220: iadd
    //   221: istore_2
    //   222: aload 8
    //   224: astore 4
    //   226: aload_1
    //   227: astore 5
    //   229: aload_0
    //   230: getfield 129	com/tencent/mm/vfs/FileSystemManager$Resolution:fileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   233: aload_0
    //   234: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   237: iconst_1
    //   238: invokeinterface 293 3 0
    //   243: astore 6
    //   245: aload 6
    //   247: astore_0
    //   248: aload 6
    //   250: ifnonnull +40 -> 290
    //   253: goto -189 -> 64
    //   256: aload 8
    //   258: astore 4
    //   260: aload_1
    //   261: astore 5
    //   263: aload_0
    //   264: getfield 132	com/tencent/mm/vfs/FileSystemManager$Resolution:path	Ljava/lang/String;
    //   267: bipush 47
    //   269: invokevirtual 237	java/lang/String:lastIndexOf	(I)I
    //   272: istore_2
    //   273: aload 8
    //   275: astore 4
    //   277: aload_1
    //   278: astore 5
    //   280: aload 6
    //   282: invokestatic 546	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   285: astore_0
    //   286: iload_2
    //   287: iconst_1
    //   288: iadd
    //   289: istore_2
    //   290: aload 8
    //   292: astore 4
    //   294: aload_1
    //   295: astore 5
    //   297: aload_0
    //   298: invokeinterface 473 1 0
    //   303: astore 11
    //   305: aload 8
    //   307: astore 4
    //   309: aload_1
    //   310: astore 5
    //   312: aload 11
    //   314: invokeinterface 478 1 0
    //   319: ifeq -255 -> 64
    //   322: aload 8
    //   324: astore 4
    //   326: aload_1
    //   327: astore 5
    //   329: aload 11
    //   331: invokeinterface 482 1 0
    //   336: checkcast 218	com/tencent/mm/vfs/FileSystem$FileEntry
    //   339: astore_0
    //   340: aload 8
    //   342: astore 4
    //   344: aload_1
    //   345: astore 5
    //   347: aload_0
    //   348: getfield 488	com/tencent/mm/vfs/FileSystem$FileEntry:isDirectory	Z
    //   351: ifeq +6 -> 357
    //   354: goto -49 -> 305
    //   357: aload 8
    //   359: astore 4
    //   361: aload_1
    //   362: astore 5
    //   364: aload_0
    //   365: getfield 485	com/tencent/mm/vfs/FileSystem$FileEntry:relPath	Ljava/lang/String;
    //   368: invokevirtual 114	java/lang/String:length	()I
    //   371: iload_2
    //   372: if_icmpge +19 -> 391
    //   375: aload 8
    //   377: astore 4
    //   379: aload_1
    //   380: astore 5
    //   382: aload_0
    //   383: getfield 567	com/tencent/mm/vfs/FileSystem$FileEntry:name	Ljava/lang/String;
    //   386: astore 6
    //   388: goto +20 -> 408
    //   391: aload 8
    //   393: astore 4
    //   395: aload_1
    //   396: astore 5
    //   398: aload_0
    //   399: getfield 485	com/tencent/mm/vfs/FileSystem$FileEntry:relPath	Ljava/lang/String;
    //   402: iload_2
    //   403: invokevirtual 241	java/lang/String:substring	(I)Ljava/lang/String;
    //   406: astore 6
    //   408: aload 8
    //   410: astore 4
    //   412: aload_1
    //   413: astore 5
    //   415: aload_0
    //   416: invokevirtual 570	com/tencent/mm/vfs/FileSystem$FileEntry:openRead	()Ljava/io/InputStream;
    //   419: astore_0
    //   420: aload_1
    //   421: new 512	java/util/zip/ZipEntry
    //   424: dup
    //   425: aload 6
    //   427: invokespecial 571	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   430: invokevirtual 575	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   433: aload_0
    //   434: aload 9
    //   436: invokevirtual 261	java/io/InputStream:read	([B)I
    //   439: istore_3
    //   440: iload_3
    //   441: iflt +14 -> 455
    //   444: aload_1
    //   445: aload 9
    //   447: iconst_0
    //   448: iload_3
    //   449: invokevirtual 576	java/util/zip/ZipOutputStream:write	([BII)V
    //   452: goto -19 -> 433
    //   455: aload_0
    //   456: invokevirtual 577	java/io/InputStream:close	()V
    //   459: aload 8
    //   461: astore 4
    //   463: aload_1
    //   464: astore 5
    //   466: aload_1
    //   467: invokevirtual 580	java/util/zip/ZipOutputStream:closeEntry	()V
    //   470: goto -165 -> 305
    //   473: astore 5
    //   475: aload_0
    //   476: astore 4
    //   478: aload 5
    //   480: astore_0
    //   481: goto +56 -> 537
    //   484: goto +24 -> 508
    //   487: aconst_null
    //   488: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   491: aload_1
    //   492: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   495: iconst_1
    //   496: ireturn
    //   497: astore_0
    //   498: aconst_null
    //   499: astore_1
    //   500: goto +37 -> 537
    //   503: aconst_null
    //   504: astore_1
    //   505: aload 7
    //   507: astore_0
    //   508: aload_0
    //   509: astore 4
    //   511: aload_1
    //   512: astore 5
    //   514: ldc 8
    //   516: iconst_1
    //   517: ldc_w 582
    //   520: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload_0
    //   524: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   527: aload_1
    //   528: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   531: iconst_0
    //   532: ireturn
    //   533: astore_0
    //   534: aload 5
    //   536: astore_1
    //   537: aload 4
    //   539: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   542: aload_1
    //   543: invokestatic 36	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   546: aload_0
    //   547: athrow
    //   548: iconst_0
    //   549: ireturn
    //   550: astore_0
    //   551: goto -48 -> 503
    //   554: astore_0
    //   555: aload 7
    //   557: astore_0
    //   558: goto -50 -> 508
    //   561: astore 4
    //   563: goto -79 -> 484
    //   566: iconst_1
    //   567: istore_2
    //   568: goto -350 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	paramList	java.util.List<String>
    //   0	571	1	paramString	String
    //   214	354	2	i	int
    //   193	256	3	j	int
    //   32	506	4	localObject1	Object
    //   561	1	4	localIOException	IOException
    //   54	411	5	str1	String
    //   473	6	5	localObject2	Object
    //   512	23	5	str2	String
    //   154	272	6	localObject3	Object
    //   35	521	7	localObject4	Object
    //   29	431	8	localObject5	Object
    //   26	420	9	arrayOfByte	byte[]
    //   62	27	10	localIterator1	Iterator
    //   303	27	11	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   420	433	473	finally
    //   433	440	473	finally
    //   444	452	473	finally
    //   455	459	473	finally
    //   37	49	497	finally
    //   56	64	533	finally
    //   71	81	533	finally
    //   88	102	533	finally
    //   109	117	533	finally
    //   124	131	533	finally
    //   141	156	533	finally
    //   171	179	533	finally
    //   186	194	533	finally
    //   201	213	533	finally
    //   229	245	533	finally
    //   263	273	533	finally
    //   280	286	533	finally
    //   297	305	533	finally
    //   312	322	533	finally
    //   329	340	533	finally
    //   347	354	533	finally
    //   364	375	533	finally
    //   382	388	533	finally
    //   398	408	533	finally
    //   415	420	533	finally
    //   466	470	533	finally
    //   514	523	533	finally
    //   37	49	550	java/io/IOException
    //   56	64	554	java/io/IOException
    //   71	81	554	java/io/IOException
    //   88	102	554	java/io/IOException
    //   109	117	554	java/io/IOException
    //   124	131	554	java/io/IOException
    //   141	156	554	java/io/IOException
    //   171	179	554	java/io/IOException
    //   186	194	554	java/io/IOException
    //   201	213	554	java/io/IOException
    //   229	245	554	java/io/IOException
    //   263	273	554	java/io/IOException
    //   280	286	554	java/io/IOException
    //   297	305	554	java/io/IOException
    //   312	322	554	java/io/IOException
    //   329	340	554	java/io/IOException
    //   347	354	554	java/io/IOException
    //   364	375	554	java/io/IOException
    //   382	388	554	java/io/IOException
    //   398	408	554	java/io/IOException
    //   415	420	554	java/io/IOException
    //   466	470	554	java/io/IOException
    //   420	433	561	java/io/IOException
    //   433	440	561	java/io/IOException
    //   444	452	561	java/io/IOException
    //   455	459	561	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileOp
 * JD-Core Version:    0.7.0.1
 */