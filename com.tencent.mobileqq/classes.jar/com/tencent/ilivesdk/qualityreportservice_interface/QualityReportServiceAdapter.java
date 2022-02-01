package com.tencent.ilivesdk.qualityreportservice_interface;

import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;

public abstract interface QualityReportServiceAdapter
{
  public abstract DataReportInterface getDataReporter();
  
  public abstract HttpInterface getHttpInterface();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceAdapter
 * JD-Core Version:    0.7.0.1
 */