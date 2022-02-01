import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qassistant.wake.aicore.QQWakeAIEngine;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class band
{
  private static String jdField_a_of_type_JavaLangString = "";
  public static final List<String> a;
  public static volatile AtomicBoolean a;
  private int jdField_a_of_type_Int = -2;
  private long jdField_a_of_type_Long;
  private banf jdField_a_of_type_Banf;
  private baob jdField_a_of_type_Baob;
  private QQWakeAIEngine jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(Arrays.asList(new String[] { "helloqq_big.bin", "helloqq_big.txt", "helloqq_small.bin", "helloqq_small.txt", "libHelloQQ.so" }));
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  band()
  {
    if (a())
    {
      this.jdField_a_of_type_Int = a();
      String str1 = bakt.a("wake", a()) + "/";
      this.jdField_a_of_type_Baob = new baob();
      this.jdField_a_of_type_Baob.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      String str2 = str1 + "helloqq_big.txt";
      this.jdField_a_of_type_Baob.c = bdcv.a(str2);
      this.jdField_a_of_type_Baob.d = (str1 + "helloqq_big.bin");
      str2 = str1 + "helloqq_small.txt";
      this.jdField_a_of_type_Baob.jdField_a_of_type_JavaLangString = bdcv.a(str2);
      this.jdField_a_of_type_Baob.b = (str1 + "helloqq_small.bin");
      this.jdField_a_of_type_Baob.e = b();
      this.jdField_a_of_type_Baob.jdField_a_of_type_Float = 0.9F;
      this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine = new QQWakeAIEngine(this.jdField_a_of_type_Baob);
      this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine.a(new bane(this));
    }
  }
  
  public static String a()
  {
    if ("".equals(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).getString("resModel", "helloqq5");
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a()
  {
    return bakt.a(bakt.a("wake", a()), jdField_a_of_type_JavaUtilList);
  }
  
  public static String b()
  {
    return bakt.a("wake", a()) + "/" + "kernal_path/";
  }
  
  int a()
  {
    if (this.jdField_a_of_type_Int == -2)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0);
      this.jdField_a_of_type_Int = localSharedPreferences.getInt("RunType", 1);
      if (this.jdField_a_of_type_Int == -2)
      {
        this.jdField_a_of_type_Int = 1;
        localSharedPreferences.edit().putInt("RunType", this.jdField_a_of_type_Int).apply();
      }
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Banf = null;
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine != null)
    {
      bakl.a("HelloQQWake", "release()");
      this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine.b();
    }
  }
  
  public void a(Looper paramLooper)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine != null)
    {
      bakl.a("HelloQQWake", "HelloQQHelper initEngine");
      this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine.a(paramLooper);
    }
  }
  
  void a(banf parambanf)
  {
    this.jdField_a_of_type_Banf = parambanf;
  }
  
  public void a(ArrayList<byte[]> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((byte[])paramArrayList.next());
    }
  }
  
  void a(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length == 3200))
    {
      int i = paramArrayOfByte.length / 2;
      short[] arrayOfShort = new short[i];
      ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(arrayOfShort);
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine.a(arrayOfShort, i);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantWakeAicoreQQWakeAIEngine.c();
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int > 0) && (QQWakeAIEngine.jdField_a_of_type_Long != 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     band
 * JD-Core Version:    0.7.0.1
 */