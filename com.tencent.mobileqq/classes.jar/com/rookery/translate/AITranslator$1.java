package com.rookery.translate;

import android.content.Context;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateCallback;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.Holder;
import java.util.List;

class AITranslator$1
  implements TranslateWithTimeCallback
{
  AITranslator$1(AITranslator paramAITranslator, String paramString1, long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString2, Language paramLanguage, TranslateCallback paramTranslateCallback, List paramList1, List paramList2, int paramInt, AITranslator.TranslatorType paramTranslatorType) {}
  
  public void a(TranslateError paramTranslateError, Long paramLong)
  {
    AITranslator.a(this.l).remove(this.a);
    AITranslator.a(this.l, this.b, this.c, this.d, this.e, this.h, this.i, this.f, this.g, this.j, this.k, paramTranslateError, paramLong);
  }
  
  public void a(List<Language> paramList, List<String> paramList1, Long paramLong)
  {
    AITranslator.a(this.l).remove(this.a);
    AITranslator.a(this.l, this.b, this.c, this.d, this.e, this.f, this.g, 0, AITranslator.TranslatorType.GOOGLE, paramList, paramList1, this.h, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.AITranslator.1
 * JD-Core Version:    0.7.0.1
 */