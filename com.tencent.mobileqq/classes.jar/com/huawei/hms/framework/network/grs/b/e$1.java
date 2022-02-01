package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.network.grs.b.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class e$1
  implements Runnable
{
  e$1(long paramLong, Context paramContext, ArrayList paramArrayList, JSONArray paramJSONArray) {}
  
  public void run()
  {
    a locala = new a();
    locala.put("total_time", this.a);
    locala.put("network_type", NetworkUtil.getNetworkType(this.b));
    Object localObject1 = this.c.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      if (((d)localObject2).h())
      {
        locala.put(e.a((d)localObject2));
        ((Iterator)localObject1).remove();
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.c.size() > 0))
      {
        localObject1 = (d)this.c.get(this.c.size() - 1);
        locala.put(e.a((d)localObject1));
        this.c.remove(localObject1);
      }
      if (this.c.size() > 0)
      {
        localObject1 = this.c.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = new JSONObject(e.a((d)((Iterator)localObject1).next()));
          this.d.put(localObject2);
        }
      }
      if (this.d.length() > 0) {
        locala.put("failed_info", this.d.toString());
      }
      Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new Object[] { new JSONObject(locala.get()) });
      HianalyticsHelper.getInstance().onEvent(locala.get(), "networkkit_grs");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.e.1
 * JD-Core Version:    0.7.0.1
 */