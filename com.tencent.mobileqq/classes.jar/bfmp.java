import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.util.Pair;
import cooperation.qqreader.net.BusinessTask;
import mqq.app.AppRuntime;

public class bfmp
{
  private static bfmp jdField_a_of_type_Bfmp;
  private static final Pair<Integer, Integer> jdField_a_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(1494), Integer.valueOf(1));
  private static boolean jdField_a_of_type_Boolean;
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("Reader_shadow_gray" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
  }
  
  public static bfmp a()
  {
    if (jdField_a_of_type_Bfmp == null) {}
    try
    {
      if (jdField_a_of_type_Bfmp == null) {
        jdField_a_of_type_Bfmp = new bfmp();
      }
      return jdField_a_of_type_Bfmp;
    }
    finally {}
  }
  
  public void a()
  {
    bfne.d("ReaderShadowGrayManager", "[fetchConfig] sIsRequestedGray = " + jdField_a_of_type_Boolean);
    if (jdField_a_of_type_Boolean) {
      return;
    }
    BusinessTask localBusinessTask = new BusinessTask("ReaderShadowGray", jdField_a_of_type_ComTencentUtilPair);
    localBusinessTask.a(new bfmq(this), true);
    localBusinessTask.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmp
 * JD-Core Version:    0.7.0.1
 */