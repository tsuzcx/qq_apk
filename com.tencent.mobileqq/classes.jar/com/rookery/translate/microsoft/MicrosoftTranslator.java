package com.rookery.translate.microsoft;

import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import com.rookery.translate.Translator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class MicrosoftTranslator
  extends Translator
{
  private static MicrosoftTranslator jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator;
  private MicrosoftTranslator.AccessToken jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator$AccessToken = new MicrosoftTranslator.AccessToken(this, null);
  DocumentBuilder jdField_a_of_type_JavaxXmlParsersDocumentBuilder;
  DocumentBuilderFactory jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
  
  private MicrosoftTranslator()
  {
    try
    {
      this.jdField_a_of_type_JavaxXmlParsersDocumentBuilder = this.jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory.newDocumentBuilder();
      return;
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      localParserConfigurationException.printStackTrace();
    }
  }
  
  public static MicrosoftTranslator a()
  {
    try
    {
      if (jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator == null) {
        jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator = new MicrosoftTranslator();
      }
      return jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Long paramLong, JsonHttpResponseHandler paramJsonHttpResponseHandler)
  {
    paramLong = new HashMap();
    paramLong.put("client_id", paramString1);
    paramLong.put("client_secret", paramString2);
    paramLong.put("scope", "https://api.microsofttranslator.com");
    paramLong.put("grant_type", "client_credentials");
    try
    {
      MicrosoftTranslateClient.a(paramContext, null, paramLong, new MicrosoftTranslator.3(this, paramJsonHttpResponseHandler));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramJsonHttpResponseHandler.a(new TranslateError(paramContext), "UnsupportedEncodingException");
    }
  }
  
  private void a(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, TranslateWithTimeCallback paramTranslateWithTimeCallback)
  {
    if (paramLanguage == null)
    {
      paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
    }
    else
    {
      localObject = paramLanguage.toString();
      if (localObject != null)
      {
        paramLanguage = (Language)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bearer ");
    ((StringBuilder)localObject).append(paramString);
    paramString = new BasicHeader("Authorization", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new MicrosoftTranslator.2(this, paramList, paramTranslateWithTimeCallback, paramLong);
      MicrosoftTranslateClient.a(paramContext, new Header[] { paramString }, paramList, paramLanguage, (AsyncHttpResponseHandler)localObject);
      return;
    }
    catch (Exception paramContext)
    {
      paramTranslateWithTimeCallback.a(new TranslateError(paramContext), paramLong);
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramTranslateWithTimeCallback.a(new TranslateError(paramContext), paramLong);
    }
  }
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, Long paramLong, String paramString1, String paramString2, TranslateWithTimeCallback paramTranslateWithTimeCallback)
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator$AccessToken.jdField_a_of_type_Long)
    {
      a(paramContext, paramList, paramLanguage, this.jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator$AccessToken.jdField_a_of_type_JavaLangString, paramLong, paramTranslateWithTimeCallback);
      return;
    }
    a(paramContext, paramString1, paramString2, paramLong, new MicrosoftTranslator.1(this, paramLong, paramContext, paramList, paramLanguage, paramTranslateWithTimeCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.microsoft.MicrosoftTranslator
 * JD-Core Version:    0.7.0.1
 */