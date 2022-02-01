package com.rookery.translate.microsoft;

import android.content.Context;
import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class MicrosoftTranslator$1
  extends JsonHttpResponseHandler
{
  MicrosoftTranslator$1(MicrosoftTranslator paramMicrosoftTranslator, Long paramLong, Context paramContext, List paramList, Language paramLanguage, TranslateWithTimeCallback paramTranslateWithTimeCallback) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    try
    {
      MicrosoftTranslator.a(this.jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator).jdField_a_of_type_JavaLangString = paramJSONObject.getString("access_token");
      MicrosoftTranslator.a(this.jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator).jdField_a_of_type_Long = (paramJSONObject.getLong("expires_in") * 1000L + this.jdField_a_of_type_JavaLangLong.longValue());
      MicrosoftTranslator.a(this.jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComRookeryTranslateTypeLanguage, MicrosoftTranslator.a(this.jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangLong, this.jdField_a_of_type_ComRookeryTranslateTypeTranslateWithTimeCallback);
      return;
    }
    catch (JSONException paramArrayOfHeader)
    {
      this.jdField_a_of_type_ComRookeryTranslateTypeTranslateWithTimeCallback.a(new TranslateError(paramArrayOfHeader), this.jdField_a_of_type_JavaLangLong);
    }
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    this.jdField_a_of_type_ComRookeryTranslateTypeTranslateWithTimeCallback.a(new TranslateError(paramThrowable), this.jdField_a_of_type_JavaLangLong);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("error:");
      paramString.append(paramThrowable);
      paramString.append("\trequest_time:");
      paramString.append(this.jdField_a_of_type_JavaLangLong);
      QLog.e("Translator", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.microsoft.MicrosoftTranslator.1
 * JD-Core Version:    0.7.0.1
 */