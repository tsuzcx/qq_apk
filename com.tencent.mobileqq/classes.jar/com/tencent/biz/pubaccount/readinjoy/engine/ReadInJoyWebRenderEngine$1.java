package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyWebRenderEngine$1
  implements ReadInJoyWebRenderStateMachineScheduler.StateMachine
{
  ReadInJoyWebRenderEngine$1(ReadInJoyWebRenderEngine paramReadInJoyWebRenderEngine) {}
  
  public int a(Bundle paramBundle)
  {
    int j = this.a.a;
    int i = -1;
    long l = System.currentTimeMillis();
    switch (this.a.a)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, "native_render CreateLoop:step[" + j + "] -> step[" + this.a.a + "] cost[" + (System.currentTimeMillis() - l) + "ms]" + " timestamps[" + System.currentTimeMillis() + "]");
      }
      RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, j, System.currentTimeMillis() - l);
      return i;
      i = this.a.b(paramBundle);
      continue;
      i = this.a.c(paramBundle);
      continue;
      i = this.a.d(paramBundle);
      continue;
      i = this.a.e(paramBundle);
      continue;
      i = this.a.f(paramBundle);
      continue;
      i = this.a.g(paramBundle);
      continue;
      i = this.a.h(paramBundle);
      continue;
      i = this.a.i(paramBundle);
      continue;
      i = this.a.j(paramBundle);
      continue;
      i = this.a.k(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.1
 * JD-Core Version:    0.7.0.1
 */