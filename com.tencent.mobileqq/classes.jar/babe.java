import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfSwitchStrategy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.util.HashMap;

public class babe
{
  private static babe jdField_a_of_type_Babe;
  private int jdField_a_of_type_Int = -1;
  
  public static babe a()
  {
    if (jdField_a_of_type_Babe == null) {
      jdField_a_of_type_Babe = new babe();
    }
    return jdField_a_of_type_Babe;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("entranceReportAlready", 0);
    }
    Object localObject;
    int i;
    int j;
    StatisticCollector localStatisticCollector;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 1;
      localObject = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      ((SharedPreferences.Editor)localObject).putInt("entranceReportAlready", this.jdField_a_of_type_Int);
      ((SharedPreferences.Editor)localObject).commit();
      i = QmcfManager.getInstance().getCurrSwitchStrategy().getEntranceState();
      j = QmcfManager.getInstance().getCurrFrameType();
      localObject = new HashMap();
      ((HashMap)localObject).put("param_hasPoseEntrance", String.valueOf(paramBoolean1));
      ((HashMap)localObject).put("param_hasFaceEntrance", String.valueOf(paramBoolean2));
      ((HashMap)localObject).put("param_entanceState", String.valueOf(i));
      ((HashMap)localObject).put("param_frameType", String.valueOf(j));
      ((HashMap)localObject).put("param_manufacture", Build.MANUFACTURER);
      ((HashMap)localObject).put("param_model", Build.MODEL);
      ((HashMap)localObject).put("param_sdk", String.valueOf(Build.VERSION.SDK_INT));
      localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label283;
      }
    }
    label283:
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(null, "dg_entrance_state", bool, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameReporter", 2, String.format("reportDGEntranceState, hasPose[%s], hasFace[%s], state[%s], frameTpye[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babe
 * JD-Core Version:    0.7.0.1
 */