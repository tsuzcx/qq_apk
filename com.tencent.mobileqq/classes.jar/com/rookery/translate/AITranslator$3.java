package com.rookery.translate;

import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.Header;

class AITranslator$3
  extends AsyncHttpResponseHandler
{
  AITranslator$3(AITranslator paramAITranslator, Context paramContext) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    boolean bool = paramString.equalsIgnoreCase("1");
    paramArrayOfHeader = Boolean.valueOf(true);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Translator", 2, "[policy update]: GOOGLE");
      }
      AITranslator.a(this.b, this.a, paramArrayOfHeader);
      AITranslator.a(this.b, this.a, AITranslator.TranslatorType.GOOGLE, 0L);
      AITranslator.a(this.b, this.a, AITranslator.TranslatorType.MS, 200000L);
      return;
    }
    if (paramString.equals("2"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Translator", 2, "[policy update]: MS");
      }
      AITranslator.a(this.b, this.a, paramArrayOfHeader);
      AITranslator.a(this.b, this.a, AITranslator.TranslatorType.MS, 0L);
      AITranslator.a(this.b, this.a, AITranslator.TranslatorType.GOOGLE, 200000L);
      return;
    }
    if (paramString.equals("0"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Translator", 2, "[policy update]: stop service");
      }
      AITranslator.a(this.b, this.a, Boolean.valueOf(false));
      return;
    }
    if (paramString.equals("3"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Translator", 2, "[policy update]: decide by Client");
      }
      AITranslator.a(this.b, this.a, paramArrayOfHeader);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "[policy update]: Update Failed");
    }
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("update policy error");
      paramThrowable.append(paramString);
      QLog.e("Translator", 2, paramThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.AITranslator.3
 * JD-Core Version:    0.7.0.1
 */