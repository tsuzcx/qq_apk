import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class bbqy
  implements bbri
{
  private static String jdField_a_of_type_JavaLangString = "ShortVideoResDownload_";
  private static ConcurrentHashMap<Integer, bbqy> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public int a;
  private bbrb jdField_a_of_type_Bbrb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean;
  
  private bbqy(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    jdField_a_of_type_JavaLangString += this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bbrb = new bbrb(jdField_a_of_type_JavaLangString, this);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  private void a(@Nullable bbrj parambbrj)
  {
    bmbx.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLoginInternal] - BEGIN -");
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new bbra(this, parambbrj));
    bmbx.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLoginInternal] - END -");
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, @Nullable bbrj parambbrj)
  {
    bmbx.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - BEGIN -");
    boolean bool = VideoEnvironment.supportShortVideoRecordAndPlay(paramQQAppInterface);
    if (!bool)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (parambbrj != null) {
        parambbrj.a(-1, -6);
      }
      bmbx.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - END -, supportShortVideo=" + bool);
      return;
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 3)
    {
      if (parambbrj != null) {
        parambbrj.a(-1, -1);
      }
      bmbx.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - END -, reach to max session size=" + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      return;
    }
    paramQQAppInterface = new bbqy(paramQQAppInterface, true);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int), paramQQAppInterface);
    paramQQAppInterface.a(parambbrj);
    bmbx.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - END -");
  }
  
  private boolean a()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, amtj.a(2131713196), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return bool;
    }
    VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, amtj.a(2131713135), null);
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (!VideoEnvironment.supportShortVideoRecordAndPlay(paramQQAppInterface))
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          paramBoolean = bool;
          return paramBoolean;
        }
        if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 3)
        {
          VideoEnvironment.LogDownLoad("ShortVideoResDownload", "reach to max session size=" + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size(), null);
          paramBoolean = bool;
          continue;
        }
        paramQQAppInterface = new bbqy(paramQQAppInterface, paramBoolean);
      }
      finally {}
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int), paramQQAppInterface);
      bool = paramQQAppInterface.a();
      paramBoolean = bool;
      if (!bool)
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int));
        paramBoolean = bool;
      }
    }
  }
  
  private static void b(bbqy parambbqy)
  {
    if (parambbqy != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(parambbqy.jdField_a_of_type_Int));
    }
  }
  
  private boolean b()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "startDownloadConfigNoLogin");
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, amtj.a(2131713196), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new bbqz(this));
      return bool;
    }
    VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, amtj.a(2131713135), null);
    return bool;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if (!VideoEnvironment.supportShortVideoRecordAndPlay(paramQQAppInterface)) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    boolean bool2;
    do
    {
      return bool1;
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 3)
      {
        VideoEnvironment.LogDownLoad("startDownloadResourceNoLogin", "reach to max session size=" + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size(), null);
        return false;
      }
      paramQQAppInterface = new bbqy(paramQQAppInterface, true);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int), paramQQAppInterface);
      bool2 = paramQQAppInterface.b();
      bool1 = bool2;
    } while (bool2);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int));
    return bool2;
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult | result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| uncompress config error=" + paramInt2, null);
        b(this);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| check config success...", null);
        this.jdField_a_of_type_Bbrb.jdField_a_of_type_Boolean = false;
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Bbrb);
        VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| mDownloadFilterSo=false", null);
        if (this.jdField_a_of_type_Boolean)
        {
          if (bbxj.c())
          {
            this.jdField_a_of_type_Bbrb.b = false;
            ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Bbrb);
          }
          if (bbxj.g())
          {
            this.jdField_a_of_type_Bbrb.d = false;
            ShortVideoResourceManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Bbrb);
          }
        }
        this.jdField_a_of_type_Bbrb.a();
        return;
      }
      VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| check config error=" + paramInt1, null);
      b(this);
      return;
    }
    VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
    b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqy
 * JD-Core Version:    0.7.0.1
 */