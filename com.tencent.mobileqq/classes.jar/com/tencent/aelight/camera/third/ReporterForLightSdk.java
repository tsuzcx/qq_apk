package com.tencent.aelight.camera.third;

import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import java.util.Map;
import org.light.LightEngine;
import org.light.report.LightReportInterface;

public class ReporterForLightSdk
  implements LightReportInterface
{
  private String a;
  private String b;
  
  public static ReporterForLightSdk a()
  {
    return ReporterForLightSdk.Holder.a();
  }
  
  private String b(int paramInt)
  {
    if (AECameraEntry.e.a() == paramInt) {
      return "qq_aio";
    }
    if ((!AECameraEntryManager.e(paramInt)) && (!AECameraEntryManager.b(paramInt)) && (AECameraEntry.g.a() != paramInt) && (AECameraEntry.m.a() != paramInt) && (AECameraEntry.q.a() != paramInt) && (AECameraEntry.r.a() != paramInt) && (AECameraEntry.h.a() != paramInt) && (AECameraEntry.v.a() != paramInt) && (AECameraEntry.l.a() != paramInt) && (AECameraEntry.s.a() != paramInt))
    {
      if ((AECameraEntry.L.a() != paramInt) && (!AECameraEntryManager.g(paramInt))) {
        return "qq_other";
      }
      return "qq_world";
    }
    return "qq_qzone";
  }
  
  public void a(int paramInt)
  {
    this.a = b(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEntry---int entry=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", convert=");
    localStringBuilder.append(this.a);
    AEQLog.b("ReporterForLightSdk", localStringBuilder.toString());
  }
  
  public void report(String paramString, Map<String, String> paramMap)
  {
    if (this.b == null) {
      this.b = LightEngine.Version();
    }
    paramMap.put("lightsdk_version", this.b);
    paramMap.put("app_id", "lightsdk_qq");
    paramMap.put("entry", this.a);
    paramString = BeaconEvent.builder().withCode(paramString).withParams(paramMap).withAppKey("0AND0WH9714UPYKY").build();
    BeaconReport.getInstance().report(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.third.ReporterForLightSdk
 * JD-Core Version:    0.7.0.1
 */