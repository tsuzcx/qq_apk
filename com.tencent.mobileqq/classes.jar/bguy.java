import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.util.Pair;
import cooperation.qqreader.net.BusinessTask;
import mqq.app.AppRuntime;

public class bguy
{
  private static bguy jdField_a_of_type_Bguy;
  private static final Pair<Integer, Integer> jdField_a_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(1494), Integer.valueOf(2));
  private static boolean jdField_a_of_type_Boolean;
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("Reader_shadow_gray" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
  }
  
  public static bguy a()
  {
    if (jdField_a_of_type_Bguy == null) {}
    try
    {
      if (jdField_a_of_type_Bguy == null) {
        jdField_a_of_type_Bguy = new bguy();
      }
      return jdField_a_of_type_Bguy;
    }
    finally {}
  }
  
  public void a()
  {
    bgvo.e("ReaderShadowGrayManager", "[fetchConfig] sIsRequestedGray = " + jdField_a_of_type_Boolean);
    if (jdField_a_of_type_Boolean) {
      return;
    }
    BusinessTask localBusinessTask = new BusinessTask("ReaderShadowGray", jdField_a_of_type_ComTencentUtilPair);
    localBusinessTask.a(new bguz(this), true);
    localBusinessTask.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguy
 * JD-Core Version:    0.7.0.1
 */