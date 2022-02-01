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
      AdLog.e(GdtFeedbackJsCallHandler.jdField_a_of_type_JavaLangString, "[onResult] error, params are null");
      return;
    }
    GdtFeedbackJsCallHandler.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtFeedbackJsCallHandler, this.jdField_a_of_type_JavaLangString, paramGdtFeedbackResultParams.jdField_a_of_type_Int, paramGdtFeedbackResultParams.jdField_a_of_type_ComTencentAdTangramAdError.getErrorCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtFeedbackJsCallHandler.1
 * JD-Core Version:    0.7.0.1
 */