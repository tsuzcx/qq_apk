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
      boolean bool = paramGdtFeedbackResultParams.a.isSuccess();
      if (!bool)
      {
        localJSONObject.put("error_code", paramGdtFeedbackResultParams.a.getErrorCode());
        GdtNotify.a(this.a, this.b, "ad_show_feedback_callback", localJSONObject, false);
        return;
      }
      localJSONObject.put("action_type", paramGdtFeedbackResultParams.b);
      localJSONObject.put("error_code", paramGdtFeedbackResultParams.a.getErrorCode());
      GdtNotify.a(this.a, this.b, "ad_feedback_action_callback", localJSONObject, false);
      return;
    }
    catch (JSONException paramGdtFeedbackResultParams) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.6
 * JD-Core Version:    0.7.0.1
 */