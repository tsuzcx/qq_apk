package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyParams;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import olh;
import org.json.JSONObject;

public final class RIJFrameworkReportManager$1
  implements Runnable
{
  public RIJFrameworkReportManager$1(int paramInt, long paramLong) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = Aladdin.get(139);
      if (localObject == null) {}
      for (;;)
      {
        olh.a(null, "CliOper", "", "", "0X8009EB2", "0X8009EB2", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Long), "1", localJSONObject.toString(), false);
        return;
        localObject = ((AladdinConfig)localObject).getList("param_list");
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SneakyParams localSneakyParams = (SneakyParams)((Iterator)localObject).next();
            localJSONObject.put(localSneakyParams.getPackageName(), localSneakyParams.toString());
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RIJFrameworkReportManager", 2, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.1
 * JD-Core Version:    0.7.0.1
 */