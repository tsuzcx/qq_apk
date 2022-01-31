package com.tencent.biz.pubaccount.readinjoy.video;

import bdgk;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import nrt;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import rbw;
import rbx;

public class VideoFeedsCPUMonitor$1$1
  implements Runnable
{
  public VideoFeedsCPUMonitor$1$1(rbx paramrbx) {}
  
  public void run()
  {
    Thread localThread = new Thread(new VideoFeedsCPUMonitor.1.1.1(this));
    for (;;)
    {
      try
      {
        Thread.sleep(10000L);
        localThread.start();
        l1 = System.currentTimeMillis();
        l2 = rbw.a();
        if (rbw.a().get() == 2)
        {
          l3 = System.currentTimeMillis();
          rbw.b().getAndAdd(1);
          if (QLog.isColorLevel()) {
            QLog.d(rbw.a(), 2, "cost = " + (l3 - l1) + ", runCount = " + l2);
          }
          localJSONObject = new JSONObject();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        long l1;
        long l2;
        long l3;
        JSONObject localJSONObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(rbw.a(), 2, "InterruptedException");
        continue;
      }
      try
      {
        localJSONObject.put("result", String.valueOf(l2));
        localJSONObject.put("costTime", String.valueOf(l3 - l1));
        localJSONObject.put("deviceModel", bdgk.d());
        localJSONObject.put("manufactureInfo", bdgk.h());
        localJSONObject.put("uin", ors.a());
        nrt.a(null, null, "0X8009576", "0X8009576", 0, 0, ors.a(), "1", "", localJSONObject.toString(), false);
        if (localThread.isAlive()) {
          localThread.interrupt();
        }
        rbw.a().set(0);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1
 * JD-Core Version:    0.7.0.1
 */