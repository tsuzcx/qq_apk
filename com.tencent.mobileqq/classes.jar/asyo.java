import android.os.Environment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.now.LogUploadUtil.1;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class asyo
{
  private static final String a = Environment.getExternalStorageDirectory() + "/Tencent/wns/logs/com.tencent.qqplugin";
  private static final String b = Environment.getExternalStorageDirectory() + "/Tencent/wns/logs/qqplugin.zip";
  
  private static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    if (paramFile.isDirectory())
    {
      b(paramFile, paramZipOutputStream, paramString);
      return;
    }
    c(paramFile, paramZipOutputStream, paramString);
  }
  
  public static void a(String paramString)
  {
    ThreadManagerV2.excute(new LogUploadUtil.1(paramString), 16, null, false);
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_1
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 43	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 5
    //   24: new 43	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload 5
    //   35: invokevirtual 68	java/io/File:exists	()Z
    //   38: ifne +33 -> 71
    //   41: new 70	java/io/FileNotFoundException
    //   44: dup
    //   45: new 11	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   52: aload_0
    //   53: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 71
    //   58: invokestatic 76	alpo:a	(I)Ljava/lang/String;
    //   61: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 77	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: new 79	java/io/FileOutputStream
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 82	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   79: astore_2
    //   80: new 84	java/util/zip/ZipOutputStream
    //   83: dup
    //   84: new 86	java/util/zip/CheckedOutputStream
    //   87: dup
    //   88: aload_2
    //   89: new 88	java/util/zip/CRC32
    //   92: dup
    //   93: invokespecial 89	java/util/zip/CRC32:<init>	()V
    //   96: invokespecial 92	java/util/zip/CheckedOutputStream:<init>	(Ljava/io/OutputStream;Ljava/util/zip/Checksum;)V
    //   99: invokespecial 95	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   102: astore_1
    //   103: aload 5
    //   105: aload_1
    //   106: ldc 97
    //   108: invokestatic 99	asyo:a	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   111: aload_1
    //   112: ifnull +59 -> 171
    //   115: aload_1
    //   116: invokevirtual 102	java/util/zip/ZipOutputStream:close	()V
    //   119: aload 4
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull -110 -> 13
    //   126: aload_0
    //   127: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   130: return
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_1
    //   137: ifnull +29 -> 166
    //   140: aload_1
    //   141: invokevirtual 102	java/util/zip/ZipOutputStream:close	()V
    //   144: aload_3
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   154: aload_0
    //   155: athrow
    //   156: astore_0
    //   157: aconst_null
    //   158: astore_1
    //   159: goto -23 -> 136
    //   162: astore_0
    //   163: goto -27 -> 136
    //   166: aload_2
    //   167: astore_1
    //   168: goto -22 -> 146
    //   171: aload_2
    //   172: astore_0
    //   173: goto -51 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString1	String
    //   0	176	1	paramString2	String
    //   79	93	2	localFileOutputStream	java.io.FileOutputStream
    //   1	144	3	localObject1	Object
    //   3	117	4	localObject2	Object
    //   22	82	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   71	80	131	finally
    //   80	103	156	finally
    //   103	111	162	finally
  }
  
  private static void b(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    File[] arrayOfFile = paramFile.listFiles();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      a(arrayOfFile[i], paramZipOutputStream, paramString + paramFile.getName() + "/");
      i += 1;
    }
  }
  
  private static void c(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    if (!paramFile.exists()) {}
    label101:
    do
    {
      return;
      try
      {
        localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
        try
        {
          paramZipOutputStream.putNextEntry(new ZipEntry(paramString + paramFile.getName()));
          paramFile = new byte[8192];
          for (;;)
          {
            int i = localBufferedInputStream.read(paramFile, 0, 8192);
            if (i == -1) {
              break;
            }
            paramZipOutputStream.write(paramFile, 0, i);
          }
          if (paramZipOutputStream == null) {
            break label101;
          }
        }
        finally
        {
          paramZipOutputStream = localBufferedInputStream;
        }
      }
      finally
      {
        for (;;)
        {
          BufferedInputStream localBufferedInputStream;
          paramZipOutputStream = null;
        }
      }
      paramZipOutputStream.close();
      throw paramFile;
    } while (localBufferedInputStream == null);
    localBufferedInputStream.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyo
 * JD-Core Version:    0.7.0.1
 */