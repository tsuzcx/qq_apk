package com.tencent.intervideo.nowproxy;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.baseability.report.BeaconReportHelper;

class CustomInterfaceLogic$1
  implements CustomizedBeaconReport
{
  CustomInterfaceLogic$1(CustomInterfaceLogic paramCustomInterfaceLogic) {}
  
  public void onBeaconReport(Bundle paramBundle, int paramInt)
  {
    BeaconReportHelper.doBeaconReport(paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.CustomInterfaceLogic.1
 * JD-Core Version:    0.7.0.1
 */