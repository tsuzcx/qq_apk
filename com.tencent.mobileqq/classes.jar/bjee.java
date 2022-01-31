import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bjee
{
  private static bjee jdField_a_of_type_Bjee;
  private int jdField_a_of_type_Int = -1;
  
  public static bjee a()
  {
    if (jdField_a_of_type_Bjee == null) {
      jdField_a_of_type_Bjee = new bjee();
    }
    return jdField_a_of_type_Bjee;
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_manufacture", Build.MANUFACTURER);
      localHashMap.put("param_model", Build.MODEL);
      localHashMap.put("param_sdk", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_cost", String.valueOf(paramLong));
      awrn.a(BaseApplicationImpl.getContext()).a(null, "dg_recognize_cost", true, paramLong, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameReporter", 2, String.format("reportDGRecognizeCost, cost[%s]", new Object[] { Long.valueOf(paramLong) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjee
 * JD-Core Version:    0.7.0.1
 */