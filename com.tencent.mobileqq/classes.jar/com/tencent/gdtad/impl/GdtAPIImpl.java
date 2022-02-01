package com.tencent.gdtad.impl;

import android.content.Context;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.api.feedback.GdtFeedbackFragment;
import com.tencent.gdtad.api.feedback.StartGdtFeedbackParams;
import com.tencent.gdtad.basics.adbox.GdtAdBox;
import com.tencent.gdtad.basics.adbox.GdtAdBoxBuilder;
import com.tencent.gdtad.basics.adbox.GdtAdBoxData;
import com.tencent.gdtad.basics.adbox.GdtAdBoxListener;
import com.tencent.gdtad.basics.adbox.IGdtAdBox;
import com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.qphone.base.util.QLog;

public class GdtAPIImpl
  implements IGdtAPI
{
  public static final String TAG = "GdtAPIImpl";
  
  public IGdtAdBox buildAdBox(Context paramContext, String paramString1, String paramString2, GdtAdBoxListener paramGdtAdBoxListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildAdBox refId=");
    localStringBuilder.append(paramString2);
    QLog.i("GdtAPIImpl", 1, localStringBuilder.toString());
    return GdtAdBox.a(paramContext).a(new GdtAdBoxData(paramString1).setRefId(paramString2)).a(paramGdtAdBoxListener).a();
  }
  
  public void reportADFlyingStreaming(long paramLong)
  {
    GdtADFlyingStreamingReportHelper.a().a(paramLong);
  }
  
  public void startGdtFeedbackFragment(StartGdtFeedbackParams paramStartGdtFeedbackParams)
  {
    GdtFeedbackFragment.a(paramStartGdtFeedbackParams);
  }
  
  public void startGdtMotiveVideo(StartGdtMotiveVideoParams paramStartGdtMotiveVideoParams)
  {
    GdtMotiveVideoFragment.a(paramStartGdtMotiveVideoParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.impl.GdtAPIImpl
 * JD-Core Version:    0.7.0.1
 */