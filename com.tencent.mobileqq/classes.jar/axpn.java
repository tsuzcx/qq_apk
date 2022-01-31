import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfSwitchStrategy;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport.BoyItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class axpn
{
  private static axpn jdField_a_of_type_Axpn;
  private int jdField_a_of_type_Int = -1;
  
  public static axpn a()
  {
    if (jdField_a_of_type_Axpn == null) {
      jdField_a_of_type_Axpn = new axpn();
    }
    return jdField_a_of_type_Axpn;
  }
  
  public void a(BoyDataReport paramBoyDataReport)
  {
    HashMap localHashMap = new HashMap();
    paramBoyDataReport = paramBoyDataReport.mBoyData.iterator();
    Object localObject2;
    while (paramBoyDataReport.hasNext())
    {
      localObject1 = (BoyDataReport.BoyItem)paramBoyDataReport.next();
      if (localHashMap.containsKey(((BoyDataReport.BoyItem)localObject1).mId))
      {
        localObject2 = (axpo)localHashMap.get(((BoyDataReport.BoyItem)localObject1).mId);
        ((axpo)localObject2).b();
        if (((BoyDataReport.BoyItem)localObject1).status >= 1) {
          ((axpo)localObject2).a();
        }
      }
      else
      {
        localObject2 = ((BoyDataReport.BoyItem)localObject1).mId;
        if (((BoyDataReport.BoyItem)localObject1).status >= 1) {}
        for (int i = 1;; i = 0)
        {
          localObject2 = new axpo(this, (String)localObject2, 1, i);
          localHashMap.put(((BoyDataReport.BoyItem)localObject1).mId, localObject2);
          break;
        }
      }
    }
    paramBoyDataReport = new HashMap();
    paramBoyDataReport.put("param_manufacture", Build.MANUFACTURER);
    paramBoyDataReport.put("param_model", Build.MODEL);
    paramBoyDataReport.put("param_sdk", String.valueOf(Build.VERSION.SDK_INT));
    Object localObject1 = localHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramBoyDataReport.put(localObject2, String.valueOf(((axpo)localHashMap.get(localObject2)).a()));
    }
    azri.a(BaseApplicationImpl.getContext()).a(null, "dg_action_match", true, 0L, 0L, paramBoyDataReport, "");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("entranceReportAlready", 0);
    }
    Object localObject;
    int i;
    int j;
    azri localazri;
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
      localazri = azri.a(BaseApplicationImpl.getContext());
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label283;
      }
    }
    label283:
    for (boolean bool = true;; bool = false)
    {
      localazri.a(null, "dg_entrance_state", bool, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameReporter", 2, String.format("reportDGEntranceState, hasPose[%s], hasFace[%s], state[%s], frameTpye[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axpn
 * JD-Core Version:    0.7.0.1
 */