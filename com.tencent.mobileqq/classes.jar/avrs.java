import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class avrs
{
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public avrs(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + File.separator + "audio_data_cache" + File.separator);
    paramString = new File(this.jdField_a_of_type_JavaLangString);
    boolean bool1 = paramString.mkdirs();
    boolean bool2 = paramString.isDirectory();
    if ((!bool1) && (!bool2))
    {
      paramString = new RuntimeException("AudioDataCache: mkd=" + bool1 + " isdir=" + bool2);
      QLog.e("AudioDataCache", 2, paramString, new Object[0]);
      awag.a(paramString);
    }
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("AudioDataCache", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("AudioDataCache", 2, "[@] " + paramString);
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 17	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   9: ldc 83
    //   11: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 85	avrs:b	Ljava/lang/String;
    //   18: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: aconst_null
    //   25: invokestatic 87	avrs:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   28: new 17	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: getfield 15	avrs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   39: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 85	avrs:b	Ljava/lang/String;
    //   46: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 89	avrs:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull +10 -> 69
    //   62: aload_0
    //   63: getfield 89	avrs:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   66: invokevirtual 94	java/io/FileOutputStream:close	()V
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_2
    //   79: goto -10 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	avrs
    //   52	20	1	str	String
    //   73	4	1	localObject	Object
    //   57	2	2	localFileOutputStream	FileOutputStream
    //   78	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	58	73	finally
    //   62	69	73	finally
    //   62	69	78	java/io/IOException
  }
  
  public void a()
  {
    File localFile;
    try
    {
      a("initCache: oldpath=" + this.b + " mOutStream=" + this.jdField_a_of_type_JavaIoFileOutputStream, null);
      this.b = axlv.a();
      String str = this.jdField_a_of_type_JavaLangString + this.b;
      localFile = new File(str);
      if (localFile.exists()) {
        throw new RuntimeException("AudioDataCache: file exists| " + str);
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
      a("initCache: newPath=" + this.b, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
      }
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      FileOutputStream localFileOutputStream = this.jdField_a_of_type_JavaIoFileOutputStream;
      bool1 = bool2;
      if (localFileOutputStream != null) {}
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
        bool1 = true;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          a("writeData: exp=", paramArrayOfByte);
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrs
 * JD-Core Version:    0.7.0.1
 */