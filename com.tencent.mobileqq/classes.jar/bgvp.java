import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.util.Pair;
import cooperation.qqreader.net.BusinessTask;
import mqq.app.AppRuntime;

public class bgvp
{
  private static bgvp jdField_a_of_type_Bgvp;
  private static final Pair<Integer, Integer> jdField_a_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(1494), Integer.valueOf(2));
  private static boolean jdField_a_of_type_Boolean;
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("Reader_shadow_gray" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
  }
  
  public static bgvp a()
  {
    if (jdField_a_of_type_Bgvp == null) {}
    try
    {
      if (jdField_a_of_type_Bgvp == null) {
        jdField_a_of_type_Bgvp = new bgvp();
      }
      return jdField_a_of_type_Bgvp;
    }
    finally {}
  }
  
  public void a()
  {
    bgwf.e("ReaderShadowGrayManager", "[fetchConfig] sIsRequestedGray = " + jdField_a_of_type_Boolean);
    if (jdField_a_of_type_Boolean) {
      return;
    }
    BusinessTask localBusinessTask = new BusinessTask("ReaderShadowGray", jdField_a_of_type_ComTencentUtilPair);
    localBusinessTask.a(new bgvq(this), true);
    localBusinessTask.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvp
 * JD-Core Version:    0.7.0.1
 */