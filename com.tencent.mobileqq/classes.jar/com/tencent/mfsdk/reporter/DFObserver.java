package com.tencent.mfsdk.reporter;

import android.os.HandlerThread;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.DropResultObject;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import rdu;

public class DFObserver
  implements Observer
{
  private static MqqHandler a = new MqqHandler(((HandlerThread)ThreadManager.getSubThread()).getLooper());
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = ((DFObservable)paramObservable).a;
    try
    {
      paramObject = new long[6];
      Object tmp14_13 = paramObject;
      tmp14_13[0] = 0L;
      Object tmp18_14 = tmp14_13;
      tmp18_14[1] = 0L;
      Object tmp22_18 = tmp18_14;
      tmp22_18[2] = 0L;
      Object tmp26_22 = tmp22_18;
      tmp26_22[3] = 0L;
      Object tmp30_26 = tmp26_22;
      tmp30_26[4] = 0L;
      Object tmp34_30 = tmp30_26;
      tmp34_30[5] = 0L;
      tmp34_30;
      Object localObject = (String)paramObservable.get("dropTimes");
      localObject = ((String)localObject).substring(1, ((String)localObject).length() - 1).split(",");
      int k = localObject.length;
      int j = 0;
      int i = 0;
      while (j < k)
      {
        paramObject[i] = Integer.parseInt(localObject[j].trim());
        j += 1;
        i += 1;
      }
      paramObject = new DropResultObject(Long.parseLong((String)paramObservable.get("dropCount")), Long.parseLong((String)paramObservable.get("totalMs")), paramObject);
      paramObject.a = Integer.parseInt(MagnifierSDK.a());
      paramObservable = new rdu(MagnifierSDK.a, (String)paramObservable.get("scene"), paramObject);
      a.post(paramObservable);
      return;
    }
    catch (Exception paramObservable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("StackObserver", 2, paramObservable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.DFObserver
 * JD-Core Version:    0.7.0.1
 */