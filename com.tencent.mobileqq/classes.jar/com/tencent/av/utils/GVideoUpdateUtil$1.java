package com.tencent.av.utils;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class GVideoUpdateUtil$1
  implements HttpWebCgiAsyncTask.Callback
{
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    String str = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (paramInt != 2134) {
      return;
    }
    if (paramJSONObject != null)
    {
      Object localObject;
      boolean bool;
      for (;;)
      {
        try
        {
          localObject = paramJSONObject.getJSONObject("data");
          bool = ((JSONObject)localObject).getBoolean("update");
          if (bool)
          {
            paramBundle = ((JSONObject)localObject).getString("title");
            str = ((JSONObject)localObject).getString("tips");
            GVideoUpdateUtil.a(this.jdField_a_of_type_AndroidContentContext, paramBundle, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUtilsGVideoUpdateUtil$OnGVideoUpdateListener);
            localObject = (GVideoUpdateUtil.Record)GVideoUpdateUtil.a.get(this.jdField_a_of_type_JavaLangString);
            if (localObject != null) {
              break;
            }
            localObject = new GVideoUpdateUtil.Record();
            ((GVideoUpdateUtil.Record)localObject).a(System.currentTimeMillis(), paramBundle, str, bool);
            GVideoUpdateUtil.a.put(this.jdField_a_of_type_JavaLangString, localObject);
            return;
          }
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          paramJSONObject.optInt("errCode");
          GVideoUpdateUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUtilsGVideoUpdateUtil$OnGVideoUpdateListener);
          return;
        }
        this.jdField_a_of_type_ComTencentAvUtilsGVideoUpdateUtil$OnGVideoUpdateListener.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        paramBundle = null;
      }
      ((GVideoUpdateUtil.Record)localObject).a(System.currentTimeMillis(), paramBundle, str, bool);
      return;
    }
    GVideoUpdateUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUtilsGVideoUpdateUtil$OnGVideoUpdateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.GVideoUpdateUtil.1
 * JD-Core Version:    0.7.0.1
 */