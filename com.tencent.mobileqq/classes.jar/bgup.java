import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class bgup
{
  private static volatile bgup jdField_a_of_type_Bgup;
  public static final String a;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.context.getCacheDir().getAbsolutePath() + "/tts_cache/";
    if (QLog.isColorLevel()) {
      QLog.d("TtsFileCache", 2, "tts_cache: " + jdField_a_of_type_JavaLangString);
    }
  }
  
  public static bgup a()
  {
    if (jdField_a_of_type_Bgup == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bgup == null) {
        jdField_a_of_type_Bgup = new bgup();
      }
      return jdField_a_of_type_Bgup;
    }
  }
  
  public InputStream a(String paramString)
  {
    int k = 0;
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TtsFileCache", 1, "get: dir does not exist");
      }
      if (!((File)localObject).mkdirs())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TtsFileCache", 1, "get: mkdir failed");
        }
        return null;
      }
    }
    localObject = ((File)localObject).listFiles();
    int m = localObject.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (localObject[i].getName().equals(paramString)) {
          j = 1;
        }
      }
      else {
        if (j == 0) {
          break;
        }
      }
      try
      {
        paramString = new BufferedInputStream(new FileInputStream(jdField_a_of_type_JavaLangString + paramString));
        return paramString;
        i += 1;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          QLog.e("TtsFileCache", 1, "get failed: ", paramString);
          paramString = null;
        }
      }
    }
  }
  
  public void a()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(jdField_a_of_type_JavaLangString);
        if (!((File)localObject).exists()) {
          return;
        }
        File[] arrayOfFile = ((File)localObject).listFiles();
        int j = arrayOfFile.length;
        i = 0;
        if (i < j)
        {
          localObject = arrayOfFile[i];
          boolean bool = ((File)localObject).delete();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("delete cache: ").append(((File)localObject).getName());
            if (bool)
            {
              localObject = "succ";
              QLog.d("TtsFileCache", 1, (String)localObject);
            }
            else
            {
              localObject = "failed";
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("TtsFileCache", 1, "clearCache Exception: ", localException);
      }
      i += 1;
    }
  }
  
  /* Error */
  public void a(String paramString, java.io.ByteArrayOutputStream paramByteArrayOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 125	bgup:a	()V
    //   6: aload_1
    //   7: invokestatic 131	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: istore_3
    //   16: iload_3
    //   17: ifne +53 -> 70
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore 5
    //   26: new 139	java/io/FileOutputStream
    //   29: dup
    //   30: new 12	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   37: getstatic 44	bgup:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: astore 4
    //   57: aload_2
    //   58: aload_1
    //   59: invokevirtual 146	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 149	java/io/FileOutputStream:close	()V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: astore_1
    //   74: ldc 52
    //   76: iconst_1
    //   77: ldc 151
    //   79: aload_1
    //   80: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: goto -13 -> 70
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: astore 4
    //   97: ldc 52
    //   99: iconst_1
    //   100: ldc 151
    //   102: aload_2
    //   103: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_1
    //   107: ifnull -37 -> 70
    //   110: aload_1
    //   111: invokevirtual 149	java/io/FileOutputStream:close	()V
    //   114: goto -44 -> 70
    //   117: astore_1
    //   118: ldc 52
    //   120: iconst_1
    //   121: ldc 151
    //   123: aload_1
    //   124: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto -57 -> 70
    //   130: astore_2
    //   131: aload 5
    //   133: astore_1
    //   134: aload_1
    //   135: astore 4
    //   137: ldc 52
    //   139: iconst_1
    //   140: ldc 151
    //   142: aload_2
    //   143: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_1
    //   147: ifnull -77 -> 70
    //   150: aload_1
    //   151: invokevirtual 149	java/io/FileOutputStream:close	()V
    //   154: goto -84 -> 70
    //   157: astore_1
    //   158: ldc 52
    //   160: iconst_1
    //   161: ldc 151
    //   163: aload_1
    //   164: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: goto -97 -> 70
    //   170: astore_1
    //   171: aload 4
    //   173: ifnull +8 -> 181
    //   176: aload 4
    //   178: invokevirtual 149	java/io/FileOutputStream:close	()V
    //   181: aload_1
    //   182: athrow
    //   183: astore_2
    //   184: ldc 52
    //   186: iconst_1
    //   187: ldc 151
    //   189: aload_2
    //   190: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto -12 -> 181
    //   196: astore_1
    //   197: goto -26 -> 171
    //   200: astore_2
    //   201: goto -67 -> 134
    //   204: astore_2
    //   205: goto -111 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	bgup
    //   0	208	1	paramString	String
    //   0	208	2	paramByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   15	2	3	bool	boolean
    //   21	156	4	str	String
    //   24	108	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	70	73	java/lang/Exception
    //   2	16	86	finally
    //   66	70	86	finally
    //   74	83	86	finally
    //   110	114	86	finally
    //   118	127	86	finally
    //   150	154	86	finally
    //   158	167	86	finally
    //   176	181	86	finally
    //   181	183	86	finally
    //   184	193	86	finally
    //   26	54	91	java/io/IOException
    //   110	114	117	java/lang/Exception
    //   26	54	130	java/lang/Exception
    //   150	154	157	java/lang/Exception
    //   26	54	170	finally
    //   137	146	170	finally
    //   176	181	183	java/lang/Exception
    //   57	62	196	finally
    //   97	106	196	finally
    //   57	62	200	java/lang/Exception
    //   57	62	204	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgup
 * JD-Core Version:    0.7.0.1
 */