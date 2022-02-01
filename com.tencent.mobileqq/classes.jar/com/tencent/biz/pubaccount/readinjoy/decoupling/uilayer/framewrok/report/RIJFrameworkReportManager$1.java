package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

final class RIJFrameworkReportManager$1
  implements Runnable
{
  RIJFrameworkReportManager$1(int paramInt, long paramLong) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = Aladdin.get(139);
      if (localObject == null) {}
      for (;;)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009EB2", "0X8009EB2", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Long), "1", localJSONObject.toString(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.1
 * JD-Core Version:    0.7.0.1
 */