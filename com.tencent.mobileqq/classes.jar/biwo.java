import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.util.Pair;
import cooperation.qqreader.net.BusinessTask;
import mqq.app.AppRuntime;

public class biwo
{
  private static biwo jdField_a_of_type_Biwo;
  private static final Pair<Integer, Integer> jdField_a_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(1494), Integer.valueOf(2));
  private static boolean jdField_a_of_type_Boolean;
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("Reader_shadow_gray" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
  }
  
  public static biwo a()
  {
    if (jdField_a_of_type_Biwo == null) {}
    try
    {
      if (jdField_a_of_type_Biwo == null) {
        jdField_a_of_type_Biwo = new biwo();
      }
      return jdField_a_of_type_Biwo;
    }
    finally {}
  }
  
  public void a()
  {
    bixe.e("ReaderShadowGrayManager", "[fetchConfig] sIsRequestedGray = " + jdField_a_of_type_Boolean);
    if (jdField_a_of_type_Boolean) {
      return;
    }
    BusinessTask localBusinessTask = new BusinessTask("ReaderShadowGray", jdField_a_of_type_ComTencentUtilPair);
    localBusinessTask.a(new biwp(this), true);
    localBusinessTask.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwo
 * JD-Core Version:    0.7.0.1
 */