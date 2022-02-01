package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.api.feedback.GdtFeedbackListener;
import com.tencent.gdtad.api.feedback.GdtFeedbackResultParams;

class GdtFeedbackJsCallHandler$1
  implements GdtFeedbackListener
{
  GdtFeedbackJsCallHandler$1(GdtFeedbackJsCallHandler paramGdtFeedbackJsCallHandler, String paramString) {}
  
  public void a(GdtFeedbackResultParams paramGdtFeedbackResultParams)
  {
    if (paramGdtFeedbackResultParams == null)
    {
      AdLog.e(GdtFeedbackJsCallHandler.a, "[onResult] error, params are null");
      return;
    }
    GdtFeedbackJsCallHandler.a(this.b, this.a, paramGdtFeedbackResultParams.b, paramGdtFeedbackResultParams.a.getErrorCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtFeedbackJsCallHandler.1
 * JD-Core Version:    0.7.0.1
 */