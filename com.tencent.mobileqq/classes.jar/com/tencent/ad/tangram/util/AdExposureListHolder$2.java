package com.tencent.ad.tangram.util;

import android.content.Context;
import com.tencent.ad.tangram.process.AdProcessManager;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;

class AdExposureListHolder$2
  implements Runnable
{
  AdExposureListHolder$2(AdExposureListHolder paramAdExposureListHolder, Context paramContext) {}
  
  public void run()
  {
    JSONArray localJSONArray = new JSONArray();
    synchronized (AdExposureListHolder.access$100(this.this$0))
    {
      Iterator localIterator = AdExposureListHolder.access$200(this.this$0).iterator();
      if (localIterator.hasNext()) {
        localJSONArray.put((String)localIterator.next());
      }
    }
    synchronized (AdExposureListHolder.access$300(this.this$0))
    {
      b.write(AdExposureListHolder.access$000(this.this$0, this.val$context, AdProcessManager.INSTANCE.getCurrentProcessName(this.val$context)), localObject1.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureListHolder.2
 * JD-Core Version:    0.7.0.1
 */