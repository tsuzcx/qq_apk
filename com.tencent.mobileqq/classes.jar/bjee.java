import android.content.Context;
import android.content.res.AssetManager;
import android.media.MediaScannerConnection;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class bjee
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final AssetManager jdField_a_of_type_AndroidContentResAssetManager;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public bjee(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResAssetManager = paramContext.getAssets();
  }
  
  private String[] a(String paramString)
  {
    try
    {
      paramString = this.jdField_a_of_type_AndroidContentResAssetManager.list(paramString);
      int i = paramString.length;
      if (i == 0) {
        return null;
      }
      return paramString;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  private int b(String paramString, File paramFile)
  {
    int j;
    if (!paramFile.isDirectory())
    {
      QLog.d("AssetCopier", 1, paramFile + " is not a directory");
      j = 0;
    }
    String[] arrayOfString;
    int i;
    int m;
    int k;
    do
    {
      return j;
      if (!paramFile.canWrite())
      {
        QLog.d("AssetCopier", 1, paramFile + " is not writable");
        return 0;
      }
      arrayOfString = a(paramString);
      if (arrayOfString == null)
      {
        if (paramString.contains(File.separator)) {}
        for (localObject = paramString.substring(paramString.lastIndexOf(File.separator));; localObject = paramString)
        {
          paramFile = new File(paramFile, (String)localObject);
          i = c(paramString, paramFile) + 0;
          j = i;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_JavaUtilList.add(paramFile.getAbsolutePath());
          return i;
        }
      }
      m = arrayOfString.length;
      k = 0;
      i = 0;
      j = i;
    } while (k >= m);
    Object localObject = arrayOfString[k];
    String str = paramString + File.separator + (String)localObject;
    if (a(str) != null)
    {
      j = 1;
      label225:
      if (j == 0) {
        break label283;
      }
    }
    label283:
    for (localObject = new File(paramFile, (String)localObject);; localObject = paramFile)
    {
      if (j != 0) {
        ((File)localObject).mkdirs();
      }
      j = b(str, (File)localObject);
      k += 1;
      i = j + i;
      break;
      j = 0;
      break label225;
    }
  }
  
  /* Error */
  private int c(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: sipush 16384
    //   9: newarray byte
    //   11: astore 6
    //   13: aload_0
    //   14: getfield 30	bjee:jdField_a_of_type_AndroidContentResAssetManager	Landroid/content/res/AssetManager;
    //   17: aload_1
    //   18: invokevirtual 124	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_1
    //   22: new 126	java/io/FileOutputStream
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 129	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_1
    //   32: aload 6
    //   34: invokevirtual 135	java/io/InputStream:read	([B)I
    //   37: istore_3
    //   38: iload_3
    //   39: iconst_m1
    //   40: if_icmpeq +57 -> 97
    //   43: aload_2
    //   44: aload 6
    //   46: iconst_0
    //   47: iload_3
    //   48: invokevirtual 141	java/io/OutputStream:write	([BII)V
    //   51: goto -20 -> 31
    //   54: astore 5
    //   56: aload_1
    //   57: astore 4
    //   59: aload 5
    //   61: astore_1
    //   62: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +12 -> 77
    //   68: ldc 49
    //   70: iconst_2
    //   71: ldc 146
    //   73: aload_1
    //   74: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   77: aload 4
    //   79: ifnull +8 -> 87
    //   82: aload 4
    //   84: invokevirtual 153	java/io/InputStream:close	()V
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 154	java/io/OutputStream:close	()V
    //   95: iconst_1
    //   96: ireturn
    //   97: aload_2
    //   98: invokevirtual 157	java/io/OutputStream:flush	()V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 153	java/io/InputStream:close	()V
    //   109: aload_2
    //   110: ifnull -15 -> 95
    //   113: aload_2
    //   114: invokevirtual 154	java/io/OutputStream:close	()V
    //   117: goto -22 -> 95
    //   120: astore_1
    //   121: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq -29 -> 95
    //   127: ldc 49
    //   129: iconst_2
    //   130: ldc 159
    //   132: aload_1
    //   133: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: goto -41 -> 95
    //   139: astore_1
    //   140: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq -34 -> 109
    //   146: ldc 49
    //   148: iconst_2
    //   149: ldc 161
    //   151: aload_1
    //   152: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -46 -> 109
    //   158: astore_1
    //   159: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq -75 -> 87
    //   165: ldc 49
    //   167: iconst_2
    //   168: ldc 161
    //   170: aload_1
    //   171: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -87 -> 87
    //   177: astore_1
    //   178: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   181: ifeq -86 -> 95
    //   184: ldc 49
    //   186: iconst_2
    //   187: ldc 159
    //   189: aload_1
    //   190: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto -98 -> 95
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_2
    //   199: aload 5
    //   201: astore 4
    //   203: aload 4
    //   205: ifnull +8 -> 213
    //   208: aload 4
    //   210: invokevirtual 153	java/io/InputStream:close	()V
    //   213: aload_2
    //   214: ifnull +7 -> 221
    //   217: aload_2
    //   218: invokevirtual 154	java/io/OutputStream:close	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore 4
    //   225: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq -15 -> 213
    //   231: ldc 49
    //   233: iconst_2
    //   234: ldc 161
    //   236: aload 4
    //   238: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: goto -28 -> 213
    //   244: astore_2
    //   245: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -27 -> 221
    //   251: ldc 49
    //   253: iconst_2
    //   254: ldc 159
    //   256: aload_2
    //   257: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: goto -39 -> 221
    //   263: astore 5
    //   265: aconst_null
    //   266: astore_2
    //   267: aload_1
    //   268: astore 4
    //   270: aload 5
    //   272: astore_1
    //   273: goto -70 -> 203
    //   276: astore 5
    //   278: aload_1
    //   279: astore 4
    //   281: aload 5
    //   283: astore_1
    //   284: goto -81 -> 203
    //   287: astore_1
    //   288: goto -85 -> 203
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_2
    //   294: goto -232 -> 62
    //   297: astore 5
    //   299: aconst_null
    //   300: astore_2
    //   301: aload_1
    //   302: astore 4
    //   304: aload 5
    //   306: astore_1
    //   307: goto -245 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	bjee
    //   0	310	1	paramString	String
    //   0	310	2	paramFile	File
    //   37	11	3	i	int
    //   4	205	4	localObject1	Object
    //   223	14	4	localIOException	IOException
    //   268	35	4	str	String
    //   1	1	5	localObject2	Object
    //   54	146	5	localThrowable1	java.lang.Throwable
    //   263	8	5	localObject3	Object
    //   276	6	5	localObject4	Object
    //   297	8	5	localThrowable2	java.lang.Throwable
    //   11	34	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   31	38	54	java/lang/Throwable
    //   43	51	54	java/lang/Throwable
    //   97	101	54	java/lang/Throwable
    //   113	117	120	java/io/IOException
    //   105	109	139	java/io/IOException
    //   82	87	158	java/io/IOException
    //   91	95	177	java/io/IOException
    //   13	22	196	finally
    //   208	213	223	java/io/IOException
    //   217	221	244	java/io/IOException
    //   22	31	263	finally
    //   31	38	276	finally
    //   43	51	276	finally
    //   97	101	276	finally
    //   62	77	287	finally
    //   13	22	291	java/lang/Throwable
    //   22	31	297	java/lang/Throwable
  }
  
  public int a(String paramString, File paramFile)
  {
    int i = b(paramString, paramFile);
    if (this.jdField_a_of_type_Boolean) {
      MediaScannerConnection.scanFile(this.jdField_a_of_type_AndroidContentContext, (String[])this.jdField_a_of_type_JavaUtilList.toArray(new String[0]), null, null);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjee
 * JD-Core Version:    0.7.0.1
 */