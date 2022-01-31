import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class axeh
  implements axeq
{
  private static ConcurrentHashMap<Integer, axeh> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public int a;
  private axej jdField_a_of_type_Axej;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "ShortVideoResDownload_";
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  
  private axeh(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    this.jdField_a_of_type_JavaLangString += this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Axej = new axej(this.jdField_a_of_type_JavaLangString, this);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  private boolean a()
  {
    boolean bool = bbev.g(null);
    if (bool)
    {
      VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, ajyc.a(2131714090), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return bool;
    }
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, ajyc.a(2131714029), null);
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    try
    {
      paramBoolean = a(paramQQAppInterface, paramBoolean, false);
      return paramBoolean;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (!VideoEnvironment.c(paramQQAppInterface))
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          paramBoolean1 = bool;
          return paramBoolean1;
        }
        if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 3)
        {
          VideoEnvironment.a("ShortVideoResDownload", "reach to max session size=" + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size(), null);
          paramBoolean1 = bool;
          continue;
        }
        paramQQAppInterface = new axeh(paramQQAppInterface, paramBoolean1);
      }
      finally {}
      paramQQAppInterface.b = paramBoolean2;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int), paramQQAppInterface);
      bool = paramQQAppInterface.a();
      if (!bool) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int));
      }
      paramBoolean1 = bool;
      if (paramBoolean2)
      {
        biqz.a().a(1, null, false);
        paramBoolean1 = bool;
      }
    }
  }
  
  private static void b(axeh paramaxeh)
  {
    if (paramaxeh != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramaxeh.jdField_a_of_type_Int));
    }
  }
  
  private boolean b()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "startDownloadConfigNoLogin");
    boolean bool = bbev.g(null);
    if (bool)
    {
      VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, ajyc.a(2131714090), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new axei(this));
      return bool;
    }
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, ajyc.a(2131714029), null);
    return bool;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if (!VideoEnvironment.c(paramQQAppInterface)) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    boolean bool2;
    do
    {
      return bool1;
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 3)
      {
        VideoEnvironment.a("startDownloadResourceNoLogin", "reach to max session size=" + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size(), null);
        return false;
      }
      paramQQAppInterface = new axeh(paramQQAppInterface, true);
      paramQQAppInterface.b = false;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int), paramQQAppInterface);
      bool2 = paramQQAppInterface.b();
      bool1 = bool2;
    } while (bool2);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int));
    return bool2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult | result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| uncompress config error=" + paramInt2, null);
        b(this);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| check config success...", null);
        this.jdField_a_of_type_Axej.jdField_a_of_type_Boolean = false;
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Axej);
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| mDownloadFilterSo=false", null);
        if (this.jdField_a_of_type_Boolean)
        {
          if (axlc.a(VideoEnvironment.a()) == 0) {
            break label239;
          }
          ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Axej);
          this.jdField_a_of_type_Axej.b = false;
        }
        for (;;)
        {
          if (axlc.f())
          {
            this.jdField_a_of_type_Axej.c = false;
            ShortVideoResourceManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Axej);
          }
          if (axlc.i())
          {
            this.jdField_a_of_type_Axej.e = false;
            ShortVideoResourceManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Axej);
          }
          this.jdField_a_of_type_Axej.a();
          return;
          label239:
          VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| getFilterSoState != 2", null);
        }
      }
      VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| check config error=" + paramInt1, null);
      b(this);
      return;
    }
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
    b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axeh
 * JD-Core Version:    0.7.0.1
 */