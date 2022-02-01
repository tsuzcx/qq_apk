package com.tencent.gdtad;

import android.content.Context;
import com.tencent.gdtad.api.feedback.StartGdtFeedbackParams;
import com.tencent.gdtad.basics.adbox.GdtAdBoxListener;
import com.tencent.gdtad.basics.adbox.IGdtAdBox;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGdtAPI
  extends QRouteApi
{
  public abstract IGdtAdBox buildAdBox(Context paramContext, String paramString1, String paramString2, GdtAdBoxListener paramGdtAdBoxListener);
  
  public abstract void reportADFlyingStreaming(long paramLong);
  
  public abstract void startGdtFeedbackFragment(StartGdtFeedbackParams paramStartGdtFeedbackParams);
  
  public abstract void startGdtMotiveVideo(StartGdtMotiveVideoParams paramStartGdtMotiveVideoParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.IGdtAPI
 * JD-Core Version:    0.7.0.1
 */