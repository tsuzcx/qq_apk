package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.network.grs.c.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class g
  implements Runnable
{
  g(long paramLong, Context paramContext, ArrayList paramArrayList, JSONArray paramJSONArray) {}
  
  public void run()
  {
    a locala = new a();
    locala.put("total_time", this.a);
    locala.put("network_type", NetworkUtil.getNetworkType(this.b));
    Object localObject1 = this.c.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (f)((Iterator)localObject1).next();
      if (((f)localObject2).m())
      {
        locala.put(h.a((f)localObject2));
        ((Iterator)localObject1).remove();
        i = 1;
        break label93;
      }
    }
    int i = 0;
    label93:
    if ((i == 0) && (this.c.size() > 0))
    {
      localObject1 = this.c;
      localObject1 = (f)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1);
      locala.put(h.a((f)localObject1));
      this.c.remove(localObject1);
    }
    if (this.c.size() > 0)
    {
      localObject1 = this.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new JSONObject(h.a((f)((Iterator)localObject1).next()));
        this.d.put(localObject2);
      }
    }
    if (this.d.length() > 0) {
      locala.put("failed_info", this.d.toString());
    }
    Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new Object[] { new JSONObject(locala.get()) });
    HianalyticsHelper.getInstance().onEvent(locala.get(), "networkkit_grs");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.g
 * JD-Core Version:    0.7.0.1
 */