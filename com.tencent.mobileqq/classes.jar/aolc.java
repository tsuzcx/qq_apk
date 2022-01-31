import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.QStorageSafeDeleteException;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class aolc
{
  public static ConcurrentHashMap<String, aolc> a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "flashchat" };
  Context jdField_a_of_type_AndroidContentContext;
  File jdField_a_of_type_JavaIoFile;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private aolc(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramString2;
    paramContext = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath() + File.separator + this.b + File.separator + "qstorage" + File.separator + "objs");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.jdField_a_of_type_JavaIoFile = paramContext;
  }
  
  public static <T extends aokj<Y>, Y> T a(Y paramY, Class<T> paramClass)
  {
    aokj localaokj = (aokj)aoks.a(paramClass);
    try
    {
      localaokj.a(paramY);
      return localaokj;
    }
    catch (Exception paramY)
    {
      aokv.a().a(paramClass, paramY);
      throw new QStorageInstantiateException("readJsonOrXml exception too much", paramY);
    }
  }
  
  public static aolc a(String paramString)
  {
    if (!a(paramString)) {
      QLog.d("QStorage", 1, "buildQStorage notRegister " + paramString);
    }
    Object localObject = (aolc)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null) {
      synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        aolc localaolc = (aolc)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localaolc;
        if (localaolc == null)
        {
          localObject = new aolc(BaseApplicationImpl.getContext(), paramString, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
        }
        return localObject;
      }
    }
    return localObject;
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (TextUtils.equals(arrayOfString[i], paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public File a(String paramString1, String paramString2)
  {
    return new File(this.jdField_a_of_type_JavaIoFile, paramString1 + paramString2);
  }
  
  public <T extends Serializable> T a(String paramString, Class<T> paramClass, int paramInt)
  {
    File localFile = a(paramString, ".serial");
    return (Serializable)a(localFile, "", paramClass, paramInt, new aole(this, localFile, paramString));
  }
  
  public <JavaBean, Param> JavaBean a(File paramFile, Param paramParam, Class<JavaBean> paramClass, int paramInt, aoki<JavaBean, Param> paramaoki)
  {
    Object localObject = null;
    if (paramFile != null) {}
    String str2;
    for (;;)
    {
      try
      {
        String str1 = paramFile.getCanonicalPath();
        if ((paramInt == 1) || (str1 == null) || (!aokp.a().a(this.jdField_a_of_type_JavaLangString, this.b, str1)) || (paramFile.exists())) {
          break;
        }
        throw new QStorageSafeDeleteException();
      }
      catch (IOException localIOException)
      {
        str2 = null;
        continue;
      }
      str2 = null;
    }
    try
    {
      paramParam = paramaoki.a(paramFile, paramParam);
      paramFile = paramParam;
    }
    catch (Exception paramParam)
    {
      for (;;)
      {
        aokv.a().a(paramaoki, paramFile, paramParam);
        QLog.d("QStorage", 1, "readFile " + paramFile.getAbsolutePath(), paramParam);
        paramFile = localObject;
        continue;
        paramParam = paramFile;
        if (str2 != null)
        {
          aokp.a().a(this.jdField_a_of_type_JavaLangString, this.b, str2);
          paramParam = paramFile;
        }
      }
    }
    if (paramFile == null)
    {
      paramParam = aoks.a(paramClass);
      if (paramParam != null) {
        return paramParam;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QStorage", 2, "readFile ");
      }
      throw new QStorageInstantiateException("readSerializable exception too much", new NullPointerException());
    }
    return paramParam;
  }
  
  /* Error */
  public <DATA> void a(File paramFile, DATA paramDATA, aoki<String, DATA> paramaoki)
  {
    // Byte code:
    //   0: aload_3
    //   1: aload_1
    //   2: aload_2
    //   3: invokeinterface 201 3 0
    //   8: pop
    //   9: aload_1
    //   10: ifnull +49 -> 59
    //   13: aload_1
    //   14: invokevirtual 72	java/io/File:exists	()Z
    //   17: istore 4
    //   19: iload 4
    //   21: ifeq +38 -> 59
    //   24: aload_1
    //   25: invokevirtual 185	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   28: astore_2
    //   29: invokestatic 190	aokp:a	()Laokp;
    //   32: aload_0
    //   33: getfield 32	aolc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 36	aolc:b	Ljava/lang/String;
    //   40: aload_2
    //   41: invokevirtual 224	aokp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 190	aokp:a	()Laokp;
    //   47: aload_0
    //   48: getfield 32	aolc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   51: aload_0
    //   52: getfield 36	aolc:b	Ljava/lang/String;
    //   55: aload_2
    //   56: invokevirtual 220	aokp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   59: return
    //   60: astore_2
    //   61: ldc 113
    //   63: iconst_1
    //   64: new 40	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   71: ldc 226
    //   73: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 51	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: aload_2
    //   87: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: invokestatic 95	aokv:a	()Laokv;
    //   93: aload_3
    //   94: aload_1
    //   95: aload_2
    //   96: invokevirtual 214	aokv:a	(Laoki;Ljava/io/File;Ljava/lang/Exception;)V
    //   99: return
    //   100: astore_1
    //   101: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	aolc
    //   0	102	1	paramFile	File
    //   0	102	2	paramDATA	DATA
    //   0	102	3	paramaoki	aoki<String, DATA>
    //   17	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	9	60	java/lang/Exception
    //   13	19	60	java/lang/Exception
    //   24	59	60	java/lang/Exception
    //   24	59	100	java/io/IOException
  }
  
  public <T extends Serializable> void a(String paramString, T paramT)
  {
    a(a(paramString, ".serial"), paramT, new aold(this, paramString, paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aolc
 * JD-Core Version:    0.7.0.1
 */