package com.rookery.translate.google;

import android.content.Context;
import android.util.Pair;
import com.rookery.translate.Translator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateWithTimeCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jei;
import jej;

public class GoogleTranslator
  extends Translator
{
  private static GoogleTranslator a;
  
  public static GoogleTranslator a()
  {
    try
    {
      if (a == null) {
        a = new GoogleTranslator();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext, List paramList, Language paramLanguage, String paramString, Long paramLong, TranslateWithTimeCallback paramTranslateWithTimeCallback)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.CHINESE_SIMPLIFIED.toString();
    }
    Object localObject;
    for (;;)
    {
      localObject = new ArrayList();
      ((List)localObject).add(new Pair("key", paramString));
      ((List)localObject).add(new Pair("target", paramLanguage));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((List)localObject).add(new Pair("q", (String)paramList.next()));
      }
      localObject = paramLanguage.toString();
      if (localObject != null)
      {
        paramLanguage = (Language)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramLanguage = Language.CHINESE_SIMPLIFIED.toString();
      }
    }
    jei.a(paramContext, null, (List)localObject, new jej(this, paramTranslateWithTimeCallback, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.google.GoogleTranslator
 * JD-Core Version:    0.7.0.1
 */