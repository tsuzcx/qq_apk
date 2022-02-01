package com.tencent.mobileqq.app.soso;

import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.inject.ILbsInfoReportManagerProcessor;

public class LbsInfoReportManagerProcessorProxy
  implements ILbsInfoReportManagerProcessor
{
  public void reportLbsInfo2DC(SosoLocation paramSosoLocation, String paramString)
  {
    LbsInfoReportManager.a(paramSosoLocation, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsInfoReportManagerProcessorProxy
 * JD-Core Version:    0.7.0.1
 */