package com.tencent.mobileqq.ark.api.notify;

import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.api.feedback.GdtFeedbackListener;
import com.tencent.gdtad.api.feedback.GdtFeedbackResultParams;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class GdtNotify$6
  implements GdtFeedbackListener
{
  GdtNotify$6(GdtNotify paramGdtNotify, String paramString, WeakReference paramWeakReference) {}
  
  public void a(GdtFeedbackResultParams paramGdtFeedbackResultParams)
  {
    if (paramGdtFeedbackResultParams == null)
    {
      AdLog.e("GdtNotify", "[onResult] error, params are null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      boolean bool = paramGdtFeedbackResultParams.jdField_a_of_type_ComTencentAdTangramAdError.isSuccess();
      if (!bool)
      {
        localJSONObject.put("error_code", paramGdtFeedbackResultParams.jdField_a_of_type_ComTencentAdTangramAdError.getErrorCode());
        GdtNotify.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangRefWeakReference, "ad_show_feedback_callback", localJSONObject, false);
        return;
      }
      localJSONObject.put("action_type", paramGdtFeedbackResultParams.jdField_a_of_type_Int);
      localJSONObject.put("error_code", paramGdtFeedbackResultParams.jdField_a_of_type_ComTencentAdTangramAdError.getErrorCode());
      GdtNotify.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangRefWeakReference, "ad_feedback_action_callback", localJSONObject, false);
      return;
    }
    catch (JSONException paramGdtFeedbackResultParams) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.6
 * JD-Core Version:    0.7.0.1
 */