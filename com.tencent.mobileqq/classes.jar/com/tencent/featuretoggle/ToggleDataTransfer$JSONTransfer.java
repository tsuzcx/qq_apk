package com.tencent.featuretoggle;

import android.text.TextUtils;
import com.tencent.featuretoggle.models.FeatureTriggered;
import com.tencent.featuretoggle.models.FeatureTypedTriggered;
import com.tencent.featuretoggle.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ToggleDataTransfer$JSONTransfer
  implements ToggleDataTransfer.DataTransfer<JSONObject>
{
  public FeatureTypedTriggered<JSONObject> a(FeatureTriggered paramFeatureTriggered)
  {
    FeatureTypedTriggered localFeatureTypedTriggered = new FeatureTypedTriggered();
    ToggleDataTransfer.a(paramFeatureTriggered, localFeatureTypedTriggered);
    if (!TextUtils.isEmpty(paramFeatureTriggered.h())) {
      try
      {
        localFeatureTypedTriggered.a(new JSONObject(paramFeatureTriggered.h()));
        return localFeatureTypedTriggered;
      }
      catch (JSONException paramFeatureTriggered)
      {
        if (LogUtils.a(paramFeatureTriggered)) {
          paramFeatureTriggered.printStackTrace();
        }
      }
    }
    return localFeatureTypedTriggered;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleDataTransfer.JSONTransfer
 * JD-Core Version:    0.7.0.1
 */