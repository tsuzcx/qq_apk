package com.tencent.biz.qcircleshadow.local.pluginparse;

import android.text.TextUtils;
import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import mqq.app.MobileQQ;

public class QCircleUnZip
{
  private static Logger jdField_a_of_type_ComTencentShadowCoreCommonLogger = LoggerFactory.getILoggerFactory().getLogger("QCIRCLE_PLUGIN");
  private final File jdField_a_of_type_JavaIoFile = new File(new File(MobileQQ.sMobileQQ.getFilesDir(), "ShadowPluginManager"), "UnpackedPlugin");
  private final String jdField_a_of_type_JavaLangString;
  
  public QCircleUnZip()
  {
    this.jdField_a_of_type_JavaIoFile.mkdirs();
    this.jdField_a_of_type_JavaLangString = "qcircle-manager";
  }
  
  private File a(File paramFile)
  {
    return new File(paramFile.getParentFile(), "unpacked." + paramFile.getName());
  }
  
  private File a(File paramFile, String paramString)
  {
    return new File(paramFile, paramString);
  }
  
  private File a(File paramFile, String paramString1, String paramString2)
  {
    return new File(a(paramFile, paramString1), paramString2);
  }
  
  private void a(File paramFile)
  {
    File[] arrayOfFile = a(paramFile);
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        b(localFile);
        label31:
        i += 1;
        continue;
        if (paramFile != null) {
          throw paramFile;
        }
      }
      catch (IOException paramFile)
      {
        break label31;
      }
    }
  }
  
  private static File[] a(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    return arrayOfFile;
  }
  
  private void b(File paramFile)
  {
    if (paramFile.isDirectory()) {
      c(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  private void c(File paramFile)
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      a(paramFile);
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  File a(String paramString)
  {
    return a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  File a(String paramString, File paramFile)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = a(paramFile);
    }
    return new File(a(str), paramFile.getName());
  }
  
  /* Error */
  public String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 155	java/io/FileInputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 157	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 161	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: getstatic 167	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   18: lconst_0
    //   19: aload_1
    //   20: invokevirtual 171	java/io/File:length	()J
    //   23: invokevirtual 177	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   26: astore_1
    //   27: ldc 179
    //   29: invokestatic 185	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 188	java/security/MessageDigest:reset	()V
    //   37: aload_3
    //   38: aload_1
    //   39: invokevirtual 192	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   42: new 194	java/math/BigInteger
    //   45: dup
    //   46: iconst_1
    //   47: aload_3
    //   48: invokevirtual 198	java/security/MessageDigest:digest	()[B
    //   51: invokespecial 201	java/math/BigInteger:<init>	(I[B)V
    //   54: bipush 16
    //   56: invokevirtual 204	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   59: astore_1
    //   60: aload_2
    //   61: ifnull +7 -> 68
    //   64: aload_2
    //   65: invokevirtual 207	java/io/FileInputStream:close	()V
    //   68: aload_1
    //   69: areturn
    //   70: astore_2
    //   71: getstatic 26	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:jdField_a_of_type_ComTencentShadowCoreCommonLogger	Lcom/tencent/shadow/core/common/Logger;
    //   74: new 65	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   81: ldc 209
    //   83: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokeinterface 214 2 0
    //   98: aload_1
    //   99: areturn
    //   100: astore_2
    //   101: aload_3
    //   102: astore_1
    //   103: new 216	java/lang/RuntimeException
    //   106: dup
    //   107: aload_2
    //   108: invokespecial 219	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   111: athrow
    //   112: astore_3
    //   113: aload_1
    //   114: astore_2
    //   115: aload_3
    //   116: astore_1
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 207	java/io/FileInputStream:close	()V
    //   125: aload_1
    //   126: athrow
    //   127: astore_2
    //   128: getstatic 26	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:jdField_a_of_type_ComTencentShadowCoreCommonLogger	Lcom/tencent/shadow/core/common/Logger;
    //   131: new 65	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   138: ldc 209
    //   140: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_2
    //   144: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokeinterface 214 2 0
    //   155: goto -30 -> 125
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_2
    //   161: goto -44 -> 117
    //   164: astore_1
    //   165: goto -48 -> 117
    //   168: astore_3
    //   169: aload_2
    //   170: astore_1
    //   171: aload_3
    //   172: astore_2
    //   173: goto -70 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	QCircleUnZip
    //   0	176	1	paramFile	File
    //   10	55	2	localFileInputStream	FileInputStream
    //   70	17	2	localIOException1	IOException
    //   100	8	2	localException1	java.lang.Exception
    //   114	8	2	localFile	File
    //   127	17	2	localIOException2	IOException
    //   160	13	2	localException2	java.lang.Exception
    //   1	101	3	localMessageDigest	java.security.MessageDigest
    //   112	4	3	localObject	Object
    //   168	4	3	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   64	68	70	java/io/IOException
    //   2	11	100	java/lang/Exception
    //   103	112	112	finally
    //   121	125	127	java/io/IOException
    //   2	11	158	finally
    //   11	60	164	finally
    //   11	60	168	java/lang/Exception
  }
  
  boolean a(File paramFile)
  {
    return a(paramFile).exists();
  }
  
  public boolean a(String paramString1, File paramFile, String paramString2)
  {
    Object localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      localObject = a(paramFile);
    }
    paramString1 = a((String)localObject, paramFile);
    paramString1.mkdirs();
    File localFile = a(paramString1);
    long l1 = System.currentTimeMillis();
    boolean bool = a(paramString1);
    jdField_a_of_type_ComTencentShadowCoreCommonLogger.info(paramString2 + "QcircleUnZip#unPackaPlugin:" + bool + " \n unPackageDir:" + paramString1 + " \n unPackageTag:" + localFile + "\n hash code:" + hashCode());
    if (bool) {
      return true;
    }
    a(paramString1);
    localObject = new QCircleSafeZipInPutStream(new FileInputStream(paramFile));
    for (;;)
    {
      try
      {
        paramFile = ((QCircleSafeZipInPutStream)localObject).getNextEntry();
        if (paramFile != null)
        {
          bool = paramFile.isDirectory();
          if (bool) {
            continue;
          }
        }
      }
      finally
      {
        ((QCircleSafeZipInPutStream)localObject).close();
      }
      try
      {
        paramFile = new BufferedOutputStream(new FileOutputStream(new File(paramString1, paramFile.getName())));
        try
        {
          BufferedInputStream localBufferedInputStream = new BufferedInputStream((InputStream)localObject);
          byte[] arrayOfByte = new byte[8192];
          int i = localBufferedInputStream.read(arrayOfByte, 0, 8192);
          if (i < 0) {
            break label261;
          }
          paramFile.write(arrayOfByte, 0, i);
          continue;
          ((QCircleSafeZipInPutStream)localObject).closeEntry();
        }
        finally {}
      }
      finally
      {
        long l2;
        paramFile = null;
        continue;
      }
      if (paramFile != null) {
        paramFile.close();
      }
      throw paramString1;
      label261:
      ((QCircleSafeZipInPutStream)localObject).closeEntry();
      if (paramFile != null) {
        paramFile.close();
      }
    }
    l2 = System.currentTimeMillis();
    jdField_a_of_type_ComTencentShadowCoreCommonLogger.info(paramString2 + "QcircleUnZip#unPackaPlugin():unzipEnd cost:" + (l2 - l1));
    localFile.createNewFile();
    ((QCircleSafeZipInPutStream)localObject).close();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleUnZip
 * JD-Core Version:    0.7.0.1
 */