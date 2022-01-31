import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class bdit
{
  protected static final String a = File.separator;
  
  public static void a(File paramFile1, File paramFile2)
  {
    paramFile2 = new ZipOutputStream(new BufferedOutputStream(new CheckedOutputStream(new FileOutputStream(paramFile2), new CRC32())));
    paramFile2.setLevel(0);
    a(paramFile1, paramFile2, "", false);
    paramFile2.flush();
    paramFile2.close();
  }
  
  public static void a(File paramFile, String paramString)
  {
    a(paramFile, new File(paramString));
  }
  
  /* Error */
  protected static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 66	java/util/zip/ZipEntry
    //   6: dup
    //   7: new 68	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   14: aload_2
    //   15: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual 77	java/io/File:getName	()Ljava/lang/String;
    //   22: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 81	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: aload_2
    //   33: lconst_0
    //   34: invokevirtual 85	java/util/zip/ZipEntry:setTime	(J)V
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual 89	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   42: new 91	java/io/BufferedInputStream
    //   45: dup
    //   46: new 93	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 97	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_2
    //   58: aload_2
    //   59: astore_0
    //   60: sipush 8192
    //   63: newarray byte
    //   65: astore 4
    //   67: aload_2
    //   68: astore_0
    //   69: aload_2
    //   70: aload 4
    //   72: iconst_0
    //   73: sipush 8192
    //   76: invokevirtual 101	java/io/BufferedInputStream:read	([BII)I
    //   79: istore_3
    //   80: iload_3
    //   81: iconst_m1
    //   82: if_icmpeq +43 -> 125
    //   85: aload_2
    //   86: astore_0
    //   87: aload_1
    //   88: aload 4
    //   90: iconst_0
    //   91: iload_3
    //   92: invokevirtual 105	java/util/zip/ZipOutputStream:write	([BII)V
    //   95: goto -28 -> 67
    //   98: astore_1
    //   99: aload_2
    //   100: astore_0
    //   101: new 64	java/lang/Exception
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 108	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   109: athrow
    //   110: astore_2
    //   111: aload_0
    //   112: astore_1
    //   113: aload_2
    //   114: astore_0
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 109	java/io/BufferedInputStream:close	()V
    //   123: aload_0
    //   124: athrow
    //   125: aload_2
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 112	java/util/zip/ZipOutputStream:closeEntry	()V
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 109	java/io/BufferedInputStream:close	()V
    //   139: return
    //   140: astore_0
    //   141: aload 4
    //   143: astore_1
    //   144: goto -29 -> 115
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_0
    //   150: goto -49 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramFile	File
    //   0	153	1	paramZipOutputStream	ZipOutputStream
    //   0	153	2	paramString	String
    //   79	13	3	i	int
    //   1	141	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   60	67	98	java/lang/Exception
    //   69	80	98	java/lang/Exception
    //   87	95	98	java/lang/Exception
    //   127	131	98	java/lang/Exception
    //   60	67	110	finally
    //   69	80	110	finally
    //   87	95	110	finally
    //   101	110	110	finally
    //   127	131	110	finally
    //   3	58	140	finally
    //   3	58	147	java/lang/Exception
  }
  
  protected static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString, boolean paramBoolean)
  {
    if (paramFile.isDirectory())
    {
      b(paramFile, paramZipOutputStream, paramString, paramBoolean);
      return;
    }
    a(paramFile, paramZipOutputStream, paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(new File(paramString1), paramString2);
  }
  
  protected static void b(File paramFile, ZipOutputStream paramZipOutputStream, String paramString, boolean paramBoolean)
  {
    File[] arrayOfFile = paramFile.listFiles();
    Arrays.sort(arrayOfFile);
    int i;
    label85:
    File localFile;
    if (arrayOfFile.length == 0)
    {
      if (paramBoolean)
      {
        localObject = paramString + paramFile.getName() + a;
        localObject = new ZipEntry((String)localObject);
        ((ZipEntry)localObject).setTime(0L);
        paramZipOutputStream.putNextEntry((ZipEntry)localObject);
        paramZipOutputStream.closeEntry();
      }
    }
    else
    {
      int j = arrayOfFile.length;
      i = 0;
      if (i >= j) {
        return;
      }
      localFile = arrayOfFile[i];
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (Object localObject = paramString + paramFile.getName() + a;; localObject = paramString)
    {
      a(localFile, paramZipOutputStream, (String)localObject, true);
      i += 1;
      break label85;
      localObject = paramString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdit
 * JD-Core Version:    0.7.0.1
 */