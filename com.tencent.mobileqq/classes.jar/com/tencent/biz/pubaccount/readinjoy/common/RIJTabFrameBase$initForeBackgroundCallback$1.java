package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGroundCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase$initForeBackgroundCallback$1", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$ForeBackGroundCallback;", "background", "", "foreground", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJTabFrameBase$initForeBackgroundCallback$1
  implements ReadinjoySPEventReport.ForeBackGroundCallback
{
  public void l()
  {
    QLog.i("RIJTabFrameBase", 1, "[foreground] preload web process.");
    RIJTabFrameBase.a(this.a).a(this.a);
  }
  
  public void m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.initForeBackgroundCallback.1
 * JD-Core Version:    0.7.0.1
 */